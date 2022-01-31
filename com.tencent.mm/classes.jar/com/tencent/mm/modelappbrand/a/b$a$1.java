package com.tencent.mm.modelappbrand.a;

import com.tencent.mm.vfs.e;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

final class b$a$1
  extends BufferedOutputStream
{
  b$a$1(b.a parama, OutputStream paramOutputStream, String paramString)
  {
    super(paramOutputStream);
  }
  
  public final void flush()
  {
    try
    {
      super.flush();
      e.deleteFile(this.eaq);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.a.1
 * JD-Core Version:    0.7.0.1
 */