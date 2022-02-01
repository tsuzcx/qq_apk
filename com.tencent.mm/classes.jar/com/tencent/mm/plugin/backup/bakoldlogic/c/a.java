package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends com.tencent.mm.plugin.backup.g.b
{
  final byte[] key;
  final int oIY;
  private v oPh;
  private w oPi;
  final String oSl;
  final String oSm;
  private boolean oSn;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    AppMethodBeat.i(21936);
    this.oPh = new v();
    this.oPi = new w();
    this.oSn = false;
    Log.i("MicroMsg.BakOldAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", new Object[] { paramString3, paramString1, paramString2, Util.getStack() });
    this.oPh.oTm = new com.tencent.mm.bw.b(l.e(paramString1.getBytes(), paramArrayOfByte));
    this.oPh.oUu = 0;
    this.oPh.ID = paramString3;
    this.oPh.Version = 0;
    this.oSl = paramString2;
    this.oSm = paramString3;
    this.key = paramArrayOfByte;
    this.oIY = -1;
    AppMethodBeat.o(21936);
  }
  
  public final void Bm(int paramInt)
  {
    AppMethodBeat.i(21937);
    if (this.oPi.oTW == 0)
    {
      if (this.oSm.equals(this.oPi.ID))
      {
        String str = new String(l.d(this.oPi.oTm.zy, this.key));
        if (str.length() != this.oSl.length()) {}
        for (boolean bool = false;; bool = str.equals(this.oSl))
        {
          this.oSn = bool;
          Log.i("MicroMsg.BakOldAuthScene", "check ok result:%b", new Object[] { Boolean.valueOf(this.oSn) });
          if (!this.oSn) {
            break;
          }
          q(0, 0, "auth ok");
          this.oPh.oTm = new com.tencent.mm.bw.b(l.e(this.oSl.getBytes(), this.key));
          this.oPh.oUu = 1;
          this.oPh.ID = this.oSm;
          try
          {
            Log.i("MicroMsg.BakOldAuthScene", "directSendAuthOk");
            com.tencent.mm.plugin.backup.g.b.D(this.oPh.toByteArray(), getType(), paramInt);
            AppMethodBeat.o(21937);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.BakOldAuthScene", localException, "directSendAuthOk req to bur err.", new Object[0]);
            AppMethodBeat.o(21937);
            return;
          }
        }
        Log.e("MicroMsg.BakOldAuthScene", "check ok failed");
        q(4, 1, "not ok packet");
        AppMethodBeat.o(21937);
        return;
      }
      Log.e("MicroMsg.BakOldAuthScene", "not the same id");
      q(4, -1, "not the same id");
      AppMethodBeat.o(21937);
      return;
    }
    Log.e("MicroMsg.BakOldAuthScene", "errType %d", new Object[] { Integer.valueOf(this.oPi.oTW) });
    q(4, this.oPi.oTW, "not not success");
    AppMethodBeat.o(21937);
  }
  
  public final com.tencent.mm.bw.a cgq()
  {
    return this.oPi;
  }
  
  public final com.tencent.mm.bw.a cgr()
  {
    return this.oPh;
  }
  
  public final int getType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.a
 * JD-Core Version:    0.7.0.1
 */