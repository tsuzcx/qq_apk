package com.tencent.mm.plugin.finder.profile.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.b.a;
import com.tencent.mm.plugin.finder.utils.v;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.d;
import com.tencent.mm.plugin.finder.view.d.a;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "checkBox$delegate", "Lkotlin/Lazy;", "clickGo", "", "getClickGo", "()Z", "setClickGo", "(Z)V", "fromMusic", "getFromMusic", "setFromMusic", "isSelf", "isSelfFlag", "isSelfFlag$delegate", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "getLoadingComponent", "()Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "setLoadingComponent", "(Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;)V", "profileSettingCallback", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$profileSettingCallback$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$profileSettingCallback$1;", "tipsLayout", "Landroid/view/View;", "getTipsLayout", "()Landroid/view/View;", "tipsLayout$delegate", "tv", "Landroid/widget/TextView;", "getTv", "()Landroid/widget/TextView;", "tv$delegate", "username", "", "getUsername", "()Ljava/lang/String;", "username$delegate", "doSet", "", "isChecked", "initLinkText", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "report21874", "action", "", "report21875", "actionId", "resetLoading", "showEduBottomSheet", "showWxProfileTips", "switchWxProfileSetting", "updateBottomSheetCount", "updateCount", "plugin-finder_release"})
public final class FinderProfileEduUIC
  extends UIComponent
{
  private final f tZk;
  private final f tZl;
  com.tencent.mm.plugin.finder.utils.b tux;
  private final f vaP;
  private final f vaQ;
  private final f vaR;
  private boolean vaS;
  boolean vaT;
  private final j vaU;
  
  public FinderProfileEduUIC(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250197);
    this.vaP = kotlin.g.ah((kotlin.g.a.a)new k(paramAppCompatActivity));
    this.vaQ = kotlin.g.ah((kotlin.g.a.a)new a(paramAppCompatActivity));
    this.vaR = kotlin.g.ah((kotlin.g.a.a)new l(paramAppCompatActivity));
    this.tZl = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.tZk = kotlin.g.ah((kotlin.g.a.a)new m(paramAppCompatActivity));
    this.vaU = new j(this, paramAppCompatActivity);
    AppMethodBeat.o(250197);
  }
  
  private final void Ka(int paramInt)
  {
    JSONObject localJSONObject = null;
    AppMethodBeat.i(250194);
    String str2 = ((c)com.tencent.mm.kernel.g.af(c.class)).cMD();
    String str1 = getActivity().getIntent().getStringExtra("key_context_id");
    if (str1 == null) {
      str1 = "";
    }
    for (;;)
    {
      Object localObject1;
      if (paramInt == 1)
      {
        Object localObject2 = getActivity();
        localObject1 = localObject2;
        if (!(localObject2 instanceof MMFinderUI)) {
          localObject1 = null;
        }
        localObject2 = (MMFinderUI)localObject1;
        localObject1 = localJSONObject;
        if (localObject2 != null) {
          localObject1 = Integer.valueOf(((MMFinderUI)localObject2).getCommentScene());
        }
      }
      for (;;)
      {
        long l = System.currentTimeMillis();
        localJSONObject = new JSONObject();
        try
        {
          if (this.vaS) {
            localJSONObject.put("Source", 1);
          }
          for (;;)
          {
            label127:
            h.CyF.a(21874, new Object[] { str2, str1, localObject1, Integer.valueOf(paramInt), String.valueOf(l), getUsername(), localJSONObject.toString() });
            AppMethodBeat.o(250194);
            return;
            localObject1 = Integer.valueOf(78);
            break;
            localJSONObject.put("Source", 0);
          }
        }
        catch (Throwable localThrowable)
        {
          break label127;
        }
      }
    }
  }
  
  private View dms()
  {
    AppMethodBeat.i(250185);
    View localView = (View)this.vaP.getValue();
    AppMethodBeat.o(250185);
    return localView;
  }
  
  private TextView dmt()
  {
    AppMethodBeat.i(250187);
    TextView localTextView = (TextView)this.vaR.getValue();
    AppMethodBeat.o(250187);
    return localTextView;
  }
  
  private final String getUsername()
  {
    AppMethodBeat.i(250190);
    String str = (String)this.tZk.getValue();
    AppMethodBeat.o(250190);
    return str;
  }
  
  private final boolean isSelf()
  {
    AppMethodBeat.i(250189);
    boolean bool = p.j(getUsername(), z.aUg());
    AppMethodBeat.o(250189);
    return bool;
  }
  
  private final boolean isSelfFlag()
  {
    AppMethodBeat.i(250188);
    boolean bool = ((Boolean)this.tZl.getValue()).booleanValue();
    AppMethodBeat.o(250188);
    return bool;
  }
  
  private final void nQ(boolean paramBoolean)
  {
    AppMethodBeat.i(250193);
    Log.i("SimpleUIComponent", "change isShowAtWxProfile, now:".concat(String.valueOf(paramBoolean)));
    Object localObject = this.tux;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.utils.b)localObject).end();
    }
    localObject = com.tencent.mm.plugin.finder.utils.b.vVa;
    this.tux = b.a.e((Context)getContext(), getContext().getString(2131756029), 500L);
    localObject = this.tux;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.utils.b)localObject).begin();
    }
    ((com.tencent.mm.plugin.i.a.x)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.x.class)).a(paramBoolean, (ai)this.vaU);
    AppMethodBeat.o(250193);
  }
  
  public final void gP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(250195);
    p.h(paramString1, "action");
    p.h(paramString2, "actionId");
    String str = ((c)com.tencent.mm.kernel.g.af(c.class)).cMD();
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
        if ((!p.j(paramString1, "mv")) && (!p.j(paramString1, "mvdelete"))) {
          continue;
        }
        ((JSONObject)localObject2).put("feedid", paramString2);
      }
      catch (Throwable paramString2)
      {
        continue;
      }
      h.CyF.a(21875, new Object[] { str, localObject1, Integer.valueOf(78), Integer.valueOf(1), String.valueOf(l), paramString1, ((JSONObject)localObject2).toString() });
      AppMethodBeat.o(250195);
      return;
      if ((p.j(paramString1, "draft")) || (p.j(paramString1, "draftdelete"))) {
        ((JSONObject)localObject2).put("draftid", paramString2);
      }
    }
  }
  
  public final CheckBox getCheckBox()
  {
    AppMethodBeat.i(250186);
    CheckBox localCheckBox = (CheckBox)this.vaQ.getValue();
    AppMethodBeat.o(250186);
    return localCheckBox;
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(250191);
    super.onCreateAfter(paramBundle);
    boolean bool;
    Object localObject1;
    if (getIntent().getIntExtra("key_from_profile_share_scene", 0) == 19)
    {
      bool = true;
      this.vaS = bool;
      paramBundle = new StringBuilder("showWxProfileTips ").append(isSelf()).append(", ").append(isSelfFlag()).append(", ");
      localObject1 = v.vXn;
      paramBundle = paramBundle.append(v.dCt()).append(", ");
      localObject1 = y.vXH;
      if (y.dCG()) {
        break label936;
      }
      bool = true;
      label103:
      paramBundle = paramBundle.append(bool).append(", ");
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      if (((com.tencent.mm.kernel.e)localObject1).azQ().getInt(ar.a.Omv, 0) != 0) {
        break label941;
      }
      bool = true;
      label145:
      Log.i("SimpleUIComponent", bool);
      if ((!isSelf()) || (!isSelfFlag())) {
        break label946;
      }
      paramBundle = v.vXn;
      if (!v.dCt()) {
        break label946;
      }
      paramBundle = y.vXH;
      if (y.dCG()) {
        break label946;
      }
      paramBundle = com.tencent.mm.kernel.g.aAh();
      p.g(paramBundle, "MMKernel.storage()");
      if (paramBundle.azQ().getInt(ar.a.Omv, 0) != 0) {
        break label946;
      }
      i = 1;
      label220:
      if (i == 0) {
        break label951;
      }
      paramBundle = k.vfA;
      k.b((Context)getActivity(), 13L, 2L);
      paramBundle = dms();
      p.g(paramBundle, "tipsLayout");
      paramBundle.setVisibility(0);
      paramBundle = getCheckBox();
      p.g(paramBundle, "checkBox");
      localObject1 = y.vXH;
      paramBundle.setChecked(y.dCG());
      localObject1 = getContext().getString(2131760485);
      p.g(localObject1, "context.getString(R.stri…r_profile_show_tips_link)");
      paramBundle = getContext().getString(2131760484, new Object[] { localObject1 });
      p.g(paramBundle, "context.getString(R.stri…file_show_tips, linkText)");
      paramBundle = com.tencent.mm.pluginsdk.ui.span.l.c((Context)getActivity(), (CharSequence)paramBundle);
      p.g(paramBundle, "tips");
      i = n.a((CharSequence)paramBundle, (String)localObject1, 0, false, 6);
      if (i >= 0) {
        paramBundle.setSpan(new com.tencent.mm.plugin.finder.view.l((String)localObject1, getContext().getResources().getColor(2131099783), getContext().getResources().getColor(2131099790), (kotlin.g.a.b)new b(this)), i, ((String)localObject1).length() + i, 17);
      }
      localObject1 = dmt();
      p.g(localObject1, "tv");
      ((TextView)localObject1).setText((CharSequence)paramBundle);
      localObject1 = y.vXH;
      localObject1 = dmt();
      p.g(localObject1, "tv");
      y.a((TextView)localObject1, (Spannable)paramBundle);
      dms().setOnClickListener((View.OnClickListener)new g(this));
      getCheckBox().setOnClickListener((View.OnClickListener)new h(this));
      label519:
      Ka(1);
      if ((!isSelf()) || (!isSelfFlag())) {
        break label972;
      }
      paramBundle = v.vXn;
      if (!v.dCt()) {
        break label972;
      }
      paramBundle = y.vXH;
      if (y.dCG()) {
        break label972;
      }
      paramBundle = com.tencent.mm.kernel.g.aAh();
      p.g(paramBundle, "MMKernel.storage()");
      if (paramBundle.azQ().getInt(ar.a.Omw, 0) != 0) {
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
        paramBundle = com.tencent.mm.kernel.g.aAh();
        p.g(paramBundle, "MMKernel.storage()");
        paramBundle.azQ().set(ar.a.Omw, Integer.valueOf(1));
        paramBundle = new d((Context)getActivity());
        paramBundle.Ml(2131494682);
        localObject1 = paramBundle.lJI.findViewById(2131310653);
        p.g(localObject1, "rootView.findViewById<Te…wxprofile_apply_title_tv)");
        com.tencent.mm.plugin.finder.utils.e.n((TextView)localObject1);
        localObject1 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject1).append((CharSequence)getContext().getString(2131760683));
        Object localObject2 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)getContext(), (CharSequence)getContext().getString(2131760684));
        Object localObject3 = ((SpannableString)localObject2).toString();
        p.g(localObject3, "linkSpan.toString()");
        ((SpannableString)localObject2).setSpan(new com.tencent.mm.plugin.finder.view.l((String)localObject3, getContext().getResources().getColor(2131099783), getContext().getResources().getColor(2131099790), (kotlin.g.a.b)new d(this)), 0, ((SpannableString)localObject2).length(), 17);
        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
        localObject2 = (TextView)paramBundle.lJI.findViewById(2131310652);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        localObject3 = y.vXH;
        p.g(localObject2, "descTv");
        y.a((TextView)localObject2, (Spannable)localObject1);
        paramBundle.a((d.a)new e(this));
        paramBundle.lJI.findViewById(2131310651).setOnClickListener((View.OnClickListener)new f(paramBundle, this));
        paramBundle.lJI.findViewById(2131310654).setOnClickListener((View.OnClickListener)new i(paramBundle));
        paramBundle.dGm();
        Ka(2);
      }
      AppMethodBeat.o(250191);
      return;
      bool = false;
      break;
      bool = false;
      break label103;
      bool = false;
      break label145;
      i = 0;
      break label220;
      paramBundle = dms();
      p.g(paramBundle, "tipsLayout");
      paramBundle.setVisibility(8);
      break label519;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(250192);
    super.onResume();
    CheckBox localCheckBox = getCheckBox();
    p.g(localCheckBox, "checkBox");
    y localy = y.vXH;
    localCheckBox.setChecked(y.dCG());
    AppMethodBeat.o(250192);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<CheckBox>
  {
    a(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<String, kotlin.x>
  {
    b(FinderProfileEduUIC paramFinderProfileEduUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    c(FinderProfileEduUIC paramFinderProfileEduUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$3$1"})
  static final class d
    extends q
    implements kotlin.g.a.b<String, kotlin.x>
  {
    d(FinderProfileEduUIC paramFinderProfileEduUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$3$2"})
  static final class e
    implements d.a
  {
    e(FinderProfileEduUIC paramFinderProfileEduUIC) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(250176);
      if (!this.vaV.vaT) {
        FinderProfileEduUIC.a(this.vaV, "cancel");
      }
      AppMethodBeat.o(250176);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$3$3"})
  static final class f
    implements View.OnClickListener
  {
    f(d paramd, FinderProfileEduUIC paramFinderProfileEduUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250177);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderProfileEduUIC.a(jdField_this, "set");
      jdField_this.vaT = true;
      paramView = jdField_this.getCheckBox();
      p.g(paramView, "checkBox");
      paramView.setChecked(true);
      FinderProfileEduUIC.b(jdField_this);
      this.tru.bMo();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$$inlined$apply$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250177);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(FinderProfileEduUIC paramFinderProfileEduUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250178);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.vaV.getCheckBox().toggle();
      FinderProfileEduUIC.a(this.vaV);
      FinderProfileEduUIC.dmu();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250178);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderProfileEduUIC paramFinderProfileEduUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250179);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderProfileEduUIC.a(this.vaV);
      FinderProfileEduUIC.dmu();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250179);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250180);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.tru.bMo();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$onCreateAfter$3$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250180);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$profileSettingCallback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class j
    implements ai<azg>
  {
    j(AppCompatActivity paramAppCompatActivity) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<View>
  {
    k(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<TextView>
  {
    l(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
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
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileEduUIC
 * JD-Core Version:    0.7.0.1
 */