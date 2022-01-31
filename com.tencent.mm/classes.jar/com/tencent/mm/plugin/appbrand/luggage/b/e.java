package com.tencent.mm.plugin.appbrand.luggage.b;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.c;
import com.tencent.mm.cd.g;
import com.tencent.mm.plugin.appbrand.widget.input.a.b.a;
import com.tencent.mm.pointers.PInt;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/luggage/customize/LuggageEmojiCompatByWechat;", "Lcom/tencent/mm/plugin/appbrand/widget/input/emoji/IEmojiCompat;", "()V", "getEmojiItemBySoftBank", "Lcom/tencent/mm/plugin/appbrand/widget/input/emoji/IEmojiCompat$EmojiInfo;", "codePoint", "", "getSmileySpan", "Landroid/text/SpannableString;", "context", "Landroid/content/Context;", "source", "", "sizePx", "", "replaceEmojiSpan", "Landroid/text/Spannable;", "ss", "sizeInPx", "maxNum", "Lcom/tencent/mm/pointers/PInt;", "factory", "Landroid/text/Spannable$Factory;", "plugin-appbrand-integration_release"})
public final class e
  implements com.tencent.mm.plugin.appbrand.widget.input.a.b
{
  public final Spannable a(Spannable paramSpannable, int paramInt, PInt paramPInt, Spannable.Factory paramFactory)
  {
    AppMethodBeat.i(143904);
    j.q(paramFactory, "factory");
    paramSpannable = com.tencent.mm.cd.b.duW().a(paramSpannable, paramInt, paramPInt, paramFactory);
    AppMethodBeat.o(143904);
    return paramSpannable;
  }
  
  public final SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(134724);
    paramContext = g.dvk().b(paramCharSequence, paramFloat);
    j.p(paramContext, "SmileyManager.getInstanc…(context, source, sizePx)");
    AppMethodBeat.o(134724);
    return paramContext;
  }
  
  public final b.a oM(int paramInt)
  {
    AppMethodBeat.i(134725);
    c localc = com.tencent.mm.cd.b.duW().Nn(paramInt);
    if (localc != null)
    {
      b.a locala = new b.a();
      locala.jpD = localc.jpD;
      locala.jpE = localc.jpE;
      locala.jpF = localc.jpF;
      AppMethodBeat.o(134725);
      return locala;
    }
    AppMethodBeat.o(134725);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.e
 * JD-Core Version:    0.7.0.1
 */