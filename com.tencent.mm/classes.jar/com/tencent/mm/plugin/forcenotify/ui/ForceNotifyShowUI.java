package com.tencent.mm.plugin.forcenotify.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Looper;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.forcenotify.b.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.PlaySound.SPEAKERON;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

@com.tencent.mm.ui.base.a(3)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI;", "Lcom/tencent/mm/plugin/forcenotify/ui/BaseForceNotifyShowUI;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "UIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "mAudioManager", "Landroid/media/AudioManager;", "mSoundPlay", "Landroid/media/MediaPlayer;", "mVibrator", "Landroid/os/Vibrator;", "stopSoundRunnable", "Ljava/lang/Runnable;", "getLayoutId", "", "onAppBackground", "", "activity", "", "onAppForeground", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onStart", "onStop", "reset", "setBlurBg", "view", "Landroid/view/View;", "plugin-force-notify_release"})
public final class ForceNotifyShowUI
  extends BaseForceNotifyShowUI
  implements o
{
  private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  private AudioManager mAudioManager;
  private Vibrator ooM;
  private MediaPlayer wMs;
  private Runnable wMt;
  private final MMHandler wMu;
  private com.tencent.mm.plugin.forcenotify.c.d wMv;
  
  public ForceNotifyShowUI()
  {
    AppMethodBeat.i(149247);
    this.wMu = new MMHandler(Looper.getMainLooper());
    this.wMv = new com.tencent.mm.plugin.forcenotify.c.d();
    AppMethodBeat.o(149247);
  }
  
  private final void reset()
  {
    AppMethodBeat.i(149246);
    Object localObject = getWindow();
    p.g(localObject, "window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "window.decorView");
    ((View)localObject).setKeepScreenOn(false);
    this.wMu.removeCallbacksAndMessages(null);
    localObject = this.mAudioManager;
    if (localObject != null) {
      ((AudioManager)localObject).abandonAudioFocus(this.audioFocusChangeListener);
    }
    try
    {
      localObject = getWindow();
      p.g(localObject, "window");
      ((Window)localObject).getDecorView().removeCallbacks(this.wMt);
      localObject = this.wMt;
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
      this.wMt = null;
      AppMethodBeat.o(149246);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localIllegalStateException, "", new Object[0]);
      AppMethodBeat.o(149246);
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494721;
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(149239);
    runOnUiThread((Runnable)new a(this));
    AppMethodBeat.o(149239);
  }
  
  public final void onAppForeground(String paramString) {}
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(149238);
    super.onBackPressed();
    Log.i(this.TAG, "[onBackPressed]");
    String str = String.valueOf(this.wMv.field_CreateTime / 1000L) + this.wMv.field_UserName;
    ((com.tencent.mm.plugin.forcenotify.a.a)g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).f(this.wMv.field_ForcePushId, str, 8, cl.aWz() / 1000L);
    AppMethodBeat.o(149238);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(149237);
    super.onCreate(paramBundle);
    com.tencent.mm.util.d.fAL();
    Log.i(this.TAG, "[onCreate] username=" + this.username);
    paramBundle = this.username;
    Object localObject1;
    if (paramBundle != null)
    {
      localObject1 = com.tencent.mm.plugin.forcenotify.d.a.wLU;
      this.wMv = com.tencent.mm.plugin.forcenotify.d.a.axG(paramBundle);
    }
    AppForegroundDelegate.djR.a((o)this);
    paramBundle = getSystemService("audio");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(149237);
      throw paramBundle;
    }
    this.mAudioManager = ((AudioManager)paramBundle);
    paramBundle = getContext().getSystemService("vibrator");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type android.os.Vibrator");
      AppMethodBeat.o(149237);
      throw paramBundle;
    }
    this.ooM = ((Vibrator)paramBundle);
    paramBundle = this.mAudioManager;
    label189:
    Object localObject2;
    label210:
    int i;
    if (paramBundle != null)
    {
      paramBundle = Integer.valueOf(paramBundle.getVibrateSetting(1));
      localObject1 = this.mAudioManager;
      if (localObject1 == null) {
        break label682;
      }
      localObject1 = Integer.valueOf(((AudioManager)localObject1).getVibrateSetting(0));
      localObject2 = this.mAudioManager;
      if (localObject2 == null) {
        break label687;
      }
      localObject2 = Integer.valueOf(((AudioManager)localObject2).getRingerMode());
      Log.i(this.TAG, "V:%s V1:%s  R:%s", new Object[] { paramBundle, localObject1, localObject2 });
      this.audioFocusChangeListener = ((AudioManager.OnAudioFocusChangeListener)b.wMx);
      paramBundle = this.mAudioManager;
      if (paramBundle == null) {
        break label693;
      }
      paramBundle = Integer.valueOf(paramBundle.requestAudioFocus(this.audioFocusChangeListener, 3, 2));
      label270:
      this.wMu.postDelayed((Runnable)new c(this), 1000L);
      localObject1 = getWindow();
      p.g(localObject1, "window");
      localObject1 = ((Window)localObject1).getDecorView();
      p.g(localObject1, "window.decorView");
      ((View)localObject1).setKeepScreenOn(true);
      p.g(findViewById(2131299180), "findViewById(R.id.content)");
      getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(getResources().getColor(2131100484)));
      Log.i(this.TAG, "[onCreate] username:%s requestAudioFocus:%s", new Object[] { this.username, paramBundle });
      localObject1 = (TextView)findViewById(2131305440);
      paramBundle = (ImageView)findViewById(2131297134);
      findViewById(2131302466).setOnClickListener((View.OnClickListener)new d(this));
      this.wMt = ((Runnable)new e(this));
      this.wMu.postDelayed(this.wMt, 60000L);
      localObject2 = (CharSequence)this.wMv.field_ForcePushId;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label698;
      }
      i = 1;
      label486:
      if (i != 0) {
        break label703;
      }
      localObject2 = this.wMv.field_ForcePushId;
      p.g(localObject2, "info.field_ForcePushId");
      if (!n.K((String)localObject2, "@miniapp", false)) {
        break label703;
      }
      ((com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(this.username, (q.a)new f(this, paramBundle, (TextView)localObject1));
      paramBundle = (com.tencent.mm.plugin.forcenotify.a.a)g.af(com.tencent.mm.plugin.forcenotify.a.a.class);
      localObject1 = this.username;
      localObject2 = c.wLS;
      localObject2 = getContext();
      p.g(localObject2, "context");
      if (!c.fR((Context)localObject2)) {
        break label830;
      }
      localObject2 = c.wLS;
      localObject2 = getContext();
      p.g(localObject2, "context");
      if (!c.fS((Context)localObject2)) {
        break label825;
      }
      i = 1;
    }
    for (;;)
    {
      paramBundle.A((String)localObject1, i, cl.aWz() / 1000L);
      if (this.username != null)
      {
        paramBundle = com.tencent.mm.plugin.forcenotify.d.a.wLU;
        localObject1 = this.username;
        if (localObject1 == null) {
          p.hyc();
        }
        paramBundle.gC((String)localObject1);
      }
      AppMethodBeat.o(149237);
      return;
      paramBundle = null;
      break;
      label682:
      localObject1 = null;
      break label189;
      label687:
      localObject2 = null;
      break label210;
      label693:
      paramBundle = null;
      break label270;
      label698:
      i = 0;
      break label486;
      label703:
      localObject2 = this.wMv;
      com.tencent.mm.kernel.c.a locala = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
      ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).aSN().Kn(this.username);
      a.b.d(paramBundle, this.username, 0.1F);
      p.g(localObject1, "titleView");
      localObject2 = (Context)getContext();
      paramBundle = this.wMv.contact;
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.arJ();; paramBundle = null)
      {
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.a((Context)localObject2, (CharSequence)paramBundle, (int)((TextView)localObject1).getTextSize(), 0, null, null));
        break;
      }
      label825:
      i = 4;
      continue;
      label830:
      localObject2 = c.wLS;
      localObject2 = getContext();
      p.g(localObject2, "context");
      if (c.fS((Context)localObject2)) {
        i = 3;
      } else {
        i = 2;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(149245);
    super.onDestroy();
    reset();
    String str = this.wMv.field_ForcePushId;
    if (str != null) {
      com.tencent.mm.plugin.forcenotify.d.a.wLU.gC(str);
    }
    AppForegroundDelegate.djR.b((o)this);
    AppMethodBeat.o(149245);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(149240);
    p.h(paramKeyEvent, "event");
    Log.i(this.TAG, "[onKeyDown] keyCode:".concat(String.valueOf(paramInt)));
    reset();
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(149240);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(149243);
    super.onPause();
    Log.i(this.TAG, "onPause");
    AppMethodBeat.o(149243);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(149242);
    super.onResume();
    Log.i(this.TAG, "onResume");
    AppMethodBeat.o(149242);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(149241);
    super.onStart();
    Log.i(this.TAG, "onStart");
    AppMethodBeat.o(149241);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(149244);
    super.onStop();
    Log.i(this.TAG, "onStop");
    reset();
    AppMethodBeat.o(149244);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149230);
      ForceNotifyShowUI.d(this.wMw);
      AppMethodBeat.o(149230);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onAudioFocusChange"})
  static final class b
    implements AudioManager.OnAudioFocusChangeListener
  {
    public static final b wMx;
    
    static
    {
      AppMethodBeat.i(149231);
      wMx = new b();
      AppMethodBeat.o(149231);
    }
    
    public final void onAudioFocusChange(int paramInt) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149232);
      Object localObject = c.wLS;
      localObject = this.wMw.getContext();
      p.g(localObject, "context");
      if (!c.fR((Context)localObject)) {
        ForceNotifyShowUI.a(this.wMw, PlaySound.playRoot((Context)this.wMw.getContext(), 2131760922, PlaySound.SPEAKERON.NOTSET, 2, true, null));
      }
      localObject = c.wLS;
      localObject = this.wMw.getContext();
      p.g(localObject, "context");
      if (c.fS((Context)localObject))
      {
        localObject = ForceNotifyShowUI.b(this.wMw);
        if (localObject == null) {
          p.hyc();
        }
        ((Vibrator)localObject).vibrate(new long[] { 1000L, 1000L, 1000L, 1000L }, 0);
      }
      AppMethodBeat.o(149232);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149233);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (ForceNotifyShowUI.c(this.wMw).field_CreateTime > 0L)
      {
        paramView = String.valueOf(ForceNotifyShowUI.c(this.wMw).field_CreateTime / 1000L) + ForceNotifyShowUI.c(this.wMw).field_UserName;
        ((com.tencent.mm.plugin.forcenotify.a.a)g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).f(ForceNotifyShowUI.c(this.wMw).field_ForcePushId, paramView, 2, cl.aWz() / 1000L);
      }
      this.wMw.finish();
      this.wMw.overridePendingTransition(0, 2130772130);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(149233);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149234);
      try
      {
        Object localObject = ForceNotifyShowUI.b(this.wMw);
        if (localObject != null) {
          ((Vibrator)localObject).cancel();
        }
        localObject = ForceNotifyShowUI.a(this.wMw);
        if (localObject != null) {
          ((MediaPlayer)localObject).stop();
        }
        localObject = ForceNotifyShowUI.a(this.wMw);
        if (localObject != null) {
          ((MediaPlayer)localObject).release();
        }
        localObject = this.wMw.getWindow();
        p.g(localObject, "window");
        localObject = ((Window)localObject).getDecorView();
        p.g(localObject, "window.decorView");
        ((View)localObject).setKeepScreenOn(false);
        AppMethodBeat.o(149234);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(149234);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
  static final class f
    implements q.a
  {
    f(ForceNotifyShowUI paramForceNotifyShowUI, ImageView paramImageView, TextView paramTextView) {}
    
    public final void b(final WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(149236);
      Log.i(this.wMw.TAG, "getOrSync result=".concat(String.valueOf(paramWxaAttributes)));
      if (paramWxaAttributes == null)
      {
        AppMethodBeat.o(149236);
        return;
      }
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149235);
          com.tencent.mm.av.q.bcV().loadImage(this.wMi, this.wMz.tEl);
          TextView localTextView1 = this.wMz.wMy;
          p.g(localTextView1, "titleView");
          Context localContext = (Context)this.wMz.wMw.getContext();
          CharSequence localCharSequence = (CharSequence)paramWxaAttributes.field_nickname;
          TextView localTextView2 = this.wMz.wMy;
          p.g(localTextView2, "titleView");
          localTextView1.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.a(localContext, localCharSequence, (int)localTextView2.getTextSize(), 0, null, null));
          AppMethodBeat.o(149235);
        }
      });
      AppMethodBeat.o(149236);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI
 * JD-Core Version:    0.7.0.1
 */