package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public final class ac
{
  private int contextStart;
  private int crypt;
  private boolean header;
  private byte[] key;
  private byte[] out;
  private int padding;
  private byte[] plain;
  private int pos;
  private int preCrypt;
  private byte[] prePlain;
  private Random random;
  
  public ac()
  {
    AppMethodBeat.i(140861);
    this.header = true;
    this.random = new Random();
    AppMethodBeat.o(140861);
  }
  
  private static long A(byte[] paramArrayOfByte, int paramInt)
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
  
  private boolean G(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(140869);
    for (this.pos = 0; this.pos < 8; this.pos += 1)
    {
      if (this.contextStart + this.pos >= paramInt)
      {
        AppMethodBeat.o(140869);
        return true;
      }
      byte[] arrayOfByte = this.prePlain;
      int i = this.pos;
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ paramArrayOfByte[(this.crypt + 0 + this.pos)]));
    }
    this.prePlain = az(this.prePlain);
    if (this.prePlain == null)
    {
      AppMethodBeat.o(140869);
      return false;
    }
    this.contextStart += 8;
    this.crypt += 8;
    this.pos = 0;
    AppMethodBeat.o(140869);
    return true;
  }
  
  private byte[] a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(140864);
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
        break label442;
      }
      paramArrayOfByte2 = this.plain;
      int k = this.pos;
      this.pos = (k + 1);
      j = paramInt + 1;
      paramArrayOfByte2[k] = paramArrayOfByte1[paramInt];
      i -= 1;
      paramInt = j;
    }
    label442:
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
        paramArrayOfByte1 = this.out;
        AppMethodBeat.o(140864);
        return paramArrayOfByte1;
      }
      break;
    }
  }
  
  private byte[] az(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(140867);
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
        l3 = A(paramArrayOfByte, 0);
        l2 = A(paramArrayOfByte, 4);
        l4 = A(this.key, 0);
        l5 = A(this.key, 4);
        l6 = A(this.key, 8);
        l7 = A(this.key, 12);
        l1 = 3816266640L;
      }
      catch (IOException paramArrayOfByte)
      {
        DataOutputStream localDataOutputStream;
        AppMethodBeat.o(140867);
        return null;
      }
      paramArrayOfByte = new ByteArrayOutputStream(8);
      localDataOutputStream = new DataOutputStream(paramArrayOfByte);
      localDataOutputStream.writeInt((int)l3);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      AppMethodBeat.o(140867);
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
  
  private byte[] b(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    int k = 0;
    AppMethodBeat.i(140862);
    this.preCrypt = 0;
    this.crypt = 0;
    this.key = paramArrayOfByte2;
    paramArrayOfByte2 = new byte[8];
    if ((paramInt % 8 != 0) || (paramInt < 16))
    {
      AppMethodBeat.o(140862);
      return null;
    }
    this.prePlain = az(paramArrayOfByte1);
    if (this.prePlain == null)
    {
      AppMethodBeat.o(140862);
      return null;
    }
    this.pos = (this.prePlain[0] & 0x7);
    int j = paramInt - this.pos - 10;
    if (j < 0)
    {
      AppMethodBeat.o(140862);
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
        if (!G(paramArrayOfByte1, paramInt))
        {
          AppMethodBeat.o(140862);
          return null;
        }
      }
      else
      {
        i = k;
        if (j != 0)
        {
          if (this.pos >= 8) {
            break label474;
          }
          this.out[i] = ((byte)(paramArrayOfByte2[(this.preCrypt + 0 + this.pos)] ^ this.prePlain[this.pos]));
          i += 1;
          this.pos += 1;
          j -= 1;
        }
        label474:
        for (;;)
        {
          if (this.pos == 8)
          {
            this.preCrypt = (this.crypt - 8);
            if (!G(paramArrayOfByte1, paramInt))
            {
              AppMethodBeat.o(140862);
              return null;
              for (this.padding = 1; this.padding < 8; this.padding += 1)
              {
                if (this.pos < 8)
                {
                  if ((paramArrayOfByte2[(this.preCrypt + 0 + this.pos)] ^ this.prePlain[this.pos]) != 0)
                  {
                    AppMethodBeat.o(140862);
                    return null;
                  }
                  this.pos += 1;
                }
                if (this.pos == 8)
                {
                  this.preCrypt = this.crypt;
                  if (!G(paramArrayOfByte1, paramInt))
                  {
                    AppMethodBeat.o(140862);
                    return null;
                  }
                  paramArrayOfByte2 = paramArrayOfByte1;
                }
              }
              paramArrayOfByte1 = this.out;
              AppMethodBeat.o(140862);
              return paramArrayOfByte1;
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
  
  private byte[] encipher(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(140866);
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
        l3 = A(paramArrayOfByte, 0);
        l2 = A(paramArrayOfByte, 4);
        l4 = A(this.key, 0);
        l5 = A(this.key, 4);
        l6 = A(this.key, 8);
        l7 = A(this.key, 12);
        l1 = 0L;
      }
      catch (IOException paramArrayOfByte)
      {
        DataOutputStream localDataOutputStream;
        AppMethodBeat.o(140866);
        return null;
      }
      paramArrayOfByte = new ByteArrayOutputStream(8);
      localDataOutputStream = new DataOutputStream(paramArrayOfByte);
      localDataOutputStream.writeInt((int)l3);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      AppMethodBeat.o(140866);
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
    AppMethodBeat.i(140868);
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
    AppMethodBeat.o(140868);
  }
  
  public final byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(140863);
    paramArrayOfByte1 = b(paramArrayOfByte1, paramArrayOfByte1.length, paramArrayOfByte2);
    AppMethodBeat.o(140863);
    return paramArrayOfByte1;
  }
  
  public final byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(140865);
    paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte1.length, paramArrayOfByte2);
    AppMethodBeat.o(140865);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ac
 * JD-Core Version:    0.7.0.1
 */