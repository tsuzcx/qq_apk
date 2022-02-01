package com.tencent.mm.plugin.editor.model.nativenote.a;

import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ParagraphStyle;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.f;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;
import com.tencent.mm.plugin.editor.model.nativenote.manager.i;
import com.tencent.mm.plugin.editor.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.editor.model.nativenote.spans.a;
import com.tencent.mm.plugin.editor.model.nativenote.spans.d;
import com.tencent.mm.plugin.editor.model.nativenote.spans.k;
import com.tencent.mm.plugin.editor.model.nativenote.spans.l;
import com.tencent.mm.plugin.editor.model.nativenote.spans.o;
import com.tencent.mm.plugin.editor.model.nativenote.spans.p;
import com.tencent.mm.plugin.editor.model.nativenote.spans.s;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public final class b
{
  private static int a(Stack<a> paramStack, StringBuilder paramStringBuilder)
  {
    int i = 0;
    AppMethodBeat.i(181702);
    if (!paramStack.isEmpty())
    {
      paramStack = (a)paramStack.pop();
      String str = paramStack.xBB.xBY;
      int j = paramStack.xBD;
      while (i < j)
      {
        paramStringBuilder.append(str);
        i += 1;
      }
      i = paramStack.xBD;
      AppMethodBeat.o(181702);
      return i;
    }
    AppMethodBeat.o(181702);
    return 0;
  }
  
  public static String a(Spanned paramSpanned)
  {
    AppMethodBeat.i(181695);
    if ((paramSpanned == null) || (Util.isNullOrNil(paramSpanned.toString())))
    {
      AppMethodBeat.o(181695);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    a(paramSpanned, localStringBuilder);
    paramSpanned = localStringBuilder.toString();
    AppMethodBeat.o(181695);
    return paramSpanned;
  }
  
  private static Set<p> a(Spanned paramSpanned, g paramg)
  {
    AppMethodBeat.i(181700);
    HashSet localHashSet = new HashSet();
    paramSpanned = (ParagraphStyle[])paramSpanned.getSpans(paramg.uG, paramg.uH, ParagraphStyle.class);
    int j = paramSpanned.length;
    int i = 0;
    while (i < j)
    {
      paramg = paramSpanned[i];
      o localo = o.a(paramg);
      if (localo != null) {
        localHashSet.add(new p(localo, paramg));
      }
      i += 1;
    }
    AppMethodBeat.o(181700);
    return localHashSet;
  }
  
  private static void a(Spanned paramSpanned, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(181696);
    ArrayList localArrayList = new i(paramSpanned).xAm;
    Stack localStack = new Stack();
    int m = localArrayList.size();
    int i = 0;
    if (i < m)
    {
      l locall = (l)localArrayList.get(i);
      Object localObject2 = a(paramSpanned, locall);
      o localo = null;
      Object localObject3 = ((Set)localObject2).iterator();
      do
      {
        localObject1 = localo;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (p)((Iterator)localObject3).next();
      } while (!((p)localObject1).xBB.xBZ);
      Object localObject1 = ((p)localObject1).xBB;
      int j = 0;
      localo = o.xBT;
      localObject2 = ((Set)localObject2).iterator();
      int k;
      label191:
      Object localObject4;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (p)((Iterator)localObject2).next();
        boolean bool;
        if ((((p)localObject3).xBB.dxv()) || (((p)localObject3).xBB.dxw()) || (((p)localObject3).xBB.dxx()))
        {
          k = 1;
          j += k;
          localObject4 = ((p)localObject3).xBB;
          if (!((p)localObject3).xBB.dxv()) {
            break label246;
          }
          bool = ((d)((p)localObject3).xCf).xBH;
          label227:
          if (!bool) {
            break label306;
          }
          localo = o.xBT;
        }
        for (;;)
        {
          break;
          k = 0;
          break label191;
          label246:
          if (((p)localObject3).xBB.dxw())
          {
            bool = ((k)((p)localObject3).xCf).xBH;
            break label227;
          }
          if (((p)localObject3).xBB.dxx())
          {
            bool = ((s)((p)localObject3).xCf).xBH;
            break label227;
          }
          bool = true;
          break label227;
          label306:
          if (((o)localObject4).dxv()) {
            localo = o.xBU;
          } else if (((o)localObject4).dxw()) {
            localo = o.xBV;
          } else if (((o)localObject4).dxx()) {
            localo = o.xBW;
          }
        }
      }
      a(localStack, paramStringBuilder, new a(localo, j, 0));
      if (localo.dxx())
      {
        localObject2 = (s[])paramSpanned.getSpans(locall.uG, locall.uH, s.class);
        if (localObject2.length > 0)
        {
          localo.xCd = localObject2[0].xCk;
          j = localo.xCa.indexOf("\"") + 1;
          k = localo.xCa.lastIndexOf("\"");
          if (j < k)
          {
            localObject3 = localo.xCa.substring(j, k);
            if (!Util.isNullOrNil((String)localObject3))
            {
              localObject4 = ((String)localObject3).trim();
              if (!localo.xCd) {
                break label671;
              }
              localObject2 = "1";
              label494:
              if (!((String)localObject4).equals(localObject2))
              {
                localObject4 = localo.xCa;
                if (!localo.xCd) {
                  break label679;
                }
              }
            }
          }
        }
      }
      label671:
      label679:
      for (localObject2 = "1";; localObject2 = "0")
      {
        localo.xCa = ((String)localObject4).replaceAll((String)localObject3, (String)localObject2);
        paramStringBuilder.append(localo.xCa);
        if (localObject1 != null) {
          paramStringBuilder.append(((o)localObject1).xBX);
        }
        j = locall.uG;
        k = locall.uH;
        localObject2 = new TreeSet(new b.1(paramSpanned));
        ((SortedSet)localObject2).addAll(Arrays.asList((CharacterStyle[])paramSpanned.getSpans(j, k, CharacterStyle.class)));
        a(paramSpanned, paramStringBuilder, j, k, (SortedSet)localObject2);
        if (localObject1 != null)
        {
          a(paramStringBuilder, (o)localObject1);
          paramStringBuilder.append(((o)localObject1).xBY);
        }
        a(paramStringBuilder, localo);
        paramStringBuilder.append(localo.xCb);
        i += 1;
        break;
        localObject2 = "0";
        break label494;
      }
    }
    while (!localStack.isEmpty()) {
      a(localStack, paramStringBuilder);
    }
    AppMethodBeat.o(181696);
  }
  
  private static void a(Spanned paramSpanned, StringBuilder paramStringBuilder, int paramInt1, int paramInt2, SortedSet<CharacterStyle> paramSortedSet)
  {
    AppMethodBeat.i(181697);
    if (paramInt1 < paramInt2)
    {
      CharacterStyle localCharacterStyle;
      label24:
      int i;
      if (paramSortedSet.isEmpty())
      {
        localCharacterStyle = null;
        if (localCharacterStyle != null) {
          break label83;
        }
        i = 2147483647;
        label34:
        if (localCharacterStyle != null) {
          break label96;
        }
      }
      label83:
      label96:
      for (int j = 2147483647;; j = paramSpanned.getSpanEnd(localCharacterStyle))
      {
        if (paramInt1 >= i) {
          break label109;
        }
        a(paramSpanned, paramStringBuilder, paramInt1, Math.min(paramInt2, i));
        paramInt1 = i;
        break;
        localCharacterStyle = (CharacterStyle)paramSortedSet.first();
        break label24;
        i = paramSpanned.getSpanStart(localCharacterStyle);
        break label34;
      }
      label109:
      paramSortedSet.remove(localCharacterStyle);
      if ((localCharacterStyle instanceof BoldSpan))
      {
        paramStringBuilder.append("<wx-b>");
        label135:
        a(paramSpanned, paramStringBuilder, Math.max(i, paramInt1), Math.min(j, paramInt2), paramSortedSet);
        if (!(localCharacterStyle instanceof ForegroundColorSpan)) {
          break label503;
        }
        paramStringBuilder.append("</wx-font>");
      }
      for (;;)
      {
        paramInt1 = j;
        break;
        if (((localCharacterStyle instanceof StyleSpan)) && (((StyleSpan)localCharacterStyle).getStyle() == 1))
        {
          paramStringBuilder.append("<wx-b>");
          break label135;
        }
        if (((localCharacterStyle instanceof StyleSpan)) && (((StyleSpan)localCharacterStyle).getStyle() == 2))
        {
          paramStringBuilder.append("<i>");
          break label135;
        }
        if ((localCharacterStyle instanceof UnderlineSpan))
        {
          paramStringBuilder.append("<u>");
          break label135;
        }
        if ((localCharacterStyle instanceof RelativeSizeSpan))
        {
          paramStringBuilder.append("<wx-font style=\"font-size:");
          paramStringBuilder.append(f.JP((int)(((RelativeSizeSpan)localCharacterStyle).getSizeChange() * f.getTextSize())));
          paramStringBuilder.append("px\">");
          break label135;
        }
        if ((localCharacterStyle instanceof AbsoluteSizeSpan))
        {
          paramStringBuilder.append("<wx-font style=\"font-size:");
          paramStringBuilder.append(f.JP(((AbsoluteSizeSpan)localCharacterStyle).getSize()));
          paramStringBuilder.append("px\">");
          break label135;
        }
        if ((localCharacterStyle instanceof ForegroundColorSpan))
        {
          paramStringBuilder.append("<wx-font style=\"color:#");
          for (str = Integer.toHexString(((ForegroundColorSpan)localCharacterStyle).getForegroundColor() + 16777216); str.length() < 6; str = "0".concat(String.valueOf(str))) {}
          paramStringBuilder.append(str);
          paramStringBuilder.append("\">");
          break label135;
        }
        if (!(localCharacterStyle instanceof BackgroundColorSpan)) {
          break label135;
        }
        paramStringBuilder.append("<wx-font style=\"background-color:#");
        for (String str = Integer.toHexString(((BackgroundColorSpan)localCharacterStyle).getBackgroundColor() + 16777216); str.length() < 6; str = "0".concat(String.valueOf(str))) {}
        paramStringBuilder.append(str);
        paramStringBuilder.append("\">");
        break label135;
        label503:
        if ((localCharacterStyle instanceof BackgroundColorSpan)) {
          paramStringBuilder.append("</wx-font>");
        } else if ((localCharacterStyle instanceof AbsoluteSizeSpan)) {
          paramStringBuilder.append("</wx-font>");
        } else if ((localCharacterStyle instanceof UnderlineSpan)) {
          paramStringBuilder.append("</u>");
        } else if ((localCharacterStyle instanceof BoldSpan)) {
          paramStringBuilder.append("</wx-b>");
        } else if (((localCharacterStyle instanceof StyleSpan)) && (((StyleSpan)localCharacterStyle).getStyle() == 2)) {
          paramStringBuilder.append("</i>");
        } else if (((localCharacterStyle instanceof StyleSpan)) && (((StyleSpan)localCharacterStyle).getStyle() == 1)) {
          paramStringBuilder.append("</wx-b>");
        } else if ((localCharacterStyle instanceof RelativeSizeSpan)) {
          paramStringBuilder.append("</wx-font>");
        }
      }
    }
    AppMethodBeat.o(181697);
  }
  
  public static void a(CharSequence paramCharSequence, StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181698);
    if (paramInt1 < paramInt2)
    {
      char c = paramCharSequence.charAt(paramInt1);
      if (c == '\n') {
        paramStringBuilder.append("<br/>");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        if (c == '<')
        {
          paramStringBuilder.append("&lt;");
        }
        else if (c == '>')
        {
          paramStringBuilder.append("&gt;");
        }
        else if (c == '&')
        {
          paramStringBuilder.append("&amp;");
        }
        else if (c == ' ')
        {
          while ((paramInt1 + 1 < paramInt2) && (paramCharSequence.charAt(paramInt1 + 1) == ' '))
          {
            paramStringBuilder.append("&nbsp;");
            paramInt1 += 1;
          }
          paramStringBuilder.append(' ');
        }
        else if (c < ' ')
        {
          paramStringBuilder.append("&#" + c + ";");
        }
        else
        {
          paramStringBuilder.append(c);
        }
      }
    }
    AppMethodBeat.o(181698);
  }
  
  private static void a(StringBuilder paramStringBuilder, o paramo)
  {
    AppMethodBeat.i(181699);
    if ((paramo.xCc) && (paramStringBuilder.length() >= 5))
    {
      int i = paramStringBuilder.length() - 5;
      int j = paramStringBuilder.length();
      if (paramStringBuilder.subSequence(i, j).equals("<br/>")) {
        paramStringBuilder.delete(i, j);
      }
    }
    AppMethodBeat.o(181699);
  }
  
  private static void a(Stack<a> paramStack, StringBuilder paramStringBuilder, a parama)
  {
    AppMethodBeat.i(181701);
    Object localObject;
    for (;;)
    {
      int i = 0;
      localObject = o.xBT;
      if (!paramStack.isEmpty())
      {
        localObject = (a)paramStack.peek();
        i = ((a)localObject).xBC;
        localObject = ((a)localObject).xBB;
      }
      if (parama.xBC > i)
      {
        parama.xBD = (parama.xBC - i);
        b(paramStack, paramStringBuilder, parama);
        AppMethodBeat.o(181701);
        return;
      }
      if (parama.xBC >= i) {
        break;
      }
      a(paramStack, paramStringBuilder);
    }
    if (parama.xBB != localObject)
    {
      parama.xBD = a(paramStack, paramStringBuilder);
      b(paramStack, paramStringBuilder, parama);
    }
    AppMethodBeat.o(181701);
  }
  
  private static void b(Stack<a> paramStack, StringBuilder paramStringBuilder, a parama)
  {
    AppMethodBeat.i(181703);
    String str = parama.xBB.xBX;
    int j = parama.xBD;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(str);
      i += 1;
    }
    paramStack.push(parama);
    AppMethodBeat.o(181703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.a.b
 * JD-Core Version:    0.7.0.1
 */