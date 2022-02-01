package com.tencent.mm.plugin.finder.webview.ad;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.i;
import com.tencent.mm.plugin.finder.utils.at;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.a.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/ad/FinderScrollDialog;", "Lcom/tencent/mm/ui/widget/dialog/MMDialog;", "context", "Landroid/content/Context;", "style", "", "(Landroid/content/Context;I)V", "bottomMargin", "getBottomMargin", "()I", "setBottomMargin", "(I)V", "dialogHeight", "getDialogHeight", "setDialogHeight", "dialogTopMargin", "dialogWidth", "getDialogWidth", "setDialogWidth", "gravity", "getGravity", "setGravity", "leftMargin", "getLeftMargin", "setLeftMargin", "mContentView", "Lcom/tencent/mm/plugin/finder/webview/ad/ScrollFrameLayout;", "getMContentView", "()Lcom/tencent/mm/plugin/finder/webview/ad/ScrollFrameLayout;", "setMContentView", "(Lcom/tencent/mm/plugin/finder/webview/ad/ScrollFrameLayout;)V", "mContext", "mRootView", "Landroid/view/ViewGroup;", "navigationBarHeight", "peekHeight", "getPeekHeight", "setPeekHeight", "peekRatio", "", "getPeekRatio", "()F", "setPeekRatio", "(F)V", "rightMargin", "getRightMargin", "setRightMargin", "screenHeight", "screenWidth", "scrollContainerHeight", "getScrollContainerHeight", "setScrollContainerHeight", "scrollContainerWidth", "getScrollContainerWidth", "setScrollContainerWidth", "scrollExpandedDownLimit", "getScrollExpandedDownLimit", "setScrollExpandedDownLimit", "scrollPeekDownLimit", "getScrollPeekDownLimit", "setScrollPeekDownLimit", "scrollUpLimit", "getScrollUpLimit", "setScrollUpLimit", "statusBarHeight", "topMargin", "getTopMargin", "setTopMargin", "addScrollView", "", "calcBottomSheetDialog", "calcCenterDialogParam", "calcLayoutParams", "initRootView", "initScrollView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends i
{
  public static final b.a GYE;
  public ScrollFrameLayout GYF;
  private final int GYG;
  private float GYH;
  private int GYI;
  private int GYJ;
  private int GYK;
  private int GYL;
  private int GYM;
  private int bmt;
  private int bmu;
  private int bmv;
  private int bmw;
  private int dqv;
  private int fl;
  private Context mContext;
  private int pQf;
  private int pQg;
  private final int pvg;
  private final int pvk;
  private final int sJv;
  private final int style;
  private ViewGroup tth;
  private final int vpn;
  
  static
  {
    AppMethodBeat.i(334645);
    GYE = new b.a((byte)0);
    AppMethodBeat.o(334645);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, e.i.CenterSheetDialog);
    AppMethodBeat.i(334627);
    this.style = 1;
    this.mContext = paramContext;
    paramContext = at.GiI;
    this.pvg = at.getScreenHeight();
    paramContext = at.GiI;
    this.sJv = at.getScreenWidth();
    this.pvk = bf.bk(this.mContext);
    this.vpn = bf.getStatusBarHeight(this.mContext);
    this.GYG = ((int)this.mContext.getResources().getDimension(e.c.Edge_7A));
    this.GYH = 0.75F;
    this.fl = 80;
    paramContext = af.mU(this.mContext).inflate(e.f.finder_ad_webview_dialog_container_layout, null);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(334627);
      throw paramContext;
    }
    this.tth = ((ViewGroup)paramContext);
    Object localObject2 = this.tth;
    paramContext = (Context)localObject2;
    if (localObject2 == null)
    {
      s.bIx("mRootView");
      paramContext = null;
    }
    paramContext.setOnClickListener(new b..ExternalSyntheticLambda0(this));
    switch (this.style)
    {
    default: 
      switch (this.style)
      {
      default: 
        label236:
        localObject2 = new FrameLayout.LayoutParams(-1, this.GYI);
        ((FrameLayout.LayoutParams)localObject2).leftMargin = this.bmt;
        ((FrameLayout.LayoutParams)localObject2).rightMargin = this.bmu;
        ((FrameLayout.LayoutParams)localObject2).topMargin = this.bmv;
        ((FrameLayout.LayoutParams)localObject2).bottomMargin = this.bmw;
        paramContext = this.tth;
        if (paramContext == null)
        {
          s.bIx("mRootView");
          paramContext = localObject1;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      paramContext.addView((View)fqr(), (ViewGroup.LayoutParams)localObject2);
      setCanceledOnTouchOutside(true);
      AppMethodBeat.o(334627);
      return;
      this.pQf = this.sJv;
      this.GYJ = this.pQf;
      this.pQg = (this.pvg - this.pvk - this.GYG);
      this.dqv = ((int)(this.pvg * this.GYH));
      this.GYI = this.pQg;
      this.bmv = ((int)(this.pvg * 0.25D - this.GYG));
      this.GYK = this.bmv;
      this.GYL = this.bmv;
      this.GYM = this.bmv;
      this.fl = 80;
      break;
      paramContext = at.GiI;
      this.pQf = at.getScreenWidth();
      this.bmt = ((int)getContext().getResources().getDimension(e.c.Edge_2A));
      this.bmu = this.bmt;
      this.GYJ = (this.pQf - (this.bmt + this.bmu));
      paramContext = at.GiI;
      this.pQg = (at.getScreenHeight() - bf.getStatusBarHeight(this.mContext));
      this.GYI = ((int)(this.GYJ * 1.666666666666667D));
      if (this.GYI > this.pQg) {
        this.GYI = (this.pQg - (int)getContext().getResources().getDimension(e.c.Edge_4A));
      }
      int i = (this.pvg - this.GYI) / 2;
      this.bmv = (this.pQg - this.GYI - i);
      if (this.bmv < 0) {
        this.bmv = 0;
      }
      this.GYL = ((int)getContext().getResources().getDimension(e.c.Edge_10A));
      this.fl = 80;
      break;
      paramContext = LayoutInflater.from(this.mContext).inflate(e.f.finder_bottom_webview_dialog_layout, null);
      if (paramContext == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.webview.ad.BottomScrollFrameLayout");
        AppMethodBeat.o(334627);
        throw paramContext;
      }
      a((ScrollFrameLayout)paramContext);
      ((BottomScrollFrameLayout)fqr()).setScrollPeekDownLimit(this.GYL);
      fqr().setScrollDownLimit(this.GYL);
      fqr().setScrollUpLimit(this.GYM);
      ((BottomScrollFrameLayout)fqr()).setPeekHeight(this.dqv);
      break label236;
      paramContext = LayoutInflater.from(this.mContext).inflate(e.f.finder_ad_webview_dialog_layout, null);
      if (paramContext == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.webview.ad.CenterScrollFrameLayout");
        AppMethodBeat.o(334627);
        throw paramContext;
      }
      a((ScrollFrameLayout)paramContext);
      fqr().setScrollDownLimit(this.GYL);
      break label236;
    }
  }
  
  private void a(ScrollFrameLayout paramScrollFrameLayout)
  {
    AppMethodBeat.i(334632);
    s.u(paramScrollFrameLayout, "<set-?>");
    this.GYF = paramScrollFrameLayout;
    AppMethodBeat.o(334632);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(334640);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/webview/ad/FinderScrollDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.dismiss();
    a.a(new Object(), "com/tencent/mm/plugin/finder/webview/ad/FinderScrollDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(334640);
  }
  
  public final ScrollFrameLayout fqr()
  {
    AppMethodBeat.i(334662);
    ScrollFrameLayout localScrollFrameLayout = this.GYF;
    if (localScrollFrameLayout != null)
    {
      AppMethodBeat.o(334662);
      return localScrollFrameLayout;
    }
    s.bIx("mContentView");
    AppMethodBeat.o(334662);
    return null;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(334673);
    super.onCreate(paramBundle);
    Object localObject = this.tth;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("mRootView");
      paramBundle = null;
    }
    setContentView((View)paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      localObject = paramBundle.getAttributes();
      ((WindowManager.LayoutParams)localObject).width = this.pQf;
      ((WindowManager.LayoutParams)localObject).height = this.pQg;
      ((WindowManager.LayoutParams)localObject).gravity = this.fl;
      paramBundle.setAttributes((WindowManager.LayoutParams)localObject);
      paramBundle.setWindowAnimations(e.i.FinderWebViewAnimation);
    }
    AppMethodBeat.o(334673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.ad.b
 * JD-Core Version:    0.7.0.1
 */