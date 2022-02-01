package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.model.an;
import com.tencent.mm.model.cd;

public abstract interface r
  extends a
{
  public abstract b getBizTimeLineCallback();
  
  public abstract cd getSysCmdMsgExtension();
  
  public abstract boolean ifAddTicketByActionFlag(String paramString);
  
  public abstract void setBizTimeLineCallback(b paramb);
  
  public abstract void setEnSendMsgActionFlag(int paramInt);
  
  public abstract void setIDataTransferFactoryDelegate(an paraman);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.r
 * JD-Core Version:    0.7.0.1
 */