package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$FAILED;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
public final class b$c
  extends b
{
  final String message;
  
  public b$c(String paramString)
  {
    super((byte)0);
    this.message = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(143781);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if (!j.e(this.message, paramObject.message)) {}
      }
    }
    else
    {
      AppMethodBeat.o(143781);
      return true;
    }
    AppMethodBeat.o(143781);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(143780);
    String str = this.message;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(143780);
      return i;
    }
    AppMethodBeat.o(143780);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(143779);
    String str = "FAILED(message=" + this.message + ")";
    AppMethodBeat.o(143779);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.b.c
 * JD-Core Version:    0.7.0.1
 */