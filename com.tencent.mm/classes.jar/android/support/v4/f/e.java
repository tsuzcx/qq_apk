package android.support.v4.f;

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
  
  private void db()
  {
    if (this.mBuilder.length() > 0) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.f.e
 * JD-Core Version:    0.7.0.1
 */