package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bdl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/MiniProgramReportHelper;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "report21188", "", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "luanchFromApp", "", "report21235", "appId", "report21237", "prewarmStartTime", "", "prewarmEndTime", "plugin-finder_release"})
public final class u
{
  private static final String TAG = "MiniProgramReportHelper";
  public static final u xWQ;
  
  static
  {
    AppMethodBeat.i(282548);
    xWQ = new u();
    TAG = "MiniProgramReportHelper";
    AppMethodBeat.o(282548);
  }
  
  public static void a(a parama, g paramg, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(282547);
    p.k(parama, "liveData");
    p.k(paramg, "bundle");
    Object localObject1 = n.zWF;
    localObject1 = MMApplicationContext.getContext();
    p.j(localObject1, "MMApplicationContext.getContext()");
    Object localObject2 = s.xWG;
    boolean bool1 = s.dwP();
    localObject2 = s.xWG;
    boolean bool2 = s.dwQ();
    long l1 = ((c)parama.business(c.class)).liveInfo.liveId;
    localObject2 = z.bdh();
    p.j(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
    long l2 = ((b)parama.business(b.class)).sessionId;
    paramg = paramg.appId;
    parama = paramg;
    if (paramg == null) {
      parama = "";
    }
    n.a((Context)localObject1, bool1, bool2, String.valueOf(l1), (String)localObject2, "", String.valueOf(l2), paramLong1, paramLong2, parama, "");
    AppMethodBeat.o(282547);
  }
  
  public static void a(a parama, g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(282546);
    p.k(parama, "liveData");
    p.k(paramg, "bundle");
    if (paramBoolean)
    {
      Object localObject1;
      Object localObject3;
      label141:
      Context localContext;
      int i;
      if ((Util.isNullOrNil(((j)parama.business(j.class)).ziN)) && (!Util.isNullOrNil(paramg.appId)))
      {
        paramBoolean = true;
        localObject2 = paramg.nBr;
        localObject1 = localObject2;
        if (!(localObject2 instanceof at)) {
          localObject1 = null;
        }
        localObject3 = (at)localObject1;
        localObject1 = s.xWG;
        if (s.dwR())
        {
          localObject1 = ((j)parama.business(j.class)).ziI;
          if (localObject1 != null)
          {
            localObject1 = ((azy)localObject1).SLy;
            if (localObject1 != null)
            {
              localObject2 = ((bdl)localObject1).SOx;
              localObject1 = localObject2;
              if (localObject2 != null) {
                break label141;
              }
            }
          }
        }
        localObject1 = "";
        localObject2 = n.zWF;
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        if (localObject3 == null) {
          break label323;
        }
        i = ((at)localObject3).yiD;
        label169:
        if (localObject3 == null) {
          break label328;
        }
        localObject2 = ((at)localObject3).yiE;
        if (localObject2 == null) {
          break label328;
        }
      }
      label323:
      label328:
      for (Object localObject2 = (Serializable)localObject2;; localObject2 = (Serializable)"")
      {
        String str = String.valueOf(localObject2);
        localObject3 = paramg.appId;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        int j = paramg.scene;
        paramg = s.xWG;
        boolean bool1 = s.dwP();
        paramg = s.xWG;
        boolean bool2 = s.dwQ();
        long l = ((c)parama.business(c.class)).liveInfo.liveId;
        paramg = z.bdh();
        p.j(paramg, "ConfigStorageLogic.getMyFinderUsername()");
        n.a(localContext, paramBoolean, i, str, (String)localObject2, j, (String)localObject1, bool1, bool2, String.valueOf(l), paramg, "", String.valueOf(((b)parama.business(b.class)).sessionId));
        AppMethodBeat.o(282546);
        return;
        paramBoolean = false;
        break;
        i = 0;
        break label169;
      }
    }
    Log.i(TAG, "luanch from mini program!");
    AppMethodBeat.o(282546);
  }
  
  public static void a(a parama, String paramString)
  {
    AppMethodBeat.i(282545);
    p.k(parama, "liveData");
    p.k(paramString, "appId");
    Object localObject1 = n.zWF;
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    localObject1 = ((j)parama.business(j.class)).ziI;
    if (localObject1 != null)
    {
      localObject1 = ((azy)localObject1).SLy;
      if (localObject1 != null)
      {
        localObject2 = ((bdl)localObject1).SOx;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label85;
        }
      }
    }
    localObject1 = "";
    label85:
    Object localObject2 = s.xWG;
    boolean bool1 = s.dwP();
    localObject2 = s.xWG;
    boolean bool2 = s.dwQ();
    long l = ((c)parama.business(c.class)).liveInfo.liveId;
    localObject2 = z.bdh();
    p.j(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
    n.a(localContext, paramString, (String)localObject1, bool1, bool2, String.valueOf(l), (String)localObject2, "", String.valueOf(((b)parama.business(b.class)).sessionId));
    AppMethodBeat.o(282545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.u
 * JD-Core Version:    0.7.0.1
 */