package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.l;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  extends b
{
  final String authId;
  public v jEX;
  public w jEY;
  final int jEZ;
  final String jFa;
  final byte[] jFb;
  
  public a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(17636);
    this.jEX = new v();
    this.jEY = new w();
    ab.i("MicroMsg.BackupAuthScene", "BackupAuthScene init, backupType[%d], stack:%s", new Object[] { Integer.valueOf(paramInt2), bo.dtY() });
    this.jEX.jJh = new com.tencent.mm.bv.b(l.d(paramString1.getBytes(), paramArrayOfByte));
    this.jEX.jKr = 0;
    this.jEX.ID = paramString3;
    this.jEX.Version = paramInt1;
    this.jFa = paramString2;
    this.authId = paramString3;
    this.jFb = paramArrayOfByte;
    this.jEZ = paramInt2;
    AppMethodBeat.o(17636);
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
    AppMethodBeat.i(17637);
    if (this.jEY.jJS != 0)
    {
      ab.e("MicroMsg.BackupAuthScene", "onSceneEnd errType[%d]", new Object[] { Integer.valueOf(this.jEY.jJS) });
      n(4, this.jEY.jJS, "onSceneEnd status failed");
      AppMethodBeat.o(17637);
      return;
    }
    if (!this.authId.equals(this.jEY.ID))
    {
      ab.e("MicroMsg.BackupAuthScene", "onSceneEnd not the same id");
      n(4, -1, "onSceneEnd not the same id");
      AppMethodBeat.o(17637);
      return;
    }
    String str = new String(l.c(this.jEY.jJh.pW, this.jFb));
    if (str.length() != this.jFa.length()) {}
    for (boolean bool = false;; bool = str.equals(this.jFa))
    {
      ab.i("MicroMsg.BackupAuthScene", "onSceneEnd check ok result[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      ab.e("MicroMsg.BackupAuthScene", "onSceneEnd check ok failed");
      n(4, -3, "onSceneEnd check ok failed");
      AppMethodBeat.o(17637);
      return;
    }
    n(0, 0, "onSceneEnd auth success");
    if ((this.jEZ == 22) && (this.jEY.Version < c.jyx))
    {
      AppMethodBeat.o(17637);
      return;
    }
    this.jEX.jJh = new com.tencent.mm.bv.b(l.d(this.jFa.getBytes(), this.jFb));
    this.jEX.jKr = 1;
    this.jEX.ID = this.authId;
    try
    {
      ab.i("MicroMsg.BackupAuthScene", "directSendAuthOk");
      b.r(this.jEX.toByteArray(), getType(), paramInt);
      AppMethodBeat.o(17637);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.BackupAuthScene", localException, "directSendAuthOk req to bur err.", new Object[0]);
      AppMethodBeat.o(17637);
    }
  }
  
  public final void t(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      localv = this.jEX;
      localv.jKt |= c.jyB;
    }
    v localv = this.jEX;
    localv.jKt |= c.jyC;
    localv = this.jEX;
    localv.jKt |= c.jyD;
    if (paramBoolean2)
    {
      localv = this.jEX;
      localv.jKt |= c.jyE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.a
 * JD-Core Version:    0.7.0.1
 */