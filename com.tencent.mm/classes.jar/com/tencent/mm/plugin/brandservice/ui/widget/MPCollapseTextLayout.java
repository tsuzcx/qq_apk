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
import com.tencent.mm.plugin.brandservice.d.c;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSpecialText", "", "mCollapseButton", "Landroid/widget/TextView;", "mCollapseButtonHideWhenExpanded", "mCollapseButtonPaddingBottom", "mCollapseButtonWidth", "mCollapseText", "", "mCollaspeCallback", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$CollapseTextCallback;", "mContent", "mContentTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "mContext", "mDefaultCollapseWidth", "mEnableExpand", "mExpandText", "mExpanded", "mExtraEllipsizeWidth", "mMaxLines", "mProcessContentRunnable", "Ljava/lang/Runnable;", "mSpecialTextView", "mViewWidth", "needProcessContent", "changeMaxLines", "", "maxLines", "collapseSpecialText", "collapseText", "textWidth", "enoughSpace", "right", "", "expandText", "textLayout", "Lcom/tencent/neattextview/textview/layout/ILayout;", "realLines", "getCollapseButton", "getContextTextView", "init", "onCollapse", "collapseTextCallback", "onExpand", "line", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "processContent", "content", "", "expand", "enableExpand", "setCollapseButtonHideWhenExpanded", "hide", "setCollapseText", "setContent", "setEnableExpand", "setExpandText", "setMaxLines", "switchProperTextView", "CollapseTextCallback", "Companion", "plugin-brandservice_release"})
public final class MPCollapseTextLayout
  extends RelativeLayout
{
  public static final MPCollapseTextLayout.b sTQ;
  private int aIj;
  private String mContent;
  private Context mContext;
  private TextView sHK;
  private boolean sTA;
  private boolean sTB;
  private int sTC;
  private MPCollapseTextLayout.a sTD;
  private MMNeat7extView sTE;
  private TextView sTF;
  private int sTG;
  private int sTH;
  private int sTI;
  private boolean sTJ;
  private boolean sTK;
  private int sTL;
  private String sTM;
  private String sTN;
  private boolean sTO;
  private Runnable sTP;
  
  static
  {
    AppMethodBeat.i(7382);
    sTQ = new MPCollapseTextLayout.b((byte)0);
    AppMethodBeat.o(7382);
  }
  
  public MPCollapseTextLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7380);
    this.mContent = "";
    this.sTC = 5;
    this.sTM = "";
    this.sTN = "";
    this.mContext = paramContext;
    cEu();
    AppMethodBeat.o(7380);
  }
  
  public MPCollapseTextLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(7381);
    this.mContent = "";
    this.sTC = 5;
    this.sTM = "";
    this.sTN = "";
    this.mContext = paramContext;
    cEu();
    AppMethodBeat.o(7381);
  }
  
  private final void Hx(int paramInt)
  {
    AppMethodBeat.i(7375);
    if (this.sTE == null)
    {
      AppMethodBeat.o(7375);
      return;
    }
    this.sTA = false;
    Object localObject = this.sHK;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)this.sTN);
    }
    boolean bool = this.sTK;
    localObject = this.sTE;
    float f;
    if (localObject != null)
    {
      localObject = ((MMNeat7extView)localObject).nH(paramInt, 2147483647);
      if (localObject == null) {
        break label226;
      }
      f = ((com.tencent.neattextview.textview.layout.a)localObject).azY(this.sTC - 1);
      label93:
      Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo doCollapseText lastLineRight: %f, textWidth: %d, mCollapseButtonWidth: %d, content: %s", new Object[] { Float.valueOf(f), Integer.valueOf(paramInt), Integer.valueOf(this.sTG), this.mContent });
      if (!d(f, paramInt)) {
        break label250;
      }
      if (bool) {
        break label231;
      }
      localObject = this.sTE;
      if (localObject != null) {
        ((MMNeat7extView)localObject).a(TextUtils.TruncateAt.END, 0.0F);
      }
      label168:
      localObject = this.sHK;
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
        f = this.sTG + this.sTI - Math.max(paramInt - f, 0.0F);
        localObject = this.sTE;
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
  
  private final void Hy(int paramInt)
  {
    AppMethodBeat.i(7377);
    if (!this.sTK)
    {
      localObject = this.sTE;
      if (localObject != null)
      {
        ((MMNeat7extView)localObject).setMaxLines(paramInt);
        AppMethodBeat.o(7377);
        return;
      }
      AppMethodBeat.o(7377);
      return;
    }
    Object localObject = this.sTF;
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
    if (this.sTJ)
    {
      parama = this.sHK;
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
    this.sTA = true;
    TextView localTextView = this.sHK;
    if (localTextView != null) {
      localTextView.setText((CharSequence)this.sTM);
    }
    localTextView = this.sHK;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    float f = parama.azY(paramInt2 - 1);
    Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo expandText textWidth: %d, realLines: %d, maxLines: %d, last line right: %f", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.sTC), Float.valueOf(f) });
    parama = this.sHK;
    if (parama != null)
    {
      parama = parama.getLayoutParams();
      if ((!(parama instanceof RelativeLayout.LayoutParams)) || (d(f, paramInt1))) {
        break label250;
      }
      Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo expandText collapseButton show be at below");
      ((RelativeLayout.LayoutParams)parama).removeRule(12);
      ((RelativeLayout.LayoutParams)parama).removeRule(3);
      parama = (RelativeLayout.LayoutParams)parama;
      if (!this.sTK) {
        break label243;
      }
    }
    label243:
    for (paramInt1 = d.e.srL;; paramInt1 = d.e.content_tv)
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
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, final MPCollapseTextLayout.a parama)
  {
    AppMethodBeat.i(7374);
    Object localObject = this.sTE;
    final int i;
    if (localObject != null)
    {
      localObject = ((MMNeat7extView)localObject).nH(this.aIj, 2147483647);
      if (localObject == null) {
        break label214;
      }
      i = ((com.tencent.neattextview.textview.layout.a)localObject).ikp();
      label44:
      Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo processContent width: %d, line: %d, specialText: %b, expand: %b, enableExpand: %b, hashCode: %d", new Object[] { Integer.valueOf(this.aIj), Integer.valueOf(i), Boolean.valueOf(this.sTK), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(hashCode()) });
      cEv();
      if (i <= this.sTC) {
        break label238;
      }
      if (!paramBoolean1) {
        Hy(this.sTC);
      }
      TextView localTextView = this.sHK;
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      if (!paramBoolean1) {
        break label220;
      }
      a((com.tencent.neattextview.textview.layout.a)localObject, this.aIj, i);
    }
    for (;;)
    {
      if (!paramBoolean2) {
        break label266;
      }
      localObject = this.sHK;
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
      Hx(this.aIj);
    }
    label231:
    AppMethodBeat.o(7374);
    return;
    label238:
    Hy(2147483647);
    parama = this.sHK;
    if (parama != null)
    {
      parama.setVisibility(8);
      AppMethodBeat.o(7374);
      return;
    }
    label266:
    AppMethodBeat.o(7374);
  }
  
  private final void cEu()
  {
    AppMethodBeat.i(7369);
    setClipChildren(false);
    setClipToPadding(false);
    Object localObject = ad.kS(this.mContext).inflate(d.f.sur, (ViewGroup)this);
    this.sTE = ((MMNeat7extView)((View)localObject).findViewById(d.e.content_tv));
    this.sHK = ((TextView)((View)localObject).findViewById(d.e.collapse_button_tv));
    this.sTF = ((TextView)((View)localObject).findViewById(d.e.srL));
    localObject = this.sHK;
    if (localObject != null) {
      ((TextView)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    this.sTH = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 30);
    localObject = this.sHK;
    if (localObject != null) {}
    for (int i = ((TextView)localObject).getMeasuredWidth();; i = this.sTH)
    {
      this.sTG = i;
      this.sTL = ((int)(com.tencent.mm.ci.a.getDensity(this.mContext) * 2.5F));
      this.sTI = getResources().getDimensionPixelSize(d.c.SmallestPadding);
      localObject = this.mContext.getResources().getString(d.i.esP);
      p.j(localObject, "mContext.resources.getSt…_line_item_text_collapse)");
      this.sTM = ((String)localObject);
      localObject = this.mContext.getResources().getString(d.i.suK);
      p.j(localObject, "mContext.resources.getSt…time_line_item_text_more)");
      this.sTN = ((String)localObject);
      AppMethodBeat.o(7369);
      return;
    }
  }
  
  private final void cEv()
  {
    AppMethodBeat.i(7378);
    if (!this.sTK)
    {
      localObject = this.sTE;
      if (localObject != null) {
        ((MMNeat7extView)localObject).setVisibility(0);
      }
      localObject = this.sTF;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.sHK;
      if (localObject != null)
      {
        ((TextView)localObject).setPadding(0, 0, 0, this.sTL);
        AppMethodBeat.o(7378);
        return;
      }
      AppMethodBeat.o(7378);
      return;
    }
    Object localObject = this.sTE;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setVisibility(8);
    }
    localObject = this.sTF;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.sHK;
    if (localObject != null)
    {
      ((TextView)localObject).setPadding(0, 0, 0, 0);
      AppMethodBeat.o(7378);
      return;
    }
    AppMethodBeat.o(7378);
  }
  
  private final boolean d(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(7379);
    TextView localTextView = this.sHK;
    if (localTextView != null) {}
    for (int i = localTextView.getMeasuredWidth();; i = this.sTH)
    {
      this.sTG = i;
      float f = paramInt - this.sTG;
      if (this.sTK) {
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
  
  public final TextView getCollapseButton()
  {
    return this.sHK;
  }
  
  public final MMNeat7extView getContextTextView()
  {
    return this.sTE;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7370);
    super.onMeasure(paramInt1, paramInt2);
    Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo onMeasure width: %d, viewWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.aIj) });
    if (this.aIj != getMeasuredWidth())
    {
      this.aIj = getMeasuredWidth();
      if (this.sTO)
      {
        Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo onMeasure needProcessContent");
        this.sTO = false;
        a(this.sTA, this.sTB, this.sTD);
      }
    }
    AppMethodBeat.o(7370);
  }
  
  public final void setCollapseButtonHideWhenExpanded(boolean paramBoolean)
  {
    this.sTJ = paramBoolean;
  }
  
  public final void setCollapseText(String paramString)
  {
    AppMethodBeat.i(7371);
    p.k(paramString, "collapseText");
    this.sTM = paramString;
    AppMethodBeat.o(7371);
  }
  
  public final void setContent(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(7373);
    p.k(paramCharSequence, "content");
    p.k(paramCharSequence, "content");
    p.k(paramCharSequence, "content");
    if ((this.mContent.equals(paramCharSequence)) && (!this.sTA) && (!this.sTB))
    {
      Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo setContent ignore %s", new Object[] { this.mContent, paramCharSequence });
      AppMethodBeat.o(7373);
      return;
    }
    this.mContent = paramCharSequence.toString();
    Object localObject = this.sTE;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setMaxLines(this.sTC);
    }
    localObject = this.sTE;
    if (localObject != null) {
      ((MMNeat7extView)localObject).aL(paramCharSequence);
    }
    localObject = this.sTF;
    if (localObject != null) {
      ((TextView)localObject).setMaxLines(this.sTC);
    }
    localObject = this.sTF;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    paramCharSequence = this.sTE;
    if (paramCharSequence != null) {}
    for (boolean bool = paramCharSequence.ikB();; bool = false)
    {
      this.sTK = bool;
      this.sTA = false;
      this.sTB = false;
      this.sTD = null;
      if (this.sTP != null)
      {
        paramCharSequence = this.sTE;
        if (paramCharSequence != null) {
          paramCharSequence.removeCallbacks(this.sTP);
        }
      }
      if (this.aIj == 0) {
        break;
      }
      this.sTO = false;
      a(false, false, null);
      AppMethodBeat.o(7373);
      return;
    }
    this.sTO = true;
    AppMethodBeat.o(7373);
  }
  
  public final void setEnableExpand(boolean paramBoolean)
  {
    this.sTB = paramBoolean;
  }
  
  public final void setExpandText(String paramString)
  {
    AppMethodBeat.i(7372);
    p.k(paramString, "expandText");
    this.sTN = paramString;
    AppMethodBeat.o(7372);
  }
  
  public final void setMaxLines(int paramInt)
  {
    this.sTC = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MPCollapseTextLayout paramMPCollapseTextLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(7365);
      TextView localTextView = MPCollapseTextLayout.d(this.sTR);
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      localTextView = MPCollapseTextLayout.d(this.sTR);
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)MPCollapseTextLayout.e(this.sTR));
        AppMethodBeat.o(7365);
        return;
      }
      AppMethodBeat.o(7365);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(MPCollapseTextLayout paramMPCollapseTextLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(7366);
      MMNeat7extView localMMNeat7extView = MPCollapseTextLayout.f(this.sTR);
      if (localMMNeat7extView != null)
      {
        localMMNeat7extView.requestLayout();
        AppMethodBeat.o(7366);
        return;
      }
      AppMethodBeat.o(7366);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(MPCollapseTextLayout paramMPCollapseTextLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(7367);
      MPCollapseTextLayout.g(this.sTR);
      AppMethodBeat.o(7367);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(MPCollapseTextLayout paramMPCollapseTextLayout, int paramInt, MPCollapseTextLayout.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7368);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$processContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (!MPCollapseTextLayout.a(this.sTR)) {
        MPCollapseTextLayout.b(this.sTR);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$processContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7368);
        return;
        MPCollapseTextLayout.c(this.sTR);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPCollapseTextLayout
 * JD-Core Version:    0.7.0.1
 */