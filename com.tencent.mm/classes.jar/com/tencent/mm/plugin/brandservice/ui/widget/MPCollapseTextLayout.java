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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.z;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSpecialText", "", "mCollapseButton", "Landroid/widget/TextView;", "mCollapseButtonHideWhenExpanded", "mCollapseButtonPaddingBottom", "mCollapseButtonWidth", "mCollapseText", "", "mCollaspeCallback", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$CollapseTextCallback;", "mContent", "mContentTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "mContext", "mDefaultCollapseWidth", "mEnableExpand", "mExpandText", "mExpanded", "mExtraEllipsizeWidth", "mMaxLines", "mProcessContentRunnable", "Ljava/lang/Runnable;", "mSpecialTextView", "mViewWidth", "needProcessContent", "changeMaxLines", "", "maxLines", "collapseSpecialText", "collapseText", "textWidth", "enoughSpace", "right", "", "expandText", "textLayout", "Lcom/tencent/neattextview/textview/layout/ILayout;", "realLines", "getCollapseButton", "getContextTextView", "init", "onCollapse", "collapseTextCallback", "onExpand", "line", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "processContent", "content", "", "expand", "enableExpand", "setCollapseButtonHideWhenExpanded", "hide", "setCollapseText", "setContent", "setEnableExpand", "setExpandText", "setMaxLines", "switchProperTextView", "CollapseTextCallback", "Companion", "plugin-brandservice_release"})
public final class MPCollapseTextLayout
  extends RelativeLayout
{
  public static final MPCollapseTextLayout.b nQb;
  private int aOy;
  private String mContent;
  private Context mContext;
  private TextView nDm;
  private boolean nPL;
  private boolean nPM;
  private int nPN;
  private MPCollapseTextLayout.a nPO;
  private MMNeat7extView nPP;
  private TextView nPQ;
  private int nPR;
  private int nPS;
  private int nPT;
  private boolean nPU;
  private boolean nPV;
  private int nPW;
  private String nPX;
  private String nPY;
  private boolean nPZ;
  private Runnable nQa;
  
  static
  {
    AppMethodBeat.i(7382);
    nQb = new MPCollapseTextLayout.b((byte)0);
    AppMethodBeat.o(7382);
  }
  
  public MPCollapseTextLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7380);
    this.mContent = "";
    this.nPN = 5;
    this.nPX = "";
    this.nPY = "";
    this.mContext = paramContext;
    bNL();
    AppMethodBeat.o(7380);
  }
  
  public MPCollapseTextLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(7381);
    this.mContent = "";
    this.nPN = 5;
    this.nPX = "";
    this.nPY = "";
    this.mContext = paramContext;
    bNL();
    AppMethodBeat.o(7381);
  }
  
  private final void a(com.tencent.neattextview.textview.layout.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7376);
    if (this.nPU)
    {
      parama = this.nDm;
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
    this.nPL = true;
    TextView localTextView = this.nDm;
    if (localTextView != null) {
      localTextView.setText((CharSequence)this.nPX);
    }
    localTextView = this.nDm;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    float f = parama.getLineRight(paramInt2 - 1);
    ac.v("MicroMsg.MPCollapseTextLayout", "alvinluo expandText textWidth: %d, realLines: %d, maxLines: %d, last line right: %f", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.nPN), Float.valueOf(f) });
    parama = this.nDm;
    if (parama != null)
    {
      parama = parama.getLayoutParams();
      if ((!(parama instanceof RelativeLayout.LayoutParams)) || (c(f, paramInt1))) {
        break label246;
      }
      ac.v("MicroMsg.MPCollapseTextLayout", "alvinluo expandText collapseButton show be at below");
      ((RelativeLayout.LayoutParams)parama).removeRule(12);
      ((RelativeLayout.LayoutParams)parama).removeRule(3);
      parama = (RelativeLayout.LayoutParams)parama;
      if (!this.nPV) {
        break label240;
      }
    }
    label240:
    for (paramInt1 = 2131298779;; paramInt1 = 2131298778)
    {
      parama.addRule(3, paramInt1);
      AppMethodBeat.o(7376);
      return;
      parama = null;
      break;
    }
    label246:
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
    Object localObject = this.nPP;
    final int i;
    if (localObject != null)
    {
      localObject = ((MMNeat7extView)localObject).kv(this.aOy, 2147483647);
      if (localObject == null) {
        break label213;
      }
      i = ((com.tencent.neattextview.textview.layout.a)localObject).fBm();
      label44:
      ac.v("MicroMsg.MPCollapseTextLayout", "alvinluo processContent width: %d, line: %d, specialText: %b, expand: %b, enableExpand: %b, hashCode: %d", new Object[] { Integer.valueOf(this.aOy), Integer.valueOf(i), Boolean.valueOf(this.nPV), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(hashCode()) });
      bNM();
      if (i <= this.nPN) {
        break label237;
      }
      if (!paramBoolean1) {
        zy(this.nPN);
      }
      TextView localTextView = this.nDm;
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      if (!paramBoolean1) {
        break label219;
      }
      a((com.tencent.neattextview.textview.layout.a)localObject, this.aOy, i);
    }
    for (;;)
    {
      if (!paramBoolean2) {
        break label265;
      }
      localObject = this.nDm;
      if (localObject == null) {
        break label230;
      }
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new f(this, i, parama));
      AppMethodBeat.o(7374);
      return;
      localObject = null;
      break;
      label213:
      i = 0;
      break label44;
      label219:
      zx(this.aOy);
    }
    label230:
    AppMethodBeat.o(7374);
    return;
    label237:
    zy(2147483647);
    parama = this.nDm;
    if (parama != null)
    {
      parama.setVisibility(8);
      AppMethodBeat.o(7374);
      return;
    }
    label265:
    AppMethodBeat.o(7374);
  }
  
  private final void bNL()
  {
    AppMethodBeat.i(7369);
    setClipChildren(false);
    setClipToPadding(false);
    Object localObject = z.jD(this.mContext).inflate(2131494562, (ViewGroup)this);
    this.nPP = ((MMNeat7extView)((View)localObject).findViewById(2131298778));
    this.nDm = ((TextView)((View)localObject).findViewById(2131298417));
    this.nPQ = ((TextView)((View)localObject).findViewById(2131298779));
    localObject = this.nDm;
    if (localObject != null) {
      ((TextView)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    this.nPS = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 30);
    localObject = this.nDm;
    if (localObject != null) {}
    for (int i = ((TextView)localObject).getMeasuredWidth();; i = this.nPS)
    {
      this.nPR = i;
      this.nPW = ((int)(com.tencent.mm.cc.a.getDensity(this.mContext) * 2.5F));
      this.nPT = getResources().getDimensionPixelSize(2131165575);
      localObject = this.mContext.getResources().getString(2131756619);
      k.g(localObject, "mContext.resources.getSt…_line_item_text_collapse)");
      this.nPX = ((String)localObject);
      localObject = this.mContext.getResources().getString(2131756621);
      k.g(localObject, "mContext.resources.getSt…time_line_item_text_more)");
      this.nPY = ((String)localObject);
      AppMethodBeat.o(7369);
      return;
    }
  }
  
  private final void bNM()
  {
    AppMethodBeat.i(7378);
    if (!this.nPV)
    {
      localObject = this.nPP;
      if (localObject != null) {
        ((MMNeat7extView)localObject).setVisibility(0);
      }
      localObject = this.nPQ;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.nDm;
      if (localObject != null)
      {
        ((TextView)localObject).setPadding(0, 0, 0, this.nPW);
        AppMethodBeat.o(7378);
        return;
      }
      AppMethodBeat.o(7378);
      return;
    }
    Object localObject = this.nPP;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setVisibility(8);
    }
    localObject = this.nPQ;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.nDm;
    if (localObject != null)
    {
      ((TextView)localObject).setPadding(0, 0, 0, 0);
      AppMethodBeat.o(7378);
      return;
    }
    AppMethodBeat.o(7378);
  }
  
  private final boolean c(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(7379);
    TextView localTextView = this.nDm;
    if (localTextView != null) {}
    for (int i = localTextView.getMeasuredWidth();; i = this.nPS)
    {
      this.nPR = i;
      float f = paramInt - this.nPR;
      if (this.nPV) {
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
  
  private final void zx(int paramInt)
  {
    AppMethodBeat.i(7375);
    if (this.nPP == null)
    {
      AppMethodBeat.o(7375);
      return;
    }
    this.nPL = false;
    Object localObject = this.nDm;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)this.nPY);
    }
    boolean bool = this.nPV;
    localObject = this.nPP;
    float f;
    if (localObject != null)
    {
      localObject = ((MMNeat7extView)localObject).kv(paramInt, 2147483647);
      if (localObject == null) {
        break label227;
      }
      f = ((com.tencent.neattextview.textview.layout.a)localObject).getLineRight(this.nPN - 1);
      label93:
      ac.v("MicroMsg.MPCollapseTextLayout", "alvinluo doCollapseText lastLineRight: %f, textWidth: %d, mCollapseButtonWidth: %d, content: %s", new Object[] { Float.valueOf(f), Integer.valueOf(paramInt), Integer.valueOf(this.nPR), this.mContent });
      if (!c(f, paramInt)) {
        break label251;
      }
      if (bool) {
        break label232;
      }
      localObject = this.nPP;
      if (localObject != null) {
        ((MMNeat7extView)localObject).a(TextUtils.TruncateAt.END, 0.0F);
      }
      label169:
      localObject = this.nDm;
      if (localObject == null) {
        break label357;
      }
    }
    label227:
    label357:
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
      label232:
      post((Runnable)new c(this));
      break label169;
      label251:
      if (!bool)
      {
        f = this.nPR + this.nPT - Math.max(paramInt - f, 0.0F);
        localObject = this.nPP;
        if (localObject != null) {
          ((MMNeat7extView)localObject).a(TextUtils.TruncateAt.END, f);
        }
        ac.v("MicroMsg.MPCollapseTextLayout", "alvinluo doCollapseText ellipsize: %f", new Object[] { Float.valueOf(f) });
        post((Runnable)new d(this));
        break label169;
      }
      post((Runnable)new e(this));
      AppMethodBeat.o(7375);
      return;
    }
  }
  
  private final void zy(int paramInt)
  {
    AppMethodBeat.i(7377);
    if (!this.nPV)
    {
      localObject = this.nPP;
      if (localObject != null)
      {
        ((MMNeat7extView)localObject).setMaxLines(paramInt);
        AppMethodBeat.o(7377);
        return;
      }
      AppMethodBeat.o(7377);
      return;
    }
    Object localObject = this.nPQ;
    if (localObject != null)
    {
      ((TextView)localObject).setMaxLines(paramInt);
      AppMethodBeat.o(7377);
      return;
    }
    AppMethodBeat.o(7377);
  }
  
  public final TextView getCollapseButton()
  {
    return this.nDm;
  }
  
  public final MMNeat7extView getContextTextView()
  {
    return this.nPP;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7370);
    super.onMeasure(paramInt1, paramInt2);
    ac.v("MicroMsg.MPCollapseTextLayout", "alvinluo onMeasure width: %d, viewWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.aOy) });
    if (this.aOy != getMeasuredWidth())
    {
      this.aOy = getMeasuredWidth();
      if (this.nPZ)
      {
        ac.v("MicroMsg.MPCollapseTextLayout", "alvinluo onMeasure needProcessContent");
        this.nPZ = false;
        a(this.nPL, this.nPM, this.nPO);
      }
    }
    AppMethodBeat.o(7370);
  }
  
  public final void setCollapseButtonHideWhenExpanded(boolean paramBoolean)
  {
    this.nPU = paramBoolean;
  }
  
  public final void setCollapseText(String paramString)
  {
    AppMethodBeat.i(7371);
    k.h(paramString, "collapseText");
    this.nPX = paramString;
    AppMethodBeat.o(7371);
  }
  
  public final void setContent(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(7373);
    k.h(paramCharSequence, "content");
    k.h(paramCharSequence, "content");
    k.h(paramCharSequence, "content");
    if ((this.mContent.equals(paramCharSequence)) && (!this.nPL) && (!this.nPM))
    {
      ac.v("MicroMsg.MPCollapseTextLayout", "alvinluo setContent ignore %s", new Object[] { this.mContent, paramCharSequence });
      AppMethodBeat.o(7373);
      return;
    }
    this.mContent = paramCharSequence.toString();
    Object localObject = this.nPP;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setMaxLines(this.nPN);
    }
    localObject = this.nPP;
    if (localObject != null) {
      ((MMNeat7extView)localObject).ar(paramCharSequence);
    }
    localObject = this.nPQ;
    if (localObject != null) {
      ((TextView)localObject).setMaxLines(this.nPN);
    }
    localObject = this.nPQ;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    paramCharSequence = this.nPP;
    if (paramCharSequence != null) {}
    for (boolean bool = paramCharSequence.fBy();; bool = false)
    {
      this.nPV = bool;
      this.nPL = false;
      this.nPM = false;
      this.nPO = null;
      if (this.nQa != null)
      {
        paramCharSequence = this.nPP;
        if (paramCharSequence != null) {
          paramCharSequence.removeCallbacks(this.nQa);
        }
      }
      if (this.aOy == 0) {
        break;
      }
      this.nPZ = false;
      a(false, false, null);
      AppMethodBeat.o(7373);
      return;
    }
    this.nPZ = true;
    AppMethodBeat.o(7373);
  }
  
  public final void setEnableExpand(boolean paramBoolean)
  {
    this.nPM = paramBoolean;
  }
  
  public final void setExpandText(String paramString)
  {
    AppMethodBeat.i(7372);
    k.h(paramString, "expandText");
    this.nPY = paramString;
    AppMethodBeat.o(7372);
  }
  
  public final void setMaxLines(int paramInt)
  {
    this.nPN = paramInt;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MPCollapseTextLayout paramMPCollapseTextLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(7365);
      TextView localTextView = MPCollapseTextLayout.d(this.nQc);
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      localTextView = MPCollapseTextLayout.d(this.nQc);
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)MPCollapseTextLayout.e(this.nQc));
        AppMethodBeat.o(7365);
        return;
      }
      AppMethodBeat.o(7365);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(MPCollapseTextLayout paramMPCollapseTextLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(7366);
      MMNeat7extView localMMNeat7extView = MPCollapseTextLayout.f(this.nQc);
      if (localMMNeat7extView != null)
      {
        localMMNeat7extView.requestLayout();
        AppMethodBeat.o(7366);
        return;
      }
      AppMethodBeat.o(7366);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(MPCollapseTextLayout paramMPCollapseTextLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(7367);
      MPCollapseTextLayout.g(this.nQc);
      AppMethodBeat.o(7367);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(MPCollapseTextLayout paramMPCollapseTextLayout, int paramInt, MPCollapseTextLayout.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7368);
      if (!MPCollapseTextLayout.a(this.nQc))
      {
        MPCollapseTextLayout.b(this.nQc);
        AppMethodBeat.o(7368);
        return;
      }
      MPCollapseTextLayout.c(this.nQc);
      AppMethodBeat.o(7368);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPCollapseTextLayout
 * JD-Core Version:    0.7.0.1
 */