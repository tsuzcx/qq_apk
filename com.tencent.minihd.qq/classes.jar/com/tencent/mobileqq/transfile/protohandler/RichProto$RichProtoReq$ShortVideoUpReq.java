package com.tencent.mobileqq.transfile.protohandler;

public class RichProto$RichProtoReq$ShortVideoUpReq
  extends RichProto.RichProtoReq.ReqCommon
{
  public int a;
  public long a;
  public String a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public byte[] b;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" chatType:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" md5:");
    localStringBuilder.append(this.jdField_a_of_type_ArrayOfByte);
    localStringBuilder.append(" format:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" str_file_name:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" uint64_file_size:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" fileTime:");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoUpReq
 * JD-Core Version:    0.7.0.1
 */