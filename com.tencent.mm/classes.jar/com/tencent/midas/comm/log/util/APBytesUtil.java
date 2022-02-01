package com.tencent.midas.comm.log.util;

public class APBytesUtil
{
  public static byte[] int2bytes(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24), (byte)(paramInt >> 16), (byte)(paramInt >> 8), (byte)paramInt };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.comm.log.util.APBytesUtil
 * JD-Core Version:    0.7.0.1
 */