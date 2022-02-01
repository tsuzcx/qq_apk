package com.tencent.mm.plugin.flutter.voip.flutterplugin;

import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.flutter.voip.manager.b;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.j;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/flutter/voip/flutterplugin/FlutterVoipPlugin$observePermission$1", "Landroidx/lifecycle/LifecycleObserver;", "onResume", "", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FlutterVoipPlugin$observePermission$1
  implements p
{
  FlutterVoipPlugin$observePermission$1(c paramc) {}
  
  @z(Ho=j.a.ON_RESUME)
  public final void onResume()
  {
    AppMethodBeat.i(263426);
    Log.i("MicroMsg.FlutterVoipPlugin", "onResume");
    b localb = c.a(this.Hni);
    if ((localb != null) && (localb.hWg() == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.i("MicroMsg.FlutterVoipPlugin", "not in minimized state, call onVoipDeviceCalled()");
        localb = c.a(this.Hni);
        if (localb != null) {
          localb.hVP();
        }
      }
      SubCoreVoip.hVq().jb(true);
      if (h.baz()) {
        SubCoreVoip.hVp().bp(false, false);
      }
      localb = c.a(this.Hni);
      if (localb != null) {
        localb.fvU();
      }
      AppMethodBeat.o(263426);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.flutterplugin.FlutterVoipPlugin.observePermission.1
 * JD-Core Version:    0.7.0.1
 */