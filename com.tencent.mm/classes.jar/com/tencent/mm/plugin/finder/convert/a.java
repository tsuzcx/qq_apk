package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import d.v;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderCommentConvertUtil;", "", "()V", "TAG", "", "lastProfileUsername", "getLastProfileUsername", "()Ljava/lang/String;", "setLastProfileUsername", "(Ljava/lang/String;)V", "calcTextWidth", "", "context", "Landroid/content/Context;", "length", "ellipseText", "tp", "Landroid/text/TextPaint;", "text", "maxWidth", "maxWithEllipseWidth", "getTextViewWidth", "tv", "Landroid/widget/TextView;", "getTextWidth", "", "paint", "jumpProfile", "", "username", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "commentScene", "measureByStaticLayout", "width", "extraMaxWidth", "setNickName", "spanText", "", "setNicknameCalculateWidth", "feedCommentLayout", "Landroid/view/View;", "nickNameTv", "commentTime", "awesomeIv", "awesomeNumTv", "ownerTv", "friendTv", "nickNameCharsequence", "commentTimeText", "plugin-finder_release"})
public final class a
{
  private static final String TAG = "Finder.FinderCommentConvertUtil";
  private static String qZE;
  public static final a qZF;
  
  static
  {
    AppMethodBeat.i(178099);
    qZF = new a();
    TAG = "Finder.FinderCommentConvertUtil";
    qZE = "";
    AppMethodBeat.o(178099);
  }
  
  public static int U(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(178096);
    d.g.b.k.h(paramContext, "context");
    paramInt = com.tencent.mm.cc.a.fromDPToPix(paramContext, paramInt * 15 + 1);
    AppMethodBeat.o(178096);
    return paramInt;
  }
  
  public static String a(TextPaint paramTextPaint, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178097);
    d.g.b.k.h(paramTextPaint, "tp");
    if ((paramString == null) || (bs.isNullOrNil(paramString)))
    {
      paramTextPaint = paramString;
      if (paramString == null) {
        paramTextPaint = "";
      }
      AppMethodBeat.o(178097);
      return paramTextPaint;
    }
    StaticLayout localStaticLayout;
    try
    {
      localObject = com.tencent.mm.pluginsdk.ui.span.k.c(ai.getContext(), (CharSequence)paramString);
      localStaticLayout = new StaticLayout((CharSequence)localObject, 0, ((SpannableString)localObject).length(), paramTextPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      if (new StaticLayout((CharSequence)localObject, 0, ((SpannableString)localObject).length(), paramTextPaint, paramInt2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= 1)
      {
        AppMethodBeat.o(178097);
        return paramString;
      }
    }
    catch (Throwable paramTextPaint)
    {
      ac.printErrStackTrace(TAG, paramTextPaint, "ellipseText: ".concat(String.valueOf(paramString)), new Object[0]);
      AppMethodBeat.o(178097);
      return paramString;
    }
    paramInt1 = localStaticLayout.getLineEnd(0);
    paramTextPaint = new StringBuilder();
    if (paramString == null)
    {
      paramTextPaint = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(178097);
      throw paramTextPaint;
    }
    Object localObject = paramString.substring(0, paramInt1);
    d.g.b.k.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramTextPaint = (String)localObject + "...";
    AppMethodBeat.o(178097);
    return paramTextPaint;
  }
  
  public static void a(final Context paramContext, View paramView1, final TextView paramTextView1, final TextView paramTextView2, final View paramView2, final TextView paramTextView3, final TextView paramTextView4, final TextView paramTextView5, CharSequence paramCharSequence, final String paramString)
  {
    AppMethodBeat.i(178095);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramView1, "feedCommentLayout");
    d.g.b.k.h(paramTextView1, "nickNameTv");
    d.g.b.k.h(paramTextView2, "commentTime");
    d.g.b.k.h(paramTextView4, "ownerTv");
    d.g.b.k.h(paramTextView5, "friendTv");
    d.g.b.k.h(paramCharSequence, "nickNameCharsequence");
    d.g.b.k.h(paramString, "commentTimeText");
    paramView1.post((Runnable)new a(paramView1, paramContext, paramTextView2, paramString, paramView2, paramTextView3, paramTextView4, paramTextView5, paramTextView1));
    AppMethodBeat.o(178095);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.finder.model.l paraml, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(178094);
    d.g.b.k.h(paramString, "username");
    d.g.b.k.h(paraml, "item");
    d.g.b.k.h(paramContext, "context");
    if ((!bs.isNullOrNil(paramString)) && (bs.lr(qZE, paramString)) && ((paramContext instanceof FinderProfileTimeLineUI)))
    {
      ((FinderProfileTimeLineUI)paramContext).finish();
      AppMethodBeat.o(178094);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", paramString);
    Object localObject = FinderReporterUIC.seQ;
    FinderReporterUIC.a.a(paramContext, localIntent, paraml.ruO.field_feedId, 5, false, 64);
    localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramContext, localIntent);
    paramContext = d.rxr;
    d.a(5, paraml.ruO.field_feedId, paramInt, 1, paramString);
    AppMethodBeat.o(178094);
  }
  
