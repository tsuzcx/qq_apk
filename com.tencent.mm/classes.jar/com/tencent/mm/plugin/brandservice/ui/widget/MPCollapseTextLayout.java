package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
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
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSpecialText", "", "mCollapseButton", "Landroid/widget/TextView;", "mCollapseButtonHideWhenExpanded", "mCollapseButtonPaddingBottom", "mCollapseButtonWidth", "mCollapseText", "", "mCollaspeCallback", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout$CollapseTextCallback;", "mContent", "mContentTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "mContext", "mDefaultCollapseWidth", "mEnableExpand", "mExpandText", "mExpanded", "mExtraEllipsizeWidth", "mMaxLines", "mProcessContentRunnable", "Ljava/lang/Runnable;", "mSpecialTextView", "mViewWidth", "needProcessContent", "changeMaxLines", "", "maxLines", "collapseSpecialText", "collapseText", "textWidth", "enoughSpace", "right", "", "expandText", "textLayout", "Lcom/tencent/neattextview/textview/layout/ILayout;", "realLines", "getCollapseButton", "getContextTextView", "init", "onCollapse", "collapseTextCallback", "onExpand", "line", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "processContent", "content", "", "expand", "enableExpand", "setCollapseButtonHideWhenExpanded", "hide", "setCollapseText", "setContent", "setEnableExpand", "setExpandText", "setMaxLines", "switchProperTextView", "CollapseTextCallback", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MPCollapseTextLayout
  extends RelativeLayout
{
  public static final MPCollapseTextLayout.b vYQ;
  private String mContent;
  private Context mContext;
  private int mViewWidth;
  private TextView vNg;
  private boolean vYR;
  private boolean vYS;
  private int vYT;
  private MPCollapseTextLayout.a vYU;
  private MMNeat7extView vYV;
  private TextView vYW;
  private int vYX;
  private int vYY;
  private int vYZ;
  private boolean vZa;
  private boolean vZb;
  private int vZc;
  private String vZd;
  private String vZe;
  private boolean vZf;
  private Runnable vZg;
  
  static
  {
    AppMethodBeat.i(7382);
    vYQ = new MPCollapseTextLayout.b((byte)0);
    AppMethodBeat.o(7382);
  }
  
  public MPCollapseTextLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7380);
    this.mContent = "";
    this.vYT = 5;
    this.vZd = "";
    this.vZe = "";
    this.mContext = paramContext;
    dhX();
    AppMethodBeat.o(7380);
  }
  
  public MPCollapseTextLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(7381);
    this.mContent = "";
    this.vYT = 5;
    this.vZd = "";
    this.vZe = "";
    this.mContext = paramContext;
    dhX();
    AppMethodBeat.o(7381);
  }
  
  private final void HZ(int paramInt)
  {
    AppMethodBeat.i(7375);
    if (this.vYV == null)
    {
      AppMethodBeat.o(7375);
      return;
    }
    this.vYR = false;
    Object localObject = this.vNg;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)this.vZe);
    }
    boolean bool = this.vZb;
    localObject = this.vYV;
    float f;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label210;
      }
      f = 0.0F;
      label74:
      Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo doCollapseText lastLineRight: %f, textWidth: %d, mCollapseButtonWidth: %d, content: %s", new Object[] { Float.valueOf(f), Integer.valueOf(paramInt), Integer.valueOf(this.vYX), this.mContent });
      if (!d(f, paramInt)) {
        break label243;
      }
      if (bool) {
        break label227;
      }
      localObject = this.vYV;
      if (localObject != null) {
        ((MMNeat7extView)localObject).a(TextUtils.TruncateAt.END, 0.0F);
      }
      label149:
      localObject = this.vNg;
      if (localObject != null) {
        break label343;
      }
    }
    label210:
    label343:
    for (localObject = null;; localObject = ((TextView)localObject).getLayoutParams())
    {
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        ((RelativeLayout.LayoutParams)localObject).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
      }
      AppMethodBeat.o(7375);
      return;
      localObject = ((MMNeat7extView)localObject).pE(paramInt, 2147483647);
      break;
      f = ((com.tencent.neattextview.textview.layout.a)localObject).aGL(this.vYT - 1);
      break label74;
      label227:
      post(new MPCollapseTextLayout..ExternalSyntheticLambda2(this));
      break label149;
      label243:
      if (!bool)
      {
        f = this.vYX + this.vYZ - Math.max(paramInt - f, 0.0F);
        localObject = this.vYV;
        if (localObject != null) {
          ((MMNeat7extView)localObject).a(TextUtils.TruncateAt.END, f);
        }
        Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo doCollapseText ellipsize: %f", new Object[] { Float.valueOf(f) });
        post(new MPCollapseTextLayout..ExternalSyntheticLambda1(this));
        break label149;
      }
      post(new MPCollapseTextLayout..ExternalSyntheticLambda3(this));
      AppMethodBeat.o(7375);
      return;
    }
  }
  
  private final void Ia(int paramInt)
  {
    AppMethodBeat.i(7377);
    Object localObject;
    if (!this.vZb)
    {
      localObject = this.vYV;
      if (localObject != null)
      {
        ((MMNeat7extView)localObject).setMaxLines(paramInt);
        AppMethodBeat.o(7377);
      }
    }
    else
    {
      localObject = this.vYW;
      if (localObject != null) {
        ((TextView)localObject).setMaxLines(paramInt);
      }
    }
    AppMethodBeat.o(7377);
  }
  
  private static final void a(MPCollapseTextLayout paramMPCollapseTextLayout)
  {
    AppMethodBeat.i(301718);
    s.u(paramMPCollapseTextLayout, "this$0");
    TextView localTextView = paramMPCollapseTextLayout.vYW;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    localTextView = paramMPCollapseTextLayout.vYW;
    if (localTextView != null) {
      localTextView.setText((CharSequence)paramMPCollapseTextLayout.mContent);
    }
    AppMethodBeat.o(301718);
  }
  
  private static final void a(MPCollapseTextLayout paramMPCollapseTextLayout, int paramInt, MPCollapseTextLayout.a parama, View paramView)
  {
    AppMethodBeat.i(301717);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramMPCollapseTextLayout);
    localb.sc(paramInt);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMPCollapseTextLayout, "this$0");
    if (!paramMPCollapseTextLayout.vYR)
    {
      parama = paramMPCollapseTextLayout.vYV;
      if (parama != null) {
        parama.setMaxLines(2147483647);
      }
      parama = paramMPCollapseTextLayout.vYW;
      if (parama != null) {
        parama.setMaxLines(2147483647);
      }
      parama = paramMPCollapseTextLayout.vYV;
      if (parama == null)
      {
        parama = null;
        int i = paramMPCollapseTextLayout.mViewWidth;
        if (parama != null) {
          break label188;
        }
        paramInt = 0;
        label137:
        paramMPCollapseTextLayout.a(parama, i, paramInt);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/widget/MPCollapseTextLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(301717);
      return;
      parama = parama.pE(paramMPCollapseTextLayout.mViewWidth, 2147483647);
      break;
      label188:
      paramInt = parama.jQH();
      break label137;
      paramMPCollapseTextLayout.Ia(paramMPCollapseTextLayout.vYT);
      paramMPCollapseTextLayout.HZ(paramMPCollapseTextLayout.mViewWidth);
    }
  }
  
  private final void a(com.tencent.neattextview.textview.layout.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7376);
    if (this.vZa)
    {
      parama = this.vNg;
      if (parama != null) {
        parama.setVisibility(8);
      }
      AppMethodBeat.o(7376);
      return;
    }
    if (parama == null)
    {
      AppMethodBeat.o(7376);
      return;
    }
    this.vYR = true;
    TextView localTextView = this.vNg;
    if (localTextView != null) {
      localTextView.setText((CharSequence)this.vZd);
    }
    localTextView = this.vNg;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    float f = parama.aGL(paramInt2 - 1);
    Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo expandText textWidth: %d, realLines: %d, maxLines: %d, last line right: %f", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.vYT), Float.valueOf(f) });
    parama = this.vNg;
    if (parama == null)
    {
      parama = null;
      if ((!(parama instanceof RelativeLayout.LayoutParams)) || (d(f, paramInt1))) {
        break label243;
      }
      Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo expandText collapseButton show be at below");
      ((RelativeLayout.LayoutParams)parama).removeRule(12);
      ((RelativeLayout.LayoutParams)parama).removeRule(3);
      parama = (RelativeLayout.LayoutParams)parama;
      if (!this.vZb) {
        break label236;
      }
    }
    label236:
    for (paramInt1 = d.e.content_tv_for_special;; paramInt1 = d.e.content_tv)
    {
      parama.addRule(3, paramInt1);
      AppMethodBeat.o(7376);
      return;
      parama = parama.getLayoutParams();
      break;
    }
    label243:
    if ((parama instanceof RelativeLayout.LayoutParams))
    {
      ((RelativeLayout.LayoutParams)parama).removeRule(3);
      ((RelativeLayout.LayoutParams)parama).addRule(12);
    }
    AppMethodBeat.o(7376);
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, MPCollapseTextLayout.a parama)
  {
    AppMethodBeat.i(7374);
    Object localObject = this.vYV;
    int i;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label205;
      }
      i = 0;
      label28:
      Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo processContent width: %d, line: %d, specialText: %b, expand: %b, enableExpand: %b, hashCode: %d", new Object[] { Integer.valueOf(this.mViewWidth), Integer.valueOf(i), Boolean.valueOf(this.vZb), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(hashCode()) });
      dhY();
      if (i <= this.vYT) {
        break label228;
      }
      if (!paramBoolean1) {
        Ia(this.vYT);
      }
      TextView localTextView = this.vNg;
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      if (!paramBoolean1) {
        break label217;
      }
      a((com.tencent.neattextview.textview.layout.a)localObject, this.mViewWidth, i);
    }
    for (;;)
    {
      if (!paramBoolean2) {
        break label249;
      }
      localObject = this.vNg;
      if (localObject == null) {
        break label249;
      }
      ((TextView)localObject).setOnClickListener(new MPCollapseTextLayout..ExternalSyntheticLambda0(this, i, parama));
      AppMethodBeat.o(7374);
      return;
      localObject = ((MMNeat7extView)localObject).pE(this.mViewWidth, 2147483647);
      break;
      label205:
      i = ((com.tencent.neattextview.textview.layout.a)localObject).jQH();
      break label28;
      label217:
      HZ(this.mViewWidth);
    }
    label228:
    Ia(2147483647);
    parama = this.vNg;
    if (parama != null) {
      parama.setVisibility(8);
    }
    label249:
    AppMethodBeat.o(7374);
  }
  
  private static final void b(MPCollapseTextLayout paramMPCollapseTextLayout)
  {
    AppMethodBeat.i(301721);
    s.u(paramMPCollapseTextLayout, "this$0");
    paramMPCollapseTextLayout = paramMPCollapseTextLayout.vYV;
    if (paramMPCollapseTextLayout != null) {
      paramMPCollapseTextLayout.requestLayout();
    }
    AppMethodBeat.o(301721);
  }
  
  private static final void c(MPCollapseTextLayout paramMPCollapseTextLayout)
  {
    AppMethodBeat.i(301723);
    s.u(paramMPCollapseTextLayout, "this$0");
    Log.d("MicroMsg.MPCollapseTextLayout", "alvinluo collapseSpeicalText");
    Object localObject = paramMPCollapseTextLayout.vYW;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = paramMPCollapseTextLayout.vYW;
    if (localObject != null) {
      ((TextView)localObject).setMaxLines(paramMPCollapseTextLayout.vYT);
    }
    localObject = paramMPCollapseTextLayout.vYW;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)paramMPCollapseTextLayout.mContent);
    }
    localObject = paramMPCollapseTextLayout.vNg;
    if (localObject != null) {
      ((TextView)localObject).setPadding(0, 0, 0, 0);
    }
    localObject = paramMPCollapseTextLayout.vYV;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setVisibility(8);
    }
    localObject = paramMPCollapseTextLayout.vNg;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((TextView)localObject).getLayoutParams())
    {
      if ((localObject != null) && ((localObject instanceof RelativeLayout.LayoutParams)))
      {
        ((RelativeLayout.LayoutParams)localObject).removeRule(12);
        ((RelativeLayout.LayoutParams)localObject).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject).addRule(3, d.e.content_tv_for_special);
      }
      paramMPCollapseTextLayout = paramMPCollapseTextLayout.vNg;
      if (paramMPCollapseTextLayout != null)
      {
        paramMPCollapseTextLayout = paramMPCollapseTextLayout.getParent();
        if (paramMPCollapseTextLayout != null) {
          paramMPCollapseTextLayout.requestLayout();
        }
      }
      AppMethodBeat.o(301723);
      return;
    }
  }
  
  private final boolean d(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(7379);
    Object localObject = this.vNg;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label90;
      }
    }
    label90:
    for (int i = this.vYY;; i = ((Integer)localObject).intValue())
    {
      this.vYX = i;
      float f = paramInt - this.vYX;
      if (this.vZb) {
        f = paramInt * 3.0F / 4.0F;
      }
      if (paramFloat >= f) {
        break label100;
      }
      AppMethodBeat.o(7379);
      return true;
      localObject = Integer.valueOf(((TextView)localObject).getMeasuredWidth());
      break;
    }
    label100:
    AppMethodBeat.o(7379);
    return false;
  }
  
  private final void dhX()
  {
    AppMethodBeat.i(7369);
    setClipChildren(false);
    setClipToPadding(false);
    Object localObject = af.mU(this.mContext).inflate(d.f.layout_mp_collapse_text, (ViewGroup)this);
    this.vYV = ((MMNeat7extView)((View)localObject).findViewById(d.e.content_tv));
    this.vNg = ((TextView)((View)localObject).findViewById(d.e.collapse_button_tv));
    this.vYW = ((TextView)((View)localObject).findViewById(d.e.content_tv_for_special));
    localObject = this.vNg;
    if (localObject != null) {
      ((TextView)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    this.vYY = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 30);
    localObject = this.vNg;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label237;
      }
    }
    label237:
    for (int i = this.vYY;; i = ((Integer)localObject).intValue())
    {
      this.vYX = i;
      this.vZc = ((int)(com.tencent.mm.cd.a.getDensity(this.mContext) * 2.5F));
      this.vYZ = getResources().getDimensionPixelSize(d.c.SmallestPadding);
      localObject = this.mContext.getResources().getString(d.i.biz_time_line_item_text_collapse);
      s.s(localObject, "mContext.resources.getSt…_line_item_text_collapse)");
      this.vZd = ((String)localObject);
      localObject = this.mContext.getResources().getString(d.i.biz_time_line_item_text_more);
      s.s(localObject, "mContext.resources.getSt…time_line_item_text_more)");
      this.vZe = ((String)localObject);
      AppMethodBeat.o(7369);
      return;
      localObject = Integer.valueOf(((TextView)localObject).getMeasuredWidth());
      break;
    }
  }
  
  private final void dhY()
  {
    AppMethodBeat.i(7378);
    Object localObject;
    if (!this.vZb)
    {
      localObject = this.vYV;
      if (localObject != null) {
        ((MMNeat7extView)localObject).setVisibility(0);
      }
      localObject = this.vYW;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.vNg;
      if (localObject != null)
      {
        ((TextView)localObject).setPadding(0, 0, 0, this.vZc);
        AppMethodBeat.o(7378);
      }
    }
    else
    {
      localObject = this.vYV;
      if (localObject != null) {
        ((MMNeat7extView)localObject).setVisibility(8);
      }
      localObject = this.vYW;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.vNg;
      if (localObject != null) {
        ((TextView)localObject).setPadding(0, 0, 0, 0);
      }
    }
    AppMethodBeat.o(7378);
  }
  
  public final TextView getCollapseButton()
  {
    return this.vNg;
  }
  
  public final MMNeat7extView getContextTextView()
  {
    return this.vYV;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7370);
    super.onMeasure(paramInt1, paramInt2);
    Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo onMeasure width: %d, viewWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.mViewWidth) });
    if (this.mViewWidth != getMeasuredWidth())
    {
      this.mViewWidth = getMeasuredWidth();
      if (this.vZf)
      {
        Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo onMeasure needProcessContent");
        this.vZf = false;
        a(this.vYR, this.vYS, this.vYU);
      }
    }
    AppMethodBeat.o(7370);
  }
  
  public final void setCollapseButtonHideWhenExpanded(boolean paramBoolean)
  {
    this.vZa = paramBoolean;
  }
  
  public final void setCollapseText(String paramString)
  {
    AppMethodBeat.i(7371);
    s.u(paramString, "collapseText");
    this.vZd = paramString;
    AppMethodBeat.o(7371);
  }
  
  public final void setContent(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(7373);
    s.u(paramCharSequence, "content");
    s.u(paramCharSequence, "content");
    s.u(paramCharSequence, "content");
    if ((this.mContent.equals(paramCharSequence)) && (!this.vYR) && (!this.vYS))
    {
      Log.v("MicroMsg.MPCollapseTextLayout", "alvinluo setContent ignore %s", new Object[] { this.mContent, paramCharSequence });
      AppMethodBeat.o(7373);
      return;
    }
    this.mContent = paramCharSequence.toString();
    Object localObject = this.vYV;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setMaxLines(this.vYT);
    }
    localObject = this.vYV;
    if (localObject != null) {
      ((MMNeat7extView)localObject).aZ(paramCharSequence);
    }
    localObject = this.vYW;
    if (localObject != null) {
      ((TextView)localObject).setMaxLines(this.vYT);
    }
    localObject = this.vYW;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    paramCharSequence = this.vYV;
    if (paramCharSequence == null) {}
    for (boolean bool = false;; bool = paramCharSequence.vZb)
    {
      this.vZb = bool;
      this.vYR = false;
      this.vYS = false;
      this.vYU = null;
      if (this.vZg != null)
      {
        paramCharSequence = this.vYV;
        if (paramCharSequence != null) {
          paramCharSequence.removeCallbacks(this.vZg);
        }
      }
      if (this.mViewWidth == 0) {
        break;
      }
      this.vZf = false;
      a(false, false, null);
      AppMethodBeat.o(7373);
      return;
    }
    this.vZf = true;
    AppMethodBeat.o(7373);
  }
  
  public final void setEnableExpand(boolean paramBoolean)
  {
    this.vYS = paramBoolean;
  }
  
  public final void setExpandText(String paramString)
  {
    AppMethodBeat.i(7372);
    s.u(paramString, "expandText");
    this.vZe = paramString;
    AppMethodBeat.o(7372);
  }
  
  public final void setMaxLines(int paramInt)
  {
    this.vYT = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPCollapseTextLayout
 * JD-Core Version:    0.7.0.1
 */