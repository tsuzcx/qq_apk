package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.i.ad;
import com.tencent.mm.plugin.backup.i.ae;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public final class d
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  private int hux;
  public String id;
  private byte[] key;
  private h nbB;
  private ad nbD;
  private ae nbE;
  private String nbF;
  private int offset;
  private int start;
  
  public d(String paramString1, String paramString2, int paramInt1, int paramInt2, h paramh, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21944);
    this.nbD = new ad();
    this.nbE = new ae();
    this.nbB = null;
    this.start = 0;
    this.offset = 0;
    if (paramInt1 == 1) {}
    for (this.nbF = (paramString1 + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.SG(paramString2));; this.nbF = (paramString1 + "backupMeida/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.SG(paramString2)))
    {
      this.id = paramString2;
      this.nbD.ndM = paramString2;
      this.nbD.ndN = paramInt1;
      this.hux = paramInt2;
      ac.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", new Object[] { this.nbD.ndM, Integer.valueOf(this.nbD.ndN), Integer.valueOf(this.hux) });
      this.nbB = paramh;
      this.key = paramArrayOfByte;
      AppMethodBeat.o(21944);
      return;
    }
  }
  
  public static void setProgress(int paramInt)
  {
    AppMethodBeat.i(21946);
    ac.i("MicroMsg.BakSceneRestoreData", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
    AppMethodBeat.o(21946);
  }
  
  public final boolean bEA()
  {
    long l = 524288L;
    AppMethodBeat.i(21945);
    ac.i("MicroMsg.BakSceneRestoreData", "doSecne");
    int i = this.hux;
    if (this.nbD.ndN == 2) {
      if (this.hux - this.offset > 524288L) {
        i = (int)l;
      }
    }
    for (;;)
    {
      this.start = this.offset;
      this.offset = (i + this.start);
      this.nbD.ndP = this.start;
      this.nbD.ndQ = this.offset;
      this.nbD.ndS = progress;
      boolean bool = super.bEA();
      AppMethodBeat.o(21945);
      return bool;
      l = this.hux - this.offset;
      break;
    }
  }
  
  public final com.tencent.mm.bw.a bEq()
  {
    return this.nbE;
  }
  
  public final com.tencent.mm.bw.a bEr()
  {
    return this.nbD;
  }
  
  public final int getType()
  {
    return 7;
  }
  
  public final void wW(int paramInt)
  {
    AppMethodBeat.i(21947);
    ac.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.nbE.ndM, Integer.valueOf(this.nbE.ndN), Integer.valueOf(this.nbE.ndP), Integer.valueOf(this.nbE.ndQ), Integer.valueOf(this.nbE.ndj) });
    if ((this.nbE.ndj != 0) && (this.nbE.ndj != 10))
    {
      q(4, this.nbE.ndj, "error");
      AppMethodBeat.o(21947);
      return;
    }
    if ((this.nbE.ndP != this.start) || (this.nbE.ndQ != this.offset))
    {
      ac.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", new Object[] { Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.nbE.ndP), Integer.valueOf(this.nbE.ndQ) });
      q(3, -1, "error");
      AppMethodBeat.o(21947);
      return;
    }
    this.nbB.a(this.nbD.ndQ - this.nbD.ndP, this.hux, this);
    byte[] arrayOfByte = this.nbE.ncy.xy;
    Object localObject;
    boolean bool;
    if (this.key != null)
    {
      localObject = this.key;
      if (this.offset == this.hux)
      {
        bool = true;
        arrayOfByte = AesEcb.aesCryptEcb(arrayOfByte, (byte[])localObject, false, bool);
      }
    }
    for (;;)
    {
      localObject = this.nbF;
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
          ac.e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", new Object[] { (String)localObject + str });
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
        ac.i("MicroMsg.BakSceneRestoreData", "onSceneEnd appendbuf len:%d", new Object[] { Integer.valueOf(paramInt) });
        if (this.offset != this.hux) {
          break label600;
        }
        ac.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", new Object[] { this.id, Integer.valueOf(this.hux) });
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
      bEA();
      AppMethodBeat.o(21947);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.d
 * JD-Core Version:    0.7.0.1
 */