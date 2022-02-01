package com.tencent.mm.plugin.hld.e;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.f.k;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.KeyboardView.c;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/key/ImeKeyboardMoveCursorListener;", "", "()V", "TAG", "", "mAnchorView", "Landroid/view/View;", "mFirstMove", "", "mImeSelection", "Lcom/tencent/mm/plugin/hld/api/ImeSelection;", "mLastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "mLastKeyOperationForXml", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "mOnTouchListener", "Ljava/lang/ref/WeakReference;", "Landroid/view/View$OnTouchListener;", "mParentView", "mStartIndex", "", "mStartXOffset", "onTouchListener", "com/tencent/mm/plugin/hld/key/ImeKeyboardMoveCursorListener$onTouchListener$1", "Lcom/tencent/mm/plugin/hld/key/ImeKeyboardMoveCursorListener$onTouchListener$1;", "onTouchListenerForXml", "com/tencent/mm/plugin/hld/key/ImeKeyboardMoveCursorListener$onTouchListenerForXml$1", "Lcom/tencent/mm/plugin/hld/key/ImeKeyboardMoveCursorListener$onTouchListenerForXml$1;", "registerListener", "", "anchorView", "lastKeyOperation", "startXOffset", "parent", "releaseListener", "plugin-hld_release"})
public final class c
{
  private static com.tencent.mm.plugin.hld.a.h DxK;
  private static int DxL;
  private static boolean DxM;
  private static final a DxN;
  private static final b DxO;
  public static final c DxP;
  private static WeakReference<View.OnTouchListener> Dxj;
  private static KeyboardView.c Dxl;
  private static com.tencent.mm.plugin.hld.keyboard.b Dxm;
  private static View lJ;
  private static View mParentView;
  private static int rFF;
  
  static
  {
    AppMethodBeat.i(216691);
    DxP = new c();
    DxM = true;
    DxN = new a();
    DxO = new b();
    AppMethodBeat.o(216691);
  }
  
