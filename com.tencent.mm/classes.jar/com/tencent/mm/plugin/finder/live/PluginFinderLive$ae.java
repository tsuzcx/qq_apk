package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.t;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/PluginFinderLive$enterFinderLiveTiger$2", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveGetLastObjectCallback;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFinderLive$ae
  implements t
{
  PluginFinderLive$ae(String paramString, Intent paramIntent, Context paramContext) {}
  
  public final void a(int paramInt1, int paramInt2, azf paramazf)
  {
    Object localObject1 = null;
    AppMethodBeat.i(370909);
    s.u(paramazf, "resp");
    FinderObject localFinderObject = paramazf.ZIo;
    StringBuilder localStringBuilder = new StringBuilder("enterFinderLiveTiger finderObject:[objectId:");
    if (localFinderObject == null)
    {
      paramazf = null;
      localStringBuilder = localStringBuilder.append(paramazf).append(" liveId:");
      if (localFinderObject != null) {
        break label174;
      }
      paramazf = null;
      label58:
      localStringBuilder = localStringBuilder.append(paramazf).append(" anchorUsername:");
      if (localFinderObject != null) {
        break label200;
      }
      paramazf = null;
      label78:
      localStringBuilder = localStringBuilder.append(paramazf).append(" liveStatus:");
      if (localFinderObject != null) {
        break label223;
      }
      paramazf = null;
      label98:
      localStringBuilder = localStringBuilder.append(paramazf).append(" layerInfoType:");
      if (localFinderObject != null) {
        break label249;
      }
      paramazf = localObject1;
    }
    for (;;)
    {
      Log.i("Plugin.FinderLive", paramazf + ']');
      PluginFinderLive.access$enterFinderLiveTiger$jump(this.Bys, this.odM, this.$context, localFinderObject, true);
      AppMethodBeat.o(370909);
      return;
      paramazf = Long.valueOf(localFinderObject.id);
      break;
      label174:
      paramazf = localFinderObject.liveInfo;
      if (paramazf == null)
      {
        paramazf = null;
        break label58;
      }
      paramazf = Long.valueOf(paramazf.liveId);
      break label58;
      label200:
      paramazf = localFinderObject.contact;
      if (paramazf == null)
      {
        paramazf = null;
        break label78;
      }
      paramazf = paramazf.username;
      break label78;
      label223:
      paramazf = localFinderObject.liveInfo;
      if (paramazf == null)
      {
        paramazf = null;
        break label98;
      }
      paramazf = Integer.valueOf(paramazf.liveStatus);
      break label98;
      label249:
      Object localObject2 = localFinderObject.liveInfo;
      paramazf = localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((bip)localObject2).ZRZ;
        paramazf = localObject1;
        if (localObject2 != null) {
          paramazf = Integer.valueOf(((bix)localObject2).show_type);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.PluginFinderLive.ae
 * JD-Core Version:    0.7.0.1
 */