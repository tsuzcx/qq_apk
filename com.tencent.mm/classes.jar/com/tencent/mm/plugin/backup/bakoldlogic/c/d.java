package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.i.ad;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;

public final class d
  extends com.tencent.mm.plugin.backup.g.b
{
  private static int progress;
  private int hPI;
  public String id;
  private byte[] key;
  private g nHt;
  private ad nHv;
  private com.tencent.mm.plugin.backup.i.ae nHw;
  private String nHx;
  private int offset;
  private int start;
  
  public d(String paramString1, String paramString2, int paramInt1, int paramInt2, g paramg, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21944);
    this.nHv = new ad();
    this.nHw = new com.tencent.mm.plugin.backup.i.ae();
    this.nHt = null;
    this.start = 0;
    this.offset = 0;
    if (paramInt1 == 1) {}
    for (this.nHx = (paramString1 + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.WQ(paramString2));; this.nHx = (paramString1 + "backupMeida/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.WQ(paramString2)))
    {
      this.id = paramString2;
      this.nHv.nJE = paramString2;
      this.nHv.nJF = paramInt1;
      this.hPI = paramInt2;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", new Object[] { this.nHv.nJE, Integer.valueOf(this.nHv.nJF), Integer.valueOf(this.hPI) });
      this.nHt = paramg;
      this.key = paramArrayOfByte;
      AppMethodBeat.o(21944);
      return;
    }
  }
  
  public static void setProgress(int paramInt)
  {
    AppMethodBeat.i(21946);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BakSceneRestoreData", "setProgress %d", new Object[] { Integer.valueOf(paramInt) });
    progress = paramInt;
    AppMethodBeat.o(21946);
  }
  
  public final boolean bJH()
  {
    long l = 524288L;
    AppMethodBeat.i(21945);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BakSceneRestoreData", "doSecne");
    int i = this.hPI;
    if (this.nHv.nJF == 2) {
      if (this.hPI - this.offset > 524288L) {
        i = (int)l;
      }
    }
    for (;;)
    {
      this.start = this.offset;
      this.offset = (i + this.start);
      this.nHv.nJH = this.start;
      this.nHv.nJI = this.offset;
      this.nHv.nJK = progress;
      boolean bool = super.bJH();
      AppMethodBeat.o(21945);
      return bool;
      l = this.hPI - this.offset;
      break;
    }
  }
  
  public final com.tencent.mm.bw.a bJx()
  {
    return this.nHw;
  }
  
  public final com.tencent.mm.bw.a bJy()
  {
    return this.nHv;
  }
  
  public final int getType()
  {
    return 7;
  }
  
  public final void xG(int paramInt)
  {
    AppMethodBeat.i(21947);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", new Object[] { this.nHw.nJE, Integer.valueOf(this.nHw.nJF), Integer.valueOf(this.nHw.nJH), Integer.valueOf(this.nHw.nJI), Integer.valueOf(this.nHw.nJb) });
    if ((this.nHw.nJb != 0) && (this.nHw.nJb != 10))
    {
      q(4, this.nHw.nJb, "error");
      AppMethodBeat.o(21947);
      return;
    }
    if ((this.nHw.nJH != this.start) || (this.nHw.nJI != this.offset))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", new Object[] { Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.nHw.nJH), Integer.valueOf(this.nHw.nJI) });
      q(3, -1, "error");
      AppMethodBeat.o(21947);
      return;
    }
    this.nHt.a(this.nHv.nJI - this.nHv.nJH, this.hPI, this);
    byte[] arrayOfByte = this.nHw.nIq.zr;
    Object localObject;
    boolean bool;
    if (this.key != null)
    {
      localObject = this.key;
      if (this.offset == this.hPI)
      {
        bool = true;
        arrayOfByte = AesEcb.aesCryptEcb(arrayOfByte, (byte[])localObject, false, bool);
      }
    }
    for (;;)
    {
      localObject = this.nHx;
      String str = this.id;
      k localk = new k((String)localObject + str);
      long l1;
      label355:
      long l2;
      if (localk.exists())
      {
        l1 = localk.length();
        o.e((String)localObject + str, arrayOfByte, arrayOfByte.length);
        localk = new k((String)localObject + str);
        if (!localk.exists()) {
          break label587;
        }
        l2 = localk.length();
        label428:
        if (l1 == l2)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", new Object[] { (String)localObject + str });
          o.e((String)localObject + str, arrayOfByte, arrayOfByte.length);
        }
        if (arrayOfByte != null) {
          break label593;
        }
      }
      label587:
      label593:
      for (paramInt = 0;; paramInt = arrayOfByte.length)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BakSceneRestoreData", "onSceneEnd appendbuf len:%d", new Object[] { Integer.valueOf(paramInt) });
        if (this.offset != this.hPI) {
          break label600;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", new Object[] { this.id, Integer.valueOf(this.hPI) });
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
      bJH();
      AppMethodBeat.o(21947);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.d
 * JD-Core Version:    0.7.0.1
 */