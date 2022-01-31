package com.tencent.mm.plugin.appbrand.game.a;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  protected final boolean BA()
  {
    return !cT(-108, 1);
  }
  
  protected final void Bz()
  {
    if (BA()) {
      A(-108L, 1L);
    }
  }
  
  public final String getName()
  {
    return "FTS5MiniGameStorage";
  }
  
  public final int getPriority()
  {
    return 8;
  }
  
  protected final String getTableName()
  {
    return "MiniGame";
  }
  
  public final int getType()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.a
 * JD-Core Version:    0.7.0.1
 */