package com.tencent.mm.platformtools;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public final class af
{
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
  
  private byte[] encipher(byte[] paramArrayOfByte)
  {
    int i = 16;
    for (;;)
    {
      long l3;
      long l2;
      long l4;
      long l5;
      long l6;
      long l7;
      long l1;
      try
      {
        l3 = y(paramArrayOfByte, 0);
        l2 = y(paramArrayOfByte, 4);
        l4 = y(this.key, 0);
        l5 = y(this.key, 4);
        l6 = y(this.key, 8);
        l7 = y(this.key, 12);
        l1 = 0L;
      }
      catch (IOException paramArrayOfByte)
      {
        DataOutputStream localDataOutputStream;
        return null;
      }
      paramArrayOfByte = new ByteArrayOutputStream(8);
      localDataOutputStream = new DataOutputStream(paramArrayOfByte);
      localDataOutputStream.writeInt((int)l3);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      return paramArrayOfByte;
      while (i > 0)
      {
        l1 = l1 + 2654435769L & 0xFFFFFFFF;
        l3 = l3 + ((l2 << 4) + l4 ^ l2 + l1 ^ (l2 >>> 5) + l5) & 0xFFFFFFFF;
        l2 = l2 + ((l3 << 4) + l6 ^ l3 + l1 ^ (l3 >>> 5) + l7) & 0xFFFFFFFF;
        i -= 1;
      }
    }
  }
  
  private void encrypt8Bytes()
  {
    this.pos = 0;
    byte[] arrayOfByte;
    int i;
    if (this.pos < 8)
    {
      if (this.header)
      {
        arrayOfByte = this.plain;
        i = this.pos;
        arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ this.prePlain[this.pos]));
      }
      for (;;)
      {
        this.pos += 1;
        break;
        arrayOfByte = this.plain;
        i = this.pos;
        arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ this.out[(this.preCrypt + this.pos)]));
      }
    }
    System.arraycopy(encipher(this.plain), 0, this.out, this.crypt, 8);
    for (this.pos = 0; this.pos < 8; this.pos += 1)
    {
      arrayOfByte = this.out;
      i = this.crypt + this.pos;
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ this.prePlain[this.pos]));
    }
    System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
    this.preCrypt = this.crypt;
    this.crypt += 8;
    this.pos = 0;
    this.header = false;
  }
  
  private static long y(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int i = paramInt;
    while (i < paramInt + 4)
    {
      l = l << 8 | paramArrayOfByte[i] & 0xFF;
      i += 1;
    }
    return l & 0xFFFFFFFF;
  }
  
  public final byte[] a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    this.plain = new byte[8];
    this.prePlain = new byte[8];
    this.pos = 1;
    this.padding = 0;
    this.preCrypt = 0;
    this.crypt = 0;
    this.key = paramArrayOfByte2;
    this.header = true;
    this.pos = ((paramInt + 10) % 8);
    if (this.pos != 0) {
      this.pos = (8 - this.pos);
    }
    this.out = new byte[this.pos + paramInt + 10];
    this.plain[0] = ((byte)(this.random.nextInt() & 0xF8 | this.pos));
    int i = 1;
    while (i <= this.pos)
    {
      this.plain[i] = ((byte)(this.random.nextInt() & 0xFF));
      i += 1;
    }
    this.pos += 1;
    i = 0;
    while (i < 8)
    {
      this.prePlain[i] = 0;
      i += 1;
    }
    this.padding = 1;
    while (this.padding <= 2)
    {
      if (this.pos < 8)
      {
        paramArrayOfByte2 = this.plain;
        i = this.pos;
        this.pos = (i + 1);
        paramArrayOfByte2[i] = ((byte)(this.random.nextInt() & 0xFF));
        this.padding += 1;
      }
      if (this.pos == 8) {
        encrypt8Bytes();
      }
    }
    int j = 0;
    i = paramInt;
    paramInt = j;
    if (i > 0)
    {
      if (this.pos >= 8) {
        break label430;
      }
      paramArrayOfByte2 = this.plain;
      int k = this.pos;
      this.pos = (k + 1);
      j = paramInt + 1;
      paramArrayOfByte2[k] = paramArrayOfByte1[paramInt];
      i -= 1;
      paramInt = j;
    }
    label430:
    for (;;)
    {
      if (this.pos == 8)
      {
        encrypt8Bytes();
        break;
        this.padding = 1;
        while (this.padding <= 7)
        {
          if (this.pos < 8)
          {
            paramArrayOfByte1 = this.plain;
            paramInt = this.pos;
            this.pos = (paramInt + 1);
            paramArrayOfByte1[paramInt] = 0;
            this.padding += 1;
          }
          if (this.pos == 8) {
            encrypt8Bytes();
          }
        }
        return this.out;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.platformtools.af
 * JD-Core Version:    0.7.0.1
 */