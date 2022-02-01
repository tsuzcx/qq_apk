package com.tencent.mm.plugin.flutter.ui;

import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/ui/CachedFlutterActivity$OnKeyListenerAdapter;", "Lcom/tencent/mm/plugin/flutter/ui/CachedFlutterActivity$OnKeyListener;", "()V", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKeyLongPress", "onKeyMultiple", "repeatCount", "onKeyUp", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public class CachedFlutterActivity$c
  implements CachedFlutterActivity.b
{
  public final boolean k(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(263270);
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(263270);
    return false;
  }
  
  public final boolean l(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(263276);
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(263276);
    return false;
  }
  
  public final boolean m(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(263282);
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(263282);
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(263265);
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(263265);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.ui.CachedFlutterActivity.c
 * JD-Core Version:    0.7.0.1
 */