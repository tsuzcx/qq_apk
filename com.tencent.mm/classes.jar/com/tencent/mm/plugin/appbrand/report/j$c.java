package com.tencent.mm.plugin.appbrand.report;

import android.os.Message;
import com.tencent.mm.sdk.d.d;

final class j$c
  extends h
{
  private j$c(j paramj) {}
  
  public final boolean g(Message paramMessage)
  {
    if (2 == paramMessage.what)
    {
      this.gXT.b(this.gXT.gXP);
      return true;
    }
    if (1 == paramMessage.what)
    {
      this.gXT.b(this.gXT.gXQ);
      return true;
    }
    return super.g(paramMessage);
  }
  
  public final String getName()
  {
    return this.gXT.mName + "|Init";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.j.c
 * JD-Core Version:    0.7.0.1
 */