package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.aw.a;
import d.g.b.p;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
final class MPVideoPreviewMgr$h
  implements aw.a
{
  public static final h vVK;
  
  static
  {
    AppMethodBeat.i(224152);
    vVK = new h();
    AppMethodBeat.o(224152);
  }
  
  public final boolean onTimerExpired()
  {
    int k = 0;
    AppMethodBeat.i(224151);
    Object localObject = MPVideoPreviewMgr.ovZ;
    localObject = MPVideoPreviewMgr.cQN();
    TextView localTextView;
    int i;
    if (localObject != null)
    {
      localTextView = (TextView)((WeakReference)localObject).get();
      if (localTextView != null)
      {
        localObject = MPVideoPreviewMgr.ovZ;
        localObject = MPVideoPreviewMgr.bTd();
        if (localObject == null) {
          break label162;
        }
        localObject = (AppBrandVideoView)((WeakReference)localObject).get();
        if (localObject == null) {
          break label162;
        }
        i = ((AppBrandVideoView)localObject).getDuration();
        localObject = MPVideoPreviewMgr.ovZ;
        localObject = MPVideoPreviewMgr.bTd();
        int j = k;
        if (localObject != null)
        {
          localObject = (AppBrandVideoView)((WeakReference)localObject).get();
          j = k;
          if (localObject != null) {
            j = ((AppBrandVideoView)localObject).getCurrPosMs();
          }
        }
        p.g(localTextView, "it");
        localObject = m.ol((i * 1000 - j) / 1000);
        if (localObject == null) {
          break label167;
        }
      }
    }
    label162:
    label167:
    for (localObject = (CharSequence)localObject;; localObject = (CharSequence)"")
    {
      localTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(224151);
      return true;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.h
 * JD-Core Version:    0.7.0.1
 */