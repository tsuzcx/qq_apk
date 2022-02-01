package com.tencent.mm.plugin.appbrand.aa.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.d.d.a;
import com.tencent.mm.plugin.appbrand.aa.d.e;
import com.tencent.mm.plugin.appbrand.aa.e.f;
import com.tencent.mm.plugin.appbrand.aa.e.h;
import com.tencent.mm.plugin.appbrand.aa.e.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private ByteBuffer mQS;
  private com.tencent.mm.plugin.appbrand.aa.d.d mQT;
  private final Random mQU;
  
  public b()
  {
    AppMethodBeat.i(156631);
    this.mQT = null;
    this.mQU = new Random();
    AppMethodBeat.o(156631);
  }
  
  private static String Vg(String paramString)
  {
    AppMethodBeat.i(156638);
    paramString = paramString.trim();
    paramString = paramString + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      paramString = com.tencent.mm.plugin.appbrand.aa.f.a.aA(localMessageDigest.digest(paramString.getBytes()));
      AppMethodBeat.o(156638);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      ad.e("MicroMsg.AppBrandNetWork.Draft_10", "not such algorithm " + paramString.toString());
      AppMethodBeat.o(156638);
    }
    return "";
  }
  
  public static int g(f paramf)
  {
    AppMethodBeat.i(156632);
    paramf = paramf.Vj("Sec-WebSocket-Version");
    if (paramf.length() > 0) {
      try
      {
        int i = new Integer(paramf.trim()).intValue();
        AppMethodBeat.o(156632);
        return i;
      }
      catch (NumberFormatException paramf)
      {
        AppMethodBeat.o(156632);
        return -1;
      }
    }
    AppMethodBeat.o(156632);
    return -1;
  }
  
  private static byte[] k(long paramLong, int paramInt)
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
  
  private com.tencent.mm.plugin.appbrand.aa.d.d z(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(156642);
    int n = paramByteBuffer.remaining();
    int j = 2;
    if (n < 2)
    {
      paramByteBuffer = new a(2);
      AppMethodBeat.o(156642);
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
      paramByteBuffer = new com.tencent.mm.plugin.appbrand.aa.c.c("bad rsv ".concat(String.valueOf(i)));
      AppMethodBeat.o(156642);
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
        paramByteBuffer = new com.tencent.mm.plugin.appbrand.aa.c.c("unknow optcode " + (short)m);
        AppMethodBeat.o(156642);
        throw paramByteBuffer;
      }
    }
    d.a locala = d.a.mRa;
    while ((!bool) && ((locala == d.a.mRd) || (locala == d.a.mRe) || (locala == d.a.mRf)))
    {
      paramByteBuffer = new com.tencent.mm.plugin.appbrand.aa.c.c("control frames may no be fragmented");
      AppMethodBeat.o(156642);
      throw paramByteBuffer;
      locala = d.a.mRb;
      continue;
      locala = d.a.mRc;
      continue;
      locala = d.a.mRf;
      continue;
      locala = d.a.mRd;
      continue;
      locala = d.a.mRe;
    }
    Object localObject;
    if ((i < 0) || (i > 125))
    {
      if ((locala == d.a.mRd) || (locala == d.a.mRe) || (locala == d.a.mRf))
      {
        paramByteBuffer = new com.tencent.mm.plugin.appbrand.aa.c.c("more than 125 octets");
        AppMethodBeat.o(156642);
        throw paramByteBuffer;
      }
      if (i == 126)
      {
        j = 4;
        if (n < 4)
        {
          paramByteBuffer = new a(4);
          AppMethodBeat.o(156642);
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
        paramByteBuffer = new a(j);
        AppMethodBeat.o(156642);
        throw paramByteBuffer;
        m = 10;
        if (n < 10)
        {
          paramByteBuffer = new a(10);
          AppMethodBeat.o(156642);
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
          ad.e("MicroMsg.AppBrandNetWork.Draft_10", "Payloadsize is to big...");
          j = m;
          break;
        }
        i = (int)l;
        j = m;
        break;
      }
      label578:
      localObject = ByteBuffer.allocate(vN(i));
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
      if (locala == d.a.mRf) {
        paramByteBuffer = new com.tencent.mm.plugin.appbrand.aa.d.b();
      }
      for (;;)
      {
        ((ByteBuffer)localObject).flip();
        paramByteBuffer.A((ByteBuffer)localObject);
        AppMethodBeat.o(156642);
        return paramByteBuffer;
        paramByteBuffer = new e();
        paramByteBuffer.hS(bool);
        paramByteBuffer.a(locala);
      }
    }
  }
  
  public final a.b a(com.tencent.mm.plugin.appbrand.aa.e.a parama, h paramh)
  {
    int j = 1;
    AppMethodBeat.i(156633);
    Object localObject = parama.Vj("Sec-WebSocket-Protocol");
    String str = paramh.Vj("Sec-WebSocket-Protocol");
    if ((!bt.isNullOrNil((String)localObject)) && (!bt.isNullOrNil(str)))
    {
      ad.d("MicroMsg.AppBrandNetWork.Draft_10", "respProtocol is %s", new Object[] { str });
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
        parama = a.b.mQP;
        AppMethodBeat.o(156633);
        return parama;
        i += 1;
        break;
      }
      if ((!parama.Vk("Sec-WebSocket-Key")) || (!paramh.Vk("Sec-WebSocket-Accept")))
      {
        parama = a.b.mQP;
        AppMethodBeat.o(156633);
        return parama;
      }
      paramh = paramh.Vj("Sec-WebSocket-Accept");
      if (Vg(parama.Vj("Sec-WebSocket-Key")).equals(paramh))
      {
        parama = a.b.mQO;
        AppMethodBeat.o(156633);
        return parama;
      }
      parama = a.b.mQP;
      AppMethodBeat.o(156633);
      return parama;
    }
  }
  
  public com.tencent.mm.plugin.appbrand.aa.e.b a(com.tencent.mm.plugin.appbrand.aa.e.b paramb)
  {
    AppMethodBeat.i(156639);
    paramb.put("Upgrade", "websocket");
    paramb.put("Connection", "Upgrade");
    paramb.put("Sec-WebSocket-Version", "8");
    byte[] arrayOfByte = new byte[16];
    this.mQU.nextBytes(arrayOfByte);
    paramb.put("Sec-WebSocket-Key", com.tencent.mm.plugin.appbrand.aa.f.a.aA(arrayOfByte));
    AppMethodBeat.o(156639);
    return paramb;
  }
  
  public com.tencent.mm.plugin.appbrand.aa.e.c a(com.tencent.mm.plugin.appbrand.aa.e.a parama, i parami)
  {
    AppMethodBeat.i(156640);
    parami.put("Upgrade", "websocket");
    parami.put("Connection", parama.Vj("Connection"));
    parami.Vi("Switching Protocols");
    parama = parama.Vj("Sec-WebSocket-Key");
    if (parama == null)
    {
      parama = new com.tencent.mm.plugin.appbrand.aa.c.d("missing Sec-WebSocket-Key");
      AppMethodBeat.o(156640);
      throw parama;
    }
    parami.put("Sec-WebSocket-Accept", Vg(parama));
    AppMethodBeat.o(156640);
    return parami;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.aa.d.d> a(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    AppMethodBeat.i(156636);
    e locale = new e();
    try
    {
      locale.A(paramByteBuffer);
      locale.hS(true);
      locale.a(d.a.mRc);
      locale.hT(paramBoolean);
      paramByteBuffer = Collections.singletonList(locale);
      AppMethodBeat.o(156636);
      return paramByteBuffer;
    }
    catch (com.tencent.mm.plugin.appbrand.aa.c.b paramByteBuffer)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + paramByteBuffer.toString());
      }
    }
  }
  
  public final List<com.tencent.mm.plugin.appbrand.aa.d.d> aB(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156637);
    e locale = new e();
    try
    {
      locale.A(ByteBuffer.wrap(com.tencent.mm.plugin.appbrand.aa.f.b.Vl(paramString)));
      locale.hS(true);
      locale.a(d.a.mRb);
      locale.hT(paramBoolean);
      paramString = Collections.singletonList(locale);
      AppMethodBeat.o(156637);
      return paramString;
    }
    catch (com.tencent.mm.plugin.appbrand.aa.c.b paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + paramString.toString());
      }
    }
  }
  
  public final a.a bBE()
  {
    return a.a.mQM;
  }
  
  public a bBF()
  {
    AppMethodBeat.i(156643);
    b localb = new b();
    AppMethodBeat.o(156643);
    return localb;
  }
  
  public a.b c(com.tencent.mm.plugin.appbrand.aa.e.a parama)
  {
    AppMethodBeat.i(156634);
    int i = g(parama);
    if ((i == 7) || (i == 8))
    {
      if ((parama.Vj("Upgrade").equalsIgnoreCase("websocket")) && (parama.Vj("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"))) {}
      for (i = 1; i != 0; i = 0)
      {
        parama = a.b.mQO;
        AppMethodBeat.o(156634);
        return parama;
      }
      parama = a.b.mQP;
      AppMethodBeat.o(156634);
      return parama;
    }
    parama = a.b.mQP;
    AppMethodBeat.o(156634);
    return parama;
  }
  
  public final ByteBuffer d(com.tencent.mm.plugin.appbrand.aa.d.d paramd)
  {
    int k = -128;
    int i1 = 0;
    AppMethodBeat.i(156635);
    ByteBuffer localByteBuffer1 = paramd.bBJ();
    int m;
    int j;
    label46:
    int i;
    label55:
    int n;
    label63:
    ByteBuffer localByteBuffer2;
    d.a locala;
    if (this.mQo == com.tencent.mm.plugin.appbrand.aa.a.b.mPZ)
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
      locala = paramd.bBM();
      if (locala != d.a.mRa) {
        break label268;
      }
      i = 0;
      label98:
      if (!paramd.bBK()) {
        break label368;
      }
      n = -128;
      label111:
      localByteBuffer2.put((byte)(i | (byte)n));
      paramd = k(localByteBuffer1.remaining(), j);
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
      paramd.putInt(this.mQU.nextInt());
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
      if (locala == d.a.mRb)
      {
        i = 1;
        break label98;
      }
      if (locala == d.a.mRc)
      {
        i = 2;
        break label98;
      }
      if (locala == d.a.mRf)
      {
        i = 8;
        break label98;
      }
      if (locala == d.a.mRd)
      {
        i = 9;
        break label98;
      }
      if (locala == d.a.mRe)
      {
        i = 10;
        break label98;
      }
      ad.e("MicroMsg.AppBrandNetWork.Draft_10", "Don't know how to handle force close" + locala.toString());
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
      ad.e("MicroMsg.AppBrandNetWork.Draft_10", "Size representation not supported/specified");
    }
    label468:
    localByteBuffer2.put(localByteBuffer1);
    localByteBuffer2.flip();
    AppMethodBeat.o(156635);
    return localByteBuffer2;
  }
  
  public final void reset()
  {
    this.mQS = null;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.aa.d.d> x(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(156641);
    for (;;)
    {
      Object localObject = new LinkedList();
      if (this.mQS != null) {}
      try
      {
        paramByteBuffer.mark();
        int i = paramByteBuffer.remaining();
        int j = this.mQS.remaining();
        if (j > i)
        {
          this.mQS.put(paramByteBuffer.array(), paramByteBuffer.position(), i);
          paramByteBuffer.position(i + paramByteBuffer.position());
          localObject = Collections.emptyList();
          AppMethodBeat.o(156641);
          return localObject;
        }
        this.mQS.put(paramByteBuffer.array(), paramByteBuffer.position(), j);
        paramByteBuffer.position(paramByteBuffer.position() + j);
        ((List)localObject).add(z((ByteBuffer)this.mQS.duplicate().position(0)));
        this.mQS = null;
        while (paramByteBuffer.hasRemaining())
        {
          paramByteBuffer.mark();
          try
          {
            ((List)localObject).add(z(paramByteBuffer));
          }
          catch (a locala2)
          {
            paramByteBuffer.reset();
            this.mQS = ByteBuffer.allocate(vN(locala2.mQV));
            this.mQS.put(paramByteBuffer);
          }
        }
        AppMethodBeat.o(156641);
        return localObject;
      }
      catch (a locala1)
      {
        this.mQS.limit();
        ByteBuffer localByteBuffer = ByteBuffer.allocate(vN(locala1.mQV));
        this.mQS.rewind();
        localByteBuffer.put(this.mQS);
        this.mQS = localByteBuffer;
      }
    }
  }
  
  final class a
    extends Throwable
  {
    int mQV;
    
    public a(int paramInt)
    {
      this.mQV = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.b.b
 * JD-Core Version:    0.7.0.1
 */