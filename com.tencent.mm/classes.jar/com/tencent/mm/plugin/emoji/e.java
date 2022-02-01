package com.tencent.mm.plugin.emoji;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.i.c.b;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/EmojiString;", "", "origin", "", "sizePx", "", "(Ljava/lang/String;I)V", "clipList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/emoji/EmojiString$Clip;", "Lkotlin/collections/ArrayList;", "getOrigin", "()Ljava/lang/String;", "getSizePx", "()I", "getTextCount", "mode", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter$Mode;", "subString", "length", "Clip", "ClipType", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private final String origin;
  private final int xFG;
  private final ArrayList<e.a> xFH;
  
  public e(String paramString, int paramInt)
  {
    AppMethodBeat.i(269749);
    this.origin = paramString;
    this.xFG = paramInt;
    this.xFH = new ArrayList();
    paramString = b.a(MMApplicationContext.getContext(), (CharSequence)this.origin, this.xFG);
    if ((paramString instanceof SpannableString))
    {
      Object localObject1 = (a[])((SpannableString)paramString).getSpans(0, paramString.length(), a.class);
      s.s(localObject1, "fixImageSpanList");
      k.a((Object[])localObject1, new e..ExternalSyntheticLambda0(paramString));
      int k = localObject1.length;
      int i = 0;
      Object localObject2;
      int j;
      for (paramInt = 0; i < k; paramInt = j)
      {
        localObject2 = localObject1[i];
        int m = ((SpannableString)paramString).getSpanStart(localObject2);
        j = ((SpannableString)paramString).getSpanEnd(localObject2);
        if (paramInt < m)
        {
          localObject2 = this.xFH;
          localb = b.xFK;
          str = this.origin;
          if (str == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(269749);
            throw paramString;
          }
          str = str.substring(paramInt, m);
          s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          ((ArrayList)localObject2).add(new e.a(paramInt, m, localb, str));
        }
        localObject2 = this.xFH;
        b localb = b.xFJ;
        String str = this.origin;
        if (str == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(269749);
          throw paramString;
        }
        str = str.substring(m, j);
        s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        ((ArrayList)localObject2).add(new e.a(m, j, localb, str));
        i += 1;
      }
      if (paramInt < this.origin.length())
      {
        paramString = this.xFH;
        i = this.origin.length();
        localObject1 = b.xFK;
        localObject2 = this.origin;
        j = this.origin.length();
        if (localObject2 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(269749);
          throw paramString;
        }
        localObject2 = ((String)localObject2).substring(paramInt, j);
        s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramString.add(new e.a(paramInt, i, (b)localObject1, (String)localObject2));
      }
    }
    AppMethodBeat.o(269749);
  }
  
  private static final int a(CharSequence paramCharSequence, a parama1, a parama2)
  {
    AppMethodBeat.i(269751);
    int i = ((SpannableString)paramCharSequence).getSpanStart(parama1);
    int j = ((SpannableString)paramCharSequence).getSpanStart(parama2);
    AppMethodBeat.o(269751);
    return i - j;
  }
  
  public final int a(g.a parama)
  {
    AppMethodBeat.i(269753);
    s.u(parama, "mode");
    int i = 0;
    Iterator localIterator = ((Iterable)this.xFH).iterator();
    if (localIterator.hasNext())
    {
      e.a locala = (e.a)localIterator.next();
      b localb = locala.xFI;
      switch (c.$EnumSwitchMapping$0[localb.ordinal()])
      {
      default: 
        parama = new p();
        AppMethodBeat.o(269753);
        throw parama;
      }
      for (int j = g.a(locala.content, parama);; j = 2)
      {
        i = j + i;
        break;
      }
    }
    AppMethodBeat.o(269753);
    return i;
  }
  
  public final String b(int paramInt, g.a parama)
  {
    AppMethodBeat.i(269754);
    s.u(parama, "mode");
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = (e)this;
    int i = 0;
    localObject = ((Iterable)((e)localObject).xFH).iterator();
    if (((Iterator)localObject).hasNext())
    {
      e.a locala = (e.a)((Iterator)localObject).next();
      b localb = locala.xFI;
      int j;
      switch (c.$EnumSwitchMapping$0[localb.ordinal()])
      {
      default: 
        parama = new p();
        AppMethodBeat.o(269754);
        throw parama;
      case 1: 
        j = g.a(locala.content, parama);
        label130:
        if (i + j <= paramInt) {
          localStringBuffer.append(locala.content);
        }
        break;
      }
      while (i + j <= paramInt)
      {
        i += j;
        break;
        j = 2;
        break label130;
      }
      if ((locala.xFI == b.xFK) && (i < paramInt)) {
        localStringBuffer.append(g.jd(locala.content, paramInt - i));
      }
    }
    parama = localStringBuffer.toString();
    s.s(parama, "outputBuffer.toString()");
    AppMethodBeat.o(269754);
    return parama;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/EmojiString$ClipType;", "", "(Ljava/lang/String;I)V", "EMOJI", "WORD", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(269747);
      xFJ = new b("EMOJI", 0);
      xFK = new b("WORD", 1);
      xFL = new b[] { xFJ, xFK };
      AppMethodBeat.o(269747);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e
 * JD-Core Version:    0.7.0.1
 */