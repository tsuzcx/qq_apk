package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic;", "", "()V", "mReceiver", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "clear", "", "notifyReceiver", "entrances", "", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "registerEntranceInfoUpdateReceiverForId", "receiver", "requestEntranceInfo", "unregisterEntranceInfoUpdateReceiverForId", "Companion", "EntranceId", "EntranceInfoUpdateReceiver", "ShowCaseType", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
{
  public static final a qQo;
  public final Map<b, List<c>> qQp;
  
  static
  {
    AppMethodBeat.i(180446);
    qQo = new a((byte)0);
    AppMethodBeat.o(180446);
  }
  
  public ao()
  {
    AppMethodBeat.i(180445);
    this.qQp = ((Map)new LinkedHashMap());
    AppMethodBeat.o(180445);
  }
  
  private static final int a(ao paramao, int paramInt1, int paramInt2, String paramString, c arg4, p paramp)
  {
    AppMethodBeat.i(319379);
    s.u(paramao, "this$0");
    paramp = c.c.b(???.otC);
    Log.i("WxaDesktopEntranceShowLogic", "CGI[getwxadesktopentrance] errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (??? != null) && (paramp != null) && ((paramp instanceof cwx)))
    {
      paramString = ((cwx)paramp).aaCs;
      s.s(paramString, "resp.entrance_info");
      paramString = (List)paramString;
      for (;;)
      {
        synchronized (paramao.qQp)
        {
          paramp = ((Iterable)paramString).iterator();
          if (!paramp.hasNext()) {
            break;
          }
          aod localaod = (aod)paramp.next();
          paramString = b.qQq;
          paramInt2 = localaod.ZvG;
          b[] arrayOfb = b.values();
          int i = arrayOfb.length;
          paramInt1 = 0;
          if (paramInt1 >= i) {
            break label257;
          }
          paramString = arrayOfb[paramInt1];
          if (paramInt2 == paramString.ordinal())
          {
            if (paramString == null) {
              continue;
            }
            paramString = (List)paramao.qQp.get(paramString);
            if (paramString == null) {
              continue;
            }
            paramString = ((Iterable)paramString).iterator();
            if (!paramString.hasNext()) {
              continue;
            }
            ((c)paramString.next()).a(localaod);
          }
        }
        paramInt1 += 1;
        continue;
        label257:
        paramString = null;
      }
      paramao = ah.aiuX;
    }
    for (;;)
    {
      AppMethodBeat.o(319379);
      return 0;
      Log.e("WxaDesktopEntranceShowLogic", "refresh() cgi return errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
  }
  
  public final void cjn()
  {
    AppMethodBeat.i(319387);
    c.a locala = new c.a();
    locala.funcId = 3752;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxadesktopentrance";
    cww localcww = new cww();
    localcww.aaCq = 0.0D;
    localcww.aaCr = 0.0D;
    locala.otE = ((a)localcww);
    locala.otF = ((a)new cwx());
    z.a(locala.bEF(), new ao..ExternalSyntheticLambda0(this), true);
    AppMethodBeat.o(319387);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "", "(Ljava/lang/String;I)V", "ENTRANCE_ID_NONE", "ENTRANCE_ID_NEARBY", "ENTRANCE_ID_LIVE", "ENTRANCE_ID_FRIENDS_USING", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    public static final a qQq;
    
    static
    {
      AppMethodBeat.i(180436);
      qQr = new b("ENTRANCE_ID_NONE", 0);
      qQs = new b("ENTRANCE_ID_NEARBY", 1);
      qQt = new b("ENTRANCE_ID_LIVE", 2);
      qQu = new b("ENTRANCE_ID_FRIENDS_USING", 3);
      qQv = new b[] { qQr, qQs, qQt, qQu };
      qQq = new a((byte)0);
      AppMethodBeat.o(180436);
    }
    
    private b() {}
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId$Companion;", "", "()V", "getByOrdinal", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "id", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "onEntranceInfoUpdate", "", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void a(aod paramaod);
    
    public abstract ao.b cjo();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType$Companion;", "", "()V", "getByOrdinal", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType;", "id", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d$a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ao
 * JD-Core Version:    0.7.0.1
 */