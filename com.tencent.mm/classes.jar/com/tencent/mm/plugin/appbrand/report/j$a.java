package com.tencent.mm.plugin.appbrand.report;

import android.os.Message;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.bk;

final class j$a
  extends h
{
  private long gXS;
  
  private j$a(j paramj) {}
  
  public final void enter()
  {
    super.enter();
    this.gXS = bk.UY();
  }
  
  public final void exit()
  {
    super.exit();
    this.gXT.gXM = (bk.UY() - this.gXS);
  }
  
  public final boolean g(Message paramMessage)
  {
    if (2 == paramMessage.what)
    {
      this.gXT.b(this.gXT.gXP);
      return true;
    }
    return super.g(paramMessage);
  }
  
  public final String getName()
  {
    return this.gXT.mName + "|Background";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.j.a
 * JD-Core Version:    0.7.0.1
 */