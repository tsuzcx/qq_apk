package com.tencent.mm.plugin.hardwareopt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.akv;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.bns;
import com.tencent.mm.protocal.protobuf.byu;
import com.tencent.mm.protocal.protobuf.bza;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.dir;
import com.tencent.mm.protocal.protobuf.iz;
import com.tencent.mm.protocal.protobuf.sb;
import com.tencent.mm.protocal.protobuf.zw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.vending.c.a<Boolean, bns>
{
  private boolean uFb = false;
  
  public b(boolean paramBoolean)
  {
    this.uFb = paramBoolean;
  }
  
  private Boolean a(bns parambns)
  {
    AppMethodBeat.i(55561);
    if (!com.tencent.mm.kernel.g.ajA().aiK())
    {
      ad.e("MicroMsg.TaskReportHardwareInfo", "Account not init, just return");
      parambns = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return parambns;
    }
    long l1 = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAZ, Long.valueOf(-1L))).longValue();
    long l2 = System.currentTimeMillis();
    ad.i("MicroMsg.TaskReportHardwareInfo", "hy: last ticks: %d, current ticks: %d, interval: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
    if ((!this.uFb) && (l2 - l1 < 86400000L))
    {
      ad.d("MicroMsg.TaskReportHardwareInfo", "hy: should not upload. too small interval");
      parambns = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return parambns;
    }
    if ((!this.uFb) && ((parambns == null) || (parambns.GHP == null)))
    {
      ad.w("MicroMsg.TaskReportHardwareInfo", "hy: error when finding hardware");
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(661L, 1L, 1L, false);
      parambns = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return parambns;
    }
    if ((!this.uFb) && (bt.isNullOrNil(parambns.GHP.imei)))
    {
      ad.w("MicroMsg.TaskReportHardwareInfo", "hy: no imei detected. maybe not grant permission. ignore");
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(661L, 2L, 1L, false);
      parambns = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return parambns;
    }
    ad.i("MicroMsg.TaskReportHardwareInfo", "hy: found hardware infos. start report");
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
    String str1 = parambns.GHP.imei;
    String str2 = parambns.GHP.FBX;
    String str3 = parambns.GHP.FBY;
    String str4 = parambns.GHP.FBZ;
    String str5 = parambns.GHQ.abi;
    String str6 = parambns.GHQ.FON;
    String str7 = parambns.GHQ.FBY;
    String str8 = parambns.GHQ.FOP;
    int i18 = parambns.GHQ.FOO;
    int i19 = parambns.GHR.GTV;
    int i20 = parambns.GHR.GTW;
    int i21 = parambns.GHS.HxB;
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
    if (parambns.GHS.HxC)
    {
      i = 1;
      if (!parambns.GHW.Gsm) {
        break label1091;
      }
      j = 1;
      if (!parambns.GHW.Gsn) {
        break label1096;
      }
      k = 1;
      str9 = parambns.GHT.resolution;
      i22 = parambns.GHT.density;
      str10 = parambns.GHU.FYW;
      if (!parambns.GHV.Gkx) {
        break label1102;
      }
      m = 1;
      if (!parambns.GHV.Gky) {
        break label1108;
      }
      n = 1;
      if (!parambns.GHV.Gkz) {
        break label1114;
      }
      i1 = 1;
      if (!parambns.GHV.GkA) {
        break label1120;
      }
      i2 = 1;
      if (!parambns.GHV.GkB) {
        break label1126;
      }
      i3 = 1;
      if (!parambns.GHV.GkC) {
        break label1132;
      }
      i4 = 1;
      if (!parambns.GHV.GkD) {
        break label1138;
      }
      i5 = 1;
      if (!parambns.GHV.GkO) {
        break label1144;
      }
      i6 = 1;
      if (!parambns.GHV.GkE) {
        break label1150;
      }
      i7 = 1;
      if (!parambns.GHV.GkF) {
        break label1156;
      }
      i8 = 1;
      if (!parambns.GHV.GkG) {
        break label1162;
      }
      i9 = 1;
      if (!parambns.GHV.GkH) {
        break label1168;
      }
      i10 = 1;
      if (!parambns.GHV.GkI) {
        break label1174;
      }
      i11 = 1;
      if (!parambns.GHV.GkJ) {
        break label1180;
      }
      i12 = 1;
      if (!parambns.GHV.GkK) {
        break label1186;
      }
      i13 = 1;
      if (!parambns.GHV.GkL) {
        break label1192;
      }
      i14 = 1;
      if (!parambns.GHV.GkM) {
        break label1198;
      }
      i15 = 1;
      if (!parambns.GHV.GkN) {
        break label1204;
      }
      i16 = 1;
      i23 = parambns.GHR.wJZ;
      i24 = parambns.GHR.GTX;
      str11 = parambns.GHU.FYX;
      str12 = aF(parambns.GHU.FYY);
      if (!parambns.GHW.Gso) {
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
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAZ, Long.valueOf(l2));
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(661L, 0L, 1L, false);
      parambns = Boolean.TRUE;
      AppMethodBeat.o(55561);
      return parambns;
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
  
  private static String aF(LinkedList<bza> paramLinkedList)
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
          Object localObject = (bza)paramLinkedList.next();
          if ((localObject == null) || (bt.isNullOrNil(((bza)localObject).mime))) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("mimeName", ((bza)localObject).mime);
          JSONArray localJSONArray2 = new JSONArray();
          if (((bza)localObject).GUf != null)
          {
            localObject = ((bza)localObject).GUf.iterator();
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
          ad.printErrStackTrace("MicroMsg.TaskReportHardwareInfo", paramLinkedList, "hy: error when build up json", new Object[0]);
          AppMethodBeat.o(55562);
          return "";
        }
        localJSONArray1.put(localJSONObject);
      }
      paramLinkedList = localJSONArray1.toString();
      AppMethodBeat.o(55562);
      return paramLinkedList;
    }
    ad.w("MicroMsg.TaskReportHardwareInfo", "hy: no mime info retrieved!");
    AppMethodBeat.o(55562);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.c.b
 * JD-Core Version:    0.7.0.1
 */