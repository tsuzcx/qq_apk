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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.lang.reflect.Constructor;
import org.xwalk.core.XWalkEnvironment;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/controller/LiveUIRouter;", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "provider", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/live/api/LiveConfig;Z)V", "TAG", "", "currentView", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "()Z", "isKeyBoardShow", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "phoneStatelistener", "Landroid/telephony/PhoneStateListener;", "getProvider", "()Lcom/tencent/mm/live/api/LiveConfig;", "rotationSwitchObserver", "Lcom/tencent/mm/live/controller/LiveUIRouter$RotationSwitchObserver;", "sp", "Landroid/content/SharedPreferences;", "viewMap", "Landroid/util/SparseArray;", "viewTable", "Ljava/lang/Class;", "keyboardChange", "", "show", "height", "", "loadViewFromClass", "key", "clazz", "maximizeUi", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "onDestroy", "onPause", "onResume", "onStart", "onStop", "route", "toWhere", "RotationSwitchObserver", "plugin-logic_release"})
public final class b
  implements a
{
  public final String TAG;
  public final Context context;
  public h fQT;
  public final a gGE;
  private final SparseArray<Class<?>> gGF;
  private final SparseArray<BaseLivePluginLayout> gGG;
  public BaseLivePluginLayout gGH;
  boolean gGI;
  public final PhoneStateListener gGJ;
  private final ViewGroup gGK;
  private final LiveConfig gGL;
  private final boolean gGM;
  public final SharedPreferences sp;
  
  public b(Context paramContext, ViewGroup paramViewGroup, LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(212016);
    this.context = paramContext;
    this.gGK = paramViewGroup;
    this.gGL = paramLiveConfig;
    this.gGM = paramBoolean;
    this.TAG = "MicroMsg.LiveUIRouter";
    paramContext = this.context.getSharedPreferences(aj.fkC(), 4);
    p.g(paramContext, "context.getSharedPrefere…ntext.MODE_MULTI_PROCESS)");
    this.sp = paramContext;
    this.gGE = new a(new Handler(Looper.getMainLooper()), (d.g.a.a)new d(this));
    this.gGF = new SparseArray();
    this.gGG = new SparseArray();
    this.gGJ = ((PhoneStateListener)new c(this));
    ad.i(this.TAG, "init");
    paramContext = this.gGF;
    paramViewGroup = f.j.gNB;
    paramContext.put(f.j.ank(), LiveAnchorPluginLayout.class);
    paramContext = this.gGF;
    paramViewGroup = f.j.gNB;
    paramContext.put(f.j.anl(), LiveVisitorPluginLayout.class);
    AppMethodBeat.o(212016);
  }
  
  public final void mY(int paramInt)
  {
    AppMethodBeat.i(212015);
    if (this.gGG.get(paramInt) == null)
    {
      Object localObject1 = this.gGF.get(paramInt);
      p.g(localObject1, "viewTable[toWhere]");
      localObject1 = (Class)localObject1;
      try
      {
        localObject1 = ((Class)localObject1).getConstructor(new Class[] { Context.class, AttributeSet.class }).newInstance(new Object[] { this.context, null });
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.live.view.BaseLivePluginLayout");
          AppMethodBeat.o(212015);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      }
    }
    for (;;)
    {
      Object localObject2 = this.gGH;
      this.gGH = ((BaseLivePluginLayout)this.gGG.get(paramInt));
      Object localObject3 = this.gGH;
      if (localObject3 != null) {
        ((BaseLivePluginLayout)localObject3).aoz();
      }
      localObject3 = this.gGH;
      if (localObject3 != null) {
        ((BaseLivePluginLayout)localObject3).bringToFront();
      }
      if (localObject2 == null) {
        break;
      }
      ((BaseLivePluginLayout)localObject2).pause();
      AppMethodBeat.o(212015);
      return;
      BaseLivePluginLayout localBaseLivePluginLayout = (BaseLivePluginLayout)localObject2;
      a locala = (a)this;
      localObject3 = this.gGL;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = LiveConfig.S("", LiveConfig.gGq);
        p.g(localObject2, "LiveConfig.getDefaultAnc…ig.SCENE_CHATTING_FOOTER)");
      }
      localBaseLivePluginLayout.a(locala, (LiveConfig)localObject2, this.gGM);
      this.gGG.put(paramInt, localBaseLivePluginLayout);
      this.gGK.addView((View)localBaseLivePluginLayout, new ViewGroup.LayoutParams(-1, -1));
      localBaseLivePluginLayout.setVisibility(8);
    }
    AppMethodBeat.o(212015);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(212014);
    ad.i(this.TAG, "onDestroy " + this.gGH);
    int j = this.gGG.size();
    int i = 0;
    while (i < j)
    {
      ((BaseLivePluginLayout)this.gGG.valueAt(i)).aoA();
      i += 1;
    }
    Object localObject = this.context.getSystemService("phone");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.telephony.TelephonyManager");
      AppMethodBeat.o(212014);
      throw ((Throwable)localObject);
    }
    ((TelephonyManager)localObject).listen(this.gGJ, 0);
    AppMethodBeat.o(212014);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/controller/LiveUIRouter$RotationSwitchObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "onChangCallback", "Lkotlin/Function0;", "", "(Landroid/os/Handler;Lkotlin/jvm/functions/Function0;)V", "mResolver", "Landroid/content/ContentResolver;", "getMResolver", "()Landroid/content/ContentResolver;", "setMResolver", "(Landroid/content/ContentResolver;)V", "getOnChangCallback", "()Lkotlin/jvm/functions/Function0;", "onChange", "selfChange", "", "startObserver", "stopObserver", "plugin-logic_release"})
  public static final class a
    extends ContentObserver
  {
    public ContentResolver gGN;
    private final d.g.a.a<z> gGO;
    
    public a(Handler paramHandler, d.g.a.a<z> parama)
    {
      super();
      AppMethodBeat.i(212009);
      this.gGO = parama;
      paramHandler = XWalkEnvironment.getContentResolver();
      p.g(paramHandler, "getContentResolver()");
      this.gGN = paramHandler;
      AppMethodBeat.o(212009);
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(212008);
      super.onChange(paramBoolean);
      d.g.a.a locala = this.gGO;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(212008);
        return;
      }
      AppMethodBeat.o(212008);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(212011);
      if (this.gGP.fQT == null)
      {
        localObject = this.gGP;
        Context localContext = this.gGP.context;
        if (localContext == null)
        {
          localObject = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(212011);
          throw ((Throwable)localObject);
        }
        ((b)localObject).fQT = new h((Activity)localContext);
        localObject = this.gGP.fQT;
        if (localObject != null) {
          ((h)localObject).setKeyboardHeightObserver((g)new g()
          {
            public final void u(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(212010);
              ad.i(this.gGQ.gGP.TAG, "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              Object localObject = this.gGQ.gGP;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true; ((b)localObject).gGI != paramAnonymousBoolean; paramAnonymousBoolean = false)
              {
                ((b)localObject).gGI = paramAnonymousBoolean;
                localObject = ((b)localObject).gGH;
                if (localObject == null) {
                  break;
                }
                ((BaseLivePluginLayout)localObject).i(paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(212010);
                return;
              }
              AppMethodBeat.o(212010);
            }
          });
        }
      }
      Object localObject = this.gGP.fQT;
      if (localObject != null)
      {
        ((h)localObject).start();
        AppMethodBeat.o(212011);
        return;
      }
      AppMethodBeat.o(212011);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/controller/LiveUIRouter$phoneStatelistener$1", "Landroid/telephony/PhoneStateListener;", "onCallStateChanged", "", "state", "", "incomingNumber", "", "plugin-logic_release"})
  public static final class c
    extends PhoneStateListener
  {
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(212012);
      p.h(paramString, "incomingNumber");
      BaseLivePluginLayout localBaseLivePluginLayout = this.gGP.gGH;
      if (localBaseLivePluginLayout != null)
      {
        localBaseLivePluginLayout.onCallStateChanged(paramInt, paramString);
        AppMethodBeat.o(212012);
        return;
      }
      AppMethodBeat.o(212012);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
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