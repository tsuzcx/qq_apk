package com.tencent.mm.plugin.collect;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements c
{
  public final n createApplication()
  {
    return null;
  }
  
  public final ar createSubCore()
  {
    return new a();
  }
  
  public final b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.Plugin
 * JD-Core Version:    0.7.0.1
 */