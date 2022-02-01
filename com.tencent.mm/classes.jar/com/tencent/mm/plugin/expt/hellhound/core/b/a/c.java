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
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.blr;
import com.tencent.mm.protocal.protobuf.bm;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bnb;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.protocal.protobuf.czz;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.dej;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.efg;
import com.tencent.mm.protocal.protobuf.emj;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.esj;
import com.tencent.mm.protocal.protobuf.fbo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;

final class c
{
  private final com.tencent.mm.plugin.expt.hellhound.core.a.a.d wfD;
  d.a wfz;
  
  c()
  {
    AppMethodBeat.i(121938);
    this.wfD = new com.tencent.mm.plugin.expt.hellhound.core.a.a.d()
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
          if (paramAnonymousa.wfd != null)
          {
            Object localObject1 = (emj)paramAnonymousa.wfd;
            Object localObject2;
            Object localObject3;
            boolean bool;
            Object localObject4;
            Object localObject5;
            Object localObject6;
            if (localObject1 != null)
            {
              Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_startActivity: %s, %s, %s", new Object[] { ((emj)localObject1).TqR.activityName, ((emj)localObject1).TqS.activityName, ((emj)localObject1).SXs });
              localObject2 = c.this;
              paramAnonymousa = null;
              if ((((emj)localObject1).TqR == null) || (TextUtils.isEmpty(((emj)localObject1).TqR.activityName))) {
                break label1104;
              }
              paramAnonymousa = ((emj)localObject1).TqR.activityName;
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dcQ();
              bool = ((emj)localObject1).SXv;
              localObject4 = ((emj)localObject1).SXs;
              ((com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c)localObject3).wfK.a(paramAnonymousa, bool, (String)localObject4);
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R(paramAnonymousa, ((emj)localObject1).SXs, 100);
              localObject3 = ((emj)localObject1).TqS.activityName;
              Log.i("HABBYGE-MALI.AsyncActivityMonitor", "_startActivity, toActivity: %s, %s", new Object[] { paramAnonymousa, localObject3 });
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R((String)localObject3, null, 101);
              localObject4 = ((emj)localObject1).SXu;
              localObject5 = ((emj)localObject1).TqU;
              localObject6 = ((emj)localObject1).TqT;
              if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.gC("Chat_User", (String)localObject4);
              }
              if ((!"1".equals(localObject6)) || (!"jd_store".equals(localObject5))) {
                break label1137;
              }
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.gC("minimize_secene", (String)localObject6);
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.gC("KPublisherId", (String)localObject5);
            }
            for (;;)
            {
              c.b(((emj)localObject1).flags, paramAnonymousa, ((emj)localObject1).SXs, (String)localObject3, 0, ((emj)localObject1).timestamp);
              a.axd((String)localObject3);
              a.axf(paramAnonymousa);
              a.KA(0);
              if ((localObject3 != null) && (((c)localObject2).wfz != null)) {
                ((c)localObject2).wfz.awd((String)localObject3);
              }
              AppMethodBeat.o(121937);
              return;
              label1104:
              com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
              if (localObject3 == null) {
                break;
              }
              paramAnonymousa = ((bl)localObject3).RGy.activityName;
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dcQ().axj(paramAnonymousa);
              break;
              label1137:
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.gC("minimize_secene", "");
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.gC("KPublisherId", "");
            }
            if (paramAnonymousa.wfd != null)
            {
              paramAnonymousa = (esj)paramAnonymousa.wfd;
              long l;
              int i;
              if (paramAnonymousa != null)
              {
                Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_finish: %s", new Object[] { paramAnonymousa.activityName });
                localObject1 = c.this;
                localObject2 = c.a(paramAnonymousa);
                if (localObject2 != null)
                {
                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "_finish: %s", new Object[] { ((esj)localObject2).activityName });
                  com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R(((esj)localObject2).activityName, null, 102);
                  localObject5 = ((esj)localObject2).activityName;
                  l = ((esj)localObject2).timestamp;
                  localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE().wfw.wfx;
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
                  paramAnonymousa = new bl();
                  paramAnonymousa.RGy = new esj();
                  paramAnonymousa.RGy.activityName = ((esj)localObject2).activityName;
                  paramAnonymousa.RGy.aNf = ((esj)localObject2).aNf;
                  paramAnonymousa.RGy.timestamp = ((esj)localObject2).timestamp;
                  com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().a(null, paramAnonymousa, 1, null);
                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.wiY;
                  com.tencent.mm.plugin.expt.hellhound.a.b.a.b.axq(((esj)localObject2).activityName);
                  com.tencent.mm.plugin.expt.hellhound.a.g.e.dfQ().a(3, ((esj)localObject2).activityName, null);
                }
                c.ba(((esj)localObject2).activityName, true);
                if (((c)localObject1).wfz != null) {
                  ((c)localObject1).wfz.e(((esj)localObject2).activityName, ((esj)localObject2).aNf, ((esj)localObject2).timestamp);
                }
                AppMethodBeat.o(121937);
                return;
                localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.c.dcC();
                if (((bm)localObject4).RGE.isEmpty())
                {
                  i = 0;
                }
                else
                {
                  if (localObject4 != null)
                  {
                    i = ((bm)localObject4).RGE.size() - 1;
                    if (i >= 0)
                    {
                      localObject6 = (eqy)((bm)localObject4).RGE.get(i);
                      j = ((eqy)localObject6).Utm.size() - 1;
                      label1488:
                      if (j >= 0)
                      {
                        paramAnonymousa = (bl)((eqy)localObject6).Utm.get(j);
                        if (paramAnonymousa.RGy.activityName.equals(localObject5))
                        {
                          ((eqy)localObject6).Utm.remove(j);
                          if (((eqy)localObject6).Utm.isEmpty()) {
                            ((bm)localObject4).RGE.remove(i);
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
                  com.tencent.mm.plugin.expt.hellhound.core.stack.c.a((bm)localObject4);
                  if (((g)localObject3).wfy != null)
                  {
                    paramAnonymousa.RGy.timestamp = l;
                    ((g)localObject3).wfy.b(paramAnonymousa, (bl)g.dcK().get(1));
                  }
                  i = 1;
                }
              }
              if (paramAnonymousa.wfd != null)
              {
                localObject1 = (czz)paramAnonymousa.wfd;
                if (localObject1 != null)
                {
                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_moveTaskToBack: %s", new Object[] { ((czz)localObject1).SXr.activityName });
                  paramAnonymousa = c.this;
                  localObject2 = ((czz)localObject1).SXr;
                  bool = ((czz)localObject1).TqW;
                  localObject1 = c.a((esj)localObject2);
                  if (localObject1 != null)
                  {
                    Log.d("HABBYGE-MALI.AsyncActivityMonitor", "_moveTaskToBack: %s", new Object[] { ((esj)localObject1).activityName });
                    if (!TextUtils.isEmpty(((esj)localObject1).activityName))
                    {
                      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R(((esj)localObject1).activityName, null, 103);
                      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE().wfw.wfx;
                      localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.c.dcC();
                      localObject4 = new bl();
                      ((bl)localObject4).RGy = new esj();
                      ((bl)localObject4).RGy.activityName = ((esj)localObject1).activityName;
                      ((bl)localObject4).RGy.aNf = ((esj)localObject1).aNf;
                      ((bl)localObject4).RGy.timestamp = ((esj)localObject1).timestamp;
                      localObject5 = g.a((bm)localObject3, (bl)localObject4);
                      if (localObject5 != null)
                      {
                        localObject6 = (eqy)((com.tencent.mm.vending.j.b)localObject5).get(0);
                        i = ((Integer)((com.tencent.mm.vending.j.c)localObject5).get(1)).intValue();
                        if (((bool) || (com.tencent.mm.plugin.expt.hellhound.core.stack.h.a(((bl)((eqy)localObject6).Utm.getFirst()).RGy, ((bl)localObject4).RGy))) && (i == ((bm)localObject3).RGE.size() - 1))
                        {
                          ((bm)localObject3).RGE.remove(i);
                          ((bm)localObject3).RGE.addFirst(localObject6);
                          com.tencent.mm.plugin.expt.hellhound.core.stack.c.a((bm)localObject3);
                          if (((g)localObject2).wfy != null) {
                            ((g)localObject2).wfy.d((bl)localObject4, g.e((bm)localObject3));
                          }
                        }
                      }
                      c.ba(((esj)localObject1).activityName, false);
                      if (paramAnonymousa.wfz != null) {
                        paramAnonymousa.wfz.f(((esj)localObject1).activityName, ((esj)localObject1).aNf, ((esj)localObject1).timestamp);
                      }
                    }
                  }
                }
                AppMethodBeat.o(121937);
                return;
                if (paramAnonymousa.wfd != null)
                {
                  paramAnonymousa = (dei)paramAnonymousa.wfd;
                  if (paramAnonymousa != null)
                  {
                    Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onCreate: %s", new Object[] { paramAnonymousa.SXr.activityName });
                    localObject1 = c.this;
                    localObject2 = paramAnonymousa.SXr;
                    c.a(paramAnonymousa.flags, (esj)localObject2);
                    if (((c)localObject1).wfz != null) {
                      ((c)localObject1).wfz.awe(((esj)localObject2).activityName);
                    }
                  }
                  AppMethodBeat.o(121937);
                  return;
                  if (paramAnonymousa.wfd != null)
                  {
                    localObject1 = (dei)paramAnonymousa.wfd;
                    if (localObject1 != null)
                    {
                      Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onNewIntent: %s", new Object[] { ((dei)localObject1).SXr.activityName });
                      paramAnonymousa = c.this;
                      i = ((dei)localObject1).flags;
                      localObject1 = ((dei)localObject1).SXr;
                      c.a(i, (esj)localObject1);
                      if (paramAnonymousa.wfz != null) {
                        paramAnonymousa.wfz.awf(((esj)localObject1).activityName);
                      }
                    }
                    AppMethodBeat.o(121937);
                    return;
                    if (paramAnonymousa.wfd != null)
                    {
                      paramAnonymousa = (esj)paramAnonymousa.wfd;
                      if (paramAnonymousa != null)
                      {
                        Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onResume: %s", new Object[] { paramAnonymousa.activityName });
                        localObject1 = c.this;
                        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.dc(com.tencent.mm.plugin.expt.hellhound.core.a.dcp().dco());
                        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R(paramAnonymousa.activityName, null, 105);
                        com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
                        com.tencent.mm.plugin.expt.hellhound.core.stack.d.axb(paramAnonymousa.activityName);
                        c.a(paramAnonymousa.activityName, paramAnonymousa.aNf, com.tencent.mm.plugin.expt.hellhound.core.stack.a.wfp);
                        if (((c)localObject1).wfz != null) {
                          ((c)localObject1).wfz.g(paramAnonymousa.activityName, paramAnonymousa.aNf, paramAnonymousa.timestamp);
                        }
                      }
                      AppMethodBeat.o(121937);
                      return;
                      if (paramAnonymousa.wfd != null)
                      {
                        paramAnonymousa = (String)paramAnonymousa.wfd;
                        Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_UPDATE_SID: %s", new Object[] { paramAnonymousa });
                        if (!TextUtils.isEmpty(paramAnonymousa)) {
                          com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayq(paramAnonymousa);
                        }
                        AppMethodBeat.o(121937);
                        return;
                        if (paramAnonymousa.wfd != null)
                        {
                          paramAnonymousa = (dej)paramAnonymousa.wfd;
                          if (paramAnonymousa != null)
                          {
                            Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPostResume: %s", new Object[] { paramAnonymousa.SXr.activityName });
                            if (c.this.wfz != null) {
                              c.this.wfz.awg(paramAnonymousa.SXr.activityName);
                            }
                          }
                          AppMethodBeat.o(121937);
                          return;
                          if (paramAnonymousa.wfd != null)
                          {
                            paramAnonymousa = (esj)paramAnonymousa.wfd;
                            if (paramAnonymousa != null)
                            {
                              Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPause: %s", new Object[] { paramAnonymousa.activityName });
                              localObject1 = c.this;
                              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R(paramAnonymousa.activityName, null, 106);
                              c.a(paramAnonymousa.activityName, paramAnonymousa.aNf, com.tencent.mm.plugin.expt.hellhound.core.stack.a.wfq);
                              if (((c)localObject1).wfz != null) {
                                ((c)localObject1).wfz.h(paramAnonymousa.activityName, paramAnonymousa.aNf, paramAnonymousa.timestamp);
                              }
                            }
                            AppMethodBeat.o(121937);
                            return;
                            if (paramAnonymousa.wfd != null)
                            {
                              paramAnonymousa = (dej)paramAnonymousa.wfd;
                              if (paramAnonymousa != null)
                              {
                                Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPaused: %s", new Object[] { paramAnonymousa.SXr.activityName });
                                if (c.this.wfz != null) {
                                  c.this.wfz.awh(paramAnonymousa.SXr.activityName);
                                }
                              }
                              AppMethodBeat.o(121937);
                              return;
                              if (paramAnonymousa.wfd != null)
                              {
                                paramAnonymousa = (esj)paramAnonymousa.wfd;
                                if (paramAnonymousa != null)
                                {
                                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onStop: %s", new Object[] { paramAnonymousa.activityName });
                                  localObject1 = c.this;
                                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.awF(paramAnonymousa.activityName))
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R(paramAnonymousa.activityName, null, 107);
                                    c.a(paramAnonymousa.activityName, paramAnonymousa.aNf, com.tencent.mm.plugin.expt.hellhound.core.stack.a.wfr);
                                    if (((c)localObject1).wfz != null) {
                                      ((c)localObject1).wfz.i(paramAnonymousa.activityName, paramAnonymousa.aNf, paramAnonymousa.timestamp);
                                    }
                                  }
                                }
                                AppMethodBeat.o(121937);
                                return;
                                if (paramAnonymousa.wfd != null)
                                {
                                  paramAnonymousa = (esj)paramAnonymousa.wfd;
                                  if (paramAnonymousa != null)
                                  {
                                    Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onDestroy: %s", new Object[] { paramAnonymousa.activityName });
                                    localObject1 = c.this;
                                    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R(paramAnonymousa.activityName, null, 108);
                                    c.a(paramAnonymousa.activityName, paramAnonymousa.aNf, com.tencent.mm.plugin.expt.hellhound.core.stack.a.wfs);
                                    if (((c)localObject1).wfz != null) {
                                      ((c)localObject1).wfz.dE(paramAnonymousa.activityName, paramAnonymousa.aNf);
                                    }
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "HellMsgType.MSGQ_TYPE_FRAGMENT_RESUME recv !!");
                                  paramAnonymousa = (bmo)paramAnonymousa.wfd;
                                  if (paramAnonymousa != null) {
                                    com.tencent.mm.plugin.expt.hellhound.core.a.dcp().weQ.a(paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (bmn)paramAnonymousa.wfd;
                                  if (paramAnonymousa != null) {
                                    com.tencent.mm.plugin.expt.hellhound.core.a.dcp().weQ.a(paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_FRAGMENT_%d", new Object[] { Integer.valueOf(paramAnonymousa.msgType) });
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.dcp();
                                  i = paramAnonymousa.msgType;
                                  l = ((Long)paramAnonymousa.wfd).longValue();
                                  ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject1).weQ.U(i, l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_STORY_%d", new Object[] { Integer.valueOf(paramAnonymousa.msgType) });
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.dcp();
                                  i = paramAnonymousa.msgType;
                                  l = ((Long)paramAnonymousa.wfd).longValue();
                                  ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject1).weQ.V(i, l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  try
                                  {
                                    i = ((Integer)paramAnonymousa.wfd).intValue();
                                    if (paramAnonymousa.msgType == 401)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.e.a.KY(i);
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
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.KX(i);
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 402)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.KX(i);
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 403) {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.KY(i);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject2 = com.tencent.mm.plugin.expt.hellhound.a.c.c.der();
                                  Log.i("HABBYGE-MALI.HellFrontBackMonitor", "add8EventMMProcessEndIfNeed");
                                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess())
                                  {
                                    paramAnonymousa = null;
                                    if (paramAnonymousa != null)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.c.a.KS(8);
                                      a.KA(8);
                                      localObject1 = (String)paramAnonymousa.get(0);
                                      i = ((Integer)paramAnonymousa.get(1)).intValue();
                                      j = ((Integer)paramAnonymousa.get(2)).intValue();
                                      l = ((Long)paramAnonymousa.get(3)).longValue();
                                      int k = ((Integer)paramAnonymousa.get(4)).intValue();
                                      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "add8EventMMProcessEndIfNeed need 补充8事件: %s, %d, %s, %d", new Object[] { localObject1, Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(k) });
                                      if (((com.tencent.mm.plugin.expt.hellhound.a.c.c)localObject2).wnL != null) {
                                        ((com.tencent.mm.plugin.expt.hellhound.a.c.c)localObject2).wnL.a((String)localObject1, i, j, l, k);
                                      }
                                    }
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  i = Process.myPid();
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.a.c.a.deq();
                                  paramAnonymousa = (com.tencent.mm.plugin.expt.hellhound.core.a.a.a)localObject1;
                                  if (localObject1 == null) {
                                    paramAnonymousa = new bmr();
                                  }
                                  if (paramAnonymousa.SXA <= 0)
                                  {
                                    Log.i("HABBYGE-MALI.FrontBackDao", "handleLastProcessParams lastMMProcessId <= 0");
                                    paramAnonymousa = null;
                                  }
                                  for (;;)
                                  {
                                    break;
                                    if (paramAnonymousa.SXA != i)
                                    {
                                      Log.i("HABBYGE-MALI.FrontBackDao", "handleLastProcessParams last != curr ---1: %d, %d", new Object[] { Integer.valueOf(paramAnonymousa.SXA), Integer.valueOf(i) });
                                      if (paramAnonymousa.SXy == 7)
                                      {
                                        com.tencent.mm.plugin.expt.hellhound.a.c.c.der();
                                        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.c.a.deq();
                                        if ((localObject1 != null) && (((bmr)localObject1).SXC)) {}
                                        for (i = 1;; i = 0)
                                        {
                                          if (i == 0) {
                                            break label3451;
                                          }
                                          Log.i("HABBYGE-MALI.FrontBackDao", "getIsLogoutFromMMPageFlowService true");
                                          com.tencent.mm.plugin.expt.hellhound.a.c.a.nv(false);
                                          paramAnonymousa = null;
                                          break;
                                        }
                                        label3451:
                                        if (TextUtils.isEmpty("page_hell_seq_mmkv_key")) {}
                                        for (i = -1;; i = MultiProcessMMKV.getMMKV("_hellhound_mmkv").getInt("page_hell_seq_mmkv_key", -1))
                                        {
                                          paramAnonymousa.mbp = i;
                                          paramAnonymousa = com.tencent.mm.vending.j.a.c(paramAnonymousa.SXB, Integer.valueOf(paramAnonymousa.aNf), Integer.valueOf(paramAnonymousa.SXA), Long.valueOf(paramAnonymousa.SXz), Integer.valueOf(paramAnonymousa.mbp));
                                          break;
                                        }
                                      }
                                    }
                                    else
                                    {
                                      Log.i("HABBYGE-MALI.FrontBackDao", "handleLastProcessParams last == curr: %d, %d", new Object[] { Integer.valueOf(paramAnonymousa.SXA), Integer.valueOf(i) });
                                    }
                                    paramAnonymousa = null;
                                  }
                                  localObject1 = (cjq)paramAnonymousa.wfd;
                                  if (localObject1 != null)
                                  {
                                    paramAnonymousa = ((cjq)localObject1).businessId;
                                    localObject1 = ((cjq)localObject1).value;
                                    Log.i("HABBYGE-MALI.SyncBizCollector", "_collectBizData: %s, %s", new Object[] { paramAnonymousa, localObject1 });
                                    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
                                    localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.awD((String)com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcG().get(0));
                                    if (localObject2 != null)
                                    {
                                      Log.i("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, curActivityName: %s", new Object[] { localObject2 });
                                      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.d.d.dex();
                                      if (localObject3 != null) {
                                        break label3693;
                                      }
                                      Log.e("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, matchInfo is NULL !!");
                                    }
                                    label3938:
                                    for (;;)
                                    {
                                      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.a.b.deN();
                                      if (localObject3 != null) {
                                        break;
                                      }
                                      Log.e("HABBYGE-MALI.SyncBizCollector", "collectBizData, tuple2 is NULL");
                                      AppMethodBeat.o(121937);
                                      return;
                                      label3693:
                                      if (((bna)localObject3).SXR.isEmpty())
                                      {
                                        Log.e("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, matchInfo.sessionFuzzyPaths is NULL !!");
                                      }
                                      else
                                      {
                                        localObject4 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
                                        if (localObject4 == null)
                                        {
                                          Log.e("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, curSession is NULL !!");
                                        }
                                        else
                                        {
                                          localObject5 = new cjq();
                                          ((cjq)localObject5).businessId = paramAnonymousa;
                                          ((cjq)localObject5).value = ((String)localObject1);
                                          i = ((bna)localObject3).SXR.size() - 1;
                                          while (i >= 0)
                                          {
                                            localObject6 = (efg)((bna)localObject3).SXR.get(i);
                                            if ((localObject6 != null) && (((efg)localObject6).fLj != null) && (((efg)localObject6).fLj.equals(((dhx)localObject4).sessionId)))
                                            {
                                              localObject6 = ((efg)localObject6).SXQ.iterator();
                                              while (((Iterator)localObject6).hasNext())
                                              {
                                                bnc localbnc = (bnc)((Iterator)localObject6).next();
                                                if (!localbnc.SXY.isEmpty())
                                                {
                                                  j = localbnc.SXY.size() - 1;
                                                  for (;;)
                                                  {
                                                    if (j < 0) {
                                                      break label3938;
                                                    }
                                                    bnb localbnb = (bnb)localbnc.SXY.get(j);
                                                    if (localbnb != null)
                                                    {
                                                      String str = com.tencent.mm.plugin.expt.hellhound.core.b.awD(localbnb.name);
                                                      if ((str != null) && (str.equals(localObject2)))
                                                      {
                                                        localbnb.SXU.addLast(localObject5);
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
                                          com.tencent.mm.plugin.expt.hellhound.a.d.d.a((bna)localObject3);
                                        }
                                      }
                                    }
                                    localObject2 = (cjp)((com.tencent.mm.vending.j.b)localObject3).get(0);
                                    i = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
                                    localObject3 = new cjq();
                                    ((cjq)localObject3).businessId = paramAnonymousa;
                                    ((cjq)localObject3).value = ((String)localObject1);
                                    ((cjp)localObject2).SXU.add(localObject3);
                                    ((cjp)localObject2).Trc.add(localObject3);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cjp)localObject2, i);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject1 = (String)paramAnonymousa.wfd;
                                  if (localObject1 != null)
                                  {
                                    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.a.b.deN();
                                    if (localObject2 != null) {
                                      break label4103;
                                    }
                                    Log.e("HABBYGE-MALI.AsyncBizCollector", "getBizId, tuple2 is NULL");
                                  }
                                  for (paramAnonymousa = null;; paramAnonymousa = ((cjq)localObject2).businessId)
                                  {
                                    Log.i("HABBYGE-MALI.AsyncBizCollector", "AsyncBizCollector, _collectBizId: %s", new Object[] { paramAnonymousa });
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.gG((String)localObject1, paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label4103:
                                    paramAnonymousa = (cjp)((com.tencent.mm.vending.j.b)localObject2).get(0);
                                    i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
                                    j = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.gj(paramAnonymousa.SXU.size() + 1, paramAnonymousa.Trc.size() + 1);
                                    localObject2 = new cjq();
                                    ((cjq)localObject2).businessId = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.u(paramAnonymousa.startTime, j);
                                    paramAnonymousa.SXU.add(localObject2);
                                    paramAnonymousa.Trc.add(localObject2);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramAnonymousa, i);
                                    Log.i("HABBYGE-MALI.AsyncBizCollector", "getBizId, addBizIdCurPageFlowItem: %s", new Object[] { ((cjq)localObject2).businessId });
                                  }
                                  localObject1 = (cjq)paramAnonymousa.wfd;
                                  if (localObject1 != null)
                                  {
                                    paramAnonymousa = ((cjq)localObject1).dataPath;
                                    localObject2 = ((cjq)localObject1).value;
                                    localObject3 = ((cjq)localObject1).businessId;
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.a.Z(paramAnonymousa, (String)localObject2, (String)localObject3);
                                    if (localObject1 != null)
                                    {
                                      Log.i("HABBYGE-MALI.AsyncBizCollector", "_collectBizData: %s, %s, %s", new Object[] { paramAnonymousa, localObject2, localObject3 });
                                      if (localObject1 != null)
                                      {
                                        paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.a.dfc();
                                        if ((paramAnonymousa == null) || (paramAnonymousa.isEmpty()))
                                        {
                                          paramAnonymousa = new JSONArray();
                                          paramAnonymousa.put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.ayG(System.currentTimeMillis() + "@" + paramAnonymousa.toString());
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
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.ayG(paramAnonymousa + "@" + ((JSONArray)localObject2).toString());
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
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.ayG(System.currentTimeMillis() + "@" + paramAnonymousa.toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                          paramAnonymousa = paramAnonymousa.split("@");
                                          if (paramAnonymousa.length <= 0) {
                                            paramAnonymousa = null;
                                          } else if (paramAnonymousa.length == 1) {
                                            paramAnonymousa = com.tencent.mm.vending.j.a.J(paramAnonymousa[0], null);
                                          } else {
                                            paramAnonymousa = com.tencent.mm.vending.j.a.J(paramAnonymousa[0], paramAnonymousa[1]);
                                          }
                                        }
                                        if ((TextUtils.isEmpty((CharSequence)paramAnonymousa.get(1))) && (!TextUtils.isEmpty((CharSequence)paramAnonymousa.get(0))))
                                        {
                                          localObject2 = new JSONArray();
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.ayG((String)paramAnonymousa.get(0) + "@" + ((JSONArray)localObject2).toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        try
                                        {
                                          localObject2 = new JSONArray((String)paramAnonymousa.get(1));
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.ayG((String)paramAnonymousa.get(0) + "@" + ((JSONArray)localObject2).toString());
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
                                  paramAnonymousa = (String)paramAnonymousa.wfd;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().deL();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.gI(paramAnonymousa, (String)localObject1);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.wfd;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.d.deP();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.gH(paramAnonymousa, (String)localObject1);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
                                  l = ((Long)paramAnonymousa.wfd).longValue();
                                  Log.i("HABBYGE-MALI.VoipFloatSession", "VoipMonitorCallback: _videoActivity2VoipFloat");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.JM(l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
                                  l = ((Long)paramAnonymousa.wfd).longValue();
                                  localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject1).wol;
                                  Log.i("HABBYGE-MALI.VoipFloatSession", "VoipMonitorCallback: _voipFloat2VideoActivity");
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
                                  if ((paramAnonymousa != null) && (!TextUtils.isEmpty(paramAnonymousa.sessionId))) {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().a(paramAnonymousa, l);
                                  }
                                  Log.i("HABBYGE-MALI.VoipFloatSession", "_beignVoipSession");
                                  bool = false;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
                                  if (paramAnonymousa == null)
                                  {
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().a(null, "LauncherUI", "VideoActivity", 0, l);
                                    if (paramAnonymousa == null)
                                    {
                                      Log.e("HABBYGE-MALI.VoipFloatSession", "_beignFloatSession, 不是合法session ~~~");
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                    bool = true;
                                    Log.i("HABBYGE-MALI.VoipFloatSession", "_beignFloatSession, isNewSession: %s, %b", new Object[] { paramAnonymousa.sessionId, Boolean.valueOf(bool) });
                                    if ((((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject1).woU == null) || (!((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject1).woU.equals("com.tencent.mm.plugin.voip.ui.VideoActivity"))) {
                                      break label5134;
                                    }
                                  }
                                  label5134:
                                  for (i = ((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject1).woV;; i = 0)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramAnonymousa, "VideoActivity", i, l);
                                    if (!bool) {
                                      break label5139;
                                    }
                                    paramAnonymousa.lEK = 0;
                                    localObject2 = m.deL();
                                    localObject1 = localObject2;
                                    if (localObject2 == null) {
                                      localObject1 = "";
                                    }
                                    paramAnonymousa.nnJ = ((String)localObject1);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(paramAnonymousa);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    Log.i("HABBYGE-MALI.VoipFloatSession", "_beignFloatSession, curSession: %s", new Object[] { paramAnonymousa.sessionId });
                                    break;
                                  }
                                  label5139:
                                  com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(paramAnonymousa);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
                                  l = ((Long)paramAnonymousa.wfd).longValue();
                                  Log.i("HABBYGE-MALI.VoipFloatSession", "VoipMonitorCallback: _closeVideoActivity");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.JM(l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
                                  l = ((Long)paramAnonymousa.wfd).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.dfJ();
                                  if (paramAnonymousa != null)
                                  {
                                    paramAnonymousa.SWK = -1;
                                    paramAnonymousa.SWL = -1;
                                    paramAnonymousa.SWN = 7;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.a(paramAnonymousa);
                                  }
                                  Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, stat, show: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.dfH()) });
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
                                  if ((paramAnonymousa == null) || (TextUtils.isEmpty(paramAnonymousa.sessionId)))
                                  {
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.core.b.dcr();
                                    if (paramAnonymousa != null) {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().am((String)paramAnonymousa.first, l);
                                    }
                                  }
                                  for (;;)
                                  {
                                    Log.d("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession");
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
                                    bool = false;
                                    if (paramAnonymousa != null) {
                                      break label5453;
                                    }
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().a(null, "LauncherUI", "FloatingBall", 0, l);
                                    if (paramAnonymousa != null) {
                                      break;
                                    }
                                    Log.e("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession, 不是合法session ~~~");
                                    AppMethodBeat.o(121937);
                                    return;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().a(paramAnonymousa, l);
                                  }
                                  bool = true;
                                  for (;;)
                                  {
                                    Log.d("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession, isNewSession: %s, %b", new Object[] { paramAnonymousa.sessionId, Boolean.valueOf(bool) });
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramAnonymousa, "FloatBall", 0, l);
                                    if (!bool) {
                                      break;
                                    }
                                    paramAnonymousa.lEK = 0;
                                    localObject2 = m.deL();
                                    localObject1 = localObject2;
                                    if (localObject2 == null) {
                                      localObject1 = "";
                                    }
                                    paramAnonymousa.nnJ = ((String)localObject1);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(paramAnonymousa);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label5453:
                                    Log.d("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession, curSession: %s", new Object[] { paramAnonymousa.sessionId });
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(paramAnonymousa);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
                                  l = ((Long)paramAnonymousa.wfd).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.dfI();
                                  if (paramAnonymousa != null)
                                  {
                                    i = ((Integer)paramAnonymousa.second).intValue();
                                    if ((i != 1) && (i != 0)) {
                                      break label5635;
                                    }
                                  }
                                  label5635:
                                  for (bool = true;; bool = false)
                                  {
                                    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatMenuHide, FloatSession, End: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
                                    if (bool) {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().b(false, null, l);
                                    }
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.dfJ();
                                    paramAnonymousa = (com.tencent.mm.plugin.expt.hellhound.core.a.a.a)localObject1;
                                    if (localObject1 == null) {
                                      paramAnonymousa = new blr();
                                    }
                                    paramAnonymousa.SWN = 8;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.a(paramAnonymousa);
                                    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, stat, hide: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.dfH()) });
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
                                  l = ((Long)paramAnonymousa.wfd).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.dfI();
                                  if (paramAnonymousa != null)
                                  {
                                    if (((Integer)paramAnonymousa.second).intValue() == 6)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().b(false, null, l);
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.KZ(4);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
                                  Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuBackgroundClicked");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.gk(1, 1);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
                                  Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuBackPressed");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.gk(0, 0);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
                                  Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuItemClicked");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.gk(2, 2);
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.nx(true);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
                                  Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuItemRemoved");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.gk(6, 6);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().b(false, null, 0L);
                                  AppMethodBeat.o(121937);
                                  return;
                                  i = ((Integer)paramAnonymousa.wfd).intValue();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.KZ(i);
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.g.e.dfQ();
                                  localObject1 = paramAnonymousa.wpq;
                                  localObject2 = paramAnonymousa.wiH;
                                  localObject3 = paramAnonymousa.wps;
                                  ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).wiH = ((com.tencent.mm.plugin.expt.hellhound.a.a.f)localObject2);
                                  com.tencent.mm.hellhoundlib.a.aFg();
                                  com.tencent.mm.hellhoundlib.a.e(((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).wgj, ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).wpe);
                                  ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).wpc = ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject3);
                                  com.tencent.mm.hellhoundlib.a.aFg();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).wiG, ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).wpf);
                                  com.tencent.mm.hellhoundlib.a.aFg();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).wcO, ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).wpf);
                                  com.tencent.mm.hellhoundlib.a.aFg();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).wpd, ((com.tencent.mm.plugin.expt.hellhound.a.g.c)localObject1).wpe);
                                  if (paramAnonymousa.mActivityRef != null) {
                                    paramAnonymousa.wja.a(0, (Activity)paramAnonymousa.mActivityRef.get());
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.g.e.dfQ();
                                  paramAnonymousa.wja.a(1, null);
                                  paramAnonymousa = paramAnonymousa.wpq;
                                  com.tencent.mm.hellhoundlib.a.aFg();
                                  com.tencent.mm.hellhoundlib.a.f(paramAnonymousa.wgj, paramAnonymousa.wpe);
                                  paramAnonymousa.wiH = null;
                                  com.tencent.mm.hellhoundlib.a.aFg();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.wiG, paramAnonymousa.wpf);
                                  com.tencent.mm.hellhoundlib.a.aFg();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.wcO, paramAnonymousa.wpf);
                                  paramAnonymousa.wpc = null;
                                  com.tencent.mm.hellhoundlib.a.aFg();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.wpd, paramAnonymousa.wpe);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.g.e.dfQ().wja.a(2, null);
                                  com.tencent.mm.plugin.expt.hellhound.a.g.e.wpr = null;
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.g.e.dfQ().wja.a(3, null);
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.wfd;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.wiY;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aT(0, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.wfd;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.wiY;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aT(1, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.wfd;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.wiY;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aT(2, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.wfd;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.wiY;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aT(3, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.JL(((Long)paramAnonymousa.wfd).longValue());
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.dfE();
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.core.b.c.e.b((fbo)paramAnonymousa.wfd);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.b.a.a((bvy)paramAnonymousa.wfd);
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
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c localc = com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB();
    com.tencent.mm.plugin.expt.hellhound.core.a.a.d locald = this.wfD;
    localc.wfh.wfj = locald;
    AppMethodBeat.o(121938);
  }
  
  private static com.tencent.mm.vending.j.d<String, Boolean, Boolean> Y(Activity paramActivity)
  {
    AppMethodBeat.i(121940);
    com.tencent.mm.vending.j.c localc = Z(paramActivity);
    if (!((Boolean)localc.get(1)).booleanValue())
    {
      paramActivity = com.tencent.mm.vending.j.a.h(localc.get(0), localc.get(1), Boolean.FALSE);
      AppMethodBeat.o(121940);
      return paramActivity;
    }
    boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramActivity.getClass().getCanonicalName());
    paramActivity = com.tencent.mm.vending.j.a.h(localc.get(0), localc.get(1), Boolean.valueOf(bool));
    AppMethodBeat.o(121940);
    return paramActivity;
  }
  
  static com.tencent.mm.vending.j.c<String, Boolean> Z(Activity paramActivity)
  {
    AppMethodBeat.i(121942);
    String str = null;
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.h.ab(paramActivity);
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
    paramActivity = com.tencent.mm.vending.j.a.J(localObject, Boolean.valueOf(bool));
    AppMethodBeat.o(121942);
    return paramActivity;
  }
  
  static esj a(esj paramesj)
  {
    AppMethodBeat.i(184315);
    esj localesj;
    if (paramesj != null)
    {
      localesj = paramesj;
      if (!TextUtils.isEmpty(paramesj.activityName)) {
        break label88;
      }
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
      com.tencent.mm.vending.j.c localc = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcF();
      if (localc == null)
      {
        AppMethodBeat.o(184315);
        return null;
      }
      localesj = paramesj;
      if (paramesj == null)
      {
        localesj = new esj();
        localesj.timestamp = System.currentTimeMillis();
      }
      localesj.activityName = ((String)localc.get(0));
      localesj.aNf = ((Integer)localc.get(1)).intValue();
      label88:
      AppMethodBeat.o(184315);
      return localesj;
    }
    catch (Exception paramesj)
    {
      Log.printErrStackTrace("HABBYGE-MALI.AsyncActivityMonitor", paramesj, "getActivityOnFinish", new Object[0]);
      AppMethodBeat.o(184315);
    }
    return null;
  }
  
  static void a(int paramInt, esj paramesj)
  {
    AppMethodBeat.i(184313);
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R(paramesj.activityName, null, 104);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.KC(101);
    if (localObject != null) {}
    for (localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);; localObject = null)
    {
      if (!paramesj.activityName.equals(localObject))
      {
        Log.w("HABBYGE-MALI.AsyncActivityMonitor", "_onCreateEvent: %s, %s", new Object[] { localObject, paramesj.activityName });
        b(paramInt, null, null, paramesj.activityName, paramesj.aNf, paramesj.timestamp);
      }
      a(paramesj.activityName, paramesj.aNf, com.tencent.mm.plugin.expt.hellhound.core.stack.a.wfo);
      AppMethodBeat.o(184313);
      return;
    }
  }
  
  static void a(String paramString, int paramInt, com.tencent.mm.plugin.expt.hellhound.core.stack.a parama)
  {
    AppMethodBeat.i(255943);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(paramString, paramInt, parama);
    AppMethodBeat.o(255943);
  }
  
  static void b(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(255944);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE().a(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramLong);
    AppMethodBeat.o(255944);
  }
  
  static void ba(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(121943);
    a.KA(1);
    if ((!paramBoolean) && (com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramString)))
    {
      Log.i("HABBYGE-MALI.AsyncActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
      AppMethodBeat.o(121943);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
    bl localbl = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
    String str = null;
    if (localbl != null) {
      str = localbl.RGy.activityName;
    }
    a.axg(paramString);
    a.axe(str);
    Log.i("HABBYGE-MALI.AsyncActivityMonitor", "setActivityActionOnFinish: from: %s, to: %s", new Object[] { paramString, str });
    AppMethodBeat.o(121943);
  }
  
  static dej c(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(184312);
    dej localdej = new dej();
    localdej.SXr = new esj();
    localdej.SXr.activityName = paramActivity.getClass().getCanonicalName();
    localdej.SXr.aNf = paramActivity.hashCode();
    localdej.SXr.timestamp = paramLong;
    paramActivity = Y(paramActivity);
    localdej.SXs = ((String)paramActivity.get(0));
    localdej.SXv = ((Boolean)paramActivity.get(1)).booleanValue();
    localdej.TqV = ((Boolean)paramActivity.get(2)).booleanValue();
    AppMethodBeat.o(184312);
    return localdej;
  }
  
  static dei g(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121941);
    dei localdei = new dei();
    if (paramIntent != null) {
      localdei.flags = paramIntent.getFlags();
    }
    localdei.SXr = new esj();
    if (paramActivity == null)
    {
      AppMethodBeat.o(121941);
      return localdei;
    }
    localdei.SXr.activityName = paramActivity.getClass().getCanonicalName();
    localdei.SXr.aNf = paramActivity.hashCode();
    localdei.SXr.timestamp = System.currentTimeMillis();
    AppMethodBeat.o(121941);
    return localdei;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.c
 * JD-Core Version:    0.7.0.1
 */