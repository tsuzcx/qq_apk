package com.tencent.imageservice;

import android.util.Log;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PNGReader
{
  private static final int IHDR = 1229472850;
  public static final long SIGNATURE = -8552249625308161526L;
  byte bit_depth;
  byte color_type;
  int height = 0;
  int width = 0;
  
  private int readInt(InputStream paramInputStream)
    throws Exception
  {
    byte[] arrayOfByte = new byte[4];
    paramInputStream.read(arrayOfByte, 0, 4);
    return (arrayOfByte[0] & 0xFF) << 24 | (arrayOfByte[1] & 0xFF) << 16 | (arrayOfByte[2] & 0xFF) << 8 | arrayOfByte[3] & 0xFF;
  }
  
  private int readInt(byte[] paramArrayOfByte, int paramInt)
    throws Exception
  {
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int i = j + 1;
    j = paramArrayOfByte[j];
    int k = i + 1;
    return (paramInt & 0xFF) << 24 | (j & 0xFF) << 16 | (paramArrayOfByte[i] & 0xFF) << 8 | paramArrayOfByte[k] & 0xFF;
  }
  
  private long readLong(InputStream paramInputStream)
    throws Exception
  {
    byte[] arrayOfByte = new byte[8];
    paramInputStream.read(arrayOfByte, 0, 8);
    return (arrayOfByte[0] & 0xFF) << 56 | (arrayOfByte[1] & 0xFF) << 48 | (arrayOfByte[2] & 0xFF) << 40 | (arrayOfByte[3] & 0xFF) << 32 | (arrayOfByte[4] & 0xFF) << 24 | (arrayOfByte[5] & 0xFF) << 16 | (arrayOfByte[6] & 0xFF) << 8 | arrayOfByte[7] & 0xFF;
  }
  
  private boolean read_IHDR(InputStream paramInputStream)
    throws Exception
  {
    if ((readInt(paramInputStream) != 13) || (readInt(paramInputStream) != 1229472850)) {
      return false;
    }
    byte[] arrayOfByte = new byte[13];
    paramInputStream.read(arrayOfByte, 0, 13);
    this.width = readInt(arrayOfByte, 0);
    this.height = readInt(arrayOfByte, 4);
    this.bit_depth = arrayOfByte[8];
    this.color_type = arrayOfByte[9];
    return true;
  }
  
  public boolean isTransparentPng(String paramString)
  {
    try
    {
      unpackImage(new FileInputStream(paramString));
      if (((this.bit_depth == 8) || (this.bit_depth == 16)) && (this.color_type == 6)) {
        return true;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w("ImageProcessService", paramString.toString());
      }
    }
    return false;
  }
  
  public void unpackImage(InputStream paramInputStream)
    throws Exception
  {
    if (readLong(paramInputStream) != -8552249625308161526L) {}
    while (read_IHDR(paramInputStream)) {
      return;
    }
    throw new IOException("NOT A VALID PNG IMAGE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.imageservice.PNGReader
 * JD-Core Version:    0.7.0.1
 */