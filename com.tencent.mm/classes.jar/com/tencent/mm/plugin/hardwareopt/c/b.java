package com.tencent.mm.plugin.hardwareopt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.abp;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.cbc;
import com.tencent.mm.protocal.protobuf.cop;
import com.tencent.mm.protocal.protobuf.cow;
import com.tencent.mm.protocal.protobuf.drg;
import com.tencent.mm.protocal.protobuf.ecz;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.vending.c.a<Boolean, cbc>
{
  private boolean yjq = false;
  
  public b(boolean paramBoolean)
  {
    this.yjq = paramBoolean;
  }
  
  private Boolean a(cbc paramcbc)
  {
    AppMethodBeat.i(55561);
    if (!g.aAf().azp())
    {
      Log.e("MicroMsg.TaskReportHardwareInfo", "Account not init, just return");
      paramcbc = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return paramcbc;
    }
    long l1 = ((Long)g.aAh().azQ().get(ar.a.OdQ, Long.valueOf(-1L))).longValue();
    long l2 = System.currentTimeMillis();
    Log.i("MicroMsg.TaskReportHardwareInfo", "hy: last ticks: %d, current ticks: %d, interval: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
    if ((!this.yjq) && (l2 - l1 < 86400000L))
    {
      Log.d("MicroMsg.TaskReportHardwareInfo", "hy: should not upload. too small interval");
      paramcbc = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return paramcbc;
    }
    if ((!this.yjq) && ((paramcbc == null) || (paramcbc.Mgs == null)))
    {
      Log.w("MicroMsg.TaskReportHardwareInfo", "hy: error when finding hardware");
      h.CyF.idkeyStat(661L, 1L, 1L, false);
      paramcbc = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return paramcbc;
    }
    Log.i("MicroMsg.TaskReportHardwareInfo", "hy: found hardware infos. start report");
    h localh = h.CyF;
    String str1 = paramcbc.Mgs.imei;
    String str2 = paramcbc.Mgs.KOb;
    String str3 = paramcbc.Mgs.kxx;
    String str4 = paramcbc.Mgs.KOc;
    String str5 = paramcbc.Mgt.abi;
    String str6 = paramcbc.Mgt.LbP;
    String str7 = paramcbc.Mgt.kxx;
    String str8 = paramcbc.Mgt.LbR;
    int i18 = paramcbc.Mgt.LbQ;
    int i19 = paramcbc.Mgu.MuL;
    int i20 = paramcbc.Mgu.MuM;
    int i21 = paramcbc.Mgv.Ndq;
    int i;
    int j;
    label330:
    int k;
    label343:
    String str9;
    int i22;
    String str10;
    int m;
    label383:
    int n;
    label396:
    int i1;
    label409:
    int i2;
    label422:
    int i3;
    label435:
    int i4;
    label448:
    int i5;
    label461:
    int i6;
    label474:
    int i7;
    label487:
    int i8;
    label500:
    int i9;
    label513:
    int i10;
    label526:
    int i11;
    label539:
    int i12;
    label552:
    int i13;
    label565:
    int i14;
    label578:
    int i15;
    label591:
    int i16;
    label604:
    int i23;
    int i24;
    String str11;
    String str12;
    if (paramcbc.Mgv.Ndr)
    {
      i = 1;
      if (!paramcbc.Mgz.LPO) {
        break label1039;
      }
      j = 1;
      if (!paramcbc.Mgz.LPP) {
        break label1044;
      }
      k = 1;
      str9 = paramcbc.Mgw.resolution;
      i22 = paramcbc.Mgw.density;
      str10 = paramcbc.Mgx.Lmu;
      if (!paramcbc.Mgy.Lzc) {
        break label1050;
      }
      m = 1;
      if (!paramcbc.Mgy.Lzd) {
        break label1056;
      }
      n = 1;
      if (!paramcbc.Mgy.Lze) {
        break label1062;
      }
      i1 = 1;
      if (!paramcbc.Mgy.Lzf) {
        break label1068;
      }
      i2 = 1;
      if (!paramcbc.Mgy.Lzg) {
        break label1074;
      }
      i3 = 1;
      if (!paramcbc.Mgy.Lzh) {
        break label1080;
      }
      i4 = 1;
      if (!paramcbc.Mgy.Lzi) {
        break label1086;
      }
      i5 = 1;
      if (!paramcbc.Mgy.Lzt) {
        break label1092;
      }
      i6 = 1;
      if (!paramcbc.Mgy.Lzj) {
        break label1098;
      }
      i7 = 1;
      if (!paramcbc.Mgy.Lzk) {
        break label1104;
      }
      i8 = 1;
      if (!paramcbc.Mgy.Lzl) {
        break label1110;
      }
      i9 = 1;
      if (!paramcbc.Mgy.Lzm) {
        break label1116;
      }
      i10 = 1;
      if (!paramcbc.Mgy.Lzn) {
        break label1122;
      }
      i11 = 1;
      if (!paramcbc.Mgy.Lzo) {
        break label1128;
      }
      i12 = 1;
      if (!paramcbc.Mgy.Lzp) {
        break label1134;
      }
      i13 = 1;
      if (!paramcbc.Mgy.Lzq) {
        break label1140;
      }
      i14 = 1;
      if (!paramcbc.Mgy.Lzr) {
        break label1146;
      }
      i15 = 1;
      if (!paramcbc.Mgy.Lzs) {
        break label1152;
      }
      i16 = 1;
      i23 = paramcbc.Mgu.AXb;
      i24 = paramcbc.Mgu.MuN;
      str11 = paramcbc.Mgx.Lmv;
      str12 = ba(paramcbc.Mgx.Lmw);
      if (!paramcbc.Mgz.LPQ) {
        break label1158;
      }
    }
    label1152:
    label1158:
    for (int i17 = 1;; i17 = 0)
    {
      localh.a(14552, new Object[] { str1, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i20), Integer.valueOf(i21), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str9, Integer.valueOf(i22), str10, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), Integer.valueOf(i23), Integer.valueOf(i24), str11, str12, Integer.valueOf(i17) });
      g.aAh().azQ().set(ar.a.OdQ, Long.valueOf(l2));
      h.CyF.idkeyStat(661L, 0L, 1L, false);
      paramcbc = Boolean.TRUE;
      AppMethodBeat.o(55561);
      return paramcbc;
      i = 0;
      break;
      label1039:
      j = 0;
      break label330;
      label1044:
      k = 0;
      break label343;
      label1050:
      m = 0;
      break label383;
      label1056:
      n = 0;
      break label396;
      label1062:
      i1 = 0;
      break label409;
      label1068:
      i2 = 0;
      break label422;
      label1074:
      i3 = 0;
      break label435;
      label1080:
      i4 = 0;
      break label448;
      label1086:
      i5 = 0;
      break label461;
      label1092:
      i6 = 0;
      break label474;
      label1098:
      i7 = 0;
      break label487;
      label1104:
      i8 = 0;
      break label500;
      label1110:
      i9 = 0;
      break label513;
      label1116:
      i10 = 0;
      break label526;
      label1122:
      i11 = 0;
      break label539;
      label1128:
      i12 = 0;
      break label552;
      label1134:
      i13 = 0;
      break label565;
      label1140:
      i14 = 0;
      break label578;
      label1146:
      i15 = 0;
      break label591;
      i16 = 0;
      break label604;
    }
  }
  
  private static String ba(LinkedList<cow> paramLinkedList)
  {
    AppMethodBeat.i(55562);
    JSONArray localJSONArray1 = new JSONArray();
    if (paramLinkedList != null)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        try
        {
          paramLinkedList = paramLinkedList.iterator();
          if (!paramLinkedList.hasNext()) {
            break;
          }
          Object localObject = (cow)paramLinkedList.next();
          if ((localObject == null) || (Util.isNullOrNil(((cow)localObject).mime))) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("mimeName", ((cow)localObject).mime);
          JSONArray localJSONArray2 = new JSONArray();
          if (((cow)localObject).Mva != null)
          {
            localObject = ((cow)localObject).Mva.iterator();
            if (((Iterator)localObject).hasNext())
            {
              localJSONArray2.put((String)((Iterator)localObject).next());
              continue;
            }
          }
          localJSONObject.put("codecName", localJSONArray2);
        }
        catch (Exception paramLinkedList)
        {
          Log.printErrStackTrace("MicroMsg.TaskReportHardwareInfo", paramLinkedList, "hy: error when build up json", new Object[0]);
          AppMethodBeat.o(55562);
          return "";
        }
        localJSONArray1.put(localJSONObject);
      }
      paramLinkedList = localJSONArray1.toString();
      AppMethodBeat.o(55562);
      return paramLinkedList;
    }
    Log.w("MicroMsg.TaskReportHardwareInfo", "hy: no mime info retrieved!");
    AppMethodBeat.o(55562);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.c.b
 * JD-Core Version:    0.7.0.1
 */