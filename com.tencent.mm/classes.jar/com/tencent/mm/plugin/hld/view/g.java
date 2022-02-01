package com.tencent.mm.plugin.hld.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeOnClickHelper;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "()V", "TAG", "", "handleNormalTouch", "", "v", "Lcom/tencent/mm/plugin/hld/view/ImeTouchSoundView;", "event", "Landroid/view/MotionEvent;", "onClick", "", "Landroid/view/View;", "onTouch", "setOnClickListener", "listener", "plugin-hld_release"})
public final class g
  implements View.OnClickListener, View.OnTouchListener
{
  public static final g DIP;
  
  static
  {
    AppMethodBeat.i(209838);
    DIP = new g();
    AppMethodBeat.o(209838);
  }
  
  public static void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(209835);
    if (paramView != null)
    {
      paramView.setTag(a.f.ime_click_listener, paramOnClickListener);
      paramView.setOnClickListener((View.OnClickListener)DIP);
      paramView.setSoundEffectsEnabled(false);
      if ((paramView instanceof ImeTouchSoundView)) {
        break label90;
      }
    }
    label90:
    for (paramOnClickListener = null;; paramOnClickListener = paramView)
    {
      if ((ImeTouchSoundView)paramOnClickListener != null) {
        paramView.setOnTouchListener((View.OnTouchListener)DIP);
      }
      AppMethodBeat.o(209835);
      return;
      Log.e("WxIme.ImeOnClickHelper", "view is null " + Util.getStack());
      break;
    }
  }
  
  public final void onClick(View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(209836);
    Object localObject2 = new b();
    ((b)localObject2).bn(paramView);
    a.c("com/tencent/mm/plugin/hld/view/ImeOnClickHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject2).aFi());
    View.OnClickListener localOnClickListener;
    if (paramView != null)
    {
      localOnClickListener = (View.OnClickListener)paramView.getTag(a.f.ime_click_listener);
      if (localOnClickListener != null)
      {
        if (!(localOnClickListener instanceof h)) {
          break label198;
        }
        localObject2 = paramView.getTag(a.f.ime_click_timestamp);
        localObject1 = localObject2;
        if (!(localObject2 instanceof Long)) {
          localObject1 = null;
        }
        localObject1 = (Long)localObject1;
        if (localObject1 == null) {
          break label198;
        }
        long l = ((Number)localObject1).longValue();
        ((h)localOnClickListener).j(Long.valueOf(System.currentTimeMillis() - l));
        if ((paramView instanceof ImeTouchSoundView)) {
          break label209;
        }
      }
    }
    label198:
    label209:
    for (localObject1 = null;; localObject1 = paramView)
    {
      if ((ImeTouchSoundView)localObject1 == null)
      {
        localObject1 = i.DHq;
        i.fj(paramView);
      }
      localObject1 = x.aazN;
      if (localObject1 == null)
      {
        Log.e("WxIme.ImeOnClickHelper", "view is null");
        paramView = x.aazN;
      }
      a.a(this, "com/tencent/mm/plugin/hld/view/ImeOnClickHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(209836);
      return;
      localOnClickListener.onClick(paramView);
      break;
    }
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209837);
    if ((paramView instanceof ImeTouchSoundView))
    {
      ImeTouchSoundView localImeTouchSoundView = (ImeTouchSoundView)paramView;
      if (paramMotionEvent != null)
      {
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        if (paramView != null) {
          break label63;
        }
        label33:
        if (paramView != null) {
          break label91;
        }
        Log.d("WxIme.ImeOnClickHelper", "action:".concat(String.valueOf(paramView)));
      }
      label135:
      label144:
      for (;;)
      {
        label51:
        AppMethodBeat.o(209837);
        return false;
        paramView = null;
        break;
        label63:
        if (paramView.intValue() != 5) {
          break label33;
        }
        label71:
        if (paramView == null) {
          label75:
          if (paramView != null) {
            break label135;
          }
        }
        for (;;)
        {
          if (paramView == null) {
            break label144;
          }
          paramView.intValue();
          break label51;
          label91:
          if (paramView.intValue() == 0) {
            break label71;
          }
          break;
          if (paramView.intValue() != 0) {
            break label75;
          }
          paramView = i.DHq;
          i.fj((View)localImeTouchSoundView);
          localImeTouchSoundView.setTag(a.f.ime_click_timestamp, Long.valueOf(System.currentTimeMillis()));
          break label51;
          if (paramView.intValue() == 2) {
            break label51;
          }
        }
      }
    }
    AppMethodBeat.o(209837);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.g
 * JD-Core Version:    0.7.0.1
 */