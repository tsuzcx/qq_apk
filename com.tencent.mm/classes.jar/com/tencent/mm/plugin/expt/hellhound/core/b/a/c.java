package com.tencent.mm.plugin.expt.hellhound.core.b.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.d.a;
import com.tencent.mm.plugin.expt.b.d.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.plugin.expt.hellhound.core.stack.g;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.dnf;
import com.tencent.mm.protocal.protobuf.dol;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;

final class c
{
  d.a qZo;
  private final com.tencent.mm.plugin.expt.hellhound.core.a.a.d qZs;
  
  c()
  {
    AppMethodBeat.i(121938);
    this.qZs = new com.tencent.mm.plugin.expt.hellhound.core.a.a.d()
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
          if (paramAnonymousa.qYQ != null)
          {
            Object localObject1 = (dix)paramAnonymousa.qYQ;
            Object localObject2;
            Object localObject3;
            boolean bool;
            Object localObject4;
            Object localObject5;
            Object localObject6;
            if (localObject1 != null)
            {
              ae.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_startActivity: %s, %s, %s", new Object[] { ((dix)localObject1).Hca.activityName, ((dix)localObject1).Hcb.activityName, ((dix)localObject1).GKU });
              localObject2 = c.this;
              paramAnonymousa = null;
              if ((((dix)localObject1).Hca == null) || (TextUtils.isEmpty(((dix)localObject1).Hca.activityName))) {
                break label1104;
              }
              paramAnonymousa = ((dix)localObject1).Hca.activityName;
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cpF();
              bool = ((dix)localObject1).GKX;
              localObject4 = ((dix)localObject1).GKU;
              ((com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c)localObject3).qZz.b(paramAnonymousa, bool, (String)localObject4);
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(paramAnonymousa, ((dix)localObject1).GKU, 100);
              localObject3 = ((dix)localObject1).Hcb.activityName;
              ae.i("HABBYGE-MALI.AsyncActivityMonitor", "_startActivity, toActivity: %s, %s", new Object[] { paramAnonymousa, localObject3 });
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject3, null, 101);
              localObject4 = ((dix)localObject1).GKW;
              localObject5 = ((dix)localObject1).Hcd;
              localObject6 = ((dix)localObject1).Hcc;
              if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fV("Chat_User", (String)localObject4);
              }
              if ((!"1".equals(localObject6)) || (!"jd_store".equals(localObject5))) {
                break label1137;
              }
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fV("minimize_secene", (String)localObject6);
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fV("KPublisherId", (String)localObject5);
            }
            for (;;)
            {
              c.b(((dix)localObject1).flags, paramAnonymousa, ((dix)localObject1).GKU, (String)localObject3, 0, ((dix)localObject1).timestamp);
              a.aeN((String)localObject3);
              a.aeP(paramAnonymousa);
              a.Df(0);
              if ((localObject3 != null) && (((c)localObject2).qZo != null)) {
                ((c)localObject2).qZo.adW((String)localObject3);
              }
              AppMethodBeat.o(121937);
              return;
              label1104:
              com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cpy();
              if (localObject3 == null) {
                break;
              }
              paramAnonymousa = ((bj)localObject3).FLG.activityName;
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cpF().aeT(paramAnonymousa);
              break;
              label1137:
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fV("minimize_secene", "");
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fV("KPublisherId", "");
            }
            if (paramAnonymousa.qYQ != null)
            {
              paramAnonymousa = (dol)paramAnonymousa.qYQ;
              long l;
              int i;
              if (paramAnonymousa != null)
              {
                ae.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_finish: %s", new Object[] { paramAnonymousa.activityName });
                localObject1 = c.this;
                localObject2 = c.a(paramAnonymousa);
                if (localObject2 != null)
                {
                  ae.i("HABBYGE-MALI.AsyncActivityMonitor", "_finish: %s", new Object[] { ((dol)localObject2).activityName });
                  com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(((dol)localObject2).activityName, null, 102);
                  localObject5 = ((dol)localObject2).activityName;
                  l = ((dol)localObject2).timestamp;
                  localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt().qZj.qZk;
                  if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                    break label1422;
                  }
                  i = 0;
                }
              }
              label1422:
              label1459:
              int j;
              for (;;)
              {
                if (i == 0)
                {
                  ae.w("HABBYGE-MALI.AsyncActivityMonitor", "_finish, popSuccess FALSE");
                  paramAnonymousa = new bj();
                  paramAnonymousa.FLG = new dol();
                  paramAnonymousa.FLG.activityName = ((dol)localObject2).activityName;
                  paramAnonymousa.FLG.aHQ = ((dol)localObject2).aHQ;
                  paramAnonymousa.FLG.timestamp = ((dol)localObject2).timestamp;
                  com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(null, paramAnonymousa, 1, null);
                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.rcx;
                  com.tencent.mm.plugin.expt.hellhound.a.b.a.b.afa(((dol)localObject2).activityName);
                  com.tencent.mm.plugin.expt.hellhound.a.g.c.csm().a(3, ((dol)localObject2).activityName, null);
                }
                c.aV(((dol)localObject2).activityName, true);
                if (((c)localObject1).qZo != null) {
                  ((c)localObject1).qZo.e(((dol)localObject2).activityName, ((dol)localObject2).aHQ, ((dol)localObject2).timestamp);
                }
                AppMethodBeat.o(121937);
                return;
                localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.c.cpr();
                if (((bk)localObject4).FLM.isEmpty())
                {
                  i = 0;
                }
                else
                {
                  if (localObject4 != null)
                  {
                    i = ((bk)localObject4).FLM.size() - 1;
                    if (i >= 0)
                    {
                      localObject6 = (dnf)((bk)localObject4).FLM.get(i);
                      j = ((dnf)localObject6).HUq.size() - 1;
                      label1488:
                      if (j >= 0)
                      {
                        paramAnonymousa = (bj)((dnf)localObject6).HUq.get(j);
                        if (paramAnonymousa.FLG.activityName.equals(localObject5))
                        {
                          ((dnf)localObject6).HUq.remove(j);
                          if (((dnf)localObject6).HUq.isEmpty()) {
                            ((bk)localObject4).FLM.remove(i);
                          }
                        }
                      }
                    }
                  }
                  for (;;)
                  {
                    if (paramAnonymousa != null) {
                      break label1579;
                    }
                    i = 0;
                    break;
                    j -= 1;
                    break label1488;
                    i -= 1;
                    break label1459;
                    paramAnonymousa = null;
                  }
                  label1579:
                  com.tencent.mm.plugin.expt.hellhound.core.stack.c.a((bk)localObject4);
                  if (((g)localObject3).qZn != null)
                  {
                    paramAnonymousa.FLG.timestamp = l;
                    ((g)localObject3).qZn.b(paramAnonymousa, (bj)g.cpz().get(1));
                  }
                  i = 1;
                }
              }
              if (paramAnonymousa.qYQ != null)
              {
                localObject1 = (ccg)paramAnonymousa.qYQ;
                if (localObject1 != null)
                {
                  ae.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_moveTaskToBack: %s", new Object[] { ((ccg)localObject1).GKT.activityName });
                  paramAnonymousa = c.this;
                  localObject2 = ((ccg)localObject1).GKT;
                  bool = ((ccg)localObject1).Hcf;
                  localObject1 = c.a((dol)localObject2);
                  if (localObject1 != null)
                  {
                    ae.d("HABBYGE-MALI.AsyncActivityMonitor", "_moveTaskToBack: %s", new Object[] { ((dol)localObject1).activityName });
                    if (!TextUtils.isEmpty(((dol)localObject1).activityName))
                    {
                      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(((dol)localObject1).activityName, null, 103);
                      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt().qZj.qZk;
                      localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.c.cpr();
                      localObject4 = new bj();
                      ((bj)localObject4).FLG = new dol();
                      ((bj)localObject4).FLG.activityName = ((dol)localObject1).activityName;
                      ((bj)localObject4).FLG.aHQ = ((dol)localObject1).aHQ;
                      ((bj)localObject4).FLG.timestamp = ((dol)localObject1).timestamp;
                      localObject5 = g.a((bk)localObject3, (bj)localObject4);
                      if (localObject5 != null)
                      {
                        localObject6 = (dnf)((com.tencent.mm.vending.j.b)localObject5).get(0);
                        i = ((Integer)((com.tencent.mm.vending.j.c)localObject5).get(1)).intValue();
                        if (((bool) || (com.tencent.mm.plugin.expt.hellhound.core.stack.h.a(((bj)((dnf)localObject6).HUq.getFirst()).FLG, ((bj)localObject4).FLG))) && (i == ((bk)localObject3).FLM.size() - 1))
                        {
                          ((bk)localObject3).FLM.remove(i);
                          ((bk)localObject3).FLM.addFirst(localObject6);
                          com.tencent.mm.plugin.expt.hellhound.core.stack.c.a((bk)localObject3);
                          if (((g)localObject2).qZn != null) {
                            ((g)localObject2).qZn.d((bj)localObject4, g.e((bk)localObject3));
                          }
                        }
                      }
                      c.aV(((dol)localObject1).activityName, false);
                      if (paramAnonymousa.qZo != null) {
                        paramAnonymousa.qZo.f(((dol)localObject1).activityName, ((dol)localObject1).aHQ, ((dol)localObject1).timestamp);
                      }
                    }
                  }
                }
                AppMethodBeat.o(121937);
                return;
                if (paramAnonymousa.qYQ != null)
                {
                  paramAnonymousa = (cer)paramAnonymousa.qYQ;
                  if (paramAnonymousa != null)
                  {
                    ae.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onCreate: %s", new Object[] { paramAnonymousa.GKT.activityName });
                    localObject1 = c.this;
                    localObject2 = paramAnonymousa.GKT;
                    c.a(paramAnonymousa.flags, (dol)localObject2);
                    if (((c)localObject1).qZo != null) {
                      ((c)localObject1).qZo.adX(((dol)localObject2).activityName);
                    }
                  }
                  AppMethodBeat.o(121937);
                  return;
                  if (paramAnonymousa.qYQ != null)
                  {
                    localObject1 = (cer)paramAnonymousa.qYQ;
                    if (localObject1 != null)
                    {
                      ae.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onNewIntent: %s", new Object[] { ((cer)localObject1).GKT.activityName });
                      paramAnonymousa = c.this;
                      i = ((cer)localObject1).flags;
                      localObject1 = ((cer)localObject1).GKT;
                      c.a(i, (dol)localObject1);
                      if (paramAnonymousa.qZo != null) {
                        paramAnonymousa.qZo.adY(((dol)localObject1).activityName);
                      }
                    }
                    AppMethodBeat.o(121937);
                    return;
                    if (paramAnonymousa.qYQ != null)
                    {
                      paramAnonymousa = (dol)paramAnonymousa.qYQ;
                      if (paramAnonymousa != null)
                      {
                        ae.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onResume: %s", new Object[] { paramAnonymousa.activityName });
                        localObject1 = c.this;
                        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.cY(com.tencent.mm.plugin.expt.hellhound.core.a.cpd().cpc());
                        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(paramAnonymousa.activityName, null, 105);
                        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
                        com.tencent.mm.plugin.expt.hellhound.core.stack.d.aeL(paramAnonymousa.activityName);
                        c.a(paramAnonymousa.activityName, paramAnonymousa.aHQ, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qZc);
                        if (((c)localObject1).qZo != null) {
                          ((c)localObject1).qZo.g(paramAnonymousa.activityName, paramAnonymousa.aHQ, paramAnonymousa.timestamp);
                        }
                      }
                      AppMethodBeat.o(121937);
                      return;
                      if (paramAnonymousa.qYQ != null)
                      {
                        paramAnonymousa = (String)paramAnonymousa.qYQ;
                        ae.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_UPDATE_SID: %s", new Object[] { paramAnonymousa });
                        if (!TextUtils.isEmpty(paramAnonymousa)) {
                          com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afF(paramAnonymousa);
                        }
                        AppMethodBeat.o(121937);
                        return;
                        if (paramAnonymousa.qYQ != null)
                        {
                          paramAnonymousa = (ces)paramAnonymousa.qYQ;
                          if (paramAnonymousa != null)
                          {
                            ae.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPostResume: %s", new Object[] { paramAnonymousa.GKT.activityName });
                            if (c.this.qZo != null) {
                              c.this.qZo.adZ(paramAnonymousa.GKT.activityName);
                            }
                          }
                          AppMethodBeat.o(121937);
                          return;
                          if (paramAnonymousa.qYQ != null)
                          {
                            paramAnonymousa = (dol)paramAnonymousa.qYQ;
                            if (paramAnonymousa != null)
                            {
                              ae.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPause: %s", new Object[] { paramAnonymousa.activityName });
                              localObject1 = c.this;
                              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(paramAnonymousa.activityName, null, 106);
                              c.a(paramAnonymousa.activityName, paramAnonymousa.aHQ, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qZd);
                              if (((c)localObject1).qZo != null) {
                                ((c)localObject1).qZo.h(paramAnonymousa.activityName, paramAnonymousa.aHQ, paramAnonymousa.timestamp);
                              }
                            }
                            AppMethodBeat.o(121937);
                            return;
                            if (paramAnonymousa.qYQ != null)
                            {
                              paramAnonymousa = (ces)paramAnonymousa.qYQ;
                              if (paramAnonymousa != null)
                              {
                                ae.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPaused: %s", new Object[] { paramAnonymousa.GKT.activityName });
                                if (c.this.qZo != null) {
                                  c.this.qZo.aea(paramAnonymousa.GKT.activityName);
                                }
                              }
                              AppMethodBeat.o(121937);
                              return;
                              if (paramAnonymousa.qYQ != null)
                              {
                                paramAnonymousa = (dol)paramAnonymousa.qYQ;
                                if (paramAnonymousa != null)
                                {
                                  ae.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onStop: %s", new Object[] { paramAnonymousa.activityName });
                                  localObject1 = c.this;
                                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.aet(paramAnonymousa.activityName))
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(paramAnonymousa.activityName, null, 107);
                                    c.a(paramAnonymousa.activityName, paramAnonymousa.aHQ, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qZe);
                                    if (((c)localObject1).qZo != null) {
                                      ((c)localObject1).qZo.i(paramAnonymousa.activityName, paramAnonymousa.aHQ, paramAnonymousa.timestamp);
                                    }
                                  }
                                }
                                AppMethodBeat.o(121937);
                                return;
                                if (paramAnonymousa.qYQ != null)
                                {
                                  paramAnonymousa = (dol)paramAnonymousa.qYQ;
                                  if (paramAnonymousa != null)
                                  {
                                    ae.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onDestroy: %s", new Object[] { paramAnonymousa.activityName });
                                    localObject1 = c.this;
                                    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(paramAnonymousa.activityName, null, 108);
                                    c.a(paramAnonymousa.activityName, paramAnonymousa.aHQ, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qZf);
                                    if (((c)localObject1).qZo != null) {
                                      ((c)localObject1).qZo.dd(paramAnonymousa.activityName, paramAnonymousa.aHQ);
                                    }
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  ae.i("HABBYGE-MALI.AsyncActivityMonitor", "HellMsgType.MSGQ_TYPE_FRAGMENT_RESUME recv !!");
                                  paramAnonymousa = (aub)paramAnonymousa.qYQ;
                                  if (paramAnonymousa != null) {
                                    com.tencent.mm.plugin.expt.hellhound.core.a.cpd().qYD.a(paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (aua)paramAnonymousa.qYQ;
                                  if (paramAnonymousa != null) {
                                    com.tencent.mm.plugin.expt.hellhound.core.a.cpd().qYD.a(paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  ae.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_FRAGMENT_%d", new Object[] { Integer.valueOf(paramAnonymousa.msgType) });
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.cpd();
                                  i = paramAnonymousa.msgType;
                                  l = ((Long)paramAnonymousa.qYQ).longValue();
                                  ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject1).qYD.Q(i, l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  ae.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_STORY_%d", new Object[] { Integer.valueOf(paramAnonymousa.msgType) });
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.cpd();
                                  i = paramAnonymousa.msgType;
                                  l = ((Long)paramAnonymousa.qYQ).longValue();
                                  ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject1).qYD.R(i, l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  try
                                  {
                                    i = ((Integer)paramAnonymousa.qYQ).intValue();
                                    if (paramAnonymousa.msgType == 401)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.e.a.DB(i);
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                  }
                                  catch (Exception paramAnonymousa)
                                  {
                                    ae.printErrStackTrace("HABBYGE-MALI.AsyncActivityMonitor", paramAnonymousa, "CATCH_ACTIVITY_ONRESUME: %s", new Object[] { paramAnonymousa.getMessage() });
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 400)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.DA(i);
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 402)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.DA(i);
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 403) {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.DB(i);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject2 = com.tencent.mm.plugin.expt.hellhound.a.c.c.cqP();
                                  ae.i("HABBYGE-MALI.HellFrontBackMonitor", "add8EventMMProcessEndIfNeed");
                                  int k;
                                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.cpe())
                                  {
                                    paramAnonymousa = null;
                                    if (paramAnonymousa != null)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.c.a.Dv(8);
                                      a.Df(8);
                                      localObject1 = (String)paramAnonymousa.get(0);
                                      i = ((Integer)paramAnonymousa.get(1)).intValue();
                                      j = ((Integer)paramAnonymousa.get(2)).intValue();
                                      l = ((Long)paramAnonymousa.get(3)).longValue();
                                      k = ((Integer)paramAnonymousa.get(4)).intValue();
                                      ae.i("HABBYGE-MALI.HellFrontBackMonitor", "add8EventMMProcessEndIfNeed need 补充8事件: %s, %d, %s, %d", new Object[] { localObject1, Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(k) });
                                      if (((com.tencent.mm.plugin.expt.hellhound.a.c.c)localObject2).rgu != null) {
                                        ((com.tencent.mm.plugin.expt.hellhound.a.c.c)localObject2).rgu.a((String)localObject1, i, j, l, k);
                                      }
                                    }
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  i = Process.myPid();
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.a.c.a.cqO();
                                  paramAnonymousa = (com.tencent.mm.plugin.expt.hellhound.core.a.a.a)localObject1;
                                  if (localObject1 == null) {
                                    paramAnonymousa = new auh();
                                  }
                                  if (paramAnonymousa.GLf <= 0)
                                  {
                                    ae.i("HABBYGE-MALI.FrontBackDao", "handleLastProcessParams lastMMProcessId <= 0");
                                    paramAnonymousa = null;
                                  }
                                  for (;;)
                                  {
                                    break;
                                    if (paramAnonymousa.GLf != i)
                                    {
                                      ae.i("HABBYGE-MALI.FrontBackDao", "handleLastProcessParams last != curr ---1: %d, %d", new Object[] { Integer.valueOf(paramAnonymousa.GLf), Integer.valueOf(i) });
                                      if (paramAnonymousa.GLd == 7)
                                      {
                                        com.tencent.mm.plugin.expt.hellhound.a.c.c.cqP();
                                        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.c.a.cqO();
                                        if ((localObject1 != null) && (((auh)localObject1).GLh)) {}
                                        for (i = 1;; i = 0)
                                        {
                                          if (i == 0) {
                                            break label3451;
                                          }
                                          ae.i("HABBYGE-MALI.FrontBackDao", "getIsLogoutFromMMPageFlowService true");
                                          com.tencent.mm.plugin.expt.hellhound.a.c.a.la(false);
                                          paramAnonymousa = null;
                                          break;
                                        }
                                        label3451:
                                        if (TextUtils.isEmpty("page_hell_seq_mmkv_key")) {}
                                        for (i = -1;; i = ay.aRW("_hellhound_mmkv").getInt("page_hell_seq_mmkv_key", -1))
                                        {
                                          paramAnonymousa.iqb = i;
                                          localObject1 = paramAnonymousa.GLg;
                                          i = paramAnonymousa.aHQ;
                                          j = paramAnonymousa.GLf;
                                          l = paramAnonymousa.GLe;
                                          k = paramAnonymousa.iqb;
                                          paramAnonymousa = new com.tencent.mm.vending.j.f();
                                          paramAnonymousa.LFB = new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(k) };
                                          paramAnonymousa = (com.tencent.mm.vending.j.f)paramAnonymousa;
                                          break;
                                        }
                                      }
                                    }
                                    else
                                    {
                                      ae.i("HABBYGE-MALI.FrontBackDao", "handleLastProcessParams last == curr: %d, %d", new Object[] { Integer.valueOf(paramAnonymousa.GLf), Integer.valueOf(i) });
                                    }
                                    paramAnonymousa = null;
                                  }
                                  localObject1 = (bov)paramAnonymousa.qYQ;
                                  if (localObject1 != null)
                                  {
                                    paramAnonymousa = ((bov)localObject1).kNn;
                                    localObject1 = ((bov)localObject1).value;
                                    ae.i("HABBYGE-MALI.SyncBizCollector", "_collectBizData: %s, %s", new Object[] { paramAnonymousa, localObject1 });
                                    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
                                    localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aer((String)com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpv().get(0));
                                    if (localObject2 != null)
                                    {
                                      ae.i("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, curActivityName: %s", new Object[] { localObject2 });
                                      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.d.d.cqV();
                                      if (localObject3 != null) {
                                        break label3741;
                                      }
                                      ae.e("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, matchInfo is NULL !!");
                                    }
                                    label3986:
                                    for (;;)
                                    {
                                      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.a.b.crl();
                                      if (localObject3 != null) {
                                        break;
                                      }
                                      ae.e("HABBYGE-MALI.SyncBizCollector", "collectBizData, tuple2 is NULL");
                                      AppMethodBeat.o(121937);
                                      return;
                                      label3741:
                                      if (((auq)localObject3).GLz.isEmpty())
                                      {
                                        ae.e("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, matchInfo.sessionFuzzyPaths is NULL !!");
                                      }
                                      else
                                      {
                                        localObject4 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
                                        if (localObject4 == null)
                                        {
                                          ae.e("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, curSession is NULL !!");
                                        }
                                        else
                                        {
                                          localObject5 = new bov();
                                          ((bov)localObject5).kNn = paramAnonymousa;
                                          ((bov)localObject5).value = ((String)localObject1);
                                          i = ((auq)localObject3).GLz.size() - 1;
                                          while (i >= 0)
                                          {
                                            localObject6 = (dca)((auq)localObject3).GLz.get(i);
                                            if ((localObject6 != null) && (((dca)localObject6).dAa != null) && (((dca)localObject6).dAa.equals(((cie)localObject4).sessionId)))
                                            {
                                              localObject6 = ((dca)localObject6).GLy.iterator();
                                              while (((Iterator)localObject6).hasNext())
                                              {
                                                aus localaus = (aus)((Iterator)localObject6).next();
                                                if (!localaus.GLG.isEmpty())
                                                {
                                                  j = localaus.GLG.size() - 1;
                                                  for (;;)
                                                  {
                                                    if (j < 0) {
                                                      break label3986;
                                                    }
                                                    aur localaur = (aur)localaus.GLG.get(j);
                                                    if (localaur != null)
                                                    {
                                                      String str = com.tencent.mm.plugin.expt.hellhound.core.b.aer(localaur.name);
                                                      if ((str != null) && (str.equals(localObject2)))
                                                      {
                                                        localaur.GLC.addLast(localObject5);
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
                                          com.tencent.mm.plugin.expt.hellhound.a.d.d.a((auq)localObject3);
                                        }
                                      }
                                    }
                                    localObject2 = (bou)((com.tencent.mm.vending.j.b)localObject3).get(0);
                                    i = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
                                    localObject3 = new bov();
                                    ((bov)localObject3).kNn = paramAnonymousa;
                                    ((bov)localObject3).value = ((String)localObject1);
                                    ((bou)localObject2).GLC.add(localObject3);
                                    ((bou)localObject2).Hcl.add(localObject3);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((bou)localObject2, i);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject1 = (String)paramAnonymousa.qYQ;
                                  if (localObject1 != null)
                                  {
                                    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.a.b.crl();
                                    if (localObject2 != null) {
                                      break label4151;
                                    }
                                    ae.e("HABBYGE-MALI.AsyncBizCollector", "getBizId, tuple2 is NULL");
                                  }
                                  for (paramAnonymousa = null;; paramAnonymousa = ((bov)localObject2).kNn)
                                  {
                                    ae.i("HABBYGE-MALI.AsyncBizCollector", "AsyncBizCollector, _collectBizId: %s", new Object[] { paramAnonymousa });
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.crm();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.fY((String)localObject1, paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label4151:
                                    paramAnonymousa = (bou)((com.tencent.mm.vending.j.b)localObject2).get(0);
                                    i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
                                    j = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.fw(paramAnonymousa.GLC.size() + 1, paramAnonymousa.Hcl.size() + 1);
                                    localObject2 = new bov();
                                    ((bov)localObject2).kNn = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.v(paramAnonymousa.startTime, j);
                                    paramAnonymousa.GLC.add(localObject2);
                                    paramAnonymousa.Hcl.add(localObject2);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramAnonymousa, i);
                                    ae.i("HABBYGE-MALI.AsyncBizCollector", "getBizId, addBizIdCurPageFlowItem: %s", new Object[] { ((bov)localObject2).kNn });
                                  }
                                  localObject1 = (bov)paramAnonymousa.qYQ;
                                  if (localObject1 != null)
                                  {
                                    paramAnonymousa = ((bov)localObject1).dGe;
                                    localObject2 = ((bov)localObject1).value;
                                    localObject3 = ((bov)localObject1).kNn;
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.a.X(paramAnonymousa, (String)localObject2, (String)localObject3);
                                    if (localObject1 != null)
                                    {
                                      ae.i("HABBYGE-MALI.AsyncBizCollector", "_collectBizData: %s, %s, %s", new Object[] { paramAnonymousa, localObject2, localObject3 });
                                      if (localObject1 != null)
                                      {
                                        paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.a.crA();
                                        if ((paramAnonymousa == null) || (paramAnonymousa.isEmpty()))
                                        {
                                          paramAnonymousa = new JSONArray();
                                          paramAnonymousa.put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.afU(System.currentTimeMillis() + "@" + paramAnonymousa.toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        if ("-1".equals(paramAnonymousa))
                                        {
                                          ae.e("HABBYGE-MALI.AsyncBizDao", " AsyncBizDao putBiz NOT LOGIN");
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        if (paramAnonymousa.split("@").length <= 1)
                                        {
                                          localObject2 = new JSONArray();
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.afU(paramAnonymousa + "@" + ((JSONArray)localObject2).toString());
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
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.afU(System.currentTimeMillis() + "@" + paramAnonymousa.toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                          paramAnonymousa = paramAnonymousa.split("@");
                                          if (paramAnonymousa.length <= 0) {
                                            paramAnonymousa = null;
                                          } else if (paramAnonymousa.length == 1) {
                                            paramAnonymousa = com.tencent.mm.vending.j.a.N(paramAnonymousa[0], null);
                                          } else {
                                            paramAnonymousa = com.tencent.mm.vending.j.a.N(paramAnonymousa[0], paramAnonymousa[1]);
                                          }
                                        }
                                        if ((TextUtils.isEmpty((CharSequence)paramAnonymousa.get(1))) && (!TextUtils.isEmpty((CharSequence)paramAnonymousa.get(0))))
                                        {
                                          localObject2 = new JSONArray();
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.afU((String)paramAnonymousa.get(0) + "@" + ((JSONArray)localObject2).toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        try
                                        {
                                          localObject2 = new JSONArray((String)paramAnonymousa.get(1));
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.afU((String)paramAnonymousa.get(0) + "@" + ((JSONArray)localObject2).toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        catch (JSONException paramAnonymousa)
                                        {
                                          ae.printErrStackTrace("HABBYGE-MALI.AsyncBizDao", paramAnonymousa, "AsyncBizDao.putBiz crash: %s", new Object[] { paramAnonymousa.getMessage() });
                                        }
                                      }
                                    }
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qYQ;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().crj();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.crm();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.ga(paramAnonymousa, (String)localObject1);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qYQ;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.d.crn();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.crm();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.fZ(paramAnonymousa, (String)localObject1);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                  l = ((Long)paramAnonymousa.qYQ).longValue();
                                  ae.i("HABBYGE-MALI.VoipFloatSession", "VoipMonitorCallback: _videoActivity2VoipFloat");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.vu(l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                  l = ((Long)paramAnonymousa.qYQ).longValue();
                                  localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject1).rgU;
                                  ae.i("HABBYGE-MALI.VoipFloatSession", "VoipMonitorCallback: _voipFloat2VideoActivity");
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
                                  if ((paramAnonymousa != null) && (!TextUtils.isEmpty(paramAnonymousa.sessionId))) {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(paramAnonymousa, l);
                                  }
                                  ae.i("HABBYGE-MALI.VoipFloatSession", "_beignVoipSession");
                                  bool = false;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
                                  if (paramAnonymousa == null)
                                  {
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(null, "LauncherUI", "VideoActivity", 0, l);
                                    if (paramAnonymousa == null)
                                    {
                                      ae.e("HABBYGE-MALI.VoipFloatSession", "_beignFloatSession, 不是合法session ~~~");
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                    bool = true;
                                    ae.i("HABBYGE-MALI.VoipFloatSession", "_beignFloatSession, isNewSession: %s, %b", new Object[] { paramAnonymousa.sessionId, Boolean.valueOf(bool) });
                                    if ((((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject1).rhB == null) || (!((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject1).rhB.equals("com.tencent.mm.plugin.voip.ui.VideoActivity"))) {
                                      break label5182;
                                    }
                                  }
                                  label5182:
                                  for (i = ((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject1).rhC;; i = 0)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramAnonymousa, "VideoActivity", i, l);
                                    if (!bool) {
                                      break label5187;
                                    }
                                    paramAnonymousa.hTf = 0;
                                    localObject2 = m.crj();
                                    localObject1 = localObject2;
                                    if (localObject2 == null) {
                                      localObject1 = "";
                                    }
                                    paramAnonymousa.sCx = ((String)localObject1);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(paramAnonymousa);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    ae.i("HABBYGE-MALI.VoipFloatSession", "_beignFloatSession, curSession: %s", new Object[] { paramAnonymousa.sessionId });
                                    break;
                                  }
                                  label5187:
                                  com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(paramAnonymousa);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                  l = ((Long)paramAnonymousa.qYQ).longValue();
                                  ae.i("HABBYGE-MALI.VoipFloatSession", "VoipMonitorCallback: _closeVideoActivity");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.vu(l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                  l = ((Long)paramAnonymousa.qYQ).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.csg();
                                  if (paramAnonymousa != null)
                                  {
                                    paramAnonymousa.GKs = -1;
                                    paramAnonymousa.GKt = -1;
                                    paramAnonymousa.GKv = 7;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.a(paramAnonymousa);
                                  }
                                  ae.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, stat, show: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cse()) });
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
                                  if ((paramAnonymousa == null) || (TextUtils.isEmpty(paramAnonymousa.sessionId)))
                                  {
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.core.b.cpg();
                                    if (paramAnonymousa != null)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.am((String)paramAnonymousa.first, l);
                                    }
                                  }
                                  for (;;)
                                  {
                                    ae.d("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession");
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
                                    bool = false;
                                    if (paramAnonymousa != null) {
                                      break label5502;
                                    }
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(null, "LauncherUI", "FloatingBall", 0, l);
                                    if (paramAnonymousa != null) {
                                      break;
                                    }
                                    ae.e("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession, 不是合法session ~~~");
                                    AppMethodBeat.o(121937);
                                    return;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(paramAnonymousa, l);
                                  }
                                  bool = true;
                                  for (;;)
                                  {
                                    ae.d("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession, isNewSession: %s, %b", new Object[] { paramAnonymousa.sessionId, Boolean.valueOf(bool) });
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramAnonymousa, "FloatBall", 0, l);
                                    if (!bool) {
                                      break;
                                    }
                                    paramAnonymousa.hTf = 0;
                                    localObject2 = m.crj();
                                    localObject1 = localObject2;
                                    if (localObject2 == null) {
                                      localObject1 = "";
                                    }
                                    paramAnonymousa.sCx = ((String)localObject1);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(paramAnonymousa);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label5502:
                                    ae.d("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession, curSession: %s", new Object[] { paramAnonymousa.sessionId });
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(paramAnonymousa);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                  l = ((Long)paramAnonymousa.qYQ).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.csf();
                                  if (paramAnonymousa != null)
                                  {
                                    i = ((Integer)paramAnonymousa.second).intValue();
                                    if ((i != 1) && (i != 0)) {
                                      break label5685;
                                    }
                                  }
                                  label5685:
                                  for (bool = true;; bool = false)
                                  {
                                    ae.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatMenuHide, FloatSession, End: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
                                    if (bool)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.b(false, null, l);
                                    }
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.csg();
                                    paramAnonymousa = (com.tencent.mm.plugin.expt.hellhound.core.a.a.a)localObject1;
                                    if (localObject1 == null) {
                                      paramAnonymousa = new atn();
                                    }
                                    paramAnonymousa.GKv = 8;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.a(paramAnonymousa);
                                    ae.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, stat, hide: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cse()) });
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                  l = ((Long)paramAnonymousa.qYQ).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.csf();
                                  if (paramAnonymousa != null)
                                  {
                                    if (((Integer)paramAnonymousa.second).intValue() == 6)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.b(false, null, l);
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.DC(4);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                  ae.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuBackgroundClicked");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.fx(1, 1);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                  ae.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuBackPressed");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.fx(0, 0);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                  ae.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuItemClicked");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.fx(2, 2);
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.lc(true);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                  ae.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuItemRemoved");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.fx(6, 6);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.b(false, null, 0L);
                                  AppMethodBeat.o(121937);
                                  return;
                                  i = ((Integer)paramAnonymousa.qYQ).intValue();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.DC(i);
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.g.c.csm();
                                  localObject1 = paramAnonymousa.rhO;
                                  localObject2 = paramAnonymousa.rch;
                                  localObject3 = paramAnonymousa.rhQ;
                                  ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).rch = ((com.tencent.mm.plugin.expt.hellhound.a.a.e)localObject2);
                                  com.tencent.mm.hellhoundlib.a.ahD();
                                  com.tencent.mm.hellhoundlib.a.e(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qZY, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).rhL);
                                  ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).rhJ = ((com.tencent.mm.plugin.expt.hellhound.a.g.a)localObject3);
                                  com.tencent.mm.hellhoundlib.a.ahD();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).rcg, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).rhM);
                                  com.tencent.mm.hellhoundlib.a.ahD();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).qXf, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).rhM);
                                  com.tencent.mm.hellhoundlib.a.ahD();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).rhK, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).rhL);
                                  if (paramAnonymousa.mActivityRef != null) {
                                    paramAnonymousa.rcz.a(0, (Activity)paramAnonymousa.mActivityRef.get());
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.g.c.csm();
                                  paramAnonymousa.rcz.a(1, null);
                                  paramAnonymousa = paramAnonymousa.rhO;
                                  com.tencent.mm.hellhoundlib.a.ahD();
                                  com.tencent.mm.hellhoundlib.a.f(paramAnonymousa.qZY, paramAnonymousa.rhL);
                                  paramAnonymousa.rch = null;
                                  com.tencent.mm.hellhoundlib.a.ahD();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.rcg, paramAnonymousa.rhM);
                                  com.tencent.mm.hellhoundlib.a.ahD();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.qXf, paramAnonymousa.rhM);
                                  paramAnonymousa.rhJ = null;
                                  com.tencent.mm.hellhoundlib.a.ahD();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.rhK, paramAnonymousa.rhL);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.g.c.csm().rcz.a(2, null);
                                  com.tencent.mm.plugin.expt.hellhound.a.g.c.rhP = null;
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.g.c.csm().rcz.a(3, null);
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qYQ;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.rcx;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aP(0, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qYQ;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.rcx;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aP(1, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qYQ;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.rcx;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aP(2, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.qYQ;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.rcx;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aP(3, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.vt(((Long)paramAnonymousa.qYQ).longValue());
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.csc();
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.core.b.c.e.b((dwx)paramAnonymousa.qYQ);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.b.a.a((bcx)paramAnonymousa.qYQ);
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
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c localc = com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq();
    com.tencent.mm.plugin.expt.hellhound.core.a.a.d locald = this.qZs;
    localc.qYU.qYW = locald;
    AppMethodBeat.o(121938);
  }
  
  private static com.tencent.mm.vending.j.d<String, Boolean, Boolean> Z(Activity paramActivity)
  {
    AppMethodBeat.i(121940);
    com.tencent.mm.vending.j.c localc = aa(paramActivity);
    if (!((Boolean)localc.get(1)).booleanValue())
    {
      paramActivity = com.tencent.mm.vending.j.a.i(localc.get(0), localc.get(1), Boolean.FALSE);
      AppMethodBeat.o(121940);
      return paramActivity;
    }
    boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.aem(paramActivity.getClass().getCanonicalName());
    paramActivity = com.tencent.mm.vending.j.a.i(localc.get(0), localc.get(1), Boolean.valueOf(bool));
    AppMethodBeat.o(121940);
    return paramActivity;
  }
  
  static dol a(dol paramdol)
  {
    AppMethodBeat.i(184315);
    dol localdol;
    if (paramdol != null)
    {
      localdol = paramdol;
      if (!TextUtils.isEmpty(paramdol.activityName)) {
        break label88;
      }
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
      com.tencent.mm.vending.j.c localc = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpu();
      if (localc == null)
      {
        AppMethodBeat.o(184315);
        return null;
      }
      localdol = paramdol;
      if (paramdol == null)
      {
        localdol = new dol();
        localdol.timestamp = System.currentTimeMillis();
      }
      localdol.activityName = ((String)localc.get(0));
      localdol.aHQ = ((Integer)localc.get(1)).intValue();
      label88:
      AppMethodBeat.o(184315);
      return localdol;
    }
    catch (Exception paramdol)
    {
      ae.printErrStackTrace("HABBYGE-MALI.AsyncActivityMonitor", paramdol, "getActivityOnFinish", new Object[0]);
      AppMethodBeat.o(184315);
    }
    return null;
  }
  
  static void a(int paramInt, dol paramdol)
  {
    AppMethodBeat.i(184313);
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(paramdol.activityName, null, 104);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Dh(101);
    if (localObject != null) {}
    for (localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);; localObject = null)
    {
      if (!paramdol.activityName.equals(localObject))
      {
        ae.w("HABBYGE-MALI.AsyncActivityMonitor", "_onCreateEvent: %s, %s", new Object[] { localObject, paramdol.activityName });
        b(paramInt, null, null, paramdol.activityName, paramdol.aHQ, paramdol.timestamp);
      }
      a(paramdol.activityName, paramdol.aHQ, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qZb);
      AppMethodBeat.o(184313);
      return;
    }
  }
  
  static void a(String paramString, int paramInt, com.tencent.mm.plugin.expt.hellhound.core.stack.a parama)
  {
    AppMethodBeat.i(195997);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(paramString, paramInt, parama);
    AppMethodBeat.o(195997);
  }
  
  static void aV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(121943);
    a.Df(1);
    if ((!paramBoolean) && (com.tencent.mm.plugin.expt.hellhound.core.b.aem(paramString)))
    {
      ae.i("HABBYGE-MALI.AsyncActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
      AppMethodBeat.o(121943);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
    bj localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cpy();
    String str = null;
    if (localbj != null) {
      str = localbj.FLG.activityName;
    }
    a.aeQ(paramString);
    a.aeO(str);
    ae.i("HABBYGE-MALI.AsyncActivityMonitor", "setActivityActionOnFinish: from: %s, to: %s", new Object[] { paramString, str });
    AppMethodBeat.o(121943);
  }
  
  static com.tencent.mm.vending.j.c<String, Boolean> aa(Activity paramActivity)
  {
    AppMethodBeat.i(121942);
    String str = null;
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.h.ac(paramActivity);
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
    paramActivity = com.tencent.mm.vending.j.a.N(localObject, Boolean.valueOf(bool));
    AppMethodBeat.o(121942);
    return paramActivity;
  }
  
  static void b(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(195998);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt().a(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramLong);
    AppMethodBeat.o(195998);
  }
  
  static ces c(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(184312);
    ces localces = new ces();
    localces.GKT = new dol();
    localces.GKT.activityName = paramActivity.getClass().getCanonicalName();
    localces.GKT.aHQ = paramActivity.hashCode();
    localces.GKT.timestamp = paramLong;
    paramActivity = Z(paramActivity);
    localces.GKU = ((String)paramActivity.get(0));
    localces.GKX = ((Boolean)paramActivity.get(1)).booleanValue();
    localces.Hce = ((Boolean)paramActivity.get(2)).booleanValue();
    AppMethodBeat.o(184312);
    return localces;
  }
  
  static cer g(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121941);
    cer localcer = new cer();
    if (paramIntent != null) {
      localcer.flags = paramIntent.getFlags();
    }
    localcer.GKT = new dol();
    if (paramActivity == null)
    {
      AppMethodBeat.o(121941);
      return localcer;
    }
    localcer.GKT.activityName = paramActivity.getClass().getCanonicalName();
    localcer.GKT.aHQ = paramActivity.hashCode();
    localcer.GKT.timestamp = System.currentTimeMillis();
    AppMethodBeat.o(121941);
    return localcer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.c
 * JD-Core Version:    0.7.0.1
 */