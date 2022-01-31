package com.tencent.mm.ay;

import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.sdk.platformtools.bk;

@Deprecated
public final class b
  extends i.b
{
  private sr evW = new sr();
  public String username;
  
  public b(String paramString)
  {
    this(paramString, 0);
    this.username = paramString;
  }
  
  public b(String paramString, int paramInt)
  {
    super(4);
    this.evW.sQs = new bml().YI(bk.pm(paramString));
    this.evW.sQt = paramInt;
    this.mdD = this.evW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ay.b
 * JD-Core Version:    0.7.0.1
 */