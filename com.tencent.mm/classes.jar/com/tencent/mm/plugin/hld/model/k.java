package com.tencent.mm.plugin.hld.model;

import android.content.Context;
import android.view.View;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.f.b.a.gb;
import com.tencent.mm.f.b.a.gc;
import com.tencent.mm.f.b.a.gd;
import com.tencent.mm.f.b.a.ge;
import com.tencent.mm.f.b.a.gf;
import com.tencent.mm.f.b.a.gg;
import com.tencent.mm.f.b.a.gh;
import com.tencent.mm.f.b.a.gi;
import com.tencent.mm.f.b.a.gk;
import com.tencent.mm.f.b.a.gn;
import com.tencent.mm.f.b.a.gr;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.keyboard.c;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.protocal.protobuf.cln;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.clr;
import com.tencent.mm.protocal.protobuf.cls;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/ImeReporter;", "", "()V", "TAG", "", "chooseCandidateRecord", "Lcom/tencent/mm/plugin/hld/model/ImeReporter$PressOperationRecord;", "getChooseCandidateRecord", "()Lcom/tencent/mm/plugin/hld/model/ImeReporter$PressOperationRecord;", "setChooseCandidateRecord", "(Lcom/tencent/mm/plugin/hld/model/ImeReporter$PressOperationRecord;)V", "clickKeyRecord", "ifCreatePerformanceObject", "", "addChineseQwertyOperation", "", "v", "Landroid/view/View;", "operationType", "", "btn", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "addClickOperation", "keyArea", "addEnglishQwertyOperation", "addFloatViewOperation", "addInputToScreenOperation", "length", "addNumberOperation", "addOperation", "addT9Operation", "appendPermissionList", "stringBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "permissions", "", "code", "(Ljava/lang/StringBuilder;[Ljava/lang/String;I)V", "createPerformanceRecord", "onWindowHide", "onWindowShown", "context", "Landroid/content/Context;", "reportChooseCandidate", "candidateType", "order", "reportChooseFirstCandidate", "reportClientEnvironment", "reportDictDownloadStatus", "downloadStatus", "Lcom/tencent/mm/plugin/hld/model/ImeResDownloadStatus;", "localDict", "Lcom/tencent/mm/protocal/protobuf/ImeLocalCloudDict;", "errorCode", "reportEmojiOperation", "actionType", "subType", "emojiType", "reportFilter", "reportInputToScreenOperation", "reportOpenClose", "open", "reportProcessChooseCandidateRecord", "engineProcessTimestamp", "", "notifyToUIThreadTime", "pressTime", "engineProcessTime", "reportProcessClickKeyRecord", "getCandidateTime", "reportProcessOneKeyRecord", "uIUpdateTime", "keyType", "reportServiceEnable", "enable", "scene", "extendInt", "extendStr", "reportSetting", "pageType", "reportStartRecord", "performance", "Lcom/tencent/mm/protocal/protobuf/ImeLocalPerformance;", "reportStartRecordNew", "localPerformance", "reportUserActionInGuide", "enterScene", "isJoinCollectData", "reportUserOperation", "reportUserPermission", "permissionList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reportUserStatusInGuide", "status", "ifGuide", "setChooseCandidate", "setClickKey", "updateImeProcessServiceTimestamp", "startTimestamp", "updateImeServiceByCreateSession", "createSessionTime", "sessionType", "updateImeServiceByEngine", "engineInitializeTime", "engineConfigTime", "engineAddCellTime", "engineNetworkTime", "updateImeServiceByLoadContact", "loadContactTime", "updateImeServiceByOnCreate", "createStartTimestamp", "createEndTimestamp", "updateImeServiceByStartInput", "startInputTimestamp", "startInputEndTimestamp", "updateImeServiceByStartInputView", "startInputViewTimestamp", "updateImeServiceByWindowShow", "windowShowTimestamp", "windowShowEndTimestamp", "keyboard", "updatePrivacySettingUITimestamp", "updateSettingUITimestamp", "PressOperationRecord", "plugin-hld_release"})
public final class k
{
  private static boolean DCY;
  private static a DCZ;
  private static a DDa;
  public static final k DDb;
  
  static
  {
    AppMethodBeat.i(209396);
    DDb = new k();
    AppMethodBeat.o(209396);
  }
  
  public static void NV(long paramLong)
  {
    AppMethodBeat.i(209357);
    DDa = new a(paramLong, 0, System.currentTimeMillis());
    AppMethodBeat.o(209357);
  }
  
  public static void NW(long paramLong)
  {
    AppMethodBeat.i(209361);
    if (eEz())
    {
      AppMethodBeat.o(209361);
      return;
    }
    com.tencent.e.h.ZvG.d((Runnable)new r(paramLong), "WxIme.ImeReporter");
    AppMethodBeat.o(209361);
  }
  
  public static void NX(long paramLong)
  {
    AppMethodBeat.i(209363);
    com.tencent.e.h.ZvG.d((Runnable)new l(paramLong), "WxIme.ImeReporter");
    AppMethodBeat.o(209363);
  }
  
