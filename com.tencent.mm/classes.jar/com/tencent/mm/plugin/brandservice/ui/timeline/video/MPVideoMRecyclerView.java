package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoMRecyclerView;", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/MRecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "animationContainerContainer", "Landroid/view/View;", "canScroll", "", "downY", "", "hasDown", "maxVideoHeight", "", "minVideoHeight", "moveY", "videoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "videoViewContainer", "Landroid/widget/FrameLayout;", "deltaY", "inScrollRange", "curHeight", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setParam", "", "animationView", "maxHeight", "minHeight", "setVideoHeight", "videoHeight", "plugin-brandservice_release"})
public final class MPVideoMRecyclerView
  extends MRecyclerView
{
  private final String TAG = "MicroMsg.MPVideoMRecyclerView";
  private int aXT;
  private float bTF;
  private boolean canScroll = true;
  private float hma;
  private boolean jcN;
  private int kfW;
  private FrameLayout kgX;
  private View kgY;
  
  public MPVideoMRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final void setVideoHeight(int paramInt)
  {
    AppMethodBeat.i(15271);
    Object localObject1 = this.kgX;
    if (localObject1 == null) {
      j.ays("videoViewContainer");
    }
    localObject1 = ((FrameLayout)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(15271);
      throw ((Throwable)localObject1);
    }
    ((ViewGroup.LayoutParams)localObject1).height = paramInt;
    Object localObject2 = this.kgX;
    if (localObject2 == null) {
      j.ays("videoViewContainer");
    }
    ((FrameLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.kgY;
    if (localObject1 == null) {
      j.ays("animationContainerContainer");
    }
    if (((View)localObject1).getVisibility() == 0)
    {
      localObject1 = this.kgY;
      if (localObject1 == null) {
        j.ays("animationContainerContainer");
      }
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        AppMethodBeat.o(15271);
        throw ((Throwable)localObject1);
      }
      ((ViewGroup.LayoutParams)localObject1).height = paramInt;
      localObject2 = this.kgY;
      if (localObject2 == null) {
        j.ays("animationContainerContainer");
      }
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    AppMethodBeat.o(15271);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    AppMethodBeat.i(15270);
    Object localObject = this.kgX;
    if (localObject == null) {
      j.ays("videoViewContainer");
    }
    int j = ((FrameLayout)localObject).getHeight();
    if (paramMotionEvent != null)
    {
      localObject = Integer.valueOf(paramMotionEvent.getAction());
      if (localObject != null) {
        break label81;
      }
      label49:
      if (localObject != null) {
        break label105;
      }
      label54:
      if (localObject != null) {
        break label383;
      }
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(15270);
      return bool;
      localObject = null;
      break;
      label81:
      if (((Integer)localObject).intValue() != 0) {
        break label49;
      }
      this.bTF = paramMotionEvent.getRawY();
      this.jcN = true;
      continue;
      label105:
      if (((Integer)localObject).intValue() != 2) {
        break label54;
      }
      if (!this.jcN)
      {
        this.bTF = paramMotionEvent.getRawY();
        this.jcN = true;
      }
      this.hma = paramMotionEvent.getRawY();
      float f = (this.hma - this.bTF) * 1.2F;
      j = (int)(j + f);
      label172:
      int m;
      if (f == 0.0F)
      {
        bool = false;
        this.canScroll = bool;
        if (this.canScroll)
        {
          int k = this.kfW;
          m = this.aXT;
          if (k <= j) {
            break label333;
          }
          label204:
          i = 0;
          label206:
          if (i == 0) {
            break label343;
          }
          setVideoHeight(j);
        }
      }
      for (;;)
      {
        this.bTF = this.hma;
        break;
        if (f > 0.0F)
        {
          localObject = this.kgX;
          if (localObject == null) {
            j.ays("videoViewContainer");
          }
          if (((FrameLayout)localObject).getHeight() >= this.aXT)
          {
            bool = false;
            break label172;
          }
        }
        if (f < 0.0F)
        {
          localObject = this.kgX;
          if (localObject == null) {
            j.ays("videoViewContainer");
          }
          if (((FrameLayout)localObject).getHeight() <= this.kfW)
          {
            bool = false;
            break label172;
          }
        }
        if ((f > 0.0F) && (canScrollVertically(-1)))
        {
          bool = false;
          break label172;
        }
        bool = true;
        break label172;
        label333:
        if (m < j) {
          break label204;
        }
        break label206;
        label343:
        if (j <= this.kfW) {
          setVideoHeight(this.kfW);
        } else if (j >= this.aXT) {
          setVideoHeight(this.aXT);
        }
      }
      label383:
      if (((Integer)localObject).intValue() == 1) {
        this.jcN = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoMRecyclerView
 * JD-Core Version:    0.7.0.1
 */