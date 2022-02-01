package com.tencent.mm.plugin.appbrand.t.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/der/Parser;", "", "data", "", "([B)V", "Lcom/tencent/mm/plugin/appbrand/network/workaround/der/ByteArrayView;", "(Lcom/tencent/mm/plugin/appbrand/network/workaround/der/ByteArrayView;)V", "hasReadLen", "", "myThread", "Ljava/lang/Thread;", "pendingReadLen", "checkThread", "", "consumePendingReadLen", "skip", "", "dataIsExhausted", "peekTagAndValue", "Lkotlin/Pair;", "readBEB128", "", "readByte", "", "readConstructed", "tag", "readLen", "readLong", "len", "readSequence", "readTag", "readTagAndValue", "tagToString", "", "Companion", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.a tpo;
  private static final boolean tpt;
  private final a tpp;
  private final Thread tpq;
  private int tpr;
  private int tps;
  
  static
  {
    AppMethodBeat.i(319239);
    tpo = new d.a((byte)0);
    tpt = com.tencent.mm.plugin.appbrand.t.c.c.a.cCQ();
    AppMethodBeat.o(319239);
  }
  
  public d(a parama)
  {
    AppMethodBeat.i(319187);
    this.tpp = parama;
    if (tpt) {}
    for (parama = Thread.currentThread();; parama = null)
    {
      this.tpq = parama;
      if (tpt) {
        Log.d("MicroMsg.Der.Parser", s.X("<init>, data: ", this.tpp));
      }
      AppMethodBeat.o(319187);
      return;
    }
  }
  
  public d(byte[] paramArrayOfByte)
  {
    this(a.a.C(paramArrayOfByte, 0, i));
    AppMethodBeat.i(319190);
    AppMethodBeat.o(319190);
  }
  
  private final long Cv(int paramInt)
  {
    AppMethodBeat.i(319231);
    if (tpt) {
      Log.d("MicroMsg.Der.Parser", s.X("readLong, len: ", Integer.valueOf(paramInt)));
    }
    int i = this.tpr;
    int j = i + paramInt;
    if (j > this.tpp.size)
    {
      c localc = new c("Not enough data for read next " + paramInt + " bytes.");
      AppMethodBeat.o(319231);
      throw localc;
    }
    long l1 = 0L;
    long l2 = l1;
    if (i < j) {}
    for (paramInt = i;; paramInt = i)
    {
      i = paramInt + 1;
      l2 = this.tpp.get(paramInt);
      if (tpt) {
        Log.d("MicroMsg.Der.Parser", "readLong, i: " + paramInt + ", byteVal: " + l2);
      }
      l1 = l1 << 8 | l2;
      if (i >= j)
      {
        l2 = l1;
        if (tpt) {
          Log.d("MicroMsg.Der.Parser", s.X("readLong, value: ", Long.valueOf(l2)));
        }
        AppMethodBeat.o(319231);
        return l2;
      }
    }
  }
  
  private static String Cw(int paramInt)
  {
    AppMethodBeat.i(319233);
    switch (paramInt)
    {
    default: 
      String str = "UNKNOWN(" + paramInt + ')';
      AppMethodBeat.o(319233);
      return str;
    case 4: 
      AppMethodBeat.o(319233);
      return "OCTET_STRING";
    case 6: 
      AppMethodBeat.o(319233);
      return "OBJECT";
    }
    AppMethodBeat.o(319233);
    return "SEQUENCE";
  }
  
  private final int aac()
  {
    AppMethodBeat.i(319206);
    int i = readByte();
    if (tpt) {
      Log.d("MicroMsg.Der.Parser", s.X("readTag, tagByte: ", Integer.valueOf(i)));
    }
    int k = (i & 0xE0) << 24;
    int j = i & 0x1F;
    if (tpt) {
      Log.d("MicroMsg.Der.Parser", "readTag, tag: " + k + ", tagNo: " + j);
    }
    i = j;
    if (31 == j)
    {
      long l = cCL();
      if (tpt) {
        Log.d("MicroMsg.Der.Parser", s.X("readTag, beb128Val: ", Long.valueOf(l)));
      }
      c localc;
      if (536870911L < l)
      {
        localc = new c("The tag number is not within our supported bounds.");
        AppMethodBeat.o(319206);
        throw localc;
      }
      if (31L > l)
      {
        localc = new c("Small tag numbers should have used low tag number form, even in BER.");
        AppMethodBeat.o(319206);
        throw localc;
      }
      j = (int)l;
      i = j;
      if (tpt)
      {
        Log.d("MicroMsg.Der.Parser", s.X("readTag, tagNo: ", Integer.valueOf(j)));
        i = j;
      }
    }
    i |= k;
    if (tpt) {
      Log.d("MicroMsg.Der.Parser", s.X("readTag, tag: ", Integer.valueOf(i)));
    }
    AppMethodBeat.o(319206);
    return i;
  }
  
  private final long cCK()
  {
    AppMethodBeat.i(319214);
    int i = readByte();
    if (tpt) {
      Log.d("MicroMsg.Der.Parser", s.X("readLen, lenByte: ", Integer.valueOf(i)));
    }
    long l1;
    if ((i & 0x80) == 0) {
      l1 = i;
    }
    long l2;
    do
    {
      if (tpt) {
        Log.d("MicroMsg.Der.Parser", s.X("readLen, len: ", Long.valueOf(l1)));
      }
      AppMethodBeat.o(319214);
      return l1;
      i &= 0x7F;
      if (tpt) {
        Log.d("MicroMsg.Der.Parser", s.X("readLen, num: ", Integer.valueOf(i)));
      }
      if ((i == 0) || (4 < i))
      {
        localc = new c("The long-form encoding length is illegal.");
        AppMethodBeat.o(319214);
        throw localc;
      }
      l2 = Cv(i);
      if (128L > l2)
      {
        localc = new c("Length should have used short-form encoding.");
        AppMethodBeat.o(319214);
        throw localc;
      }
      l1 = l2;
    } while (0L != l2 >>> (i - 1) * 8);
    c localc = new c("Length should have been at least one byte shorter.");
    AppMethodBeat.o(319214);
    throw localc;
  }
  
  private final long cCL()
  {
    AppMethodBeat.i(319219);
    long l1 = 0L;
    int i;
    long l2;
    do
    {
      i = readByte();
      if (tpt) {
        Log.d("MicroMsg.Der.Parser", s.X("readBEB128, byteVal: ", Integer.valueOf(i)));
      }
      c localc;
      if (0L != l1 >> 57)
      {
        localc = new c("The value is too large.");
        AppMethodBeat.o(319219);
        throw localc;
      }
      if ((0L == l1) && (128 == i))
      {
        localc = new c("The value must be minimally encoded.");
        AppMethodBeat.o(319219);
        throw localc;
      }
      l2 = l1 << 7 | i & 0x7F;
      if (tpt) {
        Log.d("MicroMsg.Der.Parser", s.X("readBEB128, beb128Val: ", Long.valueOf(l2)));
      }
      l1 = l2;
    } while ((i & 0x80) != 0);
    if (tpt) {
      Log.d("MicroMsg.Der.Parser", s.X("readBEB128, done, beb128Val: ", Long.valueOf(l2)));
    }
    AppMethodBeat.o(319219);
    return l2;
  }
  
  private final void kg(boolean paramBoolean)
  {
    AppMethodBeat.i(319196);
    int i = this.tps;
    if (tpt) {
      Log.d("MicroMsg.Der.Parser", "consumePendingReadLen, skip: " + paramBoolean + ", pendingReadLen: " + i);
    }
    if (!paramBoolean) {
      this.tpr = (i + this.tpr);
    }
    this.tps = 0;
    AppMethodBeat.o(319196);
  }
  
  private final byte readByte()
  {
    AppMethodBeat.i(319226);
    if (this.tpr >= this.tpp.size)
    {
      localObject = new c("Data has been exhausted.");
      AppMethodBeat.o(319226);
      throw ((Throwable)localObject);
    }
    Object localObject = this.tpp;
    int i = this.tpr;
    this.tpr = (i + 1);
    byte b = ((a)localObject).get(i);
    AppMethodBeat.o(319226);
    return b;
  }
  
  public final a Cu(int paramInt)
  {
    AppMethodBeat.i(319246);
    checkThread();
    if (tpt) {
      Log.d("MicroMsg.Der.Parser", s.X("readTag, tag: ", Cw(paramInt)));
    }
    Object localObject = cCJ();
    int i = ((Number)((r)localObject).bsC).intValue();
    localObject = (a)((r)localObject).bsD;
    if (i != paramInt)
    {
      kg(true);
      localObject = new c(s.X("Next tag is not ", Cw(paramInt)));
      AppMethodBeat.o(319246);
      throw ((Throwable)localObject);
    }
    kg(false);
    AppMethodBeat.o(319246);
    return localObject;
  }
  
  public final d cCH()
  {
    AppMethodBeat.i(319243);
    checkThread();
    if (tpt) {
      Log.d("MicroMsg.Der.Parser", s.X("readConstructed, tag: ", Cw(536870928)));
    }
    Object localObject = b.tpn;
    if (!b.cCF())
    {
      localObject = new c("Tag " + Cw(536870928) + " is not constructed");
      AppMethodBeat.o(319243);
      throw ((Throwable)localObject);
    }
    localObject = new d(Cu(536870928));
    AppMethodBeat.o(319243);
    return localObject;
  }
  
  public final boolean cCI()
  {
    AppMethodBeat.i(319249);
    checkThread();
    if (this.tpr == this.tpp.size)
    {
      AppMethodBeat.o(319249);
      return true;
    }
    AppMethodBeat.o(319249);
    return false;
  }
  
  public final r<Integer, a> cCJ()
  {
    AppMethodBeat.i(319252);
    int i = this.tpr;
    int j = aac();
    int k = (int)cCK();
    int m = this.tpr;
    Object localObject = this.tpp.fK(m, k);
    this.tpr = i;
    this.tps = (m - i + k);
    if (tpt) {
      Log.d("MicroMsg.Der.Parser", "peekTagAndValue, tag: " + j + ", len: " + k + ", valData: " + localObject + ", pendingReadLen: " + this.tps);
    }
    localObject = v.Y(Integer.valueOf(j), localObject);
    AppMethodBeat.o(319252);
    return localObject;
  }
  
  public final void checkThread()
  {
    AppMethodBeat.i(319254);
    if (tpt)
    {
      Object localObject = Thread.currentThread();
      if (!s.p(localObject, this.tpq))
      {
        localObject = new IllegalAccessException("Parser is not thread safe(Created in " + this.tpq + ", but now is in " + localObject + ").");
        AppMethodBeat.o(319254);
        throw ((Throwable)localObject);
      }
    }
    AppMethodBeat.o(319254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.c.a.d
 * JD-Core Version:    0.7.0.1
 */