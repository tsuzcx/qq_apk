package com.tencent.mobileqq.transfile.protohandler;

import java.util.ArrayList;

public class RichProto$RichProtoResp$GroupPicUpResp
  extends RichProto.RichProtoResp.RespCommon
{
  public int a;
  public long a;
  public String a;
  public ArrayList a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public boolean c = false;
  
  public RichProto$RichProtoResp$GroupPicUpResp()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" fileID:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" isExist:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" blockSize:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" netChg:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp
 * JD-Core Version:    0.7.0.1
 */