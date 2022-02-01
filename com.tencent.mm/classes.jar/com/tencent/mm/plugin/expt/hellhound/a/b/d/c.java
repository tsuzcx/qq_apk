package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.view.View;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hq;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.d;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "", "flowStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;)V", "feedObject_Field", "Ljava/lang/reflect/Field;", "getFlowStatistics", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1;", "fillShotScreenJson", "", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "feedMap", "", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "getFeed", "position", "", "feedId", "getListener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "Companion", "plugin-expt_release"})
public final class c
{
  public static final c.a rfH;
  private Field rbF;
  private Method reo;
  private Field rfE;
  public final b rfF;
  final j rfG;
  
  static
  {
    AppMethodBeat.i(196552);
    rfH = new c.a((byte)0);
    AppMethodBeat.o(196552);
  }
  
  public c(j paramj)
  {
    AppMethodBeat.i(196551);
    this.rfG = paramj;
    try
    {
      paramj = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
      p.g(paramj, "BaseFinderFeed_Class.get…redField(feedObject_Name)");
      this.rbF = paramj;
      paramj = this.rbF;
      if (paramj == null) {
        p.bdF("feedObject_Field");
      }
      paramj.setAccessible(true);
      paramj = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem").getDeclaredMethod("getFinderObject", new Class[0]);
      p.g(paramj, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
      this.reo = paramj;
      paramj = this.reo;
      if (paramj == null) {
        p.bdF("getFinderObject_Method");
      }
      paramj.setAccessible(true);
      paramj = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject").getDeclaredField("id");
      p.g(paramj, "FinderObject_Class.getDeclaredField(id_Name)");
      this.rfE = paramj;
      paramj = this.rfE;
      if (paramj == null) {
        p.bdF("id_Field");
      }
      paramj.setAccessible(true);
    }
    catch (Exception paramj)
    {
      for (;;)
      {
        ae.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)paramj, "init crash: " + paramj.getMessage(), new Object[0]);
      }
    }
    this.rfF = new b(this);
    AppMethodBeat.o(196551);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "getFeedIdWithBaseFinderFeedType", "", "obj", "", "onFeedClick", "", "position", "", "plugin-expt_release"})
  public static final class b
    implements d
  {
    private final String da(Object paramObject)
    {
      AppMethodBeat.i(196550);
      if (paramObject == null)
      {
        AppMethodBeat.o(196550);
        return null;
      }
      try
      {
        paramObject = c.a(this.rfI).get(paramObject);
        paramObject = c.b(this.rfI).invoke(paramObject, new Object[0]);
        paramObject = c.c(this.rfI).get(paramObject);
        if (paramObject == null)
        {
          paramObject = new v("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(196550);
          throw paramObject;
        }
      }
      catch (Exception paramObject)
      {
        ae.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)paramObject, "getFeedIdWithBaseFinderFeedType crash: " + paramObject.getMessage(), new Object[0]);
        AppMethodBeat.o(196550);
        return null;
      }
      paramObject = com.tencent.mm.plugin.expt.hellhound.core.b.rp(((Long)paramObject).longValue());
      AppMethodBeat.o(196550);
      return paramObject;
    }
    
    public final void i(Object paramObject, int paramInt)
    {
      Object localObject3 = null;
      Object localObject2 = null;
      AppMethodBeat.i(196549);
      Object localObject4 = new StringBuilder("onFeedClick: obj=");
      Object localObject1;
      long l;
      if (paramObject != null)
      {
        localObject1 = paramObject.getClass();
        if (localObject1 != null)
        {
          localObject1 = ((Class)localObject1).getName();
          ae.i("HABBYGE-MALI.FinderClickStatistics", (String)localObject1 + ", pos=" + paramInt);
          l = System.currentTimeMillis();
          localObject4 = new a((byte)0);
          if (!(paramObject instanceof View)) {
            break label321;
          }
          localObject3 = this.rfI.rfG;
          paramObject = (View)paramObject;
          p.h(paramObject, "feedView");
          localObject1 = ((j)localObject3).raX;
          if (localObject1 == null) {
            break label265;
          }
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject1).ad(paramObject, paramInt);
          label133:
          ae.w("HABBYGE-MALI.WaterfallsFlowStatistics", "getFeedWhenClick, getFeed=".concat(String.valueOf(localObject1)));
          if (localObject1 != null) {
            break label271;
          }
          localObject1 = localObject2;
          label157:
          localObject3 = this.rfI.rfG.cqN();
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
                ae.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-0-1");
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
        ae.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)new NullPointerException("onFeedClick, wtf, feed is null !!!"), "", new Object[0]);
        AppMethodBeat.o(196549);
        return;
        localObject1 = null;
        break;
        label265:
        localObject1 = null;
        break label133;
        label271:
        localObject2 = (i)((j)localObject3).rgc.get(localObject1);
        paramObject = localObject2;
        if (localObject2 == null)
        {
          ((j)localObject3).vk(l);
          paramObject = (i)((j)localObject3).rgc.get(localObject1);
        }
        localObject1 = paramObject;
        break label157;
        label321:
        localObject1 = this.rfI.rfG.cqN();
        paramObject = da(paramObject);
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
              ae.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-1-1");
              localObject2 = localObject1;
              paramObject = localObject3;
            }
          }
        }
        else
        {
          localObject3 = c.t(paramObject, (Map)localObject1);
          localObject2 = localObject1;
          paramObject = localObject3;
          if (localObject3 == null)
          {
            ae.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-1-2");
            localObject2 = localObject1;
            paramObject = localObject3;
          }
        }
      }
      label428:
      ((a)localObject4).width = paramObject.width;
      ((a)localObject4).height = paramObject.height;
      ((a)localObject4).sessionId = paramObject.sessionId;
      ((a)localObject4).rfs = paramObject.feedId;
      ((a)localObject4).bVF = paramObject.bVF;
      ((a)localObject4).scene = paramObject.scene;
      ((a)localObject4).rft = paramObject.rft;
      ((a)localObject4).rfu = l;
      ((a)localObject4).rfv = paramObject.rfv;
      ((a)localObject4).rfw = paramObject.rfw;
      ((a)localObject4).rfx = paramObject.rgb;
      ((a)localObject4).rfy = paramObject.rfC;
      ((a)localObject4).rfA = paramObject.rfA;
      ((a)localObject4).rfB = paramObject.rfB;
      ((a)localObject4).rfC = paramObject.kd;
      ((a)localObject4).position = paramObject.position;
      c.a((a)localObject4, (Map)localObject2);
      paramObject = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.rff;
      p.h(localObject4, "clickFeed");
      paramObject = new hq();
      paramObject.qD(((a)localObject4).sessionId);
      paramObject.qE(((a)localObject4).rfs);
      paramObject.iR(((a)localObject4).scene);
      paramObject.nl(((a)localObject4).rft);
      paramObject.nm(((a)localObject4).rfu);
      float f2;
      if (((a)localObject4).rfv <= 0.0F)
      {
        f1 = 100.0F;
        localObject1 = ad.Njc;
        localObject1 = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.g(localObject1, "java.lang.String.format(format, *args)");
        paramObject.qF((String)localObject1);
        if (((a)localObject4).rfw > 0.0F) {
          break label896;
        }
        f1 = ((a)localObject4).width;
        f2 = ((a)localObject4).height;
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
      }
      label896:
      for (float f1 = f1 * f2 * 100.0F / com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqt();; f1 = ((a)localObject4).rfw)
      {
        localObject1 = ad.Njc;
        localObject1 = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.g(localObject1, "java.lang.String.format(format, *args)");
        paramObject.qG((String)localObject1);
        paramObject.iS(((a)localObject4).rfx);
        paramObject.iT(((a)localObject4).rfy);
        paramObject.qH(com.tencent.mm.plugin.expt.hellhound.core.b.aeJ(((a)localObject4).rfz));
        paramObject.qI(((a)localObject4).rfA);
        paramObject.qJ(((a)localObject4).rfB);
        paramObject.iU(((a)localObject4).rfC);
        h.MqF.aR((Runnable)new a.a.c(paramObject, (a)localObject4));
        AppMethodBeat.o(196549);
        return;
        f1 = ((a)localObject4).rfv;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.c
 * JD-Core Version:    0.7.0.1
 */