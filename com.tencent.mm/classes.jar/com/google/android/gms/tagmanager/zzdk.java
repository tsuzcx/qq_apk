package com.google.android.gms.tagmanager;

class zzdk
  extends Number
  implements Comparable<zzdk>
{
  private double zzbID;
  private long zzbIE;
  private boolean zzbIF;
  
  private zzdk(double paramDouble)
  {
    this.zzbID = paramDouble;
    this.zzbIF = false;
  }
  
  private zzdk(long paramLong)
  {
    this.zzbIE = paramLong;
    this.zzbIF = true;
  }
  
  public static zzdk zza(Double paramDouble)
  {
    return new zzdk(paramDouble.doubleValue());
  }
  
  public static zzdk zzaA(long paramLong)
  {
    return new zzdk(paramLong);
  }
  
  public static zzdk zzhv(String paramString)
  {
    try
    {
      zzdk localzzdk1 = new zzdk(Long.parseLong(paramString));
      return localzzdk1;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        zzdk localzzdk2 = new zzdk(Double.parseDouble(paramString));
        return localzzdk2;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        throw new NumberFormatException(String.valueOf(paramString).concat(" is not a valid TypedNumber"));
      }
    }
  }
  
  public byte byteValue()
  {
    return (byte)(int)longValue();
  }
  
  public double doubleValue()
  {
    if (zzRG()) {
      return this.zzbIE;
    }
    return this.zzbID;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof zzdk)) && (zza((zzdk)paramObject) == 0);
  }
  
  public float floatValue()
  {
    return (float)doubleValue();
  }
  
  public int hashCode()
  {
    return new Long(longValue()).hashCode();
  }
  
  public int intValue()
  {
    return zzRI();
  }
  
  public long longValue()
  {
    return zzRH();
  }
  
  public short shortValue()
  {
    return zzRJ();
  }
  
  public String toString()
  {
    if (zzRG()) {
      return Long.toString(this.zzbIE);
    }
    return Double.toString(this.zzbID);
  }
  
  public boolean zzRF()
  {
    return !zzRG();
  }
  
  public boolean zzRG()
  {
    return this.zzbIF;
  }
  
  public long zzRH()
  {
    if (zzRG()) {
      return this.zzbIE;
    }
    return this.zzbID;
  }
  
  public int zzRI()
  {
    return (int)longValue();
  }
  
  public short zzRJ()
  {
    return (short)(int)longValue();
  }
  
  public int zza(zzdk paramzzdk)
  {
    if ((zzRG()) && (paramzzdk.zzRG())) {
      return new Long(this.zzbIE).compareTo(Long.valueOf(paramzzdk.zzbIE));
    }
    return Double.compare(doubleValue(), paramzzdk.doubleValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzdk
 * JD-Core Version:    0.7.0.1
 */