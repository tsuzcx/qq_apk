package com.tencent.mm.plugin.emoji;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.h.c.b;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emoji/EmojiString;", "", "origin", "", "sizePx", "", "(Ljava/lang/String;I)V", "clipList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/emoji/EmojiString$Clip;", "Lkotlin/collections/ArrayList;", "getOrigin", "()Ljava/lang/String;", "getSizePx", "()I", "getTextCount", "mode", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter$Mode;", "subString", "length", "Clip", "ClipType", "plugin-emojisdk_release"})
public final class e
{
  private final String origin;
  private final ArrayList<a> uzf;
  private final int uzg;
  
  public e(String paramString, int paramInt)
  {
    AppMethodBeat.i(231407);
    this.origin = paramString;
    this.uzg = paramInt;
    this.uzf = new ArrayList();
    paramString = b.a(MMApplicationContext.getContext(), (CharSequence)this.origin, this.uzg);
    if ((paramString instanceof SpannableString))
    {
      Object localObject1 = (a[])((SpannableString)paramString).getSpans(0, paramString.length(), a.class);
      p.j(localObject1, "fixImageSpanList");
      kotlin.a.e.a((Object[])localObject1, (Comparator)new Comparator() {});
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
          localObject2 = this.uzf;
          localb = b.uzk;
          str = this.origin;
          if (str == null)
          {
            paramString = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(231407);
            throw paramString;
          }
          str = str.substring(paramInt, m);
          p.j(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          ((ArrayList)localObject2).add(new a(paramInt, m, localb, str));
        }
        localObject2 = this.uzf;
        b localb = b.uzj;
        String str = this.origin;
        if (str == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(231407);
          throw paramString;
        }
        str = str.substring(m, j);
        p.j(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        ((ArrayList)localObject2).add(new a(m, j, localb, str));
        i += 1;
      }
      if (paramInt < this.origin.length())
      {
        paramString = this.uzf;
        i = this.origin.length();
        localObject1 = b.uzk;
        localObject2 = this.origin;
        j = this.origin.length();
        if (localObject2 == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(231407);
          throw paramString;
        }
        localObject2 = ((String)localObject2).substring(paramInt, j);
        p.j(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramString.add(new a(paramInt, i, (b)localObject1, (String)localObject2));
      }
    }
    AppMethodBeat.o(231407);
  }
  
  public final int a(g.a parama)
  {
    AppMethodBeat.i(231404);
    p.k(parama, "mode");
    int i = 0;
    Iterator localIterator = ((Iterable)this.uzf).iterator();
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      b localb = locala.uzi;
      switch (f.$EnumSwitchMapping$0[localb.ordinal()])
      {
      default: 
        parama = new m();
        AppMethodBeat.o(231404);
        throw parama;
      }
      for (int j = g.a(locala.content, parama);; j = 2)
      {
        i = j + i;
        break;
      }
    }
    AppMethodBeat.o(231404);
    return i;
  }
  
  public final String b(int paramInt, g.a parama)
  {
    AppMethodBeat.i(231405);
    p.k(parama, "mode");
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = (e)this;
    int i = 0;
    localObject = ((Iterable)((e)localObject).uzf).iterator();
    if (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      b localb = locala.uzi;
      int j;
      switch (f.jLJ[localb.ordinal()])
      {
      default: 
        parama = new m();
        AppMethodBeat.o(231405);
        throw parama;
      case 1: 
        j = g.a(locala.content, parama);
        label130:
        if (i + j <= paramInt) {
          p.j(localStringBuffer.append(locala.content), "outputBuffer.append(clip.content)");
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
      if ((locala.uzi == b.uzk) && (i < paramInt)) {
        localStringBuffer.append(g.hV(locala.content, paramInt - i));
      }
    }
    parama = localStringBuffer.toString();
    p.j(parama, "outputBuffer.toString()");
    AppMethodBeat.o(231405);
    return parama;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emoji/EmojiString$Clip;", "", "start", "", "end", "type", "Lcom/tencent/mm/plugin/emoji/EmojiString$ClipType;", "content", "", "(IILcom/tencent/mm/plugin/emoji/EmojiString$ClipType;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getEnd", "()I", "getStart", "getType", "()Lcom/tencent/mm/plugin/emoji/EmojiString$ClipType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-emojisdk_release"})
  public static final class a
  {
    final String content;
    private final int end;
    private final int start;
    final e.b uzi;
    
    public a(int paramInt1, int paramInt2, e.b paramb, String paramString)
    {
      AppMethodBeat.i(224957);
      this.start = paramInt1;
      this.end = paramInt2;
      this.uzi = paramb;
      this.content = paramString;
      AppMethodBeat.o(224957);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(224964);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.start != paramObject.start) || (this.end != paramObject.end) || (!p.h(this.uzi, paramObject.uzi)) || (!p.h(this.content, paramObject.content))) {}
        }
      }
      else
      {
        AppMethodBeat.o(224964);
        return true;
      }
      AppMethodBeat.o(224964);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(224962);
      int k = this.start;
      int m = this.end;
      Object localObject = this.uzi;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.content;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(224962);
        return (i + (k * 31 + m) * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(224959);
      String str = "Clip(start=" + this.start + ", end=" + this.end + ", type=" + this.uzi + ", content=" + this.content + ")";
      AppMethodBeat.o(224959);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emoji/EmojiString$ClipType;", "", "(Ljava/lang/String;I)V", "EMOJI", "WORD", "plugin-emojisdk_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(224597);
      b localb1 = new b("EMOJI", 0);
      uzj = localb1;
      b localb2 = new b("WORD", 1);
      uzk = localb2;
      uzl = new b[] { localb1, localb2 };
      AppMethodBeat.o(224597);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e
 * JD-Core Version:    0.7.0.1
 */