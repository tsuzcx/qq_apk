package com.tencent.mm.live.core.core.trtc;

import android.content.Context;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/trtc/WXTRTCCloudImpl;", "Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;", "var0", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getDownloadStreamInfo", "", "sdkuid", "", "getUploadState", "Companion", "plugin-core_release"})
public final class b
  extends TRTCCloudImpl
{
  private static b qEv;
  public static final a qEw;
  
  static
  {
    AppMethodBeat.i(205659);
    qEw = new a((byte)0);
    AppMethodBeat.o(205659);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(205658);
    AppMethodBeat.o(205658);
  }
  
  public final CharSequence coS()
  {
    AppMethodBeat.i(205657);
    CharSequence localCharSequence = getUploadStreamInfo();
    k.g(localCharSequence, "uploadStreamInfo");
    AppMethodBeat.o(205657);
    return localCharSequence;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/trtc/WXTRTCCloudImpl$Companion;", "", "()V", "sInstance", "Lcom/tencent/mm/live/core/core/trtc/WXTRTCCloudImpl;", "destroySharedInstance", "", "getInstance", "Lcom/tencent/trtc/TRTCCloud;", "var0", "Landroid/content/Context;", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.b
 * JD-Core Version:    0.7.0.1
 */