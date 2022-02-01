package com.tencent.mm.plugin.luckymoney.story;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public class EnvelopeStoryVideoView
  extends MMVideoView
{
  public static final String ROOT_PATH;
  private boolean dqZ;
  private String sessionId;
  boolean urs;
  private boolean urt;
  public a uru;
  
  static
  {
    AppMethodBeat.i(174376);
    ROOT_PATH = com.tencent.mm.loader.j.b.aph() + "hbstoryvideo/";
    AppMethodBeat.o(174376);
  }
  
  public EnvelopeStoryVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163671);
    this.urt = false;
    init();
    AppMethodBeat.o(163671);
  }
  
  public EnvelopeStoryVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163672);
    this.urt = false;
    init();
    AppMethodBeat.o(163672);
  }
  
  public EnvelopeStoryVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(163673);
    this.urt = false;
    init();
    AppMethodBeat.o(163673);
  }
  
  private void init()
  {
    AppMethodBeat.i(163674);
    if (this.kWf != null) {
      this.kWf.setVisibility(8);
    }
    setRootPath(ROOT_PATH);
    i.aSv(ROOT_PATH);
    setLoop(true);
    AppMethodBeat.o(163674);
  }
  
  public final boolean MZ()
  {
    AppMethodBeat.i(174375);
    if ((this.odZ instanceof VideoPlayerTextureView))
    {
      boolean bool = ((VideoPlayerTextureView)this.odZ).MZ();
      AppMethodBeat.o(174375);
      return bool;
    }
    ac.e(this.TAG, "videoview not VideoPlayerTextureView");
    if (this.hYu == 4)
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
  
  public final boolean cZM()
  {
    return false;
  }
  
  public int getRealPlayDurationSec()
  {
    AppMethodBeat.i(174374);
    if (this.urt)
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
    this.urt = true;
    if ((this.hYH) && (this.uru != null)) {
      this.uru.a(this);
    }
    super.onCompletion();
    AppMethodBeat.o(174373);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(163679);
    ac.i(this.TAG, "%s onUIPause", new Object[] { blf() });
    if (this.kWa)
    {
      this.kWl = getCurrPosSec();
      this.kWm = true;
      this.kWs = 0;
      this.kWr = 0L;
      pause();
      stopTimer();
      this.kWa = false;
      oQ(getReportIdkey() + 11);
    }
    AppMethodBeat.o(163679);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(163678);
    if (!this.kWa)
    {
      this.kWa = true;
      if (this.odZ != null)
      {
        if (!this.kWm) {
          break label54;
        }
        play();
      }
    }
    for (;;)
    {
      oQ(getReportIdkey() + 10);
      AppMethodBeat.o(163678);
      return;
      label54:
      ((VideoPlayerTextureView)this.odZ).bld();
    }
  }
  
  public void setLocal(boolean paramBoolean)
  {
    this.dqZ = paramBoolean;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(163675);
    super.setMute(paramBoolean);
    this.urs = paramBoolean;
    AppMethodBeat.o(163675);
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public final void start()
  {
    AppMethodBeat.i(163677);
    ac.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d] isLocal[%s]", new Object[] { blf(), this.hYq, Integer.valueOf(this.hYw), Boolean.valueOf(this.dqZ) });
    if (this.odZ != null)
    {
      if (!bs.isNullOrNil(this.odZ.getVideoPath())) {
        break label174;
      }
      if (this.dqZ)
      {
        aJl();
        this.hYt = 3;
        AppMethodBeat.o(163677);
        return;
      }
      showLoading();
      this.hYG = true;
      this.hYw = 0;
      this.hYt = 1;
      if (this.hYp != null)
      {
        this.hYp.q(this.hYq, this.hYr, this.url);
        this.hYp.a(this);
      }
      dOq();
    }
    for (;;)
    {
      oQ(getReportIdkey() + 1);
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