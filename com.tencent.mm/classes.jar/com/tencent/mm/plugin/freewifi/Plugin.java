package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements c
{
  public n createApplication()
  {
    return new g();
  }
  
  public ar createSubCore()
  {
    return new j();
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.Plugin
 * JD-Core Version:    0.7.0.1
 */