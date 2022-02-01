package com.tencent.mm.plugin.finder.live.model;

import com.tencent.d.a.a.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doFinishLive$1", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "onLiveStatusCallback", "", "respLiveId", "", "liveStatus", "", "resp", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$g
  implements b.d
{
  f$g(f paramf, s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.plugin.finder.live.viewmodel.data.a, ah> params) {}
  
  public final void onLiveStatusCallback(long paramLong, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(359601);
    Log.i(this.CEm.TAG, "getLiveInfo,liveData.business(LiveCommonSlice::class.java).liveId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CEm.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId + ",respLiveId:" + paramLong + ",liveStatus:" + paramInt + ",resp:" + paramObject);
    if ((paramLong == ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CEm.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId) && ((paramObject instanceof azl)))
    {
      Object localObject = ((azl)paramObject).liveInfo;
      int i;
      label142:
      int j;
      label160:
      label177:
      int n;
      long l1;
      label213:
      int k;
      label231:
      int m;
      label249:
      Boolean localBoolean;
      if (localObject == null)
      {
        paramInt = 0;
        localObject = ((azl)paramObject).liveInfo;
        if (localObject != null) {
          break label346;
        }
        i = 0;
        localObject = ((azl)paramObject).liveInfo;
        if (localObject != null) {
          break label356;
        }
        j = 0;
        localObject = ((azl)paramObject).liveInfo;
        if (localObject != null) {
          break label366;
        }
        paramLong = 0L;
        n = ((azl)paramObject).ZFm;
        localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        localObject = com.tencent.mm.plugin.finder.live.utils.a.a(((azl)paramObject).liveInfo);
        if (localObject != null) {
          break label375;
        }
        l1 = 0L;
        localObject = ((azl)paramObject).liveInfo;
        if (localObject != null) {
          break label385;
        }
        k = 0;
        localObject = ((azl)paramObject).liveInfo;
        if (localObject != null) {
          break label395;
        }
        m = 0;
        localObject = this.CEo;
        if (localObject == null) {
          break label466;
        }
        localBoolean = Boolean.TRUE;
        paramObject = ((azl)paramObject).liveInfo;
        if (paramObject != null) {
          break label405;
        }
      }
      label385:
      label395:
      label405:
      for (long l2 = 0L;; l2 = paramObject.ZKy)
      {
        ((s)localObject).a(localBoolean, Integer.valueOf(0), Integer.valueOf(0), "", new com.tencent.mm.plugin.finder.live.viewmodel.data.a(paramInt - i, j, paramLong, n, l1, m, k, l2, 256, (byte)0));
        AppMethodBeat.o(359601);
        return;
        paramInt = ((bip)localObject).endTime;
        break;
        label346:
        i = ((bip)localObject).startTime;
        break label142;
        label356:
        j = ((bip)localObject).DSe;
        break label160;
        label366:
        paramLong = ((bip)localObject).ZRW;
        break label177;
        label375:
        l1 = ((Long)localObject).longValue();
        break label213;
        k = ((bip)localObject).ZSg;
        break label231;
        m = ((bip)localObject).ZSf;
        break label249;
      }
    }
    else
    {
      paramObject = this.CEo;
      if (paramObject != null) {
        paramObject.a(Boolean.FALSE, Integer.valueOf(0), Integer.valueOf(0), "", new com.tencent.mm.plugin.finder.live.viewmodel.data.a(0, 0, 0L, 0, 0L, 0, 0, 0L, 511, (byte)0));
      }
    }
    label466:
    AppMethodBeat.o(359601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.f.g
 * JD-Core Version:    0.7.0.1
 */