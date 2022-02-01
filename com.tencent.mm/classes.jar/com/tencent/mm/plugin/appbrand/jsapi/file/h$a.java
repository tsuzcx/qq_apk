package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.d;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class h$a
{
  static final Map<String, h> rXm;
  
  static
  {
    AppMethodBeat.i(128865);
    Object localObject = new HashMap();
    rXm = (Map)localObject;
    ((Map)localObject).put("ascii", new h()
    {
      private final Charset Oj;
      
      public final ByteBuffer aax(String paramAnonymousString)
      {
        AppMethodBeat.i(128851);
        paramAnonymousString = ByteBuffer.wrap(paramAnonymousString.getBytes(this.Oj));
        AppMethodBeat.o(128851);
        return paramAnonymousString;
      }
      
      public final String q(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(128850);
        paramAnonymousByteBuffer = new String(d.s(paramAnonymousByteBuffer), this.Oj);
        AppMethodBeat.o(128850);
        return paramAnonymousByteBuffer;
      }
    });
    rXm.put("base64", new h()
    {
      public final ByteBuffer aax(String paramAnonymousString)
      {
        AppMethodBeat.i(128853);
        paramAnonymousString = ByteBuffer.wrap(Base64.decode(paramAnonymousString.getBytes(UTF_8), 2));
        AppMethodBeat.o(128853);
        return paramAnonymousString;
      }
      
      public final String q(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(128852);
        paramAnonymousByteBuffer = new String(Base64.encode(d.s(paramAnonymousByteBuffer), 2), UTF_8);
        AppMethodBeat.o(128852);
        return paramAnonymousByteBuffer;
      }
    });
    rXm.put("hex", new h()
    {
      public final ByteBuffer aax(String paramAnonymousString)
      {
        AppMethodBeat.i(128855);
        paramAnonymousString = ByteBuffer.wrap(new BigInteger(paramAnonymousString, 16).toByteArray());
        AppMethodBeat.o(128855);
        return paramAnonymousString;
      }
      
      public final String q(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(128854);
        paramAnonymousByteBuffer = new BigInteger(1, d.s(paramAnonymousByteBuffer)).toString(16);
        AppMethodBeat.o(128854);
        return paramAnonymousByteBuffer;
      }
    });
    localObject = new h()
    {
      public final ByteBuffer aax(String paramAnonymousString)
      {
        AppMethodBeat.i(128857);
        paramAnonymousString = ByteBuffer.wrap(paramAnonymousString.getBytes(h.a.this)).order(ByteOrder.LITTLE_ENDIAN);
        AppMethodBeat.o(128857);
        return paramAnonymousString;
      }
      
      public final String q(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(128856);
        paramAnonymousByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        paramAnonymousByteBuffer = new String(d.s(paramAnonymousByteBuffer), h.a.this);
        AppMethodBeat.o(128856);
        return paramAnonymousByteBuffer;
      }
    };
    rXm.put("ucs2", localObject);
    rXm.put("ucs-2", localObject);
    localObject = new h()
    {
      public final ByteBuffer aax(String paramAnonymousString)
      {
        AppMethodBeat.i(128859);
        paramAnonymousString = ByteBuffer.wrap(paramAnonymousString.getBytes(h.a.this)).order(ByteOrder.LITTLE_ENDIAN);
        AppMethodBeat.o(128859);
        return paramAnonymousString;
      }
      
      public final String q(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(128858);
        paramAnonymousByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        paramAnonymousByteBuffer = new String(d.s(paramAnonymousByteBuffer), h.a.this);
        AppMethodBeat.o(128858);
        return paramAnonymousByteBuffer;
      }
    };
    rXm.put("utf16le", localObject);
    rXm.put("utf-16le", localObject);
    localObject = new h()
    {
      public final ByteBuffer aax(String paramAnonymousString)
      {
        AppMethodBeat.i(128861);
        paramAnonymousString = ByteBuffer.wrap(paramAnonymousString.getBytes(UTF_8));
        AppMethodBeat.o(128861);
        return paramAnonymousString;
      }
      
      public final String q(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(128860);
        paramAnonymousByteBuffer = new String(d.s(paramAnonymousByteBuffer), UTF_8);
        AppMethodBeat.o(128860);
        return paramAnonymousByteBuffer;
      }
    };
    rXm.put("utf8", localObject);
    rXm.put("utf-8", localObject);
    localObject = new h()
    {
      private final Charset rXp;
      
      public final ByteBuffer aax(String paramAnonymousString)
      {
        AppMethodBeat.i(128864);
        paramAnonymousString = ByteBuffer.wrap(paramAnonymousString.getBytes(this.rXp));
        AppMethodBeat.o(128864);
        return paramAnonymousString;
      }
      
      public final String q(ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(128863);
        paramAnonymousByteBuffer = new String(d.s(paramAnonymousByteBuffer), this.rXp);
        AppMethodBeat.o(128863);
        return paramAnonymousByteBuffer;
      }
    };
    rXm.put("latin1", localObject);
    rXm.put("binary", localObject);
    AppMethodBeat.o(128865);
  }
  
  static void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.h.a
 * JD-Core Version:    0.7.0.1
 */