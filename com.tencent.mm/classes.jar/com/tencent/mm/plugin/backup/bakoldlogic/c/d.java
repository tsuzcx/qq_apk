package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.i.ae;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public final class d
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  private int hMP;
  public String id;
  private byte[] key;
  private g nBY;
  private com.tencent.mm.plugin.backup.i.ad nCa;
  private ae nCb;
  private String nCc;
  private int offset;
  private int start;
  
  public d(String paramString1, String paramString2, int paramInt1, int paramInt2, g paramg, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21944);
    this.nCa = new com.tencent.mm.plugin.backup.i.ad();
    this.nCb = new ae();
    this.nBY = null;
    this.start = 0;
    this.offset = 0;
    if (paramInt1 == 1) {}
    for (this.nCc = (paramString1 + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.We(paramString2));; this.nCc = (paramString1 + "backupMeida/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.We(paramString2)))
    {
      this.id = paramString2;
      this.nCa.nEj = paramString2;
      this.nCa.nEk = paramInt1;
      this.hMP = paramInt2;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", new Object[] { this.nCa.nEj, Integer.valueOf(this.nCa.nEk), Integer.valueOf(this.hMP) });
      this.nBY = paramg;
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
  
  public final com.tencent.mm.bx.a bIA()
  {
    return this.nCa;
  }
  
  public final boolean bIJ()
  {
    long l = 524288L;
    AppMethodBeat.i(21945);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BakSceneRestoreData", "doSecne");
    int i = this.hMP;
    if (this.nCa.nEk == 2) {
      if (this.hMP - this.offset > 524288L) {
        i = (int)l;
      }
    }
    for (;;)
    {
      this.start = this.offset;
      this.offset = (i + this.start);
      this.nCa.nEm = this.start;
      this.nCa.nEn = this.offset;
      this.nCa.nEp = progress;
      boolean bool = super.bIJ();
      AppMethodBeat.o(21945);
      return bool;
      l = this.hMP - this.offset;
      break;
    }
  }
  
  public final com.tencent.mm.bx.a bIz()
  {
    return this.nCb;
  }
  
  public final int getType()
  {
    return 7;
  }
  
  public final void xC(int paramInt)
  {
    AppMethodBeat.i(21947);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.nCb.nEj, Integer.valueOf(this.nCb.nEk), Integer.valueOf(this.nCb.nEm), Integer.valueOf(this.nCb.nEn), Integer.valueOf(this.nCb.nDG) });
    if ((this.nCb.nDG != 0) && (this.nCb.nDG != 10))
    {
      q(4, this.nCb.nDG, "error");
      AppMethodBeat.o(21947);
      return;
    }
    if ((this.nCb.nEm != this.start) || (this.nCb.nEn != this.offset))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", new Object[] { Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.nCb.nEm), Integer.valueOf(this.nCb.nEn) });
      q(3, -1, "error");
      AppMethodBeat.o(21947);
      return;
    }
    this.nBY.a(this.nCa.nEn - this.nCa.nEm, this.hMP, this);
    byte[] arrayOfByte = this.nCb.nCV.zr;
    Object localObject;
    boolean bool;
    if (this.key != null)
    {
      localObject = this.key;
      if (this.offset == this.hMP)
      {
        bool = true;
        arrayOfByte = AesEcb.aesCryptEcb(arrayOfByte, (byte[])localObject, false, bool);
      }
    }
    for (;;)
    {
      localObject = this.nCc;
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
        if (this.offset != this.hMP) {
          break label600;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", new Object[] { this.id, Integer.valueOf(this.hMP) });
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
      bIJ();
      AppMethodBeat.o(21947);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.d
 * JD-Core Version:    0.7.0.1
 */