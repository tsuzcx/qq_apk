package com.tencent.mm.live.core.core.trtc;

import android.content.Context;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/trtc/WXTRTCCloudImpl;", "Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;", "var0", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getDownloadStreamInfo", "", "sdkuid", "", "getUploadState", "Companion", "plugin-core_release"})
public final class b
  extends TRTCCloudImpl
{
  private static b kov;
  public static final a kow;
  
  static
  {
    AppMethodBeat.i(198178);
    kow = new a((byte)0);
    AppMethodBeat.o(198178);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(198176);
    AppMethodBeat.o(198176);
  }
  
  public static CharSequence Ny(String paramString)
  {
    AppMethodBeat.i(198174);
    p.k(paramString, "sdkuid");
    AppMethodBeat.o(198174);
    return null;
  }
  
  public final CharSequence aLG()
  {
    AppMethodBeat.i(198171);
    CharSequence localCharSequence = getUploadStreamInfo();
    p.j(localCharSequence, "uploadStreamInfo");
    AppMethodBeat.o(198171);
    return localCharSequence;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/trtc/WXTRTCCloudImpl$Companion;", "", "()V", "sInstance", "Lcom/tencent/mm/live/core/core/trtc/WXTRTCCloudImpl;", "destroySharedInstance", "", "getInstance", "Lcom/tencent/trtc/TRTCCloud;", "var0", "Landroid/content/Context;", "plugin-core_release"})
  public static final class a
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a kox;
      
      static
      {
        AppMethodBeat.i(200623);
        kox = new a();
        AppMethodBeat.o(200623);
      }
      
      public final void run()
      {
        AppMethodBeat.i(200621);
        b localb = b.aLH();
        if (localb != null)
        {
          localb.finalize();
          AppMethodBeat.o(200621);
          return;
        }
        AppMethodBeat.o(200621);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.b
 * JD-Core Version:    0.7.0.1
 */