package com.tencent.mm.plugin.flutter.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/ui/NormalTaskCachedFlutterActivity;", "Lcom/tencent/mm/plugin/flutter/ui/CachedFlutterActivity;", "()V", "TAG", "", "Companion", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NormalTaskCachedFlutterActivity
  extends CachedFlutterActivity
{
  public static final a Hls;
  private final String TAG = "MicroMsg.NormalTaskCachedFlutterActivity";
  
  static
  {
    AppMethodBeat.i(263266);
    Hls = new a((byte)0);
    AppMethodBeat.o(263266);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/ui/NormalTaskCachedFlutterActivity$Companion;", "", "()V", "withCachedEngine", "Lio/flutter/embedding/android/PatchedFlutterActivity$CachedEngineIntentBuilder;", "cachedEngineId", "", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.ui.NormalTaskCachedFlutterActivity
 * JD-Core Version:    0.7.0.1
 */