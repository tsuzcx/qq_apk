package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.k;
import com.tencent.mm.plugin.appbrand.widget.input.a.b;
import com.tencent.mm.plugin.appbrand.widget.input.a.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.smiley.EmojiHelper;
import com.tencent.mm.smiley.QQSmileyManager;
import com.tencent.mm.smiley.QQSmileyManager.a;
import com.tencent.mm.smiley.u;
import com.tencent.mm.smiley.w;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/customize/LuggageEmojiCompatByWechat;", "Lcom/tencent/mm/plugin/appbrand/widget/input/emoji/IEmojiCompat;", "()V", "getEmojiItemBySoftBank", "Lcom/tencent/mm/plugin/appbrand/widget/input/emoji/IEmojiCompat$EmojiInfo;", "codePoint", "", "getSmileySpan", "Landroid/text/SpannableString;", "context", "Landroid/content/Context;", "source", "", "sizePx", "", "replaceEmojiSpan", "Landroid/text/Spannable;", "ss", "sizeInPx", "maxNum", "Lcom/tencent/mm/pointers/PInt;", "factory", "Landroid/text/Spannable$Factory;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements b
{
  public static final d tfy;
  
  static
  {
    AppMethodBeat.i(50854);
    tfy = new d();
    k.UT("com.tencent.mm.plugin.emoji.PluginEmoji");
    AppMethodBeat.o(50854);
  }
  
  public final b.a Ch(int paramInt)
  {
    AppMethodBeat.i(50852);
    EmojiHelper.iUM();
    w localw = EmojiHelper.ayo(paramInt);
    if (localw == null)
    {
      AppMethodBeat.o(50852);
      return null;
    }
    b.a locala = new b.a();
    if (localw.mdx.length > 0) {
      locala.uKE = localw.mdx[0];
    }
    if (localw.mdx.length > 1) {
      locala.uKF = localw.mdx[1];
    }
    EmojiHelper.iUM();
    locala.uKG = EmojiHelper.a(localw);
    AppMethodBeat.o(50852);
    return locala;
  }
  
  public final Spannable a(Spannable paramSpannable, int paramInt, PInt paramPInt, Spannable.Factory paramFactory)
  {
    AppMethodBeat.i(50853);
    s.u(paramFactory, "factory");
    EmojiHelper.iUM();
    paramSpannable = EmojiHelper.a(paramSpannable, paramInt, paramPInt);
    paramPInt = QQSmileyManager.acyx;
    QQSmileyManager.a.iVq().a(paramSpannable, paramInt);
    AppMethodBeat.o(50853);
    return paramSpannable;
  }
  
  public final SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(50851);
    paramContext = u.iVt().a(paramContext, paramCharSequence, paramFloat);
    s.s(paramContext, "getInstance().getSmileyS…(context, source, sizePx)");
    AppMethodBeat.o(50851);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.d
 * JD-Core Version:    0.7.0.1
 */