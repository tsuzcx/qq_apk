package com.tencent.mm.plugin.finder.profile.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.service.m;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.af;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.view.e.b;
import com.tencent.mm.plugin.finder.view.o;
import com.tencent.mm.plugin.findersdk.b.b.a;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "checkBox$delegate", "Lkotlin/Lazy;", "clickGo", "", "getClickGo", "()Z", "setClickGo", "(Z)V", "fromMusic", "getFromMusic", "setFromMusic", "isSelf", "isSelfFlag", "isSelfFlag$delegate", "loadingComponent", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "getLoadingComponent", "()Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "setLoadingComponent", "(Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;)V", "profileSettingCallback", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$profileSettingCallback$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$profileSettingCallback$1;", "tipsLayout", "Landroid/view/View;", "getTipsLayout", "()Landroid/view/View;", "tipsLayout$delegate", "tv", "Landroid/widget/TextView;", "getTv", "()Landroid/widget/TextView;", "tv$delegate", "username", "", "getUsername", "()Ljava/lang/String;", "username$delegate", "doSet", "", "isChecked", "initLinkText", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "report21874", "action", "", "report21875", "eid", "actionId", "resetLoading", "showEduBottomSheet", "showWxProfileTips", "switchWxProfileSetting", "updateBottomSheetCount", "updateCount", "plugin-finder_release"})
public final class f
  extends UIComponent
{
  private final kotlin.f xLz;
  private final kotlin.f xSE;
  private final kotlin.f xjx;
  com.tencent.mm.plugin.findersdk.b.b ywG;
  private final kotlin.f zQX;
  private final kotlin.f zQY;
  private boolean zQZ;
  boolean zRa;
  private final j zRb;
  
  public f(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(246070);
    this.zQX = kotlin.g.ar((kotlin.g.a.a)new k(paramAppCompatActivity));
    this.xSE = kotlin.g.ar((kotlin.g.a.a)new a(paramAppCompatActivity));
    this.zQY = kotlin.g.ar((kotlin.g.a.a)new l(paramAppCompatActivity));
    this.xjx = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.xLz = kotlin.g.ar((kotlin.g.a.a)new m(paramAppCompatActivity));
    this.zRb = new j(this, paramAppCompatActivity);
    AppMethodBeat.o(246070);
  }
  
  private final void Pb(int paramInt)
  {
    com.tencent.mm.plugin.report.service.h localh = null;
    AppMethodBeat.i(246066);
    String str2 = ((c)com.tencent.mm.kernel.h.ae(c.class)).dbr();
    String str1 = getActivity().getIntent().getStringExtra("key_context_id");
    if (str1 == null) {
      str1 = "";
    }
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      if (paramInt == 1)
      {
        localObject2 = getActivity();
        localObject1 = localObject2;
        if (!(localObject2 instanceof MMFinderUI)) {
          localObject1 = null;
        }
        localObject2 = (MMFinderUI)localObject1;
        localObject1 = localh;
        if (localObject2 != null) {
          localObject1 = Integer.valueOf(((MMFinderUI)localObject2).getCommentScene());
        }
      }
      for (;;)
      {
        int i = getActivity().getIntent().getIntExtra("KEY_REF_COMMENTSCENE", 0);
        long l = System.currentTimeMillis();
        Object localObject3 = new JSONObject();
        try
        {
          if (this.zQZ) {
            ((JSONObject)localObject3).put("Source", 1);
          }
          for (;;)
          {
            label141:
            localh = com.tencent.mm.plugin.report.service.h.IzE;
            localObject2 = getUsername();
            localObject3 = ((JSONObject)localObject3).toString();
            com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
            localh.a(21874, new Object[] { str2, str1, localObject1, Integer.valueOf(paramInt), String.valueOf(l), localObject2, localObject3, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b(getActivity()).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).wmz, Integer.valueOf(i), Integer.valueOf(0) });
            AppMethodBeat.o(246066);
            return;
            localObject1 = Integer.valueOf(78);
            break;
            ((JSONObject)localObject3).put("Source", 0);
          }
        }
        catch (Throwable localThrowable)
        {
          break label141;
        }
      }
    }
  }
  
  private View dNu()
  {
    AppMethodBeat.i(246056);
    View localView = (View)this.zQX.getValue();
    AppMethodBeat.o(246056);
    return localView;
  }
  
  private TextView dNv()
  {
    AppMethodBeat.i(246058);
    TextView localTextView = (TextView)this.zQY.getValue();
    AppMethodBeat.o(246058);
    return localTextView;
  }
  
  private final String getUsername()
  {
    AppMethodBeat.i(246062);
    String str = (String)this.xLz.getValue();
    AppMethodBeat.o(246062);
    return str;
  }
  
  private final boolean isSelf()
  {
    AppMethodBeat.i(246061);
    boolean bool = p.h(getUsername(), z.bdh());
    AppMethodBeat.o(246061);
    return bool;
  }
  
  private final boolean isSelfFlag()
  {
    AppMethodBeat.i(246059);
    boolean bool = ((Boolean)this.xjx.getValue()).booleanValue();
    AppMethodBeat.o(246059);
    return bool;
  }
  
  private final void qa(boolean paramBoolean)
  {
    AppMethodBeat.i(246065);
    Log.i("SimpleUIComponent", "change isShowAtWxProfile, now:".concat(String.valueOf(paramBoolean)));
    Object localObject = this.ywG;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.b.b)localObject).end();
    }
    localObject = com.tencent.mm.plugin.findersdk.b.b.Bvw;
    this.ywG = b.a.d((Context)getContext(), getContext().getString(b.j.app_waiting), 500L);
    localObject = this.ywG;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.b.b)localObject).begin();
    }
    ((m)com.tencent.mm.kernel.h.ae(m.class)).a(paramBoolean, (com.tencent.mm.plugin.findersdk.a.aj)this.zRb);
    AppMethodBeat.o(246065);
  }
  
  public final void M(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(246068);
    p.k(paramString1, "eid");
    p.k(paramString2, "actionId");
    String str = ((c)com.tencent.mm.kernel.h.ae(c.class)).dbr();
    Object localObject2 = getActivity().getIntent().getStringExtra("key_context_id");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    long l = System.currentTimeMillis();
    localObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        if ((!p.h(paramString1, "mv")) && (!p.h(paramString1, "mvdelete"))) {
          continue;
        }
        ((JSONObject)localObject2).put("feedid", paramString2);
      }
      catch (Throwable paramString2)
      {
        continue;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(21875, new Object[] { str, localObject1, Integer.valueOf(78), Integer.valueOf(paramInt), String.valueOf(l), paramString1, ((JSONObject)localObject2).toString() });
      AppMethodBeat.o(246068);
      return;
      if ((p.h(paramString1, "draft")) || (p.h(paramString1, "draftdelete"))) {
        ((JSONObject)localObject2).put("draftid", paramString2);
      }
    }
  }
  
  public final CheckBox getCheckBox()
  {
    AppMethodBeat.i(246057);
    CheckBox localCheckBox = (CheckBox)this.xSE.getValue();
    AppMethodBeat.o(246057);
    return localCheckBox;
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(246063);
    super.onCreateAfter(paramBundle);
    boolean bool;
    Object localObject1;
    if (getIntent().getIntExtra("key_from_profile_share_scene", 0) == 19)
    {
      bool = true;
      this.zQZ = bool;
      paramBundle = new StringBuilder("showWxProfileTips ").append(isSelf()).append(", ").append(isSelfFlag()).append(", ");
      localObject1 = af.AFF;
      paramBundle = paramBundle.append(af.edP()).append(", ");
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.eed()) {
        break label936;
      }
      bool = true;
      label103:
      paramBundle = paramBundle.append(bool).append(", ");
      localObject1 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      if (((com.tencent.mm.kernel.f)localObject1).aHp().getInt(ar.a.VBs, 0) != 0) {
        break label941;
      }
      bool = true;
      label145:
      Log.i("SimpleUIComponent", bool);
      if ((!isSelf()) || (!isSelfFlag())) {
        break label946;
      }
      paramBundle = af.AFF;
      if (!af.edP()) {
        break label946;
      }
      paramBundle = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.eed()) {
        break label946;
      }
      paramBundle = com.tencent.mm.kernel.h.aHG();
      p.j(paramBundle, "MMKernel.storage()");
      if (paramBundle.aHp().getInt(ar.a.VBs, 0) != 0) {
        break label946;
      }
      i = 1;
      label220:
      if (i == 0) {
        break label951;
      }
      paramBundle = com.tencent.mm.plugin.finder.report.n.zWF;
      com.tencent.mm.plugin.finder.report.n.b((Context)getActivity(), 13L, 2L);
      paramBundle = dNu();
      p.j(paramBundle, "tipsLayout");
      paramBundle.setVisibility(0);
      paramBundle = getCheckBox();
      p.j(paramBundle, "checkBox");
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      paramBundle.setChecked(com.tencent.mm.plugin.finder.utils.aj.eed());
      localObject1 = getContext().getString(b.j.finder_profile_show_tips_link);
      p.j(localObject1, "context.getString(R.stri…r_profile_show_tips_link)");
      paramBundle = getContext().getString(b.j.finder_profile_show_tips, new Object[] { localObject1 });
      p.j(paramBundle, "context.getString(R.stri…file_show_tips, linkText)");
      paramBundle = com.tencent.mm.pluginsdk.ui.span.l.c((Context)getActivity(), (CharSequence)paramBundle);
      p.j(paramBundle, "tips");
      i = kotlin.n.n.a((CharSequence)paramBundle, (String)localObject1, 0, false, 6);
      if (i >= 0) {
        paramBundle.setSpan(new o((String)localObject1, getContext().getResources().getColor(b.c.Link), getContext().getResources().getColor(b.c.Link_Alpha_0_6), (kotlin.g.a.b)new b(this)), i, ((String)localObject1).length() + i, 17);
      }
      localObject1 = dNv();
      p.j(localObject1, "tv");
      ((TextView)localObject1).setText((CharSequence)paramBundle);
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject1 = dNv();
      p.j(localObject1, "tv");
      com.tencent.mm.plugin.finder.utils.aj.a((TextView)localObject1, (Spannable)paramBundle);
      dNu().setOnClickListener((View.OnClickListener)new g(this));
      getCheckBox().setOnClickListener((View.OnClickListener)new h(this));
      label519:
      Pb(1);
      if ((!isSelf()) || (!isSelfFlag())) {
        break label972;
      }
      paramBundle = af.AFF;
      if (!af.edP()) {
        break label972;
      }
      paramBundle = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.eed()) {
        break label972;
      }
      paramBundle = com.tencent.mm.kernel.h.aHG();
      p.j(paramBundle, "MMKernel.storage()");
      if (paramBundle.aHp().getInt(ar.a.VBt, 0) != 0) {
        break label972;
      }
    }
    label936:
    label941:
    label946:
    label951:
    label972:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramBundle = com.tencent.mm.kernel.h.aHG();
        p.j(paramBundle, "MMKernel.storage()");
        paramBundle.aHp().set(ar.a.VBt, Integer.valueOf(1));
        paramBundle = new e((Context)getActivity());
        paramBundle.RB(b.g.finder_wxprofile_edu_bottom_sheet);
        localObject1 = paramBundle.oFW.findViewById(b.f.wxprofile_apply_title_tv);
        p.j(localObject1, "rootView.findViewById<Te…wxprofile_apply_title_tv)");
        com.tencent.mm.plugin.finder.utils.f.i((TextView)localObject1);
        localObject1 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject1).append((CharSequence)getContext().getString(b.j.finder_wxprofile_apply_desc));
        Object localObject2 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)getContext().getString(b.j.finder_wxprofile_apply_desc_click));
        Object localObject3 = ((SpannableString)localObject2).toString();
        p.j(localObject3, "linkSpan.toString()");
        ((SpannableString)localObject2).setSpan(new o((String)localObject3, getContext().getResources().getColor(b.c.Link), getContext().getResources().getColor(b.c.Link_Alpha_0_6), (kotlin.g.a.b)new d(this)), 0, ((SpannableString)localObject2).length(), 17);
        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
        localObject2 = (TextView)paramBundle.oFW.findViewById(b.f.wxprofile_apply_desc_tv);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        p.j(localObject2, "descTv");
        com.tencent.mm.plugin.finder.utils.aj.a((TextView)localObject2, (Spannable)localObject1);
        paramBundle.a((e.b)new e(this));
        paramBundle.oFW.findViewById(b.f.wxprofile_apply_btn).setOnClickListener((View.OnClickListener)new f(paramBundle, this));
        paramBundle.oFW.findViewById(b.f.wxprofile_no_apply_btn).setOnClickListener((View.OnClickListener)new i(paramBundle));
        paramBundle.eik();
        Pb(2);
      }
      AppMethodBeat.o(246063);
      return;
      bool = false;
      break;
      bool = false;
      break label103;
      bool = false;
      break label145;
      i = 0;
      break label220;
      paramBundle = dNu();
      p.j(paramBundle, "tipsLayout");
      paramBundle.setVisibility(8);
      break label519;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(246064);
    super.onResume();
    CheckBox localCheckBox = getCheckBox();
    p.j(localCheckBox, "checkBox");
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localCheckBox.setChecked(com.tencent.mm.plugin.finder.utils.aj.eed());
    AppMethodBeat.o(246064);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<CheckBox>
  {
    a(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<String, x>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$3$1"})
  static final class d
    extends q
    implements kotlin.g.a.b<String, x>
  {
    d(f paramf)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$3$2"})
  static final class e
    implements e.b
  {
    e(f paramf) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(265405);
      if (!this.zRc.zRa) {
        f.a(this.zRc, "cancel", 0, null, 6);
      }
      AppMethodBeat.o(265405);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$3$3"})
  static final class f
    implements View.OnClickListener
  {
    f(e parame, f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(271949);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      f.a(jdField_this, "set", 0, null, 6);
      jdField_this.zRa = true;
      paramView = jdField_this.getCheckBox();
      p.j(paramView, "checkBox");
      paramView.setChecked(true);
      f.b(jdField_this);
      this.wZH.bYF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(271949);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(286066);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.zRc.getCheckBox().toggle();
      f.a(this.zRc);
      f.dNw();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286066);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(269933);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      f.a(this.zRc);
      f.dNw();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269933);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282241);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.wZH.bYF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282241);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$profileSettingCallback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.plugin.findersdk.a.aj<bfc>
  {
    j(AppCompatActivity paramAppCompatActivity) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<View>
  {
    k(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<TextView>
  {
    l(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<String>
  {
    m(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.f
 * JD-Core Version:    0.7.0.1
 */