package com.bumptech.glide.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

final class b
  implements Closeable
{
  final Charset aDV;
  private byte[] buf;
  int end;
  private final InputStream in;
  private int pos;
  
  public b(InputStream paramInputStream, Charset paramCharset)
  {
    this(paramInputStream, paramCharset, (byte)0);
  }
  
  private b(InputStream paramInputStream, Charset paramCharset, byte paramByte)
  {
    AppMethodBeat.i(100640);
    if ((paramInputStream == null) || (paramCharset == null))
    {
      paramInputStream = new NullPointerException();
      AppMethodBeat.o(100640);
      throw paramInputStream;
    }
    if (!paramCharset.equals(c.US_ASCII))
    {
      paramInputStream = new IllegalArgumentException("Unsupported encoding");
      AppMethodBeat.o(100640);
      throw paramInputStream;
    }
    this.in = paramInputStream;
    this.aDV = paramCharset;
    this.buf = new byte[8192];
    AppMethodBeat.o(100640);
  }
  
  private void nY()
  {
    AppMethodBeat.i(100643);
    int i = this.in.read(this.buf, 0, this.buf.length);
    if (i == -1)
    {
      EOFException localEOFException = new EOFException();
      AppMethodBeat.o(100643);
      throw localEOFException;
    }
    this.pos = 0;
    this.end = i;
    AppMethodBeat.o(100643);
  }
  
  public final void close()
  {
    AppMethodBeat.i(100641);
    synchronized (this.in)
    {
      if (this.buf != null)
      {
        this.buf = null;
        this.in.close();
      }
      AppMethodBeat.o(100641);
      return;
    }
  }
  
  public final String readLine()
  {
    AppMethodBeat.i(100642);
    synchronized (this.in)
    {
      if (this.buf == null)
      {
        IOException localIOException = new IOException("LineReader is closed");
        AppMethodBeat.o(100642);
        throw localIOException;
      }
    }
    if (this.pos >= this.end) {
      nY();
    }
    int i = this.pos;
    while (i != this.end)
    {
      if (this.buf[i] == 10)
      {
        if ((i != this.pos) && (this.buf[(i - 1)] == 13)) {}
        for (int j = i - 1;; j = i)
        {
          localObject2 = new String(this.buf, this.pos, j - this.pos, this.aDV.name());
          this.pos = (i + 1);
          AppMethodBeat.o(100642);
          return localObject2;
        }
      }
      i += 1;
    }
    Object localObject2 = new ByteArrayOutputStream(this.end - this.pos + 80)
    {
      public final String toString()
      {
        AppMethodBeat.i(100637);
        if ((this.count > 0) && (this.buf[(this.count - 1)] == 13)) {}
        for (int i = this.count - 1;; i = this.count) {
          try
          {
            String str = new String(this.buf, 0, i, b.this.aDV.name());
            AppMethodBeat.o(100637);
            return str;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            AssertionError localAssertionError = new AssertionError(localUnsupportedEncodingException);
            AppMethodBeat.o(100637);
            throw localAssertionError;
          }
        }
      }
    };
    for (;;)
    {
      ((ByteArrayOutputStream)localObject2).write(this.buf, this.pos, this.end - this.pos);
      this.end = -1;
      nY();
      i = this.pos;
      while (i != this.end)
      {
        if (this.buf[i] == 10)
        {
          if (i != this.pos) {
            ((ByteArrayOutputStream)localObject2).write(this.buf, this.pos, i - this.pos);
          }
          this.pos = (i + 1);
          localObject2 = ((ByteArrayOutputStream)localObject2).toString();
          AppMethodBeat.o(100642);
          return localObject2;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.a.b
 * JD-Core Version:    0.7.0.1
 */