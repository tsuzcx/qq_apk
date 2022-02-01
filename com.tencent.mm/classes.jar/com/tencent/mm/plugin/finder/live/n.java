package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.live.model.ay;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.plugin.findersdk.a.bm;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/MiniProgramReportHelper;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "report21188", "", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "luanchFromApp", "", "report21235", "appId", "report21237", "prewarmStartTime", "", "prewarmEndTime", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n BxF;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(350630);
    BxF = new n();
    TAG = "MiniProgramReportHelper";
    AppMethodBeat.o(350630);
  }
  
  public static void a(a parama, g paramg, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(350626);
    s.u(parama, "liveData");
    s.u(paramg, "bundle");
    bm localbm = (bm)h.ax(bm.class);
    if (localbm != null)
    {
      Context localContext = MMApplicationContext.getContext();
      s.s(localContext, "getContext()");
      Object localObject = l.Bxv;
      boolean bool1 = l.ehh();
      localObject = l.Bxv;
      boolean bool2 = l.ehi();
      long l1 = ((f)parama.business(f.class)).liveInfo.liveId;
      localObject = z.bAW();
      s.s(localObject, "getMyFinderUsername()");
      long l2 = ((e)parama.business(e.class)).sessionId;
      paramg = paramg.appId;
      parama = paramg;
      if (paramg == null) {
        parama = "";
      }
      localbm.a(localContext, bool1, bool2, String.valueOf(l1), (String)localObject, "", String.valueOf(l2), paramLong1, paramLong2, parama, "");
    }
    AppMethodBeat.o(350626);
  }
  
  public static void a(a parama, g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(350619);
    s.u(parama, "liveData");
    s.u(paramg, "bundle");
    if (paramBoolean)
    {
      Object localObject1;
      label72:
      Object localObject2;
      label126:
      bm localbm;
      Context localContext;
      int i;
      if ((Util.isNullOrNil(((q)parama.business(q.class)).Eii)) && (!Util.isNullOrNil(paramg.appId)))
      {
        paramBoolean = true;
        localObject1 = paramg.qAG;
        if (!(localObject1 instanceof ay)) {
          break label306;
        }
        localObject1 = (ay)localObject1;
        localObject2 = l.Bxv;
        if (!l.ehj()) {
          break label312;
        }
        localObject2 = ((q)parama.business(q.class)).Eia;
        if (localObject2 == null) {
          break label312;
        }
        localObject2 = ((bih)localObject2).ZRr;
        if (localObject2 == null) {
          break label312;
        }
        localObject2 = ((boh)localObject2).ZWE;
        if (localObject2 == null) {
          break label312;
        }
        localbm = (bm)h.ax(bm.class);
        if (localbm == null) {
          break label368;
        }
        localContext = MMApplicationContext.getContext();
        s.s(localContext, "getContext()");
        if (localObject1 != null) {
          break label319;
        }
        i = 0;
        label160:
        if (localObject1 != null) {
          break label328;
        }
        localObject1 = (Serializable)"";
      }
      for (;;)
      {
        String str2 = String.valueOf(localObject1);
        String str1 = paramg.appId;
        localObject1 = str1;
        if (str1 == null) {
          localObject1 = "";
        }
        int j = paramg.scene;
        paramg = l.Bxv;
        boolean bool1 = l.ehh();
        paramg = l.Bxv;
        boolean bool2 = l.ehi();
        long l = ((f)parama.business(f.class)).liveInfo.liveId;
        paramg = z.bAW();
        s.s(paramg, "getMyFinderUsername()");
        localbm.a(localContext, paramBoolean, i, str2, (String)localObject1, j, (String)localObject2, bool1, bool2, String.valueOf(l), paramg, "", String.valueOf(((e)parama.business(e.class)).sessionId));
        AppMethodBeat.o(350619);
        return;
        paramBoolean = false;
        break;
        label306:
        localObject1 = null;
        break label72;
        label312:
        localObject2 = "";
        break label126;
        label319:
        i = ((ay)localObject1).CIH;
        break label160;
        label328:
        localObject1 = ((ay)localObject1).CII;
        if (localObject1 == null) {
          localObject1 = (Serializable)"";
        } else {
          localObject1 = (Serializable)localObject1;
        }
      }
    }
    else
    {
      Log.i(TAG, "luanch from mini program!");
    }
    label368:
    AppMethodBeat.o(350619);
  }
  
  public static void a(a parama, String paramString)
  {
    AppMethodBeat.i(350609);
    s.u(parama, "liveData");
    s.u(paramString, "appId");
    bm localbm = (bm)h.ax(bm.class);
    Context localContext;
    Object localObject1;
    if (localbm != null)
    {
      localContext = MMApplicationContext.getContext();
      s.s(localContext, "getContext()");
      localObject1 = ((q)parama.business(q.class)).Eia;
      if (localObject1 != null) {
        break label158;
      }
      localObject1 = "";
    }
    for (;;)
    {
      Object localObject2 = l.Bxv;
      boolean bool1 = l.ehh();
      localObject2 = l.Bxv;
      boolean bool2 = l.ehi();
      long l = ((f)parama.business(f.class)).liveInfo.liveId;
      localObject2 = z.bAW();
      s.s(localObject2, "getMyFinderUsername()");
      localbm.a(localContext, paramString, (String)localObject1, bool1, bool2, String.valueOf(l), (String)localObject2, "", String.valueOf(((e)parama.business(e.class)).sessionId));
      AppMethodBeat.o(350609);
      return;
      label158:
      localObject1 = ((bih)localObject1).ZRr;
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject2 = ((boh)localObject1).ZWE;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.n
 * JD-Core Version:    0.7.0.1
 */