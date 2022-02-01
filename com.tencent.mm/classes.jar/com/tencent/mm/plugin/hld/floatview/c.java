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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView.c;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView.d;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatView;", "Lcom/tencent/mm/plugin/hld/floatview/IImeFloatView;", "Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatViewHolder$IFloatViewListener;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "arrowView", "Landroid/widget/RelativeLayout;", "getArrowView", "()Landroid/widget/RelativeLayout;", "arrowView$delegate", "Lkotlin/Lazy;", "compositionList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContext", "()Landroid/content/Context;", "keyboardView", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "mAnchorView", "Landroid/view/View;", "mButton", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "mCompositionContainerRv", "Landroidx/recyclerview/widget/RecyclerView;", "mFloatCompositionWidow", "Landroid/widget/PopupWindow;", "mLastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "mLastKeyOperationForXml", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "mOnTouchListener", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;", "mOnTouchListenerForXml", "mParentView", "mSideXOffsetList", "", "onATouch", "getOnATouch", "()Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;", "rootView", "getRootView", "()Landroid/view/View;", "rootView$delegate", "notifyDataSetChanged", "", "onHide", "end", "", "delayMs", "", "onShowView", "textList", "keyboard", "button", "lastKeyOperation", "parent", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "anchorView", "onTouch", "v", "event", "Landroid/view/MotionEvent;", "Companion", "plugin-hld_release"})
public final class c
  implements View.OnTouchListener, a, e.a
{
  public static final a Dxo;
  private final f DwJ;
  private PopupWindow DwN;
  private final f Dxd;
  private RecyclerView Dxe;
  private final ArrayList<String> Dxf;
  private KeyboardView Dxg;
  private com.tencent.mm.plugin.hld.keyboard.selfdraw.b Dxh;
  private ArrayList<Integer> Dxi;
  private WeakReference<KeyboardView.d> Dxj;
  private WeakReference<View.OnTouchListener> Dxk;
  private KeyboardView.c Dxl;
  private com.tencent.mm.plugin.hld.keyboard.b Dxm;
  private final KeyboardView.d Dxn;
  final Context context;
  private View lJ;
  private View mParentView;
  
  static
  {
    AppMethodBeat.i(215488);
    Dxo = new a((byte)0);
    AppMethodBeat.o(215488);
  }
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(215486);
    this.context = paramContext;
    this.DwJ = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.Dxd = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.Dxf = new ArrayList();
    paramContext = new PopupWindow(getRootView());
    paramContext.setClippingEnabled(false);
    paramContext.setInputMethodMode(2);
    paramContext.setTouchable(false);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = com.tencent.mm.plugin.hld.f.l.DHK;
      paramContext.setWindowLayoutType(1003);
    }
    this.DwN = paramContext;
    this.Dxe = ((RecyclerView)getRootView().findViewById(a.f.composition_container_rv));
    paramContext = this.Dxe;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setAdapter((RecyclerView.a)new d(this.Dxf, (e.a)this));
    paramContext = new WxLinearLayoutManager(this.context);
    paramContext.setOrientation(0);
    Object localObject = this.Dxe;
    if (localObject == null) {
      p.iCn();
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)paramContext);
    this.Dxn = ((KeyboardView.d)new c(this));
    AppMethodBeat.o(215486);
  }
  
  private final RelativeLayout eDt()
  {
    AppMethodBeat.i(215470);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Dxd.getValue();
    AppMethodBeat.o(215470);
    return localRelativeLayout;
  }
  
  private final View getRootView()
  {
    AppMethodBeat.i(215467);
    View localView = (View)this.DwJ.getValue();
    AppMethodBeat.o(215467);
    return localView;
  }
  
  public final void a(ArrayList<String> paramArrayList, KeyboardView paramKeyboardView, com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb, KeyboardView.c paramc)
  {
    AppMethodBeat.i(215480);
    p.k(paramArrayList, "textList");
    p.k(paramKeyboardView, "keyboard");
    p.k(paramb, "button");
    this.Dxg = paramKeyboardView;
    this.Dxh = paramb;
    this.Dxi = new ArrayList(paramArrayList.size());
    paramb.sP(true);
    this.Dxl = paramc;
    paramc = this.DwN;
    if (paramc == null) {
      p.iCn();
    }
    paramc.dismiss();
    this.Dxf.clear();
    this.Dxf.addAll((Collection)paramArrayList);
    int j = paramArrayList.size() / 2;
    paramc = this.Dxe;
    if (paramc == null) {
      p.iCn();
    }
    paramc = paramc.getAdapter();
    if (paramc == null) {
      p.iCn();
    }
    paramc.notifyDataSetChanged();
    paramc = this.DwN;
    if (paramc == null) {
      p.iCn();
    }
    paramc.setHeight(com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_view_long_click_height));
    paramc = this.DwN;
    if (paramc == null) {
      p.iCn();
    }
    paramc.setWidth((com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_composition_width) + com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_view_long_click_item_margin) * 2) * this.Dxf.size() + com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_composition_margin_left) * 2);
    paramc = new int[2];
    paramKeyboardView.getLocationInWindow(paramc);
    int m = paramc[0] + paramb.DzC.left;
    paramKeyboardView.getLocationOnScreen(paramc);
    int n = paramc[1] + paramb.DzC.top;
    paramc = this.DwN;
    if (paramc == null) {
      p.iCn();
    }
    int i = m - (paramc.getWidth() / 2 + m - (paramb.width / 2 + m));
    paramc = this.DwN;
    if (paramc == null) {
      p.iCn();
    }
    int i1 = (paramc.getWidth() - paramb.width) / 2;
    if (i < 0)
    {
      k = (paramb.width - com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_composition_width)) / 2;
      i += i1;
      j = 0;
    }
    for (;;)
    {
      paramb = eDt().getLayoutParams();
      if (paramb != null) {
        break;
      }
      paramArrayList = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(215480);
      throw paramArrayList;
      paramc = this.DwN;
      if (paramc == null) {
        p.iCn();
      }
      k = paramc.getWidth();
      paramc = paramKeyboardView.getResources();
      p.j(paramc, "keyboard.resources");
      if (k + i > paramc.getDisplayMetrics().widthPixels)
      {
        j = paramArrayList.size() - 1;
        k = (paramb.width - com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_composition_width)) / 2;
        paramc = this.DwN;
        if (paramc == null) {
          p.iCn();
        }
        k = k + paramc.getWidth() - paramb.width;
        i -= i1;
      }
      else
      {
        paramb = this.DwN;
        if (paramb == null) {
          p.iCn();
        }
        k = (paramb.getWidth() - com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_composition_width)) / 2;
      }
    }
    paramb = (RelativeLayout.LayoutParams)paramb;
    paramb.setMarginStart(k);
    eDt().setLayoutParams((ViewGroup.LayoutParams)paramb);
    paramb = this.Dxe;
    if (paramb == null) {
      p.iCn();
    }
    paramb = paramb.getAdapter();
    if (paramb == null)
    {
      paramArrayList = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.floatview.ImeLongClickFloatViewAdapter");
      AppMethodBeat.o(215480);
      throw paramArrayList;
    }
    ((d)paramb).Dxr = j;
    j = com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_view_long_click_margin_anchor);
    paramb = this.DwN;
    if (paramb == null) {
      p.iCn();
    }
    int k = paramb.getHeight();
    paramb = com.tencent.mm.plugin.hld.f.l.DHK;
    j = j + n - k - com.tencent.mm.plugin.hld.f.l.getStatusBarHeight(this.context);
    Log.d("WxIme.ImeLongClickFloatView", "onShowView " + m + ' ' + n + " oriXOffset:" + m + " yOffset:" + j + " xOffset:" + i);
    paramb = com.tencent.mm.plugin.hld.d.a.DxH;
    if (com.tencent.mm.plugin.hld.d.a.eDz() != null) {
      paramb = com.tencent.mm.plugin.hld.d.a.DxH;
    }
    for (paramb = (View)com.tencent.mm.plugin.hld.d.a.eDz();; paramb = (View)paramKeyboardView)
    {
      try
      {
        paramc = this.DwN;
        if (paramc == null) {
          p.iCn();
        }
        paramc.showAtLocation(paramb, 8388659, i, j);
      }
      catch (Exception paramb)
      {
        for (;;)
        {
          Log.e("WxIme.ImeLongClickFloatView", "onShowView " + paramb.getMessage());
        }
        AppMethodBeat.o(215480);
      }
      paramb = paramKeyboardView.getTouchListener();
      if (paramb != null) {
        this.Dxj = new WeakReference(paramb);
      }
      paramKeyboardView.setOnTouchListener(this.Dxn);
      paramKeyboardView = this.Dxi;
      if (paramKeyboardView == null) {
        p.iCn();
      }
      paramKeyboardView.add(Integer.valueOf(0));
      j = com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_composition_margin_left) + i;
      k = paramArrayList.size();
      i = 1;
      while (i < k)
      {
        j += com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_composition_width);
        paramArrayList = this.Dxi;
        if (paramArrayList == null) {
          p.iCn();
        }
        paramArrayList.add(Integer.valueOf(j));
        i += 1;
      }
    }
  }
  
  public final void a(ArrayList<String> paramArrayList, ImeKeyRelativeLayout paramImeKeyRelativeLayout, View paramView, com.tencent.mm.plugin.hld.keyboard.b paramb)
  {
    AppMethodBeat.i(215477);
    p.k(paramArrayList, "textList");
    p.k(paramView, "anchorView");
    this.mParentView = ((View)paramImeKeyRelativeLayout);
    this.lJ = paramView;
    this.Dxi = new ArrayList(paramArrayList.size());
    Object localObject = this.lJ;
    if (localObject != null) {
      ((View)localObject).setSelected(true);
    }
    this.Dxm = paramb;
    paramb = this.DwN;
    if (paramb == null) {
      p.iCn();
    }
    paramb.dismiss();
    this.Dxf.clear();
    this.Dxf.addAll((Collection)paramArrayList);
    int k = paramArrayList.size() / 2;
    paramb = this.Dxe;
    if (paramb == null) {
      p.iCn();
    }
    paramb = paramb.getAdapter();
    if (paramb == null) {
      p.iCn();
    }
    paramb.notifyDataSetChanged();
    paramb = this.DwN;
    if (paramb == null) {
      p.iCn();
    }
    paramb.setHeight(com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_view_long_click_height));
    paramb = this.DwN;
    if (paramb == null) {
      p.iCn();
    }
    paramb.setWidth((com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_composition_width) + com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_view_long_click_item_margin) * 2) * this.Dxf.size() + com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_composition_margin_left) * 2);
    paramb = new int[2];
    localObject = this.lJ;
    if (localObject == null) {
      p.iCn();
    }
    ((View)localObject).getLocationInWindow(paramb);
    int m = paramb[0];
    localObject = this.lJ;
    if (localObject == null) {
      p.iCn();
    }
    ((View)localObject).getLocationOnScreen(paramb);
    int n = paramb[1];
    paramb = this.DwN;
    if (paramb == null) {
      p.iCn();
    }
    int i = m - (paramb.getWidth() / 2 + m - (paramView.getMeasuredWidth() / 2 + m));
    paramb = this.DwN;
    if (paramb == null) {
      p.iCn();
    }
    int j = (paramb.getWidth() - paramView.getMeasuredWidth()) / 2;
    if (i < 0)
    {
      i += j;
      j = (paramView.getMeasuredWidth() - com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_composition_width)) / 2;
      k = 0;
    }
    for (;;)
    {
      paramb = eDt().getLayoutParams();
      if (paramb != null) {
        break;
      }
      paramArrayList = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(215477);
      throw paramArrayList;
      paramb = this.DwN;
      if (paramb == null) {
        p.iCn();
      }
      int i1 = paramb.getWidth();
      paramb = paramView.getResources();
      p.j(paramb, "anchorView.resources");
      if (i1 + i > paramb.getDisplayMetrics().widthPixels)
      {
        i -= j;
        k = paramArrayList.size() - 1;
        j = (paramView.getMeasuredWidth() - com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_composition_width)) / 2;
        paramb = this.DwN;
        if (paramb == null) {
          p.iCn();
        }
        j = j + paramb.getWidth() - paramView.getMeasuredWidth();
      }
      else
      {
        paramb = this.DwN;
        if (paramb == null) {
          p.iCn();
        }
        j = (paramb.getWidth() - com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_composition_width)) / 2;
      }
    }
    paramb = (RelativeLayout.LayoutParams)paramb;
    paramb.setMarginStart(j);
    eDt().setLayoutParams((ViewGroup.LayoutParams)paramb);
    paramb = this.Dxe;
    if (paramb == null) {
      p.iCn();
    }
    paramb = paramb.getAdapter();
    if (paramb == null)
    {
      paramArrayList = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.floatview.ImeLongClickFloatViewAdapter");
      AppMethodBeat.o(215477);
      throw paramArrayList;
    }
    ((d)paramb).Dxr = k;
    j = com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_view_long_click_margin_anchor);
    paramb = this.DwN;
    if (paramb == null) {
      p.iCn();
    }
    k = paramb.getHeight();
    paramb = com.tencent.mm.plugin.hld.f.l.DHK;
    j = j + n - k - com.tencent.mm.plugin.hld.f.l.getStatusBarHeight(this.context);
    Log.d("WxIme.ImeLongClickFloatView", "onShowView " + m + ' ' + n + " oriXOffset:" + m + " yOffset:" + j + " xOffset:" + i);
    paramb = com.tencent.mm.plugin.hld.d.a.DxH;
    if (com.tencent.mm.plugin.hld.d.a.eDz() != null) {
      paramb = com.tencent.mm.plugin.hld.d.a.DxH;
    }
    for (paramb = (View)com.tencent.mm.plugin.hld.d.a.eDz();; paramb = paramView)
    {
      try
      {
        localObject = this.DwN;
        if (localObject == null) {
          p.iCn();
        }
        ((PopupWindow)localObject).showAtLocation(paramb, 8388659, i, j);
      }
      catch (Exception paramb)
      {
        for (;;)
        {
          Log.e("WxIme.ImeLongClickFloatView", "onShowView " + paramb.getMessage());
        }
        AppMethodBeat.o(215477);
      }
      if ((paramView instanceof ImeKeyRelativeLayout)) {
        this.Dxk = ((ImeKeyRelativeLayout)paramView).getOnTouchListener();
      }
      if ((paramImeKeyRelativeLayout instanceof ImeKeyRelativeLayout)) {
        this.Dxk = paramImeKeyRelativeLayout.getOnTouchListener();
      }
      paramImeKeyRelativeLayout = this.mParentView;
      if (paramImeKeyRelativeLayout == null) {
        p.iCn();
      }
      paramImeKeyRelativeLayout.setOnTouchListener((View.OnTouchListener)this);
      paramImeKeyRelativeLayout = this.Dxi;
      if (paramImeKeyRelativeLayout == null) {
        p.iCn();
      }
      paramImeKeyRelativeLayout.add(Integer.valueOf(0));
      j = com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_composition_margin_left) + i;
      k = paramArrayList.size();
      i = 1;
      while (i < k)
      {
        j += com.tencent.mm.ci.a.aZ(this.context, a.d.ime_float_composition_width);
        paramArrayList = this.Dxi;
        if (paramArrayList == null) {
          p.iCn();
        }
        paramArrayList.add(Integer.valueOf(j));
        i += 1;
      }
    }
  }
  
  public final void i(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(215473);
    Object localObject1 = this.DwN;
    if (localObject1 != null) {
      ((PopupWindow)localObject1).dismiss();
    }
    Object localObject2 = this.Dxg;
    if (localObject2 != null)
    {
      localObject1 = this.Dxj;
      if (localObject1 != null)
      {
        localObject1 = (KeyboardView.d)((WeakReference)localObject1).get();
        ((KeyboardView)localObject2).setTouchListener((KeyboardView.d)localObject1);
      }
    }
    else
    {
      localObject1 = this.Dxk;
      if (localObject1 != null)
      {
        if (this.mParentView == null) {
          break label185;
        }
        if (((WeakReference)localObject1).get() != null)
        {
          localObject2 = this.mParentView;
          if (localObject2 == null) {
            p.iCn();
          }
          ((View)localObject2).setOnTouchListener((View.OnTouchListener)((WeakReference)localObject1).get());
        }
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject1 = this.Dxh;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.hld.keyboard.selfdraw.b)localObject1).sP(false);
        }
        localObject1 = this.lJ;
        if (localObject1 != null) {
          ((View)localObject1).setSelected(false);
        }
      }
      this.lJ = null;
      this.Dxh = null;
      this.Dxg = null;
      this.Dxj = null;
      AppMethodBeat.o(215473);
      return;
      localObject1 = null;
      break;
      label185:
      if ((this.lJ != null) && (((WeakReference)localObject1).get() != null))
      {
        localObject2 = this.lJ;
        if (localObject2 == null) {
          p.iCn();
        }
        ((View)localObject2).setOnTouchListener((View.OnTouchListener)((WeakReference)localObject1).get());
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(215471);
    Object localObject = this.Dxe;
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((RecyclerView)localObject).getAdapter();
    if (localObject == null) {
      p.iCn();
    }
    ((RecyclerView.a)localObject).notifyDataSetChanged();
    AppMethodBeat.o(215471);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(215484);
    label31:
    int k;
    if (paramMotionEvent != null)
    {
      localObject = Integer.valueOf(paramMotionEvent.getActionMasked());
      if (paramMotionEvent == null) {
        break label99;
      }
      paramMotionEvent = Float.valueOf(paramMotionEvent.getRawX());
      k = (int)((Float)paramMotionEvent).floatValue();
      Log.v("WxIme.ImeLongClickFloatView", "action " + localObject + ' ' + k);
      if (localObject != null) {
        break label107;
      }
      label80:
      if (localObject != null) {
        break label281;
      }
    }
    label99:
    label107:
    while (((Integer)localObject).intValue() != 1) {
      for (;;)
      {
        AppMethodBeat.o(215484);
        return false;
        localObject = null;
        break;
        paramMotionEvent = Double.valueOf(0.0D);
        break label31;
        if (((Integer)localObject).intValue() != 2) {
          break label80;
        }
        paramView = this.Dxi;
        if (paramView == null) {
          p.iCn();
        }
        int m = paramView.size();
        int i = 0;
        int j = 0;
        while (i < m)
        {
          paramView = this.Dxi;
          if (paramView == null) {
            p.iCn();
          }
          paramView = paramView.get(i);
          p.j(paramView, "mSideXOffsetList!![i]");
          if (p.compare(k, ((Number)paramView).intValue()) < 0) {
            break;
          }
          j = i;
          i += 1;
        }
        paramView = this.Dxm;
        if (paramView != null)
        {
          paramMotionEvent = this.Dxf.get(j);
          p.j(paramMotionEvent, "compositionList[index]");
          paramView.aLu((String)paramMotionEvent);
        }
        paramView = this.Dxe;
        if (paramView == null) {
          p.iCn();
        }
        paramView = paramView.getAdapter();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.floatview.ImeLongClickFloatViewAdapter");
          AppMethodBeat.o(215484);
          throw paramView;
        }
        ((d)paramView).Us(j);
      }
    }
    label281:
    paramMotionEvent = this.Dxm;
    if (paramMotionEvent != null) {
      paramMotionEvent.Dyh = true;
    }
    paramMotionEvent = this.lJ;
    if (paramMotionEvent != null) {
      paramMotionEvent.setOnTouchListener(null);
    }
    paramMotionEvent = this.Dxe;
    if (paramMotionEvent == null) {
      p.iCn();
    }
    paramMotionEvent = paramMotionEvent.getAdapter();
    if (paramMotionEvent == null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.floatview.ImeLongClickFloatViewAdapter");
      AppMethodBeat.o(215484);
      throw paramView;
    }
    Object localObject = ((d)paramMotionEvent).eDu();
    paramMotionEvent = (MotionEvent)localObject;
    if (localObject == null) {
      paramMotionEvent = "";
    }
    localObject = this.Dxm;
    if (localObject != null) {}
    for (paramMotionEvent = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent, ((com.tencent.mm.plugin.hld.keyboard.b)localObject).Dyi);; paramMotionEvent = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent))
    {
      localObject = (com.tencent.mm.plugin.hld.a.d)h.ae(com.tencent.mm.plugin.hld.a.d.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).eCD();
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).eCr();
          if (localObject != null) {
            ((com.tencent.mm.plugin.hld.a.c)localObject).b(paramMotionEvent);
          }
        }
      }
      paramMotionEvent = k.DDb;
      k.am(paramView, 2);
      a.a.a(this, false, 0L, 3);
      break;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/floatview/ImeLongClickFloatView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/floatview/ImeLongClickFloatView$onATouch$1", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;", "onTouch", "", "event", "Landroid/view/MotionEvent;", "plugin-hld_release"})
  public static final class c
    implements KeyboardView.d
  {
    public final boolean X(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(211044);
      p.k(paramMotionEvent, "event");
      int i = paramMotionEvent.getActionMasked();
      int k = (int)paramMotionEvent.getRawX();
      Log.v("WxIme.ImeLongClickFloatView", "action " + i + ' ' + k);
      switch (i)
      {
      default: 
      case 2: 
        for (;;)
        {
          AppMethodBeat.o(211044);
          return false;
          paramMotionEvent = c.b(this.Dxp);
          if (paramMotionEvent == null) {
            p.iCn();
          }
          int m = paramMotionEvent.size();
          i = 0;
          int j = 0;
          while (i < m)
          {
            paramMotionEvent = c.b(this.Dxp);
            if (paramMotionEvent == null) {
              p.iCn();
            }
            paramMotionEvent = paramMotionEvent.get(i);
            p.j(paramMotionEvent, "mSideXOffsetList!![i]");
            if (p.compare(k, ((Number)paramMotionEvent).intValue()) < 0) {
              break;
            }
            j = i;
            i += 1;
          }
          paramMotionEvent = c.c(this.Dxp);
          if (paramMotionEvent != null)
          {
            localObject = c.d(this.Dxp).get(j);
            p.j(localObject, "compositionList[index]");
            paramMotionEvent.aLu((String)localObject);
          }
          paramMotionEvent = c.e(this.Dxp);
          if (paramMotionEvent == null) {
            p.iCn();
          }
          paramMotionEvent = paramMotionEvent.getAdapter();
          if (paramMotionEvent == null)
          {
            paramMotionEvent = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.floatview.ImeLongClickFloatViewAdapter");
            AppMethodBeat.o(211044);
            throw paramMotionEvent;
          }
          ((d)paramMotionEvent).Us(j);
        }
      }
      paramMotionEvent = c.c(this.Dxp);
      if (paramMotionEvent != null) {
        paramMotionEvent.Dyh = true;
      }
      paramMotionEvent = c.e(this.Dxp);
      if (paramMotionEvent == null) {
        p.iCn();
      }
      paramMotionEvent = paramMotionEvent.getAdapter();
      if (paramMotionEvent == null)
      {
        paramMotionEvent = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.floatview.ImeLongClickFloatViewAdapter");
        AppMethodBeat.o(211044);
        throw paramMotionEvent;
      }
      Object localObject = ((d)paramMotionEvent).eDu();
      paramMotionEvent = (MotionEvent)localObject;
      if (localObject == null) {
        paramMotionEvent = "";
      }
      localObject = c.c(this.Dxp);
      if (localObject != null) {}
      for (paramMotionEvent = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent, ((KeyboardView.c)localObject).Dyi);; paramMotionEvent = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent))
      {
        localObject = (com.tencent.mm.plugin.hld.a.d)h.ae(com.tencent.mm.plugin.hld.a.d.class);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).eCD();
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).eCr();
            if (localObject != null) {
              ((com.tencent.mm.plugin.hld.a.c)localObject).b(paramMotionEvent);
            }
          }
        }
        paramMotionEvent = c.f(this.Dxp);
        if (paramMotionEvent != null)
        {
          localObject = k.DDb;
          k.a(paramMotionEvent, 2);
        }
        a.a.a(this.Dxp, false, 0L, 3);
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
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