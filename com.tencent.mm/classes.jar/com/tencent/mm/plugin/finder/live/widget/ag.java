package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.k.f;
import com.tencent.mm.plugin.finder.utils.t;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostLicenseWidget;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "licenseContainer", "Landroid/view/ViewGroup;", "forceShow", "", "callback", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;ZLcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "appId", "", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "container", "Landroid/view/View;", "getContainer", "()Landroid/view/View;", "setContainer", "(Landroid/view/View;)V", "getForceShow", "()Z", "isMiniGame", "getLicenseContainer", "()Landroid/view/ViewGroup;", "licenseState", "", "getLicenseState", "()I", "setLicenseState", "(I)V", "licenseTxt", "Landroid/widget/TextView;", "getLicenseTxt", "()Landroid/widget/TextView;", "setLicenseTxt", "(Landroid/widget/TextView;)V", "checkLicenseState", "", "isReady", "refreshGameMode", "saveLicenseState", "setLicenseText", "tv", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
{
  public static final ag.a EqH;
  private static final HashSet<String> EqK;
  public int Dma;
  private final k.f Elx;
  private final ViewGroup EqD;
  private boolean EqF;
  private final boolean EqI;
  private TextView EqJ;
  private final MMActivity activity;
  private String appId;
  public CheckBox checkBox;
  public View hDw;
  
  static
  {
    AppMethodBeat.i(361665);
    EqH = new ag.a((byte)0);
    EqK = new HashSet();
    AppMethodBeat.o(361665);
  }
  
  public ag(MMActivity paramMMActivity, ViewGroup paramViewGroup, boolean paramBoolean, k.f paramf)
  {
    AppMethodBeat.i(361627);
    this.activity = paramMMActivity;
    this.EqD = paramViewGroup;
    this.EqI = paramBoolean;
    this.Elx = paramf;
    paramMMActivity = com.tencent.d.a.a.a.a.a.ahiX;
    this.Dma = com.tencent.d.a.a.a.a.a.jTK();
    this.appId = "";
    this.hDw = ((View)this.EqD);
    this.hDw.setOnClickListener(new ag..ExternalSyntheticLambda0(this));
    paramMMActivity = this.hDw.findViewById(p.e.BZn);
    s.s(paramMMActivity, "container.findViewById(R.id.post_license_checkbox)");
    paramMMActivity = (CheckBox)paramMMActivity;
    s.u(paramMMActivity, "<set-?>");
    this.checkBox = paramMMActivity;
    getCheckBox().setOnCheckedChangeListener(new ag..ExternalSyntheticLambda1(this));
    paramMMActivity = this.hDw.findViewById(p.e.BZp);
    s.s(paramMMActivity, "container.findViewById(R.id.post_license_tv)");
    this.EqJ = ((TextView)paramMMActivity);
    setLicenseText(this.EqJ);
    AppMethodBeat.o(361627);
  }
  
  private static final void a(ag paramag, View paramView)
  {
    int i = 1;
    AppMethodBeat.i(361651);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramag);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostLicenseWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramag, "this$0");
    paramView = paramag.getCheckBox();
    boolean bool;
    if (!paramag.getCheckBox().isChecked())
    {
      bool = true;
      paramView.setChecked(bool);
      if (!paramag.getCheckBox().isChecked()) {
        break label136;
      }
    }
    for (;;)
    {
      paramag.Dma = i;
      paramag.Elx.onChange();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostLicenseWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361651);
      return;
      bool = false;
      break;
      label136:
      i = 0;
    }
  }
  
  private static final void a(ag paramag, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(361661);
    s.u(paramag, "this$0");
    if (paramag.getCheckBox().isChecked()) {}
    for (int i = 1;; i = 0)
    {
      paramag.Dma = i;
      paramag.Elx.onChange();
      AppMethodBeat.o(361661);
      return;
    }
  }
  
  private CheckBox getCheckBox()
  {
    AppMethodBeat.i(361640);
    CheckBox localCheckBox = this.checkBox;
    if (localCheckBox != null)
    {
      AppMethodBeat.o(361640);
      return localCheckBox;
    }
    s.bIx("checkBox");
    AppMethodBeat.o(361640);
    return null;
  }
  
  private final void setLicenseText(TextView paramTextView)
  {
    AppMethodBeat.i(361645);
    Object localObject = t.GgN;
    localObject = t.d((Context)this.activity, p.h.Ckw, this.EqF);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
    AppMethodBeat.o(361645);
  }
  
  public final void bF(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(361702);
    s.u(paramString, "appId");
    this.appId = paramString;
    if (this.EqF != paramBoolean)
    {
      this.EqF = paramBoolean;
      setLicenseText(this.EqJ);
    }
    AppMethodBeat.o(361702);
  }
  
  public final void eAQ()
  {
    AppMethodBeat.i(361683);
    if (this.EqI) {
      this.Dma = 0;
    }
    if (this.Dma == 1)
    {
      this.hDw.setVisibility(0);
      getCheckBox().setChecked(true);
      this.Elx.onChange();
      AppMethodBeat.o(361683);
      return;
    }
    this.hDw.setVisibility(0);
    AppMethodBeat.o(361683);
  }
  
  public final void eAR()
  {
    AppMethodBeat.i(361694);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    com.tencent.d.a.a.a.a.a.aGU(this.Dma);
    if ((this.EqF) && (isReady())) {
      EqK.add(this.appId);
    }
    AppMethodBeat.o(361694);
  }
  
  public final boolean isReady()
  {
    return this.Dma == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ag
 * JD-Core Version:    0.7.0.1
 */