package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements c
{
  b los = new b();
  
  public n createApplication()
  {
    return this.los;
  }
  
  public ar createSubCore()
  {
    return i.bcf();
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.Plugin
 * JD-Core Version:    0.7.0.1
 */