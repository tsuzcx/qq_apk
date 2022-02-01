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
  public v oPh;
  public w oPi;
  final int oPj;
  final String oPk;
  final byte[] oPl;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(231596);
    this.oPh = new v();
    this.oPi = new w();
    Log.i("MicroMsg.BackupAuthScene", "BackupAuthScene init, backupType[%d], stack:%s", new Object[] { Integer.valueOf(paramInt2), Util.getStack() });
    this.oPh.oTm = new com.tencent.mm.bw.b(l.e(paramString1.getBytes(), paramArrayOfByte));
    this.oPh.oUu = 0;
    this.oPh.ID = paramString3;
    this.oPh.Version = paramInt1;
    paramString1 = this.oPh;
    if (paramBoolean) {}
    for (paramInt1 = c.oIO;; paramInt1 = c.oIN)
    {
      paramString1.oUv = paramInt1;
      this.oPk = paramString2;
      this.authId = paramString3;
      this.oPl = paramArrayOfByte;
      this.oPj = paramInt2;
      AppMethodBeat.o(231596);
      return;
    }
  }
  
  public final void A(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      localv = this.oPh;
      localv.oUw |= c.oIQ;
    }
    v localv = this.oPh;
    localv.oUw |= c.oIR;
    localv = this.oPh;
    localv.oUw |= c.oIS;
    if (paramBoolean2)
    {
      localv = this.oPh;
      localv.oUw |= c.oIT;
    }
  }
  
  public final void Bm(int paramInt)
  {
    AppMethodBeat.i(21696);
    if (this.oPi.oTW != 0)
    {
      Log.e("MicroMsg.BackupAuthScene", "onSceneEnd errType[%d]", new Object[] { Integer.valueOf(this.oPi.oTW) });
      q(4, this.oPi.oTW, "onSceneEnd status failed");
      AppMethodBeat.o(21696);
      return;
    }
    if (!this.authId.equals(this.oPi.ID))
    {
      Log.e("MicroMsg.BackupAuthScene", "onSceneEnd not the same id");
      q(4, -1, "onSceneEnd not the same id");
      AppMethodBeat.o(21696);
      return;
    }
    String str = new String(l.d(this.oPi.oTm.zy, this.oPl));
    if (str.length() != this.oPk.length()) {}
    for (boolean bool = false;; bool = str.equals(this.oPk))
    {
      Log.i("MicroMsg.BackupAuthScene", "onSceneEnd check ok result[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      Log.e("MicroMsg.BackupAuthScene", "onSceneEnd check ok failed");
      q(4, -3, "onSceneEnd check ok failed");
      AppMethodBeat.o(21696);
      return;
    }
    q(0, 0, "onSceneEnd auth success");
    if ((this.oPj == 22) && (this.oPi.Version < c.oIM))
    {
      AppMethodBeat.o(21696);
      return;
    }
    this.oPh.oTm = new com.tencent.mm.bw.b(l.e(this.oPk.getBytes(), this.oPl));
    this.oPh.oUu = 1;
    this.oPh.ID = this.authId;
    try
    {
      Log.i("MicroMsg.BackupAuthScene", "directSendAuthOk");
      b.D(this.oPh.toByteArray(), getType(), paramInt);
      AppMethodBeat.o(21696);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupAuthScene", localException, "directSendAuthOk req to bur err.", new Object[0]);
      AppMethodBeat.o(21696);
    }
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
 * Qualified Name:     com.tencent.mm.plugin.backup.g.a
 * JD-Core Version:    0.7.0.1
 */