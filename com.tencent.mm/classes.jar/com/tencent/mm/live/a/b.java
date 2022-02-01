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
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.f.j;
import com.tencent.mm.live.view.BaseLivePluginLayout;
import com.tencent.mm.live.view.LiveAnchorPluginLayout;
import com.tencent.mm.live.view.LiveVisitorPluginLayout;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import d.g.b.k;
import d.v;
import d.y;
import java.lang.reflect.Constructor;
import org.xwalk.core.XWalkEnvironment;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/controller/LiveUIRouter;", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "provider", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/live/api/LiveConfig;Z)V", "TAG", "", "currentView", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "()Z", "isKeyBoardShow", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "phoneStatelistener", "Landroid/telephony/PhoneStateListener;", "getProvider", "()Lcom/tencent/mm/live/api/LiveConfig;", "rotationSwitchObserver", "Lcom/tencent/mm/live/controller/LiveUIRouter$RotationSwitchObserver;", "sp", "Landroid/content/SharedPreferences;", "viewMap", "Landroid/util/SparseArray;", "viewTable", "Ljava/lang/Class;", "keyboardChange", "", "show", "height", "", "loadViewFromClass", "key", "clazz", "maximizeUi", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "onDestroy", "onPause", "onResume", "onStart", "onStop", "route", "toWhere", "RotationSwitchObserver", "plugin-logic_release"})
public final class b
  implements a
{
  public final String TAG;
  public final Context context;
  public h fxG;
  public final a gmV;
  private final SparseArray<Class<?>> gmW;
  private final SparseArray<BaseLivePluginLayout> gmX;
  public BaseLivePluginLayout gmY;
  boolean gmZ;
  public final PhoneStateListener gna;
  private final ViewGroup gnb;
  private final LiveConfig gnc;
  private final boolean gnd;
  public final SharedPreferences sp;
  
  public b(Context paramContext, ViewGroup paramViewGroup, LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(189730);
    this.context = paramContext;
    this.gnb = paramViewGroup;
    this.gnc = paramLiveConfig;
    this.gnd = paramBoolean;
    this.TAG = "MicroMsg.LiveUIRouter";
    paramContext = this.context.getSharedPreferences(ai.eUX(), 4);
    k.g(paramContext, "context.getSharedPrefere…ntext.MODE_MULTI_PROCESS)");
    this.sp = paramContext;
    this.gmV = new a(new Handler(Looper.getMainLooper()), (d.g.a.a)new d(this));
    this.gmW = new SparseArray();
    this.gmX = new SparseArray();
    this.gna = ((PhoneStateListener)new c(this));
    ac.i(this.TAG, "init");
    paramContext = this.gmW;
    paramViewGroup = f.j.gtQ;
    paramContext.put(f.j.aky(), LiveAnchorPluginLayout.class);
    paramContext = this.gmW;
    paramViewGroup = f.j.gtQ;
    paramContext.put(f.j.akz(), LiveVisitorPluginLayout.class);
    AppMethodBeat.o(189730);
  }
  
  public final void mz(int paramInt)
  {
    AppMethodBeat.i(189729);
    if (this.gmX.get(paramInt) == null)
    {
      Object localObject1 = this.gmW.get(paramInt);
      k.g(localObject1, "viewTable[toWhere]");
      localObject1 = (Class)localObject1;
      try
      {
        localObject1 = ((Class)localObject1).getConstructor(new Class[] { Context.class, AttributeSet.class }).newInstance(new Object[] { this.context, null });
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.live.view.BaseLivePluginLayout");
          AppMethodBeat.o(189729);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      }
    }
    for (;;)
    {
      Object localObject2 = this.gmY;
      this.gmY = ((BaseLivePluginLayout)this.gmX.get(paramInt));
      Object localObject3 = this.gmY;
      if (localObject3 != null) {
        ((BaseLivePluginLayout)localObject3).alM();
      }
      localObject3 = this.gmY;
      if (localObject3 != null) {
        ((BaseLivePluginLayout)localObject3).bringToFront();
      }
      if (localObject2 == null) {
        break;
      }
      ((BaseLivePluginLayout)localObject2).pause();
      AppMethodBeat.o(189729);
      return;
      BaseLivePluginLayout localBaseLivePluginLayout = (BaseLivePluginLayout)localObject2;
      a locala = (a)this;
      localObject3 = this.gnc;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = LiveConfig.P("", LiveConfig.gmH);
        k.g(localObject2, "LiveConfig.getDefaultAnc…ig.SCENE_CHATTING_FOOTER)");
      }
      localBaseLivePluginLayout.a(locala, (LiveConfig)localObject2, this.gnd);
      this.gmX.put(paramInt, localBaseLivePluginLayout);
      this.gnb.addView((View)localBaseLivePluginLayout, new ViewGroup.LayoutParams(-1, -1));
      localBaseLivePluginLayout.setVisibility(8);
    }
    AppMethodBeat.o(189729);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(189728);
    ac.i(this.TAG, "onDestroy " + this.gmY);
    int j = this.gmX.size();
    int i = 0;
    while (i < j)
    {
      ((BaseLivePluginLayout)this.gmX.valueAt(i)).alN();
      i += 1;
    }
    Object localObject = this.context.getSystemService("phone");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.telephony.TelephonyManager");
      AppMethodBeat.o(189728);
      throw ((Throwable)localObject);
    }
    ((TelephonyManager)localObject).listen(this.gna, 0);
    AppMethodBeat.o(189728);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/controller/LiveUIRouter$RotationSwitchObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "onChangCallback", "Lkotlin/Function0;", "", "(Landroid/os/Handler;Lkotlin/jvm/functions/Function0;)V", "mResolver", "Landroid/content/ContentResolver;", "getMResolver", "()Landroid/content/ContentResolver;", "setMResolver", "(Landroid/content/ContentResolver;)V", "getOnChangCallback", "()Lkotlin/jvm/functions/Function0;", "onChange", "selfChange", "", "startObserver", "stopObserver", "plugin-logic_release"})
  public static final class a
    extends ContentObserver
  {
    public ContentResolver gne;
    private final d.g.a.a<y> gnf;
    
    public a(Handler paramHandler, d.g.a.a<y> parama)
    {
      super();
      AppMethodBeat.i(189723);
      this.gnf = parama;
      paramHandler = XWalkEnvironment.getContentResolver();
      k.g(paramHandler, "getContentResolver()");
      this.gne = paramHandler;
      AppMethodBeat.o(189723);
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(189722);
      super.onChange(paramBoolean);
      d.g.a.a locala = this.gnf;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(189722);
        return;
      }
      AppMethodBeat.o(189722);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(189725);
      if (this.gng.fxG == null)
      {
        localObject = this.gng;
        Context localContext = this.gng.context;
        if (localContext == null)
        {
          localObject = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(189725);
          throw ((Throwable)localObject);
        }
        ((b)localObject).fxG = new h((Activity)localContext);
        localObject = this.gng.fxG;
        if (localObject != null) {
          ((h)localObject).setKeyboardHeightObserver((g)new g()
          {
            public final void u(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(189724);
              ac.i(this.gnh.gng.TAG, "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              Object localObject = this.gnh.gng;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true; ((b)localObject).gmZ != paramAnonymousBoolean; paramAnonymousBoolean = false)
              {
                ((b)localObject).gmZ = paramAnonymousBoolean;
                localObject = ((b)localObject).gmY;
                if (localObject == null) {
                  break;
                }
                ((BaseLivePluginLayout)localObject).i(paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(189724);
                return;
              }
              AppMethodBeat.o(189724);
            }
          });
        }
      }
      Object localObject = this.gng.fxG;
      if (localObject != null)
      {
        ((h)localObject).start();
        AppMethodBeat.o(189725);
        return;
      }
      AppMethodBeat.o(189725);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/controller/LiveUIRouter$phoneStatelistener$1", "Landroid/telephony/PhoneStateListener;", "onCallStateChanged", "", "state", "", "incomingNumber", "", "plugin-logic_release"})
  public static final class c
    extends PhoneStateListener
  {
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(189726);
      k.h(paramString, "incomingNumber");
      BaseLivePluginLayout localBaseLivePluginLayout = this.gng.gmY;
      if (localBaseLivePluginLayout != null)
      {
        localBaseLivePluginLayout.onCallStateChanged(paramInt, paramString);
        AppMethodBeat.o(189726);
        return;
      }
      AppMethodBeat.o(189726);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.a.b
 * JD-Core Version:    0.7.0.1
 */