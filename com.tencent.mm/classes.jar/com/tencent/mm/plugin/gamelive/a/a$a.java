package com.tencent.mm.plugin.gamelive.a;

import android.database.ContentObserver;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class a$a
  extends ContentObserver
{
  public a$a(a parama)
  {
    super(null);
  }
  
  public final boolean deliverSelfNotifications()
  {
    return false;
  }
  
  public final void onChange(boolean paramBoolean)
  {
    AppMethodBeat.i(208533);
    int i = this.Dlv.Dlo.getStreamVolume(3);
    Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "user vol changed old:%d new:%d max:%d", new Object[] { Integer.valueOf(this.Dlv.tUM), Integer.valueOf(i), Integer.valueOf(this.Dlv.Dlp) });
    this.Dlv.tUM = i;
    AppMethodBeat.o(208533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.a.a.a
 * JD-Core Version:    0.7.0.1
 */