package com.tencent.mm.live.core.core.trtc;

import android.content.Context;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/trtc/WXTRTCCloudImpl;", "Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;", "var0", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getDownloadStreamInfo", "", "sdkuid", "", "getUploadState", "Companion", "plugin-core_release"})
public final class b
  extends TRTCCloudImpl
{
  private static b hAO;
  public static final a hAP;
  
  static
  {
    AppMethodBeat.i(196512);
    hAP = new a((byte)0);
    AppMethodBeat.o(196512);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(196511);
    AppMethodBeat.o(196511);
  }
  
  public static CharSequence Gq(String paramString)
  {
    AppMethodBeat.i(196510);
    p.h(paramString, "sdkuid");
    AppMethodBeat.o(196510);
    return null;
  }
  
  public final CharSequence aDA()
  {
    AppMethodBeat.i(196509);
    CharSequence localCharSequence = getUploadStreamInfo();
    p.g(localCharSequence, "uploadStreamInfo");
    AppMethodBeat.o(196509);
    return localCharSequence;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/trtc/WXTRTCCloudImpl$Companion;", "", "()V", "sInstance", "Lcom/tencent/mm/live/core/core/trtc/WXTRTCCloudImpl;", "destroySharedInstance", "", "getInstance", "Lcom/tencent/trtc/TRTCCloud;", "var0", "Landroid/content/Context;", "plugin-core_release"})
  public static final class a
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a hAQ;
      
      static
      {
        AppMethodBeat.i(196508);
        hAQ = new a();
        AppMethodBeat.o(196508);
      }
      
      public final void run()
      {
        AppMethodBeat.i(196507);
        b localb = b.aDB();
        if (localb != null)
        {
          localb.finalize();
          AppMethodBeat.o(196507);
          return;
        }
        AppMethodBeat.o(196507);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.b
 * JD-Core Version:    0.7.0.1
 */