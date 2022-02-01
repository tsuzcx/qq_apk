package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public class FullScreenMMVideoView
  extends MMVideoView
{
  private String irF;
  
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
    AppMethodBeat.i(218840);
    if (!bt.isNullOrNil(this.irF))
    {
      str = this.irF;
      AppMethodBeat.o(218840);
      return str;
    }
    String str = com.tencent.mm.loader.j.b.arU() + "video/";
    AppMethodBeat.o(218840);
    return str;
  }
  
  protected final void aMr()
  {
    AppMethodBeat.i(218839);
    try
    {
      if (!bt.isNullOrNil(this.url))
      {
        this.irM = ("MMVideo_FullScreen" + this.url.hashCode());
        this.irN = (getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4");
        i.aYg(i.aYr(this.irN));
        ad.i(this.TAG, "%s set video path [%s %s]", new Object[] { boQ(), this.irM, this.irN });
      }
      AppMethodBeat.o(218839);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e(this.TAG, localThrowable.toString());
      AppMethodBeat.o(218839);
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(218838);
    try
    {
      super.c(paramBoolean, paramString, paramInt);
      aMr();
      AppMethodBeat.o(218838);
      return;
    }
    catch (Throwable paramString)
    {
      ad.e(this.TAG, paramString.toString());
      AppMethodBeat.o(218838);
    }
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(218841);
    try
    {
      if (this.isd) {
        super.dXu();
      }
      for (;;)
      {
        this.irR.release();
        AppMethodBeat.o(218841);
        return;
        super.onCompletion();
        if ((this.irM != null) && (this.irL != null)) {
          this.irL.gj(this.irM);
        }
        reset();
        if (this.oHt != null) {
          this.oHt.stop();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e(this.TAG, localThrowable.toString());
      AppMethodBeat.o(218841);
    }
  }
  
  public void setRootPath(String paramString)
  {
    this.irF = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.FullScreenMMVideoView
 * JD-Core Version:    0.7.0.1
 */