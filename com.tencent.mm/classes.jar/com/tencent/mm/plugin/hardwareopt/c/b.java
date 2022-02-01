package com.tencent.mm.plugin.hardwareopt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ahg;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bpo;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.protocal.protobuf.cxs;
import com.tencent.mm.protocal.protobuf.im;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.vending.c.a<Boolean, bfs>
{
  private boolean suD = false;
  
  public b(boolean paramBoolean)
  {
    this.suD = paramBoolean;
  }
  
  private Boolean a(bfs parambfs)
  {
    AppMethodBeat.i(55561);
    if (!g.afz().aeI())
    {
      ad.e("MicroMsg.TaskReportHardwareInfo", "Account not init, just return");
      parambfs = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return parambfs;
    }
    long l1 = ((Long)g.afB().afk().get(ae.a.FqO, Long.valueOf(-1L))).longValue();
    long l2 = System.currentTimeMillis();
    ad.i("MicroMsg.TaskReportHardwareInfo", "hy: last ticks: %d, current ticks: %d, interval: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1) });
    if ((!this.suD) && (l2 - l1 < 86400000L))
    {
      ad.d("MicroMsg.TaskReportHardwareInfo", "hy: should not upload. too small interval");
      parambfs = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return parambfs;
    }
    if ((!this.suD) && ((parambfs == null) || (parambfs.DCX == null)))
    {
      ad.w("MicroMsg.TaskReportHardwareInfo", "hy: error when finding hardware");
      h.vKh.idkeyStat(661L, 1L, 1L, false);
      parambfs = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return parambfs;
    }
    if ((!this.suD) && (bt.isNullOrNil(parambfs.DCX.imei)))
    {
      ad.w("MicroMsg.TaskReportHardwareInfo", "hy: no imei detected. maybe not grant permission. ignore");
      h.vKh.idkeyStat(661L, 2L, 1L, false);
      parambfs = Boolean.FALSE;
      AppMethodBeat.o(55561);
      return parambfs;
    }
    ad.i("MicroMsg.TaskReportHardwareInfo", "hy: found hardware infos. start report");
    h localh = h.vKh;
    String str1 = parambfs.DCX.imei;
    String str2 = parambfs.DCX.CEb;
    String str3 = parambfs.DCX.CEc;
    String str4 = parambfs.DCX.CEd;
    String str5 = parambfs.DCY.abi;
    String str6 = parambfs.DCY.COV;
    String str7 = parambfs.DCY.CEc;
    String str8 = parambfs.DCY.COX;
    int i18 = parambfs.DCY.COW;
    int i19 = parambfs.DCZ.DNW;
    int i20 = parambfs.DCZ.DNX;
    int i21 = parambfs.DDa.EpO;
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
    if (parambfs.DDa.EpP)
    {
      i = 1;
      if (!parambfs.DDe.Dok) {
        break label1091;
      }
      j = 1;
      if (!parambfs.DDe.Dol) {
        break label1096;
      }
      k = 1;
      str9 = parambfs.DDb.EhJ;
      i22 = parambfs.DDb.density;
      str10 = parambfs.DDc.CZa;
      if (!parambfs.DDd.DjF) {
        break label1102;
      }
      m = 1;
      if (!parambfs.DDd.DjG) {
        break label1108;
      }
      n = 1;
      if (!parambfs.DDd.DjH) {
        break label1114;
      }
      i1 = 1;
      if (!parambfs.DDd.DjI) {
        break label1120;
      }
      i2 = 1;
      if (!parambfs.DDd.DjJ) {
        break label1126;
      }
      i3 = 1;
      if (!parambfs.DDd.DjK) {
        break label1132;
      }
      i4 = 1;
      if (!parambfs.DDd.DjL) {
        break label1138;
      }
      i5 = 1;
      if (!parambfs.DDd.DjW) {
        break label1144;
      }
      i6 = 1;
      if (!parambfs.DDd.DjM) {
        break label1150;
      }
      i7 = 1;
      if (!parambfs.DDd.DjN) {
        break label1156;
      }
      i8 = 1;
      if (!parambfs.DDd.DjO) {
        break label1162;
      }
      i9 = 1;
      if (!parambfs.DDd.DjP) {
        break label1168;
      }
      i10 = 1;
      if (!parambfs.DDd.DjQ) {
        break label1174;
      }
      i11 = 1;
      if (!parambfs.DDd.DjR) {
        break label1180;
      }
      i12 = 1;
      if (!parambfs.DDd.DjS) {
        break label1186;
      }
      i13 = 1;
      if (!parambfs.DDd.DjT) {
        break label1192;
      }
      i14 = 1;
      if (!parambfs.DDd.DjU) {
        break label1198;
      }
      i15 = 1;
      if (!parambfs.DDd.DjV) {
        break label1204;
      }
      i16 = 1;
      i23 = parambfs.DCZ.hQv;
      i24 = parambfs.DCZ.DNY;
      str11 = parambfs.DDc.CZb;
      str12 = aw(parambfs.DDc.CZc);
      if (!parambfs.DDe.Dom) {
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
      localh.f(14552, new Object[] { str1, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i20), Integer.valueOf(i21), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str9, Integer.valueOf(i22), str10, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), Integer.valueOf(i23), Integer.valueOf(i24), str11, str12, Integer.valueOf(i17) });
      g.afB().afk().set(ae.a.FqO, Long.valueOf(l2));
      h.vKh.idkeyStat(661L, 0L, 1L, false);
      parambfs = Boolean.TRUE;
      AppMethodBeat.o(55561);
      return parambfs;
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
  
  private static String aw(LinkedList<bpu> paramLinkedList)
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
          Object localObject = (bpu)paramLinkedList.next();
          if ((localObject == null) || (bt.isNullOrNil(((bpu)localObject).mime))) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("mimeName", ((bpu)localObject).mime);
          JSONArray localJSONArray2 = new JSONArray();
          if (((bpu)localObject).DOg != null)
          {
            localObject = ((bpu)localObject).DOg.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.c.b
 * JD-Core Version:    0.7.0.1
 */