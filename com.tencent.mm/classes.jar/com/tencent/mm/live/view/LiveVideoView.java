package com.tencent.mm.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import d.g.a.m;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/LiveVideoView;", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "downTime", "", "previewTouchListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setPreviewTouchListener", "callback", "plugin-logic_release"})
public final class LiveVideoView
  extends TXCloudVideoView
{
  private m<? super Float, ? super Float, y> gsp;
  private long gsq;
  
  public LiveVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(190710);
    this.gsq = -1L;
    AppMethodBeat.o(190710);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(190709);
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
      AppMethodBeat.o(190709);
      return true;
      localObject = null;
      break;
      label43:
      if (((Integer)localObject).intValue() != 0) {
        break label27;
      }
      this.gsq = System.currentTimeMillis();
      continue;
      label60:
      if (((Integer)localObject).intValue() == 1)
      {
        if ((this.gsq > 0L) && (System.currentTimeMillis() - this.gsq <= ViewConfiguration.getTapTimeout()))
        {
          localObject = this.gsp;
          if (localObject != null) {
            ((m)localObject).n(Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()));
          }
        }
        this.gsq = -1L;
      }
    }
  }
  
  public final void setPreviewTouchListener(m<? super Float, ? super Float, y> paramm)
  {
    this.gsp = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveVideoView
 * JD-Core Version:    0.7.0.1
 */