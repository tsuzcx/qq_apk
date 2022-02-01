package com.tencent.mm.live.a;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.lang.reflect.Constructor;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/controller/LiveUIRouter;", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "provider", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/live/api/LiveConfig;Z)V", "TAG", "", "currentView", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "()Z", "isKeyBoardShow", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "phoneStatelistener", "Landroid/telephony/PhoneStateListener;", "getProvider", "()Lcom/tencent/mm/live/api/LiveConfig;", "rotationSwitchObserver", "Lcom/tencent/mm/live/controller/LiveUIRouter$RotationSwitchObserver;", "sp", "Landroid/content/SharedPreferences;", "viewMap", "Landroid/util/SparseArray;", "viewTable", "Ljava/lang/Class;", "keyboardChange", "", "show", "height", "", "loadViewFromClass", "key", "clazz", "maximizeUi", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "onDestroy", "onPause", "onResume", "onStart", "onStop", "route", "toWhere", "RotationSwitchObserver", "plugin-logic_release"})
public final class b
  implements a
{
  public final String TAG;
  public final Context context;
  public h fSZ;
  public final b.a gJn;
  private final SparseArray<Class<?>> gJo;
  private final SparseArray<BaseLivePluginLayout> gJp;
  public BaseLivePluginLayout gJq;
  boolean gJr;
  public final PhoneStateListener gJs;
  private final ViewGroup gJt;
  private final LiveConfig gJu;
  private final boolean gJv;
  public final SharedPreferences sp;
  
  public b(Context paramContext, ViewGroup paramViewGroup, LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(215635);
    this.context = paramContext;
    this.gJt = paramViewGroup;
    this.gJu = paramLiveConfig;
    this.gJv = paramBoolean;
    this.TAG = "MicroMsg.LiveUIRouter";
    paramContext = this.context.getSharedPreferences(ak.fow(), 4);
    p.g(paramContext, "context.getSharedPrefere…ntext.MODE_MULTI_PROCESS)");
    this.sp = paramContext;
    this.gJn = new b.a(new Handler(Looper.getMainLooper()), (d.g.a.a)new d(this));
    this.gJo = new SparseArray();
    this.gJp = new SparseArray();
    this.gJs = ((PhoneStateListener)new c(this));
    ae.i(this.TAG, "init");
    paramContext = this.gJo;
    paramViewGroup = f.j.gQk;
    paramContext.put(f.j.anA(), LiveAnchorPluginLayout.class);
    paramContext = this.gJo;
    paramViewGroup = f.j.gQk;
    paramContext.put(f.j.anB(), LiveVisitorPluginLayout.class);
    AppMethodBeat.o(215635);
  }
  
  public final void nb(int paramInt)
  {
    AppMethodBeat.i(215634);
    if (this.gJp.get(paramInt) == null)
    {
      Object localObject1 = this.gJo.get(paramInt);
      p.g(localObject1, "viewTable[toWhere]");
      localObject1 = (Class)localObject1;
      try
      {
        localObject1 = ((Class)localObject1).getConstructor(new Class[] { Context.class, AttributeSet.class }).newInstance(new Object[] { this.context, null });
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.live.view.BaseLivePluginLayout");
          AppMethodBeat.o(215634);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
      }
    }
    for (;;)
    {
      Object localObject2 = this.gJq;
      this.gJq = ((BaseLivePluginLayout)this.gJp.get(paramInt));
      Object localObject3 = this.gJq;
      if (localObject3 != null) {
        ((BaseLivePluginLayout)localObject3).aoO();
      }
      localObject3 = this.gJq;
      if (localObject3 != null) {
        ((BaseLivePluginLayout)localObject3).bringToFront();
      }
      if (localObject2 == null) {
        break;
      }
      ((BaseLivePluginLayout)localObject2).pause();
      AppMethodBeat.o(215634);
      return;
      BaseLivePluginLayout localBaseLivePluginLayout = (BaseLivePluginLayout)localObject2;
      a locala = (a)this;
      localObject3 = this.gJu;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = LiveConfig.T("", LiveConfig.gIZ);
        p.g(localObject2, "LiveConfig.getDefaultAnc…ig.SCENE_CHATTING_FOOTER)");
      }
      localBaseLivePluginLayout.a(locala, (LiveConfig)localObject2, this.gJv);
      this.gJp.put(paramInt, localBaseLivePluginLayout);
      this.gJt.addView((View)localBaseLivePluginLayout, new ViewGroup.LayoutParams(-1, -1));
      localBaseLivePluginLayout.setVisibility(8);
    }
    AppMethodBeat.o(215634);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(215633);
    ae.i(this.TAG, "onDestroy " + this.gJq);
    int j = this.gJp.size();
    int i = 0;
    while (i < j)
    {
      ((BaseLivePluginLayout)this.gJp.valueAt(i)).aoP();
      i += 1;
    }
    Object localObject = this.context.getSystemService("phone");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.telephony.TelephonyManager");
      AppMethodBeat.o(215633);
      throw ((Throwable)localObject);
    }
    ((TelephonyManager)localObject).listen(this.gJs, 0);
    AppMethodBeat.o(215633);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(215630);
      if (this.gJy.fSZ == null)
      {
        localObject = this.gJy;
        Context localContext = this.gJy.context;
        if (localContext == null)
        {
          localObject = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(215630);
          throw ((Throwable)localObject);
        }
        ((b)localObject).fSZ = new h((Activity)localContext);
        localObject = this.gJy.fSZ;
        if (localObject != null) {
          ((h)localObject).setKeyboardHeightObserver((g)new g()
          {
            public final void u(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(215629);
              ae.i(this.gJz.gJy.TAG, "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              Object localObject = this.gJz.gJy;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true; ((b)localObject).gJr != paramAnonymousBoolean; paramAnonymousBoolean = false)
              {
                ((b)localObject).gJr = paramAnonymousBoolean;
                localObject = ((b)localObject).gJq;
                if (localObject == null) {
                  break;
                }
                ((BaseLivePluginLayout)localObject).i(paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(215629);
                return;
              }
              AppMethodBeat.o(215629);
            }
          });
        }
      }
      Object localObject = this.gJy.fSZ;
      if (localObject != null)
      {
        ((h)localObject).start();
        AppMethodBeat.o(215630);
        return;
      }
      AppMethodBeat.o(215630);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/controller/LiveUIRouter$phoneStatelistener$1", "Landroid/telephony/PhoneStateListener;", "onCallStateChanged", "", "state", "", "incomingNumber", "", "plugin-logic_release"})
  public static final class c
    extends PhoneStateListener
  {
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(215631);
      p.h(paramString, "incomingNumber");
      BaseLivePluginLayout localBaseLivePluginLayout = this.gJy.gJq;
      if (localBaseLivePluginLayout != null)
      {
        localBaseLivePluginLayout.onCallStateChanged(paramInt, paramString);
        AppMethodBeat.o(215631);
        return;
      }
      AppMethodBeat.o(215631);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.a.b
 * JD-Core Version:    0.7.0.1
 */