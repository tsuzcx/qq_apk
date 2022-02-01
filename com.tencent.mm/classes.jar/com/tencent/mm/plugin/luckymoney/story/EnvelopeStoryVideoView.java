package com.tencent.mm.plugin.luckymoney.story;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public class EnvelopeStoryVideoView
  extends MMVideoView
{
  public static final String ROOT_PATH;
  boolean KyA;
  private boolean KyB;
  public a KyC;
  private boolean KyD;
  private boolean hJv;
  private String sessionId;
  
  static
  {
    AppMethodBeat.i(174376);
    ROOT_PATH = b.bmz() + "hbstoryvideo/";
    AppMethodBeat.o(174376);
  }
  
  public EnvelopeStoryVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163671);
    this.KyB = false;
    init();
    AppMethodBeat.o(163671);
  }
  
  public EnvelopeStoryVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163672);
    this.KyB = false;
    init();
    AppMethodBeat.o(163672);
  }
  
  public EnvelopeStoryVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(163673);
    this.KyB = false;
    init();
    AppMethodBeat.o(163673);
  }
  
  private void init()
  {
    AppMethodBeat.i(163674);
    if (this.sIZ != null) {
      this.sIZ.setVisibility(8);
    }
    setRootPath(ROOT_PATH);
    y.bEr(ROOT_PATH);
    setLoop(true);
    AppMethodBeat.o(163674);
  }
  
  public final boolean aFF()
  {
    AppMethodBeat.i(174375);
    if ((this.wCd instanceof VideoPlayerTextureView))
    {
      boolean bool = ((VideoPlayerTextureView)this.wCd).aFF();
      AppMethodBeat.o(174375);
      return bool;
    }
    Log.e(this.TAG, "videoview not VideoPlayerTextureView");
    if (this.oYt == 4)
    {
      AppMethodBeat.o(174375);
      return true;
    }
    AppMethodBeat.o(174375);
    return false;
  }
  
  public final void b(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(163676);
    super.b(paramBoolean, paramString, paramInt);
    if (this.KyD) {
      this.oYr = paramString;
    }
    AppMethodBeat.o(163676);
  }
  
  public final boolean fXY()
  {
    return false;
  }
  
  public int getRealPlayDurationSec()
  {
    AppMethodBeat.i(174374);
    if (this.KyB)
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
    this.KyB = true;
    if ((this.oYG) && (this.KyC != null)) {
      this.KyC.a(this);
    }
    super.onCompletion();
    AppMethodBeat.o(174373);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(163679);
    Log.i(this.TAG, "%s onUIPause", new Object[] { bNL() });
    if (this.sIU)
    {
      this.sJf = getCurrPosSec();
      this.sJg = true;
      this.sJm = 0;
      this.sJl = 0L;
      pause();
      stopTimer();
      this.sIU = false;
      hp(getReportIdkey() + 11);
    }
    AppMethodBeat.o(163679);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(163678);
    if (!this.sIU)
    {
      this.sIU = true;
      if (this.wCd != null)
      {
        if (!this.sJg) {
          break label54;
        }
        bNU();
      }
    }
    for (;;)
    {
      hp(getReportIdkey() + 10);
      AppMethodBeat.o(163678);
      return;
      label54:
      ((VideoPlayerTextureView)this.wCd).cxp();
    }
  }
  
  public void setLocal(boolean paramBoolean)
  {
    this.hJv = paramBoolean;
  }
  
  public void setLocalPreDownloadVideo(boolean paramBoolean)
  {
    this.KyD = paramBoolean;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(163675);
    super.setMute(paramBoolean);
    this.KyA = paramBoolean;
    AppMethodBeat.o(163675);
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public final void start()
  {
    AppMethodBeat.i(163677);
    Log.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d] isLocal[%s]", new Object[] { bNL(), this.oYq, Integer.valueOf(this.oYv), Boolean.valueOf(this.hJv) });
    if (this.wCd != null)
    {
      if (!Util.isNullOrNil(this.wCd.getVideoPath())) {
        break label181;
      }
      if ((this.hJv) || (this.KyD))
      {
        bNS();
        this.oYs = 3;
        AppMethodBeat.o(163677);
        return;
      }
      showLoading();
      this.oYF = true;
      this.oYv = 0;
      this.oYs = 1;
      if (this.oYp != null)
      {
        this.oYp.w(this.oYq, this.oYr, this.url);
        this.oYp.a(this);
      }
      hmY();
    }
    for (;;)
    {
      hp(getReportIdkey() + 1);
      AppMethodBeat.o(163677);
      return;
      label181:
      bNU();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(EnvelopeStoryVideoView paramEnvelopeStoryVideoView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoView
 * JD-Core Version:    0.7.0.1
 */