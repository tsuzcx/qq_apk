package com.tencent.mm.plugin.finder.megavideo.floatball;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI.a;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/PageFloatBallHelper;", "context", "Landroid/content/Context;", "pageAdapter", "Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;)V", "getContext", "()Landroid/content/Context;", "initReportInfo", "", "isSupportSwipeToFloatBall", "", "onCreate", "floatBallType", "", "floatBallKey", "", "onMenuFloatBallSelected", "enterFloatBall", "generateType", "Companion", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private static final e lqt;
  public static final a uKD;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(248362);
    uKD = new a((byte)0);
    lqt = (e)new b();
    AppMethodBeat.o(248362);
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(248360);
    super.G(paramInt, paramString);
    ciw().hDa = 17;
    AppMethodBeat.o(248360);
  }
  
  public final boolean aGg()
  {
    return true;
  }
  
  public final void y(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(248361);
    super.y(paramBoolean, paramInt);
    Object localObject1;
    Object localObject3;
    if (paramBoolean)
    {
      localObject1 = this.oWE.getByteArrayExtra("KEY_FLOAT_BALL_INFO");
      localObject3 = new cnu();
    }
    try
    {
      ((cnu)localObject3).parseFrom((byte[])localObject1);
      localObject1 = FinderReporterUIC.wzC;
      localObject1 = FinderReporterUIC.a.fH(this.context);
      if (localObject1 != null)
      {
        localObject1 = ((FinderReporterUIC)localObject1).dIx();
        Object localObject4 = ((cnu)localObject3).Muf;
        p.g(localObject4, "floatBallInfo.cacheNewVideoList");
        localObject3 = (FinderObject)j.L((List)localObject4, ((cnu)localObject3).Muc);
        if (localObject3 == null) {
          break label408;
        }
        localObject3 = ((FinderObject)localObject3).attachmentList;
        if (localObject3 == null) {
          break label408;
        }
        localObject3 = ((aoq)localObject3).LAM;
        if (localObject3 == null) {
          break label408;
        }
        localObject3 = (aop)j.kt((List)localObject3);
        if (localObject3 == null) {
          break label408;
        }
        localObject3 = ((aop)localObject3).LAL;
        if (localObject3 == null) {
          break label408;
        }
        localObject3 = ((bei)localObject3).LIA;
        int i = cip() + 1;
        long l2 = cl.aWA();
        String str2 = "uin_".concat(String.valueOf(l2));
        this.oWE.cy("KEY_FLOAT_BALL_TASK_ORDER", i);
        this.oWE.eS("KEY_FLOAT_BALL_MINI_SESSION_ID", str2);
        this.oWE.X("KEY_FLOAT_BALL_VERSION", 1L);
        localObject4 = af.viA;
        if (paramInt != 2) {
          break label414;
        }
        paramInt = 2;
        if (localObject3 == null) {
          break label419;
        }
        l1 = ((cng)localObject3).id;
        String str3 = d.zs(l1);
        Object localObject5;
        if (localObject1 != null)
        {
          localObject5 = ((bbn)localObject1).sessionId;
          localObject4 = localObject5;
          if (localObject5 != null) {}
        }
        else
        {
          localObject4 = "";
        }
        String str1;
        if (localObject1 != null)
        {
          str1 = ((bbn)localObject1).sGQ;
          localObject5 = str1;
          if (str1 != null) {}
        }
        else
        {
          localObject5 = "";
        }
        if (localObject1 != null)
        {
          str1 = ((bbn)localObject1).sGE;
          localObject1 = str1;
          if (str1 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        if (localObject3 == null) {
          break label425;
        }
        localObject3 = ((cng)localObject3).MtI;
        if (localObject3 == null) {
          break label425;
        }
        l1 = ((cns)localObject3).hFK;
        af.a(l2, paramInt, i, str3, str2, (String)localObject4, (String)localObject5, (String)localObject1, d.zs(l1));
        AppMethodBeat.o(248361);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("MegaVideoFloatBallHelper", "handleBallInfoClicked", new Object[] { localThrowable });
        continue;
        Object localObject2 = null;
        continue;
        label408:
        localObject3 = null;
        continue;
        label414:
        paramInt = 1;
        continue;
        label419:
        long l1 = 0L;
        continue;
        label425:
        l1 = 0L;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper$Companion;", "", "()V", "INNER_VERSION", "", "KEY_FLOAT_BALL_INFO", "", "KEY_FLOAT_BALL_MINI_SESSION_ID", "KEY_FLOAT_BALL_TASK_ORDER", "KEY_FLOAT_BALL_VERSION", "TAG", "floatBallInfoEventListener", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListener;", "handleBallInfoClicked", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "startListeningFloatBallInfoClicked", "stopListeningFloatBallInfoClicked", "plugin-finder_release"})
  public static final class a
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    public static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      public a(b paramb)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper$Companion$floatBallInfoEventListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListenerAdapter;", "onFloatBallInfoClicked", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "onFloatBallInfoExposed", "onFloatBallInfoRemoved", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.plugin.ball.c.f
  {
    public final void b(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(248357);
      if (paramBallInfo != null)
      {
        Object localObject1 = a.uKD;
        p.h(paramBallInfo, "ballInfo");
        Object localObject2 = paramBallInfo.getByteArrayExtra("KEY_FLOAT_BALL_INFO");
        localObject1 = new cnu();
        try
        {
          ((cnu)localObject1).parseFrom((byte[])localObject2);
          localObject2 = new Intent();
          localObject3 = ((cnu)localObject1).Muf;
          p.g(localObject3, "floatBallInfo.cacheNewVideoList");
          localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            FinderObject localFinderObject = (FinderObject)((Iterator)localObject4).next();
            p.g(localFinderObject, "it");
            ((Collection)localObject3).add(new bm(localFinderObject));
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.e("MegaVideoFloatBallHelper", "handleBallInfoClicked", new Object[] { localThrowable });
          }
          Object localObject3 = (List)localObject3;
          Object localObject4 = y.vXH;
          y.a(((cnu)localObject1).Muc, (List)localObject3, ((cnu)localObject1).lastBuffer, localThrowable);
          localThrowable.putExtra("KEY_ROUTER_UI", ((cnu)localObject1).Mue);
          localThrowable.putExtra("KEY_FLOAT_BALL_INFO", ((cnu)localObject1).toByteArray());
          localThrowable.putExtra("KEY_FLOAT_BALL_TASK_ORDER", paramBallInfo.getIntExtra("KEY_FLOAT_BALL_TASK_ORDER", 0));
          localThrowable.putExtra("KEY_FLOAT_BALL_MINI_SESSION_ID", paramBallInfo.eT("KEY_FLOAT_BALL_MINI_SESSION_ID", ""));
          localThrowable.putExtra("KEY_VIDEO_START_PLAY_TIME_MS", ((cnu)localObject1).Mud);
          localThrowable.addFlags(536870912);
          paramBallInfo = FinderLongVideoTimelineUI.ubS;
          int i = FinderLongVideoTimelineUI.a.IS(((cnu)localObject1).Mue);
          ((aj)g.ah(aj.class)).fillContextIdToIntent(8, 6, i, localThrowable);
          paramBallInfo = com.tencent.mm.plugin.finder.utils.a.vUU;
          paramBallInfo = MMApplicationContext.getContext();
          p.g(paramBallInfo, "MMApplicationContext.getContext()");
          com.tencent.mm.plugin.finder.utils.a.d(paramBallInfo, localThrowable, true);
          AppMethodBeat.o(248357);
          return;
        }
      }
      AppMethodBeat.o(248357);
    }
    
    public final void c(BallInfo paramBallInfo)
    {
      Object localObject1 = null;
      AppMethodBeat.i(248358);
      if (paramBallInfo != null)
      {
        Object localObject2 = paramBallInfo.getByteArrayExtra("KEY_FLOAT_BALL_INFO");
        Object localObject3 = new cnu();
        try
        {
          ((cnu)localObject3).parseFrom((byte[])localObject2);
          localObject2 = FinderLongVideoTimelineUI.ubS;
          i = FinderLongVideoTimelineUI.a.IS(((cnu)localObject3).Mue);
          localObject2 = ((aj)g.ah(aj.class)).fillContextIdToIntent(8, 6, i, null);
          str = paramBallInfo.eT("KEY_FLOAT_BALL_MINI_SESSION_ID", "");
          LinkedList localLinkedList = ((cnu)localObject3).Muf;
          p.g(localLinkedList, "floatBallInfo.cacheNewVideoList");
          localObject3 = (FinderObject)j.L((List)localLinkedList, ((cnu)localObject3).Muc);
          if (localObject3 != null)
          {
            localObject3 = ((FinderObject)localObject3).attachmentList;
            if (localObject3 != null)
            {
              localObject3 = ((aoq)localObject3).LAM;
              if (localObject3 != null)
              {
                localObject3 = (aop)j.kt((List)localObject3);
                if (localObject3 != null)
                {
                  localObject3 = ((aop)localObject3).LAL;
                  if (localObject3 != null)
                  {
                    localObject3 = ((bei)localObject3).LIA;
                    if (localObject3 != null) {
                      break label211;
                    }
                  }
                }
              }
            }
          }
          AppMethodBeat.o(248358);
          return;
        }
        catch (Throwable localThrowable)
        {
          String str;
          for (;;)
          {
            Log.e("MegaVideoFloatBallHelper", "handleBallInfoClicked", new Object[] { localThrowable });
          }
          label211:
          p.g(localObject3, "floatBallInfo.cacheNewVi…ideo?.video ?: return@run");
          int i = paramBallInfo.getIntExtra("KEY_FLOAT_BALL_TASK_ORDER", 0);
          paramBallInfo = af.viA;
          p.g(str, "miniSessionId");
          paramBallInfo = localObject1;
          if (localObject3 != null) {
            paramBallInfo = Long.valueOf(((cng)localObject3).id);
          }
          paramBallInfo = d.zs(paramBallInfo.longValue());
          p.g(localThrowable, "contextId");
          af.a(str, i, paramBallInfo, "", localThrowable, "");
          AppMethodBeat.o(248358);
          return;
        }
      }
      AppMethodBeat.o(248358);
    }
    
    public final void d(BallInfo paramBallInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.floatball.a
 * JD-Core Version:    0.7.0.1
 */