  public static void UC(int paramInt)
  {
    AppMethodBeat.i(209347);
    if (eEz())
    {
      AppMethodBeat.o(209347);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.hld.f.g.DHh;
    localObject1 = com.tencent.mm.plugin.hld.f.g.eGz();
    Object localObject2 = com.tencent.mm.plugin.hld.f.g.DHh;
    localObject2 = com.tencent.mm.plugin.hld.f.g.aLG((String)localObject1);
    int i;
    if (Util.isEqual((String)localObject1, "emoji")) {
      i = 1;
    }
    for (;;)
    {
      n(paramInt, (String)localObject2, i);
      AppMethodBeat.o(209347);
      return;
      if (Util.isEqual((String)localObject1, "kaoemoji")) {
        i = 2;
      } else {
        i = -1;
      }
    }
  }
  
  public static void UD(int paramInt)
  {
    AppMethodBeat.i(209385);
    if (eEz())
    {
      AppMethodBeat.o(209385);
      return;
    }
    com.tencent.e.h.ZvG.d((Runnable)new k.b(paramInt), "WxIme.ImeReporter");
    AppMethodBeat.o(209385);
  }
  
  public static void X(long paramLong, int paramInt)
  {
    AppMethodBeat.i(209354);
    DCZ = new a(paramLong, paramInt, System.currentTimeMillis());
    AppMethodBeat.o(209354);
  }
  
  public static void Y(long paramLong, int paramInt)
  {
    AppMethodBeat.i(209362);
    com.tencent.e.h.ZvG.d((Runnable)new j(paramLong, paramInt), "WxIme.ImeReporter");
    AppMethodBeat.o(209362);
  }
  
  static void a(long paramLong1, long paramLong2, final long paramLong3, long paramLong4, long paramLong5, final int paramInt)
  {
    AppMethodBeat.i(209359);
    if (eEz())
    {
      AppMethodBeat.o(209359);
      return;
    }
    if (System.currentTimeMillis() % 100L != 1L)
    {
      AppMethodBeat.o(209359);
      return;
    }
    n localn = n.DEn;
    final int i = n.eEW();
    com.tencent.e.h.ZvG.be((Runnable)new g(paramLong1, paramLong2, paramLong3, paramLong4, i, paramLong5, paramInt));
    AppMethodBeat.o(209359);
  }
  
  public static void a(com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb, int paramInt)
  {
    AppMethodBeat.i(209381);
    kotlin.g.b.p.k(paramb, "btn");
    if (eEz())
    {
      AppMethodBeat.o(209381);
      return;
    }
    paramb = paramb.id;
    int i;
    switch (paramb.hashCode())
    {
    default: 
    case 109637894: 
    case -1423372151: 
    case -1423372152: 
    case -1423372149: 
    case -1423372150: 
    case -1423372147: 
    case -1423372148: 
    case -1423372145: 
    case -1423372146: 
    case -1423372159: 
    case -1423372157: 
    case -1423372158: 
    case -1423372155: 
    case -1423372156: 
    case -1423372153: 
    case -1423372154: 
    case -1423372135: 
    case -1423372136: 
    case -1423372134: 
    case -1423372143: 
    case -1423372144: 
    case -1423372141: 
    case -1423372142: 
    case -1423372139: 
    case -1423372140: 
    case -1423372137: 
    case -1423372138: 
    case -535868465: 
      label542:
      do
      {
        do
        {
          for (i = -1;; i = 104)
          {
            hO(i, paramInt);
            AppMethodBeat.o(209381);
            return;
            if (!paramb.equals("space")) {
              break;
            }
          }
        } while (!paramb.equals("S2_key_i"));
        for (;;)
        {
          i = 200;
          break label542;
          if (!paramb.equals("S2_key_h")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_k")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_j")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_m")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_l")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_o")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_n")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_a")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_c")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_b")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_e")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_d")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_g")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_f")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_y")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_x")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_z")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_q")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_p")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_s")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_r")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_u")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_t")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_w")) {
            break;
          }
          continue;
          if (!paramb.equals("S2_key_v")) {
            break;
          }
        }
      } while (!paramb.equals("S3_key_n"));
    }
    for (;;)
    {
      label922:
      i = 300;
      break label542;
      if (!paramb.equals("S3_key_m")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_l")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_k")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_j")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_i")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_h")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_g")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_f")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_e")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_d")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_c")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_b")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_a")) {
        break;
      }
      continue;
      if (!paramb.equals("S1_key_3")) {
        break;
      }
      for (;;)
      {
        i = 100;
        break label542;
        if (!paramb.equals("S1_key_4")) {
          break;
        }
        continue;
        if (!paramb.equals("S1_key_1")) {
          break;
        }
        continue;
        if (!paramb.equals("S1_key_2")) {
          break;
        }
        continue;
        if (!paramb.equals("S1_key_7")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_z")) {
          break;
        }
        break label922;
        if (!paramb.equals("S1_key_8")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_y")) {
          break;
        }
        break label922;
        if (!paramb.equals("S1_key_5")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_x")) {
          break;
        }
        break label922;
        if (!paramb.equals("S1_key_6")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_w")) {
          break;
        }
        break label922;
        if (!paramb.equals("S3_key_v")) {
          break;
        }
        break label922;
        if (!paramb.equals("S3_key_u")) {
          break;
        }
        break label922;
        if (!paramb.equals("S1_key_9")) {
          break;
        }
      }
      if (!paramb.equals("S3_key_t")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_s")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_r")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_q")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_p")) {
        break;
      }
      continue;
      if (!paramb.equals("S3_key_o")) {
        break;
      }
    }
  }
  
  public static void a(m paramm, final clh paramclh, final int paramInt)
  {
    AppMethodBeat.i(209351);
    kotlin.g.b.p.k(paramm, "downloadStatus");
    if (paramclh != null)
    {
      if (eEz())
      {
        AppMethodBeat.o(209351);
        return;
      }
      if (com.tencent.e.h.ZvG.be((Runnable)new f(paramm, paramclh, paramInt)) != null) {}
    }
    else
    {
      Log.e("WxIme.ImeReporter", "reportDictDownloadStatus localDict is null");
      paramm = x.aazN;
    }
    AppMethodBeat.o(209351);
  }
  
  public static void ag(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(209358);
    a locala = DDa;
    if (locala != null)
    {
      a(locala.Dui, paramLong1 - locala.DDc, paramLong2, 0L, 2L, 0);
      DDa = null;
      AppMethodBeat.o(209358);
      return;
    }
    AppMethodBeat.o(209358);
  }
  
  public static void am(View paramView, int paramInt)
  {
    AppMethodBeat.i(209384);
    if (eEz())
    {
      AppMethodBeat.o(209384);
      return;
    }
    if (paramView != null)
    {
      int i = paramView.getId();
      if ((i == a.f.t9_key1) || (i == a.f.t9_key2) || (i == a.f.t9_key3) || (i == a.f.t9_key4) || (i == a.f.t9_key5) || (i == a.f.t9_key6) || (i == a.f.t9_key7) || (i == a.f.t9_key8) || (i == a.f.t9_key9)) {
        i = 100;
      }
      for (;;)
      {
        hO(i, paramInt);
        AppMethodBeat.o(209384);
        return;
        if (i == a.f.t9_key_space) {
          i = 104;
        } else if ((i == a.f.s2_key_q) || (i == a.f.s2_key_w) || (i == a.f.s2_key_e) || (i == a.f.s2_key_r) || (i == a.f.s2_key_t) || (i == a.f.s2_key_y) || (i == a.f.s2_key_u) || (i == a.f.s2_key_i) || (i == a.f.s2_key_o) || (i == a.f.s2_key_p) || (i == a.f.s2_key_a) || (i == a.f.s2_key_s) || (i == a.f.s2_key_d) || (i == a.f.s2_key_f) || (i == a.f.s2_key_g) || (i == a.f.s2_key_h) || (i == a.f.s2_key_j) || (i == a.f.s2_key_k) || (i == a.f.s2_key_l) || (i == a.f.s2_key_z) || (i == a.f.s2_key_x) || (i == a.f.s2_key_c) || (i == a.f.s2_key_v) || (i == a.f.s2_key_b) || (i == a.f.s2_key_n) || (i == a.f.s2_key_m)) {
          i = 200;
        } else if ((i == a.f.s3_key_q) || (i == a.f.s3_key_w) || (i == a.f.s3_key_e) || (i == a.f.s3_key_r) || (i == a.f.s3_key_t) || (i == a.f.s3_key_y) || (i == a.f.s3_key_u) || (i == a.f.s3_key_i) || (i == a.f.s3_key_o) || (i == a.f.s3_key_p) || (i == a.f.s3_key_a) || (i == a.f.s3_key_s) || (i == a.f.s3_key_d) || (i == a.f.s3_key_f) || (i == a.f.s3_key_g) || (i == a.f.s3_key_h) || (i == a.f.s3_key_j) || (i == a.f.s3_key_k) || (i == a.f.s3_key_l) || (i == a.f.s3_key_z) || (i == a.f.s3_key_x) || (i == a.f.s3_key_c) || (i == a.f.s3_key_v) || (i == a.f.s3_key_b) || (i == a.f.s3_key_n) || (i == a.f.s3_key_m)) {
          i = 300;
        } else {
          i = -1;
        }
      }
    }
    Log.e("WxIme.ImeReporter", "addFloatViewOperation v is null." + Util.getStack());
    AppMethodBeat.o(209384);
  }
  
  public static void ao(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(209339);
    if (eEz())
    {
      AppMethodBeat.o(209339);
      return;
    }
    ge localge = new ge();
    localge.mE(paramInt1);
    localge.mF(paramInt2);
    localge.mG(paramInt3);
    localge.bpa();
    AppMethodBeat.o(209339);
  }
  
  public static void ap(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(209346);
    if (eEz())
    {
      AppMethodBeat.o(209346);
      return;
    }
    gk localgk = new gk();
    localgk.mQ(paramInt1);
    localgk.mR(paramInt2);
    localgk.mS(paramInt3);
    localgk.bpa();
    AppMethodBeat.o(209346);
  }
  
  public static void eEx()
  {
    AppMethodBeat.i(209389);
    if (eEz())
    {
      AppMethodBeat.o(209389);
      return;
    }
    sR(false);
    if (!eEz())
    {
      cln localcln = (cln)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_context");
      if (localcln == null) {
        break label466;
      }
      Object localObject1 = localcln.Ttd;
      kotlin.g.b.p.j(localObject1, "it.operationList");
      int i;
      if (!((Collection)localObject1).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        long l = System.currentTimeMillis();
        localObject1 = new JSONArray();
        Iterator localIterator = localcln.Ttd.iterator();
        Object localObject2;
        for (;;)
        {
          if (localIterator.hasNext())
          {
            clp localclp = (clp)localIterator.next();
            localObject2 = localObject1;
            if (((JSONArray)localObject1).length() > 100)
            {
              localObject2 = localObject1;
              if (localclp.Tth == 0)
              {
                localObject2 = new JSONObject();
                ((JSONObject)localObject2).put("num", ((JSONArray)localObject1).length());
                ((JSONObject)localObject2).put("operationList", localObject1);
                localObject1 = new gn();
                ((gn)localObject1).vz(localcln.sessionId);
                localObject2 = ((JSONObject)localObject2).toString();
                kotlin.g.b.p.j(localObject2, "result.toString()");
                ((gn)localObject1).vA(kotlin.n.n.l((String)localObject2, ",", ";", false));
                ((gn)localObject1).bpa();
                localObject2 = new JSONArray();
              }
            }
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("area", localclp.Ttf);
            ((JSONObject)localObject1).put("type", localclp.Ttg);
            ((JSONObject)localObject1).put("status", localclp.Tth);
            ((JSONArray)localObject2).put(localObject1);
            localObject1 = localObject2;
            continue;
            i = 0;
            break;
          }
        }
        if (((JSONArray)localObject1).length() > 0)
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("num", ((JSONArray)localObject1).length());
          ((JSONObject)localObject2).put("operationList", localObject1);
          localObject1 = new gn();
          ((gn)localObject1).vz(localcln.sessionId);
          localObject2 = ((JSONObject)localObject2).toString();
          kotlin.g.b.p.j(localObject2, "result.toString()");
          ((gn)localObject1).vA(kotlin.n.n.l((String)localObject2, ",", ";", false));
          ((gn)localObject1).bpa();
        }
        Log.i("WxIme.ImeReporter", "reportUserOperation time:" + (System.currentTimeMillis() - l));
      }
    }
    for (;;)
    {
      eEy();
      ((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).removeFromMemory(10, "id_context");
      AppMethodBeat.o(209389);
      return;
      label466:
      Log.e("WxIme.ImeReporter", "getOnlyMemory(reportUserOperation) 10 id_context is null");
    }
  }
  
  private static void eEy()
  {
    AppMethodBeat.i(209392);
    if (eEz())
    {
      AppMethodBeat.o(209392);
      return;
    }
    cln localcln = (cln)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_context");
    if (localcln != null)
    {
      Object localObject1 = localcln.Tte;
      kotlin.g.b.p.j(localObject1, "it.inputToScreenOperationList");
      int i;
      if (!((Collection)localObject1).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        System.currentTimeMillis();
        localObject1 = new JSONArray();
        Iterator localIterator = localcln.Tte.iterator();
        Object localObject2;
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Integer localInteger = (Integer)localIterator.next();
            localObject2 = localObject1;
            if (((JSONArray)localObject1).length() > 100)
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("num", ((JSONArray)localObject1).length());
              ((JSONObject)localObject2).put("operationList", localObject1);
              localObject1 = new gg();
              ((gg)localObject1).vt(localcln.sessionId);
              localObject2 = ((JSONObject)localObject2).toString();
              kotlin.g.b.p.j(localObject2, "result.toString()");
              ((gg)localObject1).vu(kotlin.n.n.l((String)localObject2, ",", ";", false));
              ((gg)localObject1).bpa();
              localObject2 = new JSONArray();
            }
            localObject1 = new JSONObject();
            kotlin.g.b.p.j(localInteger, "operation");
            ((JSONObject)localObject1).put("num", localInteger.intValue());
            ((JSONArray)localObject2).put(localObject1);
            localObject1 = localObject2;
            continue;
            i = 0;
            break;
          }
        }
        if (((JSONArray)localObject1).length() > 0)
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("num", ((JSONArray)localObject1).length());
          ((JSONObject)localObject2).put("operationList", localObject1);
          localObject1 = new gg();
          ((gg)localObject1).vt(localcln.sessionId);
          localObject2 = ((JSONObject)localObject2).toString();
          kotlin.g.b.p.j(localObject2, "result.toString()");
          ((gg)localObject1).vu(kotlin.n.n.l((String)localObject2, ",", ";", false));
          ((gg)localObject1).bpa();
        }
      }
      AppMethodBeat.o(209392);
      return;
    }
    Log.e("WxIme.ImeReporter", "getOnlyMemory(reportInputToScreenOperation) 10 id_context is null");
    AppMethodBeat.o(209392);
  }
  
  public static boolean eEz()
  {
    AppMethodBeat.i(209394);
    p localp = p.DEH;
    if (p.eFn())
    {
      AppMethodBeat.o(209394);
      return true;
    }
    AppMethodBeat.o(209394);
    return false;
  }
  
  public static void ff(View paramView)
  {
    AppMethodBeat.i(209365);
    if (eEz())
    {
      AppMethodBeat.o(209365);
      return;
    }
    if (paramView != null)
    {
      int i = paramView.getId();
      if ((i == a.f.t9_key1) || (i == a.f.t9_key2) || (i == a.f.t9_key3) || (i == a.f.t9_key4) || (i == a.f.t9_key5) || (i == a.f.t9_key6) || (i == a.f.t9_key7) || (i == a.f.t9_key8) || (i == a.f.t9_key9)) {
        i = 100;
      }
      for (;;)
      {
        hO(i, 1);
        AppMethodBeat.o(209365);
        return;
        if (i == a.f.t9_key_number)
        {
          i = 103;
        }
        else if (i == a.f.t9_key_space)
        {
          i = 104;
        }
        else if (i == a.f.t9_key_exchange)
        {
          i = 105;
        }
        else if (i == a.f.t9_key_new_line)
        {
          i = 108;
        }
        else if (i == a.f.t9_key_clear)
        {
          i = 107;
        }
        else if (i == a.f.t9_key_action)
        {
          paramView = (d)com.tencent.mm.kernel.h.ae(d.class);
          if (paramView != null)
          {
            paramView = paramView.eCD();
            if ((paramView != null) && (paramView.eCn() == true))
            {
              i = 108;
              continue;
            }
          }
          i = 109;
        }
        else
        {
          i = -1;
        }
      }
    }
    Log.e("WxIme.ImeReporter", "addT9Operation v is null." + Util.getStack());
    AppMethodBeat.o(209365);
  }
  
  public static void fg(View paramView)
  {
    AppMethodBeat.i(209370);
    if (eEz())
    {
      AppMethodBeat.o(209370);
      return;
    }
    if (paramView != null)
    {
      int i = paramView.getId();
      if ((i == a.f.s2_key_q) || (i == a.f.s2_key_w) || (i == a.f.s2_key_e) || (i == a.f.s2_key_r) || (i == a.f.s2_key_t) || (i == a.f.s2_key_y) || (i == a.f.s2_key_u) || (i == a.f.s2_key_i) || (i == a.f.s2_key_o) || (i == a.f.s2_key_p) || (i == a.f.s2_key_a) || (i == a.f.s2_key_s) || (i == a.f.s2_key_d) || (i == a.f.s2_key_f) || (i == a.f.s2_key_g) || (i == a.f.s2_key_h) || (i == a.f.s2_key_j) || (i == a.f.s2_key_k) || (i == a.f.s2_key_l) || (i == a.f.s2_key_z) || (i == a.f.s2_key_x) || (i == a.f.s2_key_c) || (i == a.f.s2_key_v) || (i == a.f.s2_key_b) || (i == a.f.s2_key_n) || (i == a.f.s2_key_m)) {
        i = 200;
      }
      for (;;)
      {
        hO(i, 1);
        AppMethodBeat.o(209370);
        return;
        if (i == a.f.s2_key_symbol)
        {
          i = 204;
        }
        else if (i == a.f.s2_key_number)
        {
          i = 205;
        }
        else if (i == a.f.s2_key_comma)
        {
          i = 202;
        }
        else if (i == a.f.s2_key_space)
        {
          i = 206;
        }
        else if (i == a.f.s2_key_at)
        {
          i = 203;
        }
        else if (i == a.f.s2_key_exchange)
        {
          i = 207;
        }
        else if (i == a.f.s2_key_action)
        {
          paramView = (d)com.tencent.mm.kernel.h.ae(d.class);
          if (paramView != null)
          {
            paramView = paramView.eCD();
            if ((paramView != null) && (paramView.eCn() == true))
            {
              i = 209;
              continue;
            }
          }
          i = 210;
        }
        else
        {
          i = -1;
        }
      }
    }
    Log.e("WxIme.ImeReporter", "addChineseQwertyOperation v is null." + Util.getStack());
    AppMethodBeat.o(209370);
  }
  
  public static void fh(View paramView)
  {
    AppMethodBeat.i(209377);
    if (eEz())
    {
      AppMethodBeat.o(209377);
      return;
    }
    if (paramView != null)
    {
      int i = paramView.getId();
      if ((i == a.f.s3_key_q) || (i == a.f.s3_key_w) || (i == a.f.s3_key_e) || (i == a.f.s3_key_r) || (i == a.f.s3_key_t) || (i == a.f.s3_key_y) || (i == a.f.s3_key_u) || (i == a.f.s3_key_i) || (i == a.f.s3_key_o) || (i == a.f.s3_key_p) || (i == a.f.s3_key_a) || (i == a.f.s3_key_s) || (i == a.f.s3_key_d) || (i == a.f.s3_key_f) || (i == a.f.s3_key_g) || (i == a.f.s3_key_h) || (i == a.f.s3_key_j) || (i == a.f.s3_key_k) || (i == a.f.s3_key_l) || (i == a.f.s3_key_z) || (i == a.f.s3_key_x) || (i == a.f.s3_key_c) || (i == a.f.s3_key_v) || (i == a.f.s3_key_b) || (i == a.f.s3_key_n) || (i == a.f.s3_key_m)) {
        i = 300;
      }
      for (;;)
      {
        hO(i, 1);
        AppMethodBeat.o(209377);
        return;
        if (i == a.f.s3_key_symbol)
        {
          i = 304;
        }
        else if (i == a.f.s3_key_number)
        {
          i = 305;
        }
        else if (i == a.f.s3_key_comma)
        {
          i = 302;
        }
        else if (i == a.f.s3_key_space)
        {
          i = 306;
        }
        else if (i == a.f.s3_key_at)
        {
          i = 303;
        }
        else if (i == a.f.s3_key_exchange)
        {
          i = 307;
        }
        else if (i == a.f.s3_key_action)
        {
          paramView = (d)com.tencent.mm.kernel.h.ae(d.class);
          if (paramView != null)
          {
            paramView = paramView.eCD();
            if ((paramView != null) && (paramView.eCn() == true))
            {
              i = 309;
              continue;
            }
          }
          i = 310;
        }
        else
        {
          i = -1;
        }
      }
    }
    Log.e("WxIme.ImeReporter", "addEnglishQwertyOperation v is null." + Util.getStack());
    AppMethodBeat.o(209377);
  }
  
  public static void fi(View paramView)
  {
    AppMethodBeat.i(209379);
    if (eEz())
    {
      AppMethodBeat.o(209379);
      return;
    }
    if (paramView != null)
    {
      int i = paramView.getId();
      if ((i == a.f.s4_key_1) || (i == a.f.s4_key_2) || (i == a.f.s4_key_3) || (i == a.f.s4_key_4) || (i == a.f.s4_key_5) || (i == a.f.s4_key_6) || (i == a.f.s4_key_7) || (i == a.f.s4_key_8) || (i == a.f.s4_key_9) || (i == a.f.s4_key_0)) {
        i = 400;
      }
      for (;;)
      {
        hO(i, 1);
        AppMethodBeat.o(209379);
        return;
        if (i == a.f.s4_key_space)
        {
          i = 405;
        }
        else if (i == a.f.s4_key_back)
        {
          i = 403;
        }
        else if (i == a.f.s4_key_at)
        {
          i = 406;
        }
        else if (i == a.f.s4_key_dot)
        {
          i = 408;
        }
        else if (i == a.f.s4_key_action)
        {
          paramView = (d)com.tencent.mm.kernel.h.ae(d.class);
          if (paramView != null)
          {
            paramView = paramView.eCD();
            if ((paramView != null) && (paramView.eCn() == true))
            {
              i = 407;
              continue;
            }
          }
          i = 409;
        }
        else
        {
          i = -1;
        }
      }
    }
    Log.e("WxIme.ImeReporter", "addNumberOperation v is null." + Util.getStack());
    AppMethodBeat.o(209379);
  }
  
  public static void gQ(Context paramContext)
  {
    AppMethodBeat.i(209388);
    kotlin.g.b.p.k(paramContext, "context");
    if (eEz())
    {
      AppMethodBeat.o(209388);
      return;
    }
    com.tencent.e.h.ZvG.d((Runnable)d.DDh, "WxIme.ImeReporter");
    AppMethodBeat.o(209388);
  }
  
  public static void hM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209341);
    if (eEz())
    {
      AppMethodBeat.o(209341);
      return;
    }
    gf localgf = new gf();
    localgf.mH(paramInt1);
    localgf.mI(paramInt2);
    localgf.bpa();
    AppMethodBeat.o(209341);
  }
  
  public static void hN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209345);
    if (eEz())
    {
      AppMethodBeat.o(209345);
      return;
    }
    gb localgb = new gb();
    cln localcln = (cln)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_context");
    if (localcln != null) {
      localgb.vo(localcln.sessionId);
    }
    localgb.mA(paramInt1);
    localgb.mB(paramInt2);
    localgb.bpa();
    AppMethodBeat.o(209345);
  }
  
  public static void hO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209364);
    if (eEz())
    {
      AppMethodBeat.o(209364);
      return;
    }
    n localn = n.DEn;
    if (n.eEE()) {}
    for (int i = 0;; i = 1)
    {
      com.tencent.e.h.ZvG.d((Runnable)new k.c(paramInt1, paramInt2, i), "WxIme.ImeReporter");
      AppMethodBeat.o(209364);
      return;
    }
  }
  
  public static void l(com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(209368);
    kotlin.g.b.p.k(paramb, "btn");
    if (eEz())
    {
      AppMethodBeat.o(209368);
      return;
    }
    paramb = paramb.id;
    int i;
    switch (paramb.hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      label310:
      hO(i, 1);
      AppMethodBeat.o(209368);
      return;
      if (!paramb.equals("symbol")) {
        break;
      }
      i = 204;
      continue;
      if (!paramb.equals("num")) {
        break;
      }
      i = 205;
      continue;
      if (!paramb.equals("dot")) {
        break;
      }
      i = 202;
      continue;
      if (!paramb.equals("space")) {
        break;
      }
      i = 206;
      continue;
      if (!paramb.equals("enter")) {
        break;
      }
      paramb = (d)com.tencent.mm.kernel.h.ae(d.class);
      if (paramb != null)
      {
        paramb = paramb.eCD();
        if ((paramb != null) && (paramb.eCn() == true))
        {
          i = 209;
          continue;
          if (!paramb.equals("cnSwitch")) {
            break;
          }
          i = 207;
          continue;
          if (!paramb.equals("S2_key_i")) {
            break;
          }
          for (;;)
          {
            i = 200;
            break label310;
            if (!paramb.equals("S2_key_h")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_k")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_j")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_m")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_l")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_o")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_n")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_a")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_c")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_b")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_e")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_d")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_g")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_f")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_y")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_x")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_z")) {
              break;
            }
            continue;
            if (!paramb.equals("at")) {
              break;
            }
            i = 203;
            break label310;
            if (!paramb.equals("S2_key_q")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_p")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_s")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_r")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_u")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_t")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_w")) {
              break;
            }
            continue;
            if (!paramb.equals("S2_key_v")) {
              break;
            }
          }
        }
      }
      i = 210;
    }
  }
  
  public static void m(com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(209375);
    kotlin.g.b.p.k(paramb, "btn");
    if (eEz())
    {
      AppMethodBeat.o(209375);
      return;
    }
    paramb = paramb.id;
    int i;
    switch (paramb.hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      label310:
      hO(i, 1);
      AppMethodBeat.o(209375);
      return;
      if (!paramb.equals("S3_key_n")) {
        break;
      }
      for (;;)
      {
        i = 300;
        break label310;
        if (!paramb.equals("S3_key_m")) {
          break;
        }
        continue;
        if (!paramb.equals("symbol")) {
          break;
        }
        i = 304;
        break label310;
        if (!paramb.equals("S3_key_l")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_k")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_j")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_i")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_h")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_g")) {
          break;
        }
        continue;
        if (!paramb.equals("num")) {
          break;
        }
        i = 305;
        break label310;
        if (!paramb.equals("S3_key_f")) {
          break;
        }
        continue;
        if (!paramb.equals("dot")) {
          break;
        }
        i = 302;
        break label310;
        if (!paramb.equals("S3_key_e")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_d")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_c")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_b")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_a")) {
          break;
        }
        continue;
        if (!paramb.equals("space")) {
          break;
        }
        i = 306;
        break label310;
        if (!paramb.equals("S3_key_z")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_y")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_x")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_w")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_v")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_u")) {
          break;
        }
        continue;
        if (!paramb.equals("enSwitch")) {
          break;
        }
        i = 307;
        break label310;
        if (!paramb.equals("S3_key_t")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_s")) {
          break;
        }
        continue;
        if (!paramb.equals("enter")) {
          break;
        }
        paramb = (d)com.tencent.mm.kernel.h.ae(d.class);
        if (paramb == null) {
          break label818;
        }
        paramb = paramb.eCD();
        if ((paramb == null) || (paramb.eCn() != true)) {
          break label818;
        }
        i = 309;
        break label310;
        if (!paramb.equals("S3_key_r")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_q")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_p")) {
          break;
        }
        continue;
        if (!paramb.equals("S3_key_o")) {
          break;
        }
      }
      if (!paramb.equals("at")) {
        break;
      }
      i = 303;
      continue;
      label818:
      i = 310;
    }
  }
  
  public static void n(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(209348);
    kotlin.g.b.p.k(paramString, "subType");
    if (eEz())
    {
      AppMethodBeat.o(209348);
      return;
    }
    gd localgd = new gd();
    localgd.mC(paramInt1);
    localgd.vs(paramString);
    localgd.mD(paramInt2);
    localgd.bpa();
    AppMethodBeat.o(209348);
  }
  
  public static void n(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(209355);
    a locala = DCZ;
    if (locala != null)
    {
      a(locala.Dui, paramLong1 - locala.DDc, paramLong2, paramLong3, 1L, locala.keyType);
      DCZ = null;
      AppMethodBeat.o(209355);
      return;
    }
    AppMethodBeat.o(209355);
  }
  
  public static void n(com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(209378);
    kotlin.g.b.p.k(paramb, "btn");
    if (eEz())
    {
      AppMethodBeat.o(209378);
      return;
    }
    paramb = paramb.id;
    int i;
    switch (paramb.hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      label166:
      hO(i, 1);
      AppMethodBeat.o(209378);
      return;
      if (!paramb.equals("S4_key_3")) {
        break;
      }
      for (;;)
      {
        i = 400;
        break label166;
        if (!paramb.equals("S4_key_2")) {
          break;
        }
        continue;
        if (!paramb.equals("S4_key_5")) {
          break;
        }
        continue;
        if (!paramb.equals("S4_key_4")) {
          break;
        }
        continue;
        if (!paramb.equals("S4_key_1")) {
          break;
        }
        continue;
        if (!paramb.equals("S4_key_0")) {
          break;
        }
        continue;
        if (!paramb.equals("dot")) {
          break;
        }
        i = 408;
        break label166;
        if (!paramb.equals("back")) {
          break;
        }
        i = 403;
        break label166;
        if (!paramb.equals("S4_key_7")) {
          break;
        }
        continue;
        if (!paramb.equals("S4_key_6")) {
          break;
        }
        continue;
        if (!paramb.equals("S4_key_9")) {
          break;
        }
        continue;
        if (!paramb.equals("space")) {
          break;
        }
        i = 405;
        break label166;
        if (!paramb.equals("S4_key_8")) {
          break;
        }
      }
      if (!paramb.equals("at")) {
        break;
      }
      i = 406;
      continue;
      if (!paramb.equals("enter")) {
        break;
      }
      paramb = (d)com.tencent.mm.kernel.h.ae(d.class);
      if (paramb != null)
      {
        paramb = paramb.eCD();
        if ((paramb != null) && (paramb.eCn() == true))
        {
          i = 407;
          continue;
        }
      }
      i = 409;
    }
  }
  
  public static void sR(boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(209343);
    if (eEz())
    {
      AppMethodBeat.o(209343);
      return;
    }
    gh localgh = new gh();
    Object localObject = (cln)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_context");
    if (localObject != null)
    {
      localgh.vw(((cln)localObject).sessionId);
      localgh.mJ(((cln)localObject).scene);
      if (!paramBoolean) {
        break label192;
      }
      i = 1;
      label84:
      localgh.mK(i);
      localObject = g.DCm;
      i = g.eEm();
      if (i != c.Dyl.ordinal()) {
        break label197;
      }
      i = 1;
      label111:
      localgh.mL(i);
      localObject = (d)com.tencent.mm.kernel.h.ae(d.class);
      if (localObject == null) {
        break label326;
      }
      localObject = ((d)localObject).eCD();
      if ((localObject == null) || (((com.tencent.mm.plugin.hld.a.b)localObject).eCu() != true)) {
        break label326;
      }
    }
    label192:
    label197:
    label326:
    for (int i = j;; i = 2)
    {
      localgh.vv(String.valueOf(i));
      localgh.bpa();
      AppMethodBeat.o(209343);
      return;
      Log.e("WxIme.ImeReporter", "getOnlyMemory(reportOpenClose) 10 id_context is null");
      break;
      i = 2;
      break label84;
      if (i == c.Dym.ordinal())
      {
        i = 2;
        break label111;
      }
      if (i == c.Dyn.ordinal())
      {
        i = 3;
        break label111;
      }
      if (i == c.Dyo.ordinal())
      {
        i = 4;
        break label111;
      }
      if (i == c.Dyp.ordinal())
      {
        i = 5;
        break label111;
      }
      if (i == c.Dyq.ordinal())
      {
        i = 6;
        break label111;
      }
      if (i == c.Dyr.ordinal())
      {
        i = 7;
        break label111;
      }
      if (i == c.Dys.ordinal())
      {
        i = 8;
        break label111;
      }
      if (i == c.Dyt.ordinal())
      {
        i = 9;
        break label111;
      }
      i = -1;
      break label111;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/ImeReporter$PressOperationRecord;", "", "pressTime", "", "keyType", "", "processTimeStamp", "(JIJ)V", "getKeyType", "()I", "getPressTime", "()J", "getProcessTimeStamp", "plugin-hld_release"})
  public static final class a
  {
    final long DDc;
    final long Dui;
    final int keyType;
    
    public a(long paramLong1, int paramInt, long paramLong2)
    {
      this.Dui = paramLong1;
      this.keyType = paramInt;
      this.DDc = paramLong2;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d DDh;
    
    static
    {
      AppMethodBeat.i(216988);
      DDh = new d();
      AppMethodBeat.o(216988);
    }
    
    public final void run()
    {
      AppMethodBeat.i(216987);
      Object localObject1 = (com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class);
      cln localcln = new cln();
      localcln.sessionId = String.valueOf(System.currentTimeMillis());
      Object localObject2 = (d)com.tencent.mm.kernel.h.ae(d.class);
      int i;
      if (localObject2 != null)
      {
        localObject2 = ((d)localObject2).eCD();
        if ((localObject2 != null) && (((com.tencent.mm.plugin.hld.a.b)localObject2).eCu() == true))
        {
          localObject2 = (d)com.tencent.mm.kernel.h.ae(d.class);
          if (localObject2 != null)
          {
            localObject2 = ((d)localObject2).eCD();
            if (localObject2 != null) {
              i = ((com.tencent.mm.plugin.hld.a.b)localObject2).eCw();
            }
          }
        }
      }
      for (;;)
      {
        localcln.scene = i;
        ((com.tencent.mm.plugin.secdata.g)localObject1).updateOnlyMemory(10, "id_context", (a)localcln);
        localObject1 = k.DDb;
        k.sR(true);
        AppMethodBeat.o(216987);
        return;
        i = 5;
        continue;
        i = 0;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class e
    implements Runnable
  {
    public static final e DDi;
    
    static
    {
      AppMethodBeat.i(216423);
      DDi = new e();
      AppMethodBeat.o(216423);
    }
    
    public final void run()
    {
      AppMethodBeat.i(216418);
      Object localObject1 = new gc();
      try
      {
        Object localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
        ((gc)localObject1).vp(com.tencent.mm.plugin.hld.f.l.eHt());
        localObject2 = new StringBuilder();
        k localk = k.DDb;
        k.a((StringBuilder)localObject2, new String[] { "android.permission.READ_CONTACTS" }, 1);
        localk = k.DDb;
        k.a((StringBuilder)localObject2, new String[] { "android.permission.WRITE_CONTACTS" }, 2);
        localk = k.DDb;
        k.a((StringBuilder)localObject2, new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 3);
        localk = k.DDb;
        k.a((StringBuilder)localObject2, new String[] { "android.permission.RECORD_AUDIO" }, 4);
        localk = k.DDb;
        k.a((StringBuilder)localObject2, new String[] { "android.permission.CAMERA" }, 5);
        localk = k.DDb;
        k.a((StringBuilder)localObject2, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 6);
        localk = k.DDb;
        k.a((StringBuilder)localObject2, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 7);
        localk = k.DDb;
        k.a((StringBuilder)localObject2, new String[] { "android.permission.READ_PHONE_STATE" }, 8);
        localk = k.DDb;
        k.a((StringBuilder)localObject2, new String[] { "android.permission.USE_FINGERPRINT" }, 9);
        ((gc)localObject1).vq(((StringBuilder)localObject2).toString());
        localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
        ((gc)localObject1).oP(com.tencent.mm.plugin.hld.f.l.eHu());
        localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
        ((gc)localObject1).oQ(com.tencent.mm.plugin.hld.f.l.eHx());
        localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
        ((gc)localObject1).oR(com.tencent.mm.plugin.hld.f.l.eHy());
        localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
        ((gc)localObject1).vr(com.tencent.mm.plugin.hld.f.l.eHz());
        ((gc)localObject1).bpa();
        localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
        localObject1 = com.tencent.mm.plugin.hld.f.l.getKV();
        if (localObject1 != null)
        {
          ((MultiProcessMMKV)localObject1).putBoolean("ime_if_report_client_environment", true);
          AppMethodBeat.o(216418);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.i("WxIme.ImeReporter", "getCurIme " + localException.getMessage());
        }
        AppMethodBeat.o(216418);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/hld/model/ImeReporter$reportDictDownloadStatus$1$1"})
  static final class f
    implements Runnable
  {
    f(m paramm, clh paramclh, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(211877);
      gr localgr = new gr();
      localgr.pk(this.DDj.value);
      localgr.vE(paramclh.name);
      localgr.mV(paramclh.version);
      localgr.mW(paramclh.TsM);
      localgr.mX(paramclh.lZN);
      localgr.mY(paramclh.dataType);
      localgr.mZ(paramclh.lNK);
      localgr.vF(paramclh.SoN);
      localgr.na(paramclh.ddx);
      localgr.vG(paramclh.smT);
      localgr.vH(paramclh.md5);
      localgr.nb(paramclh.TsO);
      localgr.nc(paramInt);
      localgr.bpa();
      AppMethodBeat.o(211877);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, long paramLong5, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(216429);
      gi localgi = new gi();
      localgi.oS(this.DDm);
      localgi.oT(paramLong3);
      localgi.oU(i);
      localgi.oV(paramInt);
      localgi.oW(this.DDq);
      localgi.oX(this.DDr);
      localgi.oY(this.DDs);
      localgi.mM(this.DDt);
      localgi.bpa();
      AppMethodBeat.o(216429);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(213881);
      Object localObject = k.DDb;
      k.eEA();
      localObject = (clk)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
      if (localObject != null)
      {
        ((clk)localObject).TsU = this.DDx;
        if ((((clk)localObject).TsV == 0L) && (((clk)localObject).TsW == 0L) && (((clk)localObject).TsT.Tti == 0L)) {
          ((clk)localObject).TsX = 2;
        }
        AppMethodBeat.o(213881);
        return;
      }
      AppMethodBeat.o(213881);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(long paramLong, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(210190);
      clk localclk = (clk)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
      if (localclk != null)
      {
        if (!localclk.TsY.TtC)
        {
          localclk.TsY.Ttz = this.DDy;
          localclk.TsY.sessionType = this.DDz;
        }
        AppMethodBeat.o(210190);
        return;
      }
      AppMethodBeat.o(210190);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {}
    
    public final void run()
    {
      AppMethodBeat.i(213884);
      clk localclk = (clk)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
      if (localclk != null)
      {
        if (!localclk.TsY.TtC)
        {
          localclk.TsY.Ttv = this.DDA;
          localclk.TsY.Ttw = this.DDB;
          localclk.TsY.Ttx = this.DDC;
          localclk.TsY.Tty = this.DDD;
          localclk.TsY.TtD = this.DDE;
          k localk = k.DDb;
          k.a(localclk);
        }
        AppMethodBeat.o(213884);
        return;
      }
      AppMethodBeat.o(213884);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(214790);
      clk localclk = (clk)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
      if (localclk != null)
      {
        if (!localclk.TsY.TtC)
        {
          localclk.TsY.TtA = this.DDF;
          k localk = k.DDb;
          k.a(localclk);
        }
        AppMethodBeat.o(214790);
        return;
      }
      AppMethodBeat.o(214790);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class m
    implements Runnable
  {
    public m(long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(217312);
      Object localObject = k.DDb;
      k.eEA();
      localObject = (clk)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
      if (localObject != null)
      {
        ((clk)localObject).TsT.Tti = this.DDG;
        ((clk)localObject).TsT.Ttj = this.DDH;
        ((clk)localObject).TsT.Ttk = (this.DDH - this.DDG);
        ((clk)localObject).TsT.Ttl = true;
        AppMethodBeat.o(217312);
        return;
      }
      AppMethodBeat.o(217312);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class n
    implements Runnable
  {
    public n(long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(209302);
      clk localclk = (clk)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
      if (localclk != null)
      {
        localclk.TsT.Ttm = this.DDI;
        localclk.TsT.Ttn = this.DDJ;
        localclk.TsT.Tto = (this.DDJ - this.DDI);
        localclk.TsT.Ttp = true;
        AppMethodBeat.o(209302);
        return;
      }
      AppMethodBeat.o(209302);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class o
    implements Runnable
  {
    public o(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(212223);
      clk localclk = (clk)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
      if (localclk != null)
      {
        localclk.TsT.Ttq = this.DDK;
        AppMethodBeat.o(212223);
        return;
      }
      AppMethodBeat.o(212223);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class p
    implements Runnable
  {
    public p(long paramLong1, long paramLong2, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(213873);
      clk localclk = (clk)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
      if (localclk != null)
      {
        localclk.TsT.Ttr = this.DDL;
        localclk.TsT.Tts = this.DDM;
        localclk.TsT.Ttt = (this.DDM - this.DDL);
        localclk.TsT.Ttu = this.DDN;
        k localk = k.DDb;
        k.b(localclk);
        localclk.TsT.Ttl = false;
        localclk.TsT.Ttp = false;
        AppMethodBeat.o(213873);
        return;
      }
      AppMethodBeat.o(213873);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class q
    implements Runnable
  {
    public q(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(213896);
      Object localObject = k.DDb;
      k.eEA();
      localObject = (clk)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
      if (localObject != null)
      {
        ((clk)localObject).TsW = this.DDx;
        if ((((clk)localObject).TsU == 0L) && (((clk)localObject).TsV == 0L) && (((clk)localObject).TsT.Tti == 0L)) {
          ((clk)localObject).TsX = 4;
        }
        AppMethodBeat.o(213896);
        return;
      }
      AppMethodBeat.o(213896);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(211456);
      Object localObject = k.DDb;
      k.eEA();
      localObject = (clk)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
      if (localObject != null)
      {
        ((clk)localObject).TsV = this.DDx;
        if ((((clk)localObject).TsU == 0L) && (((clk)localObject).TsW == 0L) && (((clk)localObject).TsT.Tti == 0L)) {
          ((clk)localObject).TsX = 3;
        }
        AppMethodBeat.o(211456);
        return;
      }
      AppMethodBeat.o(211456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.k
 * JD-Core Version:    0.7.0.1
 */