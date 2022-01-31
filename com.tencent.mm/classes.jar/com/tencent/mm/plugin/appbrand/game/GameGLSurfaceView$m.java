package com.tencent.mm.plugin.appbrand.game;

import com.tencent.magicbrush.a.d.f;
import java.io.Writer;

final class GameGLSurfaceView$m
  extends Writer
{
  private StringBuilder mBuilder = new StringBuilder();
  
  private void db()
  {
    if (this.mBuilder.length() > 0)
    {
      d.f.v("GLSurfaceView", this.mBuilder.toString(), new Object[0]);
      this.mBuilder.delete(0, this.mBuilder.length());
    }
  }
  
  public final void close()
  {
    db();
  }
  
  public final void flush()
  {
    db();
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        db();
      }
      for (;;)
      {
        i += 1;
        break;
        this.mBuilder.append(c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.m
 * JD-Core Version:    0.7.0.1
 */