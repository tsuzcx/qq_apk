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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/view/LiveVideoView;", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "downTime", "", "previewTouchListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setPreviewTouchListener", "callback", "plugin-core_release"})
public final class LiveVideoView
  extends TXCloudVideoView
{
  private m<? super Float, ? super Float, x> ksX;
  private long ksY;
  
  public LiveVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200147);
    this.ksY = -1L;
    AppMethodBeat.o(200147);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200143);
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
      AppMethodBeat.o(200143);
      return true;
      localObject = null;
      break;
      label43:
      if (((Integer)localObject).intValue() != 0) {
        break label27;
      }
      this.ksY = System.currentTimeMillis();
      continue;
      label60:
      if (((Integer)localObject).intValue() == 1)
      {
        if ((this.ksY > 0L) && (System.currentTimeMillis() - this.ksY <= ViewConfiguration.getTapTimeout()))
        {
          localObject = this.ksX;
          if (localObject != null) {
            ((m)localObject).invoke(Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()));
          }
        }
        this.ksY = -1L;
      }
    }
  }
  
  public final void setPreviewTouchListener(m<? super Float, ? super Float, x> paramm)
  {
    this.ksX = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.view.LiveVideoView
 * JD-Core Version:    0.7.0.1
 */