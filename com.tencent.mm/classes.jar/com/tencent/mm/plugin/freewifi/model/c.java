package com.tencent.mm.plugin.freewifi.model;

import android.os.HandlerThread;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;

public final class c
{
  private HandlerThread kou;
  private ah kov;
  
  public final ah aTT()
  {
    if (this.kou == null)
    {
      this.kou = e.aap("FreeWifiHandlerThread_handlerThread");
      this.kou.start();
    }
    if (this.kov == null) {
      this.kov = new ah(this.kou.getLooper());
    }
    return this.kov;
  }
  
  public final void release()
  {
    if (this.kou != null)
    {
      this.kou.quit();
      this.kou = null;
    }
    this.kov = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.c
 * JD-Core Version:    0.7.0.1
 */