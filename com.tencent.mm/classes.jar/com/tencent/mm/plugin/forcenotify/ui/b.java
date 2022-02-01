package com.tencent.mm.plugin.forcenotify.ui;

import android.app.KeyguardManager;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.plugin.forcenotify.a.e;
import com.tencent.mm.plugin.forcenotify.a.f;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.forcenotify.b.d;
import com.tencent.mm.plugin.forcenotify.b.e;
import com.tencent.mm.plugin.forcenotify.ui.view.StackLayoutManager;
import com.tencent.mm.plugin.forcenotify.ui.view.StackLayoutManager.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.PlaySound.SPEAKERON;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.threadpool.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/ui/MsgWindow;", "Lcom/tencent/mm/plugin/forcenotify/ui/BaseWindow;", "()V", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "checkLockScreenTask", "Ljava/lang/Runnable;", "disableFrame", "Landroid/view/View;", "isSmoothScrolling", "", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "()Landroid/app/KeyguardManager;", "keyguardManager$delegate", "layoutAnimator", "com/tencent/mm/plugin/forcenotify/ui/MsgWindow$layoutAnimator$1", "Lcom/tencent/mm/plugin/forcenotify/ui/MsgWindow$layoutAnimator$1;", "layoutManager", "Lcom/tencent/mm/plugin/forcenotify/ui/view/StackLayoutManager;", "msgList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem;", "Lkotlin/collections/ArrayList;", "getMsgList", "()Ljava/util/ArrayList;", "playSoundTask", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "shadowFrame", "smoothScrollTarget", "", "soundPlay", "Landroid/media/MediaPlayer;", "stopSoundTask", "stopVibrateTask", "taskHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getTaskHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "taskHandler$delegate", "vibrateTask", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "vibrator$delegate", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "kotlin.jvm.PlatformType", "getWakeLock", "()Landroid/os/PowerManager$WakeLock;", "wakeLock$delegate", "addMsgItem", "", "item", "addMsgItemSync", "adjustWindowUI", "getLayoutId", "isDarkMode", "isEmpty", "isPhoneLocking", "isShowing", "onHideWindow", "onInflateView", "rootView", "onKey", "v", "keyCode", "event", "Landroid/view/KeyEvent;", "onScrollUpHide", "onShowWindow", "postTaskDelay", "task", "delayMs", "", "token", "", "removeMsgItem", "id", "", "removeMsgItemSync", "removeTaskByRunnable", "removeTaskByToken", "setEnableTouch", "enable", "smoothScrollEnd", "smoothScrollTo", "pos", "startSoundAndVibrate", "sound", "vibrate", "stopSound", "stopSoundAndVibrate", "stopVibrate", "updateMsgItem", "updateMsgItemSync", "Companion", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public static final a HoY;
  private static final kotlin.j<b> nqI;
  private final kotlin.j HoR;
  private MediaPlayer HoS;
  private StackLayoutManager HoZ;
  private View Hpa;
  private View Hpb;
  private final kotlin.j Hpc;
  private final kotlin.j Hpd;
  private final kotlin.j Hpe;
  private final Runnable Hpf;
  private final Runnable Hpg;
  private final Runnable Hph;
  private final Runnable Hpi;
  private Runnable Hpj;
  private boolean Hpk;
  private int Hpl;
  private final e Hpm;
  private final AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  public final ArrayList<com.tencent.mm.plugin.forcenotify.c.a> mZo;
  private RecyclerView mkw;
  private final kotlin.j sQv;
  
  static
  {
    AppMethodBeat.i(275100);
    HoY = new a((byte)0);
    nqI = k.cm((kotlin.g.a.a)b.b.Hpn);
    AppMethodBeat.o(275100);
  }
  
  private b()
  {
    AppMethodBeat.i(274939);
    this.mZo = new ArrayList();
    this.Hpc = k.cm((kotlin.g.a.a)b.i.Hpp);
    this.sQv = k.cm((kotlin.g.a.a)new b.c(this));
    this.Hpd = k.cm((kotlin.g.a.a)new b.d(this));
    this.Hpe = k.cm((kotlin.g.a.a)new k(this));
    this.audioFocusChangeListener = b..ExternalSyntheticLambda0.INSTANCE;
    this.HoR = k.cm((kotlin.g.a.a)new b.j(this));
    this.Hpf = new b..ExternalSyntheticLambda1(this);
    this.Hpg = new b..ExternalSyntheticLambda2(this);
    this.Hph = new b..ExternalSyntheticLambda3(this);
    this.Hpi = new b..ExternalSyntheticLambda4(this);
    this.Hpl = 2147483647;
    this.Hpm = new e(this);
    this.Hpj = new b..ExternalSyntheticLambda5(this);
    AppMethodBeat.o(274939);
  }
  
  private static final void VZ(int paramInt) {}
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(275029);
    s.u(paramb, "this$0");
    paramb.fwV();
    AppMethodBeat.o(275029);
  }
  
  private static final void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(275073);
    s.u(paramb, "this$0");
    paramb = paramb.mkw;
    if (paramb != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramb, locala.aYi(), "com/tencent/mm/plugin/forcenotify/ui/MsgWindow", "smoothScrollTo$lambda-21", "(Lcom/tencent/mm/plugin/forcenotify/ui/MsgWindow;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramb.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramb, "com/tencent/mm/plugin/forcenotify/ui/MsgWindow", "smoothScrollTo$lambda-21", "(Lcom/tencent/mm/plugin/forcenotify/ui/MsgWindow;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    }
    AppMethodBeat.o(275073);
  }
  
  private static final void a(b paramb, com.tencent.mm.plugin.forcenotify.c.a parama)
  {
    AppMethodBeat.i(275048);
    s.u(paramb, "this$0");
    s.u(parama, "$item");
    paramb.d(parama);
    AppMethodBeat.o(275048);
  }
  
  private static final void a(b paramb, String paramString)
  {
    AppMethodBeat.i(275060);
    s.u(paramb, "this$0");
    s.u(paramString, "$id");
    paramb.aDV(paramString);
    AppMethodBeat.o(275060);
  }
  
  private static final void a(List paramList, b paramb)
  {
    AppMethodBeat.i(275066);
    s.u(paramList, "$itemList");
    s.u(paramb, "this$0");
    paramList = ((Iterable)p.m((Iterable)paramList)).iterator();
    while (paramList.hasNext()) {
      paramb.d((com.tencent.mm.plugin.forcenotify.c.a)paramList.next());
    }
    AppMethodBeat.o(275066);
  }
  
  private final void aDV(String paramString)
  {
    AppMethodBeat.i(274980);
    Object localObject1 = com.tencent.mm.plugin.forcenotify.e.a.HpI;
    if (!com.tencent.mm.plugin.forcenotify.e.a.hE(getContext()))
    {
      Log.i("ForceNotify.MsgWindow", "removeMsgItem no permission, return");
      AppMethodBeat.o(274980);
      return;
    }
    localObject1 = (List)new ArrayList();
    Object localObject2 = ((Iterable)this.mZo).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        p.kkW();
      }
      if (s.p(((com.tencent.mm.plugin.forcenotify.c.a)localObject3).id, paramString)) {
        ((List)localObject1).add(Integer.valueOf(i));
      }
      i += 1;
    }
    Log.i("ForceNotify.MsgWindow", "removeMsgItem id=" + paramString + " delete size = " + ((List)localObject1).size());
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      int j = ((Number)((Iterator)localObject1).next()).intValue();
      if (j < this.mZo.size())
      {
        localObject2 = this.HoZ;
        if ((localObject2 != null) && (j == ((StackLayoutManager)localObject2).fxb())) {}
        for (i = 1;; i = 0)
        {
          if ((i == 0) || (j + 1 >= this.mZo.size())) {
            break label265;
          }
          Wa(j + 1);
          break;
        }
        label265:
        if ((j < 0) || (j >= this.mZo.size()))
        {
          AppMethodBeat.o(274980);
          return;
        }
        localObject2 = this.mZo.remove(j);
        s.s(localObject2, "msgList.removeAt(it)");
        ((com.tencent.mm.plugin.forcenotify.c.a)localObject2).fwG();
        if (isEmpty())
        {
          Log.i("ForceNotify.MsgWindow", "removeMsgItem id=" + paramString + " list empty, hide");
          hide();
        }
        else
        {
          Log.i("ForceNotify.MsgWindow", "removeMsgItem id=" + paramString + " remove from recyclerView");
          localObject2 = this.mkw;
          if (localObject2 != null)
          {
            localObject2 = ((RecyclerView)localObject2).getAdapter();
            if (localObject2 != null) {
              ((RecyclerView.a)localObject2).fX(j);
            }
          }
          localObject2 = this.mkw;
          if (localObject2 != null)
          {
            localObject2 = ((RecyclerView)localObject2).getAdapter();
            if (localObject2 != null) {
              ((RecyclerView.a)localObject2).by(j, this.mZo.size() - j);
            }
          }
        }
      }
    }
    AppMethodBeat.o(274980);
  }
  
  private void aE(Runnable paramRunnable)
  {
    AppMethodBeat.i(275018);
    if (paramRunnable != null) {
      fwW().removeCallbacks(paramRunnable);
    }
    AppMethodBeat.o(275018);
  }
  
  private final void ar(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(274996);
    fwY();
    boolean bool = AppForegroundDelegate.heY.eLx;
    getAudioManager().requestAudioFocus(this.audioFocusChangeListener, 3, 2);
    if (paramBoolean1)
    {
      a(this.Hpi, 1000L, null);
      a(this.Hpf, 7000L, null);
    }
    if (paramBoolean2)
    {
      a(this.Hph, 1000L, null);
      a(this.Hpg, 7000L, null);
    }
    if ((paramBoolean1) || (paramBoolean2)) {
      a(this.Hpj, 100L, null);
    }
    if (getWakeLock().isHeld())
    {
      localWakeLock = getWakeLock();
      com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/plugin/forcenotify/ui/MsgWindow", "startSoundAndVibrate", "(ZZ)V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      localWakeLock.release();
      com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/plugin/forcenotify/ui/MsgWindow", "startSoundAndVibrate", "(ZZ)V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
    }
    PowerManager.WakeLock localWakeLock = getWakeLock();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(120000L, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, locala.aYi(), "com/tencent/mm/plugin/forcenotify/ui/MsgWindow", "startSoundAndVibrate", "(ZZ)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
    long l = ((Long)com.tencent.mm.hellhoundlib.b.c.a(locala).sb(0)).longValue();
    com.tencent.mm.hellhoundlib.b.c.aYk();
    localWakeLock.acquire(l);
    com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/plugin/forcenotify/ui/MsgWindow", "startSoundAndVibrate", "(ZZ)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "(J)V");
    AppMethodBeat.o(274996);
  }
  
  private static final void b(b paramb)
  {
    AppMethodBeat.i(275033);
    s.u(paramb, "this$0");
    paramb.fwX();
    AppMethodBeat.o(275033);
  }
  
  private static final void b(b paramb, com.tencent.mm.plugin.forcenotify.c.a parama)
  {
    AppMethodBeat.i(275056);
    s.u(paramb, "this$0");
    s.u(parama, "$item");
    Object localObject = com.tencent.mm.plugin.forcenotify.e.a.HpI;
    if (!com.tencent.mm.plugin.forcenotify.e.a.hE(paramb.getContext()))
    {
      Log.i("ForceNotify.MsgWindow", "updateMsgItem no permission, return");
      AppMethodBeat.o(275056);
      return;
    }
    Log.i("ForceNotify.MsgWindow", s.X("updateMsgItem called, id=", parama.id));
    localObject = (List)paramb.mZo;
    int i = 0;
    localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext()) {
      if (!s.p(((com.tencent.mm.plugin.forcenotify.c.a)((Iterator)localObject).next()).id, parama.id)) {}
    }
    for (;;)
    {
      if (i == -1) {
        break label218;
      }
      if (i < paramb.mZo.size())
      {
        paramb.mZo.set(i, parama);
        paramb = paramb.mkw;
        if (paramb != null)
        {
          paramb = paramb.getAdapter();
          if (paramb != null) {
            paramb.fV(i);
          }
        }
        parama.fwF();
      }
      Log.i("ForceNotify.MsgWindow", "updateMsgItem item id=" + parama.id + " exists, update it");
      AppMethodBeat.o(275056);
      return;
      i += 1;
      break;
      i = -1;
    }
    label218:
    Log.i("ForceNotify.MsgWindow", "updateMsgItem item id=" + parama.id + " doesn't exist, skip update");
    AppMethodBeat.o(275056);
  }
  
  private static final void c(b paramb)
  {
    AppMethodBeat.i(275038);
    s.u(paramb, "this$0");
    if (com.tencent.mm.plugin.forcenotify.core.c.b(com.tencent.mm.plugin.forcenotify.core.c.Hoc))
    {
      Log.i("ForceNotify.MsgWindow", "vibrator.vibrate");
      boolean bool = AppForegroundDelegate.heY.eLx;
      paramb.fwU().vibrate(new long[] { 1000L, 1000L, 1000L, 1000L, 1000L, 1000L }, -1);
    }
    AppMethodBeat.o(275038);
  }
  
  private final void d(com.tencent.mm.plugin.forcenotify.c.a parama)
  {
    AppMethodBeat.i(274971);
    Object localObject = com.tencent.mm.plugin.forcenotify.e.a.HpI;
    if (!com.tencent.mm.plugin.forcenotify.e.a.hE(getContext()))
    {
      Log.i("ForceNotify.MsgWindow", "addMsgItem no permission, return");
      AppMethodBeat.o(274971);
      return;
    }
    localObject = ((List)this.mZo).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext()) {
      if (!s.p(((com.tencent.mm.plugin.forcenotify.c.a)((Iterator)localObject).next()).id, parama.id)) {}
    }
    for (;;)
    {
      Log.i("ForceNotify.MsgWindow", s.X("addMsgItem called, id=", parama.id));
      if (i != -1) {
        break label205;
      }
      this.mZo.add(0, parama);
      localObject = this.mkw;
      if (localObject != null)
      {
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).fW(0);
        }
      }
      Wa(0);
      if ((parama.dWY()) || (parama.dWZ())) {
        ar(parama.dWY(), parama.dWZ());
      }
      parama.fwE();
      Log.i("ForceNotify.MsgWindow", s.X("addMsgItem add new item, id=", parama.id));
      AppMethodBeat.o(274971);
      return;
      i += 1;
      break;
      i = -1;
    }
    label205:
    if ((i < 0) || (i >= this.mZo.size()))
    {
      AppMethodBeat.o(274971);
      return;
    }
    this.mZo.remove(i);
    this.mZo.add(0, parama);
    localObject = this.mkw;
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).fX(i);
      }
    }
    localObject = this.mkw;
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).fW(0);
      }
    }
    Wa(0);
    if ((parama.dWY()) || (parama.dWZ())) {
      ar(parama.dWY(), parama.dWZ());
    }
    parama.fwF();
    Log.i("ForceNotify.MsgWindow", s.X("addMsgItem update item, id=", parama.id));
    AppMethodBeat.o(274971);
  }
  
  private static final void d(b paramb)
  {
    AppMethodBeat.i(275040);
    s.u(paramb, "this$0");
    if (!com.tencent.mm.plugin.forcenotify.core.c.a(com.tencent.mm.plugin.forcenotify.core.c.Hoc))
    {
      Log.i("ForceNotify.MsgWindow", "PlaySound.playRoot");
      paramb.HoS = PlaySound.playRoot(paramb.getContext(), a.h.force_notify_voice, PlaySound.SPEAKERON.NOTSET, 2, true, null);
    }
    AppMethodBeat.o(275040);
  }
  
  private static final void e(b paramb)
  {
    AppMethodBeat.i(275045);
    s.u(paramb, "this$0");
    if (((KeyguardManager)paramb.Hpd.getValue()).inKeyguardRestrictedInputMode())
    {
      paramb.fwY();
      AppMethodBeat.o(275045);
      return;
    }
    paramb.a(paramb.Hpj, 100L, null);
    AppMethodBeat.o(275045);
  }
  
  private final Vibrator fwU()
  {
    AppMethodBeat.i(274958);
    Vibrator localVibrator = (Vibrator)this.HoR.getValue();
    AppMethodBeat.o(274958);
    return localVibrator;
  }
  
  private final void fwV()
  {
    AppMethodBeat.i(275001);
    try
    {
      aE(this.Hpj);
      Object localObject = this.HoS;
      if (localObject != null) {
        ((MediaPlayer)localObject).stop();
      }
      localObject = this.HoS;
      if (localObject != null) {
        ((MediaPlayer)localObject).release();
      }
      if (getWakeLock().isHeld())
      {
        localObject = getWakeLock();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/plugin/forcenotify/ui/MsgWindow", "stopSound", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        ((PowerManager.WakeLock)localObject).release();
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/forcenotify/ui/MsgWindow", "stopSound", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      }
      getAudioManager().abandonAudioFocus(this.audioFocusChangeListener);
      AppMethodBeat.o(275001);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("ForceNotify.MsgWindow", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(275001);
    }
  }
  
  private final MMHandler fwW()
  {
    AppMethodBeat.i(274944);
    MMHandler localMMHandler = (MMHandler)this.Hpc.getValue();
    AppMethodBeat.o(274944);
    return localMMHandler;
  }
  
  private final void fwX()
  {
    AppMethodBeat.i(275005);
    try
    {
      aE(this.Hpj);
      fwU().cancel();
      if (getWakeLock().isHeld())
      {
        PowerManager.WakeLock localWakeLock = getWakeLock();
        com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/plugin/forcenotify/ui/MsgWindow", "stopVibrate", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        localWakeLock.release();
        com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/plugin/forcenotify/ui/MsgWindow", "stopVibrate", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        AppMethodBeat.o(275005);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("ForceNotify.MsgWindow", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(275005);
    }
  }
  
  private final void fwY()
  {
    AppMethodBeat.i(275011);
    aE(this.Hpf);
    aE(this.Hpi);
    aE(this.Hpg);
    aE(this.Hph);
    fwV();
    fwX();
    AppMethodBeat.o(275011);
  }
  
  private final AudioManager getAudioManager()
  {
    AppMethodBeat.i(274948);
    AudioManager localAudioManager = (AudioManager)this.sQv.getValue();
    AppMethodBeat.o(274948);
    return localAudioManager;
  }
  
  private final PowerManager.WakeLock getWakeLock()
  {
    AppMethodBeat.i(274953);
    PowerManager.WakeLock localWakeLock = (PowerManager.WakeLock)this.Hpe.getValue();
    AppMethodBeat.o(274953);
    return localWakeLock;
  }
  
  private final void setEnableTouch(boolean paramBoolean)
  {
    AppMethodBeat.i(274989);
    View localView = this.Hpb;
    if (localView != null) {
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(274989);
      return;
    }
  }
  
  public final void Wa(int paramInt)
  {
    AppMethodBeat.i(275154);
    long l = System.currentTimeMillis();
    Object localObject = MotionEvent.obtain(l, l, 1, 0.0F, 0.0F, 0);
    RecyclerView localRecyclerView = this.mkw;
    if (localRecyclerView != null) {
      localRecyclerView.onTouchEvent((MotionEvent)localObject);
    }
    setEnableTouch(false);
    this.Hpk = true;
    this.Hpl = paramInt;
    localObject = this.mkw;
    if (localObject != null) {
      ((RecyclerView)localObject).post(new b..ExternalSyntheticLambda6(this, paramInt));
    }
    AppMethodBeat.o(275154);
  }
  
  public final void a(Runnable paramRunnable, long paramLong, Object paramObject)
  {
    AppMethodBeat.i(275156);
    if (paramRunnable != null)
    {
      if (paramObject == null)
      {
        fwW().postDelayed(paramRunnable, paramLong);
        AppMethodBeat.o(275156);
        return;
      }
      long l = SystemClock.uptimeMillis();
      fwW().postAtTime(paramRunnable, paramObject, l + paramLong);
    }
    AppMethodBeat.o(275156);
  }
  
  public final void aDU(String paramString)
  {
    AppMethodBeat.i(275145);
    s.u(paramString, "id");
    h.ahAA.bk(new b..ExternalSyntheticLambda9(this, paramString));
    AppMethodBeat.o(275145);
  }
  
  public final void c(com.tencent.mm.plugin.forcenotify.c.a parama)
  {
    AppMethodBeat.i(275141);
    s.u(parama, "item");
    h.ahAA.bk(new b..ExternalSyntheticLambda7(this, parama));
    AppMethodBeat.o(275141);
  }
  
  public final void e(com.tencent.mm.plugin.forcenotify.c.a parama)
  {
    AppMethodBeat.i(275142);
    s.u(parama, "item");
    h.ahAA.bk(new b..ExternalSyntheticLambda8(this, parama));
    AppMethodBeat.o(275142);
  }
  
  public final void fJ(Object paramObject)
  {
    AppMethodBeat.i(275157);
    s.u(paramObject, "token");
    fwW().removeCallbacksAndMessages(paramObject);
    AppMethodBeat.o(275157);
  }
  
  public final void fwS()
  {
    AppMethodBeat.i(275150);
    super.fwS();
    Object localObject1 = this.mkw;
    if (localObject1 != null) {
      ((RecyclerView)localObject1).setItemAnimator(null);
    }
    localObject1 = (com.tencent.mm.plugin.forcenotify.c.a)p.oN((List)this.mZo);
    if ((localObject1 == null) || (((com.tencent.mm.plugin.forcenotify.c.a)localObject1).bZB() != -1))
    {
      localObject1 = this.mZo;
      localObject2 = com.tencent.mm.plugin.forcenotify.c.g.Hoq;
      ((ArrayList)localObject1).add(com.tencent.mm.plugin.forcenotify.c.g.fwL());
    }
    Object localObject2 = (Iterable)this.mZo;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label143:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((com.tencent.mm.plugin.forcenotify.c.a)localObject3).bZB() != -1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label143;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = (List)localObject1;
    this.mZo.removeAll((Collection)localObject1);
    this.HoZ = new StackLayoutManager(com.tencent.mm.cd.a.fromDPToPix(getContext(), 8), (m)new f(this));
    localObject2 = this.HoZ;
    if (localObject2 != null) {
      ((StackLayoutManager)localObject2).a((StackLayoutManager.c)this.Hpm);
    }
    localObject2 = this.mkw;
    if (localObject2 != null) {
      ((RecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)this.HoZ);
    }
    localObject2 = this.mkw;
    if (localObject2 != null)
    {
      localObject3 = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new g(), this.mZo);
      ((com.tencent.mm.view.recyclerview.i)localObject3).agOe = ((i.c)new h((WxRecyclerAdapter)localObject3, this));
      ah localah = ah.aiuX;
      ((RecyclerView)localObject2).setAdapter((RecyclerView.a)localObject3);
    }
    localObject2 = this.Hpa;
    if (localObject2 != null) {
      if (!fwR()) {
        break label351;
      }
    }
    label351:
    for (int i = 8;; i = 0)
    {
      ((View)localObject2).setVisibility(i);
      localObject2 = this.mkw;
      if (localObject2 != null) {
        ((RecyclerView)localObject2).post(new b..ExternalSyntheticLambda10((List)localObject1, this));
      }
      AppMethodBeat.o(275150);
      return;
    }
  }
  
  public final void fwT()
  {
    AppMethodBeat.i(275152);
    super.fwT();
    fwW().removeCallbacksAndMessages(null);
    fwY();
    Object localObject = new ArrayList((Collection)this.mZo);
    this.mZo.clear();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.forcenotify.c.a)((Iterator)localObject).next()).fwG();
    }
    localObject = this.mkw;
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).bZE.notifyChanged();
      }
    }
    this.mkw = null;
    AppMethodBeat.o(275152);
  }
  
  public final int getLayoutId()
  {
    return a.f.force_notify_window_ui;
  }
  
  public final void hq(View paramView)
  {
    AppMethodBeat.i(275147);
    s.u(paramView, "rootView");
    this.mkw = ((RecyclerView)findViewById(a.e.rv_list));
    this.Hpa = findViewById(a.e.shadow_frame);
    this.Hpb = findViewById(a.e.disable_touch_frame);
    AppMethodBeat.o(275147);
  }
  
  public final boolean isDarkMode()
  {
    AppMethodBeat.i(275138);
    boolean bool = fwR();
    AppMethodBeat.o(275138);
    return bool;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(275159);
    if (this.mZo.size() <= 1)
    {
      com.tencent.mm.plugin.forcenotify.c.a locala = (com.tencent.mm.plugin.forcenotify.c.a)p.oN((List)this.mZo);
      if (locala == null) {}
      for (int i = -1; i == -1; i = locala.bZB())
      {
        AppMethodBeat.o(275159);
        return true;
      }
    }
    AppMethodBeat.o(275159);
    return false;
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramInt = 1;
    AppMethodBeat.i(275153);
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 1)) {}
    for (;;)
    {
      if (paramInt != 0) {
        fwY();
      }
      AppMethodBeat.o(275153);
      return false;
      paramInt = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/ui/MsgWindow$Companion;", "", "()V", "NO_VALUE", "", "TAG", "", "instance", "Lcom/tencent/mm/plugin/forcenotify/ui/MsgWindow;", "getInstance$annotations", "getInstance", "()Lcom/tencent/mm/plugin/forcenotify/ui/MsgWindow;", "instance$delegate", "Lkotlin/Lazy;", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static b fwZ()
    {
      AppMethodBeat.i(275037);
      b localb = (b)b.blL().getValue();
      AppMethodBeat.o(275037);
      return localb;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/forcenotify/ui/MsgWindow$layoutAnimator$1", "Lcom/tencent/mm/plugin/forcenotify/ui/view/StackLayoutManager$LayoutAnimator;", "doAnimate", "", "view", "Landroid/view/View;", "position", "", "centerPosition", "progress", "", "prevView", "nextView", "resetViewAnimateProperty", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements StackLayoutManager.c
  {
    e(b paramb) {}
    
    public final void a(View paramView1, int paramInt1, int paramInt2, float paramFloat, View paramView2)
    {
      AppMethodBeat.i(274975);
      paramInt1 -= paramInt2;
      float f;
      int i;
      if (this.Hpo.isDarkMode())
      {
        f = 0.2F;
        i = 255 - (int)(f * Math.max(0.0F, paramInt1 - paramFloat) * 255.0F);
        i = Color.rgb(i, i, i);
        if (paramView1 != null) {
          break label175;
        }
      }
      label175:
      for (paramView1 = null;; paramView1 = paramView1.getBackground())
      {
        if (paramView1 != null) {
          paramView1.setColorFilter((ColorFilter)new PorterDuffColorFilter(i, PorterDuff.Mode.MULTIPLY));
        }
        if ((paramInt1 == 0) && (paramInt2 == this.Hpo.mZo.size() - 2))
        {
          paramView1 = b.i(this.Hpo);
          if (paramView1 != null) {
            paramView1.setAlpha(1.0F - paramFloat);
          }
        }
        if ((paramInt1 == 0) && (paramInt2 == this.Hpo.mZo.size() - 1))
        {
          paramView1 = b.i(this.Hpo);
          if (paramView1 != null) {
            paramView1.setAlpha(0.0F);
          }
        }
        AppMethodBeat.o(274975);
        return;
        f = 0.05F;
        break;
      }
    }
    
    public final void hs(View paramView)
    {
      AppMethodBeat.i(274981);
      if (paramView != null)
      {
        paramView = paramView.getBackground();
        if (paramView != null) {
          paramView.clearColorFilter();
        }
      }
      AppMethodBeat.o(274981);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "from", "", "to"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements m<Integer, Integer, ah>
  {
    f(b paramb)
    {
      super();
    }
    
    private static final void a(int paramInt1, int paramInt2, b paramb)
    {
      AppMethodBeat.i(274983);
      s.u(paramb, "this$0");
      int i;
      if (paramInt1 < paramInt2) {
        i = paramInt1;
      }
      for (;;)
      {
        i += 1;
        if ((paramInt1 >= 0) && (paramInt1 < paramb.mZo.size())) {
          b.b(paramb, ((com.tencent.mm.plugin.forcenotify.c.a)paramb.mZo.get(paramInt1)).id);
        }
        if (i >= paramInt2)
        {
          AppMethodBeat.o(274983);
          return;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/forcenotify/ui/MsgWindow$onShowWindow$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.view.recyclerview.g
  {
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(274976);
      switch (paramInt)
      {
      default: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.forcenotify.b.b();
        AppMethodBeat.o(274976);
        return localf;
      case 0: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.forcenotify.b.f();
        AppMethodBeat.o(274976);
        return localf;
      case 1: 
        localf = (com.tencent.mm.view.recyclerview.f)new e();
        AppMethodBeat.o(274976);
        return localf;
      case 2: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.forcenotify.b.b();
        AppMethodBeat.o(274976);
        return localf;
      case 3: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.forcenotify.b.c();
        AppMethodBeat.o(274976);
        return localf;
      }
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new d();
      AppMethodBeat.o(274976);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/forcenotify/ui/MsgWindow$onShowWindow$3$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    h(WxRecyclerAdapter<com.tencent.mm.plugin.forcenotify.c.a> paramWxRecyclerAdapter, b paramb) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<PowerManager.WakeLock>
  {
    k(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.b
 * JD-Core Version:    0.7.0.1
 */