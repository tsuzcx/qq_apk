package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
  extends b
{
  final String authId;
  public v mYs;
  public w mYt;
  final int mYu;
  final String mYv;
  final byte[] mYw;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21695);
    this.mYs = new v();
    this.mYt = new w();
    ac.i("MicroMsg.BackupAuthScene", "BackupAuthScene init, backupType[%d], stack:%s", new Object[] { Integer.valueOf(paramInt2), bs.eWi() });
    this.mYs.ncy = new com.tencent.mm.bw.b(l.e(paramString1.getBytes(), paramArrayOfByte));
    this.mYs.ndH = 0;
    this.mYs.ID = paramString3;
    this.mYs.Version = paramInt1;
    this.mYv = paramString2;
    this.authId = paramString3;
    this.mYw = paramArrayOfByte;
    this.mYu = paramInt2;
    AppMethodBeat.o(21695);
  }
  
  public final void B(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      localv = this.mYs;
      localv.ndJ |= c.mRY;
    }
    v localv = this.mYs;
    localv.ndJ |= c.mRZ;
    localv = this.mYs;
    localv.ndJ |= c.mSa;
    if (paramBoolean2)
    {
      localv = this.mYs;
      localv.ndJ |= c.mSb;
    }
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
    AppMethodBeat.i(21696);
    if (this.mYt.ndj != 0)
    {
      ac.e("MicroMsg.BackupAuthScene", "onSceneEnd errType[%d]", new Object[] { Integer.valueOf(this.mYt.ndj) });
      q(4, this.mYt.ndj, "onSceneEnd status failed");
      AppMethodBeat.o(21696);
      return;
    }
    if (!this.authId.equals(this.mYt.ID))
    {
      ac.e("MicroMsg.BackupAuthScene", "onSceneEnd not the same id");
      q(4, -1, "onSceneEnd not the same id");
      AppMethodBeat.o(21696);
      return;
    }
    String str = new String(l.d(this.mYt.ncy.xy, this.mYw));
    if (str.length() != this.mYv.length()) {}
    for (boolean bool = false;; bool = str.equals(this.mYv))
    {
      ac.i("MicroMsg.BackupAuthScene", "onSceneEnd check ok result[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      ac.e("MicroMsg.BackupAuthScene", "onSceneEnd check ok failed");
      q(4, -3, "onSceneEnd check ok failed");
      AppMethodBeat.o(21696);
      return;
    }
    q(0, 0, "onSceneEnd auth success");
    if ((this.mYu == 22) && (this.mYt.Version < c.mRU))
    {
      AppMethodBeat.o(21696);
      return;
    }
    this.mYs.ncy = new com.tencent.mm.bw.b(l.e(this.mYv.getBytes(), this.mYw));
    this.mYs.ndH = 1;
    this.mYs.ID = this.authId;
    try
    {
      ac.i("MicroMsg.BackupAuthScene", "directSendAuthOk");
      b.t(this.mYs.toByteArray(), getType(), paramInt);
      AppMethodBeat.o(21696);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.BackupAuthScene", localException, "directSendAuthOk req to bur err.", new Object[0]);
      AppMethodBeat.o(21696);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.a
 * JD-Core Version:    0.7.0.1
 */