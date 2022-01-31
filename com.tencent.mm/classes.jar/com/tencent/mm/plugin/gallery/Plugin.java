package com.tencent.mm.plugin.gallery;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;
import java.util.HashMap;

public class Plugin
  implements c
{
  public n createApplication()
  {
    return new Plugin.1(this);
  }
  
  public ar createSubCore()
  {
    new ar()
    {
      public final void bh(boolean paramAnonymousBoolean) {}
      
      public final void bi(boolean paramAnonymousBoolean) {}
      
      public final void gf(int paramAnonymousInt) {}
      
      public final void onAccountRelease() {}
      
      public final HashMap<Integer, h.d> xe()
      {
        return null;
      }
    };
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.Plugin
 * JD-Core Version:    0.7.0.1
 */