  public static void adp(String paramString)
  {
    AppMethodBeat.i(178093);
    d.g.b.k.h(paramString, "<set-?>");
    qZE = paramString;
    AppMethodBeat.o(178093);
  }
  
  public static void d(TextView paramTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(178098);
    d.g.b.k.h(paramTextView, "tv");
    d.g.b.k.h(paramCharSequence, "spanText");
    Object localObject1 = paramTextView.getContext();
    d.g.b.k.g(localObject1, "tv.context");
    Object localObject2 = b.rCU;
    int i = U((Context)localObject1, b.czJ());
    localObject1 = paramTextView.getContext();
    d.g.b.k.g(localObject1, "tv.context");
    localObject2 = b.rCU;
    int j = U((Context)localObject1, b.czJ() + 1);
    localObject1 = new StaticLayout(paramCharSequence, 0, paramCharSequence.length(), paramTextView.getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    if (new StaticLayout(paramCharSequence, 0, paramCharSequence.length(), paramTextView.getPaint(), j, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= 1) {}
    for (;;)
    {
      paramTextView.setText(paramCharSequence);
      AppMethodBeat.o(178098);
      return;
      i = ((StaticLayout)localObject1).getLineEnd(0);
      localObject1 = paramTextView.getContext();
      localObject2 = new StringBuilder();
      paramCharSequence = paramCharSequence.toString();
      if (paramCharSequence == null)
      {
        paramTextView = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(178098);
        throw paramTextView;
      }
      paramCharSequence = paramCharSequence.substring(0, i);
      d.g.b.k.g(paramCharSequence, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramCharSequence = (CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject1, (CharSequence)(paramCharSequence + "..."));
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(View paramView1, Context paramContext, TextView paramTextView1, String paramString, View paramView2, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5) {}
    
    public final void run()
    {
      AppMethodBeat.i(178092);
      int k;
      int m;
      float f1;
      float f2;
      int j;
      int i;
      if (this.qZG.getWidth() > 0)
      {
        k = this.qZG.getWidth();
        m = com.tencent.mm.cc.a.au(paramContext, 2131165302);
        f1 = paramTextView2.getPaint().measureText(paramString);
        f2 = com.tencent.mm.cc.a.au(paramContext, 2131165303);
        if ((paramView2 == null) || (paramView2.getVisibility() != 0)) {
          break label249;
        }
        j = paramView2.getWidth();
        if ((paramTextView3 == null) || (paramTextView3.getVisibility() != 0)) {
          break label243;
        }
        i = paramTextView3.getWidth() + com.tencent.mm.cc.a.au(paramContext, 2131165274);
      }
      for (;;)
      {
        Object localObject = a.qZF;
        int n = a.l(paramTextView4);
        int i1 = com.tencent.mm.cc.a.au(paramContext, 2131165274);
        localObject = a.qZF;
        int i2 = a.l(paramTextView5);
        int i3 = com.tencent.mm.cc.a.au(paramContext, 2131165274);
        localObject = paramTextView1;
        float f3 = k - m;
        float f4 = n + i1 + (i2 + i3);
        float f5 = j;
        ((TextView)localObject).setMaxWidth((int)(f3 - (i + (f4 + (f1 + f2) + f5)) - com.tencent.mm.cc.a.au(paramContext, 2131165303)));
        AppMethodBeat.o(178092);
        return;
        label243:
        i = 0;
        continue;
        label249:
        i = 0;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.a
 * JD-Core Version:    0.7.0.1
 */