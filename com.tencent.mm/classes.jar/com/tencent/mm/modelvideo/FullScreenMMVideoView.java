package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public class FullScreenMMVideoView
  extends MMVideoView
{
  private String mfn;
  
  public FullScreenMMVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FullScreenMMVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FullScreenMMVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String getRootPath()
  {
    AppMethodBeat.i(216800);
    if (!Util.isNullOrNil(this.mfn))
    {
      str = this.mfn;
      AppMethodBeat.o(216800);
      return str;
    }
    String str = com.tencent.mm.loader.j.b.aSL() + "video/";
    AppMethodBeat.o(216800);
    return str;
  }
  
  public final String bqf()
  {
    AppMethodBeat.i(216802);
    String str = this.mfu + " ";
    AppMethodBeat.o(216802);
    return str;
  }
  
  protected final void bqi()
  {
    AppMethodBeat.i(216799);
    try
    {
      if (!Util.isNullOrNil(this.url))
      {
        this.mfu = ("MMVideo_FullScreen" + this.url.hashCode());
        if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvv, 0) <= 0) {
          break label151;
        }
      }
      label151:
      for (this.mfv = (getRootPath() + "MMVideo_FullScreen_" + this.url.hashCode() + ".mp4");; this.mfv = (getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4"))
      {
        u.bBD(u.bBT(this.mfv));
        Log.i("MicroMsg.FullScreenMMVideoView", "%s set video path [%s %s]", new Object[] { bqf(), this.mfu, this.mfv });
        AppMethodBeat.o(216799);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.FullScreenMMVideoView", localThrowable.toString());
      AppMethodBeat.o(216799);
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(216798);
    try
    {
      super.c(paramBoolean, paramString, paramInt);
      bqi();
      AppMethodBeat.o(216798);
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.FullScreenMMVideoView", paramString.toString());
      AppMethodBeat.o(216798);
    }
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(216801);
    try
    {
      if (this.mfK) {
        super.fKt();
      }
      for (;;)
      {
        this.mfy.release();
        AppMethodBeat.o(216801);
        return;
        super.onCompletion();
        if ((this.mfu != null) && (this.mft != null)) {
          this.mft.hR(this.mfu);
        }
        reset();
        if (this.txH != null) {
          this.txH.stop();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.FullScreenMMVideoView", localThrowable.toString());
      AppMethodBeat.o(216801);
    }
  }
  
  public void setRootPath(String paramString)
  {
    this.mfn = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.FullScreenMMVideoView
 * JD-Core Version:    0.7.0.1
 */