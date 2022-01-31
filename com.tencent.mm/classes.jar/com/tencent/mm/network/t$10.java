package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.sdk.platformtools.bf;

final class t$10
  extends bf<Object>
{
  t$10(t paramt, Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(3000L, paramObject, (byte)0);
  }
  
  public final Object run()
  {
    MMLogic.setDebugIP(this.eOi, this.eOj, this.eOk, this.eOl);
    BaseEvent.onNetworkChange();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.t.10
 * JD-Core Version:    0.7.0.1
 */