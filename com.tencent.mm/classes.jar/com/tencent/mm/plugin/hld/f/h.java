package com.tencent.mm.plugin.hld.f;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wxhld.info.PendingDeletion;
import com.tencent.wxhld.info.PendingExactlyMatch;
import com.tencent.wxhld.info.PendingExchange;
import com.tencent.wxhld.info.PendingInput;
import com.tencent.wxhld.info.PendingInsertion;
import com.tencent.wxhld.info.PendingReplacement;
import com.tencent.wxhld.info.PendingSelectedText;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/utils/WxImePendingIputUtil;", "", "()V", "TAG", "", "pendingInputCache", "Lkotlin/Pair;", "", "Lcom/tencent/wxhld/info/PendingInput;", "", "", "getDebugPendingInputText", "context", "Landroid/content/Context;", "pendingInputs", "(Landroid/content/Context;[Lcom/tencent/wxhld/info/PendingInput;)Ljava/lang/String;", "getPendingInputText", "(Landroid/content/Context;[Lcom/tencent/wxhld/info/PendingInput;)Ljava/lang/CharSequence;", "getPendingInputTextAndCursor", "(Landroid/content/Context;[Lcom/tencent/wxhld/info/PendingInput;)Lkotlin/Pair;", "getValidIndex", "index", "length", "reset", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h Jyy;
  private static r<? extends PendingInput[], ? extends r<? extends CharSequence, Integer>> Jyz;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(311630);
    Jyy = new h();
    TAG = "WxIme.WxImePendingIputUtil";
    AppMethodBeat.o(311630);
  }
  
  public static r<CharSequence, Integer> a(Context paramContext, PendingInput[] paramArrayOfPendingInput)
  {
    AppMethodBeat.i(311576);
    s.u(paramContext, "context");
    Object localObject2;
    Object localObject3;
    Object localObject1;
    int i;
    label180:
    label185:
    int k;
    int j;
    int m;
    int n;
    int i1;
    if (paramArrayOfPendingInput != null)
    {
      localObject2 = TAG;
      localObject3 = new StringBuilder("getPendingInputTextAndCursor ");
      localObject1 = Jyz;
      if (localObject1 == null)
      {
        localObject1 = null;
        Log.d((String)localObject2, localObject1 + ' ' + Integer.valueOf(paramArrayOfPendingInput.hashCode()));
        localObject1 = Jyz;
        if (localObject1 == null) {
          break label180;
        }
        localObject1 = (PendingInput[])((r)localObject1).bsC;
        if ((localObject1 == null) || (Arrays.equals((Object[])localObject1, paramArrayOfPendingInput) != true)) {
          break label180;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label185;
        }
        Log.i(TAG, "getPendingInputTextAndCursor use cache");
        paramContext = Jyz;
        s.checkNotNull(paramContext);
        paramContext = (r)paramContext.bsD;
        AppMethodBeat.o(311576);
        return paramContext;
        localObject1 = (PendingInput[])((r)localObject1).bsC;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = Integer.valueOf(((Object[])localObject1).hashCode());
        break;
      }
      k = 0;
      j = 0;
      localObject1 = "";
      i = -1;
      localObject2 = new ArrayList();
      int i2 = paramArrayOfPendingInput.length - 1;
      if (i2 < 0) {
        break label918;
      }
      m = 0;
      n = -1;
      k = j;
      j = i;
      i1 = m + 1;
      i = j;
      if (paramArrayOfPendingInput[m].type() == 0)
      {
        i = j;
        if (j == -1) {
          i = ((String)localObject1).length();
        }
      }
      j = n;
      if (paramArrayOfPendingInput[m].type() != 0)
      {
        j = n;
        if (n == -1) {
          j = ((String)localObject1).length();
        }
      }
      switch (paramArrayOfPendingInput[m].type())
      {
      default: 
        if (i1 <= i2) {
          break;
        }
      }
    }
    for (;;)
    {
      localObject3 = new SpannableStringBuilder((CharSequence)localObject1);
      if (i != -1)
      {
        m = j;
        if (j == -1) {
          m = ((String)localObject1).length();
        }
        ((SpannableStringBuilder)localObject3).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(a.c.Brand)), i, m, 34);
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        if (((CharSequence)localObject1).length() <= 0) {
          break label795;
        }
        i = 1;
        label431:
        if (i != 0)
        {
          paramContext = new ForegroundColorSpan(paramContext.getResources().getColor(a.c.FG_2));
          i = 0;
          m = ((ArrayList)localObject2).size() - 1;
          if (m < 0) {}
        }
      }
      for (;;)
      {
        j = i + 1;
        Object localObject4 = ((ArrayList)localObject2).get(i);
        s.s(localObject4, "faultDataList[i]");
        localObject4 = (a)localObject4;
        switch (((a)localObject4).Jye)
        {
        }
        for (;;)
        {
          if (j > m)
          {
            paramContext = new r(localObject3, Integer.valueOf(k));
            Jyz = new r(paramArrayOfPendingInput, paramContext);
            AppMethodBeat.o(311576);
            return paramContext;
            localObject1 = s.X((String)localObject1, ((PendingSelectedText)paramArrayOfPendingInput[m]).text);
            break;
            localObject1 = s.X((String)localObject1, ((PendingExactlyMatch)paramArrayOfPendingInput[m]).match);
            break;
            ((ArrayList)localObject2).add(new a(2, ((String)localObject1).length()));
            localObject1 = s.X((String)localObject1, ((PendingDeletion)paramArrayOfPendingInput[m]).deleted);
            break;
            ((ArrayList)localObject2).add(new a(3, ((String)localObject1).length()));
            break;
            ((ArrayList)localObject2).add(new a(4, ((String)localObject1).length()));
            localObject1 = s.X((String)localObject1, ((PendingReplacement)paramArrayOfPendingInput[m]).from);
            break;
            localObject1 = s.X((String)localObject1, ((PendingExchange)paramArrayOfPendingInput[m]).right);
            ((ArrayList)localObject2).add(new a(5, ((String)localObject1).length()));
            localObject1 = s.X((String)localObject1, ((PendingExchange)paramArrayOfPendingInput[m]).left);
            break;
            localObject1 = s.X((String)localObject1, paramContext.getString(a.j.wxime_separator));
            break;
            k = ((String)localObject1).length();
            break;
            label795:
            i = 0;
            break label431;
            ((SpannableStringBuilder)localObject3).setSpan(paramContext, ju(((a)localObject4).index, ((String)localObject1).length()), ju(((a)localObject4).index + 1, ((String)localObject1).length()), 34);
            continue;
            ((SpannableStringBuilder)localObject3).setSpan(paramContext, ju(((a)localObject4).index - 1, ((String)localObject1).length()), ju(((a)localObject4).index + 1, ((String)localObject1).length()), 34);
            continue;
            paramContext = new r("", Integer.valueOf(0));
            AppMethodBeat.o(311576);
            return paramContext;
          }
        }
        i = j;
      }
      m = i1;
      n = j;
      j = i;
      break;
      label918:
      j = -1;
      localObject1 = "";
    }
  }
  
  public static String b(Context paramContext, PendingInput[] paramArrayOfPendingInput)
  {
    AppMethodBeat.i(311609);
    s.u(paramContext, "context");
    String str2 = "";
    String str1 = str2;
    int k;
    int i;
    if (paramArrayOfPendingInput != null)
    {
      k = paramArrayOfPendingInput.length - 1;
      str1 = str2;
      if (k >= 0)
      {
        i = 0;
        str1 = "";
      }
    }
    for (;;)
    {
      int j = i + 1;
      switch (paramArrayOfPendingInput[i].type())
      {
      }
      while (j > k)
      {
        AppMethodBeat.o(311609);
        return str1;
        str1 = s.X(str1, ((PendingSelectedText)paramArrayOfPendingInput[i]).text);
        continue;
        str1 = s.X(s.X(s.X(str1, "["), ((PendingExactlyMatch)paramArrayOfPendingInput[i]).match), "]");
        continue;
        str1 = s.X(s.X(s.X(str1, "-"), ((PendingDeletion)paramArrayOfPendingInput[i]).deleted), "-");
        continue;
        str1 = s.X(s.X(s.X(str1, "+"), ((PendingInsertion)paramArrayOfPendingInput[i]).insertion), "+");
        continue;
        str1 = s.X(s.X(s.X(s.X(s.X(str1, "("), ((PendingReplacement)paramArrayOfPendingInput[i]).from), "->"), ((PendingReplacement)paramArrayOfPendingInput[i]).to), ")");
        continue;
        str1 = s.X(s.X(s.X(s.X(s.X(str1, "{"), ((PendingExchange)paramArrayOfPendingInput[i]).left), "<->"), ((PendingExchange)paramArrayOfPendingInput[i]).right), "}");
        continue;
        str1 = s.X(s.X(s.X(str1, "["), paramContext.getString(a.j.wxime_separator)), "]");
        continue;
        str1 = s.X(s.X(s.X(str1, "["), paramContext.getString(a.j.wxime_cursor)), "]");
      }
      i = j;
    }
  }
  
  private static int ju(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < 0) {
      i = 0;
    }
    do
    {
      return i;
      i = paramInt1;
    } while (paramInt1 <= paramInt2);
    if (paramInt2 - 1 < 0) {
      return 0;
    }
    return paramInt2 - 1;
  }
  
  public static void reset()
  {
    Jyz = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.h
 * JD-Core Version:    0.7.0.1
 */