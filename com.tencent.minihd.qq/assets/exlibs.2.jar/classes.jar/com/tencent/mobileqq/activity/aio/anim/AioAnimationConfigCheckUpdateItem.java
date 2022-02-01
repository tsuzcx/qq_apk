package com.tencent.mobileqq.activity.aio.anim;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.GetResourceReqInfo;

public class AioAnimationConfigCheckUpdateItem
  extends ConfigHandler
  implements CheckUpdateItemInterface
{
  public static final String a = "AioAnimationConfigCheckUpdateItem";
  private ToServiceMsg a;
  
  public AioAnimationConfigCheckUpdateItem(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public int a()
  {
    return 7;
  }
  
  public ReqItem a()
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d("AioAnimationConfigCheckUpdateItem", 2, "getCheckUpdateItemData:");
    }
    a(null, new GetResourceReqInfo[] { a() });
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg != null)
    {
      BaseProtocolCoder localBaseProtocolCoder = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd());
      localObject1 = localObject2;
      if (localBaseProtocolCoder != null)
      {
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.setEncodeName("utf-8");
        localObject1 = localObject2;
        if (localBaseProtocolCoder.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, localUniPacket))
        {
          localObject1 = new ReqItem();
          ((ReqItem)localObject1).eServiceID = 120;
          ((ReqItem)localObject1).vecParam = localUniPacket.encode();
        }
      }
    }
    return localObject1;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem != null)
    {
      int i = paramRespItem.cResult;
      Object localObject = paramRespItem.vecUpdate;
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationConfigCheckUpdateItem", 2, "handleCheckUpdateItemData: item.cResult = " + i + ", dataLen = " + localObject.length);
      }
      if ((paramRespItem.eServiceID == 120) && (paramRespItem.cResult == 2))
      {
        localObject = new FromServiceMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "ConfigService.GetResourceReq");
        ((FromServiceMsg)localObject).setMsgSuccess();
        ((FromServiceMsg)localObject).putWupBuffer(paramRespItem.vecUpdate);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, (FromServiceMsg)localObject);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigCheckUpdateItem
 * JD-Core Version:    0.7.0.1
 */