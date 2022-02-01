package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.ck;

public abstract interface v
  extends a
{
  public abstract d getBizTimeLineCallback();
  
  public abstract ck getSysCmdMsgExtension();
  
  public abstract boolean ifAddTicketByActionFlag(String paramString);
  
  public abstract void setBizTimeLineCallback(d paramd);
  
  public abstract void setEnSendMsgActionFlag(int paramInt);
  
  public abstract void setIDataTransferFactoryDelegate(au paramau);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.v
 * JD-Core Version:    0.7.0.1
 */