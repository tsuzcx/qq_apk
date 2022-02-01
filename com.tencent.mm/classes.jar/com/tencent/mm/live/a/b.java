package com.tencent.mm.live.a;

import android.app.Activity;
import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e.j;
import com.tencent.mm.live.view.BaseLivePluginLayout;
import com.tencent.mm.live.view.LiveAnchorPluginLayout;
import com.tencent.mm.live.view.LiveVisitorPluginLayout;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import d.g.b.k;
import d.l;
import d.v;
import java.lang.reflect.Constructor;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/controller/LiveUIRouter;", "Lcom/tencent/mm/live/controller/ILiveUINavigation;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "provider", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/live/api/LiveConfig;Z)V", "TAG", "", "currentView", "Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "()Z", "isKeyBoardShow", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "phoneStatelistener", "Landroid/telephony/PhoneStateListener;", "getProvider", "()Lcom/tencent/mm/live/api/LiveConfig;", "viewMap", "Landroid/util/SparseArray;", "viewTable", "Ljava/lang/Class;", "keyboardChange", "", "show", "height", "", "loadViewFromClass", "key", "clazz", "maximizeUi", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "onDestroy", "onPause", "onResume", "onStart", "onStop", "route", "toWhere", "plugin-logic_release"})
public final class b
  implements a
{
  public final String TAG;
  public final Context context;
  public h ftZ;
  private final boolean goa;
  private boolean mEv;
  private final ViewGroup pTc;
  private final LiveConfig qvZ;
  public BaseLivePluginLayout qvu;
  public final PhoneStateListener qvx;
  private final SparseArray<Class<?>> vcI;
  private final SparseArray<BaseLivePluginLayout> vcJ;
  
  public b(Context paramContext, ViewGroup paramViewGroup, LiveConfig paramLiveConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(202558);
    this.context = paramContext;
    this.pTc = paramViewGroup;
    this.qvZ = paramLiveConfig;
    this.goa = paramBoolean;
    this.TAG = "MicroMsg.LiveUIRouter";
    this.vcI = new SparseArray();
    this.vcJ = new SparseArray();
    this.qvx = ((PhoneStateListener)new b(this));
    ad.i(this.TAG, "init");
    paramContext = this.vcI;
    paramViewGroup = e.j.rFK;
    paramContext.put(e.j.eNz(), LiveAnchorPluginLayout.class);
    paramContext = this.vcI;
    paramViewGroup = e.j.rFK;
    paramContext.put(e.j.eNA(), LiveVisitorPluginLayout.class);
    AppMethodBeat.o(202558);
  }
  
  public final void By(int paramInt)
  {
    AppMethodBeat.i(202557);
    if (this.vcJ.get(paramInt) == null)
    {
      Object localObject1 = this.vcI.get(paramInt);
      k.g(localObject1, "viewTable[toWhere]");
      localObject1 = (Class)localObject1;
      try
      {
        localObject1 = ((Class)localObject1).getConstructor(new Class[] { Context.class, AttributeSet.class }).newInstance(new Object[] { this.context, null });
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.live.view.BaseLivePluginLayout");
          AppMethodBeat.o(202557);
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
      Object localObject2 = this.qvu;
      this.qvu = ((BaseLivePluginLayout)this.vcJ.get(paramInt));
      Object localObject3 = this.qvu;
      if (localObject3 != null) {
        ((BaseLivePluginLayout)localObject3).fOM();
      }
      localObject3 = this.qvu;
      if (localObject3 != null) {
        ((BaseLivePluginLayout)localObject3).bringToFront();
      }
      if (localObject2 == null) {
        break;
      }
      ((BaseLivePluginLayout)localObject2).pause();
      AppMethodBeat.o(202557);
      return;
      BaseLivePluginLayout localBaseLivePluginLayout = (BaseLivePluginLayout)localObject2;
      a locala = (a)this;
      localObject3 = this.qvZ;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = LiveConfig.db("", LiveConfig.qsG);
        k.g(localObject2, "LiveConfig.getDefaultAnc…ig.SCENE_CHATTING_FOOTER)");
      }
      localBaseLivePluginLayout.a(locala, (LiveConfig)localObject2, this.goa);
      this.vcJ.put(paramInt, localBaseLivePluginLayout);
      this.pTc.addView((View)localBaseLivePluginLayout, new ViewGroup.LayoutParams(-1, -1));
      localBaseLivePluginLayout.setVisibility(8);
    }
    AppMethodBeat.o(202557);
  }
  
  public final void X(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(202556);
    if (this.mEv == paramBoolean)
    {
      AppMethodBeat.o(202556);
      return;
    }
    this.mEv = paramBoolean;
    Object localObject = this.qvu;
    if (localObject != null)
    {
      localObject = ((Iterable)((BaseLivePluginLayout)localObject).vnf).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.live.c.a)((Iterator)localObject).next()).X(paramBoolean, paramInt);
      }
      AppMethodBeat.o(202556);
      return;
    }
    AppMethodBeat.o(202556);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202555);
    ad.i(this.TAG, "onDestroy " + this.qvu);
    int j = this.vcJ.size();
    int i = 0;
    while (i < j)
    {
      ((BaseLivePluginLayout)this.vcJ.valueAt(i)).fON();
      i += 1;
    }
    Object localObject = this.context.getSystemService("phone");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.telephony.TelephonyManager");
      AppMethodBeat.o(202555);
      throw ((Throwable)localObject);
    }
    ((TelephonyManager)localObject).listen(this.qvx, 0);
    AppMethodBeat.o(202555);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class a
    implements Runnable
  {
    public a(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(202553);
      if (this.qwa.ftZ == null)
      {
        localObject = this.qwa;
        Context localContext = this.qwa.context;
        if (localContext == null)
        {
          localObject = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(202553);
          throw ((Throwable)localObject);
        }
        ((b)localObject).ftZ = new h((Activity)localContext);
        localObject = this.qwa.ftZ;
        if (localObject != null) {
          ((h)localObject).setKeyboardHeightObserver((g)new g()
          {
            public final void u(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(202552);
              ad.i(this.qwo.qwa.TAG, "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              b localb = this.qwo.qwa;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                localb.X(paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(202552);
                return;
              }
            }
          });
        }
      }
      Object localObject = this.qwa.ftZ;
      if (localObject != null)
      {
        ((h)localObject).start();
        AppMethodBeat.o(202553);
        return;
      }
      AppMethodBeat.o(202553);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/controller/LiveUIRouter$phoneStatelistener$1", "Landroid/telephony/PhoneStateListener;", "onCallStateChanged", "", "state", "", "incomingNumber", "", "plugin-logic_release"})
  public static final class b
    extends PhoneStateListener
  {
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(202554);
      k.h(paramString, "incomingNumber");
      BaseLivePluginLayout localBaseLivePluginLayout = this.qwa.qvu;
      if (localBaseLivePluginLayout != null)
      {
        localBaseLivePluginLayout.onCallStateChanged(paramInt, paramString);
        AppMethodBeat.o(202554);
        return;
      }
      AppMethodBeat.o(202554);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.a.b
 * JD-Core Version:    0.7.0.1
 */