package com.tencent.mm.plugin.expt.hellhound.core.b.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.plugin.expt.b.e.c;
import com.tencent.mm.plugin.expt.hellhound.core.stack.g;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.m;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.bu;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.cag;
import com.tencent.mm.protocal.protobuf.cah;
import com.tencent.mm.protocal.protobuf.cal;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.protocal.protobuf.cav;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.drg;
import com.tencent.mm.protocal.protobuf.dwh;
import com.tencent.mm.protocal.protobuf.dwi;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.eyz;
import com.tencent.mm.protocal.protobuf.fhg;
import com.tencent.mm.protocal.protobuf.fme;
import com.tencent.mm.protocal.protobuf.fns;
import com.tencent.mm.protocal.protobuf.fxz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;

final class c
{
  private final com.tencent.mm.plugin.expt.hellhound.core.a.a.d zBE;
  e.a zBz;
  
  c()
  {
    AppMethodBeat.i(121938);
    this.zBE = new com.tencent.mm.plugin.expt.hellhound.core.a.a.d()
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
          if (paramAnonymousa.zBd != null)
          {
            Object localObject1 = (fhg)paramAnonymousa.zBd;
            Object localObject2;
            Object localObject3;
            boolean bool;
            Object localObject4;
            Object localObject5;
            Object localObject6;
            if (localObject1 != null)
            {
              Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_startActivity: %s, %s, %s", new Object[] { ((fhg)localObject1).aaEZ.AtM, ((fhg)localObject1).aaFa.AtM, ((fhg)localObject1).aajk });
              localObject2 = c.this;
              paramAnonymousa = null;
              if ((((fhg)localObject1).aaEZ == null) || (TextUtils.isEmpty(((fhg)localObject1).aaEZ.AtM))) {
                break label1104;
              }
              paramAnonymousa = ((fhg)localObject1).aaEZ.AtM;
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dJs();
              bool = ((fhg)localObject1).aajn;
              localObject4 = ((fhg)localObject1).aajk;
              ((com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c)localObject3).zBL.d(paramAnonymousa, bool, (String)localObject4);
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y(paramAnonymousa, ((fhg)localObject1).aajk, 100);
              localObject3 = ((fhg)localObject1).aaFa.AtM;
              Log.i("HABBYGE-MALI.AsyncActivityMonitor", "_startActivity, toActivity: %s, %s", new Object[] { paramAnonymousa, localObject3 });
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y((String)localObject3, null, 101);
              localObject4 = ((fhg)localObject1).aajm;
              localObject5 = ((fhg)localObject1).aaFc;
              localObject6 = ((fhg)localObject1).aaFb;
              if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.hj("Chat_User", (String)localObject4);
              }
              if ((!"1".equals(localObject6)) || (!"jd_store".equals(localObject5))) {
                break label1137;
              }
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.hj("minimize_secene", (String)localObject6);
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.hj("KPublisherId", (String)localObject5);
            }
            for (;;)
            {
              c.b(((fhg)localObject1).flags, paramAnonymousa, ((fhg)localObject1).aajk, (String)localObject3, 0, ((fhg)localObject1).timestamp);
              a.arh((String)localObject3);
              a.arj(paramAnonymousa);
              a.LA(0);
              if ((localObject3 != null) && (((c)localObject2).zBz != null)) {
                ((c)localObject2).zBz.aqd((String)localObject3);
              }
              AppMethodBeat.o(121937);
              return;
              label1104:
              com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dJl();
              if (localObject3 == null) {
                break;
              }
              paramAnonymousa = ((bt)localObject3).YDs.AtM;
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dJs().arn(paramAnonymousa);
              break;
              label1137:
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.hj("minimize_secene", "");
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.hj("KPublisherId", "");
            }
            if (paramAnonymousa.zBd != null)
            {
              paramAnonymousa = (fns)paramAnonymousa.zBd;
              long l;
              int i;
              if (paramAnonymousa != null)
              {
                Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_finish: %s", new Object[] { paramAnonymousa.AtM });
                localObject1 = c.this;
                localObject2 = c.a(paramAnonymousa);
                if (localObject2 != null)
                {
                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "_finish: %s", new Object[] { ((fns)localObject2).AtM });
                  com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y(((fns)localObject2).AtM, null, 102);
                  localObject5 = ((fns)localObject2).AtM;
                  l = ((fns)localObject2).timestamp;
                  localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg().zBw.zBx;
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
                  paramAnonymousa = new bt();
                  paramAnonymousa.YDs = new fns();
                  paramAnonymousa.YDs.AtM = ((fns)localObject2).AtM;
                  paramAnonymousa.YDs.cHb = ((fns)localObject2).cHb;
                  paramAnonymousa.YDs.timestamp = ((fns)localObject2).timestamp;
                  com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().a(null, paramAnonymousa, 1, null);
                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.zES;
                  com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.aru(((fns)localObject2).AtM);
                  com.tencent.mm.plugin.expt.hellhound.ext.f.e.dME().a(3, ((fns)localObject2).AtM, null);
                }
                c.bm(((fns)localObject2).AtM, true);
                if (((c)localObject1).zBz != null) {
                  ((c)localObject1).zBz.e(((fns)localObject2).AtM, ((fns)localObject2).cHb, ((fns)localObject2).timestamp);
                }
                AppMethodBeat.o(121937);
                return;
                localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.c.dJe();
                if (((bu)localObject4).YDy.isEmpty())
                {
                  i = 0;
                }
                else
                {
                  if (localObject4 != null)
                  {
                    i = ((bu)localObject4).YDy.size() - 1;
                    if (i >= 0)
                    {
                      localObject6 = (fme)((bu)localObject4).YDy.get(i);
                      j = ((fme)localObject6).abMA.size() - 1;
                      label1488:
                      if (j >= 0)
                      {
                        paramAnonymousa = (bt)((fme)localObject6).abMA.get(j);
                        if (paramAnonymousa.YDs.AtM.equals(localObject5))
                        {
                          ((fme)localObject6).abMA.remove(j);
                          if (((fme)localObject6).abMA.isEmpty()) {
                            ((bu)localObject4).YDy.remove(i);
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
                  com.tencent.mm.plugin.expt.hellhound.core.stack.c.a((bu)localObject4);
                  if (((g)localObject3).zBy != null)
                  {
                    paramAnonymousa.YDs.timestamp = l;
                    ((g)localObject3).zBy.b(paramAnonymousa, (bt)g.dJm().get(1));
                  }
                  i = 1;
                }
              }
              if (paramAnonymousa.zBd != null)
              {
                localObject1 = (drg)paramAnonymousa.zBd;
                if (localObject1 != null)
                {
                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_moveTaskToBack: %s", new Object[] { ((drg)localObject1).aajj.AtM });
                  paramAnonymousa = c.this;
                  localObject2 = ((drg)localObject1).aajj;
                  bool = ((drg)localObject1).aaFe;
                  localObject1 = c.a((fns)localObject2);
                  if (localObject1 != null)
                  {
                    Log.d("HABBYGE-MALI.AsyncActivityMonitor", "_moveTaskToBack: %s", new Object[] { ((fns)localObject1).AtM });
                    if (!TextUtils.isEmpty(((fns)localObject1).AtM))
                    {
                      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y(((fns)localObject1).AtM, null, 103);
                      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg().zBw.zBx;
                      localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.c.dJe();
                      localObject4 = new bt();
                      ((bt)localObject4).YDs = new fns();
                      ((bt)localObject4).YDs.AtM = ((fns)localObject1).AtM;
                      ((bt)localObject4).YDs.cHb = ((fns)localObject1).cHb;
                      ((bt)localObject4).YDs.timestamp = ((fns)localObject1).timestamp;
                      localObject5 = g.a((bu)localObject3, (bt)localObject4);
                      if (localObject5 != null)
                      {
                        localObject6 = (fme)((com.tencent.mm.vending.j.b)localObject5).get(0);
                        i = ((Integer)((com.tencent.mm.vending.j.c)localObject5).get(1)).intValue();
                        if (((bool) || (com.tencent.mm.plugin.expt.hellhound.core.stack.h.a(((bt)((fme)localObject6).abMA.getFirst()).YDs, ((bt)localObject4).YDs))) && (i == ((bu)localObject3).YDy.size() - 1))
                        {
                          ((bu)localObject3).YDy.remove(i);
                          ((bu)localObject3).YDy.addFirst(localObject6);
                          com.tencent.mm.plugin.expt.hellhound.core.stack.c.a((bu)localObject3);
                          if (((g)localObject2).zBy != null) {
                            ((g)localObject2).zBy.d((bt)localObject4, g.e((bu)localObject3));
                          }
                        }
                      }
                      c.bm(((fns)localObject1).AtM, false);
                      if (paramAnonymousa.zBz != null) {
                        paramAnonymousa.zBz.f(((fns)localObject1).AtM, ((fns)localObject1).cHb, ((fns)localObject1).timestamp);
                      }
                    }
                  }
                }
                AppMethodBeat.o(121937);
                return;
                if (paramAnonymousa.zBd != null)
                {
                  paramAnonymousa = (dwh)paramAnonymousa.zBd;
                  if (paramAnonymousa != null)
                  {
                    Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onCreate: %s", new Object[] { paramAnonymousa.aajj.AtM });
                    localObject1 = c.this;
                    localObject2 = paramAnonymousa.aajj;
                    c.a(paramAnonymousa.flags, (fns)localObject2);
                    if (((c)localObject1).zBz != null) {
                      ((c)localObject1).zBz.aqe(((fns)localObject2).AtM);
                    }
                  }
                  AppMethodBeat.o(121937);
                  return;
                  if (paramAnonymousa.zBd != null)
                  {
                    localObject1 = (dwh)paramAnonymousa.zBd;
                    if (localObject1 != null)
                    {
                      Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onNewIntent: %s", new Object[] { ((dwh)localObject1).aajj.AtM });
                      paramAnonymousa = c.this;
                      i = ((dwh)localObject1).flags;
                      localObject1 = ((dwh)localObject1).aajj;
                      c.a(i, (fns)localObject1);
                      if (paramAnonymousa.zBz != null) {
                        paramAnonymousa.zBz.aqf(((fns)localObject1).AtM);
                      }
                    }
                    AppMethodBeat.o(121937);
                    return;
                    if (paramAnonymousa.zBd != null)
                    {
                      paramAnonymousa = (fns)paramAnonymousa.zBd;
                      if (paramAnonymousa != null)
                      {
                        Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onResume: %s", new Object[] { paramAnonymousa.AtM });
                        localObject1 = c.this;
                        com.tencent.mm.plugin.expt.hellhound.ext.session.d.a.fa(com.tencent.mm.plugin.expt.hellhound.core.a.dIT().dIS());
                        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y(paramAnonymousa.AtM, null, 105);
                        com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
                        com.tencent.mm.plugin.expt.hellhound.core.stack.d.arf(paramAnonymousa.AtM);
                        c.a(paramAnonymousa.AtM, paramAnonymousa.cHb, com.tencent.mm.plugin.expt.hellhound.core.stack.a.zBp);
                        if (((c)localObject1).zBz != null) {
                          ((c)localObject1).zBz.g(paramAnonymousa.AtM, paramAnonymousa.cHb, paramAnonymousa.timestamp);
                        }
                      }
                      AppMethodBeat.o(121937);
                      return;
                      if (paramAnonymousa.zBd != null)
                      {
                        paramAnonymousa = (String)paramAnonymousa.zBd;
                        Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_UPDATE_SID: %s", new Object[] { paramAnonymousa });
                        if (!TextUtils.isEmpty(paramAnonymousa)) {
                          com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asv(paramAnonymousa);
                        }
                        AppMethodBeat.o(121937);
                        return;
                        if (paramAnonymousa.zBd != null)
                        {
                          paramAnonymousa = (dwi)paramAnonymousa.zBd;
                          if (paramAnonymousa != null)
                          {
                            Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPostResume: %s", new Object[] { paramAnonymousa.aajj.AtM });
                            if (c.this.zBz != null) {
                              c.this.zBz.aqg(paramAnonymousa.aajj.AtM);
                            }
                          }
                          AppMethodBeat.o(121937);
                          return;
                          if (paramAnonymousa.zBd != null)
                          {
                            paramAnonymousa = (fns)paramAnonymousa.zBd;
                            if (paramAnonymousa != null)
                            {
                              Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPause: %s", new Object[] { paramAnonymousa.AtM });
                              localObject1 = c.this;
                              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y(paramAnonymousa.AtM, null, 106);
                              c.a(paramAnonymousa.AtM, paramAnonymousa.cHb, com.tencent.mm.plugin.expt.hellhound.core.stack.a.zBq);
                              if (((c)localObject1).zBz != null) {
                                ((c)localObject1).zBz.h(paramAnonymousa.AtM, paramAnonymousa.cHb, paramAnonymousa.timestamp);
                              }
                            }
                            AppMethodBeat.o(121937);
                            return;
                            if (paramAnonymousa.zBd != null)
                            {
                              paramAnonymousa = (dwi)paramAnonymousa.zBd;
                              if (paramAnonymousa != null)
                              {
                                Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPaused: %s", new Object[] { paramAnonymousa.aajj.AtM });
                                if (c.this.zBz != null) {
                                  c.this.zBz.aqh(paramAnonymousa.aajj.AtM);
                                }
                              }
                              AppMethodBeat.o(121937);
                              return;
                              if (paramAnonymousa.zBd != null)
                              {
                                paramAnonymousa = (fns)paramAnonymousa.zBd;
                                if (paramAnonymousa != null)
                                {
                                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onStop: %s", new Object[] { paramAnonymousa.AtM });
                                  localObject1 = c.this;
                                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.aqJ(paramAnonymousa.AtM))
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y(paramAnonymousa.AtM, null, 107);
                                    c.a(paramAnonymousa.AtM, paramAnonymousa.cHb, com.tencent.mm.plugin.expt.hellhound.core.stack.a.zBr);
                                    if (((c)localObject1).zBz != null) {
                                      ((c)localObject1).zBz.i(paramAnonymousa.AtM, paramAnonymousa.cHb, paramAnonymousa.timestamp);
                                    }
                                  }
                                }
                                AppMethodBeat.o(121937);
                                return;
                                if (paramAnonymousa.zBd != null)
                                {
                                  paramAnonymousa = (fns)paramAnonymousa.zBd;
                                  if (paramAnonymousa != null)
                                  {
                                    Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onDestroy: %s", new Object[] { paramAnonymousa.AtM });
                                    localObject1 = c.this;
                                    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y(paramAnonymousa.AtM, null, 108);
                                    c.a(paramAnonymousa.AtM, paramAnonymousa.cHb, com.tencent.mm.plugin.expt.hellhound.core.stack.a.zBs);
                                    if (((c)localObject1).zBz != null) {
                                      ((c)localObject1).zBz.eh(paramAnonymousa.AtM, paramAnonymousa.cHb);
                                    }
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "HellMsgType.MSGQ_TYPE_FRAGMENT_RESUME recv !!");
                                  paramAnonymousa = (cah)paramAnonymousa.zBd;
                                  if (paramAnonymousa != null) {
                                    com.tencent.mm.plugin.expt.hellhound.core.a.dIT().zAO.a(paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (cag)paramAnonymousa.zBd;
                                  if (paramAnonymousa != null) {
                                    com.tencent.mm.plugin.expt.hellhound.core.a.dIT().zAO.a(paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_FRAGMENT_%d", new Object[] { Integer.valueOf(paramAnonymousa.msgType) });
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.dIT();
                                  i = paramAnonymousa.msgType;
                                  l = ((Long)paramAnonymousa.zBd).longValue();
                                  ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject1).zAO.Y(i, l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  Log.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_STORY_%d", new Object[] { Integer.valueOf(paramAnonymousa.msgType) });
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.dIT();
                                  i = paramAnonymousa.msgType;
                                  l = ((Long)paramAnonymousa.zBd).longValue();
                                  ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject1).zAO.Z(i, l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  try
                                  {
                                    i = ((Integer)paramAnonymousa.zBd).intValue();
                                    if (paramAnonymousa.msgType == 401)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.ext.session.d.a.LX(i);
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
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.d.a.LW(i);
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 402)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.d.c.LW(i);
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 403) {
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.d.c.LX(i);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.c.c.dLg();
                                  Log.i("HABBYGE-MALI.HellFrontBackMonitor", "add8EventMMProcessEndIfNeed");
                                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess())
                                  {
                                    paramAnonymousa = null;
                                    if (paramAnonymousa != null)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.ext.c.a.LR(8);
                                      a.LA(8);
                                      localObject1 = (String)paramAnonymousa.get(0);
                                      i = ((Integer)paramAnonymousa.get(1)).intValue();
                                      j = ((Integer)paramAnonymousa.get(2)).intValue();
                                      l = ((Long)paramAnonymousa.get(3)).longValue();
                                      int k = ((Integer)paramAnonymousa.get(4)).intValue();
                                      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "add8EventMMProcessEndIfNeed need 补充8事件: %s, %d, %s, %d", new Object[] { localObject1, Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(k) });
                                      if (((com.tencent.mm.plugin.expt.hellhound.ext.c.c)localObject2).zJO != null) {
                                        ((com.tencent.mm.plugin.expt.hellhound.ext.c.c)localObject2).zJO.a((String)localObject1, i, j, l, k);
                                      }
                                    }
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  i = Process.myPid();
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.c.a.dLf();
                                  paramAnonymousa = (com.tencent.mm.plugin.expt.hellhound.core.a.a.a)localObject1;
                                  if (localObject1 == null) {
                                    paramAnonymousa = new cal();
                                  }
                                  if (paramAnonymousa.aaju <= 0)
                                  {
                                    Log.i("HABBYGE-MALI.FrontBackDao", "handleLastProcessParams lastMMProcessId <= 0");
                                    paramAnonymousa = null;
                                  }
                                  for (;;)
                                  {
                                    break;
                                    if (paramAnonymousa.aaju != i)
                                    {
                                      Log.i("HABBYGE-MALI.FrontBackDao", "handleLastProcessParams last != curr ---1: %d, %d", new Object[] { Integer.valueOf(paramAnonymousa.aaju), Integer.valueOf(i) });
                                      if (paramAnonymousa.aajs == 7)
                                      {
                                        com.tencent.mm.plugin.expt.hellhound.ext.c.c.dLg();
                                        localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.c.a.dLf();
                                        if ((localObject1 != null) && (((cal)localObject1).aajw)) {}
                                        for (i = 1;; i = 0)
                                        {
                                          if (i == 0) {
                                            break label3451;
                                          }
                                          Log.i("HABBYGE-MALI.FrontBackDao", "getIsLogoutFromMMPageFlowService true");
                                          com.tencent.mm.plugin.expt.hellhound.ext.c.a.oV(false);
                                          paramAnonymousa = null;
                                          break;
                                        }
                                        label3451:
                                        if (TextUtils.isEmpty("page_hell_seq_mmkv_key")) {}
                                        for (i = -1;; i = MultiProcessMMKV.getMMKV("_hellhound_mmkv").getInt("page_hell_seq_mmkv_key", -1))
                                        {
                                          paramAnonymousa.oUj = i;
                                          paramAnonymousa = com.tencent.mm.vending.j.a.c(paramAnonymousa.aajv, Integer.valueOf(paramAnonymousa.cHb), Integer.valueOf(paramAnonymousa.aaju), Long.valueOf(paramAnonymousa.aajt), Integer.valueOf(paramAnonymousa.oUj));
                                          break;
                                        }
                                      }
                                    }
                                    else
                                    {
                                      Log.i("HABBYGE-MALI.FrontBackDao", "handleLastProcessParams last == curr: %d, %d", new Object[] { Integer.valueOf(paramAnonymousa.aaju), Integer.valueOf(i) });
                                    }
                                    paramAnonymousa = null;
                                  }
                                  localObject1 = (czv)paramAnonymousa.zBd;
                                  if (localObject1 != null)
                                  {
                                    paramAnonymousa = ((czv)localObject1).businessId;
                                    localObject1 = ((czv)localObject1).value;
                                    Log.i("HABBYGE-MALI.SyncBizCollector", "_collectBizData: %s, %s", new Object[] { paramAnonymousa, localObject1 });
                                    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
                                    localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH((String)com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJi().get(0));
                                    if (localObject2 != null)
                                    {
                                      Log.i("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, curActivityName: %s", new Object[] { localObject2 });
                                      localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.d.c.dLm();
                                      if (localObject3 != null) {
                                        break label3693;
                                      }
                                      Log.e("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, matchInfo is NULL !!");
                                    }
                                    label3938:
                                    for (;;)
                                    {
                                      localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.session.a.b.dLC();
                                      if (localObject3 != null) {
                                        break;
                                      }
                                      Log.e("HABBYGE-MALI.SyncBizCollector", "collectBizData, tuple2 is NULL");
                                      AppMethodBeat.o(121937);
                                      return;
                                      label3693:
                                      if (((cau)localObject3).aajN.isEmpty())
                                      {
                                        Log.e("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, matchInfo.sessionFuzzyPaths is NULL !!");
                                      }
                                      else
                                      {
                                        localObject4 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
                                        if (localObject4 == null)
                                        {
                                          Log.e("HABBYGE-MALI.SyncBizCollector", "addBizData2Fuzzy, curSession is NULL !!");
                                        }
                                        else
                                        {
                                          localObject5 = new czv();
                                          ((czv)localObject5).businessId = paramAnonymousa;
                                          ((czv)localObject5).value = ((String)localObject1);
                                          i = ((cau)localObject3).aajN.size() - 1;
                                          while (i >= 0)
                                          {
                                            localObject6 = (eyz)((cau)localObject3).aajN.get(i);
                                            if ((localObject6 != null) && (((eyz)localObject6).hQR != null) && (((eyz)localObject6).hQR.equals(((eah)localObject4).sessionId)))
                                            {
                                              localObject6 = ((eyz)localObject6).aajM.iterator();
                                              while (((Iterator)localObject6).hasNext())
                                              {
                                                caw localcaw = (caw)((Iterator)localObject6).next();
                                                if (!localcaw.aajU.isEmpty())
                                                {
                                                  j = localcaw.aajU.size() - 1;
                                                  for (;;)
                                                  {
                                                    if (j < 0) {
                                                      break label3938;
                                                    }
                                                    cav localcav = (cav)localcaw.aajU.get(j);
                                                    if (localcav != null)
                                                    {
                                                      String str = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(localcav.name);
                                                      if ((str != null) && (str.equals(localObject2)))
                                                      {
                                                        localcav.aajQ.addLast(localObject5);
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
                                          com.tencent.mm.plugin.expt.hellhound.ext.d.c.a((cau)localObject3);
                                        }
                                      }
                                    }
                                    localObject2 = (czu)((com.tencent.mm.vending.j.b)localObject3).get(0);
                                    i = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
                                    localObject3 = new czv();
                                    ((czv)localObject3).businessId = paramAnonymousa;
                                    ((czv)localObject3).value = ((String)localObject1);
                                    ((czu)localObject2).aajQ.add(localObject3);
                                    ((czu)localObject2).aaFk.add(localObject3);
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a((czu)localObject2, i);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject1 = (String)paramAnonymousa.zBd;
                                  if (localObject1 != null)
                                  {
                                    localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.a.b.dLC();
                                    if (localObject2 != null) {
                                      break label4103;
                                    }
                                    Log.e("HABBYGE-MALI.AsyncBizCollector", "getBizId, tuple2 is NULL");
                                  }
                                  for (paramAnonymousa = null;; paramAnonymousa = ((czv)localObject2).businessId)
                                  {
                                    Log.i("HABBYGE-MALI.AsyncBizCollector", "AsyncBizCollector, _collectBizId: %s", new Object[] { paramAnonymousa });
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD();
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.ho((String)localObject1, paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label4103:
                                    paramAnonymousa = (czu)((com.tencent.mm.vending.j.b)localObject2).get(0);
                                    i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
                                    j = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.hc(paramAnonymousa.aajQ.size() + 1, paramAnonymousa.aaFk.size() + 1);
                                    localObject2 = new czv();
                                    ((czv)localObject2).businessId = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.E(paramAnonymousa.startTime, j);
                                    paramAnonymousa.aajQ.add(localObject2);
                                    paramAnonymousa.aaFk.add(localObject2);
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(paramAnonymousa, i);
                                    Log.i("HABBYGE-MALI.AsyncBizCollector", "getBizId, addBizIdCurPageFlowItem: %s", new Object[] { ((czv)localObject2).businessId });
                                  }
                                  localObject1 = (czv)paramAnonymousa.zBd;
                                  if (localObject1 != null)
                                  {
                                    paramAnonymousa = ((czv)localObject1).dataPath;
                                    localObject2 = ((czv)localObject1).value;
                                    localObject3 = ((czv)localObject1).businessId;
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.a.a.ac(paramAnonymousa, (String)localObject2, (String)localObject3);
                                    if (localObject1 != null)
                                    {
                                      Log.i("HABBYGE-MALI.AsyncBizCollector", "_collectBizData: %s, %s, %s", new Object[] { paramAnonymousa, localObject2, localObject3 });
                                      if (localObject1 != null)
                                      {
                                        paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.ext.session.b.a.dLR();
                                        if ((paramAnonymousa == null) || (paramAnonymousa.isEmpty()))
                                        {
                                          paramAnonymousa = new JSONArray();
                                          paramAnonymousa.put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.ext.session.b.a.asL(System.currentTimeMillis() + "@" + paramAnonymousa.toString());
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
                                          com.tencent.mm.plugin.expt.hellhound.ext.session.b.a.asL(paramAnonymousa + "@" + ((JSONArray)localObject2).toString());
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
                                          com.tencent.mm.plugin.expt.hellhound.ext.session.b.a.asL(System.currentTimeMillis() + "@" + paramAnonymousa.toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                          paramAnonymousa = paramAnonymousa.split("@");
                                          if (paramAnonymousa.length <= 0) {
                                            paramAnonymousa = null;
                                          } else if (paramAnonymousa.length == 1) {
                                            paramAnonymousa = com.tencent.mm.vending.j.a.U(paramAnonymousa[0], null);
                                          } else {
                                            paramAnonymousa = com.tencent.mm.vending.j.a.U(paramAnonymousa[0], paramAnonymousa[1]);
                                          }
                                        }
                                        if ((TextUtils.isEmpty((CharSequence)paramAnonymousa.get(1))) && (!TextUtils.isEmpty((CharSequence)paramAnonymousa.get(0))))
                                        {
                                          localObject2 = new JSONArray();
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.ext.session.b.a.asL((String)paramAnonymousa.get(0) + "@" + ((JSONArray)localObject2).toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        try
                                        {
                                          localObject2 = new JSONArray((String)paramAnonymousa.get(1));
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.ext.session.b.a.asL((String)paramAnonymousa.get(0) + "@" + ((JSONArray)localObject2).toString());
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
                                  paramAnonymousa = (String)paramAnonymousa.zBd;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLA();
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD();
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.hq(paramAnonymousa, (String)localObject1);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.zBd;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.a.d.dLE();
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD();
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.hp(paramAnonymousa, (String)localObject1);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
                                  l = ((Long)paramAnonymousa.zBd).longValue();
                                  Log.i("HABBYGE-MALI.VoipFloatSession", "VoipMonitorCallback: _videoActivity2VoipFloat");
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.c.mk(l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
                                  l = ((Long)paramAnonymousa.zBd).longValue();
                                  localObject1 = ((com.tencent.mm.plugin.expt.hellhound.ext.session.b)localObject1).zKo;
                                  Log.i("HABBYGE-MALI.VoipFloatSession", "VoipMonitorCallback: _voipFloat2VideoActivity");
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
                                  if ((paramAnonymousa != null) && (!TextUtils.isEmpty(paramAnonymousa.sessionId))) {
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().a(paramAnonymousa, l);
                                  }
                                  Log.i("HABBYGE-MALI.VoipFloatSession", "_beignVoipSession");
                                  bool = false;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
                                  if (paramAnonymousa == null)
                                  {
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().a(null, "LauncherUI", "VideoActivity", 0, l);
                                    if (paramAnonymousa == null)
                                    {
                                      Log.e("HABBYGE-MALI.VoipFloatSession", "_beignFloatSession, 不是合法session ~~~");
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                    bool = true;
                                    Log.i("HABBYGE-MALI.VoipFloatSession", "_beignFloatSession, isNewSession: %s, %b", new Object[] { paramAnonymousa.sessionId, Boolean.valueOf(bool) });
                                    if ((((com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.c)localObject1).zKZ == null) || (!((com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.c)localObject1).zKZ.equals("com.tencent.mm.plugin.voip.ui.VideoActivity"))) {
                                      break label5134;
                                    }
                                  }
                                  label5134:
                                  for (i = ((com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.c)localObject1).zLa;; i = 0)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(paramAnonymousa, "VideoActivity", i, l);
                                    if (!bool) {
                                      break label5139;
                                    }
                                    paramAnonymousa.owq = 0;
                                    localObject2 = m.dLA();
                                    localObject1 = localObject2;
                                    if (localObject2 == null) {
                                      localObject1 = "";
                                    }
                                    paramAnonymousa.qkQ = ((String)localObject1);
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.j(paramAnonymousa);
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c(paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    Log.i("HABBYGE-MALI.VoipFloatSession", "_beignFloatSession, curSession: %s", new Object[] { paramAnonymousa.sessionId });
                                    break;
                                  }
                                  label5139:
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.k(paramAnonymousa);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
                                  l = ((Long)paramAnonymousa.zBd).longValue();
                                  Log.i("HABBYGE-MALI.VoipFloatSession", "VoipMonitorCallback: _closeVideoActivity");
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.c.mk(l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
                                  l = ((Long)paramAnonymousa.zBd).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.dMx();
                                  if (paramAnonymousa != null)
                                  {
                                    paramAnonymousa.aaiB = -1;
                                    paramAnonymousa.aaiC = -1;
                                    paramAnonymousa.aaiE = 7;
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.a(paramAnonymousa);
                                  }
                                  Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, stat, show: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.dMv()) });
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
                                  if ((paramAnonymousa == null) || (TextUtils.isEmpty(paramAnonymousa.sessionId)))
                                  {
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.core.b.dIV();
                                    if (paramAnonymousa != null) {
                                      com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().au((String)paramAnonymousa.first, l);
                                    }
                                  }
                                  for (;;)
                                  {
                                    Log.d("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession");
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
                                    bool = false;
                                    if (paramAnonymousa != null) {
                                      break label5453;
                                    }
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().a(null, "LauncherUI", "FloatingBall", 0, l);
                                    if (paramAnonymousa != null) {
                                      break;
                                    }
                                    Log.e("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession, 不是合法session ~~~");
                                    AppMethodBeat.o(121937);
                                    return;
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().a(paramAnonymousa, l);
                                  }
                                  bool = true;
                                  for (;;)
                                  {
                                    Log.d("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession, isNewSession: %s, %b", new Object[] { paramAnonymousa.sessionId, Boolean.valueOf(bool) });
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(paramAnonymousa, "FloatBall", 0, l);
                                    if (!bool) {
                                      break;
                                    }
                                    paramAnonymousa.owq = 0;
                                    localObject2 = m.dLA();
                                    localObject1 = localObject2;
                                    if (localObject2 == null) {
                                      localObject1 = "";
                                    }
                                    paramAnonymousa.qkQ = ((String)localObject1);
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.j(paramAnonymousa);
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c(paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label5453:
                                    Log.d("HABBYGE-MALI.FloatBallSessionHandler", "_beignFloatSession, curSession: %s", new Object[] { paramAnonymousa.sessionId });
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.k(paramAnonymousa);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
                                  l = ((Long)paramAnonymousa.zBd).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.dMw();
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
                                      com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().b(false, null, l);
                                    }
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.dMx();
                                    paramAnonymousa = (com.tencent.mm.plugin.expt.hellhound.core.a.a.a)localObject1;
                                    if (localObject1 == null) {
                                      paramAnonymousa = new bzj();
                                    }
                                    paramAnonymousa.aaiE = 8;
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.a(paramAnonymousa);
                                    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, stat, hide: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.dMv()) });
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
                                  l = ((Long)paramAnonymousa.zBd).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.dMw();
                                  if (paramAnonymousa != null)
                                  {
                                    if (((Integer)paramAnonymousa.second).intValue() == 6)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().b(false, null, l);
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
                                    com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.a.LY(4);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
                                  Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuBackgroundClicked");
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.hd(1, 1);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
                                  Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuBackPressed");
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.hd(0, 0);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
                                  Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuItemClicked");
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.hd(2, 2);
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.oX(true);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
                                  Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall: onFloatMenuItemRemoved");
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.hd(6, 6);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().b(false, null, 0L);
                                  AppMethodBeat.o(121937);
                                  return;
                                  i = ((Integer)paramAnonymousa.zBd).intValue();
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.a.LY(i);
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.ext.f.e.dME();
                                  localObject1 = paramAnonymousa.zLv;
                                  localObject2 = paramAnonymousa.zEK;
                                  localObject3 = paramAnonymousa.zLx;
                                  ((com.tencent.mm.plugin.expt.hellhound.ext.f.c)localObject1).zEK = ((com.tencent.mm.plugin.expt.hellhound.ext.a.f)localObject2);
                                  com.tencent.mm.hellhoundlib.a.aYh();
                                  com.tencent.mm.hellhoundlib.a.e(((com.tencent.mm.plugin.expt.hellhound.ext.f.c)localObject1).zCl, ((com.tencent.mm.plugin.expt.hellhound.ext.f.c)localObject1).zLj);
                                  ((com.tencent.mm.plugin.expt.hellhound.ext.f.c)localObject1).zLh = ((com.tencent.mm.plugin.expt.hellhound.ext.f.b)localObject3);
                                  com.tencent.mm.hellhoundlib.a.aYh();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.ext.f.c)localObject1).zEJ, ((com.tencent.mm.plugin.expt.hellhound.ext.f.c)localObject1).zLk);
                                  com.tencent.mm.hellhoundlib.a.aYh();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.ext.f.c)localObject1).zxJ, ((com.tencent.mm.plugin.expt.hellhound.ext.f.c)localObject1).zLk);
                                  com.tencent.mm.hellhoundlib.a.aYh();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.ext.f.c)localObject1).zLi, ((com.tencent.mm.plugin.expt.hellhound.ext.f.c)localObject1).zLj);
                                  if (paramAnonymousa.mActivityRef != null) {
                                    paramAnonymousa.zFd.a(0, (Activity)paramAnonymousa.mActivityRef.get());
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.ext.f.e.dME();
                                  paramAnonymousa.zFd.a(1, null);
                                  paramAnonymousa = paramAnonymousa.zLv;
                                  com.tencent.mm.hellhoundlib.a.aYh();
                                  com.tencent.mm.hellhoundlib.a.f(paramAnonymousa.zCl, paramAnonymousa.zLj);
                                  paramAnonymousa.zEK = null;
                                  com.tencent.mm.hellhoundlib.a.aYh();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.zEJ, paramAnonymousa.zLk);
                                  com.tencent.mm.hellhoundlib.a.aYh();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.zxJ, paramAnonymousa.zLk);
                                  paramAnonymousa.zLh = null;
                                  com.tencent.mm.hellhoundlib.a.aYh();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.zLi, paramAnonymousa.zLj);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.ext.f.e.dME().zFd.a(2, null);
                                  com.tencent.mm.plugin.expt.hellhound.ext.f.e.zLw = null;
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.ext.f.e.dME().zFd.a(3, null);
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.zBd;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.zES;
                                    com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.bn(0, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.zBd;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.zES;
                                    com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.bn(1, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.zBd;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.zES;
                                    com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.bn(2, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.zBd;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.zES;
                                    com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.bn(3, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.mj(((Long)paramAnonymousa.zBd).longValue());
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.dMs();
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.core.b.c.e.b((fxz)paramAnonymousa.zBd);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.a.a((ckz)paramAnonymousa.zBd);
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
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c localc = com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd();
    com.tencent.mm.plugin.expt.hellhound.core.a.a.d locald = this.zBE;
    localc.zBh.zBj = locald;
    AppMethodBeat.o(121938);
  }
  
  static fns a(fns paramfns)
  {
    AppMethodBeat.i(184315);
    fns localfns;
    if (paramfns != null)
    {
      localfns = paramfns;
      if (!TextUtils.isEmpty(paramfns.AtM)) {
        break label88;
      }
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
      com.tencent.mm.vending.j.c localc = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJh();
      if (localc == null)
      {
        AppMethodBeat.o(184315);
        return null;
      }
      localfns = paramfns;
      if (paramfns == null)
      {
        localfns = new fns();
        localfns.timestamp = System.currentTimeMillis();
      }
      localfns.AtM = ((String)localc.get(0));
      localfns.cHb = ((Integer)localc.get(1)).intValue();
      label88:
      AppMethodBeat.o(184315);
      return localfns;
    }
    catch (Exception paramfns)
    {
      Log.printErrStackTrace("HABBYGE-MALI.AsyncActivityMonitor", paramfns, "getActivityOnFinish", new Object[0]);
      AppMethodBeat.o(184315);
    }
    return null;
  }
  
  static void a(int paramInt, fns paramfns)
  {
    AppMethodBeat.i(184313);
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y(paramfns.AtM, null, 104);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.LC(101);
    if (localObject != null) {}
    for (localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);; localObject = null)
    {
      if (!paramfns.AtM.equals(localObject))
      {
        Log.w("HABBYGE-MALI.AsyncActivityMonitor", "_onCreateEvent: %s, %s", new Object[] { localObject, paramfns.AtM });
        b(paramInt, null, null, paramfns.AtM, paramfns.cHb, paramfns.timestamp);
      }
      a(paramfns.AtM, paramfns.cHb, com.tencent.mm.plugin.expt.hellhound.core.stack.a.zBo);
      AppMethodBeat.o(184313);
      return;
    }
  }
  
  static void a(String paramString, int paramInt, com.tencent.mm.plugin.expt.hellhound.core.stack.a parama)
  {
    AppMethodBeat.i(300033);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(paramString, paramInt, parama);
    AppMethodBeat.o(300033);
  }
  
  private static com.tencent.mm.vending.j.d<String, Boolean, Boolean> ah(Activity paramActivity)
  {
    AppMethodBeat.i(121940);
    com.tencent.mm.vending.j.c localc = ai(paramActivity);
    if (!((Boolean)localc.get(1)).booleanValue())
    {
      paramActivity = com.tencent.mm.vending.j.a.g((String)localc.get(0), (Boolean)localc.get(1), Boolean.FALSE);
      AppMethodBeat.o(121940);
      return paramActivity;
    }
    boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.aqC(paramActivity.getClass().getCanonicalName());
    paramActivity = com.tencent.mm.vending.j.a.g((String)localc.get(0), (Boolean)localc.get(1), Boolean.valueOf(bool));
    AppMethodBeat.o(121940);
    return paramActivity;
  }
  
  static com.tencent.mm.vending.j.c<String, Boolean> ai(Activity paramActivity)
  {
    AppMethodBeat.i(121942);
    String str = null;
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.h.ak(paramActivity);
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
    paramActivity = com.tencent.mm.vending.j.a.U(localObject, Boolean.valueOf(bool));
    AppMethodBeat.o(121942);
    return paramActivity;
  }
  
  static void b(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(300037);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg().a(paramInt1, paramString1, paramString2, paramString3, paramInt2, paramLong);
    AppMethodBeat.o(300037);
  }
  
  static void bm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(121943);
    a.LA(1);
    if ((!paramBoolean) && (com.tencent.mm.plugin.expt.hellhound.core.b.aqC(paramString)))
    {
      Log.i("HABBYGE-MALI.AsyncActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
      AppMethodBeat.o(121943);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
    bt localbt = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dJl();
    String str = null;
    if (localbt != null) {
      str = localbt.YDs.AtM;
    }
    a.ark(paramString);
    a.ari(str);
    Log.i("HABBYGE-MALI.AsyncActivityMonitor", "setActivityActionOnFinish: from: %s, to: %s", new Object[] { paramString, str });
    AppMethodBeat.o(121943);
  }
  
  static dwi c(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(184312);
    dwi localdwi = new dwi();
    localdwi.aajj = new fns();
    localdwi.aajj.AtM = paramActivity.getClass().getCanonicalName();
    localdwi.aajj.cHb = paramActivity.hashCode();
    localdwi.aajj.timestamp = paramLong;
    paramActivity = ah(paramActivity);
    localdwi.aajk = ((String)paramActivity.get(0));
    localdwi.aajn = ((Boolean)paramActivity.get(1)).booleanValue();
    localdwi.aaFd = ((Boolean)paramActivity.get(2)).booleanValue();
    AppMethodBeat.o(184312);
    return localdwi;
  }
  
  static dwh g(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121941);
    dwh localdwh = new dwh();
    if (paramIntent != null) {
      localdwh.flags = paramIntent.getFlags();
    }
    localdwh.aajj = new fns();
    if (paramActivity == null)
    {
      AppMethodBeat.o(121941);
      return localdwh;
    }
    localdwh.aajj.AtM = paramActivity.getClass().getCanonicalName();
    localdwh.aajj.cHb = paramActivity.hashCode();
    localdwh.aajj.timestamp = System.currentTimeMillis();
    AppMethodBeat.o(121941);
    return localdwh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.c
 * JD-Core Version:    0.7.0.1
 */