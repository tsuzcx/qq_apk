package com.tencent.mm.live.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/view/LiveVideoView;", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "downTime", "", "previewTouchListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "disableTouch", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setPreviewTouchListener", "callback", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveVideoView
  extends TXCloudVideoView
{
  public m<? super Float, ? super Float, ah> mWQ;
  private long mWR;
  
  public LiveVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext.getApplicationContext(), paramAttributeSet);
    AppMethodBeat.i(247546);
    this.mWR = -1L;
    AppMethodBeat.o(247546);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(247569);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (this.mWQ == null)
    {
      AppMethodBeat.o(247569);
      return bool;
    }
    Object localObject;
    if (paramMotionEvent == null)
    {
      localObject = null;
      if (localObject != null) {
        break label57;
      }
      label35:
      if (localObject != null) {
        break label74;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(247569);
      return true;
      localObject = Integer.valueOf(paramMotionEvent.getAction());
      break;
      label57:
      if (((Integer)localObject).intValue() != 0) {
        break label35;
      }
      this.mWR = System.currentTimeMillis();
      continue;
      label74:
      if (((Integer)localObject).intValue() == 1)
      {
        if ((this.mWR > 0L) && (System.currentTimeMillis() - this.mWR <= ViewConfiguration.getTapTimeout()))
        {
          localObject = this.mWQ;
          if (localObject != null) {
            ((m)localObject).invoke(Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()));
          }
        }
        this.mWR = -1L;
      }
    }
  }
  
  public final void setPreviewTouchListener(m<? super Float, ? super Float, ah> paramm)
  {
    this.mWQ = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.view.LiveVideoView
 * JD-Core Version:    0.7.0.1
 */