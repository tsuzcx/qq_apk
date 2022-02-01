package com.tencent.mm.live.a;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.o.k;
import com.tencent.mm.live.view.BaseLivePluginLayout;
import com.tencent.mm.live.view.LiveAnchorPluginLayout;
import com.tencent.mm.live.view.LiveVisitorPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import java.lang.reflect.Constructor;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.xwalk.core.XWalkEnvironment;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/controller/LiveUIRouter;", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "provider", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/live/api/LiveConfig;Z)V", "TAG", "", "currentView", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "()Z", "isKeyBoardShow", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "phoneStatelistener", "Landroid/telephony/PhoneStateListener;", "getProvider", "()Lcom/tencent/mm/live/api/LiveConfig;", "rotationSwitchObserver", "Lcom/tencent/mm/live/controller/LiveUIRouter$RotationSwitchObserver;", "sp", "Landroid/content/SharedPreferences;", "viewMap", "Landroid/util/SparseArray;", "viewTable", "Ljava/lang/Class;", "keyboardChange", "", "show", "height", "", "loadViewFromClass", "key", "clazz", "maximizeUi", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "onDestroy", "onPause", "onResume", "onStart", "onStop", "route", "toWhere", "RotationSwitchObserver", "plugin-logic_release"})
public final class a
{
  public final String TAG;
  public final Context context;
  public h gyh;
  public final a hwm;
  private final SparseArray<Class<?>> hwn;
  private final SparseArray<BaseLivePluginLayout> hwo;
  public BaseLivePluginLayout hwp;
  boolean hwq;
  private final ViewGroup hwr;
  private final LiveConfig hws;
  private final boolean isFinished;
  public final PhoneStateListener phoneStatelistener;
  public final SharedPreferences sp;
  
