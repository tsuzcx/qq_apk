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
  private boolean dtp;
  private String sessionId;
  boolean tjb;
  private boolean tjc;
  public a tjd;
  
  static
  {
    AppMethodBeat.i(174376);
    ROOT_PATH = com.tencent.mm.loader.j.b.aih() + "hbstoryvideo/";
    AppMethodBeat.o(174376);
  }
  
  public EnvelopeStoryVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163671);
    this.tjc = false;
    init();
    AppMethodBeat.o(163671);
  }
  
  public EnvelopeStoryVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163672);
    this.tjc = false;
    init();
    AppMethodBeat.o(163672);
  }
  
  public EnvelopeStoryVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(163673);
    this.tjc = false;
    init();
    AppMethodBeat.o(163673);
  }
  
  private void init()
  {
    AppMethodBeat.i(163674);
    if (this.kuR != null) {
      this.kuR.setVisibility(8);
    }
    setRootPath(ROOT_PATH);
    i.aMT(ROOT_PATH);
    setLoop(true);
    AppMethodBeat.o(163674);
  }
  
  public final boolean Nb()
  {
    AppMethodBeat.i(174375);
    if ((this.nAZ instanceof VideoPlayerTextureView))
    {
      boolean bool = ((VideoPlayerTextureView)this.nAZ).Nb();
      AppMethodBeat.o(174375);
      return bool;
    }
    ad.e(this.TAG, "videoview not VideoPlayerTextureView");
    if (this.hxT == 4)
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
  
  public final boolean cMg()
  {
    return false;
  }
  
  public int getRealPlayDurationSec()
  {
    AppMethodBeat.i(174374);
    if (this.tjc)
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
    this.tjc = true;
    if ((this.hyg) && (this.tjd != null)) {
      this.tjd.a(this);
    }
    super.onCompletion();
    AppMethodBeat.o(174373);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(163679);
    ad.i(this.TAG, "%s onUIPause", new Object[] { bel() });
    if (this.kuL)
    {
      this.kuX = getCurrPosSec();
      this.kuY = true;
      this.kve = 0;
      this.kvd = 0L;
      pause();
      stopTimer();
      this.kuL = false;
      ln(getReportIdkey() + 11);
    }
    AppMethodBeat.o(163679);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(163678);
    if (!this.kuL)
    {
      this.kuL = true;
      if (this.nAZ != null)
      {
        if (!this.kuY) {
          break label54;
        }
        play();
      }
    }
    for (;;)
    {
      ln(getReportIdkey() + 10);
      AppMethodBeat.o(163678);
      return;
      label54:
      ((VideoPlayerTextureView)this.nAZ).bej();
    }
  }
  
  public void setLocal(boolean paramBoolean)
  {
    this.dtp = paramBoolean;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(163675);
    super.setMute(paramBoolean);
    this.tjb = paramBoolean;
    AppMethodBeat.o(163675);
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public final void start()
  {
    AppMethodBeat.i(163677);
    ad.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d] isLocal[%s]", new Object[] { bel(), this.hxP, Integer.valueOf(this.hxV), Boolean.valueOf(this.dtp) });
    if (this.nAZ != null)
    {
      if (!bt.isNullOrNil(this.nAZ.getVideoPath())) {
        break label174;
      }
      if (this.dtp)
      {
        aCu();
        this.hxS = 3;
        AppMethodBeat.o(163677);
        return;
      }
      showLoading();
      this.hyf = true;
      this.hxV = 0;
      this.hxS = 1;
      if (this.hxO != null)
      {
        this.hxO.q(this.hxP, this.hxQ, this.url);
        this.hxO.a(this);
      }
      dzT();
    }
    for (;;)
    {
      ln(getReportIdkey() + 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoView
 * JD-Core Version:    0.7.0.1
 */