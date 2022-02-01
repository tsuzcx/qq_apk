package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelive.c.d;
import java.util.HashMap;
import java.util.Map;

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 1033;
  public static final String NAME = "shareGameLive";
  
  static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(277234);
      oTJ = new a("WAGameLiveShareTypeUnknown", 0, 0);
      oTK = new a("WAGameLiveShareTypeFriend", 1, 1);
      oTL = new a("WAGameLiveShareTypeMoment", 2, 2);
      oTM = new a[] { oTJ, oTK, oTL };
      AppMethodBeat.o(277234);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.f
 * JD-Core Version:    0.7.0.1
 */