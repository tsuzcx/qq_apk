package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
  extends com.tencent.mm.plugin.backup.g.b
{
  final byte[] key;
  final int mSg;
  private v mYs;
  private w mYt;
  final String nbw;
  final String nbx;
  private boolean nby;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    AppMethodBeat.i(21936);
    this.mYs = new v();
    this.mYt = new w();
    this.nby = false;
    ac.i("MicroMsg.BakOldAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", new Object[] { paramString3, paramString1, paramString2, bs.eWi() });
    this.mYs.ncy = new com.tencent.mm.bw.b(l.e(paramString1.getBytes(), paramArrayOfByte));
    this.mYs.ndH = 0;
    this.mYs.ID = paramString3;
    this.mYs.Version = 0;
    this.nbw = paramString2;
    this.nbx = paramString3;
    this.key = paramArrayOfByte;
    this.mSg = -1;
    AppMethodBeat.o(21936);
  }
  
  public final com.tencent.mm.bw.a bEq()
  {
    return this.mYt;
  }
  
  public final com.tencent.mm.bw.a bEr()
  {
    return this.mYs;
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void wW(int paramInt)
  {
    AppMethodBeat.i(21937);
    if (this.mYt.ndj == 0)
    {
      if (this.nbx.equals(this.mYt.ID))
      {
        String str = new String(l.d(this.mYt.ncy.xy, this.key));
        if (str.length() != this.nbw.length()) {}
        for (boolean bool = false;; bool = str.equals(this.nbw))
        {
          this.nby = bool;
          ac.i("MicroMsg.BakOldAuthScene", "check ok result:%b", new Object[] { Boolean.valueOf(this.nby) });
          if (!this.nby) {
            break;
          }
          q(0, 0, "auth ok");
          this.mYs.ncy = new com.tencent.mm.bw.b(l.e(this.nbw.getBytes(), this.key));
          this.mYs.ndH = 1;
          this.mYs.ID = this.nbx;
          try
          {
            ac.i("MicroMsg.BakOldAuthScene", "directSendAuthOk");
            com.tencent.mm.plugin.backup.g.b.t(this.mYs.toByteArray(), getType(), paramInt);
            AppMethodBeat.o(21937);
            return;
          }
          catch (Exception localException)
          {
            ac.printErrStackTrace("MicroMsg.BakOldAuthScene", localException, "directSendAuthOk req to bur err.", new Object[0]);
            AppMethodBeat.o(21937);
            return;
          }
        }
        ac.e("MicroMsg.BakOldAuthScene", "check ok failed");
        q(4, 1, "not ok packet");
        AppMethodBeat.o(21937);
        return;
      }
      ac.e("MicroMsg.BakOldAuthScene", "not the same id");
      q(4, -1, "not the same id");
      AppMethodBeat.o(21937);
      return;
    }
    ac.e("MicroMsg.BakOldAuthScene", "errType %d", new Object[] { Integer.valueOf(this.mYt.ndj) });
    q(4, this.mYt.ndj, "not not success");
    AppMethodBeat.o(21937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.a
 * JD-Core Version:    0.7.0.1
 */