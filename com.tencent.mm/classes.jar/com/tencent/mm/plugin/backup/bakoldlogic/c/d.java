package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.h;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.i.ae;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public final class d
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  private int gTY;
  public String id;
  private byte[] key;
  private h mzA;
  private com.tencent.mm.plugin.backup.i.ad mzC;
  private ae mzD;
  private String mzE;
  private int offset;
  private int start;
  
  public d(String paramString1, String paramString2, int paramInt1, int paramInt2, h paramh, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21944);
    this.mzC = new com.tencent.mm.plugin.backup.i.ad();
    this.mzD = new ae();
    this.mzA = null;
    this.start = 0;
    this.offset = 0;
    if (paramInt1 == 1) {}
    for (this.mzE = (paramString1 + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.Ow(paramString2));; this.mzE = (paramString1 + "backupMeida/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.Ow(paramString2)))
    {
      this.id = paramString2;
      this.mzC.mBL = paramString2;
      this.mzC.mBM = paramInt1;
      this.gTY = paramInt2;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", new Object[] { this.mzC.mBL, Integer.valueOf(this.mzC.mBM), Integer.valueOf(this.gTY) });
      this.mzA = paramh;
      this.key = paramArrayOfByte;
      AppMethodBeat.o(21944);
      return;
    }
  }
  
  public static void setProgress(int paramInt)
  {
    AppMethodBeat.i(21946);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BakSceneRestoreData", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
    AppMethodBeat.o(21946);
  }
  
  public final boolean bxE()
  {
    long l = 524288L;
    AppMethodBeat.i(21945);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BakSceneRestoreData", "doSecne");
    int i = this.gTY;
    if (this.mzC.mBM == 2) {
      if (this.gTY - this.offset > 524288L) {
        i = (int)l;
      }
    }
    for (;;)
    {
      this.start = this.offset;
      this.offset = (i + this.start);
      this.mzC.mBO = this.start;
      this.mzC.mBP = this.offset;
      this.mzC.mBR = progress;
      boolean bool = super.bxE();
      AppMethodBeat.o(21945);
      return bool;
      l = this.gTY - this.offset;
      break;
    }
  }
  
  public final com.tencent.mm.bx.a bxu()
  {
    return this.mzD;
  }
  
  public final com.tencent.mm.bx.a bxv()
  {
    return this.mzC;
  }
  
  public final int getType()
  {
    return 7;
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(21947);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.mzD.mBL, Integer.valueOf(this.mzD.mBM), Integer.valueOf(this.mzD.mBO), Integer.valueOf(this.mzD.mBP), Integer.valueOf(this.mzD.mBi) });
    if ((this.mzD.mBi != 0) && (this.mzD.mBi != 10))
    {
      q(4, this.mzD.mBi, "error");
      AppMethodBeat.o(21947);
      return;
    }
    if ((this.mzD.mBO != this.start) || (this.mzD.mBP != this.offset))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", new Object[] { Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.mzD.mBO), Integer.valueOf(this.mzD.mBP) });
      q(3, -1, "error");
      AppMethodBeat.o(21947);
      return;
    }
    this.mzA.a(this.mzC.mBP - this.mzC.mBO, this.gTY, this);
    byte[] arrayOfByte = this.mzD.mAx.wA;
    Object localObject;
    boolean bool;
    if (this.key != null)
    {
      localObject = this.key;
      if (this.offset == this.gTY)
      {
        bool = true;
        arrayOfByte = AesEcb.aesCryptEcb(arrayOfByte, (byte[])localObject, false, bool);
      }
    }
    for (;;)
    {
      localObject = this.mzE;
      String str = this.id;
      e locale = new e((String)localObject + str);
      long l1;
      label355:
      long l2;
      if (locale.exists())
      {
        l1 = locale.length();
        i.e((String)localObject + str, arrayOfByte, arrayOfByte.length);
        locale = new e((String)localObject + str);
        if (!locale.exists()) {
          break label587;
        }
        l2 = locale.length();
        label428:
        if (l1 == l2)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", new Object[] { (String)localObject + str });
          i.e((String)localObject + str, arrayOfByte, arrayOfByte.length);
        }
        if (arrayOfByte != null) {
          break label593;
        }
      }
      label587:
      label593:
      for (paramInt = 0;; paramInt = arrayOfByte.length)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BakSceneRestoreData", "onSceneEnd appendbuf len:%d", new Object[] { Integer.valueOf(paramInt) });
        if (this.offset != this.gTY) {
          break label600;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", new Object[] { this.id, Integer.valueOf(this.gTY) });
        q(0, 0, "success");
        AppMethodBeat.o(21947);
        return;
        bool = false;
        break;
        l1 = 0L;
        break label355;
        l2 = 0L;
        break label428;
      }
      label600:
      bxE();
      AppMethodBeat.o(21947);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.d
 * JD-Core Version:    0.7.0.1
 */