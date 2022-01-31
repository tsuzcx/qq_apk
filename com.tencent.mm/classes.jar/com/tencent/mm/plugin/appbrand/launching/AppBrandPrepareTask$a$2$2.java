package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.h.a.ca;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandPrepareTask$a$2$2
  extends c<ca>
{
  AppBrandPrepareTask$a$2$2(AppBrandPrepareTask.a.2 param2)
  {
    this.udX = ca.class.getName().hashCode();
  }
  
  private boolean a(ca paramca)
  {
    if (paramca != null)
    {
      dead();
      y.i("MicroMsg.AppBrandPrepareTask", "prepareCall account notifyAllDone, start real prepare");
    }
    this.gJx.gJw.alD();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.2.2
 * JD-Core Version:    0.7.0.1
 */