package com.tencent.mm.plugin.hld.floatview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.g;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView.c;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView.d;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatView;", "Lcom/tencent/mm/plugin/hld/floatview/IImeFloatView;", "Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatViewHolder$IFloatViewListener;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "arrowView", "Landroid/widget/RelativeLayout;", "getArrowView", "()Landroid/widget/RelativeLayout;", "arrowView$delegate", "Lkotlin/Lazy;", "compositionList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContext", "()Landroid/content/Context;", "keyboardView", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "mAnchorView", "Landroid/view/View;", "mButton", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "mCompositionContainerRv", "Landroidx/recyclerview/widget/RecyclerView;", "mFloatCompositionWidow", "Landroid/widget/PopupWindow;", "mLastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "mLastKeyOperationForXml", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "mOnTouchListener", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;", "mOnTouchListenerForXml", "mParentView", "mSideXOffsetList", "", "onATouch", "getOnATouch", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;", "rootView", "getRootView", "()Landroid/view/View;", "rootView$delegate", "notifyDataSetChanged", "", "onHide", "end", "", "delayMs", "", "onShowView", "textList", "keyboard", "button", "lastKeyOperation", "parent", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "anchorView", "onTouch", "v", "event", "Landroid/view/MotionEvent;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements View.OnTouchListener, a, e.a
{
  public static final c.a Jqi;
  private final j JpQ;
  private PopupWindow JpU;
  private final j Jqj;
  private RecyclerView Jqk;
  private final ArrayList<String> Jql;
  private KeyboardView Jqm;
  private com.tencent.mm.plugin.hld.keyboard.selfdraw.b Jqn;
  private ArrayList<Integer> Jqo;
  private WeakReference<KeyboardView.d> Jqp;
  private WeakReference<View.OnTouchListener> Jqq;
  private KeyboardView.c Jqr;
  private com.tencent.mm.plugin.hld.keyboard.b Jqs;
  private final KeyboardView.d Jqt;
  final Context context;
  private View mF;
  private View xyY;
  
  static
  {
    AppMethodBeat.i(312832);
    Jqi = new c.a((byte)0);
    AppMethodBeat.o(312832);
  }
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(312787);
    this.context = paramContext;
    this.JpQ = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.Jqj = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.Jql = new ArrayList();
    paramContext = new PopupWindow(getRootView());
    paramContext.setClippingEnabled(false);
    paramContext.setInputMethodMode(2);
    paramContext.setTouchable(false);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = l.JyV;
      paramContext.setWindowLayoutType(l.fOG());
    }
    Object localObject = ah.aiuX;
    this.JpU = paramContext;
    this.Jqk = ((RecyclerView)getRootView().findViewById(a.f.composition_container_rv));
    paramContext = this.Jqk;
    s.checkNotNull(paramContext);
    paramContext.setAdapter((RecyclerView.a)new d(this.Jql, (e.a)this));
    paramContext = new WxLinearLayoutManager(this.context);
    paramContext.setOrientation(0);
    localObject = this.Jqk;
    s.checkNotNull(localObject);
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)paramContext);
    this.Jqt = ((KeyboardView.d)new c(this));
    AppMethodBeat.o(312787);
  }
  
  private final RelativeLayout fLt()
  {
    AppMethodBeat.i(312801);
    Object localObject = this.Jqj.getValue();
    s.s(localObject, "<get-arrowView>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312801);
    return localObject;
  }
  
  private final View getRootView()
  {
    AppMethodBeat.i(312796);
    Object localObject = this.JpQ.getValue();
    s.s(localObject, "<get-rootView>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(312796);
    return localObject;
  }
  
  public final void a(ArrayList<String> paramArrayList, KeyboardView paramKeyboardView, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb, KeyboardView.c paramc)
  {
    AppMethodBeat.i(312882);
    s.u(paramArrayList, "textList");
    s.u(paramKeyboardView, "keyboard");
    s.u(paramb, "button");
    this.Jqm = paramKeyboardView;
    this.Jqn = paramb;
    this.Jqo = new ArrayList(paramArrayList.size());
    paramb.wV(true);
    this.Jqr = paramc;
    paramc = this.JpU;
    s.checkNotNull(paramc);
    paramc.dismiss();
    this.Jql.clear();
    this.Jql.addAll((Collection)paramArrayList);
    int j = paramArrayList.size() / 2;
    paramc = this.Jqk;
    s.checkNotNull(paramc);
    paramc = paramc.getAdapter();
    s.checkNotNull(paramc);
    paramc.bZE.notifyChanged();
    paramc = this.JpU;
    s.checkNotNull(paramc);
    paramc.setHeight(com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_view_long_click_height));
    paramc = this.JpU;
    s.checkNotNull(paramc);
    paramc.setWidth((com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_composition_width) + com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_view_long_click_item_margin) * 2) * this.Jql.size() + com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_composition_margin_left) * 2);
    paramc = new int[2];
    paramKeyboardView.getLocationInWindow(paramc);
    int m = paramc[0] + paramb.JsF.left;
    paramKeyboardView.getLocationOnScreen(paramc);
    int n = paramc[1] + paramb.JsF.top;
    paramc = this.JpU;
    s.checkNotNull(paramc);
    int i = m - (paramc.getWidth() / 2 + m - (paramb.width / 2 + m));
    paramc = this.JpU;
    s.checkNotNull(paramc);
    int i1 = (paramc.getWidth() - paramb.width) / 2;
    if (i < 0)
    {
      k = (paramb.width - com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_composition_width)) / 2;
      i += i1;
      j = 0;
    }
    for (;;)
    {
      paramb = fLt().getLayoutParams();
      if (paramb != null) {
        break;
      }
      paramArrayList = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(312882);
      throw paramArrayList;
      paramc = this.JpU;
      s.checkNotNull(paramc);
      if (paramc.getWidth() + i > paramKeyboardView.getResources().getDisplayMetrics().widthPixels)
      {
        j = paramArrayList.size() - 1;
        k = (paramb.width - com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_composition_width)) / 2;
        paramc = this.JpU;
        s.checkNotNull(paramc);
        k = k + paramc.getWidth() - paramb.width;
        i -= i1;
      }
      else
      {
        paramb = this.JpU;
        s.checkNotNull(paramb);
        k = (paramb.getWidth() - com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_composition_width)) / 2;
      }
    }
    paramb = (RelativeLayout.LayoutParams)paramb;
    paramb.setMarginStart(k);
    fLt().setLayoutParams((ViewGroup.LayoutParams)paramb);
    paramb = this.Jqk;
    s.checkNotNull(paramb);
    paramb = paramb.getAdapter();
    if (paramb == null)
    {
      paramArrayList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.floatview.ImeLongClickFloatViewAdapter");
      AppMethodBeat.o(312882);
      throw paramArrayList;
    }
    ((d)paramb).Jqx = j;
    j = com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_view_long_click_margin_anchor);
    paramb = this.JpU;
    s.checkNotNull(paramb);
    int k = paramb.getHeight();
    paramb = l.JyV;
    j = j + n - k - l.getStatusBarHeight(this.context);
    Log.d("WxIme.ImeLongClickFloatView", "onShowView " + m + ' ' + n + " oriXOffset:" + m + " yOffset:" + j + " xOffset:" + i);
    paramb = com.tencent.mm.plugin.hld.d.a.JqJ;
    if (com.tencent.mm.plugin.hld.d.a.fLA() != null)
    {
      paramb = com.tencent.mm.plugin.hld.d.a.JqJ;
      paramb = (View)com.tencent.mm.plugin.hld.d.a.fLA();
    }
    try
    {
      for (;;)
      {
        paramc = this.JpU;
        s.checkNotNull(paramc);
        paramc.showAtLocation(paramb, 8388659, i, j);
        paramb = paramKeyboardView.getTouchListener();
        if (paramb != null) {
          this.Jqp = new WeakReference(paramb);
        }
        paramKeyboardView.setOnTouchListener(this.Jqt);
        paramKeyboardView = this.Jqo;
        s.checkNotNull(paramKeyboardView);
        paramKeyboardView.add(Integer.valueOf(0));
        j = i + com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_composition_margin_left);
        m = paramArrayList.size();
        if (1 < m)
        {
          i = 1;
          do
          {
            k = i + 1;
            j += com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_composition_width);
            paramArrayList = this.Jqo;
            s.checkNotNull(paramArrayList);
            paramArrayList.add(Integer.valueOf(j));
            i = k;
          } while (k < m);
        }
        AppMethodBeat.o(312882);
        return;
        paramb = (View)paramKeyboardView;
      }
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        Log.e("WxIme.ImeLongClickFloatView", s.X("onShowView ", paramb.getMessage()));
      }
    }
  }
  
  public final void a(ArrayList<String> paramArrayList, ImeKeyRelativeLayout paramImeKeyRelativeLayout, View paramView, com.tencent.mm.plugin.hld.keyboard.b paramb)
  {
    AppMethodBeat.i(312864);
    s.u(paramArrayList, "textList");
    s.u(paramView, "anchorView");
    this.xyY = ((View)paramImeKeyRelativeLayout);
    this.mF = paramView;
    this.Jqo = new ArrayList(paramArrayList.size());
    Object localObject = this.mF;
    if (localObject != null) {
      ((View)localObject).setSelected(true);
    }
    this.Jqs = paramb;
    paramb = this.JpU;
    s.checkNotNull(paramb);
    paramb.dismiss();
    this.Jql.clear();
    this.Jql.addAll((Collection)paramArrayList);
    int k = paramArrayList.size() / 2;
    paramb = this.Jqk;
    s.checkNotNull(paramb);
    paramb = paramb.getAdapter();
    s.checkNotNull(paramb);
    paramb.bZE.notifyChanged();
    paramb = this.JpU;
    s.checkNotNull(paramb);
    paramb.setHeight(com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_view_long_click_height));
    paramb = this.JpU;
    s.checkNotNull(paramb);
    paramb.setWidth((com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_composition_width) + com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_view_long_click_item_margin) * 2) * this.Jql.size() + com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_composition_margin_left) * 2);
    paramb = new int[2];
    localObject = this.mF;
    s.checkNotNull(localObject);
    ((View)localObject).getLocationInWindow(paramb);
    int m = paramb[0];
    localObject = this.mF;
    s.checkNotNull(localObject);
    ((View)localObject).getLocationOnScreen(paramb);
    int n = paramb[1];
    paramb = this.JpU;
    s.checkNotNull(paramb);
    int i = m - (paramb.getWidth() / 2 + m - (paramView.getMeasuredWidth() / 2 + m));
    paramb = this.JpU;
    s.checkNotNull(paramb);
    int j = (paramb.getWidth() - paramView.getMeasuredWidth()) / 2;
    if (i < 0)
    {
      i += j;
      j = (paramView.getMeasuredWidth() - com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_composition_width)) / 2;
      k = 0;
    }
    for (;;)
    {
      paramb = fLt().getLayoutParams();
      if (paramb != null) {
        break;
      }
      paramArrayList = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(312864);
      throw paramArrayList;
      paramb = this.JpU;
      s.checkNotNull(paramb);
      if (paramb.getWidth() + i > paramView.getResources().getDisplayMetrics().widthPixels)
      {
        i -= j;
        k = paramArrayList.size() - 1;
        j = (paramView.getMeasuredWidth() - com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_composition_width)) / 2;
        paramb = this.JpU;
        s.checkNotNull(paramb);
        j = j + paramb.getWidth() - paramView.getMeasuredWidth();
      }
      else
      {
        paramb = this.JpU;
        s.checkNotNull(paramb);
        j = (paramb.getWidth() - com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_composition_width)) / 2;
      }
    }
    paramb = (RelativeLayout.LayoutParams)paramb;
    paramb.setMarginStart(j);
    fLt().setLayoutParams((ViewGroup.LayoutParams)paramb);
    paramb = this.Jqk;
    s.checkNotNull(paramb);
    paramb = paramb.getAdapter();
    if (paramb == null)
    {
      paramArrayList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.floatview.ImeLongClickFloatViewAdapter");
      AppMethodBeat.o(312864);
      throw paramArrayList;
    }
    ((d)paramb).Jqx = k;
    j = com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_view_long_click_margin_anchor);
    paramb = this.JpU;
    s.checkNotNull(paramb);
    k = paramb.getHeight();
    paramb = l.JyV;
    j = j + n - k - l.getStatusBarHeight(this.context);
    Log.d("WxIme.ImeLongClickFloatView", "onShowView " + m + ' ' + n + " oriXOffset:" + m + " yOffset:" + j + " xOffset:" + i);
    paramb = com.tencent.mm.plugin.hld.d.a.JqJ;
    if (com.tencent.mm.plugin.hld.d.a.fLA() != null)
    {
      paramb = com.tencent.mm.plugin.hld.d.a.JqJ;
      paramb = (View)com.tencent.mm.plugin.hld.d.a.fLA();
    }
    try
    {
      for (;;)
      {
        localObject = this.JpU;
        s.checkNotNull(localObject);
        ((PopupWindow)localObject).showAtLocation(paramb, 8388659, i, j);
        if ((paramView instanceof ImeKeyRelativeLayout)) {
          this.Jqq = ((ImeKeyRelativeLayout)paramView).getOnTouchListener();
        }
        if (paramImeKeyRelativeLayout != null) {
          this.Jqq = paramImeKeyRelativeLayout.getOnTouchListener();
        }
        paramImeKeyRelativeLayout = this.xyY;
        s.checkNotNull(paramImeKeyRelativeLayout);
        paramImeKeyRelativeLayout.setOnTouchListener((View.OnTouchListener)this);
        paramImeKeyRelativeLayout = this.Jqo;
        s.checkNotNull(paramImeKeyRelativeLayout);
        paramImeKeyRelativeLayout.add(Integer.valueOf(0));
        j = com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_composition_margin_left) + i;
        m = paramArrayList.size();
        if (1 < m)
        {
          i = 1;
          do
          {
            k = i + 1;
            j += com.tencent.mm.cd.a.bs(this.context, a.d.ime_float_composition_width);
            paramArrayList = this.Jqo;
            s.checkNotNull(paramArrayList);
            paramArrayList.add(Integer.valueOf(j));
            i = k;
          } while (k < m);
        }
        AppMethodBeat.o(312864);
        return;
        paramb = paramView;
      }
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        Log.e("WxIme.ImeLongClickFloatView", s.X("onShowView ", paramb.getMessage()));
      }
    }
  }
  
  public final void l(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(312845);
    Object localObject1 = this.JpU;
    if (localObject1 != null) {
      ((PopupWindow)localObject1).dismiss();
    }
    Object localObject2 = this.Jqm;
    if (localObject2 != null)
    {
      localObject1 = this.Jqp;
      if (localObject1 == null)
      {
        localObject1 = null;
        ((KeyboardView)localObject2).setTouchListener((KeyboardView.d)localObject1);
      }
    }
    else
    {
      localObject1 = this.Jqq;
      if (localObject1 != null)
      {
        if (this.xyY == null) {
          break label182;
        }
        if (((WeakReference)localObject1).get() != null)
        {
          localObject2 = this.xyY;
          s.checkNotNull(localObject2);
          ((View)localObject2).setOnTouchListener((View.OnTouchListener)((WeakReference)localObject1).get());
        }
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject1 = this.Jqn;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.hld.keyboard.selfdraw.b)localObject1).wV(false);
        }
        localObject1 = this.mF;
        if (localObject1 != null) {
          ((View)localObject1).setSelected(false);
        }
      }
      this.mF = null;
      this.Jqn = null;
      this.Jqm = null;
      this.Jqp = null;
      AppMethodBeat.o(312845);
      return;
      localObject1 = (KeyboardView.d)((WeakReference)localObject1).get();
      break;
      label182:
      if ((this.mF != null) && (((WeakReference)localObject1).get() != null))
      {
        localObject2 = this.mF;
        s.checkNotNull(localObject2);
        ((View)localObject2).setOnTouchListener((View.OnTouchListener)((WeakReference)localObject1).get());
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(312839);
    Object localObject = this.Jqk;
    s.checkNotNull(localObject);
    localObject = ((RecyclerView)localObject).getAdapter();
    s.checkNotNull(localObject);
    ((RecyclerView.a)localObject).bZE.notifyChanged();
    AppMethodBeat.o(312839);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(312895);
    Object localObject1;
    label25:
    int m;
    if (paramMotionEvent == null)
    {
      localObject1 = null;
      if (paramMotionEvent != null) {
        break label99;
      }
      paramMotionEvent = Double.valueOf(0.0D);
      m = (int)((Float)paramMotionEvent).floatValue();
      Log.v("WxIme.ImeLongClickFloatView", "action " + localObject1 + ' ' + m);
      if (localObject1 != null) {
        break label110;
      }
    }
    label99:
    label110:
    int i;
    int j;
    label144:
    int k;
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(312895);
        return false;
        localObject1 = Integer.valueOf(paramMotionEvent.getActionMasked());
        break;
        paramMotionEvent = Float.valueOf(paramMotionEvent.getRawX());
        break label25;
        if (((Integer)localObject1).intValue() == 2)
        {
          paramView = this.Jqo;
          s.checkNotNull(paramView);
          int n = paramView.size();
          if (n <= 0) {
            break label493;
          }
          i = 0;
          j = 0;
          k = i + 1;
          paramView = this.Jqo;
          s.checkNotNull(paramView);
          paramView = paramView.get(i);
          s.s(paramView, "mSideXOffsetList!![i]");
          if (m < ((Number)paramView).intValue()) {
            break label487;
          }
          if (k < n) {
            break label478;
          }
        }
      }
    }
    for (;;)
    {
      paramView = this.Jqs;
      if (paramView != null)
      {
        paramMotionEvent = this.Jql.get(i);
        s.s(paramMotionEvent, "compositionList[index]");
        paramView.aIl((String)paramMotionEvent);
      }
      paramView = this.Jqk;
      s.checkNotNull(paramView);
      paramView = paramView.getAdapter();
      if (paramView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.floatview.ImeLongClickFloatViewAdapter");
        AppMethodBeat.o(312895);
        throw paramView;
      }
      ((d)paramView).Yp(i);
      break;
      if (((Integer)localObject1).intValue() != 1) {
        break;
      }
      paramMotionEvent = this.Jqs;
      if (paramMotionEvent != null) {
        paramMotionEvent.Jrl = true;
      }
      paramMotionEvent = this.mF;
      if (paramMotionEvent != null) {
        paramMotionEvent.setOnTouchListener(null);
      }
      paramMotionEvent = this.Jqk;
      s.checkNotNull(paramMotionEvent);
      paramMotionEvent = paramMotionEvent.getAdapter();
      if (paramMotionEvent == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.floatview.ImeLongClickFloatViewAdapter");
        AppMethodBeat.o(312895);
        throw paramView;
      }
      paramMotionEvent = ((d)paramMotionEvent).fLu();
      localObject1 = paramMotionEvent;
      if (paramMotionEvent == null) {
        localObject1 = "";
      }
      paramMotionEvent = this.Jqs;
      if (paramMotionEvent == null) {}
      for (paramMotionEvent = (MotionEvent)localObject2;; paramMotionEvent = new g((String)localObject1, paramMotionEvent.Jrm))
      {
        localObject2 = paramMotionEvent;
        if (paramMotionEvent == null) {
          localObject2 = new g((String)localObject1);
        }
        paramMotionEvent = (com.tencent.mm.plugin.hld.a.d)h.ax(com.tencent.mm.plugin.hld.a.d.class);
        if (paramMotionEvent != null)
        {
          paramMotionEvent = paramMotionEvent.fKG();
          if (paramMotionEvent != null)
          {
            paramMotionEvent = paramMotionEvent.fKC();
            if (paramMotionEvent != null) {
              paramMotionEvent.b((g)localObject2);
            }
          }
        }
        paramMotionEvent = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.aB(paramView, 2);
        a.a.a((a)this, false, 0L, 3);
        break;
      }
      label478:
      j = i;
      i = k;
      break label144;
      label487:
      i = j;
      continue;
      label493:
      i = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/floatview/ImeLongClickFloatView$onATouch$1", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;", "onTouch", "", "event", "Landroid/view/MotionEvent;", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements KeyboardView.d
  {
    c(c paramc) {}
    
    public final boolean Z(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(312795);
      s.u(paramMotionEvent, "event");
      int i = paramMotionEvent.getActionMasked();
      int m = (int)paramMotionEvent.getRawX();
      Log.v("WxIme.ImeLongClickFloatView", "action " + i + ' ' + m);
      int j;
      label110:
      int k;
      switch (i)
      {
      default: 
        AppMethodBeat.o(312795);
        return false;
      case 2: 
        paramMotionEvent = c.b(this.Jqu);
        s.checkNotNull(paramMotionEvent);
        int n = paramMotionEvent.size();
        if (n > 0)
        {
          i = 0;
          j = 0;
          k = i + 1;
          paramMotionEvent = c.b(this.Jqu);
          s.checkNotNull(paramMotionEvent);
          paramMotionEvent = paramMotionEvent.get(i);
          s.s(paramMotionEvent, "mSideXOffsetList!![i]");
          if (m >= ((Number)paramMotionEvent).intValue()) {
            if (k < n) {
              break;
            }
          }
        }
        break;
      }
      for (;;)
      {
        paramMotionEvent = c.c(this.Jqu);
        if (paramMotionEvent != null)
        {
          localObject1 = c.f(this.Jqu).get(i);
          s.s(localObject1, "compositionList[index]");
          paramMotionEvent.aIl((String)localObject1);
        }
        paramMotionEvent = c.d(this.Jqu);
        s.checkNotNull(paramMotionEvent);
        paramMotionEvent = paramMotionEvent.getAdapter();
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.floatview.ImeLongClickFloatViewAdapter");
          AppMethodBeat.o(312795);
          throw paramMotionEvent;
        }
        ((d)paramMotionEvent).Yp(i);
        break;
        paramMotionEvent = c.c(this.Jqu);
        if (paramMotionEvent != null) {
          paramMotionEvent.Jrl = true;
        }
        paramMotionEvent = c.d(this.Jqu);
        s.checkNotNull(paramMotionEvent);
        paramMotionEvent = paramMotionEvent.getAdapter();
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.floatview.ImeLongClickFloatViewAdapter");
          AppMethodBeat.o(312795);
          throw paramMotionEvent;
        }
        paramMotionEvent = ((d)paramMotionEvent).fLu();
        Object localObject1 = paramMotionEvent;
        if (paramMotionEvent == null) {
          localObject1 = "";
        }
        paramMotionEvent = c.c(this.Jqu);
        if (paramMotionEvent == null) {}
        for (paramMotionEvent = null;; paramMotionEvent = new g((String)localObject1, paramMotionEvent.Jrm))
        {
          Object localObject2 = paramMotionEvent;
          if (paramMotionEvent == null) {
            localObject2 = new g((String)localObject1);
          }
          paramMotionEvent = (com.tencent.mm.plugin.hld.a.d)h.ax(com.tencent.mm.plugin.hld.a.d.class);
          if (paramMotionEvent != null)
          {
            paramMotionEvent = paramMotionEvent.fKG();
            if (paramMotionEvent != null)
            {
              paramMotionEvent = paramMotionEvent.fKC();
              if (paramMotionEvent != null) {
                paramMotionEvent.b((g)localObject2);
              }
            }
          }
          paramMotionEvent = c.e(this.Jqu);
          if (paramMotionEvent != null)
          {
            localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
            com.tencent.mm.plugin.hld.model.k.a(paramMotionEvent, 2);
          }
          a.a.a((a)this.Jqu, false, 0L, 3);
          break;
        }
        j = i;
        i = k;
        break label110;
        i = j;
        continue;
        i = 0;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<View>
  {
    d(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.floatview.c
 * JD-Core Version:    0.7.0.1
 */