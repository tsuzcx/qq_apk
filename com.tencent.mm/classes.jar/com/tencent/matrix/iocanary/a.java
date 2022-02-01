package com.tencent.matrix.iocanary;

import android.app.Application;
import com.tencent.matrix.d.b;
import com.tencent.matrix.d.c;
import com.tencent.matrix.iocanary.core.IOCanaryCore;

public class a
  extends b
{
  private IOCanaryCore cYB;
  public final com.tencent.matrix.iocanary.a.a mIOConfig;
  
  public a(com.tencent.matrix.iocanary.a.a parama)
  {
    this.mIOConfig = parama;
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  public String getTag()
  {
    return "io";
  }
  
  public void init(Application paramApplication, c paramc)
  {
    super.init(paramApplication, paramc);
    com.tencent.matrix.iocanary.c.a.setPackageName(paramApplication);
    this.cYB = new IOCanaryCore(this);
  }
  
  public void start()
  {
    super.start();
    this.cYB.start();
  }
  
  public void stop()
  {
    super.stop();
    this.cYB.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.iocanary.a
 * JD-Core Version:    0.7.0.1
 */