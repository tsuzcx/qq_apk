package com.tencent.mm.plugin.luckymoney.story;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public class EnvelopeStoryVideoView
  extends MMVideoView
{
  public static final String ROOT_PATH;
  private boolean dCQ;
  private String sessionId;
  boolean vtV;
  private boolean vtW;
  public a vtX;
  
  static
  {
    AppMethodBeat.i(174376);
    ROOT_PATH = com.tencent.mm.loader.j.b.arU() + "hbstoryvideo/";
    AppMethodBeat.o(174376);
  }
  
  public EnvelopeStoryVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163671);
    this.vtW = false;
    init();
    AppMethodBeat.o(163671);
  }
  
  public EnvelopeStoryVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163672);
    this.vtW = false;
    init();
    AppMethodBeat.o(163672);
  }
  
  public EnvelopeStoryVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(163673);
    this.vtW = false;
    init();
    AppMethodBeat.o(163673);
  }
  
  private void init()
  {
    AppMethodBeat.i(163674);
    if (this.lte != null) {
      this.lte.setVisibility(8);
    }
    setRootPath(ROOT_PATH);
    i.aYu(ROOT_PATH);
    setLoop(true);
    AppMethodBeat.o(163674);
  }
  
  public final boolean OI()
  {
    AppMethodBeat.i(174375);
    if ((this.oHt instanceof VideoPlayerTextureView))
    {
      boolean bool = ((VideoPlayerTextureView)this.oHt).OI();
      AppMethodBeat.o(174375);
      return bool;
    }
    ad.e(this.TAG, "videoview not VideoPlayerTextureView");
    if (this.irQ == 4)
    {
      AppMethodBeat.o(174375);
      return true;
    }
    AppMethodBeat.o(174375);
    return false;
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(163676);
    super.c(paramBoolean, paramString, paramInt);
    AppMethodBeat.o(163676);
  }
  
  public final boolean diZ()
  {
    return false;
  }
  
  public int getRealPlayDurationSec()
  {
    AppMethodBeat.i(174374);
    if (this.vtW)
    {
      i = getVideoDurationSec();
      AppMethodBeat.o(174374);
      return i;
    }
    int i = getCurrPosSec();
    AppMethodBeat.o(174374);
    return i;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(174373);
    this.vtW = true;
    if ((this.isd) && (this.vtX != null)) {
      this.vtX.a(this);
    }
    super.onCompletion();
    AppMethodBeat.o(174373);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(163679);
    ad.i(this.TAG, "%s onUIPause", new Object[] { boQ() });
    if (this.lsZ)
    {
      this.ltk = getCurrPosSec();
      this.ltl = true;
      this.ltr = 0;
      this.ltq = 0L;
      pause();
      stopTimer();
      this.lsZ = false;
      qQ(getReportIdkey() + 11);
    }
    AppMethodBeat.o(163679);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(163678);
    if (!this.lsZ)
    {
      this.lsZ = true;
      if (this.oHt != null)
      {
        if (!this.ltl) {
          break label54;
        }
        play();
      }
    }
    for (;;)
    {
      qQ(getReportIdkey() + 10);
      AppMethodBeat.o(163678);
      return;
      label54:
      ((VideoPlayerTextureView)this.oHt).boO();
    }
  }
  
  public void setLocal(boolean paramBoolean)
  {
    this.dCQ = paramBoolean;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(163675);
    super.setMute(paramBoolean);
    this.vtV = paramBoolean;
    AppMethodBeat.o(163675);
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public final void start()
  {
    AppMethodBeat.i(163677);
    ad.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d] isLocal[%s]", new Object[] { boQ(), this.irM, Integer.valueOf(this.irS), Boolean.valueOf(this.dCQ) });
    if (this.oHt != null)
    {
      if (!bt.isNullOrNil(this.oHt.getVideoPath())) {
        break label174;
      }
      if (this.dCQ)
      {
        aMv();
        this.irP = 3;
        AppMethodBeat.o(163677);
        return;
      }
      showLoading();
      this.isc = true;
      this.irS = 0;
      this.irP = 1;
      if (this.irL != null)
      {
        this.irL.p(this.irM, this.irN, this.url);
        this.irL.a(this);
      }
      eaE();
    }
    for (;;)
    {
      qQ(getReportIdkey() + 1);
      AppMethodBeat.o(163677);
      return;
      label174:
      play();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(EnvelopeStoryVideoView paramEnvelopeStoryVideoView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoView
 * JD-Core Version:    0.7.0.1
 */