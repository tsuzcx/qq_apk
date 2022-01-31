package com.tencent.mm.plugin.appbrand.report;

import android.os.Message;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.bk;

final class j$b
  extends h
{
  private long gXU;
  
  private j$b(j paramj) {}
  
  public final void enter()
  {
    super.enter();
    this.gXU = bk.UY();
  }
  
  public final void exit()
  {
    super.exit();
    this.gXT.gXN = (bk.UY() - this.gXU);
  }
  
  public final boolean g(Message paramMessage)
  {
    if (1 == paramMessage.what)
    {
      this.gXT.b(this.gXT.gXQ);
      return true;
    }
    return super.g(paramMessage);
  }
  
  public final String getName()
  {
    return this.gXT.mName + "|Foreground";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.j.b
 * JD-Core Version:    0.7.0.1
 */