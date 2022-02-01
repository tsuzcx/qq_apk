package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.uniComments.storge.b;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderCommentConvertUtil;", "", "()V", "TAG", "", "lastProfileUsername", "getLastProfileUsername", "()Ljava/lang/String;", "setLastProfileUsername", "(Ljava/lang/String;)V", "calcTextWidth", "", "context", "Landroid/content/Context;", "length", "ellipseText", "tp", "Landroid/text/TextPaint;", "text", "maxWidth", "maxWithEllipseWidth", "getNickName", "", "paint", "spanText", "maxNameCount", "tv", "Landroid/widget/TextView;", "getTextViewWidth", "getTextWidth", "", "jumpBizProfile", "", "bizUsername", "commentScene", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "currentFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "jumpProfile", "username", "measureByStaticLayout", "width", "extraMaxWidth", "setNickName", "setNicknameCalculateWidth", "feedCommentLayout", "Landroid/view/View;", "nickNameTv", "commentTime", "awesomeIv", "awesomeNumTv", "ownerTv", "friendTv", "nickNameCharsequence", "commentTimeText", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d AHD;
  private static String AHE;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(178099);
    AHD = new d();
    TAG = "Finder.FinderCommentConvertUtil";
    AHE = "";
    AppMethodBeat.o(178099);
  }
  
  public static CharSequence a(TextView paramTextView, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(350534);
    s.u(paramTextView, "tv");
    s.u(paramCharSequence, "spanText");
    Object localObject = paramTextView.getContext();
    s.s(localObject, "tv.context");
    int i = ao((Context)localObject, paramInt);
    localObject = paramTextView.getContext();
    s.s(localObject, "tv.context");
    paramInt = ao((Context)localObject, paramInt + 1);
    localObject = new StaticLayout(paramCharSequence, 0, paramCharSequence.length(), paramTextView.getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    if (new StaticLayout(paramCharSequence, 0, paramCharSequence.length(), paramTextView.getPaint(), paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= 1)
    {
      AppMethodBeat.o(350534);
      return paramCharSequence;
    }
    paramInt = ((StaticLayout)localObject).getLineEnd(0);
    paramTextView = paramTextView.getContext();
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence == null)
    {
      paramTextView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(350534);
      throw paramTextView;
    }
    paramCharSequence = paramCharSequence.substring(0, paramInt);
    s.s(paramCharSequence, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramTextView = p.b(paramTextView, (CharSequence)s.X(paramCharSequence, "..."));
    s.s(paramTextView, "{\n            val ellips…Start) + \"...\")\n        }");
    paramTextView = (CharSequence)paramTextView;
    AppMethodBeat.o(350534);
    return paramTextView;
  }
  
  public static String a(TextPaint paramTextPaint, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178097);
    s.u(paramTextPaint, "tp");
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      if (paramString == null)
      {
        AppMethodBeat.o(178097);
        return "";
      }
      AppMethodBeat.o(178097);
      return paramString;
    }
    StaticLayout localStaticLayout;
    try
    {
      SpannableString localSpannableString = p.b(MMApplicationContext.getContext(), (CharSequence)paramString);
      localStaticLayout = new StaticLayout((CharSequence)localSpannableString, 0, localSpannableString.length(), paramTextPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      if (new StaticLayout((CharSequence)localSpannableString, 0, localSpannableString.length(), paramTextPaint, paramInt2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= 1)
      {
        AppMethodBeat.o(178097);
        return paramString;
      }
    }
    finally
    {
      Log.printErrStackTrace(TAG, paramTextPaint, s.X("ellipseText: ", paramString), new Object[0]);
      AppMethodBeat.o(178097);
      return paramString;
    }
    paramInt1 = localStaticLayout.getLineEnd(0);
    if (paramString == null)
    {
      paramTextPaint = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(178097);
      throw paramTextPaint;
    }
    paramTextPaint = paramString.substring(0, paramInt1);
    s.s(paramTextPaint, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramTextPaint = s.X(paramTextPaint, "...");
    AppMethodBeat.o(178097);
    return paramTextPaint;
  }
  
  public static void a(Context paramContext, View paramView1, TextView paramTextView1, TextView paramTextView2, View paramView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5, CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(178095);
    s.u(paramContext, "context");
    s.u(paramView1, "feedCommentLayout");
    s.u(paramTextView1, "nickNameTv");
    s.u(paramTextView2, "commentTime");
    s.u(paramTextView4, "ownerTv");
    s.u(paramTextView5, "friendTv");
    s.u(paramCharSequence, "nickNameCharsequence");
    s.u(paramString, "commentTimeText");
    paramView1.post(new d..ExternalSyntheticLambda0(paramView1, paramContext, paramTextView2, paramString, paramView2, paramTextView3, paramTextView4, paramTextView5, paramTextView1));
    AppMethodBeat.o(178095);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, t paramt, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(350482);
    s.u(paramContext, "context");
    s.u(paramString, "bizUsername");
    s.u(paramt, "item");
    s.u(paramFinderItem, "currentFeed");
    if (paramInt == 120)
    {
      Log.i(TAG, "jumpBizProfile: hit SOURCE_PROFILE_TIMELINE, avatar can't click.");
      ((Activity)paramContext).finish();
      AppMethodBeat.o(350482);
      return;
    }
    Intent localIntent = new Intent();
    as.a locala = as.GSQ;
    as.a.a(paramContext, localIntent, paramt.ECu.field_feedId, 5, false, 64);
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("Contact_Scene", 214);
    localIntent.putExtra("biz_profile_enter_from_finder", true);
    localIntent.putExtra("force_get_contact", true);
    localIntent.putExtra("key_use_new_contact_profile", true);
    localIntent.putExtra("biz_profile_tab_type", 1);
    localIntent.putExtra("Contact_Scene_Note", paramFinderItem.getFeedObject().sessionBuffer);
    c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(350482);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, com.tencent.mm.plugin.finder.uniComments.storge.d paramd)
  {
    AppMethodBeat.i(350491);
    s.u(paramContext, "context");
    s.u(paramString, "bizUsername");
    s.u(paramd, "item");
    if (paramInt == 120)
    {
      Log.i(TAG, "jumpBizProfile: hit SOURCE_PROFILE_TIMELINE, avatar can't click.");
      ((Activity)paramContext).finish();
      AppMethodBeat.o(350491);
      return;
    }
    Intent localIntent = new Intent();
    as.a locala = as.GSQ;
    as.a.a(paramContext, localIntent, paramd.Gbp.field_feedId, 5, false, 64);
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("Contact_Scene", 214);
    localIntent.putExtra("biz_profile_enter_from_finder", true);
    localIntent.putExtra("force_get_contact", true);
    localIntent.putExtra("key_use_new_contact_profile", true);
    localIntent.putExtra("biz_profile_tab_type", 1);
    c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(350491);
  }
  
  private static final void a(View paramView1, Context paramContext, TextView paramTextView1, String paramString, View paramView2, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5)
  {
    AppMethodBeat.i(350547);
    s.u(paramView1, "$feedCommentLayout");
    s.u(paramContext, "$context");
    s.u(paramTextView1, "$commentTime");
    s.u(paramString, "$commentTimeText");
    s.u(paramTextView3, "$ownerTv");
    s.u(paramTextView4, "$friendTv");
    s.u(paramTextView5, "$nickNameTv");
    if (paramView1.getWidth() > 0)
    {
      int n = paramView1.getWidth();
      int i1 = com.tencent.mm.cd.a.br(paramContext, e.c.Edge_9A);
      float f1 = paramTextView1.getPaint().measureText(paramString);
      float f2 = com.tencent.mm.cd.a.br(paramContext, e.c.Edge_A);
      int m = 0;
      int k = 0;
      int j = k;
      int i = m;
      if (paramView2 != null)
      {
        j = k;
        i = m;
        if (paramView2.getVisibility() == 0)
        {
          m = paramView2.getWidth();
          j = k;
          i = m;
          if (paramTextView2 != null)
          {
            j = k;
            i = m;
            if (paramTextView2.getVisibility() == 0)
            {
              j = paramTextView2.getWidth() + com.tencent.mm.cd.a.br(paramContext, e.c.Edge_0_5_A);
              i = m;
            }
          }
        }
      }
      k = s(paramTextView3);
      m = com.tencent.mm.cd.a.br(paramContext, e.c.Edge_0_5_A);
      int i2 = s(paramTextView4);
      int i3 = com.tencent.mm.cd.a.br(paramContext, e.c.Edge_0_5_A);
      float f3 = n - i1;
      float f4 = k + m + (i2 + i3);
      float f5 = i;
      paramTextView5.setMaxWidth((int)(f3 - (j + (f5 + (f1 + f2 + f4))) - com.tencent.mm.cd.a.br(paramContext, e.c.Edge_A)));
    }
    AppMethodBeat.o(350547);
  }
  
  public static void a(String paramString, t paramt, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(178094);
    s.u(paramString, "username");
    s.u(paramt, "item");
    s.u(paramContext, "context");
    if ((!Util.isNullOrNil(paramString)) && (Util.isEqual(AHE, paramString)) && ((paramContext instanceof FinderProfileTimeLineUI)))
    {
      ((FinderProfileTimeLineUI)paramContext).finish();
      AppMethodBeat.o(178094);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", paramString);
    localIntent.putExtra("KEY_FROM_TIMELINE", true);
    localIntent.putExtra("KEY_DO_NOT_CHECK_ENTER_BIZ_PROFILE", true);
    as.a locala = as.GSQ;
    as.a.a(paramContext, localIntent, paramt.ECu.field_feedId, 5, false, 64);
    com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI(paramContext, localIntent);
    paramContext = z.FrZ;
    z.a(5, paramt.ECu.field_feedId, paramInt, 1, paramString);
    AppMethodBeat.o(178094);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.finder.uniComments.storge.d paramd, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(350500);
    s.u(paramString, "username");
    s.u(paramd, "item");
    s.u(paramContext, "context");
    if ((!Util.isNullOrNil(paramString)) && (Util.isEqual(AHE, paramString)) && ((paramContext instanceof FinderProfileTimeLineUI)))
    {
      ((FinderProfileTimeLineUI)paramContext).finish();
      AppMethodBeat.o(350500);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", paramString);
    localIntent.putExtra("KEY_FROM_TIMELINE", true);
    localIntent.putExtra("KEY_DO_NOT_CHECK_ENTER_BIZ_PROFILE", true);
    as.a locala = as.GSQ;
    as.a.a(paramContext, localIntent, paramd.Gbp.field_feedId, 5, false, 64);
    com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI(paramContext, localIntent);
    paramContext = z.FrZ;
    z.a(5, paramd.Gbp.field_feedId, paramInt, 1, paramString);
    AppMethodBeat.o(350500);
  }
  
  public static int ao(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(178096);
    s.u(paramContext, "context");
    paramInt = com.tencent.mm.cd.a.fromDPToPix(paramContext, paramInt * 15 + 1);
    AppMethodBeat.o(178096);
    return paramInt;
  }
  
  public static void avl(String paramString)
  {
    AppMethodBeat.i(178093);
    s.u(paramString, "<set-?>");
    AHE = paramString;
    AppMethodBeat.o(178093);
  }
  
  public static void d(TextView paramTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(178098);
    s.u(paramTextView, "tv");
    s.u(paramCharSequence, "spanText");
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    paramTextView.setText(a(paramTextView, paramCharSequence, com.tencent.mm.plugin.finder.storage.d.eRC()));
    AppMethodBeat.o(178098);
  }
  
  private static int s(TextView paramTextView)
  {
    AppMethodBeat.i(350512);
    if (paramTextView.getVisibility() != 0)
    {
      AppMethodBeat.o(350512);
      return 0;
    }
    int i = (int)paramTextView.getPaint().measureText(paramTextView.getText().toString());
    AppMethodBeat.o(350512);
    return i + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.d
 * JD-Core Version:    0.7.0.1
 */