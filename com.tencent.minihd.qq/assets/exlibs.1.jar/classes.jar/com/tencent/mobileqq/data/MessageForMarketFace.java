package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.im_msg_body.MarketFace;

public class MessageForMarketFace
  extends ChatMessage
{
  public MarkFaceMessage mMarkFaceMessage = null;
  public boolean needToPlay = false;
  public String sendFaceName = null;
  
  public static MessageForMarketFace parsePb(im_msg_body.MarketFace paramMarketFace)
  {
    MarkFaceMessage localMarkFaceMessage = new MarkFaceMessage();
    localMarkFaceMessage.cFaceInfo = paramMarketFace.uint32_face_info.get();
    localMarkFaceMessage.cSubType = paramMarketFace.uint32_sub_type.get();
    localMarkFaceMessage.dwMSGItemType = paramMarketFace.uint32_item_type.get();
    localMarkFaceMessage.dwTabID = paramMarketFace.uint32_tab_id.get();
    localMarkFaceMessage.sbfKey = paramMarketFace.bytes_key.get().toByteArray();
    localMarkFaceMessage.sbufID = paramMarketFace.bytes_face_id.get().toByteArray();
    localMarkFaceMessage.mediaType = paramMarketFace.uint32_media_type.get();
    localMarkFaceMessage.mobileparam = paramMarketFace.bytes_mobileparam.get().toByteArray();
    paramMarketFace = new MessageForMarketFace();
    paramMarketFace.mMarkFaceMessage = localMarkFaceMessage;
    return paramMarketFace;
  }
  
  protected void doParse()
  {
    try
    {
      this.mMarkFaceMessage = ((MarkFaceMessage)MessagePkgUtils.a(this.msgData));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public im_msg_body.MarketFace getSerialPB()
  {
    im_msg_body.MarketFace localMarketFace = new im_msg_body.MarketFace();
    if (this.mMarkFaceMessage.sbufID != null) {
      localMarketFace.bytes_face_id.set(ByteStringMicro.copyFrom(this.mMarkFaceMessage.sbufID));
    }
    if (this.mMarkFaceMessage.sbfKey != null) {
      localMarketFace.bytes_key.set(ByteStringMicro.copyFrom(this.mMarkFaceMessage.sbfKey));
    }
    localMarketFace.uint32_face_info.set(this.mMarkFaceMessage.cFaceInfo);
    localMarketFace.uint32_item_type.set(this.mMarkFaceMessage.dwMSGItemType);
    localMarketFace.uint32_sub_type.set(this.mMarkFaceMessage.cSubType);
    localMarketFace.uint32_tab_id.set(this.mMarkFaceMessage.dwTabID);
    localMarketFace.uint32_media_type.set(this.mMarkFaceMessage.mediaType);
    localMarketFace.bytes_mobileparam.set(ByteStringMicro.copyFrom(this.mMarkFaceMessage.mobileparam));
    return localMarketFace;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    if (this.mMarkFaceMessage != null) {}
    try
    {
      this.msgData = MessagePkgUtils.a(this.mMarkFaceMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForMarketFace
 * JD-Core Version:    0.7.0.1
 */