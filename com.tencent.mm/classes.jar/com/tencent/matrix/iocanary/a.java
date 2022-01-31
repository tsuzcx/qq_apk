package com.tencent.matrix.iocanary;

import android.app.Application;
import com.tencent.matrix.d.b;
import com.tencent.matrix.d.c;
import com.tencent.matrix.iocanary.core.IOCanaryCore;

public final class a
  extends b
{
  private IOCanaryCore bNE;
  public final com.tencent.matrix.iocanary.a.a mIOConfig;
  
  public a(com.tencent.matrix.iocanary.a.a parama)
  {
    this.mIOConfig = parama;
  }
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public final String getTag()
  {
    return "io";
  }
  
  public final void init(Application paramApplication, c paramc)
  {
    super.init(paramApplication, paramc);
    com.tencent.matrix.iocanary.c.a.setPackageName(paramApplication);
    this.bNE = new IOCanaryCore(this);
  }
  
  public final void start()
  {
    super.start();
    this.bNE.start();
  }
  
  public final void stop()
  {
    super.stop();
    this.bNE.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.iocanary.a
 * JD-Core Version:    0.7.0.1
 */