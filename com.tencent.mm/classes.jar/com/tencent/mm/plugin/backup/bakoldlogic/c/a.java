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
  final int rKO;
  private v rRe;
  private w rRf;
  final String rUk;
  final String rUl;
  private boolean rUm;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    AppMethodBeat.i(21936);
    this.rRe = new v();
    this.rRf = new w();
    this.rUm = false;
    Log.i("MicroMsg.BakOldAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", new Object[] { paramString3, paramString1, paramString2, Util.getStack() });
    this.rRe.rVk = new com.tencent.mm.cd.b(l.e(paramString1.getBytes(), paramArrayOfByte));
    this.rRe.rWs = 0;
    this.rRe.ID = paramString3;
    this.rRe.rWt = 0;
    this.rUk = paramString2;
    this.rUl = paramString3;
    this.key = paramArrayOfByte;
    this.rKO = -1;
    AppMethodBeat.o(21936);
  }
  
  public final void EN(int paramInt)
  {
    AppMethodBeat.i(21937);
    if (this.rRf.rVU == 0)
    {
      if (this.rUl.equals(this.rRf.ID))
      {
        String str = new String(l.d(this.rRf.rVk.UH, this.key));
        if (str.length() != this.rUk.length()) {}
        for (boolean bool = false;; bool = str.equals(this.rUk))
        {
          this.rUm = bool;
          Log.i("MicroMsg.BakOldAuthScene", "check ok result:%b", new Object[] { Boolean.valueOf(this.rUm) });
          if (!this.rUm) {
            break;
          }
          r(0, 0, "auth ok");
          this.rRe.rVk = new com.tencent.mm.cd.b(l.e(this.rUk.getBytes(), this.key));
          this.rRe.rWs = 1;
          this.rRe.ID = this.rUl;
          try
          {
            Log.i("MicroMsg.BakOldAuthScene", "directSendAuthOk");
            com.tencent.mm.plugin.backup.g.b.F(this.rRe.toByteArray(), getType(), paramInt);
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
        r(4, 1, "not ok packet");
        AppMethodBeat.o(21937);
        return;
      }
      Log.e("MicroMsg.BakOldAuthScene", "not the same id");
      r(4, -1, "not the same id");
      AppMethodBeat.o(21937);
      return;
    }
    Log.e("MicroMsg.BakOldAuthScene", "errType %d", new Object[] { Integer.valueOf(this.rRf.rVU) });
    r(4, this.rRf.rVU, "not not success");
    AppMethodBeat.o(21937);
  }
  
  public final com.tencent.mm.cd.a ctC()
  {
    return this.rRf;
  }
  
  public final com.tencent.mm.cd.a ctD()
  {
    return this.rRe;
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