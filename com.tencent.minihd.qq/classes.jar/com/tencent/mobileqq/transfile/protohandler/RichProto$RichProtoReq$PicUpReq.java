package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;

public class RichProto$RichProtoReq$PicUpReq
  extends RichProto.RichProtoReq.ReqCommon
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  public boolean b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" name:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" width:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" height:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" size:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" isRaw:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" isContant:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(" md5:");
    localStringBuilder.append(HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq
 * JD-Core Version:    0.7.0.1
 */