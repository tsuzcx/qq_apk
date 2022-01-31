package com.tencent.mm.plugin.hardwareopt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.ael;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.protocal.protobuf.bde;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.protocal.protobuf.uf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.vending.c.a<Boolean, auq>
{
  private boolean nGW = false;
  
  public b(boolean paramBoolean)
  {
    this.nGW = paramBoolean;
  }
  
  private Boolean a(auq paramauq)
  {
    AppMethodBeat.i(59280);
    if (!g.RJ().QU())
    {
      ab.e("MicroMsg.TaskReportHardwareInfo", "Account not init, just return");
      paramauq = Boolean.FALSE;
      AppMethodBeat.o(59280);
      return paramauq;
    }
    long l1 = ((Long)g.RL().Ru().get(ac.a.yHS, Long.valueOf(-1L))).longValue();
    long l2 = System.currentTimeMillis();
    ab.i("MicroMsg.TaskReportHardwareInfo", "hy: last ticks: %d, current ticks: %d, interval: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
    if ((!this.nGW) && (l2 - l1 < 86400000L))
    {
      ab.d("MicroMsg.TaskReportHardwareInfo", "hy: should not upload. too small interval");
      paramauq = Boolean.FALSE;
      AppMethodBeat.o(59280);
      return paramauq;
    }
    if ((!this.nGW) && ((paramauq == null) || (paramauq.xjC == null)))
    {
      ab.w("MicroMsg.TaskReportHardwareInfo", "hy: error when finding hardware");
      h.qsU.idkeyStat(661L, 1L, 1L, false);
      paramauq = Boolean.FALSE;
      AppMethodBeat.o(59280);
      return paramauq;
    }
    if ((!this.nGW) && (bo.isNullOrNil(paramauq.xjC.imei)))
    {
      ab.w("MicroMsg.TaskReportHardwareInfo", "hy: no imei detected. maybe not grant permission. ignore");
      h.qsU.idkeyStat(661L, 2L, 1L, false);
      paramauq = Boolean.FALSE;
      AppMethodBeat.o(59280);
      return paramauq;
    }
    ab.i("MicroMsg.TaskReportHardwareInfo", "hy: found hardware infos. start report");
    h localh = h.qsU;
    String str1 = paramauq.xjC.imei;
    String str2 = paramauq.xjC.wul;
    String str3 = paramauq.xjC.wum;
    String str4 = paramauq.xjC.wun;
    String str5 = paramauq.xjD.wDv;
    String str6 = paramauq.xjD.wDt;
    String str7 = paramauq.xjD.wum;
    String str8 = paramauq.xjD.wDw;
    int i18 = paramauq.xjD.wDu;
    int i19 = paramauq.xjE.xsW;
    int i20 = paramauq.xjE.xsX;
    int i21 = paramauq.xjF.xRu;
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
    if (paramauq.xjF.xRv)
    {
      i = 1;
      if (!paramauq.xjJ.wXo) {
        break label1091;
      }
      j = 1;
      if (!paramauq.xjJ.wXp) {
        break label1096;
      }
      k = 1;
      str9 = paramauq.xjG.xJZ;
      i22 = paramauq.xjG.density;
      str10 = paramauq.xjH.wME;
      if (!paramauq.xjI.wWd) {
        break label1102;
      }
      m = 1;
      if (!paramauq.xjI.wWe) {
        break label1108;
      }
      n = 1;
      if (!paramauq.xjI.wWf) {
        break label1114;
      }
      i1 = 1;
      if (!paramauq.xjI.wWg) {
        break label1120;
      }
      i2 = 1;
      if (!paramauq.xjI.wWh) {
        break label1126;
      }
      i3 = 1;
      if (!paramauq.xjI.wWi) {
        break label1132;
      }
      i4 = 1;
      if (!paramauq.xjI.wWj) {
        break label1138;
      }
      i5 = 1;
      if (!paramauq.xjI.wWu) {
        break label1144;
      }
      i6 = 1;
      if (!paramauq.xjI.wWk) {
        break label1150;
      }
      i7 = 1;
      if (!paramauq.xjI.wWl) {
        break label1156;
      }
      i8 = 1;
      if (!paramauq.xjI.wWm) {
        break label1162;
      }
      i9 = 1;
      if (!paramauq.xjI.wWn) {
        break label1168;
      }
      i10 = 1;
      if (!paramauq.xjI.wWo) {
        break label1174;
      }
      i11 = 1;
      if (!paramauq.xjI.wWp) {
        break label1180;
      }
      i12 = 1;
      if (!paramauq.xjI.wWq) {
        break label1186;
      }
      i13 = 1;
      if (!paramauq.xjI.wWr) {
        break label1192;
      }
      i14 = 1;
      if (!paramauq.xjI.wWs) {
        break label1198;
      }
      i15 = 1;
      if (!paramauq.xjI.wWt) {
        break label1204;
      }
      i16 = 1;
      i23 = paramauq.xjE.gim;
      i24 = paramauq.xjE.xsY;
      str11 = paramauq.xjH.wMF;
      str12 = ah(paramauq.xjH.wMG);
      if (!paramauq.xjJ.wXq) {
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
      localh.e(14552, new Object[] { str1, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i20), Integer.valueOf(i21), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str9, Integer.valueOf(i22), str10, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), Integer.valueOf(i23), Integer.valueOf(i24), str11, str12, Integer.valueOf(i17) });
      g.RL().Ru().set(ac.a.yHS, Long.valueOf(l2));
      h.qsU.idkeyStat(661L, 0L, 1L, false);
      paramauq = Boolean.TRUE;
      AppMethodBeat.o(59280);
      return paramauq;
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
  
  private static String ah(LinkedList<bde> paramLinkedList)
  {
    AppMethodBeat.i(59281);
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
          Object localObject = (bde)paramLinkedList.next();
          if ((localObject == null) || (bo.isNullOrNil(((bde)localObject).cfP))) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("mimeName", ((bde)localObject).cfP);
          JSONArray localJSONArray2 = new JSONArray();
          if (((bde)localObject).xtg != null)
          {
            localObject = ((bde)localObject).xtg.iterator();
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
          ab.printErrStackTrace("MicroMsg.TaskReportHardwareInfo", paramLinkedList, "hy: error when build up json", new Object[0]);
          AppMethodBeat.o(59281);
          return "";
        }
        localJSONArray1.put(localJSONObject);
      }
      paramLinkedList = localJSONArray1.toString();
      AppMethodBeat.o(59281);
      return paramLinkedList;
    }
    ab.w("MicroMsg.TaskReportHardwareInfo", "hy: no mime info retrieved!");
    AppMethodBeat.o(59281);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.c.b
 * JD-Core Version:    0.7.0.1
 */