package com.tencent.mm.plugin.expt.hellhound.ext.a;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.expt.hellhound.ext.a.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.cc;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellSpeedChecker;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingStagety;", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "pageName", "", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;Ljava/lang/String;)V", "BaseViewHolder_Class", "Ljava/lang/Class;", "Id_Field", "Ljava/lang/reflect/Field;", "MAX_SCROLL_SPEED", "", "TAG", "VALIDATE_DISTANCE", "", "getCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "getTimeLineMethod", "Ljava/lang/reflect/Method;", "idField", "mFeedLastScrollY", "mFirstVisibleItem", "mLastFeedId", "mLastTimestamp", "mScrollState", "mSpeedOfScroll", "mVisibleItemCount", "getPageName", "()Ljava/lang/String;", "timeLineObject_Field", "_getBottomFeedView", "Landroid/view/View;", "listView", "Landroid/widget/AbsListView;", "visibleItemCount", "_monitorOneScreen", "", "firstPos", "_speedOk", "", "computeDistance", "getFeedId1", "view", "getFeedId2", "getFeedIdChat", "getFeedIdSns", "bottomView", "getY", "initChat", "initSns", "sendOnScroll", "firstVisibleItem", "sendOnScrollStateChanged", "scrollState", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements e
{
  private final String TAG;
  private final String hJW;
  private int mScrollState;
  private int mVisibleItemCount;
  private final com.tencent.mm.plugin.expt.hellhound.ext.a.b.d zDM;
  private final long zDN;
  private Class<?> zDO;
  private Field zDP;
  private Field zDQ;
  private Method zDR;
  private Field zDS;
  private int zDc;
  private int zDr;
  private int zDu;
  private long zDv;
  private long zDw;
  private String zDx;
  
  public d(com.tencent.mm.plugin.expt.hellhound.ext.a.b.d paramd, String paramString)
  {
    AppMethodBeat.i(300134);
    this.zDM = paramd;
    this.hJW = paramString;
    this.TAG = "HABBYGE-MALI.HellSpeedChecker";
    this.zDN = 1000L;
    this.zDu = -1;
    this.zDw = -1L;
    this.zDx = "";
    this.zDr = -1;
    this.zDr = -1;
    this.mVisibleItemCount = 0;
    try
    {
      this.zDc = ViewConfiguration.get(MMApplicationContext.getContext()).getScaledTouchSlop();
      paramd = this.hJW;
      if (!s.p(paramd, "SnsTimelineUI")) {}
    }
    catch (Exception paramd)
    {
      for (;;)
      {
        try
        {
          this.zDO = Class.forName("com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$BaseViewHolder");
          paramd = this.zDO;
          if (paramd == null)
          {
            paramd = null;
            this.zDP = paramd;
            paramd = this.zDP;
            if (paramd != null) {
              paramd.setAccessible(true);
            }
            this.zDQ = Class.forName("com.tencent.mm.protocal.protobuf.TimeLineObject").getDeclaredField("Id");
            paramd = this.zDQ;
            if (paramd != null) {
              paramd.setAccessible(true);
            }
          }
        }
        catch (Exception paramd)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)paramd, "initSns crash-1: %s", new Object[] { paramd.getMessage() });
          continue;
        }
        try
        {
          this.zDR = Class.forName("com.tencent.mm.plugin.sns.storage.SnsInfo").getDeclaredMethod("getTimeLine", new Class[0]);
          paramd = this.zDR;
          if (paramd != null) {
            paramd.setAccessible(true);
          }
          this.zDS = Class.forName("com.tencent.mm.protocal.protobuf.TimeLineObject").getDeclaredField("Id");
          paramd = this.zDS;
          if (paramd == null) {
            break label316;
          }
          paramd.setAccessible(true);
          AppMethodBeat.o(300134);
          return;
        }
        catch (Exception paramd)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)paramd, "initSns crash-2: %s", new Object[] { paramd.getMessage() });
          AppMethodBeat.o(300134);
          return;
        }
        paramd = paramd;
        Log.printErrStackTrace(this.TAG, (Throwable)paramd, "init crash: %s", new Object[] { paramd.getMessage() });
        continue;
        paramd = paramd.getDeclaredField("timeLineObject");
      }
    }
    label316:
    s.p(paramd, "ChattingUIFragment");
    AppMethodBeat.o(300134);
  }
  
  private final String fg(View paramView)
  {
    AppMethodBeat.i(300141);
    if (this.zDO == null)
    {
      AppMethodBeat.o(300141);
      return null;
    }
    if (paramView.getTag() == null)
    {
      AppMethodBeat.o(300141);
      return null;
    }
    try
    {
      localObject = this.zDO;
      s.checkNotNull(localObject);
      if (!((Class)localObject).isInstance(paramView.getTag()))
      {
        AppMethodBeat.o(300141);
        return null;
      }
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(300141);
      return null;
    }
    Object localObject = this.zDP;
    if (localObject == null) {}
    for (paramView = null; paramView == null; paramView = ((Field)localObject).get(paramView.getTag()))
    {
      AppMethodBeat.o(300141);
      return null;
    }
    try
    {
      localObject = this.zDQ;
      if (localObject == null)
      {
        paramView = null;
        if (paramView != null) {
          break label167;
        }
        AppMethodBeat.o(300141);
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
      AppMethodBeat.o(300141);
      return paramView;
      paramView = ((Field)localObject).get(paramView);
      break;
      label167:
      if ((paramView instanceof String)) {
        paramView = (String)paramView;
      } else {
        paramView = null;
      }
    }
  }
  
  private static int getY(View paramView)
  {
    AppMethodBeat.i(300144);
    int i = 0;
    int[] arrayOfInt = new int[2];
    while (i < 2)
    {
      arrayOfInt[i] = -1;
      i += 1;
    }
    paramView.getLocationOnScreen(arrayOfInt);
    i = arrayOfInt[1];
    AppMethodBeat.o(300144);
    return i;
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(300148);
    if (paramAbsListView == null)
    {
      AppMethodBeat.o(300148);
      return;
    }
    this.mScrollState = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300148);
      return;
      com.tencent.mm.plugin.expt.hellhound.ext.a.b.d locald = this.zDM;
      if (locald != null) {
        locald.b(paramAbsListView, this.zDr, this.mVisibleItemCount);
      }
    }
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(300155);
    if (paramAbsListView == null)
    {
      AppMethodBeat.o(300155);
      return;
    }
    this.zDr = paramInt1;
    this.mVisibleItemCount = paramInt2;
    Object localObject1;
    if (this.mScrollState == 0)
    {
      this.zDv = 0L;
      i = 1;
      if (i != 0)
      {
        localObject1 = this.zDM;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.expt.hellhound.ext.a.b.d)localObject1).c(paramAbsListView, paramInt1, paramInt2);
        }
      }
      AppMethodBeat.o(300155);
      return;
    }
    int i = paramInt2 - 1;
    label85:
    int j;
    if (i >= 0)
    {
      j = i - 1;
      localObject2 = paramAbsListView.getChildAt(i);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition());
      }
      if ((localObject1 == null) && (j >= 0)) {}
    }
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      Object localObject3;
      if (localObject2 != null)
      {
        localObject1 = this.hJW;
        if (s.p(localObject1, "SnsTimelineUI"))
        {
          localObject3 = fg((View)localObject2);
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject3 = (ListAdapter)paramAbsListView.getAdapter();
            if (localObject3 == null) {
              break label362;
            }
            i = paramInt1 + paramInt2 - 1;
            if (i < ((ListAdapter)localObject3).getCount())
            {
              localObject1 = ((ListAdapter)localObject3).getItem(i);
              if (localObject1 != null) {
                break label628;
              }
            }
            localObject1 = ((ListAdapter)localObject3).getItem(paramAbsListView.getLastVisiblePosition());
          }
        }
      }
      label270:
      label285:
      label350:
      label362:
      label499:
      label628:
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject3 = this.zDR;
          if (localObject3 == null)
          {
            localObject1 = null;
            label251:
            if (localObject1 == null) {
              break label362;
            }
            localObject3 = this.zDS;
            if (localObject3 != null) {
              break label350;
            }
            localObject1 = null;
            if (!(localObject1 instanceof String)) {
              break label362;
            }
            localObject1 = (String)localObject1;
            if (localObject1 == null) {
              break label404;
            }
            localObject3 = localObject1;
          }
        }
        do
        {
          if (s.p(localObject3, this.zDx)) {
            break label505;
          }
          this.zDu = getY((View)localObject2);
          this.zDw = System.currentTimeMillis();
          this.zDx = ((String)localObject3);
          i = 1;
          break;
          localObject1 = ((Method)localObject3).invoke(localObject1, new Object[0]);
          break label251;
          localObject1 = ((Field)localObject3).get(localObject1);
          break label270;
          localObject1 = null;
          break label285;
          if (!s.p(localObject1, "ChattingUIFragment")) {
            break label499;
          }
          localObject3 = (ListAdapter)paramAbsListView.getAdapter();
          if (localObject3 != null) {
            break label410;
          }
          localObject1 = null;
          localObject3 = localObject1;
        } while (localObject1 != null);
        i = 0;
        break;
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
            break label395;
          }
          if (!(localObject1 instanceof cc))
          {
            localObject1 = null;
            break label395;
          }
          localObject1 = String.valueOf(((cc)localObject1).field_msgId);
          break label395;
          i = 0;
          break;
          label505:
          i = getY((View)localObject2);
          j = Math.abs(i - this.zDu);
          long l1 = System.currentTimeMillis();
          long l2 = l1 - this.zDw;
          if ((l2 <= 0L) || (j <= this.zDc)) {
            break label404;
          }
          this.zDv = (j * 1000L / l2);
          this.zDu = i;
          this.zDw = l1;
          if (this.zDv <= this.zDN) {}
          for (i = 1;; i = 0)
          {
            if ((i == 0) && (this.mScrollState != 0)) {
              break label619;
            }
            i = 1;
            break;
          }
          i = 0;
          break;
        }
      }
      label395:
      label404:
      label410:
      label619:
      i = j;
      break label85;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.a.d
 * JD-Core Version:    0.7.0.1
 */