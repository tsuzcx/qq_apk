package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.backup.i.n;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.sdk.platformtools.y;

public final class k
  extends b
{
  public n hMD = new n();
  public o hME = new o();
  
  public k(String paramString)
  {
    y.i("MicroMsg.BackupStartScene", "BackupStartScene, id[%s]", new Object[] { paramString });
    this.hMD.ID = paramString;
  }
  
  public final a auK()
  {
    return this.hMD;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void nF(int paramInt)
  {
    y.i("MicroMsg.BackupStartScene", "onSceneEnd.");
    if (this.hME.hQq != 0)
    {
      j(4, this.hME.hQq, "BackupStartScene onSceneEnd failed");
      return;
    }
    j(0, this.hME.hQq, "BackupStartScene onSceneEnd success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.k
 * JD-Core Version:    0.7.0.1
 */