package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
  extends b
{
  final String authId;
  public v nEk;
  public w nEl;
  final int nEm;
  final String nEn;
  final byte[] nEo;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21695);
    this.nEk = new v();
    this.nEl = new w();
    ae.i("MicroMsg.BackupAuthScene", "BackupAuthScene init, backupType[%d], stack:%s", new Object[] { Integer.valueOf(paramInt2), bu.fpN() });
    this.nEk.nIq = new com.tencent.mm.bw.b(l.e(paramString1.getBytes(), paramArrayOfByte));
    this.nEk.nJz = 0;
    this.nEk.ID = paramString3;
    this.nEk.Version = paramInt1;
    this.nEn = paramString2;
    this.authId = paramString3;
    this.nEo = paramArrayOfByte;
    this.nEm = paramInt2;
    AppMethodBeat.o(21695);
  }
  
  public final void B(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      localv = this.nEk;
      localv.nJB |= c.nxS;
    }
    v localv = this.nEk;
    localv.nJB |= c.nxT;
    localv = this.nEk;
    localv.nJB |= c.nxU;
    if (paramBoolean2)
    {
      localv = this.nEk;
      localv.nJB |= c.nxV;
    }
  }
  
  public final com.tencent.mm.bw.a bJx()
  {
    return this.nEl;
  }
  
  public final com.tencent.mm.bw.a bJy()
  {
    return this.nEk;
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void xG(int paramInt)
  {
    AppMethodBeat.i(21696);
    if (this.nEl.nJb != 0)
    {
      ae.e("MicroMsg.BackupAuthScene", "onSceneEnd errType[%d]", new Object[] { Integer.valueOf(this.nEl.nJb) });
      q(4, this.nEl.nJb, "onSceneEnd status failed");
      AppMethodBeat.o(21696);
      return;
    }
    if (!this.authId.equals(this.nEl.ID))
    {
      ae.e("MicroMsg.BackupAuthScene", "onSceneEnd not the same id");
      q(4, -1, "onSceneEnd not the same id");
      AppMethodBeat.o(21696);
      return;
    }
    String str = new String(l.d(this.nEl.nIq.zr, this.nEo));
    if (str.length() != this.nEn.length()) {}
    for (boolean bool = false;; bool = str.equals(this.nEn))
    {
      ae.i("MicroMsg.BackupAuthScene", "onSceneEnd check ok result[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      ae.e("MicroMsg.BackupAuthScene", "onSceneEnd check ok failed");
      q(4, -3, "onSceneEnd check ok failed");
      AppMethodBeat.o(21696);
      return;
    }
    q(0, 0, "onSceneEnd auth success");
    if ((this.nEm == 22) && (this.nEl.Version < c.nxO))
    {
      AppMethodBeat.o(21696);
      return;
    }
    this.nEk.nIq = new com.tencent.mm.bw.b(l.e(this.nEn.getBytes(), this.nEo));
    this.nEk.nJz = 1;
    this.nEk.ID = this.authId;
    try
    {
      ae.i("MicroMsg.BackupAuthScene", "directSendAuthOk");
      b.t(this.nEk.toByteArray(), getType(), paramInt);
      AppMethodBeat.o(21696);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.BackupAuthScene", localException, "directSendAuthOk req to bur err.", new Object[0]);
      AppMethodBeat.o(21696);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.a
 * JD-Core Version:    0.7.0.1
 */