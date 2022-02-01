package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.c;
import com.tencent.mm.ce.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.widget.input.a.b.a;
import com.tencent.mm.pointers.PInt;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/customize/LuggageEmojiCompatByWechat;", "Lcom/tencent/mm/plugin/appbrand/widget/input/emoji/IEmojiCompat;", "()V", "getEmojiItemBySoftBank", "Lcom/tencent/mm/plugin/appbrand/widget/input/emoji/IEmojiCompat$EmojiInfo;", "codePoint", "", "getSmileySpan", "Landroid/text/SpannableString;", "context", "Landroid/content/Context;", "source", "", "sizePx", "", "replaceEmojiSpan", "Landroid/text/Spannable;", "ss", "sizeInPx", "maxNum", "Lcom/tencent/mm/pointers/PInt;", "factory", "Landroid/text/Spannable$Factory;", "plugin-appbrand-integration_release"})
public final class d
  implements com.tencent.mm.plugin.appbrand.widget.input.a.b
{
  public static final d nae;
  
  static
  {
    AppMethodBeat.i(50854);
    nae = new d();
    j.UJ("com.tencent.mm.plugin.emoji.PluginEmoji");
    AppMethodBeat.o(50854);
  }
  
  public final Spannable a(Spannable paramSpannable, int paramInt, PInt paramPInt, Spannable.Factory paramFactory)
  {
    AppMethodBeat.i(50853);
    p.h(paramFactory, "factory");
    paramSpannable = com.tencent.mm.ce.b.gxI().a(paramSpannable, paramInt, paramPInt, paramFactory);
    AppMethodBeat.o(50853);
    return paramSpannable;
  }
  
  public final SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(50851);
    paramContext = g.gxZ().a(paramContext, paramCharSequence, paramFloat);
    p.g(paramContext, "SmileyManager.getInstanc…(context, source, sizePx)");
    AppMethodBeat.o(50851);
    return paramContext;
  }
  
  public final b.a ys(int paramInt)
  {
    AppMethodBeat.i(50852);
    c localc = com.tencent.mm.ce.b.gxI().ajN(paramInt);
    if (localc != null)
    {
      b.a locala = new b.a();
      locala.owH = localc.owH;
      locala.owI = localc.owI;
      locala.owJ = localc.owJ;
      AppMethodBeat.o(50852);
      return locala;
    }
    AppMethodBeat.o(50852);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.d
 * JD-Core Version:    0.7.0.1
 */