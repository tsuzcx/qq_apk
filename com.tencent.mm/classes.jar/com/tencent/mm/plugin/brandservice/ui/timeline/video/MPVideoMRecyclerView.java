package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoMRecyclerView;", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/MRecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "animationContainerContainer", "Landroid/view/View;", "canScroll", "", "downY", "", "hasDown", "maxVideoHeight", "", "minVideoHeight", "moveY", "videoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "videoViewContainer", "Landroid/widget/FrameLayout;", "deltaY", "inScrollRange", "curHeight", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setParam", "", "animationView", "maxHeight", "minHeight", "setVideoHeight", "videoHeight", "plugin-brandservice_release"})
public final class MPVideoMRecyclerView
  extends MRecyclerView
{
  private final String TAG = "MicroMsg.MPVideoMRecyclerView";
  private int bEk;
  private float cNh;
  private boolean canScroll = true;
  private float kbE;
  private boolean mVq;
  private int opS;
  private FrameLayout opT;
  private View opU;
  
  public MPVideoMRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final void setVideoHeight(int paramInt)
  {
    AppMethodBeat.i(7267);
    Object localObject1 = this.opT;
    if (localObject1 == null) {
      p.bcb("videoViewContainer");
    }
    localObject1 = ((FrameLayout)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(7267);
      throw ((Throwable)localObject1);
    }
    ((ViewGroup.LayoutParams)localObject1).height = paramInt;
    Object localObject2 = this.opT;
    if (localObject2 == null) {
      p.bcb("videoViewContainer");
    }
    ((FrameLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.opU;
    if (localObject1 == null) {
      p.bcb("animationContainerContainer");
    }
    if (((View)localObject1).getVisibility() == 0)
    {
      localObject1 = this.opU;
      if (localObject1 == null) {
        p.bcb("animationContainerContainer");
      }
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        AppMethodBeat.o(7267);
        throw ((Throwable)localObject1);
      }
      ((ViewGroup.LayoutParams)localObject1).height = paramInt;
      localObject2 = this.opU;
      if (localObject2 == null) {
        p.bcb("animationContainerContainer");
      }
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    AppMethodBeat.o(7267);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    AppMethodBeat.i(7266);
    Object localObject = this.opT;
    if (localObject == null) {
      p.bcb("videoViewContainer");
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
      AppMethodBeat.o(7266);
      return bool;
      localObject = null;
      break;
      label81:
      if (((Integer)localObject).intValue() != 0) {
        break label49;
      }
      this.cNh = paramMotionEvent.getRawY();
      this.mVq = true;
      continue;
      label105:
      if (((Integer)localObject).intValue() != 2) {
        break label54;
      }
      if (!this.mVq)
      {
        this.cNh = paramMotionEvent.getRawY();
        this.mVq = true;
      }
      this.kbE = paramMotionEvent.getRawY();
      float f = (this.kbE - this.cNh) * 1.2F;
      j = (int)(j + f);
      label172:
      int m;
      if (f == 0.0F)
      {
        bool = false;
        this.canScroll = bool;
        if (this.canScroll)
        {
          int k = this.opS;
          m = this.bEk;
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
        this.cNh = this.kbE;
        break;
        if (f > 0.0F)
        {
          localObject = this.opT;
          if (localObject == null) {
            p.bcb("videoViewContainer");
          }
          if (((FrameLayout)localObject).getHeight() >= this.bEk)
          {
            bool = false;
            break label172;
          }
        }
        if (f < 0.0F)
        {
          localObject = this.opT;
          if (localObject == null) {
            p.bcb("videoViewContainer");
          }
          if (((FrameLayout)localObject).getHeight() <= this.opS)
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
        if (j <= this.opS) {
          setVideoHeight(this.opS);
        } else if (j >= this.bEk) {
          setVideoHeight(this.bEk);
        }
      }
      label383:
      if (((Integer)localObject).intValue() == 1) {
        this.mVq = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoMRecyclerView
 * JD-Core Version:    0.7.0.1
 */