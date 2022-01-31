package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.mm.am.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bf;

final class t$8
  extends bf<Object>
{
  t$8(t paramt, Object paramObject, boolean paramBoolean)
  {
    super(3000L, paramObject, (byte)0);
  }
  
  public final Object run()
  {
    BaseEvent.onForeground(this.eOd);
    a.bU(this.eOd);
    b.bN(this.eOd);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.network.t.8
 * JD-Core Version:    0.7.0.1
 */