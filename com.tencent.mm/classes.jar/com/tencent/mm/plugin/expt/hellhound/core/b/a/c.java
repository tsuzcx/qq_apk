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
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.protocal.protobuf.bsf;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.cqn;
import com.tencent.mm.protocal.protobuf.cxd;
import com.tencent.mm.protocal.protobuf.dbj;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;

final class c
{
  d.a pED;
  private final com.tencent.mm.plugin.expt.hellhound.core.a.a.d pEH;
  
  c()
  {
    AppMethodBeat.i(121938);
    this.pEH = new com.tencent.mm.plugin.expt.hellhound.core.a.a.d()
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
          if (paramAnonymousa.pEf != null)
          {
            Object localObject1 = (cxd)paramAnonymousa.pEf;
            Object localObject2;
            Object localObject3;
            boolean bool;
            Object localObject4;
            Object localObject5;
            Object localObject6;
            if (localObject1 != null)
            {
              ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_startActivity: %s, %s, %s", new Object[] { ((cxd)localObject1).DDG.activityName, ((cxd)localObject1).DDH.activityName, ((cxd)localObject1).DnF });
              localObject2 = c.this;
              paramAnonymousa = null;
              if ((((cxd)localObject1).DDG == null) || (TextUtils.isEmpty(((cxd)localObject1).DDG.activityName))) {
                break label1088;
              }
              paramAnonymousa = ((cxd)localObject1).DDG.activityName;
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cbS();
              bool = ((cxd)localObject1).DnH;
              localObject4 = ((cxd)localObject1).DnF;
              ((com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c)localObject3).pEO.b(paramAnonymousa, bool, (String)localObject4);
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K(paramAnonymousa, ((cxd)localObject1).DnF, 100);
              localObject3 = ((cxd)localObject1).DDH.activityName;
              ad.i("HABBYGE-MALI.AsyncActivityMonitor", "_startActivity, toActivity: %s, %s", new Object[] { paramAnonymousa, localObject3 });
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K((String)localObject3, null, 101);
              localObject4 = ((cxd)localObject1).DnG;
              localObject5 = ((cxd)localObject1).DDJ;
              localObject6 = ((cxd)localObject1).DDI;
              if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fu("Chat_User", (String)localObject4);
              }
              if ((!"1".equals(localObject6)) || (!"jd_store".equals(localObject5))) {
                break label1121;
              }
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fu("minimize_secene", (String)localObject6);
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fu("KPublisherId", (String)localObject5);
            }
            for (;;)
            {
              c.b(((cxd)localObject1).flags, paramAnonymousa, ((cxd)localObject1).DnF, (String)localObject3, null, ((cxd)localObject1).timestamp);
              a.VR((String)localObject3);
              a.VT(paramAnonymousa);
              a.Bp(0);
              if ((localObject3 != null) && (((c)localObject2).pED != null)) {
                ((c)localObject2).pED.Vn((String)localObject3);
              }
              AppMethodBeat.o(121937);
              return;
              label1088:
              com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
              localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
              if (localObject3 == null) {
                break;
              }
              paramAnonymousa = ((bh)localObject3).CvH.activityName;
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cbS().VX(paramAnonymousa);
              break;
              label1121:
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fu("minimize_secene", "");
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fu("KPublisherId", "");
            }
            if (paramAnonymousa.pEf != null)
            {
              paramAnonymousa = (dcm)paramAnonymousa.pEf;
              long l;
              int i;
              if (paramAnonymousa != null)
              {
                ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_finish: %s", new Object[] { paramAnonymousa.activityName });
                localObject1 = c.this;
                localObject2 = c.a(paramAnonymousa);
                if (localObject2 != null)
                {
                  ad.i("HABBYGE-MALI.AsyncActivityMonitor", "_finish: %s", new Object[] { ((dcm)localObject2).activityName });
                  com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K(((dcm)localObject2).activityName, null, 102);
                  localObject5 = ((dcm)localObject2).activityName;
                  l = ((dcm)localObject2).timestamp;
                  localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG().pEy.pEz;
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
                  ad.w("HABBYGE-MALI.AsyncActivityMonitor", "_finish, popSuccess FALSE");
                  paramAnonymousa = new bh();
                  paramAnonymousa.CvH = new dcm();
                  paramAnonymousa.CvH.activityName = ((dcm)localObject2).activityName;
                  paramAnonymousa.CvH.DnR = ((dcm)localObject2).DnR;
                  paramAnonymousa.CvH.timestamp = ((dcm)localObject2).timestamp;
                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().a(null, paramAnonymousa, 1, null);
                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.KFp;
                  com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aUU(((dcm)localObject2).activityName);
                  com.tencent.mm.plugin.expt.hellhound.a.g.c.cdO().a(3, ((dcm)localObject2).activityName, null);
                }
                c.aQ(((dcm)localObject2).activityName, true);
                if (((c)localObject1).pED != null) {
                  ((c)localObject1).pED.g(((dcm)localObject2).activityName, ((dcm)localObject2).DnR, ((dcm)localObject2).timestamp);
                }
                AppMethodBeat.o(121937);
                return;
                localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.c.cbE();
                if (((bi)localObject4).CvM.isEmpty())
                {
                  i = 0;
                }
                else
                {
                  if (localObject4 != null)
                  {
                    i = ((bi)localObject4).CvM.size() - 1;
                    label1443:
                    if (i >= 0)
                    {
                      localObject6 = (dbj)((bi)localObject4).CvM.get(i);
                      j = ((dbj)localObject6).EsW.size() - 1;
                      label1472:
                      if (j >= 0)
                      {
                        paramAnonymousa = (bh)((dbj)localObject6).EsW.get(j);
                        if (paramAnonymousa.CvH.activityName.equals(localObject5))
                        {
                          ((dbj)localObject6).EsW.remove(j);
                          if (((dbj)localObject6).EsW.isEmpty()) {
                            ((bi)localObject4).CvM.remove(i);
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
                  com.tencent.mm.plugin.expt.hellhound.core.stack.c.a((bi)localObject4);
                  if (((com.tencent.mm.plugin.expt.hellhound.core.stack.g)localObject3).pEC != null)
                  {
                    paramAnonymousa.CvH.timestamp = l;
                    ((com.tencent.mm.plugin.expt.hellhound.core.stack.g)localObject3).pEC.b(paramAnonymousa, (bh)com.tencent.mm.plugin.expt.hellhound.core.stack.g.cbM().get(1));
                  }
                  i = 1;
                }
              }
              if (paramAnonymousa.pEf != null)
              {
                localObject1 = (bsf)paramAnonymousa.pEf;
                if (localObject1 != null)
                {
                  ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_moveTaskToBack: %s", new Object[] { ((bsf)localObject1).DnE.activityName });
                  paramAnonymousa = c.this;
                  localObject2 = ((bsf)localObject1).DnE;
                  bool = ((bsf)localObject1).DDL;
                  localObject1 = c.a((dcm)localObject2);
                  if (localObject1 != null)
                  {
                    ad.d("HABBYGE-MALI.AsyncActivityMonitor", "_moveTaskToBack: %s", new Object[] { ((dcm)localObject1).activityName });
                    if (!TextUtils.isEmpty(((dcm)localObject1).activityName))
                    {
                      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K(((dcm)localObject1).activityName, null, 103);
                      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG().pEy.pEz;
                      localObject3 = com.tencent.mm.plugin.expt.hellhound.core.stack.c.cbE();
                      localObject4 = new bh();
                      ((bh)localObject4).CvH = new dcm();
                      ((bh)localObject4).CvH.activityName = ((dcm)localObject1).activityName;
                      ((bh)localObject4).CvH.DnR = ((dcm)localObject1).DnR;
                      ((bh)localObject4).CvH.timestamp = ((dcm)localObject1).timestamp;
                      localObject5 = com.tencent.mm.plugin.expt.hellhound.core.stack.g.a((bi)localObject3, (bh)localObject4);
                      if (localObject5 != null)
                      {
                        localObject6 = (dbj)((com.tencent.mm.vending.j.b)localObject5).get(0);
                        i = ((Integer)((com.tencent.mm.vending.j.c)localObject5).get(1)).intValue();
                        if (((bool) || (h.a(((bh)((dbj)localObject6).EsW.getFirst()).CvH, ((bh)localObject4).CvH))) && (i == ((bi)localObject3).CvM.size() - 1))
                        {
                          ((bi)localObject3).CvM.remove(i);
                          ((bi)localObject3).CvM.addFirst(localObject6);
                          com.tencent.mm.plugin.expt.hellhound.core.stack.c.a((bi)localObject3);
                          if (((com.tencent.mm.plugin.expt.hellhound.core.stack.g)localObject2).pEC != null) {
                            ((com.tencent.mm.plugin.expt.hellhound.core.stack.g)localObject2).pEC.d((bh)localObject4, com.tencent.mm.plugin.expt.hellhound.core.stack.g.e((bi)localObject3));
                          }
                        }
                      }
                      c.aQ(((dcm)localObject1).activityName, false);
                      if (paramAnonymousa.pED != null) {
                        paramAnonymousa.pED.h(((dcm)localObject1).activityName, ((dcm)localObject1).DnR, ((dcm)localObject1).timestamp);
                      }
                    }
                  }
                }
                AppMethodBeat.o(121937);
                return;
                if (paramAnonymousa.pEf != null)
                {
                  paramAnonymousa = (bup)paramAnonymousa.pEf;
                  if (paramAnonymousa != null)
                  {
                    ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onCreate: %s", new Object[] { paramAnonymousa.DnE.activityName });
                    localObject1 = c.this;
                    localObject2 = paramAnonymousa.DnE;
                    i = paramAnonymousa.flags;
                    ad.d("HABBYGE-MALI.AsyncActivityMonitor", "_onCreate: 0x%s, %s, %s", new Object[] { Integer.toHexString(i), ((dcm)localObject2).activityName, ((dcm)localObject2).DnR });
                    c.a(i, (dcm)localObject2);
                    if (((c)localObject1).pED != null) {
                      ((c)localObject1).pED.Vo(((dcm)localObject2).activityName);
                    }
                  }
                  AppMethodBeat.o(121937);
                  return;
                  if (paramAnonymousa.pEf != null)
                  {
                    localObject1 = (bup)paramAnonymousa.pEf;
                    if (localObject1 != null)
                    {
                      ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onNewIntent: %s", new Object[] { ((bup)localObject1).DnE.activityName });
                      paramAnonymousa = c.this;
                      i = ((bup)localObject1).flags;
                      localObject1 = ((bup)localObject1).DnE;
                      ad.d("HABBYGE-MALI.AsyncActivityMonitor", "_onNewIntent: 0x%s, %s, %s", new Object[] { Integer.toHexString(i), ((dcm)localObject1).activityName, ((dcm)localObject1).DnR });
                      c.a(i, (dcm)localObject1);
                      if (paramAnonymousa.pED != null) {
                        paramAnonymousa.pED.Vp(((dcm)localObject1).activityName);
                      }
                    }
                    AppMethodBeat.o(121937);
                    return;
                    if (paramAnonymousa.pEf != null)
                    {
                      paramAnonymousa = (dcm)paramAnonymousa.pEf;
                      if (paramAnonymousa != null)
                      {
                        ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onResume: %s", new Object[] { paramAnonymousa.activityName });
                        localObject1 = c.this;
                        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K(paramAnonymousa.activityName, null, 105);
                        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
                        com.tencent.mm.plugin.expt.hellhound.core.stack.d.VP(paramAnonymousa.activityName);
                        c.a(paramAnonymousa.activityName, paramAnonymousa.DnR, com.tencent.mm.plugin.expt.hellhound.core.stack.a.pEr);
                        if (((c)localObject1).pED != null) {
                          ((c)localObject1).pED.i(paramAnonymousa.activityName, paramAnonymousa.DnR, paramAnonymousa.timestamp);
                        }
                      }
                      AppMethodBeat.o(121937);
                      return;
                      if (paramAnonymousa.pEf != null)
                      {
                        paramAnonymousa = (String)paramAnonymousa.pEf;
                        ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_UPDATE_SID: %s", new Object[] { paramAnonymousa });
                        if (!TextUtils.isEmpty(paramAnonymousa)) {
                          com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wy(paramAnonymousa);
                        }
                        AppMethodBeat.o(121937);
                        return;
                        if (paramAnonymousa.pEf != null)
                        {
                          paramAnonymousa = (buq)paramAnonymousa.pEf;
                          if (paramAnonymousa != null)
                          {
                            ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPostResume: %s", new Object[] { paramAnonymousa.DnE.activityName });
                            if (c.this.pED != null) {
                              c.this.pED.Vq(paramAnonymousa.DnE.activityName);
                            }
                          }
                          AppMethodBeat.o(121937);
                          return;
                          if (paramAnonymousa.pEf != null)
                          {
                            paramAnonymousa = (dcm)paramAnonymousa.pEf;
                            if (paramAnonymousa != null)
                            {
                              ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPause: %s", new Object[] { paramAnonymousa.activityName });
                              localObject1 = c.this;
                              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K(paramAnonymousa.activityName, null, 106);
                              c.a(paramAnonymousa.activityName, paramAnonymousa.DnR, com.tencent.mm.plugin.expt.hellhound.core.stack.a.pEs);
                              if (((c)localObject1).pED != null) {
                                ((c)localObject1).pED.j(paramAnonymousa.activityName, paramAnonymousa.DnR, paramAnonymousa.timestamp);
                              }
                            }
                            AppMethodBeat.o(121937);
                            return;
                            if (paramAnonymousa.pEf != null)
                            {
                              paramAnonymousa = (buq)paramAnonymousa.pEf;
                              if (paramAnonymousa != null)
                              {
                                ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onPaused: %s", new Object[] { paramAnonymousa.DnE.activityName });
                                if (c.this.pED != null) {
                                  c.this.pED.Vr(paramAnonymousa.DnE.activityName);
                                }
                              }
                              AppMethodBeat.o(121937);
                              return;
                              if (paramAnonymousa.pEf != null)
                              {
                                paramAnonymousa = (dcm)paramAnonymousa.pEf;
                                if (paramAnonymousa != null)
                                {
                                  ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onStop: %s", new Object[] { paramAnonymousa.activityName });
                                  localObject1 = c.this;
                                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.VA(paramAnonymousa.activityName))
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K(paramAnonymousa.activityName, null, 107);
                                    c.a(paramAnonymousa.activityName, paramAnonymousa.DnR, com.tencent.mm.plugin.expt.hellhound.core.stack.a.pEt);
                                    if (((c)localObject1).pED != null) {
                                      ((c)localObject1).pED.k(paramAnonymousa.activityName, paramAnonymousa.DnR, paramAnonymousa.timestamp);
                                    }
                                  }
                                }
                                AppMethodBeat.o(121937);
                                return;
                                if (paramAnonymousa.pEf != null)
                                {
                                  paramAnonymousa = (dcm)paramAnonymousa.pEf;
                                  if (paramAnonymousa != null)
                                  {
                                    ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_ACTIVITY_onDestroy: %s", new Object[] { paramAnonymousa.activityName });
                                    localObject1 = c.this;
                                    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K(paramAnonymousa.activityName, null, 108);
                                    c.a(paramAnonymousa.activityName, paramAnonymousa.DnR, com.tencent.mm.plugin.expt.hellhound.core.stack.a.pEu);
                                    if (((c)localObject1).pED != null) {
                                      ((c)localObject1).pED.fr(paramAnonymousa.activityName, paramAnonymousa.DnR);
                                    }
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  ad.i("HABBYGE-MALI.AsyncActivityMonitor", "HellMsgType.MSGQ_TYPE_FRAGMENT_RESUME recv !!");
                                  paramAnonymousa = (amo)paramAnonymousa.pEf;
                                  if (paramAnonymousa != null) {
                                    com.tencent.mm.plugin.expt.hellhound.core.a.cbt().pDT.a(paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (amn)paramAnonymousa.pEf;
                                  if (paramAnonymousa != null) {
                                    com.tencent.mm.plugin.expt.hellhound.core.a.cbt().pDT.a(paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_FRAGMENT_%d", new Object[] { Integer.valueOf(paramAnonymousa.msgType) });
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.cbt();
                                  i = paramAnonymousa.msgType;
                                  l = ((Long)paramAnonymousa.pEf).longValue();
                                  ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject1).pDT.Q(i, l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  ad.i("HABBYGE-MALI.AsyncActivityMonitor", "MSGQ_TYPE_STORY_%d", new Object[] { Integer.valueOf(paramAnonymousa.msgType) });
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.cbt();
                                  i = paramAnonymousa.msgType;
                                  l = ((Long)paramAnonymousa.pEf).longValue();
                                  ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject1).pDT.R(i, l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  try
                                  {
                                    i = ((Integer)paramAnonymousa.pEf).intValue();
                                    if (paramAnonymousa.msgType == 401)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.e.a.BI(i);
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                  }
                                  catch (Exception paramAnonymousa)
                                  {
                                    ad.printErrStackTrace("HABBYGE-MALI.AsyncActivityMonitor", paramAnonymousa, "CATCH_ACTIVITY_ONRESUME: %s", new Object[] { paramAnonymousa.getMessage() });
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 400)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.BH(i);
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 402)
                                  {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.BH(i);
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  if (paramAnonymousa.msgType == 403) {
                                    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.BI(i);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject2 = com.tencent.mm.plugin.expt.hellhound.a.c.c.ccq();
                                  ad.i("HellFrontBackMonitor", "HABBYGE-MALI, add8EventMMProcessEndIfNeed");
                                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.cbv())
                                  {
                                    paramAnonymousa = null;
                                    if (paramAnonymousa != null)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.c.a.BB(8);
                                      a.Bp(8);
                                      localObject1 = (String)paramAnonymousa.get(0);
                                      localObject3 = (String)paramAnonymousa.get(1);
                                      i = ((Integer)paramAnonymousa.get(2)).intValue();
                                      l = ((Long)paramAnonymousa.get(3)).longValue();
                                      j = ((Integer)paramAnonymousa.get(4)).intValue();
                                      ad.i("HellFrontBackMonitor", "HABBYGE-MALI, add8EventMMProcessEndIfNeed need 补充8事件: %s, %d, %s, %d", new Object[] { localObject1, Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j) });
                                      if (((com.tencent.mm.plugin.expt.hellhound.a.c.c)localObject2).pGI != null) {
                                        ((com.tencent.mm.plugin.expt.hellhound.a.c.c)localObject2).pGI.a((String)localObject1, (String)localObject3, i, l, j);
                                      }
                                    }
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  i = Process.myPid();
                                  localObject1 = com.tencent.mm.plugin.expt.hellhound.a.c.a.ccp();
                                  paramAnonymousa = (com.tencent.mm.plugin.expt.hellhound.core.a.a.a)localObject1;
                                  if (localObject1 == null) {
                                    paramAnonymousa = new amt();
                                  }
                                  if (paramAnonymousa.DnP <= 0)
                                  {
                                    ad.i("FrontBackDao", "habbyge-mali, handleLastProcessParams lastMMProcessId <= 0");
                                    paramAnonymousa = null;
                                  }
                                  for (;;)
                                  {
                                    break;
                                    if (paramAnonymousa.DnP != i)
                                    {
                                      ad.i("FrontBackDao", "habbyge-mali, handleLastProcessParams last != curr ---1: %d, %d", new Object[] { Integer.valueOf(paramAnonymousa.DnP), Integer.valueOf(i) });
                                      if (paramAnonymousa.DnN == 7)
                                      {
                                        com.tencent.mm.plugin.expt.hellhound.a.c.c.ccq();
                                        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.c.a.ccp();
                                        if ((localObject1 != null) && (((amt)localObject1).DnS)) {}
                                        for (i = 1;; i = 0)
                                        {
                                          if (i == 0) {
                                            break label3494;
                                          }
                                          ad.i("FrontBackDao", "HABBYGE-MALI, getIsLogoutFromMMPageFlowService true");
                                          com.tencent.mm.plugin.expt.hellhound.a.c.a.ke(false);
                                          paramAnonymousa = null;
                                          break;
                                        }
                                        label3494:
                                        if (TextUtils.isEmpty("page_hell_seq_mmkv_key")) {}
                                        for (i = -1;; i = ax.aFC("_hellhound_mmkv").getInt("page_hell_seq_mmkv_key", -1))
                                        {
                                          paramAnonymousa.htk = i;
                                          localObject1 = paramAnonymousa.DnQ;
                                          localObject3 = paramAnonymousa.DnR;
                                          i = paramAnonymousa.DnP;
                                          l = paramAnonymousa.DnO;
                                          j = paramAnonymousa.htk;
                                          paramAnonymousa = new com.tencent.mm.vending.j.f();
                                          paramAnonymousa.HQZ = new Object[] { localObject1, localObject3, Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j) };
                                          paramAnonymousa = (com.tencent.mm.vending.j.f)paramAnonymousa;
                                          break;
                                        }
                                      }
                                    }
                                    else
                                    {
                                      ad.i("FrontBackDao", "habbyge-mali, handleLastProcessParams last == curr: %d, %d", new Object[] { Integer.valueOf(paramAnonymousa.DnP), Integer.valueOf(i) });
                                    }
                                    paramAnonymousa = null;
                                  }
                                  localObject1 = (bgd)paramAnonymousa.pEf;
                                  if (localObject1 != null)
                                  {
                                    paramAnonymousa = ((bgd)localObject1).jOx;
                                    localObject1 = ((bgd)localObject1).value;
                                    ad.i("SyncBizCollector", "HABBYGE-MALI, _collectBizData: %s, %s", new Object[] { paramAnonymousa, localObject1 });
                                    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
                                    localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy((String)com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbI().get(0));
                                    if (localObject2 != null)
                                    {
                                      ad.i("SyncBizCollector", "HABBYGE-MALI, addBizData2Fuzzy, curActivityName: %s", new Object[] { localObject2 });
                                      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.d.d.ccv();
                                      if (localObject3 != null) {
                                        break label3781;
                                      }
                                      ad.e("SyncBizCollector", "HABBYGE-MALI, addBizData2Fuzzy, matchInfo is NULL !!");
                                    }
                                    label4026:
                                    for (;;)
                                    {
                                      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.a.b.ccL();
                                      if (localObject3 != null) {
                                        break;
                                      }
                                      ad.e("SyncBizCollector", "HABBYGE-MALI, collectBizData, tuple2 is NULL");
                                      AppMethodBeat.o(121937);
                                      return;
                                      label3781:
                                      if (((ana)localObject3).Doa.isEmpty())
                                      {
                                        ad.e("SyncBizCollector", "HABBYGE-MALI, addBizData2Fuzzy, matchInfo.sessionFuzzyPaths is NULL !!");
                                      }
                                      else
                                      {
                                        localObject4 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
                                        if (localObject4 == null)
                                        {
                                          ad.e("SyncBizCollector", "HABBYGE-MALI, addBizData2Fuzzy, curSession is NULL !!");
                                        }
                                        else
                                        {
                                          localObject5 = new bgd();
                                          ((bgd)localObject5).jOx = paramAnonymousa;
                                          ((bgd)localObject5).value = ((String)localObject1);
                                          i = ((ana)localObject3).Doa.size() - 1;
                                          while (i >= 0)
                                          {
                                            localObject6 = (cqn)((ana)localObject3).Doa.get(i);
                                            if ((localObject6 != null) && (((cqn)localObject6).dpw != null) && (((cqn)localObject6).dpw.equals(((bxx)localObject4).sessionId)))
                                            {
                                              localObject6 = ((cqn)localObject6).DnZ.iterator();
                                              while (((Iterator)localObject6).hasNext())
                                              {
                                                anc localanc = (anc)((Iterator)localObject6).next();
                                                if (!localanc.Dog.isEmpty())
                                                {
                                                  j = localanc.Dog.size() - 1;
                                                  for (;;)
                                                  {
                                                    if (j < 0) {
                                                      break label4026;
                                                    }
                                                    anb localanb = (anb)localanc.Dog.get(j);
                                                    if (localanb != null)
                                                    {
                                                      String str = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(localanb.name);
                                                      if ((str != null) && (str.equals(localObject2)))
                                                      {
                                                        localanb.Dod.addLast(localObject5);
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
                                          com.tencent.mm.plugin.expt.hellhound.a.d.d.a((ana)localObject3);
                                        }
                                      }
                                    }
                                    localObject2 = (bgc)((com.tencent.mm.vending.j.b)localObject3).get(0);
                                    i = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
                                    localObject3 = new bgd();
                                    ((bgd)localObject3).jOx = paramAnonymousa;
                                    ((bgd)localObject3).value = ((String)localObject1);
                                    ((bgc)localObject2).Dod.add(localObject3);
                                    ((bgc)localObject2).DDQ.add(localObject3);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((bgc)localObject2, i);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  localObject1 = (String)paramAnonymousa.pEf;
                                  if (localObject1 != null)
                                  {
                                    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.a.b.ccL();
                                    if (localObject2 != null) {
                                      break label4191;
                                    }
                                    ad.e("AsyncBizCollector", "HABBYGE-MALI, getBizId, tuple2 is NULL");
                                  }
                                  for (paramAnonymousa = null;; paramAnonymousa = ((bgd)localObject2).jOx)
                                  {
                                    ad.i("AsyncBizCollector", "HABBYGE-MALI, AsyncBizCollector, _collectBizId: %s", new Object[] { paramAnonymousa });
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.ccM();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.fx((String)localObject1, paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label4191:
                                    paramAnonymousa = (bgc)((com.tencent.mm.vending.j.b)localObject2).get(0);
                                    i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
                                    j = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.fo(paramAnonymousa.Dod.size() + 1, paramAnonymousa.DDQ.size() + 1);
                                    localObject2 = new bgd();
                                    ((bgd)localObject2).jOx = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.u(paramAnonymousa.startTime, j);
                                    paramAnonymousa.Dod.add(localObject2);
                                    paramAnonymousa.DDQ.add(localObject2);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramAnonymousa, i);
                                    ad.i("AsyncBizCollector", "HABBYGE-MALI, getBizId, addBizIdCurPageFlowItem: %s", new Object[] { ((bgd)localObject2).jOx });
                                  }
                                  localObject1 = (bgd)paramAnonymousa.pEf;
                                  if (localObject1 != null)
                                  {
                                    paramAnonymousa = ((bgd)localObject1).dvm;
                                    localObject2 = ((bgd)localObject1).value;
                                    localObject3 = ((bgd)localObject1).jOx;
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.a.U(paramAnonymousa, (String)localObject2, (String)localObject3);
                                    if (localObject1 != null)
                                    {
                                      ad.i("AsyncBizCollector", "HABBYGE-MALI, _collectBizData: %s, %s, %s", new Object[] { paramAnonymousa, localObject2, localObject3 });
                                      if (localObject1 != null)
                                      {
                                        paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.a.cdb();
                                        if ((paramAnonymousa == null) || (paramAnonymousa.isEmpty()))
                                        {
                                          paramAnonymousa = new JSONArray();
                                          paramAnonymousa.put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.WO(System.currentTimeMillis() + "@" + paramAnonymousa.toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        if ("-1".equals(paramAnonymousa))
                                        {
                                          ad.e("AsyncBizDao", "habbyge-mali, AsyncBizDao putBiz NOT LOGIN");
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        if (paramAnonymousa.split("@").length <= 1)
                                        {
                                          localObject2 = new JSONArray();
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.WO(paramAnonymousa + "@" + ((JSONArray)localObject2).toString());
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
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.WO(System.currentTimeMillis() + "@" + paramAnonymousa.toString());
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
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.WO((String)paramAnonymousa.get(0) + "@" + ((JSONArray)localObject2).toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        try
                                        {
                                          localObject2 = new JSONArray((String)paramAnonymousa.get(1));
                                          ((JSONArray)localObject2).put(localObject1);
                                          com.tencent.mm.plugin.expt.hellhound.a.f.c.a.WO((String)paramAnonymousa.get(0) + "@" + ((JSONArray)localObject2).toString());
                                          AppMethodBeat.o(121937);
                                          return;
                                        }
                                        catch (JSONException paramAnonymousa)
                                        {
                                          ad.printErrStackTrace("AsyncBizDao", paramAnonymousa, "AsyncBizDao.putBiz crash: %s", new Object[] { paramAnonymousa.getMessage() });
                                        }
                                      }
                                    }
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.pEf;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().ccJ();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.ccM();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.fz(paramAnonymousa, (String)localObject1);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.pEf;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.a.d.ccN();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.ccM();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.a.c.fy(paramAnonymousa, (String)localObject1);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                  l = ((Long)paramAnonymousa.pEf).longValue();
                                  ad.i("VoipFloatSession", "HABBYGE-MALI, VoipMonitorCallback: _videoActivity2VoipFloat");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.d.ps(l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                  l = ((Long)paramAnonymousa.pEf).longValue();
                                  ad.i("VoipFloatSession", "HABBYGE-MALI, VoipMonitorCallback: _voipFloat2VideoActivity");
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
                                  if ((paramAnonymousa == null) || (TextUtils.isEmpty(paramAnonymousa.sessionId)))
                                  {
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.core.b.cbx();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ai(paramAnonymousa, l);
                                  }
                                  for (;;)
                                  {
                                    ad.i("VoipFloatSession", "HABBYGE-MALI, _beignVoipSession");
                                    bool = false;
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
                                    if (paramAnonymousa != null) {
                                      break label5178;
                                    }
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().a(null, "LauncherUI", "VideoActivity", l);
                                    if (paramAnonymousa != null) {
                                      break;
                                    }
                                    ad.e("VoipFloatSession", "HABBYGE-MALI, _beignFloatSession, 不是合法session ~~~");
                                    AppMethodBeat.o(121937);
                                    return;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().a(paramAnonymousa, l);
                                  }
                                  bool = true;
                                  for (;;)
                                  {
                                    ad.i("VoipFloatSession", "HABBYGE-MALI, _beignFloatSession, isNewSession: %s, %b", new Object[] { paramAnonymousa.sessionId, Boolean.valueOf(bool) });
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(paramAnonymousa, "VideoActivity", l);
                                    if (!bool) {
                                      break;
                                    }
                                    paramAnonymousa.gXt = 0;
                                    localObject2 = l.ccJ();
                                    localObject1 = localObject2;
                                    if (localObject2 == null) {
                                      localObject1 = "";
                                    }
                                    paramAnonymousa.DUm = ((String)localObject1);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(paramAnonymousa);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label5178:
                                    ad.i("VoipFloatSession", "HABBYGE-MALI, _beignFloatSession, curSession: %s", new Object[] { paramAnonymousa.sessionId });
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(paramAnonymousa);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                  l = ((Long)paramAnonymousa.pEf).longValue();
                                  ad.i("VoipFloatSession", "HABBYGE-MALI, VoipMonitorCallback: _closeVideoActivity");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.d.ps(l);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                  l = ((Long)paramAnonymousa.pEf).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cdH();
                                  if (paramAnonymousa != null)
                                  {
                                    paramAnonymousa.Dna = -1;
                                    paramAnonymousa.Dnb = -1;
                                    paramAnonymousa.Dnd = 7;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.a(paramAnonymousa);
                                  }
                                  ad.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBall, stat, show: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cdF()) });
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
                                  if ((paramAnonymousa == null) || (TextUtils.isEmpty(paramAnonymousa.sessionId)))
                                  {
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.core.b.cbx();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ai(paramAnonymousa, l);
                                  }
                                  for (;;)
                                  {
                                    ad.d("FloatBallSessionHandler", "HABBYGE-MALI, _beignFloatSession");
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
                                    bool = false;
                                    if (paramAnonymousa != null) {
                                      break label5504;
                                    }
                                    paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().a(null, "LauncherUI", "FloatingBall", l);
                                    if (paramAnonymousa != null) {
                                      break;
                                    }
                                    ad.e("FloatBallSessionHandler", "HABBYGE-MALI, _beignFloatSession, 不是合法session ~~~");
                                    AppMethodBeat.o(121937);
                                    return;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().a(paramAnonymousa, l);
                                  }
                                  bool = true;
                                  for (;;)
                                  {
                                    ad.d("FloatBallSessionHandler", "HABBYGE-MALI, _beignFloatSession, isNewSession: %s, %b", new Object[] { paramAnonymousa.sessionId, Boolean.valueOf(bool) });
                                    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(paramAnonymousa, "FloatBall", l);
                                    if (!bool) {
                                      break;
                                    }
                                    paramAnonymousa.gXt = 0;
                                    localObject2 = l.ccJ();
                                    localObject1 = localObject2;
                                    if (localObject2 == null) {
                                      localObject1 = "";
                                    }
                                    paramAnonymousa.DUm = ((String)localObject1);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(paramAnonymousa);
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousa);
                                    AppMethodBeat.o(121937);
                                    return;
                                    label5504:
                                    ad.d("FloatBallSessionHandler", "HABBYGE-MALI, _beignFloatSession, curSession: %s", new Object[] { paramAnonymousa.sessionId });
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(paramAnonymousa);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                  l = ((Long)paramAnonymousa.pEf).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cdG();
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
                                    ad.d("FloatBallSessionHandler", "HABBYGE-MALI, onFloatMenuHide, FloatSession, End: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
                                    if (bool)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.b(false, null, l);
                                    }
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cdH();
                                    paramAnonymousa = (com.tencent.mm.plugin.expt.hellhound.core.a.a.a)localObject1;
                                    if (localObject1 == null) {
                                      paramAnonymousa = new alz();
                                    }
                                    paramAnonymousa.Dnd = 8;
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.a(paramAnonymousa);
                                    ad.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBall, stat, hide: %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cdF()) });
                                    AppMethodBeat.o(121937);
                                    return;
                                  }
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                  l = ((Long)paramAnonymousa.pEf).longValue();
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cdG();
                                  if (paramAnonymousa != null)
                                  {
                                    if (((Integer)paramAnonymousa.second).intValue() == 6)
                                    {
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                      com.tencent.mm.plugin.expt.hellhound.a.f.b.b(false, null, l);
                                      AppMethodBeat.o(121937);
                                      return;
                                    }
                                    com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.aha(4);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                  ad.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBall: onFloatMenuBackgroundClicked");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.fp(1, 1);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                  ad.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBall: onFloatMenuBackPressed");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.fp(0, 0);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                  ad.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBall: onFloatMenuItemClicked");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.fp(2, 2);
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.kg(true);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                  ad.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBall: onFloatMenuItemRemoved");
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.fp(6, 6);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.b(false, null, 0L);
                                  AppMethodBeat.o(121937);
                                  return;
                                  i = ((Integer)paramAnonymousa.pEf).intValue();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.aha(i);
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.g.c.cdO();
                                  localObject1 = paramAnonymousa.pHX;
                                  localObject2 = paramAnonymousa.pGj;
                                  localObject3 = paramAnonymousa.pHZ;
                                  ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).pGj = ((com.tencent.mm.plugin.expt.hellhound.a.a.d)localObject2);
                                  com.tencent.mm.hellhoundlib.a.adm();
                                  com.tencent.mm.hellhoundlib.a.e(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).pFf, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).pHU);
                                  ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).pHR = ((com.tencent.mm.plugin.expt.hellhound.a.g.a)localObject3);
                                  com.tencent.mm.hellhoundlib.a.adm();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).pGi, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).pHV);
                                  com.tencent.mm.hellhoundlib.a.adm();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).pHS, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).pHV);
                                  com.tencent.mm.hellhoundlib.a.adm();
                                  com.tencent.mm.hellhoundlib.a.a(((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).pHT, ((com.tencent.mm.plugin.expt.hellhound.a.g.b)localObject1).pHU);
                                  if (paramAnonymousa.mActivityRef != null) {
                                    paramAnonymousa.pGv.a(0, (Activity)paramAnonymousa.mActivityRef.get());
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = com.tencent.mm.plugin.expt.hellhound.a.g.c.cdO();
                                  paramAnonymousa.pGv.a(1, null);
                                  paramAnonymousa = paramAnonymousa.pHX;
                                  com.tencent.mm.hellhoundlib.a.adm();
                                  com.tencent.mm.hellhoundlib.a.f(paramAnonymousa.pFf, paramAnonymousa.pHU);
                                  paramAnonymousa.pGj = null;
                                  com.tencent.mm.hellhoundlib.a.adm();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.pGi, paramAnonymousa.pHV);
                                  com.tencent.mm.hellhoundlib.a.adm();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.pHS, paramAnonymousa.pHV);
                                  paramAnonymousa.pHR = null;
                                  com.tencent.mm.hellhoundlib.a.adm();
                                  com.tencent.mm.hellhoundlib.a.b(paramAnonymousa.pHT, paramAnonymousa.pHU);
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.g.c.cdO().pGv.a(2, null);
                                  com.tencent.mm.plugin.expt.hellhound.a.g.c.pHY = null;
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.g.c.cdO().pGv.a(3, null);
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.pEf;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.KFp;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.bw(0, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.pEf;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.KFp;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.bw(1, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.pEf;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.KFp;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.bw(2, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  paramAnonymousa = (String)paramAnonymousa.pEf;
                                  if (paramAnonymousa != null)
                                  {
                                    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.KFp;
                                    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.bw(3, paramAnonymousa);
                                  }
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.pr(((Long)paramAnonymousa.pEf).longValue());
                                  AppMethodBeat.o(121937);
                                  return;
                                  com.tencent.mm.plugin.expt.hellhound.a.f.g.a.cdB();
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
    com.tencent.mm.plugin.expt.hellhound.core.a.a.c localc = com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD();
    com.tencent.mm.plugin.expt.hellhound.core.a.a.d locald = this.pEH;
    localc.pEj.pEl = locald;
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
    boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.Vt(paramActivity.getClass().getCanonicalName());
    paramActivity = com.tencent.mm.vending.j.a.i(localc.get(0), localc.get(1), Boolean.valueOf(bool));
    AppMethodBeat.o(121940);
    return paramActivity;
  }
  
  static com.tencent.mm.vending.j.c<String, Boolean> Y(Activity paramActivity)
  {
    AppMethodBeat.i(121942);
    String str = null;
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.g.aa(paramActivity);
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
  
  static dcm a(dcm paramdcm)
  {
    AppMethodBeat.i(184315);
    dcm localdcm;
    if (paramdcm != null)
    {
      localdcm = paramdcm;
      if (!TextUtils.isEmpty(paramdcm.activityName)) {
        break label85;
      }
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
      com.tencent.mm.vending.j.c localc = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbH();
      if (localc == null)
      {
        AppMethodBeat.o(184315);
        return null;
      }
      localdcm = paramdcm;
      if (paramdcm == null)
      {
        localdcm = new dcm();
        localdcm.timestamp = System.currentTimeMillis();
      }
      localdcm.activityName = ((String)localc.get(0));
      localdcm.DnR = ((String)localc.get(1));
      label85:
      AppMethodBeat.o(184315);
      return localdcm;
    }
    catch (Exception paramdcm)
    {
      ad.printErrStackTrace("HABBYGE-MALI.AsyncActivityMonitor", paramdcm, "getActivityOnFinish", new Object[0]);
      AppMethodBeat.o(184315);
    }
    return null;
  }
  
  static void a(int paramInt, dcm paramdcm)
  {
    AppMethodBeat.i(184313);
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K(paramdcm.activityName, null, 104);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Br(101);
    if (localObject != null) {}
    for (localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);; localObject = null)
    {
      if (!paramdcm.activityName.equals(localObject))
      {
        ad.w("HABBYGE-MALI.AsyncActivityMonitor", "AsyncActivityMonitor, _onCreateEvent: %s, %s", new Object[] { localObject, paramdcm.activityName });
        b(paramInt, null, null, paramdcm.activityName, paramdcm.DnR, paramdcm.timestamp);
      }
      a(paramdcm.activityName, paramdcm.DnR, com.tencent.mm.plugin.expt.hellhound.core.stack.a.pEq);
      AppMethodBeat.o(184313);
      return;
    }
  }
  
  static void a(String paramString1, String paramString2, com.tencent.mm.plugin.expt.hellhound.core.stack.a parama)
  {
    AppMethodBeat.i(121945);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(paramString1, paramString2, parama);
    AppMethodBeat.o(121945);
  }
  
  static void aQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(121943);
    a.Bp(1);
    if ((!paramBoolean) && (com.tencent.mm.plugin.expt.hellhound.core.b.Vt(paramString)))
    {
      ad.i("HABBYGE-MALI.AsyncActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
      AppMethodBeat.o(121943);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    bh localbh = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
    String str = null;
    if (localbh != null) {
      str = localbh.CvH.activityName;
    }
    a.VU(paramString);
    a.VS(str);
    ad.i("HABBYGE-MALI.AsyncActivityMonitor", "setActivityActionOnFinish: from: %s, to: %s", new Object[] { paramString, str });
    AppMethodBeat.o(121943);
  }
  
  static void b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(184314);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG().a(paramInt, paramString1, paramString2, paramString3, paramString4, paramLong);
    AppMethodBeat.o(184314);
  }
  
  static buq c(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(184312);
    buq localbuq = new buq();
    localbuq.DnE = new dcm();
    localbuq.DnE.activityName = paramActivity.getClass().getCanonicalName();
    localbuq.DnE.DnR = String.valueOf(paramActivity.hashCode());
    localbuq.DnE.timestamp = paramLong;
    paramActivity = X(paramActivity);
    localbuq.DnF = ((String)paramActivity.get(0));
    localbuq.DnH = ((Boolean)paramActivity.get(1)).booleanValue();
    localbuq.DDK = ((Boolean)paramActivity.get(2)).booleanValue();
    AppMethodBeat.o(184312);
    return localbuq;
  }
  
  static bup g(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121941);
    bup localbup = new bup();
    localbup.flags = paramIntent.getFlags();
    localbup.DnE = new dcm();
    if (paramActivity == null)
    {
      AppMethodBeat.o(121941);
      return localbup;
    }
    localbup.DnE.activityName = paramActivity.getClass().getCanonicalName();
    localbup.DnE.DnR = String.valueOf(paramActivity.hashCode());
    localbup.DnE.timestamp = System.currentTimeMillis();
    AppMethodBeat.o(121941);
    return localbup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.c
 * JD-Core Version:    0.7.0.1
 */