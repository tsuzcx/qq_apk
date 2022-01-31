package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements c
{
  public n createApplication()
  {
    return new b();
  }
  
  public ar createSubCore()
  {
    return null;
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.Plugin
 * JD-Core Version:    0.7.0.1
 */