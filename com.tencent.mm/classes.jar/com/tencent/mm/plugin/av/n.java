package com.tencent.mm.plugin.av;

import android.graphics.Color;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsapi/WxPopupAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxPopupAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxPopupAPIContext;)V", "close", "", "popupId", "", "popup", "width", "", "height", "left", "top", "mode", "", "colorRGBA", "onDismissCallback", "onOuterClickCallback", "webview-sdk_release"})
public final class n
  extends a<o>
{
  public n(o paramo)
  {
    super("wxPopup", (b)paramo);
    AppMethodBeat.i(206732);
    AppMethodBeat.o(206732);
  }
  
  @JavascriptInterface
  public final void close(final String paramString)
  {
    AppMethodBeat.i(206730);
    p.k(paramString, "popupId");
    d.uiThread((kotlin.g.a.a)new a(this, paramString));
    AppMethodBeat.o(206730);
  }
  
  @JavascriptInterface
  public final void popup(final String paramString1, final Number paramNumber1, final Number paramNumber2, final Number paramNumber3, final Number paramNumber4, final int paramInt, String paramString2, final String paramString3, final String paramString4)
  {
    AppMethodBeat.i(206729);
    p.k(paramString1, "popupId");
    p.k(paramNumber1, "width");
    p.k(paramNumber2, "height");
    p.k(paramNumber3, "left");
    p.k(paramNumber4, "top");
    p.k(paramString2, "colorRGBA");
    p.k(paramString3, "onDismissCallback");
    p.k(paramString4, "onOuterClickCallback");
    Object localObject = new char[1];
    localObject[0] = 35;
    p.k(paramString2, "$this$trimStart");
    p.k(localObject, "chars");
    paramString2 = (CharSequence)paramString2;
    final int i = 0;
    int j = paramString2.length();
    if (i < j) {
      if (e.contains((char[])localObject, paramString2.charAt(i))) {}
    }
    for (paramString2 = paramString2.subSequence(i, paramString2.length());; paramString2 = (CharSequence)"")
    {
      paramString2 = paramString2.toString();
      if (paramString2 != null) {
        break label192;
      }
      paramString1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(206729);
      throw paramString1;
      i += 1;
      break;
    }
    label192:
    paramString2 = paramString2.toUpperCase();
    p.j(paramString2, "(this as java.lang.String).toUpperCase()");
    localObject = (CharSequence)paramString2;
    int k;
    if (new k("[A-F0-9]{8}").aY((CharSequence)localObject))
    {
      if (paramString2 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(206729);
        throw paramString1;
      }
      localObject = paramString2.substring(6, 8);
      p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      i = Integer.parseInt((String)localObject, kotlin.n.a.aFL(16));
      if (paramString2 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(206729);
        throw paramString1;
      }
      localObject = paramString2.substring(0, 2);
      p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      j = Integer.parseInt((String)localObject, kotlin.n.a.aFL(16));
      if (paramString2 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(206729);
        throw paramString1;
      }
      localObject = paramString2.substring(2, 4);
      p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      k = Integer.parseInt((String)localObject, kotlin.n.a.aFL(16));
      if (paramString2 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(206729);
        throw paramString1;
      }
      paramString2 = paramString2.substring(4, 6);
      p.j(paramString2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (i = Color.argb(i, j, k, Integer.parseInt(paramString2, kotlin.n.a.aFL(16)));; i = 0)
    {
      ((o)this.Pvj).bif(paramString1);
      d.uiThread((kotlin.g.a.a)new b(this, paramString1, paramNumber1, paramNumber2, paramNumber3, paramNumber4, paramInt, i, paramString3, paramString4));
      AppMethodBeat.o(206729);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(n paramn, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(n paramn, String paramString1, Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, int paramInt1, int paramInt2, String paramString2, String paramString3)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.av.n
 * JD-Core Version:    0.7.0.1
 */