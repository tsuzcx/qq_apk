package com.tencent.mm.chatroom.e;

import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.protocal.c.axb;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.bk;

@Deprecated
public final class b
  extends i.b
{
  private axb dnj = new axb();
  
  public b(String paramString, int paramInt)
  {
    super(20);
    this.dnj.svp = new bml().YI(bk.pm(paramString));
    this.dnj.hQq = paramInt;
    this.mdD = this.dnj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.b
 * JD-Core Version:    0.7.0.1
 */