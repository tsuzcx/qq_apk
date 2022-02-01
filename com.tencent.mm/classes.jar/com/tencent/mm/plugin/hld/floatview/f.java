package com.tencent.mm.plugin.hld.floatview;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView.c;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView.d;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/floatview/ImeUpperSlideFloatView;", "Lcom/tencent/mm/plugin/hld/floatview/IImeFloatView;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mAnchorView", "Landroid/view/View;", "mButton", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "mClickStr", "", "mFloatCompositionWidow", "Landroid/widget/PopupWindow;", "mLastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "mLastKeyOperationForXml", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "mMinSlideUpHeight", "", "mOnTouchListener", "Ljava/lang/ref/WeakReference;", "mOnTouchListenerForXml", "Landroid/view/View$OnTouchListener;", "mParentView", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "mParentViewForXml", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "mUpperSlideStr", "mUpperSlideTv", "Landroid/widget/TextView;", "onTouchListenerForXml", "com/tencent/mm/plugin/hld/floatview/ImeUpperSlideFloatView$onTouchListenerForXml$1", "Lcom/tencent/mm/plugin/hld/floatview/ImeUpperSlideFloatView$onTouchListenerForXml$1;", "onHide", "", "end", "", "delayMs", "", "onHideImp", "onShowView", "textList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "keyboard", "button", "lastKeyOperation", "parent", "anchorView", "onShowViewImp", "onShowViewImpForXml", "onTouch", "event", "Landroid/view/MotionEvent;", "Companion", "plugin-hld_release"})
public final class f
  implements a, KeyboardView.d
{
  public static final a DxC;
  public PopupWindow DwN;
  private int DxA;
  public final b DxB;
  public com.tencent.mm.plugin.hld.keyboard.selfdraw.b Dxh;
  public WeakReference<KeyboardView.d> Dxj;
  public WeakReference<View.OnTouchListener> Dxk;
  public KeyboardView.c Dxl;
  public com.tencent.mm.plugin.hld.keyboard.b Dxm;
  public ImeKeyRelativeLayout Dxv;
  public TextView Dxw;
  public KeyboardView Dxx;
  public String Dxy;
  public String Dxz;
  public final Context context;
  public View lJ;
  
  static
  {
    AppMethodBeat.i(209452);
    DxC = new a((byte)0);
    AppMethodBeat.o(209452);
  }
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(209451);
    this.context = paramContext;
    paramContext = ad.kS(this.context).inflate(a.h.ime_upper_slide_float_view, null, false);
    PopupWindow localPopupWindow = new PopupWindow(paramContext);
    localPopupWindow.setClippingEnabled(false);
    localPopupWindow.setInputMethodMode(2);
    localPopupWindow.setTouchable(false);
    if (Build.VERSION.SDK_INT >= 23)
    {
      com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
      localPopupWindow.setWindowLayoutType(1003);
    }
    this.DwN = localPopupWindow;
    this.Dxw = ((TextView)paramContext.findViewById(a.f.upper_slide_tv));
    this.DxA = com.tencent.mm.ci.a.aZ(this.context, a.d.ime_upper_slide_min_height);
    this.DxB = new b(this);
    AppMethodBeat.o(209451);
  }
  
  private final void eDx()
  {
    AppMethodBeat.i(209450);
    PopupWindow localPopupWindow = this.DwN;
    if (localPopupWindow != null)
    {
      localPopupWindow.dismiss();
      AppMethodBeat.o(209450);
      return;
    }
    AppMethodBeat.o(209450);
  }
  
  public final boolean X(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209448);
    p.k(paramMotionEvent, "event");
    int i = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 2: 
      for (;;)
      {
        AppMethodBeat.o(209448);
        return false;
        KeyboardView.c localc = this.Dxl;
        if (localc != null)
        {
          Log.d("WxIme.ImeUpperSlideFloatView", "onTouch yOffset:" + (localc.y - i) + " minHeight:" + this.DxA);
          if (localc.y - i > this.DxA)
          {
            paramMotionEvent = this.Dxh;
            if (paramMotionEvent != null)
            {
              localObject = paramMotionEvent.floatText;
              paramMotionEvent = (MotionEvent)localObject;
              if (localObject != null) {}
            }
            else
            {
              paramMotionEvent = "";
            }
            localc.aLu(paramMotionEvent);
            paramMotionEvent = this.DwN;
            if ((paramMotionEvent == null) || (paramMotionEvent.isShowing() != true)) {
              eDw();
            }
          }
          else
          {
            paramMotionEvent = this.Dxh;
            if (paramMotionEvent != null)
            {
              localObject = paramMotionEvent.floatText;
              paramMotionEvent = (MotionEvent)localObject;
              if (localObject != null) {}
            }
            else
            {
              paramMotionEvent = "";
            }
            localc.aLu(paramMotionEvent);
            eDx();
          }
        }
      }
    }
    paramMotionEvent = this.Dxl;
    if (paramMotionEvent != null) {
      paramMotionEvent.Dyh = true;
    }
    paramMotionEvent = this.DwN;
    if ((paramMotionEvent == null) || (paramMotionEvent.isShowing() != true))
    {
      paramMotionEvent = this.Dxz;
      if (paramMotionEvent != null)
      {
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new t("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(209448);
          throw paramMotionEvent;
        }
        localObject = n.bb((CharSequence)paramMotionEvent).toString();
        paramMotionEvent = (MotionEvent)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramMotionEvent = "";
      }
      localObject = com.tencent.mm.plugin.hld.model.g.DCm;
      if (com.tencent.mm.plugin.hld.model.g.eEk())
      {
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(209448);
          throw paramMotionEvent;
        }
        paramMotionEvent = paramMotionEvent.toUpperCase();
        p.j(paramMotionEvent, "(this as java.lang.String).toUpperCase()");
        label336:
        localObject = this.Dxl;
        if (localObject == null) {
          break label466;
        }
      }
      label466:
      for (paramMotionEvent = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent, ((KeyboardView.c)localObject).Dyi);; paramMotionEvent = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent))
      {
        localObject = (d)h.ae(d.class);
        if (localObject != null)
        {
          localObject = ((d)localObject).eCD();
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).eCr();
            if (localObject != null) {
              ((c)localObject).b(paramMotionEvent);
            }
          }
        }
        paramMotionEvent = this.Dxh;
        if (paramMotionEvent != null)
        {
          localObject = k.DDb;
          k.a(paramMotionEvent, 1);
        }
        a.a.a(this, false, 0L, 3);
        break;
        if (paramMotionEvent == null)
        {
          paramMotionEvent = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(209448);
          throw paramMotionEvent;
        }
        paramMotionEvent = paramMotionEvent.toLowerCase();
        p.j(paramMotionEvent, "(this as java.lang.String).toLowerCase()");
        break label336;
      }
    }
    paramMotionEvent = this.Dxy;
    if (paramMotionEvent != null)
    {
      if (paramMotionEvent == null)
      {
        paramMotionEvent = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(209448);
        throw paramMotionEvent;
      }
      localObject = n.bb((CharSequence)paramMotionEvent).toString();
      paramMotionEvent = (MotionEvent)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramMotionEvent = "";
    }
    Object localObject = this.Dxl;
    if (localObject != null) {}
    for (paramMotionEvent = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent, ((KeyboardView.c)localObject).Dyi);; paramMotionEvent = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent))
    {
      localObject = (d)h.ae(d.class);
      if (localObject != null)
      {
        localObject = ((d)localObject).eCD();
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).eCr();
          if (localObject != null) {
            ((c)localObject).b(paramMotionEvent);
          }
        }
      }
      paramMotionEvent = this.Dxh;
      if (paramMotionEvent == null) {
        break;
      }
      localObject = k.DDb;
      k.a(paramMotionEvent, 3);
      break;
    }
  }
  
  public final void eDv()
  {
    AppMethodBeat.i(209447);
    Object localObject1 = new int[2];
    Object localObject2 = this.lJ;
    if (localObject2 == null) {
      p.iCn();
    }
    ((View)localObject2).getLocationInWindow((int[])localObject1);
    int i = localObject1[0];
    localObject2 = this.lJ;
    if (localObject2 == null) {
      p.iCn();
    }
    ((View)localObject2).getLocationOnScreen((int[])localObject1);
    int j = localObject1[1];
    int k = com.tencent.mm.ci.a.aZ(this.context, a.d.ime_upper_slide_float_view_margin_top);
    int m = com.tencent.mm.ci.a.aZ(this.context, a.d.ime_upper_slide_float_view_height);
    localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
    int n = com.tencent.mm.plugin.hld.f.l.getStatusBarHeight(this.context);
    localObject1 = this.DwN;
    if (localObject1 == null) {
      p.iCn();
    }
    int i1 = ((PopupWindow)localObject1).getWidth();
    localObject1 = this.lJ;
    if (localObject1 == null) {
      p.iCn();
    }
    i1 = (i1 - ((View)localObject1).getMeasuredWidth()) / 2;
    localObject1 = com.tencent.mm.plugin.hld.d.a.DxH;
    if (com.tencent.mm.plugin.hld.d.a.eDz() != null) {
      localObject1 = com.tencent.mm.plugin.hld.d.a.DxH;
    }
    for (localObject1 = (View)com.tencent.mm.plugin.hld.d.a.eDz();; localObject1 = this.lJ) {
      try
      {
        localObject2 = this.DwN;
        if (localObject2 == null) {
          p.iCn();
        }
        ((PopupWindow)localObject2).showAtLocation((View)localObject1, 8388659, i - i1, j + k - m - n);
        AppMethodBeat.o(209447);
        return;
      }
      catch (Exception localException)
      {
        Log.e("WxIme.ImeUpperSlideFloatView", "onShowView " + localException.getMessage());
        AppMethodBeat.o(209447);
      }
    }
  }
  
  public final void eDw()
  {
    AppMethodBeat.i(209449);
    Object localObject1 = new int[2];
    Object localObject2 = this.Dxx;
    if (localObject2 == null) {
      p.iCn();
    }
    ((KeyboardView)localObject2).getLocationInWindow((int[])localObject1);
    int i = localObject1[0];
    localObject2 = this.Dxh;
    if (localObject2 == null) {
      p.iCn();
    }
    int j = ((com.tencent.mm.plugin.hld.keyboard.selfdraw.b)localObject2).DzC.left;
    localObject2 = this.Dxx;
    if (localObject2 == null) {
      p.iCn();
    }
    ((KeyboardView)localObject2).getLocationOnScreen((int[])localObject1);
    int k = localObject1[1];
    localObject1 = this.Dxh;
    if (localObject1 == null) {
      p.iCn();
    }
    int m = ((com.tencent.mm.plugin.hld.keyboard.selfdraw.b)localObject1).DzC.top;
    int n = com.tencent.mm.ci.a.aZ(this.context, a.d.ime_upper_slide_float_view_margin_top);
    int i1 = com.tencent.mm.ci.a.aZ(this.context, a.d.ime_upper_slide_float_view_height);
    localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
    int i2 = com.tencent.mm.plugin.hld.f.l.getStatusBarHeight(this.context);
    localObject1 = this.DwN;
    if (localObject1 == null) {
      p.iCn();
    }
    int i3 = ((PopupWindow)localObject1).getWidth();
    localObject1 = this.Dxh;
    if (localObject1 == null) {
      p.iCn();
    }
    i3 = (i3 - ((com.tencent.mm.plugin.hld.keyboard.selfdraw.b)localObject1).width) / 2;
    localObject1 = com.tencent.mm.plugin.hld.d.a.DxH;
    if (com.tencent.mm.plugin.hld.d.a.eDz() != null) {
      localObject1 = com.tencent.mm.plugin.hld.d.a.DxH;
    }
    for (localObject1 = (View)com.tencent.mm.plugin.hld.d.a.eDz();; localObject1 = (View)this.Dxx) {
      try
      {
        localObject2 = this.DwN;
        if (localObject2 == null) {
          p.iCn();
        }
        ((PopupWindow)localObject2).showAtLocation((View)localObject1, 8388659, i + j - i3, k + m + n - i1 - i2);
        AppMethodBeat.o(209449);
        return;
      }
      catch (Exception localException)
      {
        Log.e("WxIme.ImeUpperSlideFloatView", "onShowView " + localException.getMessage());
        AppMethodBeat.o(209449);
      }
    }
  }
  
  public final void i(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(209446);
    eDx();
    Object localObject1 = this.Dxk;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
    {
      localObject2 = this.Dxv;
      if (localObject2 == null) {
        p.iCn();
      }
      ((ImeKeyRelativeLayout)localObject2).setOnTouchListener((View.OnTouchListener)((WeakReference)localObject1).get());
    }
    Object localObject2 = this.Dxx;
    if (localObject2 != null)
    {
      localObject1 = this.Dxj;
      if (localObject1 == null) {
        break label160;
      }
    }
    label160:
    for (localObject1 = (KeyboardView.d)((WeakReference)localObject1).get();; localObject1 = null)
    {
      ((KeyboardView)localObject2).setTouchListener((KeyboardView.d)localObject1);
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
      this.Dxx = null;
      this.Dxj = null;
      AppMethodBeat.o(209446);
      return;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/floatview/ImeUpperSlideFloatView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/floatview/ImeUpperSlideFloatView$onTouchListenerForXml$1", "Landroid/view/View$OnTouchListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-hld_release"})
  public static final class b
    implements View.OnTouchListener
  {
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(217474);
      int i;
      if (paramMotionEvent != null)
      {
        localObject = Float.valueOf(paramMotionEvent.getRawY());
        i = (int)((Float)localObject).floatValue();
        if (paramMotionEvent == null) {
          break label64;
        }
        paramMotionEvent = Integer.valueOf(paramMotionEvent.getActionMasked());
        label40:
        if (paramMotionEvent != null) {
          break label69;
        }
        label44:
        if (paramMotionEvent != null) {
          break label254;
        }
      }
      label64:
      label69:
      label254:
      while (paramMotionEvent.intValue() != 1) {
        for (;;)
        {
          AppMethodBeat.o(217474);
          return false;
          localObject = Double.valueOf(0.0D);
          break;
          paramMotionEvent = null;
          break label40;
          if (paramMotionEvent.intValue() != 2) {
            break label44;
          }
          localObject = f.a(this.DxD);
          if (localObject != null)
          {
            Log.d("WxIme.ImeUpperSlideFloatView", "onTouch yOffset:" + (((com.tencent.mm.plugin.hld.keyboard.b)localObject).y - i) + " minHeight:" + f.b(this.DxD));
            if (((com.tencent.mm.plugin.hld.keyboard.b)localObject).y - i > f.b(this.DxD))
            {
              paramView = f.c(this.DxD);
              if (paramView != null)
              {
                paramMotionEvent = paramView.getSecondText();
                paramView = paramMotionEvent;
                if (paramMotionEvent != null) {}
              }
              else
              {
                paramView = "";
              }
              ((com.tencent.mm.plugin.hld.keyboard.b)localObject).aLu(paramView);
              paramView = f.d(this.DxD);
              if ((paramView == null) || (paramView.isShowing() != true)) {
                f.e(this.DxD);
              }
            }
            else
            {
              paramView = f.c(this.DxD);
              if (paramView != null)
              {
                paramMotionEvent = paramView.getText();
                paramView = paramMotionEvent;
                if (paramMotionEvent != null) {}
              }
              else
              {
                paramView = "";
              }
              ((com.tencent.mm.plugin.hld.keyboard.b)localObject).aLu(paramView);
              f.f(this.DxD);
            }
          }
        }
      }
      paramMotionEvent = f.a(this.DxD);
      if (paramMotionEvent != null) {
        paramMotionEvent.Dyh = true;
      }
      paramMotionEvent = f.g(this.DxD);
      if (paramMotionEvent != null) {
        paramMotionEvent.setOnTouchListener(null);
      }
      paramMotionEvent = f.d(this.DxD);
      if ((paramMotionEvent == null) || (paramMotionEvent.isShowing() != true))
      {
        paramMotionEvent = f.h(this.DxD);
        if (paramMotionEvent != null)
        {
          if (paramMotionEvent == null)
          {
            paramView = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(217474);
            throw paramView;
          }
          localObject = n.bb((CharSequence)paramMotionEvent).toString();
          paramMotionEvent = (MotionEvent)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramMotionEvent = "";
        }
        localObject = com.tencent.mm.plugin.hld.model.g.DCm;
        if (com.tencent.mm.plugin.hld.model.g.eEk())
        {
          if (paramMotionEvent == null)
          {
            paramView = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(217474);
            throw paramView;
          }
          paramMotionEvent = paramMotionEvent.toUpperCase();
          p.j(paramMotionEvent, "(this as java.lang.String).toUpperCase()");
          label415:
          localObject = f.a(this.DxD);
          if (localObject == null) {
            break label552;
          }
        }
        label552:
        for (paramMotionEvent = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent, ((com.tencent.mm.plugin.hld.keyboard.b)localObject).Dyi);; paramMotionEvent = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent))
        {
          localObject = (d)h.ae(d.class);
          if (localObject != null)
          {
            localObject = ((d)localObject).eCD();
            if (localObject != null)
            {
              localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).eCr();
              if (localObject != null) {
                ((c)localObject).b(paramMotionEvent);
              }
            }
          }
          paramMotionEvent = k.DDb;
          k.am(paramView, 1);
          a.a.a(this.DxD, false, 0L, 3);
          break;
          if (paramMotionEvent == null)
          {
            paramView = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(217474);
            throw paramView;
          }
          paramMotionEvent = paramMotionEvent.toLowerCase();
          p.j(paramMotionEvent, "(this as java.lang.String).toLowerCase()");
          break label415;
        }
      }
      paramMotionEvent = f.i(this.DxD);
      if (paramMotionEvent != null)
      {
        if (paramMotionEvent == null)
        {
          paramView = new t("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(217474);
          throw paramView;
        }
        localObject = n.bb((CharSequence)paramMotionEvent).toString();
        paramMotionEvent = (MotionEvent)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramMotionEvent = "";
      }
      Object localObject = f.a(this.DxD);
      if (localObject != null) {}
      for (paramMotionEvent = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent, ((com.tencent.mm.plugin.hld.keyboard.b)localObject).Dyi);; paramMotionEvent = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent))
      {
        localObject = (d)h.ae(d.class);
        if (localObject != null)
        {
          localObject = ((d)localObject).eCD();
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).eCr();
            if (localObject != null) {
              ((c)localObject).b(paramMotionEvent);
            }
          }
        }
        paramMotionEvent = k.DDb;
        k.am(paramView, 3);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.floatview.f
 * JD-Core Version:    0.7.0.1
 */