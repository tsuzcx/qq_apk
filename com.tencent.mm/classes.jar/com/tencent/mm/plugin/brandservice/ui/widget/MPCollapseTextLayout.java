package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSpecialText", "", "mCollapseButton", "Landroid/widget/TextView;", "mCollapseButtonHideWhenExpanded", "mCollapseButtonPaddingBottom", "mCollapseButtonWidth", "mCollapseText", "", "mCollaspeCallback", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$CollapseTextCallback;", "mContent", "mContentTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "mContext", "mDefaultCollapseWidth", "mEnableExpand", "mExpandText", "mExpanded", "mExtraEllipsizeWidth", "mMaxLines", "mProcessContentRunnable", "Ljava/lang/Runnable;", "mSpecialTextView", "mViewWidth", "needProcessContent", "changeMaxLines", "", "maxLines", "collapseSpecialText", "collapseText", "textWidth", "enoughSpace", "right", "", "expandText", "textLayout", "Lcom/tencent/neattextview/textview/layout/ILayout;", "realLines", "getCollapseButton", "getContextTextView", "init", "onCollapse", "collapseTextCallback", "onExpand", "line", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "processContent", "content", "", "expand", "enableExpand", "setCollapseButtonHideWhenExpanded", "hide", "setCollapseText", "setContent", "setEnableExpand", "setExpandText", "setMaxLines", "switchProperTextView", "CollapseTextCallback", "Companion", "plugin-brandservice_release"})
public final class MPCollapseTextLayout
  extends RelativeLayout
{
  public static final MPCollapseTextLayout.b pMS;
  private int aYN;
  private String mContent;
  private Context mContext;
  private boolean pMC;
  private boolean pMD;
  private int pME;
  private a pMF;
  private MMNeat7extView pMG;
  private TextView pMH;
  private int pMI;
  private int pMJ;
  private int pMK;
  private boolean pML;
  private boolean pMM;
  private int pMN;
  private String pMO;
  private String pMP;
  private boolean pMQ;
  private Runnable pMR;
  private TextView pyh;
  
  static
  {
    AppMethodBeat.i(7382);
    pMS = new MPCollapseTextLayout.b((byte)0);
    AppMethodBeat.o(7382);
  }
  
  public MPCollapseTextLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7380);
    this.mContent = "";
    this.pME = 5;
    this.pMO = "";
    this.pMP = "";
    this.mContext = paramContext;
    crl();
    AppMethodBeat.o(7380);
  }
  
  public MPCollapseTextLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(7381);
    this.mContent = "";
    this.pME = 5;
    this.pMO = "";
    this.pMP = "";
    this.mContext = paramContext;
    crl();
    AppMethodBeat.o(7381);
  }
  
  private final void DX(int paramInt)
  {
    AppMethodBeat.i(7375);
    if (this.pMG == null)
    {
      AppMethodBeat.o(7375);
      return;
    }
    this.pMC = false;
    Object localObject = this.pyh;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)this.pMP);
    }
    boolean bool = this.pMM;
    localObject = this.pMG;
    float f;
    if (localObject != null)
    {
      localObject = ((MMNeat7extView)localObject).mq(paramInt, 2147483647);
      if (localObject == null) {
        break label226;
      }
      f = ((com.tencent.neattextview.textview.layout.a)localObject).getLineRight(this.pME - 1);
      label93:
      Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo doCollapseText lastLineRight: %f, textWidth: %d, mCollapseButtonWidth: %d, content: %s", new Object[] { Float.valueOf(f), Integer.valueOf(paramInt), Integer.valueOf(this.pMI), this.mContent });
      if (!a(f, paramInt)) {
        break label250;
      }
      if (bool) {
        break label231;
      }
      localObject = this.pMG;
      if (localObject != null) {
        ((MMNeat7extView)localObject).a(TextUtils.TruncateAt.END, 0.0F);
      }
      label168:
      localObject = this.pyh;
      if (localObject == null) {
        break label356;
      }
    }
    label226:
    label356:
    for (localObject = ((TextView)localObject).getLayoutParams();; localObject = null)
    {
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        ((RelativeLayout.LayoutParams)localObject).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
      }
      AppMethodBeat.o(7375);
      return;
      localObject = null;
      break;
      f = 0.0F;
      break label93;
      label231:
      post((Runnable)new c(this));
      break label168;
      label250:
      if (!bool)
      {
        f = this.pMI + this.pMK - Math.max(paramInt - f, 0.0F);
        localObject = this.pMG;
        if (localObject != null) {
          ((MMNeat7extView)localObject).a(TextUtils.TruncateAt.END, f);
        }
        Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo doCollapseText ellipsize: %f", new Object[] { Float.valueOf(f) });
        post((Runnable)new d(this));
        break label168;
      }
      post((Runnable)new e(this));
      AppMethodBeat.o(7375);
      return;
    }
  }
  
  private final void DY(int paramInt)
  {
    AppMethodBeat.i(7377);
    if (!this.pMM)
    {
      localObject = this.pMG;
      if (localObject != null)
      {
        ((MMNeat7extView)localObject).setMaxLines(paramInt);
        AppMethodBeat.o(7377);
        return;
      }
      AppMethodBeat.o(7377);
      return;
    }
    Object localObject = this.pMH;
    if (localObject != null)
    {
      ((TextView)localObject).setMaxLines(paramInt);
      AppMethodBeat.o(7377);
      return;
    }
    AppMethodBeat.o(7377);
  }
  
  private final void a(com.tencent.neattextview.textview.layout.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7376);
    if (this.pML)
    {
      parama = this.pyh;
      if (parama != null)
      {
        parama.setVisibility(8);
        AppMethodBeat.o(7376);
        return;
      }
      AppMethodBeat.o(7376);
      return;
    }
    if (parama == null)
    {
      AppMethodBeat.o(7376);
      return;
    }
    this.pMC = true;
    TextView localTextView = this.pyh;
    if (localTextView != null) {
      localTextView.setText((CharSequence)this.pMO);
    }
    localTextView = this.pyh;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    float f = parama.getLineRight(paramInt2 - 1);
    Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo expandText textWidth: %d, realLines: %d, maxLines: %d, last line right: %f", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.pME), Float.valueOf(f) });
    parama = this.pyh;
    if (parama != null)
    {
      parama = parama.getLayoutParams();
      if ((!(parama instanceof RelativeLayout.LayoutParams)) || (a(f, paramInt1))) {
        break label250;
      }
      Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo expandText collapseButton show be at below");
      ((RelativeLayout.LayoutParams)parama).removeRule(12);
      ((RelativeLayout.LayoutParams)parama).removeRule(3);
      parama = (RelativeLayout.LayoutParams)parama;
      if (!this.pMM) {
        break label243;
      }
    }
    label243:
    for (paramInt1 = 2131299224;; paramInt1 = 2131299223)
    {
      parama.addRule(3, paramInt1);
      AppMethodBeat.o(7376);
      return;
      parama = null;
      break;
    }
    label250:
    if ((parama instanceof RelativeLayout.LayoutParams))
    {
      ((RelativeLayout.LayoutParams)parama).removeRule(3);
      ((RelativeLayout.LayoutParams)parama).addRule(12);
    }
    AppMethodBeat.o(7376);
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, final a parama)
  {
    AppMethodBeat.i(7374);
    Object localObject = this.pMG;
    final int i;
    if (localObject != null)
    {
      localObject = ((MMNeat7extView)localObject).mq(this.aYN, 2147483647);
      if (localObject == null) {
        break label214;
      }
      i = ((com.tencent.neattextview.textview.layout.a)localObject).hiG();
      label44:
      Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo processContent width: %d, line: %d, specialText: %b, expand: %b, enableExpand: %b, hashCode: %d", new Object[] { Integer.valueOf(this.aYN), Integer.valueOf(i), Boolean.valueOf(this.pMM), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(hashCode()) });
      crm();
      if (i <= this.pME) {
        break label238;
      }
      if (!paramBoolean1) {
        DY(this.pME);
      }
      TextView localTextView = this.pyh;
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      if (!paramBoolean1) {
        break label220;
      }
      a((com.tencent.neattextview.textview.layout.a)localObject, this.aYN, i);
    }
    for (;;)
    {
      if (!paramBoolean2) {
        break label266;
      }
      localObject = this.pyh;
      if (localObject == null) {
        break label231;
      }
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new f(this, i, parama));
      AppMethodBeat.o(7374);
      return;
      localObject = null;
      break;
      label214:
      i = 0;
      break label44;
      label220:
      DX(this.aYN);
    }
    label231:
    AppMethodBeat.o(7374);
    return;
    label238:
    DY(2147483647);
    parama = this.pyh;
    if (parama != null)
    {
      parama.setVisibility(8);
      AppMethodBeat.o(7374);
      return;
    }
    label266:
    AppMethodBeat.o(7374);
  }
  
  private final boolean a(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(7379);
    TextView localTextView = this.pyh;
    if (localTextView != null) {}
    for (int i = localTextView.getMeasuredWidth();; i = this.pMJ)
    {
      this.pMI = i;
      float f = paramInt - this.pMI;
      if (this.pMM) {
        f = paramInt * 3.0F / 4.0F;
      }
      if (paramFloat >= f) {
        break;
      }
      AppMethodBeat.o(7379);
      return true;
    }
    AppMethodBeat.o(7379);
    return false;
  }
  
  private final void crl()
  {
    AppMethodBeat.i(7369);
    setClipChildren(false);
    setClipToPadding(false);
    Object localObject = aa.jQ(this.mContext).inflate(2131495178, (ViewGroup)this);
    this.pMG = ((MMNeat7extView)((View)localObject).findViewById(2131299223));
    this.pyh = ((TextView)((View)localObject).findViewById(2131298827));
    this.pMH = ((TextView)((View)localObject).findViewById(2131299224));
    localObject = this.pyh;
    if (localObject != null) {
      ((TextView)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    this.pMJ = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 30);
    localObject = this.pyh;
    if (localObject != null) {}
    for (int i = ((TextView)localObject).getMeasuredWidth();; i = this.pMJ)
    {
      this.pMI = i;
      this.pMN = ((int)(com.tencent.mm.cb.a.getDensity(this.mContext) * 2.5F));
      this.pMK = getResources().getDimensionPixelSize(2131165593);
      localObject = this.mContext.getResources().getString(2131756767);
      p.g(localObject, "mContext.resources.getSt…_line_item_text_collapse)");
      this.pMO = ((String)localObject);
      localObject = this.mContext.getResources().getString(2131756769);
      p.g(localObject, "mContext.resources.getSt…time_line_item_text_more)");
      this.pMP = ((String)localObject);
      AppMethodBeat.o(7369);
      return;
    }
  }
  
  private final void crm()
  {
    AppMethodBeat.i(7378);
    if (!this.pMM)
    {
      localObject = this.pMG;
      if (localObject != null) {
        ((MMNeat7extView)localObject).setVisibility(0);
      }
      localObject = this.pMH;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.pyh;
      if (localObject != null)
      {
        ((TextView)localObject).setPadding(0, 0, 0, this.pMN);
        AppMethodBeat.o(7378);
        return;
      }
      AppMethodBeat.o(7378);
      return;
    }
    Object localObject = this.pMG;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setVisibility(8);
    }
    localObject = this.pMH;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.pyh;
    if (localObject != null)
    {
      ((TextView)localObject).setPadding(0, 0, 0, 0);
      AppMethodBeat.o(7378);
      return;
    }
    AppMethodBeat.o(7378);
  }
  
  public final TextView getCollapseButton()
  {
    return this.pyh;
  }
  
  public final MMNeat7extView getContextTextView()
  {
    return this.pMG;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7370);
    super.onMeasure(paramInt1, paramInt2);
    Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo onMeasure width: %d, viewWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.aYN) });
    if (this.aYN != getMeasuredWidth())
    {
      this.aYN = getMeasuredWidth();
      if (this.pMQ)
      {
        Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo onMeasure needProcessContent");
        this.pMQ = false;
        a(this.pMC, this.pMD, this.pMF);
      }
    }
    AppMethodBeat.o(7370);
  }
  
  public final void setCollapseButtonHideWhenExpanded(boolean paramBoolean)
  {
    this.pML = paramBoolean;
  }
  
  public final void setCollapseText(String paramString)
  {
    AppMethodBeat.i(7371);
    p.h(paramString, "collapseText");
    this.pMO = paramString;
    AppMethodBeat.o(7371);
  }
  
  public final void setContent(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(7373);
    p.h(paramCharSequence, "content");
    p.h(paramCharSequence, "content");
    p.h(paramCharSequence, "content");
    if ((this.mContent.equals(paramCharSequence)) && (!this.pMC) && (!this.pMD))
    {
      Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo setContent ignore %s", new Object[] { this.mContent, paramCharSequence });
      AppMethodBeat.o(7373);
      return;
    }
    this.mContent = paramCharSequence.toString();
    Object localObject = this.pMG;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setMaxLines(this.pME);
    }
    localObject = this.pMG;
    if (localObject != null) {
      ((MMNeat7extView)localObject).aw(paramCharSequence);
    }
    localObject = this.pMH;
    if (localObject != null) {
      ((TextView)localObject).setMaxLines(this.pME);
    }
    localObject = this.pMH;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    paramCharSequence = this.pMG;
    if (paramCharSequence != null) {}
    for (boolean bool = paramCharSequence.hiS();; bool = false)
    {
      this.pMM = bool;
      this.pMC = false;
      this.pMD = false;
      this.pMF = null;
      if (this.pMR != null)
      {
        paramCharSequence = this.pMG;
        if (paramCharSequence != null) {
          paramCharSequence.removeCallbacks(this.pMR);
        }
      }
      if (this.aYN == 0) {
        break;
      }
      this.pMQ = false;
      a(false, false, null);
      AppMethodBeat.o(7373);
      return;
    }
    this.pMQ = true;
    AppMethodBeat.o(7373);
  }
  
  public final void setEnableExpand(boolean paramBoolean)
  {
    this.pMD = paramBoolean;
  }
  
  public final void setExpandText(String paramString)
  {
    AppMethodBeat.i(7372);
    p.h(paramString, "expandText");
    this.pMP = paramString;
    AppMethodBeat.o(7372);
  }
  
  public final void setMaxLines(int paramInt)
  {
    this.pME = paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$CollapseTextCallback;", "", "onCollapse", "", "showLines", "", "onExpand", "onMeasured", "layout", "Lcom/tencent/neattextview/textview/layout/ILayout;", "plugin-brandservice_release"})
  public static abstract interface a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MPCollapseTextLayout paramMPCollapseTextLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(7365);
      TextView localTextView = MPCollapseTextLayout.d(this.pMT);
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      localTextView = MPCollapseTextLayout.d(this.pMT);
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)MPCollapseTextLayout.e(this.pMT));
        AppMethodBeat.o(7365);
        return;
      }
      AppMethodBeat.o(7365);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(MPCollapseTextLayout paramMPCollapseTextLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(7366);
      MMNeat7extView localMMNeat7extView = MPCollapseTextLayout.f(this.pMT);
      if (localMMNeat7extView != null)
      {
        localMMNeat7extView.requestLayout();
        AppMethodBeat.o(7366);
        return;
      }
      AppMethodBeat.o(7366);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(MPCollapseTextLayout paramMPCollapseTextLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(7367);
      MPCollapseTextLayout.g(this.pMT);
      AppMethodBeat.o(7367);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(MPCollapseTextLayout paramMPCollapseTextLayout, int paramInt, MPCollapseTextLayout.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7368);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$processContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (!MPCollapseTextLayout.a(this.pMT)) {
        MPCollapseTextLayout.b(this.pMT);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$processContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7368);
        return;
        MPCollapseTextLayout.c(this.pMT);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPCollapseTextLayout
 * JD-Core Version:    0.7.0.1
 */