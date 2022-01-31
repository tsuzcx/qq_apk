package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.mm.sdk.platformtools.bf;

final class t$13
  extends bf<Object>
{
  t$13(t paramt, Object paramObject)
  {
    super(3000L, paramObject, (byte)0);
  }
  
  public final Object run()
  {
    BaseEvent.onNetworkChange();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.network.t.13
 * JD-Core Version:    0.7.0.1
 */