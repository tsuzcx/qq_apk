package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cf.c;
import com.tencent.mm.plugin.appbrand.widget.input.a.b.a;
import com.tencent.mm.pointers.PInt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/customize/LuggageEmojiCompatByWechat;", "Lcom/tencent/mm/plugin/appbrand/widget/input/emoji/IEmojiCompat;", "()V", "getEmojiItemBySoftBank", "Lcom/tencent/mm/plugin/appbrand/widget/input/emoji/IEmojiCompat$EmojiInfo;", "codePoint", "", "getSmileySpan", "Landroid/text/SpannableString;", "context", "Landroid/content/Context;", "source", "", "sizePx", "", "replaceEmojiSpan", "Landroid/text/Spannable;", "ss", "sizeInPx", "maxNum", "Lcom/tencent/mm/pointers/PInt;", "factory", "Landroid/text/Spannable$Factory;", "plugin-appbrand-integration_release"})
public final class d
  implements com.tencent.mm.plugin.appbrand.widget.input.a.b
{
  public static final d lOd;
  
  static
  {
    AppMethodBeat.i(50854);
    lOd = new d();
    com.tencent.mm.plugin.appbrand.app.g.La("com.tencent.mm.plugin.emoji.PluginEmoji");
    AppMethodBeat.o(50854);
  }
  
  public final Spannable a(Spannable paramSpannable, int paramInt, PInt paramPInt, Spannable.Factory paramFactory)
  {
    AppMethodBeat.i(50853);
    p.h(paramFactory, "factory");
    paramSpannable = com.tencent.mm.cf.b.fmR().a(paramSpannable, paramInt, paramPInt, paramFactory);
    AppMethodBeat.o(50853);
    return paramSpannable;
  }
  
  public final SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(50851);
    paramContext = com.tencent.mm.cf.g.fng().b(paramCharSequence, paramFloat);
    p.g(paramContext, "SmileyManager.getInstanc…(context, source, sizePx)");
    AppMethodBeat.o(50851);
    return paramContext;
  }
  
  public final b.a uv(int paramInt)
  {
    AppMethodBeat.i(50852);
    c localc = com.tencent.mm.cf.b.fmR().aaC(paramInt);
    if (localc != null)
    {
      b.a locala = new b.a();
      locala.nhS = localc.nhS;
      locala.nhT = localc.nhT;
      locala.nhU = localc.nhU;
      AppMethodBeat.o(50852);
      return locala;
    }
    AppMethodBeat.o(50852);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.d
 * JD-Core Version:    0.7.0.1
 */