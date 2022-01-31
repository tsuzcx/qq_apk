package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.a.k;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends com.tencent.mm.plugin.backup.g.b
{
  final int hFq;
  private v hLu = new v();
  private w hLv = new w();
  final String hOB;
  final String hOC;
  private boolean hOD = false;
  final byte[] key;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    y.i("MicroMsg.BakOldAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", new Object[] { paramString3, paramString1, paramString2, bk.csb() });
    this.hLu.hPF = new com.tencent.mm.bv.b(k.b(paramString1.getBytes(), paramArrayOfByte));
    this.hLu.hQP = 0;
    this.hLu.ID = paramString3;
    this.hLu.hQQ = 0;
    this.hOB = paramString2;
    this.hOC = paramString3;
    this.key = paramArrayOfByte;
    this.hFq = -1;
  }
  
  public final com.tencent.mm.bv.a auJ()
  {
    return this.hLv;
  }
  
  public final com.tencent.mm.bv.a auK()
  {
    return this.hLu;
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void nF(int paramInt)
  {
    if (this.hLv.hQq == 0)
    {
      if (this.hOC.equals(this.hLv.ID))
      {
        String str = new String(k.a(this.hLv.hPF.oY, this.key));
        if (str.length() != this.hOB.length()) {}
        for (boolean bool = false;; bool = str.equals(this.hOB))
        {
          this.hOD = bool;
          y.i("MicroMsg.BakOldAuthScene", "check ok result:%b", new Object[] { Boolean.valueOf(this.hOD) });
          if (!this.hOD) {
            break;
          }
          j(0, 0, "auth ok");
          this.hLu.hPF = new com.tencent.mm.bv.b(k.b(this.hOB.getBytes(), this.key));
          this.hLu.hQP = 1;
          this.hLu.ID = this.hOC;
          try
          {
            y.i("MicroMsg.BakOldAuthScene", "directSendAuthOk");
            com.tencent.mm.plugin.backup.g.b.o(this.hLu.toByteArray(), 1, paramInt);
            return;
          }
          catch (Exception localException)
          {
            y.printErrStackTrace("MicroMsg.BakOldAuthScene", localException, "directSendAuthOk req to bur err.", new Object[0]);
            return;
          }
        }
        y.e("MicroMsg.BakOldAuthScene", "check ok failed");
        j(4, 1, "not ok packet");
        return;
      }
      y.e("MicroMsg.BakOldAuthScene", "not the same id");
      j(4, -1, "not the same id");
      return;
    }
    y.e("MicroMsg.BakOldAuthScene", "errType %d", new Object[] { Integer.valueOf(this.hLv.hQq) });
    j(4, this.hLv.hQq, "not not success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.a
 * JD-Core Version:    0.7.0.1
 */