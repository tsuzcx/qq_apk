package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.j;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.i.ad;
import com.tencent.mm.plugin.backup.i.ae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;

public final class d
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  public String id;
  private byte[] key;
  private int lAW;
  private int offset;
  private j rUp;
  private ad rUr;
  private ae rUs;
  private String rUt;
  private int start;
  
  public d(String paramString1, String paramString2, int paramInt1, int paramInt2, j paramj, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21944);
    this.rUr = new ad();
    this.rUs = new ae();
    this.rUp = null;
    this.start = 0;
    this.offset = 0;
    if (paramInt1 == 1) {}
    for (this.rUt = (paramString1 + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.aoo(paramString2));; this.rUt = (paramString1 + "backupMeida/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.aoo(paramString2)))
    {
      this.id = paramString2;
      this.rUr.rWy = paramString2;
      this.rUr.rWz = paramInt1;
      this.lAW = paramInt2;
      Log.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", new Object[] { this.rUr.rWy, Integer.valueOf(this.rUr.rWz), Integer.valueOf(this.lAW) });
      this.rUp = paramj;
      this.key = paramArrayOfByte;
      AppMethodBeat.o(21944);
      return;
    }
  }
  
  public static void setProgress(int paramInt)
  {
    AppMethodBeat.i(21946);
    Log.i("MicroMsg.BakSceneRestoreData", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
    AppMethodBeat.o(21946);
  }
  
  public final void EN(int paramInt)
  {
    AppMethodBeat.i(21947);
    Log.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.rUs.rWy, Integer.valueOf(this.rUs.rWz), Integer.valueOf(this.rUs.rWB), Integer.valueOf(this.rUs.rWC), Integer.valueOf(this.rUs.rVU) });
    if ((this.rUs.rVU != 0) && (this.rUs.rVU != 10))
    {
      r(4, this.rUs.rVU, "error");
      AppMethodBeat.o(21947);
      return;
    }
    if ((this.rUs.rWB != this.start) || (this.rUs.rWC != this.offset))
    {
      Log.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", new Object[] { Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.rUs.rWB), Integer.valueOf(this.rUs.rWC) });
      r(3, -1, "error");
      AppMethodBeat.o(21947);
      return;
    }
    this.rUp.a(this.rUr.rWC - this.rUr.rWB, this.lAW, this);
    byte[] arrayOfByte = this.rUs.rVk.UH;
    Object localObject;
    boolean bool;
    if (this.key != null)
    {
      localObject = this.key;
      if (this.offset == this.lAW)
      {
        bool = true;
        arrayOfByte = AesEcb.aesCryptEcb(arrayOfByte, (byte[])localObject, false, bool);
      }
    }
    for (;;)
    {
      localObject = this.rUt;
      String str = this.id;
      q localq = new q((String)localObject + str);
      long l1;
      label355:
      long l2;
      if (localq.ifE())
      {
        l1 = localq.length();
        u.F((String)localObject + str, arrayOfByte);
        localq = new q((String)localObject + str);
        if (!localq.ifE()) {
          break label581;
        }
        l2 = localq.length();
        label425:
        if (l1 == l2)
        {
          Log.e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", new Object[] { (String)localObject + str });
          u.F((String)localObject + str, arrayOfByte);
        }
        if (arrayOfByte != null) {
          break label587;
        }
      }
      label581:
      label587:
      for (paramInt = 0;; paramInt = arrayOfByte.length)
      {
        Log.i("MicroMsg.BakSceneRestoreData", "onSceneEnd appendbuf len:%d", new Object[] { Integer.valueOf(paramInt) });
        if (this.offset != this.lAW) {
          break label594;
        }
        Log.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", new Object[] { this.id, Integer.valueOf(this.lAW) });
        r(0, 0, "success");
        AppMethodBeat.o(21947);
        return;
        bool = false;
        break;
        l1 = 0L;
        break label355;
        l2 = 0L;
        break label425;
      }
      label594:
      ctM();
      AppMethodBeat.o(21947);
      return;
    }
  }
  
  public final com.tencent.mm.cd.a ctC()
  {
    return this.rUs;
  }
  
  public final com.tencent.mm.cd.a ctD()
  {
    return this.rUr;
  }
  
  public final boolean ctM()
  {
    long l = 524288L;
    AppMethodBeat.i(21945);
    Log.i("MicroMsg.BakSceneRestoreData", "doSecne");
    int i = this.lAW;
    if (this.rUr.rWz == 2) {
      if (this.lAW - this.offset > 524288L) {
        i = (int)l;
      }
    }
    for (;;)
    {
      this.start = this.offset;
      this.offset = (i + this.start);
      this.rUr.rWB = this.start;
      this.rUr.rWC = this.offset;
      this.rUr.rWE = progress;
      boolean bool = super.ctM();
      AppMethodBeat.o(21945);
      return bool;
      l = this.lAW - this.offset;
      break;
    }
  }
  
  public final int getType()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.d
 * JD-Core Version:    0.7.0.1
 */