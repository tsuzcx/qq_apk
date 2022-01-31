package com.tencent.mm.plugin.appbrand.v;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public final class q
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
  
  private boolean D(byte[] paramArrayOfByte, int paramInt)
  {
    for (this.pos = 0; this.pos < 8; this.pos += 1)
    {
      if (this.contextStart + this.pos >= paramInt) {
        return true;
      }
      byte[] arrayOfByte = this.prePlain;
      int i = this.pos;
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ paramArrayOfByte[(this.crypt + 0 + this.pos)]));
    }
    this.prePlain = R(this.prePlain);
    if (this.prePlain == null) {
      return false;
    }
    this.contextStart += 8;
    this.crypt += 8;
    this.pos = 0;
    return true;
  }
  
  private byte[] R(byte[] paramArrayOfByte)
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
        l1 = 3816266640L;
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
        l2 = l2 - ((l3 << 4) + l6 ^ l3 + l1 ^ (l3 >>> 5) + l7) & 0xFFFFFFFF;
        l3 = l3 - ((l2 << 4) + l4 ^ l2 + l1 ^ (l2 >>> 5) + l5) & 0xFFFFFFFF;
        l1 = l1 - 2654435769L & 0xFFFFFFFF;
        i -= 1;
      }
    }
  }
  
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
  
  public final byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int k = 0;
    int m = paramArrayOfByte1.length;
    this.preCrypt = 0;
    this.crypt = 0;
    this.key = paramArrayOfByte2;
    paramArrayOfByte2 = new byte[8];
    if ((m % 8 != 0) || (m < 16)) {
      return null;
    }
    this.prePlain = R(paramArrayOfByte1);
    if (this.prePlain == null) {
      return null;
    }
    this.pos = (this.prePlain[0] & 0x7);
    int j = m - this.pos - 10;
    if (j < 0) {
      return null;
    }
    int i = 0;
    while (i < 8)
    {
      paramArrayOfByte2[i] = 0;
      i += 1;
    }
    this.out = new byte[j];
    this.preCrypt = 0;
    this.crypt = 8;
    this.contextStart = 8;
    this.pos += 1;
    this.padding = 1;
    for (;;)
    {
      if (this.padding <= 2)
      {
        if (this.pos < 8)
        {
          this.pos += 1;
          this.padding += 1;
        }
        if (this.pos != 8) {
          continue;
        }
        if (!D(paramArrayOfByte1, m)) {
          return null;
        }
      }
      else
      {
        i = k;
        if (j != 0)
        {
          if (this.pos >= 8) {
            break label428;
          }
          this.out[i] = ((byte)(paramArrayOfByte2[(this.preCrypt + 0 + this.pos)] ^ this.prePlain[this.pos]));
          i += 1;
          this.pos += 1;
          j -= 1;
        }
        label428:
        for (;;)
        {
          if (this.pos == 8)
          {
            this.preCrypt = (this.crypt - 8);
            if (!D(paramArrayOfByte1, m))
            {
              return null;
              for (this.padding = 1; this.padding < 8; this.padding += 1)
              {
                if (this.pos < 8)
                {
                  if ((paramArrayOfByte2[(this.preCrypt + 0 + this.pos)] ^ this.prePlain[this.pos]) != 0) {
                    return null;
                  }
                  this.pos += 1;
                }
                if (this.pos == 8)
                {
                  this.preCrypt = this.crypt;
                  if (!D(paramArrayOfByte1, m)) {
                    return null;
                  }
                  paramArrayOfByte2 = paramArrayOfByte1;
                }
              }
              return this.out;
            }
            paramArrayOfByte2 = paramArrayOfByte1;
            break;
          }
          break;
        }
      }
      paramArrayOfByte2 = paramArrayOfByte1;
    }
  }
  
  public final byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = paramArrayOfByte1.length;
    this.plain = new byte[8];
    this.prePlain = new byte[8];
    this.pos = 1;
    this.padding = 0;
    this.preCrypt = 0;
    this.crypt = 0;
    this.key = paramArrayOfByte2;
    this.header = true;
    this.pos = ((j + 10) % 8);
    if (this.pos != 0) {
      this.pos = (8 - this.pos);
    }
    this.out = new byte[this.pos + j + 10];
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
    i = 0;
    if (j > 0)
    {
      if (this.pos >= 8) {
        break label416;
      }
      paramArrayOfByte2 = this.plain;
      int m = this.pos;
      this.pos = (m + 1);
      int k = i + 1;
      paramArrayOfByte2[m] = paramArrayOfByte1[i];
      j -= 1;
      i = k;
    }
    label416:
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
            i = this.pos;
            this.pos = (i + 1);
            paramArrayOfByte1[i] = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.q
 * JD-Core Version:    0.7.0.1
 */