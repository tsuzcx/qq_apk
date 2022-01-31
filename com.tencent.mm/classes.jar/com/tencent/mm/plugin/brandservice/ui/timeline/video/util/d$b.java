package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.l;
import a.v;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1", "Landroid/view/OrientationEventListener;", "onOrientationChanged", "", "orientation", "", "plugin-brandservice_release"})
public final class d$b
  extends OrientationEventListener
{
  d$b(Context paramContext, int paramInt)
  {
    super(paramInt, 3);
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(15312);
    if ((!d.a(this.kid)) || (this.kid.khY.get() == null))
    {
      AppMethodBeat.o(15312);
      return;
    }
    if (80 > paramInt)
    {
      if (260 <= paramInt) {
        break label101;
      }
      label49:
      if (170 <= paramInt) {
        break label114;
      }
      label56:
      if ((paramInt >= 10) && (paramInt <= 350)) {
        break label128;
      }
      paramInt = 0;
    }
    for (;;)
    {
      if (d.b(this.kid) == paramInt)
      {
        AppMethodBeat.o(15312);
        return;
        if (100 < paramInt) {
          break;
        }
        paramInt = -90;
        continue;
        label101:
        if (280 < paramInt) {
          break label49;
        }
        paramInt = 90;
        continue;
        label114:
        if (190 < paramInt) {
          break label56;
        }
        paramInt = 180;
        continue;
        label128:
        AppMethodBeat.o(15312);
        return;
      }
    }
    ab.v("MicroMsg.BizVideoOrientationHelper", "last rotation :" + d.b(this.kid) + " ,current rotation:" + paramInt);
    Object localObject = this.kid.khY.get();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView");
      AppMethodBeat.o(15312);
      throw ((Throwable)localObject);
    }
    if (bo.isNullOrNil(((MPVideoView)localObject).getVideoPath()))
    {
      AppMethodBeat.o(15312);
      return;
    }
    localObject = this.kid.khY.get();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView");
      AppMethodBeat.o(15312);
      throw ((Throwable)localObject);
    }
    if (((MPVideoView)localObject).aEQ())
    {
      if (paramInt == 0)
      {
        if ((!this.kid.aZN()) && (Math.abs(d.c(this.kid)) < 6.0F))
        {
          localObject = (MPVideoView)this.kid.khY.get();
          if (localObject != null) {
            ((MPVideoView)localObject).l(false, 0);
          }
          d.a(this.kid, 0);
          AppMethodBeat.o(15312);
        }
      }
      else
      {
        if (paramInt == 90)
        {
          localObject = (MPVideoView)this.kid.khY.get();
          if (localObject != null) {
            ((MPVideoView)localObject).setFullScreenDirection(90);
          }
          localObject = this.kid.hyV.get();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(15312);
            throw ((Throwable)localObject);
          }
          ((MMActivity)localObject).setRequestedOrientation(0);
          d.a(this.kid, 90);
          AppMethodBeat.o(15312);
          return;
        }
        if (paramInt == -90)
        {
          localObject = (MPVideoView)this.kid.khY.get();
          if (localObject != null) {
            ((MPVideoView)localObject).setFullScreenDirection(-90);
          }
          localObject = this.kid.hyV.get();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(15312);
            throw ((Throwable)localObject);
          }
          ((MMActivity)localObject).setRequestedOrientation(8);
          d.a(this.kid, -90);
        }
        AppMethodBeat.o(15312);
      }
    }
    else if ((!this.kid.aZN()) && ((paramInt == 90) || (paramInt == -90)))
    {
      localObject = (MPVideoView)this.kid.khY.get();
      if (localObject != null) {
        ((MPVideoView)localObject).setFullScreenDirection(paramInt);
      }
      localObject = (MPVideoView)this.kid.khY.get();
      if (localObject != null) {
        ((MPVideoView)localObject).l(true, paramInt);
      }
      d.a(this.kid, paramInt);
    }
    AppMethodBeat.o(15312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.d.b
 * JD-Core Version:    0.7.0.1
 */