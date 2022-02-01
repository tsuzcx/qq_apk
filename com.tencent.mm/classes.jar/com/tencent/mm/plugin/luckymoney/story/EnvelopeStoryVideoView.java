package com.tencent.mm.plugin.luckymoney.story;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public class EnvelopeStoryVideoView
  extends MMVideoView
{
  public static final String ROOT_PATH;
  boolean EFv;
  private boolean EFw;
  public a EFx;
  private boolean EFy;
  private boolean fEF;
  private String sessionId;
  
  static
  {
    AppMethodBeat.i(174376);
    ROOT_PATH = b.aSL() + "hbstoryvideo/";
    AppMethodBeat.o(174376);
  }
  
  public EnvelopeStoryVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163671);
    this.EFw = false;
    init();
    AppMethodBeat.o(163671);
  }
  
  public EnvelopeStoryVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163672);
    this.EFw = false;
    init();
    AppMethodBeat.o(163672);
  }
  
  public EnvelopeStoryVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(163673);
    this.EFw = false;
    init();
    AppMethodBeat.o(163673);
  }
  
  private void init()
  {
    AppMethodBeat.i(163674);
    if (this.pDN != null) {
      this.pDN.setVisibility(8);
    }
    setRootPath(ROOT_PATH);
    u.bBX(ROOT_PATH);
    setLoop(true);
    AppMethodBeat.o(163674);
  }
  
  public final boolean adH()
  {
    AppMethodBeat.i(174375);
    if ((this.txH instanceof VideoPlayerTextureView))
    {
      boolean bool = ((VideoPlayerTextureView)this.txH).adH();
      AppMethodBeat.o(174375);
      return bool;
    }
    Log.e(this.TAG, "videoview not VideoPlayerTextureView");
    if (this.mfx == 4)
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
    if (this.EFy) {
      this.mfv = paramString;
    }
    AppMethodBeat.o(163676);
  }
  
  public final boolean ePu()
  {
    return false;
  }
  
  public int getRealPlayDurationSec()
  {
    AppMethodBeat.i(174374);
    if (this.EFw)
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
    this.EFw = true;
    if ((this.mfK) && (this.EFx != null)) {
      this.EFx.a(this);
    }
    super.onCompletion();
    AppMethodBeat.o(174373);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(163679);
    Log.i(this.TAG, "%s onUIPause", new Object[] { bqf() });
    if (this.pDI)
    {
      this.pDT = getCurrPosSec();
      this.pDU = true;
      this.pEa = 0;
      this.pDZ = 0L;
      pause();
      stopTimer();
      this.pDI = false;
      EW(getReportIdkey() + 11);
    }
    AppMethodBeat.o(163679);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(163678);
    if (!this.pDI)
    {
      this.pDI = true;
      if (this.txH != null)
      {
        if (!this.pDU) {
          break label54;
        }
        bqo();
      }
    }
    for (;;)
    {
      EW(getReportIdkey() + 10);
      AppMethodBeat.o(163678);
      return;
      label54:
      ((VideoPlayerTextureView)this.txH).bXe();
    }
  }
  
  public void setLocal(boolean paramBoolean)
  {
    this.fEF = paramBoolean;
  }
  
  public void setLocalPreDownloadVideo(boolean paramBoolean)
  {
    this.EFy = paramBoolean;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(163675);
    super.setMute(paramBoolean);
    this.EFv = paramBoolean;
    AppMethodBeat.o(163675);
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public final void start()
  {
    AppMethodBeat.i(163677);
    Log.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d] isLocal[%s]", new Object[] { bqf(), this.mfu, Integer.valueOf(this.mfz), Boolean.valueOf(this.fEF) });
    if (this.txH != null)
    {
      if (!Util.isNullOrNil(this.txH.getVideoPath())) {
        break label181;
      }
      if ((this.fEF) || (this.EFy))
      {
        bqm();
        this.mfw = 3;
        AppMethodBeat.o(163677);
        return;
      }
      showLoading();
      this.mfJ = true;
      this.mfz = 0;
      this.mfw = 1;
      if (this.mft != null)
      {
        this.mft.s(this.mfu, this.mfv, this.url);
        this.mft.a(this);
      }
      fUH();
    }
    for (;;)
    {
      EW(getReportIdkey() + 1);
      AppMethodBeat.o(163677);
      return;
      label181:
      bqo();
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