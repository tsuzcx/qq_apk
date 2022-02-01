package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.b.h;
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/FinderLiveRedPacketCache;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "coverCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteRedPacketStatus;", "getCoverCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "getStatus", "coverUrl", "saveStatus", "", "status", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n DJd;
  private static final String TAG;
  private static final h<String, bld> akfE;
  
  static
  {
    AppMethodBeat.i(351320);
    DJd = new n();
    TAG = "FinderLiveRedPacketCache";
    akfE = new h(1000);
    AppMethodBeat.o(351320);
  }
  
  public static void a(String paramString, bld parambld)
  {
    AppMethodBeat.i(351301);
    s.u(paramString, "coverUrl");
    s.u(parambld, "status");
    Log.i(TAG, "[saveStatus] status:" + f.dg(parambld) + ", url:" + paramString);
    akfE.put(paramString, parambld);
    AppMethodBeat.o(351301);
  }
  
  public static bld axM(String paramString)
  {
    AppMethodBeat.i(351310);
    s.u(paramString, "coverUrl");
    bld localbld = (bld)akfE.get(paramString);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("[getStatus] status:");
    if (localbld == null) {}
    for (JSONObject localJSONObject = null;; localJSONObject = f.dg(localbld))
    {
      Object localObject = localJSONObject;
      if (localJSONObject == null) {
        localObject = "null";
      }
      Log.i(str, localObject + ", url:" + paramString);
      AppMethodBeat.o(351310);
      return localbld;
      s.s(localbld, "status");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.n
 * JD-Core Version:    0.7.0.1
 */