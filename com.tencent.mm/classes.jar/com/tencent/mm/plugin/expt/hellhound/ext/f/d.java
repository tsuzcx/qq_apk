package com.tencent.mm.plugin.expt.hellhound.ext.f;

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
import com.tencent.mm.protocal.protobuf.fed;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.j.b;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/SnsFeedMonitor;", "", "()V", "AdSnsInfoClassName", "", "IdName", "SnsInfoClassName", "TAG", "TimeLineObjectClassName", "UserNameName", "adCardActionBtnInfoField", "Ljava/lang/reflect/Field;", "adsnsinfoField", "adsnsinfoName", "finderLiveFeedExportIdField", "finderLiveIdField", "finderUsernameField", "getAdXmlMethod", "Ljava/lang/reflect/Method;", "getAdXmlMethodName", "getTimeLineMethod", "getTimeLineMethodName", "idField", "listeners", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/sns/ISnsFeedListener;", "Lkotlin/collections/ArrayList;", "mActionBarHeight", "", "mFirstPostion", "mScreenHeight", "mScreenRealHeight", "mSnsFeedCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellFeed;", "Lkotlin/collections/HashMap;", "mStatusBarHeight", "mVisibleItemCount", "userNameField", "virtualKeyHeight", "_getHellFeed", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "feedView", "Landroid/view/View;", "position", "listView", "Landroid/widget/AbsListView;", "firstPos", "_getUIParams", "view", "getY", "init", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "initActionBarHeight", "Landroid/app/Activity;", "initScreenHeight", "initStatusBarHeight", "monitor", "adapter", "Landroid/widget/BaseAdapter;", "firstPostion", "visibleItemCount", "onFeedAppear", "feed", "onFeedDisappear", "registerListener", "listener", "resetCache", "unregisterListener", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
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
  private static Method zDR;
  private static Field zDS;
  public static final d zLm;
  public static final HashMap<String, com.tencent.mm.plugin.expt.hellhound.ext.a.c> zLn;
  private static Field zLo;
  private static Field zLp;
  private static Method zLq;
  private static Field zLr;
  private static Field zLs;
  private static Field zLt;
  private static Field zLu;
  
  static
  {
    AppMethodBeat.i(300128);
    zLm = new d();
    listeners = new ArrayList();
    zLn = new HashMap();
    mFirstPostion = -1;
    mVisibleItemCount = -1;
    try
    {
      Object localObject1 = Class.forName("com.tencent.mm.plugin.sns.storage.SnsInfo");
      Object localObject2 = ((Class)localObject1).getDeclaredMethod("getTimeLine", new Class[0]);
      zDR = (Method)localObject2;
      if (localObject2 != null) {
        ((Method)localObject2).setAccessible(true);
      }
      localObject2 = Class.forName("com.tencent.mm.protocal.protobuf.TimeLineObject");
      Field localField = ((Class)localObject2).getDeclaredField("Id");
      zDS = localField;
      if (localField != null) {
        localField.setAccessible(true);
      }
      localObject2 = ((Class)localObject2).getDeclaredField("UserName");
      zLo = (Field)localObject2;
      if (localObject2 != null) {
        ((Field)localObject2).setAccessible(true);
      }
      localObject1 = ((Class)localObject1).getDeclaredField("adsnsinfo");
      zLp = (Field)localObject1;
      if (localObject1 != null) {
        ((Field)localObject1).setAccessible(true);
      }
      localObject1 = Class.forName("com.tencent.mm.plugin.sns.storage.AdSnsInfo").getDeclaredMethod("getAdXml", new Class[0]);
      zLq = (Method)localObject1;
      if (localObject1 != null) {
        ((Method)localObject1).setAccessible(true);
      }
      localObject1 = Class.forName("com.tencent.mm.plugin.sns.storage.ADXml").getDeclaredField("adCardActionBtnInfo");
      zLr = (Field)localObject1;
      if (localObject1 != null) {
        ((Field)localObject1).setAccessible(true);
      }
      localObject1 = Class.forName("com.tencent.mm.plugin.sns.storage.ADXml$AdCardActionBtnInfo");
      localObject2 = ((Class)localObject1).getDeclaredField("finderUsername");
      zLs = (Field)localObject2;
      if (localObject2 != null) {
        ((Field)localObject2).setAccessible(true);
      }
      localObject2 = ((Class)localObject1).getDeclaredField("finderLiveId");
      zLt = (Field)localObject2;
      if (localObject2 != null) {
        ((Field)localObject2).setAccessible(true);
      }
      localObject1 = ((Class)localObject1).getDeclaredField("finderLiveFeedExportId");
      zLu = (Field)localObject1;
      if (localObject1 != null)
      {
        ((Field)localObject1).setAccessible(true);
        AppMethodBeat.o(300128);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("HABBYGE-MALI.SnsFeedMonitor", s.X("SnsFeedMonitor, init-1, crash: ", localException.getMessage()));
      AppMethodBeat.o(300128);
    }
  }
  
  public static com.tencent.mm.vending.j.c<com.tencent.mm.plugin.expt.hellhound.ext.a.c, Boolean> _getHellFeed(View paramView, int paramInt1, AbsListView paramAbsListView, int paramInt2)
  {
    AppMethodBeat.i(300115);
    if ((ListAdapter)paramAbsListView.getAdapter() == null)
    {
      AppMethodBeat.o(300115);
      return null;
    }
    int i = paramInt2 + paramInt1;
    if (i >= ((ListAdapter)paramAbsListView.getAdapter()).getCount())
    {
      AppMethodBeat.o(300115);
      return null;
    }
    Object localObject3 = ((ListAdapter)paramAbsListView.getAdapter()).getItem(i);
    if (localObject3 == null)
    {
      AppMethodBeat.o(300115);
      return null;
    }
    paramInt2 = 0;
    Object localObject1 = new int[2];
    while (paramInt2 < 2)
    {
      localObject1[paramInt2] = -1;
      paramInt2 += 1;
    }
    paramView.getLocationOnScreen((int[])localObject1);
    paramView = com.tencent.mm.vending.j.a.U(Integer.valueOf(Math.min(localObject1[1], (int)paramView.getY())), Integer.valueOf(paramView.getHeight()));
    s.s(paramView, "make(y, view.height)");
    Integer localInteger1 = (Integer)paramView.get(0);
    Integer localInteger2 = (Integer)paramView.get(1);
    com.tencent.mm.plugin.expt.hellhound.ext.a.c localc = new com.tencent.mm.plugin.expt.hellhound.ext.a.c();
    localc.zDG = new fed();
    try
    {
      paramView = zDR;
      if (paramView != null) {
        break label716;
      }
      localObject1 = null;
      localfed = localc.zDG;
      paramView = zDS;
      if (paramView != null) {
        break label731;
      }
      paramView = null;
      label211:
      if (!(paramView instanceof String)) {
        break label969;
      }
      paramView = (String)paramView;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        fed localfed;
        label226:
        Log.e("HABBYGE-MALI.SnsFeedMonitor", s.X("_getHellFeed, crash: ", paramView.getMessage()));
        continue;
        paramView = paramView.get(localObject3);
        continue;
        paramView = ((Method)localObject1).invoke(paramView, new Object[0]);
        continue;
        localObject1 = ((Field)localObject1).get(paramView);
        continue;
        paramView = paramView.get(localObject1);
        continue;
        paramView = paramView.get(localObject1);
        continue;
        localObject1 = ((Field)localObject2).get(localObject1);
        continue;
        localObject1 = null;
        continue;
        bool = false;
        continue;
        bool = false;
      }
    }
    localfed.feedId = ((String)localObject2);
    Object localObject2 = localc.zDG;
    paramView = zLo;
    if (paramView == null)
    {
      paramView = null;
      label250:
      if (!(paramView instanceof String)) {
        break label751;
      }
      paramView = (String)paramView;
      break label927;
      label265:
      ((fed)localObject2).userName = ((String)localObject1);
      localc.zDL = localc.zDG.userName;
    }
    try
    {
      paramView = zLp;
      if (paramView != null) {
        break label775;
      }
      paramView = null;
      if (paramView == null) {
        break label854;
      }
      localObject1 = zLq;
      if (localObject1 != null) {
        break label785;
      }
      paramView = null;
      if (paramView == null) {
        break label854;
      }
      localObject1 = zLr;
      if (localObject1 != null) {
        break label799;
      }
      localObject1 = null;
      if (localObject1 == null) {
        break label854;
      }
      paramView = zLs;
      if (paramView != null) {
        break label810;
      }
      paramView = null;
      if (!(paramView instanceof String)) {
        break label974;
      }
      paramView = (String)paramView;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        label358:
        bool = false;
        Log.e("HABBYGE-MALI.SnsFeedMonitor", s.X("_getHellFeed, crash-2: ", paramView.getMessage()));
        continue;
        paramInt2 = mActionBarHeight;
        continue;
        if (k + m <= paramInt1 + paramInt2) {
          bool = false;
        } else {
          bool = true;
        }
      }
    }
    localc.zDJ = ((String)localObject2);
    paramView = zLt;
    if (paramView == null)
    {
      paramView = null;
      if (!(paramView instanceof String)) {
        break label979;
      }
      paramView = (String)paramView;
    }
    for (;;)
    {
      localc.finderLiveId = ((String)localObject2);
      localc.liveId = localc.finderLiveId;
      localObject2 = zLu;
      boolean bool;
      int k;
      int m;
      if (localObject2 == null)
      {
        localObject1 = null;
        if (!(localObject1 instanceof String)) {
          break label842;
        }
        localObject1 = (String)localObject1;
        localc.zDK = ((String)localObject1);
        bool = s.p(paramView, "");
        if ((bool) || (paramView == null)) {
          break label848;
        }
        bool = true;
        localc.zDI = bool;
        if (TextUtils.isEmpty((CharSequence)localc.zDG.feedId)) {
          localc.zDG.feedId = String.valueOf(paramAbsListView.getItemIdAtPosition(i));
        }
        paramView = localc.zDG;
        s.s(localInteger1, "y");
        paramView.y = localInteger1.intValue();
        paramView = localc.zDG;
        s.s(localInteger2, "height");
        paramView.height = localInteger2.intValue();
        localc.zDG.pvg = mScreenRealHeight;
        localc.zDG.virtualKeyHeight = (mScreenRealHeight - mScreenHeight);
        localc.zDG.vpn = mStatusBarHeight;
        paramView = localc.zDG;
        if (mActionBarHeight > 0) {
          break label882;
        }
        paramInt2 = 144;
        paramView.BqU = paramInt2;
        localc.position = i;
        localc.zDH = paramInt1;
        paramInt1 = localc.zDG.vpn;
        paramInt2 = localc.zDG.BqU;
        i = localc.zDG.pvg;
        int j = localc.zDG.virtualKeyHeight;
        k = localc.zDG.y;
        m = localc.zDG.height;
        if (localc.zDG.y < i - j) {
          break label889;
        }
        bool = false;
        paramView = com.tencent.mm.vending.j.a.U(localc, Boolean.valueOf(bool));
        AppMethodBeat.o(300115);
        return paramView;
        label716:
        localObject1 = paramView.invoke(localObject3, new Object[0]);
        break;
        label731:
        paramView = paramView.get(localObject1);
        break label211;
        paramView = paramView.get(localObject1);
        break label250;
        label751:
        paramView = null;
        break label927;
      }
      label775:
      label785:
      label799:
      label810:
      label842:
      label848:
      label854:
      label882:
      label889:
      localObject2 = paramView;
      label912:
      if (paramView != null) {
        break label226;
      }
      localObject2 = "";
      break label226;
      label927:
      localObject1 = paramView;
      if (paramView != null) {
        break label265;
      }
      localObject1 = "";
      break label265;
      label942:
      localObject2 = paramView;
      if (paramView != null) {
        break label358;
      }
      localObject2 = "";
      break label358;
      for (;;)
      {
        if (paramView != null) {
          break label984;
        }
        localObject2 = "";
        break;
        label969:
        paramView = null;
        break label912;
        label974:
        paramView = null;
        break label942;
        label979:
        paramView = null;
      }
      label984:
      localObject2 = paramView;
    }
  }
  
  public static void dMD()
  {
    AppMethodBeat.i(300124);
    Iterator localIterator = listeners.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(300124);
  }
  
  public static void initActionBarHeight(Activity paramActivity)
  {
    AppMethodBeat.i(300125);
    if (paramActivity == null)
    {
      AppMethodBeat.o(300125);
      return;
    }
    for (;;)
    {
      try
      {
        if (!(paramActivity instanceof AppCompatActivity)) {
          continue;
        }
        paramActivity = ((AppCompatActivity)paramActivity).getSupportActionBar();
        if (paramActivity == null)
        {
          paramActivity = null;
          break label92;
          mActionBarHeight = i;
          AppMethodBeat.o(300125);
        }
        else
        {
          paramActivity = paramActivity.getCustomView();
        }
      }
      catch (Exception paramActivity)
      {
        Log.printErrStackTrace("HABBYGE-MALI.SnsFeedMonitor", (Throwable)paramActivity, "initBarHeight", new Object[0]);
        AppMethodBeat.o(300125);
        return;
      }
      int i = paramActivity.getHeight();
      continue;
      label92:
      if (paramActivity == null) {
        i = -1;
      }
    }
  }
  
  public static void initScreenHeight(Activity paramActivity)
  {
    Point localPoint2 = null;
    AppMethodBeat.i(300127);
    if (paramActivity == null)
    {
      AppMethodBeat.o(300127);
      return;
    }
    for (;;)
    {
      try
      {
        localObject = MMApplicationContext.getContext().getSystemService("window");
        if (!(localObject instanceof WindowManager)) {
          continue;
        }
        localObject = (WindowManager)localObject;
        if (localObject != null) {
          continue;
        }
        paramActivity = null;
      }
      catch (Exception localException)
      {
        Object localObject;
        paramActivity = paramActivity.getWindowManager();
        if (paramActivity != null) {
          continue;
        }
        paramActivity = localPoint2;
        continue;
        paramActivity = paramActivity.getDefaultDisplay();
        continue;
        localPoint1 = new Point();
        if (Build.VERSION.SDK_INT < 13) {
          continue;
        }
        paramActivity.getSize(localPoint1);
        localPoint2 = new Point();
        if (Build.VERSION.SDK_INT < 17) {
          continue;
        }
        paramActivity.getRealSize(localPoint2);
        mScreenHeight = localPoint1.y;
        i = localPoint2.y;
        mScreenRealHeight = i;
        i -= mScreenHeight;
        if (i <= 0) {
          break label179;
        }
      }
      if (paramActivity != null) {
        continue;
      }
      AppMethodBeat.o(300127);
      return;
      localObject = null;
      continue;
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      paramActivity = (Activity)localObject;
    }
    for (;;)
    {
      Point localPoint1;
      virtualKeyHeight = i;
      AppMethodBeat.o(300127);
      return;
      label179:
      int i = 0;
    }
  }
  
  public static void onFeedAppear(BaseAdapter paramBaseAdapter, com.tencent.mm.plugin.expt.hellhound.ext.a.c paramc, View paramView)
  {
    AppMethodBeat.i(300122);
    Iterator localIterator = listeners.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramBaseAdapter, paramc, paramView);
    }
    AppMethodBeat.o(300122);
  }
  
  public static void registerListener(a parama)
  {
    AppMethodBeat.i(300118);
    if (parama == null)
    {
      AppMethodBeat.o(300118);
      return;
    }
    if (!listeners.contains(parama)) {
      listeners.add(parama);
    }
    AppMethodBeat.o(300118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.f.d
 * JD-Core Version:    0.7.0.1
 */