package com.tencent.mobileqq.data;

import com.tencent.mobileqq.utils.httputils.PkgTools;

public class MessageForText$AtTroopMemberInfo
{
  public static final String ALL_MEM_UIN = "0";
  public static final byte FLAG_AT_GROUP = 1;
  public static final byte FLAG_AT_UIN = 0;
  public static final int SINGLE_BASIC_INFO_LEN = 11;
  public byte flag = 0;
  public short startPos = 0;
  public short textLen = 0;
  public long uin = 0L;
  public short wExtBufLen = 0;
  
  public boolean isIncludingAll()
  {
    return (this.flag == 1) && (this.uin == 0L);
  }
  
  public boolean isIncludingMe(long paramLong)
  {
    return (this.flag == 0) && (this.uin == paramLong);
  }
  
  public boolean isValid()
  {
    return (this.startPos >= 0) && (this.textLen > 0);
  }
  
  public int length()
  {
    return this.wExtBufLen + 11;
  }
  
  public boolean readFrom(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt < 0) || (paramArrayOfByte.length < paramInt + 11)) {
      return false;
    }
    this.startPos = PkgTools.a(paramArrayOfByte, paramInt + 0);
    this.textLen = PkgTools.a(paramArrayOfByte, paramInt + 2);
    this.flag = paramArrayOfByte[(paramInt + 4)];
    this.uin = PkgTools.a(paramArrayOfByte, paramInt + 5);
    this.wExtBufLen = PkgTools.a(paramArrayOfByte, paramInt + 9);
    return true;
  }
  
  public boolean writeTo(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt < 0) || (paramArrayOfByte.length < paramInt + 11)) {
      return false;
    }
    PkgTools.a(paramArrayOfByte, paramInt + 0, this.startPos);
    PkgTools.a(paramArrayOfByte, paramInt + 2, this.textLen);
    paramArrayOfByte[(paramInt + 4)] = this.flag;
    PkgTools.a(paramArrayOfByte, paramInt + 5, this.uin);
    PkgTools.a(paramArrayOfByte, paramInt + 9, (short)0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo
 * JD-Core Version:    0.7.0.1
 */