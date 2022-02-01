package com.tencent.mm.plugin.finder.live.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.replay.widget.b;
import com.tencent.mm.plugin.finder.replay.widget.d;
import com.tencent.mm.plugin.finder.replay.widget.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/SeiProcessCallbackMiniProxy;", "Lcom/tencent/mm/plugin/finder/live/model/SeiProcessViewCallback;", "sReplayMiniView", "Ljava/lang/ref/SoftReference;", "Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayMiniView;", "(Ljava/lang/ref/SoftReference;)V", "getSReplayMiniView", "()Ljava/lang/ref/SoftReference;", "checkPkAnchorAudioTip", "", "checkPkAnchorAudioVolume", "getMiniView", "notifyAnchorVolumeChange", "isTalking", "", "notifyAudienceMicUserChange", "checkDiff", "screenSize", "Lkotlin/Pair;", "", "notifyPKMicUserChange", "notifyRoomPKMicUserChange", "micData", "Lorg/json/JSONObject;", "forceUpdate", "onMediaModeChange", "audio", "screenShare", "onNotifyMicUserVolume", "setLastRoomPkMicUserList", "obj", "Lorg/json/JSONArray;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchAudioMode", "switchScreenShareMode", "docCast", "switchVideoMode", "updateVideoWidgetCover", "userId", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
  implements aw
{
  public static final av.a CIz;
  private final SoftReference<b> CIA;
  
  static
  {
    AppMethodBeat.i(360062);
    CIz = new av.a((byte)0);
    AppMethodBeat.o(360062);
  }
  
  public av(SoftReference<b> paramSoftReference)
  {
    AppMethodBeat.i(360047);
    this.CIA = paramSoftReference;
    AppMethodBeat.o(360047);
  }
  
  private b emz()
  {
    AppMethodBeat.i(360054);
    b localb = (b)this.CIA.get();
    if (localb == null) {
      Log.i("SeiProcessCallbackMiniProxy", "getMiniView fail!");
    }
    AppMethodBeat.o(360054);
    return localb;
  }
  
  public final void Y(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void awC(String paramString) {}
  
  public final void bev() {}
  
  public final void bew() {}
  
  public final void emv() {}
  
  public final void emw()
  {
    AppMethodBeat.i(360096);
    b localb = emz();
    if (localb != null) {
      d.a.a((d)localb, 1, null, false, 6);
    }
    AppMethodBeat.o(360096);
  }
  
  public final void emx() {}
  
  public final void emy() {}
  
  public final void notifyAudienceMicUserChange(boolean paramBoolean, r<Integer, Integer> paramr)
  {
    AppMethodBeat.i(360126);
    paramr = emz();
    if (paramr != null) {
      d.a.a((d)paramr, 2, null, paramBoolean, 2);
    }
    AppMethodBeat.o(360126);
  }
  
  public final boolean notifyRoomPKMicUserChange(JSONObject paramJSONObject, boolean paramBoolean, r<Integer, Integer> paramr)
  {
    AppMethodBeat.i(360132);
    paramr = emz();
    if (paramr != null) {
      d.a.a((d)paramr, 3, paramJSONObject, false, 4);
    }
    AppMethodBeat.o(360132);
    return false;
  }
  
  public final void qJ(boolean paramBoolean) {}
  
  public final void qK(boolean paramBoolean) {}
  
  public final void setLastRoomPkMicUserList(JSONArray paramJSONArray) {}
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(360073);
    s.u(paramc, "status");
    AppMethodBeat.o(360073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.av
 * JD-Core Version:    0.7.0.1
 */