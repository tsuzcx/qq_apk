package com.tencent.mm.plugin.finder.live.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.plugin.aj;
import com.tencent.mm.plugin.finder.live.plugin.be;
import com.tencent.mm.plugin.finder.live.plugin.bf;
import com.tencent.mm.plugin.finder.live.view.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/SeiProcessCallbackFullUIProxy;", "Lcom/tencent/mm/plugin/finder/live/model/SeiProcessViewCallback;", "sReplayPluginLayout", "Ljava/lang/ref/SoftReference;", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "(Ljava/lang/ref/SoftReference;)V", "getSReplayPluginLayout", "()Ljava/lang/ref/SoftReference;", "checkPkAnchorAudioTip", "", "checkPkAnchorAudioVolume", "getPluginLayout", "notifyAnchorVolumeChange", "isTalking", "", "notifyAudienceMicUserChange", "checkDiff", "screenSize", "Lkotlin/Pair;", "", "notifyPKMicUserChange", "notifyRoomPKMicUserChange", "micData", "Lorg/json/JSONObject;", "forceUpdate", "onMediaModeChange", "audio", "screenShare", "onNotifyMicUserVolume", "setLastRoomPkMicUserList", "obj", "Lorg/json/JSONArray;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchAudioMode", "switchScreenShareMode", "docCast", "switchVideoMode", "updateVideoWidgetCover", "userId", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class au
  implements aw
{
  public static final au.a CIx;
  private final SoftReference<a> CIy;
  
  static
  {
    AppMethodBeat.i(360086);
    CIx = new au.a((byte)0);
    AppMethodBeat.o(360086);
  }
  
  public au(SoftReference<a> paramSoftReference)
  {
    AppMethodBeat.i(360060);
    this.CIy = paramSoftReference;
    AppMethodBeat.o(360060);
  }
  
  private a ehM()
  {
    AppMethodBeat.i(360072);
    a locala = (a)this.CIy.get();
    if (locala == null) {
      Log.i("SeiProcessCallbackFullUIProxy", "getPluginLayout fail!");
    }
    AppMethodBeat.o(360072);
    return locala;
  }
  
  public final void Y(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void awC(String paramString)
  {
    AppMethodBeat.i(360145);
    Object localObject = ehM();
    if (localObject != null)
    {
      localObject = (bf)((a)localObject).getPlugin(bf.class);
      if (localObject != null) {
        ((bf)localObject).awC(paramString);
      }
    }
    AppMethodBeat.o(360145);
  }
  
  public final void bev() {}
  
  public final void bew() {}
  
  public final void emv()
  {
    AppMethodBeat.i(360102);
    Object localObject = ehM();
    if (localObject != null)
    {
      localObject = (be)((a)localObject).getPlugin(be.class);
      if (localObject != null) {
        ((be)localObject).emv();
      }
    }
    AppMethodBeat.o(360102);
  }
  
  public final void emw()
  {
    AppMethodBeat.i(360138);
    a locala = ehM();
    if (locala != null) {
      a.notifyPKMicUserChange$default(locala, false, 1, null);
    }
    AppMethodBeat.o(360138);
  }
  
  public final void emx()
  {
    AppMethodBeat.i(360154);
    Object localObject = ehM();
    if (localObject != null)
    {
      localObject = (aj)((a)localObject).getPlugin(aj.class);
      if (localObject != null) {
        ((aj)localObject).emx();
      }
    }
    AppMethodBeat.o(360154);
  }
  
  public final void emy()
  {
    AppMethodBeat.i(360163);
    Object localObject = ehM();
    if (localObject != null)
    {
      localObject = (aj)((a)localObject).getPlugin(aj.class);
      if (localObject != null) {
        ((aj)localObject).emy();
      }
    }
    AppMethodBeat.o(360163);
  }
  
  public final void notifyAudienceMicUserChange(boolean paramBoolean, r<Integer, Integer> paramr)
  {
    AppMethodBeat.i(360180);
    paramr = ehM();
    if (paramr != null) {
      paramr.notifyAudienceMicUserChange(paramBoolean);
    }
    AppMethodBeat.o(360180);
  }
  
  public final boolean notifyRoomPKMicUserChange(JSONObject paramJSONObject, boolean paramBoolean, r<Integer, Integer> paramr)
  {
    AppMethodBeat.i(360193);
    paramr = ehM();
    if (paramr == null)
    {
      AppMethodBeat.o(360193);
      return false;
    }
    paramBoolean = a.notifyRoomPKMicUserChange$default(paramr, paramJSONObject, false, null, 6, null);
    AppMethodBeat.o(360193);
    return paramBoolean;
  }
  
  public final void qJ(boolean paramBoolean)
  {
    AppMethodBeat.i(360130);
    Object localObject = ehM();
    if (localObject != null)
    {
      localObject = (aj)((a)localObject).getPlugin(aj.class);
      if (localObject != null) {
        ((aj)localObject).qJ(paramBoolean);
      }
    }
    AppMethodBeat.o(360130);
  }
  
  public final void qK(boolean paramBoolean) {}
  
  public final void setLastRoomPkMicUserList(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(360172);
    a locala = ehM();
    if (locala != null) {
      locala.setLastRoomPkMicUserList(paramJSONArray);
    }
    AppMethodBeat.o(360172);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(360116);
    s.u(paramc, "status");
    a locala = ehM();
    if (locala != null) {
      locala.statusChange(paramc, paramBundle);
    }
    AppMethodBeat.o(360116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.au
 * JD-Core Version:    0.7.0.1
 */