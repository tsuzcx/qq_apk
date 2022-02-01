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
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.f;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.fgq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePrecheckWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "TAG", "", "ageArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "ageCheckFail", "", "ageCheckResult", "Landroid/widget/TextView;", "backImg", "btnClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ok", "", "getBtnClick", "()Lkotlin/jvm/functions/Function1;", "setBtnClick", "(Lkotlin/jvm/functions/Function1;)V", "hasShowLicense", "okBtn", "Landroid/widget/Button;", "onFaceVerifyClick", "Lkotlin/Function2;", "verifyUrl", "", "precheckType", "getOnFaceVerifyClick", "()Lkotlin/jvm/functions/Function2;", "setOnFaceVerifyClick", "(Lkotlin/jvm/functions/Function2;)V", "othersArrow", "othersCheckFail", "othersCheckResult", "othersGroup", "Landroid/view/View;", "othersTips", "othersTipsStr", "getOthersTipsStr", "()Ljava/lang/String;", "setOthersTipsStr", "(Ljava/lang/String;)V", "realnameArrow", "realnameCheckFail", "realnameCheckResult", "getRoot", "()Landroid/view/ViewGroup;", "title", "url", "getUrl", "setUrl", "userFlag", "getUserFlag", "()I", "setUserFlag", "(I)V", "gotoFaceVerify", "hidePrecheckPage", "initLogic", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "setAge", "setOkBtn", "setOthers", "tips", "setRealname", "setTouchDelegate", "view", "showPrecheckPage", "spamRisk", "Lcom/tencent/mm/protocal/protobuf/SpamRisk;", "updatePrecheck", "verifyOk", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
  implements View.OnClickListener
{
  public static final ax.a EsU;
  private WeImageView EoE;
  int EsV;
  String EsW;
  public m<? super String, ? super Integer, ah> EsX;
  public kotlin.g.a.b<? super Boolean, ah> EsY;
  private TextView EsZ;
  private WeImageView Eta;
  private TextView Etb;
  private WeImageView Etc;
  private View Etd;
  private TextView Ete;
  private TextView Etf;
  private WeImageView Etg;
  public boolean Eth;
  public boolean Eti;
  public boolean Etj;
  public boolean Etk;
  private final String TAG;
  final ViewGroup mJe;
  private TextView mll;
  private Button nhC;
  String url;
  
  static
  {
    AppMethodBeat.i(361689);
    EsU = new ax.a((byte)0);
    AppMethodBeat.o(361689);
  }
  
  public ax(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(361468);
    this.mJe = paramViewGroup;
    this.TAG = "FinderLivePrecheckWidget";
    this.url = "";
    this.EsW = "";
    this.Eti = true;
    this.Etj = true;
    this.Etk = true;
    AppMethodBeat.o(361468);
  }
  
  private final void ayC(String paramString)
  {
    AppMethodBeat.i(361525);
    Object localObject;
    if (this.Etk)
    {
      localObject = this.Etd;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.Etf;
      if (localObject != null) {
        ((TextView)localObject).setText(p.h.CqK);
      }
      localObject = this.Etf;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.Red));
      }
      localObject = this.Ete;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramString);
      }
      paramString = this.Etg;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.Etf;
      if (paramString != null)
      {
        paramString.setEnabled(true);
        AppMethodBeat.o(361525);
      }
    }
    else
    {
      localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject = this.Etd;
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = this.Etf;
        if (localObject != null) {
          ((TextView)localObject).setText(p.h.finder_live_post_precheck_result_ok);
        }
        localObject = this.Etf;
        if (localObject != null) {
          ((TextView)localObject).setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.Brand_100));
        }
        localObject = this.Ete;
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)paramString);
        }
        paramString = this.Etg;
        if (paramString != null) {
          paramString.setVisibility(4);
        }
        paramString = this.Etf;
        if (paramString == null) {
          break label271;
        }
        paramString.setEnabled(false);
        AppMethodBeat.o(361525);
        return;
      }
      paramString = this.Etd;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
    }
    label271:
    AppMethodBeat.o(361525);
  }
  
  private final void eBp()
  {
    AppMethodBeat.i(361493);
    Object localObject;
    if (this.Eti)
    {
      localObject = this.EsZ;
      if (localObject != null) {
        ((TextView)localObject).setText(p.h.CqK);
      }
      localObject = this.EsZ;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.Red));
      }
      localObject = this.Eta;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(0);
      }
      localObject = this.EsZ;
      if (localObject != null)
      {
        ((TextView)localObject).setEnabled(true);
        AppMethodBeat.o(361493);
      }
    }
    else
    {
      localObject = this.EsZ;
      if (localObject != null) {
        ((TextView)localObject).setText(p.h.finder_live_post_precheck_result_ok);
      }
      localObject = this.EsZ;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.Brand_100));
      }
      localObject = this.Eta;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(4);
      }
      localObject = this.EsZ;
      if (localObject != null) {
        ((TextView)localObject).setEnabled(false);
      }
    }
    AppMethodBeat.o(361493);
  }
  
  private final void eBq()
  {
    AppMethodBeat.i(361509);
    Object localObject;
    if (this.Etj)
    {
      localObject = this.Etb;
      if (localObject != null) {
        ((TextView)localObject).setText(p.h.CqK);
      }
      localObject = this.Etb;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.Red));
      }
      localObject = this.Etc;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(0);
      }
      localObject = this.Etb;
      if (localObject != null)
      {
        ((TextView)localObject).setEnabled(true);
        AppMethodBeat.o(361509);
      }
    }
    else
    {
      localObject = this.Etb;
      if (localObject != null) {
        ((TextView)localObject).setText(p.h.finder_live_post_precheck_result_ok);
      }
      localObject = this.Etb;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.Brand_100));
      }
      localObject = this.Etc;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(4);
      }
      localObject = this.Etb;
      if (localObject != null) {
        ((TextView)localObject).setEnabled(false);
      }
    }
    AppMethodBeat.o(361509);
  }
  
  private final void eC(String paramString, int paramInt)
  {
    AppMethodBeat.i(361540);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e(this.TAG, "gotoFaceVerify error url is empty!");
      paramString = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramString = this.mJe.getContext();
      s.s(paramString, "root.context");
      com.tencent.mm.plugin.finder.live.utils.a.aD(paramString, "检测地址为空");
      AppMethodBeat.o(361540);
      return;
    }
    localObject = this.EsX;
    if (localObject != null) {
      ((m)localObject).invoke(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(361540);
  }
  
  private static void gr(View paramView)
  {
    AppMethodBeat.i(361476);
    paramView.post(new ax..ExternalSyntheticLambda0(paramView));
    AppMethodBeat.o(361476);
  }
  
  private static final void gs(View paramView)
  {
    AppMethodBeat.i(361550);
    s.u(paramView, "$view");
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_A);
    localRect.inset(-i, -i);
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(361550);
      throw paramView;
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate(localRect, paramView));
    AppMethodBeat.o(361550);
  }
  
  public final void Q(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(361715);
    switch (paramInt)
    {
    }
    for (;;)
    {
      eBr();
      Log.i(this.TAG, "updatePrecheck realnameCheckFail:" + this.Eti + ", ageCheckFail:" + this.Etj + ", othersCheckFail:" + this.Etk);
      AppMethodBeat.o(361715);
      return;
      if (paramBoolean) {
        this.Eti = false;
      }
      eBp();
      continue;
      if (paramBoolean) {
        this.Etj = false;
      }
      eBq();
      continue;
      if (paramBoolean) {
        this.Etk = false;
      }
      ayC(this.EsW);
    }
  }
  
  public final void eBr()
  {
    AppMethodBeat.i(361729);
    Button localButton;
    if (this.Eth)
    {
      localButton = this.nhC;
      if (localButton != null) {
        localButton.setText(p.h.finder_live_post_precheck_ok_btn);
      }
    }
    for (;;)
    {
      boolean bool = true;
      if ((this.Eti) || (this.Etj) || (this.Etk)) {
        bool = false;
      }
      localButton = this.nhC;
      if (localButton != null) {
        localButton.setEnabled(bool);
      }
      AppMethodBeat.o(361729);
      return;
      localButton = this.nhC;
      if (localButton != null) {
        localButton.setText(p.h.finder_live_post_precheck_next_btn);
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(361758);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLivePrecheckWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    int i;
    if (paramView == null)
    {
      localObject1 = null;
      i = p.e.BZy;
      if (localObject1 != null) {
        break label113;
      }
      label56:
      i = p.e.BZx;
      if (localObject1 != null) {
        break label126;
      }
      label64:
      i = 0;
      label66:
      if (i == 0) {
        break label139;
      }
      eC(this.url, 1);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLivePrecheckWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361758);
      return;
      localObject1 = Integer.valueOf(paramView.getId());
      break;
      label113:
      if (((Integer)localObject1).intValue() != i) {
        break label56;
      }
      i = 1;
      break label66;
      label126:
      if (((Integer)localObject1).intValue() != i) {
        break label64;
      }
      i = 1;
      break label66;
      label139:
      i = p.e.BZr;
      if (localObject1 == null)
      {
        label147:
        i = p.e.BZq;
        if (localObject1 != null) {
          break label186;
        }
        label155:
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label199;
        }
        eC(this.url, 2);
        break;
        if (((Integer)localObject1).intValue() != i) {
          break label147;
        }
        i = 1;
        continue;
        label186:
        if (((Integer)localObject1).intValue() != i) {
          break label155;
        }
        i = 1;
      }
      label199:
      i = p.e.BZv;
      if (localObject1 == null)
      {
        label207:
        i = p.e.BZu;
        if (localObject1 != null) {
          break label246;
        }
        label215:
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label259;
        }
        eC(this.url, 3);
        break;
        if (((Integer)localObject1).intValue() != i) {
          break label207;
        }
        i = 1;
        continue;
        label246:
        if (((Integer)localObject1).intValue() != i) {
          break label215;
        }
        i = 1;
      }
      label259:
      i = p.e.BZs;
      if (localObject1 == null) {}
      while (((Integer)localObject1).intValue() != i)
      {
        i = p.e.CbE;
        if ((localObject1 == null) || (((Integer)localObject1).intValue() != i)) {
          break;
        }
        paramView = this.EsY;
        if (paramView == null) {
          break;
        }
        paramView.invoke(Boolean.FALSE);
        break;
      }
      localObject1 = aw.Gjk;
      if (aw.isFastClick())
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLivePrecheckWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(361758);
        return;
      }
      if ((paramView instanceof Button))
      {
        paramView = (Button)paramView;
        label358:
        if (paramView != null) {
          break label420;
        }
        paramView = localObject2;
      }
      for (;;)
      {
        if (Util.isEqual(paramView, MMApplicationContext.getContext().getResources().getString(p.h.finder_live_post_precheck_next_btn)))
        {
          paramView = this.mJe.getContext();
          if (paramView == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(361758);
            throw paramView;
            paramView = null;
            break label358;
            label420:
            paramView = paramView.getText();
            continue;
          }
          paramView = (Activity)paramView;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("KEY_PATH", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy");
          ((Intent)localObject1).putExtra("KEY_TYPE", "TYPE_LICENSE");
          ((f)h.ax(f.class)).b(paramView, (Intent)localObject1, 10123);
          break;
        }
      }
      paramView = this.EsY;
      if (paramView != null) {
        paramView.invoke(Boolean.TRUE);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public b(ax paramax, int paramInt, fgq paramfgq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ax
 * JD-Core Version:    0.7.0.1
 */