package com.tencent.midas.data;

public class APDataId
{
  private static APDataId gInstance = null;
  private static int paydataCount = 0;
  private final String DATA_DISCOUNT_INIT = "initdataCount";
  private final String DATA_DISCOUNT_PAY = "dataCount";
  private final String TENCENTUNIPAY_DATAID_FLAG = "TencentUnipay";
  
  public static int getDataId()
  {
    int i = paydataCount;
    paydataCount = i + 1;
    return i;
  }
  
  public static void initDataId()
  {
    paydataCount = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.data.APDataId
 * JD-Core Version:    0.7.0.1
 */