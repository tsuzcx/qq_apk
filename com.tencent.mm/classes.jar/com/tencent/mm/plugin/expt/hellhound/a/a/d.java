package com.tencent.mm.plugin.expt.hellhound.a.a;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.a.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellSpeedChecker;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingStagety;", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "pageName", "", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;Ljava/lang/String;)V", "BaseViewHolder_Class", "Ljava/lang/Class;", "Id_Field", "Ljava/lang/reflect/Field;", "MAX_SCROLL_SPEED", "", "TAG", "VALIDATE_DISTANCE", "", "getCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "getTimeLineMethod", "Ljava/lang/reflect/Method;", "idField", "mFeedLastScrollY", "mFirstVisibleItem", "mLastFeedId", "mLastTimestamp", "mScrollState", "mSpeedOfScroll", "mVisibleItemCount", "getPageName", "()Ljava/lang/String;", "timeLineObject_Field", "_getBottomFeedView", "Landroid/view/View;", "listView", "Landroid/widget/AbsListView;", "visibleItemCount", "_monitorOneScreen", "", "firstPos", "_speedOk", "", "computeDistance", "getFeedId1", "view", "getFeedId2", "getFeedIdChat", "getFeedIdSns", "bottomView", "getY", "initChat", "initSns", "sendOnScroll", "firstVisibleItem", "sendOnScrollStateChanged", "scrollState", "plugin-expt_release"})
public final class d
  implements f
{
  private final String TAG;
  private final String dMl;
  private int mScrollState;
  private int mVisibleItemCount;
  private long sBA;
  private String sBB;
  private final long sBO;
  private Class<?> sBP;
  private Field sBQ;
  private Field sBR;
  private Method sBS;
  private Field sBT;
  private final e sBU;
  private int sBg;
  private int sBv;
  private int sBy;
  private long sBz;
  
  public d(e parame, String paramString)
  {
    AppMethodBeat.i(220796);
    this.sBU = parame;
    this.dMl = paramString;
    this.TAG = "HABBYGE-MALI.HellSpeedChecker";
    this.sBO = 1000L;
    this.sBy = -1;
    this.sBA = -1L;
    this.sBB = "";
    this.sBv = -1;
    this.sBv = -1;
    this.mVisibleItemCount = 0;
    do
    {
      do
      {
        try
        {
          parame = ViewConfiguration.get(MMApplicationContext.getContext());
          p.g(parame, "ViewConfiguration.get(MM…tionContext.getContext())");
          this.sBg = parame.getScaledTouchSlop();
          parame = this.dMl;
          if (parame == null)
          {
            AppMethodBeat.o(220796);
            return;
          }
        }
        catch (Exception parame)
        {
          for (;;)
          {
            Log.printErrStackTrace(this.TAG, (Throwable)parame, "init crash: %s", new Object[] { parame.getMessage() });
          }
          switch (parame.hashCode())
          {
          default: 
            AppMethodBeat.o(220796);
            return;
          }
        }
      } while (!parame.equals("ChattingUIFragment"));
      AppMethodBeat.o(220796);
      return;
    } while (!parame.equals("SnsTimelineUI"));
    for (;;)
    {
      try
      {
        this.sBP = Class.forName("com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$BaseViewHolder");
        parame = this.sBP;
        if (parame == null) {
          continue;
        }
        parame = parame.getDeclaredField("timeLineObject");
        this.sBQ = parame;
        parame = this.sBQ;
        if (parame != null) {
          parame.setAccessible(true);
        }
        parame = Class.forName("com.tencent.mm.protocal.protobuf.TimeLineObject");
        p.g(parame, "Class.forName(\"com.tence…protobuf.TimeLineObject\")");
        this.sBR = parame.getDeclaredField("Id");
        parame = this.sBR;
        if (parame != null) {
          parame.setAccessible(true);
        }
      }
      catch (Exception parame)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)parame, "initSns crash-1: %s", new Object[] { parame.getMessage() });
        continue;
        AppMethodBeat.o(220796);
      }
      try
      {
        parame = Class.forName("com.tencent.mm.plugin.sns.storage.SnsInfo");
        p.g(parame, "Class.forName(\"com.tence…gin.sns.storage.SnsInfo\")");
        this.sBS = parame.getDeclaredMethod("getTimeLine", new Class[0]);
        parame = this.sBS;
        if (parame != null) {
          parame.setAccessible(true);
        }
        parame = Class.forName("com.tencent.mm.protocal.protobuf.TimeLineObject");
        p.g(parame, "Class.forName(\"com.tence…protobuf.TimeLineObject\")");
        this.sBT = parame.getDeclaredField("Id");
        parame = this.sBT;
        if (parame == null) {
          continue;
        }
        parame.setAccessible(true);
        AppMethodBeat.o(220796);
        return;
      }
      catch (Exception parame)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)parame, "initSns crash-2: %s", new Object[] { parame.getMessage() });
      }
      break;
      parame = null;
    }
  }
  
  private final String dO(View paramView)
  {
    AppMethodBeat.i(220794);
    if (this.sBP == null)
    {
      AppMethodBeat.o(220794);
      return null;
    }
    if (paramView.getTag() == null)
    {
      AppMethodBeat.o(220794);
      return null;
    }
    try
    {
      localObject = this.sBP;
      if (localObject == null) {
        p.hyc();
      }
      if (!((Class)localObject).isInstance(paramView.getTag()))
      {
        AppMethodBeat.o(220794);
        return null;
      }
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(220794);
      return null;
    }
    Object localObject = this.sBQ;
    if (localObject != null)
    {
      paramView = ((Field)localObject).get(paramView.getTag());
      if (paramView != null) {}
    }
    else
    {
      AppMethodBeat.o(220794);
      return null;
    }
    try
    {
      localObject = this.sBR;
      if (localObject != null)
      {
        localObject = ((Field)localObject).get(paramView);
        if (localObject != null) {}
      }
      else
      {
        AppMethodBeat.o(220794);
        return null;
      }
    }
    catch (Exception paramView)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramView, "getFeedId1: %s", new Object[] { paramView.getMessage() });
      paramView = null;
    }
    for (;;)
    {
      AppMethodBeat.o(220794);
      return paramView;
      paramView = (View)localObject;
      if (!(localObject instanceof String)) {
        paramView = null;
      }
      paramView = (String)paramView;
    }
  }
  
  private static int getY(View paramView)
  {
    AppMethodBeat.i(220795);
    int[] arrayOfInt = new int[2];
    int i = 0;
    while (i < 2)
    {
      arrayOfInt[i] = -1;
      i += 1;
    }
    paramView.getLocationOnScreen(arrayOfInt);
    i = arrayOfInt[1];
    AppMethodBeat.o(220795);
    return i;
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(220792);
    if (paramAbsListView == null)
    {
      AppMethodBeat.o(220792);
      return;
    }
    this.mScrollState = paramInt;
    switch (paramInt)
    {
    }
    e locale;
    do
    {
      AppMethodBeat.o(220792);
      return;
      locale = this.sBU;
    } while (locale == null);
    locale.b(paramAbsListView, this.sBv, this.mVisibleItemCount);
    AppMethodBeat.o(220792);
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220793);
    if (paramAbsListView == null)
    {
      AppMethodBeat.o(220793);
      return;
    }
    this.sBv = paramInt1;
    this.mVisibleItemCount = paramInt2;
    int i;
    Object localObject1;
    Object localObject2;
    label142:
    label159:
    Object localObject3;
    if (this.mScrollState == 0)
    {
      this.sBz = 0L;
      i = 1;
      if (i != 0)
      {
        localObject1 = this.sBU;
        if (localObject1 != null)
        {
          ((e)localObject1).c(paramAbsListView, paramInt1, paramInt2);
          AppMethodBeat.o(220793);
        }
      }
    }
    else
    {
      localObject1 = null;
      i = paramInt2 - 1;
      for (;;)
      {
        localObject2 = localObject1;
        if (i < 0) {
          break;
        }
        localObject2 = paramAbsListView.getChildAt(i);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition());
        }
        localObject2 = localObject1;
        if (localObject1 != null) {
          break;
        }
        i -= 1;
      }
      if (localObject2 == null) {}
      label321:
      for (;;)
      {
        i = 0;
        break;
        localObject1 = this.dMl;
        if (localObject1 == null) {}
        do
        {
          for (;;)
          {
            i = 0;
            break;
            switch (((String)localObject1).hashCode())
            {
            }
          }
        } while (!((String)localObject1).equals("ChattingUIFragment"));
        localObject3 = (ListAdapter)paramAbsListView.getAdapter();
        if (localObject3 != null) {
          break label478;
        }
        localObject1 = null;
        label226:
        if (localObject1 != null)
        {
          localObject3 = localObject1;
          do
          {
            if (!(p.j(localObject3, this.sBB) ^ true)) {
              break label567;
            }
            this.sBy = getY((View)localObject2);
            this.sBA = System.currentTimeMillis();
            this.sBB = ((String)localObject3);
            i = 1;
            break;
            if (!((String)localObject1).equals("SnsTimelineUI")) {
              break label159;
            }
            localObject3 = dO((View)localObject2);
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              localObject3 = (ListAdapter)paramAbsListView.getAdapter();
              if (localObject3 != null) {
                break label333;
              }
              localObject1 = null;
            }
            localObject3 = localObject1;
          } while (localObject1 != null);
        }
      }
      label333:
      i = paramInt1 + paramInt2 - 1;
      if (i < ((ListAdapter)localObject3).getCount())
      {
        localObject1 = ((ListAdapter)localObject3).getItem(i);
        if (localObject1 != null) {
          break label697;
        }
      }
      localObject1 = ((ListAdapter)localObject3).getItem(paramAbsListView.getLastVisiblePosition());
    }
    label567:
    label697:
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject1 = null;
        break label321;
      }
      localObject3 = this.sBS;
      if (localObject3 != null)
      {
        localObject1 = ((Method)localObject3).invoke(localObject1, new Object[0]);
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = null;
        break label321;
      }
      localObject3 = this.sBT;
      if (localObject3 != null) {}
      for (localObject1 = ((Field)localObject3).get(localObject1);; localObject1 = null)
      {
        localObject3 = localObject1;
        if (!(localObject1 instanceof String)) {
          localObject3 = null;
        }
        localObject1 = (String)localObject3;
        break;
      }
      label478:
      i = paramInt1 + paramInt2 - 1;
      if (i < ((ListAdapter)localObject3).getCount())
      {
        localObject1 = ((ListAdapter)localObject3).getItem(i);
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = ((ListAdapter)localObject3).getItem(paramAbsListView.getLastVisiblePosition());
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          localObject1 = null;
          break label226;
        }
        if (!(localObject1 instanceof ca))
        {
          localObject1 = null;
          break label226;
        }
        localObject1 = String.valueOf(((ca)localObject1).ajL());
        break label226;
        i = getY((View)localObject2);
        int j = Math.abs(i - this.sBy);
        long l1 = System.currentTimeMillis();
        long l2 = l1 - this.sBA;
        if ((l2 <= 0L) || (j <= this.sBg)) {
          break label142;
        }
        this.sBz = (j * 1000L / l2);
        this.sBy = i;
        this.sBA = l1;
        if (this.sBz <= this.sBO) {}
        for (i = 1;; i = 0)
        {
          if ((i == 0) && (this.mScrollState != 0)) {
            break label681;
          }
          i = 1;
          break;
        }
        i = 0;
        break;
        AppMethodBeat.o(220793);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.d
 * JD-Core Version:    0.7.0.1
 */