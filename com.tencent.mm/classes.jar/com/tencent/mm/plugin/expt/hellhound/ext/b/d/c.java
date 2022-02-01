package com.tencent.mm.plugin.expt.hellhound.ext.b.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.d;
import com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "", "flowStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;)V", "feedObject_Field", "Ljava/lang/reflect/Field;", "getFlowStatistics", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1;", "fillShotScreenJson", "", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "feedMap", "", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "getFeed", "position", "", "feedId", "getListener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a zIS;
  private Field zEc;
  private Method zHG;
  final j zIT;
  private Field zIU;
  public final b zIV;
  
  static
  {
    AppMethodBeat.i(300340);
    zIS = new c.a((byte)0);
    AppMethodBeat.o(300340);
  }
  
  public c(j paramj)
  {
    AppMethodBeat.i(300300);
    this.zIT = paramj;
    for (;;)
    {
      try
      {
        paramj = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
        s.s(paramj, "BaseFinderFeed_Class.get…redField(feedObject_Name)");
        this.zEc = paramj;
        Object localObject2 = this.zEc;
        paramj = (j)localObject2;
        if (localObject2 == null)
        {
          s.bIx("feedObject_Field");
          paramj = null;
        }
        paramj.setAccessible(true);
        paramj = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem").getDeclaredMethod("getFinderObject", new Class[0]);
        s.s(paramj, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
        this.zHG = paramj;
        localObject2 = this.zHG;
        paramj = (j)localObject2;
        if (localObject2 == null)
        {
          s.bIx("getFinderObject_Method");
          paramj = null;
        }
        paramj.setAccessible(true);
        paramj = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject").getDeclaredField("id");
        s.s(paramj, "FinderObject_Class.getDeclaredField(id_Name)");
        this.zIU = paramj;
        paramj = this.zIU;
        if (paramj != null) {
          continue;
        }
        s.bIx("id_Field");
        paramj = localObject1;
        paramj.setAccessible(true);
      }
      catch (Exception paramj)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)paramj, s.X("init crash: ", paramj.getMessage()), new Object[0]);
        continue;
      }
      this.zIV = new b(this);
      AppMethodBeat.o(300300);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "getFeedIdWithBaseFinderFeedType", "", "obj", "", "onFeedClick", "", "position", "", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements d
  {
    b(c paramc) {}
    
    private final String fe(Object paramObject)
    {
      AppMethodBeat.i(300366);
      if (paramObject == null)
      {
        AppMethodBeat.o(300366);
        return null;
      }
      try
      {
        Object localObject2 = c.a(this.zIW);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("feedObject_Field");
          localObject1 = null;
        }
        localObject2 = ((Field)localObject1).get(paramObject);
        localObject1 = c.b(this.zIW);
        paramObject = localObject1;
        if (localObject1 == null)
        {
          s.bIx("getFinderObject_Method");
          paramObject = null;
        }
        localObject2 = paramObject.invoke(localObject2, new Object[0]);
        localObject1 = c.c(this.zIW);
        paramObject = localObject1;
        if (localObject1 == null)
        {
          s.bIx("id_Field");
          paramObject = null;
        }
        paramObject = paramObject.get(localObject2);
        if (paramObject == null)
        {
          paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(300366);
          throw paramObject;
        }
      }
      catch (Exception paramObject)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)paramObject, s.X("getFeedIdWithBaseFinderFeedType crash: ", paramObject.getMessage()), new Object[0]);
        AppMethodBeat.o(300366);
        return null;
      }
      paramObject = com.tencent.mm.plugin.expt.hellhound.core.b.hF(((Long)paramObject).longValue());
      AppMethodBeat.o(300366);
      return paramObject;
    }
    
    public final void r(Object paramObject, int paramInt)
    {
      Object localObject3 = null;
      Object localObject2 = null;
      AppMethodBeat.i(300379);
      Object localObject4 = new StringBuilder("onFeedClick: obj=");
      Object localObject1;
      long l;
      if (paramObject == null)
      {
        localObject1 = null;
        Log.i("HABBYGE-MALI.FinderClickStatistics", localObject1 + ", pos=" + paramInt);
        l = System.currentTimeMillis();
        localObject4 = new a((byte)0);
        if (!(paramObject instanceof View)) {
          break label322;
        }
        localObject3 = this.zIW.zIT;
        paramObject = (View)paramObject;
        s.u(paramObject, "feedView");
        localObject1 = ((j)localObject3).zDk;
        if (localObject1 != null) {
          break label259;
        }
        localObject1 = null;
        label109:
        Log.w("HABBYGE-MALI.WaterfallsFlowStatistics", s.X("getFeedWhenClick, getFeed=", localObject1));
        if (localObject1 != null) {
          break label273;
        }
        localObject1 = localObject2;
        label130:
        localObject3 = this.zIW.zIT.dLe();
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
              Log.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-0-1");
              paramObject = localObject1;
              localObject2 = localObject3;
            }
          }
        }
      }
      for (;;)
      {
        if (paramObject != null) {
          break label429;
        }
        Log.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", (Throwable)new NullPointerException("onFeedClick, wtf, feed is null !!!"), "", new Object[0]);
        AppMethodBeat.o(300379);
        return;
        localObject1 = paramObject.getClass();
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = ((Class)localObject1).getName();
        break;
        label259:
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.ext.a.a.b)localObject1).aj(paramObject, paramInt);
        break label109;
        label273:
        localObject2 = (i)((j)localObject3).zJx.get(localObject1);
        paramObject = localObject2;
        if (localObject2 == null)
        {
          ((j)localObject3).ma(l);
          paramObject = (i)((j)localObject3).zJx.get(localObject1);
        }
        localObject1 = paramObject;
        break label130;
        label322:
        localObject1 = this.zIW.zIT.dLe();
        paramObject = fe(paramObject);
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
              Log.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-1-1");
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
            Log.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-1-2");
            localObject2 = localObject1;
            paramObject = localObject3;
          }
        }
      }
      label429:
      ((a)localObject4).width = paramObject.width;
      ((a)localObject4).height = paramObject.height;
      ((a)localObject4).sessionId = paramObject.sessionId;
      ((a)localObject4).zIG = paramObject.feedId;
      ((a)localObject4).nickName = paramObject.nickName;
      ((a)localObject4).scene = paramObject.scene;
      ((a)localObject4).zIH = paramObject.zIH;
      ((a)localObject4).zII = l;
      ((a)localObject4).zIJ = paramObject.zIJ;
      ((a)localObject4).zIK = paramObject.zIK;
      ((a)localObject4).zIL = paramObject.zJv;
      ((a)localObject4).zIM = paramObject.zIQ;
      ((a)localObject4).zIO = paramObject.zIO;
      ((a)localObject4).zIP = paramObject.zIP;
      ((a)localObject4).zIQ = paramObject.dpP;
      ((a)localObject4).position = paramObject.position;
      c.a((a)localObject4, (Map)localObject2);
      paramObject = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
      a.a.a((a)localObject4);
      AppMethodBeat.o(300379);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.d.c
 * JD-Core Version:    0.7.0.1
 */