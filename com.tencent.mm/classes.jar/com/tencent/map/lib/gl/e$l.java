package com.tencent.map.lib.gl;

import java.io.Writer;

class e$l
  extends Writer
{
  private StringBuilder a = new StringBuilder();
  
  private void a()
  {
    if (this.a.length() > 0) {
      this.a.delete(0, this.a.length());
    }
  }
  
  public void close()
  {
    a();
  }
  
  public void flush()
  {
    a();
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        a();
      }
      for (;;)
      {
        i += 1;
        break;
        this.a.append(c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.map.lib.gl.e.l
 * JD-Core Version:    0.7.0.1
 */