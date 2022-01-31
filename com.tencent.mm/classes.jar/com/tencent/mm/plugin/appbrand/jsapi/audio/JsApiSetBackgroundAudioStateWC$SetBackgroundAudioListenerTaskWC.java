package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.ui.banner.f;

public class JsApiSetBackgroundAudioStateWC$SetBackgroundAudioListenerTaskWC
  extends JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask
{
  public u.b fVQ;
  public f giI;
  
  public JsApiSetBackgroundAudioStateWC$SetBackgroundAudioListenerTaskWC(a parama, c paramc, int paramInt)
  {
    super(parama, paramc, paramInt);
  }
  
  protected final void lh(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    default: 
      return;
    case 0: 
    case 1: 
      this.fVQ.h("setBackgroundAudioState#isPlaying", Boolean.valueOf(true));
      AppBrandStickyBannerLogic.a.d(this.giI);
      return;
    }
    this.fVQ.h("setBackgroundAudioState#isPlaying", Boolean.valueOf(false));
    AppBrandStickyBannerLogic.a.c(this.giI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC
 * JD-Core Version:    0.7.0.1
 */