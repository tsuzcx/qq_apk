package com.tencent.mm.plugin.forcenotify.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.forcenotify.a.c;
import com.tencent.mm.plugin.forcenotify.a.e;
import com.tencent.mm.plugin.forcenotify.a.f;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.forcenotify.d.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow;", "Landroid/view/View$OnKeyListener;", "()V", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "checkLockScreenTask", "Ljava/lang/Runnable;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItem;", "Lkotlin/collections/ArrayList;", "dividerHeight", "", "isHiding", "", "()Z", "setHiding", "(Z)V", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "()Landroid/app/KeyguardManager;", "keyguardManager$delegate", "maskBottomIv", "Landroid/widget/ImageView;", "maskTopIv", "playSoundRunnable", "powerManager", "Landroid/os/PowerManager;", "getPowerManager", "()Landroid/os/PowerManager;", "powerManager$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rootView", "Landroid/view/View;", "shown", "soundPlay", "Landroid/media/MediaPlayer;", "stopSoundTask", "titleTv", "Landroid/widget/TextView;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "uiHandler$delegate", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "vibrator$delegate", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "getWakeLock", "()Landroid/os/PowerManager$WakeLock;", "wakeLock$delegate", "windowManager", "Landroid/view/WindowManager;", "getWindowManager", "()Landroid/view/WindowManager;", "windowManager$delegate", "adjustWindowUI", "", "darkMode", "canListScroll", "checkNeedMask", "hide", "isPhoneLocking", "onCreate", "onHideWindow", "onKey", "v", "keyCode", "event", "Landroid/view/KeyEvent;", "onShowWindow", "onUpdateData", "add", "playPopupAnimation", "playScrollUpAnimation", "onAnimateEnd", "Lkotlin/Function0;", "playSound", "resetVibrateAndSound", "show", "update", "stopSound", "updateRecyclerViewHeight", "updateWindowTitle", "isFirstItemReachTop", "isLastItemReachBottom", "Companion", "plugin-force-notify_release"})
public final class b
  implements View.OnKeyListener
{
  public static final a BES;
  private static final kotlin.f kPd;
  private Runnable BEB;
  private ImageView BEH;
  private ImageView BEI;
  private final kotlin.f BEJ;
  private final kotlin.f BEK;
  private final kotlin.f BEL;
  private final kotlin.f BEM;
  private final kotlin.f BEN;
  private boolean BEO;
  private Runnable BEP;
  private Runnable BEQ;
  boolean BER;
  private MediaPlayer BEz;
  private final AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  private RecyclerView jLl;
  private final int jau;
  private final ArrayList<com.tencent.mm.plugin.forcenotify.d.e> mXB;
  private View oFW;
  private final kotlin.f pLA;
  private TextView titleTv;
  private final kotlin.f xwp;
  private final kotlin.f yWF;
  
  static
  {
    AppMethodBeat.i(252678);
    BES = new a((byte)0);
    kPd = kotlin.g.ar((kotlin.g.a.a)b.b.BET);
    AppMethodBeat.o(252678);
  }
  
  private b()
  {
    AppMethodBeat.i(252676);
    this.xwp = kotlin.g.ar((kotlin.g.a.a)b.e.BEW);
    this.pLA = kotlin.g.ar((kotlin.g.a.a)new b.d(this));
    this.BEJ = kotlin.g.ar((kotlin.g.a.a)new b.q(this));
    this.BEK = kotlin.g.ar((kotlin.g.a.a)new b.g(this));
    this.BEL = kotlin.g.ar((kotlin.g.a.a)new b.w(this));
    this.audioFocusChangeListener = ((AudioManager.OnAudioFocusChangeListener)b.c.BEU);
    this.BEM = kotlin.g.ar((kotlin.g.a.a)new b.x(this));
    this.yWF = kotlin.g.ar((kotlin.g.a.a)new b.v(this));
    this.BEN = kotlin.g.ar((kotlin.g.a.a)b.t.BFd);
    this.mXB = new ArrayList();
    this.BEP = ((Runnable)new s(this));
    this.BEB = ((Runnable)new b.p(this));
    this.jau = com.tencent.mm.ci.a.fromDPToPix(getContext(), 0.5F);
    AppMethodBeat.o(252676);
  }
  
  private final Vibrator eqq()
  {
    AppMethodBeat.i(252653);
    Vibrator localVibrator = (Vibrator)this.yWF.getValue();
    AppMethodBeat.o(252653);
    return localVibrator;
  }
  
  private final void eqr()
  {
    AppMethodBeat.i(252673);
    try
    {
      eqq().cancel();
      Object localObject = this.BEz;
      if (localObject != null) {
        ((MediaPlayer)localObject).stop();
      }
      localObject = this.BEz;
      if (localObject != null) {
        ((MediaPlayer)localObject).release();
      }
      localObject = getWakeLock();
      p.j(localObject, "wakeLock");
      if (((PowerManager.WakeLock)localObject).isHeld())
      {
        localObject = getWakeLock();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow", "stopSound", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        ((PowerManager.WakeLock)localObject).release();
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow", "stopSound", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      }
      getAudioManager().abandonAudioFocus(this.audioFocusChangeListener);
      AppMethodBeat.o(252673);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("ForceNotifyWindow", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(252673);
    }
  }
  
  private final void eqs()
  {
    AppMethodBeat.i(252656);
    RecyclerView localRecyclerView = this.jLl;
    if (localRecyclerView != null)
    {
      localRecyclerView.post((Runnable)new u(localRecyclerView, this));
      AppMethodBeat.o(252656);
      return;
    }
    AppMethodBeat.o(252656);
  }
  
  private final void eqt()
  {
    AppMethodBeat.i(252659);
    Object localObject = this.oFW;
    if (localObject != null)
    {
      TextView localTextView = (TextView)((View)localObject).findViewById(a.e.title_tv);
      if (localTextView != null)
      {
        if (this.mXB.size() > 1)
        {
          localObject = localTextView.getContext();
          p.j(localObject, "it.context");
          localTextView.setText((CharSequence)((Context)localObject).getResources().getString(a.h.force_notify));
          AppMethodBeat.o(252659);
          return;
        }
        localObject = (com.tencent.mm.plugin.forcenotify.d.e)j.lp((List)this.mXB);
        if (localObject != null)
        {
          localObject = Integer.valueOf(((com.tencent.mm.plugin.forcenotify.d.e)localObject).bAQ());
          if (localObject != null) {
            break label148;
          }
        }
        label148:
        while (((Integer)localObject).intValue() != 1)
        {
          localObject = localTextView.getContext();
          p.j(localObject, "it.context");
          localTextView.setText((CharSequence)((Context)localObject).getResources().getString(a.h.force_notify_msg));
          AppMethodBeat.o(252659);
          return;
          localObject = null;
          break;
        }
        localObject = localTextView.getContext();
        p.j(localObject, "it.context");
        localTextView.setText((CharSequence)((Context)localObject).getResources().getString(a.h.force_notify_live));
        AppMethodBeat.o(252659);
        return;
      }
    }
    AppMethodBeat.o(252659);
  }
  
  private final void eqv()
  {
    AppMethodBeat.i(252674);
    getUiHandler().removeCallbacksAndMessages(null);
    this.BEP.run();
    AppMethodBeat.o(252674);
  }
  
  private final AudioManager getAudioManager()
  {
    AppMethodBeat.i(252651);
    AudioManager localAudioManager = (AudioManager)this.pLA.getValue();
    AppMethodBeat.o(252651);
    return localAudioManager;
  }
  
  private final Context getContext()
  {
    AppMethodBeat.i(252650);
    Context localContext = (Context)this.xwp.getValue();
    AppMethodBeat.o(252650);
    return localContext;
  }
  
  private final MMHandler getUiHandler()
  {
    AppMethodBeat.i(252655);
    MMHandler localMMHandler = (MMHandler)this.BEN.getValue();
    AppMethodBeat.o(252655);
    return localMMHandler;
  }
  
  private final PowerManager.WakeLock getWakeLock()
  {
    AppMethodBeat.i(252652);
    PowerManager.WakeLock localWakeLock = (PowerManager.WakeLock)this.BEL.getValue();
    AppMethodBeat.o(252652);
    return localWakeLock;
  }
  
  private static boolean x(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(252665);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.findViewByPosition(0);
      if (paramRecyclerView != null)
      {
        if (paramRecyclerView.getTop() >= 0)
        {
          AppMethodBeat.o(252665);
          return true;
        }
        AppMethodBeat.o(252665);
        return false;
      }
    }
    AppMethodBeat.o(252665);
    return false;
  }
  
  private static boolean y(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(252668);
    Object localObject = paramRecyclerView.getLayoutManager();
    if (localObject != null)
    {
      Rect localRect = new Rect();
      if ((localObject instanceof LinearLayoutManager))
      {
        int i = ((LinearLayoutManager)localObject).kL();
        if (i == ((LinearLayoutManager)localObject).getItemCount() - 1)
        {
          localObject = ((RecyclerView.LayoutManager)localObject).findViewByPosition(i);
          if (localObject != null)
          {
            RecyclerView.getDecoratedBoundsWithMargins((View)localObject, localRect);
            if (localRect.bottom <= paramRecyclerView.getHeight())
            {
              ((View)localObject).getHitRect(localRect);
              if (localRect.bottom <= paramRecyclerView.getHeight())
              {
                AppMethodBeat.o(252668);
                return true;
              }
              AppMethodBeat.o(252668);
              return false;
            }
          }
        }
      }
    }
    AppMethodBeat.o(252668);
    return false;
  }
  
  public final void equ()
  {
    AppMethodBeat.i(252660);
    Object localObject = com.tencent.mm.plugin.forcenotify.f.a.BFf;
    localObject = getContext();
    p.j(localObject, "context");
    if (!com.tencent.mm.plugin.forcenotify.f.a.gm((Context)localObject))
    {
      AppMethodBeat.o(252660);
      return;
    }
    com.tencent.e.h.ZvG.bc((Runnable)new r(this, true));
    AppMethodBeat.o(252660);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(252662);
    com.tencent.e.h.ZvG.bc((Runnable)new f(this));
    AppMethodBeat.o(252662);
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252675);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.bn(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 1)) {
      eqv();
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(252675);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$Companion;", "", "()V", "LIST_ITEM_COUNT_MAX", "", "TAG", "", "instance", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow;", "instance$annotations", "getInstance", "()Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow;", "instance$delegate", "Lkotlin/Lazy;", "plugin-force-notify_release"})
  public static final class a
  {
    public static b eqw()
    {
      AppMethodBeat.i(254041);
      Object localObject = b.aRW();
      a locala = b.BES;
      localObject = (b)((kotlin.f)localObject).getValue();
      AppMethodBeat.o(254041);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(253467);
      if (b.h(this.BEV))
      {
        b.b(this.BEV, false);
        View localView = b.c(this.BEV);
        if (localView != null) {
          localView.setVisibility(8);
        }
      }
      try
      {
        b.j(this.BEV).removeView(b.c(this.BEV));
        b.p(this.BEV);
        b.a(this.BEV, null);
        b.a(this.BEV, null);
        b.a(this.BEV, null);
        b.b(this.BEV, null);
        AppMethodBeat.o(253467);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("ForceNotifyWindow", "ForceNotifyWindow dettach from window failed!");
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$onShowWindow$4$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-force-notify_release"})
  public static final class h
    implements h.c<com.tencent.mm.view.recyclerview.i>
  {
    h(WxRecyclerAdapter paramWxRecyclerAdapter, b paramb) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(253066);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$onShowWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (!this.BEV.BER)
      {
        ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.a.class)).a(3, 0, "", b.a(this.BEV).size(), "");
        this.BEV.hide();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$onShowWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(253066);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    j(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$onShowWindow$3", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-force-notify_release"})
  public static final class k
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(252983);
      switch (paramInt)
      {
      default: 
        locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.forcenotify.b.c();
        AppMethodBeat.o(252983);
        return locale;
      case 0: 
        locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.forcenotify.b.c();
        AppMethodBeat.o(252983);
        return locale;
      }
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.forcenotify.b.b();
      AppMethodBeat.o(252983);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(252601);
      if (b.l(this.BEV))
      {
        b.m(this.BEV);
        AppMethodBeat.o(252601);
        return;
      }
      b.n(this.BEV).postDelayed(b.o(this.BEV), 100L);
      AppMethodBeat.o(252601);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(b paramb, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(253238);
      Object localObject1;
      Object localObject2;
      Object localObject3;
      int j;
      if (this.BFa)
      {
        localObject1 = com.tencent.mm.plugin.forcenotify.d.f.BDU;
        localObject2 = f.a.eql().eqk();
        if (localObject2 != null)
        {
          b.a(this.BEV).add(0, localObject2);
          localObject1 = b.g(this.BEV);
          if (localObject1 != null)
          {
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null) {
              ((RecyclerView.a)localObject1).cM(0);
            }
          }
          b.a(this.BEV, true);
          localObject1 = b.g(this.BEV);
          if (localObject1 != null)
          {
            localObject3 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aFh(), "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$show$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).sf(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$show$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          }
          localObject1 = b.g(this.BEV);
          if (localObject1 != null) {
            ((RecyclerView)localObject1).post((Runnable)new a(this));
          }
          if (!(localObject2 instanceof com.tencent.mm.plugin.forcenotify.d.h)) {
            break label818;
          }
          localObject1 = ((com.tencent.mm.plugin.forcenotify.d.h)localObject2).username;
          j = 1;
        }
      }
      for (;;)
      {
        localObject3 = (com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.a.class);
        com.tencent.mm.plugin.forcenotify.c.c localc = com.tencent.mm.plugin.forcenotify.c.c.BDQ;
        Context localContext = b.e(this.BEV);
        p.j(localContext, "context");
        int i;
        if (localc.gk(localContext))
        {
          localc = com.tencent.mm.plugin.forcenotify.c.c.BDQ;
          localContext = b.e(this.BEV);
          p.j(localContext, "context");
          if (localc.gl(localContext))
          {
            i = 1;
            label291:
            ((com.tencent.mm.plugin.forcenotify.a.a)localObject3).a((String)localObject1, i, j, ((com.tencent.mm.plugin.forcenotify.d.e)localObject2).BDR, false);
            if (!b.h(this.BEV))
            {
              b.a(this.BEV, LayoutInflater.from(b.e(this.BEV)).inflate(a.f.force_notify_window_ui, null));
              localObject2 = this.BEV;
              localObject1 = b.c(this.BEV);
              if (localObject1 == null) {
                break label897;
              }
              localObject1 = (RecyclerView)((View)localObject1).findViewById(a.e.rv_list);
              label375:
              b.a((b)localObject2, (RecyclerView)localObject1);
              localObject2 = this.BEV;
              localObject1 = b.c(this.BEV);
              if (localObject1 == null) {
                break label903;
              }
              localObject1 = (TextView)((View)localObject1).findViewById(a.e.title_tv);
              label415:
              b.a((b)localObject2, (TextView)localObject1);
              localObject2 = this.BEV;
              localObject1 = b.c(this.BEV);
              if (localObject1 == null) {
                break label909;
              }
              localObject1 = (ImageView)((View)localObject1).findViewById(a.e.force_notify_mask_top_down_iv);
              label455:
              b.a((b)localObject2, (ImageView)localObject1);
              localObject2 = this.BEV;
              localObject1 = b.c(this.BEV);
              if (localObject1 == null) {
                break label915;
              }
              localObject1 = (ImageView)((View)localObject1).findViewById(a.e.force_notify_mask_bottom_up_iv);
              label495:
              b.b((b)localObject2, (ImageView)localObject1);
              b.c(this.BEV, ar.isDarkMode());
              localObject1 = new WindowManager.LayoutParams();
              if (!d.qV(26)) {
                break label921;
              }
              i = 2038;
              ((WindowManager.LayoutParams)localObject1).type = i;
              ((WindowManager.LayoutParams)localObject1).format = -2;
              localObject2 = b.e(this.BEV);
              p.j(localObject2, "context");
              ((WindowManager.LayoutParams)localObject1).packageName = ((Context)localObject2).getPackageName();
              ((WindowManager.LayoutParams)localObject1).gravity = 48;
              ((WindowManager.LayoutParams)localObject1).flags = 1064;
              localObject2 = b.e(this.BEV);
              p.j(localObject2, "context");
              ((WindowManager.LayoutParams)localObject1).horizontalMargin = ((Context)localObject2).getResources().getDimensionPixelSize(a.c.Edge_A);
              ((WindowManager.LayoutParams)localObject1).width = -1;
              ((WindowManager.LayoutParams)localObject1).height = -2;
              localObject2 = b.i(this.BEV);
              p.j(localObject2, "wakeLock");
              if (!((PowerManager.WakeLock)localObject2).isHeld())
              {
                localObject2 = b.i(this.BEV);
                localObject3 = com.tencent.mm.hellhoundlib.b.c.a(120000L, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aFh(), "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$show$1", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
                long l = ((Long)com.tencent.mm.hellhoundlib.b.c.a((com.tencent.mm.hellhoundlib.b.a)localObject3).sf(0)).longValue();
                com.tencent.mm.hellhoundlib.b.c.aFj();
                ((PowerManager.WakeLock)localObject2).acquire(l);
                com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$show$1", "run", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
              }
              localObject2 = b.c(this.BEV);
              if (localObject2 != null) {
                ((View)localObject2).setVisibility(0);
              }
            }
          }
        }
        try
        {
          b.j(this.BEV).addView(b.c(this.BEV), (ViewGroup.LayoutParams)localObject1);
          b.k(this.BEV);
          b.b(this.BEV, true);
          AppMethodBeat.o(253238);
          return;
          label818:
          if ((localObject2 instanceof com.tencent.mm.plugin.forcenotify.d.g))
          {
            j = 2;
            localObject1 = ((com.tencent.mm.plugin.forcenotify.d.g)localObject2).feedId;
            continue;
          }
          localObject1 = "";
          j = -1;
          continue;
          i = 4;
          break label291;
          localc = com.tencent.mm.plugin.forcenotify.c.c.BDQ;
          localContext = b.e(this.BEV);
          p.j(localContext, "context");
          if (localc.gl(localContext))
          {
            i = 3;
            break label291;
          }
          i = 2;
          break label291;
          label897:
          localObject1 = null;
          break label375;
          label903:
          localObject1 = null;
          break label415;
          label909:
          localObject1 = null;
          break label455;
          label915:
          localObject1 = null;
          break label495;
          label921:
          i = 2002;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("ForceNotifyWindow", "ForceNotifyWindow attach to window failed!");
          }
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$show$1$1$1"})
    static final class a
      implements Runnable
    {
      a(b.r paramr) {}
      
      public final void run()
      {
        AppMethodBeat.i(253398);
        b.d(this.BFb.BEV);
        AppMethodBeat.o(253398);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(253859);
      b.m(this.BEV);
      b.n(this.BEV).removeCallbacks(b.o(this.BEV));
      AppMethodBeat.o(253859);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyWindow$updateRecyclerViewHeight$1$1"})
  static final class u
    implements Runnable
  {
    u(RecyclerView paramRecyclerView, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(252993);
      Object localObject1 = this.xMC.getChildAt(0);
      Object localObject2;
      int i;
      int j;
      int k;
      if (localObject1 != null)
      {
        if (b.a(jdField_this).size() != 1) {
          break label169;
        }
        localObject2 = b.c(jdField_this);
        if (localObject2 != null)
        {
          localObject2 = ((View)localObject2).findViewById(a.e.title_divider);
          if (localObject2 != null) {
            ((View)localObject2).setVisibility(8);
          }
        }
        i = ((View)localObject1).getPaddingLeft();
        j = ((View)localObject1).getPaddingTop();
        k = ((View)localObject1).getPaddingEnd();
        localObject2 = b.e(jdField_this);
        p.j(localObject2, "context");
        ((View)localObject1).setPadding(i, j, k, (int)((Context)localObject2).getResources().getDimension(a.c.Edge_2_5_A));
      }
      while (b.a(jdField_this).size() <= 3)
      {
        localObject1 = this.xMC.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = -2;
        this.xMC.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(252993);
        return;
        label169:
        localObject2 = b.c(jdField_this);
        if (localObject2 != null)
        {
          localObject2 = ((View)localObject2).findViewById(a.e.title_divider);
          if (localObject2 != null) {
            ((View)localObject2).setVisibility(0);
          }
        }
        i = ((View)localObject1).getPaddingLeft();
        j = ((View)localObject1).getPaddingTop();
        k = ((View)localObject1).getPaddingEnd();
        localObject2 = b.e(jdField_this);
        p.j(localObject2, "context");
        ((View)localObject1).setPadding(i, j, k, (int)((Context)localObject2).getResources().getDimension(a.c.Edge_2A));
      }
      localObject1 = this.xMC.getChildAt(0);
      if (localObject1 != null)
      {
        i = ((View)localObject1).getHeight();
        j = b.f(jdField_this);
        localObject1 = this.xMC.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = (i * 3 + j * 2);
        this.xMC.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(252993);
        return;
      }
      AppMethodBeat.o(252993);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.b
 * JD-Core Version:    0.7.0.1
 */