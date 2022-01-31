package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.game.d.as;
import com.tencent.mm.plugin.game.d.bh;
import com.tencent.mm.plugin.game.d.p;
import java.io.IOException;

public final class ac
  extends y
{
  private bh kQx;
  
  public ac(a parama)
  {
    if (parama == null)
    {
      this.kQx = new bh();
      return;
    }
    this.kQx = ((bh)parama);
  }
  
  public ac(byte[] paramArrayOfByte)
  {
    this.kQx = new bh();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    try
    {
      this.kQx.aH(paramArrayOfByte);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.GamePBDataDownloadGuidance", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
    }
  }
  
  public final p aZH()
  {
    if (this.kQx != null) {
      return this.kQx.kUN;
    }
    return null;
  }
  
  public final as aZI()
  {
    if (this.kQx != null) {
      return this.kQx.kUO;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ac
 * JD-Core Version:    0.7.0.1
 */