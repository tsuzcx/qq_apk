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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class f
{
  public static final SpannableString a(String paramString1, String paramString2, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(243878);
    paramString1 = f(paramString1 + paramCharSequence + paramString2, paramString1.length(), paramString1.length() + paramCharSequence.length());
    AppMethodBeat.o(243878);
    return paramString1;
  }
  
  private static com.tencent.mm.plugin.fts.a.a.f a(Spannable paramSpannable, e.b paramb, e parame)
  {
    AppMethodBeat.i(131656);
    com.tencent.mm.plugin.fts.a.a.f localf = new com.tencent.mm.plugin.fts.a.a.f();
    float f1 = parame.BId - parame.bzo.getTextSize() * 2.0F;
    float f2 = parame.bzo.measureText("…");
    float f3 = parame.bzo.measureText(paramSpannable, 0, paramb.BIn);
    float f4 = parame.bzo.measureText(paramSpannable, paramb.BIn, paramb.BIo);
    float f5 = parame.bzo.measureText(paramSpannable, paramb.BIo, paramSpannable.length());
    if (f3 + f4 + f5 < f1)
    {
      paramSpannable = c(paramSpannable, paramb, parame);
      AppMethodBeat.o(131656);
      return paramSpannable;
    }
    Object localObject2 = paramSpannable.subSequence(paramb.BIn, paramb.BIo);
    Object localObject1;
    if (parame.BIb == e.a.BIk)
    {
      localObject1 = new SpannableString(TextUtils.concat(new CharSequence[] { parame.BIg, localObject2, parame.BIh }));
      if (f3 + f4 + f2 >= f1) {
        break label389;
      }
      localObject2 = new SpannableStringBuilder(paramSpannable, 0, paramb.BIn);
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(paramSpannable.subSequence(paramb.BIo, paramSpannable.length()), parame.bzo, f1 - f3 - f4, TextUtils.TruncateAt.END));
      localf.BIp = ((CharSequence)localObject2);
    }
    for (;;)
    {
      localf.resultCode = 0;
      AppMethodBeat.o(131656);
      return localf;
      if (parame.BIb == e.a.BIj) {}
      for (localObject1 = new BackgroundColorSpan(parame.BIc);; localObject1 = new ForegroundColorSpan(parame.BIc)) {
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
            Log.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", parame, "setSpan %s", new Object[] { paramb.toString() });
            localf.resultCode = -1;
            localf.BIp = paramSpannable;
            AppMethodBeat.o(131656);
            return localf;
          }
        }
      }
      label389:
      if (f2 + f4 + f5 < f1)
      {
        localObject2 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(paramSpannable.subSequence(0, paramb.BIn), parame.bzo, f1 - f4 - f5, TextUtils.TruncateAt.START));
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).append(paramSpannable, paramb.BIo, paramSpannable.length());
        localf.BIp = ((CharSequence)localObject2);
      }
      else if (f2 + f4 + f2 >= f1)
      {
        paramSpannable = new SpannableStringBuilder();
        paramSpannable.append(TextUtils.ellipsize((CharSequence)localObject1, parame.bzo, f1, TextUtils.TruncateAt.END));
        localf.BIp = paramSpannable;
      }
      else
      {
        localObject2 = new SpannableStringBuilder();
        f1 = (f1 - f4) / 2.0F;
        CharSequence localCharSequence = paramSpannable.subSequence(0, paramb.BIn);
        paramSpannable = paramSpannable.subSequence(paramb.BIo, paramSpannable.length());
        ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(localCharSequence, parame.bzo, f1, TextUtils.TruncateAt.START));
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(paramSpannable, parame.bzo, f1, TextUtils.TruncateAt.END));
        localf.BIp = ((CharSequence)localObject2);
      }
    }
  }
  
  public static final com.tencent.mm.plugin.fts.a.a.f a(e parame)
  {
    int j = 1;
    AppMethodBeat.i(131654);
    Object localObject1 = new com.tencent.mm.plugin.fts.a.a.f();
    SpannableString localSpannableString = new SpannableString(TextUtils.concat(new CharSequence[] { parame.BIe, parame.BHX, parame.BIf }));
    ((com.tencent.mm.plugin.fts.a.a.f)localObject1).resultCode = -1;
    ((com.tencent.mm.plugin.fts.a.a.f)localObject1).BIp = localSpannableString;
    if ((!Util.isNullOrNil(parame.BHX)) && (parame.BHY != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(131654);
      return localObject1;
    }
    Object localObject4 = d.aHJ(parame.BHX.toString());
    Object localObject2 = new ArrayList();
    if (parame.BHZ) {
      localObject2 = bH((String)localObject4, parame.BIa);
    }
    for (;;)
    {
      Object localObject6;
      if ((parame.BHY.BIA.size() == 1) || (a(localSpannableString, parame)))
      {
        localObject6 = new e.b();
        if (parame.BHY.BIA.size() == 1)
        {
          ((e.b)localObject6).BIm = ((h.c)parame.BHY.BIA.get(0));
          if (parame.BHZ) {
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
                ((com.tencent.mm.plugin.fts.a.a.f)localObject1).BIp = localSpannableString;
                parame = (e)localObject1;
              }
            }
          }
        }
        ((e.b)localObject6).BIm = ((h.c)parame.BHY.BIA.get(0));
        if (parame.BHZ)
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
          localObject7 = ((com.tencent.mm.plugin.fts.a.a.f)localObject2).BIp.toString();
          localObject1 = new ArrayList();
          if (!parame.BHZ) {
            break label857;
          }
          localObject1 = bH((String)localObject7, parame.BIa);
          i = j;
          if (i < parame.BHY.BIA.size())
          {
            ((e.b)localObject6).BIm = ((h.c)parame.BHY.BIA.get(i));
            if (parame.BHZ)
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
            localObject4 = b((Spannable)((com.tencent.mm.plugin.fts.a.a.f)localObject2).BIp, (e.b)localObject6, parame);
            i += 1;
            localObject2 = localObject4;
            continue;
            a((String)localObject4, (e.b)localObject6, parame);
            break;
            localException1 = localException1;
            ((com.tencent.mm.plugin.fts.a.a.f)localObject1).BIp = localSpannableString;
            localObject3 = localObject1;
            continue;
            a((String)localObject7, (e.b)localObject6, parame);
          }
          catch (Exception localException2)
          {
            ((com.tencent.mm.plugin.fts.a.a.f)localObject3).BIp = localSpannableString;
            localObject5 = localObject3;
            continue;
          }
          AppMethodBeat.o(131654);
          return localObject3;
        }
        localObject6 = new e.b();
        ((e.b)localObject6).BIm = new h.c();
        Object localObject7 = new h.b();
        ((h.b)localObject7).BIC = h.d.BIH;
        ((h.b)localObject7).content = parame.BHY.BIx;
        ((e.b)localObject6).BIm.BIE.add(localObject7);
        if (parame.BHZ) {
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
                ((com.tencent.mm.plugin.fts.a.a.f)localObject1).BIp = localSpannableString;
                parame = (e)localObject1;
              }
            }
          }
        }
        localObject6 = new ArrayList();
        localObject7 = parame.BHY.BIA.iterator();
        Object localObject8;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (h.c)((Iterator)localObject7).next();
          e.b localb = new e.b();
          localb.BIm = ((h.c)localObject8);
          ((List)localObject6).add(localb);
        }
        localObject7 = ((List)localObject6).iterator();
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (e.b)((Iterator)localObject7).next();
          if (parame.BHZ) {
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
            if (((com.tencent.mm.plugin.fts.a.a.f)localObject3).resultCode == 0) {
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
    parame.BIp = TextUtils.concat(new CharSequence[] { paramString1, parame.BIp, paramString2 });
    AppMethodBeat.o(131652);
    return parame;
  }
  
  private static void a(String paramString, e.b paramb, e parame)
  {
    AppMethodBeat.i(131659);
    String str = paramb.getKeyword();
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(131659);
      return;
    }
    int i = paramString.indexOf(str);
    if (i >= 0)
    {
      paramb.BIn = i;
      paramb.BIo = (str.length() + i);
    }
    if ((paramb.isAvailable()) && (parame.BIe != null))
    {
      paramb.BIn += parame.BIe.length();
      paramb.BIo += parame.BIe.length();
    }
    AppMethodBeat.o(131659);
  }
  
  private static void a(List<List<String>> paramList, e.b paramb, e parame)
  {
    AppMethodBeat.i(131660);
    Object localObject2;
    Object localObject1;
    if (parame.BIa)
    {
      localObject2 = paramb.BIm.BIE.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (h.b)((Iterator)localObject2).next();
      } while (((h.b)localObject1).BIC != h.d.BIG);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(131660);
        return;
      }
      int i = r(paramList, ((h.b)localObject1).BID);
      if (i >= 0)
      {
        paramb.BIn = i;
        paramb.BIo = (((h.b)localObject1).BID.size() + i);
        break label178;
      }
      for (;;)
      {
        if ((paramb.isAvailable()) && (parame.BIe != null))
        {
          paramb.BIn += parame.BIe.length();
          paramb.BIo += parame.BIe.length();
        }
        AppMethodBeat.o(131660);
        return;
        localObject1 = paramb.BIm.BIE.iterator();
        label178:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (h.b)((Iterator)localObject1).next();
          if (((h.b)localObject2).BIC != h.d.BIF) {
            break;
          }
          i = r(paramList, ((h.b)localObject2).BID);
          if (i < 0) {
            break;
          }
          paramb.BIn = i;
          paramb.BIo = (((h.b)localObject2).BID.size() + i);
        }
      }
      localObject1 = null;
    }
  }
  
  private static boolean a(Spannable paramSpannable, e parame)
  {
    AppMethodBeat.i(131655);
    if ((parame.BId > 0.0F) && (parame.bzo != null))
    {
      if (parame.BId - parame.bzo.getTextSize() * 2.0F < parame.bzo.measureText(paramSpannable.toString()))
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
  
  public static CharSequence aHP(String paramString)
  {
    AppMethodBeat.i(131664);
    if (Util.isNullOrNil(paramString))
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
    if ((paramCharSequence.BIp instanceof Spannable))
    {
      paramCharSequence = (Spannable)paramCharSequence.BIp;
      AppMethodBeat.o(131663);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableString(paramCharSequence.BIp);
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
  
  private static List<List<String>> bH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131662);
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      ArrayList localArrayList2 = new ArrayList(2);
      if (g.J(c))
      {
        String[] arrayOfString = (String[])g.BHJ.get(String.valueOf(c));
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
    if (parame.BIb == e.a.BIk)
    {
      paramSpannable = paramSpannable.toString();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramSpannable.substring(0, paramb.BIn));
      localStringBuffer.append(parame.BIg);
      localStringBuffer.append(paramSpannable.substring(paramb.BIn, paramb.BIo));
      localStringBuffer.append(parame.BIh);
      if (paramb.BIo < paramSpannable.length()) {
        localStringBuffer.append(paramSpannable.substring(paramb.BIo, paramSpannable.length()));
      }
      localf.BIp = localStringBuffer.toString();
      localf.resultCode = 0;
      AppMethodBeat.o(131658);
      return localf;
    }
    if (parame.BIb == e.a.BIj) {}
    for (parame = new BackgroundColorSpan(parame.BIc);; parame = new ForegroundColorSpan(parame.BIc))
    {
      try
      {
        paramSpannable.setSpan(parame, paramb.BIn, paramb.BIo, 33);
        localf.BIp = paramSpannable;
        localf.resultCode = 0;
      }
      catch (Exception parame)
      {
        Log.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", parame, "setSpan %s", new Object[] { paramb.toString() });
        localf.BIp = paramSpannable;
        localf.resultCode = -1;
      }
      break;
    }
  }
  
  public static final SpannableString f(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131653);
    paramCharSequence = new SpannableString(paramCharSequence);
    e.b localb = new e.b();
    localb.BIn = paramInt1;
    localb.BIo = paramInt2;
    b(paramCharSequence, localb, new e());
    AppMethodBeat.o(131653);
    return paramCharSequence;
  }
  
  private static int r(List<List<String>> paramList, List<String> paramList1)
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