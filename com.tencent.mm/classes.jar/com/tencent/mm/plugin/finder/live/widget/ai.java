package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.elx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePrecheckWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "TAG", "", "ageArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "ageCheckFail", "", "ageCheckResult", "Landroid/widget/TextView;", "backImg", "btnClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ok", "", "getBtnClick", "()Lkotlin/jvm/functions/Function1;", "setBtnClick", "(Lkotlin/jvm/functions/Function1;)V", "hasShowLicense", "okBtn", "Landroid/widget/Button;", "onFaceVerifyClick", "Lkotlin/Function2;", "verifyUrl", "", "precheckType", "getOnFaceVerifyClick", "()Lkotlin/jvm/functions/Function2;", "setOnFaceVerifyClick", "(Lkotlin/jvm/functions/Function2;)V", "othersArrow", "othersCheckFail", "othersCheckResult", "othersGroup", "Landroid/view/View;", "othersTips", "othersTipsStr", "getOthersTipsStr", "()Ljava/lang/String;", "setOthersTipsStr", "(Ljava/lang/String;)V", "realnameArrow", "realnameCheckFail", "realnameCheckResult", "getRoot", "()Landroid/view/ViewGroup;", "title", "url", "getUrl", "setUrl", "userFlag", "getUserFlag", "()I", "setUserFlag", "(I)V", "gotoFaceVerify", "hidePrecheckPage", "initLogic", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "setAge", "setOkBtn", "setOthers", "tips", "setRealname", "setTouchDelegate", "view", "showPrecheckPage", "spamRisk", "Lcom/tencent/mm/protocal/protobuf/SpamRisk;", "updatePrecheck", "verifyOk", "Companion", "plugin-finder_release"})
public final class ai
  implements View.OnClickListener
{
  public static final a zqJ;
  private final String TAG;
  private TextView jMg;
  private Button kEt;
  final ViewGroup kiF;
  String url;
  private WeImageView znA;
  private WeImageView zqA;
  private View zqB;
  private TextView zqC;
  private TextView zqD;
  private WeImageView zqE;
  public boolean zqF;
  public boolean zqG;
  public boolean zqH;
  public boolean zqI;
  int zqt;
  String zqu;
  public m<? super String, ? super Integer, x> zqv;
  public kotlin.g.a.b<? super Boolean, x> zqw;
  private TextView zqx;
  private WeImageView zqy;
  private TextView zqz;
  
  static
  {
    AppMethodBeat.i(270152);
    zqJ = new a((byte)0);
    AppMethodBeat.o(270152);
  }
  
  public ai(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(270151);
    this.kiF = paramViewGroup;
    this.TAG = "FinderLivePrecheckWidget";
    this.url = "";
    this.zqu = "";
    this.zqG = true;
    this.zqH = true;
    this.zqI = true;
    AppMethodBeat.o(270151);
  }
  
  private final void aDi(String paramString)
  {
    AppMethodBeat.i(270147);
    Context localContext;
    if (this.zqI)
    {
      localObject = this.zqB;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.zqD;
      if (localObject != null) {
        ((TextView)localObject).setText(b.j.finder_live_post_precheck_result_fail);
      }
      localObject = this.zqD;
      if (localObject != null)
      {
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        ((TextView)localObject).setTextColor(localContext.getResources().getColor(b.c.Red));
      }
      localObject = this.zqC;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramString);
      }
      paramString = this.zqE;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.zqD;
      if (paramString != null)
      {
        paramString.setEnabled(true);
        AppMethodBeat.o(270147);
        return;
      }
      AppMethodBeat.o(270147);
      return;
    }
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {
      i = 1;
    }
    while (i == 0)
    {
      localObject = this.zqB;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.zqD;
      if (localObject != null) {
        ((TextView)localObject).setText(b.j.finder_live_post_precheck_result_ok);
      }
      localObject = this.zqD;
      if (localObject != null)
      {
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        ((TextView)localObject).setTextColor(localContext.getResources().getColor(b.c.Brand_100));
      }
      localObject = this.zqC;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramString);
      }
      paramString = this.zqE;
      if (paramString != null) {
        paramString.setVisibility(4);
      }
      paramString = this.zqD;
      if (paramString != null)
      {
        paramString.setEnabled(false);
        AppMethodBeat.o(270147);
        return;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(270147);
        return;
      }
    }
    paramString = this.zqB;
    if (paramString != null)
    {
      paramString.setVisibility(8);
      AppMethodBeat.o(270147);
      return;
    }
    AppMethodBeat.o(270147);
  }
  
  private final void dIB()
  {
    AppMethodBeat.i(270144);
    Context localContext;
    if (this.zqG)
    {
      localObject = this.zqx;
      if (localObject != null) {
        ((TextView)localObject).setText(b.j.finder_live_post_precheck_result_fail);
      }
      localObject = this.zqx;
      if (localObject != null)
      {
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        ((TextView)localObject).setTextColor(localContext.getResources().getColor(b.c.Red));
      }
      localObject = this.zqy;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(0);
      }
      localObject = this.zqx;
      if (localObject != null)
      {
        ((TextView)localObject).setEnabled(true);
        AppMethodBeat.o(270144);
        return;
      }
      AppMethodBeat.o(270144);
      return;
    }
    Object localObject = this.zqx;
    if (localObject != null) {
      ((TextView)localObject).setText(b.j.finder_live_post_precheck_result_ok);
    }
    localObject = this.zqx;
    if (localObject != null)
    {
      localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      ((TextView)localObject).setTextColor(localContext.getResources().getColor(b.c.Brand_100));
    }
    localObject = this.zqy;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(4);
    }
    localObject = this.zqx;
    if (localObject != null)
    {
      ((TextView)localObject).setEnabled(false);
      AppMethodBeat.o(270144);
      return;
    }
    AppMethodBeat.o(270144);
  }
  
  private final void dIC()
  {
    AppMethodBeat.i(270145);
    Context localContext;
    if (this.zqH)
    {
      localObject = this.zqz;
      if (localObject != null) {
        ((TextView)localObject).setText(b.j.finder_live_post_precheck_result_fail);
      }
      localObject = this.zqz;
      if (localObject != null)
      {
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        ((TextView)localObject).setTextColor(localContext.getResources().getColor(b.c.Red));
      }
      localObject = this.zqA;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(0);
      }
      localObject = this.zqz;
      if (localObject != null)
      {
        ((TextView)localObject).setEnabled(true);
        AppMethodBeat.o(270145);
        return;
      }
      AppMethodBeat.o(270145);
      return;
    }
    Object localObject = this.zqz;
    if (localObject != null) {
      ((TextView)localObject).setText(b.j.finder_live_post_precheck_result_ok);
    }
    localObject = this.zqz;
    if (localObject != null)
    {
      localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      ((TextView)localObject).setTextColor(localContext.getResources().getColor(b.c.Brand_100));
    }
    localObject = this.zqA;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(4);
    }
    localObject = this.zqz;
    if (localObject != null)
    {
      ((TextView)localObject).setEnabled(false);
      AppMethodBeat.o(270145);
      return;
    }
    AppMethodBeat.o(270145);
  }
  
  private final void dS(String paramString, int paramInt)
  {
    AppMethodBeat.i(270150);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e(this.TAG, "gotoFaceVerify error url is empty!");
      paramString = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      paramString = this.kiF.getContext();
      p.j(paramString, "root.context");
      com.tencent.mm.plugin.finder.live.utils.a.aC(paramString, "检测地址为空");
      AppMethodBeat.o(270150);
      return;
    }
    localObject = this.zqv;
    if (localObject != null)
    {
      ((m)localObject).invoke(paramString, Integer.valueOf(paramInt));
      AppMethodBeat.o(270150);
      return;
    }
    AppMethodBeat.o(270150);
  }
  
  private static void eE(View paramView)
  {
    AppMethodBeat.i(270143);
    paramView.post((Runnable)new b(paramView));
    AppMethodBeat.o(270143);
  }
  
  public final void Q(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(270142);
    switch (paramInt)
    {
    }
    for (;;)
    {
      dID();
      Log.i(this.TAG, "updatePrecheck realnameCheckFail:" + this.zqG + ", ageCheckFail:" + this.zqH + ", othersCheckFail:" + this.zqI);
      AppMethodBeat.o(270142);
      return;
      if (paramBoolean) {
        this.zqG = false;
      }
      dIB();
      continue;
      if (paramBoolean) {
        this.zqH = false;
      }
      dIC();
      continue;
      if (paramBoolean) {
        this.zqI = false;
      }
      aDi(this.zqu);
    }
  }
  
  public final void dID()
  {
    AppMethodBeat.i(270148);
    Button localButton;
    if (this.zqF)
    {
      localButton = this.kEt;
      if (localButton != null) {
        localButton.setText(b.j.finder_live_post_precheck_ok_btn);
      }
    }
    for (;;)
    {
      boolean bool = true;
      if ((this.zqG) || (this.zqH) || (this.zqI)) {
        bool = false;
      }
      localButton = this.kEt;
      if (localButton == null) {
        break;
      }
      localButton.setEnabled(bool);
      AppMethodBeat.o(270148);
      return;
      localButton = this.kEt;
      if (localButton != null) {
        localButton.setText(b.j.finder_live_post_precheck_next_btn);
      }
    }
    AppMethodBeat.o(270148);
  }
  
  public final void onClick(View paramView)
  {
    com.tencent.mm.plugin.finder.utils.a locala = null;
    AppMethodBeat.i(270149);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLivePrecheckWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i;
    if (paramView != null)
    {
      localObject = Integer.valueOf(paramView.getId());
      i = b.f.precheck_realname_result;
      if (localObject != null) {
        break label146;
      }
      label62:
      i = b.f.precheck_realname_arrow;
      if (localObject != null) {
        break label166;
      }
      i = b.f.precheck_age_result;
      if (localObject != null) {
        break label177;
      }
      label78:
      i = b.f.precheck_age_arrow;
      if (localObject != null) {
        break label197;
      }
      i = b.f.precheck_others_result;
      if (localObject != null) {
        break label208;
      }
      label94:
      i = b.f.precheck_others_arrow;
      if (localObject != null) {
        break label228;
      }
      i = b.f.precheck_ok_btn;
      if (localObject != null) {
        break label239;
      }
    }
    label118:
    while (((Integer)localObject).intValue() != i)
    {
      i = b.f.top_back;
      if (localObject != null) {
        break label438;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLivePrecheckWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(270149);
      return;
      localObject = null;
      break;
      if (((Integer)localObject).intValue() != i) {
        break label62;
      }
      for (;;)
      {
        dS(this.url, 1);
        break label118;
        if (((Integer)localObject).intValue() != i) {
          break;
        }
      }
      if (((Integer)localObject).intValue() != i) {
        break label78;
      }
      for (;;)
      {
        dS(this.url, 2);
        break label118;
        if (((Integer)localObject).intValue() != i) {
          break;
        }
      }
      if (((Integer)localObject).intValue() != i) {
        break label94;
      }
      for (;;)
      {
        dS(this.url, 3);
        break label118;
        if (((Integer)localObject).intValue() != i) {
          break;
        }
      }
    }
    label146:
    label166:
    label177:
    label197:
    label208:
    label228:
    label239:
    localObject = aj.AGc;
    if (aj.isFastClick())
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLivePrecheckWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(270149);
      return;
    }
    if (!(paramView instanceof Button)) {
      paramView = null;
    }
    for (;;)
    {
      localObject = (Button)paramView;
      paramView = locala;
      if (localObject != null) {
        paramView = ((Button)localObject).getText();
      }
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      if (Util.isEqual(paramView, ((Context)localObject).getResources().getString(b.j.finder_live_post_precheck_next_btn)))
      {
        paramView = this.kiF.getContext();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(270149);
          throw paramView;
        }
        paramView = (Activity)paramView;
        localObject = new Intent();
        ((Intent)localObject).putExtra("KEY_PATH", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy");
        ((Intent)localObject).putExtra("KEY_TYPE", "TYPE_LICENSE");
        locala = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.d(paramView, (Intent)localObject, 10123);
        break;
      }
      paramView = this.zqw;
      if (paramView == null) {
        break;
      }
      paramView.invoke(Boolean.TRUE);
      break;
      label438:
      if (((Integer)localObject).intValue() != i) {
        break;
      }
      paramView = this.zqw;
      if (paramView == null) {
        break;
      }
      paramView.invoke(Boolean.FALSE);
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePrecheckWidget$Companion;", "", "()V", "PRECHECK_AGE", "", "PRECHECK_OTHERS", "PRECHECK_REALNAME", "REQUEST_LICENSE_CODE", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(286845);
      Object localObject1 = new Rect();
      this.kqJ.getHitRect((Rect)localObject1);
      Object localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      int i = ((Context)localObject2).getResources().getDimensionPixelOffset(b.d.Edge_A);
      ((Rect)localObject1).inset(-i, -i);
      localObject2 = this.kqJ.getParent();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(286845);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, this.kqJ));
      AppMethodBeat.o(286845);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    public c(ai paramai, int paramInt, elx paramelx)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ai
 * JD-Core Version:    0.7.0.1
 */