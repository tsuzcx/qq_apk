package com.tencent.mobileqq.emosm;

import java.io.File;
import java.io.RandomAccessFile;

public class EmosmRandomAccessFile
  extends RandomAccessFile
{
  private final byte[] scratch = new byte[8];
  
  public EmosmRandomAccessFile(String paramString1, String paramString2)
  {
    super(new File(paramString1), paramString2);
  }
  
  public int read()
  {
    int i = -1;
    if (read(this.scratch, 0, 1) != -1) {
      i = this.scratch[0] & 0xFF;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = super.getFilePointer();
    paramInt2 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > -1) {
      EmosmUtils.decryptFi(paramArrayOfByte, paramInt1, paramInt2, l);
    }
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.EmosmRandomAccessFile
 * JD-Core Version:    0.7.0.1
 */