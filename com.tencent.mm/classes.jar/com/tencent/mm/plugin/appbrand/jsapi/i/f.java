package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelive.b.f;
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
      AppMethodBeat.i(325894);
      rYW = new a("WAGameLiveShareTypeUnknown", 0, 0);
      rYX = new a("WAGameLiveShareTypeFriend", 1, 1);
      rYY = new a("WAGameLiveShareTypeMoment", 2, 2);
      rYZ = new a[] { rYW, rYX, rYY };
      AppMethodBeat.o(325894);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.f
 * JD-Core Version:    0.7.0.1
 */