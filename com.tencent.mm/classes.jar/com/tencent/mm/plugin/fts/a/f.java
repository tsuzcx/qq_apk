package com.tencent.mm.plugin.fts.a;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.e.a;
import com.tencent.mm.plugin.fts.a.a.e.b;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.h.b;
import com.tencent.mm.plugin.fts.a.a.h.c;
import com.tencent.mm.plugin.fts.a.a.h.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class f
{
  private static com.tencent.mm.plugin.fts.a.a.f a(Spannable paramSpannable, e.b paramb, e parame)
  {
    AppMethodBeat.i(131656);
    com.tencent.mm.plugin.fts.a.a.f localf = new com.tencent.mm.plugin.fts.a.a.f();
    float f1 = parame.sxR - parame.gZ.getTextSize() * 2.0F;
    float f2 = parame.gZ.measureText("…");
    float f3 = parame.gZ.measureText(paramSpannable, 0, paramb.syb);
    float f4 = parame.gZ.measureText(paramSpannable, paramb.syb, paramb.syc);
    float f5 = parame.gZ.measureText(paramSpannable, paramb.syc, paramSpannable.length());
    if (f3 + f4 + f5 < f1)
    {
      paramSpannable = c(paramSpannable, paramb, parame);
      AppMethodBeat.o(131656);
      return paramSpannable;
    }
    Object localObject2 = paramSpannable.subSequence(paramb.syb, paramb.syc);
    Object localObject1;
    if (parame.sxP == e.a.sxY)
    {
      localObject1 = new SpannableString(TextUtils.concat(new CharSequence[] { parame.sxU, localObject2, parame.sxV }));
      if (f3 + f4 + f2 >= f1) {
        break label389;
      }
      localObject2 = new SpannableStringBuilder(paramSpannable, 0, paramb.syb);
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(paramSpannable.subSequence(paramb.syc, paramSpannable.length()), parame.gZ, f1 - f3 - f4, TextUtils.TruncateAt.END));
      localf.syd = ((CharSequence)localObject2);
    }
    for (;;)
    {
      localf.bPH = 0;
      AppMethodBeat.o(131656);
      return localf;
      if (parame.sxP == e.a.sxX) {}
      for (localObject1 = new BackgroundColorSpan(parame.sxQ);; localObject1 = new ForegroundColorSpan(parame.sxQ)) {
        for (;;)
        {
          localObject2 = new SpannableString((CharSequence)localObject2);
          try
          {
            ((SpannableString)localObject2).setSpan(localObject1, 0, ((SpannableString)localObject2).length(), 33);
            localObject1 = localObject2;
          }
          catch (Exception parame)
          {
            ac.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", parame, "setSpan %s", new Object[] { paramb.toString() });
            localf.bPH = -1;
            localf.syd = paramSpannable;
            AppMethodBeat.o(131656);
            return localf;
          }
        }
      }
      label389:
      if (f2 + f4 + f5 < f1)
      {
        localObject2 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(paramSpannable.subSequence(0, paramb.syb), parame.gZ, f1 - f4 - f5, TextUtils.TruncateAt.START));
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).append(paramSpannable, paramb.syc, paramSpannable.length());
        localf.syd = ((CharSequence)localObject2);
      }
      else if (f2 + f4 + f2 >= f1)
      {
        paramSpannable = new SpannableStringBuilder();
        paramSpannable.append(TextUtils.ellipsize((CharSequence)localObject1, parame.gZ, f1, TextUtils.TruncateAt.END));
        localf.syd = paramSpannable;
      }
      else
      {
        localObject2 = new SpannableStringBuilder();
        f1 = (f1 - f4) / 2.0F;
        CharSequence localCharSequence = paramSpannable.subSequence(0, paramb.syb);
        paramSpannable = paramSpannable.subSequence(paramb.syc, paramSpannable.length());
        ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(localCharSequence, parame.gZ, f1, TextUtils.TruncateAt.START));
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(paramSpannable, parame.gZ, f1, TextUtils.TruncateAt.END));
        localf.syd = ((CharSequence)localObject2);
      }
    }
  }
  
  public static final com.tencent.mm.plugin.fts.a.a.f a(e parame)
  {
    int j = 1;
    AppMethodBeat.i(131654);
    Object localObject1 = new com.tencent.mm.plugin.fts.a.a.f();
    SpannableString localSpannableString = new SpannableString(TextUtils.concat(new CharSequence[] { parame.sxS, parame.sxL, parame.sxT }));
    ((com.tencent.mm.plugin.fts.a.a.f)localObject1).bPH = -1;
    ((com.tencent.mm.plugin.fts.a.a.f)localObject1).syd = localSpannableString;
    if ((!bs.aj(parame.sxL)) && (parame.sxM != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(131654);
      return localObject1;
    }
    Object localObject4 = d.afQ(parame.sxL.toString());
    Object localObject2 = new ArrayList();
    if (parame.sxN) {
      localObject2 = bg((String)localObject4, parame.sxO);
    }
    for (;;)
    {
      Object localObject6;
      if ((parame.sxM.syo.size() == 1) || (a(localSpannableString, parame)))
      {
        localObject6 = new e.b();
        if (parame.sxM.syo.size() == 1)
        {
          ((e.b)localObject6).sya = ((h.c)parame.sxM.syo.get(0));
          if (parame.sxN) {
            a((List)localObject2, (e.b)localObject6, parame);
          }
          for (;;)
          {
            if (!((e.b)localObject6).isAvailable()) {
              break label850;
            }
            try
            {
              parame = b(localSpannableString, (e.b)localObject6, parame);
              AppMethodBeat.o(131654);
              return parame;
              a((String)localObject4, (e.b)localObject6, parame);
            }
            catch (Exception parame)
            {
              for (;;)
              {
                ((com.tencent.mm.plugin.fts.a.a.f)localObject1).syd = localSpannableString;
                parame = (e)localObject1;
              }
            }
          }
        }
        ((e.b)localObject6).sya = ((h.c)parame.sxM.syo.get(0));
        if (parame.sxN)
        {
          a((List)localObject2, (e.b)localObject6, parame);
          localObject2 = localObject1;
          if (!((e.b)localObject6).isAvailable()) {}
        }
      }
      for (;;)
      {
        Object localObject3;
        try
        {
          localObject2 = b(localSpannableString, (e.b)localObject6, parame);
          localObject7 = ((com.tencent.mm.plugin.fts.a.a.f)localObject2).syd.toString();
          localObject1 = new ArrayList();
          if (!parame.sxN) {
            break label857;
          }
          localObject1 = bg((String)localObject7, parame.sxO);
          i = j;
          if (i < parame.sxM.syo.size())
          {
            ((e.b)localObject6).sya = ((h.c)parame.sxM.syo.get(i));
            if (parame.sxN)
            {
              a((List)localObject1, (e.b)localObject6, parame);
              localObject4 = localObject2;
              if (!((e.b)localObject6).isAvailable()) {}
            }
          }
        }
        catch (Exception localException1)
        {
          try
          {
            localObject4 = b((Spannable)((com.tencent.mm.plugin.fts.a.a.f)localObject2).syd, (e.b)localObject6, parame);
            i += 1;
            localObject2 = localObject4;
            continue;
            a((String)localObject4, (e.b)localObject6, parame);
            break;
            localException1 = localException1;
            ((com.tencent.mm.plugin.fts.a.a.f)localObject1).syd = localSpannableString;
            localObject3 = localObject1;
            continue;
            a((String)localObject7, (e.b)localObject6, parame);
          }
          catch (Exception localException2)
          {
            ((com.tencent.mm.plugin.fts.a.a.f)localObject3).syd = localSpannableString;
            localObject5 = localObject3;
            continue;
          }
          AppMethodBeat.o(131654);
          return localObject3;
        }
        localObject6 = new e.b();
        ((e.b)localObject6).sya = new h.c();
        Object localObject7 = new h.b();
        ((h.b)localObject7).syq = h.d.syv;
        ((h.b)localObject7).content = parame.sxM.syl;
        ((e.b)localObject6).sya.sys.add(localObject7);
        if (parame.sxN) {
          a((List)localObject3, (e.b)localObject6, parame);
        }
        for (;;)
        {
          if (((e.b)localObject6).isAvailable()) {
            try
            {
              parame = b(localSpannableString, (e.b)localObject6, parame);
              AppMethodBeat.o(131654);
              return parame;
              a((String)localObject5, (e.b)localObject6, parame);
            }
            catch (Exception parame)
            {
              for (;;)
              {
                ((com.tencent.mm.plugin.fts.a.a.f)localObject1).syd = localSpannableString;
                parame = (e)localObject1;
              }
            }
          }
        }
        localObject6 = new ArrayList();
        localObject7 = parame.sxM.syo.iterator();
        Object localObject8;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (h.c)((Iterator)localObject7).next();
          e.b localb = new e.b();
          localb.sya = ((h.c)localObject8);
          ((List)localObject6).add(localb);
        }
        localObject7 = ((List)localObject6).iterator();
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (e.b)((Iterator)localObject7).next();
          if (parame.sxN) {
            a((List)localObject3, (e.b)localObject8, parame);
          } else {
            a((String)localObject5, (e.b)localObject8, parame);
          }
        }
        Object localObject5 = ((List)localObject6).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject3 = (e.b)((Iterator)localObject5).next();
          if (((e.b)localObject3).isAvailable())
          {
            localObject3 = b(localSpannableString, (e.b)localObject3, parame);
            if (((com.tencent.mm.plugin.fts.a.a.f)localObject3).bPH == 0) {
              localObject1 = localObject3;
            }
          }
        }
        AppMethodBeat.o(131654);
        return localObject1;
        label850:
        AppMethodBeat.o(131654);
        return localObject1;
        label857:
        i = j;
      }
    }
  }
  
  public static final com.tencent.mm.plugin.fts.a.a.f a(String paramString1, String paramString2, e parame)
  {
    AppMethodBeat.i(131652);
    parame = a(parame);
    parame.syd = TextUtils.concat(new CharSequence[] { paramString1, parame.syd, paramString2 });
    AppMethodBeat.o(131652);
    return parame;
  }
  
  private static void a(String paramString, e.b paramb, e parame)
  {
    AppMethodBeat.i(131659);
    String str = paramb.cKv();
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(131659);
      return;
    }
    int i = paramString.indexOf(str);
    if (i >= 0)
    {
      paramb.syb = i;
      paramb.syc = (str.length() + i);
    }
    if ((paramb.isAvailable()) && (parame.sxS != null))
    {
      paramb.syb += parame.sxS.length();
      paramb.syc += parame.sxS.length();
    }
    AppMethodBeat.o(131659);
  }
  
  private static void a(List<List<String>> paramList, e.b paramb, e parame)
  {
    AppMethodBeat.i(131660);
    Object localObject2;
    Object localObject1;
    if (parame.sxO)
    {
      localObject2 = paramb.sya.sys.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (h.b)((Iterator)localObject2).next();
      } while (((h.b)localObject1).syq != h.d.syu);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(131660);
        return;
      }
      int i = l(paramList, ((h.b)localObject1).syr);
      if (i >= 0)
      {
        paramb.syb = i;
        paramb.syc = (((h.b)localObject1).syr.size() + i);
        break label178;
      }
      for (;;)
      {
        if ((paramb.isAvailable()) && (parame.sxS != null))
        {
          paramb.syb += parame.sxS.length();
          paramb.syc += parame.sxS.length();
        }
        AppMethodBeat.o(131660);
        return;
        localObject1 = paramb.sya.sys.iterator();
        label178:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (h.b)((Iterator)localObject1).next();
          if (((h.b)localObject2).syq != h.d.syt) {
            break;
          }
          i = l(paramList, ((h.b)localObject2).syr);
          if (i < 0) {
            break;
          }
          paramb.syb = i;
          paramb.syc = (((h.b)localObject2).syr.size() + i);
        }
      }
      localObject1 = null;
    }
  }
  
  private static boolean a(Spannable paramSpannable, e parame)
  {
    AppMethodBeat.i(131655);
    if ((parame.sxR > 0.0F) && (parame.gZ != null))
    {
      if (parame.sxR - parame.gZ.getTextSize() * 2.0F < parame.gZ.measureText(paramSpannable.toString()))
      {
        AppMethodBeat.o(131655);
        return true;
      }
      AppMethodBeat.o(131655);
      return false;
    }
    AppMethodBeat.o(131655);
    return false;
  }
  
  public static CharSequence afV(String paramString)
  {
    AppMethodBeat.i(131664);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(131664);
      return "";
    }
    paramString = Html.fromHtml(paramString.replaceAll("<em class=\"highlight\">", "<font color=\"#06AD56\">").replaceAll("</em>", "</font>"));
    AppMethodBeat.o(131664);
    return paramString;
  }
  
  @Deprecated
  public static Spannable b(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(131663);
    paramCharSequence = a(e.c(paramCharSequence, paramString));
    if ((paramCharSequence.syd instanceof Spannable))
    {
      paramCharSequence = (Spannable)paramCharSequence.syd;
      AppMethodBeat.o(131663);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableString(paramCharSequence.syd);
    AppMethodBeat.o(131663);
    return paramCharSequence;
  }
  
  private static com.tencent.mm.plugin.fts.a.a.f b(Spannable paramSpannable, e.b paramb, e parame)
  {
    AppMethodBeat.i(131657);
    if (a(paramSpannable, parame))
    {
      paramSpannable = a(paramSpannable, paramb, parame);
      AppMethodBeat.o(131657);
      return paramSpannable;
    }
    paramSpannable = c(paramSpannable, paramb, parame);
    AppMethodBeat.o(131657);
    return paramSpannable;
  }
  
  private static List<List<String>> bg(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131662);
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      ArrayList localArrayList2 = new ArrayList(2);
      if (g.y(c))
      {
        String[] arrayOfString = (String[])g.sxw.get(String.valueOf(c));
        if ((arrayOfString != null) && (arrayOfString.length > 0) && (arrayOfString[0].length() > 0))
        {
          int k = arrayOfString.length;
          int j = 0;
          while (j < k)
          {
            String str2 = arrayOfString[j];
            String str1 = str2;
            if (paramBoolean) {
              str1 = str2.substring(0, 1);
            }
            if (!localArrayList2.contains(str1)) {
              localArrayList2.add(str1);
            }
            j += 1;
          }
          localArrayList1.add(localArrayList2);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList1.add(localArrayList2);
        continue;
        localArrayList1.add(localArrayList2);
      }
    }
    AppMethodBeat.o(131662);
    return localArrayList1;
  }
  
  private static com.tencent.mm.plugin.fts.a.a.f c(Spannable paramSpannable, e.b paramb, e parame)
  {
    AppMethodBeat.i(131658);
    com.tencent.mm.plugin.fts.a.a.f localf = new com.tencent.mm.plugin.fts.a.a.f();
    if (parame.sxP == e.a.sxY)
    {
      paramSpannable = paramSpannable.toString();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramSpannable.substring(0, paramb.syb));
      localStringBuffer.append(parame.sxU);
      localStringBuffer.append(paramSpannable.substring(paramb.syb, paramb.syc));
      localStringBuffer.append(parame.sxV);
      if (paramb.syc < paramSpannable.length()) {
        localStringBuffer.append(paramSpannable.substring(paramb.syc, paramSpannable.length()));
      }
      localf.syd = localStringBuffer.toString();
      localf.bPH = 0;
      AppMethodBeat.o(131658);
      return localf;
    }
    if (parame.sxP == e.a.sxX) {}
    for (parame = new BackgroundColorSpan(parame.sxQ);; parame = new ForegroundColorSpan(parame.sxQ))
    {
      try
      {
        paramSpannable.setSpan(parame, paramb.syb, paramb.syc, 18);
        localf.syd = paramSpannable;
        localf.bPH = 0;
      }
      catch (Exception parame)
      {
        ac.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", parame, "setSpan %s", new Object[] { paramb.toString() });
        localf.syd = paramSpannable;
        localf.bPH = -1;
      }
      break;
    }
  }
  
  public static final SpannableString f(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131653);
    paramCharSequence = new SpannableString(paramCharSequence);
    e.b localb = new e.b();
    localb.syb = paramInt1;
    localb.syc = paramInt2;
    b(paramCharSequence, localb, new e());
    AppMethodBeat.o(131653);
    return paramCharSequence;
  }
  
  private static int l(List<List<String>> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(131661);
    int j = 0;
    int i = 0;
    int k;
    if (j < paramList.size() - paramList1.size() + 1) {
      for (;;)
      {
        if (i < paramList1.size())
        {
          Object localObject = (List)paramList.get(j + i);
          String str = (String)paramList1.get(i);
          if (((List)localObject).contains(str))
          {
            i += 1;
          }
          else if (i == paramList1.size() - 1)
          {
            localObject = ((List)localObject).iterator();
            for (;;)
            {
              if (((Iterator)localObject).hasNext()) {
                if (((String)((Iterator)localObject).next()).startsWith(str))
                {
                  k = 1;
                  label136:
                  if (k != 0)
                  {
                    i += 1;
                    break;
                  }
                  k = 0;
                  i = 0;
                  label153:
                  if (k == 0) {}
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(131661);
      return j;
      k = 0;
      i = 0;
      break label153;
      j += 1;
      break;
      k = 0;
      break label136;
      k = 1;
      break label153;
      j = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.f
 * JD-Core Version:    0.7.0.1
 */