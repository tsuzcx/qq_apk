package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.d;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class g$a
{
  static final Map<String, g> hLT;
  
  static
  {
    AppMethodBeat.i(102775);
    Object localObject = new HashMap();
    hLT = (Map)localObject;
    ((Map)localObject).put("ascii", new g()
    {
      private final Charset pz;
      
      public final ByteBuffer BZ(String paramAnonymousString)
      {
        AppMethodBeat.i(102761);
        paramAnonymousString = ByteBuffer.wrap(paramAnonymousString.getBytes(this.pz));
        AppMethodBeat.o(102761);
        return paramAnonymousString;
      }
      
      public final String k(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(102760);
        paramAnonymousByteBuffer = new String(d.m(paramAnonymousByteBuffer), this.pz);
        AppMethodBeat.o(102760);
        return paramAnonymousByteBuffer;
      }
    });
    hLT.put("base64", new g()
    {
      public final ByteBuffer BZ(String paramAnonymousString)
      {
        AppMethodBeat.i(102763);
        paramAnonymousString = ByteBuffer.wrap(Base64.decode(paramAnonymousString.getBytes(UTF_8), 2));
        AppMethodBeat.o(102763);
        return paramAnonymousString;
      }
      
      public final String k(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(102762);
        paramAnonymousByteBuffer = new String(Base64.encode(d.m(paramAnonymousByteBuffer), 2), UTF_8);
        AppMethodBeat.o(102762);
        return paramAnonymousByteBuffer;
      }
    });
    hLT.put("hex", new g.a.3());
    localObject = new g.a.4(Charset.forName("ISO-10646-UCS-2"));
    hLT.put("ucs2", localObject);
    hLT.put("ucs-2", localObject);
    localObject = new g.a.5(Charset.forName("UTF-16LE"));
    hLT.put("utf16le", localObject);
    hLT.put("utf-16le", localObject);
    localObject = new g.a.6();
    hLT.put("utf8", localObject);
    hLT.put("utf-8", localObject);
    localObject = new g.a.7();
    hLT.put("latin1", localObject);
    hLT.put("binary", localObject);
    AppMethodBeat.o(102775);
  }
  
  static void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.g.a
 * JD-Core Version:    0.7.0.1
 */