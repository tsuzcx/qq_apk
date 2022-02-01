package com.tencent.mm.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import d.g.a.m;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/LiveVideoView;", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "downTime", "", "previewTouchListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setPreviewTouchListener", "callback", "plugin-logic_release"})
public final class LiveVideoView
  extends TXCloudVideoView
{
  private m<? super Float, ? super Float, z> gOG;
  private long gOH;
  
  public LiveVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216630);
    this.gOH = -1L;
    AppMethodBeat.o(216630);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(216629);
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
      AppMethodBeat.o(216629);
      return true;
      localObject = null;
      break;
      label43:
      if (((Integer)localObject).intValue() != 0) {
        break label27;
      }
      this.gOH = System.currentTimeMillis();
      continue;
      label60:
      if (((Integer)localObject).intValue() == 1)
      {
        if ((this.gOH > 0L) && (System.currentTimeMillis() - this.gOH <= ViewConfiguration.getTapTimeout()))
        {
          localObject = this.gOG;
          if (localObject != null) {
            ((m)localObject).p(Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()));
          }
        }
        this.gOH = -1L;
      }
    }
  }
  
  public final void setPreviewTouchListener(m<? super Float, ? super Float, z> paramm)
  {
    this.gOG = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveVideoView
 * JD-Core Version:    0.7.0.1
 */