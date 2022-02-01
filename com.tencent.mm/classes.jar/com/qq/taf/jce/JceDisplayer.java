package com.qq.taf.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class JceDisplayer
{
  private int _level = 0;
  private StringBuilder sb;
  
  public JceDisplayer(StringBuilder paramStringBuilder)
  {
    this.sb = paramStringBuilder;
  }
  
  public JceDisplayer(StringBuilder paramStringBuilder, int paramInt)
  {
    this.sb = paramStringBuilder;
    this._level = paramInt;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    AppMethodBeat.i(109639);
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append(1.2D);
    System.out.println(paramArrayOfString.toString());
    AppMethodBeat.o(109639);
  }
  
  private void ps(String paramString)
  {
    AppMethodBeat.i(109596);
    int i = 0;
    for (;;)
    {
      if (i >= this._level)
      {
        if (paramString != null) {
          this.sb.append(paramString).append(": ");
        }
        AppMethodBeat.o(109596);
        return;
      }
      this.sb.append('\t');
      i += 1;
    }
  }
  
  public final JceDisplayer display(byte paramByte, String paramString)
  {
    AppMethodBeat.i(109599);
    ps(paramString);
    this.sb.append(paramByte).append('\n');
    AppMethodBeat.o(109599);
    return this;
  }
  
  public final JceDisplayer display(char paramChar, String paramString)
  {
    AppMethodBeat.i(109601);
    ps(paramString);
    this.sb.append(paramChar).append('\n');
    AppMethodBeat.o(109601);
    return this;
  }
  
  public final JceDisplayer display(double paramDouble, String paramString)
  {
    AppMethodBeat.i(109611);
    ps(paramString);
    this.sb.append(paramDouble).append('\n');
    AppMethodBeat.o(109611);
    return this;
  }
  
  public final JceDisplayer display(float paramFloat, String paramString)
  {
    AppMethodBeat.i(109609);
    ps(paramString);
    this.sb.append(paramFloat).append('\n');
    AppMethodBeat.o(109609);
    return this;
  }
  
  public final JceDisplayer display(int paramInt, String paramString)
  {
    AppMethodBeat.i(109605);
    ps(paramString);
    this.sb.append(paramInt).append('\n');
    AppMethodBeat.o(109605);
    return this;
  }
  
  public final JceDisplayer display(long paramLong, String paramString)
  {
    AppMethodBeat.i(109607);
    ps(paramString);
    this.sb.append(paramLong).append('\n');
    AppMethodBeat.o(109607);
    return this;
  }
  
  public final JceDisplayer display(JceStruct paramJceStruct, String paramString)
  {
    AppMethodBeat.i(109637);
    display('{', paramString);
    if (paramJceStruct == null) {
      this.sb.append('\t').append("null");
    }
    for (;;)
    {
      display('}', null);
      AppMethodBeat.o(109637);
      return this;
      paramJceStruct.display(this.sb, this._level + 1);
    }
  }
  
  public final <T> JceDisplayer display(T paramT, String paramString)
  {
    AppMethodBeat.i(109635);
    if (paramT == null) {
      this.sb.append("null\n");
    }
    for (;;)
    {
      AppMethodBeat.o(109635);
      return this;
      if ((paramT instanceof Byte))
      {
        display(((Byte)paramT).byteValue(), paramString);
      }
      else if ((paramT instanceof Boolean))
      {
        display(((Boolean)paramT).booleanValue(), paramString);
      }
      else if ((paramT instanceof Short))
      {
        display(((Short)paramT).shortValue(), paramString);
      }
      else if ((paramT instanceof Integer))
      {
        display(((Integer)paramT).intValue(), paramString);
      }
      else if ((paramT instanceof Long))
      {
        display(((Long)paramT).longValue(), paramString);
      }
      else if ((paramT instanceof Float))
      {
        display(((Float)paramT).floatValue(), paramString);
      }
      else if ((paramT instanceof Double))
      {
        display(((Double)paramT).doubleValue(), paramString);
      }
      else if ((paramT instanceof String))
      {
        display((String)paramT, paramString);
      }
      else if ((paramT instanceof Map))
      {
        display((Map)paramT, paramString);
      }
      else if ((paramT instanceof List))
      {
        display((List)paramT, paramString);
      }
      else if ((paramT instanceof JceStruct))
      {
        display((JceStruct)paramT, paramString);
      }
      else if ((paramT instanceof byte[]))
      {
        display((byte[])paramT, paramString);
      }
      else if ((paramT instanceof boolean[]))
      {
        display((boolean[])paramT, paramString);
      }
      else if ((paramT instanceof short[]))
      {
        display((short[])paramT, paramString);
      }
      else if ((paramT instanceof int[]))
      {
        display((int[])paramT, paramString);
      }
      else if ((paramT instanceof long[]))
      {
        display((long[])paramT, paramString);
      }
      else if ((paramT instanceof float[]))
      {
        display((float[])paramT, paramString);
      }
      else if ((paramT instanceof double[]))
      {
        display((double[])paramT, paramString);
      }
      else
      {
        if (!paramT.getClass().isArray()) {
          break;
        }
        display((Object[])paramT, paramString);
      }
    }
    paramT = new JceEncodeException("write object error: unsupport type.");
    AppMethodBeat.o(109635);
    throw paramT;
  }
  
  public final JceDisplayer display(String paramString1, String paramString2)
  {
    AppMethodBeat.i(109613);
    ps(paramString2);
    if (paramString1 == null) {
      this.sb.append("null\n");
    }
    for (;;)
    {
      AppMethodBeat.o(109613);
      return this;
      this.sb.append(paramString1).append('\n');
    }
  }
  
  public final <T> JceDisplayer display(Collection<T> paramCollection, String paramString)
  {
    AppMethodBeat.i(109633);
    if (paramCollection == null)
    {
      ps(paramString);
      this.sb.append("null\t");
      AppMethodBeat.o(109633);
      return this;
    }
    paramCollection = display(paramCollection.toArray(), paramString);
    AppMethodBeat.o(109633);
    return paramCollection;
  }
  
  public final <K, V> JceDisplayer display(Map<K, V> paramMap, String paramString)
  {
    AppMethodBeat.i(109629);
    ps(paramString);
    if (paramMap == null)
    {
      this.sb.append("null\n");
      AppMethodBeat.o(109629);
      return this;
    }
    if (paramMap.isEmpty())
    {
      this.sb.append(paramMap.size()).append(", {}\n");
      AppMethodBeat.o(109629);
      return this;
    }
    this.sb.append(paramMap.size()).append(", {\n");
    paramString = new JceDisplayer(this.sb, this._level + 1);
    JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 2);
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!paramMap.hasNext())
      {
        display('}', null);
        AppMethodBeat.o(109629);
        return this;
      }
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramString.display('(', null);
      localJceDisplayer.display(localEntry.getKey(), null);
      localJceDisplayer.display(localEntry.getValue(), null);
      paramString.display(')', null);
    }
  }
  
  public final JceDisplayer display(short paramShort, String paramString)
  {
    AppMethodBeat.i(109603);
    ps(paramString);
    this.sb.append(paramShort).append('\n');
    AppMethodBeat.o(109603);
    return this;
  }
  
  public final JceDisplayer display(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(109597);
    ps(paramString);
    paramString = this.sb;
    if (paramBoolean) {}
    for (char c = 'T';; c = 'F')
    {
      paramString.append(c).append('\n');
      AppMethodBeat.o(109597);
      return this;
    }
  }
  
  public final JceDisplayer display(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(109615);
    ps(paramString);
    if (paramArrayOfByte == null)
    {
      this.sb.append("null\n");
      AppMethodBeat.o(109615);
      return this;
    }
    if (paramArrayOfByte.length == 0)
    {
      this.sb.append(paramArrayOfByte.length).append(", []\n");
      AppMethodBeat.o(109615);
      return this;
    }
    this.sb.append(paramArrayOfByte.length).append(", [\n");
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        display(']', null);
        AppMethodBeat.o(109615);
        return this;
      }
      paramString.display(paramArrayOfByte[i], null);
      i += 1;
    }
  }
  
  public final JceDisplayer display(char[] paramArrayOfChar, String paramString)
  {
    AppMethodBeat.i(109617);
    ps(paramString);
    if (paramArrayOfChar == null)
    {
      this.sb.append("null\n");
      AppMethodBeat.o(109617);
      return this;
    }
    if (paramArrayOfChar.length == 0)
    {
      this.sb.append(paramArrayOfChar.length).append(", []\n");
      AppMethodBeat.o(109617);
      return this;
    }
    this.sb.append(paramArrayOfChar.length).append(", [\n");
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfChar.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        display(']', null);
        AppMethodBeat.o(109617);
        return this;
      }
      paramString.display(paramArrayOfChar[i], null);
      i += 1;
    }
  }
  
  public final JceDisplayer display(double[] paramArrayOfDouble, String paramString)
  {
    AppMethodBeat.i(109627);
    ps(paramString);
    if (paramArrayOfDouble == null)
    {
      this.sb.append("null\n");
      AppMethodBeat.o(109627);
      return this;
    }
    if (paramArrayOfDouble.length == 0)
    {
      this.sb.append(paramArrayOfDouble.length).append(", []\n");
      AppMethodBeat.o(109627);
      return this;
    }
    this.sb.append(paramArrayOfDouble.length).append(", [\n");
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfDouble.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        display(']', null);
        AppMethodBeat.o(109627);
        return this;
      }
      paramString.display(paramArrayOfDouble[i], null);
      i += 1;
    }
  }
  
  public final JceDisplayer display(float[] paramArrayOfFloat, String paramString)
  {
    AppMethodBeat.i(109625);
    ps(paramString);
    if (paramArrayOfFloat == null)
    {
      this.sb.append("null\n");
      AppMethodBeat.o(109625);
      return this;
    }
    if (paramArrayOfFloat.length == 0)
    {
      this.sb.append(paramArrayOfFloat.length).append(", []\n");
      AppMethodBeat.o(109625);
      return this;
    }
    this.sb.append(paramArrayOfFloat.length).append(", [\n");
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfFloat.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        display(']', null);
        AppMethodBeat.o(109625);
        return this;
      }
      paramString.display(paramArrayOfFloat[i], null);
      i += 1;
    }
  }
  
  public final JceDisplayer display(int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(109621);
    ps(paramString);
    if (paramArrayOfInt == null)
    {
      this.sb.append("null\n");
      AppMethodBeat.o(109621);
      return this;
    }
    if (paramArrayOfInt.length == 0)
    {
      this.sb.append(paramArrayOfInt.length).append(", []\n");
      AppMethodBeat.o(109621);
      return this;
    }
    this.sb.append(paramArrayOfInt.length).append(", [\n");
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        display(']', null);
        AppMethodBeat.o(109621);
        return this;
      }
      paramString.display(paramArrayOfInt[i], null);
      i += 1;
    }
  }
  
  public final JceDisplayer display(long[] paramArrayOfLong, String paramString)
  {
    AppMethodBeat.i(109623);
    ps(paramString);
    if (paramArrayOfLong == null)
    {
      this.sb.append("null\n");
      AppMethodBeat.o(109623);
      return this;
    }
    if (paramArrayOfLong.length == 0)
    {
      this.sb.append(paramArrayOfLong.length).append(", []\n");
      AppMethodBeat.o(109623);
      return this;
    }
    this.sb.append(paramArrayOfLong.length).append(", [\n");
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfLong.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        display(']', null);
        AppMethodBeat.o(109623);
        return this;
      }
      paramString.display(paramArrayOfLong[i], null);
      i += 1;
    }
  }
  
  public final <T> JceDisplayer display(T[] paramArrayOfT, String paramString)
  {
    AppMethodBeat.i(109631);
    ps(paramString);
    if (paramArrayOfT == null)
    {
      this.sb.append("null\n");
      AppMethodBeat.o(109631);
      return this;
    }
    if (paramArrayOfT.length == 0)
    {
      this.sb.append(paramArrayOfT.length).append(", []\n");
      AppMethodBeat.o(109631);
      return this;
    }
    this.sb.append(paramArrayOfT.length).append(", [\n");
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfT.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        display(']', null);
        AppMethodBeat.o(109631);
        return this;
      }
      paramString.display(paramArrayOfT[i], null);
      i += 1;
    }
  }
  
  public final JceDisplayer display(short[] paramArrayOfShort, String paramString)
  {
    AppMethodBeat.i(109619);
    ps(paramString);
    if (paramArrayOfShort == null)
    {
      this.sb.append("null\n");
      AppMethodBeat.o(109619);
      return this;
    }
    if (paramArrayOfShort.length == 0)
    {
      this.sb.append(paramArrayOfShort.length).append(", []\n");
      AppMethodBeat.o(109619);
      return this;
    }
    this.sb.append(paramArrayOfShort.length).append(", [\n");
    paramString = new JceDisplayer(this.sb, this._level + 1);
    int j = paramArrayOfShort.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        display(']', null);
        AppMethodBeat.o(109619);
        return this;
      }
      paramString.display(paramArrayOfShort[i], null);
      i += 1;
    }
  }
  
  public final JceDisplayer displaySimple(byte paramByte, boolean paramBoolean)
  {
    AppMethodBeat.i(109600);
    this.sb.append(paramByte);
    if (paramBoolean) {
      this.sb.append("|");
    }
    AppMethodBeat.o(109600);
    return this;
  }
  
  public final JceDisplayer displaySimple(char paramChar, boolean paramBoolean)
  {
    AppMethodBeat.i(109602);
    this.sb.append(paramChar);
    if (paramBoolean) {
      this.sb.append("|");
    }
    AppMethodBeat.o(109602);
    return this;
  }
  
  public final JceDisplayer displaySimple(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(109612);
    this.sb.append(paramDouble);
    if (paramBoolean) {
      this.sb.append("|");
    }
    AppMethodBeat.o(109612);
    return this;
  }
  
  public final JceDisplayer displaySimple(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(109610);
    this.sb.append(paramFloat);
    if (paramBoolean) {
      this.sb.append("|");
    }
    AppMethodBeat.o(109610);
    return this;
  }
  
  public final JceDisplayer displaySimple(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109606);
    this.sb.append(paramInt);
    if (paramBoolean) {
      this.sb.append("|");
    }
    AppMethodBeat.o(109606);
    return this;
  }
  
  public final JceDisplayer displaySimple(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(109608);
    this.sb.append(paramLong);
    if (paramBoolean) {
      this.sb.append("|");
    }
    AppMethodBeat.o(109608);
    return this;
  }
  
  public final JceDisplayer displaySimple(JceStruct paramJceStruct, boolean paramBoolean)
  {
    AppMethodBeat.i(109638);
    this.sb.append("{");
    if (paramJceStruct == null) {
      this.sb.append('\t').append("null");
    }
    for (;;)
    {
      this.sb.append("}");
      if (paramBoolean) {
        this.sb.append("|");
      }
      AppMethodBeat.o(109638);
      return this;
      paramJceStruct.displaySimple(this.sb, this._level + 1);
    }
  }
  
  public final <T> JceDisplayer displaySimple(T paramT, boolean paramBoolean)
  {
    AppMethodBeat.i(109636);
    if (paramT == null) {
      this.sb.append("null\n");
    }
    for (;;)
    {
      AppMethodBeat.o(109636);
      return this;
      if ((paramT instanceof Byte))
      {
        displaySimple(((Byte)paramT).byteValue(), paramBoolean);
      }
      else if ((paramT instanceof Boolean))
      {
        displaySimple(((Boolean)paramT).booleanValue(), paramBoolean);
      }
      else if ((paramT instanceof Short))
      {
        displaySimple(((Short)paramT).shortValue(), paramBoolean);
      }
      else if ((paramT instanceof Integer))
      {
        displaySimple(((Integer)paramT).intValue(), paramBoolean);
      }
      else if ((paramT instanceof Long))
      {
        displaySimple(((Long)paramT).longValue(), paramBoolean);
      }
      else if ((paramT instanceof Float))
      {
        displaySimple(((Float)paramT).floatValue(), paramBoolean);
      }
      else if ((paramT instanceof Double))
      {
        displaySimple(((Double)paramT).doubleValue(), paramBoolean);
      }
      else if ((paramT instanceof String))
      {
        displaySimple((String)paramT, paramBoolean);
      }
      else if ((paramT instanceof Map))
      {
        displaySimple((Map)paramT, paramBoolean);
      }
      else if ((paramT instanceof List))
      {
        displaySimple((List)paramT, paramBoolean);
      }
      else if ((paramT instanceof JceStruct))
      {
        displaySimple((JceStruct)paramT, paramBoolean);
      }
      else if ((paramT instanceof byte[]))
      {
        displaySimple((byte[])paramT, paramBoolean);
      }
      else if ((paramT instanceof boolean[]))
      {
        displaySimple((boolean[])paramT, paramBoolean);
      }
      else if ((paramT instanceof short[]))
      {
        displaySimple((short[])paramT, paramBoolean);
      }
      else if ((paramT instanceof int[]))
      {
        displaySimple((int[])paramT, paramBoolean);
      }
      else if ((paramT instanceof long[]))
      {
        displaySimple((long[])paramT, paramBoolean);
      }
      else if ((paramT instanceof float[]))
      {
        displaySimple((float[])paramT, paramBoolean);
      }
      else if ((paramT instanceof double[]))
      {
        displaySimple((double[])paramT, paramBoolean);
      }
      else
      {
        if (!paramT.getClass().isArray()) {
          break;
        }
        displaySimple((Object[])paramT, paramBoolean);
      }
    }
    paramT = new JceEncodeException("write object error: unsupport type.");
    AppMethodBeat.o(109636);
    throw paramT;
  }
  
  public final JceDisplayer displaySimple(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(109614);
    if (paramString == null) {
      this.sb.append("null");
    }
    for (;;)
    {
      if (paramBoolean) {
        this.sb.append("|");
      }
      AppMethodBeat.o(109614);
      return this;
      this.sb.append(paramString);
    }
  }
  
  public final <T> JceDisplayer displaySimple(Collection<T> paramCollection, boolean paramBoolean)
  {
    AppMethodBeat.i(109634);
    if (paramCollection == null)
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
      AppMethodBeat.o(109634);
      return this;
    }
    paramCollection = displaySimple(paramCollection.toArray(), paramBoolean);
    AppMethodBeat.o(109634);
    return paramCollection;
  }
  
  public final <K, V> JceDisplayer displaySimple(Map<K, V> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(109630);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      this.sb.append("{}");
      if (paramBoolean) {
        this.sb.append("|");
      }
      AppMethodBeat.o(109630);
      return this;
    }
    this.sb.append("{");
    JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 2);
    paramMap = paramMap.entrySet().iterator();
    for (int i = 1;; i = 0)
    {
      if (!paramMap.hasNext())
      {
        this.sb.append("}");
        if (paramBoolean) {
          this.sb.append("|");
        }
        AppMethodBeat.o(109630);
        return this;
      }
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (i == 0) {
        this.sb.append(",");
      }
      localJceDisplayer.displaySimple(localEntry.getKey(), true);
      localJceDisplayer.displaySimple(localEntry.getValue(), false);
    }
  }
  
  public final JceDisplayer displaySimple(short paramShort, boolean paramBoolean)
  {
    AppMethodBeat.i(109604);
    this.sb.append(paramShort);
    if (paramBoolean) {
      this.sb.append("|");
    }
    AppMethodBeat.o(109604);
    return this;
  }
  
  public final JceDisplayer displaySimple(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(109598);
    StringBuilder localStringBuilder = this.sb;
    if (paramBoolean1) {}
    for (char c = 'T';; c = 'F')
    {
      localStringBuilder.append(c);
      if (paramBoolean2) {
        this.sb.append("|");
      }
      AppMethodBeat.o(109598);
      return this;
    }
  }
  
  public final JceDisplayer displaySimple(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(109616);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      if (paramBoolean) {
        this.sb.append("|");
      }
      AppMethodBeat.o(109616);
      return this;
    }
    this.sb.append(HexUtil.bytes2HexStr(paramArrayOfByte));
    if (paramBoolean) {
      this.sb.append("|");
    }
    AppMethodBeat.o(109616);
    return this;
  }
  
  public final JceDisplayer displaySimple(char[] paramArrayOfChar, boolean paramBoolean)
  {
    AppMethodBeat.i(109618);
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0))
    {
      if (paramBoolean) {
        this.sb.append("|");
      }
      AppMethodBeat.o(109618);
      return this;
    }
    this.sb.append(new String(paramArrayOfChar));
    if (paramBoolean) {
      this.sb.append("|");
    }
    AppMethodBeat.o(109618);
    return this;
  }
  
  public final JceDisplayer displaySimple(double[] paramArrayOfDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(109628);
    if ((paramArrayOfDouble == null) || (paramArrayOfDouble.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
      AppMethodBeat.o(109628);
      return this;
    }
    this.sb.append("[");
    JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 1);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfDouble.length)
      {
        this.sb.append("[");
        if (paramBoolean) {
          this.sb.append("|");
        }
        AppMethodBeat.o(109628);
        return this;
      }
      double d = paramArrayOfDouble[i];
      if (i != 0) {
        this.sb.append("|");
      }
      localJceDisplayer.displaySimple(d, false);
      i += 1;
    }
  }
  
  public final JceDisplayer displaySimple(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(109626);
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
      AppMethodBeat.o(109626);
      return this;
    }
    this.sb.append("[");
    JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 1);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfFloat.length)
      {
        this.sb.append("]");
        if (paramBoolean) {
          this.sb.append("|");
        }
        AppMethodBeat.o(109626);
        return this;
      }
      float f = paramArrayOfFloat[i];
      if (i != 0) {
        this.sb.append("|");
      }
      localJceDisplayer.displaySimple(f, false);
      i += 1;
    }
  }
  
  public final JceDisplayer displaySimple(int[] paramArrayOfInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109622);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
      AppMethodBeat.o(109622);
      return this;
    }
    this.sb.append("[");
    JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 1);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfInt.length)
      {
        this.sb.append("]");
        if (paramBoolean) {
          this.sb.append("|");
        }
        AppMethodBeat.o(109622);
        return this;
      }
      int j = paramArrayOfInt[i];
      if (i != 0) {
        this.sb.append("|");
      }
      localJceDisplayer.displaySimple(j, false);
      i += 1;
    }
  }
  
  public final JceDisplayer displaySimple(long[] paramArrayOfLong, boolean paramBoolean)
  {
    AppMethodBeat.i(109624);
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
      AppMethodBeat.o(109624);
      return this;
    }
    this.sb.append("[");
    JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 1);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfLong.length)
      {
        this.sb.append("]");
        if (paramBoolean) {
          this.sb.append("|");
        }
        AppMethodBeat.o(109624);
        return this;
      }
      long l = paramArrayOfLong[i];
      if (i != 0) {
        this.sb.append("|");
      }
      localJceDisplayer.displaySimple(l, false);
      i += 1;
    }
  }
  
  public final <T> JceDisplayer displaySimple(T[] paramArrayOfT, boolean paramBoolean)
  {
    AppMethodBeat.i(109632);
    if ((paramArrayOfT == null) || (paramArrayOfT.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
      AppMethodBeat.o(109632);
      return this;
    }
    this.sb.append("[");
    JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 1);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfT.length)
      {
        this.sb.append("]");
        if (paramBoolean) {
          this.sb.append("|");
        }
        AppMethodBeat.o(109632);
        return this;
      }
      T ? = paramArrayOfT[i];
      if (i != 0) {
        this.sb.append("|");
      }
      localJceDisplayer.displaySimple(?, false);
      i += 1;
    }
  }
  
  public final JceDisplayer displaySimple(short[] paramArrayOfShort, boolean paramBoolean)
  {
    AppMethodBeat.i(109620);
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
      AppMethodBeat.o(109620);
      return this;
    }
    this.sb.append("[");
    JceDisplayer localJceDisplayer = new JceDisplayer(this.sb, this._level + 1);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfShort.length)
      {
        this.sb.append("]");
        if (paramBoolean) {
          this.sb.append("|");
        }
        AppMethodBeat.o(109620);
        return this;
      }
      short s = paramArrayOfShort[i];
      if (i != 0) {
        this.sb.append("|");
      }
      localJceDisplayer.displaySimple(s, false);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.qq.taf.jce.JceDisplayer
 * JD-Core Version:    0.7.0.1
 */