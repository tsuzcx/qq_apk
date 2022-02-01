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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/ImeOnClickHelper;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "()V", "TAG", "", "handleNormalTouch", "", "v", "Lcom/tencent/mm/plugin/hld/view/ImeTouchSoundView;", "event", "Landroid/view/MotionEvent;", "onClick", "", "Landroid/view/View;", "onTouch", "setOnClickListener", "listener", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements View.OnClickListener, View.OnTouchListener
{
  public static final f JzR;
  
  static
  {
    AppMethodBeat.i(312616);
    JzR = new f();
    AppMethodBeat.o(312616);
  }
  
  public final void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(312624);
    if (paramView == null)
    {
      paramOnClickListener = null;
      if (paramOnClickListener == null) {
        Log.e("WxIme.ImeOnClickHelper", s.X("view is null ", Util.getStack()));
      }
      if (!(paramView instanceof ImeTouchSoundView)) {
        break label89;
      }
    }
    label89:
    for (paramOnClickListener = (ImeTouchSoundView)paramView;; paramOnClickListener = null)
    {
      if (paramOnClickListener != null) {
        ((ImeTouchSoundView)paramView).setOnTouchListener((View.OnTouchListener)this);
      }
      AppMethodBeat.o(312624);
      return;
      paramView.setTag(a.f.ime_click_listener, paramOnClickListener);
      paramView.setOnClickListener((View.OnClickListener)this);
      paramView.setSoundEffectsEnabled(false);
      paramOnClickListener = ah.aiuX;
      break;
    }
  }
  
  public final void onClick(View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(312639);
    Object localObject1 = new b();
    ((b)localObject1).cH(paramView);
    a.c("com/tencent/mm/plugin/hld/view/ImeOnClickHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aYj());
    if (paramView == null) {}
    View.OnClickListener localOnClickListener;
    for (paramView = null;; paramView = null)
    {
      if (paramView == null) {
        Log.e("WxIme.ImeOnClickHelper", "view is null");
      }
      a.a(this, "com/tencent/mm/plugin/hld/view/ImeOnClickHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(312639);
      return;
      localOnClickListener = (View.OnClickListener)paramView.getTag(a.f.ime_click_listener);
      if (localOnClickListener != null) {
        break;
      }
    }
    if ((localOnClickListener instanceof g))
    {
      localObject1 = paramView.getTag(a.f.ime_click_timestamp);
      if (!(localObject1 instanceof Long)) {
        break label193;
      }
      localObject1 = (Long)localObject1;
      label129:
      if (localObject1 != null) {
        break label199;
      }
      localObject1 = null;
      label137:
      if (localObject1 != null) {}
    }
    else
    {
      localOnClickListener.onClick(paramView);
    }
    if ((paramView instanceof ImeTouchSoundView))
    {
      localObject1 = (ImeTouchSoundView)paramView;
      label163:
      if (localObject1 != null) {
        break label240;
      }
    }
    label193:
    label199:
    label240:
    for (localObject1 = localObject2;; localObject1 = ah.aiuX)
    {
      if (localObject1 == null)
      {
        localObject1 = i.JyA;
        i.hV(paramView);
      }
      paramView = ah.aiuX;
      break;
      localObject1 = null;
      break label129;
      long l = ((Number)localObject1).longValue();
      ((g)localOnClickListener).k(Long.valueOf(System.currentTimeMillis() - l));
      localObject1 = ah.aiuX;
      break label137;
      localObject1 = null;
      break label163;
    }
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(312649);
    if ((paramView instanceof ImeTouchSoundView))
    {
      ImeTouchSoundView localImeTouchSoundView = (ImeTouchSoundView)paramView;
      if (paramMotionEvent == null)
      {
        paramView = null;
        if (paramView != null) {
          break label60;
        }
        label27:
        if (paramView != null) {
          break label122;
        }
      }
      for (;;)
      {
        Log.d("WxIme.ImeOnClickHelper", s.X("action:", paramView));
        AppMethodBeat.o(312649);
        return false;
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        break;
        label60:
        if (paramView.intValue() != 5) {
          break label27;
        }
        label122:
        do
        {
          switch (paramView.intValue())
          {
          default: 
            break;
          case 0: 
            paramView = i.JyA;
            i.hV((View)localImeTouchSoundView);
            localImeTouchSoundView.setTag(a.f.ime_click_timestamp, Long.valueOf(System.currentTimeMillis()));
            break;
          }
        } while (paramView.intValue() == 0);
      }
    }
    AppMethodBeat.o(312649);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.f
 * JD-Core Version:    0.7.0.1
 */