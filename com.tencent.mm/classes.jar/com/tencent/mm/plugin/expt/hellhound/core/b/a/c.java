package com.tencent.mm.plugin.expt.hellhound.core.b.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.d.a;
import com.tencent.mm.plugin.expt.a.d.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.core.stack.h;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.apq;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.bzg;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.dcp;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;

final class c
{
  d.a qjq;
  private final com.tencent.mm.plugin.expt.hellhound.core.a.a.d qju;
  
  c()
  {
    AppMethodBeat.i(121938);
    this.qju = new com.tencent.mm.plugin.expt.hellhound.core.a.a.d()
    {
      public final void a(com.tencent.mm.plugin.expt.hellhound.core.a.a.a paramAnonymousa)
      {
        AppMethodBeat.i(121937);
        if (paramAnonymousa == null)
        {
          AppMethodBeat.o(121937);
          return;
        }
        switch (paramAnonymousa.msgType)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(121937);
          return;
          if (paramAnonymousa.qiS != null)
          {
            Object localObject1 = (dcp)paramAnonymousa.qiS;
            Object localObject2;
            Object localObject3;
            boolean bool;
            Object localObject4;
            Object localObject5;
            Object localObject6;
            if (localObject1 != null)
            {
              ac.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_startActivity: %s, %s, %s", new Object[] { ((dcp)localObject1).EZc.activityName, ((dcp)localObject1).EZd.activityName, ((dcp)localObject1).EIF });
              localObject2 = c.this;
              paramAnonymousa = null;
              if ((((dcp)localObject1).EZc == null) || (TextUtils.isEmpty(((dcp)localObject1).EZc.activityName))) {
                break label1088;
              }
              paramAnonymousa = ((dcp)localObject1).EZc.activityName;
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cjd();
              bool = ((dcp)localObject1).EIH;
              localObject4 = ((dcp)localObject1).EIF;
              ((com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c)localObject3).qjB.b(paramAnonymousa, bool, (String)localObject4);
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L(paramAnonymousa, ((dcp)localObject1).EIF, 100);
              localObject3 = ((dcp)localObject1).EZd.activityName;
              ac.i("HABBYGE-MALI.AsyncActivityMonitor", "_startActivity, toActivity: %s, %s", new Object[] { paramAnonymousa, localObject3 });
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L((String)localObject3, null, 101);
              localObject4 = ((dcp)localObject1).EIG;
              localObject5 = ((dcp)localObject1).EZf;
              localObject6 = ((dcp)localObject1).EZe;
              if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fH("Chat_User", (String)localObject4);
              }
              if ((!"1".equals(localObject6)) || (!"jd_store".equals(localObject5))) {
                break label1121;
              }
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fH("minimize_secene", (String)localObject6);
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fH("KPublisherId", (String)localObject5);
            }
            for (;;)
            {
              c.b(((dcp)localObject1).flags, paramAnonymousa, ((dcp)localObject1).EIF, (String)localObject3, null, ((dcp)localObject1).timestamp);
              a.aag((String)localObject3);
              a.aai(paramAnonymousa);
              a.Ch(0);
              if ((localObject3 != null) && (((c)localObject2).qjq != null)) {
                ((c)localObject2).qjq.Zz((String)localObject3);
              }
              AppMethodBeat.o(121937);
              return;
              label1088:
              com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW();
              if (localObject3 == null) {
                break;
              }
              paramAnonymousa = ((bj)localObject3).DOc.activityName;
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cjd().aam(paramAnonymousa);
              break;
              label1121:
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fH("minimize_secene", "");
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fH("KPublisherId", "");
            }
            if (paramAnonymousa.qiS != null)
            {
              paramAnonymousa = (dhz)paramAnonymousa.qiS;
              long l;
              int i;
              if (paramAnonymousa != null)
              {
                ac.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_finish: %s", new Object[] { paramAnonymousa.activityName });
                localObject1 = c.this;
                localObject2 = c.a(paramAnonymousa);
                if (localObject2 != null)
                {
                  ac.i("HABBYGE-MALI.AsyncActivityMonitor", "_finish: %s", new Object[] { ((dhz)localObject2).activityName });
                  com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L(((dhz)localObject2).activityName, null, 102);
                  localObject5 = ((dhz)localObject2).activityName;
                  l = ((dhz)localObject2).timestamp;
                  localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR().qjl.qjm;
                  if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                    break label1406;
                  }
                  i = 0;
                }
              }
              label1406:
              int j;
              for (;;)
              {
                if (i == 0)
                {
                  ac.w("HABBYGE-MALI.AsyncActivityMonitor", "_finish, popSuccess FALSE");
                  paramAnonymousa = new bj();
                  paramAnonymousa.DOc = new dhz();
                  paramAnonymousa.DOc.activityName = ((dhz)localObject2).activityName;
                  paramAnonymousa.DOc.EIR = ((dhz)localObject2).EIR;
                  paramAnonymousa.DOc.timestamp = ((dhz)localObject2).timestamp;
                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().a(null, paramAnonymousa, 1, null);
                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qlC;
                  com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aas(((dhz)localObject2).activityName);
                  com.tencent.mm.plugin.expt.hellhound.a.g.c.clv().a(3, ((dhz)localObject2).activityName, null);
                }
                c.aR(((dhz)localObject2).activityName, true);
                if (((c)localObject1).qjq != null) {
                  ((c)localObject1).qjq.g(((dhz)localObject2).activityName, ((dhz)localObject2).EIR, ((dhz)localObject2).timestamp);
                }
                AppMethodBeat.o(121937);
                return;
                localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.c.ciP();
                if (((bk)localObject4).DOh.isEmpty())
                {
                  i = 0;
                }
                else
                {
                  if (localObject4 != null)
                  {
                    i = ((bk)localObject4).DOh.size() - 1;
                    label1443:
                    if (i >= 0)
                    {
                      localObject6 = (dgv)((bk)localObject4).DOh.get(i);
                      j = ((dgv)localObject6).FPY.size() - 1;
                      label1472:
                      if (j >= 0)
                      {
                        paramAnonymousa = (bj)((dgv)localObject6).FPY.get(j);
                        if (paramAnonymousa.DOc.activityName.equals(localObject5))
                        {
                          ((dgv)localObject6).FPY.remove(j);
                          if (((dgv)localObject6).FPY.isEmpty()) {
                            ((bk)localObject4).DOh.remove(i);
                          }
                        }
                      }
                    }
                  }
                  for (;;)
                  {
                    if (paramAnonymousa != null) {
                      break label1563;
                    }
                    i = 0;
                    break;
                    j -= 1;
                    break label1472;
                    i -= 1;
                    break label1443;
                    paramAnonymousa = null;
                  }
                  label1563:
                  com.tencent.mm.plugin.expt.hellhound.core.stack.c.a((bk)localObject4);
                  if (((com.tencent.mm.plugin.expt.hellhound.core.stack.g)localObject3).qjp != null)
                  {
                    paramAnonymousa.DOc.timestamp = l;
                    ((com.tencent.mm.plugin.expt.hellhound.core.stack.g)localObject3).qjp.b(paramAnonymousa, (bj)com.tencent.mm.plugin.expt.hellhound.core.stack.g.ciX().get(1));
                  }
                  i = 1;
                }
              }
              if (paramAnonymousa.qiS != null)
              {
                localObject1 = (bww)paramAnonymousa.qiS;
                if (localObject1 != null)
                {
                  ac.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_moveTaskToBack: %s", new Object[] { ((bww)localObject1).EIE.activityName });
                  paramAnonymousa = c.this;
                  localObject2 = ((bww)localObject1).EIE;
                  bool = ((bww)localObject1).EZh;
                  localObject1 = c.a((dhz)localObject2);
                  if (localObject1 != null)
                  {
                    ac.d("HABBYGE-MALI.AsyncActivityMonitor", "_moveTaskToBack: %s", new Object[] { ((dhz)localObject1).activityName });
                    if (!TextUtils.isEmpty(((dhz)localObject1).activityName))
                    {
                      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L(((dhz)localObject1).activityName, null, 103);
                      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR().qjl.qjm;
                      localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.c.ciP();
                      localObject4 = new bj();
                      ((bj)localObject4).DOc = new dhz();
                      ((bj)localObject4).DOc.activityName = ((dhz)localObject1).activityName;
                      ((bj)localObject4).DOc.EIR = ((dhz)localObject1).EIR;
                      ((bj)localObject4).DOc.timestamp = ((dhz)localObject1).timestamp;
                      localObject5 = com.tencent.mm.plugin.expt.hellhound.core.stack.g.a((bk)localObject3, (bj)localObject4);
                      if (localObject5 != null)
                      {
                        localObject6 = (dgv)((com.tencent.mm.vending.j.b)localObject5).get(0);
                        i = ((Integer)((com.tencent.mm.vending.j.c)localObject5).get(1)).intValue();
                        if (((bool) || (h.a(((bj)((dgv)localObject6).FPY.getFirst()).DOc, ((bj)localObject4).DOc))) && (i == ((bk)localObject3).DOh.size() - 1))
                        {
                          ((bk)localObject3).DOh.remove(i);
                          ((bk)localObject3).DOh.addFirst(localObject6);
                          com.tencent.mm.plugin.expt.hellhound.core.stack.c.a((bk)localObject3);
                          if (((com.tencent.mm.plugin.expt.hellhound.core.stack.g)localObject2).qjp != null) {
                            ((com.tencent.mm.plugin.expt.hellhound.core.stack.g)localObject2).qjp.d((bj)localObject4, com.tencent.mm.plugin.expt.hellhound.core.stack.g.e((bk)localObject3));
                          }
                        }
                      }
                      c.aR(((dhz)localObject1).activityName, false);
                      if (paramAnonymousa.qjq != null) {
                        paramAnonymousa.qjq.h(((dhz)localObject1).activityName, ((dhz)localObject1).EIR, ((dhz)localObject1).timestamp);
                      }
                    }
                  }
                }
                AppMethodBeat.o(121937);
                return;
                if (paramAnonymousa.qiS != null)
                {
                  paramAnonymousa = (bzg)paramAnonymousa.qiS;
                  if (paramAnonymousa != null)
                  {
                    ac.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onCreate: %s", new Object[] { paramAnonymousa.EIE.activityName });
                    localObject1 = c.this;
                    localObject2 = paramAnonymousa.EIE;
                    i = paramAnonymousa.flags;
                    ac.d("HABBYGE-MALI.AsyncActivityMonitor", "_onCreate: 0x%s, %s, %s", new Object[] { Integer.toHexString(i), ((dhz)localObject2).activityName, ((dhz)localObject2).EIR });
                    c.a(i, (dhz)localObject2);
                    if (((c)localObject1).qjq != null) {
                      ((c)localObject1).qjq.ZA(((dhz)localObject2).activityName);
                    }
                  }
                  AppMethodBeat.o(121937);
                  return;
                  if (paramAnonymousa.qiS != null)
                  {
                    localObject1 = (bzg)paramAnonymousa.qiS;
                    if (localObject1 != null)
                    {
                      ac.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onNewIntent: %s", new Object[] { ((bzg)localObject1).EIE.activityName });
                      paramAnonymousa = c.this;
                      i = ((bzg)localObject1).flags;
                      localObject1 = ((bzg)localObject1).EIE;
                      ac.d("HABBYGE-MALI.AsyncActivityMonitor", "_onNewIntent: 0x%s, %s, %s", new Object[] { Integer.toHexString(i), ((dhz)localObject1).activityName, ((dhz)localObject1).EIR });
                      c.a(i, (dhz)localObject1);
                      if (paramAnonymousa.qjq != null) {
                        paramAnonymousa.qjq.ZB(((dhz)localObject1).activityName);
                      }
                    }
                    AppMethodBeat.o(121937);
                    return;
                    if (paramAnonymousa.qiS != null)
                    {
                      paramAnonymousa = (dhz)paramAnonymousa.qiS;
                      if (paramAnonymousa != null)
                      {
                        ac.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onResume: %s", new Object[] { paramAnonymousa.activityName });
                        localObject1 = c.this;
                        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L(paramAnonymousa.activityName, null, 105);
                        com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
                        com.tencent.mm.plugin.expt.hellhound.core.stack.d.aae(paramAnonymousa.activityName);
                        c.a(paramAnonymousa.activityName, paramAnonymousa.EIR, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qje);
                        if (((c)localObject1).qjq != null) {
                          ((c)localObject1).qjq.i(paramAnonymousa.activityName, paramAnonymousa.EIR, paramAnonymousa.timestamp);
                        }
                      }
                      AppMethodBeat.o(121937);
                      return;
                      if (paramAnonymousa.qiS != null)
                      {
                        paramAnonymousa = (String)paramAnonymousa.qiS;
                        ac.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_UPDATE_SID: %s", new Object[] { paramAnonymousa });
                        if (!TextUtils.isEmpty(paramAnonymousa)) {
                          com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaV(paramAnonymousa);
                        }
                        AppMethodBeat.o(121937);
                        return;
                        if (paramAnonymousa.qiS != null)
                        {
                          paramAnonymousa = (bzh)paramAnonymousa.qiS;
                          if (paramAnonymousa != null)
                          {
                            ac.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPostResume: %s", new Object[] { paramAnonymousa.EIE.activityName });
                            if (c.this.qjq != null) {
                              c.this.qjq.ZC(paramAnonymousa.EIE.activityName);
                            }
                          }
                          AppMethodBeat.o(121937);
                          return;
                          if (paramAnonymousa.qiS != null)
                          {
                            paramAnonymousa = (dhz)paramAnonymousa.qiS;
                            if (paramAnonymousa != null)
                            {
                              ac.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPause: %s", new Object[] { paramAnonymousa.activityName });
                              localObject1 = c.this;
                              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L(paramAnonymousa.activityName, null, 106);
                              c.a(paramAnonymousa.activityName, paramAnonymousa.EIR, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qjf);
                              if (((c)localObject1).qjq != null) {
                                ((c)localObject1).qjq.j(paramAnonymousa.activityName, paramAnonymousa.EIR, paramAnonymousa.timestamp);
                              }
                            }
                            AppMethodBeat.o(121937);
                            return;
                            if (paramAnonymousa.qiS != null)
                            {
                              paramAnonymousa = (bzh)paramAnonymousa.qiS;
                              if (paramAnonymousa != null)
                              {
                                ac.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPaused: %s", new Object[] { paramAnonymousa.EIE.activityName });
                                if (c.this.qjq != null) {
                                  c.this.qjq.ZD(paramAnonymousa.EIE.activityName);
                                }
                              }
                              AppMethodBeat.o(121937);
                              return;
                              if (paramAnonymousa.qiS != null)
                              {
                                paramAnonymousa = (dhz)paramAnonymousa.qiS;
                                if (paramAnonymousa != null)
                                {
                                  ac.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onStop: %s", new Object[] { paramAnonymousa.activityName });
                                  localObject1 = c.this;
                                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.ZM(paramAnonymousa.activityName))
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L(paramAnonymousa.activityName, null, 107);
                                    c.a(paramAnonymousa.activityName, paramAnonymousa.EIR, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qjg);
                                    if (((c)localObject1).qjq != null) {
                                      ((c)localObject1).qjq.k(paramAnonymousa.activityName, paramAnonymousa.EIR, paramAnonymousa.timestamp);
                                    }
                                  }
                                }
                                AppMethodBeat.o(121937);
                                return;
                                if (paramAnonymousa.qiS != null)
                                {
                                  paramAnonymousa = (dhz)paramAnonymousa.qiS;
                                  if (paramAnonymousa != null)
                                  {
                                    ac.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onDestroy: %s", new Object[] { paramAnonymousa.activityName });
                                    localObject1 = c.this;
                                    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L(paramAnonymousa.activityName, null, 108);
                                    c.a(paramAnonymousa.activityName, paramAnonymousa.EIR, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qjh);
                                    if (((c)localObject1).qjq != null) {
                                      ((c)localObject1).qjq.fE(paramAnonymousa.activityName, paramAnonymousa.EIR);
                                    }
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  ac.i("HABBYGE-MALI.AsyncActivityMonitor", "HellMsgType.MSGQ_TYPE_FRAGMENT_RESUME recv !!");
                                  paramAnonymousa = (apr)paramAnonymousa.qiS;
                                  if (paramAnonymousa != null) {
                                    com.tencent.mm.plugin.expt.hellhound.core.a.ciC().qiG.a(paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (apq)paramAnonymousa.qiS;
                                  if (paramAnonymousa != null) {
                                    com.tencent.mm.plugin.expt.hellhound.core.a.ciC().qiG.a(paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  ac.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_FRAGMENT_%d", new Object[] { Integer.valueOf(paramAnonymousa.msgType) });
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.ciC();
                                  i = paramAnonymousa.msgType;
                                  l = ((Long)paramAnonymousa.qiS).longValue();
                                  ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject1).qiG.P(i, l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  ac.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_STORY_%d", new Object[] { Integer.valueOf(paramAnonymousa.msgType) });
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.ciC();
                                  i = paramAnonymousa.msgType;
                                  l = ((Long)paramAnonymousa.qiS).longValue();
                                  ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject1).qiG.Q(i, l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  try
                                  {
                                    i = ((Integer)paramAnonymousa.qiS).intValue();
                                    if (paramAnonymousa.msgType == 401)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.e.a.CB(i);
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                  }
                                  catch (Exception paramAnonymousa)
                                  {
                                    ac.printErrStackTrace("HABBYGE-MALI.AsyncActivityMonitor", paramAnonymousa, "CATCH_ACTIVITY_ONRESUME: %s", new Object[] { paramAnonymousa.getMessage() });
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 400)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.CA(i);
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 402)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.CA(i);
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 403) {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.CB(i);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject2 = com.tencent.mm.plugin.expt.hellhound.a.c.c.cjZ();
                                  ac.i("HellFrontBackMonitor", "HABBYGE-MALI, add8EventMMProcessEndIfNeed");
                                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.ciE())
                                  {
                                    paramAnonymousa = null;
                                    if (paramAnonymousa != null)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.c.a.Cv(8);
                                      a.Ch(8);
                                      localObject1 = (String)paramAnonymousa.get(0);
                                      localObject3 = (String)paramAnonymousa.get(1);
                                      i = ((Integer)paramAnonymousa.get(2)).intValue();
                                      l = ((Long)paramAnonymousa.get(3)).longValue();
                                      j = ((Integer)paramAnonymousa.get(4)).intValue();
                                      ac.i("HellFrontBackMonitor", "HABBYGE-MALI, add8EventMMProcessEndIfNeed need 补充8事件: %s, %d, %s, %d", new Object[] { localObject1, Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j) });
                                      if (((com.tencent.mm.plugin.expt.hellhound.a.c.c)localObject2).qpp != null) {
                                        ((com.tencent.mm.plugin.expt.hellhound.a.c.c)localObject2).qpp.a((String)localObject1, (String)localObject3, i, l, j);
                                      }
                                    }
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  i = Process.myPid();
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.a.c.a.cjY();
                                  paramAnonymousa = (com.tencent.mm.plugin.expt.hellhound.core.a.a.a)localObject1;
                                  if (localObject1 == null) {
                                    paramAnonymousa = new apx();
                                  }
                                  if (paramAnonymousa.EIP <= 0)
                                  {
                                    ac.i("FrontBackDao", "habbyge-mali, handleLastProcessParams lastMMProcessId <= 0");
                                    paramAnonymousa = null;
                                  }
                                  for (;;)
                                  {
                                    break;
                                    if (paramAnonymousa.EIP != i)
                                    {
                                      ac.i("FrontBackDao", "habbyge-mali, handleLastProcessParams last != curr ---1: %d, %d", new Object[] { Integer.valueOf(paramAnonymousa.EIP), Integer.valueOf(i) });
                                      if (paramAnonymousa.EIN == 7)
                                      {
                                        com.tencent.mm.plugin.expt.hellhound.a.c.c.cjZ();
                                        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.c.a.cjY();
                                        if ((localObject1 != null) && (((apx)localObject1).EIS)) {}
                                        for (i = 1;; i = 0)
                                        {
                                          if (i == 0) {
                                            break label3494;
                                          }
                                          ac.i("FrontBackDao", "HABBYGE-MALI, getIsLogoutFromMMPageFlowService true");
                                          com.tencent.mm.plugin.expt.hellhound.a.c.a.kI(false);
                                          paramAnonymousa = null;
                                          break;
                                        }
                                        label3494:
                                        if (TextUtils.isEmpty("page_hell_seq_mmkv_key")) {}
                                        for (i = -1;; i = aw.aKT("_hellhound_mmkv").getInt("page_hell_seq_mmkv_key", -1))
                                        {
                                          paramAnonymousa.hTM = i;
                                          localObject1 = paramAnonymousa.EIQ;
                                          localObject3 = paramAnonymousa.EIR;
                                          i = paramAnonymousa.EIP;
                                          l = paramAnonymousa.EIO;
                                          j = paramAnonymousa.hTM;
                                          paramAnonymousa = new com.tencent.mm.vending.j.f();
                                          paramAnonymousa.Jru = new Object[] { localObject1, localObject3, Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j) };
                                          paramAnonymousa = (com.tencent.mm.vending.j.f)paramAnonymousa;
                                          break;
                                        }
                                      }
                                    }
                                    else
                                    {
                                      ac.i("FrontBackDao", "habbyge-mali, handleLastProcessParams last == curr: %d, %d", new Object[] { Integer.valueOf(paramAnonymousa.EIP), Integer.valueOf(i) });
                                    }
                                    paramAnonymousa = null;
                                  }
                                  localObject1 = (bjv)paramAnonymousa.qiS;
                                  if (localObject1 != null)
                                  {
                                    paramAnonymousa = ((bjv)localObject1).koY;
                                    localObject1 = ((bjv)localObject1).value;
                                    ac.i("SyncBizCollector", "HABBYGE-MALI, _collectBizData: %s, %s", new Object[] { paramAnonymousa, localObject1 });
                                    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
                                    localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK((String)com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciT().get(0));
                                    if (localObject2 != null)
                                    {
                                      ac.i("SyncBizCollector", "HABBYGE-MALI, addBizData2Fuzzy, curActivityName: %s", new Object[] { localObject2 });
                                      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.d.d.cke();
                                      if (localObject3 != null) {
                                        break label3781;
                                      }
                                      ac.e("SyncBizCollector", "HABBYGE-MALI, addBizData2Fuzzy, matchInfo is NULL !!");
                                    }
                                    label4026:
                                    for (;;)
                                    {
                                      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.a.b.ckt();
                                      if (localObject3 != null) {
                                        break;
                                      }
                                      ac.e("SyncBizCollector", "HABBYGE-MALI, collectBizData, tuple2 is NULL");
                                      AppMethodBeat.o(121937);
                                      return;
                                      label3781:
                                      if (((aqe)localObject3).EJa.isEmpty())
                                      {
                                        ac.e("SyncBizCollector", "HABBYGE-MALI, addBizData2Fuzzy, matchInfo.sessionFuzzyPaths is NULL !!");
                                      }
                                      else
                                      {
                                        localObject4 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
                                        if (localObject4 == null)
                                        {
                                          ac.e("SyncBizCollector", "HABBYGE-MALI, addBizData2Fuzzy, curSession is NULL !!");
                                        }
                                        else
                                        {
                                          localObject5 = new bjv();
                                          ((bjv)localObject5).koY = paramAnonymousa;
                                          ((bjv)localObject5).value = ((String)localObject1);
                                          i = ((aqe)localObject3).EJa.size() - 1;
                                          while (i >= 0)
                                          {
                                            localObject6 = (cvu)((aqe)localObject3).EJa.get(i);
                                            if ((localObject6 != null) && (((cvu)localObject6).dnh != null) && (((cvu)localObject6).dnh.equals(((ccs)localObject4).sessionId)))
                                            {
                                              localObject6 = ((cvu)localObject6).EIZ.iterator();
                                              while (((Iterator)localObject6).hasNext())
                                              {
                                                aqg localaqg = (aqg)((Iterator)localObject6).next();
                                                if (!localaqg.EJg.isEmpty())
                                                {
                                                  j = localaqg.EJg.size() - 1;
                                                  for (;;)
                                                  {
                                                    if (j < 0) {
                                                      break label4026;
                                                    }
                                                    aqf localaqf = (aqf)localaqg.EJg.get(j);
                                                    if (localaqf != null)
                                                    {
                                                      String str = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(localaqf.name);
                                                      if ((str != null) && (str.equals(localObject2)))
                                                      {
                                                        localaqf.EJd.addLast(localObject5);
                                                        break;
                                                      }
                                                    }
                                                    j -= 1;
                                                  }
                                                }
                                              }
                                            }
                                            i -= 1;
                                          }
                                          com.tencent.mm.plugin.expt.hellhound.a.d.d.a((aqe)localObject3);
                                        }
                                      }
                                    }
                                    localObject2 = (bju)((com.tencent.mm.vending.j.b)localObject3).get(0);
                                    i = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
                                    localObject3 = new bjv();
                                    ((bjv)localObject3).koY = paramAnonymousa;
                                    ((bjv)localObject3).value = ((String)localObject1);
                                    ((bju)localObject2).EJd.add(localObject3);
                                    ((bju)localObject2).EZl.add(localObject3);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((bju)localObject2, i);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject1 = (String)paramAnonymousa.qiS;
                                  if (localObject1 != null)
                                  {
                                    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.a.b.ckt();
                                    if (localObject2 != null) {
                                      break label4191;
                                    }
                                    ac.e("AsyncBizCollector", "HABBYGE-MALI, getBizId, tuple2 is NULL");
                                  }
                                  for (paramAnonymousa = null;; paramAnonymousa = ((bjv)localObject2).koY)
                                  {
                                    ac.i("AsyncBizCollector", "HABBYGE-MALI, AsyncBizCollector, _collectBizId: %s", new Object[] { paramAnonymousa });
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cku();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.fK((String)localObject1, paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label4191:
                                    paramAnonymousa = (bju)((com.tencent.mm.vending.j.b)localObject2).get(0);
                                    i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
                                    j = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.fr(paramAnonymousa.EJd.size() + 1, paramAnonymousa.EZl.size() + 1);
                                    localObject2 = new bjv();
                                    ((bjv)localObject2).koY = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.v(paramAnonymousa.startTime, j);
                                    paramAnonymousa.EJd.add(localObject2);
                                    paramAnonymousa.EZl.add(localObject2);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramAnonymousa, i);
                                    ac.i("AsyncBizCollector", "HABBYGE-MALI, getBizId, addBizIdCurPageFlowItem: %s", new Object[] { ((bjv)localObject2).koY });
                                  }
                                  localObject1 = (bjv)paramAnonymousa.qiS;
                                  if (localObject1 != null)
                                  {
                                    paramAnonymousa = ((bjv)localObject1).dsY;
                                    localObject2 = ((bjv)localObject1).value;
                                    localObject3 = ((bjv)localObject1).koY;
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.a.U(paramAnonymousa, (String)localObject2, (String)localObject3);
                                    if (localObject1 != null)
                                    {
                                      ac.i("AsyncBizCollector", "HABBYGE-MALI, _collectBizData: %s, %s, %s", new Object[] { paramAnonymousa, localObject2, localObject3 });
                                      if (localObject1 != null)
                                      {
                                        paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.a.ckJ();
                                        if ((paramAnonymousa == null) || (paramAnonymousa.isEmpty()))
                                        {
                                          paramAnonymousa = new JSONArray();
                                          paramAnonymousa.put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.abl(System.currentTimeMillis() + "@" + paramAnonymousa.toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        if ("-1".equals(paramAnonymousa))
                                        {
                                          ac.e("AsyncBizDao", "habbyge-mali, AsyncBizDao putBiz NOT LOGIN");
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        if (paramAnonymousa.split("@").length <= 1)
                                        {
                                          localObject2 = new JSONArray();
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.abl(paramAnonymousa + "@" + ((JSONArray)localObject2).toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        if ((paramAnonymousa == null) || (paramAnonymousa.isEmpty())) {
                                          paramAnonymousa = null;
                                        }
                                        while (paramAnonymousa == null)
                                        {
                                          paramAnonymousa = new JSONArray();
                                          paramAnonymousa.put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.abl(System.currentTimeMillis() + "@" + paramAnonymousa.toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                          paramAnonymousa = paramAnonymousa.split("@");
                                          if (paramAnonymousa.length <= 0) {
                                            paramAnonymousa = null;
                                          } else if (paramAnonymousa.length == 1) {
                                            paramAnonymousa = com.tencent.mm.vending.j.a.L(paramAnonymousa[0], null);
                                          } else {
                                            paramAnonymousa = com.tencent.mm.vending.j.a.L(paramAnonymousa[0], paramAnonymousa[1]);
                                          }
                                        }
                                        if ((TextUtils.isEmpty((CharSequence)paramAnonymousa.get(1))) && (!TextUtils.isEmpty((CharSequence)paramAnonymousa.get(0))))
                                        {
                                          localObject2 = new JSONArray();
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.abl((String)paramAnonymousa.get(0) + "@" + ((JSONArray)localObject2).toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        try
                                        {
                                          localObject2 = new JSONArray((String)paramAnonymousa.get(1));
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.abl((String)paramAnonymousa.get(0) + "@" + ((JSONArray)localObject2).toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        catch (JSONException paramAnonymousa)
                                        {
                                          ac.printErrStackTrace("AsyncBizDao", paramAnonymousa, "AsyncBizDao.putBiz crash: %s", new Object[] { paramAnonymousa.getMessage() });
                                        }
                                      }
                                    }
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qiS;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().ckr();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cku();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.fM(paramAnonymousa, (String)localObject1);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qiS;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.d.ckv();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cku();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.fL(paramAnonymousa, (String)localObject1);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                  l = ((Long)paramAnonymousa.qiS).longValue();
                                  ac.i("VoipFloatSession", "HABBYGE-MALI, VoipMonitorCallback: _videoActivity2VoipFloat");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.d.th(l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                  l = ((Long)paramAnonymousa.qiS).longValue();
                                  ac.i("VoipFloatSession", "HABBYGE-MALI, VoipMonitorCallback: _voipFloat2VideoActivity");
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
                                  if ((paramAnonymousa == null) || (TextUtils.isEmpty(paramAnonymousa.sessionId)))
                                  {
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.core.b.ciG();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ak(paramAnonymousa, l);
                                  }
                                  for (;;)
                                  {
                                    ac.i("VoipFloatSession", "HABBYGE-MALI, _beignVoipSession");
                                    bool = false;
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
                                    if (paramAnonymousa != null) {
                                      break label5178;
                                    }
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().a(null, "LauncherUI", "VideoActivity", l);
                                    if (paramAnonymousa != null) {
                                      break;
                                    }
                                    ac.e("VoipFloatSession", "HABBYGE-MALI, _beignFloatSession, 不是合法session ~~~");
                                    AppMethodBeat.o(121937);
                                    return;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().a(paramAnonymousa, l);
                                  }
                                  bool = true;
                                  for (;;)
                                  {
                                    ac.i("VoipFloatSession", "HABBYGE-MALI, _beignFloatSession, isNewSession: %s, %b", new Object[] { paramAnonymousa.sessionId, Boolean.valueOf(bool) });
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(paramAnonymousa, "VideoActivity", l);
                                    if (!bool) {
                                      break;
                                    }
                                    paramAnonymousa.hxS = 0;
                                    localObject2 = l.ckr();
                                    localObject1 = localObject2;
                                    if (localObject2 == null) {
                                      localObject1 = "";
                                    }
                                    paramAnonymousa.FqZ = ((String)localObject1);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(paramAnonymousa);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label5178:
                                    ac.i("VoipFloatSession", "HABBYGE-MALI, _beignFloatSession, curSession: %s", new Object[] { paramAnonymousa.sessionId });
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.a.f.c.c.j(paramAnonymousa);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                  l = ((Long)paramAnonymousa.qiS).longValue();
                                  ac.i("VoipFloatSession", "HABBYGE-MALI, VoipMonitorCallback: _closeVideoActivity");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.d.th(l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                  l = ((Long)paramAnonymousa.qiS).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.clp();
                                  if (paramAnonymousa != null)
                                  {
                                    paramAnonymousa.EIa = -1;
                                    paramAnonymousa.EIb = -1;
                                    paramAnonymousa.EId = 7;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.a(paramAnonymousa);
                                  }
                                  ac.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBall, stat, show: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cln()) });
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
                                  if ((paramAnonymousa == null) || (TextUtils.isEmpty(paramAnonymousa.sessionId)))
                                  {
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.core.b.ciG();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ak(paramAnonymousa, l);
                                  }
                                  for (;;)
                                  {
                                    ac.d("FloatBallSessionHandler", "HABBYGE-MALI, _beignFloatSession");
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
                                    bool = false;
                                    if (paramAnonymousa != null) {
                                      break label5504;
                                    }
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().a(null, "LauncherUI", "FloatingBall", l);
                                    if (paramAnonymousa != null) {
                                      break;
                                    }
                                    ac.e("FloatBallSessionHandler", "HABBYGE-MALI, _beignFloatSession, 不是合法session ~~~");
                                    AppMethodBeat.o(121937);
                                    return;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().a(paramAnonymousa, l);
                                  }
                                  bool = true;
                                  for (;;)
                                  {
                                    ac.d("FloatBallSessionHandler", "HABBYGE-MALI, _beignFloatSession, isNewSession: %s, %b", new Object[] { paramAnonymousa.sessionId, Boolean.valueOf(bool) });
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(paramAnonymousa, "FloatBall", l);
                                    if (!bool) {
                                      break;
                                    }
                                    paramAnonymousa.hxS = 0;
                                    localObject2 = l.ckr();
                                    localObject1 = localObject2;
                                    if (localObject2 == null) {
                                      localObject1 = "";
                                    }
                                    paramAnonymousa.FqZ = ((String)localObject1);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(paramAnonymousa);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label5504:
                                    ac.d("FloatBallSessionHandler", "HABBYGE-MALI, _beignFloatSession, curSession: %s", new Object[] { paramAnonymousa.sessionId });
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.a.f.c.c.j(paramAnonymousa);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                  l = ((Long)paramAnonymousa.qiS).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.clo();
                                  if (paramAnonymousa != null)
                                  {
                                    i = ((Integer)paramAnonymousa.second).intValue();
                                    if ((i != 1) && (i != 0)) {
                                      break label5687;
                                    }
                                  }
                                  label5687:
                                  for (bool = true;; bool = false)
                                  {
                                    ac.d("FloatBallSessionHandler", "HABBYGE-MALI, onFloatMenuHide, FloatSession, End: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
                                    if (bool)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.b(false, null, l);
                                    }
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.clp();
                                    paramAnonymousa = (com.tencent.mm.plugin.expt.hellhound.core.a.a.a)localObject1;
                                    if (localObject1 == null) {
                                      paramAnonymousa = new apc();
                                    }
                                    paramAnonymousa.EId = 8;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.a(paramAnonymousa);
                                    ac.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBall, stat, hide: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cln()) });
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                  l = ((Long)paramAnonymousa.qiS).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.clo();
                                  if (paramAnonymousa != null)
                                  {
                                    if (((Integer)paramAnonymousa.second).intValue() == 6)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.b(false, null, l);
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.CC(4);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                  ac.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBall: onFloatMenuBackgroundClicked");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.fs(1, 1);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                  ac.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBall: onFloatMenuBackPressed");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.fs(0, 0);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                  ac.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBall: onFloatMenuItemClicked");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.fs(2, 2);
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.kK(true);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                  ac.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBall: onFloatMenuItemRemoved");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.fs(6, 6);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.b(false, null, 0L);
                                  AppMethodBeat.o(121937);
                                  return;
                                  i = ((Integer)paramAnonymousa.qiS).intValue();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.CC(i);
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.g.c.clv();
                                  localObject1 = paramAnonymousa.qqE;
                                  localObject2 = paramAnonymousa.qlm;
                                  localObject3 = paramAnonymousa.qqG;
                                  ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qlm = ((com.tencent.mm.plugin.expt.hellhound.a.a.e)localObject2);
                                  com.tencent.mm.hellhoundlib.a.aeC();
                                  com.tencent.mm.hellhoundlib.a.e(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qjT, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qqB);
                                  ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qqy = ((com.tencent.mm.plugin.expt.hellhound.a.g.a)localObject3);
                                  com.tencent.mm.hellhoundlib.a.aeC();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qll, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qqC);
                                  com.tencent.mm.hellhoundlib.a.aeC();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qqz, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qqC);
                                  com.tencent.mm.hellhoundlib.a.aeC();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qqA, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qqB);
                                  if (paramAnonymousa.mActivityRef != null) {
                                    paramAnonymousa.qlE.a(0, (Activity)paramAnonymousa.mActivityRef.get());
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.g.c.clv();
                                  paramAnonymousa.qlE.a(1, null);
                                  paramAnonymousa = paramAnonymousa.qqE;
                                  com.tencent.mm.hellhoundlib.a.aeC();
                                  com.tencent.mm.hellhoundlib.a.f(paramAnonymousa.qjT, paramAnonymousa.qqB);
                                  paramAnonymousa.qlm = null;
                                  com.tencent.mm.hellhoundlib.a.aeC();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.qll, paramAnonymousa.qqC);
                                  com.tencent.mm.hellhoundlib.a.aeC();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.qqz, paramAnonymousa.qqC);
                                  paramAnonymousa.qqy = null;
                                  com.tencent.mm.hellhoundlib.a.aeC();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.qqA, paramAnonymousa.qqB);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.g.c.clv().qlE.a(2, null);
                                  com.tencent.mm.plugin.expt.hellhound.a.g.c.qqF = null;
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.g.c.clv().qlE.a(3, null);
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qiS;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qlC;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aN(0, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qiS;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qlC;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aN(1, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qiS;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qlC;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aN(2, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qiS;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qlC;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aN(3, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.tg(((Long)paramAnonymousa.qiS).longValue());
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.clj();
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
    };
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c localc = com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO();
    com.tencent.mm.plugin.expt.hellhound.core.a.a.d locald = this.qju;
    localc.qiW.qiY = locald;
    AppMethodBeat.o(121938);
  }
  
  private static com.tencent.mm.vending.j.d<String, Boolean, Boolean> Y(Activity paramActivity)
  {
    AppMethodBeat.i(121940);
    com.tencent.mm.vending.j.c localc = Z(paramActivity);
    if (!((Boolean)localc.get(1)).booleanValue())
    {
      paramActivity = com.tencent.mm.vending.j.a.i(localc.get(0), localc.get(1), Boolean.FALSE);
      AppMethodBeat.o(121940);
      return paramActivity;
    }
    boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.ZF(paramActivity.getClass().getCanonicalName());
    paramActivity = com.tencent.mm.vending.j.a.i(localc.get(0), localc.get(1), Boolean.valueOf(bool));
    AppMethodBeat.o(121940);
    return paramActivity;
  }
  
  static com.tencent.mm.vending.j.c<String, Boolean> Z(Activity paramActivity)
  {
    AppMethodBeat.i(121942);
    String str = null;
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.g.ab(paramActivity);
    if (localObject != null) {
      str = localObject.getClass().getCanonicalName();
    }
    boolean bool = true;
    localObject = str;
    if (str == null)
    {
      localObject = paramActivity.getClass().getCanonicalName();
      bool = false;
    }
    paramActivity = com.tencent.mm.vending.j.a.L(localObject, Boolean.valueOf(bool));
    AppMethodBeat.o(121942);
    return paramActivity;
  }
  
  static dhz a(dhz paramdhz)
  {
    AppMethodBeat.i(184315);
    dhz localdhz;
    if (paramdhz != null)
    {
      localdhz = paramdhz;
      if (!TextUtils.isEmpty(paramdhz.activityName)) {
        break label85;
      }
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
      com.tencent.mm.vending.j.c localc = com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciS();
      if (localc == null)
      {
        AppMethodBeat.o(184315);
        return null;
      }
      localdhz = paramdhz;
      if (paramdhz == null)
      {
        localdhz = new dhz();
        localdhz.timestamp = System.currentTimeMillis();
      }
      localdhz.activityName = ((String)localc.get(0));
      localdhz.EIR = ((String)localc.get(1));
      label85:
      AppMethodBeat.o(184315);
      return localdhz;
    }
    catch (Exception paramdhz)
    {
      ac.printErrStackTrace("HABBYGE-MALI.AsyncActivityMonitor", paramdhz, "getActivityOnFinish", new Object[0]);
      AppMethodBeat.o(184315);
    }
    return null;
  }
  
  static void a(int paramInt, dhz paramdhz)
  {
    AppMethodBeat.i(184313);
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L(paramdhz.activityName, null, 104);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Cj(101);
    if (localObject != null) {}
    for (localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);; localObject = null)
    {
      if (!paramdhz.activityName.equals(localObject))
      {
        ac.w("HABBYGE-MALI.AsyncActivityMonitor", "AsyncActivityMonitor, _onCreateEvent: %s, %s", new Object[] { localObject, paramdhz.activityName });
        b(paramInt, null, null, paramdhz.activityName, paramdhz.EIR, paramdhz.timestamp);
      }
      a(paramdhz.activityName, paramdhz.EIR, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qjd);
      AppMethodBeat.o(184313);
      return;
    }
  }
  
  static void a(String paramString1, String paramString2, com.tencent.mm.plugin.expt.hellhound.core.stack.a parama)
  {
    AppMethodBeat.i(121945);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(paramString1, paramString2, parama);
    AppMethodBeat.o(121945);
  }
  
  static void aR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(121943);
    a.Ch(1);
    if ((!paramBoolean) && (com.tencent.mm.plugin.expt.hellhound.core.b.ZF(paramString)))
    {
      ac.i("HABBYGE-MALI.AsyncActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
      AppMethodBeat.o(121943);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
    bj localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW();
    String str = null;
    if (localbj != null) {
      str = localbj.DOc.activityName;
    }
    a.aaj(paramString);
    a.aah(str);
    ac.i("HABBYGE-MALI.AsyncActivityMonitor", "setActivityActionOnFinish: from: %s, to: %s", new Object[] { paramString, str });
    AppMethodBeat.o(121943);
  }
  
  static void b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(184314);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR().a(paramInt, paramString1, paramString2, paramString3, paramString4, paramLong);
    AppMethodBeat.o(184314);
  }
  
  static bzh c(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(184312);
    bzh localbzh = new bzh();
    localbzh.EIE = new dhz();
    localbzh.EIE.activityName = paramActivity.getClass().getCanonicalName();
    localbzh.EIE.EIR = String.valueOf(paramActivity.hashCode());
    localbzh.EIE.timestamp = paramLong;
    paramActivity = Y(paramActivity);
    localbzh.EIF = ((String)paramActivity.get(0));
    localbzh.EIH = ((Boolean)paramActivity.get(1)).booleanValue();
    localbzh.EZg = ((Boolean)paramActivity.get(2)).booleanValue();
    AppMethodBeat.o(184312);
    return localbzh;
  }
  
  static bzg g(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121941);
    bzg localbzg = new bzg();
    localbzg.flags = paramIntent.getFlags();
    localbzg.EIE = new dhz();
    if (paramActivity == null)
    {
      AppMethodBeat.o(121941);
      return localbzg;
    }
    localbzg.EIE.activityName = paramActivity.getClass().getCanonicalName();
    localbzg.EIE.EIR = String.valueOf(paramActivity.hashCode());
    localbzg.EIE.timestamp = System.currentTimeMillis();
    AppMethodBeat.o(121941);
    return localbzg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.c
 * JD-Core Version:    0.7.0.1
 */