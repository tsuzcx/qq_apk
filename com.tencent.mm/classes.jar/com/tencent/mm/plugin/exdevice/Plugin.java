package com.tencent.mm.plugin.exdevice;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements c
{
  public n createApplication()
  {
    return new a();
  }
  
  public ar createSubCore()
  {
    return new ad();
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.Plugin
 * JD-Core Version:    0.7.0.1
 */