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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/LiveVideoView;", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "downTime", "", "previewTouchListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setPreviewTouchListener", "callback", "plugin-logic_release"})
public final class LiveVideoView
  extends TXCloudVideoView
{
  private m<? super Float, ? super Float, z> gLX;
  private long gLY;
  
  public LiveVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(213000);
    this.gLY = -1L;
    AppMethodBeat.o(213000);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(212999);
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
      AppMethodBeat.o(212999);
      return true;
      localObject = null;
      break;
      label43:
      if (((Integer)localObject).intValue() != 0) {
        break label27;
      }
      this.gLY = System.currentTimeMillis();
      continue;
      label60:
      if (((Integer)localObject).intValue() == 1)
      {
        if ((this.gLY > 0L) && (System.currentTimeMillis() - this.gLY <= ViewConfiguration.getTapTimeout()))
        {
          localObject = this.gLX;
          if (localObject != null) {
            ((m)localObject).p(Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()));
          }
        }
        this.gLY = -1L;
      }
    }
  }
  
  public final void setPreviewTouchListener(m<? super Float, ? super Float, z> paramm)
  {
    this.gLX = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveVideoView
 * JD-Core Version:    0.7.0.1
 */