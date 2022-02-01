package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.e.j;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/CollapsibleTextView;", "Lcom/tencent/mm/plugin/finder/view/FlowTextMixView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "collapseMaxLines", "ellipsizedTextView", "Lcom/tencent/mm/plugin/finder/view/EllipsizedTextView;", "expandLeftPadding", "getExpandLeftPadding", "()I", "setExpandLeftPadding", "(I)V", "expandTextView", "Landroid/widget/TextView;", "isBtnVisible", "", "()Z", "setBtnVisible", "(Z)V", "value", "isExpand", "setExpand", "isRealExpand", "onExpandBtnClickListener", "Lkotlin/Function0;", "", "getOnExpandBtnClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnExpandBtnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onExpandStateChangeListener", "Lkotlin/Function2;", "getOnExpandStateChangeListener", "()Lkotlin/jvm/functions/Function2;", "setOnExpandStateChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "checkExpandTextViewVisible", "getContentTextView", "initView", "measureEllipseText", "", "onExpandStateChange", "isFirstTime", "refreshEllipsizedTextView", "setTextColor", "contentColor", "foldColor", "tryInitAttrs", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CollapsibleTextView
  extends FlowTextMixView
{
  private kotlin.g.a.a<ah> GwA;
  private int GwB;
  private EllipsizedTextView Gwv;
  private TextView Gww;
  public boolean Gwx;
  private boolean Gwy;
  private m<? super Boolean, ? super Boolean, ah> Gwz;
  private CharSequence bba;
  private int collapseMaxLines;
  
  public CollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345079);
    this.collapseMaxLines = 2147483647;
    this.GwB = com.tencent.mm.cd.a.fromDPToPix(getContext(), 4);
    b(paramContext, paramAttributeSet);
    this.Gwv = new EllipsizedTextView(paramContext, paramAttributeSet);
    this.Gww = new TextView(paramContext, paramAttributeSet);
    initView();
    AppMethodBeat.o(345079);
  }
  
  public CollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345088);
    this.collapseMaxLines = 2147483647;
    this.GwB = com.tencent.mm.cd.a.fromDPToPix(getContext(), 4);
    b(paramContext, paramAttributeSet);
    this.Gwv = new EllipsizedTextView(paramContext, paramAttributeSet, paramInt);
    this.Gww = new TextView(paramContext, paramAttributeSet, paramInt);
    initView();
    AppMethodBeat.o(345088);
  }
  
  private static final void a(CollapsibleTextView paramCollapsibleTextView, View paramView)
  {
    AppMethodBeat.i(345144);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramCollapsibleTextView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/CollapsibleTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramCollapsibleTextView, "this$0");
    paramView = paramCollapsibleTextView.getOnExpandBtnClickListener();
    if (paramView != null) {
      paramView.invoke();
    }
    if (!paramCollapsibleTextView.Gwx) {}
    for (boolean bool = true;; bool = false)
    {
      paramCollapsibleTextView.setExpand(bool);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/CollapsibleTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345144);
      return;
    }
  }
  
  private static final void a(CollapsibleTextView paramCollapsibleTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(345135);
    s.u(paramCollapsibleTextView, "this$0");
    m localm = paramCollapsibleTextView.getOnExpandStateChangeListener();
    if (localm != null) {
      localm.invoke(Boolean.valueOf(paramBoolean), Boolean.valueOf(paramCollapsibleTextView.fke()));
    }
    AppMethodBeat.o(345135);
  }
  
  private final void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(345101);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, e.j.CollapsibleTextView);
    s.s(paramContext, "context.obtainStyledAttr…able.CollapsibleTextView)");
    try
    {
      this.collapseMaxLines = paramContext.getInt(e.j.CollapsibleTextView_collapseMaxLines, 2147483647);
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(345101);
    }
  }
  
  private static final void b(CollapsibleTextView paramCollapsibleTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(345153);
    s.u(paramCollapsibleTextView, "this$0");
    Object localObject = paramCollapsibleTextView.Gwv.getLayout();
    if (localObject == null)
    {
      AppMethodBeat.o(345153);
      return;
    }
    float f1 = ((Layout)localObject).getPrimaryHorizontal(((Layout)localObject).getOffsetForHorizontal(k.qv(((Layout)localObject).getLineCount(), paramCollapsibleTextView.Gwv.getMaxLines()) - 1, 3.4028235E+38F));
    float f2 = paramCollapsibleTextView.Gwv.getExtraEllipsizeWidth();
    TextPaint localTextPaint = paramCollapsibleTextView.Gww.getPaint();
    if (paramBoolean) {}
    for (localObject = paramCollapsibleTextView.getContext().getString(e.h.collapse);; localObject = paramCollapsibleTextView.getContext().getString(e.h.finder_all_text))
    {
      float f3 = localTextPaint.measureText((String)localObject);
      float f4 = paramCollapsibleTextView.getExpandLeftPadding();
      paramCollapsibleTextView.fkf();
      if ((f3 + (f2 + f1) <= paramCollapsibleTextView.getWidth()) || (paramCollapsibleTextView.Gww.getVisibility() != 0)) {
        break;
      }
      paramCollapsibleTextView.Gwv.setExtraEllipsizeWidth((int)(1.2F * f3 + f4));
      AppMethodBeat.o(345153);
      return;
    }
    paramCollapsibleTextView.Gwv.setExtraEllipsizeWidth(0);
    AppMethodBeat.o(345153);
  }
  
  private final boolean fkf()
  {
    AppMethodBeat.i(345121);
    Object localObject = this.Gwv.getLayout();
    int j;
    boolean bool;
    for (;;)
    {
      try
      {
        i = k.qv(this.collapseMaxLines, ((Layout)localObject).getLineCount()) - 1;
        if (i < 0) {
          continue;
        }
        i = ((Layout)localObject).getOffsetForHorizontal(i, 10000.0F);
      }
      catch (Exception localException)
      {
        int k;
        Layout localLayout;
        label124:
        if (!BuildInfo.DEBUG) {
          continue;
        }
        AppMethodBeat.o(345121);
        throw localException;
        i = 0;
        continue;
        j = ((CharSequence)localObject).length();
        continue;
        m = localException.getLineCount();
        if (m <= 0) {
          break label220;
        }
      }
      k = this.Gww.getVisibility();
      if ((localObject != null) && (i > 0))
      {
        localObject = this.Gwv.getText();
        if (localObject != null) {
          continue;
        }
        j = 0;
        if (i < j) {}
      }
      else
      {
        localObject = this.Gwv;
        if (((EllipsizedTextView)localObject).getEllipsize() == null) {
          break label220;
        }
        localLayout = ((EllipsizedTextView)localObject).getLayout();
        if (localLayout != null) {
          continue;
        }
        bool = false;
        if (!bool) {
          break label230;
        }
      }
      this.Gww.setVisibility(0);
      if (k == this.Gww.getVisibility()) {
        break label242;
      }
      AppMethodBeat.o(345121);
      return true;
      i = 0;
    }
    int m;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (localException.getEllipsisCount(i) > 0)
      {
        bool = true;
        break;
      }
      if (j >= m)
      {
        label220:
        bool = ((EllipsizedTextView)localObject).GwI;
        break;
        label230:
        this.Gww.setVisibility(8);
        break label124;
        label242:
        AppMethodBeat.o(345121);
        return false;
      }
    }
  }
  
  private final void initView()
  {
    AppMethodBeat.i(345113);
    Object localObject = this.Gwv;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    this.Gwv.setLayoutParams(localLayoutParams);
    ((EllipsizedTextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((EllipsizedTextView)localObject).setMaxLines(this.collapseMaxLines);
    ((EllipsizedTextView)localObject).setTextColor(((EllipsizedTextView)localObject).getContext().getResources().getColor(e.b.FG_1));
    ((EllipsizedTextView)localObject).setTextSize(0, ((EllipsizedTextView)localObject).getContext().getResources().getDimension(e.c.SmallTextSize) * com.tencent.mm.cd.a.getScaleSize(((EllipsizedTextView)localObject).getContext()));
    addView((View)this.Gwv);
    localObject = this.Gww;
    localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    this.Gww.setLayoutParams(localLayoutParams);
    ((TextView)localObject).setTextColor(((TextView)localObject).getContext().getResources().getColor(e.b.Link_100));
    ((TextView)localObject).setTextSize(0, ((TextView)localObject).getContext().getResources().getDimension(e.c.SmallTextSize) * com.tencent.mm.cd.a.getScaleSize(((TextView)localObject).getContext()));
    ((TextView)localObject).setPadding(getExpandLeftPadding(), 0, 0, 0);
    this.Gww.setVisibility(8);
    addView((View)this.Gww);
    uO(false);
    this.Gww.setOnClickListener(new CollapsibleTextView..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(345113);
  }
  
  private void uO(boolean paramBoolean)
  {
    AppMethodBeat.i(345093);
    this.Gwx = paramBoolean;
    uP(paramBoolean);
    AppMethodBeat.o(345093);
  }
  
  private final void uP(boolean paramBoolean)
  {
    AppMethodBeat.i(345108);
    if (paramBoolean)
    {
      this.Gww.setText(e.h.collapse);
      this.Gwv.setMaxLines(2147483647);
    }
    for (;;)
    {
      uQ(paramBoolean);
      this.Gwv.post(new CollapsibleTextView..ExternalSyntheticLambda2(this, paramBoolean));
      AppMethodBeat.o(345108);
      return;
      this.Gww.setText(e.h.finder_all_text);
      this.Gwv.setMaxLines(this.collapseMaxLines);
    }
  }
  
  private final void uQ(boolean paramBoolean)
  {
    AppMethodBeat.i(345128);
    this.Gwv.post(new CollapsibleTextView..ExternalSyntheticLambda1(this, paramBoolean));
    AppMethodBeat.o(345128);
  }
  
  public final int aCB(String paramString)
  {
    AppMethodBeat.i(345247);
    s.u(paramString, "text");
    int i = (int)this.Gwv.getPaint().measureText(paramString);
    AppMethodBeat.o(345247);
    return i;
  }
  
  public final boolean fke()
  {
    AppMethodBeat.i(345209);
    if (this.Gww.getVisibility() == 0)
    {
      AppMethodBeat.o(345209);
      return true;
    }
    AppMethodBeat.o(345209);
    return false;
  }
  
  public final EllipsizedTextView getContentTextView()
  {
    return this.Gwv;
  }
  
  public final int getExpandLeftPadding()
  {
    return this.GwB;
  }
  
  public final kotlin.g.a.a<ah> getOnExpandBtnClickListener()
  {
    return this.GwA;
  }
  
  public final m<Boolean, Boolean, ah> getOnExpandStateChangeListener()
  {
    return this.Gwz;
  }
  
  public final CharSequence getText()
  {
    AppMethodBeat.i(345196);
    CharSequence localCharSequence = this.Gwv.getText();
    AppMethodBeat.o(345196);
    return localCharSequence;
  }
  
  public final void iD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(345253);
    this.Gwv.setTextColor(paramInt1);
    this.Gww.setTextColor(paramInt2);
    AppMethodBeat.o(345253);
  }
  
  public final void setBtnVisible(boolean paramBoolean)
  {
    this.Gwy = paramBoolean;
  }
  
  public final void setExpand(boolean paramBoolean)
  {
    AppMethodBeat.i(345189);
    uO(paramBoolean);
    AppMethodBeat.o(345189);
  }
  
  public final void setExpandLeftPadding(int paramInt)
  {
    this.GwB = paramInt;
  }
  
  public final void setOnExpandBtnClickListener(kotlin.g.a.a<ah> parama)
  {
    this.GwA = parama;
  }
  
  public final void setOnExpandStateChangeListener(m<? super Boolean, ? super Boolean, ah> paramm)
  {
    this.Gwz = paramm;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(345203);
    if (!s.p(this.bba, paramCharSequence))
    {
      this.bba = paramCharSequence;
      this.Gwv.setText(paramCharSequence);
      uQ(this.Gwx);
    }
    AppMethodBeat.o(345203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.CollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */