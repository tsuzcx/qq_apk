package com.tencent.mm.plugin.messenger.a;

import com.tencent.mm.pluginsdk.a.b;
import com.tencent.mm.sdk.platformtools.y;

public final class g
{
  public static d mcv;
  
  public static d bhI()
  {
    if (mcv == null) {
      mcv = new b();
    }
    if ((mcv instanceof b)) {
      y.w("MicroMsg.SendMsgMgrFactory", "we are using dummy SendMsgMgr!!");
    }
    return mcv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.g
 * JD-Core Version:    0.7.0.1
 */