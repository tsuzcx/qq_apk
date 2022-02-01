package com.tencent.mm.plugin.ax;

import android.graphics.Color;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsapi/WxPopupAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxPopupAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxPopupAPIContext;)V", "close", "", "popupId", "", "popup", "width", "", "height", "left", "top", "mode", "", "colorRGBA", "onDismissCallback", "onOuterClickCallback", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends a<o>
{
  public n(o paramo)
  {
    super("wxPopup", (b)paramo);
    AppMethodBeat.i(260802);
    AppMethodBeat.o(260802);
  }
  
  @JavascriptInterface
  public final void close(final String paramString)
  {
    AppMethodBeat.i(260825);
    s.u(paramString, "popupId");
    d.uiThread((kotlin.g.a.a)new a(this, paramString));
    AppMethodBeat.o(260825);
  }
  
  @JavascriptInterface
  public final void popup(final String paramString1, final Number paramNumber1, final Number paramNumber2, final Number paramNumber3, final Number paramNumber4, final int paramInt, String paramString2, final String paramString3, final String paramString4)
  {
    AppMethodBeat.i(260817);
    s.u(paramString1, "popupId");
    s.u(paramNumber1, "width");
    s.u(paramNumber2, "height");
    s.u(paramNumber3, "left");
    s.u(paramNumber4, "top");
    s.u(paramString2, "colorRGBA");
    s.u(paramString3, "onDismissCallback");
    s.u(paramString4, "onOuterClickCallback");
    Object localObject = new char[1];
    localObject[0] = 35;
    s.u(paramString2, "$this$trimStart");
    s.u(localObject, "chars");
    paramString2 = (CharSequence)paramString2;
    final int i = 0;
    int j = paramString2.length();
    if (i < j) {
      if (kotlin.a.k.contains((char[])localObject, paramString2.charAt(i))) {}
    }
    for (paramString2 = paramString2.subSequence(i, paramString2.length());; paramString2 = (CharSequence)"")
    {
      paramString2 = paramString2.toString();
      if (paramString2 != null) {
        break label192;
      }
      paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(260817);
      throw paramString1;
      i += 1;
      break;
    }
    label192:
    paramString2 = paramString2.toUpperCase();
    s.s(paramString2, "(this as java.lang.String).toUpperCase()");
    localObject = (CharSequence)paramString2;
    int k;
    if (new kotlin.n.k("[A-F0-9]{8}").bm((CharSequence)localObject))
    {
      if (paramString2 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(260817);
        throw paramString1;
      }
      localObject = paramString2.substring(6, 8);
      s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      i = Integer.parseInt((String)localObject, kotlin.n.a.aMy(16));
      if (paramString2 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(260817);
        throw paramString1;
      }
      localObject = paramString2.substring(0, 2);
      s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      j = Integer.parseInt((String)localObject, kotlin.n.a.aMy(16));
      if (paramString2 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(260817);
        throw paramString1;
      }
      localObject = paramString2.substring(2, 4);
      s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      k = Integer.parseInt((String)localObject, kotlin.n.a.aMy(16));
      if (paramString2 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(260817);
        throw paramString1;
      }
      paramString2 = paramString2.substring(4, 6);
      s.s(paramString2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (i = Color.argb(i, j, k, Integer.parseInt(paramString2, kotlin.n.a.aMy(16)));; i = 0)
    {
      ((o)this.WlE).bhR(paramString1);
      d.uiThread((kotlin.g.a.a)new b(this, paramString1, paramNumber1, paramNumber2, paramNumber3, paramNumber4, paramInt, i, paramString3, paramString4));
      AppMethodBeat.o(260817);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(n paramn, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(n paramn, String paramString1, Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, int paramInt1, int paramInt2, String paramString2, String paramString3)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.n
 * JD-Core Version:    0.7.0.1
 */