package com.tencent.mm.plugin.appbrand.jsapi.aa.e;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/VolumeObserver;", "Landroid/database/ContentObserver;", "context", "Landroid/content/Context;", "handler", "Landroid/os/Handler;", "(Landroid/content/Context;Landroid/os/Handler;)V", "audioManager", "Landroid/media/AudioManager;", "deliverSelfNotifications", "", "onChange", "", "selfChange", "Companion", "luggage-xweb-ext_release"})
public final class i
  extends ContentObserver
{
  public static final a kAL;
  private final AudioManager audioManager;
  
  static
  {
    AppMethodBeat.i(139678);
    kAL = new a((byte)0);
    AppMethodBeat.o(139678);
  }
  
  public i(Context paramContext)
  {
    super(null);
    AppMethodBeat.i(139677);
    paramContext = paramContext.getSystemService("audio");
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(139677);
      throw paramContext;
    }
    this.audioManager = ((AudioManager)paramContext);
    AppMethodBeat.o(139677);
  }
  
  public final boolean deliverSelfNotifications()
  {
    return false;
  }
  
  public final void onChange(boolean paramBoolean)
  {
    AppMethodBeat.i(139676);
    ad.i("SettingsContentObserver", "Volume now ".concat(String.valueOf(this.audioManager.getStreamVolume(3))));
    AppMethodBeat.o(139676);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/VolumeObserver$Companion;", "", "()V", "TAG", "", "luggage-xweb-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.i
 * JD-Core Version:    0.7.0.1
 */