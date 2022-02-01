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
import com.tencent.mm.aw.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.m.a;
import com.tencent.mm.plugin.forcenotify.b.c;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.b;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.util.b;
import d.l;
import d.v;

@com.tencent.mm.ui.base.a(3)
@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI;", "Lcom/tencent/mm/plugin/forcenotify/ui/BaseForceNotifyShowUI;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "UIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "mAudioManager", "Landroid/media/AudioManager;", "mSoundPlay", "Landroid/media/MediaPlayer;", "mVibrator", "Landroid/os/Vibrator;", "stopSoundRunnable", "Ljava/lang/Runnable;", "getLayoutId", "", "onAppBackground", "", "activity", "", "onAppForeground", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onStart", "onStop", "reset", "setBlurBg", "view", "Landroid/view/View;", "plugin-force-notify_release"})
public final class ForceNotifyShowUI
  extends BaseForceNotifyShowUI
  implements com.tencent.mm.app.n
{
  private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  private Vibrator lRO;
  private AudioManager mAudioManager;
  private MediaPlayer reZ;
  private Runnable rfa;
  private final ap rfb;
  private d rfc;
  
  public ForceNotifyShowUI()
  {
    AppMethodBeat.i(149247);
    this.rfb = new ap(Looper.getMainLooper());
    this.rfc = new d();
    AppMethodBeat.o(149247);
  }
  
  private final void reset()
  {
    AppMethodBeat.i(149246);
    Object localObject = getWindow();
    d.g.b.k.g(localObject, "window");
    localObject = ((Window)localObject).getDecorView();
    d.g.b.k.g(localObject, "window.decorView");
    ((View)localObject).setKeepScreenOn(false);
    this.rfb.removeCallbacksAndMessages(null);
    localObject = this.mAudioManager;
    if (localObject != null) {
      ((AudioManager)localObject).abandonAudioFocus(this.audioFocusChangeListener);
    }
    try
    {
      localObject = getWindow();
      d.g.b.k.g(localObject, "window");
      ((Window)localObject).getDecorView().removeCallbacks(this.rfa);
      localObject = this.rfa;
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
      this.rfa = null;
      AppMethodBeat.o(149246);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localIllegalStateException, "", new Object[0]);
      AppMethodBeat.o(149246);
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494166;
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
    ad.i(this.TAG, "[onBackPressed]");
    String str = String.valueOf(this.rfc.field_CreateTime / 1000L) + this.rfc.field_UserName;
    ((com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).b(this.rfc.field_ForcePushId, str, 8, ce.asR() / 1000L);
    AppMethodBeat.o(149238);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(149237);
    super.onCreate(paramBundle);
    b.fgU();
    ad.i(this.TAG, "[onCreate] username=" + this.username);
    paramBundle = this.username;
    Object localObject1;
    if (paramBundle != null)
    {
      localObject1 = com.tencent.mm.plugin.forcenotify.d.a.rez;
      this.rfc = com.tencent.mm.plugin.forcenotify.d.a.aan(paramBundle);
    }
    AppForegroundDelegate.cKE.a((com.tencent.mm.app.n)this);
    paramBundle = getSystemService("audio");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(149237);
      throw paramBundle;
    }
    this.mAudioManager = ((AudioManager)paramBundle);
    paramBundle = getContext().getSystemService("vibrator");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.os.Vibrator");
      AppMethodBeat.o(149237);
      throw paramBundle;
    }
    this.lRO = ((Vibrator)paramBundle);
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
        break label681;
      }
      localObject1 = Integer.valueOf(((AudioManager)localObject1).getVibrateSetting(0));
      localObject2 = this.mAudioManager;
      if (localObject2 == null) {
        break label686;
      }
      localObject2 = Integer.valueOf(((AudioManager)localObject2).getRingerMode());
      ad.i(this.TAG, "V:%s V1:%s  R:%s", new Object[] { paramBundle, localObject1, localObject2 });
      this.audioFocusChangeListener = ((AudioManager.OnAudioFocusChangeListener)ForceNotifyShowUI.b.rfe);
      paramBundle = this.mAudioManager;
      if (paramBundle == null) {
        break label692;
      }
      paramBundle = Integer.valueOf(paramBundle.requestAudioFocus(this.audioFocusChangeListener, 3, 2));
      label270:
      this.rfb.postDelayed((Runnable)new c(this), 1000L);
      localObject1 = getWindow();
      d.g.b.k.g(localObject1, "window");
      localObject1 = ((Window)localObject1).getDecorView();
      d.g.b.k.g(localObject1, "window.decorView");
      ((View)localObject1).setKeepScreenOn(true);
      d.g.b.k.g(findViewById(2131298739), "findViewById(R.id.content)");
      getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(getResources().getColor(2131100384)));
      ad.i(this.TAG, "[onCreate] username:%s requestAudioFocus:%s", new Object[] { this.username, paramBundle });
      localObject1 = (TextView)findViewById(2131302867);
      paramBundle = (ImageView)findViewById(2131297008);
      findViewById(2131300872).setOnClickListener((View.OnClickListener)new d(this));
      this.rfa = ((Runnable)new e(this));
      this.rfb.postDelayed(this.rfa, 60000L);
      localObject2 = (CharSequence)this.rfc.field_ForcePushId;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label697;
      }
      i = 1;
      label486:
      if (i != 0) {
        break label702;
      }
      localObject2 = this.rfc.field_ForcePushId;
      d.g.b.k.g(localObject2, "info.field_ForcePushId");
      if (!d.n.n.mB((String)localObject2, "@miniapp")) {
        break label702;
      }
      ((m)g.ab(m.class)).a(this.username, (m.a)new f(this, paramBundle, (TextView)localObject1));
      paramBundle = (com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class);
      localObject1 = this.username;
      localObject2 = c.rex;
      localObject2 = getContext();
      d.g.b.k.g(localObject2, "context");
      if (!c.eR((Context)localObject2)) {
        break label826;
      }
      localObject2 = c.rex;
      localObject2 = getContext();
      d.g.b.k.g(localObject2, "context");
      if (!c.eS((Context)localObject2)) {
        break label821;
      }
      i = 1;
    }
    for (;;)
    {
      paramBundle.g((String)localObject1, i, ce.asR() / 1000L);
      if (this.username != null)
      {
        paramBundle = com.tencent.mm.plugin.forcenotify.d.a.rez;
        localObject1 = this.username;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        paramBundle.vv((String)localObject1);
      }
      AppMethodBeat.o(149237);
      return;
      paramBundle = null;
      break;
      label681:
      localObject1 = null;
      break label189;
      label686:
      localObject2 = null;
      break label210;
      label692:
      paramBundle = null;
      break label270;
      label697:
      i = 0;
      break label486;
      label702:
      localObject2 = this.rfc;
      com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
      ((d)localObject2).contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)locala).apM().aHY(this.username);
      a.b.d(paramBundle, this.username, 0.1F);
      d.g.b.k.g(localObject1, "titleView");
      localObject2 = getBaseContext();
      paramBundle = this.rfc.contact;
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.ZX();; paramBundle = null)
      {
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.a((Context)localObject2, (CharSequence)paramBundle, (int)((TextView)localObject1).getTextSize(), 0, null, null));
        break;
      }
      label821:
      i = 4;
      continue;
      label826:
      localObject2 = c.rex;
      localObject2 = getContext();
      d.g.b.k.g(localObject2, "context");
      if (c.eS((Context)localObject2)) {
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
    String str = this.rfc.field_ForcePushId;
    if (str != null) {
      com.tencent.mm.plugin.forcenotify.d.a.rez.vv(str);
    }
    AppForegroundDelegate.cKE.b((com.tencent.mm.app.n)this);
    AppMethodBeat.o(149245);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(149240);
    d.g.b.k.h(paramKeyEvent, "event");
    ad.i(this.TAG, "[onKeyDown] keyCode:".concat(String.valueOf(paramInt)));
    reset();
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(149240);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(149243);
    super.onPause();
    ad.i(this.TAG, "onPause");
    AppMethodBeat.o(149243);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(149242);
    super.onResume();
    ad.i(this.TAG, "onResume");
    AppMethodBeat.o(149242);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(149241);
    super.onStart();
    ad.i(this.TAG, "onStart");
    AppMethodBeat.o(149241);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(149244);
    super.onStop();
    ad.i(this.TAG, "onStop");
    reset();
    AppMethodBeat.o(149244);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149230);
      ForceNotifyShowUI.d(this.rfd);
      AppMethodBeat.o(149230);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149232);
      Object localObject = c.rex;
      localObject = this.rfd.getContext();
      d.g.b.k.g(localObject, "context");
      if (!c.eR((Context)localObject)) {
        ForceNotifyShowUI.a(this.rfd, bd.a((Context)this.rfd.getContext(), 2131759601, bd.b.EWm, 2, true, null));
      }
      localObject = c.rex;
      localObject = this.rfd.getContext();
      d.g.b.k.g(localObject, "context");
      if (c.eS((Context)localObject))
      {
        localObject = ForceNotifyShowUI.b(this.rfd);
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        ((Vibrator)localObject).vibrate(new long[] { 1000L, 1000L, 1000L, 1000L }, 0);
      }
      AppMethodBeat.o(149232);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149233);
      if (ForceNotifyShowUI.c(this.rfd).field_CreateTime > 0L)
      {
        paramView = String.valueOf(ForceNotifyShowUI.c(this.rfd).field_CreateTime / 1000L) + ForceNotifyShowUI.c(this.rfd).field_UserName;
        ((com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).b(ForceNotifyShowUI.c(this.rfd).field_ForcePushId, paramView, 2, ce.asR() / 1000L);
      }
      this.rfd.finish();
      this.rfd.overridePendingTransition(0, 2130772106);
      AppMethodBeat.o(149233);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149234);
      try
      {
        Object localObject = ForceNotifyShowUI.b(this.rfd);
        if (localObject != null) {
          ((Vibrator)localObject).cancel();
        }
        localObject = ForceNotifyShowUI.a(this.rfd);
        if (localObject != null) {
          ((MediaPlayer)localObject).stop();
        }
        localObject = ForceNotifyShowUI.a(this.rfd);
        if (localObject != null) {
          ((MediaPlayer)localObject).release();
        }
        localObject = this.rfd.getWindow();
        d.g.b.k.g(localObject, "window");
        localObject = ((Window)localObject).getDecorView();
        d.g.b.k.g(localObject, "window.decorView");
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
  static final class f
    implements m.a
  {
    f(ForceNotifyShowUI paramForceNotifyShowUI, ImageView paramImageView, TextView paramTextView) {}
    
    public final void b(final WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(149236);
      ad.i(this.rfd.TAG, "getOrSync result=".concat(String.valueOf(paramWxaAttributes)));
      if (paramWxaAttributes == null)
      {
        AppMethodBeat.o(149236);
        return;
      }
      aq.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149235);
          o.ayJ().loadImage(this.reP, this.rfh.rff);
          TextView localTextView1 = this.rfh.rfg;
          d.g.b.k.g(localTextView1, "titleView");
          Context localContext = this.rfh.rfd.getBaseContext();
          CharSequence localCharSequence = (CharSequence)paramWxaAttributes.field_nickname;
          TextView localTextView2 = this.rfh.rfg;
          d.g.b.k.g(localTextView2, "titleView");
          localTextView1.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.a(localContext, localCharSequence, (int)localTextView2.getTextSize(), 0, null, null));
          AppMethodBeat.o(149235);
        }
      });
      AppMethodBeat.o(149236);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI
 * JD-Core Version:    0.7.0.1
 */