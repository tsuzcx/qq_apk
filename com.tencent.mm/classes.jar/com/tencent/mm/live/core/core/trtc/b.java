package com.tencent.mm.live.core.core.trtc;

import android.content.Context;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/core/trtc/WXTRTCCloudImpl;", "Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;", "var0", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getDownloadStreamInfo", "", "sdkuid", "", "getUploadState", "Companion", "plugin-core_release"})
public final class b
  extends TRTCCloudImpl
{
  private static b gII;
  public static final b.a gIJ;
  
  static
  {
    AppMethodBeat.i(216853);
    gIJ = new b.a((byte)0);
    AppMethodBeat.o(216853);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(216852);
    AppMethodBeat.o(216852);
  }
  
  public static CharSequence xn(String paramString)
  {
    AppMethodBeat.i(216851);
    p.h(paramString, "sdkuid");
    AppMethodBeat.o(216851);
    return null;
  }
  
  public final CharSequence alH()
  {
    AppMethodBeat.i(216850);
    CharSequence localCharSequence = getUploadStreamInfo();
    p.g(localCharSequence, "uploadStreamInfo");
    AppMethodBeat.o(216850);
    return localCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.b
 * JD-Core Version:    0.7.0.1
 */