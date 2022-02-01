package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.model.av;
import com.tencent.mm.model.cl;

public abstract interface v
  extends a
{
  public abstract d getBizTimeLineCallback();
  
  public abstract cl getSysCmdMsgExtension();
  
  public abstract boolean ifAddTicketByActionFlag(String paramString);
  
  public abstract void setBizTimeLineCallback(d paramd);
  
  public abstract void setEnSendMsgActionFlag(int paramInt);
  
  public abstract void setIDataTransferFactoryDelegate(av paramav);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.v
 * JD-Core Version:    0.7.0.1
 */