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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/key/ImeKeyboardMoveCursorListener;", "", "()V", "TAG", "", "mAnchorView", "Landroid/view/View;", "mFirstMove", "", "mImeSelection", "Lcom/tencent/mm/plugin/hld/api/ImeSelection;", "mLastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "mLastKeyOperationForXml", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "mOnTouchListener", "Ljava/lang/ref/WeakReference;", "Landroid/view/View$OnTouchListener;", "mParentView", "mStartIndex", "", "mStartXOffset", "onTouchListener", "com/tencent/mm/plugin/hld/key/ImeKeyboardMoveCursorListener$onTouchListener$1", "Lcom/tencent/mm/plugin/hld/key/ImeKeyboardMoveCursorListener$onTouchListener$1;", "onTouchListenerForXml", "com/tencent/mm/plugin/hld/key/ImeKeyboardMoveCursorListener$onTouchListenerForXml$1", "Lcom/tencent/mm/plugin/hld/key/ImeKeyboardMoveCursorListener$onTouchListenerForXml$1;", "registerListener", "", "anchorView", "lastKeyOperation", "startXOffset", "parent", "releaseListener", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b JqP;
  private static com.tencent.mm.plugin.hld.a.h JqQ;
  private static int JqR;
  private static boolean JqS;
  private static final a JqT;
  private static final b JqU;
  private static WeakReference<View.OnTouchListener> Jqp;
  private static KeyboardView.c Jqr;
  private static com.tencent.mm.plugin.hld.keyboard.b Jqs;
  private static View mF;
  private static int uQR;
  private static View xyY;
  
  static
  {
    AppMethodBeat.i(311515);
    JqP = new b();
    JqS = true;
    JqT = new a();
    JqU = new b();
    AppMethodBeat.o(311515);
  }
  
  public static void a(View paramView1, View paramView2, com.tencent.mm.plugin.hld.keyboard.b paramb, int paramInt)
  {
    AppMethodBeat.i(311453);
    s.u(paramView2, "anchorView");
    Object localObject = (d)com.tencent.mm.kernel.h.ax(d.class);
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      JqQ = (com.tencent.mm.plugin.hld.a.h)localObject;
      if (localObject != null) {
        break;
      }
      Log.e("WxIme.ImeKeyboardMoveCursorListener", "registerListener: mImeSelection == null");
      AppMethodBeat.o(311453);
      return;
      localObject = ((d)localObject).fKG();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).fKv();
      }
    }
    Jqs = paramb;
    xyY = paramView1;
    mF = paramView2;
    JqR = paramInt;
    paramb = mF;
    if (paramb != null) {
      paramb.setSelected(false);
    }
    paramb = Jqs;
    if (paramb != null) {
      paramb.Jrl = true;
    }
    if (paramView1 == null)
    {
      if ((paramView2 instanceof ImeKeyRelativeLayout)) {
        Jqp = ((ImeKeyRelativeLayout)paramView2).getOnTouchListener();
      }
      paramView1 = mF;
      s.checkNotNull(paramView1);
      paramView1.setOnTouchListener((View.OnTouchListener)JqU);
      AppMethodBeat.o(311453);
      return;
    }
    if ((paramView1 instanceof ImeKeyRelativeLayout)) {
      Jqp = ((ImeKeyRelativeLayout)paramView1).getOnTouchListener();
    }
    paramView1 = xyY;
    s.checkNotNull(paramView1);
    paramView1.setOnTouchListener((View.OnTouchListener)JqU);
    AppMethodBeat.o(311453);
  }
  
  public static void a(View paramView, com.tencent.mm.plugin.hld.keyboard.b paramb, int paramInt)
  {
    AppMethodBeat.i(311457);
    s.u(paramView, "anchorView");
    Object localObject = (d)com.tencent.mm.kernel.h.ax(d.class);
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      JqQ = (com.tencent.mm.plugin.hld.a.h)localObject;
      if (localObject != null) {
        break;
      }
      Log.e("WxIme.ImeKeyboardMoveCursorListener", "registerListener: mImeSelection == null");
      AppMethodBeat.o(311457);
      return;
      localObject = ((d)localObject).fKG();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).fKv();
      }
    }
    Jqs = paramb;
    xyY = null;
    mF = paramView;
    JqR = paramInt;
    paramView = mF;
    s.checkNotNull(paramView);
    paramView.setOnTouchListener((View.OnTouchListener)JqU);
    AppMethodBeat.o(311457);
  }
  
  public static void a(View paramView, KeyboardView.c paramc, int paramInt)
  {
    AppMethodBeat.i(311460);
    s.u(paramView, "anchorView");
    Object localObject = (d)com.tencent.mm.kernel.h.ax(d.class);
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      JqQ = (com.tencent.mm.plugin.hld.a.h)localObject;
      if (localObject != null) {
        break;
      }
      Log.e("WxIme.ImeKeyboardMoveCursorListener", "registerListener: mImeSelection == null");
      AppMethodBeat.o(311460);
      return;
      localObject = ((d)localObject).fKG();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).fKv();
      }
    }
    Jqr = paramc;
    xyY = null;
    mF = paramView;
    JqR = paramInt;
    paramView = mF;
    s.checkNotNull(paramView);
    paramView.setOnTouchListener((View.OnTouchListener)JqT);
    AppMethodBeat.o(311460);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/key/ImeKeyboardMoveCursorListener$onTouchListener$1", "Landroid/view/View$OnTouchListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements View.OnTouchListener
  {
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(311461);
      int j;
      if (paramMotionEvent == null)
      {
        paramView = Double.valueOf(0.0D);
        j = (int)((Float)paramView).floatValue();
        if (paramMotionEvent != null) {
          break label56;
        }
        paramView = null;
        label30:
        if (paramView != null) {
          break label67;
        }
        label34:
        if (paramView != null) {
          break label298;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(311461);
        return true;
        paramView = Float.valueOf(paramMotionEvent.getRawX());
        break;
        label56:
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        break label30;
        label67:
        if (paramView.intValue() != 2) {
          break label34;
        }
        paramView = b.fLC();
        if (paramView != null)
        {
          int i;
          label125:
          int k;
          if (b.fLF())
          {
            paramMotionEvent = b.JqP;
            b.fLG();
            paramMotionEvent = b.JqP;
            if (paramView.x - j > 0)
            {
              paramView = b.fLH();
              s.checkNotNull(paramView);
              i = paramView.start - 1;
              b.Yq(i);
            }
          }
          else
          {
            i = Math.abs(b.fLI() - j);
            paramView = k.JyF;
            k = i / k.fOA();
            if (b.fLI() - j <= 0) {
              break label282;
            }
            i = b.fLJ() - k;
            label166:
            paramView = (d)com.tencent.mm.kernel.h.ax(d.class);
            if (paramView != null)
            {
              paramView = paramView.fKG();
              if (paramView != null) {
                paramView.Yj(i);
              }
            }
            paramView = new StringBuilder().append(b.fLJ()).append(' ').append(k).append(", ");
            if (b.fLI() - j <= 0) {
              break label292;
            }
          }
          label282:
          label292:
          for (boolean bool = true;; bool = false)
          {
            Log.d("WxIme.ImeKeyboardMoveCursorListener", bool + ' ' + i);
            break;
            paramView = b.fLH();
            s.checkNotNull(paramView);
            i = paramView.end + 1;
            break label125;
            i = b.fLJ() + k;
            break label166;
          }
          label298:
          if (paramView.intValue() == 1)
          {
            paramView = b.fLD();
            if (paramView != null) {
              paramView.setOnTouchListener(null);
            }
            paramView = b.JqP;
            b.fLE();
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/key/ImeKeyboardMoveCursorListener$onTouchListenerForXml$1", "Landroid/view/View$OnTouchListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements View.OnTouchListener
  {
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(311449);
      int j;
      if (paramMotionEvent == null)
      {
        paramView = Double.valueOf(0.0D);
        j = (int)((Float)paramView).floatValue();
        if (paramMotionEvent != null) {
          break label56;
        }
        paramView = null;
        label30:
        if (paramView != null) {
          break label67;
        }
        label34:
        if (paramView != null) {
          break label298;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(311449);
        return false;
        paramView = Float.valueOf(paramMotionEvent.getRawX());
        break;
        label56:
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        break label30;
        label67:
        if (paramView.intValue() != 2) {
          break label34;
        }
        paramView = b.fLK();
        if (paramView != null)
        {
          int i;
          label125:
          int k;
          if (b.fLF())
          {
            paramMotionEvent = b.JqP;
            b.fLG();
            paramMotionEvent = b.JqP;
            if (paramView.x - j > 0)
            {
              paramView = b.fLH();
              s.checkNotNull(paramView);
              i = paramView.start - 1;
              b.Yq(i);
            }
          }
          else
          {
            i = Math.abs(b.fLI() - j);
            paramView = k.JyF;
            k = i / k.fOA();
            if (b.fLI() - j <= 0) {
              break label282;
            }
            i = b.fLJ() - k;
            label166:
            paramView = (d)com.tencent.mm.kernel.h.ax(d.class);
            if (paramView != null)
            {
              paramView = paramView.fKG();
              if (paramView != null) {
                paramView.Yj(i);
              }
            }
            paramView = new StringBuilder().append(b.fLJ()).append(' ').append(k).append(", ");
            if (b.fLI() - j <= 0) {
              break label292;
            }
          }
          label282:
          label292:
          for (boolean bool = true;; bool = false)
          {
            Log.d("WxIme.ImeKeyboardMoveCursorListener", bool + ' ' + i);
            break;
            paramView = b.fLH();
            s.checkNotNull(paramView);
            i = paramView.end + 1;
            break label125;
            i = b.fLJ() + k;
            break label166;
          }
          label298:
          if (paramView.intValue() == 1)
          {
            paramView = b.fLD();
            if (paramView != null) {
              paramView.setOnTouchListener(null);
            }
            paramView = b.JqP;
            b.fLE();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.e.b
 * JD-Core Version:    0.7.0.1
 */