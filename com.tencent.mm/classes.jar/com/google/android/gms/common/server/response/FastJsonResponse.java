package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

public abstract class FastJsonResponse
{
  protected static final String QUOTE = "\"";
  private int zzwk;
  private byte[] zzwl;
  private boolean zzwm;
  
  public static InputStream getUnzippedStream(byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    if (IOUtils.isGzipByteBuffer(paramArrayOfByte)) {
      try
      {
        paramArrayOfByte = new GZIPInputStream(localByteArrayInputStream);
        return paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte) {}
    }
    return localByteArrayInputStream;
  }
  
  private final <I, O> void zza(Field<I, O> paramField, I paramI)
  {
    String str = paramField.getOutputFieldName();
    paramI = paramField.convert(paramI);
    switch (paramField.getTypeOut())
    {
    case 3: 
    default: 
      int i = paramField.getTypeOut();
      throw new IllegalStateException(44 + "Unsupported type for conversion: " + i);
    case 0: 
      if (zzb(str, paramI)) {
        setIntegerInternal(paramField, str, ((Integer)paramI).intValue());
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            setBigIntegerInternal(paramField, str, (BigInteger)paramI);
            return;
          } while (!zzb(str, paramI));
          setLongInternal(paramField, str, ((Long)paramI).longValue());
          return;
        } while (!zzb(str, paramI));
        setDoubleInternal(paramField, str, ((Double)paramI).doubleValue());
        return;
        setBigDecimalInternal(paramField, str, (BigDecimal)paramI);
        return;
      } while (!zzb(str, paramI));
      setBooleanInternal(paramField, str, ((Boolean)paramI).booleanValue());
      return;
      setStringInternal(paramField, str, (String)paramI);
      return;
    } while (!zzb(str, paramI));
    setDecodedBytesInternal(paramField, str, (byte[])paramI);
  }
  
  private static void zza(StringBuilder paramStringBuilder, Field paramField, Object paramObject)
  {
    if (paramField.getTypeIn() == 11)
    {
      paramStringBuilder.append(((FastJsonResponse)paramField.getConcreteType().cast(paramObject)).toString());
      return;
    }
    if (paramField.getTypeIn() == 7)
    {
      paramStringBuilder.append("\"");
      paramStringBuilder.append(JsonUtils.escapeString((String)paramObject));
      paramStringBuilder.append("\"");
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  private static <O> boolean zzb(String paramString, O paramO)
  {
    if (paramO == null)
    {
      if (Log.isLoggable("FastJsonResponse", 6)) {
        new StringBuilder(String.valueOf(paramString).length() + 58).append("Output field (").append(paramString).append(") has a null value, but expected a primitive");
      }
      return false;
    }
    return true;
  }
  
  public <T extends FastJsonResponse> void addConcreteType(String paramString, T paramT)
  {
    throw new UnsupportedOperationException("Concrete type not supported");
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeArray(String paramString, ArrayList<T> paramArrayList)
  {
    throw new UnsupportedOperationException("Concrete type array not supported");
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> paramField, String paramString, ArrayList<T> paramArrayList)
  {
    addConcreteTypeArray(paramString, paramArrayList);
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> paramField, String paramString, T paramT)
  {
    addConcreteType(paramString, paramT);
  }
  
  public HashMap<String, Object> getConcreteTypeArrays()
  {
    return null;
  }
  
  public HashMap<String, Object> getConcreteTypes()
  {
    return null;
  }
  
  public abstract Map<String, Field<?, ?>> getFieldMappings();
  
  protected Object getFieldValue(Field paramField)
  {
    String str = paramField.getOutputFieldName();
    if (paramField.getConcreteType() != null)
    {
      boolean bool;
      if (getValueObject(paramField.getOutputFieldName()) == null)
      {
        bool = true;
        Preconditions.checkState(bool, "Concrete field shouldn't be value object: %s", new Object[] { paramField.getOutputFieldName() });
        if (!paramField.isTypeOutArray()) {
          break label73;
        }
      }
      label73:
      for (paramField = getConcreteTypeArrays();; paramField = getConcreteTypes())
      {
        if (paramField == null) {
          break label81;
        }
        return paramField.get(str);
        bool = false;
        break;
      }
      try
      {
        label81:
        char c = Character.toUpperCase(str.charAt(0));
        paramField = str.substring(1);
        paramField = String.valueOf(paramField).length() + 4 + "get" + c + paramField;
        paramField = getClass().getMethod(paramField, new Class[0]).invoke(this, new Object[0]);
        return paramField;
      }
      catch (Exception paramField)
      {
        throw new RuntimeException(paramField);
      }
    }
    return getValueObject(paramField.getOutputFieldName());
  }
  
  protected <O, I> I getOriginalValue(Field<I, O> paramField, Object paramObject)
  {
    Object localObject = paramObject;
    if (Field.zza(paramField) != null) {
      localObject = paramField.convertBack(paramObject);
    }
    return localObject;
  }
  
  public PostProcessor<? extends FastJsonResponse> getPostProcessor()
  {
    return null;
  }
  
  /* Error */
  public byte[] getResponseBody()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 303	com/google/android/gms/common/server/response/FastJsonResponse:zzwm	Z
    //   4: invokestatic 306	com/google/android/gms/common/internal/Preconditions:checkState	(Z)V
    //   7: new 44	java/util/zip/GZIPInputStream
    //   10: dup
    //   11: new 33	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_0
    //   16: getfield 308	com/google/android/gms/common/server/response/FastJsonResponse:zzwl	[B
    //   19: invokespecial 36	java/io/ByteArrayInputStream:<init>	([B)V
    //   22: invokespecial 47	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_3
    //   26: aload_3
    //   27: astore_2
    //   28: sipush 4096
    //   31: newarray byte
    //   33: astore 4
    //   35: aload_3
    //   36: astore_2
    //   37: new 310	java/io/ByteArrayOutputStream
    //   40: dup
    //   41: invokespecial 311	java/io/ByteArrayOutputStream:<init>	()V
    //   44: astore 5
    //   46: aload_3
    //   47: astore_2
    //   48: aload_3
    //   49: aload 4
    //   51: iconst_0
    //   52: sipush 4096
    //   55: invokevirtual 317	java/io/InputStream:read	([BII)I
    //   58: istore_1
    //   59: iload_1
    //   60: iconst_m1
    //   61: if_icmpeq +37 -> 98
    //   64: aload_3
    //   65: astore_2
    //   66: aload 5
    //   68: aload 4
    //   70: iconst_0
    //   71: iload_1
    //   72: invokevirtual 321	java/io/ByteArrayOutputStream:write	([BII)V
    //   75: goto -29 -> 46
    //   78: astore_2
    //   79: aload_3
    //   80: astore_2
    //   81: aload_0
    //   82: getfield 308	com/google/android/gms/common/server/response/FastJsonResponse:zzwl	[B
    //   85: astore 4
    //   87: aload_3
    //   88: ifnull +7 -> 95
    //   91: aload_3
    //   92: invokevirtual 324	java/io/InputStream:close	()V
    //   95: aload 4
    //   97: areturn
    //   98: aload_3
    //   99: astore_2
    //   100: aload 5
    //   102: invokevirtual 327	java/io/ByteArrayOutputStream:flush	()V
    //   105: aload_3
    //   106: astore_2
    //   107: aload 5
    //   109: invokevirtual 330	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   112: astore 4
    //   114: aload_3
    //   115: invokevirtual 324	java/io/InputStream:close	()V
    //   118: aload 4
    //   120: areturn
    //   121: astore_2
    //   122: aload 4
    //   124: areturn
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_3
    //   128: aload_3
    //   129: ifnull +7 -> 136
    //   132: aload_3
    //   133: invokevirtual 324	java/io/InputStream:close	()V
    //   136: aload_2
    //   137: athrow
    //   138: astore_2
    //   139: aload 4
    //   141: areturn
    //   142: astore_3
    //   143: goto -7 -> 136
    //   146: astore_3
    //   147: aload_2
    //   148: astore 4
    //   150: aload_3
    //   151: astore_2
    //   152: aload 4
    //   154: astore_3
    //   155: goto -27 -> 128
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_3
    //   161: goto -82 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	FastJsonResponse
    //   58	14	1	i	int
    //   27	39	2	localGZIPInputStream1	GZIPInputStream
    //   78	1	2	localIOException1	IOException
    //   80	27	2	localGZIPInputStream2	GZIPInputStream
    //   121	1	2	localIOException2	IOException
    //   125	12	2	localObject1	Object
    //   138	10	2	localIOException3	IOException
    //   151	1	2	localObject2	Object
    //   158	1	2	localIOException4	IOException
    //   25	108	3	localGZIPInputStream3	GZIPInputStream
    //   142	1	3	localIOException5	IOException
    //   146	5	3	localObject3	Object
    //   154	7	3	localObject4	Object
    //   33	120	4	localObject5	Object
    //   44	64	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   28	35	78	java/io/IOException
    //   37	46	78	java/io/IOException
    //   48	59	78	java/io/IOException
    //   66	75	78	java/io/IOException
    //   100	105	78	java/io/IOException
    //   107	114	78	java/io/IOException
    //   114	118	121	java/io/IOException
    //   7	26	125	finally
    //   91	95	138	java/io/IOException
    //   132	136	142	java/io/IOException
    //   28	35	146	finally
    //   37	46	146	finally
    //   48	59	146	finally
    //   66	75	146	finally
    //   81	87	146	finally
    //   100	105	146	finally
    //   107	114	146	finally
    //   7	26	158	java/io/IOException
  }
  
  public int getResponseCode()
  {
    Preconditions.checkState(this.zzwm);
    return this.zzwk;
  }
  
  protected abstract Object getValueObject(String paramString);
  
  protected boolean isConcreteTypeArrayFieldSet(String paramString)
  {
    throw new UnsupportedOperationException("Concrete type arrays not supported");
  }
  
  protected boolean isConcreteTypeFieldSet(String paramString)
  {
    throw new UnsupportedOperationException("Concrete types not supported");
  }
  
  protected boolean isFieldSet(Field paramField)
  {
    if (paramField.getTypeOut() == 11)
    {
      if (paramField.isTypeOutArray()) {
        return isConcreteTypeArrayFieldSet(paramField.getOutputFieldName());
      }
      return isConcreteTypeFieldSet(paramField.getOutputFieldName());
    }
    return isPrimitiveFieldSet(paramField.getOutputFieldName());
  }
  
  protected abstract boolean isPrimitiveFieldSet(String paramString);
  
  /* Error */
  public <T extends FastJsonResponse> void parseNetworkResponse(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: putfield 333	com/google/android/gms/common/server/response/FastJsonResponse:zzwk	I
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 308	com/google/android/gms/common/server/response/FastJsonResponse:zzwl	[B
    //   10: aload_0
    //   11: iconst_1
    //   12: putfield 303	com/google/android/gms/common/server/response/FastJsonResponse:zzwm	Z
    //   15: aload_2
    //   16: invokestatic 353	com/google/android/gms/common/server/response/FastJsonResponse:getUnzippedStream	([B)Ljava/io/InputStream;
    //   19: astore_3
    //   20: new 355	com/google/android/gms/common/server/response/FastParser
    //   23: dup
    //   24: invokespecial 356	com/google/android/gms/common/server/response/FastParser:<init>	()V
    //   27: aload_3
    //   28: aload_0
    //   29: invokevirtual 360	com/google/android/gms/common/server/response/FastParser:parse	(Ljava/io/InputStream;Lcom/google/android/gms/common/server/response/FastJsonResponse;)V
    //   32: aload_3
    //   33: invokevirtual 324	java/io/InputStream:close	()V
    //   36: return
    //   37: astore_2
    //   38: aload_3
    //   39: invokevirtual 324	java/io/InputStream:close	()V
    //   42: aload_2
    //   43: athrow
    //   44: astore_2
    //   45: return
    //   46: astore_3
    //   47: goto -5 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	FastJsonResponse
    //   0	50	1	paramInt	int
    //   0	50	2	paramArrayOfByte	byte[]
    //   19	20	3	localInputStream	InputStream
    //   46	1	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   20	32	37	finally
    //   32	36	44	java/io/IOException
    //   38	42	46	java/io/IOException
  }
  
  public final <O> void setBigDecimal(Field<BigDecimal, O> paramField, BigDecimal paramBigDecimal)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, paramBigDecimal);
      return;
    }
    setBigDecimalInternal(paramField, paramField.getOutputFieldName(), paramBigDecimal);
  }
  
  protected void setBigDecimal(String paramString, BigDecimal paramBigDecimal)
  {
    throw new UnsupportedOperationException("BigDecimal not supported");
  }
  
  protected void setBigDecimalInternal(Field<?, ?> paramField, String paramString, BigDecimal paramBigDecimal)
  {
    setBigDecimal(paramString, paramBigDecimal);
  }
  
  public final <O> void setBigDecimals(Field<ArrayList<BigDecimal>, O> paramField, ArrayList<BigDecimal> paramArrayList)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, paramArrayList);
      return;
    }
    setBigDecimalsInternal(paramField, paramField.getOutputFieldName(), paramArrayList);
  }
  
  protected void setBigDecimals(String paramString, ArrayList<BigDecimal> paramArrayList)
  {
    throw new UnsupportedOperationException("BigDecimal list not supported");
  }
  
  protected void setBigDecimalsInternal(Field<?, ?> paramField, String paramString, ArrayList<BigDecimal> paramArrayList)
  {
    setBigDecimals(paramString, paramArrayList);
  }
  
  public final <O> void setBigInteger(Field<BigInteger, O> paramField, BigInteger paramBigInteger)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, paramBigInteger);
      return;
    }
    setBigIntegerInternal(paramField, paramField.getOutputFieldName(), paramBigInteger);
  }
  
  protected void setBigInteger(String paramString, BigInteger paramBigInteger)
  {
    throw new UnsupportedOperationException("BigInteger not supported");
  }
  
  protected void setBigIntegerInternal(Field<?, ?> paramField, String paramString, BigInteger paramBigInteger)
  {
    setBigInteger(paramString, paramBigInteger);
  }
  
  public final <O> void setBigIntegers(Field<ArrayList<BigInteger>, O> paramField, ArrayList<BigInteger> paramArrayList)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, paramArrayList);
      return;
    }
    setBigIntegersInternal(paramField, paramField.getOutputFieldName(), paramArrayList);
  }
  
  protected void setBigIntegers(String paramString, ArrayList<BigInteger> paramArrayList)
  {
    throw new UnsupportedOperationException("BigInteger list not supported");
  }
  
  protected void setBigIntegersInternal(Field<?, ?> paramField, String paramString, ArrayList<BigInteger> paramArrayList)
  {
    setBigIntegers(paramString, paramArrayList);
  }
  
  public final <O> void setBoolean(Field<Boolean, O> paramField, boolean paramBoolean)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, Boolean.valueOf(paramBoolean));
      return;
    }
    setBooleanInternal(paramField, paramField.getOutputFieldName(), paramBoolean);
  }
  
  protected void setBoolean(String paramString, boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Boolean not supported");
  }
  
  protected void setBooleanInternal(Field<?, ?> paramField, String paramString, boolean paramBoolean)
  {
    setBoolean(paramString, paramBoolean);
  }
  
  public final <O> void setBooleans(Field<ArrayList<Boolean>, O> paramField, ArrayList<Boolean> paramArrayList)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, paramArrayList);
      return;
    }
    setBooleansInternal(paramField, paramField.getOutputFieldName(), paramArrayList);
  }
  
  protected void setBooleans(String paramString, ArrayList<Boolean> paramArrayList)
  {
    throw new UnsupportedOperationException("Boolean list not supported");
  }
  
  protected void setBooleansInternal(Field<?, ?> paramField, String paramString, ArrayList<Boolean> paramArrayList)
  {
    setBooleans(paramString, paramArrayList);
  }
  
  public final <O> void setDecodedBytes(Field<byte[], O> paramField, byte[] paramArrayOfByte)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, paramArrayOfByte);
      return;
    }
    setDecodedBytesInternal(paramField, paramField.getOutputFieldName(), paramArrayOfByte);
  }
  
  protected void setDecodedBytes(String paramString, byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException("byte[] not supported");
  }
  
  protected void setDecodedBytesInternal(Field<?, ?> paramField, String paramString, byte[] paramArrayOfByte)
  {
    setDecodedBytes(paramString, paramArrayOfByte);
  }
  
  public final <O> void setDouble(Field<Double, O> paramField, double paramDouble)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, Double.valueOf(paramDouble));
      return;
    }
    setDoubleInternal(paramField, paramField.getOutputFieldName(), paramDouble);
  }
  
  protected void setDouble(String paramString, double paramDouble)
  {
    throw new UnsupportedOperationException("Double not supported");
  }
  
  protected void setDoubleInternal(Field<?, ?> paramField, String paramString, double paramDouble)
  {
    setDouble(paramString, paramDouble);
  }
  
  public final <O> void setDoubles(Field<ArrayList<Double>, O> paramField, ArrayList<Double> paramArrayList)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, paramArrayList);
      return;
    }
    setDoublesInternal(paramField, paramField.getOutputFieldName(), paramArrayList);
  }
  
  protected void setDoubles(String paramString, ArrayList<Double> paramArrayList)
  {
    throw new UnsupportedOperationException("Double list not supported");
  }
  
  protected void setDoublesInternal(Field<?, ?> paramField, String paramString, ArrayList<Double> paramArrayList)
  {
    setDoubles(paramString, paramArrayList);
  }
  
  public final <O> void setFloat(Field<Float, O> paramField, float paramFloat)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, Float.valueOf(paramFloat));
      return;
    }
    setFloatInternal(paramField, paramField.getOutputFieldName(), paramFloat);
  }
  
  protected void setFloat(String paramString, float paramFloat)
  {
    throw new UnsupportedOperationException("Float not supported");
  }
  
  protected void setFloatInternal(Field<?, ?> paramField, String paramString, float paramFloat)
  {
    setFloat(paramString, paramFloat);
  }
  
  public final <O> void setFloats(Field<ArrayList<Float>, O> paramField, ArrayList<Float> paramArrayList)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, paramArrayList);
      return;
    }
    setFloatsInternal(paramField, paramField.getOutputFieldName(), paramArrayList);
  }
  
  protected void setFloats(String paramString, ArrayList<Float> paramArrayList)
  {
    throw new UnsupportedOperationException("Float list not supported");
  }
  
  protected void setFloatsInternal(Field<?, ?> paramField, String paramString, ArrayList<Float> paramArrayList)
  {
    setFloats(paramString, paramArrayList);
  }
  
  public final <O> void setInteger(Field<Integer, O> paramField, int paramInt)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, Integer.valueOf(paramInt));
      return;
    }
    setIntegerInternal(paramField, paramField.getOutputFieldName(), paramInt);
  }
  
  protected void setInteger(String paramString, int paramInt)
  {
    throw new UnsupportedOperationException("Integer not supported");
  }
  
  protected void setIntegerInternal(Field<?, ?> paramField, String paramString, int paramInt)
  {
    setInteger(paramString, paramInt);
  }
  
  public final <O> void setIntegers(Field<ArrayList<Integer>, O> paramField, ArrayList<Integer> paramArrayList)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, paramArrayList);
      return;
    }
    setIntegersInternal(paramField, paramField.getOutputFieldName(), paramArrayList);
  }
  
  protected void setIntegers(String paramString, ArrayList<Integer> paramArrayList)
  {
    throw new UnsupportedOperationException("Integer list not supported");
  }
  
  protected void setIntegersInternal(Field<?, ?> paramField, String paramString, ArrayList<Integer> paramArrayList)
  {
    setIntegers(paramString, paramArrayList);
  }
  
  public final <O> void setLong(Field<Long, O> paramField, long paramLong)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, Long.valueOf(paramLong));
      return;
    }
    setLongInternal(paramField, paramField.getOutputFieldName(), paramLong);
  }
  
  protected void setLong(String paramString, long paramLong)
  {
    throw new UnsupportedOperationException("Long not supported");
  }
  
  protected void setLongInternal(Field<?, ?> paramField, String paramString, long paramLong)
  {
    setLong(paramString, paramLong);
  }
  
  public final <O> void setLongs(Field<ArrayList<Long>, O> paramField, ArrayList<Long> paramArrayList)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, paramArrayList);
      return;
    }
    setLongsInternal(paramField, paramField.getOutputFieldName(), paramArrayList);
  }
  
  protected void setLongs(String paramString, ArrayList<Long> paramArrayList)
  {
    throw new UnsupportedOperationException("Long list not supported");
  }
  
  protected void setLongsInternal(Field<?, ?> paramField, String paramString, ArrayList<Long> paramArrayList)
  {
    setLongs(paramString, paramArrayList);
  }
  
  public final <O> void setString(Field<String, O> paramField, String paramString)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, paramString);
      return;
    }
    setStringInternal(paramField, paramField.getOutputFieldName(), paramString);
  }
  
  protected void setString(String paramString1, String paramString2)
  {
    throw new UnsupportedOperationException("String not supported");
  }
  
  protected void setStringInternal(Field<?, ?> paramField, String paramString1, String paramString2)
  {
    setString(paramString1, paramString2);
  }
  
  public final <O> void setStringMap(Field<Map<String, String>, O> paramField, Map<String, String> paramMap)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, paramMap);
      return;
    }
    setStringMapInternal(paramField, paramField.getOutputFieldName(), paramMap);
  }
  
  protected void setStringMap(String paramString, Map<String, String> paramMap)
  {
    throw new UnsupportedOperationException("String map not supported");
  }
  
  protected void setStringMapInternal(Field<?, ?> paramField, String paramString, Map<String, String> paramMap)
  {
    setStringMap(paramString, paramMap);
  }
  
  public final <O> void setStrings(Field<ArrayList<String>, O> paramField, ArrayList<String> paramArrayList)
  {
    if (Field.zza(paramField) != null)
    {
      zza(paramField, paramArrayList);
      return;
    }
    setStringsInternal(paramField, paramField.getOutputFieldName(), paramArrayList);
  }
  
  protected void setStrings(String paramString, ArrayList<String> paramArrayList)
  {
    throw new UnsupportedOperationException("String list not supported");
  }
  
  protected void setStringsInternal(Field<?, ?> paramField, String paramString, ArrayList<String> paramArrayList)
  {
    setStrings(paramString, paramArrayList);
  }
  
  public String toString()
  {
    Map localMap = getFieldMappings();
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Field localField = (Field)localMap.get(localObject1);
      if (isFieldSet(localField))
      {
        Object localObject2 = getOriginalValue(localField, getFieldValue(localField));
        if (localStringBuilder.length() == 0) {
          localStringBuilder.append("{");
        }
        for (;;)
        {
          localStringBuilder.append("\"").append((String)localObject1).append("\":");
          if (localObject2 != null) {
            break label152;
          }
          localStringBuilder.append("null");
          break;
          localStringBuilder.append(",");
        }
        label152:
        int i;
        int j;
        switch (localField.getTypeOut())
        {
        default: 
          if (localField.isTypeInArray())
          {
            localObject1 = (ArrayList)localObject2;
            localStringBuilder.append("[");
            i = 0;
            j = ((ArrayList)localObject1).size();
          }
          break;
        case 8: 
        case 9: 
        case 10: 
          for (;;)
          {
            if (i < j)
            {
              if (i > 0) {
                localStringBuilder.append(",");
              }
              localObject2 = ((ArrayList)localObject1).get(i);
              if (localObject2 != null) {
                zza(localStringBuilder, localField, localObject2);
              }
              i += 1;
              continue;
              localStringBuilder.append("\"").append(Base64Utils.encode((byte[])localObject2)).append("\"");
              break;
              localStringBuilder.append("\"").append(Base64Utils.encodeUrlSafe((byte[])localObject2)).append("\"");
              break;
              MapUtils.writeStringMapToJson(localStringBuilder, (HashMap)localObject2);
              break;
            }
          }
          localStringBuilder.append("]");
          break;
        }
        zza(localStringBuilder, localField, localObject2);
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append("}");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("{}");
    }
  }
  
  @SafeParcelable.Class(creator="FieldCreator")
  @VisibleForTesting
  public static class Field<I, O>
    extends AbstractSafeParcelable
  {
    public static final FieldCreator CREATOR;
    protected final Class<? extends FastJsonResponse> mConcreteType;
    @SafeParcelable.Field(getter="getConcreteTypeName", id=8)
    protected final String mConcreteTypeName;
    @SafeParcelable.Field(getter="getOutputFieldName", id=6)
    protected final String mOutputFieldName;
    @SafeParcelable.Field(getter="getSafeParcelableFieldId", id=7)
    protected final int mSafeParcelableFieldId;
    @SafeParcelable.Field(getter="getTypeIn", id=2)
    protected final int mTypeIn;
    @SafeParcelable.Field(getter="isTypeInArray", id=3)
    protected final boolean mTypeInArray;
    @SafeParcelable.Field(getter="getTypeOut", id=4)
    protected final int mTypeOut;
    @SafeParcelable.Field(getter="isTypeOutArray", id=5)
    protected final boolean mTypeOutArray;
    @SafeParcelable.VersionField(getter="getVersionCode", id=1)
    private final int zzal;
    private FieldMappingDictionary zzwn;
    @SafeParcelable.Field(getter="getWrappedConverter", id=9, type="com.google.android.gms.common.server.converter.ConverterWrapper")
    private FastJsonResponse.FieldConverter<I, O> zzwo;
    
    static
    {
      AppMethodBeat.i(12013);
      CREATOR = new FieldCreator();
      AppMethodBeat.o(12013);
    }
    
    @SafeParcelable.Constructor
    Field(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) boolean paramBoolean1, @SafeParcelable.Param(id=4) int paramInt3, @SafeParcelable.Param(id=5) boolean paramBoolean2, @SafeParcelable.Param(id=6) String paramString1, @SafeParcelable.Param(id=7) int paramInt4, @SafeParcelable.Param(id=8) String paramString2, @SafeParcelable.Param(id=9) ConverterWrapper paramConverterWrapper)
    {
      AppMethodBeat.i(11957);
      this.zzal = paramInt1;
      this.mTypeIn = paramInt2;
      this.mTypeInArray = paramBoolean1;
      this.mTypeOut = paramInt3;
      this.mTypeOutArray = paramBoolean2;
      this.mOutputFieldName = paramString1;
      this.mSafeParcelableFieldId = paramInt4;
      if (paramString2 == null) {
        this.mConcreteType = null;
      }
      for (this.mConcreteTypeName = null; paramConverterWrapper == null; this.mConcreteTypeName = paramString2)
      {
        this.zzwo = null;
        AppMethodBeat.o(11957);
        return;
        this.mConcreteType = SafeParcelResponse.class;
      }
      this.zzwo = paramConverterWrapper.unwrap();
      AppMethodBeat.o(11957);
    }
    
    protected Field(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class<? extends FastJsonResponse> paramClass, FastJsonResponse.FieldConverter<I, O> paramFieldConverter)
    {
      AppMethodBeat.i(11958);
      this.zzal = 1;
      this.mTypeIn = paramInt1;
      this.mTypeInArray = paramBoolean1;
      this.mTypeOut = paramInt2;
      this.mTypeOutArray = paramBoolean2;
      this.mOutputFieldName = paramString;
      this.mSafeParcelableFieldId = paramInt3;
      this.mConcreteType = paramClass;
      if (paramClass == null) {}
      for (this.mConcreteTypeName = null;; this.mConcreteTypeName = paramClass.getCanonicalName())
      {
        this.zzwo = paramFieldConverter;
        AppMethodBeat.o(11958);
        return;
      }
    }
    
    public static Field<byte[], byte[]> forBase64(String paramString)
    {
      AppMethodBeat.i(12005);
      paramString = new Field(8, false, 8, false, paramString, -1, null, null);
      AppMethodBeat.o(12005);
      return paramString;
    }
    
    @VisibleForTesting
    public static Field<byte[], byte[]> forBase64(String paramString, int paramInt)
    {
      AppMethodBeat.i(11981);
      paramString = new Field(8, false, 8, false, paramString, paramInt, null, null);
      AppMethodBeat.o(11981);
      return paramString;
    }
    
    @VisibleForTesting
    public static Field<byte[], byte[]> forBase64UrlSafe(String paramString)
    {
      AppMethodBeat.i(12006);
      paramString = new Field(9, false, 9, false, paramString, -1, null, null);
      AppMethodBeat.o(12006);
      return paramString;
    }
    
    @VisibleForTesting
    public static Field<byte[], byte[]> forBase64UrlSafe(String paramString, int paramInt)
    {
      AppMethodBeat.i(11982);
      paramString = new Field(9, false, 9, false, paramString, paramInt, null, null);
      AppMethodBeat.o(11982);
      return paramString;
    }
    
    public static Field<BigDecimal, BigDecimal> forBigDecimal(String paramString)
    {
      AppMethodBeat.i(11999);
      paramString = new Field(5, false, 5, false, paramString, -1, null, null);
      AppMethodBeat.o(11999);
      return paramString;
    }
    
    @VisibleForTesting
    public static Field<BigDecimal, BigDecimal> forBigDecimal(String paramString, int paramInt)
    {
      AppMethodBeat.i(11975);
      paramString = new Field(5, false, 5, false, paramString, paramInt, null, null);
      AppMethodBeat.o(11975);
      return paramString;
    }
    
    public static Field<ArrayList<BigDecimal>, ArrayList<BigDecimal>> forBigDecimals(String paramString)
    {
      AppMethodBeat.i(12000);
      paramString = new Field(5, true, 5, true, paramString, -1, null, null);
      AppMethodBeat.o(12000);
      return paramString;
    }
    
    public static Field<ArrayList<BigDecimal>, ArrayList<BigDecimal>> forBigDecimals(String paramString, int paramInt)
    {
      AppMethodBeat.i(11976);
      paramString = new Field(5, true, 5, true, paramString, paramInt, null, null);
      AppMethodBeat.o(11976);
      return paramString;
    }
    
    public static Field<BigInteger, BigInteger> forBigInteger(String paramString)
    {
      AppMethodBeat.i(11991);
      paramString = new Field(1, false, 1, false, paramString, -1, null, null);
      AppMethodBeat.o(11991);
      return paramString;
    }
    
    public static Field<BigInteger, BigInteger> forBigInteger(String paramString, int paramInt)
    {
      AppMethodBeat.i(11967);
      paramString = new Field(1, false, 1, false, paramString, paramInt, null, null);
      AppMethodBeat.o(11967);
      return paramString;
    }
    
    public static Field<ArrayList<BigInteger>, ArrayList<BigInteger>> forBigIntegers(String paramString)
    {
      AppMethodBeat.i(11992);
      paramString = new Field(0, true, 1, true, paramString, -1, null, null);
      AppMethodBeat.o(11992);
      return paramString;
    }
    
    public static Field<ArrayList<BigInteger>, ArrayList<BigInteger>> forBigIntegers(String paramString, int paramInt)
    {
      AppMethodBeat.i(11968);
      paramString = new Field(0, true, 1, true, paramString, paramInt, null, null);
      AppMethodBeat.o(11968);
      return paramString;
    }
    
    public static Field<Boolean, Boolean> forBoolean(String paramString)
    {
      AppMethodBeat.i(12001);
      paramString = new Field(6, false, 6, false, paramString, -1, null, null);
      AppMethodBeat.o(12001);
      return paramString;
    }
    
    public static Field<Boolean, Boolean> forBoolean(String paramString, int paramInt)
    {
      AppMethodBeat.i(11977);
      paramString = new Field(6, false, 6, false, paramString, paramInt, null, null);
      AppMethodBeat.o(11977);
      return paramString;
    }
    
    public static Field<ArrayList<Boolean>, ArrayList<Boolean>> forBooleans(String paramString)
    {
      AppMethodBeat.i(12002);
      paramString = new Field(6, true, 6, true, paramString, -1, null, null);
      AppMethodBeat.o(12002);
      return paramString;
    }
    
    public static Field<ArrayList<Boolean>, ArrayList<Boolean>> forBooleans(String paramString, int paramInt)
    {
      AppMethodBeat.i(11978);
      paramString = new Field(6, true, 6, true, paramString, paramInt, null, null);
      AppMethodBeat.o(11978);
      return paramString;
    }
    
    public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String paramString, int paramInt, Class<T> paramClass)
    {
      AppMethodBeat.i(11984);
      paramString = new Field(11, false, 11, false, paramString, paramInt, paramClass, null);
      AppMethodBeat.o(11984);
      return paramString;
    }
    
    public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String paramString, Class<T> paramClass)
    {
      AppMethodBeat.i(12008);
      paramString = new Field(11, false, 11, false, paramString, -1, paramClass, null);
      AppMethodBeat.o(12008);
      return paramString;
    }
    
    public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String paramString, int paramInt, Class<T> paramClass)
    {
      AppMethodBeat.i(11985);
      paramString = new Field(11, true, 11, true, paramString, paramInt, paramClass, null);
      AppMethodBeat.o(11985);
      return paramString;
    }
    
    public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String paramString, Class<T> paramClass)
    {
      AppMethodBeat.i(12009);
      paramString = new Field(11, true, 11, true, paramString, -1, paramClass, null);
      AppMethodBeat.o(12009);
      return paramString;
    }
    
    public static Field<Double, Double> forDouble(String paramString)
    {
      AppMethodBeat.i(11997);
      paramString = new Field(4, false, 4, false, paramString, -1, null, null);
      AppMethodBeat.o(11997);
      return paramString;
    }
    
    public static Field<Double, Double> forDouble(String paramString, int paramInt)
    {
      AppMethodBeat.i(11973);
      paramString = new Field(4, false, 4, false, paramString, paramInt, null, null);
      AppMethodBeat.o(11973);
      return paramString;
    }
    
    public static Field<ArrayList<Double>, ArrayList<Double>> forDoubles(String paramString)
    {
      AppMethodBeat.i(11998);
      paramString = new Field(4, true, 4, true, paramString, -1, null, null);
      AppMethodBeat.o(11998);
      return paramString;
    }
    
    public static Field<ArrayList<Double>, ArrayList<Double>> forDoubles(String paramString, int paramInt)
    {
      AppMethodBeat.i(11974);
      paramString = new Field(4, true, 4, true, paramString, paramInt, null, null);
      AppMethodBeat.o(11974);
      return paramString;
    }
    
    public static Field<Float, Float> forFloat(String paramString)
    {
      AppMethodBeat.i(11995);
      paramString = new Field(3, false, 3, false, paramString, -1, null, null);
      AppMethodBeat.o(11995);
      return paramString;
    }
    
    public static Field<Float, Float> forFloat(String paramString, int paramInt)
    {
      AppMethodBeat.i(11971);
      paramString = new Field(3, false, 3, false, paramString, paramInt, null, null);
      AppMethodBeat.o(11971);
      return paramString;
    }
    
    public static Field<ArrayList<Float>, ArrayList<Float>> forFloats(String paramString)
    {
      AppMethodBeat.i(11996);
      paramString = new Field(3, true, 3, true, paramString, -1, null, null);
      AppMethodBeat.o(11996);
      return paramString;
    }
    
    public static Field<ArrayList<Float>, ArrayList<Float>> forFloats(String paramString, int paramInt)
    {
      AppMethodBeat.i(11972);
      paramString = new Field(3, true, 3, true, paramString, paramInt, null, null);
      AppMethodBeat.o(11972);
      return paramString;
    }
    
    public static Field<Integer, Integer> forInteger(String paramString)
    {
      AppMethodBeat.i(11989);
      paramString = new Field(0, false, 0, false, paramString, -1, null, null);
      AppMethodBeat.o(11989);
      return paramString;
    }
    
    @VisibleForTesting
    public static Field<Integer, Integer> forInteger(String paramString, int paramInt)
    {
      AppMethodBeat.i(11965);
      paramString = new Field(0, false, 0, false, paramString, paramInt, null, null);
      AppMethodBeat.o(11965);
      return paramString;
    }
    
    public static Field<ArrayList<Integer>, ArrayList<Integer>> forIntegers(String paramString)
    {
      AppMethodBeat.i(11990);
      paramString = new Field(0, true, 0, true, paramString, -1, null, null);
      AppMethodBeat.o(11990);
      return paramString;
    }
    
    @VisibleForTesting
    public static Field<ArrayList<Integer>, ArrayList<Integer>> forIntegers(String paramString, int paramInt)
    {
      AppMethodBeat.i(11966);
      paramString = new Field(0, true, 0, true, paramString, paramInt, null, null);
      AppMethodBeat.o(11966);
      return paramString;
    }
    
    @VisibleForTesting
    public static Field<Long, Long> forLong(String paramString)
    {
      AppMethodBeat.i(11993);
      paramString = new Field(2, false, 2, false, paramString, -1, null, null);
      AppMethodBeat.o(11993);
      return paramString;
    }
    
    public static Field<Long, Long> forLong(String paramString, int paramInt)
    {
      AppMethodBeat.i(11969);
      paramString = new Field(2, false, 2, false, paramString, paramInt, null, null);
      AppMethodBeat.o(11969);
      return paramString;
    }
    
    @VisibleForTesting
    public static Field<ArrayList<Long>, ArrayList<Long>> forLongs(String paramString)
    {
      AppMethodBeat.i(11994);
      paramString = new Field(2, true, 2, true, paramString, -1, null, null);
      AppMethodBeat.o(11994);
      return paramString;
    }
    
    public static Field<ArrayList<Long>, ArrayList<Long>> forLongs(String paramString, int paramInt)
    {
      AppMethodBeat.i(11970);
      paramString = new Field(2, true, 2, true, paramString, paramInt, null, null);
      AppMethodBeat.o(11970);
      return paramString;
    }
    
    public static Field<String, String> forString(String paramString)
    {
      AppMethodBeat.i(12003);
      paramString = new Field(7, false, 7, false, paramString, -1, null, null);
      AppMethodBeat.o(12003);
      return paramString;
    }
    
    public static Field<String, String> forString(String paramString, int paramInt)
    {
      AppMethodBeat.i(11979);
      paramString = new Field(7, false, 7, false, paramString, paramInt, null, null);
      AppMethodBeat.o(11979);
      return paramString;
    }
    
    public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(String paramString)
    {
      AppMethodBeat.i(12007);
      paramString = new Field(10, false, 10, false, paramString, -1, null, null);
      AppMethodBeat.o(12007);
      return paramString;
    }
    
    public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(String paramString, int paramInt)
    {
      AppMethodBeat.i(11983);
      paramString = new Field(10, false, 10, false, paramString, paramInt, null, null);
      AppMethodBeat.o(11983);
      return paramString;
    }
    
    public static Field<ArrayList<String>, ArrayList<String>> forStrings(String paramString)
    {
      AppMethodBeat.i(12004);
      paramString = new Field(7, true, 7, true, paramString, -1, null, null);
      AppMethodBeat.o(12004);
      return paramString;
    }
    
    public static Field<ArrayList<String>, ArrayList<String>> forStrings(String paramString, int paramInt)
    {
      AppMethodBeat.i(11980);
      paramString = new Field(7, true, 7, true, paramString, paramInt, null, null);
      AppMethodBeat.o(11980);
      return paramString;
    }
    
    public static Field withConverter(String paramString, int paramInt, FastJsonResponse.FieldConverter<?, ?> paramFieldConverter, boolean paramBoolean)
    {
      AppMethodBeat.i(11988);
      paramString = new Field(paramFieldConverter.getTypeIn(), paramBoolean, paramFieldConverter.getTypeOut(), false, paramString, paramInt, null, paramFieldConverter);
      AppMethodBeat.o(11988);
      return paramString;
    }
    
    public static <T extends FastJsonResponse.FieldConverter> Field withConverter(String paramString, int paramInt, Class<T> paramClass, boolean paramBoolean)
    {
      AppMethodBeat.i(11986);
      try
      {
        paramString = withConverter(paramString, paramInt, (FastJsonResponse.FieldConverter)paramClass.newInstance(), paramBoolean);
        AppMethodBeat.o(11986);
        return paramString;
      }
      catch (InstantiationException paramString)
      {
        paramString = new RuntimeException(paramString);
        AppMethodBeat.o(11986);
        throw paramString;
      }
      catch (IllegalAccessException paramString)
      {
        paramString = new RuntimeException(paramString);
        AppMethodBeat.o(11986);
        throw paramString;
      }
    }
    
    public static Field withConverter(String paramString, FastJsonResponse.FieldConverter<?, ?> paramFieldConverter, boolean paramBoolean)
    {
      AppMethodBeat.i(11987);
      paramString = withConverter(paramString, -1, paramFieldConverter, paramBoolean);
      AppMethodBeat.o(11987);
      return paramString;
    }
    
    public static <T extends FastJsonResponse.FieldConverter> Field withConverter(String paramString, Class<T> paramClass, boolean paramBoolean)
    {
      AppMethodBeat.i(12010);
      paramString = withConverter(paramString, -1, paramClass, paramBoolean);
      AppMethodBeat.o(12010);
      return paramString;
    }
    
    private final String zzcz()
    {
      if (this.mConcreteTypeName == null) {
        return null;
      }
      return this.mConcreteTypeName;
    }
    
    private final ConverterWrapper zzda()
    {
      AppMethodBeat.i(11960);
      if (this.zzwo == null)
      {
        AppMethodBeat.o(11960);
        return null;
      }
      ConverterWrapper localConverterWrapper = ConverterWrapper.wrap(this.zzwo);
      AppMethodBeat.o(11960);
      return localConverterWrapper;
    }
    
    public O convert(I paramI)
    {
      AppMethodBeat.i(11963);
      paramI = this.zzwo.convert(paramI);
      AppMethodBeat.o(11963);
      return paramI;
    }
    
    public I convertBack(O paramO)
    {
      AppMethodBeat.i(11964);
      paramO = this.zzwo.convertBack(paramO);
      AppMethodBeat.o(11964);
      return paramO;
    }
    
    public Field<I, O> copyForDictionary()
    {
      AppMethodBeat.i(11959);
      Field localField = new Field(this.zzal, this.mTypeIn, this.mTypeInArray, this.mTypeOut, this.mTypeOutArray, this.mOutputFieldName, this.mSafeParcelableFieldId, this.mConcreteTypeName, zzda());
      AppMethodBeat.o(11959);
      return localField;
    }
    
    public Class<? extends FastJsonResponse> getConcreteType()
    {
      return this.mConcreteType;
    }
    
    public Map<String, Field<?, ?>> getConcreteTypeFieldMappingFromDictionary()
    {
      AppMethodBeat.i(11962);
      Preconditions.checkNotNull(this.mConcreteTypeName);
      Preconditions.checkNotNull(this.zzwn);
      Map localMap = this.zzwn.getFieldMapping(this.mConcreteTypeName);
      AppMethodBeat.o(11962);
      return localMap;
    }
    
    public String getOutputFieldName()
    {
      return this.mOutputFieldName;
    }
    
    public int getSafeParcelableFieldId()
    {
      return this.mSafeParcelableFieldId;
    }
    
    public int getTypeIn()
    {
      return this.mTypeIn;
    }
    
    public int getTypeOut()
    {
      return this.mTypeOut;
    }
    
    public int getVersionCode()
    {
      return this.zzal;
    }
    
    public boolean hasConverter()
    {
      return this.zzwo != null;
    }
    
    public boolean isTypeInArray()
    {
      return this.mTypeInArray;
    }
    
    public boolean isTypeOutArray()
    {
      return this.mTypeOutArray;
    }
    
    public boolean isValidSafeParcelableFieldId()
    {
      return this.mSafeParcelableFieldId != -1;
    }
    
    public FastJsonResponse newConcreteTypeInstance()
    {
      AppMethodBeat.i(11961);
      if (this.mConcreteType == SafeParcelResponse.class)
      {
        Preconditions.checkNotNull(this.zzwn, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
        localObject = new SafeParcelResponse(this.zzwn, this.mConcreteTypeName);
        AppMethodBeat.o(11961);
        return localObject;
      }
      Object localObject = (FastJsonResponse)this.mConcreteType.newInstance();
      AppMethodBeat.o(11961);
      return localObject;
    }
    
    public void setFieldMappingDictionary(FieldMappingDictionary paramFieldMappingDictionary)
    {
      this.zzwn = paramFieldMappingDictionary;
    }
    
    public String toString()
    {
      AppMethodBeat.i(12012);
      Object localObject = Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.zzal)).add("typeIn", Integer.valueOf(this.mTypeIn)).add("typeInArray", Boolean.valueOf(this.mTypeInArray)).add("typeOut", Integer.valueOf(this.mTypeOut)).add("typeOutArray", Boolean.valueOf(this.mTypeOutArray)).add("outputFieldName", this.mOutputFieldName).add("safeParcelFieldId", Integer.valueOf(this.mSafeParcelableFieldId)).add("concreteTypeName", zzcz());
      Class localClass = getConcreteType();
      if (localClass != null) {
        ((Objects.ToStringHelper)localObject).add("concreteType.class", localClass.getCanonicalName());
      }
      if (this.zzwo != null) {
        ((Objects.ToStringHelper)localObject).add("converterName", this.zzwo.getClass().getCanonicalName());
      }
      localObject = ((Objects.ToStringHelper)localObject).toString();
      AppMethodBeat.o(12012);
      return localObject;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(12011);
      int i = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeInt(paramParcel, 1, getVersionCode());
      SafeParcelWriter.writeInt(paramParcel, 2, getTypeIn());
      SafeParcelWriter.writeBoolean(paramParcel, 3, isTypeInArray());
      SafeParcelWriter.writeInt(paramParcel, 4, getTypeOut());
      SafeParcelWriter.writeBoolean(paramParcel, 5, isTypeOutArray());
      SafeParcelWriter.writeString(paramParcel, 6, getOutputFieldName(), false);
      SafeParcelWriter.writeInt(paramParcel, 7, getSafeParcelableFieldId());
      SafeParcelWriter.writeString(paramParcel, 8, zzcz(), false);
      SafeParcelWriter.writeParcelable(paramParcel, 9, zzda(), paramInt, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      AppMethodBeat.o(12011);
    }
  }
  
  public static abstract interface FieldConverter<I, O>
  {
    public abstract O convert(I paramI);
    
    public abstract I convertBack(O paramO);
    
    public abstract int getTypeIn();
    
    public abstract int getTypeOut();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FastJsonResponse
 * JD-Core Version:    0.7.0.1
 */