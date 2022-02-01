package com.tencent.mm.plugin.hld.model;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.hw;
import com.tencent.mm.autogen.mmdata.rpt.hx;
import com.tencent.mm.autogen.mmdata.rpt.hy;
import com.tencent.mm.autogen.mmdata.rpt.hz;
import com.tencent.mm.autogen.mmdata.rpt.ia;
import com.tencent.mm.autogen.mmdata.rpt.ib;
import com.tencent.mm.autogen.mmdata.rpt.ic;
import com.tencent.mm.autogen.mmdata.rpt.id;
import com.tencent.mm.autogen.mmdata.rpt.ie;
import com.tencent.mm.autogen.mmdata.rpt.if;
import com.tencent.mm.autogen.mmdata.rpt.ig;
import com.tencent.mm.autogen.mmdata.rpt.ih;
import com.tencent.mm.autogen.mmdata.rpt.ii;
import com.tencent.mm.autogen.mmdata.rpt.im;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.b.g.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.keyboard.c;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.protocal.protobuf.dbv;
import com.tencent.mm.protocal.protobuf.dbx;
import com.tencent.mm.protocal.protobuf.dbz;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/ImeReporter;", "", "()V", "TAG", "", "chooseCandidateRecord", "Lcom/tencent/mm/plugin/hld/model/ImeReporter$PressOperationRecord;", "getChooseCandidateRecord", "()Lcom/tencent/mm/plugin/hld/model/ImeReporter$PressOperationRecord;", "setChooseCandidateRecord", "(Lcom/tencent/mm/plugin/hld/model/ImeReporter$PressOperationRecord;)V", "clickKeyRecord", "ifCreatePerformanceObject", "", "addChineseQwertyOperation", "", "v", "Landroid/view/View;", "operationType", "", "btn", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "addClickOperation", "keyArea", "addEnglishQwertyOperation", "addFloatViewOperation", "addInputToScreenOperation", "length", "addNumberOperation", "addOperation", "addT9Operation", "appendPermissionList", "stringBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "permissions", "", "code", "(Ljava/lang/StringBuilder;[Ljava/lang/String;I)V", "createPerformanceRecord", "onWindowHide", "onWindowShown", "context", "Landroid/content/Context;", "reportChooseCandidate", "candidateType", "order", "reportChooseFirstCandidate", "reportClientEnvironment", "reportDictDownloadStatus", "downloadStatus", "Lcom/tencent/mm/plugin/hld/model/ImeResDownloadStatus;", "localDict", "Lcom/tencent/mm/protocal/protobuf/ImeLocalCloudDict;", "errorCode", "reportEmojiOperation", "actionType", "subType", "emojiType", "reportFilter", "reportInputToScreenOperation", "reportOpenClose", "open", "reportProcessChooseCandidateRecord", "engineProcessTimestamp", "", "notifyToUIThreadTime", "pressTime", "engineProcessTime", "reportProcessClickKeyRecord", "getCandidateTime", "reportProcessOneKeyRecord", "uIUpdateTime", "keyType", "reportServiceEnable", "enable", "scene", "extendInt", "extendStr", "reportSetting", "pageType", "reportStartRecord", "performance", "Lcom/tencent/mm/protocal/protobuf/ImeLocalPerformance;", "reportStartRecordNew", "localPerformance", "reportUserActionInGuide", "enterScene", "isJoinCollectData", "reportUserOperation", "reportUserPermission", "permissionList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reportUserStatusInGuide", "status", "ifGuide", "setChooseCandidate", "setClickKey", "updateImeProcessServiceTimestamp", "startTimestamp", "updateImeServiceByCreateSession", "createSessionTime", "sessionType", "updateImeServiceByEngine", "engineInitializeTime", "engineConfigTime", "engineAddCellTime", "engineNetworkTime", "updateImeServiceByLoadContact", "loadContactTime", "updateImeServiceByOnCreate", "createStartTimestamp", "createEndTimestamp", "updateImeServiceByStartInput", "startInputTimestamp", "startInputEndTimestamp", "updateImeServiceByStartInputView", "startInputViewTimestamp", "updateImeServiceByWindowShow", "windowShowTimestamp", "windowShowEndTimestamp", "keyboard", "updatePrivacySettingUITimestamp", "updateSettingUITimestamp", "PressOperationRecord", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k JvH;
  private static boolean JvI;
  private static a JvJ;
  private static a JvK;
  
  static
  {
    AppMethodBeat.i(312509);
    JvH = new k();
    AppMethodBeat.o(312509);
  }
  
  public static void YA(int paramInt)
  {
    AppMethodBeat.i(312181);
    js(paramInt, 1);
    AppMethodBeat.o(312181);
  }
  
  public static void YB(int paramInt)
  {
    AppMethodBeat.i(312299);
    if (fMC())
    {
      AppMethodBeat.o(312299);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new k..ExternalSyntheticLambda0(paramInt), "WxIme.ImeReporter");
    AppMethodBeat.o(312299);
  }
  
  private static final void YC(int paramInt)
  {
    AppMethodBeat.i(312492);
    Object localObject = (dbv)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_context");
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        Log.e("WxIme.ImeReporter", "getOnlyMemory(addInputToScreenOperation) 10 id_context is null");
      }
      AppMethodBeat.o(312492);
      return;
      ((dbv)localObject).aaHp.addLast(Integer.valueOf(paramInt));
      Log.d("WxIme.ImeReporter", s.X("addInputToScreenOperation ", Integer.valueOf(paramInt)));
    }
  }
  
  public static void Yz(int paramInt)
  {
    AppMethodBeat.i(311993);
    if (fMC())
    {
      AppMethodBeat.o(311993);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.hld.f.g.Jyo;
    localObject1 = com.tencent.mm.plugin.hld.f.g.fOn();
    Object localObject2 = com.tencent.mm.plugin.hld.f.g.Jyo;
    localObject2 = com.tencent.mm.plugin.hld.f.g.aIz((String)localObject1);
    int i;
    if (Util.isEqual((String)localObject1, "emoji")) {
      i = 1;
    }
    for (;;)
    {
      r(paramInt, (String)localObject2, i);
      AppMethodBeat.o(311993);
      return;
      if (Util.isEqual((String)localObject1, "kaoemoji")) {
        i = 2;
      } else {
        i = -1;
      }
    }
  }
  
  private static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt)
  {
    AppMethodBeat.i(312075);
    if (fMC())
    {
      AppMethodBeat.o(312075);
      return;
    }
    if (System.currentTimeMillis() % 100L != 1L)
    {
      AppMethodBeat.o(312075);
      return;
    }
    n localn = n.JvW;
    int i = n.fMZ();
    com.tencent.threadpool.h.ahAA.bm(new k..ExternalSyntheticLambda12(paramLong1, paramLong2, paramLong3, paramLong4, 0L, i, paramLong5, paramInt));
    AppMethodBeat.o(312075);
  }
  
  private static final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, long paramLong6, int paramInt2)
  {
    AppMethodBeat.i(312382);
    id localid = new id();
    localid.iPw = paramLong1;
    localid.iPx = paramLong2;
    localid.iPy = paramLong3;
    localid.iPz = paramLong4;
    localid.iPA = paramLong5;
    localid.iPB = paramInt1;
    localid.iPC = paramLong6;
    localid.iPD = paramInt2;
    localid.bMH();
    AppMethodBeat.o(312382);
  }
  
  public static void a(com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb, int paramInt)
  {
    AppMethodBeat.i(312275);
    s.u(paramb, "btn");
    if (fMC())
    {
      AppMethodBeat.o(312275);
      return;
    }
    paramb = paramb.id;
    switch (paramb.hashCode())
    {
    }
    for (;;)
    {
      for (int i = -1;; i = 104)
      {
        js(i, paramInt);
        AppMethodBeat.o(312275);
        return;
        if (!paramb.equals("space")) {
          break;
        }
      }
      if (paramb.equals("S2_key_i"))
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              do
                                              {
                                                do
                                                {
                                                  do
                                                  {
                                                    do
                                                    {
                                                      do
                                                      {
                                                        do
                                                        {
                                                          i = 200;
                                                          break;
                                                        } while (paramb.equals("S2_key_h"));
                                                        break;
                                                      } while (paramb.equals("S2_key_k"));
                                                      break;
                                                    } while (paramb.equals("S2_key_j"));
                                                    break;
                                                  } while (paramb.equals("S2_key_m"));
                                                  break;
                                                } while (paramb.equals("S2_key_l"));
                                                break;
                                              } while (paramb.equals("S2_key_o"));
                                              break;
                                            } while (paramb.equals("S2_key_n"));
                                            break;
                                          } while (paramb.equals("S2_key_a"));
                                          break;
                                        } while (paramb.equals("S2_key_c"));
                                        break;
                                      } while (paramb.equals("S2_key_b"));
                                      break;
                                    } while (paramb.equals("S2_key_e"));
                                    break;
                                  } while (paramb.equals("S2_key_d"));
                                  break;
                                } while (paramb.equals("S2_key_g"));
                                break;
                              } while (paramb.equals("S2_key_f"));
                              break;
                            } while (paramb.equals("S2_key_y"));
                            break;
                          } while (paramb.equals("S2_key_x"));
                          break;
                        } while (paramb.equals("S2_key_z"));
                        break;
                      } while (paramb.equals("S2_key_q"));
                      break;
                    } while (paramb.equals("S2_key_p"));
                    break;
                  } while (paramb.equals("S2_key_s"));
                  break;
                } while (paramb.equals("S2_key_r"));
                break;
              } while (paramb.equals("S2_key_u"));
              break;
            } while (paramb.equals("S2_key_t"));
            break;
          } while (paramb.equals("S2_key_w"));
          break;
        } while (paramb.equals("S2_key_v"));
        if ((goto 540) && (paramb.equals("S3_key_n"))) {
          label922:
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              do
                                              {
                                                i = 300;
                                                break;
                                              } while (paramb.equals("S3_key_m"));
                                              break;
                                            } while (paramb.equals("S3_key_l"));
                                            break;
                                          } while (paramb.equals("S3_key_k"));
                                          break;
                                        } while (paramb.equals("S3_key_j"));
                                        break;
                                      } while (paramb.equals("S3_key_i"));
                                      break;
                                    } while (paramb.equals("S3_key_h"));
                                    break;
                                  } while (paramb.equals("S3_key_g"));
                                  break;
                                } while (paramb.equals("S3_key_f"));
                                break;
                              } while (paramb.equals("S3_key_e"));
                              break;
                            } while (paramb.equals("S3_key_d"));
                            break;
                          } while (paramb.equals("S3_key_c"));
                          break;
                        } while (paramb.equals("S3_key_b"));
                        break;
                      } while (paramb.equals("S3_key_a"));
                      if ((goto 540) || (!paramb.equals("S1_key_3"))) {
                        break;
                      }
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      i = 100;
                                      break;
                                    } while (paramb.equals("S1_key_4"));
                                    break;
                                  } while (paramb.equals("S1_key_1"));
                                  break;
                                } while (paramb.equals("S1_key_2"));
                                break;
                              } while (paramb.equals("S1_key_7"));
                              break;
                              if (paramb.equals("S3_key_z")) {
                                break label922;
                              }
                              break;
                            } while (paramb.equals("S1_key_8"));
                            break;
                            if (paramb.equals("S3_key_y")) {
                              break label922;
                            }
                            break;
                          } while (paramb.equals("S1_key_5"));
                          break;
                          if (paramb.equals("S3_key_x")) {
                            break label922;
                          }
                          break;
                        } while (paramb.equals("S1_key_6"));
                        break;
                        if (paramb.equals("S3_key_w")) {
                          break label922;
                        }
                        break;
                        if (paramb.equals("S3_key_v")) {
                          break label922;
                        }
                        break;
                        if (paramb.equals("S3_key_u")) {
                          break label922;
                        }
                        break;
                      } while (paramb.equals("S1_key_9"));
                      break;
                    } while (paramb.equals("S3_key_t"));
                    break;
                  } while (paramb.equals("S3_key_s"));
                  break;
                } while (paramb.equals("S3_key_r"));
                break;
              } while (paramb.equals("S3_key_q"));
              break;
            } while (paramb.equals("S3_key_p"));
            break;
          } while (paramb.equals("S3_key_o"));
        }
      }
    }
  }
  
  public static void a(m paramm, dbp paramdbp, int paramInt)
  {
    AppMethodBeat.i(312023);
    s.u(paramm, "downloadStatus");
    if (paramdbp == null) {}
    for (paramm = null;; paramm = com.tencent.threadpool.h.ahAA.bm(new k..ExternalSyntheticLambda13(paramm, paramdbp, paramInt)))
    {
      if (paramm == null) {
        Log.e("WxIme.ImeReporter", "reportDictDownloadStatus localDict is null");
      }
      AppMethodBeat.o(312023);
      return;
      if (fMC())
      {
        AppMethodBeat.o(312023);
        return;
      }
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(312084);
    if (((CharSequence)paramStringBuilder).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramStringBuilder.append(";");
      }
      l locall = l.JyV;
      if (l.L(paramArrayOfString)) {
        paramStringBuilder.append(paramInt);
      }
      AppMethodBeat.o(312084);
      return;
    }
  }
  
  public static void aB(View paramView, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(312292);
    if (fMC())
    {
      AppMethodBeat.o(312292);
      return;
    }
    if (paramView == null)
    {
      paramView = null;
      if (paramView == null) {
        Log.e("WxIme.ImeReporter", s.X("addFloatViewOperation v is null.", Util.getStack()));
      }
      AppMethodBeat.o(312292);
      return;
    }
    int k = paramView.getId();
    int i;
    if (k == a.f.t9_key1)
    {
      i = 1;
      label69:
      if (i == 0) {
        break label148;
      }
      i = 1;
      label75:
      if (i == 0) {
        break label166;
      }
      i = 1;
      label81:
      if (i == 0) {
        break label184;
      }
      i = 1;
      label87:
      if (i == 0) {
        break label202;
      }
      i = 1;
      label93:
      if (i == 0) {
        break label220;
      }
      i = 1;
      label99:
      if (i == 0) {
        break label238;
      }
      i = 1;
      label105:
      if (i == 0) {
        break label256;
      }
      i = 1;
      label111:
      if (i == 0) {
        break label274;
      }
      i = 100;
    }
    label256:
    label388:
    label394:
    label400:
    label913:
    for (;;)
    {
      js(i, paramInt);
      paramView = ah.aiuX;
      break;
      if (k == a.f.t9_key2)
      {
        i = 1;
        break label69;
      }
      i = 0;
      break label69;
      label148:
      if (k == a.f.t9_key3)
      {
        i = 1;
        break label75;
      }
      i = 0;
      break label75;
      label166:
      if (k == a.f.t9_key4)
      {
        i = 1;
        break label81;
      }
      i = 0;
      break label81;
      label184:
      if (k == a.f.t9_key5)
      {
        i = 1;
        break label87;
      }
      i = 0;
      break label87;
      label202:
      if (k == a.f.t9_key6)
      {
        i = 1;
        break label93;
      }
      i = 0;
      break label93;
      label220:
      if (k == a.f.t9_key7)
      {
        i = 1;
        break label99;
      }
      i = 0;
      break label99;
      label238:
      if (k == a.f.t9_key8)
      {
        i = 1;
        break label105;
      }
      i = 0;
      break label105;
      if (k == a.f.t9_key9)
      {
        i = 1;
        break label111;
      }
      i = 0;
      break label111;
      label274:
      if (k == a.f.t9_key_space)
      {
        i = 104;
      }
      else
      {
        if (k == a.f.s2_key_q)
        {
          i = 1;
          label298:
          if (i == 0) {
            break label471;
          }
          i = 1;
          label304:
          if (i == 0) {
            break label489;
          }
          i = 1;
          label310:
          if (i == 0) {
            break label507;
          }
          i = 1;
          label316:
          if (i == 0) {
            break label525;
          }
          i = 1;
          label322:
          if (i == 0) {
            break label543;
          }
          i = 1;
          label328:
          if (i == 0) {
            break label561;
          }
          i = 1;
          label334:
          if (i == 0) {
            break label579;
          }
          i = 1;
          label340:
          if (i == 0) {
            break label597;
          }
          i = 1;
          label346:
          if (i == 0) {
            break label615;
          }
          i = 1;
          label352:
          if (i == 0) {
            break label633;
          }
          i = 1;
          label358:
          if (i == 0) {
            break label651;
          }
          i = 1;
          label364:
          if (i == 0) {
            break label669;
          }
          i = 1;
          label370:
          if (i == 0) {
            break label687;
          }
          i = 1;
          label376:
          if (i == 0) {
            break label705;
          }
          i = 1;
          label382:
          if (i == 0) {
            break label723;
          }
          i = 1;
          if (i == 0) {
            break label741;
          }
          i = 1;
          if (i == 0) {
            break label759;
          }
          i = 1;
          if (i == 0) {
            break label777;
          }
          i = 1;
          label406:
          if (i == 0) {
            break label795;
          }
          i = 1;
          label412:
          if (i == 0) {
            break label813;
          }
          i = 1;
          label418:
          if (i == 0) {
            break label831;
          }
          i = 1;
          label424:
          if (i == 0) {
            break label849;
          }
          i = 1;
          label430:
          if (i == 0) {
            break label867;
          }
          i = 1;
          label436:
          if (i == 0) {
            break label885;
          }
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label903;
          }
          i = 200;
          break;
          if (k == a.f.s2_key_w)
          {
            i = 1;
            break label298;
          }
          i = 0;
          break label298;
          label471:
          if (k == a.f.s2_key_e)
          {
            i = 1;
            break label304;
          }
          i = 0;
          break label304;
          label489:
          if (k == a.f.s2_key_r)
          {
            i = 1;
            break label310;
          }
          i = 0;
          break label310;
          label507:
          if (k == a.f.s2_key_t)
          {
            i = 1;
            break label316;
          }
          i = 0;
          break label316;
          if (k == a.f.s2_key_y)
          {
            i = 1;
            break label322;
          }
          i = 0;
          break label322;
          label543:
          if (k == a.f.s2_key_u)
          {
            i = 1;
            break label328;
          }
          i = 0;
          break label328;
          label561:
          if (k == a.f.s2_key_i)
          {
            i = 1;
            break label334;
          }
          i = 0;
          break label334;
          label579:
          if (k == a.f.s2_key_o)
          {
            i = 1;
            break label340;
          }
          i = 0;
          break label340;
          label597:
          if (k == a.f.s2_key_p)
          {
            i = 1;
            break label346;
          }
          i = 0;
          break label346;
          label615:
          if (k == a.f.s2_key_a)
          {
            i = 1;
            break label352;
          }
          i = 0;
          break label352;
          label633:
          if (k == a.f.s2_key_s)
          {
            i = 1;
            break label358;
          }
          i = 0;
          break label358;
          if (k == a.f.s2_key_d)
          {
            i = 1;
            break label364;
          }
          i = 0;
          break label364;
          label669:
          if (k == a.f.s2_key_f)
          {
            i = 1;
            break label370;
          }
          i = 0;
          break label370;
          label687:
          if (k == a.f.s2_key_g)
          {
            i = 1;
            break label376;
          }
          i = 0;
          break label376;
          label705:
          if (k == a.f.s2_key_h)
          {
            i = 1;
            break label382;
          }
          i = 0;
          break label382;
          label723:
          if (k == a.f.s2_key_j)
          {
            i = 1;
            break label388;
          }
          i = 0;
          break label388;
          label741:
          if (k == a.f.s2_key_k)
          {
            i = 1;
            break label394;
          }
          i = 0;
          break label394;
          label759:
          if (k == a.f.s2_key_l)
          {
            i = 1;
            break label400;
          }
          i = 0;
          break label400;
          if (k == a.f.s2_key_z)
          {
            i = 1;
            break label406;
          }
          i = 0;
          break label406;
          label795:
          if (k == a.f.s2_key_x)
          {
            i = 1;
            break label412;
          }
          i = 0;
          break label412;
          label813:
          if (k == a.f.s2_key_c)
          {
            i = 1;
            break label418;
          }
          i = 0;
          break label418;
          label831:
          if (k == a.f.s2_key_v)
          {
            i = 1;
            break label424;
          }
          i = 0;
          break label424;
          label849:
          if (k == a.f.s2_key_b)
          {
            i = 1;
            break label430;
          }
          i = 0;
          break label430;
          label867:
          if (k == a.f.s2_key_n)
          {
            i = 1;
            break label436;
          }
          i = 0;
          break label436;
          label885:
          if (k == a.f.s2_key_m) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (k == a.f.s3_key_q)
        {
          i = 1;
          if (i == 0) {
            break label1086;
          }
          i = 1;
          label919:
          if (i == 0) {
            break label1104;
          }
          i = 1;
          label925:
          if (i == 0) {
            break label1122;
          }
          i = 1;
          label931:
          if (i == 0) {
            break label1140;
          }
          i = 1;
          label937:
          if (i == 0) {
            break label1158;
          }
          i = 1;
          label943:
          if (i == 0) {
            break label1176;
          }
          i = 1;
          label949:
          if (i == 0) {
            break label1194;
          }
          i = 1;
          label955:
          if (i == 0) {
            break label1212;
          }
          i = 1;
          label961:
          if (i == 0) {
            break label1230;
          }
          i = 1;
          label967:
          if (i == 0) {
            break label1248;
          }
          i = 1;
          label973:
          if (i == 0) {
            break label1266;
          }
          i = 1;
          label979:
          if (i == 0) {
            break label1284;
          }
          i = 1;
          label985:
          if (i == 0) {
            break label1302;
          }
          i = 1;
          label991:
          if (i == 0) {
            break label1320;
          }
          i = 1;
          label997:
          if (i == 0) {
            break label1338;
          }
          i = 1;
          label1003:
          if (i == 0) {
            break label1356;
          }
          i = 1;
          label1009:
          if (i == 0) {
            break label1374;
          }
          i = 1;
          label1015:
          if (i == 0) {
            break label1392;
          }
          i = 1;
          label1021:
          if (i == 0) {
            break label1410;
          }
          i = 1;
          if (i == 0) {
            break label1428;
          }
          i = 1;
          if (i == 0) {
            break label1446;
          }
          i = 1;
          if (i == 0) {
            break label1464;
          }
          i = 1;
          label1045:
          if (i == 0) {
            break label1482;
          }
          i = 1;
          label1051:
          if (i == 0) {
            break label1500;
          }
          i = j;
        }
        for (;;)
        {
          if (i == 0) {
            break label1515;
          }
          i = 300;
          break;
          if (k == a.f.s3_key_w)
          {
            i = 1;
            break label913;
          }
          i = 0;
          break label913;
          label1086:
          if (k == a.f.s3_key_e)
          {
            i = 1;
            break label919;
          }
          i = 0;
          break label919;
          label1104:
          if (k == a.f.s3_key_r)
          {
            i = 1;
            break label925;
          }
          i = 0;
          break label925;
          label1122:
          if (k == a.f.s3_key_t)
          {
            i = 1;
            break label931;
          }
          i = 0;
          break label931;
          label1140:
          if (k == a.f.s3_key_y)
          {
            i = 1;
            break label937;
          }
          i = 0;
          break label937;
          if (k == a.f.s3_key_u)
          {
            i = 1;
            break label943;
          }
          i = 0;
          break label943;
          label1176:
          if (k == a.f.s3_key_i)
          {
            i = 1;
            break label949;
          }
          i = 0;
          break label949;
          label1194:
          if (k == a.f.s3_key_o)
          {
            i = 1;
            break label955;
          }
          i = 0;
          break label955;
          label1212:
          if (k == a.f.s3_key_p)
          {
            i = 1;
            break label961;
          }
          i = 0;
          break label961;
          label1230:
          if (k == a.f.s3_key_a)
          {
            i = 1;
            break label967;
          }
          i = 0;
          break label967;
          label1248:
          if (k == a.f.s3_key_s)
          {
            i = 1;
            break label973;
          }
          i = 0;
          break label973;
          label1266:
          if (k == a.f.s3_key_d)
          {
            i = 1;
            break label979;
          }
          i = 0;
          break label979;
          if (k == a.f.s3_key_f)
          {
            i = 1;
            break label985;
          }
          i = 0;
          break label985;
          label1302:
          if (k == a.f.s3_key_g)
          {
            i = 1;
            break label991;
          }
          i = 0;
          break label991;
          label1320:
          if (k == a.f.s3_key_h)
          {
            i = 1;
            break label997;
          }
          i = 0;
          break label997;
          label1338:
          if (k == a.f.s3_key_j)
          {
            i = 1;
            break label1003;
          }
          i = 0;
          break label1003;
          label1356:
          if (k == a.f.s3_key_k)
          {
            i = 1;
            break label1009;
          }
          i = 0;
          break label1009;
          label1374:
          if (k == a.f.s3_key_l)
          {
            i = 1;
            break label1015;
          }
          i = 0;
          break label1015;
          label1392:
          if (k == a.f.s3_key_z)
          {
            i = 1;
            break label1021;
          }
          i = 0;
          break label1021;
          if (k == a.f.s3_key_x)
          {
            i = 1;
            break label1027;
          }
          i = 0;
          break label1027;
          label1428:
          if (k == a.f.s3_key_c)
          {
            i = 1;
            break label1033;
          }
          i = 0;
          break label1033;
          label1446:
          if (k == a.f.s3_key_v)
          {
            i = 1;
            break label1039;
          }
          i = 0;
          break label1039;
          label1464:
          if (k == a.f.s3_key_b)
          {
            i = 1;
            break label1045;
          }
          i = 0;
          break label1045;
          label1482:
          if (k == a.f.s3_key_n)
          {
            i = 1;
            break label1051;
          }
          i = 0;
          break label1051;
          label1500:
          i = j;
          if (k != a.f.s3_key_m) {
            i = 0;
          }
        }
        label1515:
        i = -1;
      }
    }
  }
  
  public static void aK(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(311925);
    if (fMC())
    {
      AppMethodBeat.o(311925);
      return;
    }
    hz localhz = new hz();
    localhz.ipH = paramInt1;
    localhz.iHU = paramInt2;
    localhz.iPp = paramInt3;
    localhz.bMH();
    AppMethodBeat.o(311925);
  }
  
  public static void aK(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(312058);
    a(paramLong1, 0L, paramLong2, 0L, 2L, 0);
    AppMethodBeat.o(312058);
  }
  
  public static void aL(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(311987);
    if (fMC())
    {
      AppMethodBeat.o(311987);
      return;
    }
    if localif = new if();
    localif.ipH = paramInt1;
    localif.iPf = paramInt2;
    localif.iPH = paramInt3;
    localif.bMH();
    AppMethodBeat.o(311987);
  }
  
  public static void aL(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(312064);
    a locala = JvK;
    if (locala != null)
    {
      a(locala.JnG, paramLong1 - locala.JvL, paramLong2, 0L, 2L, 0);
      JvK = null;
    }
    AppMethodBeat.o(312064);
  }
  
  private static final void aM(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(312483);
    Object localObject = (dbv)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_context");
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        Log.e("WxIme.ImeReporter", "getOnlyMemory(addOperation) 10 id_context is null");
      }
      AppMethodBeat.o(312483);
      return;
      dbx localdbx = new dbx();
      localdbx.aaHq = paramInt1;
      localdbx.aaHr = paramInt2;
      localdbx.aaHs = paramInt3;
      ((dbv)localObject).aaHo.addLast(localdbx);
      Log.d("WxIme.ImeReporter", "addOperation " + localdbx.aaHq + ' ' + localdbx.aaHr + ' ' + localdbx.aaHs);
    }
  }
  
  public static void aM(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(312112);
    if (fMC())
    {
      AppMethodBeat.o(312112);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new k..ExternalSyntheticLambda8(paramLong1, paramLong2), "WxIme.ImeReporter");
    AppMethodBeat.o(312112);
  }
  
  public static void aN(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(312116);
    if (fMC())
    {
      AppMethodBeat.o(312116);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new k..ExternalSyntheticLambda9(paramLong1, paramLong2), "WxIme.ImeReporter");
    AppMethodBeat.o(312116);
  }
  
  private static final void aO(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(312414);
    fMz();
    dbs localdbs = (dbs)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
    if (localdbs != null)
    {
      localdbs.aaHe.aaHt = paramLong1;
      localdbs.aaHe.aaHu = paramLong2;
      localdbs.aaHe.aaHv = (paramLong2 - paramLong1);
      localdbs.aaHe.aaHw = true;
    }
    AppMethodBeat.o(312414);
  }
  
  private static final void aP(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(312421);
    dbs localdbs = (dbs)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
    if (localdbs != null)
    {
      localdbs.aaHe.aaHx = paramLong1;
      localdbs.aaHe.aaHy = paramLong2;
      localdbs.aaHe.aaHz = (paramLong2 - paramLong1);
      localdbs.aaHe.aaHA = true;
    }
    AppMethodBeat.o(312421);
  }
  
  public static void an(long paramLong, int paramInt)
  {
    AppMethodBeat.i(312043);
    JvJ = new a(paramLong, paramInt, System.currentTimeMillis());
    AppMethodBeat.o(312043);
  }
  
  public static void ao(long paramLong, int paramInt)
  {
    AppMethodBeat.i(312155);
    com.tencent.threadpool.h.ahAA.g(new k..ExternalSyntheticLambda7(paramLong, paramInt), "WxIme.ImeReporter");
    AppMethodBeat.o(312155);
  }
  
  private static final void ap(long paramLong, int paramInt)
  {
    AppMethodBeat.i(312447);
    dbs localdbs = (dbs)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
    if ((localdbs != null) && (!localdbs.aaHj.aaHN))
    {
      localdbs.aaHj.aaHK = paramLong;
      localdbs.aaHj.sessionType = paramInt;
    }
    AppMethodBeat.o(312447);
  }
  
  private static final void b(m paramm, dbp paramdbp, int paramInt)
  {
    AppMethodBeat.i(312372);
    s.u(paramm, "$downloadStatus");
    im localim = new im();
    localim.iyK = paramm.value;
    localim.iQg = localim.F("DictName", paramdbp.name, true);
    localim.iQh = paramdbp.version;
    localim.iQi = paramdbp.aaGX;
    localim.ivL = paramdbp.KPQ;
    localim.iQj = paramdbp.dataType;
    localim.iQk = paramdbp.oGu;
    localim.iQl = localim.F("CompressedMd5", paramdbp.Znz, true);
    localim.iQm = paramdbp.typeId;
    localim.iQn = localim.F("CdnUrl", paramdbp.mOI, true);
    localim.iQo = localim.F("OriMd5", paramdbp.md5, true);
    localim.iQp = paramdbp.aaGZ;
    localim.inj = paramInt;
    localim.bMH();
    AppMethodBeat.o(312372);
  }
  
  private static final void c(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(312360);
    s.u(paramString, "$extendStr");
    ie localie = new ie();
    localie.iPE = paramInt1;
    localie.imW = paramInt2;
    localie.iPF = paramInt3;
    localie.iPG = localie.F("ExtendStr", paramString, true);
    localie.bMH();
    AppMethodBeat.o(312360);
  }
  
  public static void c(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(312127);
    if (fMC())
    {
      AppMethodBeat.o(312127);
      return;
    }
    long l = System.currentTimeMillis();
    com.tencent.threadpool.h.ahAA.g(new k..ExternalSyntheticLambda11(paramLong1, paramLong2, paramLong3, paramLong4, l), "WxIme.ImeReporter");
    AppMethodBeat.o(312127);
  }
  
  private static final void c(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    AppMethodBeat.i(312439);
    dbs localdbs = (dbs)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
    if ((localdbs != null) && (!localdbs.aaHj.aaHN))
    {
      localdbs.aaHj.aaHG = paramLong1;
      localdbs.aaHj.aaHH = paramLong2;
      localdbs.aaHj.aaHI = paramLong3;
      localdbs.aaHj.aaHJ = paramLong4;
      localdbs.aaHj.aaHO = paramLong5;
      if (!localdbs.aaHj.aaHN)
      {
        int i = 0;
        Object localObject;
        if ((localdbs.aaHj.aaHL == 0L) || (localdbs.aaHj.aaHO == 0L))
        {
          localObject = l.JyV;
          if (l.bGa())
          {
            localObject = com.tencent.mm.plugin.hld.f.i.JyA;
            if (!com.tencent.mm.plugin.hld.f.i.fOo()) {
              break label159;
            }
          }
        }
        i = 1;
        label159:
        if (i != 0)
        {
          localdbs.aaHj.aaHN = true;
          localObject = new ig();
          ((ig)localObject).iPI = localdbs.aaHj.aaHG;
          ((ig)localObject).iPJ = localdbs.aaHj.aaHK;
          ((ig)localObject).iPK = localdbs.aaHj.sessionType;
          ((ig)localObject).iPL = localdbs.aaHj.aaHH;
          ((ig)localObject).iPM = localdbs.aaHj.aaHI;
          ((ig)localObject).iPN = localdbs.aaHj.aaHJ;
          ((ig)localObject).iPO = localdbs.aaHj.aaHL;
          ((ig)localObject).iPP = (localdbs.aaHj.aaHO - localdbs.aaHe.aaHt);
          ((ig)localObject).bMH();
          Log.d("WxIme.ImeReporter", s.X("reportStartRecordNew ", ((ig)localObject).aIF()));
        }
      }
    }
    AppMethodBeat.o(312439);
  }
  
  public static void fMA()
  {
    AppMethodBeat.i(312325);
    if (fMC())
    {
      AppMethodBeat.o(312325);
      return;
    }
    wX(false);
    dbv localdbv;
    if (!fMC())
    {
      localdbv = (dbv)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_context");
      if (localdbv != null) {
        break label102;
      }
    }
    for (Object localObject1 = null;; localObject1 = ah.aiuX)
    {
      if (localObject1 == null) {
        Log.e("WxIme.ImeReporter", "getOnlyMemory(reportUserOperation) 10 id_context is null");
      }
      fMB();
      ((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).removeFromMemory(10, "id_context");
      AppMethodBeat.o(312325);
      return;
      label102:
      localObject1 = localdbv.aaHo;
      s.s(localObject1, "it.operationList");
      int i;
      if (!((Collection)localObject1).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        long l = System.currentTimeMillis();
        localObject1 = new JSONArray();
        Iterator localIterator = localdbv.aaHo.iterator();
        Object localObject2;
        for (;;)
        {
          if (localIterator.hasNext())
          {
            dbx localdbx = (dbx)localIterator.next();
            localObject2 = localObject1;
            if (((JSONArray)localObject1).length() > 100)
            {
              localObject2 = localObject1;
              if (localdbx.aaHs == 0)
              {
                localObject2 = new JSONObject();
                ((JSONObject)localObject2).put("num", ((JSONArray)localObject1).length());
                ((JSONObject)localObject2).put("operationList", localObject1);
                localObject1 = new ii();
                ((ii)localObject1).rL(localdbv.sessionId);
                localObject2 = ((JSONObject)localObject2).toString();
                s.s(localObject2, "result.toString()");
                ((ii)localObject1).rM(kotlin.n.n.bV((String)localObject2, ",", ";"));
                ((ii)localObject1).bMH();
                localObject2 = new JSONArray();
              }
            }
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("area", localdbx.aaHq);
            ((JSONObject)localObject1).put("type", localdbx.aaHr);
            ((JSONObject)localObject1).put("status", localdbx.aaHs);
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
          localObject1 = new ii();
          ((ii)localObject1).rL(localdbv.sessionId);
          localObject2 = ((JSONObject)localObject2).toString();
          s.s(localObject2, "result.toString()");
          ((ii)localObject1).rM(kotlin.n.n.bV((String)localObject2, ",", ";"));
          ((ii)localObject1).bMH();
        }
        Log.i("WxIme.ImeReporter", s.X("reportUserOperation time:", Long.valueOf(System.currentTimeMillis() - l)));
      }
    }
  }
  
  private static void fMB()
  {
    AppMethodBeat.i(312334);
    if (fMC())
    {
      AppMethodBeat.o(312334);
      return;
    }
    dbv localdbv = (dbv)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_context");
    if (localdbv == null) {}
    for (Object localObject1 = null;; localObject1 = ah.aiuX)
    {
      if (localObject1 == null) {
        Log.e("WxIme.ImeReporter", "getOnlyMemory(reportInputToScreenOperation) 10 id_context is null");
      }
      AppMethodBeat.o(312334);
      return;
      localObject1 = localdbv.aaHp;
      s.s(localObject1, "it.inputToScreenOperationList");
      int i;
      if (!((Collection)localObject1).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        System.currentTimeMillis();
        localObject1 = new JSONArray();
        Iterator localIterator = localdbv.aaHp.iterator();
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
              localObject1 = new ib();
              ((ib)localObject1).rJ(localdbv.sessionId);
              localObject2 = ((JSONObject)localObject2).toString();
              s.s(localObject2, "result.toString()");
              ((ib)localObject1).rK(kotlin.n.n.bV((String)localObject2, ",", ";"));
              ((ib)localObject1).bMH();
              localObject2 = new JSONArray();
            }
            localObject1 = new JSONObject();
            s.s(localInteger, "operation");
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
          localObject1 = new ib();
          ((ib)localObject1).rJ(localdbv.sessionId);
          localObject2 = ((JSONObject)localObject2).toString();
          s.s(localObject2, "result.toString()");
          ((ib)localObject1).rK(kotlin.n.n.bV((String)localObject2, ",", ";"));
          ((ib)localObject1).bMH();
        }
      }
    }
  }
  
  public static boolean fMC()
  {
    AppMethodBeat.i(312343);
    o localo = o.Jwm;
    if (o.fNe())
    {
      AppMethodBeat.o(312343);
      return true;
    }
    AppMethodBeat.o(312343);
    return false;
  }
  
  private static final void fMD()
  {
    AppMethodBeat.i(312353);
    Object localObject1 = new hx();
    try
    {
      Object localObject2 = l.JyV;
      ((hx)localObject1).iPh = ((hx)localObject1).F("AppName", l.fPc(), true);
      localObject2 = new StringBuilder();
      a((StringBuilder)localObject2, new String[] { "android.permission.READ_CONTACTS" }, 1);
      a((StringBuilder)localObject2, new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 3);
      a((StringBuilder)localObject2, new String[] { "android.permission.RECORD_AUDIO" }, 4);
      a((StringBuilder)localObject2, new String[] { "android.permission.CAMERA" }, 5);
      a((StringBuilder)localObject2, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 6);
      a((StringBuilder)localObject2, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 7);
      a((StringBuilder)localObject2, new String[] { "android.permission.READ_PHONE_STATE" }, 8);
      a((StringBuilder)localObject2, new String[] { "android.permission.USE_FINGERPRINT" }, 9);
      ((hx)localObject1).iPi = ((hx)localObject1).F("PermissionList", ((StringBuilder)localObject2).toString(), true);
      localObject2 = l.JyV;
      ((hx)localObject1).iPj = l.fPd();
      localObject2 = l.JyV;
      ((hx)localObject1).iPk = l.fPg();
      localObject2 = l.JyV;
      ((hx)localObject1).iPl = l.fPh();
      localObject2 = l.JyV;
      ((hx)localObject1).iPm = ((hx)localObject1).F("CpuInfo", l.fPi(), true);
      ((hx)localObject1).bMH();
      localObject1 = l.JyV;
      localObject1 = l.getKV();
      if (localObject1 != null) {
        ((MultiProcessMMKV)localObject1).putBoolean("ime_if_report_client_environment", true);
      }
      AppMethodBeat.o(312353);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("WxIme.ImeReporter", s.X("getCurIme ", localException.getMessage()));
      }
    }
  }
  
  private static final void fME()
  {
    AppMethodBeat.i(312504);
    com.tencent.mm.plugin.secdata.g localg = (com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class);
    dbv localdbv = new dbv();
    localdbv.sessionId = String.valueOf(System.currentTimeMillis());
    Object localObject = (d)com.tencent.mm.kernel.h.ax(d.class);
    int i;
    if (localObject != null)
    {
      localObject = ((d)localObject).fKG();
      if ((localObject != null) && (((com.tencent.mm.plugin.hld.a.b)localObject).fKx() == true))
      {
        i = 1;
        if (i == 0) {
          break label157;
        }
        localObject = (d)com.tencent.mm.kernel.h.ax(d.class);
        if (localObject != null) {
          break label131;
        }
        i = 5;
      }
    }
    for (;;)
    {
      localdbv.scene = i;
      localObject = ah.aiuX;
      localg.updateOnlyMemory(10, "id_context", (a)localdbv);
      wX(true);
      AppMethodBeat.o(312504);
      return;
      i = 0;
      break;
      label131:
      localObject = ((d)localObject).fKG();
      if (localObject == null)
      {
        i = 5;
      }
      else
      {
        i = ((com.tencent.mm.plugin.hld.a.b)localObject).fKz();
        continue;
        label157:
        i = 0;
      }
    }
  }
  
  public static void fMy()
  {
    int i = 1;
    AppMethodBeat.i(312008);
    if (fMC())
    {
      AppMethodBeat.o(312008);
      return;
    }
    Object localObject = l.JyV;
    localObject = l.getKV();
    if ((localObject != null) && (((MultiProcessMMKV)localObject).getBoolean("ime_if_report_client_environment", false) == true)) {}
    while (i != 0)
    {
      AppMethodBeat.o(312008);
      return;
      i = 0;
    }
    com.tencent.threadpool.h.ahAA.bm(k..ExternalSyntheticLambda14.INSTANCE);
    AppMethodBeat.o(312008);
  }
  
  private static void fMz()
  {
    AppMethodBeat.i(312173);
    if (fMC())
    {
      AppMethodBeat.o(312173);
      return;
    }
    if (JvI)
    {
      AppMethodBeat.o(312173);
      return;
    }
    JvI = true;
    com.tencent.mm.plugin.secdata.g localg = (com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class);
    dbs localdbs = new dbs();
    Object localObject = new dbz();
    ((dbz)localObject).aaHt = 0L;
    ((dbz)localObject).aaHu = 0L;
    ((dbz)localObject).aaHv = 0L;
    ((dbz)localObject).aaHw = false;
    ((dbz)localObject).aaHx = 0L;
    ((dbz)localObject).aaHy = 0L;
    ((dbz)localObject).aaHz = 0L;
    ((dbz)localObject).aaHA = false;
    ((dbz)localObject).aaHB = 0L;
    ((dbz)localObject).aaHC = 0L;
    ((dbz)localObject).aaHD = 0L;
    ((dbz)localObject).aaHE = 0L;
    ah localah = ah.aiuX;
    localdbs.aaHe = ((dbz)localObject);
    localObject = new dca();
    ((dca)localObject).aaHG = 0L;
    ((dca)localObject).aaHH = 0L;
    ((dca)localObject).aaHI = 0L;
    ((dca)localObject).aaHJ = 0L;
    ((dca)localObject).aaHK = 0L;
    ((dca)localObject).sessionType = 0;
    ((dca)localObject).aaHL = 0L;
    ((dca)localObject).hqS = 0L;
    ((dca)localObject).aaHM = 0L;
    localah = ah.aiuX;
    localdbs.aaHj = ((dca)localObject);
    localdbs.aaHf = 0L;
    localdbs.aaHg = 0L;
    localdbs.aaHh = 0L;
    localdbs.aaHi = 1;
    localObject = ah.aiuX;
    localg.updateOnlyMemory(10, "id_performance", (a)localdbs);
    AppMethodBeat.o(312173);
  }
  
  public static void hR(View paramView)
  {
    AppMethodBeat.i(312197);
    if (fMC())
    {
      AppMethodBeat.o(312197);
      return;
    }
    if (paramView == null)
    {
      paramView = null;
      if (paramView == null) {
        Log.e("WxIme.ImeReporter", s.X("addT9Operation v is null.", Util.getStack()));
      }
      AppMethodBeat.o(312197);
      return;
    }
    int j = paramView.getId();
    int i;
    if (j == a.f.t9_key1)
    {
      i = 1;
      label65:
      if (i == 0) {
        break label143;
      }
      i = 1;
      label71:
      if (i == 0) {
        break label160;
      }
      i = 1;
      label77:
      if (i == 0) {
        break label177;
      }
      i = 1;
      label83:
      if (i == 0) {
        break label194;
      }
      i = 1;
      label89:
      if (i == 0) {
        break label211;
      }
      i = 1;
      label95:
      if (i == 0) {
        break label228;
      }
      i = 1;
      label101:
      if (i == 0) {
        break label245;
      }
      i = 1;
      label107:
      if (i == 0) {
        break label262;
      }
      i = 100;
    }
    label386:
    for (;;)
    {
      js(i, 1);
      paramView = ah.aiuX;
      break;
      if (j == a.f.t9_key2)
      {
        i = 1;
        break label65;
      }
      i = 0;
      break label65;
      label143:
      if (j == a.f.t9_key3)
      {
        i = 1;
        break label71;
      }
      i = 0;
      break label71;
      label160:
      if (j == a.f.t9_key4)
      {
        i = 1;
        break label77;
      }
      i = 0;
      break label77;
      label177:
      if (j == a.f.t9_key5)
      {
        i = 1;
        break label83;
      }
      i = 0;
      break label83;
      label194:
      if (j == a.f.t9_key6)
      {
        i = 1;
        break label89;
      }
      i = 0;
      break label89;
      label211:
      if (j == a.f.t9_key7)
      {
        i = 1;
        break label95;
      }
      i = 0;
      break label95;
      label228:
      if (j == a.f.t9_key8)
      {
        i = 1;
        break label101;
      }
      i = 0;
      break label101;
      label245:
      if (j == a.f.t9_key9)
      {
        i = 1;
        break label107;
      }
      i = 0;
      break label107;
      label262:
      if (j == a.f.t9_key_number)
      {
        i = 103;
      }
      else if (j == a.f.t9_key_space)
      {
        i = 104;
      }
      else if (j == a.f.t9_key_exchange)
      {
        i = 105;
      }
      else if (j == a.f.t9_key_new_line)
      {
        i = 108;
      }
      else if (j == a.f.t9_key_clear)
      {
        i = 107;
      }
      else if (j == a.f.t9_key_action)
      {
        paramView = (d)com.tencent.mm.kernel.h.ax(d.class);
        if (paramView != null)
        {
          paramView = paramView.fKG();
          if ((paramView == null) || (paramView.fKr() != true)) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label386;
          }
          i = 108;
          break;
        }
        i = 109;
      }
      else
      {
        i = -1;
      }
    }
  }
  
  public static void hS(View paramView)
  {
    AppMethodBeat.i(312220);
    if (fMC())
    {
      AppMethodBeat.o(312220);
      return;
    }
    if (paramView == null)
    {
      paramView = null;
      if (paramView == null) {
        Log.e("WxIme.ImeReporter", s.X("addChineseQwertyOperation v is null.", Util.getStack()));
      }
      AppMethodBeat.o(312220);
      return;
    }
    int j = paramView.getId();
    int i;
    if (j == a.f.s2_key_q)
    {
      i = 1;
      label65:
      if (i == 0) {
        break label246;
      }
      i = 1;
      label71:
      if (i == 0) {
        break label263;
      }
      i = 1;
      label77:
      if (i == 0) {
        break label280;
      }
      i = 1;
      label83:
      if (i == 0) {
        break label297;
      }
      i = 1;
      label89:
      if (i == 0) {
        break label314;
      }
      i = 1;
      label95:
      if (i == 0) {
        break label331;
      }
      i = 1;
      label101:
      if (i == 0) {
        break label348;
      }
      i = 1;
      label107:
      if (i == 0) {
        break label365;
      }
      i = 1;
      label113:
      if (i == 0) {
        break label382;
      }
      i = 1;
      label119:
      if (i == 0) {
        break label399;
      }
      i = 1;
      label125:
      if (i == 0) {
        break label416;
      }
      i = 1;
      label131:
      if (i == 0) {
        break label433;
      }
      i = 1;
      label137:
      if (i == 0) {
        break label450;
      }
      i = 1;
      label143:
      if (i == 0) {
        break label467;
      }
      i = 1;
      label149:
      if (i == 0) {
        break label484;
      }
      i = 1;
      label155:
      if (i == 0) {
        break label501;
      }
      i = 1;
      label161:
      if (i == 0) {
        break label518;
      }
      i = 1;
      label167:
      if (i == 0) {
        break label535;
      }
      i = 1;
      label173:
      if (i == 0) {
        break label552;
      }
      i = 1;
      label179:
      if (i == 0) {
        break label569;
      }
      i = 1;
      label185:
      if (i == 0) {
        break label586;
      }
      i = 1;
      label191:
      if (i == 0) {
        break label603;
      }
      i = 1;
      label197:
      if (i == 0) {
        break label620;
      }
      i = 1;
      label203:
      if (i == 0) {
        break label637;
      }
      i = 1;
      label209:
      if (i == 0) {
        break label654;
      }
      i = 200;
    }
    for (;;)
    {
      js(i, 1);
      paramView = ah.aiuX;
      break;
      if (j == a.f.s2_key_w)
      {
        i = 1;
        break label65;
      }
      i = 0;
      break label65;
      label246:
      if (j == a.f.s2_key_e)
      {
        i = 1;
        break label71;
      }
      i = 0;
      break label71;
      label263:
      if (j == a.f.s2_key_r)
      {
        i = 1;
        break label77;
      }
      i = 0;
      break label77;
      label280:
      if (j == a.f.s2_key_t)
      {
        i = 1;
        break label83;
      }
      i = 0;
      break label83;
      label297:
      if (j == a.f.s2_key_y)
      {
        i = 1;
        break label89;
      }
      i = 0;
      break label89;
      label314:
      if (j == a.f.s2_key_u)
      {
        i = 1;
        break label95;
      }
      i = 0;
      break label95;
      label331:
      if (j == a.f.s2_key_i)
      {
        i = 1;
        break label101;
      }
      i = 0;
      break label101;
      label348:
      if (j == a.f.s2_key_o)
      {
        i = 1;
        break label107;
      }
      i = 0;
      break label107;
      label365:
      if (j == a.f.s2_key_p)
      {
        i = 1;
        break label113;
      }
      i = 0;
      break label113;
      label382:
      if (j == a.f.s2_key_a)
      {
        i = 1;
        break label119;
      }
      i = 0;
      break label119;
      label399:
      if (j == a.f.s2_key_s)
      {
        i = 1;
        break label125;
      }
      i = 0;
      break label125;
      label416:
      if (j == a.f.s2_key_d)
      {
        i = 1;
        break label131;
      }
      i = 0;
      break label131;
      label433:
      if (j == a.f.s2_key_f)
      {
        i = 1;
        break label137;
      }
      i = 0;
      break label137;
      label450:
      if (j == a.f.s2_key_g)
      {
        i = 1;
        break label143;
      }
      i = 0;
      break label143;
      label467:
      if (j == a.f.s2_key_h)
      {
        i = 1;
        break label149;
      }
      i = 0;
      break label149;
      label484:
      if (j == a.f.s2_key_j)
      {
        i = 1;
        break label155;
      }
      i = 0;
      break label155;
      label501:
      if (j == a.f.s2_key_k)
      {
        i = 1;
        break label161;
      }
      i = 0;
      break label161;
      label518:
      if (j == a.f.s2_key_l)
      {
        i = 1;
        break label167;
      }
      i = 0;
      break label167;
      label535:
      if (j == a.f.s2_key_z)
      {
        i = 1;
        break label173;
      }
      i = 0;
      break label173;
      label552:
      if (j == a.f.s2_key_x)
      {
        i = 1;
        break label179;
      }
      i = 0;
      break label179;
      label569:
      if (j == a.f.s2_key_c)
      {
        i = 1;
        break label185;
      }
      i = 0;
      break label185;
      label586:
      if (j == a.f.s2_key_v)
      {
        i = 1;
        break label191;
      }
      i = 0;
      break label191;
      label603:
      if (j == a.f.s2_key_b)
      {
        i = 1;
        break label197;
      }
      i = 0;
      break label197;
      label620:
      if (j == a.f.s2_key_n)
      {
        i = 1;
        break label203;
      }
      i = 0;
      break label203;
      label637:
      if (j == a.f.s2_key_m)
      {
        i = 1;
        break label209;
      }
      i = 0;
      break label209;
      label654:
      if (j == a.f.s2_key_symbol)
      {
        i = 204;
      }
      else if (j == a.f.s2_key_number)
      {
        i = 205;
      }
      else if (j == a.f.s2_key_comma)
      {
        i = 202;
      }
      else if (j == a.f.s2_key_space)
      {
        i = 206;
      }
      else if (j == a.f.s2_key_at)
      {
        i = 203;
      }
      else if (j == a.f.s2_key_exchange)
      {
        i = 207;
      }
      else if (j == a.f.s2_key_action)
      {
        paramView = (d)com.tencent.mm.kernel.h.ax(d.class);
        if (paramView != null)
        {
          paramView = paramView.fKG();
          if ((paramView == null) || (paramView.fKr() != true)) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label798;
          }
          i = 209;
          break;
        }
        label798:
        i = 210;
      }
      else
      {
        i = -1;
      }
    }
  }
  
  public static void hT(View paramView)
  {
    AppMethodBeat.i(312244);
    if (fMC())
    {
      AppMethodBeat.o(312244);
      return;
    }
    if (paramView == null)
    {
      paramView = null;
      if (paramView == null) {
        Log.e("WxIme.ImeReporter", s.X("addEnglishQwertyOperation v is null.", Util.getStack()));
      }
      AppMethodBeat.o(312244);
      return;
    }
    int j = paramView.getId();
    int i;
    if (j == a.f.s3_key_q)
    {
      i = 1;
      label65:
      if (i == 0) {
        break label246;
      }
      i = 1;
      label71:
      if (i == 0) {
        break label263;
      }
      i = 1;
      label77:
      if (i == 0) {
        break label280;
      }
      i = 1;
      label83:
      if (i == 0) {
        break label297;
      }
      i = 1;
      label89:
      if (i == 0) {
        break label314;
      }
      i = 1;
      label95:
      if (i == 0) {
        break label331;
      }
      i = 1;
      label101:
      if (i == 0) {
        break label348;
      }
      i = 1;
      label107:
      if (i == 0) {
        break label365;
      }
      i = 1;
      label113:
      if (i == 0) {
        break label382;
      }
      i = 1;
      label119:
      if (i == 0) {
        break label399;
      }
      i = 1;
      label125:
      if (i == 0) {
        break label416;
      }
      i = 1;
      label131:
      if (i == 0) {
        break label433;
      }
      i = 1;
      label137:
      if (i == 0) {
        break label450;
      }
      i = 1;
      label143:
      if (i == 0) {
        break label467;
      }
      i = 1;
      label149:
      if (i == 0) {
        break label484;
      }
      i = 1;
      label155:
      if (i == 0) {
        break label501;
      }
      i = 1;
      label161:
      if (i == 0) {
        break label518;
      }
      i = 1;
      label167:
      if (i == 0) {
        break label535;
      }
      i = 1;
      label173:
      if (i == 0) {
        break label552;
      }
      i = 1;
      label179:
      if (i == 0) {
        break label569;
      }
      i = 1;
      label185:
      if (i == 0) {
        break label586;
      }
      i = 1;
      label191:
      if (i == 0) {
        break label603;
      }
      i = 1;
      label197:
      if (i == 0) {
        break label620;
      }
      i = 1;
      label203:
      if (i == 0) {
        break label637;
      }
      i = 1;
      label209:
      if (i == 0) {
        break label654;
      }
      i = 300;
    }
    for (;;)
    {
      js(i, 1);
      paramView = ah.aiuX;
      break;
      if (j == a.f.s3_key_w)
      {
        i = 1;
        break label65;
      }
      i = 0;
      break label65;
      label246:
      if (j == a.f.s3_key_e)
      {
        i = 1;
        break label71;
      }
      i = 0;
      break label71;
      label263:
      if (j == a.f.s3_key_r)
      {
        i = 1;
        break label77;
      }
      i = 0;
      break label77;
      label280:
      if (j == a.f.s3_key_t)
      {
        i = 1;
        break label83;
      }
      i = 0;
      break label83;
      label297:
      if (j == a.f.s3_key_y)
      {
        i = 1;
        break label89;
      }
      i = 0;
      break label89;
      label314:
      if (j == a.f.s3_key_u)
      {
        i = 1;
        break label95;
      }
      i = 0;
      break label95;
      label331:
      if (j == a.f.s3_key_i)
      {
        i = 1;
        break label101;
      }
      i = 0;
      break label101;
      label348:
      if (j == a.f.s3_key_o)
      {
        i = 1;
        break label107;
      }
      i = 0;
      break label107;
      label365:
      if (j == a.f.s3_key_p)
      {
        i = 1;
        break label113;
      }
      i = 0;
      break label113;
      label382:
      if (j == a.f.s3_key_a)
      {
        i = 1;
        break label119;
      }
      i = 0;
      break label119;
      label399:
      if (j == a.f.s3_key_s)
      {
        i = 1;
        break label125;
      }
      i = 0;
      break label125;
      label416:
      if (j == a.f.s3_key_d)
      {
        i = 1;
        break label131;
      }
      i = 0;
      break label131;
      label433:
      if (j == a.f.s3_key_f)
      {
        i = 1;
        break label137;
      }
      i = 0;
      break label137;
      label450:
      if (j == a.f.s3_key_g)
      {
        i = 1;
        break label143;
      }
      i = 0;
      break label143;
      label467:
      if (j == a.f.s3_key_h)
      {
        i = 1;
        break label149;
      }
      i = 0;
      break label149;
      label484:
      if (j == a.f.s3_key_j)
      {
        i = 1;
        break label155;
      }
      i = 0;
      break label155;
      label501:
      if (j == a.f.s3_key_k)
      {
        i = 1;
        break label161;
      }
      i = 0;
      break label161;
      label518:
      if (j == a.f.s3_key_l)
      {
        i = 1;
        break label167;
      }
      i = 0;
      break label167;
      label535:
      if (j == a.f.s3_key_z)
      {
        i = 1;
        break label173;
      }
      i = 0;
      break label173;
      label552:
      if (j == a.f.s3_key_x)
      {
        i = 1;
        break label179;
      }
      i = 0;
      break label179;
      label569:
      if (j == a.f.s3_key_c)
      {
        i = 1;
        break label185;
      }
      i = 0;
      break label185;
      label586:
      if (j == a.f.s3_key_v)
      {
        i = 1;
        break label191;
      }
      i = 0;
      break label191;
      label603:
      if (j == a.f.s3_key_b)
      {
        i = 1;
        break label197;
      }
      i = 0;
      break label197;
      label620:
      if (j == a.f.s3_key_n)
      {
        i = 1;
        break label203;
      }
      i = 0;
      break label203;
      label637:
      if (j == a.f.s3_key_m)
      {
        i = 1;
        break label209;
      }
      i = 0;
      break label209;
      label654:
      if (j == a.f.s3_key_symbol)
      {
        i = 304;
      }
      else if (j == a.f.s3_key_number)
      {
        i = 305;
      }
      else if (j == a.f.s3_key_comma)
      {
        i = 302;
      }
      else if (j == a.f.s3_key_space)
      {
        i = 306;
      }
      else if (j == a.f.s3_key_at)
      {
        i = 303;
      }
      else if (j == a.f.s3_key_exchange)
      {
        i = 307;
      }
      else if (j == a.f.s3_key_action)
      {
        paramView = (d)com.tencent.mm.kernel.h.ax(d.class);
        if (paramView != null)
        {
          paramView = paramView.fKG();
          if ((paramView == null) || (paramView.fKr() != true)) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label798;
          }
          i = 309;
          break;
        }
        label798:
        i = 310;
      }
      else
      {
        i = -1;
      }
    }
  }
  
  public static void hU(View paramView)
  {
    AppMethodBeat.i(312261);
    if (fMC())
    {
      AppMethodBeat.o(312261);
      return;
    }
    if (paramView == null)
    {
      paramView = null;
      if (paramView == null) {
        Log.e("WxIme.ImeReporter", s.X("addNumberOperation v is null.", Util.getStack()));
      }
      AppMethodBeat.o(312261);
      return;
    }
    int j = paramView.getId();
    int i;
    if (j == a.f.s4_key_1)
    {
      i = 1;
      label65:
      if (i == 0) {
        break label150;
      }
      i = 1;
      label71:
      if (i == 0) {
        break label167;
      }
      i = 1;
      label77:
      if (i == 0) {
        break label184;
      }
      i = 1;
      label83:
      if (i == 0) {
        break label201;
      }
      i = 1;
      label89:
      if (i == 0) {
        break label218;
      }
      i = 1;
      label95:
      if (i == 0) {
        break label235;
      }
      i = 1;
      label101:
      if (i == 0) {
        break label252;
      }
      i = 1;
      label107:
      if (i == 0) {
        break label269;
      }
      i = 1;
      label113:
      if (i == 0) {
        break label286;
      }
      i = 400;
    }
    label269:
    label402:
    for (;;)
    {
      js(i, 1);
      paramView = ah.aiuX;
      break;
      if (j == a.f.s4_key_2)
      {
        i = 1;
        break label65;
      }
      i = 0;
      break label65;
      label150:
      if (j == a.f.s4_key_3)
      {
        i = 1;
        break label71;
      }
      i = 0;
      break label71;
      label167:
      if (j == a.f.s4_key_4)
      {
        i = 1;
        break label77;
      }
      i = 0;
      break label77;
      label184:
      if (j == a.f.s4_key_5)
      {
        i = 1;
        break label83;
      }
      i = 0;
      break label83;
      label201:
      if (j == a.f.s4_key_6)
      {
        i = 1;
        break label89;
      }
      i = 0;
      break label89;
      label218:
      if (j == a.f.s4_key_7)
      {
        i = 1;
        break label95;
      }
      i = 0;
      break label95;
      label235:
      if (j == a.f.s4_key_8)
      {
        i = 1;
        break label101;
      }
      i = 0;
      break label101;
      label252:
      if (j == a.f.s4_key_9)
      {
        i = 1;
        break label107;
      }
      i = 0;
      break label107;
      if (j == a.f.s4_key_0)
      {
        i = 1;
        break label113;
      }
      i = 0;
      break label113;
      label286:
      if (j == a.f.s4_key_space)
      {
        i = 405;
      }
      else if (j == a.f.s4_key_back)
      {
        i = 403;
      }
      else if (j == a.f.s4_key_at)
      {
        i = 406;
      }
      else if (j == a.f.s4_key_dot)
      {
        i = 408;
      }
      else if (j == a.f.s4_key_action)
      {
        paramView = (d)com.tencent.mm.kernel.h.ax(d.class);
        if (paramView != null)
        {
          paramView = paramView.fKG();
          if ((paramView == null) || (paramView.fKr() != true)) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label402;
          }
          i = 407;
          break;
        }
        i = 409;
      }
      else
      {
        i = -1;
      }
    }
  }
  
  public static void il(Context paramContext)
  {
    AppMethodBeat.i(312308);
    s.u(paramContext, "context");
    if (fMC())
    {
      AppMethodBeat.o(312308);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(k..ExternalSyntheticLambda15.INSTANCE, "WxIme.ImeReporter");
    AppMethodBeat.o(312308);
  }
  
  public static void jq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(311943);
    if (fMC())
    {
      AppMethodBeat.o(311943);
      return;
    }
    ia localia = new ia();
    localia.iPq = paramInt1;
    localia.iPr = paramInt2;
    localia.bMH();
    AppMethodBeat.o(311943);
  }
  
  public static void jr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(311978);
    if (fMC())
    {
      AppMethodBeat.o(311978);
      return;
    }
    hw localhw = new hw();
    dbv localdbv = (dbv)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_context");
    if (localdbv != null) {
      localhw.ijk = localhw.F("SessionId", localdbv.sessionId, true);
    }
    localhw.iPf = paramInt1;
    localhw.iPg = paramInt2;
    localhw.bMH();
    AppMethodBeat.o(311978);
  }
  
  public static void js(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(312186);
    if (fMC())
    {
      AppMethodBeat.o(312186);
      return;
    }
    n localn = n.JvW;
    if (n.fMH()) {}
    for (int i = 0;; i = 1)
    {
      com.tencent.threadpool.h.ahAA.g(new k..ExternalSyntheticLambda1(paramInt1, paramInt2, i), "WxIme.ImeReporter");
      AppMethodBeat.o(312186);
      return;
    }
  }
  
  public static void k(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(312161);
    if (fMC())
    {
      AppMethodBeat.o(312161);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new k..ExternalSyntheticLambda10(paramLong1, paramLong2, paramInt), "WxIme.ImeReporter");
    AppMethodBeat.o(312161);
  }
  
  private static final void l(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(312475);
    dbs localdbs = (dbs)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
    ih localih;
    dbz localdbz;
    if (localdbs != null)
    {
      localdbs.aaHe.aaHC = paramLong1;
      localdbs.aaHe.aaHD = paramLong2;
      localdbs.aaHe.aaHE = (paramLong2 - paramLong1);
      localdbs.aaHe.aaHF = paramInt;
      localih = new ih();
      localih.iPV = localdbs.aaHi;
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("imeProcessServiceTimestamp", localdbs.aaHf);
      ((JSONObject)localObject1).put("imeSettingUITimestamp", localdbs.aaHg);
      ((JSONObject)localObject1).put("imePrivacySettingUITimestamp", localdbs.aaHh);
      localdbz = localdbs.aaHe;
      ((JSONObject)localObject1).put("imeServiceCreateStartTimestamp", localdbz.aaHt);
      ((JSONObject)localObject1).put("windowShowKeyboard", localdbz.aaHF);
      if ((localdbz.aaHw) && (localdbz.aaHA))
      {
        localih.iPR = 0;
        Object localObject2 = com.tencent.mm.kernel.i.baI().baB().bad().mFH;
        localih.iPS = (((g.a)localObject2).mFR - ((g.a)localObject2).mFI);
        localih.iPT = (localdbz.aaHv + localdbz.aaHz + localdbz.aaHD - localdbz.aaHB);
        localih.iPU = (localih.iPS + localih.iPT);
        Log.i("WxIme.ImeReporter", "PerformanceRecorder preInitTimestamp:" + ((g.a)localObject2).mFI + " initTimestamp:" + ((g.a)localObject2).mFJ + " helloTimestamp:" + ((g.a)localObject2).mFK + " installTimestamp:" + ((g.a)localObject2).mFL + " dependencyTimestamp:" + ((g.a)localObject2).mFM + " configurationTimestamp:" + ((g.a)localObject2).mFN + " executionTimestamp:" + ((g.a)localObject2).mFO + " extensionsTimestamp:" + ((g.a)localObject2).mFP + " terminateTimestamp:" + ((g.a)localObject2).mFQ + " initFinishTimestamp:" + ((g.a)localObject2).mFR + ' ');
        Log.i("WxIme.ImeReporter", "reportStartRecord onCreate:" + localdbz.aaHv + " startInput:" + localdbz.aaHz);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("createStartTimestamp", localdbz.aaHt);
        ((JSONObject)localObject2).put("createEndTimestamp", localdbz.aaHu);
        ((JSONObject)localObject2).put("createDiffTime", localdbz.aaHv);
        ((JSONObject)localObject2).put("isFirstEdit", localdbz.aaHw);
        ((JSONObject)localObject2).put("startInputTimestamp", localdbz.aaHx);
        ((JSONObject)localObject2).put("startInputEndTimestamp", localdbz.aaHy);
        ((JSONObject)localObject2).put("startInputDiffTimestamp", localdbz.aaHz);
        ((JSONObject)localObject2).put("isEditFirstShow", localdbz.aaHA);
        ((JSONObject)localObject2).put("startInputViewTimestamp", localdbz.aaHB);
        ((JSONObject)localObject2).put("windowShowTimestamp", localdbz.aaHC);
        ((JSONObject)localObject2).put("windowShowEndTimestamp", localdbz.aaHD);
        ((JSONObject)localObject2).put("windowShowDiffTimestamp", localdbz.aaHE);
        ((JSONObject)localObject1).put("ImeServicePerformanceRecord", localObject2);
        Log.i("WxIme.ImeReporter", "reportStartRecord startReason:" + localdbs.aaHi + " startType:" + localih.iPR + " processTime:" + localih.iPS + " businessTime:" + localih.iPT + " allTime:" + localih.iPU + " windowShowTime:" + localdbz.aaHE + " isEditFirstShow:" + localdbz.aaHA + " (" + localdbz.aaHz + ", " + localdbz.aaHC + '-' + localdbz.aaHD + ')');
        localObject1 = ((JSONObject)localObject1).toString();
        s.s(localObject1, "extendStrJs.toString()");
        localih.iPG = localih.F("ExtendStr", kotlin.n.n.bV((String)localObject1, ",", ";"), true);
        localih.bMH();
        Log.d("WxIme.ImeReporter", s.X("reportStartRecord ", localih.aIF()));
        localdbs.aaHe.aaHw = false;
        localdbs.aaHe.aaHA = false;
      }
    }
    else
    {
      AppMethodBeat.o(312475);
      return;
    }
    localih.iPR = 1;
    localih.iPS = 0L;
    if (localdbz.aaHA) {}
    for (localih.iPT = (localdbz.aaHD - localdbz.aaHB + localdbz.aaHz);; localih.iPT = (localdbz.aaHD - localdbz.aaHB))
    {
      localih.iPU = localih.iPT;
      break;
    }
  }
  
  public static void l(com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(312204);
    s.u(paramb, "btn");
    if (fMC())
    {
      AppMethodBeat.o(312204);
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
      js(i, 1);
      AppMethodBeat.o(312204);
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
      paramb = (d)com.tencent.mm.kernel.h.ax(d.class);
      if (paramb != null)
      {
        paramb = paramb.fKG();
        if ((paramb == null) || (paramb.fKr() != true)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label829;
        }
        i = 209;
        break label310;
        if (!paramb.equals("cnSwitch")) {
          break;
        }
        i = 207;
        break label310;
        if (!paramb.equals("S2_key_i")) {
          break;
        }
        for (;;)
        {
          i = 200;
          break label310;
          if (!paramb.equals("S2_key_h"))
          {
            break;
            if (!paramb.equals("S2_key_k"))
            {
              break;
              if (!paramb.equals("S2_key_j"))
              {
                break;
                if (!paramb.equals("S2_key_m"))
                {
                  break;
                  if (!paramb.equals("S2_key_l"))
                  {
                    break;
                    if (!paramb.equals("S2_key_o"))
                    {
                      break;
                      if (!paramb.equals("S2_key_n"))
                      {
                        break;
                        if (!paramb.equals("S2_key_a"))
                        {
                          break;
                          if (!paramb.equals("S2_key_c"))
                          {
                            break;
                            if (!paramb.equals("S2_key_b"))
                            {
                              break;
                              if (!paramb.equals("S2_key_e"))
                              {
                                break;
                                if (!paramb.equals("S2_key_d"))
                                {
                                  break;
                                  if (!paramb.equals("S2_key_g"))
                                  {
                                    break;
                                    if (!paramb.equals("S2_key_f"))
                                    {
                                      break;
                                      if (!paramb.equals("S2_key_y"))
                                      {
                                        break;
                                        if (!paramb.equals("S2_key_x"))
                                        {
                                          break;
                                          if (!paramb.equals("S2_key_z"))
                                          {
                                            if ((goto 308) || (!paramb.equals("at"))) {
                                              break;
                                            }
                                            i = 203;
                                            break label310;
                                            if (!paramb.equals("S2_key_q"))
                                            {
                                              break;
                                              if (!paramb.equals("S2_key_p"))
                                              {
                                                break;
                                                if (!paramb.equals("S2_key_s"))
                                                {
                                                  break;
                                                  if (!paramb.equals("S2_key_r"))
                                                  {
                                                    break;
                                                    if (!paramb.equals("S2_key_u"))
                                                    {
                                                      break;
                                                      if (!paramb.equals("S2_key_t"))
                                                      {
                                                        break;
                                                        if (!paramb.equals("S2_key_w")) {
                                                          if ((goto 308) || (!paramb.equals("S2_key_v"))) {
                                                            break;
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label829:
      i = 210;
    }
  }
  
  public static void m(com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(312231);
    s.u(paramb, "btn");
    if (fMC())
    {
      AppMethodBeat.o(312231);
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
      js(i, 1);
      AppMethodBeat.o(312231);
      return;
      if (!paramb.equals("S3_key_n")) {
        break;
      }
      label332:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              do
                                              {
                                                i = 300;
                                                break;
                                              } while (paramb.equals("S3_key_m"));
                                              if ((goto 308) || (!paramb.equals("symbol"))) {
                                                break;
                                              }
                                              i = 304;
                                              break label310;
                                            } while (paramb.equals("S3_key_l"));
                                            break;
                                          } while (paramb.equals("S3_key_k"));
                                          break;
                                        } while (paramb.equals("S3_key_j"));
                                        break;
                                      } while (paramb.equals("S3_key_i"));
                                      break;
                                    } while (paramb.equals("S3_key_h"));
                                    break;
                                  } while (paramb.equals("S3_key_g"));
                                  if ((goto 308) || (!paramb.equals("num"))) {
                                    break;
                                  }
                                  i = 305;
                                  break label310;
                                } while (paramb.equals("S3_key_f"));
                                if ((goto 308) || (!paramb.equals("dot"))) {
                                  break;
                                }
                                i = 302;
                                break label310;
                              } while (paramb.equals("S3_key_e"));
                              break;
                            } while (paramb.equals("S3_key_d"));
                            break;
                          } while (paramb.equals("S3_key_c"));
                          break;
                        } while (paramb.equals("S3_key_b"));
                        break;
                      } while (paramb.equals("S3_key_a"));
                      if ((goto 308) || (!paramb.equals("space"))) {
                        break;
                      }
                      i = 306;
                      break label310;
                    } while (paramb.equals("S3_key_z"));
                    break;
                  } while (paramb.equals("S3_key_y"));
                  break;
                } while (paramb.equals("S3_key_x"));
                break;
              } while (paramb.equals("S3_key_w"));
              break;
            } while (paramb.equals("S3_key_v"));
            break;
          } while (paramb.equals("S3_key_u"));
          if ((goto 308) || (!paramb.equals("enSwitch"))) {
            break;
          }
          i = 307;
          break label310;
        } while (paramb.equals("S3_key_t"));
        break;
      } while (paramb.equals("S3_key_s"));
      if ((goto 308) || (!paramb.equals("enter"))) {
        break;
      }
      paramb = (d)com.tencent.mm.kernel.h.ax(d.class);
      if (paramb != null)
      {
        paramb = paramb.fKG();
        if ((paramb == null) || (paramb.fKr() != true)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label829;
        }
        i = 309;
        break label310;
        if (paramb.equals("S3_key_r")) {
          break label332;
        }
        break;
        if (paramb.equals("S3_key_q")) {
          break label332;
        }
        break;
        if (paramb.equals("S3_key_p")) {
          break label332;
        }
        break;
        if (paramb.equals("S3_key_o")) {
          break label332;
        }
        if ((goto 308) || (!paramb.equals("at"))) {
          break;
        }
        i = 303;
        break label310;
      }
      label829:
      i = 310;
    }
  }
  
  public static void n(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(312049);
    a locala = JvJ;
    if (locala != null)
    {
      a(locala.JnG, paramLong1 - locala.JvL, paramLong2, paramLong3, 1L, locala.keyType);
      JvJ = null;
    }
    AppMethodBeat.o(312049);
  }
  
  public static void n(com.tencent.mm.plugin.hld.keyboard.selfdraw.b paramb)
  {
    AppMethodBeat.i(312250);
    s.u(paramb, "btn");
    if (fMC())
    {
      AppMethodBeat.o(312250);
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
      js(i, 1);
      AppMethodBeat.o(312250);
      return;
      if (!paramb.equals("S4_key_3")) {
        break;
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        i = 400;
                        break;
                      } while (paramb.equals("S4_key_2"));
                      break;
                    } while (paramb.equals("S4_key_5"));
                    break;
                  } while (paramb.equals("S4_key_4"));
                  break;
                } while (paramb.equals("S4_key_1"));
                break;
              } while (paramb.equals("S4_key_0"));
              if ((goto 164) || (!paramb.equals("dot"))) {
                break;
              }
              i = 408;
              break label166;
              if (!paramb.equals("back")) {
                break;
              }
              i = 403;
              break label166;
            } while (paramb.equals("S4_key_7"));
            break;
          } while (paramb.equals("S4_key_6"));
          break;
        } while (paramb.equals("S4_key_9"));
        if ((goto 164) || (!paramb.equals("space"))) {
          break;
        }
        i = 405;
        break label166;
      } while (paramb.equals("S4_key_8"));
      if ((goto 164) || (!paramb.equals("at"))) {
        break;
      }
      i = 406;
      continue;
      if (!paramb.equals("enter")) {
        break;
      }
      paramb = (d)com.tencent.mm.kernel.h.ax(d.class);
      if (paramb != null)
      {
        paramb = paramb.fKG();
        if ((paramb == null) || (paramb.fKr() != true)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label443;
        }
        i = 407;
        break;
      }
      label443:
      i = 409;
    }
  }
  
  public static void r(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(312001);
    s.u(paramString, "subType");
    if (fMC())
    {
      AppMethodBeat.o(312001);
      return;
    }
    hy localhy = new hy();
    localhy.ipH = paramInt1;
    localhy.rI(paramString);
    localhy.iPo = paramInt2;
    localhy.bMH();
    AppMethodBeat.o(312001);
  }
  
  public static void rM(long paramLong)
  {
    AppMethodBeat.i(312053);
    JvK = new a(paramLong, 0, System.currentTimeMillis());
    AppMethodBeat.o(312053);
  }
  
  public static void rN(long paramLong)
  {
    AppMethodBeat.i(312090);
    if (fMC())
    {
      AppMethodBeat.o(312090);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new k..ExternalSyntheticLambda3(paramLong), "WxIme.ImeReporter");
    AppMethodBeat.o(312090);
  }
  
  public static void rO(long paramLong)
  {
    AppMethodBeat.i(312098);
    if (fMC())
    {
      AppMethodBeat.o(312098);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new k..ExternalSyntheticLambda4(paramLong), "WxIme.ImeReporter");
    AppMethodBeat.o(312098);
  }
  
  public static void rP(long paramLong)
  {
    AppMethodBeat.i(312106);
    if (fMC())
    {
      AppMethodBeat.o(312106);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new k..ExternalSyntheticLambda5(paramLong), "WxIme.ImeReporter");
    AppMethodBeat.o(312106);
  }
  
  public static void rQ(long paramLong)
  {
    AppMethodBeat.i(312121);
    if (fMC())
    {
      AppMethodBeat.o(312121);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new k..ExternalSyntheticLambda6(paramLong), "WxIme.ImeReporter");
    AppMethodBeat.o(312121);
  }
  
  private static final void rR(long paramLong)
  {
    AppMethodBeat.i(312389);
    fMz();
    dbs localdbs = (dbs)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
    if (localdbs != null)
    {
      localdbs.aaHf = paramLong;
      if ((localdbs.aaHg == 0L) && (localdbs.aaHh == 0L) && (localdbs.aaHe.aaHt == 0L)) {
        localdbs.aaHi = 2;
      }
    }
    AppMethodBeat.o(312389);
  }
  
  private static final void rS(long paramLong)
  {
    AppMethodBeat.i(312395);
    fMz();
    dbs localdbs = (dbs)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
    if (localdbs != null)
    {
      localdbs.aaHg = paramLong;
      if ((localdbs.aaHf == 0L) && (localdbs.aaHh == 0L) && (localdbs.aaHe.aaHt == 0L)) {
        localdbs.aaHi = 3;
      }
    }
    AppMethodBeat.o(312395);
  }
  
  private static final void rT(long paramLong)
  {
    AppMethodBeat.i(312403);
    fMz();
    dbs localdbs = (dbs)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
    if (localdbs != null)
    {
      localdbs.aaHh = paramLong;
      if ((localdbs.aaHf == 0L) && (localdbs.aaHg == 0L) && (localdbs.aaHe.aaHt == 0L)) {
        localdbs.aaHi = 4;
      }
    }
    AppMethodBeat.o(312403);
  }
  
  private static final void rU(long paramLong)
  {
    AppMethodBeat.i(312428);
    dbs localdbs = (dbs)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_performance");
    if (localdbs != null) {
      localdbs.aaHe.aaHB = paramLong;
    }
    AppMethodBeat.o(312428);
  }
  
  private static void wX(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(311969);
    if (fMC())
    {
      AppMethodBeat.o(311969);
      return;
    }
    ic localic = new ic();
    Object localObject = (dbv)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getOnlyMemory(10, "id_context");
    if (localObject == null)
    {
      localObject = null;
      if (localObject == null) {
        Log.e("WxIme.ImeReporter", "getOnlyMemory(reportOpenClose) 10 id_context is null");
      }
      if (!paramBoolean) {
        break label218;
      }
      i = 1;
      label78:
      localic.ipH = i;
      localObject = g.JuL;
      i = g.fMo();
      if (i != c.Jrp.ordinal()) {
        break label223;
      }
      i = 1;
      label104:
      localic.iPu = i;
      localObject = (d)com.tencent.mm.kernel.h.ax(d.class);
      if (localObject == null) {
        break label352;
      }
      localObject = ((d)localObject).fKG();
      if ((localObject == null) || (((com.tencent.mm.plugin.hld.a.b)localObject).fKx() != true)) {
        break label352;
      }
    }
    label218:
    label223:
    label352:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        j = 1;
      }
      localic.iPt = localic.F("PackageName", String.valueOf(j), true);
      localic.bMH();
      AppMethodBeat.o(311969);
      return;
      localic.ijk = localic.F("SessionId", ((dbv)localObject).sessionId, true);
      localic.imW = ((dbv)localObject).scene;
      localObject = ah.aiuX;
      break;
      i = 2;
      break label78;
      if (i == c.Jrq.ordinal())
      {
        i = 2;
        break label104;
      }
      if (i == c.Jrr.ordinal())
      {
        i = 3;
        break label104;
      }
      if (i == c.Jrs.ordinal())
      {
        i = 4;
        break label104;
      }
      if (i == c.Jrt.ordinal())
      {
        i = 5;
        break label104;
      }
      if (i == c.Jru.ordinal())
      {
        i = 6;
        break label104;
      }
      if (i == c.Jrv.ordinal())
      {
        i = 7;
        break label104;
      }
      if (i == c.Jrw.ordinal())
      {
        i = 8;
        break label104;
      }
      if (i == c.Jrx.ordinal())
      {
        i = 9;
        break label104;
      }
      i = -1;
      break label104;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/ImeReporter$PressOperationRecord;", "", "pressTime", "", "keyType", "", "processTimeStamp", "(JIJ)V", "getKeyType", "()I", "getPressTime", "()J", "getProcessTimeStamp", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final long JnG;
    final long JvL;
    final int keyType;
    
    public a(long paramLong1, int paramInt, long paramLong2)
    {
      this.JnG = paramLong1;
      this.keyType = paramInt;
      this.JvL = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.k
 * JD-Core Version:    0.7.0.1
 */