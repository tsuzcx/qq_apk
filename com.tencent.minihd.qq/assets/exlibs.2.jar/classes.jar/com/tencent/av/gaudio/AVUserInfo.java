package com.tencent.av.gaudio;

public class AVUserInfo
{
  public long account = 0L;
  public int accountType = 0;
  public String openId = null;
  public int pstnStatus = 0;
  
  public String toString()
  {
    return "AVUserInfo{account=" + this.account + ", openId='" + this.openId + '\'' + ", accountType=" + this.accountType + ", pstnStatus=" + this.pstnStatus + '}';
  }
  
  public static abstract interface ACCOUNT_TYPE
  {
    public static final int PSTN = 1;
    public static final int QQ = 0;
  }
  
  public static abstract interface PSTN_STATUS
  {
    public static final int ACCEPT = 3;
    public static final int CALLING = 1;
    public static final int CLOSED = 6;
    public static final int MISSED = 5;
    public static final int REFUSE = 4;
    public static final int RINGING = 2;
    public static final int UNKNOWN = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.gaudio.AVUserInfo
 * JD-Core Version:    0.7.0.1
 */