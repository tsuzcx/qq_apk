package com.tencent.mm.plugin.flutter.ui;

import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.pulldown.c;
import kotlin.Metadata;

@a(3)
@c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/ui/TransparentCachedFlutterActivity;", "Lcom/tencent/mm/plugin/flutter/ui/CachedFlutterActivity;", "()V", "finish", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TransparentCachedFlutterActivity
  extends CachedFlutterActivity
{
  public static final a Hlt;
  
  static
  {
    AppMethodBeat.i(263274);
    Hlt = new a((byte)0);
    AppMethodBeat.o(263274);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(263287);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(263287);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(263279);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().setStatusBarColor(0);
    AppMethodBeat.o(263279);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/ui/TransparentCachedFlutterActivity$Companion;", "", "()V", "withCachedEngine", "Lio/flutter/embedding/android/PatchedFlutterActivity$CachedEngineIntentBuilder;", "cachedEngineId", "", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.ui.TransparentCachedFlutterActivity
 * JD-Core Version:    0.7.0.1
 */