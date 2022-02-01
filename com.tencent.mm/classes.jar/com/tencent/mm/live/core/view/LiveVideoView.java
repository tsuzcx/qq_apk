package com.tencent.mm.live.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/view/LiveVideoView;", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "downTime", "", "previewTouchListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setPreviewTouchListener", "callback", "plugin-core_release"})
public final class LiveVideoView
  extends TXCloudVideoView
{
  private m<? super Float, ? super Float, x> hES;
  private long hET;
  
  public LiveVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(196767);
    this.hET = -1L;
    AppMethodBeat.o(196767);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(196766);
    super.onTouchEvent(paramMotionEvent);
    Object localObject;
    if (paramMotionEvent != null)
    {
      localObject = Integer.valueOf(paramMotionEvent.getAction());
      if (localObject != null) {
        break label43;
      }
      label27:
      if (localObject != null) {
        break label60;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(196766);
      return true;
      localObject = null;
      break;
      label43:
      if (((Integer)localObject).intValue() != 0) {
        break label27;
      }
      this.hET = System.currentTimeMillis();
      continue;
      label60:
      if (((Integer)localObject).intValue() == 1)
      {
        if ((this.hET > 0L) && (System.currentTimeMillis() - this.hET <= ViewConfiguration.getTapTimeout()))
        {
          localObject = this.hES;
          if (localObject != null) {
            ((m)localObject).invoke(Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()));
          }
        }
        this.hET = -1L;
      }
    }
  }
  
  public final void setPreviewTouchListener(m<? super Float, ? super Float, x> paramm)
  {
    this.hES = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.view.LiveVideoView
 * JD-Core Version:    0.7.0.1
 */