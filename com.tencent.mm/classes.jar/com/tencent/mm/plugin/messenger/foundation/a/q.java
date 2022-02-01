package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.model.am;
import com.tencent.mm.model.cc;

public abstract interface q
  extends a
{
  public abstract cc getSysCmdMsgExtension();
  
  public abstract boolean ifAddTicketByActionFlag(String paramString);
  
  public abstract void setEnSendMsgActionFlag(int paramInt);
  
  public abstract void setIDataTransferFactoryDelegate(am paramam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.q
 * JD-Core Version:    0.7.0.1
 */