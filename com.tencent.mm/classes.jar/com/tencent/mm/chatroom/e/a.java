package com.tencent.mm.chatroom.e;

import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.sm;
import com.tencent.mm.sdk.platformtools.bk;

@Deprecated
public final class a
  extends i.b
{
  private sm dni = new sm();
  
  public a(String paramString)
  {
    super(7);
    this.dni.sQs = new bml().YI(bk.pm(paramString));
    this.mdD = this.dni;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.a
 * JD-Core Version:    0.7.0.1
 */