package com.google.android.gms.internal;

import java.util.Map;

public class zzj
{
  public final byte[] data;
  public final int statusCode;
  public final boolean zzA;
  public final long zzB;
  public final Map<String, String> zzz;
  
  public zzj(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    this.statusCode = paramInt;
    this.data = paramArrayOfByte;
    this.zzz = paramMap;
    this.zzA = paramBoolean;
    this.zzB = paramLong;
  }
  
  public zzj(byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this(200, paramArrayOfByte, paramMap, false, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzj
 * JD-Core Version:    0.7.0.1
 */