package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.viewmodel.d;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderCollapsibleTextView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "collapseTextView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getCollapseTextView", "()Landroid/widget/TextView;", "collapseTextView$delegate", "Lkotlin/Lazy;", "collapseTextViewRight", "", "getCollapseTextViewRight", "()F", "setCollapseTextViewRight", "(F)V", "collapseTextWidth", "contentTextView", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getContentTextView", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "contentTextView$delegate", "expanText", "getExpanText", "()I", "setExpanText", "(I)V", "extraView", "Landroid/view/View;", "getExtraView", "()Landroid/view/View;", "setExtraView", "(Landroid/view/View;)V", "value", "", "isCollapse", "()Z", "setCollapse", "(Z)V", "isTopicExpand", "setTopicExpand", "limitLine", "getLimitLine", "setLimitLine", "onCollapse", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnCollapse", "()Lkotlin/jvm/functions/Function1;", "setOnCollapse", "(Lkotlin/jvm/functions/Function1;)V", "realContent", "", "getRealContent", "()Ljava/lang/CharSequence;", "setRealContent", "(Ljava/lang/CharSequence;)V", "text", "getText", "setText", "textColor", "getTextColor", "setTextColor", "textSize", "getTextSize", "setTextSize", "_setText", "content", "callBack", "backToDefaultLogic", "source", "", "checkCollapseVisible", "checkCollapseVisibleSync", "checkIfAllRestTextTopic", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "enableContentTextViewClick", "enable", "onClickFun", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refresh", "refreshCollapseText", "tryExpand", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderCollapsibleTextView
  extends RelativeLayout
{
  public static final FinderCollapsibleTextView.a Gxr;
  private kotlin.g.a.b<? super Boolean, ah> GxA;
  private int GxB;
  private CharSequence GxC;
  private final j Gxs;
  private final j Gxt;
  private float Gxu;
  private int Gxv;
  private View Gxw;
  private boolean Gxx;
  private boolean Gxy;
  private float Gxz;
  private CharSequence bba;
  
  static
  {
    AppMethodBeat.i(168229);
    Gxr = new FinderCollapsibleTextView.a((byte)0);
    AppMethodBeat.o(168229);
  }
  
  public FinderCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168241);
    this.Gxs = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.Gxt = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.Gxv = e.h.finder_all_text;
    af.mU(getContext()).inflate(e.f.finder_collapsible_layout, (ViewGroup)this, true);
    getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
    getContentTextView().setOnTouchListener((View.OnTouchListener)new l(getContentTextView(), (View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s()));
    uT(true);
    getCollapseTextView().setOnClickListener(new FinderCollapsibleTextView..ExternalSyntheticLambda0(this));
    this.Gxy = true;
    this.GxB = 3;
    AppMethodBeat.o(168241);
  }
  
  public FinderCollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168242);
    this.Gxs = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.Gxt = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.Gxv = e.h.finder_all_text;
    af.mU(getContext()).inflate(e.f.finder_collapsible_layout, (ViewGroup)this, true);
    getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
    getContentTextView().setOnTouchListener((View.OnTouchListener)new l(getContentTextView(), (View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s()));
    uT(true);
    getCollapseTextView().setOnClickListener(new FinderCollapsibleTextView..ExternalSyntheticLambda0(this));
    this.Gxy = true;
    this.GxB = 3;
    AppMethodBeat.o(168242);
  }
  
  private static final void a(View paramView, FinderCollapsibleTextView paramFinderCollapsibleTextView, CharSequence paramCharSequence, kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(345154);
    kotlin.g.b.s.u(paramFinderCollapsibleTextView, "this$0");
    kotlin.g.b.s.u(paramb, "$callBack");
    int i = paramView.getWidth();
    if (i > 0) {
      paramFinderCollapsibleTextView.getContentTextView().setLineEndExtraWidths(new float[] { i });
    }
    paramFinderCollapsibleTextView.setText(paramCharSequence);
    paramb.invoke(Boolean.valueOf(paramFinderCollapsibleTextView.getContentTextView().vZb));
    paramView = z.FrZ;
    paramView = paramFinderCollapsibleTextView.getContext();
    kotlin.g.b.s.s(paramView, "context");
    z.a(paramView, true, 0, paramFinderCollapsibleTextView.Gxy, paramFinderCollapsibleTextView.Gxx);
    AppMethodBeat.o(345154);
  }
  
  private static final void a(FinderCollapsibleTextView paramFinderCollapsibleTextView)
  {
    AppMethodBeat.i(345131);
    kotlin.g.b.s.u(paramFinderCollapsibleTextView, "this$0");
    for (;;)
    {
      try
      {
        ah.d locald = new ah.d();
        locald.aixb = paramFinderCollapsibleTextView.getContentTextView().getLayout().H(paramFinderCollapsibleTextView.getLimitLine() - 1, 3.4028235E+38F);
        float f1 = paramFinderCollapsibleTextView.getContentTextView().getLayout().dv(locald.aixb);
        int j = paramFinderCollapsibleTextView.getContentTextView().getWidth();
        if (paramFinderCollapsibleTextView.Gxz == 0.0F)
        {
          i = 1;
          if (i != 0) {
            paramFinderCollapsibleTextView.Gxz = paramFinderCollapsibleTextView.getCollapseTextView().getPaint().measureText(paramFinderCollapsibleTextView.getContext().getResources().getString(e.h.finder_all_text));
          }
          float f2 = paramFinderCollapsibleTextView.Gxz + 3.0F;
          if ((paramFinderCollapsibleTextView.getContentTextView().vZb) && (j - f1 <= f2))
          {
            paramFinderCollapsibleTextView.aCC("#1");
            AppMethodBeat.o(345131);
            return;
          }
          if (f1 + f2 > j)
          {
            paramFinderCollapsibleTextView.getContentTextView().a(TextUtils.TruncateAt.END, f2);
            paramFinderCollapsibleTextView.post(new FinderCollapsibleTextView..ExternalSyntheticLambda12(locald, paramFinderCollapsibleTextView, f2, j));
            AppMethodBeat.o(345131);
            return;
          }
          if (paramFinderCollapsibleTextView.getContentTextView().getExtraEllipsizeWidth() > 0.0F) {
            continue;
          }
          paramFinderCollapsibleTextView.getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
          continue;
        }
        int i = 0;
      }
      catch (Exception localException)
      {
        paramFinderCollapsibleTextView.aCC(kotlin.g.b.s.X("#2:Exception:", localException.getMessage()));
        AppMethodBeat.o(345131);
        return;
      }
    }
  }
  
  private static final void a(FinderCollapsibleTextView paramFinderCollapsibleTextView, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(345198);
    kotlin.g.b.s.u(paramFinderCollapsibleTextView, "this$0");
    paramContextMenu.add(0, 0, 0, (CharSequence)paramFinderCollapsibleTextView.getContext().getString(e.h.app_copy));
    AppMethodBeat.o(345198);
  }
  
  private static final void a(FinderCollapsibleTextView paramFinderCollapsibleTextView, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(345175);
    kotlin.g.b.s.u(paramFinderCollapsibleTextView, "this$0");
    if (paramInt == 0) {
      ClipboardHelper.setText(paramFinderCollapsibleTextView.getContentTextView().jPy());
    }
    AppMethodBeat.o(345175);
  }
  
  private static final void a(FinderCollapsibleTextView paramFinderCollapsibleTextView, View paramView)
  {
    AppMethodBeat.i(345114);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderCollapsibleTextView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderCollapsibleTextView, "this$0");
    paramFinderCollapsibleTextView.fkl();
    paramView = z.FrZ;
    paramView = paramFinderCollapsibleTextView.getContext();
    kotlin.g.b.s.s(paramView, "context");
    z.a(paramView, false, 1, paramFinderCollapsibleTextView.Gxy, paramFinderCollapsibleTextView.Gxx);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345114);
  }
  
  private static final void a(FinderCollapsibleTextView paramFinderCollapsibleTextView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(345146);
    kotlin.g.b.s.u(paramFinderCollapsibleTextView, "this$0");
    kotlin.g.b.s.u(paramCharSequence, "$it");
    Log.i("Finder.CollapsibleTextView", kotlin.g.b.s.X("[checkIfAllRestTextTopic] start timeStamp:", Long.valueOf(System.currentTimeMillis())));
    try
    {
      i = paramFinderCollapsibleTextView.getContentTextView().getLayout().dk(paramFinderCollapsibleTextView.getLimitLine() - 1);
      j = paramFinderCollapsibleTextView.getContentTextView().getLayout().aGM(paramFinderCollapsibleTextView.getLimitLine() - 1);
      i = i + j + 2;
    }
    catch (Exception localException)
    {
      int i;
      for (;;)
      {
        Log.i("Finder.CollapsibleTextView", kotlin.g.b.s.X("[checkIfAllRestTextTopic] ", localException.getMessage()));
        i = -1;
      }
      CharSequence localCharSequence = paramCharSequence.subSequence(i, paramCharSequence.length());
      if ((!(paramCharSequence instanceof SpannableString)) || (i <= 0)) {
        break label380;
      }
      int k = 0;
      int j = 0;
      for (boolean bool1 = true;; bool1 = bool2)
      {
        bool2 = bool1;
        if (k >= localCharSequence.length()) {
          break;
        }
        int m = localCharSequence.charAt(k);
        bool2 = bool1;
        if (m != 32)
        {
          bool2 = bool1;
          if (m != 10)
          {
            Object localObject = (q[])((SpannableString)paramCharSequence).getSpans(j + i, j + i, q.class);
            if (localObject != null)
            {
              if (localObject.length == 0)
              {
                m = 1;
                if (m == 0) {
                  break label342;
                }
              }
            }
            else {
              m = 1;
            }
            for (;;)
            {
              if (m == 0)
              {
                localObject = localObject[0];
                if (localObject == null)
                {
                  paramFinderCollapsibleTextView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.FinderTextClickSpan");
                  AppMethodBeat.o(345146);
                  throw paramFinderCollapsibleTextView;
                  m = 0;
                  break;
                  label342:
                  m = 0;
                  continue;
                }
                bool2 = bool1;
                if (((q)localObject).GDg) {
                  break label363;
                }
              }
            }
            bool2 = false;
          }
        }
        label363:
        k += 1;
        j += 1;
      }
      label380:
      bool2 = false;
      if (!bool2) {
        break label437;
      }
    }
    if ((i < 0) || (i > paramCharSequence.length()))
    {
      Log.i("Finder.CollapsibleTextView", "[checkIfAllRestTextTopic] offset:" + i + " , length:" + paramCharSequence.length() + ",text:" + paramCharSequence);
      AppMethodBeat.o(345146);
      return;
    }
    boolean bool2;
    paramFinderCollapsibleTextView.setExpanText(e.h.finder_collpase_topic);
    for (;;)
    {
      paramFinderCollapsibleTextView.getCollapseTextView().setText(paramFinderCollapsibleTextView.getExpanText());
      paramFinderCollapsibleTextView.setTopicExpand(bool2);
      Log.i("Finder.CollapsibleTextView", kotlin.g.b.s.X("[checkIfAllRestTextTopic] end timeStamp:", Long.valueOf(System.currentTimeMillis())));
      AppMethodBeat.o(345146);
      return;
      label437:
      paramFinderCollapsibleTextView.setExpanText(e.h.finder_all_text);
    }
  }
  
  private static final void a(ah.d paramd, FinderCollapsibleTextView paramFinderCollapsibleTextView, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(345123);
    kotlin.g.b.s.u(paramd, "$offset");
    kotlin.g.b.s.u(paramFinderCollapsibleTextView, "this$0");
    paramd.aixb = paramFinderCollapsibleTextView.getContentTextView().getLayout().H(paramFinderCollapsibleTextView.getLimitLine() - 1, 3.4028235E+38F);
    float f1 = paramFinderCollapsibleTextView.getContentTextView().getLayout().dv(paramd.aixb);
    float f2 = paramFinderCollapsibleTextView.getCollapseTextView().getPaint().measureText("…");
    paramFinderCollapsibleTextView.setCollapseTextViewRight(paramInt - (f1 + paramFloat + f2));
    paramFinderCollapsibleTextView.setCollapseTextViewRight(kotlin.k.k.bt(0.0F, paramFinderCollapsibleTextView.getCollapseTextViewRight()));
    paramd = paramFinderCollapsibleTextView.getCollapseTextView().getLayoutParams();
    if (paramd == null)
    {
      paramd = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(345123);
      throw paramd;
    }
    paramd = (RelativeLayout.LayoutParams)paramd;
    paramd.setMarginEnd((int)paramFinderCollapsibleTextView.getCollapseTextViewRight());
    paramFinderCollapsibleTextView.getCollapseTextView().setLayoutParams((ViewGroup.LayoutParams)paramd);
    paramFinderCollapsibleTextView.fkm();
    AppMethodBeat.o(345123);
  }
  
  private final void aCC(String paramString)
  {
    AppMethodBeat.i(345090);
    Log.i("Finder.CollapsibleTextView", kotlin.g.b.s.X("go to defaule logic,source:", paramString));
    getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
    paramString = getCollapseTextView().getLayoutParams();
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(345090);
      throw paramString;
    }
    paramString = (RelativeLayout.LayoutParams)paramString;
    paramString.removeRule(11);
    paramString.removeRule(8);
    paramString.addRule(3, e.e.collapse_content_tv);
    paramString.addRule(5, e.e.collapse_content_tv);
    paramString.setMarginEnd(0);
    getCollapseTextView().setLayoutParams((ViewGroup.LayoutParams)paramString);
    fkm();
    AppMethodBeat.o(345090);
  }
  
  private static final void b(FinderCollapsibleTextView paramFinderCollapsibleTextView)
  {
    AppMethodBeat.i(345160);
    kotlin.g.b.s.u(paramFinderCollapsibleTextView, "this$0");
    Log.i("Finder.CollapsibleTextView", "post refresh");
    paramFinderCollapsibleTextView.uS(paramFinderCollapsibleTextView.Gxy);
    AppMethodBeat.o(345160);
  }
  
  private static final void b(FinderCollapsibleTextView paramFinderCollapsibleTextView, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(345204);
    kotlin.g.b.s.u(paramFinderCollapsibleTextView, "this$0");
    if (paramInt == 0)
    {
      if (paramFinderCollapsibleTextView.getRealContent() == null)
      {
        ClipboardHelper.setText(paramFinderCollapsibleTextView.getContentTextView().jPy());
        AppMethodBeat.o(345204);
        return;
      }
      ClipboardHelper.setText(paramFinderCollapsibleTextView.getRealContent());
    }
    AppMethodBeat.o(345204);
  }
  
  private static final boolean b(FinderCollapsibleTextView paramFinderCollapsibleTextView, View paramView)
  {
    AppMethodBeat.i(345213);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderCollapsibleTextView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramFinderCollapsibleTextView, "this$0");
    try
    {
      paramView = new com.tencent.mm.ui.widget.b.a(paramFinderCollapsibleTextView.getContext());
      paramView.GAC = new FinderCollapsibleTextView..ExternalSyntheticLambda6(paramFinderCollapsibleTextView);
      paramView.afLp = new FinderCollapsibleTextView..ExternalSyntheticLambda4(paramFinderCollapsibleTextView);
      paramFinderCollapsibleTextView.getContentTextView().setBackgroundResource(e.b.list_devider_color);
      localObject1 = (View)paramFinderCollapsibleTextView.getContentTextView();
      localObject2 = new FinderCollapsibleTextView..ExternalSyntheticLambda2(paramFinderCollapsibleTextView);
      paramFinderCollapsibleTextView = new FinderCollapsibleTextView..ExternalSyntheticLambda5(paramFinderCollapsibleTextView);
      TouchableLayout.a locala = TouchableLayout.agKp;
      int i = TouchableLayout.jMn();
      locala = TouchableLayout.agKp;
      paramView.a((View)localObject1, (View.OnCreateContextMenuListener)localObject2, paramFinderCollapsibleTextView, i, TouchableLayout.jMo());
      com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(345213);
      return true;
    }
    catch (Exception paramFinderCollapsibleTextView)
    {
      for (;;)
      {
        Log.i("Finder.CollapsibleTextView", kotlin.g.b.s.X("[enableContentTextViewClick] errMsg:", paramFinderCollapsibleTextView.getMessage()));
      }
    }
  }
  
  private static final void c(FinderCollapsibleTextView paramFinderCollapsibleTextView)
  {
    AppMethodBeat.i(345167);
    kotlin.g.b.s.u(paramFinderCollapsibleTextView, "this$0");
    paramFinderCollapsibleTextView.uS(paramFinderCollapsibleTextView.Gxy);
    AppMethodBeat.o(345167);
  }
  
  private static final void c(FinderCollapsibleTextView paramFinderCollapsibleTextView, View paramView)
  {
    AppMethodBeat.i(345242);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderCollapsibleTextView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderCollapsibleTextView, "this$0");
    if (paramView == null)
    {
      paramFinderCollapsibleTextView = new NullPointerException("null cannot be cast to non-null type com.tencent.neattextview.textview.view.NeatTextView");
      AppMethodBeat.o(345242);
      throw paramFinderCollapsibleTextView;
    }
    try
    {
      i = ((NeatTextView)paramView).getLayout().aGN(paramFinderCollapsibleTextView.getLimitLine() - 1);
      if (((paramFinderCollapsibleTextView.Gxy) && (i > 0)) || (!paramFinderCollapsibleTextView.Gxy))
      {
        paramFinderCollapsibleTextView.fkl();
        paramView = z.FrZ;
        paramView = paramFinderCollapsibleTextView.getContext();
        kotlin.g.b.s.s(paramView, "context");
        z.a(paramView, false, 2, paramFinderCollapsibleTextView.Gxy, paramFinderCollapsibleTextView.Gxx);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderCollapsibleTextView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345242);
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramView)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
  
  private static final void d(FinderCollapsibleTextView paramFinderCollapsibleTextView)
  {
    AppMethodBeat.i(345188);
    kotlin.g.b.s.u(paramFinderCollapsibleTextView, "this$0");
    paramFinderCollapsibleTextView.getContentTextView().setBackgroundResource(e.b.transparent);
    AppMethodBeat.o(345188);
  }
  
  private final void fkl()
  {
    AppMethodBeat.i(345070);
    Log.i("Finder.CollapsibleTextView", "on btn ClickFun");
    if (!this.Gxy) {}
    for (boolean bool = true;; bool = false)
    {
      setCollapse(bool);
      if (!this.Gxy)
      {
        localObject = com.tencent.mm.ui.component.k.aeZF;
        com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(d.class);
        d.fmN();
      }
      uS(this.Gxy);
      Object localObject = this.GxA;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(Boolean.valueOf(this.Gxy));
      }
      AppMethodBeat.o(345070);
      return;
    }
  }
  
  private final void fkm()
  {
    AppMethodBeat.i(345097);
    CharSequence localCharSequence = this.bba;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(345097);
      return;
    }
    localCharSequence = this.bba;
    if (localCharSequence != null) {
      post(new FinderCollapsibleTextView..ExternalSyntheticLambda11(this, localCharSequence));
    }
    AppMethodBeat.o(345097);
  }
  
  private boolean fkn()
  {
    AppMethodBeat.i(168240);
    com.tencent.neattextview.textview.layout.a locala = getContentTextView().getLayout();
    for (;;)
    {
      try
      {
        i = kotlin.k.k.qv(this.GxB, locala.jQH()) - 1;
        if (i < 0) {
          continue;
        }
        i = locala.H(i, 10000.0F);
      }
      catch (Exception localException)
      {
        int j;
        if (!BuildInfo.DEBUG) {
          continue;
        }
        AppMethodBeat.o(168240);
        throw localException;
        int i = 0;
        continue;
        getCollapseTextView().setVisibility(8);
        continue;
        AppMethodBeat.o(168240);
      }
      j = getCollapseTextView().getVisibility();
      if ((locala == null) || (i <= 0) || (i >= getContentTextView().jPy().length())) {
        continue;
      }
      getCollapseTextView().setVisibility(0);
      if (j == getCollapseTextView().getVisibility()) {
        continue;
      }
      AppMethodBeat.o(168240);
      return true;
      i = 0;
    }
    return false;
  }
  
  private final void uS(boolean paramBoolean)
  {
    AppMethodBeat.i(345081);
    if (getCollapseTextView().getVisibility() == 0)
    {
      if (paramBoolean)
      {
        localObject = getCollapseTextView().getLayoutParams();
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(345081);
          throw ((Throwable)localObject);
        }
        localObject = (RelativeLayout.LayoutParams)localObject;
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(8, e.e.collapse_content_tv);
        ((RelativeLayout.LayoutParams)localObject).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject).removeRule(5);
        ((RelativeLayout.LayoutParams)localObject).setMarginEnd((int)this.Gxu);
        getCollapseTextView().setLayoutParams((ViewGroup.LayoutParams)localObject);
        getCollapseTextView().setTextSize(0, getContentTextView().getTextSize());
        Log.i("Finder.CollapsibleTextView", kotlin.g.b.s.X("isSpecialText:", Boolean.valueOf(getContentTextView().vZb)));
        post(new FinderCollapsibleTextView..ExternalSyntheticLambda8(this));
        AppMethodBeat.o(345081);
        return;
      }
      getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
      Object localObject = getCollapseTextView().getLayoutParams();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(345081);
        throw ((Throwable)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).removeRule(11);
      ((RelativeLayout.LayoutParams)localObject).removeRule(8);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, e.e.collapse_content_tv);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, e.e.collapse_content_tv);
      ((RelativeLayout.LayoutParams)localObject).setMarginEnd(0);
      getCollapseTextView().setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(345081);
      return;
    }
    getContentTextView().aZ(this.bba);
    getContentTextView().a(TextUtils.TruncateAt.END, 0.0F);
    AppMethodBeat.o(345081);
  }
  
  public final void bDL()
  {
    AppMethodBeat.i(345420);
    post(new FinderCollapsibleTextView..ExternalSyntheticLambda9(this));
    AppMethodBeat.o(345420);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(168232);
    kotlin.g.b.s.u(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      getContentTextView().setTag(e.e.touch_loc, new int[] { i, j });
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(168232);
    return bool;
  }
  
  public final boolean fko()
  {
    AppMethodBeat.i(345477);
    try
    {
      i = getContentTextView().getLayout().aGN(this.GxB - 1);
      if ((this.Gxy) && (i > 0))
      {
        fkl();
        AppMethodBeat.o(345477);
        return true;
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        int i = -1;
      }
      AppMethodBeat.o(345477);
    }
    return false;
  }
  
  public final TextView getCollapseTextView()
  {
    AppMethodBeat.i(168231);
    TextView localTextView = (TextView)this.Gxt.getValue();
    AppMethodBeat.o(168231);
    return localTextView;
  }
  
  public final float getCollapseTextViewRight()
  {
    return this.Gxu;
  }
  
  public final NeatTextView getContentTextView()
  {
    AppMethodBeat.i(168230);
    NeatTextView localNeatTextView = (NeatTextView)this.Gxs.getValue();
    AppMethodBeat.o(168230);
    return localNeatTextView;
  }
  
  public final int getExpanText()
  {
    return this.Gxv;
  }
  
  public final View getExtraView()
  {
    return this.Gxw;
  }
  
  public final int getLimitLine()
  {
    return this.GxB;
  }
  
  public final kotlin.g.a.b<Boolean, ah> getOnCollapse()
  {
    return this.GxA;
  }
  
  public final CharSequence getRealContent()
  {
    return this.GxC;
  }
  
  public final CharSequence getText()
  {
    return this.bba;
  }
  
  public final int getTextColor()
  {
    AppMethodBeat.i(168237);
    int i = getContentTextView().getCurrentTextColor();
    AppMethodBeat.o(168237);
    return i;
  }
  
  public final float getTextSize()
  {
    AppMethodBeat.i(345461);
    float f = getContentTextView().getTextSize();
    AppMethodBeat.o(345461);
    return f;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168234);
    super.onMeasure(paramInt1, paramInt2);
    if (fkn()) {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(168234);
  }
  
  public final void setCollapse(boolean paramBoolean)
  {
    AppMethodBeat.i(168233);
    this.Gxy = paramBoolean;
    if (paramBoolean)
    {
      if (getContentTextView().getMaxLines() != this.GxB) {
        getContentTextView().setMaxLines(this.GxB);
      }
      getCollapseTextView().setText(this.Gxv);
      AppMethodBeat.o(168233);
      return;
    }
    if (getContentTextView().getMaxLines() != 2147483647) {
      getContentTextView().setMaxLines(2147483647);
    }
    getCollapseTextView().setText(e.h.collapse);
    AppMethodBeat.o(168233);
  }
  
  public final void setCollapseTextViewRight(float paramFloat)
  {
    this.Gxu = paramFloat;
  }
  
  public final void setExpanText(int paramInt)
  {
    this.Gxv = paramInt;
  }
  
  public final void setExtraView(View paramView)
  {
    this.Gxw = paramView;
  }
  
  public final void setLimitLine(int paramInt)
  {
    AppMethodBeat.i(345445);
    this.GxB = paramInt;
    if (getContentTextView().getMaxLines() != paramInt) {
      getContentTextView().setMaxLines(paramInt);
    }
    AppMethodBeat.o(345445);
  }
  
  public final void setOnCollapse(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    this.GxA = paramb;
  }
  
  public final void setRealContent(CharSequence paramCharSequence)
  {
    this.GxC = paramCharSequence;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(168236);
    this.bba = paramCharSequence;
    getContentTextView().aZ(paramCharSequence);
    post(new FinderCollapsibleTextView..ExternalSyntheticLambda10(this));
    AppMethodBeat.o(168236);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(168238);
    getContentTextView().setTextColor(paramInt);
    AppMethodBeat.o(168238);
  }
  
  public final void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(345467);
    getContentTextView().setTextSize(paramFloat);
    AppMethodBeat.o(345467);
  }
  
  public final void setTopicExpand(boolean paramBoolean)
  {
    this.Gxx = paramBoolean;
  }
  
  public final void uT(boolean paramBoolean)
  {
    AppMethodBeat.i(168239);
    if (paramBoolean)
    {
      getContentTextView().setOnLongClickListener(new FinderCollapsibleTextView..ExternalSyntheticLambda3(this));
      getContentTextView().setOnClickListener(new FinderCollapsibleTextView..ExternalSyntheticLambda1(this));
      getContentTextView().setBackgroundResource(e.b.transparent);
      getContentTextView().setClickable(true);
      getContentTextView().setLongClickable(true);
      AppMethodBeat.o(168239);
      return;
    }
    getContentTextView().setOnLongClickListener(null);
    getContentTextView().setOnClickListener(null);
    getContentTextView().setBackgroundResource(e.d.transparent_background);
    getContentTextView().setClickable(false);
    getContentTextView().setLongClickable(false);
    AppMethodBeat.o(168239);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<TextView>
  {
    c(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<NeatTextView>
  {
    d(FinderCollapsibleTextView paramFinderCollapsibleTextView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */