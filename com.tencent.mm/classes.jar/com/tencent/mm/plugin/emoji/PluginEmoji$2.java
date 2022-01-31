package com.tencent.mm.plugin.emoji;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.f;
import com.tencent.mm.cd.g;
import com.tencent.mm.sdk.platformtools.bo;
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
  
  public final int bW(String paramString, int paramInt)
  {
    AppMethodBeat.i(62321);
    g.dvk();
    Object localObject = f.dvf();
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(62321);
      return paramInt;
    }
    int j = paramString.length();
    if ((paramInt == 0) || (paramInt == j))
    {
      AppMethodBeat.o(62321);
      return paramInt;
    }
    if (f.yuU == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int k = ((f)localObject).yuK.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.yuK[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      k = ((f)localObject).yuL.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.yuL[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      k = ((f)localObject).yuM.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.yuM[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      k = ((f)localObject).yuN.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.yuN[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      k = ((f)localObject).yuO.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.yuO[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      k = ((f)localObject).yuP.length;
      i = 0;
      while (i < k)
      {
        localStringBuilder.append(Pattern.quote(localObject.yuP[i]));
        if (i != k - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      if ((((f)localObject).yuQ != null) && (!((f)localObject).yuQ.isEmpty()))
      {
        localObject = ((f)localObject).yuQ.iterator();
        while (((Iterator)localObject).hasNext())
        {
          SmileyInfo localSmileyInfo = (SmileyInfo)((Iterator)localObject).next();
          localStringBuilder.append(Pattern.quote(localSmileyInfo.field_key)).append("|");
          if (!bo.isNullOrNil(localSmileyInfo.field_cnValue)) {
            localStringBuilder.append(Pattern.quote(localSmileyInfo.field_cnValue)).append("|");
          }
          if (!bo.isNullOrNil(localSmileyInfo.field_enValue)) {
            localStringBuilder.append(Pattern.quote(localSmileyInfo.field_enValue)).append("|");
          }
          if (!bo.isNullOrNil(localSmileyInfo.field_qqValue)) {
            localStringBuilder.append(Pattern.quote(localSmileyInfo.field_qqValue)).append("|");
          }
          if (!bo.isNullOrNil(localSmileyInfo.field_twValue)) {
            localStringBuilder.append(Pattern.quote(localSmileyInfo.field_twValue)).append("|");
          }
          if (!bo.isNullOrNil(localSmileyInfo.field_thValue)) {
            localStringBuilder.append(Pattern.quote(localSmileyInfo.field_thValue)).append("|");
          }
        }
      }
      f.yuU = Pattern.compile(localStringBuilder.toString());
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
      paramString = f.yuU.matcher(paramString);
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
        AppMethodBeat.o(62321);
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
  
  public final CharSequence c(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(62320);
    paramContext = g.dvk().b(paramCharSequence, paramFloat);
    AppMethodBeat.o(62320);
    return paramContext;
  }
  
  public final CharSequence h(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(62319);
    paramCharSequence = g.dvk().p(paramCharSequence, paramInt);
    AppMethodBeat.o(62319);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.PluginEmoji.2
 * JD-Core Version:    0.7.0.1
 */