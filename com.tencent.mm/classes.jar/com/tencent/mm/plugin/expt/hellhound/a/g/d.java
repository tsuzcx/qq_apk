package com.tencent.mm.plugin.expt.hellhound.a.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ejv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/SnsFeedMonitor;", "", "()V", "AdSnsInfoClassName", "", "IdName", "SnsInfoClassName", "TAG", "TimeLineObjectClassName", "UserNameName", "adCardActionBtnInfoField", "Ljava/lang/reflect/Field;", "adsnsinfoField", "adsnsinfoName", "finderLiveFeedExportIdField", "finderLiveIdField", "finderUsernameField", "getAdXmlMethod", "Ljava/lang/reflect/Method;", "getAdXmlMethodName", "getTimeLineMethod", "getTimeLineMethodName", "idField", "listeners", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/ISnsFeedListener;", "Lkotlin/collections/ArrayList;", "mActionBarHeight", "", "mFirstPostion", "mScreenHeight", "mScreenRealHeight", "mSnsFeedCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "Lkotlin/collections/HashMap;", "mStatusBarHeight", "mVisibleItemCount", "userNameField", "virtualKeyHeight", "_getHellFeed", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "feedView", "Landroid/view/View;", "position", "listView", "Landroid/widget/AbsListView;", "firstPos", "_getUIParams", "view", "getY", "init", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "initActionBarHeight", "Landroid/app/Activity;", "initScreenHeight", "initStatusBarHeight", "monitor", "adapter", "Landroid/widget/BaseAdapter;", "firstPostion", "visibleItemCount", "onFeedAppear", "feed", "onFeedDisappear", "registerListener", "listener", "resetCache", "unregisterListener", "plugin-expt_release"})
public final class d
{
  public static final ArrayList<a> listeners;
  public static int mActionBarHeight;
  public static int mFirstPostion;
  public static int mScreenHeight;
  public static int mScreenRealHeight;
  public static int mStatusBarHeight;
  public static int mVisibleItemCount;
  public static int virtualKeyHeight;
  private static Method whN;
  private static Field whO;
  public static final HashMap<String, com.tencent.mm.plugin.expt.hellhound.a.a.c> wph;
  private static Field wpi;
  private static Field wpj;
  private static Method wpk;
  private static Field wpl;
  private static Field wpm;
  private static Field wpn;
  private static Field wpo;
  public static final d wpp;
  
