package com.tencent.mm.plugin.emoji;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.f;
import com.tencent.mm.ce.g;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.ui.f.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class PluginEmoji$2
  implements a
{
  PluginEmoji$2(PluginEmoji paramPluginEmoji) {}
  
  public final CharSequence c(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(104548);
    paramContext = g.fqZ().b(paramCharSequence, paramFloat);
    AppMethodBeat.o(104548);
    return paramContext;
  }
  
  public final int cV(String paramString, int paramInt)
  {
    AppMethodBeat.i(104549);
    g.fqZ();
    Object localObject = f.fqV();
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(104549);
      return paramInt;
    }
    int j = paramString.length();
    if ((paramInt == 0) || (paramInt == j))
    {
      AppMethodBeat.o(104549);
      return paramInt;
    }
    if (f.IEs == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int k = ((f)localObject).IEh.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.IEh[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      k = ((f)localObject).IEi.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.IEi[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      k = ((f)localObject).IEj.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.IEj[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      k = ((f)localObject).IEk.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.IEk[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      k = ((f)localObject).IEl.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.IEl[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      k = ((f)localObject).IEm.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.IEm[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      if ((((f)localObject).IEn != null) && (!((f)localObject).IEn.isEmpty()))
      {
        localObject = ((f)localObject).IEn.iterator();
        while (((Iterator)localObject).hasNext())
        {
          SmileyInfo localSmileyInfo = (SmileyInfo)((Iterator)localObject).next();
          localStringBuilder.append(Pattern.quote(localSmileyInfo.field_key)).append("|");
          if (!bu.isNullOrNil(localSmileyInfo.field_cnValue)) {
            localStringBuilder.append(Pattern.quote(localSmileyInfo.field_cnValue)).append("|");
          }
          if (!bu.isNullOrNil(localSmileyInfo.field_enValue)) {
            localStringBuilder.append(Pattern.quote(localSmileyInfo.field_enValue)).append("|");
          }
          if (!bu.isNullOrNil(localSmileyInfo.field_qqValue)) {
            localStringBuilder.append(Pattern.quote(localSmileyInfo.field_qqValue)).append("|");
          }
          if (!bu.isNullOrNil(localSmileyInfo.field_twValue)) {
            localStringBuilder.append(Pattern.quote(localSmileyInfo.field_twValue)).append("|");
          }
          if (!bu.isNullOrNil(localSmileyInfo.field_thValue)) {
            localStringBuilder.append(Pattern.quote(localSmileyInfo.field_thValue)).append("|");
          }
        }
      }
      f.IEs = Pattern.compile(localStringBuilder.toString());
    }
    if (paramInt < 6)
    {
      i = 0;
      if (paramInt + 6 < j) {
        break label728;
      }
      j -= 1;
      label653:
      paramString = paramString.substring(i, j);
      paramString = f.IEs.matcher(paramString);
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
        AppMethodBeat.o(104549);
        return paramInt + i;
        i = paramInt - 6;
        break;
        label728:
        j = paramInt + 6;
        break label653;
        i = 0;
      }
    }
  }
  
  public final CharSequence i(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(104547);
    paramCharSequence = g.fqZ().n(paramCharSequence, paramInt);
    AppMethodBeat.o(104547);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.PluginEmoji.2
 * JD-Core Version:    0.7.0.1
 */