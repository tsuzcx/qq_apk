package com.tencent.mm.live.core.core.trtc;

import android.content.Context;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/core/trtc/WXTRTCCloudImpl;", "Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;", "var0", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getDownloadStreamInfo", "", "sdkuid", "", "getUploadState", "Companion", "plugin-core_release"})
public final class b
  extends TRTCCloudImpl
{
  private static b gpa;
  public static final b.a gpb;
  
  static
  {
    AppMethodBeat.i(209195);
    gpb = new b.a((byte)0);
    AppMethodBeat.o(209195);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(209194);
    AppMethodBeat.o(209194);
  }
  
  public final CharSequence aiV()
  {
    AppMethodBeat.i(209193);
    CharSequence localCharSequence = getUploadStreamInfo();
    k.g(localCharSequence, "uploadStreamInfo");
    AppMethodBeat.o(209193);
    return localCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.b
 * JD-Core Version:    0.7.0.1
 */