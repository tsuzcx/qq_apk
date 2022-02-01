package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.model.at;
import com.tencent.mm.model.cj;

public abstract interface s
  extends a
{
  public abstract b getBizTimeLineCallback();
  
  public abstract cj getSysCmdMsgExtension();
  
  public abstract boolean ifAddTicketByActionFlag(String paramString);
  
  public abstract void setBizTimeLineCallback(b paramb);
  
  public abstract void setEnSendMsgActionFlag(int paramInt);
  
  public abstract void setIDataTransferFactoryDelegate(at paramat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.s
 * JD-Core Version:    0.7.0.1
 */