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
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderCommentConvertUtil;", "", "()V", "TAG", "", "lastProfileUsername", "getLastProfileUsername", "()Ljava/lang/String;", "setLastProfileUsername", "(Ljava/lang/String;)V", "calcTextWidth", "", "context", "Landroid/content/Context;", "length", "ellipseText", "tp", "Landroid/text/TextPaint;", "text", "maxWidth", "maxWithEllipseWidth", "getNickName", "", "paint", "spanText", "maxNameCount", "tv", "Landroid/widget/TextView;", "getTextViewWidth", "getTextWidth", "", "jumpProfile", "", "username", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "commentScene", "measureByStaticLayout", "width", "extraMaxWidth", "setNickName", "setNicknameCalculateWidth", "feedCommentLayout", "Landroid/view/View;", "nickNameTv", "commentTime", "awesomeIv", "awesomeNumTv", "ownerTv", "friendTv", "nickNameCharsequence", "commentTimeText", "plugin-finder_release"})
public final class d
{
  private static final String TAG = "Finder.FinderCommentConvertUtil";
  private static String tyY;
  public static final d tyZ;
  
  static
  {
    AppMethodBeat.i(178099);
    tyZ = new d();
    TAG = "Finder.FinderCommentConvertUtil";
    tyY = "";
    AppMethodBeat.o(178099);
  }
  
  public static int Z(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(178096);
    p.h(paramContext, "context");
    paramInt = com.tencent.mm.cb.a.fromDPToPix(paramContext, paramInt * 15 + 1);
    AppMethodBeat.o(178096);
    return paramInt;
  }
  
