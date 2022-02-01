package com.tencent.mm.plugin.finder.megavideo.floatball;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI.a;
import com.tencent.mm.plugin.finder.report.ai;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.cwl;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper;", "Lcom/tencent/mm/plugin/ball/service/PageFloatBallHelper;", "context", "Landroid/content/Context;", "pageAdapter", "Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/ball/adapter/IFloatBallPageAdapter;)V", "getContext", "()Landroid/content/Context;", "initReportInfo", "", "isSupportSwipeToFloatBall", "", "onCreate", "floatBallType", "", "floatBallKey", "", "onMenuFloatBallSelected", "enterFloatBall", "generateType", "Companion", "plugin-finder_release"})
public final class b
  extends com.tencent.mm.plugin.ball.service.e
{
  private static final com.tencent.mm.plugin.ball.c.e old;
  public static final a zwu;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(288128);
    zwu = new a((byte)0);
    old = (com.tencent.mm.plugin.ball.c.e)new b();
    AppMethodBeat.o(288128);
  }
  
  public b(Context paramContext, com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
    AppMethodBeat.i(288127);
    this.context = paramContext;
    AppMethodBeat.o(288127);
  }
  
  public final void D(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(288126);
    super.D(paramBoolean, paramInt);
    Object localObject1;
    Object localObject3;
    if (paramBoolean)
    {
      localObject1 = this.rYE.aou("KEY_FLOAT_BALL_INFO");
      localObject3 = new cwl();
    }
    try
    {
      ((cwl)localObject3).parseFrom((byte[])localObject1);
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject1 = aj.a.fZ(this.context);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).ekY();
        Object localObject4 = ((cwl)localObject3).TFk;
        p.j(localObject4, "floatBallInfo.cacheNewVideoList");
        localObject3 = (FinderObject)j.M((List)localObject4, ((cwl)localObject3).TFh);
        if (localObject3 == null) {
          break label408;
        }
        localObject3 = ((FinderObject)localObject3).attachmentList;
        if (localObject3 == null) {
          break label408;
        }
        localObject3 = ((apx)localObject3).SDm;
        if (localObject3 == null) {
          break label408;
        }
        localObject3 = (apw)j.lp((List)localObject3);
        if (localObject3 == null) {
          break label408;
        }
        localObject3 = ((apw)localObject3).SDl;
        if (localObject3 == null) {
          break label408;
        }
        localObject3 = ((blj)localObject3).SPm;
        int i = cvC() + 1;
        long l2 = cm.bfE();
        String str2 = "uin_".concat(String.valueOf(l2));
        this.rYE.cT("KEY_FLOAT_BALL_TASK_ORDER", i);
        this.rYE.fg("KEY_FLOAT_BALL_MINI_SESSION_ID", str2);
        this.rYE.Y("KEY_FLOAT_BALL_VERSION", 1L);
        localObject4 = ai.zZt;
        if (paramInt != 2) {
          break label414;
        }
        paramInt = 2;
        if (localObject3 == null) {
          break label419;
        }
        l1 = ((cvy)localObject3).id;
        String str3 = d.Fw(l1);
        Object localObject5;
        if (localObject1 != null)
        {
          localObject5 = ((bid)localObject1).sessionId;
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
          str1 = ((bid)localObject1).wmL;
          localObject5 = str1;
          if (str1 != null) {}
        }
        else
        {
          localObject5 = "";
        }
        if (localObject1 != null)
        {
          str1 = ((bid)localObject1).wmz;
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
        localObject3 = ((cvy)localObject3).TEO;
        if (localObject3 == null) {
          break label425;
        }
        l1 = ((cwj)localObject3).xbk;
        ai.a(l2, paramInt, i, str3, str2, (String)localObject4, (String)localObject5, (String)localObject1, d.Fw(l1));
        AppMethodBeat.o(288126);
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
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(288125);
    super.I(paramInt, paramString);
    cvL().kqZ = 17;
    AppMethodBeat.o(288125);
  }
  
  public final boolean aOg()
  {
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper$Companion;", "", "()V", "INNER_VERSION", "", "INTERVAL_REMOVE_THEN_ADD", "KEY_FLOAT_BALL_INFO", "", "KEY_FLOAT_BALL_MINI_SESSION_ID", "KEY_FLOAT_BALL_TASK_ORDER", "KEY_FLOAT_BALL_VERSION", "KEY_VIDEO_FLOAT_BALL_INFO", "TAG", "floatBallInfoEventListener", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListener;", "handleBallInfoClicked", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "isFromVideoBall", "", "i", "Landroid/content/Intent;", "startListeningFloatBallInfoClicked", "stopListeningFloatBallInfoClicked", "plugin-finder_release"})
  public static final class a
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    public static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      public a(com.tencent.mm.plugin.ball.c.b paramb)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper$Companion$floatBallInfoEventListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListenerAdapter;", "onFloatBallInfoClicked", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "onFloatBallInfoExposed", "onFloatBallInfoRemoved", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.plugin.ball.c.f
  {
    public final void b(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(275907);
      if (paramBallInfo != null)
      {
        Object localObject1 = b.zwu;
        p.k(paramBallInfo, "ballInfo");
        Object localObject2 = paramBallInfo.aou("KEY_FLOAT_BALL_INFO");
        localObject1 = new cwl();
        try
        {
          ((cwl)localObject1).parseFrom((byte[])localObject2);
          localObject2 = new Intent();
          localObject3 = ((cwl)localObject1).TFk;
          p.j(localObject3, "floatBallInfo.cacheNewVideoList");
          localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            Object localObject5 = (FinderObject)((Iterator)localObject4).next();
            Object localObject6 = FinderItem.Companion;
            p.j(localObject5, "it");
            localObject5 = FinderItem.a.b((FinderObject)localObject5, 1);
            localObject6 = c.AnK;
            ((Collection)localObject3).add(c.a.a((FinderItem)localObject5));
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.e("MegaVideoFloatBallHelper", "handleBallInfoClicked", new Object[] { localThrowable });
          }
          Object localObject3 = (List)localObject3;
          Object localObject4 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          com.tencent.mm.plugin.finder.utils.aj.a(((cwl)localObject1).TFh, (List)localObject3, ((cwl)localObject1).lastBuffer, localThrowable);
          localThrowable.putExtra("KEY_ROUTER_UI", ((cwl)localObject1).TFj);
          localThrowable.putExtra("KEY_FLOAT_BALL_INFO", ((cwl)localObject1).toByteArray());
          localThrowable.putExtra("KEY_FLOAT_BALL_TASK_ORDER", paramBallInfo.getIntExtra("KEY_FLOAT_BALL_TASK_ORDER", 0));
          localThrowable.putExtra("KEY_FLOAT_BALL_MINI_SESSION_ID", paramBallInfo.fh("KEY_FLOAT_BALL_MINI_SESSION_ID", ""));
          localThrowable.putExtra("KEY_VIDEO_START_PLAY_TIME_MS", ((cwl)localObject1).TFi * 1000L);
          localThrowable.addFlags(536870912);
          ((ak)h.ag(ak.class)).fillContextIdToIntent(8, 6, 45, localThrowable);
          paramBallInfo = com.tencent.mm.plugin.finder.utils.a.ACH;
          paramBallInfo = MMApplicationContext.getContext();
          p.j(paramBallInfo, "MMApplicationContext.getContext()");
          com.tencent.mm.plugin.finder.utils.a.an(paramBallInfo, localThrowable);
          AppMethodBeat.o(275907);
          return;
        }
      }
      AppMethodBeat.o(275907);
    }
    
    public final void c(BallInfo paramBallInfo)
    {
      Object localObject1 = null;
      AppMethodBeat.i(275908);
      if (paramBallInfo != null)
      {
        Object localObject2 = paramBallInfo.aou("KEY_FLOAT_BALL_INFO");
        Object localObject3 = new cwl();
        try
        {
          ((cwl)localObject3).parseFrom((byte[])localObject2);
          localObject2 = FinderLongVideoTimelineUI.xQK;
          i = FinderLongVideoTimelineUI.a.MP(((cwl)localObject3).TFj);
          localObject2 = ((ak)h.ag(ak.class)).fillContextIdToIntent(8, 6, i, null);
          str = paramBallInfo.fh("KEY_FLOAT_BALL_MINI_SESSION_ID", "");
          LinkedList localLinkedList = ((cwl)localObject3).TFk;
          p.j(localLinkedList, "floatBallInfo.cacheNewVideoList");
          localObject3 = (FinderObject)j.M((List)localLinkedList, ((cwl)localObject3).TFh);
          if (localObject3 != null)
          {
            localObject3 = ((FinderObject)localObject3).attachmentList;
            if (localObject3 != null)
            {
              localObject3 = ((apx)localObject3).SDm;
              if (localObject3 != null)
              {
                localObject3 = (apw)j.lp((List)localObject3);
                if (localObject3 != null)
                {
                  localObject3 = ((apw)localObject3).SDl;
                  if (localObject3 != null)
                  {
                    localObject3 = ((blj)localObject3).SPm;
                    if (localObject3 != null) {
                      break label211;
                    }
                  }
                }
              }
            }
          }
          AppMethodBeat.o(275908);
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
          p.j(localObject3, "floatBallInfo.cacheNewVi…ideo?.video ?: return@run");
          int i = paramBallInfo.getIntExtra("KEY_FLOAT_BALL_TASK_ORDER", 0);
          paramBallInfo = ai.zZt;
          p.j(str, "miniSessionId");
          paramBallInfo = localObject1;
          if (localObject3 != null) {
            paramBallInfo = Long.valueOf(((cvy)localObject3).id);
          }
          paramBallInfo = d.Fw(paramBallInfo.longValue());
          p.j(localThrowable, "contextId");
          ai.a(str, i, paramBallInfo, "", localThrowable, "");
          AppMethodBeat.o(275908);
          return;
        }
      }
      AppMethodBeat.o(275908);
    }
    
    public final void d(BallInfo paramBallInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.floatball.b
 * JD-Core Version:    0.7.0.1
 */