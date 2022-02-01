package com.tencent.mm.live.core.core.trtc;

import android.content.Context;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/trtc/WXTRTCCloudImpl;", "Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;", "var0", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getDownloadStreamInfo", "", "sdkuid", "", "getUploadState", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends TRTCCloudImpl
{
  public static final a mSj;
  private static c mSk;
  
  static
  {
    AppMethodBeat.i(248287);
    mSj = new a((byte)0);
    AppMethodBeat.o(248287);
  }
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(248262);
    AppMethodBeat.o(248262);
  }
  
  public static CharSequence FR(String paramString)
  {
    AppMethodBeat.i(248268);
    s.u(paramString, "sdkuid");
    AppMethodBeat.o(248268);
    return null;
  }
  
  public final CharSequence bfk()
  {
    AppMethodBeat.i(248294);
    CharSequence localCharSequence = getUploadStreamInfo();
    s.s(localCharSequence, "uploadStreamInfo");
    AppMethodBeat.o(248294);
    return localCharSequence;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/trtc/WXTRTCCloudImpl$Companion;", "", "()V", "sInstance", "Lcom/tencent/mm/live/core/core/trtc/WXTRTCCloudImpl;", "destroySharedInstance", "", "getInstance", "Lcom/tencent/trtc/TRTCCloud;", "var0", "Landroid/content/Context;", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final void bfm()
    {
      AppMethodBeat.i(248260);
      c localc = c.bfl();
      if (localc != null) {
        localc.finalize();
      }
      AppMethodBeat.o(248260);
    }
    
    public static void destroySharedInstance()
    {
      AppMethodBeat.i(248254);
      c localc = c.bfl();
      if (localc != null) {
        localc.destroy();
      }
      localc = c.bfl();
      if (localc != null) {
        c.a(localc, c.a..ExternalSyntheticLambda0.INSTANCE);
      }
      c.a(null);
      AppMethodBeat.o(248254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.c
 * JD-Core Version:    0.7.0.1
 */