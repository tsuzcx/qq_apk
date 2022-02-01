package com.tencent.mm.plugin.finder.model;

import android.content.Context;
import com.tencent.d.a.a.a.b;
import com.tencent.d.a.a.a.b.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.cgi.p;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pluginsdk.ui.applet.w;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderFollowLogic;", "", "()V", "follow", "", "context", "Landroid/content/Context;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "opType", "", "isFromTimeline", "", "isFromShareUI", "enterType", "finderUser", "", "feedId", "", "liveReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;", "followAsync", "isPrivate", "participantFinderUsername", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
{
  public static final ak ECS;
  
  static
  {
    AppMethodBeat.i(166392);
    ECS = new ak();
    AppMethodBeat.o(166392);
  }
  
  public static void a(Context paramContext, bui parambui, BaseFinderFeed paramBaseFinderFeed, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    AppMethodBeat.i(332140);
    s.u(paramContext, "context");
    s.u(parambui, "contextObj");
    s.u(paramBaseFinderFeed, "feed");
    pu localpu = paramBaseFinderFeed.feedObject.getBizInfo();
    if (localpu == null)
    {
      paramContext = null;
      if (paramContext == null)
      {
        paramContext = paramBaseFinderFeed.contact;
        if (paramContext != null) {
          break label234;
        }
        paramContext = "";
      }
    }
    for (;;)
    {
      a(parambui, paramContext, paramInt1, paramBaseFinderFeed.bZA(), paramBoolean1, paramBoolean2, paramInt2, 128);
      AppMethodBeat.o(332140);
      return;
      Object localObject1 = z.FrZ;
      long l = parambui.ADF;
      localObject1 = paramBaseFinderFeed.contact;
      label106:
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = "";
        localObject2 = bh.ABm;
        if (paramInt1 != bh.dVs()) {
          break label228;
        }
      }
      label228:
      for (int i = 1;; i = 2)
      {
        z.a(parambui, l, (String)localObject1, i);
        localObject1 = new com.tencent.mm.pluginsdk.a();
        ((com.tencent.mm.pluginsdk.a)localObject1).XNl = false;
        ((com.tencent.mm.pluginsdk.a)localObject1).hzx = paramBaseFinderFeed.feedObject.getFeedObject().sessionBuffer;
        ((com.tencent.mm.pluginsdk.i)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.i.class)).a(paramContext, localpu.ADE, 212, new ak..ExternalSyntheticLambda0(paramBaseFinderFeed), (com.tencent.mm.pluginsdk.a)localObject1).show();
        paramContext = ah.aiuX;
        break;
        localObject2 = ((m)localObject1).getUsername();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label106;
        }
        localObject1 = "";
        break label106;
      }
      label234:
      localObject1 = paramContext.getUsername();
      paramContext = (Context)localObject1;
      if (localObject1 == null) {
        paramContext = "";
      }
    }
  }
  
  public static void a(bui parambui, String paramString1, int paramInt, long paramLong, boolean paramBoolean, String paramString2, bma parambma)
  {
    AppMethodBeat.i(332176);
    s.u(parambui, "contextObj");
    s.u(paramString1, "finderUser");
    s.u(paramString2, "participantFinderUsername");
    Log.i("Finder.FinderFollowLogic", "follow event commentScene:" + parambui.hLK + " user:" + paramString1 + " opType: " + paramInt + " participantFinderUsername:" + paramString2 + " form " + Util.getStack());
    Object localObject = f.Ozc;
    bh localbh = bh.ABm;
    long l;
    if (paramInt == bh.dVs())
    {
      l = 5L;
      ((f)localObject).idkeyStat(1278L, l, 1L, false);
      localObject = z.FrZ;
      l = parambui.ADF;
      localObject = bh.ABm;
      if (paramInt != bh.dVs()) {
        break label225;
      }
    }
    label225:
    for (int i = 1;; i = 2)
    {
      z.a(parambui, l, paramString1, i);
      localObject = com.tencent.mm.plugin.finder.upload.action.i.Gde;
      com.tencent.mm.plugin.finder.upload.action.i.a(com.tencent.mm.plugin.finder.upload.action.i.fej(), paramString1, paramInt, paramLong, parambui, paramBoolean, paramString2, parambma, 32);
      parambui = bh.ABm;
      if (paramInt == bh.dVs()) {
        ((b)com.tencent.mm.kernel.h.az(b.class)).getFinderLiveActionRecordStorage().a(paramString1, a.a.ahmE);
      }
      AppMethodBeat.o(332176);
      return;
      l = 4L;
      break;
    }
  }
  
  private static void a(bui parambui, String paramString, int paramInt1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    AppMethodBeat.i(332158);
    s.u(parambui, "contextObj");
    s.u(paramString, "finderUser");
    Log.i("Finder.FinderFollowLogic", "follow event commentScene:" + parambui.hLK + " user:" + paramString + " opType: " + paramInt1 + " form " + Util.getStack());
    Object localObject = f.Ozc;
    bh localbh = bh.ABm;
    long l;
    if (paramInt1 == bh.dVs())
    {
      l = 5L;
      ((f)localObject).idkeyStat(1278L, l, 1L, false);
      localObject = z.FrZ;
      l = parambui.ADF;
      localObject = bh.ABm;
      if (paramInt1 != bh.dVs()) {
        break label184;
      }
    }
    label184:
    for (int i = 1;; i = 2)
    {
      z.a(parambui, l, paramString, i);
      new p(new com.tencent.mm.plugin.finder.upload.action.h(paramString, paramInt1, paramLong, parambui, paramInt2, null), paramBoolean1, paramBoolean2).bFJ();
      AppMethodBeat.o(332158);
      return;
      l = 4L;
      break;
    }
  }
  
  private static final void b(BaseFinderFeed paramBaseFinderFeed, int paramInt)
  {
    AppMethodBeat.i(332189);
    s.u(paramBaseFinderFeed, "$feed");
    Log.i("Finder.FinderFollowLogic", s.X("follow biz result = ", Integer.valueOf(paramInt)));
    if localif = new if();
    localif.hJB.id = paramBaseFinderFeed.bZA();
    paramBaseFinderFeed = localif.hJB;
    if (paramInt == -1) {}
    for (paramInt = 1;; paramInt = 22)
    {
      paramBaseFinderFeed.type = paramInt;
      localif.publish();
      AppMethodBeat.o(332189);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ak
 * JD-Core Version:    0.7.0.1
 */