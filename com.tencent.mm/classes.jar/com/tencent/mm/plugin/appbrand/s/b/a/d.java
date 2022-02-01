package com.tencent.mm.plugin.appbrand.s.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/der/Parser;", "", "data", "", "([B)V", "Lcom/tencent/mm/plugin/appbrand/network/workaround/der/ByteArrayView;", "(Lcom/tencent/mm/plugin/appbrand/network/workaround/der/ByteArrayView;)V", "hasReadLen", "", "myThread", "Ljava/lang/Thread;", "pendingReadLen", "checkThread", "", "consumePendingReadLen", "skip", "", "dataIsExhausted", "peekTagAndValue", "Lkotlin/Pair;", "readBEB128", "", "readByte", "", "readConstructed", "tag", "readLen", "readLong", "len", "readSequence", "readTag", "readTagAndValue", "tagToString", "", "Companion", "luggage-commons_release"})
public final class d
{
  private static final boolean qkv;
  public static final d.a qkw;
  private final Thread qkr;
  private int qks;
  private int qkt;
  private final a qku;
  
  static
  {
    AppMethodBeat.i(207712);
    qkw = new d.a((byte)0);
    qkv = com.tencent.mm.plugin.appbrand.s.b.c.a.ccu();
    AppMethodBeat.o(207712);
  }
  
  public d(a parama)
  {
    AppMethodBeat.i(207710);
    this.qku = parama;
    if (qkv) {}
    for (parama = Thread.currentThread();; parama = null)
    {
      this.qkr = parama;
      if (qkv) {
        Log.d("MicroMsg.Der.Parser", "<init>, data: " + this.qku);
      }
      AppMethodBeat.o(207710);
      return;
    }
  }
  
  public d(byte[] paramArrayOfByte)
  {
    this(a.a.E(paramArrayOfByte, 0, i));
    AppMethodBeat.i(207711);
    AppMethodBeat.o(207711);
  }
  
  private final int Av()
  {
    AppMethodBeat.i(207693);
    int i = readByte();
    if (qkv) {
      Log.d("MicroMsg.Der.Parser", "readTag, tagByte: ".concat(String.valueOf(i)));
    }
    int k = (i & 0xE0) << 24;
    int j = i & 0x1F;
    if (qkv) {
      Log.d("MicroMsg.Der.Parser", "readTag, tag: " + k + ", tagNo: " + j);
    }
    i = j;
    if (31 == j)
    {
      long l = ccp();
      if (qkv) {
        Log.d("MicroMsg.Der.Parser", "readTag, beb128Val: ".concat(String.valueOf(l)));
      }
      Throwable localThrowable;
      if (536870911L < l)
      {
        localThrowable = (Throwable)new c("The tag number is not within our supported bounds.");
        AppMethodBeat.o(207693);
        throw localThrowable;
      }
      if (31L > l)
      {
        localThrowable = (Throwable)new c("Small tag numbers should have used low tag number form, even in BER.");
        AppMethodBeat.o(207693);
        throw localThrowable;
      }
      j = (int)l;
      i = j;
      if (qkv)
      {
        Log.d("MicroMsg.Der.Parser", "readTag, tagNo: ".concat(String.valueOf(j)));
        i = j;
      }
    }
    i |= k;
    if (qkv) {
      Log.d("MicroMsg.Der.Parser", "readTag, tag: ".concat(String.valueOf(i)));
    }
    AppMethodBeat.o(207693);
    return i;
  }
  
  private final long Cg(int paramInt)
  {
    AppMethodBeat.i(207703);
    if (qkv) {
      Log.d("MicroMsg.Der.Parser", "readLong, len: ".concat(String.valueOf(paramInt)));
    }
    int i = this.qks;
    int j = i + paramInt;
    if (j > this.qku.size)
    {
      Throwable localThrowable = (Throwable)new c("Not enough data for read next " + paramInt + " bytes.");
      AppMethodBeat.o(207703);
      throw localThrowable;
    }
    long l1 = 0L;
    paramInt = i;
    while (paramInt < j)
    {
      long l2 = this.qku.get(paramInt);
      if (qkv) {
        Log.d("MicroMsg.Der.Parser", "readLong, i: " + paramInt + ", byteVal: " + l2);
      }
      l1 = l1 << 8 | l2;
      paramInt += 1;
    }
    if (qkv) {
      Log.d("MicroMsg.Der.Parser", "readLong, value: ".concat(String.valueOf(l1)));
    }
    AppMethodBeat.o(207703);
    return l1;
  }
  
  private static String Ch(int paramInt)
  {
    AppMethodBeat.i(207706);
    switch (paramInt)
    {
    default: 
      String str = "UNKNOWN(" + paramInt + ')';
      AppMethodBeat.o(207706);
      return str;
    case 4: 
      AppMethodBeat.o(207706);
      return "OCTET_STRING";
    case 6: 
      AppMethodBeat.o(207706);
      return "OBJECT";
    }
    AppMethodBeat.o(207706);
    return "SEQUENCE";
  }
  
  private final long cco()
  {
    AppMethodBeat.i(207695);
    int i = readByte();
    if (qkv) {
      Log.d("MicroMsg.Der.Parser", "readLen, lenByte: ".concat(String.valueOf(i)));
    }
    long l1;
    if ((i & 0x80) == 0) {
      l1 = i;
    }
    long l2;
    do
    {
      if (qkv) {
        Log.d("MicroMsg.Der.Parser", "readLen, len: ".concat(String.valueOf(l1)));
      }
      AppMethodBeat.o(207695);
      return l1;
      i &= 0x7F;
      if (qkv) {
        Log.d("MicroMsg.Der.Parser", "readLen, num: ".concat(String.valueOf(i)));
      }
      if ((i == 0) || (4 < i))
      {
        localThrowable = (Throwable)new c("The long-form encoding length is illegal.");
        AppMethodBeat.o(207695);
        throw localThrowable;
      }
      l2 = Cg(i);
      if (128L > l2)
      {
        localThrowable = (Throwable)new c("Length should have used short-form encoding.");
        AppMethodBeat.o(207695);
        throw localThrowable;
      }
      l1 = l2;
    } while (0L != l2 >>> (i - 1) * 8);
    Throwable localThrowable = (Throwable)new c("Length should have been at least one byte shorter.");
    AppMethodBeat.o(207695);
    throw localThrowable;
  }
  
  private final long ccp()
  {
    AppMethodBeat.i(207698);
    long l1 = 0L;
    int i;
    long l2;
    do
    {
      i = readByte();
      if (qkv) {
        Log.d("MicroMsg.Der.Parser", "readBEB128, byteVal: ".concat(String.valueOf(i)));
      }
      Throwable localThrowable;
      if (0L != l1 >> 57)
      {
        localThrowable = (Throwable)new c("The value is too large.");
        AppMethodBeat.o(207698);
        throw localThrowable;
      }
      if ((0L == l1) && (128 == i))
      {
        localThrowable = (Throwable)new c("The value must be minimally encoded.");
        AppMethodBeat.o(207698);
        throw localThrowable;
      }
      l2 = l1 << 7 | i & 0x7F;
      if (qkv) {
        Log.d("MicroMsg.Der.Parser", "readBEB128, beb128Val: ".concat(String.valueOf(l2)));
      }
      l1 = l2;
    } while ((i & 0x80) != 0);
    if (qkv) {
      Log.d("MicroMsg.Der.Parser", "readBEB128, done, beb128Val: ".concat(String.valueOf(l2)));
    }
    AppMethodBeat.o(207698);
    return l2;
  }
  
  private final void iY(boolean paramBoolean)
  {
    AppMethodBeat.i(207688);
    int i = this.qkt;
    if (qkv) {
      Log.d("MicroMsg.Der.Parser", "consumePendingReadLen, skip: " + paramBoolean + ", pendingReadLen: " + i);
    }
    if (!paramBoolean) {
      this.qks = (i + this.qks);
    }
    this.qkt = 0;
    AppMethodBeat.o(207688);
  }
  
  private final byte readByte()
  {
    AppMethodBeat.i(207701);
    if (this.qks >= this.qku.size)
    {
      localObject = (Throwable)new c("Data has been exhausted.");
      AppMethodBeat.o(207701);
      throw ((Throwable)localObject);
    }
    Object localObject = this.qku;
    int i = this.qks;
    this.qks = (i + 1);
    byte b = ((a)localObject).get(i);
    AppMethodBeat.o(207701);
    return b;
  }
  
  public final a Cf(int paramInt)
  {
    AppMethodBeat.i(207684);
    checkThread();
    if (qkv) {
      Log.d("MicroMsg.Der.Parser", "readTag, tag: " + Ch(paramInt));
    }
    Object localObject = ccn();
    int i = ((Number)((o)localObject).Mx).intValue();
    localObject = (a)((o)localObject).My;
    if (i != paramInt)
    {
      iY(true);
      localObject = (Throwable)new c("Next tag is not " + Ch(paramInt));
      AppMethodBeat.o(207684);
      throw ((Throwable)localObject);
    }
    iY(false);
    AppMethodBeat.o(207684);
    return localObject;
  }
  
  public final d ccl()
  {
    AppMethodBeat.i(207683);
    checkThread();
    if (qkv) {
      Log.d("MicroMsg.Der.Parser", "readConstructed, tag: " + Ch(536870928));
    }
    Object localObject = b.qkq;
    b.ccj();
    localObject = new d(Cf(536870928));
    AppMethodBeat.o(207683);
    return localObject;
  }
  
  public final boolean ccm()
  {
    AppMethodBeat.i(207685);
    checkThread();
    if (this.qks == this.qku.size)
    {
      AppMethodBeat.o(207685);
      return true;
    }
    AppMethodBeat.o(207685);
    return false;
  }
  
  public final o<Integer, a> ccn()
  {
    AppMethodBeat.i(207687);
    int i = this.qks;
    int j = Av();
    int k = (int)cco();
    int m = this.qks;
    Object localObject = this.qku.eR(m, k);
    this.qks = i;
    this.qkt = (m - i + k);
    if (qkv) {
      Log.d("MicroMsg.Der.Parser", "peekTagAndValue, tag: " + j + ", len: " + k + ", valData: " + localObject + ", pendingReadLen: " + this.qkt);
    }
    localObject = s.M(Integer.valueOf(j), localObject);
    AppMethodBeat.o(207687);
    return localObject;
  }
  
  public final void checkThread()
  {
    AppMethodBeat.i(207705);
    if (qkv)
    {
      Object localObject = Thread.currentThread();
      p.j(localObject, "Thread.currentThread()");
      if ((p.h(localObject, this.qkr) ^ true))
      {
        localObject = (Throwable)new IllegalAccessException("Parser is not thread safe(Created in " + this.qkr + ", but now is in " + localObject + ").");
        AppMethodBeat.o(207705);
        throw ((Throwable)localObject);
      }
    }
    AppMethodBeat.o(207705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.b.a.d
 * JD-Core Version:    0.7.0.1
 */