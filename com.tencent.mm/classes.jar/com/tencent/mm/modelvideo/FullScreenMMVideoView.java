package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public class FullScreenMMVideoView
  extends MMVideoView
{
  private String hYj;
  
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
    AppMethodBeat.i(209964);
    if (!bs.isNullOrNil(this.hYj))
    {
      str = this.hYj;
      AppMethodBeat.o(209964);
      return str;
    }
    String str = com.tencent.mm.loader.j.b.aph() + "video/";
    AppMethodBeat.o(209964);
    return str;
  }
  
  protected final void aJh()
  {
    AppMethodBeat.i(209963);
    try
    {
      if (!bs.isNullOrNil(this.url))
      {
        this.hYq = ("MMVideo_FullScreen" + this.url.hashCode());
        this.hYr = (getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4");
        i.aSh(i.aSs(this.hYr));
        ac.i(this.TAG, "%s set video path [%s %s]", new Object[] { blf(), this.hYq, this.hYr });
      }
      AppMethodBeat.o(209963);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e(this.TAG, localThrowable.toString());
      AppMethodBeat.o(209963);
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(209962);
    try
    {
      super.c(paramBoolean, paramString, paramInt);
      aJh();
      AppMethodBeat.o(209962);
      return;
    }
    catch (Throwable paramString)
    {
      ac.e(this.TAG, paramString.toString());
      AppMethodBeat.o(209962);
    }
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(209965);
    try
    {
      if (this.hYH) {
        super.dLd();
      }
      for (;;)
      {
        this.hYv.release();
        AppMethodBeat.o(209965);
        return;
        super.onCompletion();
        if ((this.hYq != null) && (this.hYp != null)) {
          this.hYp.fo(this.hYq);
        }
        reset();
        if (this.odZ != null) {
          this.odZ.stop();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e(this.TAG, localThrowable.toString());
      AppMethodBeat.o(209965);
    }
  }
  
  public void setRootPath(String paramString)
  {
    this.hYj = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.FullScreenMMVideoView
 * JD-Core Version:    0.7.0.1
 */