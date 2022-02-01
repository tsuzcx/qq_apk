package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends com.tencent.mm.plugin.backup.g.b
{
  final byte[] key;
  final int mqf;
  private v mwr;
  private w mws;
  final String mzv;
  final String mzw;
  private boolean mzx;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    AppMethodBeat.i(21936);
    this.mwr = new v();
    this.mws = new w();
    this.mzx = false;
    ad.i("MicroMsg.BakOldAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", new Object[] { paramString3, paramString1, paramString2, bt.eGN() });
    this.mwr.mAx = new com.tencent.mm.bx.b(l.e(paramString1.getBytes(), paramArrayOfByte));
    this.mwr.mBG = 0;
    this.mwr.ID = paramString3;
    this.mwr.Version = 0;
    this.mzv = paramString2;
    this.mzw = paramString3;
    this.key = paramArrayOfByte;
    this.mqf = -1;
    AppMethodBeat.o(21936);
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
    AppMethodBeat.i(21937);
    if (this.mws.mBi == 0)
    {
      if (this.mzw.equals(this.mws.ID))
      {
        String str = new String(l.d(this.mws.mAx.wA, this.key));
        if (str.length() != this.mzv.length()) {}
        for (boolean bool = false;; bool = str.equals(this.mzv))
        {
          this.mzx = bool;
          ad.i("MicroMsg.BakOldAuthScene", "check ok result:%b", new Object[] { Boolean.valueOf(this.mzx) });
          if (!this.mzx) {
            break;
          }
          q(0, 0, "auth ok");
          this.mwr.mAx = new com.tencent.mm.bx.b(l.e(this.mzv.getBytes(), this.key));
          this.mwr.mBG = 1;
          this.mwr.ID = this.mzw;
          try
          {
            ad.i("MicroMsg.BakOldAuthScene", "directSendAuthOk");
            com.tencent.mm.plugin.backup.g.b.u(this.mwr.toByteArray(), getType(), paramInt);
            AppMethodBeat.o(21937);
            return;
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.BakOldAuthScene", localException, "directSendAuthOk req to bur err.", new Object[0]);
            AppMethodBeat.o(21937);
            return;
          }
        }
        ad.e("MicroMsg.BakOldAuthScene", "check ok failed");
        q(4, 1, "not ok packet");
        AppMethodBeat.o(21937);
        return;
      }
      ad.e("MicroMsg.BakOldAuthScene", "not the same id");
      q(4, -1, "not the same id");
      AppMethodBeat.o(21937);
      return;
    }
    ad.e("MicroMsg.BakOldAuthScene", "errType %d", new Object[] { Integer.valueOf(this.mws.mBi) });
    q(4, this.mws.mBi, "not not success");
    AppMethodBeat.o(21937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.a
 * JD-Core Version:    0.7.0.1
 */