  static
  {
    AppMethodBeat.i(253284);
    wpp = new d();
    listeners = new ArrayList();
    wph = new HashMap();
    mFirstPostion = -1;
    mVisibleItemCount = -1;
    try
    {
      Object localObject1 = Class.forName("com.tencent.mm.plugin.sns.storage.SnsInfo");
      p.j(localObject1, "Class.forName(SnsInfoClassName)");
      Object localObject2 = ((Class)localObject1).getDeclaredMethod("getTimeLine", new Class[0]);
      whN = (Method)localObject2;
      if (localObject2 != null) {
        ((Method)localObject2).setAccessible(true);
      }
      localObject2 = Class.forName("com.tencent.mm.protocal.protobuf.TimeLineObject");
      p.j(localObject2, "Class.forName(TimeLineObjectClassName)");
      Field localField = ((Class)localObject2).getDeclaredField("Id");
      whO = localField;
      if (localField != null) {
        localField.setAccessible(true);
      }
      localObject2 = ((Class)localObject2).getDeclaredField("UserName");
      wpi = (Field)localObject2;
      if (localObject2 != null) {
        ((Field)localObject2).setAccessible(true);
      }
      localObject1 = ((Class)localObject1).getDeclaredField("adsnsinfo");
      wpj = (Field)localObject1;
      if (localObject1 != null) {
        ((Field)localObject1).setAccessible(true);
      }
      localObject1 = Class.forName("com.tencent.mm.plugin.sns.storage.AdSnsInfo");
      p.j(localObject1, "Class.forName(AdSnsInfoClassName)");
      localObject1 = ((Class)localObject1).getDeclaredMethod("getAdXml", new Class[0]);
      wpk = (Method)localObject1;
      if (localObject1 != null) {
        ((Method)localObject1).setAccessible(true);
      }
      localObject1 = Class.forName("com.tencent.mm.plugin.sns.storage.ADXml");
      p.j(localObject1, "Class.forName(\"com.tence…lugin.sns.storage.ADXml\")");
      localObject1 = ((Class)localObject1).getDeclaredField("adCardActionBtnInfo");
      wpl = (Field)localObject1;
      if (localObject1 != null) {
        ((Field)localObject1).setAccessible(true);
      }
      localObject1 = Class.forName("com.tencent.mm.plugin.sns.storage.ADXml$AdCardActionBtnInfo");
      p.j(localObject1, "Class.forName(\"com.tence…ml\\$AdCardActionBtnInfo\")");
      localObject2 = ((Class)localObject1).getDeclaredField("finderUsername");
      wpm = (Field)localObject2;
      if (localObject2 != null) {
        ((Field)localObject2).setAccessible(true);
      }
      localObject2 = ((Class)localObject1).getDeclaredField("finderLiveId");
      wpn = (Field)localObject2;
      if (localObject2 != null) {
        ((Field)localObject2).setAccessible(true);
      }
      localObject1 = ((Class)localObject1).getDeclaredField("finderLiveFeedExportId");
      wpo = (Field)localObject1;
      if (localObject1 != null)
      {
        ((Field)localObject1).setAccessible(true);
        AppMethodBeat.o(253284);
        return;
      }
      AppMethodBeat.o(253284);
      return;
    }
    catch (Exception localException)
    {
      Log.e("HABBYGE-MALI.SnsFeedMonitor", "SnsFeedMonitor, init-1, crash: " + localException.getMessage());
      AppMethodBeat.o(253284);
    }
  }
  