  public static void a(View paramView1, View paramView2, com.tencent.mm.plugin.hld.keyboard.b paramb, int paramInt)
  {
    AppMethodBeat.i(216687);
    p.k(paramView2, "anchorView");
    Object localObject = (d)com.tencent.mm.kernel.h.ae(d.class);
    if (localObject != null)
    {
      localObject = ((d)localObject).eCD();
      if (localObject == null) {}
    }
    for (localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).eCs();; localObject = null)
    {
      DxK = (com.tencent.mm.plugin.hld.a.h)localObject;
      if (localObject != null) {
        break;
      }
      Log.e("WxIme.ImeKeyboardMoveCursorListener", "registerListener: mImeSelection == null");
      AppMethodBeat.o(216687);
      return;
    }
    Dxm = paramb;
    mParentView = paramView1;
    lJ = paramView2;
    DxL = paramInt;
    paramb = lJ;
    if (paramb != null) {
      paramb.setSelected(false);
    }
    paramb = Dxm;
    if (paramb != null) {
      paramb.Dyh = true;
    }
    if (paramView1 == null)
    {
      if ((paramView2 instanceof ImeKeyRelativeLayout)) {
        Dxj = ((ImeKeyRelativeLayout)paramView2).getOnTouchListener();
      }
      paramView1 = lJ;
      if (paramView1 == null) {
        p.iCn();
      }
      paramView1.setOnTouchListener((View.OnTouchListener)DxO);
      AppMethodBeat.o(216687);
      return;
    }
    if ((paramView1 instanceof ImeKeyRelativeLayout)) {
      Dxj = ((ImeKeyRelativeLayout)paramView1).getOnTouchListener();
    }
    paramView1 = mParentView;
    if (paramView1 == null) {
      p.iCn();
    }
    paramView1.setOnTouchListener((View.OnTouchListener)DxO);
    AppMethodBeat.o(216687);
  }
  
  public static void a(View paramView, com.tencent.mm.plugin.hld.keyboard.b paramb, int paramInt)
  {
    AppMethodBeat.i(216689);
    p.k(paramView, "anchorView");
    Object localObject = (d)com.tencent.mm.kernel.h.ae(d.class);
    if (localObject != null)
    {
      localObject = ((d)localObject).eCD();
      if (localObject == null) {}
    }
    for (localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).eCs();; localObject = null)
    {
      DxK = (com.tencent.mm.plugin.hld.a.h)localObject;
      if (localObject != null) {
        break;
      }
      Log.e("WxIme.ImeKeyboardMoveCursorListener", "registerListener: mImeSelection == null");
      AppMethodBeat.o(216689);
      return;
    }
    Dxm = paramb;
    mParentView = null;
    lJ = paramView;
    DxL = paramInt;
    paramView = lJ;
    if (paramView == null) {
      p.iCn();
    }
    paramView.setOnTouchListener((View.OnTouchListener)DxO);
    AppMethodBeat.o(216689);
  }
  
  public static void a(View paramView, KeyboardView.c paramc, int paramInt)
  {
    AppMethodBeat.i(216690);
    p.k(paramView, "anchorView");
    Object localObject = (d)com.tencent.mm.kernel.h.ae(d.class);
    if (localObject != null)
    {
      localObject = ((d)localObject).eCD();
      if (localObject == null) {}
    }
    for (localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).eCs();; localObject = null)
    {
      DxK = (com.tencent.mm.plugin.hld.a.h)localObject;
      if (localObject != null) {
        break;
      }
      Log.e("WxIme.ImeKeyboardMoveCursorListener", "registerListener: mImeSelection == null");
      AppMethodBeat.o(216690);
      return;
    }
    Dxl = paramc;
    mParentView = null;
    lJ = paramView;
    DxL = paramInt;
    paramView = lJ;
    if (paramView == null) {
      p.iCn();
    }
    paramView.setOnTouchListener((View.OnTouchListener)DxN);
    AppMethodBeat.o(216690);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/key/ImeKeyboardMoveCursorListener$onTouchListener$1", "Landroid/view/View$OnTouchListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-hld_release"})
  public static final class a
    implements View.OnTouchListener
  {
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(210622);
      int j;
      if (paramMotionEvent != null)
      {
        paramView = Float.valueOf(paramMotionEvent.getRawX());
        j = (int)((Float)paramView).floatValue();
        if (paramMotionEvent == null) {
          break label62;
        }
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        label39:
        if (paramView != null) {
          break label67;
        }
        label43:
        if (paramView != null) {
          break label346;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(210622);
        return true;
        paramView = Double.valueOf(0.0D);
        break;
        label62:
        paramView = null;
        break label39;
        label67:
        if (paramView.intValue() != 2) {
          break label43;
        }
        paramView = c.DxP;
        paramView = c.eDA();
        if (paramView != null)
        {
          paramMotionEvent = c.DxP;
          int i;
          label140:
          int k;
          if (c.eDB())
          {
            paramMotionEvent = c.DxP;
            c.eDC();
            paramMotionEvent = c.DxP;
            if (paramView.x - j > 0)
            {
              paramView = c.DxP;
              paramView = c.eDE();
              if (paramView == null) {
                p.iCn();
              }
              i = paramView.start - 1;
              c.Ut(i);
            }
          }
          else
          {
            paramView = c.DxP;
            i = Math.abs(c.eDF() - j);
            paramView = k.DHH;
            k = i / k.eGR();
            paramView = c.DxP;
            if (c.eDF() - j <= 0) {
              break label326;
            }
            paramView = c.DxP;
            i = c.eDD() - k;
            label193:
            paramView = (d)com.tencent.mm.kernel.h.ae(d.class);
            if (paramView != null)
            {
              paramView = paramView.eCD();
              if (paramView != null) {
                paramView.Un(i);
              }
            }
            paramView = new StringBuilder();
            paramMotionEvent = c.DxP;
            paramView = paramView.append(c.eDD()).append(' ').append(k).append(", ");
            paramMotionEvent = c.DxP;
            if (c.eDF() - j <= 0) {
              break label340;
            }
          }
          label326:
          label340:
          for (boolean bool = true;; bool = false)
          {
            Log.d("WxIme.ImeKeyboardMoveCursorListener", bool + ' ' + i);
            break;
            paramView = c.DxP;
            paramView = c.eDE();
            if (paramView == null) {
              p.iCn();
            }
            i = paramView.end + 1;
            break label140;
            paramView = c.DxP;
            i = c.eDD() + k;
            break label193;
          }
          label346:
          if (paramView.intValue() == 1)
          {
            paramView = c.DxP;
            paramView = c.eDG();
            if (paramView != null) {
              paramView.setOnTouchListener(null);
            }
            paramView = c.DxP;
            c.eDH();
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/key/ImeKeyboardMoveCursorListener$onTouchListenerForXml$1", "Landroid/view/View$OnTouchListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-hld_release"})
  public static final class b
    implements View.OnTouchListener
  {
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(209074);
      int j;
      if (paramMotionEvent != null)
      {
        paramView = Float.valueOf(paramMotionEvent.getRawX());
        j = (int)((Float)paramView).floatValue();
        if (paramMotionEvent == null) {
          break label62;
        }
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        label39:
        if (paramView != null) {
          break label67;
        }
        label43:
        if (paramView != null) {
          break label346;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(209074);
        return false;
        paramView = Double.valueOf(0.0D);
        break;
        label62:
        paramView = null;
        break label39;
        label67:
        if (paramView.intValue() != 2) {
          break label43;
        }
        paramView = c.DxP;
        paramView = c.eDI();
        if (paramView != null)
        {
          paramMotionEvent = c.DxP;
          int i;
          label140:
          int k;
          if (c.eDB())
          {
            paramMotionEvent = c.DxP;
            c.eDC();
            paramMotionEvent = c.DxP;
            if (paramView.x - j > 0)
            {
              paramView = c.DxP;
              paramView = c.eDE();
              if (paramView == null) {
                p.iCn();
              }
              i = paramView.start - 1;
              c.Ut(i);
            }
          }
          else
          {
            paramView = c.DxP;
            i = Math.abs(c.eDF() - j);
            paramView = k.DHH;
            k = i / k.eGR();
            paramView = c.DxP;
            if (c.eDF() - j <= 0) {
              break label326;
            }
            paramView = c.DxP;
            i = c.eDD() - k;
            label193:
            paramView = (d)com.tencent.mm.kernel.h.ae(d.class);
            if (paramView != null)
            {
              paramView = paramView.eCD();
              if (paramView != null) {
                paramView.Un(i);
              }
            }
            paramView = new StringBuilder();
            paramMotionEvent = c.DxP;
            paramView = paramView.append(c.eDD()).append(' ').append(k).append(", ");
            paramMotionEvent = c.DxP;
            if (c.eDF() - j <= 0) {
              break label340;
            }
          }
          label326:
          label340:
          for (boolean bool = true;; bool = false)
          {
            Log.d("WxIme.ImeKeyboardMoveCursorListener", bool + ' ' + i);
            break;
            paramView = c.DxP;
            paramView = c.eDE();
            if (paramView == null) {
              p.iCn();
            }
            i = paramView.end + 1;
            break label140;
            paramView = c.DxP;
            i = c.eDD() + k;
            break label193;
          }
          label346:
          if (paramView.intValue() == 1)
          {
            paramView = c.DxP;
            paramView = c.eDG();
            if (paramView != null) {
              paramView.setOnTouchListener(null);
            }
            paramView = c.DxP;
            c.eDH();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.e.c
 * JD-Core Version:    0.7.0.1
 */