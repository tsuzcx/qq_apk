package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.d.d;
import kotlin.r;

@Metadata(d1={""}, d2={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
final class w$i
  implements IPCRunCgi.a
{
  w$i(d<? super r<Integer, String>> paramd) {}
  
  public final void callback(int paramInt1, int paramInt2, String paramString, c paramc)
  {
    AppMethodBeat.i(235800);
    Log.i("MicroMsg.OpenIMKefuConfirmController", "checkAppBrandBindState errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramc == null) {
        paramString = null;
      }
    }
    while ((paramString instanceof zr))
    {
      paramString = c.c.b(paramc.otC);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CheckAppCustomerServiceBindResponse");
        AppMethodBeat.o(235800);
        throw paramString;
        paramString = c.c.b(paramc.otC);
      }
      else
      {
        paramString = (zr)paramString;
        Log.i("MicroMsg.OpenIMKefuConfirmController", "checkAppBrandBindState bindState: %s", new Object[] { Integer.valueOf(paramString.Zin) });
        if (paramString.Zin == 1)
        {
          paramString = this.ntL;
          paramc = new r(Integer.valueOf(0), "");
          localCompanion = Result.Companion;
          paramString.resumeWith(Result.constructor-impl(paramc));
          AppMethodBeat.o(235800);
          return;
        }
        paramString = this.ntL;
        paramc = new r(Integer.valueOf(6), "not bind");
        Result.Companion localCompanion = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(paramc));
        AppMethodBeat.o(235800);
        return;
        paramString = this.ntL;
        paramc = new r(Integer.valueOf(6), "check failed");
        localCompanion = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(paramc));
      }
    }
    AppMethodBeat.o(235800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.model.w.i
 * JD-Core Version:    0.7.0.1
 */