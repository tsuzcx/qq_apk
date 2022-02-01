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
import com.tencent.mm.live.b.l.j;
import com.tencent.mm.live.view.BaseLivePluginLayout;
import com.tencent.mm.live.view.LiveAnchorPluginLayout;
import com.tencent.mm.live.view.LiveVisitorPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.tools.i;
import java.lang.reflect.Constructor;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.xwalk.core.XWalkEnvironment;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/controller/LiveUIRouter;", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "provider", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/live/api/LiveConfig;Z)V", "TAG", "", "currentView", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "()Z", "isKeyBoardShow", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "phoneStatelistener", "Landroid/telephony/PhoneStateListener;", "getProvider", "()Lcom/tencent/mm/live/api/LiveConfig;", "rotationSwitchObserver", "Lcom/tencent/mm/live/controller/LiveUIRouter$RotationSwitchObserver;", "sp", "Landroid/content/SharedPreferences;", "viewMap", "Landroid/util/SparseArray;", "viewTable", "Ljava/lang/Class;", "keyboardChange", "", "show", "height", "", "loadViewFromClass", "key", "clazz", "maximizeUi", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "route", "toWhere", "RotationSwitchObserver", "plugin-logic_release"})
public final class a
{
  public final String TAG;
  public final Context context;
  private final boolean isFinished;
  public i jij;
  private final SparseArray<Class<?>> kiA;
  private final SparseArray<BaseLivePluginLayout> kiB;
  public BaseLivePluginLayout kiC;
  boolean kiD;
  public final PhoneStateListener kiE;
  private final ViewGroup kiF;
  private final LiveConfig kiG;
  public final a kiz;
  public final SharedPreferences sp;
  
