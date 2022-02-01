package com.tencent.mm.plugin.luckymoney.story;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public class EnvelopeStoryVideoView
  extends MMVideoView
{
  public static final String ROOT_PATH;
  private boolean dLQ;
  private String sessionId;
  boolean zaZ;
  private boolean zba;
  public a zbb;
  
  static
  {
    AppMethodBeat.i(174376);
    ROOT_PATH = com.tencent.mm.loader.j.b.aKJ() + "hbstoryvideo/";
    AppMethodBeat.o(174376);
  }
  
  public EnvelopeStoryVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163671);
    this.zba = false;
    init();
    AppMethodBeat.o(163671);
  }
  
  public EnvelopeStoryVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163672);
    this.zba = false;
    init();
    AppMethodBeat.o(163672);
  }
  
  public EnvelopeStoryVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(163673);
    this.zba = false;
    init();
    AppMethodBeat.o(163673);
  }
  
  private void init()
  {
    AppMethodBeat.i(163674);
    if (this.mEB != null) {
      this.mEB.setVisibility(8);
    }
    setRootPath(ROOT_PATH);
    s.bpc(ROOT_PATH);
    setLoop(true);
    AppMethodBeat.o(163674);
  }
  
  public final boolean YY()
  {
    AppMethodBeat.i(174375);
    if ((this.qbJ instanceof VideoPlayerTextureView))
    {
      boolean bool = ((VideoPlayerTextureView)this.qbJ).YY();
      AppMethodBeat.o(174375);
      return bool;
    }
    Log.e(this.TAG, "videoview not VideoPlayerTextureView");
    if (this.jpW == 4)
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
  
  public final boolean efT()
  {
    return false;
  }
  
  public int getRealPlayDurationSec()
  {
    AppMethodBeat.i(174374);
    if (this.zba)
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
    this.zba = true;
    if ((this.jqj) && (this.zbb != null)) {
      this.zbb.a(this);
    }
    super.onCompletion();
    AppMethodBeat.o(174373);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(163679);
    Log.i(this.TAG, "%s onUIPause", new Object[] { bgQ() });
    if (this.mEw)
    {
      this.mEH = getCurrPosSec();
      this.mEI = true;
      this.mEO = 0;
      this.mEN = 0L;
      pause();
      stopTimer();
      this.mEw = false;
      yU(getReportIdkey() + 11);
    }
    AppMethodBeat.o(163679);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(163678);
    if (!this.mEw)
    {
      this.mEw = true;
      if (this.qbJ != null)
      {
        if (!this.mEI) {
          break label54;
        }
        play();
      }
    }
    for (;;)
    {
      yU(getReportIdkey() + 10);
      AppMethodBeat.o(163678);
      return;
      label54:
      ((VideoPlayerTextureView)this.qbJ).bLe();
    }
  }
  
  public void setLocal(boolean paramBoolean)
  {
    this.dLQ = paramBoolean;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(163675);
    super.setMute(paramBoolean);
    this.zaZ = paramBoolean;
    AppMethodBeat.o(163675);
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public final void start()
  {
    AppMethodBeat.i(163677);
    Log.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d] isLocal[%s]", new Object[] { bgQ(), this.jpT, Integer.valueOf(this.jpY), Boolean.valueOf(this.dLQ) });
    if (this.qbJ != null)
    {
      if (!Util.isNullOrNil(this.qbJ.getVideoPath())) {
        break label174;
      }
      if (this.dLQ)
      {
        bgV();
        this.jpV = 3;
        AppMethodBeat.o(163677);
        return;
      }
      showLoading();
      this.jqi = true;
      this.jpY = 0;
      this.jpV = 1;
      if (this.jpS != null)
      {
        this.jpS.p(this.jpT, this.jpU, this.url);
        this.jpS.a(this);
      }
      fgB();
    }
    for (;;)
    {
      yU(getReportIdkey() + 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoView
 * JD-Core Version:    0.7.0.1
 */