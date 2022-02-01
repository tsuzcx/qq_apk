package com.tencent.mm.plugin.hardwareopt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.bok;
import com.tencent.mm.protocal.protobuf.bzo;
import com.tencent.mm.protocal.protobuf.bzu;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.djm;
import com.tencent.mm.protocal.protobuf.iz;
import com.tencent.mm.protocal.protobuf.sd;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.vending.c.a<Boolean, bok>
{
  private boolean uQO = false;
  
  public b(boolean paramBoolean)
  {
    this.uQO = paramBoolean;
  }
  
  private Boolean a(bok parambok)
  {
    AppMethodBeat.i(55561);
    if (!com.tencent.mm.kernel.g.ajP().aiZ())
    {
      ae.e("MicroMsg.TaskReportHardwareInfo", "Account not init, just return");
      parambok = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return parambok;
    }
    long l1 = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVy, Long.valueOf(-1L))).longValue();
    long l2 = System.currentTimeMillis();
    ae.i("MicroMsg.TaskReportHardwareInfo", "hy: last ticks: %d, current ticks: %d, interval: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
    if ((!this.uQO) && (l2 - l1 < 86400000L))
    {
      ae.d("MicroMsg.TaskReportHardwareInfo", "hy: should not upload. too small interval");
      parambok = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return parambok;
    }
    if ((!this.uQO) && ((parambok == null) || (parambok.Hbr == null)))
    {
      ae.w("MicroMsg.TaskReportHardwareInfo", "hy: error when finding hardware");
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(661L, 1L, 1L, false);
      parambok = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return parambok;
    }
    if ((!this.uQO) && (bu.isNullOrNil(parambok.Hbr.imei)))
    {
      ae.w("MicroMsg.TaskReportHardwareInfo", "hy: no imei detected. maybe not grant permission. ignore");
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(661L, 2L, 1L, false);
      parambok = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return parambok;
    }
    ae.i("MicroMsg.TaskReportHardwareInfo", "hy: found hardware infos. start report");
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
    String str1 = parambok.Hbr.imei;
    String str2 = parambok.Hbr.FUs;
    String str3 = parambok.Hbr.FUt;
    String str4 = parambok.Hbr.FUu;
    String str5 = parambok.Hbs.abi;
    String str6 = parambok.Hbs.Ghm;
    String str7 = parambok.Hbs.FUt;
    String str8 = parambok.Hbs.Gho;
    int i18 = parambok.Hbs.Ghn;
    int i19 = parambok.Hbt.Hnw;
    int i20 = parambok.Hbt.Hnx;
    int i21 = parambok.Hbu.HRm;
    int i;
    int j;
    label382:
    int k;
    label395:
    String str9;
    int i22;
    String str10;
    int m;
    label435:
    int n;
    label448:
    int i1;
    label461:
    int i2;
    label474:
    int i3;
    label487:
    int i4;
    label500:
    int i5;
    label513:
    int i6;
    label526:
    int i7;
    label539:
    int i8;
    label552:
    int i9;
    label565:
    int i10;
    label578:
    int i11;
    label591:
    int i12;
    label604:
    int i13;
    label617:
    int i14;
    label630:
    int i15;
    label643:
    int i16;
    label656:
    int i23;
    int i24;
    String str11;
    String str12;
    if (parambok.Hbu.HRn)
    {
      i = 1;
      if (!parambok.Hby.GLK) {
        break label1091;
      }
      j = 1;
      if (!parambok.Hby.GLL) {
        break label1096;
      }
      k = 1;
      str9 = parambok.Hbv.resolution;
      i22 = parambok.Hbv.density;
      str10 = parambok.Hbw.Grw;
      if (!parambok.Hbx.GDh) {
        break label1102;
      }
      m = 1;
      if (!parambok.Hbx.GDi) {
        break label1108;
      }
      n = 1;
      if (!parambok.Hbx.GDj) {
        break label1114;
      }
      i1 = 1;
      if (!parambok.Hbx.GDk) {
        break label1120;
      }
      i2 = 1;
      if (!parambok.Hbx.GDl) {
        break label1126;
      }
      i3 = 1;
      if (!parambok.Hbx.GDm) {
        break label1132;
      }
      i4 = 1;
      if (!parambok.Hbx.GDn) {
        break label1138;
      }
      i5 = 1;
      if (!parambok.Hbx.GDy) {
        break label1144;
      }
      i6 = 1;
      if (!parambok.Hbx.GDo) {
        break label1150;
      }
      i7 = 1;
      if (!parambok.Hbx.GDp) {
        break label1156;
      }
      i8 = 1;
      if (!parambok.Hbx.GDq) {
        break label1162;
      }
      i9 = 1;
      if (!parambok.Hbx.GDr) {
        break label1168;
      }
      i10 = 1;
      if (!parambok.Hbx.GDs) {
        break label1174;
      }
      i11 = 1;
      if (!parambok.Hbx.GDt) {
        break label1180;
      }
      i12 = 1;
      if (!parambok.Hbx.GDu) {
        break label1186;
      }
      i13 = 1;
      if (!parambok.Hbx.GDv) {
        break label1192;
      }
      i14 = 1;
      if (!parambok.Hbx.GDw) {
        break label1198;
      }
      i15 = 1;
      if (!parambok.Hbx.GDx) {
        break label1204;
      }
      i16 = 1;
      i23 = parambok.Hbt.wZK;
      i24 = parambok.Hbt.Hny;
      str11 = parambok.Hbw.Grx;
      str12 = aF(parambok.Hbw.Gry);
      if (!parambok.Hby.GLM) {
        break label1210;
      }
    }
    label1156:
    label1162:
    label1168:
    label1174:
    label1180:
    label1186:
    label1192:
    label1198:
    label1204:
    label1210:
    for (int i17 = 1;; i17 = 0)
    {
      localg.f(14552, new Object[] { str1, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i20), Integer.valueOf(i21), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str9, Integer.valueOf(i22), str10, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), Integer.valueOf(i23), Integer.valueOf(i24), str11, str12, Integer.valueOf(i17) });
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVy, Long.valueOf(l2));
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(661L, 0L, 1L, false);
      parambok = Boolean.TRUE;
      AppMethodBeat.o(55561);
      return parambok;
      i = 0;
      break;
      label1091:
      j = 0;
      break label382;
      label1096:
      k = 0;
      break label395;
      label1102:
      m = 0;
      break label435;
      label1108:
      n = 0;
      break label448;
      label1114:
      i1 = 0;
      break label461;
      label1120:
      i2 = 0;
      break label474;
      label1126:
      i3 = 0;
      break label487;
      label1132:
      i4 = 0;
      break label500;
      label1138:
      i5 = 0;
      break label513;
      label1144:
      i6 = 0;
      break label526;
      label1150:
      i7 = 0;
      break label539;
      i8 = 0;
      break label552;
      i9 = 0;
      break label565;
      i10 = 0;
      break label578;
      i11 = 0;
      break label591;
      i12 = 0;
      break label604;
      i13 = 0;
      break label617;
      i14 = 0;
      break label630;
      i15 = 0;
      break label643;
      i16 = 0;
      break label656;
    }
  }
  
  private static String aF(LinkedList<bzu> paramLinkedList)
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
          Object localObject = (bzu)paramLinkedList.next();
          if ((localObject == null) || (bu.isNullOrNil(((bzu)localObject).mime))) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("mimeName", ((bzu)localObject).mime);
          JSONArray localJSONArray2 = new JSONArray();
          if (((bzu)localObject).HnG != null)
          {
            localObject = ((bzu)localObject).HnG.iterator();
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
          ae.printErrStackTrace("MicroMsg.TaskReportHardwareInfo", paramLinkedList, "hy: error when build up json", new Object[0]);
          AppMethodBeat.o(55562);
          return "";
        }
        localJSONArray1.put(localJSONObject);
      }
      paramLinkedList = localJSONArray1.toString();
      AppMethodBeat.o(55562);
      return paramLinkedList;
    }
    ae.w("MicroMsg.TaskReportHardwareInfo", "hy: no mime info retrieved!");
    AppMethodBeat.o(55562);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.c.b
 * JD-Core Version:    0.7.0.1
 */