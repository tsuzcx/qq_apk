package com.tencent.mm.plugin.emoji;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.c.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.smiley.EmojiHelper;
import com.tencent.mm.smiley.QQSmileyManager;
import com.tencent.mm.smiley.QQSmileyManager.d;
import com.tencent.mm.smiley.m;
import com.tencent.mm.smiley.t;
import com.tencent.mm.smiley.u;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;

public final class b
  implements a
{
  public final SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(104526);
    paramContext = u.iVt().a(paramContext, paramCharSequence, paramFloat);
    AppMethodBeat.o(104526);
    return paramContext;
  }
  
  public final boolean aa(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104529);
    boolean bool = u.iVt().aa(paramCharSequence);
    AppMethodBeat.o(104529);
    return bool;
  }
  
  public final boolean ab(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104530);
    boolean bool = u.iVt().ab(paramCharSequence);
    AppMethodBeat.o(104530);
    return bool;
  }
  
  public final String anH(String paramString)
  {
    AppMethodBeat.i(104531);
    EmojiHelper.iUM();
    paramString = EmojiHelper.anH(paramString);
    AppMethodBeat.o(104531);
    return paramString;
  }
  
  public final SpannableString b(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(104527);
    paramContext = p.b(paramContext, paramCharSequence, paramFloat);
    AppMethodBeat.o(104527);
    return paramContext;
  }
  
  public final String gF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104528);
    u.iVt();
    QQSmileyManager localQQSmileyManager = QQSmileyManager.iVq();
    s.u(paramString1, "content");
    s.u(paramString2, "replacement");
    int i = paramString1.length();
    StringBuilder localStringBuilder = new StringBuilder();
    ah.d locald = new ah.d();
    localQQSmileyManager.acyI.a((CharSequence)paramString1, 0, i, (m)new QQSmileyManager.d(localStringBuilder, paramString1, locald, paramString2));
    if (locald.aixb < i) {
      localStringBuilder.append((CharSequence)paramString1, locald.aixb, i);
    }
    paramString1 = localStringBuilder.toString();
    s.s(paramString1, "sb.toString()");
    AppMethodBeat.o(104528);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.b
 * JD-Core Version:    0.7.0.1
 */