package com.tencent.mm.ay;

import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;

@Deprecated
public final class d
  extends i.b
{
  private ta evY = new ta();
  
  public d(String paramString, long paramLong)
  {
    super(9);
    this.evY.sQs = new bml().YI(bk.pm(paramString));
    this.evY.sQy.add(Integer.valueOf((int)paramLong));
    this.evY.hPS = 1;
    this.mdD = this.evY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ay.d
 * JD-Core Version:    0.7.0.1
 */