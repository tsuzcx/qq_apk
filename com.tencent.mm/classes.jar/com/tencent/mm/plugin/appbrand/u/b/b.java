package com.tencent.mm.plugin.appbrand.u.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.u.d.d.a;
import com.tencent.mm.plugin.appbrand.u.d.e;
import com.tencent.mm.plugin.appbrand.u.e.f;
import com.tencent.mm.plugin.appbrand.u.e.h;
import com.tencent.mm.plugin.appbrand.u.e.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class b
  extends a
{
  private ByteBuffer iZx;
  private com.tencent.mm.plugin.appbrand.u.d.d iZy;
  private final Random iZz;
  
  public b()
  {
    AppMethodBeat.i(73233);
    this.iZy = null;
    this.iZz = new Random();
    AppMethodBeat.o(73233);
  }
  
  private static String Fv(String paramString)
  {
    AppMethodBeat.i(73240);
    paramString = paramString.trim();
    paramString = paramString + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      paramString = com.tencent.mm.plugin.appbrand.u.f.a.am(localMessageDigest.digest(paramString.getBytes()));
      AppMethodBeat.o(73240);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      ab.e("MicroMsg.AppBrandNetWork.Draft_10", "not such algorithm " + paramString.toString());
      AppMethodBeat.o(73240);
    }
    return "";
  }
  
  public static int g(f paramf)
  {
    AppMethodBeat.i(73234);
    paramf = paramf.Fy("Sec-WebSocket-Version");
    if (paramf.length() > 0) {
      try
      {
        int i = new Integer(paramf.trim()).intValue();
        AppMethodBeat.o(73234);
        return i;
      }
      catch (NumberFormatException paramf)
      {
        AppMethodBeat.o(73234);
        return -1;
      }
    }
    AppMethodBeat.o(73234);
    return -1;
  }
  
  private static byte[] i(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong >>> paramInt * 8 - 8 - i * 8));
      i += 1;
    }
    return arrayOfByte;
  }
  
  private com.tencent.mm.plugin.appbrand.u.d.d v(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(73244);
    int n = paramByteBuffer.remaining();
    int j = 2;
    if (n < 2)
    {
      paramByteBuffer = new b.a(this, 2);
      AppMethodBeat.o(73244);
      throw paramByteBuffer;
    }
    int m = paramByteBuffer.get();
    if (m >> 8 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      i = (byte)((m & 0x7F) >> 4);
      if (i == 0) {
        break;
      }
      paramByteBuffer = new com.tencent.mm.plugin.appbrand.u.c.c("bad rsv ".concat(String.valueOf(i)));
      AppMethodBeat.o(73244);
      throw paramByteBuffer;
    }
    int i = paramByteBuffer.get();
    if ((i & 0xFFFFFF80) != 0) {}
    for (int k = 1;; k = 0)
    {
      i = (byte)(i & 0x7F);
      m = (byte)(m & 0xF);
      switch (m)
      {
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        paramByteBuffer = new com.tencent.mm.plugin.appbrand.u.c.c("unknow optcode " + (short)m);
        AppMethodBeat.o(73244);
        throw paramByteBuffer;
      }
    }
    d.a locala = d.a.iZF;
    while ((!bool) && ((locala == d.a.iZI) || (locala == d.a.iZJ) || (locala == d.a.iZK)))
    {
      paramByteBuffer = new com.tencent.mm.plugin.appbrand.u.c.c("control frames may no be fragmented");
      AppMethodBeat.o(73244);
      throw paramByteBuffer;
      locala = d.a.iZG;
      continue;
      locala = d.a.iZH;
      continue;
      locala = d.a.iZK;
      continue;
      locala = d.a.iZI;
      continue;
      locala = d.a.iZJ;
    }
    Object localObject;
    if ((i < 0) || (i > 125))
    {
      if ((locala == d.a.iZI) || (locala == d.a.iZJ) || (locala == d.a.iZK))
      {
        paramByteBuffer = new com.tencent.mm.plugin.appbrand.u.c.c("more than 125 octets");
        AppMethodBeat.o(73244);
        throw paramByteBuffer;
      }
      if (i == 126)
      {
        j = 4;
        if (n < 4)
        {
          paramByteBuffer = new b.a(this, 4);
          AppMethodBeat.o(73244);
          throw paramByteBuffer;
        }
        localObject = new byte[3];
        localObject[1] = paramByteBuffer.get();
        localObject[2] = paramByteBuffer.get();
        i = new BigInteger((byte[])localObject).intValue();
      }
    }
    for (;;)
    {
      if (k != 0) {}
      for (m = 4;; m = 0)
      {
        j = m + j + i;
        if (n >= j) {
          break label578;
        }
        paramByteBuffer = new b.a(this, j);
        AppMethodBeat.o(73244);
        throw paramByteBuffer;
        m = 10;
        if (n < 10)
        {
          paramByteBuffer = new b.a(this, 10);
          AppMethodBeat.o(73244);
          throw paramByteBuffer;
        }
        localObject = new byte[8];
        j = 0;
        while (j < 8)
        {
          localObject[j] = paramByteBuffer.get();
          j += 1;
        }
        long l = new BigInteger((byte[])localObject).longValue();
        if (l > 2147483647L)
        {
          ab.e("MicroMsg.AppBrandNetWork.Draft_10", "Payloadsize is to big...");
          j = m;
          break;
        }
        i = (int)l;
        j = m;
        break;
      }
      label578:
      localObject = ByteBuffer.allocate(pR(i));
      if (k != 0)
      {
        byte[] arrayOfByte = new byte[4];
        paramByteBuffer.get(arrayOfByte);
        j = 0;
        while (j < i)
        {
          ((ByteBuffer)localObject).put((byte)(paramByteBuffer.get() ^ arrayOfByte[(j % 4)]));
          j += 1;
        }
      }
      ((ByteBuffer)localObject).put(paramByteBuffer.array(), paramByteBuffer.position(), ((ByteBuffer)localObject).limit());
      paramByteBuffer.position(paramByteBuffer.position() + ((ByteBuffer)localObject).limit());
      if (locala == d.a.iZK) {
        paramByteBuffer = new com.tencent.mm.plugin.appbrand.u.d.b();
      }
      for (;;)
      {
        ((ByteBuffer)localObject).flip();
        paramByteBuffer.w((ByteBuffer)localObject);
        AppMethodBeat.o(73244);
        return paramByteBuffer;
        paramByteBuffer = new e();
        paramByteBuffer.eY(bool);
        paramByteBuffer.a(locala);
      }
    }
  }
  
  public final a.b a(com.tencent.mm.plugin.appbrand.u.e.a parama, h paramh)
  {
    int j = 1;
    AppMethodBeat.i(73235);
    Object localObject = parama.Fy("Sec-WebSocket-Protocol");
    String str = paramh.Fy("Sec-WebSocket-Protocol");
    if ((!bo.isNullOrNil((String)localObject)) && (!bo.isNullOrNil(str)))
    {
      ab.d("MicroMsg.AppBrandNetWork.Draft_10", "respProtocol is %s", new Object[] { str });
      localObject = ((String)localObject).split(", ");
      int k = localObject.length;
      i = 0;
      if (i >= k) {
        break label207;
      }
      if (!str.equals(localObject[i])) {}
    }
    label207:
    for (int i = j;; i = 0)
    {
      if (i == 0)
      {
        parama = a.b.iZv;
        AppMethodBeat.o(73235);
        return parama;
        i += 1;
        break;
      }
      if ((!parama.Fz("Sec-WebSocket-Key")) || (!paramh.Fz("Sec-WebSocket-Accept")))
      {
        parama = a.b.iZv;
        AppMethodBeat.o(73235);
        return parama;
      }
      paramh = paramh.Fy("Sec-WebSocket-Accept");
      if (Fv(parama.Fy("Sec-WebSocket-Key")).equals(paramh))
      {
        parama = a.b.iZu;
        AppMethodBeat.o(73235);
        return parama;
      }
      parama = a.b.iZv;
      AppMethodBeat.o(73235);
      return parama;
    }
  }
  
  public com.tencent.mm.plugin.appbrand.u.e.b a(com.tencent.mm.plugin.appbrand.u.e.b paramb)
  {
    AppMethodBeat.i(73241);
    paramb.put("Upgrade", "websocket");
    paramb.put("Connection", "Upgrade");
    paramb.put("Sec-WebSocket-Version", "8");
    byte[] arrayOfByte = new byte[16];
    this.iZz.nextBytes(arrayOfByte);
    paramb.put("Sec-WebSocket-Key", com.tencent.mm.plugin.appbrand.u.f.a.am(arrayOfByte));
    AppMethodBeat.o(73241);
    return paramb;
  }
  
  public com.tencent.mm.plugin.appbrand.u.e.c a(com.tencent.mm.plugin.appbrand.u.e.a parama, i parami)
  {
    AppMethodBeat.i(73242);
    parami.put("Upgrade", "websocket");
    parami.put("Connection", parama.Fy("Connection"));
    parami.Fx("Switching Protocols");
    parama = parama.Fy("Sec-WebSocket-Key");
    if (parama == null)
    {
      parama = new com.tencent.mm.plugin.appbrand.u.c.d("missing Sec-WebSocket-Key");
      AppMethodBeat.o(73242);
      throw parama;
    }
    parami.put("Sec-WebSocket-Accept", Fv(parama));
    AppMethodBeat.o(73242);
    return parami;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.u.d.d> a(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    AppMethodBeat.i(73238);
    e locale = new e();
    try
    {
      locale.w(paramByteBuffer);
      locale.eY(true);
      locale.a(d.a.iZH);
      locale.eZ(paramBoolean);
      paramByteBuffer = Collections.singletonList(locale);
      AppMethodBeat.o(73238);
      return paramByteBuffer;
    }
    catch (com.tencent.mm.plugin.appbrand.u.c.b paramByteBuffer)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + paramByteBuffer.toString());
      }
    }
  }
  
  public final a.a aOg()
  {
    return a.a.iZs;
  }
  
  public a aOh()
  {
    AppMethodBeat.i(73245);
    b localb = new b();
    AppMethodBeat.o(73245);
    return localb;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.u.d.d> au(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(73239);
    e locale = new e();
    try
    {
      locale.w(ByteBuffer.wrap(com.tencent.mm.plugin.appbrand.u.f.b.FA(paramString)));
      locale.eY(true);
      locale.a(d.a.iZG);
      locale.eZ(paramBoolean);
      paramString = Collections.singletonList(locale);
      AppMethodBeat.o(73239);
      return paramString;
    }
    catch (com.tencent.mm.plugin.appbrand.u.c.b paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + paramString.toString());
      }
    }
  }
  
  public a.b c(com.tencent.mm.plugin.appbrand.u.e.a parama)
  {
    AppMethodBeat.i(73236);
    int i = g(parama);
    if ((i == 7) || (i == 8))
    {
      if ((parama.Fy("Upgrade").equalsIgnoreCase("websocket")) && (parama.Fy("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"))) {}
      for (i = 1; i != 0; i = 0)
      {
        parama = a.b.iZu;
        AppMethodBeat.o(73236);
        return parama;
      }
      parama = a.b.iZv;
      AppMethodBeat.o(73236);
      return parama;
    }
    parama = a.b.iZv;
    AppMethodBeat.o(73236);
    return parama;
  }
  
  public final ByteBuffer d(com.tencent.mm.plugin.appbrand.u.d.d paramd)
  {
    int k = -128;
    int i1 = 0;
    AppMethodBeat.i(73237);
    ByteBuffer localByteBuffer1 = paramd.aOl();
    int m;
    int j;
    label46:
    int i;
    label55:
    int n;
    label63:
    ByteBuffer localByteBuffer2;
    d.a locala;
    if (this.iYT == com.tencent.mm.plugin.appbrand.u.a.b.iYE)
    {
      m = 1;
      if (localByteBuffer1.remaining() > 125) {
        break label235;
      }
      j = 1;
      if (j <= 1) {
        break label257;
      }
      i = j + 1;
      if (m == 0) {
        break label262;
      }
      n = 4;
      localByteBuffer2 = ByteBuffer.allocate(n + (i + 1) + localByteBuffer1.remaining());
      locala = paramd.aOo();
      if (locala != d.a.iZF) {
        break label268;
      }
      i = 0;
      label98:
      if (!paramd.aOm()) {
        break label368;
      }
      n = -128;
      label111:
      localByteBuffer2.put((byte)(i | (byte)n));
      paramd = i(localByteBuffer1.remaining(), j);
      if (j != 1) {
        break label380;
      }
      i = paramd[0];
      if (m == 0) {
        break label374;
      }
      label148:
      localByteBuffer2.put((byte)(i | k));
    }
    for (;;)
    {
      if (m == 0) {
        break label468;
      }
      paramd = ByteBuffer.allocate(4);
      paramd.putInt(this.iZz.nextInt());
      localByteBuffer2.put(paramd.array());
      i = i1;
      while (localByteBuffer1.hasRemaining())
      {
        localByteBuffer2.put((byte)(localByteBuffer1.get() ^ paramd.get(i % 4)));
        i += 1;
      }
      m = 0;
      break;
      label235:
      if (localByteBuffer1.remaining() <= 65535)
      {
        j = 2;
        break label46;
      }
      j = 8;
      break label46;
      label257:
      i = j;
      break label55;
      label262:
      n = 0;
      break label63;
      label268:
      if (locala == d.a.iZG)
      {
        i = 1;
        break label98;
      }
      if (locala == d.a.iZH)
      {
        i = 2;
        break label98;
      }
      if (locala == d.a.iZK)
      {
        i = 8;
        break label98;
      }
      if (locala == d.a.iZI)
      {
        i = 9;
        break label98;
      }
      if (locala == d.a.iZJ)
      {
        i = 10;
        break label98;
      }
      ab.e("MicroMsg.AppBrandNetWork.Draft_10", "Don't know how to handle force close" + locala.toString());
      i = 8;
      break label98;
      label368:
      n = 0;
      break label111;
      label374:
      k = 0;
      break label148;
      label380:
      if (j == 2)
      {
        if (m != 0) {}
        for (;;)
        {
          localByteBuffer2.put((byte)(k | 0x7E));
          localByteBuffer2.put(paramd);
          break;
          k = 0;
        }
      }
      if (j == 8)
      {
        if (m != 0) {}
        for (;;)
        {
          localByteBuffer2.put((byte)(k | 0x7F));
          localByteBuffer2.put(paramd);
          break;
          k = 0;
        }
      }
      ab.e("MicroMsg.AppBrandNetWork.Draft_10", "Size representation not supported/specified");
    }
    label468:
    localByteBuffer2.put(localByteBuffer1);
    localByteBuffer2.flip();
    AppMethodBeat.o(73237);
    return localByteBuffer2;
  }
  
  public final void reset()
  {
    this.iZx = null;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.u.d.d> t(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(73243);
    for (;;)
    {
      Object localObject = new LinkedList();
      if (this.iZx != null) {}
      try
      {
        paramByteBuffer.mark();
        int i = paramByteBuffer.remaining();
        int j = this.iZx.remaining();
        if (j > i)
        {
          this.iZx.put(paramByteBuffer.array(), paramByteBuffer.position(), i);
          paramByteBuffer.position(i + paramByteBuffer.position());
          localObject = Collections.emptyList();
          AppMethodBeat.o(73243);
          return localObject;
        }
        this.iZx.put(paramByteBuffer.array(), paramByteBuffer.position(), j);
        paramByteBuffer.position(paramByteBuffer.position() + j);
        ((List)localObject).add(v((ByteBuffer)this.iZx.duplicate().position(0)));
        this.iZx = null;
        while (paramByteBuffer.hasRemaining())
        {
          paramByteBuffer.mark();
          try
          {
            ((List)localObject).add(v(paramByteBuffer));
          }
          catch (b.a locala2)
          {
            paramByteBuffer.reset();
            this.iZx = ByteBuffer.allocate(pR(locala2.iZA));
            this.iZx.put(paramByteBuffer);
          }
        }
        AppMethodBeat.o(73243);
        return localObject;
      }
      catch (b.a locala1)
      {
        this.iZx.limit();
        ByteBuffer localByteBuffer = ByteBuffer.allocate(pR(locala1.iZA));
        this.iZx.rewind();
        localByteBuffer.put(this.iZx);
        this.iZx = localByteBuffer;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.b.b
 * JD-Core Version:    0.7.0.1
 */