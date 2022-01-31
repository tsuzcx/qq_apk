package com.tencent.mm.plugin.fts.a;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.d.a;
import com.tencent.mm.plugin.fts.a.a.d.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.g.b;
import com.tencent.mm.plugin.fts.a.a.g.c;
import com.tencent.mm.plugin.fts.a.a.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class f
{
  @Deprecated
  public static Spannable a(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(114229);
    paramCharSequence = a(com.tencent.mm.plugin.fts.a.a.d.b(paramCharSequence, paramString));
    if ((paramCharSequence.mSp instanceof Spannable))
    {
      paramCharSequence = (Spannable)paramCharSequence.mSp;
      AppMethodBeat.o(114229);
      return paramCharSequence;
    }
    paramCharSequence = new SpannableString(paramCharSequence.mSp);
    AppMethodBeat.o(114229);
    return paramCharSequence;
  }
  
  private static e a(Spannable paramSpannable, d.b paramb, com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    AppMethodBeat.i(114222);
    e locale = new e();
    float f1 = paramd.mSc - paramd.eLQ.getTextSize() * 2.0F;
    float f2 = paramd.eLQ.measureText("…");
    float f3 = paramd.eLQ.measureText(paramSpannable, 0, paramb.mSm);
    float f4 = paramd.eLQ.measureText(paramSpannable, paramb.mSm, paramb.mSn);
    float f5 = paramd.eLQ.measureText(paramSpannable, paramb.mSn, paramSpannable.length());
    if (f3 + f4 + f5 < f1)
    {
      paramSpannable = c(paramSpannable, paramb, paramd);
      AppMethodBeat.o(114222);
      return paramSpannable;
    }
    Object localObject2 = paramSpannable.subSequence(paramb.mSm, paramb.mSn);
    Object localObject1;
    if (paramd.mSa == d.a.mSj)
    {
      localObject1 = new SpannableString(TextUtils.concat(new CharSequence[] { paramd.mSf, localObject2, paramd.mSg }));
      if (f3 + f4 + f2 >= f1) {
        break label389;
      }
      localObject2 = new SpannableStringBuilder(paramSpannable, 0, paramb.mSm);
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(paramSpannable.subSequence(paramb.mSn, paramSpannable.length()), paramd.eLQ, f1 - f3 - f4, TextUtils.TruncateAt.END));
      locale.mSp = ((CharSequence)localObject2);
    }
    for (;;)
    {
      locale.bpE = 0;
      AppMethodBeat.o(114222);
      return locale;
      if (paramd.mSa == d.a.mSi) {}
      for (localObject1 = new BackgroundColorSpan(paramd.mSb);; localObject1 = new ForegroundColorSpan(paramd.mSb)) {
        for (;;)
        {
          localObject2 = new SpannableString((CharSequence)localObject2);
          try
          {
            ((SpannableString)localObject2).setSpan(localObject1, 0, ((SpannableString)localObject2).length(), 33);
            localObject1 = localObject2;
          }
          catch (Exception paramd)
          {
            ab.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", paramd, "setSpan %s", new Object[] { paramb.toString() });
            locale.bpE = -1;
            locale.mSp = paramSpannable;
            AppMethodBeat.o(114222);
            return locale;
          }
        }
      }
      label389:
      if (f2 + f4 + f5 < f1)
      {
        localObject2 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(paramSpannable.subSequence(0, paramb.mSm), paramd.eLQ, f1 - f4 - f5, TextUtils.TruncateAt.START));
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).append(paramSpannable, paramb.mSn, paramSpannable.length());
        locale.mSp = ((CharSequence)localObject2);
      }
      else if (f2 + f4 + f2 >= f1)
      {
        paramSpannable = new SpannableStringBuilder();
        paramSpannable.append(TextUtils.ellipsize((CharSequence)localObject1, paramd.eLQ, f1, TextUtils.TruncateAt.END));
        locale.mSp = paramSpannable;
      }
      else
      {
        localObject2 = new SpannableStringBuilder();
        f1 = (f1 - f4) / 2.0F;
        CharSequence localCharSequence = paramSpannable.subSequence(0, paramb.mSm);
        paramSpannable = paramSpannable.subSequence(paramb.mSn, paramSpannable.length());
        ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(localCharSequence, paramd.eLQ, f1, TextUtils.TruncateAt.START));
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(paramSpannable, paramd.eLQ, f1, TextUtils.TruncateAt.END));
        locale.mSp = ((CharSequence)localObject2);
      }
    }
  }
  
  public static final e a(com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    int j = 1;
    AppMethodBeat.i(114220);
    Object localObject1 = new e();
    SpannableString localSpannableString = new SpannableString(TextUtils.concat(new CharSequence[] { paramd.mSd, paramd.mRW, paramd.mSe }));
    ((e)localObject1).bpE = -1;
    ((e)localObject1).mSp = localSpannableString;
    if ((!bo.aa(paramd.mRW)) && (paramd.mRX != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(114220);
      return localObject1;
    }
    Object localObject4 = d.Pa(paramd.mRW.toString());
    Object localObject2 = new ArrayList();
    if (paramd.mRY) {
      localObject2 = aS((String)localObject4, paramd.mRZ);
    }
    for (;;)
    {
      Object localObject6;
      if ((paramd.mRX.mSA.size() == 1) || (a(localSpannableString, paramd)))
      {
        localObject6 = new d.b();
        if (paramd.mRX.mSA.size() == 1)
        {
          ((d.b)localObject6).mSl = ((g.c)paramd.mRX.mSA.get(0));
          if (paramd.mRY) {
            a((List)localObject2, (d.b)localObject6, paramd);
          }
          for (;;)
          {
            if (!((d.b)localObject6).isAvailable()) {
              break label850;
            }
            try
            {
              paramd = b(localSpannableString, (d.b)localObject6, paramd);
              AppMethodBeat.o(114220);
              return paramd;
              a((String)localObject4, (d.b)localObject6, paramd);
            }
            catch (Exception paramd)
            {
              for (;;)
              {
                ((e)localObject1).mSp = localSpannableString;
                paramd = (com.tencent.mm.plugin.fts.a.a.d)localObject1;
              }
            }
          }
        }
        ((d.b)localObject6).mSl = ((g.c)paramd.mRX.mSA.get(0));
        if (paramd.mRY)
        {
          a((List)localObject2, (d.b)localObject6, paramd);
          localObject2 = localObject1;
          if (!((d.b)localObject6).isAvailable()) {}
        }
      }
      for (;;)
      {
        Object localObject3;
        try
        {
          localObject2 = b(localSpannableString, (d.b)localObject6, paramd);
          localObject7 = ((e)localObject2).mSp.toString();
          localObject1 = new ArrayList();
          if (!paramd.mRY) {
            break label857;
          }
          localObject1 = aS((String)localObject7, paramd.mRZ);
          i = j;
          if (i < paramd.mRX.mSA.size())
          {
            ((d.b)localObject6).mSl = ((g.c)paramd.mRX.mSA.get(i));
            if (paramd.mRY)
            {
              a((List)localObject1, (d.b)localObject6, paramd);
              localObject4 = localObject2;
              if (!((d.b)localObject6).isAvailable()) {}
            }
          }
        }
        catch (Exception localException1)
        {
          try
          {
            localObject4 = b((Spannable)((e)localObject2).mSp, (d.b)localObject6, paramd);
            i += 1;
            localObject2 = localObject4;
            continue;
            a((String)localObject4, (d.b)localObject6, paramd);
            break;
            localException1 = localException1;
            ((e)localObject1).mSp = localSpannableString;
            localObject3 = localObject1;
            continue;
            a((String)localObject7, (d.b)localObject6, paramd);
          }
          catch (Exception localException2)
          {
            ((e)localObject3).mSp = localSpannableString;
            localObject5 = localObject3;
            continue;
          }
          AppMethodBeat.o(114220);
          return localObject3;
        }
        localObject6 = new d.b();
        ((d.b)localObject6).mSl = new g.c();
        Object localObject7 = new g.b();
        ((g.b)localObject7).mSC = g.d.mSH;
        ((g.b)localObject7).content = paramd.mRX.mSx;
        ((d.b)localObject6).mSl.mSE.add(localObject7);
        if (paramd.mRY) {
          a((List)localObject3, (d.b)localObject6, paramd);
        }
        for (;;)
        {
          if (((d.b)localObject6).isAvailable()) {
            try
            {
              paramd = b(localSpannableString, (d.b)localObject6, paramd);
              AppMethodBeat.o(114220);
              return paramd;
              a((String)localObject5, (d.b)localObject6, paramd);
            }
            catch (Exception paramd)
            {
              for (;;)
              {
                ((e)localObject1).mSp = localSpannableString;
                paramd = (com.tencent.mm.plugin.fts.a.a.d)localObject1;
              }
            }
          }
        }
        localObject6 = new ArrayList();
        localObject7 = paramd.mRX.mSA.iterator();
        Object localObject8;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (g.c)((Iterator)localObject7).next();
          d.b localb = new d.b();
          localb.mSl = ((g.c)localObject8);
          ((List)localObject6).add(localb);
        }
        localObject7 = ((List)localObject6).iterator();
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (d.b)((Iterator)localObject7).next();
          if (paramd.mRY) {
            a((List)localObject3, (d.b)localObject8, paramd);
          } else {
            a((String)localObject5, (d.b)localObject8, paramd);
          }
        }
        Object localObject5 = ((List)localObject6).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject3 = (d.b)((Iterator)localObject5).next();
          if (((d.b)localObject3).isAvailable())
          {
            localObject3 = b(localSpannableString, (d.b)localObject3, paramd);
            if (((e)localObject3).bpE == 0) {
              localObject1 = localObject3;
            }
          }
        }
        AppMethodBeat.o(114220);
        return localObject1;
        label850:
        AppMethodBeat.o(114220);
        return localObject1;
        label857:
        i = j;
      }
    }
  }
  
  public static final e a(String paramString1, String paramString2, com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    AppMethodBeat.i(114218);
    paramd = a(paramd);
    paramd.mSp = TextUtils.concat(new CharSequence[] { paramString1, paramd.mSp, paramString2 });
    AppMethodBeat.o(114218);
    return paramd;
  }
  
  private static void a(String paramString, d.b paramb, com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    AppMethodBeat.i(114225);
    String str = paramb.bBW();
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(114225);
      return;
    }
    int i = paramString.indexOf(str);
    if (i >= 0)
    {
      paramb.mSm = i;
      paramb.mSn = (str.length() + i);
    }
    if ((paramb.isAvailable()) && (paramd.mSd != null))
    {
      paramb.mSm += paramd.mSd.length();
      paramb.mSn += paramd.mSd.length();
    }
    AppMethodBeat.o(114225);
  }
  
  private static void a(List<List<String>> paramList, d.b paramb, com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    AppMethodBeat.i(114226);
    Object localObject2;
    Object localObject1;
    if (paramd.mRZ)
    {
      localObject2 = paramb.mSl.mSE.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (g.b)((Iterator)localObject2).next();
      } while (((g.b)localObject1).mSC != g.d.mSG);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(114226);
        return;
      }
      int i = i(paramList, ((g.b)localObject1).mSD);
      if (i >= 0)
      {
        paramb.mSm = i;
        paramb.mSn = (((g.b)localObject1).mSD.size() + i);
        break label178;
      }
      for (;;)
      {
        if ((paramb.isAvailable()) && (paramd.mSd != null))
        {
          paramb.mSm += paramd.mSd.length();
          paramb.mSn += paramd.mSd.length();
        }
        AppMethodBeat.o(114226);
        return;
        localObject1 = paramb.mSl.mSE.iterator();
        label178:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (g.b)((Iterator)localObject1).next();
          if (((g.b)localObject2).mSC != g.d.mSF) {
            break;
          }
          i = i(paramList, ((g.b)localObject2).mSD);
          if (i < 0) {
            break;
          }
          paramb.mSm = i;
          paramb.mSn = (((g.b)localObject2).mSD.size() + i);
        }
      }
      localObject1 = null;
    }
  }
  
  private static boolean a(Spannable paramSpannable, com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    AppMethodBeat.i(114221);
    if ((paramd.mSc > 0.0F) && (paramd.eLQ != null))
    {
      if (paramd.mSc - paramd.eLQ.getTextSize() * 2.0F < paramd.eLQ.measureText(paramSpannable.toString()))
      {
        AppMethodBeat.o(114221);
        return true;
      }
      AppMethodBeat.o(114221);
      return false;
    }
    AppMethodBeat.o(114221);
    return false;
  }
  
  private static List<List<String>> aS(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(114228);
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      ArrayList localArrayList2 = new ArrayList(2);
      if (g.w(c))
      {
        String[] arrayOfString = (String[])g.mRL.get(String.valueOf(c));
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
    AppMethodBeat.o(114228);
    return localArrayList1;
  }
  
  private static e b(Spannable paramSpannable, d.b paramb, com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    AppMethodBeat.i(114223);
    if (a(paramSpannable, paramd))
    {
      paramSpannable = a(paramSpannable, paramb, paramd);
      AppMethodBeat.o(114223);
      return paramSpannable;
    }
    paramSpannable = c(paramSpannable, paramb, paramd);
    AppMethodBeat.o(114223);
    return paramSpannable;
  }
  
  private static e c(Spannable paramSpannable, d.b paramb, com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    AppMethodBeat.i(114224);
    e locale = new e();
    if (paramd.mSa == d.a.mSj)
    {
      paramSpannable = paramSpannable.toString();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramSpannable.substring(0, paramb.mSm));
      localStringBuffer.append(paramd.mSf);
      localStringBuffer.append(paramSpannable.substring(paramb.mSm, paramb.mSn));
      localStringBuffer.append(paramd.mSg);
      if (paramb.mSn < paramSpannable.length()) {
        localStringBuffer.append(paramSpannable.substring(paramb.mSn, paramSpannable.length()));
      }
      locale.mSp = localStringBuffer.toString();
      locale.bpE = 0;
      AppMethodBeat.o(114224);
      return locale;
    }
    if (paramd.mSa == d.a.mSi) {}
    for (paramd = new BackgroundColorSpan(paramd.mSb);; paramd = new ForegroundColorSpan(paramd.mSb))
    {
      try
      {
        paramSpannable.setSpan(paramd, paramb.mSm, paramb.mSn, 18);
        locale.mSp = paramSpannable;
        locale.bpE = 0;
      }
      catch (Exception paramd)
      {
        ab.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", paramd, "setSpan %s", new Object[] { paramb.toString() });
        locale.mSp = paramSpannable;
        locale.bpE = -1;
      }
      break;
    }
  }
  
  private static int i(List<List<String>> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(114227);
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
      AppMethodBeat.o(114227);
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
  
  public static final SpannableString j(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(114219);
    paramCharSequence = new SpannableString(paramCharSequence);
    d.b localb = new d.b();
    localb.mSm = 0;
    localb.mSn = paramInt;
    b(paramCharSequence, localb, new com.tencent.mm.plugin.fts.a.a.d());
    AppMethodBeat.o(114219);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.f
 * JD-Core Version:    0.7.0.1
 */