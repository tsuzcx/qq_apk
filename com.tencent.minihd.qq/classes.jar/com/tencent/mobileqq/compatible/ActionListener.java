package com.tencent.mobileqq.compatible;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener.Stub;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

@Deprecated
public abstract class ActionListener
  extends IBaseActionListener.Stub
{
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public void onActionResult(FromServiceMsg paramFromServiceMsg) {}
  
  public void onRecvFromMsg(FromServiceMsg paramFromServiceMsg)
  {
    a((ToServiceMsg)paramFromServiceMsg.attributes.get(FromServiceMsg.class.getSimpleName()), paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.compatible.ActionListener
 * JD-Core Version:    0.7.0.1
 */