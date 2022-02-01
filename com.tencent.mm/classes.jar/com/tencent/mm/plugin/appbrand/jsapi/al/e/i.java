package com.tencent.mm.plugin.appbrand.jsapi.al.e;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/VolumeObserver;", "Landroid/database/ContentObserver;", "context", "Landroid/content/Context;", "handler", "Landroid/os/Handler;", "(Landroid/content/Context;Landroid/os/Handler;)V", "audioManager", "Landroid/media/AudioManager;", "deliverSelfNotifications", "", "onChange", "", "selfChange", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends ContentObserver
{
  public static final i.a sQS;
  private final AudioManager audioManager;
  
  static
  {
    AppMethodBeat.i(139678);
    sQS = new i.a((byte)0);
    AppMethodBeat.o(139678);
  }
  
  public i(Context paramContext)
  {
    super(null);
    AppMethodBeat.i(139677);
    paramContext = paramContext.getSystemService("audio");
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
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
    Log.i("SettingsContentObserver", s.X("Volume now ", Integer.valueOf(this.audioManager.getStreamVolume(3))));
    AppMethodBeat.o(139676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.i
 * JD-Core Version:    0.7.0.1
 */