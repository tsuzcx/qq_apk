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
import com.tencent.mm.protocal.protobuf.ben;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bfq;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.protocal.protobuf.cuy;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.protocal.protobuf.eci;
import com.tencent.mm.protocal.protobuf.egw;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;

final class c
{
  d.a szF;
  private final com.tencent.mm.plugin.expt.hellhound.core.a.a.d szJ;
  
  c()
  {
    AppMethodBeat.i(121938);
    this.szJ = new com.tencent.mm.plugin.expt.hellhound.core.a.a.d()
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
          if (paramAnonymousa.szh != null)
          {
            Object localObject1 = (eci)paramAnonymousa.szh;
            Object localObject2;
            Object localObject3;
            boolean bool;
            Object localObject4;
            Object localObject5;
            Object localObject6;
            if (localObject1 != null)
            {
              Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_startActivity: %s, %s, %s", new Object[] { ((eci)localObject1).Mhd.activityName, ((eci)localObject1).Mhe.activityName, ((eci)localObject1).LOY });
              localObject2 = c.this;
              paramAnonymousa = null;
              if ((((eci)localObject1).Mhd == null) || (TextUtils.isEmpty(((eci)localObject1).Mhd.activityName))) {
                break label1104;
              }
              paramAnonymousa = ((eci)localObject1).Mhd.activityName;
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY();
              bool = ((eci)localObject1).LPb;
              localObject4 = ((eci)localObject1).LOY;
              ((com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c)localObject3).szQ.b(paramAnonymousa, bool, (String)localObject4);
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(paramAnonymousa, ((eci)localObject1).LOY, 100);
              localObject3 = ((eci)localObject1).Mhe.activityName;
              Log.i("HABBYGE-MALI.AsyncActivityMonitor", "_startActivity, toActivity: %s, %s", new Object[] { paramAnonymousa, localObject3 });
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N((String)localObject3, null, 101);
              localObject4 = ((eci)localObject1).LPa;
              localObject5 = ((eci)localObject1).Mhg;
              localObject6 = ((eci)localObject1).Mhf;
              if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.go("Chat_User", (String)localObject4);
              }
              if ((!"1".equals(localObject6)) || (!"jd_store".equals(localObject5))) {
                break label1137;
              }
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.go("minimize_secene", (String)localObject6);
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.go("KPublisherId", (String)localObject5);
            }
            for (;;)
            {
              c.b(((eci)localObject1).flags, paramAnonymousa, ((eci)localObject1).LOY, (String)localObject3, 0, ((eci)localObject1).timestamp);
              a.apd((String)localObject3);
              a.apf(paramAnonymousa);
              a.GQ(0);
              if ((localObject3 != null) && (((c)localObject2).szF != null)) {
                ((c)localObject2).szF.aof((String)localObject3);
              }
              AppMethodBeat.o(121937);
              return;
              label1104:
              com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
              if (localObject3 == null) {
                break;
              }
              paramAnonymousa = ((bn)localObject3).KFh.activityName;
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY().apj(paramAnonymousa);
              break;
              label1137:
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.go("minimize_secene", "");
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.go("KPublisherId", "");
            }
            if (paramAnonymousa.szh != null)
            {
              paramAnonymousa = (eih)paramAnonymousa.szh;
              long l;
              int i;
              if (paramAnonymousa != null)
              {
                Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_finish: %s", new Object[] { paramAnonymousa.activityName });
                localObject1 = c.this;
                localObject2 = c.a(paramAnonymousa);
                if (localObject2 != null)
                {
                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "_finish: %s", new Object[] { ((eih)localObject2).activityName });
                  com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(((eih)localObject2).activityName, null, 102);
                  localObject5 = ((eih)localObject2).activityName;
                  l = ((eih)localObject2).timestamp;
                  localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM().szA.szB;
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
                  Log.w("HABBYGE-MALI.AsyncActivityMonitor", "_finish, popSuccess FALSE");
                  paramAnonymousa = new bn();
                  paramAnonymousa.KFh = new eih();
                  paramAnonymousa.KFh.activityName = ((eih)localObject2).activityName;
                  paramAnonymousa.KFh.aHK = ((eih)localObject2).aHK;
                  paramAnonymousa.KFh.timestamp = ((eih)localObject2).timestamp;
                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(null, paramAnonymousa, 1, null);
                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.sDe;
                  com.tencent.mm.plugin.expt.hellhound.a.b.a.b.apq(((eih)localObject2).activityName);
                  com.tencent.mm.plugin.expt.hellhound.a.g.e.cQV().a(3, ((eih)localObject2).activityName, null);
                }
                c.aX(((eih)localObject2).activityName, true);
                if (((c)localObject1).szF != null) {
                  ((c)localObject1).szF.d(((eih)localObject2).activityName, ((eih)localObject2).aHK, ((eih)localObject2).timestamp);
                }
                AppMethodBeat.o(121937);
                return;
                localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.c.cNK();
                if (((bo)localObject4).KFn.isEmpty())
                {
                  i = 0;
                }
                else
                {
                  if (localObject4 != null)
                  {
                    i = ((bo)localObject4).KFn.size() - 1;
                    if (i >= 0)
                    {
                      localObject6 = (egw)((bo)localObject4).KFn.get(i);
                      j = ((egw)localObject6).NgI.size() - 1;
                      label1488:
                      if (j >= 0)
                      {
                        paramAnonymousa = (bn)((egw)localObject6).NgI.get(j);
                        if (paramAnonymousa.KFh.activityName.equals(localObject5))
                        {
                          ((egw)localObject6).NgI.remove(j);
                          if (((egw)localObject6).NgI.isEmpty()) {
                            ((bo)localObject4).KFn.remove(i);
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
                  com.tencent.mm.plugin.expt.hellhound.core.stack.c.a((bo)localObject4);
                  if (((g)localObject3).szE != null)
                  {
                    paramAnonymousa.KFh.timestamp = l;
                    ((g)localObject3).szE.b(paramAnonymousa, (bn)g.cNS().get(1));
                  }
                  i = 1;
                }
              }
              if (paramAnonymousa.szh != null)
              {
                localObject1 = (cri)paramAnonymousa.szh;
                if (localObject1 != null)
                {
                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_moveTaskToBack: %s", new Object[] { ((cri)localObject1).LOX.activityName });
                  paramAnonymousa = c.this;
                  localObject2 = ((cri)localObject1).LOX;
                  bool = ((cri)localObject1).Mhi;
                  localObject1 = c.a((eih)localObject2);
                  if (localObject1 != null)
                  {
                    Log.d("HABBYGE-MALI.AsyncActivityMonitor", "_moveTaskToBack: %s", new Object[] { ((eih)localObject1).activityName });
                    if (!TextUtils.isEmpty(((eih)localObject1).activityName))
                    {
                      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(((eih)localObject1).activityName, null, 103);
                      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM().szA.szB;
                      localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.c.cNK();
                      localObject4 = new bn();
                      ((bn)localObject4).KFh = new eih();
                      ((bn)localObject4).KFh.activityName = ((eih)localObject1).activityName;
                      ((bn)localObject4).KFh.aHK = ((eih)localObject1).aHK;
                      ((bn)localObject4).KFh.timestamp = ((eih)localObject1).timestamp;
                      localObject5 = g.a((bo)localObject3, (bn)localObject4);
                      if (localObject5 != null)
                      {
                        localObject6 = (egw)((com.tencent.mm.vending.j.b)localObject5).get(0);
                        i = ((Integer)((com.tencent.mm.vending.j.c)localObject5).get(1)).intValue();
                        if (((bool) || (com.tencent.mm.plugin.expt.hellhound.core.stack.h.a(((bn)((egw)localObject6).NgI.getFirst()).KFh, ((bn)localObject4).KFh))) && (i == ((bo)localObject3).KFn.size() - 1))
                        {
                          ((bo)localObject3).KFn.remove(i);
                          ((bo)localObject3).KFn.addFirst(localObject6);
                          com.tencent.mm.plugin.expt.hellhound.core.stack.c.a((bo)localObject3);
                          if (((g)localObject2).szE != null) {
                            ((g)localObject2).szE.d((bn)localObject4, g.e((bo)localObject3));
                          }
                        }
                      }
                      c.aX(((eih)localObject1).activityName, false);
                      if (paramAnonymousa.szF != null) {
                        paramAnonymousa.szF.e(((eih)localObject1).activityName, ((eih)localObject1).aHK, ((eih)localObject1).timestamp);
                      }
                    }
                  }
                }
                AppMethodBeat.o(121937);
                return;
                if (paramAnonymousa.szh != null)
                {
                  paramAnonymousa = (cuy)paramAnonymousa.szh;
                  if (paramAnonymousa != null)
                  {
                    Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onCreate: %s", new Object[] { paramAnonymousa.LOX.activityName });
                    localObject1 = c.this;
                    localObject2 = paramAnonymousa.LOX;
                    c.a(paramAnonymousa.flags, (eih)localObject2);
                    if (((c)localObject1).szF != null) {
                      ((c)localObject1).szF.aog(((eih)localObject2).activityName);
                    }
                  }
                  AppMethodBeat.o(121937);
                  return;
                  if (paramAnonymousa.szh != null)
                  {
                    localObject1 = (cuy)paramAnonymousa.szh;
                    if (localObject1 != null)
                    {
                      Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onNewIntent: %s", new Object[] { ((cuy)localObject1).LOX.activityName });
                      paramAnonymousa = c.this;
                      i = ((cuy)localObject1).flags;
                      localObject1 = ((cuy)localObject1).LOX;
                      c.a(i, (eih)localObject1);
                      if (paramAnonymousa.szF != null) {
                        paramAnonymousa.szF.aoh(((eih)localObject1).activityName);
                      }
                    }
                    AppMethodBeat.o(121937);
                    return;
                    if (paramAnonymousa.szh != null)
                    {
                      paramAnonymousa = (eih)paramAnonymousa.szh;
                      if (paramAnonymousa != null)
                      {
                        Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onResume: %s", new Object[] { paramAnonymousa.activityName });
                        localObject1 = c.this;
                        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.df(com.tencent.mm.plugin.expt.hellhound.core.a.cNx().cNw());
                        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(paramAnonymousa.activityName, null, 105);
                        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
                        com.tencent.mm.plugin.expt.hellhound.core.stack.d.apb(paramAnonymousa.activityName);
                        c.a(paramAnonymousa.activityName, paramAnonymousa.aHK, com.tencent.mm.plugin.expt.hellhound.core.stack.a.szt);
                        if (((c)localObject1).szF != null) {
                          ((c)localObject1).szF.f(paramAnonymousa.activityName, paramAnonymousa.aHK, paramAnonymousa.timestamp);
                        }
                      }
                      AppMethodBeat.o(121937);
                      return;
                      if (paramAnonymousa.szh != null)
                      {
                        paramAnonymousa = (String)paramAnonymousa.szh;
                        Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_UPDATE_SID: %s", new Object[] { paramAnonymousa });
                        if (!TextUtils.isEmpty(paramAnonymousa)) {
                          com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqq(paramAnonymousa);
                        }
                        AppMethodBeat.o(121937);
                        return;
                        if (paramAnonymousa.szh != null)
                        {
                          paramAnonymousa = (cuz)paramAnonymousa.szh;
                          if (paramAnonymousa != null)
                          {
                            Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPostResume: %s", new Object[] { paramAnonymousa.LOX.activityName });
                            if (c.this.szF != null) {
                              c.this.szF.aoi(paramAnonymousa.LOX.activityName);
                            }
                          }
                          AppMethodBeat.o(121937);
                          return;
                          if (paramAnonymousa.szh != null)
                          {
                            paramAnonymousa = (eih)paramAnonymousa.szh;
                            if (paramAnonymousa != null)
                            {
                              Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPause: %s", new Object[] { paramAnonymousa.activityName });
                              localObject1 = c.this;
                              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(paramAnonymousa.activityName, null, 106);
                              c.a(paramAnonymousa.activityName, paramAnonymousa.aHK, com.tencent.mm.plugin.expt.hellhound.core.stack.a.szu);
                              if (((c)localObject1).szF != null) {
                                ((c)localObject1).szF.g(paramAnonymousa.activityName, paramAnonymousa.aHK, paramAnonymousa.timestamp);
                              }
                            }
                            AppMethodBeat.o(121937);
                            return;
                            if (paramAnonymousa.szh != null)
                            {
                              paramAnonymousa = (cuz)paramAnonymousa.szh;
                              if (paramAnonymousa != null)
                              {
                                Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPaused: %s", new Object[] { paramAnonymousa.LOX.activityName });
                                if (c.this.szF != null) {
                                  c.this.szF.aoj(paramAnonymousa.LOX.activityName);
                                }
                              }
                              AppMethodBeat.o(121937);
                              return;
                              if (paramAnonymousa.szh != null)
                              {
                                paramAnonymousa = (eih)paramAnonymousa.szh;
                                if (paramAnonymousa != null)
                                {
                                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onStop: %s", new Object[] { paramAnonymousa.activityName });
                                  localObject1 = c.this;
                                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoG(paramAnonymousa.activityName))
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(paramAnonymousa.activityName, null, 107);
                                    c.a(paramAnonymousa.activityName, paramAnonymousa.aHK, com.tencent.mm.plugin.expt.hellhound.core.stack.a.szv);
                                    if (((c)localObject1).szF != null) {
                                      ((c)localObject1).szF.h(paramAnonymousa.activityName, paramAnonymousa.aHK, paramAnonymousa.timestamp);
                                    }
                                  }
                                }
                                AppMethodBeat.o(121937);
                                return;
                                if (paramAnonymousa.szh != null)
                                {
                                  paramAnonymousa = (eih)paramAnonymousa.szh;
                                  if (paramAnonymousa != null)
                                  {
                                    Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onDestroy: %s", new Object[] { paramAnonymousa.activityName });
                                    localObject1 = c.this;
                                    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(paramAnonymousa.activityName, null, 108);
                                    c.a(paramAnonymousa.activityName, paramAnonymousa.aHK, com.tencent.mm.plugin.expt.hellhound.core.stack.a.szw);
                                    if (((c)localObject1).szF != null) {
                                      ((c)localObject1).szF.dj(paramAnonymousa.activityName, paramAnonymousa.aHK);
                                    }
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "HellMsgType.MSGQ_TYPE_FRAGMENT_RESUME recv !!");
                                  paramAnonymousa = (bfk)paramAnonymousa.szh;
                                  if (paramAnonymousa != null) {
                                    com.tencent.mm.plugin.expt.hellhound.core.a.cNx().syU.a(paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (bfj)paramAnonymousa.szh;
                                  if (paramAnonymousa != null) {
                                    com.tencent.mm.plugin.expt.hellhound.core.a.cNx().syU.a(paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_FRAGMENT_%d", new Object[] { Integer.valueOf(paramAnonymousa.msgType) });
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.cNx();
                                  i = paramAnonymousa.msgType;
                                  l = ((Long)paramAnonymousa.szh).longValue();
                                  ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject1).syU.T(i, l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_STORY_%d", new Object[] { Integer.valueOf(paramAnonymousa.msgType) });
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.cNx();
                                  i = paramAnonymousa.msgType;
                                  l = ((Long)paramAnonymousa.szh).longValue();
                                  ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject1).syU.U(i, l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  try
                                  {
                                    i = ((Integer)paramAnonymousa.szh).intValue();
                                    if (paramAnonymousa.msgType == 401)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.e.a.Ho(i);
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                  }
                                  catch (Exception paramAnonymousa)
                                  {
                                    Log.printErrStackTrace("HABBYGE-MALI.AsyncActivityMonitor", paramAnonymousa, "CATCH_ACTIVITY_ONRESUME: %s", new Object[] { paramAnonymousa.getMessage() });
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 400)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.Hn(i);
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 402)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.Hn(i);
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 403) {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.Ho(i);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject2 = com.tencent.mm.plugin.expt.hellhound.a.c.c.cPx();
                                  Log.i("HABBYGE-MALI.HellFrontBackMonitor", "add8EventMMProcessEndIfNeed");
                                  int k;
                                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess())
                                  {
                                    paramAnonymousa = null;
                                    if (paramAnonymousa != null)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.c.a.Hi(8);
                                      a.GQ(8);
                                      localObject1 = (String)paramAnonymousa.get(0);
                                      i = ((Integer)paramAnonymousa.get(1)).intValue();
                                      j = ((Integer)paramAnonymousa.get(2)).intValue();
                                      l = ((Long)paramAnonymousa.get(3)).longValue();
                                      k = ((Integer)paramAnonymousa.get(4)).intValue();
                                      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "add8EventMMProcessEndIfNeed need 补充8事件: %s, %d, %s, %d", new Object[] { localObject1, Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(k) });
                                      if (((com.tencent.mm.plugin.expt.hellhound.a.c.c)localObject2).sHQ != null) {
                                        ((com.tencent.mm.plugin.expt.hellhound.a.c.c)localObject2).sHQ.a((String)localObject1, i, j, l, k);
                                      }
                                    }
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  i = Process.myPid();
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.a.c.a.cPw();
                                  paramAnonymousa = (com.tencent.mm.plugin.expt.hellhound.core.a.a.a)localObject1;
                                  if (localObject1 == null) {
                                    paramAnonymousa = new bfq();
                                  }
                                  if (paramAnonymousa.LPj <= 0)
                                  {
                                    Log.i("HABBYGE-MALI.FrontBackDao", "handleLastProcessParams lastMMProcessId <= 0");
                                    paramAnonymousa = null;
                                  }
                                  for (;;)
                                  {
                                    break;
                                    if (paramAnonymousa.LPj != i)
                                    {
                                      Log.i("HABBYGE-MALI.FrontBackDao", "handleLastProcessParams last != curr ---1: %d, %d", new Object[] { Integer.valueOf(paramAnonymousa.LPj), Integer.valueOf(i) });
                                      if (paramAnonymousa.LPh == 7)
                                      {
                                        com.tencent.mm.plugin.expt.hellhound.a.c.c.cPx();
                                        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.c.a.cPw();
                                        if ((localObject1 != null) && (((bfq)localObject1).LPl)) {}
                                        for (i = 1;; i = 0)
                                        {
                                          if (i == 0) {
                                            break label3451;
                                          }
                                          Log.i("HABBYGE-MALI.FrontBackDao", "getIsLogoutFromMMPageFlowService true");
                                          com.tencent.mm.plugin.expt.hellhound.a.c.a.mi(false);
                                          paramAnonymousa = null;
                                          break;
                                        }
                                        label3451:
                                        if (TextUtils.isEmpty("page_hell_seq_mmkv_key")) {}
                                        for (i = -1;; i = MultiProcessMMKV.getMMKV("_hellhound_mmkv").getInt("page_hell_seq_mmkv_key", -1))
                                        {
                                          paramAnonymousa.jlm = i;
                                          localObject1 = paramAnonymousa.LPk;
                                          i = paramAnonymousa.aHK;
                                          j = paramAnonymousa.LPj;
                                          l = paramAnonymousa.LPi;
                                          k = paramAnonymousa.jlm;
                                          paramAnonymousa = new com.tencent.mm.vending.j.f();
                                          paramAnonymousa.RaR = new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(k) };
                                          paramAnonymousa = (com.tencent.mm.vending.j.f)paramAnonymousa;
                                          break;
                                        }
                                      }
                                    }
                                    else
                                    {
                                      Log.i("HABBYGE-MALI.FrontBackDao", "handleLastProcessParams last == curr: %d, %d", new Object[] { Integer.valueOf(paramAnonymousa.LPj), Integer.valueOf(i) });
                                    }
                                    paramAnonymousa = null;
                                  }
                                  localObject1 = (cbn)paramAnonymousa.szh;
                                  if (localObject1 != null)
                                  {
                                    paramAnonymousa = ((cbn)localObject1).businessId;
                                    localObject1 = ((cbn)localObject1).value;
                                    Log.i("HABBYGE-MALI.SyncBizCollector", "_collectBizData: %s, %s", new Object[] { paramAnonymousa, localObject1 });
                                    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
                                    localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE((String)com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNO().get(0));
                                    if (localObject2 != null)
                                    {
                                      Log.i("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, curActivityName: %s", new Object[] { localObject2 });
                                      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.d.d.cPD();
                                      if (localObject3 != null) {
                                        break label3741;
                                      }
                                      Log.e("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, matchInfo is NULL !!");
                                    }
                                    label3986:
                                    for (;;)
                                    {
                                      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.a.b.cPT();
                                      if (localObject3 != null) {
                                        break;
                                      }
                                      Log.e("HABBYGE-MALI.SyncBizCollector", "collectBizData, tuple2 is NULL");
                                      AppMethodBeat.o(121937);
                                      return;
                                      label3741:
                                      if (((bfz)localObject3).LPD.isEmpty())
                                      {
                                        Log.e("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, matchInfo.sessionFuzzyPaths is NULL !!");
                                      }
                                      else
                                      {
                                        localObject4 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
                                        if (localObject4 == null)
                                        {
                                          Log.e("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, curSession is NULL !!");
                                        }
                                        else
                                        {
                                          localObject5 = new cbn();
                                          ((cbn)localObject5).businessId = paramAnonymousa;
                                          ((cbn)localObject5).value = ((String)localObject1);
                                          i = ((bfz)localObject3).LPD.size() - 1;
                                          while (i >= 0)
                                          {
                                            localObject6 = (dve)((bfz)localObject3).LPD.get(i);
                                            if ((localObject6 != null) && (((dve)localObject6).dRM != null) && (((dve)localObject6).dRM.equals(((cyl)localObject4).sessionId)))
                                            {
                                              localObject6 = ((dve)localObject6).LPC.iterator();
                                              while (((Iterator)localObject6).hasNext())
                                              {
                                                bgb localbgb = (bgb)((Iterator)localObject6).next();
                                                if (!localbgb.LPK.isEmpty())
                                                {
                                                  j = localbgb.LPK.size() - 1;
                                                  for (;;)
                                                  {
                                                    if (j < 0) {
                                                      break label3986;
                                                    }
                                                    bga localbga = (bga)localbgb.LPK.get(j);
                                                    if (localbga != null)
                                                    {
                                                      String str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(localbga.name);
                                                      if ((str != null) && (str.equals(localObject2)))
                                                      {
                                                        localbga.LPG.addLast(localObject5);
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
                                          com.tencent.mm.plugin.expt.hellhound.a.d.d.a((bfz)localObject3);
                                        }
                                      }
                                    }
                                    localObject2 = (cbm)((com.tencent.mm.vending.j.b)localObject3).get(0);
                                    i = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
                                    localObject3 = new cbn();
                                    ((cbn)localObject3).businessId = paramAnonymousa;
                                    ((cbn)localObject3).value = ((String)localObject1);
                                    ((cbm)localObject2).LPG.add(localObject3);
                                    ((cbm)localObject2).Mho.add(localObject3);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cbm)localObject2, i);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject1 = (String)paramAnonymousa.szh;
                                  if (localObject1 != null)
                                  {
                                    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.a.b.cPT();
                                    if (localObject2 != null) {
                                      break label4151;
                                    }
                                    Log.e("HABBYGE-MALI.AsyncBizCollector", "getBizId, tuple2 is NULL");
                                  }
                                  for (paramAnonymousa = null;; paramAnonymousa = ((cbn)localObject2).businessId)
                                  {
                                    Log.i("HABBYGE-MALI.AsyncBizCollector", "AsyncBizCollector, _collectBizId: %s", new Object[] { paramAnonymousa });
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.gs((String)localObject1, paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label4151:
                                    paramAnonymousa = (cbm)((com.tencent.mm.vending.j.b)localObject2).get(0);
                                    i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
                                    j = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.fM(paramAnonymousa.LPG.size() + 1, paramAnonymousa.Mho.size() + 1);
                                    localObject2 = new cbn();
                                    ((cbn)localObject2).businessId = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.s(paramAnonymousa.startTime, j);
                                    paramAnonymousa.LPG.add(localObject2);
                                    paramAnonymousa.Mho.add(localObject2);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramAnonymousa, i);
                                    Log.i("HABBYGE-MALI.AsyncBizCollector", "getBizId, addBizIdCurPageFlowItem: %s", new Object[] { ((cbn)localObject2).businessId });
                                  }
                                  localObject1 = (cbn)paramAnonymousa.szh;
                                  if (localObject1 != null)
                                  {
                                    paramAnonymousa = ((cbn)localObject1).dataPath;
                                    localObject2 = ((cbn)localObject1).value;
                                    localObject3 = ((cbn)localObject1).businessId;
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.a.ac(paramAnonymousa, (String)localObject2, (String)localObject3);
                                    if (localObject1 != null)
                                    {
                                      Log.i("HABBYGE-MALI.AsyncBizCollector", "_collectBizData: %s, %s, %s", new Object[] { paramAnonymousa, localObject2, localObject3 });
                                      if (localObject1 != null)
                                      {
                                        paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.a.cQi();
                                        if ((paramAnonymousa == null) || (paramAnonymousa.isEmpty()))
                                        {
                                          paramAnonymousa = new JSONArray();
                                          paramAnonymousa.put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.aqF(System.currentTimeMillis() + "@" + paramAnonymousa.toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        if ("-1".equals(paramAnonymousa))
                                        {
                                          Log.e("HABBYGE-MALI.AsyncBizDao", " AsyncBizDao putBiz NOT LOGIN");
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        if (paramAnonymousa.split("@").length <= 1)
                                        {
                                          localObject2 = new JSONArray();
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.aqF(paramAnonymousa + "@" + ((JSONArray)localObject2).toString());
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
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.aqF(System.currentTimeMillis() + "@" + paramAnonymousa.toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                          paramAnonymousa = paramAnonymousa.split("@");
                                          if (paramAnonymousa.length <= 0) {
                                            paramAnonymousa = null;
                                          } else if (paramAnonymousa.length == 1) {
                                            paramAnonymousa = com.tencent.mm.vending.j.a.Q(paramAnonymousa[0], null);
                                          } else {
                                            paramAnonymousa = com.tencent.mm.vending.j.a.Q(paramAnonymousa[0], paramAnonymousa[1]);
                                          }
                                        }
                                        if ((TextUtils.isEmpty((CharSequence)paramAnonymousa.get(1))) && (!TextUtils.isEmpty((CharSequence)paramAnonymousa.get(0))))
                                        {
                                          localObject2 = new JSONArray();
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.aqF((String)paramAnonymousa.get(0) + "@" + ((JSONArray)localObject2).toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        try
                                        {
                                          localObject2 = new JSONArray((String)paramAnonymousa.get(1));
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.aqF((String)paramAnonymousa.get(0) + "@" + ((JSONArray)localObject2).toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        catch (JSONException paramAnonymousa)
                                        {
                                          Log.printErrStackTrace("HABBYGE-MALI.AsyncBizDao", paramAnonymousa, "AsyncBizDao.putBiz crash: %s", new Object[] { paramAnonymousa.getMessage() });
                                        }
                                      }
                                    }
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.szh;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().cPR();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.gu(paramAnonymousa, (String)localObject1);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.szh;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.d.cPV();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.gt(paramAnonymousa, (String)localObject1);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                                  l = ((Long)paramAnonymousa.szh).longValue();
                                  Log.i("HABBYGE-MALI.VoipFloatSession", "VoipMonitorCallback: _videoActivity2VoipFloat");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.Dy(l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                                  l = ((Long)paramAnonymousa.szh).longValue();
                                  localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject1).sIq;
                                  Log.i("HABBYGE-MALI.VoipFloatSession", "VoipMonitorCallback: _voipFloat2VideoActivity");
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
                                  if ((paramAnonymousa != null) && (!TextUtils.isEmpty(paramAnonymousa.sessionId))) {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(paramAnonymousa, l);
                                  }
                                  Log.i("HABBYGE-MALI.VoipFloatSession", "_beignVoipSession");
                                  bool = false;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
                                  if (paramAnonymousa == null)
                                  {
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(null, "LauncherUI", "VideoActivity", 0, l);
                                    if (paramAnonymousa == null)
                                    {
                                      Log.e("HABBYGE-MALI.VoipFloatSession", "_beignFloatSession, 不是合法session ~~~");
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                    bool = true;
                                    Log.i("HABBYGE-MALI.VoipFloatSession", "_beignFloatSession, isNewSession: %s, %b", new Object[] { paramAnonymousa.sessionId, Boolean.valueOf(bool) });
                                    if ((((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject1).sIX == null) || (!((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject1).sIX.equals("com.tencent.mm.plugin.voip.ui.VideoActivity"))) {
                                      break label5182;
                                    }
                                  }
                                  label5182:
                                  for (i = ((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject1).sIY;; i = 0)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramAnonymousa, "VideoActivity", i, l);
                                    if (!bool) {
                                      break label5187;
                                    }
                                    paramAnonymousa.iOu = 0;
                                    localObject2 = m.cPR();
                                    localObject1 = localObject2;
                                    if (localObject2 == null) {
                                      localObject1 = "";
                                    }
                                    paramAnonymousa.kvy = ((String)localObject1);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(paramAnonymousa);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    Log.i("HABBYGE-MALI.VoipFloatSession", "_beignFloatSession, curSession: %s", new Object[] { paramAnonymousa.sessionId });
                                    break;
                                  }
                                  label5187:
                                  com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(paramAnonymousa);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                                  l = ((Long)paramAnonymousa.szh).longValue();
                                  Log.i("HABBYGE-MALI.VoipFloatSession", "VoipMonitorCallback: _closeVideoActivity");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.Dy(l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                                  l = ((Long)paramAnonymousa.szh).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cQO();
                                  if (paramAnonymousa != null)
                                  {
                                    paramAnonymousa.LOm = -1;
                                    paramAnonymousa.LOn = -1;
                                    paramAnonymousa.LOp = 7;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.a(paramAnonymousa);
                                  }
                                  Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, stat, show: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cQM()) });
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
                                  if ((paramAnonymousa == null) || (TextUtils.isEmpty(paramAnonymousa.sessionId)))
                                  {
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.core.b.cNz();
                                    if (paramAnonymousa != null)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.al((String)paramAnonymousa.first, l);
                                    }
                                  }
                                  for (;;)
                                  {
                                    Log.d("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession");
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
                                    bool = false;
                                    if (paramAnonymousa != null) {
                                      break label5502;
                                    }
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(null, "LauncherUI", "FloatingBall", 0, l);
                                    if (paramAnonymousa != null) {
                                      break;
                                    }
                                    Log.e("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession, 不是合法session ~~~");
                                    AppMethodBeat.o(121937);
                                    return;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(paramAnonymousa, l);
                                  }
                                  bool = true;
                                  for (;;)
                                  {
                                    Log.d("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession, isNewSession: %s, %b", new Object[] { paramAnonymousa.sessionId, Boolean.valueOf(bool) });
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramAnonymousa, "FloatBall", 0, l);
                                    if (!bool) {
                                      break;
                                    }
                                    paramAnonymousa.iOu = 0;
                                    localObject2 = m.cPR();
                                    localObject1 = localObject2;
                                    if (localObject2 == null) {
                                      localObject1 = "";
                                    }
                                    paramAnonymousa.kvy = ((String)localObject1);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(paramAnonymousa);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label5502:
                                    Log.d("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession, curSession: %s", new Object[] { paramAnonymousa.sessionId });
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(paramAnonymousa);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                                  l = ((Long)paramAnonymousa.szh).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cQN();
                                  if (paramAnonymousa != null)
                                  {
                                    i = ((Integer)paramAnonymousa.second).intValue();
                                    if ((i != 1) && (i != 0)) {
                                      break label5684;
                                    }
                                  }
                                  label5684:
                                  for (bool = true;; bool = false)
                                  {
                                    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatMenuHide, FloatSession, End: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
                                    if (bool) {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().b(false, null, l);
                                    }
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cQO();
                                    paramAnonymousa = (com.tencent.mm.plugin.expt.hellhound.core.a.a.a)localObject1;
                                    if (localObject1 == null) {
                                      paramAnonymousa = new ben();
                                    }
                                    paramAnonymousa.LOp = 8;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.a(paramAnonymousa);
                                    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, stat, hide: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cQM()) });
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                                  l = ((Long)paramAnonymousa.szh).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cQN();
                                  if (paramAnonymousa != null)
                                  {
                                    if (((Integer)paramAnonymousa.second).intValue() == 6)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().b(false, null, l);
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.Hp(4);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                                  Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuBackgroundClicked");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.fN(1, 1);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                                  Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuBackPressed");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.fN(0, 0);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                                  Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuItemClicked");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.fN(2, 2);
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.mk(true);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                                  Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuItemRemoved");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.fN(6, 6);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().b(false, null, 0L);
                                  AppMethodBeat.o(121937);
                                  return;
                                  i = ((Integer)paramAnonymousa.szh).intValue();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.Hp(i);
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.g.e.cQV();
                                  localObject1 = paramAnonymousa.sJs;
                                  localObject2 = paramAnonymousa.sCN;
                                  localObject3 = paramAnonymousa.sJu;
                                  ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).sCN = ((com.tencent.mm.plugin.expt.hellhound.a.a.f)localObject2);
                                  com.tencent.mm.hellhoundlib.a.axP();
                                  com.tencent.mm.hellhoundlib.a.e(((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).sAp, ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).sJh);
                                  ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).sJf = ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject3);
                                  com.tencent.mm.hellhoundlib.a.axP();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).sCM, ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).sJi);
                                  com.tencent.mm.hellhoundlib.a.axP();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).sxm, ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).sJi);
                                  com.tencent.mm.hellhoundlib.a.axP();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).sJg, ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).sJh);
                                  if (paramAnonymousa.mActivityRef != null) {
                                    paramAnonymousa.sDg.a(0, (Activity)paramAnonymousa.mActivityRef.get());
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.g.e.cQV();
                                  paramAnonymousa.sDg.a(1, null);
                                  paramAnonymousa = paramAnonymousa.sJs;
                                  com.tencent.mm.hellhoundlib.a.axP();
                                  com.tencent.mm.hellhoundlib.a.f(paramAnonymousa.sAp, paramAnonymousa.sJh);
                                  paramAnonymousa.sCN = null;
                                  com.tencent.mm.hellhoundlib.a.axP();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.sCM, paramAnonymousa.sJi);
                                  com.tencent.mm.hellhoundlib.a.axP();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.sxm, paramAnonymousa.sJi);
                                  paramAnonymousa.sJf = null;
                                  com.tencent.mm.hellhoundlib.a.axP();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.sJg, paramAnonymousa.sJh);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.g.e.cQV().sDg.a(2, null);
                                  com.tencent.mm.plugin.expt.hellhound.a.g.e.sJt = null;
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.g.e.cQV().sDg.a(3, null);
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.szh;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.sDe;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aU(0, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.szh;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.sDe;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aU(1, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.szh;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.sDe;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aU(2, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.szh;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.sDe;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aU(3, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.Dx(((Long)paramAnonymousa.szh).longValue());
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.cQK();
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.core.b.c.e.b((erd)paramAnonymousa.szh);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.b.a.a((boj)paramAnonymousa.szh);
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
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c localc = com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ();
    com.tencent.mm.plugin.expt.hellhound.core.a.a.d locald = this.szJ;
    localc.szl.szn = locald;
    AppMethodBeat.o(121938);
  }
  
  private static com.tencent.mm.vending.j.d<String, Boolean, Boolean> X(Activity paramActivity)
  {
    AppMethodBeat.i(121940);
    com.tencent.mm.vending.j.c localc = Y(paramActivity);
    if (!((Boolean)localc.get(1)).booleanValue())
    {
      paramActivity = com.tencent.mm.vending.j.a.i(localc.get(0), localc.get(1), Boolean.FALSE);
      AppMethodBeat.o(121940);
      return paramActivity;
    }
    boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.aoz(paramActivity.getClass().getCanonicalName());
    paramActivity = com.tencent.mm.vending.j.a.i(localc.get(0), localc.get(1), Boolean.valueOf(bool));
    AppMethodBeat.o(121940);
    return paramActivity;
  }
  
  static com.tencent.mm.vending.j.c<String, Boolean> Y(Activity paramActivity)
  {
    AppMethodBeat.i(121942);
    String str = null;
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.h.aa(paramActivity);
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
    paramActivity = com.tencent.mm.vending.j.a.Q(localObject, Boolean.valueOf(bool));
    AppMethodBeat.o(121942);
    return paramActivity;
  }
  
  static eih a(eih parameih)
  {
    AppMethodBeat.i(184315);
    eih localeih;
    if (parameih != null)
    {
      localeih = parameih;
      if (!TextUtils.isEmpty(parameih.activityName)) {
        break label88;
      }
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
      com.tencent.mm.vending.j.c localc = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNN();
      if (localc == null)
      {
        AppMethodBeat.o(184315);
        return null;
      }
      localeih = parameih;
      if (parameih == null)
      {
        localeih = new eih();
        localeih.timestamp = System.currentTimeMillis();
      }
      localeih.activityName = ((String)localc.get(0));
      localeih.aHK = ((Integer)localc.get(1)).intValue();
      label88:
      AppMethodBeat.o(184315);
      return localeih;
    }
    catch (Exception parameih)
    {
      Log.printErrStackTrace("HABBYGE-MALI.AsyncActivityMonitor", parameih, "getActivityOnFinish", new Object[0]);
      AppMethodBeat.o(184315);
    }
    return null;
  }
  
  static void a(int paramInt, eih parameih)
  {
    AppMethodBeat.i(184313);
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(parameih.activityName, null, 104);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GS(101);
    if (localObject != null) {}
    for (localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);; localObject = null)
    {
      if (!parameih.activityName.equals(localObject))
      {
        Log.w("HABBYGE-MALI.AsyncActivityMonitor", "_onCreateEvent: %s, %s", new Object[] { localObject, parameih.activityName });
        b(paramInt, null, null, parameih.activityName, parameih.aHK, parameih.timestamp);
      }
      a(parameih.activityName, parameih.aHK, com.tencent.mm.plugin.expt.hellhound.core.stack.a.szs);
      AppMethodBeat.o(184313);
      return;
    }
  }
  
  static void a(String paramString, int paramInt, com.tencent.mm.plugin.expt.hellhound.core.stack.a parama)
  {
    AppMethodBeat.i(220427);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(paramString, paramInt, parama);
    AppMethodBeat.o(220427);
  }
  
  static void aX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(121943);
    a.GQ(1);
    if ((!paramBoolean) && (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(paramString)))
    {
      Log.i("HABBYGE-MALI.AsyncActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
      AppMethodBeat.o(121943);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
    bn localbn = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
    String str = null;
    if (localbn != null) {
      str = localbn.KFh.activityName;
    }
    a.apg(paramString);
    a.ape(str);
    Log.i("HABBYGE-MALI.AsyncActivityMonitor", "setActivityActionOnFinish: from: %s, to: %s", new Object[] { paramString, str });
    AppMethodBeat.o(121943);
  }
  
  static void b(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(220428);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM().a(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramLong);
    AppMethodBeat.o(220428);
  }
  
  static cuz c(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(184312);
    cuz localcuz = new cuz();
    localcuz.LOX = new eih();
    localcuz.LOX.activityName = paramActivity.getClass().getCanonicalName();
    localcuz.LOX.aHK = paramActivity.hashCode();
    localcuz.LOX.timestamp = paramLong;
    paramActivity = X(paramActivity);
    localcuz.LOY = ((String)paramActivity.get(0));
    localcuz.LPb = ((Boolean)paramActivity.get(1)).booleanValue();
    localcuz.Mhh = ((Boolean)paramActivity.get(2)).booleanValue();
    AppMethodBeat.o(184312);
    return localcuz;
  }
  
  static cuy g(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121941);
    cuy localcuy = new cuy();
    if (paramIntent != null) {
      localcuy.flags = paramIntent.getFlags();
    }
    localcuy.LOX = new eih();
    if (paramActivity == null)
    {
      AppMethodBeat.o(121941);
      return localcuy;
    }
    localcuy.LOX.activityName = paramActivity.getClass().getCanonicalName();
    localcuy.LOX.aHK = paramActivity.hashCode();
    localcuy.LOX.timestamp = System.currentTimeMillis();
    AppMethodBeat.o(121941);
    return localcuy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.c
 * JD-Core Version:    0.7.0.1
 */