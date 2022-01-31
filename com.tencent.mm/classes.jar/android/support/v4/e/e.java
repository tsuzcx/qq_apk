package android.support.v4.e;

import java.io.Writer;

public final class e
  extends Writer
{
  private StringBuilder mBuilder = new StringBuilder(128);
  private final String mTag;
  
  public e(String paramString)
  {
    this.mTag = paramString;
  }
  
  private void flushBuilder()
  {
    if (this.mBuilder.length() > 0) {
      this.mBuilder.delete(0, this.mBuilder.length());
    }
  }
  
  public final void close()
  {
    flushBuilder();
  }
  
  public final void flush()
  {
    flushBuilder();
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        flushBuilder();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.e
 * JD-Core Version:    0.7.0.1
 */