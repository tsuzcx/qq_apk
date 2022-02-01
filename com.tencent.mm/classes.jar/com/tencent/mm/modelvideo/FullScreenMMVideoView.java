package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public class FullScreenMMVideoView
  extends MMVideoView
{
  private String oYg;
  
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
    AppMethodBeat.i(241191);
    if (!Util.isNullOrNil(this.oYg))
    {
      str = this.oYg;
      AppMethodBeat.o(241191);
      return str;
    }
    String str = b.bmz() + "video/";
    AppMethodBeat.o(241191);
    return str;
  }
  
  public final void b(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(241193);
    try
    {
      super.b(paramBoolean, paramString, paramInt);
      bNO();
      AppMethodBeat.o(241193);
      return;
    }
    finally
    {
      Log.e("MicroMsg.FullScreenMMVideoView", paramString.toString());
      AppMethodBeat.o(241193);
    }
  }
  
  public final String bNL()
  {
    AppMethodBeat.i(241204);
    String str = this.oYq + " ";
    AppMethodBeat.o(241204);
    return str;
  }
  
  protected final void bNO()
  {
    AppMethodBeat.i(241199);
    try
    {
      if (!Util.isNullOrNil(this.url))
      {
        this.oYq = ("MMVideo_FullScreen" + this.url.hashCode());
        if (((c)h.ax(c.class)).a(c.a.yIy, 0) <= 0) {
          break label151;
        }
      }
      label151:
      for (this.oYr = (getRootPath() + "MMVideo_FullScreen_" + this.url.hashCode() + ".mp4");; this.oYr = (getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4"))
      {
        y.bDX(y.bEo(this.oYr));
        Log.i("MicroMsg.FullScreenMMVideoView", "%s set video path [%s %s]", new Object[] { bNL(), this.oYq, this.oYr });
        AppMethodBeat.o(241199);
        return;
      }
      return;
    }
    finally
    {
      Log.e("MicroMsg.FullScreenMMVideoView", localObject.toString());
      AppMethodBeat.o(241199);
    }
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(241201);
    try
    {
      if (this.oYG) {
        super.hay();
      }
      for (;;)
      {
        this.oYu.release();
        AppMethodBeat.o(241201);
        return;
        super.onCompletion();
        if ((this.oYq != null) && (this.oYp != null)) {
          this.oYp.js(this.oYq);
        }
        reset();
        if (this.wCd != null) {
          this.wCd.stop();
        }
      }
      return;
    }
    finally
    {
      Log.e("MicroMsg.FullScreenMMVideoView", localObject.toString());
      AppMethodBeat.o(241201);
    }
  }
  
  public void setRootPath(String paramString)
  {
    this.oYg = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvideo.FullScreenMMVideoView
 * JD-Core Version:    0.7.0.1
 */