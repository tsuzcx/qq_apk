package com.tencent.mm.plugin.gcm;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements com.tencent.mm.pluginsdk.b.c
{
  com.tencent.mm.sdk.b.c lhf = new Plugin.1(this);
  com.tencent.mm.sdk.b.c lhg = new Plugin.2(this);
  
  public Plugin()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.lhf);
    com.tencent.mm.sdk.b.a.udP.c(this.lhg);
  }
  
  public n createApplication()
  {
    return new com.tencent.mm.plugin.gcm.a.a();
  }
  
  public ar createSubCore()
  {
    return new com.tencent.mm.plugin.gcm.modelgcm.b();
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gcm.Plugin
 * JD-Core Version:    0.7.0.1
 */