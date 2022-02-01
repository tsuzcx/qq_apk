package com.tencent.mm.plugin.hardwareopt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.protocal.protobuf.ady;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.protocal.protobuf.cax;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.dog;
import com.tencent.mm.protocal.protobuf.doq;
import com.tencent.mm.protocal.protobuf.eur;
import com.tencent.mm.protocal.protobuf.fhy;
import com.tencent.mm.protocal.protobuf.jx;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements a<Boolean, czg>
{
  private boolean JmI = false;
  
  public b(boolean paramBoolean)
  {
    this.JmI = paramBoolean;
  }
  
  private Boolean a(czg paramczg)
  {
    AppMethodBeat.i(55561);
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      Log.e("MicroMsg.TaskReportHardwareInfo", "Account not init, just return");
      paramczg = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return paramczg;
    }
    long l1 = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTF, Long.valueOf(-1L))).longValue();
    long l2 = System.currentTimeMillis();
    Log.i("MicroMsg.TaskReportHardwareInfo", "hy: last ticks: %d, current ticks: %d, interval: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
    if ((!this.JmI) && (l2 - l1 < 86400000L))
    {
      Log.d("MicroMsg.TaskReportHardwareInfo", "hy: should not upload. too small interval");
      paramczg = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return paramczg;
    }
    if ((!this.JmI) && ((paramczg == null) || (paramczg.aaEg == null)))
    {
      Log.w("MicroMsg.TaskReportHardwareInfo", "hy: error when finding hardware");
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(661L, 1L, 1L, false);
      paramczg = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return paramczg;
    }
    Log.i("MicroMsg.TaskReportHardwareInfo", "hy: found hardware infos. start report");
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    String str1 = paramczg.aaEg.imei;
    String str2 = paramczg.aaEg.YMj;
    String str3 = paramczg.aaEg.modelName;
    String str4 = paramczg.aaEg.YMk;
    String str5 = paramczg.aaEh.ZaV;
    String str6 = paramczg.aaEh.ZaT;
    String str7 = paramczg.aaEh.modelName;
    String str8 = paramczg.aaEh.ZaW;
    int i18 = paramczg.aaEh.ZaU;
    int i19 = paramczg.aaEi.aaVj;
    int i20 = paramczg.aaEi.aaVk;
    int i21 = paramczg.aaEj.abIM;
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
    if (paramczg.aaEj.abIN)
    {
      i = 1;
      if (!paramczg.aaEn.aajY) {
        break label1039;
      }
      j = 1;
      if (!paramczg.aaEn.aajZ) {
        break label1044;
      }
      k = 1;
      str9 = paramczg.aaEk.resolution;
      i22 = paramczg.aaEk.oKu;
      str10 = paramczg.aaEl.Zme;
      if (!paramczg.aaEm.ZCv) {
        break label1050;
      }
      m = 1;
      if (!paramczg.aaEm.ZCw) {
        break label1056;
      }
      n = 1;
      if (!paramczg.aaEm.ZCx) {
        break label1062;
      }
      i1 = 1;
      if (!paramczg.aaEm.ZCy) {
        break label1068;
      }
      i2 = 1;
      if (!paramczg.aaEm.ZCz) {
        break label1074;
      }
      i3 = 1;
      if (!paramczg.aaEm.ZCA) {
        break label1080;
      }
      i4 = 1;
      if (!paramczg.aaEm.ZCB) {
        break label1086;
      }
      i5 = 1;
      if (!paramczg.aaEm.ZCM) {
        break label1092;
      }
      i6 = 1;
      if (!paramczg.aaEm.ZCC) {
        break label1098;
      }
      i7 = 1;
      if (!paramczg.aaEm.ZCD) {
        break label1104;
      }
      i8 = 1;
      if (!paramczg.aaEm.ZCE) {
        break label1110;
      }
      i9 = 1;
      if (!paramczg.aaEm.ZCF) {
        break label1116;
      }
      i10 = 1;
      if (!paramczg.aaEm.ZCG) {
        break label1122;
      }
      i11 = 1;
      if (!paramczg.aaEm.ZCH) {
        break label1128;
      }
      i12 = 1;
      if (!paramczg.aaEm.ZCI) {
        break label1134;
      }
      i13 = 1;
      if (!paramczg.aaEm.ZCJ) {
        break label1140;
      }
      i14 = 1;
      if (!paramczg.aaEm.ZCK) {
        break label1146;
      }
      i15 = 1;
      if (!paramczg.aaEm.ZCL) {
        break label1152;
      }
      i16 = 1;
      i23 = paramczg.aaEi.MNT;
      i24 = paramczg.aaEi.aaVl;
      str11 = paramczg.aaEl.Zmf;
      str12 = bA(paramczg.aaEl.Zmg);
      if (!paramczg.aaEn.aaka) {
        break label1158;
      }
    }
    label1152:
    label1158:
    for (int i17 = 1;; i17 = 0)
    {
      localh.b(14552, new Object[] { str1, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i20), Integer.valueOf(i21), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str9, Integer.valueOf(i22), str10, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), Integer.valueOf(i23), Integer.valueOf(i24), str11, str12, Integer.valueOf(i17) });
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTF, Long.valueOf(l2));
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(661L, 0L, 1L, false);
      paramczg = Boolean.TRUE;
      AppMethodBeat.o(55561);
      return paramczg;
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
  
  private static String bA(LinkedList<doq> paramLinkedList)
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
          Object localObject = (doq)paramLinkedList.next();
          if ((localObject == null) || (Util.isNullOrNil(((doq)localObject).cBw))) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("mimeName", ((doq)localObject).cBw);
          JSONArray localJSONArray2 = new JSONArray();
          if (((doq)localObject).aaVD != null)
          {
            localObject = ((doq)localObject).aaVD.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.c.b
 * JD-Core Version:    0.7.0.1
 */