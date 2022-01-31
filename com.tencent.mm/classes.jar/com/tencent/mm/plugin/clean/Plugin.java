package com.tencent.mm.plugin.clean;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.clean.a.a;
import com.tencent.mm.plugin.clean.c.j;
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
    return j.aEb();
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.Plugin
 * JD-Core Version:    0.7.0.1
 */