package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.a.a;
import a.f.b.k;
import a.l;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"getNativeActivity", "", "invoke"})
final class PreloadLogic$w
  extends k
  implements a<String>
{
  PreloadLogic$w(boolean paramBoolean, String paramString, PreloadLogic.PreloadSession paramPreloadSession)
  {
    super(0);
  }
  
  public final String aXs()
  {
    if (this.kck) {}
    switch (this.kcm.fgh)
    {
    case 6: 
    case 7: 
    default: 
      return this.kcn;
    case 5: 
      return ".ui.timeline.video.BizVideoDetailUI";
    }
    return ".ui.timeline.video.BizImgDetailUI";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.w
 * JD-Core Version:    0.7.0.1
 */