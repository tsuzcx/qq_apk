package com.tencent.mm.plugin.hardwareopt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.protocal.protobuf.bnd;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.cxb;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.protocal.protobuf.ena;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements a<Boolean, cjd>
{
  private boolean Dts = false;
  
  public b(boolean paramBoolean)
  {
    this.Dts = paramBoolean;
  }
  
  private Boolean a(cjd paramcjd)
  {
    AppMethodBeat.i(55561);
    if (!com.tencent.mm.kernel.h.aHE().aGM())
    {
      Log.e("MicroMsg.TaskReportHardwareInfo", "Account not init, just return");
      paramcjd = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return paramcjd;
    }
    long l1 = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vsb, Long.valueOf(-1L))).longValue();
    long l2 = System.currentTimeMillis();
    Log.i("MicroMsg.TaskReportHardwareInfo", "hy: last ticks: %d, current ticks: %d, interval: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
    if ((!this.Dts) && (l2 - l1 < 86400000L))
    {
      Log.d("MicroMsg.TaskReportHardwareInfo", "hy: should not upload. too small interval");
      paramcjd = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return paramcjd;
    }
    if ((!this.Dts) && ((paramcjd == null) || (paramcjd.Tqe == null)))
    {
      Log.w("MicroMsg.TaskReportHardwareInfo", "hy: error when finding hardware");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(661L, 1L, 1L, false);
      paramcjd = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return paramcjd;
    }
    Log.i("MicroMsg.TaskReportHardwareInfo", "hy: found hardware infos. start report");
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    String str1 = paramcjd.Tqe.imei;
    String str2 = paramcjd.Tqe.ROV;
    String str3 = paramcjd.Tqe.nqp;
    String str4 = paramcjd.Tqe.ROX;
    String str5 = paramcjd.Tqf.Sdd;
    String str6 = paramcjd.Tqf.Sdb;
    String str7 = paramcjd.Tqf.nqp;
    String str8 = paramcjd.Tqf.Sde;
    int i18 = paramcjd.Tqf.Sdc;
    int i19 = paramcjd.Tqg.TFC;
    int i20 = paramcjd.Tqg.TFD;
    int i21 = paramcjd.Tqh.UpN;
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
    if (paramcjd.Tqh.UpO)
    {
      i = 1;
      if (!paramcjd.Tql.SYc) {
        break label1039;
      }
      j = 1;
      if (!paramcjd.Tql.SYd) {
        break label1044;
      }
      k = 1;
      str9 = paramcjd.Tqi.resolution;
      i22 = paramcjd.Tqi.lRI;
      str10 = paramcjd.Tqj.SnI;
      if (!paramcjd.Tqk.SBD) {
        break label1050;
      }
      m = 1;
      if (!paramcjd.Tqk.SBE) {
        break label1056;
      }
      n = 1;
      if (!paramcjd.Tqk.SBF) {
        break label1062;
      }
      i1 = 1;
      if (!paramcjd.Tqk.SBG) {
        break label1068;
      }
      i2 = 1;
      if (!paramcjd.Tqk.SBH) {
        break label1074;
      }
      i3 = 1;
      if (!paramcjd.Tqk.SBI) {
        break label1080;
      }
      i4 = 1;
      if (!paramcjd.Tqk.SBJ) {
        break label1086;
      }
      i5 = 1;
      if (!paramcjd.Tqk.SBU) {
        break label1092;
      }
      i6 = 1;
      if (!paramcjd.Tqk.SBK) {
        break label1098;
      }
      i7 = 1;
      if (!paramcjd.Tqk.SBL) {
        break label1104;
      }
      i8 = 1;
      if (!paramcjd.Tqk.SBM) {
        break label1110;
      }
      i9 = 1;
      if (!paramcjd.Tqk.SBN) {
        break label1116;
      }
      i10 = 1;
      if (!paramcjd.Tqk.SBO) {
        break label1122;
      }
      i11 = 1;
      if (!paramcjd.Tqk.SBP) {
        break label1128;
      }
      i12 = 1;
      if (!paramcjd.Tqk.SBQ) {
        break label1134;
      }
      i13 = 1;
      if (!paramcjd.Tqk.SBR) {
        break label1140;
      }
      i14 = 1;
      if (!paramcjd.Tqk.SBS) {
        break label1146;
      }
      i15 = 1;
      if (!paramcjd.Tqk.SBT) {
        break label1152;
      }
      i16 = 1;
      i23 = paramcjd.Tqg.GQB;
      i24 = paramcjd.Tqg.TFE;
      str11 = paramcjd.Tqj.SnJ;
      str12 = bt(paramcjd.Tqj.SnK);
      if (!paramcjd.Tql.SYe) {
        break label1158;
      }
    }
    label1152:
    label1158:
    for (int i17 = 1;; i17 = 0)
    {
      localh.a(14552, new Object[] { str1, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i20), Integer.valueOf(i21), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str9, Integer.valueOf(i22), str10, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), Integer.valueOf(i23), Integer.valueOf(i24), str11, str12, Integer.valueOf(i17) });
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vsb, Long.valueOf(l2));
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(661L, 0L, 1L, false);
      paramcjd = Boolean.TRUE;
      AppMethodBeat.o(55561);
      return paramcjd;
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
  
  private static String bt(LinkedList<cxl> paramLinkedList)
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
          Object localObject = (cxl)paramLinkedList.next();
          if ((localObject == null) || (Util.isNullOrNil(((cxl)localObject).aFM))) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("mimeName", ((cxl)localObject).aFM);
          JSONArray localJSONArray2 = new JSONArray();
          if (((cxl)localObject).TFX != null)
          {
            localObject = ((cxl)localObject).TFX.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.c.b
 * JD-Core Version:    0.7.0.1
 */