package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.plugin.ax.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.r;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$onConfigClient$2", "Lcom/tencent/mm/plugin/webjsapi/WxAdAPIContext;", "deleteAd", "", "msgId", "", "forceDelete", "", "getAdContext", "from", "", "getInfo", "key", "replaceAdData", "data", "setAdExposeParams", "exposureRatio", "exposureTme", "setAdInsertType", "type", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$g
  implements e
{
  public final void deleteAd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(303116);
    s.u(paramString, "msgId");
    long l = Util.safeParseLong(paramString);
    Log.i("MicroMsg.AdWebPrefetcherJsEngineInterceptor", "deleteAd msgId=" + l + ", forceDelete=" + paramBoolean);
    if (l == 0L)
    {
      AppMethodBeat.o(303116);
      return;
    }
    if (BuildInfo.DEBUG)
    {
      paramString = r.acDM;
      if (r.iXn())
      {
        AppMethodBeat.o(303116);
        return;
      }
    }
    if (paramBoolean)
    {
      af.bHl().yQ(l);
      AppMethodBeat.o(303116);
      return;
    }
    paramString = af.bHl().aq(l, "msgId");
    if ((paramString != null) && (paramString.field_isRead != 1)) {
      af.bHl().yQ(l);
    }
    AppMethodBeat.o(303116);
  }
  
  public final String getAdContext(int paramInt)
  {
    AppMethodBeat.i(303108);
    Object localObject = r.acDM;
    localObject = r.ayw(paramInt);
    AppMethodBeat.o(303108);
    return localObject;
  }
  
  public final void replaceAdData(String paramString)
  {
    AppMethodBeat.i(303103);
    s.u(paramString, "data");
    r localr = r.acDM;
    r.replaceAdData(paramString);
    AppMethodBeat.o(303103);
  }
  
  public final void setAdExposeParams(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(303131);
    r localr = r.acDM;
    Log.d("MicroMsg.BizCardLogic", "setAdExposeParams exposureRatio=" + paramInt1 + "， exposureTme=" + paramInt2);
    r.acEn = k.bu(k.bt(paramInt1 / 100.0F, 0.0F), 0.5F);
    r.acEo = k.bS(k.bR(paramInt2, 1L), 1000L);
    r.acEp = true;
    r.iXi().encode("minAdExposureRatio", r.acEn);
    r.iXi().encode("minAdExposureTme", r.acEo);
    AppMethodBeat.o(303131);
  }
  
  public final void setAdInsertType(int paramInt)
  {
    AppMethodBeat.i(303121);
    r localr = r.acDM;
    r.setAdInsertType(paramInt);
    AppMethodBeat.o(303121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.g
 * JD-Core Version:    0.7.0.1
 */