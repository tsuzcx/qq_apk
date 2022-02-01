package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public class FullScreenMMVideoView
  extends MMVideoView
{
  private String jpM;
  
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
    AppMethodBeat.i(240845);
    if (!Util.isNullOrNil(this.jpM))
    {
      str = this.jpM;
      AppMethodBeat.o(240845);
      return str;
    }
    String str = com.tencent.mm.loader.j.b.aKJ() + "video/";
    AppMethodBeat.o(240845);
    return str;
  }
  
  public final String bgQ()
  {
    AppMethodBeat.i(240847);
    String str = this.jpT + " ";
    AppMethodBeat.o(240847);
    return str;
  }
  
  protected final void bgR()
  {
    AppMethodBeat.i(240844);
    try
    {
      if (!Util.isNullOrNil(this.url))
      {
        this.jpT = ("MMVideo_FullScreen" + this.url.hashCode());
        this.jpU = (getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4");
        s.boN(s.boZ(this.jpU));
        Log.i("MicroMsg.FullScreenMMVideoView", "%s set video path [%s %s]", new Object[] { bgQ(), this.jpT, this.jpU });
      }
      AppMethodBeat.o(240844);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.FullScreenMMVideoView", localThrowable.toString());
      AppMethodBeat.o(240844);
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(240843);
    try
    {
      super.c(paramBoolean, paramString, paramInt);
      bgR();
      AppMethodBeat.o(240843);
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.FullScreenMMVideoView", paramString.toString());
      AppMethodBeat.o(240843);
    }
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(240846);
    try
    {
      if (this.jqj) {
        super.fdO();
      }
      for (;;)
      {
        this.jpX.release();
        AppMethodBeat.o(240846);
        return;
        super.onCompletion();
        if ((this.jpT != null) && (this.jpS != null)) {
          this.jpS.he(this.jpT);
        }
        reset();
        if (this.qbJ != null) {
          this.qbJ.stop();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.FullScreenMMVideoView", localThrowable.toString());
      AppMethodBeat.o(240846);
    }
  }
  
  public void setRootPath(String paramString)
  {
    this.jpM = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvideo.FullScreenMMVideoView
 * JD-Core Version:    0.7.0.1
 */