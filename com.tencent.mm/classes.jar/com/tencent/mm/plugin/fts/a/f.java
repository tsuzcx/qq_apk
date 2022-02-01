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
import com.tencent.mm.plugin.fts.a.a.g.a;
import com.tencent.mm.plugin.fts.a.a.g.b;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.j.b;
import com.tencent.mm.plugin.fts.a.a.j.c;
import com.tencent.mm.plugin.fts.a.a.j.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class f
{
  private static int C(List<List<String>> paramList, List<String> paramList1)
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
                  label135:
                  if (k != 0)
                  {
                    i += 1;
                    break;
                  }
                  k = 0;
                  i = 0;
                  label152:
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
      break label152;
      j += 1;
      break;
      k = 0;
      break label135;
      k = 1;
      break label152;
      j = -1;
    }
  }
  
  @Deprecated
  public static Spannable a(CharSequence paramCharSequence, List<String> paramList)
  {
    AppMethodBeat.i(265546);
    paramCharSequence = a(com.tencent.mm.plugin.fts.a.a.g.b(paramCharSequence, paramList));
    if ((paramCharSequence.HsX instanceof Spannable))
    {
      paramCharSequence = (Spannable)paramCharSequence.HsX;
      AppMethodBeat.o(265546);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableString(paramCharSequence.HsX);
    AppMethodBeat.o(265546);
    return paramCharSequence;
  }
  
  public static final SpannableString a(String paramString1, String paramString2, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(265528);
    paramString1 = d(paramString1 + paramCharSequence + paramString2, paramString1.length(), paramString1.length() + paramCharSequence.length());
    AppMethodBeat.o(265528);
    return paramString1;
  }
  
  private static h a(Spannable paramSpannable, g.b paramb, com.tencent.mm.plugin.fts.a.a.g paramg)
  {
    AppMethodBeat.i(131656);
    h localh = new h();
    float f1 = paramg.HsL - paramg.dso.getTextSize() * 2.0F;
    float f2 = paramg.dso.measureText("…");
    float f3 = paramg.dso.measureText(paramSpannable, 0, paramb.HsV);
    float f4 = paramg.dso.measureText(paramSpannable, paramb.HsV, paramb.HsW);
    float f5 = paramg.dso.measureText(paramSpannable, paramb.HsW, paramSpannable.length());
    if (f3 + f4 + f5 < f1)
    {
      paramSpannable = c(paramSpannable, paramb, paramg);
      AppMethodBeat.o(131656);
      return paramSpannable;
    }
    Object localObject2 = paramSpannable.subSequence(paramb.HsV, paramb.HsW);
    Object localObject1;
    if (paramg.HsJ == g.a.HsS)
    {
      localObject1 = new SpannableString(TextUtils.concat(new CharSequence[] { paramg.HsO, localObject2, paramg.HsP }));
      if (f3 + f4 + f2 >= f1) {
        break label389;
      }
      localObject2 = new SpannableStringBuilder(paramSpannable, 0, paramb.HsV);
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(paramSpannable.subSequence(paramb.HsW, paramSpannable.length()), paramg.dso, f1 - f3 - f4, TextUtils.TruncateAt.END));
      localh.HsX = ((CharSequence)localObject2);
    }
    for (;;)
    {
      localh.resultCode = 0;
      AppMethodBeat.o(131656);
      return localh;
      if (paramg.HsJ == g.a.HsR) {}
      for (localObject1 = new BackgroundColorSpan(paramg.HsK);; localObject1 = new ForegroundColorSpan(paramg.HsK)) {
        for (;;)
        {
          localObject2 = new SpannableString((CharSequence)localObject2);
          try
          {
            ((SpannableString)localObject2).setSpan(localObject1, 0, ((SpannableString)localObject2).length(), 33);
            localObject1 = localObject2;
          }
          catch (Exception paramg)
          {
            Log.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", paramg, "setSpan %s", new Object[] { paramb.toString() });
            localh.resultCode = -1;
            localh.HsX = paramSpannable;
            AppMethodBeat.o(131656);
            return localh;
          }
        }
      }
      label389:
      if (f2 + f4 + f5 < f1)
      {
        localObject2 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(paramSpannable.subSequence(0, paramb.HsV), paramg.dso, f1 - f4 - f5, TextUtils.TruncateAt.START));
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).append(paramSpannable, paramb.HsW, paramSpannable.length());
        localh.HsX = ((CharSequence)localObject2);
      }
      else if (f2 + f4 + f2 >= f1)
      {
        paramSpannable = new SpannableStringBuilder();
        paramSpannable.append(TextUtils.ellipsize((CharSequence)localObject1, paramg.dso, f1, TextUtils.TruncateAt.END));
        localh.HsX = paramSpannable;
      }
      else
      {
        localObject2 = new SpannableStringBuilder();
        f1 = (f1 - f4) / 2.0F;
        CharSequence localCharSequence = paramSpannable.subSequence(0, paramb.HsV);
        paramSpannable = paramSpannable.subSequence(paramb.HsW, paramSpannable.length());
        ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(localCharSequence, paramg.dso, f1, TextUtils.TruncateAt.START));
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(paramSpannable, paramg.dso, f1, TextUtils.TruncateAt.END));
        localh.HsX = ((CharSequence)localObject2);
      }
    }
  }
  
  public static final h a(com.tencent.mm.plugin.fts.a.a.g paramg)
  {
    int j = 1;
    AppMethodBeat.i(131654);
    Object localObject1 = new h();
    SpannableString localSpannableString = new SpannableString(TextUtils.concat(new CharSequence[] { paramg.HsM, paramg.HsG, paramg.HsN }));
    ((h)localObject1).resultCode = -1;
    ((h)localObject1).HsX = localSpannableString;
    if ((!Util.isNullOrNil(paramg.HsG)) && (paramg.FWt != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(131654);
      return localObject1;
    }
    Object localObject4 = d.aEh(paramg.HsG.toString());
    Object localObject2 = new ArrayList();
    if (paramg.HsH) {
      localObject2 = ca((String)localObject4, paramg.HsI);
    }
    for (;;)
    {
      Object localObject6;
      if ((paramg.FWt.Hti.size() == 1) || (a(localSpannableString, paramg)))
      {
        localObject6 = new g.b();
        if (paramg.FWt.Hti.size() == 1)
        {
          ((g.b)localObject6).HsU = ((j.c)paramg.FWt.Hti.get(0));
          if (paramg.HsH) {
            a((List)localObject2, (g.b)localObject6, paramg);
          }
          for (;;)
          {
            if (!((g.b)localObject6).isAvailable()) {
              break label850;
            }
            try
            {
              paramg = b(localSpannableString, (g.b)localObject6, paramg);
              AppMethodBeat.o(131654);
              return paramg;
              a((String)localObject4, (g.b)localObject6, paramg);
            }
            catch (Exception paramg)
            {
              for (;;)
              {
                ((h)localObject1).HsX = localSpannableString;
                paramg = (com.tencent.mm.plugin.fts.a.a.g)localObject1;
              }
            }
          }
        }
        ((g.b)localObject6).HsU = ((j.c)paramg.FWt.Hti.get(0));
        if (paramg.HsH)
        {
          a((List)localObject2, (g.b)localObject6, paramg);
          localObject2 = localObject1;
          if (!((g.b)localObject6).isAvailable()) {}
        }
      }
      for (;;)
      {
        Object localObject3;
        try
        {
          localObject2 = b(localSpannableString, (g.b)localObject6, paramg);
          localObject7 = ((h)localObject2).HsX.toString();
          localObject1 = new ArrayList();
          if (!paramg.HsH) {
            break label857;
          }
          localObject1 = ca((String)localObject7, paramg.HsI);
          i = j;
          if (i < paramg.FWt.Hti.size())
          {
            ((g.b)localObject6).HsU = ((j.c)paramg.FWt.Hti.get(i));
            if (paramg.HsH)
            {
              a((List)localObject1, (g.b)localObject6, paramg);
              localObject4 = localObject2;
              if (!((g.b)localObject6).isAvailable()) {}
            }
          }
        }
        catch (Exception localException1)
        {
          try
          {
            localObject4 = b((Spannable)((h)localObject2).HsX, (g.b)localObject6, paramg);
            i += 1;
            localObject2 = localObject4;
            continue;
            a((String)localObject4, (g.b)localObject6, paramg);
            break;
            localException1 = localException1;
            ((h)localObject1).HsX = localSpannableString;
            localObject3 = localObject1;
            continue;
            a((String)localObject7, (g.b)localObject6, paramg);
          }
          catch (Exception localException2)
          {
            ((h)localObject3).HsX = localSpannableString;
            localObject5 = localObject3;
            continue;
          }
          AppMethodBeat.o(131654);
          return localObject3;
        }
        localObject6 = new g.b();
        ((g.b)localObject6).HsU = new j.c();
        Object localObject7 = new j.b();
        ((j.b)localObject7).Htk = j.d.Htp;
        ((j.b)localObject7).content = paramg.FWt.Htf;
        ((g.b)localObject6).HsU.Htm.add(localObject7);
        if (paramg.HsH) {
          a((List)localObject3, (g.b)localObject6, paramg);
        }
        for (;;)
        {
          if (((g.b)localObject6).isAvailable()) {
            try
            {
              paramg = b(localSpannableString, (g.b)localObject6, paramg);
              AppMethodBeat.o(131654);
              return paramg;
              a((String)localObject5, (g.b)localObject6, paramg);
            }
            catch (Exception paramg)
            {
              for (;;)
              {
                ((h)localObject1).HsX = localSpannableString;
                paramg = (com.tencent.mm.plugin.fts.a.a.g)localObject1;
              }
            }
          }
        }
        localObject6 = new ArrayList();
        localObject7 = paramg.FWt.Hti.iterator();
        Object localObject8;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (j.c)((Iterator)localObject7).next();
          g.b localb = new g.b();
          localb.HsU = ((j.c)localObject8);
          ((List)localObject6).add(localb);
        }
        localObject7 = ((List)localObject6).iterator();
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (g.b)((Iterator)localObject7).next();
          if (paramg.HsH) {
            a((List)localObject3, (g.b)localObject8, paramg);
          } else {
            a((String)localObject5, (g.b)localObject8, paramg);
          }
        }
        Object localObject5 = ((List)localObject6).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject3 = (g.b)((Iterator)localObject5).next();
          if (((g.b)localObject3).isAvailable())
          {
            localObject3 = b(localSpannableString, (g.b)localObject3, paramg);
            if (((h)localObject3).resultCode == 0) {
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
  
  public static final h a(String paramString1, String paramString2, com.tencent.mm.plugin.fts.a.a.g paramg)
  {
    AppMethodBeat.i(131652);
    paramg = a(paramg);
    paramg.HsX = TextUtils.concat(new CharSequence[] { paramString1, paramg.HsX, paramString2 });
    AppMethodBeat.o(131652);
    return paramg;
  }
  
  private static void a(String paramString, g.b paramb, com.tencent.mm.plugin.fts.a.a.g paramg)
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
      paramb.HsV = i;
      paramb.HsW = (str.length() + i);
    }
    if ((paramb.isAvailable()) && (paramg.HsM != null))
    {
      paramb.HsV += paramg.HsM.length();
      paramb.HsW += paramg.HsM.length();
    }
    AppMethodBeat.o(131659);
  }
  
  private static void a(List<List<String>> paramList, g.b paramb, com.tencent.mm.plugin.fts.a.a.g paramg)
  {
    AppMethodBeat.i(131660);
    Object localObject2;
    Object localObject1;
    if (paramg.HsI)
    {
      localObject2 = paramb.HsU.Htm.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (j.b)((Iterator)localObject2).next();
      } while (((j.b)localObject1).Htk != j.d.Hto);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(131660);
        return;
      }
      int i = C(paramList, ((j.b)localObject1).Htl);
      if (i >= 0)
      {
        paramb.HsV = i;
        paramb.HsW = (((j.b)localObject1).Htl.size() + i);
        break label178;
      }
      for (;;)
      {
        if ((paramb.isAvailable()) && (paramg.HsM != null))
        {
          paramb.HsV += paramg.HsM.length();
          paramb.HsW += paramg.HsM.length();
        }
        AppMethodBeat.o(131660);
        return;
        localObject1 = paramb.HsU.Htm.iterator();
        label178:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (j.b)((Iterator)localObject1).next();
          if (((j.b)localObject2).Htk != j.d.Htn) {
            break;
          }
          i = C(paramList, ((j.b)localObject2).Htl);
          if (i < 0) {
            break;
          }
          paramb.HsV = i;
          paramb.HsW = (((j.b)localObject2).Htl.size() + i);
        }
      }
      localObject1 = null;
    }
  }
  
  private static boolean a(Spannable paramSpannable, com.tencent.mm.plugin.fts.a.a.g paramg)
  {
    AppMethodBeat.i(131655);
    if ((paramg.HsL > 0.0F) && (paramg.dso != null))
    {
      if (paramg.HsL - paramg.dso.getTextSize() * 2.0F < paramg.dso.measureText(paramSpannable.toString()))
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
  
  public static CharSequence aEn(String paramString)
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
    paramCharSequence = a(com.tencent.mm.plugin.fts.a.a.g.c(paramCharSequence, paramString));
    if ((paramCharSequence.HsX instanceof Spannable))
    {
      paramCharSequence = (Spannable)paramCharSequence.HsX;
      AppMethodBeat.o(131663);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableString(paramCharSequence.HsX);
    AppMethodBeat.o(131663);
    return paramCharSequence;
  }
  
  private static h b(Spannable paramSpannable, g.b paramb, com.tencent.mm.plugin.fts.a.a.g paramg)
  {
    AppMethodBeat.i(131657);
    if (a(paramSpannable, paramg))
    {
      paramSpannable = a(paramSpannable, paramb, paramg);
      AppMethodBeat.o(131657);
      return paramSpannable;
    }
    paramSpannable = c(paramSpannable, paramb, paramg);
    AppMethodBeat.o(131657);
    return paramSpannable;
  }
  
  private static h c(Spannable paramSpannable, g.b paramb, com.tencent.mm.plugin.fts.a.a.g paramg)
  {
    AppMethodBeat.i(131658);
    h localh = new h();
    if (paramg.HsJ == g.a.HsS)
    {
      paramSpannable = paramSpannable.toString();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramSpannable.substring(0, paramb.HsV));
      localStringBuffer.append(paramg.HsO);
      localStringBuffer.append(paramSpannable.substring(paramb.HsV, paramb.HsW));
      localStringBuffer.append(paramg.HsP);
      if (paramb.HsW < paramSpannable.length()) {
        localStringBuffer.append(paramSpannable.substring(paramb.HsW, paramSpannable.length()));
      }
      localh.HsX = localStringBuffer.toString();
      localh.resultCode = 0;
      AppMethodBeat.o(131658);
      return localh;
    }
    if (paramg.HsJ == g.a.HsR) {}
    for (paramg = new BackgroundColorSpan(paramg.HsK);; paramg = new ForegroundColorSpan(paramg.HsK))
    {
      try
      {
        paramSpannable.setSpan(paramg, paramb.HsV, paramb.HsW, 33);
        localh.HsX = paramSpannable;
        localh.resultCode = 0;
      }
      catch (Exception paramg)
      {
        Log.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", paramg, "setSpan %s", new Object[] { paramb.toString() });
        localh.HsX = paramSpannable;
        localh.resultCode = -1;
      }
      break;
    }
  }
  
  private static List<List<String>> ca(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131662);
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      ArrayList localArrayList2 = new ArrayList(2);
      if (g.C(c))
      {
        String[] arrayOfString = (String[])g.Hso.get(String.valueOf(c));
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
  
  public static final SpannableString d(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131653);
    paramCharSequence = new SpannableString(paramCharSequence);
    g.b localb = new g.b();
    localb.HsV = paramInt1;
    localb.HsW = paramInt2;
    b(paramCharSequence, localb, new com.tencent.mm.plugin.fts.a.a.g());
    AppMethodBeat.o(131653);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.f
 * JD-Core Version:    0.7.0.1
 */