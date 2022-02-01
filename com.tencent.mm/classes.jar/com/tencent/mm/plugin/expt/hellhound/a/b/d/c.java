package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.view.View;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ho;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.d;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a.c;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "", "flowStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;)V", "feedObject_Field", "Ljava/lang/reflect/Field;", "getFlowStatistics", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1;", "fillShotScreenJson", "", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "feedMap", "", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "getFeed", "position", "", "feedId", "getListener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "Companion", "plugin-expt_release"})
public final class c
{
  public static final c.a qXB;
  private Field qTH;
  private Method qWo;
  final j qXA;
  private Field qXy;
  public final b qXz;
  
  static
  {
    AppMethodBeat.i(210881);
    qXB = new c.a((byte)0);
    AppMethodBeat.o(210881);
  }
  
  public c(j paramj)
  {
    AppMethodBeat.i(210880);
    this.qXA = paramj;
    try
    {
      paramj = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
      p.g(paramj, "BaseFinderFeed_Class.get…redField(feedObject_Name)");
      this.qTH = paramj;
      paramj = this.qTH;
      if (paramj == null) {
        p.bcb("feedObject_Field");
      }
      paramj.setAccessible(true);
      paramj = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem").getDeclaredMethod("getFinderObject", new Class[0]);
      p.g(paramj, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
      this.qWo = paramj;
      paramj = this.qWo;
      if (paramj == null) {
        p.bcb("getFinderObject_Method");
      }
      paramj.setAccessible(true);
      paramj = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject").getDeclaredField("id");
      p.g(paramj, "FinderObject_Class.getDeclaredField(id_Name)");
      this.qXy = paramj;
      paramj = this.qXy;
      if (paramj == null) {
        p.bcb("id_Field");
      }
      paramj.setAccessible(true);
    }
    catch (Exception paramj)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)paramj, "init crash: " + paramj.getMessage(), new Object[0]);
      }
    }
    this.qXz = new b(this);
    AppMethodBeat.o(210880);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "getFeedIdWithBaseFinderFeedType", "", "obj", "", "onFeedClick", "", "position", "", "plugin-expt_release"})
  public static final class b
    implements d
  {
    private final String cZ(Object paramObject)
    {
      AppMethodBeat.i(210879);
      if (paramObject == null)
      {
        AppMethodBeat.o(210879);
        return null;
      }
      try
      {
        paramObject = c.a(this.qXC).get(paramObject);
        paramObject = c.b(this.qXC).invoke(paramObject, new Object[0]);
        paramObject = c.c(this.qXC).get(paramObject);
        if (paramObject == null)
        {
          paramObject = new v("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(210879);
          throw paramObject;
        }
      }
      catch (Exception paramObject)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)paramObject, "getFeedIdWithBaseFinderFeedType crash: " + paramObject.getMessage(), new Object[0]);
        AppMethodBeat.o(210879);
        return null;
      }
      paramObject = com.tencent.mm.plugin.expt.hellhound.core.b.rc(((Long)paramObject).longValue());
      AppMethodBeat.o(210879);
      return paramObject;
    }
    
    public final void i(Object paramObject, int paramInt)
    {
      Object localObject3 = null;
      Object localObject2 = null;
      AppMethodBeat.i(210878);
      Object localObject4 = new StringBuilder("onFeedClick: obj=");
      Object localObject1;
      long l;
      if (paramObject != null)
      {
        localObject1 = paramObject.getClass();
        if (localObject1 != null)
        {
          localObject1 = ((Class)localObject1).getName();
          com.tencent.mm.sdk.platformtools.ad.i("HABBYGE-MALI.FinderClickStatistics", (String)localObject1 + ", pos=" + paramInt);
          l = System.currentTimeMillis();
          localObject4 = new a((byte)0);
          if (!(paramObject instanceof View)) {
            break label321;
          }
          localObject3 = this.qXC.qXA;
          paramObject = (View)paramObject;
          p.h(paramObject, "feedView");
          localObject1 = ((j)localObject3).qSZ;
          if (localObject1 == null) {
            break label265;
          }
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject1).ad(paramObject, paramInt);
          label133:
          com.tencent.mm.sdk.platformtools.ad.w("HABBYGE-MALI.WaterfallsFlowStatistics", "getFeedWhenClick, getFeed=".concat(String.valueOf(localObject1)));
          if (localObject1 != null) {
            break label271;
          }
          localObject1 = localObject2;
          label157:
          localObject3 = this.qXC.qXA.cpl();
          localObject2 = localObject3;
          paramObject = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject3;
            paramObject = localObject1;
            if (paramInt >= 0)
            {
              localObject1 = c.e(paramInt, (Map)localObject3);
              localObject2 = localObject3;
              paramObject = localObject1;
              if (localObject1 == null)
              {
                com.tencent.mm.sdk.platformtools.ad.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-0-1");
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
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)new NullPointerException("onFeedClick, wtf, feed is null !!!"), "", new Object[0]);
        AppMethodBeat.o(210878);
        return;
        localObject1 = null;
        break;
        label265:
        localObject1 = null;
        break label133;
        label271:
        localObject2 = (i)((j)localObject3).qXW.get(localObject1);
        paramObject = localObject2;
        if (localObject2 == null)
        {
          ((j)localObject3).uT(l);
          paramObject = (i)((j)localObject3).qXW.get(localObject1);
        }
        localObject1 = paramObject;
        break label157;
        label321:
        localObject1 = this.qXC.qXA.cpl();
        paramObject = cZ(paramObject);
        if (paramObject == null)
        {
          localObject2 = localObject1;
          paramObject = localObject3;
          if (paramInt >= 0)
          {
            localObject3 = c.e(paramInt, (Map)localObject1);
            localObject2 = localObject1;
            paramObject = localObject3;
            if (localObject3 == null)
            {
              com.tencent.mm.sdk.platformtools.ad.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-1-1");
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
            com.tencent.mm.sdk.platformtools.ad.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-1-2");
            localObject2 = localObject1;
            paramObject = localObject3;
          }
        }
      }
      label428:
      ((a)localObject4).width = paramObject.width;
      ((a)localObject4).height = paramObject.height;
      ((a)localObject4).sessionId = paramObject.sessionId;
      ((a)localObject4).qXm = paramObject.feedId;
      ((a)localObject4).bVF = paramObject.bVF;
      ((a)localObject4).scene = paramObject.scene;
      ((a)localObject4).qXn = paramObject.qXn;
      ((a)localObject4).qXo = l;
      ((a)localObject4).qXp = paramObject.qXp;
      ((a)localObject4).qXq = paramObject.qXq;
      ((a)localObject4).qXr = paramObject.qXV;
      ((a)localObject4).qXs = paramObject.qXw;
      ((a)localObject4).qXu = paramObject.qXu;
      ((a)localObject4).qXv = paramObject.qXv;
      ((a)localObject4).qXw = paramObject.kd;
      ((a)localObject4).position = paramObject.position;
      c.a((a)localObject4, (Map)localObject2);
      paramObject = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.qXa;
      p.h(localObject4, "clickFeed");
      paramObject = new ho();
      paramObject.qi(((a)localObject4).sessionId);
      paramObject.qj(((a)localObject4).qXm);
      paramObject.iP(((a)localObject4).scene);
      paramObject.mZ(((a)localObject4).qXn);
      paramObject.na(((a)localObject4).qXo);
      float f2;
      if (((a)localObject4).qXp <= 0.0F)
      {
        f1 = 100.0F;
        localObject1 = d.g.b.ad.MLZ;
        localObject1 = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.g(localObject1, "java.lang.String.format(format, *args)");
        paramObject.qk((String)localObject1);
        if (((a)localObject4).qXq > 0.0F) {
          break label896;
        }
        f1 = ((a)localObject4).width;
        f2 = ((a)localObject4).height;
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
      }
      label896:
      for (float f1 = f1 * f2 * 100.0F / com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coR();; f1 = ((a)localObject4).qXq)
      {
        localObject1 = d.g.b.ad.MLZ;
        localObject1 = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.g(localObject1, "java.lang.String.format(format, *args)");
        paramObject.ql((String)localObject1);
        paramObject.iQ(((a)localObject4).qXr);
        paramObject.iR(((a)localObject4).qXs);
        paramObject.qm(com.tencent.mm.plugin.expt.hellhound.core.b.adP(((a)localObject4).qXt));
        paramObject.qn(((a)localObject4).qXu);
        paramObject.qo(((a)localObject4).qXv);
        paramObject.iS(((a)localObject4).qXw);
        h.LTJ.aU((Runnable)new a.a.c(paramObject, (a)localObject4));
        AppMethodBeat.o(210878);
        return;
        f1 = ((a)localObject4).qXp;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.c
 * JD-Core Version:    0.7.0.1
 */