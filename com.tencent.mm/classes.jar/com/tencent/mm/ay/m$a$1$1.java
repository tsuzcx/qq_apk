package com.tencent.mm.ay;

import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.protocal.c.bck;

final class m$a$1$1
  implements Runnable
{
  m$a$1$1(m.a.1 param1, i.b paramb, int paramInt, bck parambck) {}
  
  public final void run()
  {
    m localm = this.ewt.ewp;
    int i = this.ewq.getCmdId();
    int j = this.ewr;
    String str1;
    if (this.ews == null)
    {
      str1 = "";
      if (this.ews != null) {
        break label65;
      }
    }
    label65:
    for (String str2 = "";; str2 = this.ews.kVs)
    {
      localm.c(i, j, str1, str2);
      return;
      str1 = this.ews.bGw;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ay.m.a.1.1
 * JD-Core Version:    0.7.0.1
 */