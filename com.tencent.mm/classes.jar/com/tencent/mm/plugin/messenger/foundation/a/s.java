package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.cf;

public abstract interface s
  extends a
{
  public abstract b getBizTimeLineCallback();
  
  public abstract cf getSysCmdMsgExtension();
  
  public abstract boolean ifAddTicketByActionFlag(String paramString);
  
  public abstract void setBizTimeLineCallback(b paramb);
  
  public abstract void setEnSendMsgActionFlag(int paramInt);
  
  public abstract void setIDataTransferFactoryDelegate(ap paramap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.s
 * JD-Core Version:    0.7.0.1
 */