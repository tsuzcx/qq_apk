package com.tencent.mm.accessibility.uitl;

import android.content.Context;
import android.text.TextUtils.SimpleStringSplitter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.core.AccReporter;
import com.tencent.mm.sdk.observer.IMvvmObserver;
import com.tencent.mm.sdk.observer.MvvmObserverOwner;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/uitl/AccUtil;", "", "()V", "CACHE_TIME", "", "TAG", "", "defaultWhiteList", "", "isAccessibilityEnabled", "", "isCoolAssistRunning", "isEnableAccEnableForced", "()Z", "setEnableAccEnableForced", "(Z)V", "isEnableExpand", "setEnableExpand", "isGlobalDisableAcc", "setGlobalDisableAcc", "value", "isTouchExplorationEnable", "isTouchExplorationEnable$plugin_autoaccessibility_release", "setTouchExplorationEnable$plugin_autoaccessibility_release", "lastTimeCoolAssist", "lastTimeEnabled", "listenersOwner", "Lcom/tencent/mm/sdk/observer/MvvmObserverOwner;", "Lcom/tencent/mm/sdk/observer/IMvvmObserver;", "getListenersOwner", "()Lcom/tencent/mm/sdk/observer/MvvmObserverOwner;", "whileList", "getWhileList", "()Ljava/util/List;", "setWhileList", "(Ljava/util/List;)V", "canExpand", "canPreDeal", "isEnableCallbackRealtime", "isEnableNodeInfoCache", "isEnableShowTextLinespace", "notifyTouchExplorationChange", "", "enable", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AccUtil
{
  private static final long CACHE_TIME = 1000L;
  public static final AccUtil INSTANCE;
  public static final String TAG = "MicroMsg.Acc.AccUtil";
  private static final List<String> defaultWhiteList;
  private static boolean isAccessibilityEnabled;
  private static boolean isCoolAssistRunning;
  private static boolean isEnableAccEnableForced;
  private static boolean isEnableExpand;
  private static boolean isGlobalDisableAcc;
  private static boolean isTouchExplorationEnable;
  private static long lastTimeCoolAssist;
  private static long lastTimeEnabled;
  private static final MvvmObserverOwner<IMvvmObserver<Boolean>, Boolean> listenersOwner;
  private static List<String> whileList;
  
  static
  {
    AppMethodBeat.i(234118);
    INSTANCE = new AccUtil();
    listenersOwner = (MvvmObserverOwner)new MvvmObserverOwner()
    {
      public final String getLogTag()
      {
        return "MicroMsg.Acc.AccUtil";
      }
    };
    List localList = p.listOf(new String[] { "com.google.android.marvin.talkback.TalkBackService", "com.bjbyhd.screenreader_huawei.ScreenReaderService", "com.bjbyhd.voiceback.BoyhoodVoiceBackService", "com.nirenr.talkman.TalkManAccessibilityService", "com.dianming.phoneapp.MyAccessibilityService" });
    defaultWhiteList = localList;
    whileList = localList;
    isEnableExpand = true;
    AppMethodBeat.o(234118);
  }
  
  private final void notifyTouchExplorationChange(boolean paramBoolean)
  {
    AppMethodBeat.i(234112);
    listenersOwner.notify(Boolean.valueOf(paramBoolean));
    Log.i("MicroMsg.Acc.AccUtil", "notifyTouchExplorationChange " + paramBoolean + ' ');
    if (paramBoolean)
    {
      AccReporter.INSTANCE.reportTouchExplorationEnable();
      AccReporter.INSTANCE.reportAppTypeIfNeed();
    }
    AppMethodBeat.o(234112);
  }
  
  public final boolean canExpand()
  {
    return isEnableExpand;
  }
  
  public final boolean canPreDeal()
  {
    AppMethodBeat.i(234173);
    if (((isAccessibilityEnabled()) || (isEnableAccEnableForced) || (canExpand())) && (!isGlobalDisableAcc))
    {
      AppMethodBeat.o(234173);
      return true;
    }
    AppMethodBeat.o(234173);
    return false;
  }
  
  public final MvvmObserverOwner<IMvvmObserver<Boolean>, Boolean> getListenersOwner()
  {
    return listenersOwner;
  }
  
  public final List<String> getWhileList()
  {
    return whileList;
  }
  
  public final boolean isAccessibilityEnabled()
  {
    AppMethodBeat.i(234137);
    if (isTouchExplorationEnable)
    {
      AppMethodBeat.o(234137);
      return true;
    }
    if (System.currentTimeMillis() - lastTimeEnabled < 1000L)
    {
      boolean bool = isAccessibilityEnabled;
      AppMethodBeat.o(234137);
      return bool;
    }
    lastTimeEnabled = System.currentTimeMillis();
    Object localObject = MMApplicationContext.getContext().getContentResolver();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG("enabled_accessibility_services").cG(localObject);
    String str = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/accessibility/uitl/AccUtil", "isAccessibilityEnabled", "()Z", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
    if (str != null)
    {
      localObject = new TextUtils.SimpleStringSplitter(':');
      ((TextUtils.SimpleStringSplitter)localObject).setString(str);
      while (((TextUtils.SimpleStringSplitter)localObject).hasNext())
      {
        str = ((TextUtils.SimpleStringSplitter)localObject).next();
        s.s(str, "splitter.next()");
        Log.i("MicroMsg.Acc.AccUtil", s.X("Setting: ", str));
        int k = whileList.size() - 1;
        if (k >= 0)
        {
          int j;
          for (int i = 0;; i = j)
          {
            j = i + 1;
            if (n.a((CharSequence)str, (CharSequence)whileList.get(i), false))
            {
              isAccessibilityEnabled = true;
              AppMethodBeat.o(234137);
              return true;
            }
            if (j > k) {
              break;
            }
          }
        }
      }
    }
    isAccessibilityEnabled = false;
    AppMethodBeat.o(234137);
    return false;
  }
  
  public final boolean isCoolAssistRunning()
  {
    AppMethodBeat.i(234160);
    if (System.currentTimeMillis() - lastTimeCoolAssist < 1000L)
    {
      boolean bool = isCoolAssistRunning;
      AppMethodBeat.o(234160);
      return bool;
    }
    lastTimeCoolAssist = System.currentTimeMillis();
    Object localObject = MMApplicationContext.getContext().getContentResolver();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG("enabled_accessibility_services").cG(localObject);
    String str = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/accessibility/uitl/AccUtil", "isCoolAssistRunning", "()Z", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
    if (str != null)
    {
      localObject = new TextUtils.SimpleStringSplitter(':');
      ((TextUtils.SimpleStringSplitter)localObject).setString(str);
      while (((TextUtils.SimpleStringSplitter)localObject).hasNext())
      {
        str = ((TextUtils.SimpleStringSplitter)localObject).next();
        s.s(str, "splitter.next()");
        if (n.a((CharSequence)str, (CharSequence)"MMAccessibilityService", false))
        {
          isCoolAssistRunning = true;
          AppMethodBeat.o(234160);
          return true;
        }
      }
    }
    isCoolAssistRunning = false;
    AppMethodBeat.o(234160);
    return false;
  }
  
  public final boolean isEnableAccEnableForced()
  {
    return isEnableAccEnableForced;
  }
  
  public final boolean isEnableCallbackRealtime()
  {
    AppMethodBeat.i(234163);
    i locali = i.agtt;
    if (i.a(b.a.agrs, 0) == 1)
    {
      AppMethodBeat.o(234163);
      return true;
    }
    AppMethodBeat.o(234163);
    return false;
  }
  
  public final boolean isEnableExpand()
  {
    return isEnableExpand;
  }
  
  public final boolean isEnableNodeInfoCache()
  {
    AppMethodBeat.i(234169);
    i locali = i.agtt;
    if (i.a(b.a.agru, 0) == 1)
    {
      AppMethodBeat.o(234169);
      return true;
    }
    AppMethodBeat.o(234169);
    return false;
  }
  
  public final boolean isEnableShowTextLinespace()
  {
    return true;
  }
  
  public final boolean isGlobalDisableAcc()
  {
    return isGlobalDisableAcc;
  }
  
  public final boolean isTouchExplorationEnable$plugin_autoaccessibility_release()
  {
    return isTouchExplorationEnable;
  }
  
  public final void setEnableAccEnableForced(boolean paramBoolean)
  {
    isEnableAccEnableForced = paramBoolean;
  }
  
  public final void setEnableExpand(boolean paramBoolean)
  {
    isEnableExpand = paramBoolean;
  }
  
  public final void setGlobalDisableAcc(boolean paramBoolean)
  {
    isGlobalDisableAcc = paramBoolean;
  }
  
  public final void setTouchExplorationEnable$plugin_autoaccessibility_release(boolean paramBoolean)
  {
    AppMethodBeat.i(234124);
    isTouchExplorationEnable = paramBoolean;
    notifyTouchExplorationChange(paramBoolean);
    AppMethodBeat.o(234124);
  }
  
  public final void setWhileList(List<String> paramList)
  {
    AppMethodBeat.i(234150);
    s.u(paramList, "<set-?>");
    whileList = paramList;
    AppMethodBeat.o(234150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.uitl.AccUtil
 * JD-Core Version:    0.7.0.1
 */