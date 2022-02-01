package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.view.View;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.oi;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.d;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "", "flowStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;)V", "feedObject_Field", "Ljava/lang/reflect/Field;", "getFlowStatistics", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1;", "fillShotScreenJson", "", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "feedMap", "", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "getFeed", "position", "", "feedId", "getListener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "Companion", "plugin-expt_release"})
public final class c
{
  public static final c.a wmS;
  private Field whZ;
  private Method wlA;
  private Field wmP;
  public final b wmQ;
  final j wmR;
  
  static
  {
    AppMethodBeat.i(251820);
    wmS = new c.a((byte)0);
    AppMethodBeat.o(251820);
  }
  
  public c(j paramj)
  {
    AppMethodBeat.i(251819);
    this.wmR = paramj;
    try
    {
      paramj = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
      p.j(paramj, "Class.forName(BaseFinderFeed_Name)");
      paramj = paramj.getDeclaredField("feedObject");
      p.j(paramj, "BaseFinderFeed_Class.get…redField(feedObject_Name)");
      this.whZ = paramj;
      paramj = this.whZ;
      if (paramj == null) {
        p.bGy("feedObject_Field");
      }
      paramj.setAccessible(true);
      paramj = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
      p.j(paramj, "Class.forName(FinderItem_Name)");
      paramj = paramj.getDeclaredMethod("getFinderObject", new Class[0]);
      p.j(paramj, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
      this.wlA = paramj;
      paramj = this.wlA;
      if (paramj == null) {
        p.bGy("getFinderObject_Method");
      }
      paramj.setAccessible(true);
      paramj = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
      p.j(paramj, "Class.forName(FinderObject_Name)");
      paramj = paramj.getDeclaredField("id");
      p.j(paramj, "FinderObject_Class.getDeclaredField(id_Name)");
      this.wmP = paramj;
      paramj = this.wmP;
      if (paramj == null) {
        p.bGy("id_Field");
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
    this.wmQ = new b(this);
    AppMethodBeat.o(251819);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "getFeedIdWithBaseFinderFeedType", "", "obj", "", "onFeedClick", "", "position", "", "plugin-expt_release"})
  public static final class b
    implements d
  {
    private final String de(Object paramObject)
    {
      AppMethodBeat.i(251087);
      if (paramObject == null)
      {
        AppMethodBeat.o(251087);
        return null;
      }
      try
      {
        paramObject = c.a(this.wmT).get(paramObject);
        paramObject = c.b(this.wmT).invoke(paramObject, new Object[0]);
        paramObject = c.c(this.wmT).get(paramObject);
        if (paramObject == null)
        {
          paramObject = new t("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(251087);
          throw paramObject;
        }
      }
      catch (Exception paramObject)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)paramObject, "getFeedIdWithBaseFinderFeedType crash: " + paramObject.getMessage(), new Object[0]);
        AppMethodBeat.o(251087);
        return null;
      }
      paramObject = com.tencent.mm.plugin.expt.hellhound.core.b.Fw(((Long)paramObject).longValue());
      AppMethodBeat.o(251087);
      return paramObject;
    }
    
    public final void o(Object paramObject, int paramInt)
    {
      Object localObject3 = null;
      Object localObject2 = null;
      AppMethodBeat.i(251086);
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
          localObject3 = this.wmT.wmR;
          paramObject = (View)paramObject;
          p.k(paramObject, "feedView");
          localObject1 = ((j)localObject3).whi;
          if (localObject1 == null) {
            break label265;
          }
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject1).ae(paramObject, paramInt);
          label133:
          Log.w("HABBYGE-MALI.WaterfallsFlowStatistics", "getFeedWhenClick, getFeed=".concat(String.valueOf(localObject1)));
          if (localObject1 != null) {
            break label271;
          }
          localObject1 = localObject2;
          label157:
          localObject3 = this.wmT.wmR.dep();
          localObject2 = localObject3;
          paramObject = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject3;
            paramObject = localObject1;
            if (paramInt >= 0)
            {
              localObject1 = c.f(paramInt, (Map)localObject3);
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
        AppMethodBeat.o(251086);
        return;
        localObject1 = null;
        break;
        label265:
        localObject1 = null;
        break label133;
        label271:
        localObject2 = (i)((j)localObject3).wnt.get(localObject1);
        paramObject = localObject2;
        if (localObject2 == null)
        {
          ((j)localObject3).JC(l);
          paramObject = (i)((j)localObject3).wnt.get(localObject1);
        }
        localObject1 = paramObject;
        break label157;
        label321:
        localObject1 = this.wmT.wmR.dep();
        paramObject = de(paramObject);
        if (paramObject == null)
        {
          localObject2 = localObject1;
          paramObject = localObject3;
          if (paramInt >= 0)
          {
            localObject3 = c.f(paramInt, (Map)localObject1);
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
          localObject3 = c.r(paramObject, (Map)localObject1);
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
      ((a)localObject4).wmD = paramObject.feedId;
      ((a)localObject4).nickName = paramObject.nickName;
      ((a)localObject4).scene = paramObject.scene;
      ((a)localObject4).wmE = paramObject.wmE;
      ((a)localObject4).wmF = l;
      ((a)localObject4).wmG = paramObject.wmG;
      ((a)localObject4).wmH = paramObject.wmH;
      ((a)localObject4).wmI = paramObject.wns;
      ((a)localObject4).wmJ = paramObject.wmN;
      ((a)localObject4).wmL = paramObject.wmL;
      ((a)localObject4).wmM = paramObject.wmM;
      ((a)localObject4).wmN = paramObject.bwM;
      ((a)localObject4).position = paramObject.position;
      c.a((a)localObject4, (Map)localObject2);
      paramObject = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.wmq;
      p.k(localObject4, "clickFeed");
      paramObject = new oi();
      paramObject.Fh(((a)localObject4).sessionId);
      paramObject.Fi(((a)localObject4).wmD);
      paramObject.oe(((a)localObject4).scene);
      paramObject.AK(((a)localObject4).wmE);
      paramObject.AL(((a)localObject4).wmF);
      float f2;
      if (((a)localObject4).wmG <= 0.0F)
      {
        f1 = 100.0F;
        localObject1 = af.aaBG;
        localObject1 = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.j(localObject1, "java.lang.String.format(format, *args)");
        paramObject.Fj((String)localObject1);
        if (((a)localObject4).wmH > 0.0F) {
          break label896;
        }
        f1 = ((a)localObject4).width;
        f2 = ((a)localObject4).height;
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      }
      label896:
      for (float f1 = f1 * f2 * 100.0F / com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddO();; f1 = ((a)localObject4).wmH)
      {
        localObject1 = af.aaBG;
        localObject1 = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.j(localObject1, "java.lang.String.format(format, *args)");
        paramObject.Fk((String)localObject1);
        paramObject.of(((a)localObject4).wmI);
        paramObject.og(((a)localObject4).wmJ);
        paramObject.Fl(com.tencent.mm.plugin.expt.hellhound.core.b.awX(((a)localObject4).wmK));
        paramObject.Fm(((a)localObject4).wmL);
        paramObject.Fn(((a)localObject4).wmM);
        paramObject.oh(((a)localObject4).wmN);
        h.ZvG.bh((Runnable)new a.a.c(paramObject, (a)localObject4));
        AppMethodBeat.o(251086);
        return;
        f1 = ((a)localObject4).wmG;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.c
 * JD-Core Version:    0.7.0.1
 */