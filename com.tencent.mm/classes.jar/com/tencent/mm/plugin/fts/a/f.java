package com.tencent.mm.plugin.fts.a;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.plugin.fts.a.a.d.a;
import com.tencent.mm.plugin.fts.a.a.d.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.g.b;
import com.tencent.mm.plugin.fts.a.a.g.c;
import com.tencent.mm.plugin.fts.a.a.g.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class f
{
  @Deprecated
  public static Spannable a(CharSequence paramCharSequence, String paramString)
  {
    paramCharSequence = a(com.tencent.mm.plugin.fts.a.a.d.b(paramCharSequence, paramString));
    if ((paramCharSequence.kwz instanceof Spannable)) {
      return (Spannable)paramCharSequence.kwz;
    }
    return new SpannableString(paramCharSequence.kwz);
  }
  
  private static e a(SpannableString paramSpannableString, d.b paramb, com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    e locale = new e();
    float f1 = paramd.kwn - paramd.dOi.getTextSize() * 2.0F;
    float f2 = paramd.dOi.measureText("…");
    float f3 = paramd.dOi.measureText(paramSpannableString, 0, paramb.kwx);
    float f4 = paramd.dOi.measureText(paramSpannableString, paramb.kwx, paramb.kwy);
    float f5 = paramd.dOi.measureText(paramSpannableString, paramb.kwy, paramSpannableString.length());
    if (f3 + f4 + f5 < f1) {
      return c(paramSpannableString, paramb, paramd);
    }
    Object localObject1;
    Object localObject2;
    if (paramd.kwl == d.a.kwu)
    {
      localObject1 = new SpannableString(TextUtils.concat(new CharSequence[] { paramd.kwq, paramSpannableString.subSequence(paramb.kwx, paramb.kwy), paramd.kwr }));
      if (f3 + f4 + f2 >= f1) {
        break label365;
      }
      localObject2 = new SpannableStringBuilder(paramSpannableString, 0, paramb.kwx);
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(paramSpannableString.subSequence(paramb.kwy, paramSpannableString.length()), paramd.dOi, f1 - f3 - f4, TextUtils.TruncateAt.END));
      locale.kwz = ((CharSequence)localObject2);
    }
    for (;;)
    {
      locale.aYY = 0;
      return locale;
      if (paramd.kwl == d.a.kwt) {}
      for (localObject1 = new BackgroundColorSpan(paramd.kwm);; localObject1 = new ForegroundColorSpan(paramd.kwm)) {
        for (;;)
        {
          localObject2 = new SpannableString(paramSpannableString.subSequence(paramb.kwx, paramb.kwy));
          try
          {
            ((SpannableString)localObject2).setSpan(localObject1, 0, ((SpannableString)localObject2).length(), 33);
            localObject1 = localObject2;
          }
          catch (Exception paramd)
          {
            y.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", paramd, "setSpan %s", new Object[] { paramb.toString() });
            locale.aYY = -1;
            locale.kwz = paramSpannableString;
            return locale;
          }
        }
      }
      label365:
      if (f2 + f4 + f5 < f1)
      {
        localObject2 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(paramSpannableString.subSequence(0, paramb.kwx), paramd.dOi, f1 - f4 - f5, TextUtils.TruncateAt.START));
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).append(paramSpannableString, paramb.kwy, paramSpannableString.length());
        locale.kwz = ((CharSequence)localObject2);
      }
      else if (f2 + f4 + f2 >= f1)
      {
        paramSpannableString = new SpannableStringBuilder();
        paramSpannableString.append(TextUtils.ellipsize((CharSequence)localObject1, paramd.dOi, f1, TextUtils.TruncateAt.END));
        locale.kwz = paramSpannableString;
      }
      else
      {
        localObject2 = new SpannableStringBuilder();
        f1 = (f1 - f4) / 2.0F;
        CharSequence localCharSequence = paramSpannableString.subSequence(0, paramb.kwx);
        paramSpannableString = paramSpannableString.subSequence(paramb.kwy, paramSpannableString.length());
        ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(localCharSequence, paramd.dOi, f1, TextUtils.TruncateAt.START));
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).append(TextUtils.ellipsize(paramSpannableString, paramd.dOi, f1, TextUtils.TruncateAt.END));
        locale.kwz = ((CharSequence)localObject2);
      }
    }
  }
  
  public static final e a(com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    Object localObject1 = new e();
    SpannableString localSpannableString = new SpannableString(TextUtils.concat(new CharSequence[] { paramd.kwo, paramd.kwh, paramd.kwp }));
    ((e)localObject1).aYY = -1;
    ((e)localObject1).kwz = localSpannableString;
    if ((!bk.L(paramd.kwh)) && (paramd.kwi != null)) {}
    Object localObject3;
    for (int i = 1; i == 0; i = 0)
    {
      localObject3 = localObject1;
      return localObject3;
    }
    Object localObject4 = d.DR(paramd.kwh.toString());
    Object localObject2 = new ArrayList();
    if (paramd.kwj) {
      localObject2 = aE((String)localObject4, paramd.kwk);
    }
    for (;;)
    {
      Object localObject6;
      if ((paramd.kwi.kwK.size() == 1) || (a(localSpannableString, paramd)))
      {
        localObject5 = new d.b();
        if (paramd.kwi.kwK.size() == 1)
        {
          ((d.b)localObject5).kww = ((g.c)paramd.kwi.kwK.get(0));
          if (paramd.kwj) {
            a((List)localObject2, (d.b)localObject5, paramd);
          }
          for (;;)
          {
            localObject3 = localObject1;
            if (!((d.b)localObject5).isAvailable()) {
              break;
            }
            try
            {
              paramd = b(localSpannableString, (d.b)localObject5, paramd);
              return paramd;
              a((String)localObject4, (d.b)localObject5, paramd);
            }
            catch (Exception paramd)
            {
              for (;;)
              {
                ((e)localObject1).kwz = localSpannableString;
                paramd = (com.tencent.mm.plugin.fts.a.a.d)localObject1;
              }
            }
          }
        }
        localObject6 = paramd.kwi.kwK.iterator();
        for (;;)
        {
          localObject3 = localObject1;
          if (!((Iterator)localObject6).hasNext()) {
            break;
          }
          ((d.b)localObject5).kww = ((g.c)((Iterator)localObject6).next());
          if (paramd.kwj) {
            a((List)localObject2, (d.b)localObject5, paramd);
          }
          while (((d.b)localObject5).isAvailable())
          {
            try
            {
              paramd = b(localSpannableString, (d.b)localObject5, paramd);
              return paramd;
            }
            catch (Exception paramd)
            {
              ((e)localObject1).kwz = localSpannableString;
              return localObject1;
            }
            a((String)localObject4, (d.b)localObject5, paramd);
          }
        }
      }
      localObject3 = new d.b();
      ((d.b)localObject3).kww = new g.c();
      Object localObject5 = new g.b();
      ((g.b)localObject5).kwM = g.d.kwR;
      ((g.b)localObject5).content = paramd.kwi.kwH;
      ((d.b)localObject3).kww.kwO.add(localObject5);
      if (paramd.kwj) {
        a((List)localObject2, (d.b)localObject3, paramd);
      }
      while (((d.b)localObject3).isAvailable())
      {
        try
        {
          paramd = b(localSpannableString, (d.b)localObject3, paramd);
          return paramd;
        }
        catch (Exception paramd)
        {
          ((e)localObject1).kwz = localSpannableString;
          return localObject1;
        }
        a((String)localObject4, (d.b)localObject3, paramd);
      }
      localObject3 = new ArrayList();
      localObject5 = paramd.kwi.kwK.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (g.c)((Iterator)localObject5).next();
        d.b localb = new d.b();
        localb.kww = ((g.c)localObject6);
        ((List)localObject3).add(localb);
      }
      localObject5 = ((List)localObject3).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (d.b)((Iterator)localObject5).next();
        if (paramd.kwj) {
          a((List)localObject2, (d.b)localObject6, paramd);
        } else {
          a((String)localObject4, (d.b)localObject6, paramd);
        }
      }
      localObject4 = ((List)localObject3).iterator();
      for (;;)
      {
        localObject3 = localObject1;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject2 = (d.b)((Iterator)localObject4).next();
        if (((d.b)localObject2).isAvailable())
        {
          localObject2 = b(localSpannableString, (d.b)localObject2, paramd);
          if (((e)localObject2).aYY == 0) {
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public static final e a(String paramString1, String paramString2, com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    paramd = a(paramd);
    paramd.kwz = TextUtils.concat(new CharSequence[] { paramString1, paramd.kwz, paramString2 });
    return paramd;
  }
  
  private static void a(String paramString, d.b paramb, com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    Object localObject;
    if ((paramb.kww != null) && (paramb.kww.kwO.size() > 0))
    {
      localObject = paramb.kww.kwO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        g.b localb = (g.b)((Iterator)localObject).next();
        if (localb.kwM == g.d.kwR)
        {
          localObject = localb.content;
          if (!bk.bl((String)localObject)) {
            break label91;
          }
        }
      }
    }
    label91:
    do
    {
      return;
      localObject = null;
      break;
      int i = paramString.indexOf((String)localObject);
      if (i >= 0)
      {
        paramb.kwx = i;
        paramb.kwy = (((String)localObject).length() + i);
      }
    } while ((!paramb.isAvailable()) || (paramd.kwo == null));
    paramb.kwx += paramd.kwo.length();
    paramb.kwy += paramd.kwo.length();
  }
  
  private static void a(List<List<String>> paramList, d.b paramb, com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    Object localObject2;
    Object localObject1;
    if (paramd.kwk)
    {
      localObject2 = paramb.kww.kwO.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (g.b)((Iterator)localObject2).next();
      } while (((g.b)localObject1).kwM != g.d.kwQ);
    }
    for (;;)
    {
      if (localObject1 == null) {}
      label160:
      label229:
      for (;;)
      {
        return;
        int i = g(paramList, ((g.b)localObject1).kwN);
        if (i >= 0)
        {
          paramb.kwx = i;
          paramb.kwy = (((g.b)localObject1).kwN.size() + i);
          break label160;
        }
        for (;;)
        {
          if ((!paramb.isAvailable()) || (paramd.kwo == null)) {
            break label229;
          }
          paramb.kwx += paramd.kwo.length();
          paramb.kwy += paramd.kwo.length();
          return;
          localObject1 = paramb.kww.kwO.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (g.b)((Iterator)localObject1).next();
            if (((g.b)localObject2).kwM != g.d.kwP) {
              break;
            }
            i = g(paramList, ((g.b)localObject2).kwN);
            if (i < 0) {
              break;
            }
            paramb.kwx = i;
            paramb.kwy = (((g.b)localObject2).kwN.size() + i);
          }
        }
      }
      localObject1 = null;
    }
  }
  
  private static boolean a(SpannableString paramSpannableString, com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramd.kwn > 0.0F)
    {
      bool1 = bool2;
      if (paramd.dOi != null)
      {
        bool1 = bool2;
        if (paramd.kwn - paramd.dOi.getTextSize() * 2.0F < paramd.dOi.measureText(paramSpannableString.toString())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static List<List<String>> aE(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      ArrayList localArrayList2 = new ArrayList(2);
      if (g.g(c))
      {
        String[] arrayOfString = (String[])g.kvX.get(String.valueOf(c));
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
    return localArrayList1;
  }
  
  private static e b(SpannableString paramSpannableString, d.b paramb, com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    if (a(paramSpannableString, paramd)) {
      return a(paramSpannableString, paramb, paramd);
    }
    return c(paramSpannableString, paramb, paramd);
  }
  
  private static e c(SpannableString paramSpannableString, d.b paramb, com.tencent.mm.plugin.fts.a.a.d paramd)
  {
    e locale = new e();
    if (paramd.kwl == d.a.kwu)
    {
      paramSpannableString = paramSpannableString.toString();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramSpannableString.substring(0, paramb.kwx));
      localStringBuffer.append(paramd.kwq);
      localStringBuffer.append(paramSpannableString.substring(paramb.kwx, paramb.kwy));
      localStringBuffer.append(paramd.kwr);
      if (paramb.kwy < paramSpannableString.length()) {
        localStringBuffer.append(paramSpannableString.substring(paramb.kwy, paramSpannableString.length()));
      }
      locale.kwz = localStringBuffer.toString();
      locale.aYY = 0;
      return locale;
    }
    if (paramd.kwl == d.a.kwt) {}
    for (paramd = new BackgroundColorSpan(paramd.kwm);; paramd = new ForegroundColorSpan(paramd.kwm)) {
      try
      {
        paramSpannableString.setSpan(paramd, paramb.kwx, paramb.kwy, 18);
        locale.kwz = paramSpannableString;
        locale.aYY = 0;
        return locale;
      }
      catch (Exception paramd)
      {
        y.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", paramd, "setSpan %s", new Object[] { paramb.toString() });
        locale.kwz = paramSpannableString;
        locale.aYY = -1;
        return locale;
      }
    }
  }
  
  public static final SpannableString d(CharSequence paramCharSequence, int paramInt)
  {
    paramCharSequence = new SpannableString(paramCharSequence);
    d.b localb = new d.b();
    localb.kwx = 0;
    localb.kwy = paramInt;
    b(paramCharSequence, localb, new com.tencent.mm.plugin.fts.a.a.d());
    return paramCharSequence;
  }
  
  private static int g(List<List<String>> paramList, List<String> paramList1)
  {
    int k = 0;
    int i = 0;
    if (k < paramList.size() - paramList1.size() + 1)
    {
      int j;
      for (;;)
      {
        if (i < paramList1.size())
        {
          Object localObject = (List)paramList.get(k + i);
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
                  j = 1;
                  label132:
                  if (j != 0)
                  {
                    i += 1;
                    break;
                  }
                  j = 0;
                  i = 0;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if (j != 0)
        {
          return k;
          j = 0;
          i = 0;
        }
        else
        {
          k += 1;
          break;
          j = 0;
          break label132;
          j = 1;
        }
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.f
 * JD-Core Version:    0.7.0.1
 */