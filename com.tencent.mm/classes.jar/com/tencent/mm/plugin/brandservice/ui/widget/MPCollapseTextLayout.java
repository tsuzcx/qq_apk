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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.z;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSpecialText", "", "mCollapseButton", "Landroid/widget/TextView;", "mCollapseButtonHideWhenExpanded", "mCollapseButtonPaddingBottom", "mCollapseButtonWidth", "mCollapseText", "", "mCollaspeCallback", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$CollapseTextCallback;", "mContent", "mContentTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "mContext", "mDefaultCollapseWidth", "mEnableExpand", "mExpandText", "mExpanded", "mExtraEllipsizeWidth", "mMaxLines", "mProcessContentRunnable", "Ljava/lang/Runnable;", "mSpecialTextView", "mViewWidth", "needProcessContent", "changeMaxLines", "", "maxLines", "collapseSpecialText", "collapseText", "textWidth", "enoughSpace", "right", "", "expandText", "textLayout", "Lcom/tencent/neattextview/textview/layout/ILayout;", "realLines", "getCollapseButton", "getContextTextView", "init", "onCollapse", "collapseTextCallback", "onExpand", "line", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "processContent", "content", "", "expand", "enableExpand", "setCollapseButtonHideWhenExpanded", "hide", "setCollapseText", "setContent", "setEnableExpand", "setExpandText", "setMaxLines", "switchProperTextView", "CollapseTextCallback", "Companion", "plugin-brandservice_release"})
public final class MPCollapseTextLayout
  extends RelativeLayout
{
  public static final MPCollapseTextLayout.b ozj;
  private int aYS;
  private String mContent;
  private Context mContext;
  private TextView olJ;
  private boolean oyT;
  private boolean oyU;
  private int oyV;
  private MPCollapseTextLayout.a oyW;
  private MMNeat7extView oyX;
  private TextView oyY;
  private int oyZ;
  private int oza;
  private int ozb;
  private boolean ozc;
  private boolean ozd;
  private int oze;
  private String ozf;
  private String ozg;
  private boolean ozh;
  private Runnable ozi;
  
  static
  {
    AppMethodBeat.i(7382);
    ozj = new MPCollapseTextLayout.b((byte)0);
    AppMethodBeat.o(7382);
  }
  
  public MPCollapseTextLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7380);
    this.mContent = "";
    this.oyV = 5;
    this.ozf = "";
    this.ozg = "";
    this.mContext = paramContext;
    bTy();
    AppMethodBeat.o(7380);
  }
  
  public MPCollapseTextLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(7381);
    this.mContent = "";
    this.oyV = 5;
    this.ozf = "";
    this.ozg = "";
    this.mContext = paramContext;
    bTy();
    AppMethodBeat.o(7381);
  }
  
  private final void As(int paramInt)
  {
    AppMethodBeat.i(7375);
    if (this.oyX == null)
    {
      AppMethodBeat.o(7375);
      return;
    }
    this.oyT = false;
    Object localObject = this.olJ;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)this.ozg);
    }
    boolean bool = this.ozd;
    localObject = this.oyX;
    float f;
    if (localObject != null)
    {
      localObject = ((MMNeat7extView)localObject).kR(paramInt, 2147483647);
      if (localObject == null) {
        break label226;
      }
      f = ((com.tencent.neattextview.textview.layout.a)localObject).getLineRight(this.oyV - 1);
      label93:
      ae.v("MicroMsg.MPCollapseTextLayout", "alvinluo doCollapseText lastLineRight: %f, textWidth: %d, mCollapseButtonWidth: %d, content: %s", new Object[] { Float.valueOf(f), Integer.valueOf(paramInt), Integer.valueOf(this.oyZ), this.mContent });
      if (!c(f, paramInt)) {
        break label250;
      }
      if (bool) {
        break label231;
      }
      localObject = this.oyX;
      if (localObject != null) {
        ((MMNeat7extView)localObject).a(TextUtils.TruncateAt.END, 0.0F);
      }
      label168:
      localObject = this.olJ;
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
        f = this.oyZ + this.ozb - Math.max(paramInt - f, 0.0F);
        localObject = this.oyX;
        if (localObject != null) {
          ((MMNeat7extView)localObject).a(TextUtils.TruncateAt.END, f);
        }
        ae.v("MicroMsg.MPCollapseTextLayout", "alvinluo doCollapseText ellipsize: %f", new Object[] { Float.valueOf(f) });
        post((Runnable)new d(this));
        break label168;
      }
      post((Runnable)new e(this));
      AppMethodBeat.o(7375);
      return;
    }
  }
  
  private final void At(int paramInt)
  {
    AppMethodBeat.i(7377);
    if (!this.ozd)
    {
      localObject = this.oyX;
      if (localObject != null)
      {
        ((MMNeat7extView)localObject).setMaxLines(paramInt);
        AppMethodBeat.o(7377);
        return;
      }
      AppMethodBeat.o(7377);
      return;
    }
    Object localObject = this.oyY;
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
    if (this.ozc)
    {
      parama = this.olJ;
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
    this.oyT = true;
    TextView localTextView = this.olJ;
    if (localTextView != null) {
      localTextView.setText((CharSequence)this.ozf);
    }
    localTextView = this.olJ;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    float f = parama.getLineRight(paramInt2 - 1);
    ae.v("MicroMsg.MPCollapseTextLayout", "alvinluo expandText textWidth: %d, realLines: %d, maxLines: %d, last line right: %f", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.oyV), Float.valueOf(f) });
    parama = this.olJ;
    if (parama != null)
    {
      parama = parama.getLayoutParams();
      if ((!(parama instanceof RelativeLayout.LayoutParams)) || (c(f, paramInt1))) {
        break label250;
      }
      ae.v("MicroMsg.MPCollapseTextLayout", "alvinluo expandText collapseButton show be at below");
      ((RelativeLayout.LayoutParams)parama).removeRule(12);
      ((RelativeLayout.LayoutParams)parama).removeRule(3);
      parama = (RelativeLayout.LayoutParams)parama;
      if (!this.ozd) {
        break label243;
      }
    }
    label243:
    for (paramInt1 = 2131298779;; paramInt1 = 2131298778)
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
    Object localObject = this.oyX;
    final int i;
    if (localObject != null)
    {
      localObject = ((MMNeat7extView)localObject).kR(this.aYS, 2147483647);
      if (localObject == null) {
        break label214;
      }
      i = ((com.tencent.neattextview.textview.layout.a)localObject).fXb();
      label44:
      ae.v("MicroMsg.MPCollapseTextLayout", "alvinluo processContent width: %d, line: %d, specialText: %b, expand: %b, enableExpand: %b, hashCode: %d", new Object[] { Integer.valueOf(this.aYS), Integer.valueOf(i), Boolean.valueOf(this.ozd), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(hashCode()) });
      bTz();
      if (i <= this.oyV) {
        break label238;
      }
      if (!paramBoolean1) {
        At(this.oyV);
      }
      TextView localTextView = this.olJ;
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      if (!paramBoolean1) {
        break label220;
      }
      a((com.tencent.neattextview.textview.layout.a)localObject, this.aYS, i);
    }
    for (;;)
    {
      if (!paramBoolean2) {
        break label266;
      }
      localObject = this.olJ;
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
      As(this.aYS);
    }
    label231:
    AppMethodBeat.o(7374);
    return;
    label238:
    At(2147483647);
    parama = this.olJ;
    if (parama != null)
    {
      parama.setVisibility(8);
      AppMethodBeat.o(7374);
      return;
    }
    label266:
    AppMethodBeat.o(7374);
  }
  
  private final void bTy()
  {
    AppMethodBeat.i(7369);
    setClipChildren(false);
    setClipToPadding(false);
    Object localObject = z.jV(this.mContext).inflate(2131494562, (ViewGroup)this);
    this.oyX = ((MMNeat7extView)((View)localObject).findViewById(2131298778));
    this.olJ = ((TextView)((View)localObject).findViewById(2131298417));
    this.oyY = ((TextView)((View)localObject).findViewById(2131298779));
    localObject = this.olJ;
    if (localObject != null) {
      ((TextView)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    this.oza = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 30);
    localObject = this.olJ;
    if (localObject != null) {}
    for (int i = ((TextView)localObject).getMeasuredWidth();; i = this.oza)
    {
      this.oyZ = i;
      this.oze = ((int)(com.tencent.mm.cb.a.getDensity(this.mContext) * 2.5F));
      this.ozb = getResources().getDimensionPixelSize(2131165575);
      localObject = this.mContext.getResources().getString(2131756619);
      p.g(localObject, "mContext.resources.getSt…_line_item_text_collapse)");
      this.ozf = ((String)localObject);
      localObject = this.mContext.getResources().getString(2131756621);
      p.g(localObject, "mContext.resources.getSt…time_line_item_text_more)");
      this.ozg = ((String)localObject);
      AppMethodBeat.o(7369);
      return;
    }
  }
  
  private final void bTz()
  {
    AppMethodBeat.i(7378);
    if (!this.ozd)
    {
      localObject = this.oyX;
      if (localObject != null) {
        ((MMNeat7extView)localObject).setVisibility(0);
      }
      localObject = this.oyY;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.olJ;
      if (localObject != null)
      {
        ((TextView)localObject).setPadding(0, 0, 0, this.oze);
        AppMethodBeat.o(7378);
        return;
      }
      AppMethodBeat.o(7378);
      return;
    }
    Object localObject = this.oyX;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setVisibility(8);
    }
    localObject = this.oyY;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.olJ;
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
    TextView localTextView = this.olJ;
    if (localTextView != null) {}
    for (int i = localTextView.getMeasuredWidth();; i = this.oza)
    {
      this.oyZ = i;
      float f = paramInt - this.oyZ;
      if (this.ozd) {
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
    return this.olJ;
  }
  
  public final MMNeat7extView getContextTextView()
  {
    return this.oyX;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7370);
    super.onMeasure(paramInt1, paramInt2);
    ae.v("MicroMsg.MPCollapseTextLayout", "alvinluo onMeasure width: %d, viewWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.aYS) });
    if (this.aYS != getMeasuredWidth())
    {
      this.aYS = getMeasuredWidth();
      if (this.ozh)
      {
        ae.v("MicroMsg.MPCollapseTextLayout", "alvinluo onMeasure needProcessContent");
        this.ozh = false;
        a(this.oyT, this.oyU, this.oyW);
      }
    }
    AppMethodBeat.o(7370);
  }
  
  public final void setCollapseButtonHideWhenExpanded(boolean paramBoolean)
  {
    this.ozc = paramBoolean;
  }
  
  public final void setCollapseText(String paramString)
  {
    AppMethodBeat.i(7371);
    p.h(paramString, "collapseText");
    this.ozf = paramString;
    AppMethodBeat.o(7371);
  }
  
  public final void setContent(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(7373);
    p.h(paramCharSequence, "content");
    p.h(paramCharSequence, "content");
    p.h(paramCharSequence, "content");
    if ((this.mContent.equals(paramCharSequence)) && (!this.oyT) && (!this.oyU))
    {
      ae.v("MicroMsg.MPCollapseTextLayout", "alvinluo setContent ignore %s", new Object[] { this.mContent, paramCharSequence });
      AppMethodBeat.o(7373);
      return;
    }
    this.mContent = paramCharSequence.toString();
    Object localObject = this.oyX;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setMaxLines(this.oyV);
    }
    localObject = this.oyX;
    if (localObject != null) {
      ((MMNeat7extView)localObject).aq(paramCharSequence);
    }
    localObject = this.oyY;
    if (localObject != null) {
      ((TextView)localObject).setMaxLines(this.oyV);
    }
    localObject = this.oyY;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    paramCharSequence = this.oyX;
    if (paramCharSequence != null) {}
    for (boolean bool = paramCharSequence.fXn();; bool = false)
    {
      this.ozd = bool;
      this.oyT = false;
      this.oyU = false;
      this.oyW = null;
      if (this.ozi != null)
      {
        paramCharSequence = this.oyX;
        if (paramCharSequence != null) {
          paramCharSequence.removeCallbacks(this.ozi);
        }
      }
      if (this.aYS == 0) {
        break;
      }
      this.ozh = false;
      a(false, false, null);
      AppMethodBeat.o(7373);
      return;
    }
    this.ozh = true;
    AppMethodBeat.o(7373);
  }
  
  public final void setEnableExpand(boolean paramBoolean)
  {
    this.oyU = paramBoolean;
  }
  
  public final void setExpandText(String paramString)
  {
    AppMethodBeat.i(7372);
    p.h(paramString, "expandText");
    this.ozg = paramString;
    AppMethodBeat.o(7372);
  }
  
  public final void setMaxLines(int paramInt)
  {
    this.oyV = paramInt;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MPCollapseTextLayout paramMPCollapseTextLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(7365);
      TextView localTextView = MPCollapseTextLayout.d(this.ozk);
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      localTextView = MPCollapseTextLayout.d(this.ozk);
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)MPCollapseTextLayout.e(this.ozk));
        AppMethodBeat.o(7365);
        return;
      }
      AppMethodBeat.o(7365);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(MPCollapseTextLayout paramMPCollapseTextLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(7366);
      MMNeat7extView localMMNeat7extView = MPCollapseTextLayout.f(this.ozk);
      if (localMMNeat7extView != null)
      {
        localMMNeat7extView.requestLayout();
        AppMethodBeat.o(7366);
        return;
      }
      AppMethodBeat.o(7366);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(MPCollapseTextLayout paramMPCollapseTextLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(7367);
      MPCollapseTextLayout.g(this.ozk);
      AppMethodBeat.o(7367);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(MPCollapseTextLayout paramMPCollapseTextLayout, int paramInt, MPCollapseTextLayout.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7368);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$processContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (!MPCollapseTextLayout.a(this.ozk)) {
        MPCollapseTextLayout.b(this.ozk);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$processContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7368);
        return;
        MPCollapseTextLayout.c(this.ozk);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPCollapseTextLayout
 * JD-Core Version:    0.7.0.1
 */