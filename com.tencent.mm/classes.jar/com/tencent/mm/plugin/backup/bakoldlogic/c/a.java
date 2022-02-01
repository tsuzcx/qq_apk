package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
  extends com.tencent.mm.plugin.backup.g.b
{
  final byte[] key;
  private v nEk;
  private w nEl;
  final String nHo;
  final String nHp;
  private boolean nHq;
  final int nya;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    AppMethodBeat.i(21936);
    this.nEk = new v();
    this.nEl = new w();
    this.nHq = false;
    ae.i("MicroMsg.BakOldAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", new Object[] { paramString3, paramString1, paramString2, bu.fpN() });
    this.nEk.nIq = new com.tencent.mm.bw.b(l.e(paramString1.getBytes(), paramArrayOfByte));
    this.nEk.nJz = 0;
    this.nEk.ID = paramString3;
    this.nEk.Version = 0;
    this.nHo = paramString2;
    this.nHp = paramString3;
    this.key = paramArrayOfByte;
    this.nya = -1;
    AppMethodBeat.o(21936);
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
    AppMethodBeat.i(21937);
    if (this.nEl.nJb == 0)
    {
      if (this.nHp.equals(this.nEl.ID))
      {
        String str = new String(l.d(this.nEl.nIq.zr, this.key));
        if (str.length() != this.nHo.length()) {}
        for (boolean bool = false;; bool = str.equals(this.nHo))
        {
          this.nHq = bool;
          ae.i("MicroMsg.BakOldAuthScene", "check ok result:%b", new Object[] { Boolean.valueOf(this.nHq) });
          if (!this.nHq) {
            break;
          }
          q(0, 0, "auth ok");
          this.nEk.nIq = new com.tencent.mm.bw.b(l.e(this.nHo.getBytes(), this.key));
          this.nEk.nJz = 1;
          this.nEk.ID = this.nHp;
          try
          {
            ae.i("MicroMsg.BakOldAuthScene", "directSendAuthOk");
            com.tencent.mm.plugin.backup.g.b.t(this.nEk.toByteArray(), getType(), paramInt);
            AppMethodBeat.o(21937);
            return;
          }
          catch (Exception localException)
          {
            ae.printErrStackTrace("MicroMsg.BakOldAuthScene", localException, "directSendAuthOk req to bur err.", new Object[0]);
            AppMethodBeat.o(21937);
            return;
          }
        }
        ae.e("MicroMsg.BakOldAuthScene", "check ok failed");
        q(4, 1, "not ok packet");
        AppMethodBeat.o(21937);
        return;
      }
      ae.e("MicroMsg.BakOldAuthScene", "not the same id");
      q(4, -1, "not the same id");
      AppMethodBeat.o(21937);
      return;
    }
    ae.e("MicroMsg.BakOldAuthScene", "errType %d", new Object[] { Integer.valueOf(this.nEl.nJb) });
    q(4, this.nEl.nJb, "not not success");
    AppMethodBeat.o(21937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.a
 * JD-Core Version:    0.7.0.1
 */