package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.f.a.bu.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.k.a.a.m;
import com.tencent.mm.protocal.protobuf.dyw;
import com.tencent.mm.protocal.protobuf.zm;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class t
  extends IListener<bu>
  implements i
{
  public static final String EAi;
  
  static
  {
    AppMethodBeat.i(65222);
    EAi = com.tencent.mm.loader.j.b.aSD() + "luckymoney/";
    AppMethodBeat.o(65222);
  }
  
  public t()
  {
    AppMethodBeat.i(160802);
    this.__eventId = bu.class.getName().hashCode();
    AppMethodBeat.o(160802);
  }
  
  public static String VT(int paramInt)
  {
    AppMethodBeat.i(65218);
    String str = EAi + paramInt + "/";
    AppMethodBeat.o(65218);
    return str;
  }
  
  public static String VU(int paramInt)
  {
    AppMethodBeat.i(210363);
    String str = VT(paramInt) + "story/";
    AppMethodBeat.o(210363);
    return str;
  }
  
  public static void eOF()
  {
    AppMethodBeat.i(65217);
    com.tencent.mm.pluginsdk.k.a.a.b.hii();
    com.tencent.mm.pluginsdk.k.a.a.b.apP(58);
    AppMethodBeat.o(65217);
  }
  
  public static String hY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210364);
    String str = VU(paramInt1) + "detail_video_" + paramInt2 + ".mp4";
    AppMethodBeat.o(210364);
    return str;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(210366);
    Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "resourceType.errType:%s，errCode：%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (((paramq instanceof m)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (zm)d.c.b(((d)paramq.getReqResp()).lBS);
      if (!Util.isNullOrNil(paramString.SlL))
      {
        paramq = paramString.SlL.iterator();
        if (paramq.hasNext())
        {
          dyw localdyw = (dyw)paramq.next();
          paramInt1 = localdyw.rWu;
          if (Util.isNullOrNil(localdyw.UeG)) {}
          for (paramString = "null";; paramString = String.valueOf(localdyw.UeG.size()))
          {
            Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "resType：%d，responses.size()：%s", new Object[] { Integer.valueOf(paramInt1), paramString });
            if ((localdyw.rWu != 58) || (Util.isNullOrNil(localdyw.UeG))) {
              break;
            }
            h.IzE.el(991, 16);
            break;
          }
        }
      }
    }
    AppMethodBeat.o(210366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.t
 * JD-Core Version:    0.7.0.1
 */