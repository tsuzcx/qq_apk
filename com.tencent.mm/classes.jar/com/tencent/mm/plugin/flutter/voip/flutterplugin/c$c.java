package com.tencent.mm.plugin.flutter.voip.flutterplugin;

import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.ui.CachedFlutterActivity.c;
import com.tencent.mm.plugin.flutter.voip.manager.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/flutter/voip/flutterplugin/FlutterVoipPlugin$onAttachedToActivity$2", "Lcom/tencent/mm/plugin/flutter/ui/CachedFlutterActivity$OnKeyListenerAdapter;", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$c
  extends CachedFlutterActivity.c
{
  c$c(c paramc) {}
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(263420);
    s.u(paramKeyEvent, "event");
    Object localObject = c.a(this.Hni);
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Boolean.valueOf(((b)localObject).onKeyDown(paramInt, paramKeyEvent)))
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(263420);
      return bool;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(263420);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.flutterplugin.c.c
 * JD-Core Version:    0.7.0.1
 */