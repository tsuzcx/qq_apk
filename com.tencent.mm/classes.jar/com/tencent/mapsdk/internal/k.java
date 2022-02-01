package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class k
{
  private StringBuilder a;
  private int b = 0;
  
  private k(StringBuilder paramStringBuilder)
  {
    this.a = paramStringBuilder;
  }
  
  public k(StringBuilder paramStringBuilder, int paramInt)
  {
    this.a = paramStringBuilder;
    this.b = paramInt;
  }
  
  private k a(char paramChar, String paramString)
  {
    AppMethodBeat.i(225162);
    a(paramString);
    this.a.append(paramChar).append('\n');
    AppMethodBeat.o(225162);
    return this;
  }
  
  private k a(char paramChar, boolean paramBoolean)
  {
    AppMethodBeat.i(225174);
    this.a.append(paramChar);
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225174);
    return this;
  }
  
  private k a(double paramDouble, String paramString)
  {
    AppMethodBeat.i(225202);
    a(paramString);
    this.a.append(paramDouble).append('\n');
    AppMethodBeat.o(225202);
    return this;
  }
  
  private k a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(225210);
    this.a.append(paramDouble);
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225210);
    return this;
  }
  
  private k a(float paramFloat, String paramString)
  {
    AppMethodBeat.i(225183);
    a(paramString);
    this.a.append(paramFloat).append('\n');
    AppMethodBeat.o(225183);
    return this;
  }
  
  private k a(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(225191);
    this.a.append(paramFloat);
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225191);
    return this;
  }
  
  private <T> k a(T paramT, String paramString)
  {
    AppMethodBeat.i(225389);
    if (paramT == null) {
      this.a.append("null\n");
    }
    for (;;)
    {
      AppMethodBeat.o(225389);
      return this;
      if ((paramT instanceof Byte))
      {
        a(((Byte)paramT).byteValue(), paramString);
      }
      else if ((paramT instanceof Boolean))
      {
        a(((Boolean)paramT).booleanValue(), paramString);
      }
      else if ((paramT instanceof Short))
      {
        a(((Short)paramT).shortValue(), paramString);
      }
      else if ((paramT instanceof Integer))
      {
        a(((Integer)paramT).intValue(), paramString);
      }
      else if ((paramT instanceof Long))
      {
        a(((Long)paramT).longValue(), paramString);
      }
      else if ((paramT instanceof Float))
      {
        a(((Float)paramT).floatValue(), paramString);
      }
      else if ((paramT instanceof Double))
      {
        a(((Double)paramT).doubleValue(), paramString);
      }
      else if ((paramT instanceof String))
      {
        a((String)paramT, paramString);
      }
      else if ((paramT instanceof Map))
      {
        a((Map)paramT, paramString);
      }
      else if ((paramT instanceof List))
      {
        a((List)paramT, paramString);
      }
      else if ((paramT instanceof p))
      {
        a((p)paramT, paramString);
      }
      else if ((paramT instanceof byte[]))
      {
        a((byte[])paramT, paramString);
      }
      else if ((paramT instanceof boolean[]))
      {
        a((boolean[])paramT, paramString);
      }
      else if ((paramT instanceof short[]))
      {
        a((short[])paramT, paramString);
      }
      else if ((paramT instanceof int[]))
      {
        a((int[])paramT, paramString);
      }
      else if ((paramT instanceof long[]))
      {
        a((long[])paramT, paramString);
      }
      else if ((paramT instanceof float[]))
      {
        a((float[])paramT, paramString);
      }
      else if ((paramT instanceof double[]))
      {
        a((double[])paramT, paramString);
      }
      else
      {
        if (!paramT.getClass().isArray()) {
          break;
        }
        a((Object[])paramT, paramString);
      }
    }
    paramT = new l("write object error: unsupport type.");
    AppMethodBeat.o(225389);
    throw paramT;
  }
  
  private <T> k a(T paramT, boolean paramBoolean)
  {
    AppMethodBeat.i(225404);
    if (paramT == null) {
      this.a.append("null\n");
    }
    for (;;)
    {
      AppMethodBeat.o(225404);
      return this;
      if ((paramT instanceof Byte))
      {
        a(((Byte)paramT).byteValue(), paramBoolean);
      }
      else if ((paramT instanceof Boolean))
      {
        a(((Boolean)paramT).booleanValue(), paramBoolean);
      }
      else if ((paramT instanceof Short))
      {
        a(((Short)paramT).shortValue(), paramBoolean);
      }
      else if ((paramT instanceof Integer))
      {
        a(((Integer)paramT).intValue(), paramBoolean);
      }
      else if ((paramT instanceof Long))
      {
        a(((Long)paramT).longValue(), paramBoolean);
      }
      else if ((paramT instanceof Float))
      {
        a(((Float)paramT).floatValue(), paramBoolean);
      }
      else if ((paramT instanceof Double))
      {
        a(((Double)paramT).doubleValue(), paramBoolean);
      }
      else if ((paramT instanceof String))
      {
        a((String)paramT, paramBoolean);
      }
      else if ((paramT instanceof Map))
      {
        a((Map)paramT, paramBoolean);
      }
      else if ((paramT instanceof List))
      {
        a((List)paramT, paramBoolean);
      }
      else if ((paramT instanceof p))
      {
        a((p)paramT, paramBoolean);
      }
      else if ((paramT instanceof byte[]))
      {
        a((byte[])paramT, paramBoolean);
      }
      else if ((paramT instanceof boolean[]))
      {
        a((boolean[])paramT, paramBoolean);
      }
      else if ((paramT instanceof short[]))
      {
        a((short[])paramT, paramBoolean);
      }
      else if ((paramT instanceof int[]))
      {
        a((int[])paramT, paramBoolean);
      }
      else if ((paramT instanceof long[]))
      {
        a((long[])paramT, paramBoolean);
      }
      else if ((paramT instanceof float[]))
      {
        a((float[])paramT, paramBoolean);
      }
      else if ((paramT instanceof double[]))
      {
        a((double[])paramT, paramBoolean);
      }
      else
      {
        if (!paramT.getClass().isArray()) {
          break;
        }
        a((Object[])paramT, paramBoolean);
      }
    }
    paramT = new l("write object error: unsupport type.");
    AppMethodBeat.o(225404);
    throw paramT;
  }
  
  private <K, V> k a(Map<K, V> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(225356);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      this.a.append("{}");
      if (paramBoolean) {
        this.a.append("|");
      }
      AppMethodBeat.o(225356);
      return this;
    }
    this.a.append("{");
    k localk = new k(this.a, this.b + 2);
    paramMap = paramMap.entrySet().iterator();
    for (int i = 1; paramMap.hasNext(); i = 0)
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (i == 0) {
        this.a.append(",");
      }
      localk.a(localEntry.getKey(), true);
      localk.a(localEntry.getValue(), false);
    }
    this.a.append("}");
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225356);
    return this;
  }
  
  private k a(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(225141);
    a(paramString);
    paramString = this.a;
    if (paramBoolean) {}
    for (char c = 'T';; c = 'F')
    {
      paramString.append(c).append('\n');
      AppMethodBeat.o(225141);
      return this;
    }
  }
  
  private k a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(225152);
    StringBuilder localStringBuilder = this.a;
    if (paramBoolean1) {}
    for (char c = 'T';; c = 'F')
    {
      localStringBuilder.append(c);
      if (paramBoolean2) {
        this.a.append("|");
      }
      AppMethodBeat.o(225152);
      return this;
    }
  }
  
  private k a(char[] paramArrayOfChar, String paramString)
  {
    AppMethodBeat.i(225221);
    a(paramString);
    if (paramArrayOfChar == null)
    {
      this.a.append("null\n");
      AppMethodBeat.o(225221);
      return this;
    }
    if (paramArrayOfChar.length == 0)
    {
      this.a.append(paramArrayOfChar.length).append(", []\n");
      AppMethodBeat.o(225221);
      return this;
    }
    this.a.append(paramArrayOfChar.length).append(", [\n");
    paramString = new k(this.a, this.b + 1);
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfChar[i], null);
      i += 1;
    }
    a(']', null);
    AppMethodBeat.o(225221);
    return this;
  }
  
  private k a(char[] paramArrayOfChar, boolean paramBoolean)
  {
    AppMethodBeat.i(225229);
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0))
    {
      if (paramBoolean) {
        this.a.append("|");
      }
      AppMethodBeat.o(225229);
      return this;
    }
    this.a.append(new String(paramArrayOfChar));
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225229);
    return this;
  }
  
  private k a(double[] paramArrayOfDouble, String paramString)
  {
    AppMethodBeat.i(225327);
    a(paramString);
    if (paramArrayOfDouble == null)
    {
      this.a.append("null\n");
      AppMethodBeat.o(225327);
      return this;
    }
    if (paramArrayOfDouble.length == 0)
    {
      this.a.append(paramArrayOfDouble.length).append(", []\n");
      AppMethodBeat.o(225327);
      return this;
    }
    this.a.append(paramArrayOfDouble.length).append(", [\n");
    paramString = new k(this.a, this.b + 1);
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfDouble[i], null);
      i += 1;
    }
    a(']', null);
    AppMethodBeat.o(225327);
    return this;
  }
  
  private k a(double[] paramArrayOfDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(225343);
    if ((paramArrayOfDouble == null) || (paramArrayOfDouble.length == 0))
    {
      this.a.append("[]");
      if (paramBoolean) {
        this.a.append("|");
      }
      AppMethodBeat.o(225343);
      return this;
    }
    this.a.append("[");
    k localk = new k(this.a, this.b + 1);
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      double d = paramArrayOfDouble[i];
      if (i != 0) {
        this.a.append("|");
      }
      localk.a(d, false);
      i += 1;
    }
    this.a.append("[");
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225343);
    return this;
  }
  
  private k a(float[] paramArrayOfFloat, String paramString)
  {
    AppMethodBeat.i(225305);
    a(paramString);
    if (paramArrayOfFloat == null)
    {
      this.a.append("null\n");
      AppMethodBeat.o(225305);
      return this;
    }
    if (paramArrayOfFloat.length == 0)
    {
      this.a.append(paramArrayOfFloat.length).append(", []\n");
      AppMethodBeat.o(225305);
      return this;
    }
    this.a.append(paramArrayOfFloat.length).append(", [\n");
    paramString = new k(this.a, this.b + 1);
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfFloat[i], null);
      i += 1;
    }
    a(']', null);
    AppMethodBeat.o(225305);
    return this;
  }
  
  private k a(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(225318);
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0))
    {
      this.a.append("[]");
      if (paramBoolean) {
        this.a.append("|");
      }
      AppMethodBeat.o(225318);
      return this;
    }
    this.a.append("[");
    k localk = new k(this.a, this.b + 1);
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      float f = paramArrayOfFloat[i];
      if (i != 0) {
        this.a.append("|");
      }
      localk.a(f, false);
      i += 1;
    }
    this.a.append("]");
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225318);
    return this;
  }
  
  private k a(int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(225259);
    a(paramString);
    if (paramArrayOfInt == null)
    {
      this.a.append("null\n");
      AppMethodBeat.o(225259);
      return this;
    }
    if (paramArrayOfInt.length == 0)
    {
      this.a.append(paramArrayOfInt.length).append(", []\n");
      AppMethodBeat.o(225259);
      return this;
    }
    this.a.append(paramArrayOfInt.length).append(", [\n");
    paramString = new k(this.a, this.b + 1);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfInt[i], null);
      i += 1;
    }
    a(']', null);
    AppMethodBeat.o(225259);
    return this;
  }
  
  private k a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225272);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      this.a.append("[]");
      if (paramBoolean) {
        this.a.append("|");
      }
      AppMethodBeat.o(225272);
      return this;
    }
    this.a.append("[");
    k localk = new k(this.a, this.b + 1);
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      int j = paramArrayOfInt[i];
      if (i != 0) {
        this.a.append("|");
      }
      localk.a(j, false);
      i += 1;
    }
    this.a.append("]");
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225272);
    return this;
  }
  
  private k a(long[] paramArrayOfLong, String paramString)
  {
    AppMethodBeat.i(225285);
    a(paramString);
    if (paramArrayOfLong == null)
    {
      this.a.append("null\n");
      AppMethodBeat.o(225285);
      return this;
    }
    if (paramArrayOfLong.length == 0)
    {
      this.a.append(paramArrayOfLong.length).append(", []\n");
      AppMethodBeat.o(225285);
      return this;
    }
    this.a.append(paramArrayOfLong.length).append(", [\n");
    paramString = new k(this.a, this.b + 1);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfLong[i], null);
      i += 1;
    }
    a(']', null);
    AppMethodBeat.o(225285);
    return this;
  }
  
  private k a(long[] paramArrayOfLong, boolean paramBoolean)
  {
    AppMethodBeat.i(225297);
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0))
    {
      this.a.append("[]");
      if (paramBoolean) {
        this.a.append("|");
      }
      AppMethodBeat.o(225297);
      return this;
    }
    this.a.append("[");
    k localk = new k(this.a, this.b + 1);
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      long l = paramArrayOfLong[i];
      if (i != 0) {
        this.a.append("|");
      }
      localk.a(l, false);
      i += 1;
    }
    this.a.append("]");
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225297);
    return this;
  }
  
  private <T> k a(T[] paramArrayOfT, String paramString)
  {
    AppMethodBeat.i(225362);
    a(paramString);
    if (paramArrayOfT == null)
    {
      this.a.append("null\n");
      AppMethodBeat.o(225362);
      return this;
    }
    if (paramArrayOfT.length == 0)
    {
      this.a.append(paramArrayOfT.length).append(", []\n");
      AppMethodBeat.o(225362);
      return this;
    }
    this.a.append(paramArrayOfT.length).append(", [\n");
    paramString = new k(this.a, this.b + 1);
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfT[i], null);
      i += 1;
    }
    a(']', null);
    AppMethodBeat.o(225362);
    return this;
  }
  
  private <T> k a(T[] paramArrayOfT, boolean paramBoolean)
  {
    AppMethodBeat.i(225372);
    if ((paramArrayOfT == null) || (paramArrayOfT.length == 0))
    {
      this.a.append("[]");
      if (paramBoolean) {
        this.a.append("|");
      }
      AppMethodBeat.o(225372);
      return this;
    }
    this.a.append("[");
    k localk = new k(this.a, this.b + 1);
    int i = 0;
    while (i < paramArrayOfT.length)
    {
      T ? = paramArrayOfT[i];
      if (i != 0) {
        this.a.append("|");
      }
      localk.a(?, false);
      i += 1;
    }
    this.a.append("]");
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225372);
    return this;
  }
  
  private k a(short[] paramArrayOfShort, String paramString)
  {
    AppMethodBeat.i(225236);
    a(paramString);
    if (paramArrayOfShort == null)
    {
      this.a.append("null\n");
      AppMethodBeat.o(225236);
      return this;
    }
    if (paramArrayOfShort.length == 0)
    {
      this.a.append(paramArrayOfShort.length).append(", []\n");
      AppMethodBeat.o(225236);
      return this;
    }
    this.a.append(paramArrayOfShort.length).append(", [\n");
    paramString = new k(this.a, this.b + 1);
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfShort[i], null);
      i += 1;
    }
    a(']', null);
    AppMethodBeat.o(225236);
    return this;
  }
  
  private k a(short[] paramArrayOfShort, boolean paramBoolean)
  {
    AppMethodBeat.i(225250);
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0))
    {
      this.a.append("[]");
      if (paramBoolean) {
        this.a.append("|");
      }
      AppMethodBeat.o(225250);
      return this;
    }
    this.a.append("[");
    k localk = new k(this.a, this.b + 1);
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      short s = paramArrayOfShort[i];
      if (i != 0) {
        this.a.append("|");
      }
      localk.a(s, false);
      i += 1;
    }
    this.a.append("]");
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225250);
    return this;
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(225109);
    int i = 0;
    while (i < this.b)
    {
      this.a.append('\t');
      i += 1;
    }
    if (paramString != null) {
      this.a.append(paramString).append(": ");
    }
    AppMethodBeat.o(225109);
  }
  
  public final k a(byte paramByte, String paramString)
  {
    AppMethodBeat.i(225412);
    a(paramString);
    this.a.append(paramByte).append('\n');
    AppMethodBeat.o(225412);
    return this;
  }
  
  public final k a(byte paramByte, boolean paramBoolean)
  {
    AppMethodBeat.i(225421);
    this.a.append(paramByte);
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225421);
    return this;
  }
  
  public final k a(int paramInt, String paramString)
  {
    AppMethodBeat.i(225452);
    a(paramString);
    this.a.append(paramInt).append('\n');
    AppMethodBeat.o(225452);
    return this;
  }
  
  public final k a(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(225464);
    this.a.append(paramInt);
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225464);
    return this;
  }
  
  public final k a(long paramLong, String paramString)
  {
    AppMethodBeat.i(225469);
    a(paramString);
    this.a.append(paramLong).append('\n');
    AppMethodBeat.o(225469);
    return this;
  }
  
  public final k a(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(225478);
    this.a.append(paramLong);
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225478);
    return this;
  }
  
  public final k a(p paramp, String paramString)
  {
    AppMethodBeat.i(225543);
    a('{', paramString);
    if (paramp == null) {
      this.a.append('\t').append("null");
    }
    for (;;)
    {
      a('}', null);
      AppMethodBeat.o(225543);
      return this;
      paramp.display(this.a, this.b + 1);
    }
  }
  
  public final k a(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(225553);
    this.a.append("{");
    if (paramp == null) {
      this.a.append('\t').append("null");
    }
    for (;;)
    {
      this.a.append("}");
      if (paramBoolean) {
        this.a.append("|");
      }
      AppMethodBeat.o(225553);
      return this;
      paramp.displaySimple(this.a, this.b + 1);
    }
  }
  
  public final k a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(225485);
    a(paramString2);
    if (paramString1 == null) {
      this.a.append("null\n");
    }
    for (;;)
    {
      AppMethodBeat.o(225485);
      return this;
      this.a.append(paramString1).append('\n');
    }
  }
  
  public final k a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(225493);
    if (paramString == null) {
      this.a.append("null");
    }
    for (;;)
    {
      if (paramBoolean) {
        this.a.append("|");
      }
      AppMethodBeat.o(225493);
      return this;
      this.a.append(paramString);
    }
  }
  
  public final <T> k a(Collection<T> paramCollection, String paramString)
  {
    AppMethodBeat.i(225525);
    if (paramCollection == null)
    {
      a(paramString);
      this.a.append("null\t");
      AppMethodBeat.o(225525);
      return this;
    }
    paramCollection = a(paramCollection.toArray(), paramString);
    AppMethodBeat.o(225525);
    return paramCollection;
  }
  
  public final <T> k a(Collection<T> paramCollection, boolean paramBoolean)
  {
    AppMethodBeat.i(225531);
    if (paramCollection == null)
    {
      this.a.append("[]");
      if (paramBoolean) {
        this.a.append("|");
      }
      AppMethodBeat.o(225531);
      return this;
    }
    paramCollection = a(paramCollection.toArray(), paramBoolean);
    AppMethodBeat.o(225531);
    return paramCollection;
  }
  
  public final <K, V> k a(Map<K, V> paramMap, String paramString)
  {
    AppMethodBeat.i(225517);
    a(paramString);
    if (paramMap == null)
    {
      this.a.append("null\n");
      AppMethodBeat.o(225517);
      return this;
    }
    if (paramMap.isEmpty())
    {
      this.a.append(paramMap.size()).append(", {}\n");
      AppMethodBeat.o(225517);
      return this;
    }
    this.a.append(paramMap.size()).append(", {\n");
    paramString = new k(this.a, this.b + 1);
    k localk = new k(this.a, this.b + 2);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramString.a('(', null);
      localk.a(localEntry.getKey(), null);
      localk.a(localEntry.getValue(), null);
      paramString.a(')', null);
    }
    a('}', null);
    AppMethodBeat.o(225517);
    return this;
  }
  
  public final k a(short paramShort, String paramString)
  {
    AppMethodBeat.i(225431);
    a(paramString);
    this.a.append(paramShort).append('\n');
    AppMethodBeat.o(225431);
    return this;
  }
  
  public final k a(short paramShort, boolean paramBoolean)
  {
    AppMethodBeat.i(225442);
    this.a.append(paramShort);
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225442);
    return this;
  }
  
  public final k a(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(225500);
    a(paramString);
    if (paramArrayOfByte == null)
    {
      this.a.append("null\n");
      AppMethodBeat.o(225500);
      return this;
    }
    if (paramArrayOfByte.length == 0)
    {
      this.a.append(paramArrayOfByte.length).append(", []\n");
      AppMethodBeat.o(225500);
      return this;
    }
    this.a.append(paramArrayOfByte.length).append(", [\n");
    paramString = new k(this.a, this.b + 1);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfByte[i], null);
      i += 1;
    }
    a(']', null);
    AppMethodBeat.o(225500);
    return this;
  }
  
  public final k a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(225508);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      if (paramBoolean) {
        this.a.append("|");
      }
      AppMethodBeat.o(225508);
      return this;
    }
    this.a.append(i.a(paramArrayOfByte));
    if (paramBoolean) {
      this.a.append("|");
    }
    AppMethodBeat.o(225508);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.k
 * JD-Core Version:    0.7.0.1
 */