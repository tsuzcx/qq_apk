package com.tencent.mm.plugin.emoji;

import com.tencent.mm.cd.f;
import com.tencent.mm.cd.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.ui.e.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class PluginEmoji$2
  implements a
{
  PluginEmoji$2(PluginEmoji paramPluginEmoji) {}
  
  public final CharSequence b(CharSequence paramCharSequence, float paramFloat)
  {
    return g.csM().a(paramCharSequence, paramFloat);
  }
  
  public final int bs(String paramString, int paramInt)
  {
    g.csM();
    Object localObject = f.csI();
    if (bk.bl(paramString)) {}
    int j;
    do
    {
      return paramInt;
      j = paramString.length();
    } while ((paramInt == 0) || (paramInt == j));
    if (f.ulq == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int k = ((f)localObject).ulg.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.ulg[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      k = ((f)localObject).ulh.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.ulh[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      k = ((f)localObject).uli.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.uli[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      k = ((f)localObject).ulj.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.ulj[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      k = ((f)localObject).ulk.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.ulk[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      k = ((f)localObject).ull.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.ull[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      if ((((f)localObject).ulm != null) && (!((f)localObject).ulm.isEmpty()))
      {
        localObject = ((f)localObject).ulm.iterator();
        while (((Iterator)localObject).hasNext())
        {
          q localq = (q)((Iterator)localObject).next();
          localStringBuilder.append(Pattern.quote(localq.field_key)).append("|");
          if (!bk.bl(localq.field_cnValue)) {
            localStringBuilder.append(Pattern.quote(localq.field_cnValue)).append("|");
          }
          if (!bk.bl(localq.field_enValue)) {
            localStringBuilder.append(Pattern.quote(localq.field_enValue)).append("|");
          }
          if (!bk.bl(localq.field_qqValue)) {
            localStringBuilder.append(Pattern.quote(localq.field_qqValue)).append("|");
          }
          if (!bk.bl(localq.field_twValue)) {
            localStringBuilder.append(Pattern.quote(localq.field_twValue)).append("|");
          }
          if (!bk.bl(localq.field_thValue)) {
            localStringBuilder.append(Pattern.quote(localq.field_thValue)).append("|");
          }
        }
      }
      f.ulq = Pattern.compile(localStringBuilder.toString());
    }
    if (paramInt < 6)
    {
      i = 0;
      if (paramInt + 6 < j) {
        break label706;
      }
      j -= 1;
      label636:
      paramString = paramString.substring(i, j);
      paramString = f.ulq.matcher(paramString);
      do
      {
        if (!paramString.find()) {
          break;
        }
      } while ((6 <= paramString.start()) || (6 >= paramString.end()));
    }
    for (int i = paramString.start();; i = 6)
    {
      if (i - 6 > 0) {
        i -= 6;
      }
      for (;;)
      {
        return paramInt + i;
        i = paramInt - 6;
        break;
        label706:
        j = paramInt + 6;
        break label636;
        i = 0;
      }
    }
  }
  
  public final CharSequence c(CharSequence paramCharSequence, int paramInt)
  {
    return g.csM().g(paramCharSequence, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.PluginEmoji.2
 * JD-Core Version:    0.7.0.1
 */