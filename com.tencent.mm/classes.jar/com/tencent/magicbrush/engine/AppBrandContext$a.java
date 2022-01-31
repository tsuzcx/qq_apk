package com.tencent.magicbrush.engine;

import android.os.Handler;
import java.util.ArrayList;
import java.util.TimerTask;

public final class AppBrandContext$a
  extends TimerTask
{
  public int bks;
  public boolean bkt;
  
  public AppBrandContext$a(AppBrandContext paramAppBrandContext, int paramInt, boolean paramBoolean)
  {
    this.bks = paramInt;
    this.bkt = paramBoolean;
  }
  
  public final void run()
  {
    if (AppBrandContext.b(this.bku))
    {
      if (this.bkt) {
        return;
      }
      AppBrandContext.c(this.bku).add(Integer.valueOf(this.bks));
      return;
    }
    AppBrandContext.d(this.bku).post(new AppBrandContext.a.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.engine.AppBrandContext.a
 * JD-Core Version:    0.7.0.1
 */