  public a(Context paramContext, ViewGroup paramViewGroup, LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(190998);
    this.context = paramContext;
    this.kiF = paramViewGroup;
    this.kiG = paramLiveConfig;
    this.isFinished = paramBoolean;
    this.TAG = "MicroMsg.LiveUIRouter";
    paramContext = this.context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 4);
    p.j(paramContext, "context.getSharedPrefere…ntext.MODE_MULTI_PROCESS)");
    this.sp = paramContext;
    this.kiz = new a(new Handler(Looper.getMainLooper()), (kotlin.g.a.a)new d(this));
    this.kiA = new SparseArray();
    this.kiB = new SparseArray();
    this.kiE = ((PhoneStateListener)new c(this));
    Log.i(this.TAG, "init");
    paramContext = this.kiA;
    paramViewGroup = l.j.kuS;
    paramContext.put(l.j.aNT(), LiveAnchorPluginLayout.class);
    paramContext = this.kiA;
    paramViewGroup = l.j.kuS;
    paramContext.put(l.j.aNU(), LiveVisitorPluginLayout.class);
    AppMethodBeat.o(190998);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(190982);
    Log.i(this.TAG, "onDestroy " + this.kiC);
    int j = this.kiB.size();
    int i = 0;
    while (i < j)
    {
      ((BaseLivePluginLayout)this.kiB.valueAt(i)).unMount();
      i += 1;
    }
    Object localObject1 = this.context.getSystemService("phone");
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
      AppMethodBeat.o(190982);
      throw ((Throwable)localObject1);
    }
    localObject1 = (TelephonyManager)localObject1;
    Object localObject2 = this.kiE;
    localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/live/controller/LiveUIRouter", "onDestroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/live/controller/LiveUIRouter", "onDestroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    AppMethodBeat.o(190982);
  }
  
  public final void sR(int paramInt)
  {
    AppMethodBeat.i(190993);
    if (this.kiB.get(paramInt) == null)
    {
      Object localObject1 = this.kiA.get(paramInt);
      p.j(localObject1, "viewTable[toWhere]");
      localObject1 = (Class)localObject1;
      try
      {
        localObject1 = ((Class)localObject1).getConstructor(new Class[] { Context.class, AttributeSet.class });
        p.j(localObject1, "clazz.getConstructor(Con…AttributeSet::class.java)");
        localObject1 = ((Constructor)localObject1).newInstance(new Object[] { this.context, null });
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.live.view.BaseLivePluginLayout");
          AppMethodBeat.o(190993);
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
      Object localObject2 = this.kiC;
      this.kiC = ((BaseLivePluginLayout)this.kiB.get(paramInt));
      Object localObject3 = this.kiC;
      if (localObject3 != null) {
        ((BaseLivePluginLayout)localObject3).mount();
      }
      localObject3 = this.kiC;
      if (localObject3 != null) {
        ((BaseLivePluginLayout)localObject3).bringToFront();
      }
      if (localObject2 == null) {
        break;
      }
      ((BaseLivePluginLayout)localObject2).pause();
      AppMethodBeat.o(190993);
      return;
      BaseLivePluginLayout localBaseLivePluginLayout = (BaseLivePluginLayout)localObject2;
      localObject3 = this.kiG;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = LiveConfig.an("", LiveConfig.khV);
        p.j(localObject2, "LiveConfig.getDefaultAnc…ig.SCENE_CHATTING_FOOTER)");
      }
      localBaseLivePluginLayout.initLogic((LiveConfig)localObject2, this.isFinished);
      this.kiB.put(paramInt, localBaseLivePluginLayout);
      this.kiF.addView((View)localBaseLivePluginLayout, new ViewGroup.LayoutParams(-1, -1));
      localBaseLivePluginLayout.setVisibility(8);
    }
    AppMethodBeat.o(190993);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/controller/LiveUIRouter$RotationSwitchObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "onChangCallback", "Lkotlin/Function0;", "", "(Landroid/os/Handler;Lkotlin/jvm/functions/Function0;)V", "mResolver", "Landroid/content/ContentResolver;", "getMResolver", "()Landroid/content/ContentResolver;", "setMResolver", "(Landroid/content/ContentResolver;)V", "getOnChangCallback", "()Lkotlin/jvm/functions/Function0;", "onChange", "selfChange", "", "startObserver", "stopObserver", "plugin-logic_release"})
  public static final class a
    extends ContentObserver
  {
    public ContentResolver kiH;
    private final kotlin.g.a.a<x> kiI;
    
    public a(Handler paramHandler, kotlin.g.a.a<x> parama)
    {
      super();
      AppMethodBeat.i(194624);
      this.kiI = parama;
      paramHandler = XWalkEnvironment.getContentResolver();
      p.j(paramHandler, "getContentResolver()");
      this.kiH = paramHandler;
      AppMethodBeat.o(194624);
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(194623);
      super.onChange(paramBoolean);
      kotlin.g.a.a locala = this.kiI;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(194623);
        return;
      }
      AppMethodBeat.o(194623);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(196783);
      if (this.kiJ.jij == null)
      {
        localObject = this.kiJ;
        Context localContext = this.kiJ.context;
        if (localContext == null)
        {
          localObject = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(196783);
          throw ((Throwable)localObject);
        }
        ((a)localObject).jij = new i((Activity)localContext);
        localObject = this.kiJ.jij;
        if (localObject != null) {
          ((i)localObject).setKeyboardHeightObserver((h)new h()
          {
            public final void A(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(193981);
              Log.i(this.kiK.kiJ.TAG, "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              Object localObject = this.kiK.kiJ;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true; ((a)localObject).kiD != paramAnonymousBoolean; paramAnonymousBoolean = false)
              {
                ((a)localObject).kiD = paramAnonymousBoolean;
                localObject = ((a)localObject).kiC;
                if (localObject == null) {
                  break;
                }
                ((BaseLivePluginLayout)localObject).keyboardChange(paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(193981);
                return;
              }
              AppMethodBeat.o(193981);
            }
          });
        }
      }
      Object localObject = this.kiJ.jij;
      if (localObject != null)
      {
        ((i)localObject).start();
        AppMethodBeat.o(196783);
        return;
      }
      AppMethodBeat.o(196783);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/controller/LiveUIRouter$phoneStatelistener$1", "Landroid/telephony/PhoneStateListener;", "onCallStateChanged", "", "state", "", "incomingNumber", "", "plugin-logic_release"})
  public static final class c
    extends PhoneStateListener
  {
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(188948);
      p.k(paramString, "incomingNumber");
      BaseLivePluginLayout localBaseLivePluginLayout = this.kiJ.kiC;
      if (localBaseLivePluginLayout != null)
      {
        localBaseLivePluginLayout.onCallStateChanged(paramInt, paramString);
        AppMethodBeat.o(188948);
        return;
      }
      AppMethodBeat.o(188948);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.a.a
 * JD-Core Version:    0.7.0.1
 */