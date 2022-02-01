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
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView.c;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView.d;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/floatview/ImeUpperSlideFloatView;", "Lcom/tencent/mm/plugin/hld/floatview/IImeFloatView;", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$OnTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mAnchorView", "Landroid/view/View;", "mButton", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "mClickStr", "", "mFloatCompositionWidow", "Landroid/widget/PopupWindow;", "mLastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "mLastKeyOperationForXml", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "mMinSlideUpHeight", "", "mOnTouchListener", "Ljava/lang/ref/WeakReference;", "mOnTouchListenerForXml", "Landroid/view/View$OnTouchListener;", "mParentView", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "mParentViewForXml", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "mUpperSlideStr", "mUpperSlideTv", "Landroid/widget/TextView;", "onTouchListenerForXml", "com/tencent/mm/plugin/hld/floatview/ImeUpperSlideFloatView$onTouchListenerForXml$1", "Lcom/tencent/mm/plugin/hld/floatview/ImeUpperSlideFloatView$onTouchListenerForXml$1;", "onHide", "", "end", "", "delayMs", "", "onHideImp", "onShowView", "textList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "keyboard", "button", "lastKeyOperation", "parent", "anchorView", "onShowViewImp", "onShowViewImpForXml", "onTouch", "event", "Landroid/view/MotionEvent;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements a, KeyboardView.d
{
  public static final f.a JqA;
  public PopupWindow JpU;
  public ImeKeyRelativeLayout JqB;
  public TextView JqC;
  public KeyboardView JqD;
  public String JqE;
  public String JqF;
  private int JqG;
  public final b JqH;
  public com.tencent.mm.plugin.hld.keyboard.selfdraw.b Jqn;
  public WeakReference<KeyboardView.d> Jqp;
  public WeakReference<View.OnTouchListener> Jqq;
  public KeyboardView.c Jqr;
  public com.tencent.mm.plugin.hld.keyboard.b Jqs;
  public final Context context;
  public View mF;
  
  static
  {
    AppMethodBeat.i(312849);
    JqA = new f.a((byte)0);
    AppMethodBeat.o(312849);
  }
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(312794);
    this.context = paramContext;
    paramContext = af.mU(this.context).inflate(a.h.ime_upper_slide_float_view, null, false);
    PopupWindow localPopupWindow = new PopupWindow(paramContext);
    localPopupWindow.setClippingEnabled(false);
    localPopupWindow.setInputMethodMode(2);
    localPopupWindow.setTouchable(false);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = l.JyV;
      localPopupWindow.setWindowLayoutType(l.fOG());
    }
    Object localObject = ah.aiuX;
    this.JpU = localPopupWindow;
    this.JqC = ((TextView)paramContext.findViewById(a.f.upper_slide_tv));
    this.JqG = com.tencent.mm.cd.a.bs(this.context, a.d.ime_upper_slide_min_height);
    this.JqH = new b(this);
    AppMethodBeat.o(312794);
  }
  
  private final void fLx()
  {
    AppMethodBeat.i(312798);
    PopupWindow localPopupWindow = this.JpU;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
    AppMethodBeat.o(312798);
  }
  
  public final boolean Z(MotionEvent paramMotionEvent)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i = 1;
    AppMethodBeat.i(312880);
    s.u(paramMotionEvent, "event");
    int j = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 2: 
      do
      {
        AppMethodBeat.o(312880);
        return false;
        localObject2 = this.Jqr;
      } while (localObject2 == null);
      Log.d("WxIme.ImeUpperSlideFloatView", "onTouch yOffset:" + (((KeyboardView.c)localObject2).y - j) + " minHeight:" + this.JqG);
      if (((KeyboardView.c)localObject2).y - j > this.JqG)
      {
        paramMotionEvent = this.Jqn;
        if (paramMotionEvent == null)
        {
          paramMotionEvent = "";
          label140:
          ((KeyboardView.c)localObject2).aIl(paramMotionEvent);
          paramMotionEvent = this.JpU;
          if ((paramMotionEvent == null) || (paramMotionEvent.isShowing() != true)) {
            break label195;
          }
        }
        while (i == 0)
        {
          fLw();
          break;
          localObject1 = paramMotionEvent.floatText;
          paramMotionEvent = (MotionEvent)localObject1;
          if (localObject1 != null) {
            break label140;
          }
          paramMotionEvent = "";
          break label140;
          label195:
          i = 0;
        }
      }
      paramMotionEvent = this.Jqn;
      if (paramMotionEvent == null) {
        paramMotionEvent = "";
      }
      for (;;)
      {
        ((KeyboardView.c)localObject2).aIl(paramMotionEvent);
        fLx();
        break;
        localObject1 = paramMotionEvent.floatText;
        paramMotionEvent = (MotionEvent)localObject1;
        if (localObject1 == null) {
          paramMotionEvent = "";
        }
      }
    }
    paramMotionEvent = this.Jqr;
    if (paramMotionEvent != null) {
      paramMotionEvent.Jrl = true;
    }
    paramMotionEvent = this.JpU;
    if ((paramMotionEvent != null) && (paramMotionEvent.isShowing() == true))
    {
      i = 1;
      label280:
      if (i != 0) {
        break label494;
      }
      paramMotionEvent = this.JqF;
      if (paramMotionEvent != null) {
        break label433;
      }
      paramMotionEvent = "";
      label297:
      localObject1 = com.tencent.mm.plugin.hld.model.g.JuL;
      if (!com.tencent.mm.plugin.hld.model.g.fMm()) {
        break label460;
      }
      localObject1 = paramMotionEvent.toUpperCase();
      s.s(localObject1, "(this as java.lang.String).toUpperCase()");
      label322:
      paramMotionEvent = this.Jqr;
      if (paramMotionEvent != null) {
        break label477;
      }
    }
    label433:
    label460:
    label477:
    for (paramMotionEvent = (MotionEvent)localObject2;; paramMotionEvent = new com.tencent.mm.plugin.hld.a.g((String)localObject1, paramMotionEvent.Jrm))
    {
      localObject2 = paramMotionEvent;
      if (paramMotionEvent == null) {
        localObject2 = new com.tencent.mm.plugin.hld.a.g((String)localObject1);
      }
      paramMotionEvent = (d)h.ax(d.class);
      if (paramMotionEvent != null)
      {
        paramMotionEvent = paramMotionEvent.fKG();
        if (paramMotionEvent != null)
        {
          paramMotionEvent = paramMotionEvent.fKC();
          if (paramMotionEvent != null) {
            paramMotionEvent.b((com.tencent.mm.plugin.hld.a.g)localObject2);
          }
        }
      }
      paramMotionEvent = this.Jqn;
      if (paramMotionEvent != null)
      {
        localObject1 = k.JvH;
        k.a(paramMotionEvent, 1);
      }
      a.a.a((a)this, false, 0L, 3);
      break;
      i = 0;
      break label280;
      localObject1 = n.bq((CharSequence)paramMotionEvent).toString();
      paramMotionEvent = (MotionEvent)localObject1;
      if (localObject1 != null) {
        break label297;
      }
      paramMotionEvent = "";
      break label297;
      localObject1 = paramMotionEvent.toLowerCase();
      s.s(localObject1, "(this as java.lang.String).toLowerCase()");
      break label322;
    }
    label494:
    paramMotionEvent = this.JqE;
    if (paramMotionEvent == null)
    {
      paramMotionEvent = "";
      label507:
      localObject2 = this.Jqr;
      if (localObject2 != null) {
        break label630;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent);
      }
      paramMotionEvent = (d)h.ax(d.class);
      if (paramMotionEvent != null)
      {
        paramMotionEvent = paramMotionEvent.fKG();
        if (paramMotionEvent != null)
        {
          paramMotionEvent = paramMotionEvent.fKC();
          if (paramMotionEvent != null) {
            paramMotionEvent.b((com.tencent.mm.plugin.hld.a.g)localObject2);
          }
        }
      }
      paramMotionEvent = this.Jqn;
      if (paramMotionEvent == null) {
        break;
      }
      localObject1 = k.JvH;
      k.a(paramMotionEvent, 3);
      break;
      localObject2 = n.bq((CharSequence)paramMotionEvent).toString();
      paramMotionEvent = (MotionEvent)localObject2;
      if (localObject2 != null) {
        break label507;
      }
      paramMotionEvent = "";
      break label507;
      label630:
      localObject1 = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent, ((KeyboardView.c)localObject2).Jrm);
    }
  }
  
  public final void fLv()
  {
    AppMethodBeat.i(312866);
    Object localObject1 = new int[2];
    Object localObject2 = this.mF;
    s.checkNotNull(localObject2);
    ((View)localObject2).getLocationInWindow((int[])localObject1);
    int i = localObject1[0];
    localObject2 = this.mF;
    s.checkNotNull(localObject2);
    ((View)localObject2).getLocationOnScreen((int[])localObject1);
    int j = localObject1[1];
    int k = com.tencent.mm.cd.a.bs(this.context, a.d.ime_upper_slide_float_view_margin_top);
    int m = com.tencent.mm.cd.a.bs(this.context, a.d.ime_upper_slide_float_view_height);
    localObject1 = l.JyV;
    int n = l.getStatusBarHeight(this.context);
    localObject1 = this.JpU;
    s.checkNotNull(localObject1);
    int i1 = ((PopupWindow)localObject1).getWidth();
    localObject1 = this.mF;
    s.checkNotNull(localObject1);
    i1 = (i1 - ((View)localObject1).getMeasuredWidth()) / 2;
    localObject1 = com.tencent.mm.plugin.hld.d.a.JqJ;
    if (com.tencent.mm.plugin.hld.d.a.fLA() != null) {
      localObject1 = com.tencent.mm.plugin.hld.d.a.JqJ;
    }
    for (localObject1 = (View)com.tencent.mm.plugin.hld.d.a.fLA();; localObject1 = this.mF) {
      try
      {
        localObject2 = this.JpU;
        s.checkNotNull(localObject2);
        ((PopupWindow)localObject2).showAtLocation((View)localObject1, 8388659, i - i1, j + k - m - n);
        AppMethodBeat.o(312866);
        return;
      }
      catch (Exception localException)
      {
        Log.e("WxIme.ImeUpperSlideFloatView", s.X("onShowView ", localException.getMessage()));
        AppMethodBeat.o(312866);
      }
    }
  }
  
  public final void fLw()
  {
    AppMethodBeat.i(312888);
    Object localObject1 = new int[2];
    Object localObject2 = this.JqD;
    s.checkNotNull(localObject2);
    ((KeyboardView)localObject2).getLocationInWindow((int[])localObject1);
    int i = localObject1[0];
    localObject2 = this.Jqn;
    s.checkNotNull(localObject2);
    int j = ((com.tencent.mm.plugin.hld.keyboard.selfdraw.b)localObject2).JsF.left;
    localObject2 = this.JqD;
    s.checkNotNull(localObject2);
    ((KeyboardView)localObject2).getLocationOnScreen((int[])localObject1);
    int k = localObject1[1];
    localObject1 = this.Jqn;
    s.checkNotNull(localObject1);
    int m = ((com.tencent.mm.plugin.hld.keyboard.selfdraw.b)localObject1).JsF.top;
    int n = com.tencent.mm.cd.a.bs(this.context, a.d.ime_upper_slide_float_view_margin_top);
    int i1 = com.tencent.mm.cd.a.bs(this.context, a.d.ime_upper_slide_float_view_height);
    localObject1 = l.JyV;
    int i2 = l.getStatusBarHeight(this.context);
    localObject1 = this.JpU;
    s.checkNotNull(localObject1);
    int i3 = ((PopupWindow)localObject1).getWidth();
    localObject1 = this.Jqn;
    s.checkNotNull(localObject1);
    i3 = (i3 - ((com.tencent.mm.plugin.hld.keyboard.selfdraw.b)localObject1).width) / 2;
    localObject1 = com.tencent.mm.plugin.hld.d.a.JqJ;
    if (com.tencent.mm.plugin.hld.d.a.fLA() != null) {
      localObject1 = com.tencent.mm.plugin.hld.d.a.JqJ;
    }
    for (localObject1 = (View)com.tencent.mm.plugin.hld.d.a.fLA();; localObject1 = (View)this.JqD) {
      try
      {
        localObject2 = this.JpU;
        s.checkNotNull(localObject2);
        ((PopupWindow)localObject2).showAtLocation((View)localObject1, 8388659, i + j - i3, k + m + n - i1 - i2);
        AppMethodBeat.o(312888);
        return;
      }
      catch (Exception localException)
      {
        Log.e("WxIme.ImeUpperSlideFloatView", s.X("onShowView ", localException.getMessage()));
        AppMethodBeat.o(312888);
      }
    }
  }
  
  public final void l(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(312860);
    fLx();
    Object localObject1 = this.Jqq;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
    {
      localObject2 = this.JqB;
      s.checkNotNull(localObject2);
      ((ImeKeyRelativeLayout)localObject2).setOnTouchListener((View.OnTouchListener)((WeakReference)localObject1).get());
    }
    Object localObject2 = this.JqD;
    if (localObject2 != null)
    {
      localObject1 = this.Jqp;
      if (localObject1 != null) {
        break label150;
      }
    }
    label150:
    for (localObject1 = null;; localObject1 = (KeyboardView.d)((WeakReference)localObject1).get())
    {
      ((KeyboardView)localObject2).setTouchListener((KeyboardView.d)localObject1);
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
      this.JqD = null;
      this.Jqp = null;
      AppMethodBeat.o(312860);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/floatview/ImeUpperSlideFloatView$onTouchListenerForXml$1", "Landroid/view/View$OnTouchListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements View.OnTouchListener
  {
    b(f paramf) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      Object localObject3 = null;
      Object localObject2 = null;
      int i = 1;
      AppMethodBeat.i(312777);
      int j;
      if (paramMotionEvent == null)
      {
        localObject1 = Double.valueOf(0.0D);
        j = (int)((Float)localObject1).floatValue();
        if (paramMotionEvent != null) {
          break label67;
        }
        paramMotionEvent = null;
        label40:
        if (paramMotionEvent != null) {
          break label78;
        }
        label44:
        if (paramMotionEvent != null) {
          break label278;
        }
      }
      label67:
      label78:
      label229:
      label232:
      label234:
      while (paramMotionEvent.intValue() != 1)
      {
        for (;;)
        {
          AppMethodBeat.o(312777);
          return false;
          localObject1 = Float.valueOf(paramMotionEvent.getRawY());
          break;
          paramMotionEvent = Integer.valueOf(paramMotionEvent.getActionMasked());
          break label40;
          if (paramMotionEvent.intValue() != 2) {
            break label44;
          }
          localObject2 = f.a(this.JqI);
          if (localObject2 != null)
          {
            localObject1 = this.JqI;
            Log.d("WxIme.ImeUpperSlideFloatView", "onTouch yOffset:" + (((com.tencent.mm.plugin.hld.keyboard.b)localObject2).y - j) + " minHeight:" + f.f((f)localObject1));
            if (((com.tencent.mm.plugin.hld.keyboard.b)localObject2).y - j <= f.f((f)localObject1)) {
              break label234;
            }
            paramView = f.g((f)localObject1);
            if (paramView == null)
            {
              paramView = "";
              ((com.tencent.mm.plugin.hld.keyboard.b)localObject2).aIl(paramView);
              paramView = f.c((f)localObject1);
              if ((paramView == null) || (paramView.isShowing() != true)) {
                break label229;
              }
            }
            for (;;)
            {
              if (i != 0) {
                break label232;
              }
              f.h((f)localObject1);
              break;
              paramMotionEvent = paramView.getSecondText();
              paramView = paramMotionEvent;
              if (paramMotionEvent != null) {
                break label176;
              }
              paramView = "";
              break label176;
              i = 0;
            }
          }
        }
        paramView = f.g((f)localObject1);
        if (paramView == null) {
          paramView = "";
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.hld.keyboard.b)localObject2).aIl(paramView);
          f.i((f)localObject1);
          break;
          paramMotionEvent = paramView.getText();
          paramView = paramMotionEvent;
          if (paramMotionEvent == null) {
            paramView = "";
          }
        }
      }
      label176:
      paramMotionEvent = f.a(this.JqI);
      label278:
      if (paramMotionEvent != null) {
        paramMotionEvent.Jrl = true;
      }
      paramMotionEvent = f.b(this.JqI);
      if (paramMotionEvent != null) {
        paramMotionEvent.setOnTouchListener(null);
      }
      paramMotionEvent = f.c(this.JqI);
      if ((paramMotionEvent != null) && (paramMotionEvent.isShowing() == true))
      {
        i = 1;
        label342:
        if (i != 0) {
          break label550;
        }
        paramMotionEvent = f.d(this.JqI);
        if (paramMotionEvent != null) {
          break label491;
        }
        paramMotionEvent = "";
        label361:
        localObject1 = com.tencent.mm.plugin.hld.model.g.JuL;
        if (!com.tencent.mm.plugin.hld.model.g.fMm()) {
          break label517;
        }
        localObject1 = paramMotionEvent.toUpperCase();
        s.s(localObject1, "(this as java.lang.String).toUpperCase()");
        label385:
        paramMotionEvent = f.a(this.JqI);
        if (paramMotionEvent != null) {
          break label533;
        }
      }
      label517:
      label533:
      for (paramMotionEvent = (MotionEvent)localObject2;; paramMotionEvent = new com.tencent.mm.plugin.hld.a.g((String)localObject1, paramMotionEvent.Jrm))
      {
        localObject2 = paramMotionEvent;
        if (paramMotionEvent == null) {
          localObject2 = new com.tencent.mm.plugin.hld.a.g((String)localObject1);
        }
        paramMotionEvent = (d)h.ax(d.class);
        if (paramMotionEvent != null)
        {
          paramMotionEvent = paramMotionEvent.fKG();
          if (paramMotionEvent != null)
          {
            paramMotionEvent = paramMotionEvent.fKC();
            if (paramMotionEvent != null) {
              paramMotionEvent.b((com.tencent.mm.plugin.hld.a.g)localObject2);
            }
          }
        }
        paramMotionEvent = k.JvH;
        k.aB(paramView, 1);
        a.a.a((a)this.JqI, false, 0L, 3);
        break;
        i = 0;
        break label342;
        label491:
        localObject1 = n.bq((CharSequence)paramMotionEvent).toString();
        paramMotionEvent = (MotionEvent)localObject1;
        if (localObject1 != null) {
          break label361;
        }
        paramMotionEvent = "";
        break label361;
        localObject1 = paramMotionEvent.toLowerCase();
        s.s(localObject1, "(this as java.lang.String).toLowerCase()");
        break label385;
      }
      label550:
      paramMotionEvent = f.e(this.JqI);
      if (paramMotionEvent == null)
      {
        paramMotionEvent = "";
        label565:
        localObject1 = f.a(this.JqI);
        if (localObject1 != null) {
          break label683;
        }
      }
      label683:
      for (Object localObject1 = localObject3;; localObject1 = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent, ((com.tencent.mm.plugin.hld.keyboard.b)localObject1).Jrm))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new com.tencent.mm.plugin.hld.a.g(paramMotionEvent);
        }
        paramMotionEvent = (d)h.ax(d.class);
        if (paramMotionEvent != null)
        {
          paramMotionEvent = paramMotionEvent.fKG();
          if (paramMotionEvent != null)
          {
            paramMotionEvent = paramMotionEvent.fKC();
            if (paramMotionEvent != null) {
              paramMotionEvent.b((com.tencent.mm.plugin.hld.a.g)localObject2);
            }
          }
        }
        paramMotionEvent = k.JvH;
        k.aB(paramView, 3);
        break;
        localObject1 = n.bq((CharSequence)paramMotionEvent).toString();
        paramMotionEvent = (MotionEvent)localObject1;
        if (localObject1 != null) {
          break label565;
        }
        paramMotionEvent = "";
        break label565;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.floatview.f
 * JD-Core Version:    0.7.0.1
 */