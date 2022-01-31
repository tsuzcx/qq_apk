package com.tencent.mm.plugin.brandservice.ui.widget;

import a.f.b.j;
import a.l;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMNeat7extView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSpecialText", "", "mCollapseButton", "Landroid/widget/TextView;", "mCollapseButtonHideWhenExpanded", "mCollapseButtonPaddingBottom", "mCollapseButtonWidth", "mCollapseText", "", "mCollaspeCallback", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$CollapseTextCallback;", "mContent", "mContentTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "mContext", "mDefaultCollapseWidth", "mEnableExpand", "mExpandText", "mExpanded", "mExtraEllipsizeWidth", "mMaxLines", "mProcessContentRunnable", "Ljava/lang/Runnable;", "mSpecialTextView", "mViewWidth", "needProcessContent", "changeMaxLines", "", "maxLines", "collapseSpecialText", "collapseText", "textWidth", "enoughSpace", "right", "", "expandText", "textLayout", "Lcom/tencent/neattextview/textview/layout/ILayout;", "realLines", "getCollapseButton", "getContextTextView", "init", "onCollapse", "collapseTextCallback", "onExpand", "line", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "processContent", "content", "", "expand", "enableExpand", "setCollapseButtonHideWhenExpanded", "hide", "setCollapseText", "setContent", "setEnableExpand", "setExpandText", "setMaxLines", "switchProperTextView", "CollapseTextCallback", "Companion", "plugin-brandservice_release"})
public final class MPCollapseTextLayout
  extends RelativeLayout
{
  public static final MPCollapseTextLayout.b kjo;
  private int asY;
  private TextView jYv;
  private boolean kiY;
  private boolean kiZ;
  private int kja;
  private MPCollapseTextLayout.a kjb;
  private MMNeat7extView kjc;
  private TextView kjd;
  private int kje;
  private int kjf;
  private int kjg;
  private boolean kjh;
  private boolean kji;
  private int kjj;
  private String kjk;
  private String kjl;
  private boolean kjm;
  private Runnable kjn;
  private String mContent;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(153005);
    kjo = new MPCollapseTextLayout.b((byte)0);
    AppMethodBeat.o(153005);
  }
  
  public MPCollapseTextLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(153003);
    this.mContent = "";
    this.kja = 5;
    this.kjk = "";
    this.kjl = "";
    this.mContext = paramContext;
    aZY();
    AppMethodBeat.o(153003);
  }
  
  public MPCollapseTextLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(153004);
    this.mContent = "";
    this.kja = 5;
    this.kjk = "";
    this.kjl = "";
    this.mContext = paramContext;
    aZY();
    AppMethodBeat.o(153004);
  }
  
  private final void a(com.tencent.neattextview.textview.layout.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152999);
    if (this.kjh)
    {
      parama = this.jYv;
      if (parama != null)
      {
        parama.setVisibility(8);
        AppMethodBeat.o(152999);
        return;
      }
      AppMethodBeat.o(152999);
      return;
    }
    if (parama == null)
    {
      AppMethodBeat.o(152999);
      return;
    }
    this.kiY = true;
    TextView localTextView = this.jYv;
    if (localTextView != null) {
      localTextView.setText((CharSequence)this.kjk);
    }
    localTextView = this.jYv;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    float f = parama.getLineRight(paramInt2 - 1);
    ab.v("MicroMsg.MPCollapseTextLayout", "alvinluo expandText textWidth: %d, realLines: %d, maxLines: %d, last line right: %f", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.kja), Float.valueOf(f) });
    parama = this.jYv;
    if (parama != null)
    {
      parama = parama.getLayoutParams();
      if ((!(parama instanceof RelativeLayout.LayoutParams)) || (e(f, paramInt1))) {
        break label241;
      }
      ab.v("MicroMsg.MPCollapseTextLayout", "alvinluo expandText collapseButton show be at below");
      ((RelativeLayout.LayoutParams)parama).removeRule(12);
      ((RelativeLayout.LayoutParams)parama).removeRule(3);
      parama = (RelativeLayout.LayoutParams)parama;
      if (!this.kji) {
        break label235;
      }
    }
    label235:
    for (paramInt1 = 2131825402;; paramInt1 = 2131823022)
    {
      parama.addRule(3, paramInt1);
      AppMethodBeat.o(152999);
      return;
      parama = null;
      break;
    }
    label241:
    if ((parama instanceof RelativeLayout.LayoutParams))
    {
      ((RelativeLayout.LayoutParams)parama).removeRule(3);
      ((RelativeLayout.LayoutParams)parama).addRule(12);
    }
    AppMethodBeat.o(152999);
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, MPCollapseTextLayout.a parama)
  {
    AppMethodBeat.i(152997);
    Object localObject = this.kjc;
    int i;
    if (localObject != null)
    {
      localObject = ((MMNeat7extView)localObject).Sa(this.asY);
      if (localObject == null) {
        break label209;
      }
      i = ((com.tencent.neattextview.textview.layout.a)localObject).dTo();
      label41:
      ab.v("MicroMsg.MPCollapseTextLayout", "alvinluo processContent width: %d, line: %d, specialText: %b, expand: %b, enableExpand: %b, hashCode: %d", new Object[] { Integer.valueOf(this.asY), Integer.valueOf(i), Boolean.valueOf(this.kji), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(hashCode()) });
      aZZ();
      if (i <= this.kja) {
        break label232;
      }
      if (!paramBoolean1) {
        sP(this.kja);
      }
      TextView localTextView = this.jYv;
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      if (!paramBoolean1) {
        break label215;
      }
      a((com.tencent.neattextview.textview.layout.a)localObject, this.asY, i);
    }
    for (;;)
    {
      if (!paramBoolean2) {
        break label260;
      }
      localObject = this.jYv;
      if (localObject == null) {
        break label226;
      }
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new MPCollapseTextLayout.f(this, i, parama));
      AppMethodBeat.o(152997);
      return;
      localObject = null;
      break;
      label209:
      i = 0;
      break label41;
      label215:
      sO(this.asY);
    }
    label226:
    AppMethodBeat.o(152997);
    return;
    label232:
    sP(2147483647);
    parama = this.jYv;
    if (parama != null)
    {
      parama.setVisibility(8);
      AppMethodBeat.o(152997);
      return;
    }
    label260:
    AppMethodBeat.o(152997);
  }
  
  private final void aZY()
  {
    AppMethodBeat.i(152992);
    setClipChildren(false);
    setClipToPadding(false);
    Object localObject = w.hM(this.mContext).inflate(2130969974, (ViewGroup)this);
    this.kjc = ((MMNeat7extView)((View)localObject).findViewById(2131823022));
    this.jYv = ((TextView)((View)localObject).findViewById(2131825403));
    this.kjd = ((TextView)((View)localObject).findViewById(2131825402));
    localObject = this.jYv;
    if (localObject != null) {
      ((TextView)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    this.kjf = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 30);
    localObject = this.jYv;
    if (localObject != null) {}
    for (int i = ((TextView)localObject).getMeasuredWidth();; i = this.kjf)
    {
      this.kje = i;
      this.kjj = ((int)(com.tencent.mm.cb.a.getDensity(this.mContext) * 2.5F));
      this.kjg = getResources().getDimensionPixelSize(2131427861);
      localObject = this.mContext.getResources().getString(2131297703);
      j.p(localObject, "mContext.resources.getSt…_line_item_text_collapse)");
      this.kjk = ((String)localObject);
      localObject = this.mContext.getResources().getString(2131297705);
      j.p(localObject, "mContext.resources.getSt…time_line_item_text_more)");
      this.kjl = ((String)localObject);
      AppMethodBeat.o(152992);
      return;
    }
  }
  
  private final void aZZ()
  {
    AppMethodBeat.i(153001);
    if (!this.kji)
    {
      localObject = this.kjc;
      if (localObject != null) {
        ((MMNeat7extView)localObject).setVisibility(0);
      }
      localObject = this.kjd;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.jYv;
      if (localObject != null)
      {
        ((TextView)localObject).setPadding(0, 0, 0, this.kjj);
        AppMethodBeat.o(153001);
        return;
      }
      AppMethodBeat.o(153001);
      return;
    }
    Object localObject = this.kjc;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setVisibility(8);
    }
    localObject = this.kjd;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.jYv;
    if (localObject != null)
    {
      ((TextView)localObject).setPadding(0, 0, 0, 0);
      AppMethodBeat.o(153001);
      return;
    }
    AppMethodBeat.o(153001);
  }
  
  private final boolean e(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(153002);
    TextView localTextView = this.jYv;
    if (localTextView != null) {}
    for (int i = localTextView.getMeasuredWidth();; i = this.kjf)
    {
      this.kje = i;
      float f = paramInt - this.kje;
      if (this.kji) {
        f = paramInt * 3.0F / 4.0F;
      }
      if (paramFloat >= f) {
        break;
      }
      AppMethodBeat.o(153002);
      return true;
    }
    AppMethodBeat.o(153002);
    return false;
  }
  
  private final void sO(int paramInt)
  {
    AppMethodBeat.i(152998);
    if (this.kjc == null)
    {
      AppMethodBeat.o(152998);
      return;
    }
    this.kiY = false;
    Object localObject = this.jYv;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)this.kjl);
    }
    boolean bool = this.kji;
    localObject = this.kjc;
    float f;
    if (localObject != null)
    {
      localObject = ((MMNeat7extView)localObject).Sa(paramInt);
      if (localObject == null) {
        break label225;
      }
      f = ((com.tencent.neattextview.textview.layout.a)localObject).getLineRight(this.kja - 1);
      label91:
      ab.v("MicroMsg.MPCollapseTextLayout", "alvinluo doCollapseText lastLineRight: %f, textWidth: %d, mCollapseButtonWidth: %d, content: %s", new Object[] { Float.valueOf(f), Integer.valueOf(paramInt), Integer.valueOf(this.kje), this.mContent });
      if (!e(f, paramInt)) {
        break label249;
      }
      if (bool) {
        break label230;
      }
      localObject = this.kjc;
      if (localObject != null) {
        ((MMNeat7extView)localObject).a(TextUtils.TruncateAt.END, 0.0F);
      }
      label167:
      localObject = this.jYv;
      if (localObject == null) {
        break label355;
      }
    }
    label225:
    label355:
    for (localObject = ((TextView)localObject).getLayoutParams();; localObject = null)
    {
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        ((RelativeLayout.LayoutParams)localObject).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
      }
      AppMethodBeat.o(152998);
      return;
      localObject = null;
      break;
      f = 0.0F;
      break label91;
      label230:
      post((Runnable)new MPCollapseTextLayout.c(this));
      break label167;
      label249:
      if (!bool)
      {
        f = this.kje + this.kjg - Math.max(paramInt - f, 0.0F);
        localObject = this.kjc;
        if (localObject != null) {
          ((MMNeat7extView)localObject).a(TextUtils.TruncateAt.END, f);
        }
        ab.v("MicroMsg.MPCollapseTextLayout", "alvinluo doCollapseText ellipsize: %f", new Object[] { Float.valueOf(f) });
        post((Runnable)new MPCollapseTextLayout.d(this));
        break label167;
      }
      post((Runnable)new MPCollapseTextLayout.e(this));
      AppMethodBeat.o(152998);
      return;
    }
  }
  
  private final void sP(int paramInt)
  {
    AppMethodBeat.i(153000);
    if (!this.kji)
    {
      localObject = this.kjc;
      if (localObject != null)
      {
        ((MMNeat7extView)localObject).setMaxLines(paramInt);
        AppMethodBeat.o(153000);
        return;
      }
      AppMethodBeat.o(153000);
      return;
    }
    Object localObject = this.kjd;
    if (localObject != null)
    {
      ((TextView)localObject).setMaxLines(paramInt);
      AppMethodBeat.o(153000);
      return;
    }
    AppMethodBeat.o(153000);
  }
  
  public final TextView getCollapseButton()
  {
    return this.jYv;
  }
  
  public final MMNeat7extView getContextTextView()
  {
    return this.kjc;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152993);
    super.onMeasure(paramInt1, paramInt2);
    ab.v("MicroMsg.MPCollapseTextLayout", "alvinluo onMeasure width: %d, viewWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.asY) });
    if (this.asY != getMeasuredWidth())
    {
      this.asY = getMeasuredWidth();
      if (this.kjm)
      {
        ab.v("MicroMsg.MPCollapseTextLayout", "alvinluo onMeasure needProcessContent");
        this.kjm = false;
        a(this.kiY, this.kiZ, this.kjb);
      }
    }
    AppMethodBeat.o(152993);
  }
  
  public final void setCollapseButtonHideWhenExpanded(boolean paramBoolean)
  {
    this.kjh = paramBoolean;
  }
  
  public final void setCollapseText(String paramString)
  {
    AppMethodBeat.i(152994);
    j.q(paramString, "collapseText");
    this.kjk = paramString;
    AppMethodBeat.o(152994);
  }
  
  public final void setContent(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152996);
    j.q(paramCharSequence, "content");
    j.q(paramCharSequence, "content");
    j.q(paramCharSequence, "content");
    if ((this.mContent.equals(paramCharSequence)) && (!this.kiY) && (!this.kiZ))
    {
      ab.v("MicroMsg.MPCollapseTextLayout", "alvinluo setContent ignore %s", new Object[] { this.mContent, paramCharSequence });
      AppMethodBeat.o(152996);
      return;
    }
    this.mContent = paramCharSequence.toString();
    Object localObject = this.kjc;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setMaxLines(this.kja);
    }
    localObject = this.kjc;
    if (localObject != null) {
      ((MMNeat7extView)localObject).af(paramCharSequence);
    }
    localObject = this.kjd;
    if (localObject != null) {
      ((TextView)localObject).setMaxLines(this.kja);
    }
    localObject = this.kjd;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    paramCharSequence = this.kjc;
    if (paramCharSequence != null) {}
    for (boolean bool = paramCharSequence.dTA();; bool = false)
    {
      this.kji = bool;
      this.kiY = false;
      this.kiZ = false;
      this.kjb = null;
      if (this.kjn != null)
      {
        paramCharSequence = this.kjc;
        if (paramCharSequence != null) {
          paramCharSequence.removeCallbacks(this.kjn);
        }
      }
      if (this.asY == 0) {
        break;
      }
      this.kjm = false;
      a(false, false, null);
      AppMethodBeat.o(152996);
      return;
    }
    this.kjm = true;
    AppMethodBeat.o(152996);
  }
  
  public final void setEnableExpand(boolean paramBoolean)
  {
    this.kiZ = paramBoolean;
  }
  
  public final void setExpandText(String paramString)
  {
    AppMethodBeat.i(152995);
    j.q(paramString, "expandText");
    this.kjl = paramString;
    AppMethodBeat.o(152995);
  }
  
  public final void setMaxLines(int paramInt)
  {
    this.kja = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPCollapseTextLayout
 * JD-Core Version:    0.7.0.1
 */