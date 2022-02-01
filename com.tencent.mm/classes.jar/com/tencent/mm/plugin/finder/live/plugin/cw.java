package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.util.g;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "anchorAuthIcon", "Landroid/widget/ImageView;", "anchorExtAuthTv", "Landroid/widget/TextView;", "anchorExtFriendFollowCountTv", "anchorExtInfoLayout", "Landroid/widget/LinearLayout;", "anchorName", "anchorProfile", "avatar", "backBtn", "desc", "loadingProgressBar", "Landroid/widget/ProgressBar;", "needAnimation", "", "getNeedAnimation", "()Z", "setNeedAnimation", "(Z)V", "okBtn", "Landroid/widget/Button;", "rootContent", "Landroid/widget/RelativeLayout;", "title", "fillAnchorInfo", "", "authProfession", "friendFollowCount", "", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "show", "updateBg", "bgUrl", "contactUsername", "updateFinishInfo", "plugin-finder_release"})
public final class cw
  extends d
{
  public final String TAG;
  private final TextView jMg;
  public final RelativeLayout kCI;
  private final com.tencent.mm.live.c.b kCU;
  private final ImageView kCv;
  private final Button kEt;
  private final ImageView mWb;
  private final TextView msF;
  private final TextView yyC;
  private final TextView yyD;
  private final LinearLayout yyE;
  private final TextView yyF;
  private final TextView yyG;
  private final ImageView yyH;
  public final ProgressBar yyI;
  public boolean yyJ;
  
  public cw(final ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(271497);
    this.kCU = paramb;
    this.TAG = "Finder.LiveVisitorAfterPlugin";
    paramb = paramViewGroup.findViewById(b.f.title);
    p.j(paramb, "root.findViewById(R.id.title)");
    this.jMg = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.desc);
    p.j(paramb, "root.findViewById(R.id.desc)");
    this.msF = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.anchor_avatar);
    p.j(paramb, "root.findViewById(R.id.anchor_avatar)");
    this.mWb = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(b.f.anchor_name);
    p.j(paramb, "root.findViewById(R.id.anchor_name)");
    this.yyC = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.visit_anchor_profile);
    p.j(paramb, "root.findViewById(R.id.visit_anchor_profile)");
    this.yyD = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_after_finish_btn);
    p.j(paramb, "root.findViewById(R.id.live_after_finish_btn)");
    this.kEt = ((Button)paramb);
    paramb = paramViewGroup.findViewById(b.f.live_after_ui_root_group);
    p.j(paramb, "root.findViewById(R.id.live_after_ui_root_group)");
    this.kCI = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(b.f.anchor_ext_info_layout);
    p.j(paramb, "root.findViewById(R.id.anchor_ext_info_layout)");
    this.yyE = ((LinearLayout)paramb);
    paramb = paramViewGroup.findViewById(b.f.anchor_ext_info_auth);
    p.j(paramb, "root.findViewById(R.id.anchor_ext_info_auth)");
    this.yyF = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.anchor_ext_info_friend_floow_count);
    p.j(paramb, "root.findViewById(R.id.a…_info_friend_floow_count)");
    this.yyG = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.f.anchor_auth_icon);
    p.j(paramb, "root.findViewById(R.id.anchor_auth_icon)");
    this.yyH = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(b.f.back_icon);
    p.j(paramb, "root.findViewById(R.id.back_icon)");
    this.kCv = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(b.f.loading_bar);
    p.j(paramb, "root.findViewById(R.id.loading_bar)");
    this.yyI = ((ProgressBar)paramb);
    this.yyJ = true;
    this.kEt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(289820);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        cw.a(this.yyK).statusChange(b.c.kyW, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(289820);
      }
    });
    this.yyD.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(225704);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yyK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig;
        localObject = new Intent();
        ((Intent)localObject).putExtra("finder_username", paramAnonymousView);
        ((Intent)localObject).putExtra("key_enter_profile_type", 11);
        ((ak)h.ag(ak.class)).enterFinderProfileUI(paramViewGroup.getContext(), (Intent)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(225704);
      }
    });
    paramb = this.jMg;
    if (paramb != null) {}
    for (paramb = paramb.getLayoutParams(); paramb == null; paramb = null)
    {
      paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(271497);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.topMargin += ax.getStatusBarHeight(MMApplicationContext.getContext());
    paramb = this.kEt;
    if (paramb != null) {}
    for (paramb = paramb.getLayoutParams(); paramb == null; paramb = null)
    {
      paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(271497);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.bottomMargin += ax.aB(MMApplicationContext.getContext());
    ar.a((Paint)this.jMg.getPaint(), 0.8F);
    ar.a((Paint)this.yyC.getPaint(), 0.8F);
    ar.a((Paint)this.kEt.getPaint(), 0.8F);
    this.kCI.setVisibility(8);
    this.yyI.setVisibility(8);
    this.kCv.setImageDrawable(au.o(paramViewGroup.getContext(), b.i.icons_filled_back, -1));
    this.kCv.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(232483);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        cw.a(this.yyK).statusChange(b.c.kyW, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(232483);
      }
    });
    paramViewGroup.setTranslationX(ax.au(paramViewGroup.getContext()).x);
    AppMethodBeat.o(271497);
  }
  
  public final void a(String paramString, int paramInt, FinderAuthInfo paramFinderAuthInfo)
  {
    AppMethodBeat.i(271496);
    if ((Util.isNullOrNil(paramString)) && (paramInt <= 0)) {
      this.yyE.setVisibility(8);
    }
    for (;;)
    {
      if (paramFinderAuthInfo != null)
      {
        paramString = aj.AGc;
        aj.a(this.yyH, paramFinderAuthInfo, 0);
      }
      AppMethodBeat.o(271496);
      return;
      Log.i(this.TAG, "authProfession:" + paramString + ", friendFollowCount:" + paramInt);
      this.yyE.setVisibility(0);
      Object localObject1;
      if (!Util.isNullOrNil(paramString))
      {
        localObject1 = this.kiF.getContext();
        p.j(localObject1, "root.context");
        paramString = ((Context)localObject1).getResources().getString(b.j.finder_contact_auth, new Object[] { paramString });
        p.j(paramString, "root.context.resources.g…act_auth, authProfession)");
        this.yyF.setText((CharSequence)paramString);
        this.yyF.setVisibility(0);
        label162:
        localObject1 = "";
        if (paramInt <= 0) {
          break label424;
        }
        localObject1 = this.kiF.getContext();
        p.j(localObject1, "root.context");
        localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_friend_follow, new Object[] { m.QF(paramInt) });
        p.j(localObject1, "root.context.resources.g…umber(friendFollowCount))");
        this.yyG.setText((CharSequence)localObject1);
        this.yyG.setVisibility(0);
      }
      for (;;)
      {
        Object localObject2 = this.kiF.getContext();
        p.j(localObject2, "root.context");
        localObject2 = ((Context)localObject2).getResources();
        p.j(localObject2, "root.context.resources");
        paramInt = ((Resources)localObject2).getDisplayMetrics().widthPixels;
        localObject2 = this.kiF.getContext();
        p.j(localObject2, "root.context");
        int i = ((Context)localObject2).getResources().getDimensionPixelOffset(b.d.Edge_1_5_A);
        localObject2 = this.yyF.getPaint();
        float f1 = ((TextPaint)localObject2).measureText((String)localObject1);
        float f2 = ((TextPaint)localObject2).measureText(paramString);
        float f3 = i;
        paramString = this.kiF.getContext();
        p.j(paramString, "root.context");
        if (f1 + f2 + f3 + paramString.getResources().getDimensionPixelOffset(b.d.Edge_3A) * 2 >= paramInt) {
          break label436;
        }
        this.yyG.setPadding(i, 0, 0, 0);
        this.yyE.setOrientation(0);
        break;
        this.yyF.setVisibility(8);
        paramString = "";
        break label162;
        label424:
        this.yyG.setVisibility(8);
      }
      label436:
      this.yyG.setPadding(0, 0, 0, 0);
      this.yyE.setOrientation(1);
    }
  }
  
  public final void gZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(271495);
    p.k(paramString1, "bgUrl");
    p.k(paramString2, "contactUsername");
    Object localObject = g.yPJ;
    g.a(paramString2, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGE(), (View)this.kCI);
    localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
    localObject = com.tencent.mm.plugin.finder.loader.t.dJh();
    paramString1 = new com.tencent.mm.plugin.finder.loader.e(paramString1);
    ImageView localImageView = this.mWb;
    com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
    ((com.tencent.mm.loader.d)localObject).a(paramString1, localImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
    paramString1 = aj.AGc;
    localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
    paramString1 = paramString2;
    if (localObject != null)
    {
      localObject = ((FinderObject)localObject).contact;
      paramString1 = paramString2;
      if (localObject != null)
      {
        paramString1 = ((FinderContact)localObject).username;
        if (paramString1 != null) {
          break label346;
        }
        paramString1 = paramString2;
      }
    }
    label310:
    label330:
    label346:
    for (;;)
    {
      paramString2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zeZ;
      if (paramString2 != null)
      {
        paramString2 = paramString2.contact;
        if (paramString2 != null)
        {
          paramString2 = paramString2.nickname;
          paramString1 = aj.ht(paramString1, paramString2);
          this.yyC.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.kiF.getContext(), (CharSequence)paramString1));
          this.kCI.setVisibility(0);
          this.yyI.setVisibility(8);
          paramString2 = this.jMg;
          paramString1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).zhc;
          if (paramString1 == null) {
            break label310;
          }
        }
      }
      for (paramString1 = (CharSequence)paramString1;; paramString1 = (CharSequence)this.kiF.getContext().getString(b.j.live_after_over))
      {
        paramString2.setText(paramString1);
        if (Util.isNullOrNil(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).zhd)) {
          break label330;
        }
        this.msF.setVisibility(0);
        this.msF.setText((CharSequence)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).zhd);
        AppMethodBeat.o(271495);
        return;
        paramString2 = null;
        break;
      }
      this.msF.setVisibility(8);
      AppMethodBeat.o(271495);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cw
 * JD-Core Version:    0.7.0.1
 */