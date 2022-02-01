package com.tencent.mm.plugin.finder.nearby.report;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyPersonReporter;", "", "()V", "TAG", "", "sessionId", "finderTypeToFilterType", "", "lbsFinderType", "", "onConfirmClearAndExitClick", "", "onFilterActionSelect", "filterType", "onMenuButtonClick", "onUserClick", "contactInfo", "Lcom/tencent/mm/protocal/protobuf/LbsContactInfo;", "ifSns", "", "ifFinder", "position", "onUserExpose", "report", "action", "userName", "country", "city", "district", "ifSignature", "ifNicknameHasEmoji", "userPos", "userGender", "stayTime", "reportSayHiClick", "sex", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d EQT;
  private static String sessionId;
  
  static
  {
    AppMethodBeat.i(339768);
    EQT = new d();
    sessionId = "";
    AppMethodBeat.o(339768);
  }
  
  public static long Re(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 0L;
    case 1: 
      return 3L;
    case 3: 
      return 2L;
    }
    return 1L;
  }
  
  public static void Rf(int paramInt)
  {
    AppMethodBeat.i(339722);
    long l;
    switch (paramInt)
    {
    default: 
      l = 3L;
    }
    for (;;)
    {
      a(null, null, null, null, 0L, 3L, l, 0L, 0L, 0L, 0L, 0L, 0L, 8095);
      AppMethodBeat.o(339722);
      return;
      l = 1L;
      continue;
      l = 2L;
      continue;
      l = 3L;
      continue;
      l = 4L;
      continue;
      l = 5L;
      continue;
      l = 6L;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9)
  {
    AppMethodBeat.i(339749);
    s.u(paramString1, "userName");
    s.u(paramString2, "country");
    s.u(paramString3, "city");
    s.u(paramString4, "district");
    af localaf = new af();
    if (TextUtils.isEmpty((CharSequence)sessionId))
    {
      String str = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      sessionId = (String)localObject;
    }
    localaf.inx = localaf.F("sessionid", sessionId, true);
    localaf.iny = localaf.F("contextid", g.ERj.eeL(), true);
    Object localObject = g.ERj;
    localaf.inz = localaf.F("clickTabContextid", g.eGL(), true);
    localaf.inA = 0L;
    localaf.inG = localaf.F("nearby_username", paramString1, true);
    localaf.inI = localaf.F("country", paramString2, true);
    localaf.inH = localaf.F("city", paramString3, true);
    paramString3 = "";
    paramString1 = paramString3;
    paramString2 = paramString3;
    for (;;)
    {
      try
      {
        if (n.a((CharSequence)paramString4, (CharSequence)" - ", false))
        {
          paramString2 = paramString3;
          paramString1 = paramString4.subSequence(n.a((CharSequence)paramString4, " - ", 0, false, 6) + 3, paramString4.length()).toString();
        }
        paramString2 = paramString1;
        if (!n.a((CharSequence)paramString4, (CharSequence)"公里", false)) {
          continue;
        }
        paramString2 = paramString1;
        l = Long.parseLong(paramString4.subSequence(0, n.a((CharSequence)paramString4, "公里", 0, false, 6)).toString());
        l *= 1000L;
      }
      finally
      {
        Log.e("NearbyPersonReporter", paramString1.toString());
        paramString3 = paramString2;
        long l = 0L;
        paramString1 = paramString3;
        continue;
      }
      localaf.inB = l;
      localaf.inC = localaf.F("district", paramString1, true);
      localaf.inD = paramLong1;
      localaf.ila = paramLong2;
      localaf.inE = cn.bDw();
      localaf.inF = paramLong3;
      localaf.inJ = paramLong4;
      localaf.inK = paramLong5;
      localaf.inL = paramLong6;
      localaf.inM = paramLong7;
      localaf.inN = paramLong8;
      localaf.inw = paramLong9;
      localaf.bMH();
      Log.d("NearbyPersonReporter", s.X("report ", localaf.aIF()));
      AppMethodBeat.o(339749);
      return;
      paramString2 = paramString1;
      paramString3 = paramString1;
      if (!n.a((CharSequence)paramString4, (CharSequence)"米", false)) {
        continue;
      }
      paramString2 = paramString1;
      l = Long.parseLong(paramString4.subSequence(0, n.a((CharSequence)paramString4, "米", 0, false, 6)).toString());
    }
  }
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(339732);
    a("", null, null, null, 0L, paramLong, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 8158);
    AppMethodBeat.o(339732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.d
 * JD-Core Version:    0.7.0.1
 */