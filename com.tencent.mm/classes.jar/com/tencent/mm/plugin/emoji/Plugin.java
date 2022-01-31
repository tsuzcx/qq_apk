package com.tencent.mm.plugin.emoji;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.emoji.model.i;
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
    return new i();
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.Plugin
 * JD-Core Version:    0.7.0.1
 */