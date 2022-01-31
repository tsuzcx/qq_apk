package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class d
  extends h
{
  private static final int CTRL_INDEX = 110;
  private static final String NAME = "insertTextArea";
  
  protected final i a(WeakReference<v> paramWeakReference, String paramString, int paramInt)
  {
    AppMethodBeat.i(123537);
    paramWeakReference = new d.2(this, paramWeakReference, paramInt, paramString);
    AppMethodBeat.o(123537);
    return paramWeakReference;
  }
  
  public final void a(v paramv, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(123534);
    super.a(paramv, paramJSONObject, paramInt);
    AppMethodBeat.o(123534);
  }
  
  protected final void a(i parami)
  {
    AppMethodBeat.i(123536);
    super.a(parami);
    parami.jlb = new d.1(this, parami);
    AppMethodBeat.o(123536);
  }
  
  protected final boolean a(e parame, JSONObject paramJSONObject, v paramv, int paramInt)
  {
    AppMethodBeat.i(123535);
    if (!super.a(parame, paramJSONObject, paramv, paramInt))
    {
      AppMethodBeat.o(123535);
      return false;
    }
    parame.jqY = Boolean.TRUE;
    parame.jqC = "emoji";
    parame.jqD = false;
    parame.jqE = false;
    parame.jre = Boolean.FALSE;
    parame.jqZ = Boolean.valueOf(paramJSONObject.optBoolean("confirm", true));
    AppMethodBeat.o(123535);
    return true;
  }
  
  protected final boolean aDa()
  {
    return false;
  }
  
  protected final boolean aDb()
  {
    return false;
  }
  
  static final class a
    extends p
  {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onTextAreaHeightChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.d
 * JD-Core Version:    0.7.0.1
 */