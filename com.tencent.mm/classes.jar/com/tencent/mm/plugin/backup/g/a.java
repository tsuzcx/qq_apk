package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends b
{
  final String authId;
  public v rRe;
  public w rRf;
  final int rRg;
  final String rRh;
  final byte[] rRi;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(288138);
    this.rRe = new v();
    this.rRf = new w();
    Log.i("MicroMsg.BackupAuthScene", "BackupAuthScene init, backupType[%d], stack:%s", new Object[] { Integer.valueOf(paramInt2), Util.getStack() });
    this.rRe.rVk = new com.tencent.mm.cd.b(l.e(paramString1.getBytes(), paramArrayOfByte));
    this.rRe.rWs = 0;
    this.rRe.ID = paramString3;
    this.rRe.rWt = paramInt1;
    paramString1 = this.rRe;
    if (paramBoolean) {}
    for (paramInt1 = c.rKE;; paramInt1 = c.rKD)
    {
      paramString1.rWu = paramInt1;
      this.rRh = paramString2;
      this.authId = paramString3;
      this.rRi = paramArrayOfByte;
      this.rRg = paramInt2;
      AppMethodBeat.o(288138);
      return;
    }
  }
  
  public final void E(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      localv = this.rRe;
      localv.rWv |= c.rKG;
    }
    v localv = this.rRe;
    localv.rWv |= c.rKH;
    localv = this.rRe;
    localv.rWv |= c.rKI;
    if (paramBoolean2)
    {
      localv = this.rRe;
      localv.rWv |= c.rKJ;
    }
  }
  
  public final void EN(int paramInt)
  {
    AppMethodBeat.i(21696);
    if (this.rRf.rVU != 0)
    {
      Log.e("MicroMsg.BackupAuthScene", "onSceneEnd errType[%d]", new Object[] { Integer.valueOf(this.rRf.rVU) });
      r(4, this.rRf.rVU, "onSceneEnd status failed");
      AppMethodBeat.o(21696);
      return;
    }
    if (!this.authId.equals(this.rRf.ID))
    {
      Log.e("MicroMsg.BackupAuthScene", "onSceneEnd not the same id");
      r(4, -1, "onSceneEnd not the same id");
      AppMethodBeat.o(21696);
      return;
    }
    String str = new String(l.d(this.rRf.rVk.UH, this.rRi));
    if (str.length() != this.rRh.length()) {}
    for (boolean bool = false;; bool = str.equals(this.rRh))
    {
      Log.i("MicroMsg.BackupAuthScene", "onSceneEnd check ok result[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      Log.e("MicroMsg.BackupAuthScene", "onSceneEnd check ok failed");
      r(4, -3, "onSceneEnd check ok failed");
      AppMethodBeat.o(21696);
      return;
    }
    r(0, 0, "onSceneEnd auth success");
    if ((this.rRg == 22) && (this.rRf.rWt < c.rKC))
    {
      AppMethodBeat.o(21696);
      return;
    }
    this.rRe.rVk = new com.tencent.mm.cd.b(l.e(this.rRh.getBytes(), this.rRi));
    this.rRe.rWs = 1;
    this.rRe.ID = this.authId;
    try
    {
      Log.i("MicroMsg.BackupAuthScene", "directSendAuthOk");
      b.F(this.rRe.toByteArray(), getType(), paramInt);
      AppMethodBeat.o(21696);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupAuthScene", localException, "directSendAuthOk req to bur err.", new Object[0]);
      AppMethodBeat.o(21696);
    }
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
 * Qualified Name:     com.tencent.mm.plugin.backup.g.a
 * JD-Core Version:    0.7.0.1
 */