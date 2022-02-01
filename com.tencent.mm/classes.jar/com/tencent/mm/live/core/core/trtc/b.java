package com.tencent.mm.live.core.core.trtc;

import android.content.Context;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/core/trtc/WXTRTCCloudImpl;", "Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;", "var0", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getDownloadStreamInfo", "", "sdkuid", "", "getUploadState", "Companion", "plugin-core_release"})
public final class b
  extends TRTCCloudImpl
{
  private static b gLr;
  public static final b.a gLs;
  
  static
  {
    AppMethodBeat.i(196865);
    gLs = new b.a((byte)0);
    AppMethodBeat.o(196865);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(196864);
    AppMethodBeat.o(196864);
  }
  
  public static CharSequence xW(String paramString)
  {
    AppMethodBeat.i(196863);
    p.h(paramString, "sdkuid");
    AppMethodBeat.o(196863);
    return null;
  }
  
  public final CharSequence alW()
  {
    AppMethodBeat.i(196862);
    CharSequence localCharSequence = getUploadStreamInfo();
    p.g(localCharSequence, "uploadStreamInfo");
    AppMethodBeat.o(196862);
    return localCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.b
 * JD-Core Version:    0.7.0.1
 */