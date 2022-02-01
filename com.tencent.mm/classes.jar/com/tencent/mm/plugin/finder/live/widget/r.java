package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.viewmodel.i.e;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostLicenseWidget;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "licenseContainer", "Landroid/view/ViewGroup;", "forceShow", "", "callback", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;ZLcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "appId", "", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "container", "Landroid/view/View;", "getContainer", "()Landroid/view/View;", "setContainer", "(Landroid/view/View;)V", "getForceShow", "()Z", "isMiniGame", "getLicenseContainer", "()Landroid/view/ViewGroup;", "licenseState", "", "getLicenseState", "()I", "setLicenseState", "(I)V", "licenseTxt", "Landroid/widget/TextView;", "getLicenseTxt", "()Landroid/widget/TextView;", "setLicenseTxt", "(Landroid/widget/TextView;)V", "checkLicenseState", "", "isReady", "refreshGameMode", "saveLicenseState", "setLicenseText", "tv", "Companion", "plugin-finder_release"})
public final class r
{
  private static final HashSet<String> zoe;
  public static final a zof;
  private final MMActivity activity;
  private String appId;
  public CheckBox checkBox;
  public View fyN;
  int yzc;
  final i.e zlm;
  private boolean znY;
  private final ViewGroup znZ;
  private TextView zoc;
  private final boolean zod;
  
  static
  {
    AppMethodBeat.i(287887);
    zof = new a((byte)0);
    zoe = new HashSet();
    AppMethodBeat.o(287887);
  }
  
  public r(MMActivity paramMMActivity, ViewGroup paramViewGroup, boolean paramBoolean, i.e parame)
  {
    AppMethodBeat.i(287886);
    this.activity = paramMMActivity;
    this.znZ = paramViewGroup;
    this.zod = paramBoolean;
    this.zlm = parame;
    paramMMActivity = com.tencent.c.a.a.a.a.a.Zlt;
    this.yzc = com.tencent.c.a.a.a.a.a.ind();
    this.appId = "";
    this.fyN = ((View)this.znZ);
    this.fyN.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        int i = 1;
        AppMethodBeat.i(287373);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostLicenseWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.zog.getCheckBox();
        boolean bool;
        if (!this.zog.getCheckBox().isChecked())
        {
          bool = true;
          paramAnonymousView.setChecked(bool);
          paramAnonymousView = this.zog;
          if (!this.zog.getCheckBox().isChecked()) {
            break label125;
          }
        }
        for (;;)
        {
          paramAnonymousView.yzc = i;
          this.zog.zlm.onChange();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostLicenseWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(287373);
          return;
          bool = false;
          break;
          label125:
          i = 0;
        }
      }
    });
    paramMMActivity = this.fyN.findViewById(b.f.post_license_checkbox);
    kotlin.g.b.p.j(paramMMActivity, "container.findViewById(R.id.post_license_checkbox)");
    this.checkBox = ((CheckBox)paramMMActivity);
    paramMMActivity = this.checkBox;
    if (paramMMActivity == null) {
      kotlin.g.b.p.bGy("checkBox");
    }
    paramMMActivity.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(285550);
        paramAnonymousCompoundButton = this.zog;
        if (this.zog.getCheckBox().isChecked()) {}
        for (int i = 1;; i = 0)
        {
          paramAnonymousCompoundButton.yzc = i;
          this.zog.zlm.onChange();
          AppMethodBeat.o(285550);
          return;
        }
      }
    });
    paramMMActivity = this.fyN.findViewById(b.f.post_license_tv);
    kotlin.g.b.p.j(paramMMActivity, "container.findViewById(R.id.post_license_tv)");
    this.zoc = ((TextView)paramMMActivity);
    s(this.zoc);
    AppMethodBeat.o(287886);
  }
  
  private final void s(TextView paramTextView)
  {
    AppMethodBeat.i(287882);
    Object localObject = com.tencent.mm.plugin.finder.utils.p.ADF;
    localObject = com.tencent.mm.plugin.finder.utils.p.d((Context)this.activity, b.j.finder_live_game_agree_with_format, this.znY);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
    AppMethodBeat.o(287882);
  }
  
  public final void bp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(287885);
    kotlin.g.b.p.k(paramString, "appId");
    this.appId = paramString;
    if (this.znY != paramBoolean)
    {
      this.znY = paramBoolean;
      s(this.zoc);
    }
    if (paramBoolean) {
      if (!zoe.contains(paramString)) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      this.yzc = i;
      AppMethodBeat.o(287885);
      return;
    }
  }
  
  public final void dIl()
  {
    AppMethodBeat.i(287883);
    if (this.zod) {
      this.yzc = 0;
    }
    if (this.yzc == 1)
    {
      this.fyN.setVisibility(8);
      this.zlm.onChange();
      AppMethodBeat.o(287883);
      return;
    }
    this.fyN.setVisibility(0);
    AppMethodBeat.o(287883);
  }
  
  public final void dIm()
  {
    AppMethodBeat.i(287884);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    com.tencent.c.a.a.a.a.a.aAi(this.yzc);
    if ((this.znY) && (isReady())) {
      zoe.add(this.appId);
    }
    AppMethodBeat.o(287884);
  }
  
  public final CheckBox getCheckBox()
  {
    AppMethodBeat.i(287881);
    CheckBox localCheckBox = this.checkBox;
    if (localCheckBox == null) {
      kotlin.g.b.p.bGy("checkBox");
    }
    AppMethodBeat.o(287881);
    return localCheckBox;
  }
  
  public final boolean isReady()
  {
    return this.yzc == 1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostLicenseWidget$Companion;", "", "()V", "checkedMiniGameIdSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.r
 * JD-Core Version:    0.7.0.1
 */