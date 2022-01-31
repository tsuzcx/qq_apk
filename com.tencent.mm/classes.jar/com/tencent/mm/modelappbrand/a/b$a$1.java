package com.tencent.mm.modelappbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
      AppMethodBeat.i(77320);
      super.flush();
      e.deleteFile(this.fqz);
      AppMethodBeat.o(77320);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.a.1
 * JD-Core Version:    0.7.0.1
 */