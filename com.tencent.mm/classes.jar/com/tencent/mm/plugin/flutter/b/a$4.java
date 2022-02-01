package com.tencent.mm.plugin.flutter.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.plugin.a.k.d;

final class a$4
  implements k.d
{
  a$4(a parama, Context paramContext) {}
  
  public final void b(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(240931);
    Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onBackPressed error");
    ((Activity)this.lRR).finish();
    AppMethodBeat.o(240931);
  }
  
  public final void ba(Object paramObject)
  {
    AppMethodBeat.i(240930);
    if ((paramObject != null) && ((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue()))
    {
      this.wJp.dLr();
      AppMethodBeat.o(240930);
      return;
    }
    Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onBackPressed success can not pop.");
    this.wJp.dLr();
    AppMethodBeat.o(240930);
  }
  
  public final void dLv()
  {
    AppMethodBeat.i(240932);
    Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onBackPressed notImplemented");
    ((Activity)this.lRR).finish();
    AppMethodBeat.o(240932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.b.a.4
 * JD-Core Version:    0.7.0.1
 */