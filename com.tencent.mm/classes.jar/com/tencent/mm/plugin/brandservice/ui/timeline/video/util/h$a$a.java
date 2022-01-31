package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.e.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoImageAnimationHelper$handleAnimation$1$onPreDraw$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-brandservice_release"})
public final class h$a$a
  implements e.b
{
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(15331);
    this.kiy.kix.aZS();
    ab.d(this.kiy.kix.TAG, "handleAnimation animation end");
    long l = System.currentTimeMillis() - this.kiy.kiw;
    if (this.kiy.kix.kiv)
    {
      i = 33;
      b.Ko(i);
      if (l > 800L)
      {
        ab.w(this.kiy.kix.TAG, "Slow animation, cost %d", new Object[] { Long.valueOf(l) });
        if (!this.kiy.kix.kiv) {
          break label130;
        }
      }
    }
    label130:
    for (int i = 34;; i = 36)
    {
      b.Ko(i);
      AppMethodBeat.o(15331);
      return;
      i = 35;
      break;
    }
  }
  
  public final void onAnimationStart()
  {
    AppMethodBeat.i(155388);
    this.kiy.kiw = System.currentTimeMillis();
    AppMethodBeat.o(155388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h.a.a
 * JD-Core Version:    0.7.0.1
 */