package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.view.View;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.in;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.d;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.g.b.z;
import d.l;
import d.v;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "", "flowStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;)V", "feedObject_Field", "Ljava/lang/reflect/Field;", "getFlowStatistics", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1;", "fillShotScreenJson", "", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "feedMap", "", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "getFeed", "position", "", "feedId", "getListener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "Companion", "plugin-expt_release"})
public final class c
{
  public static final a KIm;
  private Method KHc;
  private Field KIj;
  public final b KIk;
  final j KIl;
  private Field pFR;
  
  static
  {
    AppMethodBeat.i(205276);
    KIm = new a((byte)0);
    AppMethodBeat.o(205276);
  }
  
  public c(j paramj)
  {
    AppMethodBeat.i(205275);
    this.KIl = paramj;
    try
    {
      paramj = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
      k.g(paramj, "BaseFinderFeed_Class.get…redField(feedObject_Name)");
      this.pFR = paramj;
      paramj = this.pFR;
      if (paramj == null) {
        k.aPZ("feedObject_Field");
      }
      paramj.setAccessible(true);
      paramj = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem").getDeclaredMethod("getFinderObject", new Class[0]);
      k.g(paramj, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
      this.KHc = paramj;
      paramj = this.KHc;
      if (paramj == null) {
        k.aPZ("getFinderObject_Method");
      }
      paramj.setAccessible(true);
      paramj = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject").getDeclaredField("id");
      k.g(paramj, "FinderObject_Class.getDeclaredField(id_Name)");
      this.KIj = paramj;
      paramj = this.KIj;
      if (paramj == null) {
        k.aPZ("id_Field");
      }
      paramj.setAccessible(true);
    }
    catch (Exception paramj)
    {
      for (;;)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)paramj, "init crash: " + paramj.getMessage(), new Object[0]);
      }
    }
    this.KIk = new b(this);
    AppMethodBeat.o(205275);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "getFeedIdWithBaseFinderFeedType", "", "obj", "", "onFeedClick", "", "position", "", "plugin-expt_release"})
  public static final class b
    implements d
  {
    private final String ge(Object paramObject)
    {
      AppMethodBeat.i(205274);
      if (paramObject == null)
      {
        AppMethodBeat.o(205274);
        return null;
      }
      try
      {
        paramObject = c.a(this.KIn).get(paramObject);
        paramObject = c.b(this.KIn).invoke(paramObject, new Object[0]);
        paramObject = c.c(this.KIn).get(paramObject);
        if (paramObject == null)
        {
          paramObject = new v("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(205274);
          throw paramObject;
        }
      }
      catch (Exception paramObject)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)paramObject, "getFeedIdWithBaseFinderFeedType crash: " + paramObject.getMessage(), new Object[0]);
        AppMethodBeat.o(205274);
        return null;
      }
      paramObject = com.tencent.mm.plugin.expt.hellhound.core.b.ly(((Long)paramObject).longValue());
      AppMethodBeat.o(205274);
      return paramObject;
    }
    
    public final void m(Object paramObject, int paramInt)
    {
      Object localObject3 = null;
      Object localObject2 = null;
      AppMethodBeat.i(205273);
      Object localObject4 = new StringBuilder("onFeedClick: obj=");
      Object localObject1;
      long l;
      if (paramObject != null)
      {
        localObject1 = paramObject.getClass();
        if (localObject1 != null)
        {
          localObject1 = ((Class)localObject1).getName();
          ad.i("HABBYGE-MALI.FinderClickStatistics", (String)localObject1 + ", pos=" + paramInt);
          l = System.currentTimeMillis();
          localObject4 = new a((byte)0);
          if (!(paramObject instanceof View)) {
            break label321;
          }
          localObject3 = this.KIn.KIl;
          paramObject = (View)paramObject;
          k.h(paramObject, "feedView");
          localObject1 = ((j)localObject3).pFp;
          if (localObject1 == null) {
            break label265;
          }
          localObject1 = ((com.tencent.mm.plugin.expt.hellhound.a.a.a.b)localObject1).ab(paramObject, paramInt);
          label133:
          ad.w("HABBYGE-MALI.WaterfallsFlowStatistics", "getFeedWhenClick, getFeed=".concat(String.valueOf(localObject1)));
          if (localObject1 != null) {
            break label271;
          }
          localObject1 = localObject2;
          label157:
          localObject3 = this.KIn.KIl.fRQ();
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
                ad.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-0-1");
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
        ad.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)new NullPointerException("onFeedClick, wtf, feed is null !!!"), "", new Object[0]);
        AppMethodBeat.o(205273);
        return;
        localObject1 = null;
        break;
        label265:
        localObject1 = null;
        break label133;
        label271:
        localObject2 = (i)((j)localObject3).KIF.get(localObject1);
        paramObject = localObject2;
        if (localObject2 == null)
        {
          ((j)localObject3).Bp(l);
          paramObject = (i)((j)localObject3).KIF.get(localObject1);
        }
        localObject1 = paramObject;
        break label157;
        label321:
        localObject1 = this.KIn.KIl.fRQ();
        paramObject = ge(paramObject);
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
              ad.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-1-1");
              localObject2 = localObject1;
              paramObject = localObject3;
            }
          }
        }
        else
        {
          localObject3 = c.S(paramObject, (Map)localObject1);
          localObject2 = localObject1;
          paramObject = localObject3;
          if (localObject3 == null)
          {
            ad.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-1-2");
            localObject2 = localObject1;
            paramObject = localObject3;
          }
        }
      }
      label428:
      ((a)localObject4).width = paramObject.width;
      ((a)localObject4).height = paramObject.height;
      ((a)localObject4).sessionId = paramObject.sessionId;
      ((a)localObject4).KHY = paramObject.feedId;
      ((a)localObject4).bNK = paramObject.bNK;
      ((a)localObject4).scene = paramObject.scene;
      ((a)localObject4).KHZ = paramObject.KHZ;
      ((a)localObject4).KIa = l;
      ((a)localObject4).KIb = paramObject.KIb;
      ((a)localObject4).KIc = paramObject.KIc;
      ((a)localObject4).KId = paramObject.KIE;
      ((a)localObject4).KIe = paramObject.KIh;
      ((a)localObject4).qwV = paramObject.qwV;
      ((a)localObject4).KIg = paramObject.KIg;
      ((a)localObject4).KIh = paramObject.hj;
      ((a)localObject4).position = paramObject.position;
      c.a((a)localObject4, (Map)localObject2);
      paramObject = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.KHO;
      k.h(localObject4, "clickFeed");
      paramObject = new in();
      paramObject.aTE(((a)localObject4).sessionId);
      paramObject.aTF(((a)localObject4).KHY);
      paramObject.uN(((a)localObject4).scene);
      paramObject.AV(((a)localObject4).KHZ);
      paramObject.AW(((a)localObject4).KIa);
      float f2;
      if (((a)localObject4).KIb <= 0.0F)
      {
        f1 = 100.0F;
        localObject1 = z.Jhz;
        localObject1 = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        k.g(localObject1, "java.lang.String.format(format, *args)");
        paramObject.aTG((String)localObject1);
        if (((a)localObject4).KIc > 0.0F) {
          break label896;
        }
        f1 = ((a)localObject4).width;
        f2 = ((a)localObject4).height;
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
      }
      label896:
      for (float f1 = f1 * f2 * 100.0F / com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRz();; f1 = ((a)localObject4).KIc)
      {
        localObject1 = z.Jhz;
        localObject1 = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        k.g(localObject1, "java.lang.String.format(format, *args)");
        paramObject.aTH((String)localObject1);
        paramObject.uO(((a)localObject4).KId);
        paramObject.uP(((a)localObject4).KIe);
        paramObject.aTI(com.tencent.mm.plugin.expt.hellhound.core.b.aUQ(((a)localObject4).KIf));
        paramObject.aTJ(((a)localObject4).qwV);
        paramObject.aTK(((a)localObject4).KIg);
        paramObject.xK(((a)localObject4).KIh);
        h.Iye.aS((Runnable)new a.a.c(paramObject, (a)localObject4));
        AppMethodBeat.o(205273);
        return;
        f1 = ((a)localObject4).KIb;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.c
 * JD-Core Version:    0.7.0.1
 */