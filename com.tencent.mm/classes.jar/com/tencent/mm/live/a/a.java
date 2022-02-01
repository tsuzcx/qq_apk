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
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.model.l.j;
import com.tencent.mm.live.view.BaseLivePluginLayout;
import com.tencent.mm.live.view.LiveAnchorPluginLayout;
import com.tencent.mm.live.view.LiveVisitorPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.tools.i;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/controller/LiveUIRouter;", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "provider", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/live/api/LiveConfig;Z)V", "TAG", "", "currentView", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "()Z", "isKeyBoardShow", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "phoneStatelistener", "Landroid/telephony/PhoneStateListener;", "getProvider", "()Lcom/tencent/mm/live/api/LiveConfig;", "rotationSwitchObserver", "Lcom/tencent/mm/live/controller/LiveUIRouter$RotationSwitchObserver;", "sp", "Landroid/content/SharedPreferences;", "viewMap", "Landroid/util/SparseArray;", "viewTable", "Ljava/lang/Class;", "keyboardChange", "", "show", "height", "", "loadViewFromClass", "key", "clazz", "maximizeUi", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "route", "toWhere", "RotationSwitchObserver", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public final String TAG;
  public final Context context;
  private final boolean isFinished;
  public i lKz;
  private final ViewGroup mJe;
  private final LiveConfig mJf;
  public final a.a mJg;
  private final SparseArray<Class<?>> mJh;
  private final SparseArray<BaseLivePluginLayout> mJi;
  public BaseLivePluginLayout mJj;
  private boolean mJk;
  public final PhoneStateListener mJl;
  public final SharedPreferences sp;
  
  public a(Context paramContext, ViewGroup paramViewGroup, LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(245972);
    this.context = paramContext;
    this.mJe = paramViewGroup;
    this.mJf = paramLiveConfig;
    this.isFinished = paramBoolean;
    this.TAG = "MicroMsg.LiveUIRouter";
    paramContext = this.context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 4);
    s.s(paramContext, "context.getSharedPrefere…ntext.MODE_MULTI_PROCESS)");
    this.sp = paramContext;
    this.mJg = new a.a(new Handler(Looper.getMainLooper()), (kotlin.g.a.a)new c(this));
    this.mJh = new SparseArray();
    this.mJi = new SparseArray();
    this.mJl = ((PhoneStateListener)new b(this));
    Log.i(this.TAG, "init");
    paramContext = this.mJh;
    paramViewGroup = l.j.mYK;
    paramContext.put(l.j.bhE(), LiveAnchorPluginLayout.class);
    paramContext = this.mJh;
    paramViewGroup = l.j.mYK;
    paramContext.put(l.j.bhF(), LiveVisitorPluginLayout.class);
    AppMethodBeat.o(245972);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(245988);
    s.u(parama, "this$0");
    if (parama.lKz == null)
    {
      parama.lKz = new i((Activity)parama.context);
      i locali = parama.lKz;
      if (locali != null) {
        locali.afIL = new a..ExternalSyntheticLambda0(parama);
      }
    }
    parama = parama.lKz;
    if (parama != null) {
      parama.start();
    }
    AppMethodBeat.o(245988);
  }
  
  private static final void a(a parama, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(245978);
    s.u(parama, "this$0");
    Log.i(parama.TAG, "onKeyboardHeightChanged, height:" + paramInt + ", isResized:" + paramBoolean);
    if (paramInt > 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (parama.mJk != paramBoolean)
      {
        parama.mJk = paramBoolean;
        parama = parama.mJj;
        if (parama != null) {
          parama.keyboardChange(paramBoolean, paramInt);
        }
      }
      AppMethodBeat.o(245978);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(246026);
    Log.i(this.TAG, s.X("onDestroy ", this.mJj));
    int k = this.mJi.size();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      ((BaseLivePluginLayout)this.mJi.valueAt(i)).unMount();
      if (j >= k)
      {
        Object localObject1 = this.context.getSystemService("phone");
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
          AppMethodBeat.o(246026);
          throw ((Throwable)localObject1);
        }
        localObject1 = (TelephonyManager)localObject1;
        Object localObject2 = this.mJl;
        localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/live/controller/LiveUIRouter", "onDestroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/live/controller/LiveUIRouter", "onDestroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        AppMethodBeat.o(246026);
        return;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(246013);
    Log.i(this.TAG, s.X("onResume ", this.mJj));
    BaseLivePluginLayout localBaseLivePluginLayout = this.mJj;
    if (localBaseLivePluginLayout != null) {
      localBaseLivePluginLayout.resume();
    }
    localBaseLivePluginLayout = this.mJj;
    if (localBaseLivePluginLayout != null) {
      localBaseLivePluginLayout.post(new a..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(246013);
  }
  
  public final void sL(int paramInt)
  {
    AppMethodBeat.i(246039);
    if (this.mJi.get(paramInt) == null)
    {
      Object localObject1 = this.mJh.get(paramInt);
      s.s(localObject1, "viewTable[toWhere]");
      localObject1 = (Class)localObject1;
      try
      {
        localObject1 = ((Class)localObject1).getConstructor(new Class[] { Context.class, AttributeSet.class }).newInstance(new Object[] { this.context, null });
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.live.view.BaseLivePluginLayout");
          AppMethodBeat.o(246039);
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
      Object localObject2 = this.mJj;
      this.mJj = ((BaseLivePluginLayout)this.mJi.get(paramInt));
      Object localObject3 = this.mJj;
      if (localObject3 != null) {
        ((BaseLivePluginLayout)localObject3).mount();
      }
      localObject3 = this.mJj;
      if (localObject3 != null) {
        ((BaseLivePluginLayout)localObject3).bringToFront();
      }
      if (localObject2 != null) {
        ((BaseLivePluginLayout)localObject2).pause();
      }
      AppMethodBeat.o(246039);
      return;
      BaseLivePluginLayout localBaseLivePluginLayout = (BaseLivePluginLayout)localObject2;
      localObject3 = this.mJf;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = LiveConfig.aw("", LiveConfig.mIr);
      }
      s.s(localObject2, "provider ?: LiveConfig.g…ig.SCENE_CHATTING_FOOTER)");
      localBaseLivePluginLayout.initLogic((LiveConfig)localObject2, this.isFinished);
      this.mJi.put(paramInt, localBaseLivePluginLayout);
      this.mJe.addView((View)localBaseLivePluginLayout, new ViewGroup.LayoutParams(-1, -1));
      localBaseLivePluginLayout.setVisibility(8);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/controller/LiveUIRouter$phoneStatelistener$1", "Landroid/telephony/PhoneStateListener;", "onCallStateChanged", "", "state", "", "incomingNumber", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends PhoneStateListener
  {
    b(a parama) {}
    
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(245963);
      s.u(paramString, "incomingNumber");
      BaseLivePluginLayout localBaseLivePluginLayout = this.mJo.mJj;
      if (localBaseLivePluginLayout != null) {
        localBaseLivePluginLayout.onCallStateChanged(paramInt, paramString);
      }
      AppMethodBeat.o(245963);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.a.a
 * JD-Core Version:    0.7.0.1
 */