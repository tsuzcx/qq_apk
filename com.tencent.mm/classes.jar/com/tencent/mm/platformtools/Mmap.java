package com.tencent.mm.platformtools;

public class Mmap
{
  private int fileSize = 0;
  private String gjO = "";
  
  private static native int close(long paramLong);
  
  private static native long open(String paramString, int paramInt);
  
  private static native int read(long paramLong, int paramInt1, int paramInt2, Object paramObject);
  
  private static native int sync(long paramLong, int paramInt);
  
  private static native int write(long paramLong, int paramInt1, int paramInt2, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.Mmap
 * JD-Core Version:    0.7.0.1
 */