package com.tencent.mm.plugin.ext.c;

import android.util.SparseArray;

public final class d
{
  private static SparseArray<byte[]> jLe = new SparseArray(1);
  
  static d.c aNK()
  {
    return new d.a();
  }
  
  private static int au(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.d
 * JD-Core Version:    0.7.0.1
 */