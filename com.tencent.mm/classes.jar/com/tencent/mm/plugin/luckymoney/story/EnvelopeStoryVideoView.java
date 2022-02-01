package com.tencent.mm.plugin.luckymoney.story;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public class EnvelopeStoryVideoView
  extends MMVideoView
{
  public static final String ROOT_PATH;
  private boolean dDV;
  private String sessionId;
  boolean vFZ;
  private boolean vGa;
  public a vGb;
  
  static
  {
    AppMethodBeat.i(174376);
    ROOT_PATH = com.tencent.mm.loader.j.b.asj() + "hbstoryvideo/";
    AppMethodBeat.o(174376);
  }
  
  public EnvelopeStoryVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163671);
    this.vGa = false;
    init();
    AppMethodBeat.o(163671);
  }
  
  public EnvelopeStoryVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163672);
    this.vGa = false;
    init();
    AppMethodBeat.o(163672);
  }
  
  public EnvelopeStoryVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(163673);
    this.vGa = false;
    init();
    AppMethodBeat.o(163673);
  }
  
  private void init()
  {
    AppMethodBeat.i(163674);
    if (this.lxD != null) {
      this.lxD.setVisibility(8);
    }
    setRootPath(ROOT_PATH);
    o.aZX(ROOT_PATH);
    setLoop(true);
    AppMethodBeat.o(163674);
  }
  
  public final boolean OG()
  {
    AppMethodBeat.i(174375);
    if ((this.oNV instanceof VideoPlayerTextureView))
    {
      boolean bool = ((VideoPlayerTextureView)this.oNV).OG();
      AppMethodBeat.o(174375);
      return bool;
    }
    ae.e(this.TAG, "videoview not VideoPlayerTextureView");
    if (this.iuK == 4)
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
  
  public final boolean dlY()
  {
    return false;
  }
  
  public int getRealPlayDurationSec()
  {
    AppMethodBeat.i(174374);
    if (this.vGa)
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
    this.vGa = true;
    if ((this.iuX) && (this.vGb != null)) {
      this.vGb.a(this);
    }
    super.onCompletion();
    AppMethodBeat.o(174373);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(163679);
    ae.i(this.TAG, "%s onUIPause", new Object[] { bpA() });
    if (this.lxy)
    {
      this.lxJ = getCurrPosSec();
      this.lxK = true;
      this.lxQ = 0;
      this.lxP = 0L;
      pause();
      stopTimer();
      this.lxy = false;
      rd(getReportIdkey() + 11);
    }
    AppMethodBeat.o(163679);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(163678);
    if (!this.lxy)
    {
      this.lxy = true;
      if (this.oNV != null)
      {
        if (!this.lxK) {
          break label54;
        }
        play();
      }
    }
    for (;;)
    {
      rd(getReportIdkey() + 10);
      AppMethodBeat.o(163678);
      return;
      label54:
      ((VideoPlayerTextureView)this.oNV).bpy();
    }
  }
  
  public void setLocal(boolean paramBoolean)
  {
    this.dDV = paramBoolean;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(163675);
    super.setMute(paramBoolean);
    this.vFZ = paramBoolean;
    AppMethodBeat.o(163675);
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public final void start()
  {
    AppMethodBeat.i(163677);
    ae.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d] isLocal[%s]", new Object[] { bpA(), this.iuG, Integer.valueOf(this.iuM), Boolean.valueOf(this.dDV) });
    if (this.oNV != null)
    {
      if (!bu.isNullOrNil(this.oNV.getVideoPath())) {
        break label174;
      }
      if (this.dDV)
      {
        aMT();
        this.iuJ = 3;
        AppMethodBeat.o(163677);
        return;
      }
      showLoading();
      this.iuW = true;
      this.iuM = 0;
      this.iuJ = 1;
      if (this.iuF != null)
      {
        this.iuF.p(this.iuG, this.iuH, this.url);
        this.iuF.a(this);
      }
      eek();
    }
    for (;;)
    {
      rd(getReportIdkey() + 1);
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