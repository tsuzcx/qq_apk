package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.view.View;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ll;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.d;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "", "flowStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;)V", "feedObject_Field", "Ljava/lang/reflect/Field;", "getFlowStatistics", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1;", "fillShotScreenJson", "", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "feedMap", "", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "getFeed", "position", "", "feedId", "getListener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "Companion", "plugin-expt_release"})
public final class c
{
  public static final c.a sGX;
  private Field sCe;
  private Method sFF;
  private Field sGU;
  public final b sGV;
  final j sGW;
  
  static
  {
    AppMethodBeat.i(221044);
    sGX = new c.a((byte)0);
    AppMethodBeat.o(221044);
  }
  
  public c(j paramj)
  {
    AppMethodBeat.i(221043);
    this.sGW = paramj;
    try
    {
      paramj = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
      p.g(paramj, "Class.forName(BaseFinderFeed_Name)");
      paramj = paramj.getDeclaredField("feedObject");
      p.g(paramj, "BaseFinderFeed_Class.get…redField(feedObject_Name)");
      this.sCe = paramj;
      paramj = this.sCe;
      if (paramj == null) {
        p.btv("feedObject_Field");
      }
      paramj.setAccessible(true);
      paramj = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
      p.g(paramj, "Class.forName(FinderItem_Name)");
      paramj = paramj.getDeclaredMethod("getFinderObject", new Class[0]);
      p.g(paramj, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
      this.sFF = paramj;
      paramj = this.sFF;
      if (paramj == null) {
        p.btv("getFinderObject_Method");
      }
      paramj.setAccessible(true);
      paramj = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
      p.g(paramj, "Class.forName(FinderObject_Name)");
      paramj = paramj.getDeclaredField("id");
      p.g(paramj, "FinderObject_Class.getDeclaredField(id_Name)");
      this.sGU = paramj;
      paramj = this.sGU;
      if (paramj == null) {
        p.btv("id_Field");
      }
      paramj.setAccessible(true);
    }
    catch (Exception paramj)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)paramj, "init crash: " + paramj.getMessage(), new Object[0]);
      }
    }
    this.sGV = new b(this);
    AppMethodBeat.o(221043);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "getFeedIdWithBaseFinderFeedType", "", "obj", "", "onFeedClick", "", "position", "", "plugin-expt_release"})
  public static final class b
    implements d
  {
    private final String dh(Object paramObject)
    {
      AppMethodBeat.i(221042);
      if (paramObject == null)
      {
        AppMethodBeat.o(221042);
        return null;
      }
      try
      {
        paramObject = c.a(this.sGY).get(paramObject);
        paramObject = c.b(this.sGY).invoke(paramObject, new Object[0]);
        paramObject = c.c(this.sGY).get(paramObject);
        if (paramObject == null)
        {
          paramObject = new t("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(221042);
          throw paramObject;
        }
      }
      catch (Exception paramObject)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)paramObject, "getFeedIdWithBaseFinderFeedType crash: " + paramObject.getMessage(), new Object[0]);
        AppMethodBeat.o(221042);
        return null;
      }
      paramObject = com.tencent.mm.plugin.expt.hellhound.core.b.zs(((Long)paramObject).longValue());
      AppMethodBeat.o(221042);
      return paramObject;
    }
    
    public final void k(Object paramObject, int paramInt)
    {
      Object localObject3 = null;
      Object localObject2 = null;
      AppMethodBeat.i(221041);
      Object localObject4 = new StringBuilder("onFeedClick: obj=");
      Object localObject1;
      long l;
      if (paramObject != null)
      {
        localObject1 = paramObject.getClass();
        if (localObject1 != null)
        {
          localObject1 = ((Class)localObject1).getName();
          Log.i("HABBYGE-MALI.FinderClickStatistics", (String)localObject1 + ", pos=" + paramInt);
          l = System.currentTimeMillis();
          localObject4 = new a((byte)0);
          if (!(paramObject instanceof View)) {
            break label321;
          }
          localObject3 = this.sGY.sGW;
          paramObject = (View)paramObject;
          p.h(paramObject, "feedView");
          localObject1 = ((j)localObject3).sBo;
          if (localObject1 == null) {
            break label265;
          }
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject1).ac(paramObject, paramInt);
          label133:
          Log.w("HABBYGE-MALI.WaterfallsFlowStatistics", "getFeedWhenClick, getFeed=".concat(String.valueOf(localObject1)));
          if (localObject1 != null) {
            break label271;
          }
          localObject1 = localObject2;
          label157:
          localObject3 = this.sGY.sGW.cPv();
          localObject2 = localObject3;
          paramObject = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject3;
            paramObject = localObject1;
            if (paramInt >= 0)
            {
              localObject1 = c.g(paramInt, (Map)localObject3);
              localObject2 = localObject3;
              paramObject = localObject1;
              if (localObject1 == null)
              {
                Log.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-0-1");
                paramObject = localObject1;
                localObject2 = localObject3;
              }
            }
          }
        }
      }
      for (;;)
      {
        if (paramObject != null) {
          break label428;
        }
        Log.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)new NullPointerException("onFeedClick, wtf, feed is null !!!"), "", new Object[0]);
        AppMethodBeat.o(221041);
        return;
        localObject1 = null;
        break;
        label265:
        localObject1 = null;
        break label133;
        label271:
        localObject2 = (i)((j)localObject3).sHy.get(localObject1);
        paramObject = localObject2;
        if (localObject2 == null)
        {
          ((j)localObject3).Do(l);
          paramObject = (i)((j)localObject3).sHy.get(localObject1);
        }
        localObject1 = paramObject;
        break label157;
        label321:
        localObject1 = this.sGY.sGW.cPv();
        paramObject = dh(paramObject);
        if (paramObject == null)
        {
          localObject2 = localObject1;
          paramObject = localObject3;
          if (paramInt >= 0)
          {
            localObject3 = c.g(paramInt, (Map)localObject1);
            localObject2 = localObject1;
            paramObject = localObject3;
            if (localObject3 == null)
            {
              Log.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-1-1");
              localObject2 = localObject1;
              paramObject = localObject3;
            }
          }
        }
        else
        {
          localObject3 = c.s(paramObject, (Map)localObject1);
          localObject2 = localObject1;
          paramObject = localObject3;
          if (localObject3 == null)
          {
            Log.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-1-2");
            localObject2 = localObject1;
            paramObject = localObject3;
          }
        }
      }
      label428:
      ((a)localObject4).width = paramObject.width;
      ((a)localObject4).height = paramObject.height;
      ((a)localObject4).sessionId = paramObject.sessionId;
      ((a)localObject4).sGI = paramObject.feedId;
      ((a)localObject4).nickName = paramObject.nickName;
      ((a)localObject4).scene = paramObject.scene;
      ((a)localObject4).sGJ = paramObject.sGJ;
      ((a)localObject4).sGK = l;
      ((a)localObject4).sGL = paramObject.sGL;
      ((a)localObject4).sGM = paramObject.sGM;
      ((a)localObject4).sGN = paramObject.sHx;
      ((a)localObject4).sGO = paramObject.sGS;
      ((a)localObject4).sGQ = paramObject.sGQ;
      ((a)localObject4).sGR = paramObject.sGR;
      ((a)localObject4).sGS = paramObject.kf;
      ((a)localObject4).position = paramObject.position;
      c.a((a)localObject4, (Map)localObject2);
      paramObject = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
      p.h(localObject4, "clickFeed");
      paramObject = new ll();
      paramObject.yG(((a)localObject4).sessionId);
      paramObject.yH(((a)localObject4).sGI);
      paramObject.lT(((a)localObject4).scene);
      paramObject.uV(((a)localObject4).sGJ);
      paramObject.uW(((a)localObject4).sGK);
      float f2;
      if (((a)localObject4).sGL <= 0.0F)
      {
        f1 = 100.0F;
        localObject1 = ae.SYK;
        localObject1 = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.g(localObject1, "java.lang.String.format(format, *args)");
        paramObject.yI((String)localObject1);
        if (((a)localObject4).sGM > 0.0F) {
          break label896;
        }
        f1 = ((a)localObject4).width;
        f2 = ((a)localObject4).height;
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      }
      label896:
      for (float f1 = f1 * f2 * 100.0F / com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOV();; f1 = ((a)localObject4).sGM)
      {
        localObject1 = ae.SYK;
        localObject1 = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.g(localObject1, "java.lang.String.format(format, *args)");
        paramObject.yJ((String)localObject1);
        paramObject.lU(((a)localObject4).sGN);
        paramObject.lV(((a)localObject4).sGO);
        paramObject.yK(com.tencent.mm.plugin.expt.hellhound.core.b.aoY(((a)localObject4).sGP));
        paramObject.yL(((a)localObject4).sGQ);
        paramObject.yM(((a)localObject4).sGR);
        paramObject.lW(((a)localObject4).sGS);
        h.RTc.ba((Runnable)new a.a.c(paramObject, (a)localObject4));
        AppMethodBeat.o(221041);
        return;
        f1 = ((a)localObject4).sGL;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.c
 * JD-Core Version:    0.7.0.1
 */