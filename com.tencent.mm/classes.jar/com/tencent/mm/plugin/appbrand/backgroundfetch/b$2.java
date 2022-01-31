package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.dae;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class b$2
  implements b.a
{
  b$2(m paramm, dae paramdae, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(129760);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.fsW.fta != null) && ((paramb.fsW.fta instanceof daf)))
    {
      paramString = (daf)paramb.fsW.fta;
      if ((paramString.ygM != null) && (!paramString.ygM.isEmpty()))
      {
        ab.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data success");
        this.hdV.e(paramString.ygM, this.hdW.ygL);
        AppMethodBeat.o(129760);
        return;
      }
      ab.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:data is null");
      this.hdV.onFail(this.bHS);
      AppMethodBeat.o(129760);
      return;
    }
    ab.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:request fail");
    this.hdV.onFail(this.bHS);
    AppMethodBeat.o(129760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.b.2
 * JD-Core Version:    0.7.0.1
 */