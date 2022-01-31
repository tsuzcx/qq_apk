package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.l;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  extends com.tencent.mm.plugin.backup.g.b
{
  private v jEX;
  private w jEY;
  final String jId;
  final String jIe;
  private boolean jIf;
  final int jyJ;
  final byte[] key;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    AppMethodBeat.i(17879);
    this.jEX = new v();
    this.jEY = new w();
    this.jIf = false;
    ab.i("MicroMsg.BakOldAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", new Object[] { paramString3, paramString1, paramString2, bo.dtY() });
    this.jEX.jJh = new com.tencent.mm.bv.b(l.d(paramString1.getBytes(), paramArrayOfByte));
    this.jEX.jKr = 0;
    this.jEX.ID = paramString3;
    this.jEX.Version = 0;
    this.jId = paramString2;
    this.jIe = paramString3;
    this.key = paramArrayOfByte;
    this.jyJ = -1;
    AppMethodBeat.o(17879);
  }
  
  public final com.tencent.mm.bv.a aUl()
  {
    return this.jEY;
  }
  
  public final com.tencent.mm.bv.a aUm()
  {
    return this.jEX;
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void rt(int paramInt)
  {
    AppMethodBeat.i(17880);
    if (this.jEY.jJS == 0)
    {
      if (this.jIe.equals(this.jEY.ID))
      {
        String str = new String(l.c(this.jEY.jJh.pW, this.key));
        if (str.length() != this.jId.length()) {}
        for (boolean bool = false;; bool = str.equals(this.jId))
        {
          this.jIf = bool;
          ab.i("MicroMsg.BakOldAuthScene", "check ok result:%b", new Object[] { Boolean.valueOf(this.jIf) });
          if (!this.jIf) {
            break;
          }
          n(0, 0, "auth ok");
          this.jEX.jJh = new com.tencent.mm.bv.b(l.d(this.jId.getBytes(), this.key));
          this.jEX.jKr = 1;
          this.jEX.ID = this.jIe;
          try
          {
            ab.i("MicroMsg.BakOldAuthScene", "directSendAuthOk");
            com.tencent.mm.plugin.backup.g.b.r(this.jEX.toByteArray(), getType(), paramInt);
            AppMethodBeat.o(17880);
            return;
          }
          catch (Exception localException)
          {
            ab.printErrStackTrace("MicroMsg.BakOldAuthScene", localException, "directSendAuthOk req to bur err.", new Object[0]);
            AppMethodBeat.o(17880);
            return;
          }
        }
        ab.e("MicroMsg.BakOldAuthScene", "check ok failed");
        n(4, 1, "not ok packet");
        AppMethodBeat.o(17880);
        return;
      }
      ab.e("MicroMsg.BakOldAuthScene", "not the same id");
      n(4, -1, "not the same id");
      AppMethodBeat.o(17880);
      return;
    }
    ab.e("MicroMsg.BakOldAuthScene", "errType %d", new Object[] { Integer.valueOf(this.jEY.jJS) });
    n(4, this.jEY.jJS, "not not success");
    AppMethodBeat.o(17880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.a
 * JD-Core Version:    0.7.0.1
 */