  public static com.tencent.mm.vending.j.c<com.tencent.mm.plugin.expt.hellhound.a.a.c, Boolean> _getHellFeed(View paramView, int paramInt1, AbsListView paramAbsListView, int paramInt2)
  {
    AppMethodBeat.i(253274);
    if ((ListAdapter)paramAbsListView.getAdapter() == null)
    {
      AppMethodBeat.o(253274);
      return null;
    }
    int i = paramInt2 + paramInt1;
    localObject1 = (ListAdapter)paramAbsListView.getAdapter();
    p.j(localObject1, "listView.adapter");
    if (i >= ((ListAdapter)localObject1).getCount())
    {
      AppMethodBeat.o(253274);
      return null;
    }
    Object localObject3 = ((ListAdapter)paramAbsListView.getAdapter()).getItem(i);
    if (localObject3 == null)
    {
      AppMethodBeat.o(253274);
      return null;
    }
    localObject1 = new int[2];
    paramInt2 = 0;
    while (paramInt2 < 2)
    {
      localObject1[paramInt2] = -1;
      paramInt2 += 1;
    }
    paramView.getLocationOnScreen((int[])localObject1);
    paramView = com.tencent.mm.vending.j.a.J(Integer.valueOf(Math.min(localObject1[1], (int)paramView.getY())), Integer.valueOf(paramView.getHeight()));
    p.j(paramView, "Tuple.make(y, view.height)");
    Integer localInteger1 = (Integer)paramView.ieT();
    Integer localInteger2 = (Integer)paramView.ieU();
    com.tencent.mm.plugin.expt.hellhound.a.a.c localc = new com.tencent.mm.plugin.expt.hellhound.a.a.c();
    localc.whE = new ejv();
    for (;;)
    {
      try
      {
        paramView = whN;
        if (paramView != null)
        {
          localObject1 = paramView.invoke(localObject3, new Object[0]);
          ejv localejv = localc.whE;
          paramView = whO;
          if (paramView == null) {
            continue;
          }
          paramView = paramView.get(localObject1);
          localObject2 = paramView;
          if (!(paramView instanceof String)) {
            localObject2 = null;
          }
          localObject2 = (String)localObject2;
          paramView = (View)localObject2;
          if (localObject2 == null) {
            paramView = "";
          }
          localejv.feedId = paramView;
          localObject2 = localc.whE;
          paramView = wpi;
          if (paramView == null) {
            continue;
          }
          paramView = paramView.get(localObject1);
          localObject1 = paramView;
          if (!(paramView instanceof String)) {
            localObject1 = null;
          }
          localObject1 = (String)localObject1;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          ((ejv)localObject2).userName = paramView;
        }
      }
      catch (Exception paramView)
      {
        Log.e("HABBYGE-MALI.SnsFeedMonitor", "_getHellFeed, crash: " + paramView.getMessage());
        continue;
        paramView = null;
        continue;
        paramView = null;
        continue;
        localObject1 = null;
        continue;
        paramView = null;
        continue;
        paramView = null;
        continue;
        paramView = null;
        continue;
        bool = false;
        continue;
        bool = false;
        continue;
      }
      try
      {
        paramView = wpj;
        if (paramView == null) {
          continue;
        }
        paramView = paramView.get(localObject3);
        if (paramView == null) {
          continue;
        }
        localObject1 = wpk;
        if (localObject1 == null) {
          continue;
        }
        paramView = ((Method)localObject1).invoke(paramView, new Object[0]);
        if (paramView == null) {
          continue;
        }
        localObject1 = wpl;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((Field)localObject1).get(paramView);
        if (localObject1 == null) {
          continue;
        }
        paramView = wpm;
        if (paramView == null) {
          continue;
        }
        paramView = paramView.get(localObject1);
        localObject2 = paramView;
        if (!(paramView instanceof String)) {
          localObject2 = null;
        }
        localObject2 = (String)localObject2;
        paramView = (View)localObject2;
        if (localObject2 == null) {
          paramView = "";
        }
        localc.whH = paramView;
        paramView = wpn;
        if (paramView == null) {
          continue;
        }
        paramView = paramView.get(localObject1);
        localObject2 = paramView;
        if (!(paramView instanceof String)) {
          localObject2 = null;
        }
        localObject2 = (String)localObject2;
        if (localObject2 != null) {
          break label881;
        }
        paramView = "";
      }
      catch (Exception paramView)
      {
        bool = false;
        Log.e("HABBYGE-MALI.SnsFeedMonitor", "_getHellFeed, crash-2: " + paramView.getMessage());
        continue;
        paramInt2 = mActionBarHeight;
        continue;
        paramView = (View)localObject2;
        continue;
      }
      localc.finderLiveId = paramView;
      localc.kwM = localc.finderLiveId;
      paramView = wpo;
      if (paramView == null) {
        continue;
      }
      paramView = paramView.get(localObject1);
      localObject1 = paramView;
      if (!(paramView instanceof String)) {
        localObject1 = null;
      }
      localc.whI = ((String)localObject1);
      bool = p.h(localObject2, "");
      if ((!(bool ^ true)) || (localObject2 == null)) {
        continue;
      }
      bool = true;
      localc.whG = bool;
      if (TextUtils.isEmpty((CharSequence)localc.whE.feedId)) {
        localc.whE.feedId = String.valueOf(paramAbsListView.getItemIdAtPosition(i));
      }
      paramView = localc.whE;
      p.j(localInteger1, "y");
      paramView.y = localInteger1.intValue();
      paramView = localc.whE;
      p.j(localInteger2, "height");
      paramView.height = localInteger2.intValue();
      localc.whE.pEk = mScreenRealHeight;
      localc.whE.virtualKeyHeight = (mScreenRealHeight - mScreenHeight);
      localc.whE.INC = mStatusBarHeight;
      paramView = localc.whE;
      if (mActionBarHeight > 0) {
        break label874;
      }
      paramInt2 = 144;
      paramView.xRu = paramInt2;
      localc.position = i;
      localc.whF = paramInt1;
      paramView = com.tencent.mm.vending.j.a.J(localc, Boolean.valueOf(localc.bVd()));
      AppMethodBeat.o(253274);
      return paramView;
      localObject1 = null;
      continue;
      paramView = null;
      continue;
      paramView = null;
    }
  }
  
