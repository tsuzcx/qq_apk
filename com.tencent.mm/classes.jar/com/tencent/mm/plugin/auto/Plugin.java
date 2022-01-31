package com.tencent.mm.plugin.auto;

import com.tencent.mm.model.ar;
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
    return new com.tencent.mm.plugin.auto.a.b();
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.Plugin
 * JD-Core Version:    0.7.0.1
 */