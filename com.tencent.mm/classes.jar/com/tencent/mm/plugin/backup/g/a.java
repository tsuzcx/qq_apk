package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.a.k;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends b
{
  public v hLu = new v();
  public w hLv = new w();
  final int hLw;
  final String hLx;
  final byte[] hLy;
  final String hLz;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.BackupAuthScene", "BackupAuthScene init, backupType[%d], stack:%s", new Object[] { Integer.valueOf(paramInt2), bk.csb() });
    this.hLu.hPF = new com.tencent.mm.bv.b(k.b(paramString1.getBytes(), paramArrayOfByte));
    this.hLu.hQP = 0;
    this.hLu.ID = paramString3;
    this.hLu.hQQ = paramInt1;
    this.hLx = paramString2;
    this.hLz = paramString3;
    this.hLy = paramArrayOfByte;
    this.hLw = paramInt2;
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
    if (this.hLv.hQq != 0)
    {
      y.e("MicroMsg.BackupAuthScene", "onSceneEnd errType[%d]", new Object[] { Integer.valueOf(this.hLv.hQq) });
      j(4, this.hLv.hQq, "onSceneEnd status failed");
    }
    do
    {
      return;
      if (!this.hLz.equals(this.hLv.ID))
      {
        y.e("MicroMsg.BackupAuthScene", "onSceneEnd not the same id");
        j(4, -1, "onSceneEnd not the same id");
        return;
      }
      String str = new String(k.a(this.hLv.hPF.oY, this.hLy));
      if (str.length() != this.hLx.length()) {}
      for (boolean bool = false;; bool = str.equals(this.hLx))
      {
        y.i("MicroMsg.BackupAuthScene", "onSceneEnd check ok result[%b]", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          break;
        }
        y.e("MicroMsg.BackupAuthScene", "onSceneEnd check ok failed");
        j(4, -3, "onSceneEnd check ok failed");
        return;
      }
      j(0, 0, "onSceneEnd auth success");
    } while ((this.hLw == 22) && (this.hLv.hQQ < c.hFe));
    this.hLu.hPF = new com.tencent.mm.bv.b(k.b(this.hLx.getBytes(), this.hLy));
    this.hLu.hQP = 1;
    this.hLu.ID = this.hLz;
    try
    {
      y.i("MicroMsg.BackupAuthScene", "directSendAuthOk");
      b.o(this.hLu.toByteArray(), 1, paramInt);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.BackupAuthScene", localException, "directSendAuthOk req to bur err.", new Object[0]);
    }
  }
  
  public final void t(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      localv = this.hLu;
      localv.hQS |= c.hFi;
    }
    v localv = this.hLu;
    localv.hQS |= c.hFj;
    localv = this.hLu;
    localv.hQS |= c.hFk;
    if (paramBoolean2)
    {
      localv = this.hLu;
      localv.hQS |= c.hFl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.a
 * JD-Core Version:    0.7.0.1
 */