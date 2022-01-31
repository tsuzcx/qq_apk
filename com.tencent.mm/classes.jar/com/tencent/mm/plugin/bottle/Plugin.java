package com.tencent.mm.plugin.bottle;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements c
{
  private b hYb = new Plugin.1(this);
  
  public final n createApplication()
  {
    return new a();
  }
  
  public final ar createSubCore()
  {
    return new i();
  }
  
  public final b getContactWidgetFactory()
  {
    return this.hYb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.Plugin
 * JD-Core Version:    0.7.0.1
 */