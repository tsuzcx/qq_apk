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
  public v mwr;
  public w mws;
  final int mwt;
  final String mwu;
  final byte[] mwv;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21695);
    this.mwr = new v();
    this.mws = new w();
    ad.i("MicroMsg.BackupAuthScene", "BackupAuthScene init, backupType[%d], stack:%s", new Object[] { Integer.valueOf(paramInt2), bt.eGN() });
    this.mwr.mAx = new com.tencent.mm.bx.b(l.e(paramString1.getBytes(), paramArrayOfByte));
    this.mwr.mBG = 0;
    this.mwr.ID = paramString3;
    this.mwr.Version = paramInt1;
    this.mwu = paramString2;
    this.authId = paramString3;
    this.mwv = paramArrayOfByte;
    this.mwt = paramInt2;
    AppMethodBeat.o(21695);
  }
  
  public final void A(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      localv = this.mwr;
      localv.mBI |= c.mpX;
    }
    v localv = this.mwr;
    localv.mBI |= c.mpY;
    localv = this.mwr;
    localv.mBI |= c.mpZ;
    if (paramBoolean2)
    {
      localv = this.mwr;
      localv.mBI |= c.mqa;
    }
  }
  
  public final com.tencent.mm.bx.a bxu()
  {
    return this.mws;
  }
  
  public final com.tencent.mm.bx.a bxv()
  {
    return this.mwr;
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(21696);
    if (this.mws.mBi != 0)
    {
      ad.e("MicroMsg.BackupAuthScene", "onSceneEnd errType[%d]", new Object[] { Integer.valueOf(this.mws.mBi) });
      q(4, this.mws.mBi, "onSceneEnd status failed");
      AppMethodBeat.o(21696);
      return;
    }
    if (!this.authId.equals(this.mws.ID))
    {
      ad.e("MicroMsg.BackupAuthScene", "onSceneEnd not the same id");
      q(4, -1, "onSceneEnd not the same id");
      AppMethodBeat.o(21696);
      return;
    }
    String str = new String(l.d(this.mws.mAx.wA, this.mwv));
    if (str.length() != this.mwu.length()) {}
    for (boolean bool = false;; bool = str.equals(this.mwu))
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
    if ((this.mwt == 22) && (this.mws.Version < c.mpT))
    {
      AppMethodBeat.o(21696);
      return;
    }
    this.mwr.mAx = new com.tencent.mm.bx.b(l.e(this.mwu.getBytes(), this.mwv));
    this.mwr.mBG = 1;
    this.mwr.ID = this.authId;
    try
    {
      ad.i("MicroMsg.BackupAuthScene", "directSendAuthOk");
      b.u(this.mwr.toByteArray(), getType(), paramInt);
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