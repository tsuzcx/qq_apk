package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.p;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public class FullScreenMMVideoView
  extends MMVideoView
{
  private String hxI;
  
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
    AppMethodBeat.i(195141);
    if (!bt.isNullOrNil(this.hxI))
    {
      str = this.hxI;
      AppMethodBeat.o(195141);
      return str;
    }
    String str = com.tencent.mm.loader.j.b.aih() + "video/";
    AppMethodBeat.o(195141);
    return str;
  }
  
  protected final void aCr()
  {
    AppMethodBeat.i(195140);
    try
    {
      if (!bt.isNullOrNil(this.url))
      {
        this.hxP = ("MMVideo_FullScreen" + this.url.hashCode());
        this.hxQ = (getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4");
        i.aMF(i.aMQ(this.hxQ));
        ad.i(this.TAG, "%s set video path [%s %s]", new Object[] { bel(), this.hxP, this.hxQ });
      }
      AppMethodBeat.o(195140);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e(this.TAG, localThrowable.toString());
      AppMethodBeat.o(195140);
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(195139);
    try
    {
      super.c(paramBoolean, paramString, paramInt);
      aCr();
      AppMethodBeat.o(195139);
      return;
    }
    catch (Throwable paramString)
    {
      ad.e(this.TAG, paramString.toString());
      AppMethodBeat.o(195139);
    }
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(195142);
    try
    {
      if (this.hyg) {
        super.dwE();
      }
      for (;;)
      {
        this.KCd.release();
        AppMethodBeat.o(195142);
        return;
        super.onCompletion();
        if ((this.hxP != null) && (this.hxO != null)) {
          this.hxO.fy(this.hxP);
        }
        reset();
        if (this.nAZ != null) {
          this.nAZ.stop();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e(this.TAG, localThrowable.toString());
      AppMethodBeat.o(195142);
    }
  }
  
  public void setRootPath(String paramString)
  {
    this.hxI = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.FullScreenMMVideoView
 * JD-Core Version:    0.7.0.1
 */