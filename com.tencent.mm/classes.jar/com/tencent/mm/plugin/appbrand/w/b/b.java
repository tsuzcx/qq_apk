package com.tencent.mm.plugin.appbrand.w.b;

import com.tencent.mm.plugin.appbrand.w.d.d.a;
import com.tencent.mm.plugin.appbrand.w.d.e;
import com.tencent.mm.plugin.appbrand.w.e.f;
import com.tencent.mm.plugin.appbrand.w.e.h;
import com.tencent.mm.plugin.appbrand.w.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private ByteBuffer hmY;
  private com.tencent.mm.plugin.appbrand.w.d.d hmZ = null;
  private final Random hna = new Random();
  
  public static int f(f paramf)
  {
    int i = -1;
    paramf = paramf.wS("Sec-WebSocket-Version");
    if (paramf.length() > 0) {}
    try
    {
      i = new Integer(paramf.trim()).intValue();
      return i;
    }
    catch (NumberFormatException paramf) {}
    return -1;
  }
  
  private static byte[] h(long paramLong, int paramInt)
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
  
  private com.tencent.mm.plugin.appbrand.w.d.d u(ByteBuffer paramByteBuffer)
  {
    int n = paramByteBuffer.remaining();
    int j = 2;
    if (n < 2) {
      throw new b.a(this, 2);
    }
    int m = paramByteBuffer.get();
    if (m >> 8 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      i = (byte)((m & 0x7F) >> 4);
      if (i == 0) {
        break;
      }
      throw new com.tencent.mm.plugin.appbrand.w.c.c("bad rsv " + i);
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
        throw new com.tencent.mm.plugin.appbrand.w.c.c("unknow optcode " + (short)m);
      }
    }
    d.a locala = d.a.hnh;
    while ((!bool) && ((locala == d.a.hnk) || (locala == d.a.hnl) || (locala == d.a.hnm)))
    {
      throw new com.tencent.mm.plugin.appbrand.w.c.c("control frames may no be fragmented");
      locala = d.a.hni;
      continue;
      locala = d.a.hnj;
      continue;
      locala = d.a.hnm;
      continue;
      locala = d.a.hnk;
      continue;
      locala = d.a.hnl;
    }
    Object localObject;
    if ((i < 0) || (i > 125))
    {
      if ((locala == d.a.hnk) || (locala == d.a.hnl) || (locala == d.a.hnm)) {
        throw new com.tencent.mm.plugin.appbrand.w.c.c("more than 125 octets");
      }
      if (i == 126)
      {
        j = 4;
        if (n < 4) {
          throw new b.a(this, 4);
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
          break label524;
        }
        throw new b.a(this, j);
        m = 10;
        if (n < 10) {
          throw new b.a(this, 10);
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
          y.e("MicroMsg.AppBrandNetWork.Draft_10", "Payloadsize is to big...");
          j = m;
          break;
        }
        i = (int)l;
        j = m;
        break;
      }
      label524:
      localObject = ByteBuffer.allocate(mA(i));
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
      if (locala == d.a.hnm) {
        paramByteBuffer = new com.tencent.mm.plugin.appbrand.w.d.b();
      }
      for (;;)
      {
        ((ByteBuffer)localObject).flip();
        paramByteBuffer.v((ByteBuffer)localObject);
        return paramByteBuffer;
        paramByteBuffer = new e();
        paramByteBuffer.dI(bool);
        paramByteBuffer.a(locala);
      }
    }
  }
  
  private static String wP(String paramString)
  {
    paramString = paramString.trim();
    paramString = paramString + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      return com.tencent.mm.plugin.appbrand.w.f.a.S(localMessageDigest.digest(paramString.getBytes()));
    }
    catch (NoSuchAlgorithmException paramString)
    {
      y.e("MicroMsg.AppBrandNetWork.Draft_10", "not such algorithm " + paramString.toString());
    }
    return "";
  }
  
  public final a.b a(com.tencent.mm.plugin.appbrand.w.e.a parama, h paramh)
  {
    int j = 1;
    Object localObject = parama.wS("Sec-WebSocket-Protocol");
    String str = paramh.wS("Sec-WebSocket-Protocol");
    if ((!bk.bl((String)localObject)) && (!bk.bl(str)))
    {
      y.d("MicroMsg.AppBrandNetWork.Draft_10", "respProtocol is %s", new Object[] { str });
      localObject = ((String)localObject).split(", ");
      int k = localObject.length;
      i = 0;
      if (i >= k) {
        break label172;
      }
      if (!str.equals(localObject[i])) {}
    }
    label172:
    for (int i = j;; i = 0)
    {
      if (i == 0)
      {
        return a.b.hmW;
        i += 1;
        break;
      }
      if ((!parama.wT("Sec-WebSocket-Key")) || (!paramh.wT("Sec-WebSocket-Accept"))) {
        return a.b.hmW;
      }
      paramh = paramh.wS("Sec-WebSocket-Accept");
      if (wP(parama.wS("Sec-WebSocket-Key")).equals(paramh)) {
        return a.b.hmV;
      }
      return a.b.hmW;
    }
  }
  
  public com.tencent.mm.plugin.appbrand.w.e.b a(com.tencent.mm.plugin.appbrand.w.e.b paramb)
  {
    paramb.put("Upgrade", "websocket");
    paramb.put("Connection", "Upgrade");
    paramb.put("Sec-WebSocket-Version", "8");
    byte[] arrayOfByte = new byte[16];
    this.hna.nextBytes(arrayOfByte);
    paramb.put("Sec-WebSocket-Key", com.tencent.mm.plugin.appbrand.w.f.a.S(arrayOfByte));
    return paramb;
  }
  
  public com.tencent.mm.plugin.appbrand.w.e.c a(com.tencent.mm.plugin.appbrand.w.e.a parama, i parami)
  {
    parami.put("Upgrade", "websocket");
    parami.put("Connection", parama.wS("Connection"));
    parami.wR("Switching Protocols");
    parama = parama.wS("Sec-WebSocket-Key");
    if (parama == null) {
      throw new com.tencent.mm.plugin.appbrand.w.c.d("missing Sec-WebSocket-Key");
    }
    parami.put("Sec-WebSocket-Accept", wP(parama));
    return parami;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.w.d.d> a(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    e locale = new e();
    try
    {
      locale.v(paramByteBuffer);
      locale.dI(true);
      locale.a(d.a.hnj);
      locale.dJ(paramBoolean);
      return Collections.singletonList(locale);
    }
    catch (com.tencent.mm.plugin.appbrand.w.c.b paramByteBuffer)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + paramByteBuffer.toString());
      }
    }
  }
  
  public final List<com.tencent.mm.plugin.appbrand.w.d.d> ak(String paramString, boolean paramBoolean)
  {
    e locale = new e();
    try
    {
      locale.v(ByteBuffer.wrap(com.tencent.mm.plugin.appbrand.w.f.b.wU(paramString)));
      locale.dI(true);
      locale.a(d.a.hni);
      locale.dJ(paramBoolean);
      return Collections.singletonList(locale);
    }
    catch (com.tencent.mm.plugin.appbrand.w.c.b paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + paramString.toString());
      }
    }
  }
  
  public final a.a aqH()
  {
    return a.a.hmT;
  }
  
  public a aqI()
  {
    return new b();
  }
  
  public a.b c(com.tencent.mm.plugin.appbrand.w.e.a parama)
  {
    int i = f(parama);
    if ((i == 7) || (i == 8))
    {
      if ((parama.wS("Upgrade").equalsIgnoreCase("websocket")) && (parama.wS("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"))) {}
      for (i = 1; i != 0; i = 0) {
        return a.b.hmV;
      }
      return a.b.hmW;
    }
    return a.b.hmW;
  }
  
  public final ByteBuffer d(com.tencent.mm.plugin.appbrand.w.d.d paramd)
  {
    int k = -128;
    int i1 = 0;
    ByteBuffer localByteBuffer1 = paramd.aqK();
    int m;
    int j;
    label40:
    int i;
    label49:
    int n;
    label57:
    ByteBuffer localByteBuffer2;
    d.a locala;
    if (this.hmu == com.tencent.mm.plugin.appbrand.w.a.b.hmf)
    {
      m = 1;
      if (localByteBuffer1.remaining() > 125) {
        break label229;
      }
      j = 1;
      if (j <= 1) {
        break label251;
      }
      i = j + 1;
      if (m == 0) {
        break label256;
      }
      n = 4;
      localByteBuffer2 = ByteBuffer.allocate(n + (i + 1) + localByteBuffer1.remaining());
      locala = paramd.aqN();
      if (locala != d.a.hnh) {
        break label262;
      }
      i = 0;
      label92:
      if (!paramd.aqL()) {
        break label362;
      }
      n = -128;
      label105:
      localByteBuffer2.put((byte)(i | (byte)n));
      paramd = h(localByteBuffer1.remaining(), j);
      if (j != 1) {
        break label374;
      }
      i = paramd[0];
      if (m == 0) {
        break label368;
      }
      label142:
      localByteBuffer2.put((byte)(i | k));
    }
    for (;;)
    {
      if (m == 0) {
        break label462;
      }
      paramd = ByteBuffer.allocate(4);
      paramd.putInt(this.hna.nextInt());
      localByteBuffer2.put(paramd.array());
      i = i1;
      while (localByteBuffer1.hasRemaining())
      {
        localByteBuffer2.put((byte)(localByteBuffer1.get() ^ paramd.get(i % 4)));
        i += 1;
      }
      m = 0;
      break;
      label229:
      if (localByteBuffer1.remaining() <= 65535)
      {
        j = 2;
        break label40;
      }
      j = 8;
      break label40;
      label251:
      i = j;
      break label49;
      label256:
      n = 0;
      break label57;
      label262:
      if (locala == d.a.hni)
      {
        i = 1;
        break label92;
      }
      if (locala == d.a.hnj)
      {
        i = 2;
        break label92;
      }
      if (locala == d.a.hnm)
      {
        i = 8;
        break label92;
      }
      if (locala == d.a.hnk)
      {
        i = 9;
        break label92;
      }
      if (locala == d.a.hnl)
      {
        i = 10;
        break label92;
      }
      y.e("MicroMsg.AppBrandNetWork.Draft_10", "Don't know how to handle force close" + locala.toString());
      i = 8;
      break label92;
      label362:
      n = 0;
      break label105;
      label368:
      k = 0;
      break label142;
      label374:
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
      y.e("MicroMsg.AppBrandNetWork.Draft_10", "Size representation not supported/specified");
    }
    label462:
    localByteBuffer2.put(localByteBuffer1);
    localByteBuffer2.flip();
    return localByteBuffer2;
  }
  
  public final void reset()
  {
    this.hmY = null;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.w.d.d> s(ByteBuffer paramByteBuffer)
  {
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList();
      if (this.hmY != null) {}
      try
      {
        paramByteBuffer.mark();
        int i = paramByteBuffer.remaining();
        int j = this.hmY.remaining();
        if (j > i)
        {
          this.hmY.put(paramByteBuffer.array(), paramByteBuffer.position(), i);
          paramByteBuffer.position(i + paramByteBuffer.position());
          return Collections.emptyList();
        }
        this.hmY.put(paramByteBuffer.array(), paramByteBuffer.position(), j);
        paramByteBuffer.position(paramByteBuffer.position() + j);
        localLinkedList.add(u((ByteBuffer)this.hmY.duplicate().position(0)));
        this.hmY = null;
        while (paramByteBuffer.hasRemaining())
        {
          paramByteBuffer.mark();
          try
          {
            localLinkedList.add(u(paramByteBuffer));
          }
          catch (b.a locala2)
          {
            paramByteBuffer.reset();
            this.hmY = ByteBuffer.allocate(mA(locala2.hnb));
            this.hmY.put(paramByteBuffer);
          }
        }
        return localLinkedList;
      }
      catch (b.a locala1)
      {
        this.hmY.limit();
        ByteBuffer localByteBuffer = ByteBuffer.allocate(mA(locala1.hnb));
        this.hmY.rewind();
        localByteBuffer.put(this.hmY);
        this.hmY = localByteBuffer;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.b.b
 * JD-Core Version:    0.7.0.1
 */