  public static CharSequence a(TextView paramTextView, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(242771);
    p.h(paramTextView, "tv");
    p.h(paramCharSequence, "spanText");
    Object localObject = paramTextView.getContext();
    p.g(localObject, "tv.context");
    int i = Z((Context)localObject, paramInt);
    localObject = paramTextView.getContext();
    p.g(localObject, "tv.context");
    paramInt = Z((Context)localObject, paramInt + 1);
    localObject = new StaticLayout(paramCharSequence, 0, paramCharSequence.length(), paramTextView.getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    if (new StaticLayout(paramCharSequence, 0, paramCharSequence.length(), paramTextView.getPaint(), paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= 1)
    {
      AppMethodBeat.o(242771);
      return paramCharSequence;
    }
    paramInt = ((StaticLayout)localObject).getLineEnd(0);
    paramTextView = paramTextView.getContext();
    localObject = new StringBuilder();
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence == null)
    {
      paramTextView = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(242771);
      throw paramTextView;
    }
    paramCharSequence = paramCharSequence.substring(0, paramInt);
    p.g(paramCharSequence, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramTextView = com.tencent.mm.pluginsdk.ui.span.l.c(paramTextView, (CharSequence)(paramCharSequence + "..."));
    p.g(paramTextView, "MMSpanManager.spanForSmi…0, ellipseStart) + \"...\")");
    paramTextView = (CharSequence)paramTextView;
    AppMethodBeat.o(242771);
    return paramTextView;
  }
  
  public static String a(TextPaint paramTextPaint, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178097);
    p.h(paramTextPaint, "tp");
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
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
      localObject = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramString);
      localStaticLayout = new StaticLayout((CharSequence)localObject, 0, ((SpannableString)localObject).length(), paramTextPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      if (new StaticLayout((CharSequence)localObject, 0, ((SpannableString)localObject).length(), paramTextPaint, paramInt2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= 1)
      {
        AppMethodBeat.o(178097);
        return paramString;
      }
    }
    catch (Throwable paramTextPaint)
    {
      Log.printErrStackTrace(TAG, paramTextPaint, "ellipseText: ".concat(String.valueOf(paramString)), new Object[0]);
      AppMethodBeat.o(178097);
      return paramString;
    }
    paramInt1 = localStaticLayout.getLineEnd(0);
    paramTextPaint = new StringBuilder();
    if (paramString == null)
    {
      paramTextPaint = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(178097);
      throw paramTextPaint;
    }
    Object localObject = paramString.substring(0, paramInt1);
    p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramTextPaint = (String)localObject + "...";
    AppMethodBeat.o(178097);
    return paramTextPaint;
  }
  
  public static void a(final Context paramContext, View paramView1, final TextView paramTextView1, final TextView paramTextView2, final View paramView2, final TextView paramTextView3, final TextView paramTextView4, final TextView paramTextView5, CharSequence paramCharSequence, final String paramString)
  {
    AppMethodBeat.i(178095);
    p.h(paramContext, "context");
    p.h(paramView1, "feedCommentLayout");
    p.h(paramTextView1, "nickNameTv");
    p.h(paramTextView2, "commentTime");
    p.h(paramTextView4, "ownerTv");
    p.h(paramTextView5, "friendTv");
    p.h(paramCharSequence, "nickNameCharsequence");
    p.h(paramString, "commentTimeText");
    paramView1.post((Runnable)new a(paramView1, paramContext, paramTextView2, paramString, paramView2, paramTextView3, paramTextView4, paramTextView5, paramTextView1));
    AppMethodBeat.o(178095);
  }
  
  public static void a(String paramString, s params, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(178094);
    p.h(paramString, "username");
    p.h(params, "item");
    p.h(paramContext, "context");
    if ((!Util.isNullOrNil(paramString)) && (Util.isEqual(tyY, paramString)) && ((paramContext instanceof FinderProfileTimeLineUI)))
    {
      ((FinderProfileTimeLineUI)paramContext).finish();
      AppMethodBeat.o(178094);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", paramString);
    Object localObject = FinderReporterUIC.wzC;
    FinderReporterUIC.a.a(paramContext, localIntent, params.uOf.field_feedId, 5, false, 64);
    localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramContext, localIntent);
    paramContext = k.vfA;
    k.a(5, params.uOf.field_feedId, paramInt, 1, paramString);
    AppMethodBeat.o(178094);
  }
  
  public static void asR(String paramString)
  {
    AppMethodBeat.i(178093);
    p.h(paramString, "<set-?>");
    tyY = paramString;
    AppMethodBeat.o(178093);
  }
  
  public final void d(TextView paramTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(178098);
    p.h(paramTextView, "tv");
    p.h(paramCharSequence, "spanText");
    paramTextView.setText(e(paramTextView, paramCharSequence));
    AppMethodBeat.o(178098);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
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
      if (this.tza.getWidth() > 0)
      {
        k = this.tza.getWidth();
        m = com.tencent.mm.cb.a.aG(paramContext, 2131165313);
        f1 = paramTextView2.getPaint().measureText(paramString);
        f2 = com.tencent.mm.cb.a.aG(paramContext, 2131165314);
        if ((paramView2 == null) || (paramView2.getVisibility() != 0)) {
          break label249;
        }
        j = paramView2.getWidth();
        if ((paramTextView3 == null) || (paramTextView3.getVisibility() != 0)) {
          break label243;
        }
        i = paramTextView3.getWidth() + com.tencent.mm.cb.a.aG(paramContext, 2131165277);
      }
      for (;;)
      {
        Object localObject = d.tyZ;
        int n = d.l(paramTextView4);
        int i1 = com.tencent.mm.cb.a.aG(paramContext, 2131165277);
        localObject = d.tyZ;
        int i2 = d.l(paramTextView5);
        int i3 = com.tencent.mm.cb.a.aG(paramContext, 2131165277);
        localObject = paramTextView1;
        float f3 = k - m;
        float f4 = n + i1 + (i2 + i3);
        float f5 = j;
        ((TextView)localObject).setMaxWidth((int)(f3 - (i + (f4 + (f1 + f2) + f5)) - com.tencent.mm.cb.a.aG(paramContext, 2131165314)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.d
 * JD-Core Version:    0.7.0.1
 */