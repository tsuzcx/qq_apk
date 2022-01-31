package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
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
  
  private final <I, O> void zza(FastJsonResponse.Field<I, O> paramField, I paramI)
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
  
  private static void zza(StringBuilder paramStringBuilder, FastJsonResponse.Field paramField, Object paramObject)
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
  
  public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<T> paramArrayList)
  {
    addConcreteTypeArray(paramString, paramArrayList);
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, T paramT)
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
  
  public abstract Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings();
  
  protected Object getFieldValue(FastJsonResponse.Field paramField)
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
  
  protected <O, I> I getOriginalValue(FastJsonResponse.Field<I, O> paramField, Object paramObject)
  {
    Object localObject = paramObject;
    if (FastJsonResponse.Field.zza(paramField) != null) {
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
    //   1: getfield 302	com/google/android/gms/common/server/response/FastJsonResponse:zzwm	Z
    //   4: invokestatic 305	com/google/android/gms/common/internal/Preconditions:checkState	(Z)V
    //   7: new 43	java/util/zip/GZIPInputStream
    //   10: dup
    //   11: new 32	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_0
    //   16: getfield 307	com/google/android/gms/common/server/response/FastJsonResponse:zzwl	[B
    //   19: invokespecial 35	java/io/ByteArrayInputStream:<init>	([B)V
    //   22: invokespecial 46	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_3
    //   26: aload_3
    //   27: astore_2
    //   28: sipush 4096
    //   31: newarray byte
    //   33: astore 4
    //   35: aload_3
    //   36: astore_2
    //   37: new 309	java/io/ByteArrayOutputStream
    //   40: dup
    //   41: invokespecial 310	java/io/ByteArrayOutputStream:<init>	()V
    //   44: astore 5
    //   46: aload_3
    //   47: astore_2
    //   48: aload_3
    //   49: aload 4
    //   51: iconst_0
    //   52: sipush 4096
    //   55: invokevirtual 316	java/io/InputStream:read	([BII)I
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
    //   72: invokevirtual 320	java/io/ByteArrayOutputStream:write	([BII)V
    //   75: goto -29 -> 46
    //   78: astore_2
    //   79: aload_3
    //   80: astore_2
    //   81: aload_0
    //   82: getfield 307	com/google/android/gms/common/server/response/FastJsonResponse:zzwl	[B
    //   85: astore 4
    //   87: aload_3
    //   88: ifnull +7 -> 95
    //   91: aload_3
    //   92: invokevirtual 323	java/io/InputStream:close	()V
    //   95: aload 4
    //   97: areturn
    //   98: aload_3
    //   99: astore_2
    //   100: aload 5
    //   102: invokevirtual 326	java/io/ByteArrayOutputStream:flush	()V
    //   105: aload_3
    //   106: astore_2
    //   107: aload 5
    //   109: invokevirtual 329	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   112: astore 4
    //   114: aload_3
    //   115: invokevirtual 323	java/io/InputStream:close	()V
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
    //   133: invokevirtual 323	java/io/InputStream:close	()V
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
  
  protected boolean isFieldSet(FastJsonResponse.Field paramField)
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
    //   2: putfield 332	com/google/android/gms/common/server/response/FastJsonResponse:zzwk	I
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 307	com/google/android/gms/common/server/response/FastJsonResponse:zzwl	[B
    //   10: aload_0
    //   11: iconst_1
    //   12: putfield 302	com/google/android/gms/common/server/response/FastJsonResponse:zzwm	Z
    //   15: aload_2
    //   16: invokestatic 352	com/google/android/gms/common/server/response/FastJsonResponse:getUnzippedStream	([B)Ljava/io/InputStream;
    //   19: astore_3
    //   20: new 354	com/google/android/gms/common/server/response/FastParser
    //   23: dup
    //   24: invokespecial 355	com/google/android/gms/common/server/response/FastParser:<init>	()V
    //   27: aload_3
    //   28: aload_0
    //   29: invokevirtual 359	com/google/android/gms/common/server/response/FastParser:parse	(Ljava/io/InputStream;Lcom/google/android/gms/common/server/response/FastJsonResponse;)V
    //   32: aload_3
    //   33: invokevirtual 323	java/io/InputStream:close	()V
    //   36: return
    //   37: astore_2
    //   38: aload_3
    //   39: invokevirtual 323	java/io/InputStream:close	()V
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
  
  public final <O> void setBigDecimal(FastJsonResponse.Field<BigDecimal, O> paramField, BigDecimal paramBigDecimal)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setBigDecimalInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, BigDecimal paramBigDecimal)
  {
    setBigDecimal(paramString, paramBigDecimal);
  }
  
  public final <O> void setBigDecimals(FastJsonResponse.Field<ArrayList<BigDecimal>, O> paramField, ArrayList<BigDecimal> paramArrayList)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setBigDecimalsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigDecimal> paramArrayList)
  {
    setBigDecimals(paramString, paramArrayList);
  }
  
  public final <O> void setBigInteger(FastJsonResponse.Field<BigInteger, O> paramField, BigInteger paramBigInteger)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setBigIntegerInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, BigInteger paramBigInteger)
  {
    setBigInteger(paramString, paramBigInteger);
  }
  
  public final <O> void setBigIntegers(FastJsonResponse.Field<ArrayList<BigInteger>, O> paramField, ArrayList<BigInteger> paramArrayList)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setBigIntegersInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigInteger> paramArrayList)
  {
    setBigIntegers(paramString, paramArrayList);
  }
  
  public final <O> void setBoolean(FastJsonResponse.Field<Boolean, O> paramField, boolean paramBoolean)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setBooleanInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, boolean paramBoolean)
  {
    setBoolean(paramString, paramBoolean);
  }
  
  public final <O> void setBooleans(FastJsonResponse.Field<ArrayList<Boolean>, O> paramField, ArrayList<Boolean> paramArrayList)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setBooleansInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Boolean> paramArrayList)
  {
    setBooleans(paramString, paramArrayList);
  }
  
  public final <O> void setDecodedBytes(FastJsonResponse.Field<byte[], O> paramField, byte[] paramArrayOfByte)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, byte[] paramArrayOfByte)
  {
    setDecodedBytes(paramString, paramArrayOfByte);
  }
  
  public final <O> void setDouble(FastJsonResponse.Field<Double, O> paramField, double paramDouble)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setDoubleInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, double paramDouble)
  {
    setDouble(paramString, paramDouble);
  }
  
  public final <O> void setDoubles(FastJsonResponse.Field<ArrayList<Double>, O> paramField, ArrayList<Double> paramArrayList)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setDoublesInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Double> paramArrayList)
  {
    setDoubles(paramString, paramArrayList);
  }
  
  public final <O> void setFloat(FastJsonResponse.Field<Float, O> paramField, float paramFloat)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setFloatInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, float paramFloat)
  {
    setFloat(paramString, paramFloat);
  }
  
  public final <O> void setFloats(FastJsonResponse.Field<ArrayList<Float>, O> paramField, ArrayList<Float> paramArrayList)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setFloatsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Float> paramArrayList)
  {
    setFloats(paramString, paramArrayList);
  }
  
  public final <O> void setInteger(FastJsonResponse.Field<Integer, O> paramField, int paramInt)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setIntegerInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, int paramInt)
  {
    setInteger(paramString, paramInt);
  }
  
  public final <O> void setIntegers(FastJsonResponse.Field<ArrayList<Integer>, O> paramField, ArrayList<Integer> paramArrayList)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setIntegersInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Integer> paramArrayList)
  {
    setIntegers(paramString, paramArrayList);
  }
  
  public final <O> void setLong(FastJsonResponse.Field<Long, O> paramField, long paramLong)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setLongInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, long paramLong)
  {
    setLong(paramString, paramLong);
  }
  
  public final <O> void setLongs(FastJsonResponse.Field<ArrayList<Long>, O> paramField, ArrayList<Long> paramArrayList)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setLongsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Long> paramArrayList)
  {
    setLongs(paramString, paramArrayList);
  }
  
  public final <O> void setString(FastJsonResponse.Field<String, O> paramField, String paramString)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setStringInternal(FastJsonResponse.Field<?, ?> paramField, String paramString1, String paramString2)
  {
    setString(paramString1, paramString2);
  }
  
  public final <O> void setStringMap(FastJsonResponse.Field<Map<String, String>, O> paramField, Map<String, String> paramMap)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setStringMapInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, Map<String, String> paramMap)
  {
    setStringMap(paramString, paramMap);
  }
  
  public final <O> void setStrings(FastJsonResponse.Field<ArrayList<String>, O> paramField, ArrayList<String> paramArrayList)
  {
    if (FastJsonResponse.Field.zza(paramField) != null)
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
  
  protected void setStringsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<String> paramArrayList)
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
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localMap.get(localObject1);
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
  
  public static abstract interface FieldConverter<I, O>
  {
    public abstract O convert(I paramI);
    
    public abstract I convertBack(O paramO);
    
    public abstract int getTypeIn();
    
    public abstract int getTypeOut();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FastJsonResponse
 * JD-Core Version:    0.7.0.1
 */