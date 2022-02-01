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
  public v vct;
  public w vcu;
  final int vcv;
  final String vcw;
  final byte[] vcx;
  final String vcy;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(300719);
    this.vct = new v();
    this.vcu = new w();
    Log.i("MicroMsg.BackupAuthScene", "BackupAuthScene init, backupType[%d], stack:%s", new Object[] { Integer.valueOf(paramInt2), Util.getStack() });
    this.vct.vgA = new com.tencent.mm.bx.b(l.e(paramString1.getBytes(), paramArrayOfByte));
    this.vct.vhI = 0;
    this.vct.vgy = paramString3;
    this.vct.crz = paramInt1;
    paramString1 = this.vct;
    if (paramBoolean) {}
    for (paramInt1 = c.uVS;; paramInt1 = c.uVR)
    {
      paramString1.vhJ = paramInt1;
      this.vcw = paramString2;
      this.vcy = paramString3;
      this.vcx = paramArrayOfByte;
      this.vcv = paramInt2;
      AppMethodBeat.o(300719);
      return;
    }
  }
  
  public final void Fo(int paramInt)
  {
    AppMethodBeat.i(21696);
    if (this.vcu.vhk != 0)
    {
      Log.e("MicroMsg.BackupAuthScene", "onSceneEnd errType[%d]", new Object[] { Integer.valueOf(this.vcu.vhk) });
      u(4, this.vcu.vhk, "onSceneEnd status failed");
      AppMethodBeat.o(21696);
      return;
    }
    if (!this.vcy.equals(this.vcu.vgy))
    {
      Log.e("MicroMsg.BackupAuthScene", "onSceneEnd not the same id");
      u(4, -1, "onSceneEnd not the same id");
      AppMethodBeat.o(21696);
      return;
    }
    String str = new String(l.d(this.vcu.vgA.Op, this.vcx));
    if (str.length() != this.vcw.length()) {}
    for (boolean bool = false;; bool = str.equals(this.vcw))
    {
      Log.i("MicroMsg.BackupAuthScene", "onSceneEnd check ok result[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      Log.e("MicroMsg.BackupAuthScene", "onSceneEnd check ok failed");
      u(4, -3, "onSceneEnd check ok failed");
      AppMethodBeat.o(21696);
      return;
    }
    u(0, 0, "onSceneEnd auth success");
    if ((this.vcv == 22) && (this.vcu.crz < c.uVQ))
    {
      AppMethodBeat.o(21696);
      return;
    }
    this.vct.vgA = new com.tencent.mm.bx.b(l.e(this.vcw.getBytes(), this.vcx));
    this.vct.vhI = 1;
    this.vct.vgy = this.vcy;
    try
    {
      Log.i("MicroMsg.BackupAuthScene", "directSendAuthOk");
      b.D(this.vct.toByteArray(), getType(), paramInt);
      AppMethodBeat.o(21696);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.BackupAuthScene", localException, "directSendAuthOk req to bur err.", new Object[0]);
      AppMethodBeat.o(21696);
    }
  }
  
  public final void K(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      localv = this.vct;
      localv.vhK |= c.uVU;
    }
    v localv = this.vct;
    localv.vhK |= c.uVV;
    localv = this.vct;
    localv.vhK |= c.uVW;
    if (paramBoolean2)
    {
      localv = this.vct;
      localv.vhK |= c.uVX;
    }
  }
  
  public final com.tencent.mm.bx.a cWm()
  {
    return this.vcu;
  }
  
  public final com.tencent.mm.bx.a cWn()
  {
    return this.vct;
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