package com.tencent.matrix.a.b;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.NoSuchElementException;

final class k
{
  private boolean eSe = true;
  private final byte[] eTS;
  private RandomAccessFile eTT;
  char eTU;
  private char eTV;
  private boolean eTW = false;
  private int ebW;
  private final String mPath;
  private int mPosition = -1;
  
  k(String paramString, byte[] paramArrayOfByte)
  {
    this.mPath = paramString;
    this.eTS = paramArrayOfByte;
  }
  
  public final k axy()
  {
    this.eSe = true;
    if (this.eTT != null) {}
    try
    {
      this.eTT.seek(0L);
      if (this.eTT != null) {}
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          this.eTT = new RandomAccessFile(this.mPath, "r");
          if (this.eSe)
          {
            this.mPosition = -1;
            this.ebW = 0;
            this.eTU = '\000';
            this.eTV = '\000';
            this.eTW = false;
          }
          return this;
        }
        catch (IOException localIOException2)
        {
          this.eSe = false;
          close();
          throw new l.c("RAF err: " + localIOException2.getMessage());
        }
        localIOException1 = localIOException1;
        close();
      }
    }
  }
  
  public final long axz()
  {
    long l2 = 1L;
    long l1 = 0L;
    int i = 1;
    if (hasNext())
    {
      next();
      if (Character.isDigit(this.eTU)) {
        l1 = this.eTU - '0' + 10L * l1;
      }
      for (;;)
      {
        i = 0;
        break;
        if (i == 0) {
          break label79;
        }
        if (this.eTU != '-') {
          break label69;
        }
        l2 = -1L;
      }
      label69:
      throw new a("Couldn't read number!");
      label79:
      bh();
    }
    if (i != 0) {
      throw new a("Couldn't read number because the file ended!");
    }
    return l2 * l1;
  }
  
  final void bh()
  {
    if (this.eTW) {
      throw new a("Can only rewind one step!");
    }
    this.mPosition -= 1;
    this.eTU = this.eTV;
    this.eTW = true;
  }
  
  /* Error */
  public final void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/matrix/a/b/k:eTT	Ljava/io/RandomAccessFile;
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 44	com/tencent/matrix/a/b/k:eTT	Ljava/io/RandomAccessFile;
    //   11: invokevirtual 115	java/io/RandomAccessFile:close	()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 44	com/tencent/matrix/a/b/k:eTT	Ljava/io/RandomAccessFile;
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 44	com/tencent/matrix/a/b/k:eTT	Ljava/io/RandomAccessFile;
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 44	com/tencent/matrix/a/b/k:eTT	Ljava/io/RandomAccessFile;
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	k
    //   20	1	1	localIOException	IOException
    //   27	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	14	20	java/io/IOException
    //   7	14	27	finally
  }
  
  protected final void finalize()
  {
    close();
  }
  
  public final boolean hasNext()
  {
    for (;;)
    {
      if ((!this.eSe) || (this.eTT == null) || (this.mPosition > this.ebW - 1)) {
        return false;
      }
      if (this.mPosition < this.ebW - 1) {
        return true;
      }
      try
      {
        this.ebW = this.eTT.read(this.eTS);
        this.mPosition = -1;
      }
      catch (IOException localIOException)
      {
        this.eSe = false;
        close();
      }
    }
  }
  
  final void next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    this.mPosition += 1;
    this.eTV = this.eTU;
    this.eTU = ((char)this.eTS[this.mPosition]);
    this.eTW = false;
  }
  
  public final void s(char paramChar)
  {
    int i = 0;
    while (hasNext())
    {
      next();
      if (this.eTU == paramChar) {
        i = 1;
      } else if (i != 0) {
        bh();
      }
    }
  }
  
  static final class a
    extends RuntimeException
  {
    a(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.b.k
 * JD-Core Version:    0.7.0.1
 */