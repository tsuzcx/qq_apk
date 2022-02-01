package com.tencent.upload.common;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public class Tea
{
  private int contextStart;
  private int crypt;
  private boolean header = true;
  private byte[] key;
  private byte[] out;
  private int padding;
  private byte[] plain;
  private int pos;
  private int preCrypt;
  private byte[] prePlain;
  private Random random = new Random();
  
  private byte[] decipher(byte[] paramArrayOfByte)
  {
    return decipher(paramArrayOfByte, 0);
  }
  
  private byte[] decipher(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      long l2 = getUnsignedInt(paramArrayOfByte, paramInt, 4);
      long l3 = getUnsignedInt(paramArrayOfByte, paramInt + 4, 4);
      long l4 = getUnsignedInt(this.key, 0, 4);
      long l5 = getUnsignedInt(this.key, 4, 4);
      long l6 = getUnsignedInt(this.key, 8, 4);
      long l7 = getUnsignedInt(this.key, 12, 4);
      long l1 = 0xE3779B90 & 0xFFFFFFFF;
      paramInt = 16;
      for (;;)
      {
        if (paramInt <= 0)
        {
          paramArrayOfByte = new ByteArrayOutputStream(8);
          DataOutputStream localDataOutputStream = new DataOutputStream(paramArrayOfByte);
          localDataOutputStream.writeInt((int)l2);
          localDataOutputStream.writeInt((int)l3);
          localDataOutputStream.close();
          paramArrayOfByte = paramArrayOfByte.toByteArray();
          return paramArrayOfByte;
        }
        l3 = l3 - ((l2 << 4) + l6 ^ l2 + l1 ^ (l2 >>> 5) + l7) & 0xFFFFFFFF;
        l2 = l2 - ((l3 << 4) + l4 ^ l3 + l1 ^ (l3 >>> 5) + l5) & 0xFFFFFFFF;
        l1 = l1 - (0x9E3779B9 & 0xFFFFFFFF) & 0xFFFFFFFF;
        paramInt -= 1;
      }
      return null;
    }
    catch (IOException paramArrayOfByte) {}
  }
  
  private boolean decrypt8Bytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    for (this.pos = 0;; this.pos += 1)
    {
      boolean bool1;
      if (this.pos >= 8)
      {
        this.prePlain = decipher(this.prePlain);
        if (this.prePlain != null) {
          break;
        }
        bool1 = false;
      }
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.contextStart + this.pos >= paramInt2);
      int i = this.pos;
      byte[] arrayOfByte = this.prePlain;
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ paramArrayOfByte[(this.crypt + paramInt1 + this.pos)]));
    }
    this.contextStart += 8;
    this.crypt += 8;
    this.pos = 0;
    return true;
  }
  
  private byte[] encipher(byte[] paramArrayOfByte)
  {
    try
    {
      long l2 = getUnsignedInt(paramArrayOfByte, 0, 4);
      long l1 = getUnsignedInt(paramArrayOfByte, 4, 4);
      long l4 = getUnsignedInt(this.key, 0, 4);
      long l5 = getUnsignedInt(this.key, 4, 4);
      long l6 = getUnsignedInt(this.key, 8, 4);
      long l7 = getUnsignedInt(this.key, 12, 4);
      long l3 = 0L;
      int i = 16;
      for (;;)
      {
        if (i <= 0)
        {
          paramArrayOfByte = new ByteArrayOutputStream(8);
          DataOutputStream localDataOutputStream = new DataOutputStream(paramArrayOfByte);
          localDataOutputStream.writeInt((int)l2);
          localDataOutputStream.writeInt((int)l1);
          localDataOutputStream.close();
          paramArrayOfByte = paramArrayOfByte.toByteArray();
          return paramArrayOfByte;
        }
        l3 = l3 + (0x9E3779B9 & 0xFFFFFFFF) & 0xFFFFFFFF;
        l2 = l2 + ((l1 << 4) + l4 ^ l1 + l3 ^ (l1 >>> 5) + l5) & 0xFFFFFFFF;
        l1 = l1 + ((l2 << 4) + l6 ^ l2 + l3 ^ (l2 >>> 5) + l7) & 0xFFFFFFFF;
        i -= 1;
      }
      return null;
    }
    catch (IOException paramArrayOfByte) {}
  }
  
  private byte[] encrypt(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.plain = new byte[8];
    this.prePlain = new byte[8];
    this.pos = 1;
    this.padding = 0;
    this.preCrypt = 0;
    this.crypt = 0;
    this.key = paramArrayOfByte2;
    this.header = true;
    this.pos = ((paramInt2 + 10) % 8);
    if (this.pos != 0) {
      this.pos = (8 - this.pos);
    }
    this.out = new byte[this.pos + paramInt2 + 10];
    this.plain[0] = ((byte)(rand() & 0xF8 | this.pos));
    int i = 1;
    if (i > this.pos)
    {
      this.pos += 1;
      i = 0;
      label136:
      if (i < 8) {
        break label204;
      }
      this.padding = 1;
    }
    for (;;)
    {
      if (this.padding > 2)
      {
        if (paramInt2 > 0) {
          break label290;
        }
        this.padding = 1;
        label165:
        if (this.padding <= 7) {
          break label355;
        }
        return this.out;
        this.plain[i] = ((byte)(rand() & 0xFF));
        i += 1;
        break;
        label204:
        this.prePlain[i] = 0;
        i += 1;
        break label136;
      }
      if (this.pos < 8)
      {
        paramArrayOfByte2 = this.plain;
        i = this.pos;
        this.pos = (i + 1);
        paramArrayOfByte2[i] = ((byte)(rand() & 0xFF));
        this.padding += 1;
      }
      if (this.pos == 8) {
        encrypt8Bytes();
      }
    }
    label290:
    if (this.pos < 8)
    {
      paramArrayOfByte2 = this.plain;
      int j = this.pos;
      this.pos = (j + 1);
      i = paramInt1 + 1;
      paramArrayOfByte2[j] = paramArrayOfByte1[paramInt1];
      paramInt2 -= 1;
      paramInt1 = i;
    }
    for (;;)
    {
      if (this.pos == 8) {
        encrypt8Bytes();
      }
      break;
      label355:
      if (this.pos < 8)
      {
        paramArrayOfByte1 = this.plain;
        paramInt1 = this.pos;
        this.pos = (paramInt1 + 1);
        paramArrayOfByte1[paramInt1] = 0;
        this.padding += 1;
      }
      if (this.pos != 8) {
        break label165;
      }
      encrypt8Bytes();
      break label165;
    }
  }
  
  private void encrypt8Bytes()
  {
    this.pos = 0;
    if (this.pos >= 8) {
      System.arraycopy(encipher(this.plain), 0, this.out, this.crypt, 8);
    }
    for (this.pos = 0;; this.pos += 1)
    {
      if (this.pos >= 8)
      {
        System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
        this.preCrypt = this.crypt;
        this.crypt += 8;
        this.pos = 0;
        this.header = false;
        return;
        if (this.header)
        {
          i = this.pos;
          arrayOfByte = this.plain;
          arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ this.prePlain[this.pos]));
        }
        for (;;)
        {
          this.pos += 1;
          break;
          i = this.pos;
          arrayOfByte = this.plain;
          arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ this.out[(this.preCrypt + this.pos)]));
        }
      }
      int i = this.crypt + this.pos;
      byte[] arrayOfByte = this.out;
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ this.prePlain[this.pos]));
    }
  }
  
  private static long getUnsignedInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = 0L;
    if (paramInt2 > 8) {
      paramInt2 = paramInt1 + 8;
    }
    for (;;)
    {
      if (paramInt1 >= paramInt2)
      {
        return 0xFFFFFFFF & l | l >>> 32;
        paramInt2 = paramInt1 + paramInt2;
      }
      else
      {
        l = l << 8 | paramArrayOfByte[paramInt1] & 0xFF;
        paramInt1 += 1;
      }
    }
  }
  
  private int rand()
  {
    return this.random.nextInt();
  }
  
  protected byte[] decrypt(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.preCrypt = 0;
    this.crypt = 0;
    this.key = paramArrayOfByte2;
    paramArrayOfByte2 = new byte[paramInt1 + 8];
    if ((paramInt2 % 8 != 0) || (paramInt2 < 16)) {}
    int k;
    do
    {
      return null;
      this.prePlain = decipher(paramArrayOfByte1, paramInt1);
      this.pos = (this.prePlain[0] & 0x7);
      k = paramInt2 - this.pos - 10;
    } while (k < 0);
    int i = paramInt1;
    label81:
    int j;
    if (i >= paramArrayOfByte2.length)
    {
      this.out = new byte[k];
      this.preCrypt = 0;
      this.crypt = 8;
      this.contextStart = 8;
      this.pos += 1;
      this.padding = 1;
      label129:
      if (this.padding <= 2) {
        break label183;
      }
      j = 0;
      i = k;
      label144:
      if (i != 0) {
        break label236;
      }
    }
    for (this.padding = 1;; this.padding += 1)
    {
      if (this.padding >= 8)
      {
        return this.out;
        paramArrayOfByte2[i] = 0;
        i += 1;
        break label81;
        label183:
        if (this.pos < 8)
        {
          this.pos += 1;
          this.padding += 1;
        }
        if (this.pos != 8) {
          break label129;
        }
        paramArrayOfByte2 = paramArrayOfByte1;
        if (decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2)) {
          break label129;
        }
        return null;
        label236:
        int m = i;
        k = j;
        if (this.pos < 8)
        {
          this.out[j] = ((byte)(paramArrayOfByte2[(this.preCrypt + paramInt1 + this.pos)] ^ this.prePlain[this.pos]));
          k = j + 1;
          m = i - 1;
          this.pos += 1;
        }
        i = m;
        j = k;
        if (this.pos != 8) {
          break label144;
        }
        paramArrayOfByte2 = paramArrayOfByte1;
        this.preCrypt = (this.crypt - 8);
        i = m;
        j = k;
        if (decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2)) {
          break label144;
        }
        return null;
      }
      if (this.pos < 8)
      {
        if ((paramArrayOfByte2[(this.preCrypt + paramInt1 + this.pos)] ^ this.prePlain[this.pos]) != 0) {
          break;
        }
        this.pos += 1;
      }
      if (this.pos == 8)
      {
        paramArrayOfByte2 = paramArrayOfByte1;
        this.preCrypt = this.crypt;
        if (!decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2)) {
          break;
        }
      }
    }
  }
  
  protected byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return decrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
  }
  
  protected byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.common.Tea
 * JD-Core Version:    0.7.0.1
 */