package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.i.ad;
import com.tencent.mm.plugin.backup.i.ae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class d
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  private int iKP;
  public String id;
  private byte[] key;
  private j oSq;
  private ad oSs;
  private ae oSt;
  private String oSu;
  private int offset;
  private int start;
  
  public d(String paramString1, String paramString2, int paramInt1, int paramInt2, j paramj, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21944);
    this.oSs = new ad();
    this.oSt = new ae();
    this.oSq = null;
    this.start = 0;
    this.offset = 0;
    if (paramInt1 == 1) {}
    for (this.oSu = (paramString1 + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.agK(paramString2));; this.oSu = (paramString1 + "backupMeida/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.agK(paramString2)))
    {
      this.id = paramString2;
      this.oSs.oUz = paramString2;
      this.oSs.oUA = paramInt1;
      this.iKP = paramInt2;
      Log.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", new Object[] { this.oSs.oUz, Integer.valueOf(this.oSs.oUA), Integer.valueOf(this.iKP) });
      this.oSq = paramj;
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
  
  public final void Bm(int paramInt)
  {
    AppMethodBeat.i(21947);
    Log.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.oSt.oUz, Integer.valueOf(this.oSt.oUA), Integer.valueOf(this.oSt.oUC), Integer.valueOf(this.oSt.oUD), Integer.valueOf(this.oSt.oTW) });
    if ((this.oSt.oTW != 0) && (this.oSt.oTW != 10))
    {
      q(4, this.oSt.oTW, "error");
      AppMethodBeat.o(21947);
      return;
    }
    if ((this.oSt.oUC != this.start) || (this.oSt.oUD != this.offset))
    {
      Log.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", new Object[] { Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.oSt.oUC), Integer.valueOf(this.oSt.oUD) });
      q(3, -1, "error");
      AppMethodBeat.o(21947);
      return;
    }
    this.oSq.a(this.oSs.oUD - this.oSs.oUC, this.iKP, this);
    byte[] arrayOfByte = this.oSt.oTm.zy;
    Object localObject;
    boolean bool;
    if (this.key != null)
    {
      localObject = this.key;
      if (this.offset == this.iKP)
      {
        bool = true;
        arrayOfByte = AesEcb.aesCryptEcb(arrayOfByte, (byte[])localObject, false, bool);
      }
    }
    for (;;)
    {
      localObject = this.oSu;
      String str = this.id;
      o localo = new o((String)localObject + str);
      long l1;
      label355:
      long l2;
      if (localo.exists())
      {
        l1 = localo.length();
        s.e((String)localObject + str, arrayOfByte, arrayOfByte.length);
        localo = new o((String)localObject + str);
        if (!localo.exists()) {
          break label587;
        }
        l2 = localo.length();
        label428:
        if (l1 == l2)
        {
          Log.e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", new Object[] { (String)localObject + str });
          s.e((String)localObject + str, arrayOfByte, arrayOfByte.length);
        }
        if (arrayOfByte != null) {
          break label593;
        }
      }
      label587:
      label593:
      for (paramInt = 0;; paramInt = arrayOfByte.length)
      {
        Log.i("MicroMsg.BakSceneRestoreData", "onSceneEnd appendbuf len:%d", new Object[] { Integer.valueOf(paramInt) });
        if (this.offset != this.iKP) {
          break label600;
        }
        Log.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", new Object[] { this.id, Integer.valueOf(this.iKP) });
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
      cgA();
      AppMethodBeat.o(21947);
      return;
    }
  }
  
  public final boolean cgA()
  {
    long l = 524288L;
    AppMethodBeat.i(21945);
    Log.i("MicroMsg.BakSceneRestoreData", "doSecne");
    int i = this.iKP;
    if (this.oSs.oUA == 2) {
      if (this.iKP - this.offset > 524288L) {
        i = (int)l;
      }
    }
    for (;;)
    {
      this.start = this.offset;
      this.offset = (i + this.start);
      this.oSs.oUC = this.start;
      this.oSs.oUD = this.offset;
      this.oSs.oUF = progress;
      boolean bool = super.cgA();
      AppMethodBeat.o(21945);
      return bool;
      l = this.iKP - this.offset;
      break;
    }
  }
  
  public final com.tencent.mm.bw.a cgq()
  {
    return this.oSt;
  }
  
  public final com.tencent.mm.bw.a cgr()
  {
    return this.oSs;
  }
  
  public final int getType()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.d
 * JD-Core Version:    0.7.0.1
 */