package com.qq.taf.jce;

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
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append(1.2D);
    System.out.println(paramArrayOfString.toString());
  }
  
  private void ps(String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i >= this._level)
      {
        if (paramString != null) {
          this.sb.append(paramString).append(": ");
        }
        return;
      }
      this.sb.append('\t');
      i += 1;
    }
  }
  
  public final JceDisplayer display(byte paramByte, String paramString)
  {
    ps(paramString);
    this.sb.append(paramByte).append('\n');
    return this;
  }
  
  public final JceDisplayer display(char paramChar, String paramString)
  {
    ps(paramString);
    this.sb.append(paramChar).append('\n');
    return this;
  }
  
  public final JceDisplayer display(double paramDouble, String paramString)
  {
    ps(paramString);
    this.sb.append(paramDouble).append('\n');
    return this;
  }
  
  public final JceDisplayer display(float paramFloat, String paramString)
  {
    ps(paramString);
    this.sb.append(paramFloat).append('\n');
    return this;
  }
  
  public final JceDisplayer display(int paramInt, String paramString)
  {
    ps(paramString);
    this.sb.append(paramInt).append('\n');
    return this;
  }
  
  public final JceDisplayer display(long paramLong, String paramString)
  {
    ps(paramString);
    this.sb.append(paramLong).append('\n');
    return this;
  }
  
  public final JceDisplayer display(JceStruct paramJceStruct, String paramString)
  {
    display('{', paramString);
    if (paramJceStruct == null) {
      this.sb.append('\t').append("null");
    }
    for (;;)
    {
      display('}', null);
      return this;
      paramJceStruct.display(this.sb, this._level + 1);
    }
  }
  
  public final <T> JceDisplayer display(T paramT, String paramString)
  {
    if (paramT == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if ((paramT instanceof Byte))
    {
      display(((Byte)paramT).byteValue(), paramString);
      return this;
    }
    if ((paramT instanceof Boolean))
    {
      display(((Boolean)paramT).booleanValue(), paramString);
      return this;
    }
    if ((paramT instanceof Short))
    {
      display(((Short)paramT).shortValue(), paramString);
      return this;
    }
    if ((paramT instanceof Integer))
    {
      display(((Integer)paramT).intValue(), paramString);
      return this;
    }
    if ((paramT instanceof Long))
    {
      display(((Long)paramT).longValue(), paramString);
      return this;
    }
    if ((paramT instanceof Float))
    {
      display(((Float)paramT).floatValue(), paramString);
      return this;
    }
    if ((paramT instanceof Double))
    {
      display(((Double)paramT).doubleValue(), paramString);
      return this;
    }
    if ((paramT instanceof String))
    {
      display((String)paramT, paramString);
      return this;
    }
    if ((paramT instanceof Map))
    {
      display((Map)paramT, paramString);
      return this;
    }
    if ((paramT instanceof List))
    {
      display((List)paramT, paramString);
      return this;
    }
    if ((paramT instanceof JceStruct))
    {
      display((JceStruct)paramT, paramString);
      return this;
    }
    if ((paramT instanceof byte[]))
    {
      display((byte[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof boolean[]))
    {
      display((boolean[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof short[]))
    {
      display((short[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof int[]))
    {
      display((int[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof long[]))
    {
      display((long[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof float[]))
    {
      display((float[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof double[]))
    {
      display((double[])paramT, paramString);
      return this;
    }
    if (paramT.getClass().isArray())
    {
      display((Object[])paramT, paramString);
      return this;
    }
    throw new JceEncodeException("write object error: unsupport type.");
  }
  
  public final JceDisplayer display(String paramString1, String paramString2)
  {
    ps(paramString2);
    if (paramString1 == null)
    {
      this.sb.append("null\n");
      return this;
    }
    this.sb.append(paramString1).append('\n');
    return this;
  }
  
  public final <T> JceDisplayer display(Collection<T> paramCollection, String paramString)
  {
    if (paramCollection == null)
    {
      ps(paramString);
      this.sb.append("null\t");
      return this;
    }
    return display(paramCollection.toArray(), paramString);
  }
  
  public final <K, V> JceDisplayer display(Map<K, V> paramMap, String paramString)
  {
    ps(paramString);
    if (paramMap == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramMap.isEmpty())
    {
      this.sb.append(paramMap.size()).append(", {}\n");
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
    ps(paramString);
    this.sb.append(paramShort).append('\n');
    return this;
  }
  
  public final JceDisplayer display(boolean paramBoolean, String paramString)
  {
    ps(paramString);
    paramString = this.sb;
    if (paramBoolean) {}
    for (char c = 'T';; c = 'F')
    {
      paramString.append(c).append('\n');
      return this;
    }
  }
  
  public final JceDisplayer display(byte[] paramArrayOfByte, String paramString)
  {
    ps(paramString);
    if (paramArrayOfByte == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfByte.length == 0)
    {
      this.sb.append(paramArrayOfByte.length).append(", []\n");
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
        return this;
      }
      paramString.display(paramArrayOfByte[i], null);
      i += 1;
    }
  }
  
  public final JceDisplayer display(char[] paramArrayOfChar, String paramString)
  {
    ps(paramString);
    if (paramArrayOfChar == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfChar.length == 0)
    {
      this.sb.append(paramArrayOfChar.length).append(", []\n");
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
        return this;
      }
      paramString.display(paramArrayOfChar[i], null);
      i += 1;
    }
  }
  
  public final JceDisplayer display(double[] paramArrayOfDouble, String paramString)
  {
    ps(paramString);
    if (paramArrayOfDouble == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfDouble.length == 0)
    {
      this.sb.append(paramArrayOfDouble.length).append(", []\n");
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
        return this;
      }
      paramString.display(paramArrayOfDouble[i], null);
      i += 1;
    }
  }
  
  public final JceDisplayer display(float[] paramArrayOfFloat, String paramString)
  {
    ps(paramString);
    if (paramArrayOfFloat == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfFloat.length == 0)
    {
      this.sb.append(paramArrayOfFloat.length).append(", []\n");
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
        return this;
      }
      paramString.display(paramArrayOfFloat[i], null);
      i += 1;
    }
  }
  
  public final JceDisplayer display(int[] paramArrayOfInt, String paramString)
  {
    ps(paramString);
    if (paramArrayOfInt == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfInt.length == 0)
    {
      this.sb.append(paramArrayOfInt.length).append(", []\n");
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
        return this;
      }
      paramString.display(paramArrayOfInt[i], null);
      i += 1;
    }
  }
  
  public final JceDisplayer display(long[] paramArrayOfLong, String paramString)
  {
    ps(paramString);
    if (paramArrayOfLong == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfLong.length == 0)
    {
      this.sb.append(paramArrayOfLong.length).append(", []\n");
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
        return this;
      }
      paramString.display(paramArrayOfLong[i], null);
      i += 1;
    }
  }
  
  public final <T> JceDisplayer display(T[] paramArrayOfT, String paramString)
  {
    ps(paramString);
    if (paramArrayOfT == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfT.length == 0)
    {
      this.sb.append(paramArrayOfT.length).append(", []\n");
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
        return this;
      }
      paramString.display(paramArrayOfT[i], null);
      i += 1;
    }
  }
  
  public final JceDisplayer display(short[] paramArrayOfShort, String paramString)
  {
    ps(paramString);
    if (paramArrayOfShort == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if (paramArrayOfShort.length == 0)
    {
      this.sb.append(paramArrayOfShort.length).append(", []\n");
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
        return this;
      }
      paramString.display(paramArrayOfShort[i], null);
      i += 1;
    }
  }
  
  public final JceDisplayer displaySimple(byte paramByte, boolean paramBoolean)
  {
    this.sb.append(paramByte);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(char paramChar, boolean paramBoolean)
  {
    this.sb.append(paramChar);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(double paramDouble, boolean paramBoolean)
  {
    this.sb.append(paramDouble);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(float paramFloat, boolean paramBoolean)
  {
    this.sb.append(paramFloat);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(int paramInt, boolean paramBoolean)
  {
    this.sb.append(paramInt);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(long paramLong, boolean paramBoolean)
  {
    this.sb.append(paramLong);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(JceStruct paramJceStruct, boolean paramBoolean)
  {
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
      return this;
      paramJceStruct.displaySimple(this.sb, this._level + 1);
    }
  }
  
  public final <T> JceDisplayer displaySimple(T paramT, boolean paramBoolean)
  {
    if (paramT == null)
    {
      this.sb.append("null\n");
      return this;
    }
    if ((paramT instanceof Byte))
    {
      displaySimple(((Byte)paramT).byteValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Boolean))
    {
      displaySimple(((Boolean)paramT).booleanValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Short))
    {
      displaySimple(((Short)paramT).shortValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Integer))
    {
      displaySimple(((Integer)paramT).intValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Long))
    {
      displaySimple(((Long)paramT).longValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Float))
    {
      displaySimple(((Float)paramT).floatValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Double))
    {
      displaySimple(((Double)paramT).doubleValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof String))
    {
      displaySimple((String)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof Map))
    {
      displaySimple((Map)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof List))
    {
      displaySimple((List)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof JceStruct))
    {
      displaySimple((JceStruct)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof byte[]))
    {
      displaySimple((byte[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof boolean[]))
    {
      displaySimple((boolean[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof short[]))
    {
      displaySimple((short[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof int[]))
    {
      displaySimple((int[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof long[]))
    {
      displaySimple((long[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof float[]))
    {
      displaySimple((float[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof double[]))
    {
      displaySimple((double[])paramT, paramBoolean);
      return this;
    }
    if (paramT.getClass().isArray())
    {
      displaySimple((Object[])paramT, paramBoolean);
      return this;
    }
    throw new JceEncodeException("write object error: unsupport type.");
  }
  
  public final JceDisplayer displaySimple(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      this.sb.append("null");
    }
    for (;;)
    {
      if (paramBoolean) {
        this.sb.append("|");
      }
      return this;
      this.sb.append(paramString);
    }
  }
  
  public final <T> JceDisplayer displaySimple(Collection<T> paramCollection, boolean paramBoolean)
  {
    if (paramCollection == null)
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
      return this;
    }
    return displaySimple(paramCollection.toArray(), paramBoolean);
  }
  
  public final <K, V> JceDisplayer displaySimple(Map<K, V> paramMap, boolean paramBoolean)
  {
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      this.sb.append("{}");
      if (paramBoolean) {
        this.sb.append("|");
      }
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
        if (!paramBoolean) {
          break;
        }
        this.sb.append("|");
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
    this.sb.append(paramShort);
    if (paramBoolean) {
      this.sb.append("|");
    }
    return this;
  }
  
  public final JceDisplayer displaySimple(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = this.sb;
    if (paramBoolean1) {}
    for (char c = 'T';; c = 'F')
    {
      localStringBuilder.append(c);
      if (paramBoolean2) {
        this.sb.append("|");
      }
      return this;
    }
  }
  
  public final JceDisplayer displaySimple(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      if (paramBoolean) {
        this.sb.append("|");
      }
    }
    do
    {
      return this;
      this.sb.append(HexUtil.bytes2HexStr(paramArrayOfByte));
    } while (!paramBoolean);
    this.sb.append("|");
    return this;
  }
  
  public final JceDisplayer displaySimple(char[] paramArrayOfChar, boolean paramBoolean)
  {
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0)) {
      if (paramBoolean) {
        this.sb.append("|");
      }
    }
    do
    {
      return this;
      this.sb.append(new String(paramArrayOfChar));
    } while (!paramBoolean);
    this.sb.append("|");
    return this;
  }
  
  public final JceDisplayer displaySimple(double[] paramArrayOfDouble, boolean paramBoolean)
  {
    if ((paramArrayOfDouble == null) || (paramArrayOfDouble.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
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
        if (!paramBoolean) {
          break;
        }
        this.sb.append("|");
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
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
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
        if (!paramBoolean) {
          break;
        }
        this.sb.append("|");
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
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
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
        if (!paramBoolean) {
          break;
        }
        this.sb.append("|");
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
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
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
        if (!paramBoolean) {
          break;
        }
        this.sb.append("|");
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
    if ((paramArrayOfT == null) || (paramArrayOfT.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
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
        if (!paramBoolean) {
          break;
        }
        this.sb.append("|");
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
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0))
    {
      this.sb.append("[]");
      if (paramBoolean) {
        this.sb.append("|");
      }
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
        if (!paramBoolean) {
          break;
        }
        this.sb.append("|");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.qq.taf.jce.JceDisplayer
 * JD-Core Version:    0.7.0.1
 */