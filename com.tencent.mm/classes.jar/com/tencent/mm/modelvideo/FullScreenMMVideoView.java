package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public class FullScreenMMVideoView
  extends MMVideoView
{
  private String iuz;
  
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
    AppMethodBeat.i(217457);
    if (!bu.isNullOrNil(this.iuz))
    {
      str = this.iuz;
      AppMethodBeat.o(217457);
      return str;
    }
    String str = com.tencent.mm.loader.j.b.asj() + "video/";
    AppMethodBeat.o(217457);
    return str;
  }
  
  protected final void aMP()
  {
    AppMethodBeat.i(217456);
    try
    {
      if (!bu.isNullOrNil(this.url))
      {
        this.iuG = ("MMVideo_FullScreen" + this.url.hashCode());
        this.iuH = (getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4");
        o.aZI(o.aZU(this.iuH));
        ae.i(this.TAG, "%s set video path [%s %s]", new Object[] { bpA(), this.iuG, this.iuH });
      }
      AppMethodBeat.o(217456);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e(this.TAG, localThrowable.toString());
      AppMethodBeat.o(217456);
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(217455);
    try
    {
      super.c(paramBoolean, paramString, paramInt);
      aMP();
      AppMethodBeat.o(217455);
      return;
    }
    catch (Throwable paramString)
    {
      ae.e(this.TAG, paramString.toString());
      AppMethodBeat.o(217455);
    }
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(217458);
    try
    {
      if (this.iuX) {
        super.eaX();
      }
      for (;;)
      {
        this.iuL.release();
        AppMethodBeat.o(217458);
        return;
        super.onCompletion();
        if ((this.iuG != null) && (this.iuF != null)) {
          this.iuF.gp(this.iuG);
        }
        reset();
        if (this.oNV != null) {
          this.oNV.stop();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e(this.TAG, localThrowable.toString());
      AppMethodBeat.o(217458);
    }
  }
  
  public void setRootPath(String paramString)
  {
    this.iuz = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.FullScreenMMVideoView
 * JD-Core Version:    0.7.0.1
 */