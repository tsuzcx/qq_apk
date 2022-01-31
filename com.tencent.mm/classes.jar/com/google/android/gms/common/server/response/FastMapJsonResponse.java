package com.google.android.gms.common.server.response;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastMapJsonResponse
  extends FastJsonResponse
{
  private final HashMap<String, Object> zzwp = new HashMap();
  
  public Object getValueObject(String paramString)
  {
    return this.zzwp.get(paramString);
  }
  
  public HashMap<String, Object> getValues()
  {
    return this.zzwp;
  }
  
  protected boolean isPrimitiveFieldSet(String paramString)
  {
    return this.zzwp.containsKey(paramString);
  }
  
  public void setBigDecimal(String paramString, BigDecimal paramBigDecimal)
  {
    this.zzwp.put(paramString, paramBigDecimal);
  }
  
  public void setBigDecimals(String paramString, ArrayList<BigDecimal> paramArrayList)
  {
    this.zzwp.put(paramString, paramArrayList);
  }
  
  public void setBigInteger(String paramString, BigInteger paramBigInteger)
  {
    this.zzwp.put(paramString, paramBigInteger);
  }
  
  public void setBigIntegers(String paramString, ArrayList<BigInteger> paramArrayList)
  {
    this.zzwp.put(paramString, paramArrayList);
  }
  
  public void setBoolean(String paramString, boolean paramBoolean)
  {
    this.zzwp.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public void setBooleans(String paramString, ArrayList<Boolean> paramArrayList)
  {
    this.zzwp.put(paramString, paramArrayList);
  }
  
  public void setDecodedBytes(String paramString, byte[] paramArrayOfByte)
  {
    this.zzwp.put(paramString, paramArrayOfByte);
  }
  
  public void setDouble(String paramString, double paramDouble)
  {
    this.zzwp.put(paramString, Double.valueOf(paramDouble));
  }
  
  public void setDoubles(String paramString, ArrayList<Double> paramArrayList)
  {
    this.zzwp.put(paramString, paramArrayList);
  }
  
  protected void setFloat(String paramString, float paramFloat)
  {
    this.zzwp.put(paramString, Float.valueOf(paramFloat));
  }
  
  protected void setFloats(String paramString, ArrayList<Float> paramArrayList)
  {
    this.zzwp.put(paramString, paramArrayList);
  }
  
  public void setInteger(String paramString, int paramInt)
  {
    this.zzwp.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void setIntegers(String paramString, ArrayList<Integer> paramArrayList)
  {
    this.zzwp.put(paramString, paramArrayList);
  }
  
  public void setLong(String paramString, long paramLong)
  {
    this.zzwp.put(paramString, Long.valueOf(paramLong));
  }
  
  public void setLongs(String paramString, ArrayList<Long> paramArrayList)
  {
    this.zzwp.put(paramString, paramArrayList);
  }
  
  public void setString(String paramString1, String paramString2)
  {
    this.zzwp.put(paramString1, paramString2);
  }
  
  public void setStringMap(String paramString, Map<String, String> paramMap)
  {
    this.zzwp.put(paramString, paramMap);
  }
  
  public void setStrings(String paramString, ArrayList<String> paramArrayList)
  {
    this.zzwp.put(paramString, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FastMapJsonResponse
 * JD-Core Version:    0.7.0.1
 */