  public static void dfP()
  {
    AppMethodBeat.i(253277);
    Iterator localIterator = listeners.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(253277);
  }
  
  public static void initActionBarHeight(Activity paramActivity)
  {
    AppMethodBeat.i(253280);
    if (paramActivity == null)
    {
      AppMethodBeat.o(253280);
      return;
    }
    try
    {
      if ((paramActivity instanceof AppCompatActivity))
      {
        paramActivity = ((AppCompatActivity)paramActivity).getSupportActionBar();
        if (paramActivity != null)
        {
          paramActivity = paramActivity.getCustomView();
          if (paramActivity == null) {
            break label66;
          }
        }
        label66:
        for (int i = paramActivity.getHeight();; i = -1)
        {
          mActionBarHeight = i;
          AppMethodBeat.o(253280);
          return;
          paramActivity = null;
          break;
        }
      }
      return;
    }
    catch (Exception paramActivity)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SnsFeedMonitor", (Throwable)paramActivity, "initBarHeight", new Object[0]);
      AppMethodBeat.o(253280);
    }
  }
  
  @SuppressLint({"ObsoleteSdkInt"})
  public static void initScreenHeight(Activity paramActivity)
  {
    Point localPoint = null;
    AppMethodBeat.i(253282);
    if (paramActivity == null)
    {
      AppMethodBeat.o(253282);
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = MMApplicationContext.getContext().getSystemService("window");
        Object localObject1 = localObject3;
        if (!(localObject3 instanceof WindowManager)) {
          localObject1 = null;
        }
        localObject1 = (WindowManager)localObject1;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
        paramActivity = (Activity)localObject1;
      }
      catch (Exception localException)
      {
        localObject2 = paramActivity.getWindowManager();
        paramActivity = localPoint;
        if (localObject2 == null) {
          continue;
        }
        paramActivity = ((WindowManager)localObject2).getDefaultDisplay();
        continue;
        localObject2 = new Point();
        if (Build.VERSION.SDK_INT < 13) {
          continue;
        }
        paramActivity.getSize((Point)localObject2);
        localPoint = new Point();
        if (Build.VERSION.SDK_INT < 17) {
          continue;
        }
        paramActivity.getRealSize(localPoint);
        mScreenHeight = ((Point)localObject2).y;
        i = localPoint.y;
        mScreenRealHeight = i;
        i -= mScreenHeight;
        if (i <= 0) {
          break label178;
        }
      }
      if (paramActivity != null) {
        continue;
      }
      AppMethodBeat.o(253282);
      return;
      paramActivity = null;
    }
    for (;;)
    {
      Object localObject2;
      virtualKeyHeight = i;
      AppMethodBeat.o(253282);
      return;
      label178:
      int i = 0;
    }
  }
  
  public static void onFeedAppear(BaseAdapter paramBaseAdapter, com.tencent.mm.plugin.expt.hellhound.a.a.c paramc, View paramView)
  {
    AppMethodBeat.i(253276);
    Iterator localIterator = listeners.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramBaseAdapter, paramc, paramView);
    }
    AppMethodBeat.o(253276);
  }
  
  public static void registerListener(a parama)
  {
    AppMethodBeat.i(253275);
    if (parama == null)
    {
      AppMethodBeat.o(253275);
      return;
    }
    if (!listeners.contains(parama)) {
      listeners.add(parama);
    }
    AppMethodBeat.o(253275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.g.d
 * JD-Core Version:    0.7.0.1
 */