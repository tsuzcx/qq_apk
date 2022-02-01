package com.tencent.mm.plugin.lite.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.ad.h;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.Map;
import kotlin.ah;
import kotlin.g.a.r;
import org.json.JSONArray;

final class a$1
  implements r<Integer, Integer, String, aub, ah>
{
  a$1(a parama, Map paramMap, String paramString) {}
  
  private ah a(Integer paramInteger1, Integer paramInteger2, aub paramaub)
  {
    AppMethodBeat.i(271512);
    for (;;)
    {
      try
      {
        Log.d("LiteAppJsApiGetFinderLivePreviewMicCover", "resp count" + paramaub.ZEz.size());
        if ((paramInteger1.intValue() != 0) || (paramInteger2.intValue() != 0) || (paramaub == null) || (paramaub.ZEz.isEmpty())) {
          break label556;
        }
        paramInteger1 = new JSONArray();
        paramInteger2 = (bqy)paramaub.ZEz.get(0);
        if ((!Util.isNullOrNil(paramInteger2.ZYT.ZGl.ZTd)) || (paramInteger2.ZYT.ZGl.ZTe != null)) {
          continue;
        }
        this.Kav.put("ret", Integer.valueOf(0));
        this.Kav.put("err_msg", "live mic info is empty");
        this.Kav.put("requestId", this.Kaw);
        a.a(this.Kax).az(this.Kav);
      }
      catch (Exception paramInteger1)
      {
        label169:
        Log.printErrStackTrace("LiteAppJsApiGetFinderLivePreviewMicCover", paramInteger1, "getFinderLivePreviewMicCover fail", new Object[0]);
        a.c(this.Kax).aJV("Invalid input parameters");
        continue;
        i = 0;
      }
      AppMethodBeat.o(271512);
      return null;
      if (!Util.isNullOrNil(paramInteger2.ZYT.ZGl.ZTd)) {
        continue;
      }
      paramaub = h.aZn();
      paramaub.l("headurl", paramInteger2.ZYT.ZGl.ZTe.ZOh.contact.headUrl);
      paramaub.l("nickname", paramInteger2.ZYT.ZGl.ZTe.ZOh.contact.nickname);
      paramaub.l("mictype", Integer.valueOf(2));
      paramInteger1.put(paramaub);
      this.Kav.put("micInfos", paramInteger1);
      this.Kav.put("ret", Integer.valueOf(0));
      this.Kav.put("err_msg", "");
      this.Kav.put("requestId", this.Kaw);
    }
    for (;;)
    {
      int i;
      if (i < paramInteger2.ZYT.ZGl.ZTd.size())
      {
        paramaub = (bjl)paramInteger2.ZYT.ZGl.ZTd.get(i);
        if ((paramaub != null) && (paramaub.ZOh != null) && (paramaub.ZOh.contact != null))
        {
          c localc = h.aZn();
          localc.l("headurl", paramaub.ZOh.contact.headUrl);
          localc.l("nickname", paramaub.ZOh.contact.nickname);
          localc.l("mictype", Integer.valueOf(paramaub.ZOf));
          paramInteger1.put(localc);
        }
      }
      else
      {
        this.Kav.put("micInfos", paramInteger1);
        this.Kav.put("ret", Integer.valueOf(0));
        this.Kav.put("err_msg", "");
        this.Kav.put("requestId", this.Kaw);
        break;
        label556:
        a.b(this.Kax).aJV("Invalid input parameters Or live mic info is empty!");
        break label169;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.d.a.1
 * JD-Core Version:    0.7.0.1
 */