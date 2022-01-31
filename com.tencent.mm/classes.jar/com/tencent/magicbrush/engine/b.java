package com.tencent.magicbrush.engine;

public final class b
{
  protected long bkx;
  
  public b(String paramString, byte[] paramArrayOfByte)
  {
    this.bkx = JsEngine.createVM(paramString, paramArrayOfByte);
  }
  
  public final void dispose()
  {
    if (this.bkx == 0L) {
      return;
    }
    JsEngine.releaseVM(this.bkx);
    this.bkx = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.engine.b
 * JD-Core Version:    0.7.0.1
 */