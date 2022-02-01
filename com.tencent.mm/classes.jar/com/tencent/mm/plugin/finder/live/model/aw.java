package com.tencent.mm.plugin.finder.live.model;

import android.os.Bundle;
import com.tencent.mm.live.b.b.c;
import kotlin.Metadata;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/SeiProcessViewCallback;", "", "checkPkAnchorAudioTip", "", "checkPkAnchorAudioVolume", "notifyAnchorVolumeChange", "isTalking", "", "notifyAudienceMicUserChange", "checkDiff", "screenSize", "Lkotlin/Pair;", "", "notifyPKMicUserChange", "notifyRoomPKMicUserChange", "micData", "Lorg/json/JSONObject;", "forceUpdate", "onMediaModeChange", "audio", "screenShare", "onNotifyMicUserVolume", "setLastRoomPkMicUserList", "obj", "Lorg/json/JSONArray;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchAudioMode", "switchScreenShareMode", "docCast", "switchVideoMode", "updateVideoWidgetCover", "userId", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface aw
{
  public abstract void Y(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void awC(String paramString);
  
  public abstract void bev();
  
  public abstract void bew();
  
  public abstract void emv();
  
  public abstract void emw();
  
  public abstract void emx();
  
  public abstract void emy();
  
  public abstract void notifyAudienceMicUserChange(boolean paramBoolean, r<Integer, Integer> paramr);
  
  public abstract boolean notifyRoomPKMicUserChange(JSONObject paramJSONObject, boolean paramBoolean, r<Integer, Integer> paramr);
  
  public abstract void qJ(boolean paramBoolean);
  
  public abstract void qK(boolean paramBoolean);
  
  public abstract void setLastRoomPkMicUserList(JSONArray paramJSONArray);
  
  public abstract void statusChange(b.c paramc, Bundle paramBundle);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.aw
 * JD-Core Version:    0.7.0.1
 */