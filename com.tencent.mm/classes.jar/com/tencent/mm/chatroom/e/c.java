package com.tencent.mm.chatroom.e;

import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.protocal.c.big;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.bk;

@Deprecated
public final class c
  extends i.b
{
  private big dnk = new big();
  
  public c(String paramString1, String paramString2)
  {
    super(16);
    this.dnk.sQs = new bml().YI(bk.pm(paramString1));
    this.dnk.svp = new bml().YI(bk.pm(paramString2));
    this.mdD = this.dnk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.c
 * JD-Core Version:    0.7.0.1
 */