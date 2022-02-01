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
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/utils/WxImePendingIputUtil;", "", "()V", "TAG", "", "pendingInputCache", "Lkotlin/Pair;", "", "Lcom/tencent/wxhld/info/PendingInput;", "", "", "getDebugPendingInputText", "context", "Landroid/content/Context;", "pendingInputs", "(Landroid/content/Context;[Lcom/tencent/wxhld/info/PendingInput;)Ljava/lang/String;", "getPendingInputText", "(Landroid/content/Context;[Lcom/tencent/wxhld/info/PendingInput;)Ljava/lang/CharSequence;", "getPendingInputTextAndCursor", "(Landroid/content/Context;[Lcom/tencent/wxhld/info/PendingInput;)Lkotlin/Pair;", "getValidIndex", "index", "length", "reset", "", "plugin-hld_release"})
public final class h
{
  private static o<? extends PendingInput[], ? extends o<? extends CharSequence, Integer>> DHk;
  public static final h DHl;
  private static final String TAG = "WxIme.WxImePendingIputUtil";
  
  static
  {
    AppMethodBeat.i(213577);
    DHl = new h();
    TAG = "WxIme.WxImePendingIputUtil";
    AppMethodBeat.o(213577);
  }
  
  public static o<CharSequence, Integer> a(Context paramContext, PendingInput[] paramArrayOfPendingInput)
  {
    AppMethodBeat.i(213569);
    p.k(paramContext, "context");
    if (paramArrayOfPendingInput != null)
    {
      Object localObject2 = TAG;
      Object localObject3 = new StringBuilder("getPendingInputTextAndCursor ");
      Object localObject1 = DHk;
      if (localObject1 != null)
      {
        localObject1 = (PendingInput[])((o)localObject1).Mx;
        if (localObject1 == null) {}
      }
      for (localObject1 = Integer.valueOf(((Object[])localObject1).hashCode());; localObject1 = null)
      {
        Log.d((String)localObject2, localObject1 + ' ' + paramArrayOfPendingInput.hashCode());
        localObject1 = DHk;
        if (localObject1 == null) {
          break;
        }
        localObject1 = (PendingInput[])((o)localObject1).Mx;
        if ((localObject1 == null) || (Arrays.equals((Object[])localObject1, paramArrayOfPendingInput) != true)) {
          break;
        }
        Log.i(TAG, "getPendingInputTextAndCursor use cache");
        paramContext = DHk;
        if (paramContext == null) {
          p.iCn();
        }
        paramContext = (o)paramContext.My;
        AppMethodBeat.o(213569);
        return paramContext;
      }
      int i = 0;
      localObject1 = "";
      int i1 = -1;
      int j = -1;
      localObject2 = new ArrayList();
      int i2 = paramArrayOfPendingInput.length;
      int k = 0;
      if (k < i2)
      {
        int m = i1;
        if (paramArrayOfPendingInput[k].type() == 0)
        {
          m = i1;
          if (i1 == -1) {
            m = ((String)localObject1).length();
          }
        }
        int n = j;
        if (paramArrayOfPendingInput[k].type() != 0)
        {
          n = j;
          if (j == -1) {
            n = ((String)localObject1).length();
          }
        }
        switch (paramArrayOfPendingInput[k].type())
        {
        }
        for (;;)
        {
          k += 1;
          i1 = m;
          j = n;
          break;
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject3 = paramArrayOfPendingInput[k];
          if (localObject3 == null)
          {
            paramContext = new t("null cannot be cast to non-null type com.tencent.wxhld.info.PendingSelectedText");
            AppMethodBeat.o(213569);
            throw paramContext;
          }
          localObject1 = ((PendingSelectedText)localObject3).text;
          continue;
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject3 = paramArrayOfPendingInput[k];
          if (localObject3 == null)
          {
            paramContext = new t("null cannot be cast to non-null type com.tencent.wxhld.info.PendingExactlyMatch");
            AppMethodBeat.o(213569);
            throw paramContext;
          }
          localObject1 = ((PendingExactlyMatch)localObject3).match;
          continue;
          ((ArrayList)localObject2).add(new a(2, ((String)localObject1).length()));
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject3 = paramArrayOfPendingInput[k];
          if (localObject3 == null)
          {
            paramContext = new t("null cannot be cast to non-null type com.tencent.wxhld.info.PendingDeletion");
            AppMethodBeat.o(213569);
            throw paramContext;
          }
          localObject1 = ((PendingDeletion)localObject3).deleted;
          continue;
          ((ArrayList)localObject2).add(new a(3, ((String)localObject1).length()));
          continue;
          ((ArrayList)localObject2).add(new a(4, ((String)localObject1).length()));
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject3 = paramArrayOfPendingInput[k];
          if (localObject3 == null)
          {
            paramContext = new t("null cannot be cast to non-null type com.tencent.wxhld.info.PendingReplacement");
            AppMethodBeat.o(213569);
            throw paramContext;
          }
          localObject1 = ((PendingReplacement)localObject3).from;
          continue;
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject3 = paramArrayOfPendingInput[k];
          if (localObject3 == null)
          {
            paramContext = new t("null cannot be cast to non-null type com.tencent.wxhld.info.PendingExchange");
            AppMethodBeat.o(213569);
            throw paramContext;
          }
          localObject1 = ((PendingExchange)localObject3).right;
          ((ArrayList)localObject2).add(new a(5, ((String)localObject1).length()));
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject3 = paramArrayOfPendingInput[k];
          if (localObject3 == null)
          {
            paramContext = new t("null cannot be cast to non-null type com.tencent.wxhld.info.PendingExchange");
            AppMethodBeat.o(213569);
            throw paramContext;
          }
          localObject1 = ((PendingExchange)localObject3).left;
          continue;
          localObject1 = (String)localObject1 + paramContext.getString(a.j.wxime_separator);
          continue;
          i = ((String)localObject1).length();
        }
      }
      localObject3 = new SpannableStringBuilder((CharSequence)localObject1);
      if (i1 != -1)
      {
        k = j;
        if (j == -1) {
          k = ((String)localObject1).length();
        }
        ((SpannableStringBuilder)localObject3).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(a.c.Brand)), i1, k, 34);
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        label947:
        Object localObject4;
        if (((CharSequence)localObject1).length() > 0)
        {
          j = 1;
          if (j == 0) {
            break label1104;
          }
          paramContext = new ForegroundColorSpan(paramContext.getResources().getColor(a.c.FG_2));
          j = 0;
          k = ((Collection)localObject2).size();
          if (j >= k) {
            break label1104;
          }
          localObject4 = ((ArrayList)localObject2).get(j);
          p.j(localObject4, "faultDataList[i]");
          localObject4 = (a)localObject4;
          switch (((a)localObject4).DGH)
          {
          }
        }
        for (;;)
        {
          j += 1;
          break label947;
          j = 0;
          break;
          ((SpannableStringBuilder)localObject3).setSpan(paramContext, hQ(((a)localObject4).index, ((String)localObject1).length()), hQ(((a)localObject4).index + 1, ((String)localObject1).length()), 34);
          continue;
          ((SpannableStringBuilder)localObject3).setSpan(paramContext, hQ(((a)localObject4).index - 1, ((String)localObject1).length()), hQ(((a)localObject4).index + 1, ((String)localObject1).length()), 34);
        }
      }
      label1104:
      paramContext = new o(localObject3, Integer.valueOf(i));
      DHk = new o(paramArrayOfPendingInput, paramContext);
      AppMethodBeat.o(213569);
      return paramContext;
    }
    paramContext = new o("", Integer.valueOf(0));
    AppMethodBeat.o(213569);
    return paramContext;
  }
  
  public static String b(Context paramContext, PendingInput[] paramArrayOfPendingInput)
  {
    AppMethodBeat.i(213574);
    p.k(paramContext, "context");
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramArrayOfPendingInput != null)
    {
      int i = 0;
      int j = paramArrayOfPendingInput.length;
      localObject2 = localObject1;
      if (i < j)
      {
        switch (paramArrayOfPendingInput[i].type())
        {
        }
        for (;;)
        {
          i += 1;
          break;
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject2 = paramArrayOfPendingInput[i];
          if (localObject2 == null)
          {
            paramContext = new t("null cannot be cast to non-null type com.tencent.wxhld.info.PendingSelectedText");
            AppMethodBeat.o(213574);
            throw paramContext;
          }
          localObject1 = ((PendingSelectedText)localObject2).text;
          continue;
          localObject1 = (String)localObject1 + "[";
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject2 = paramArrayOfPendingInput[i];
          if (localObject2 == null)
          {
            paramContext = new t("null cannot be cast to non-null type com.tencent.wxhld.info.PendingExactlyMatch");
            AppMethodBeat.o(213574);
            throw paramContext;
          }
          localObject1 = ((PendingExactlyMatch)localObject2).match;
          localObject1 = (String)localObject1 + "]";
          continue;
          localObject1 = (String)localObject1 + "-";
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject2 = paramArrayOfPendingInput[i];
          if (localObject2 == null)
          {
            paramContext = new t("null cannot be cast to non-null type com.tencent.wxhld.info.PendingDeletion");
            AppMethodBeat.o(213574);
            throw paramContext;
          }
          localObject1 = ((PendingDeletion)localObject2).deleted;
          localObject1 = (String)localObject1 + "-";
          continue;
          localObject1 = (String)localObject1 + "+";
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject2 = paramArrayOfPendingInput[i];
          if (localObject2 == null)
          {
            paramContext = new t("null cannot be cast to non-null type com.tencent.wxhld.info.PendingInsertion");
            AppMethodBeat.o(213574);
            throw paramContext;
          }
          localObject1 = ((PendingInsertion)localObject2).insertion;
          localObject1 = (String)localObject1 + "+";
          continue;
          localObject1 = (String)localObject1 + "(";
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject2 = paramArrayOfPendingInput[i];
          if (localObject2 == null)
          {
            paramContext = new t("null cannot be cast to non-null type com.tencent.wxhld.info.PendingReplacement");
            AppMethodBeat.o(213574);
            throw paramContext;
          }
          localObject1 = ((PendingReplacement)localObject2).from;
          localObject1 = (String)localObject1 + "->";
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject2 = paramArrayOfPendingInput[i];
          if (localObject2 == null)
          {
            paramContext = new t("null cannot be cast to non-null type com.tencent.wxhld.info.PendingReplacement");
            AppMethodBeat.o(213574);
            throw paramContext;
          }
          localObject1 = ((PendingReplacement)localObject2).to;
          localObject1 = (String)localObject1 + ")";
          continue;
          localObject1 = (String)localObject1 + "{";
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject2 = paramArrayOfPendingInput[i];
          if (localObject2 == null)
          {
            paramContext = new t("null cannot be cast to non-null type com.tencent.wxhld.info.PendingExchange");
            AppMethodBeat.o(213574);
            throw paramContext;
          }
          localObject1 = ((PendingExchange)localObject2).left;
          localObject1 = (String)localObject1 + "<->";
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject2 = paramArrayOfPendingInput[i];
          if (localObject2 == null)
          {
            paramContext = new t("null cannot be cast to non-null type com.tencent.wxhld.info.PendingExchange");
            AppMethodBeat.o(213574);
            throw paramContext;
          }
          localObject1 = ((PendingExchange)localObject2).right;
          localObject1 = (String)localObject1 + "}";
          continue;
          localObject1 = (String)localObject1 + "[";
          localObject1 = (String)localObject1 + paramContext.getString(a.j.wxime_separator);
          localObject1 = (String)localObject1 + "]";
          continue;
          localObject1 = (String)localObject1 + "[";
          localObject1 = (String)localObject1 + paramContext.getString(a.j.wxime_cursor);
          localObject1 = (String)localObject1 + "]";
        }
      }
    }
    AppMethodBeat.o(213574);
    return localObject2;
  }
  
  private static int hQ(int paramInt1, int paramInt2)
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
    DHk = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.h
 * JD-Core Version:    0.7.0.1
 */