package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.ui.banner.f;

public class JsApiSetBackgroundAudioStateWC$SetBackgroundAudioListenerTaskWC
  extends JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask
{
  public v.b hCb;
  public f hCc;
  
  public JsApiSetBackgroundAudioStateWC$SetBackgroundAudioListenerTaskWC(a parama, c paramc, int paramInt)
  {
    super(parama, paramc, paramInt);
  }
  
  protected final void nQ(int paramInt)
  {
    AppMethodBeat.i(130763);
    switch (paramInt)
    {
    case 5: 
    case 6: 
    case 9: 
    default: 
      AppMethodBeat.o(130763);
      return;
    case 0: 
    case 1: 
      this.hCb.i("setBackgroundAudioState#isPlaying", Boolean.TRUE);
      AppBrandStickyBannerLogic.a.d(this.hCc);
      AppMethodBeat.o(130763);
      return;
    case 2: 
    case 3: 
    case 4: 
    case 7: 
      this.hCb.i("setBackgroundAudioState#isPlaying", Boolean.FALSE);
      AppBrandStickyBannerLogic.a.c(this.hCc);
      AppMethodBeat.o(130763);
      return;
    case 10: 
      AppMethodBeat.o(130763);
      return;
    case 8: 
    case 11: 
    case 12: 
      AppMethodBeat.o(130763);
      return;
    case 13: 
      AppMethodBeat.o(130763);
      return;
    }
    AppMethodBeat.o(130763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC
 * JD-Core Version:    0.7.0.1
 */