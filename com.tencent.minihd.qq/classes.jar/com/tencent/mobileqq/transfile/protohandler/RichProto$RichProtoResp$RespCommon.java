package com.tencent.mobileqq.transfile.protohandler;

public class RichProto$RichProtoResp$RespCommon
{
  public RichProto.RichProtoReq a;
  public int c = -1;
  public int d;
  public String d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  
  public RichProto$RichProtoResp$RespCommon()
  {
    this.jdField_e_of_type_Boolean = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("res:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" errCode:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(" errStr:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(" reason:");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append(" succCnt:");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(" failCnt");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" isSendByQuickHttp");
    localStringBuilder.append(this.jdField_e_of_type_Boolean);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
 * JD-Core Version:    0.7.0.1
 */