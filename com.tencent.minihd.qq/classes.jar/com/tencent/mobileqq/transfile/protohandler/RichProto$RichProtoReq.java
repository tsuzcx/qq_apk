package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import java.util.ArrayList;
import java.util.List;

public class RichProto$RichProtoReq
{
  ProtoReqManager.ProtoReq jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoReq;
  public ProtoReqManager a;
  RichProto.RichProtoResp jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp = new RichProto.RichProtoResp();
  public RichProtoProc.RichProtoCallback a;
  public String a;
  public List a;
  
  public RichProto$RichProtoReq()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localStringBuilder.append("index:");
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
      localStringBuilder.append(((RichProto.RichProtoReq.ReqCommon)this.jdField_a_of_type_JavaUtilList.get(i)).toString());
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq
 * JD-Core Version:    0.7.0.1
 */