  public a(Context paramContext, ViewGroup paramViewGroup, LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(207548);
    this.context = paramContext;
    this.hwr = paramViewGroup;
    this.hws = paramLiveConfig;
    this.isFinished = paramBoolean;
    this.TAG = "MicroMsg.LiveUIRouter";
    paramContext = this.context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 4);
    p.g(paramContext, "context.getSharedPrefere…ntext.MODE_MULTI_PROCESS)");
    this.sp = paramContext;
    this.hwm = new a(new Handler(Looper.getMainLooper()), (kotlin.g.a.a)new d(this));
    this.hwn = new SparseArray();
    this.hwo = new SparseArray();
    this.phoneStatelistener = ((PhoneStateListener)new c(this));
    Log.i(this.TAG, "init");
    paramContext = this.hwn;
    paramViewGroup = o.k.hHn;
    paramContext.put(o.k.aFM(), LiveAnchorPluginLayout.class);
    paramContext = this.hwn;
    paramViewGroup = o.k.hHn;
    paramContext.put(o.k.aFN(), LiveVisitorPluginLayout.class);
    AppMethodBeat.o(207548);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(207546);
    Log.i(this.TAG, "onDestroy " + this.hwp);
    int j = this.hwo.size();
    int i = 0;
    while (i < j)
    {
      ((BaseLivePluginLayout)this.hwo.valueAt(i)).unMount();
      i += 1;
    }
    Object localObject1 = this.context.getSystemService("phone");
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
      AppMethodBeat.o(207546);
      throw ((Throwable)localObject1);
    }
    localObject1 = (TelephonyManager)localObject1;
    Object localObject2 = this.phoneStatelistener;
    localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/live/controller/LiveUIRouter", "onDestroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/live/controller/LiveUIRouter", "onDestroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    AppMethodBeat.o(207546);
  }
  
  public final void qp(int paramInt)
  {
    AppMethodBeat.i(207547);
    if (this.hwo.get(paramInt) == null)
    {
      Object localObject1 = this.hwn.get(paramInt);
      p.g(localObject1, "viewTable[toWhere]");
      localObject1 = (Class)localObject1;
      try
      {
        localObject1 = ((Class)localObject1).getConstructor(new Class[] { Context.class, AttributeSet.class });
        p.g(localObject1, "clazz.getConstructor(Con…AttributeSet::class.java)");
        localObject1 = ((Constructor)localObject1).newInstance(new Object[] { this.context, null });
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.live.view.BaseLivePluginLayout");
          AppMethodBeat.o(207547);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      }
    }
    for (;;)
    {
      Object localObject2 = this.hwp;
      this.hwp = ((BaseLivePluginLayout)this.hwo.get(paramInt));
      Object localObject3 = this.hwp;
      if (localObject3 != null) {
        ((BaseLivePluginLayout)localObject3).mount();
      }
      localObject3 = this.hwp;
      if (localObject3 != null) {
        ((BaseLivePluginLayout)localObject3).bringToFront();
      }
      if (localObject2 == null) {
        break;
      }
      ((BaseLivePluginLayout)localObject2).pause();
      AppMethodBeat.o(207547);
      return;
      BaseLivePluginLayout localBaseLivePluginLayout = (BaseLivePluginLayout)localObject2;
      localObject3 = this.hws;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = LiveConfig.V("", LiveConfig.hvS);
        p.g(localObject2, "LiveConfig.getDefaultAnc…ig.SCENE_CHATTING_FOOTER)");
      }
      localBaseLivePluginLayout.initLogic((LiveConfig)localObject2, this.isFinished);
      this.hwo.put(paramInt, localBaseLivePluginLayout);
      this.hwr.addView((View)localBaseLivePluginLayout, new ViewGroup.LayoutParams(-1, -1));
      localBaseLivePluginLayout.setVisibility(8);
    }
    AppMethodBeat.o(207547);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/controller/LiveUIRouter$RotationSwitchObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "onChangCallback", "Lkotlin/Function0;", "", "(Landroid/os/Handler;Lkotlin/jvm/functions/Function0;)V", "mResolver", "Landroid/content/ContentResolver;", "getMResolver", "()Landroid/content/ContentResolver;", "setMResolver", "(Landroid/content/ContentResolver;)V", "getOnChangCallback", "()Lkotlin/jvm/functions/Function0;", "onChange", "selfChange", "", "startObserver", "stopObserver", "plugin-logic_release"})
  public static final class a
    extends ContentObserver
  {
    public ContentResolver hwt;
    private final kotlin.g.a.a<x> hwu;
    
    public a(Handler paramHandler, kotlin.g.a.a<x> parama)
    {
      super();
      AppMethodBeat.i(207541);
      this.hwu = parama;
      paramHandler = XWalkEnvironment.getContentResolver();
      p.g(paramHandler, "getContentResolver()");
      this.hwt = paramHandler;
      AppMethodBeat.o(207541);
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(207540);
      super.onChange(paramBoolean);
      kotlin.g.a.a locala = this.hwu;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(207540);
        return;
      }
      AppMethodBeat.o(207540);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(207543);
      if (this.hwv.gyh == null)
      {
        localObject = this.hwv;
        Context localContext = this.hwv.context;
        if (localContext == null)
        {
          localObject = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(207543);
          throw ((Throwable)localObject);
        }
        ((a)localObject).gyh = new h((Activity)localContext);
        localObject = this.hwv.gyh;
        if (localObject != null) {
          ((h)localObject).setKeyboardHeightObserver((g)new g()
          {
            public final void y(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(207542);
              Log.i(this.hww.hwv.TAG, "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              Object localObject = this.hww.hwv;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true; ((a)localObject).hwq != paramAnonymousBoolean; paramAnonymousBoolean = false)
              {
                ((a)localObject).hwq = paramAnonymousBoolean;
                localObject = ((a)localObject).hwp;
                if (localObject == null) {
                  break;
                }
                ((BaseLivePluginLayout)localObject).keyboardChange(paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(207542);
                return;
              }
              AppMethodBeat.o(207542);
            }
          });
        }
      }
      Object localObject = this.hwv.gyh;
      if (localObject != null)
      {
        ((h)localObject).start();
        AppMethodBeat.o(207543);
        return;
      }
      AppMethodBeat.o(207543);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/controller/LiveUIRouter$phoneStatelistener$1", "Landroid/telephony/PhoneStateListener;", "onCallStateChanged", "", "state", "", "incomingNumber", "", "plugin-logic_release"})
  public static final class c
    extends PhoneStateListener
  {
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(207544);
      p.h(paramString, "incomingNumber");
      BaseLivePluginLayout localBaseLivePluginLayout = this.hwv.hwp;
      if (localBaseLivePluginLayout != null)
      {
        localBaseLivePluginLayout.onCallStateChanged(paramInt, paramString);
        AppMethodBeat.o(207544);
        return;
      }
      AppMethodBeat.o(207544);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.a.a
 * JD-Core Version:    0.7.0.1
 */