package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends b
{
  final String authId;
  public v nyP;
  public w nyQ;
  final int nyR;
  final String nyS;
  final byte[] nyT;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21695);
    this.nyP = new v();
    this.nyQ = new w();
    ad.i("MicroMsg.BackupAuthScene", "BackupAuthScene init, backupType[%d], stack:%s", new Object[] { Integer.valueOf(paramInt2), bt.flS() });
    this.nyP.nCV = new com.tencent.mm.bx.b(l.e(paramString1.getBytes(), paramArrayOfByte));
    this.nyP.nEe = 0;
    this.nyP.ID = paramString3;
    this.nyP.Version = paramInt1;
    this.nyS = paramString2;
    this.authId = paramString3;
    this.nyT = paramArrayOfByte;
    this.nyR = paramInt2;
    AppMethodBeat.o(21695);
  }
  
  public final void B(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      localv = this.nyP;
      localv.nEg |= c.nsx;
    }
    v localv = this.nyP;
    localv.nEg |= c.nsy;
    localv = this.nyP;
    localv.nEg |= c.nsz;
    if (paramBoolean2)
    {
      localv = this.nyP;
      localv.nEg |= c.nsA;
    }
  }
  
  public final com.tencent.mm.bx.a bIA()
  {
    return this.nyP;
  }
  
  public final com.tencent.mm.bx.a bIz()
  {
    return this.nyQ;
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void xC(int paramInt)
  {
    AppMethodBeat.i(21696);
    if (this.nyQ.nDG != 0)
    {
      ad.e("MicroMsg.BackupAuthScene", "onSceneEnd errType[%d]", new Object[] { Integer.valueOf(this.nyQ.nDG) });
      q(4, this.nyQ.nDG, "onSceneEnd status failed");
      AppMethodBeat.o(21696);
      return;
    }
    if (!this.authId.equals(this.nyQ.ID))
    {
      ad.e("MicroMsg.BackupAuthScene", "onSceneEnd not the same id");
      q(4, -1, "onSceneEnd not the same id");
      AppMethodBeat.o(21696);
      return;
    }
    String str = new String(l.d(this.nyQ.nCV.zr, this.nyT));
    if (str.length() != this.nyS.length()) {}
    for (boolean bool = false;; bool = str.equals(this.nyS))
    {
      ad.i("MicroMsg.BackupAuthScene", "onSceneEnd check ok result[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      ad.e("MicroMsg.BackupAuthScene", "onSceneEnd check ok failed");
      q(4, -3, "onSceneEnd check ok failed");
      AppMethodBeat.o(21696);
      return;
    }
    q(0, 0, "onSceneEnd auth success");
    if ((this.nyR == 22) && (this.nyQ.Version < c.nst))
    {
      AppMethodBeat.o(21696);
      return;
    }
    this.nyP.nCV = new com.tencent.mm.bx.b(l.e(this.nyS.getBytes(), this.nyT));
    this.nyP.nEe = 1;
    this.nyP.ID = this.authId;
    try
    {
      ad.i("MicroMsg.BackupAuthScene", "directSendAuthOk");
      b.t(this.nyP.toByteArray(), getType(), paramInt);
      AppMethodBeat.o(21696);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BackupAuthScene", localException, "directSendAuthOk req to bur err.", new Object[0]);
      AppMethodBeat.o(21696);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.a
 * JD-Core Version:    0.7.0.1
 */