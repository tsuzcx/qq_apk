package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.view.View;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gl;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.d;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.g.b.z;
import d.l;
import d.v;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "", "flowStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;)V", "feedObject_Field", "Ljava/lang/reflect/Field;", "getFlowStatistics", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1;", "fillShotScreenJson", "", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "feedMap", "", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "getFeed", "position", "", "feedId", "getListener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "Companion", "plugin-expt_release"})
public final class c
{
  public static final c.a qoE;
  private Field qkL;
  private Method qnq;
  private Field qoB;
  public final b qoC;
  final j qoD;
  
  static
  {
    AppMethodBeat.i(195535);
    qoE = new c.a((byte)0);
    AppMethodBeat.o(195535);
  }
  
  public c(j paramj)
  {
    AppMethodBeat.i(195534);
    this.qoD = paramj;
    try
    {
      paramj = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
      k.g(paramj, "BaseFinderFeed_Class.get…redField(feedObject_Name)");
      this.qkL = paramj;
      paramj = this.qkL;
      if (paramj == null) {
        k.aVY("feedObject_Field");
      }
      paramj.setAccessible(true);
      paramj = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem").getDeclaredMethod("getFinderObject", new Class[0]);
      k.g(paramj, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
      this.qnq = paramj;
      paramj = this.qnq;
      if (paramj == null) {
        k.aVY("getFinderObject_Method");
      }
      paramj.setAccessible(true);
      paramj = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject").getDeclaredField("id");
      k.g(paramj, "FinderObject_Class.getDeclaredField(id_Name)");
      this.qoB = paramj;
      paramj = this.qoB;
      if (paramj == null) {
        k.aVY("id_Field");
      }
      paramj.setAccessible(true);
    }
    catch (Exception paramj)
    {
      for (;;)
      {
        ac.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)paramj, "init crash: " + paramj.getMessage(), new Object[0]);
      }
    }
    this.qoC = new b(this);
    AppMethodBeat.o(195534);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "getFeedIdWithBaseFinderFeedType", "", "obj", "", "onFeedClick", "", "position", "", "plugin-expt_release"})
  public static final class b
    implements d
  {
    private final String cV(Object paramObject)
    {
      AppMethodBeat.i(195533);
      if (paramObject == null)
      {
        AppMethodBeat.o(195533);
        return null;
      }
      try
      {
        paramObject = c.a(this.qoF).get(paramObject);
        paramObject = c.b(this.qoF).invoke(paramObject, new Object[0]);
        paramObject = c.c(this.qoF).get(paramObject);
        if (paramObject == null)
        {
          paramObject = new v("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(195533);
          throw paramObject;
        }
      }
      catch (Exception paramObject)
      {
        ac.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)paramObject, "getFeedIdWithBaseFinderFeedType crash: " + paramObject.getMessage(), new Object[0]);
        AppMethodBeat.o(195533);
        return null;
      }
      paramObject = com.tencent.mm.plugin.expt.hellhound.core.b.pb(((Long)paramObject).longValue());
      AppMethodBeat.o(195533);
      return paramObject;
    }
    
    public final void h(Object paramObject, int paramInt)
    {
      Object localObject3 = null;
      Object localObject2 = null;
      AppMethodBeat.i(195532);
      Object localObject4 = new StringBuilder("onFeedClick: obj=");
      Object localObject1;
      long l;
      if (paramObject != null)
      {
        localObject1 = paramObject.getClass();
        if (localObject1 != null)
        {
          localObject1 = ((Class)localObject1).getName();
          ac.i("HABBYGE-MALI.FinderClickStatistics", (String)localObject1 + ", pos=" + paramInt);
          l = System.currentTimeMillis();
          localObject4 = new a((byte)0);
          if (!(paramObject instanceof View)) {
            break label321;
          }
          localObject3 = this.qoF.qoD;
          paramObject = (View)paramObject;
          k.h(paramObject, "feedView");
          localObject1 = ((j)localObject3).qkd;
          if (localObject1 == null) {
            break label265;
          }
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject1).ac(paramObject, paramInt);
          label133:
          ac.w("HABBYGE-MALI.WaterfallsFlowStatistics", "getFeedWhenClick, getFeed=".concat(String.valueOf(localObject1)));
          if (localObject1 != null) {
            break label271;
          }
          localObject1 = localObject2;
          label157:
          localObject3 = this.qoF.qoD.cjX();
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
                ac.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-0-1");
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
        ac.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)new NullPointerException("onFeedClick, wtf, feed is null !!!"), "", new Object[0]);
        AppMethodBeat.o(195532);
        return;
        localObject1 = null;
        break;
        label265:
        localObject1 = null;
        break label133;
        label271:
        localObject2 = (i)((j)localObject3).qoX.get(localObject1);
        paramObject = localObject2;
        if (localObject2 == null)
        {
          ((j)localObject3).sW(l);
          paramObject = (i)((j)localObject3).qoX.get(localObject1);
        }
        localObject1 = paramObject;
        break label157;
        label321:
        localObject1 = this.qoF.qoD.cjX();
        paramObject = cV(paramObject);
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
              ac.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-1-1");
              localObject2 = localObject1;
              paramObject = localObject3;
            }
          }
        }
        else
        {
          localObject3 = c.q(paramObject, (Map)localObject1);
          localObject2 = localObject1;
          paramObject = localObject3;
          if (localObject3 == null)
          {
            ac.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-1-2");
            localObject2 = localObject1;
            paramObject = localObject3;
          }
        }
      }
      label428:
      ((a)localObject4).width = paramObject.width;
      ((a)localObject4).height = paramObject.height;
      ((a)localObject4).sessionId = paramObject.sessionId;
      ((a)localObject4).qop = paramObject.feedId;
      ((a)localObject4).bLs = paramObject.bLs;
      ((a)localObject4).scene = paramObject.scene;
      ((a)localObject4).qoq = paramObject.qoq;
      ((a)localObject4).qor = l;
      ((a)localObject4).qos = paramObject.qos;
      ((a)localObject4).qot = paramObject.qot;
      ((a)localObject4).qou = paramObject.qoW;
      ((a)localObject4).qov = paramObject.qoz;
      ((a)localObject4).qox = paramObject.qox;
      ((a)localObject4).qoy = paramObject.qoy;
      ((a)localObject4).qoz = paramObject.ij;
      ((a)localObject4).position = paramObject.position;
      c.a((a)localObject4, (Map)localObject2);
      paramObject = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.qoc;
      k.h(localObject4, "clickFeed");
      paramObject = new gl();
      paramObject.nJ(((a)localObject4).sessionId);
      paramObject.nK(((a)localObject4).qop);
      paramObject.iw(((a)localObject4).scene);
      paramObject.lf(((a)localObject4).qoq);
      paramObject.lg(((a)localObject4).qor);
      float f2;
      if (((a)localObject4).qos <= 0.0F)
      {
        f1 = 100.0F;
        localObject1 = z.KUT;
        localObject1 = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        k.g(localObject1, "java.lang.String.format(format, *args)");
        paramObject.nL((String)localObject1);
        if (((a)localObject4).qot > 0.0F) {
          break label896;
        }
        f1 = ((a)localObject4).width;
        f2 = ((a)localObject4).height;
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
      }
      label896:
      for (float f1 = f1 * f2 * 100.0F / com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjG();; f1 = ((a)localObject4).qot)
      {
        localObject1 = z.KUT;
        localObject1 = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        k.g(localObject1, "java.lang.String.format(format, *args)");
        paramObject.nM((String)localObject1);
        paramObject.ix(((a)localObject4).qou);
        paramObject.iy(((a)localObject4).qov);
        paramObject.nN(com.tencent.mm.plugin.expt.hellhound.core.b.aac(((a)localObject4).qow));
        paramObject.nO(((a)localObject4).qox);
        paramObject.nP(((a)localObject4).qoy);
        paramObject.iz(((a)localObject4).qoz);
        h.JZN.aV((Runnable)new a.a.c(paramObject, (a)localObject4));
        AppMethodBeat.o(195532);
        return;
        f1 = ((a)localObject4).qos;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.c
 * JD-Core Version:    0.7.0.1
 */