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
  final String nBT;
  final String nBU;
  private boolean nBV;
  final int nsF;
  private v nyP;
  private w nyQ;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    AppMethodBeat.i(21936);
    this.nyP = new v();
    this.nyQ = new w();
    this.nBV = false;
    ad.i("MicroMsg.BakOldAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", new Object[] { paramString3, paramString1, paramString2, bt.flS() });
    this.nyP.nCV = new com.tencent.mm.bx.b(l.e(paramString1.getBytes(), paramArrayOfByte));
    this.nyP.nEe = 0;
    this.nyP.ID = paramString3;
    this.nyP.Version = 0;
    this.nBT = paramString2;
    this.nBU = paramString3;
    this.key = paramArrayOfByte;
    this.nsF = -1;
    AppMethodBeat.o(21936);
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
    AppMethodBeat.i(21937);
    if (this.nyQ.nDG == 0)
    {
      if (this.nBU.equals(this.nyQ.ID))
      {
        String str = new String(l.d(this.nyQ.nCV.zr, this.key));
        if (str.length() != this.nBT.length()) {}
        for (boolean bool = false;; bool = str.equals(this.nBT))
        {
          this.nBV = bool;
          ad.i("MicroMsg.BakOldAuthScene", "check ok result:%b", new Object[] { Boolean.valueOf(this.nBV) });
          if (!this.nBV) {
            break;
          }
          q(0, 0, "auth ok");
          this.nyP.nCV = new com.tencent.mm.bx.b(l.e(this.nBT.getBytes(), this.key));
          this.nyP.nEe = 1;
          this.nyP.ID = this.nBU;
          try
          {
            ad.i("MicroMsg.BakOldAuthScene", "directSendAuthOk");
            com.tencent.mm.plugin.backup.g.b.t(this.nyP.toByteArray(), getType(), paramInt);
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
    ad.e("MicroMsg.BakOldAuthScene", "errType %d", new Object[] { Integer.valueOf(this.nyQ.nDG) });
    q(4, this.nyQ.nDG, "not not success");
    AppMethodBeat.o(21937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.a
 * JD-Core Version:    0.7.0.1
 */