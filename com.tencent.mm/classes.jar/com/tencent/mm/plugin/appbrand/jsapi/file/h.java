package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.d;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

abstract interface h
{
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  
  public abstract ByteBuffer Ib(String paramString);
  
  public abstract String o(ByteBuffer paramByteBuffer);
  
  public static final class a
  {
    static final Map<String, h> jQr;
    
    static
    {
      AppMethodBeat.i(128865);
      Object localObject = new HashMap();
      jQr = (Map)localObject;
      ((Map)localObject).put("ascii", new h()
      {
        private final Charset wa;
        
        public final ByteBuffer Ib(String paramAnonymousString)
        {
          AppMethodBeat.i(128851);
          paramAnonymousString = ByteBuffer.wrap(paramAnonymousString.getBytes(this.wa));
          AppMethodBeat.o(128851);
          return paramAnonymousString;
        }
        
        public final String o(ByteBuffer paramAnonymousByteBuffer)
        {
          AppMethodBeat.i(128850);
          paramAnonymousByteBuffer = new String(d.q(paramAnonymousByteBuffer), this.wa);
          AppMethodBeat.o(128850);
          return paramAnonymousByteBuffer;
        }
      });
      jQr.put("base64", new h()
      {
        public final ByteBuffer Ib(String paramAnonymousString)
        {
          AppMethodBeat.i(128853);
          paramAnonymousString = ByteBuffer.wrap(Base64.decode(paramAnonymousString.getBytes(UTF_8), 2));
          AppMethodBeat.o(128853);
          return paramAnonymousString;
        }
        
        public final String o(ByteBuffer paramAnonymousByteBuffer)
        {
          AppMethodBeat.i(128852);
          paramAnonymousByteBuffer = new String(Base64.encode(d.q(paramAnonymousByteBuffer), 2), UTF_8);
          AppMethodBeat.o(128852);
          return paramAnonymousByteBuffer;
        }
      });
      jQr.put("hex", new h()
      {
        public final ByteBuffer Ib(String paramAnonymousString)
        {
          AppMethodBeat.i(128855);
          paramAnonymousString = ByteBuffer.wrap(new BigInteger(paramAnonymousString, 16).toByteArray());
          AppMethodBeat.o(128855);
          return paramAnonymousString;
        }
        
        public final String o(ByteBuffer paramAnonymousByteBuffer)
        {
          AppMethodBeat.i(128854);
          paramAnonymousByteBuffer = new BigInteger(1, d.q(paramAnonymousByteBuffer)).toString(16);
          AppMethodBeat.o(128854);
          return paramAnonymousByteBuffer;
        }
      });
      localObject = new h()
      {
        public final ByteBuffer Ib(String paramAnonymousString)
        {
          AppMethodBeat.i(128857);
          paramAnonymousString = ByteBuffer.wrap(paramAnonymousString.getBytes(this.jQs)).order(ByteOrder.LITTLE_ENDIAN);
          AppMethodBeat.o(128857);
          return paramAnonymousString;
        }
        
        public final String o(ByteBuffer paramAnonymousByteBuffer)
        {
          AppMethodBeat.i(128856);
          paramAnonymousByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
          paramAnonymousByteBuffer = new String(d.q(paramAnonymousByteBuffer), this.jQs);
          AppMethodBeat.o(128856);
          return paramAnonymousByteBuffer;
        }
      };
      jQr.put("ucs2", localObject);
      jQr.put("ucs-2", localObject);
      localObject = new h()
      {
        public final ByteBuffer Ib(String paramAnonymousString)
        {
          AppMethodBeat.i(128859);
          paramAnonymousString = ByteBuffer.wrap(paramAnonymousString.getBytes(this.jQt)).order(ByteOrder.LITTLE_ENDIAN);
          AppMethodBeat.o(128859);
          return paramAnonymousString;
        }
        
        public final String o(ByteBuffer paramAnonymousByteBuffer)
        {
          AppMethodBeat.i(128858);
          paramAnonymousByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
          paramAnonymousByteBuffer = new String(d.q(paramAnonymousByteBuffer), this.jQt);
          AppMethodBeat.o(128858);
          return paramAnonymousByteBuffer;
        }
      };
      jQr.put("utf16le", localObject);
      jQr.put("utf-16le", localObject);
      localObject = new h()
      {
        public final ByteBuffer Ib(String paramAnonymousString)
        {
          AppMethodBeat.i(128861);
          paramAnonymousString = ByteBuffer.wrap(paramAnonymousString.getBytes(UTF_8));
          AppMethodBeat.o(128861);
          return paramAnonymousString;
        }
        
        public final String o(ByteBuffer paramAnonymousByteBuffer)
        {
          AppMethodBeat.i(128860);
          paramAnonymousByteBuffer = new String(d.q(paramAnonymousByteBuffer), UTF_8);
          AppMethodBeat.o(128860);
          return paramAnonymousByteBuffer;
        }
      };
      jQr.put("utf8", localObject);
      jQr.put("utf-8", localObject);
      localObject = new h()
      {
        private final Charset jQu;
        
        public final ByteBuffer Ib(String paramAnonymousString)
        {
          AppMethodBeat.i(128864);
          paramAnonymousString = ByteBuffer.wrap(paramAnonymousString.getBytes(this.jQu));
          AppMethodBeat.o(128864);
          return paramAnonymousString;
        }
        
        public final String o(ByteBuffer paramAnonymousByteBuffer)
        {
          AppMethodBeat.i(128863);
          paramAnonymousByteBuffer = new String(d.q(paramAnonymousByteBuffer), this.jQu);
          AppMethodBeat.o(128863);
          return paramAnonymousByteBuffer;
        }
      };
      jQr.put("latin1", localObject);
      jQr.put("binary", localObject);
      AppMethodBeat.o(128865);
    }
    
    static void init() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.h
 * JD-Core Version:    0.7.0.1
 */