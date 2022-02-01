package com.tencent.mm.plugin.finder.profile.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/adapter/ProfileHeaderHelper;", "", "header", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "getHeader", "()Landroid/view/ViewGroup;", "visibleStateRecorder", "", "changeBtnPos", "", "isDown", "", "view", "Landroid/view/View;", "changePosition", "spannableStr", "Landroid/text/SpannableString;", "locationText", "", "lltext", "isRecordStat", "getChangeLeftRegionWidth", "", "text", "getChangeRightRegionWidth", "", "getEditWidth", "getLocationTextWidth", "getTotalAvailableWidth", "recordVisibleState", "isShouldRecord", "restoreVisibleState", "setProfileTextWidth", "availableWidth", "nameExtWidth", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Fba;
  private final ViewGroup Fbb;
  private final int[] Fbc;
  
  static
  {
    AppMethodBeat.i(348424);
    Fba = new a((byte)0);
    AppMethodBeat.o(348424);
  }
  
  public a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(348376);
    this.Fbb = paramViewGroup;
    this.Fbc = new int[] { 0, 0 };
    AppMethodBeat.o(348376);
  }
  
  private static final void a(a parama, ah.f paramf1, ah.f paramf2, boolean paramBoolean)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(348420);
    s.u(parama, "this$0");
    s.u(paramf1, "$text");
    s.u(paramf2, "$locationText");
    Object localObject = new DisplayMetrics();
    Context localContext = parama.Fbb.getContext();
    if (localContext == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(348420);
      throw parama;
    }
    ((Activity)localContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    Log.i("ProfileHeaderHelper", s.X("screen width :", Integer.valueOf(((DisplayMetrics)localObject).widthPixels)));
    int k = ((DisplayMetrics)localObject).widthPixels - com.tencent.mm.cd.a.bs(parama.Fbb.getContext(), e.c.finder_12_A);
    if (parama.Fbc[0] == 0) {}
    for (int i = ((FrameLayout)parama.Fbb.findViewById(e.e.sendMsgBtn)).getWidth() + com.tencent.mm.cd.a.bs(parama.Fbb.getContext(), e.c.Edge_A) + 0;; i = 0)
    {
      int j = i;
      if (parama.Fbc[1] == 0) {
        j = i + (((FrameLayout)parama.Fbb.findViewById(e.e.finder_profile_follow_btn)).getWidth() + com.tencent.mm.cd.a.bs(parama.Fbb.getContext(), e.c.Edge_2A));
      }
      i = k - j;
      if (((ImageView)parama.Fbb.findViewById(e.e.finder_profile_auth_icon)).getVisibility() == 0) {}
      for (float f1 = com.tencent.mm.cd.a.bs(parama.Fbb.getContext(), e.c.Edge_2_5_A) + 0.0F;; f1 = 0.0F)
      {
        if (((WeImageView)parama.Fbb.findViewById(e.e.finder_profile_block_icon)).getVisibility() == 0) {
          f1 += com.tencent.mm.cd.a.bs(parama.Fbb.getContext(), e.c.Edge_2_5_A);
        }
        for (;;)
        {
          float f3 = ((TextView)parama.Fbb.findViewById(e.e.finder_profile_name_tv)).getPaint().measureText((String)paramf1.aqH);
          localObject = (String)paramf2.aqH;
          if (!Util.isNullOrNil((String)localObject)) {
            f2 = ((TextView)parama.Fbb.findViewById(e.e.user_tag_layout)).getPaint().measureText((String)localObject);
          }
          if ((f1 + f3 > i) || (f2 > i))
          {
            localObject = (FrameLayout)parama.Fbb.findViewById(e.e.sendMsgBtn);
            s.s(localObject, "header.sendMsgBtn");
            parama.a(true, (View)localObject);
            localObject = (FrameLayout)parama.Fbb.findViewById(e.e.finder_profile_follow_btn);
            s.s(localObject, "header.finder_profile_follow_btn");
            parama.a(true, (View)localObject);
            i = com.tencent.mm.cd.a.bs(parama.Fbb.getContext(), e.c.Edge_2A);
            parama.setProfileTextWidth((String)paramf1.aqH, (String)paramf2.aqH, k - i, (int)f1);
          }
          for (;;)
          {
            if (paramBoolean)
            {
              if (((FrameLayout)parama.Fbb.findViewById(e.e.sendMsgBtn)).getVisibility() != parama.Fbc[0]) {
                ((FrameLayout)parama.Fbb.findViewById(e.e.sendMsgBtn)).setVisibility(parama.Fbc[0]);
              }
              if (((FrameLayout)parama.Fbb.findViewById(e.e.finder_profile_follow_btn)).getVisibility() != parama.Fbc[1]) {
                ((FrameLayout)parama.Fbb.findViewById(e.e.finder_profile_follow_btn)).setVisibility(parama.Fbc[1]);
              }
              parama.Fbc[0] = 0;
              parama.Fbc[1] = 0;
            }
            AppMethodBeat.o(348420);
            return;
            localObject = (FrameLayout)parama.Fbb.findViewById(e.e.sendMsgBtn);
            s.s(localObject, "header.sendMsgBtn");
            parama.a(false, (View)localObject);
            localObject = (FrameLayout)parama.Fbb.findViewById(e.e.finder_profile_follow_btn);
            s.s(localObject, "header.finder_profile_follow_btn");
            parama.a(false, (View)localObject);
            parama.setProfileTextWidth((String)paramf1.aqH, (String)paramf2.aqH, i, (int)f1);
          }
        }
      }
    }
  }
  
  private final void a(boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(348393);
    int i;
    if (s.p(paramView, (FrameLayout)this.Fbb.findViewById(e.e.sendMsgBtn))) {
      i = 0;
    }
    Object localObject;
    while (this.Fbc[i] == 0)
    {
      localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(348393);
        throw paramView;
        i = 1;
      }
      else
      {
        localObject = (ConstraintLayout.LayoutParams)localObject;
        i = ((ConstraintLayout.LayoutParams)localObject).topMargin;
        if ((!paramBoolean) || (i >= com.tencent.mm.cd.a.bs(this.Fbb.getContext(), e.c.Edge_2_5_A) + 5)) {
          break label142;
        }
      }
    }
    for (((ConstraintLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cd.a.bs(this.Fbb.getContext(), e.c.Edge_9A);; ((ConstraintLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cd.a.bs(this.Fbb.getContext(), e.c.Edge_2_5_A)) {
      label142:
      do
      {
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(348393);
        return;
      } while ((paramBoolean) || (i <= com.tencent.mm.cd.a.bs(this.Fbb.getContext(), e.c.Edge_9A) - 5));
    }
  }
  
  private final void setProfileTextWidth(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(348404);
    int i = paramInt1 - paramInt2;
    paramInt2 = paramInt1;
    if (((RoundCornerRelativeLayout)this.Fbb.findViewById(e.e.finder_profile_edit_ll)).getVisibility() == 0)
    {
      i = com.tencent.mm.cd.a.bs(this.Fbb.getContext(), e.c.Edge_6A);
      paramInt2 = paramInt1 - com.tencent.mm.cd.a.bs(this.Fbb.getContext(), e.c.Edge_6A);
      i = paramInt1 - i;
    }
    ((TextView)this.Fbb.findViewById(e.e.finder_profile_name_tv)).setMaxWidth(i);
    ((TextView)this.Fbb.findViewById(e.e.finder_profile_name_tv)).setText((CharSequence)paramString1);
    ((TextView)this.Fbb.findViewById(e.e.user_tag_layout)).setMaxWidth(paramInt2);
    ((TextView)this.Fbb.findViewById(e.e.user_tag_layout)).setText((CharSequence)paramString2);
    AppMethodBeat.o(348404);
  }
  
  private final void tg(boolean paramBoolean)
  {
    AppMethodBeat.i(348384);
    if (paramBoolean)
    {
      this.Fbc[0] = ((FrameLayout)this.Fbb.findViewById(e.e.sendMsgBtn)).getVisibility();
      this.Fbc[1] = ((FrameLayout)this.Fbb.findViewById(e.e.finder_profile_follow_btn)).getVisibility();
      if (((FrameLayout)this.Fbb.findViewById(e.e.sendMsgBtn)).getVisibility() == 0) {
        ((FrameLayout)this.Fbb.findViewById(e.e.sendMsgBtn)).setVisibility(4);
      }
      if (((FrameLayout)this.Fbb.findViewById(e.e.finder_profile_follow_btn)).getVisibility() == 0) {
        ((FrameLayout)this.Fbb.findViewById(e.e.finder_profile_follow_btn)).setVisibility(4);
      }
    }
    AppMethodBeat.o(348384);
  }
  
  public final void a(SpannableString paramSpannableString, String paramString)
  {
    AppMethodBeat.i(348441);
    s.u(paramString, "locationText");
    a(paramSpannableString, paramString, true);
    AppMethodBeat.o(348441);
  }
  
  public final void a(SpannableString paramSpannableString, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(348450);
    s.u(paramString, "lltext");
    if ((paramSpannableString == null) || (Util.isNullOrNil(paramSpannableString.toString())))
    {
      AppMethodBeat.o(348450);
      return;
    }
    ah.f localf = new ah.f();
    paramSpannableString = paramSpannableString.toString();
    s.s(paramSpannableString, "spannableStr.toString()");
    localf.aqH = paramSpannableString;
    paramSpannableString = new ah.f();
    paramSpannableString.aqH = paramString;
    tg(paramBoolean);
    if ((String)localf.aqH != null) {
      this.Fbb.post(new a..ExternalSyntheticLambda0(this, localf, paramSpannableString, paramBoolean));
    }
    AppMethodBeat.o(348450);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/adapter/ProfileHeaderHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.adapter.a
 * JD-Core Version:    0.7.0.1
 */