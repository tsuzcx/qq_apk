package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "", "flag", "", "getFlag", "()I", "name", "", "getName", "()Ljava/lang/String;", "contains", "", "flags", "equals", "Parser", "plugin-appbrand-integration_release"})
public abstract interface m$b
{
  public static final m.b.b hSE = m.b.b.hSF;
  
  public abstract int aDR();
  
  public abstract String getName();
  
  @l(eaO={1, 1, 13})
  public static final class a
  {
    public static boolean a(m.b paramb, int paramInt)
    {
      AppMethodBeat.i(143832);
      if (paramInt == paramb.aDR())
      {
        AppMethodBeat.o(143832);
        return true;
      }
      AppMethodBeat.o(143832);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.m.b
 * JD-Core Version:    0.7.0.1
 */