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
import com.tencent.mm.aw.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.n.a;
import com.tencent.mm.plugin.forcenotify.b.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.b;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import d.g.b.p;
import d.v;

@com.tencent.mm.ui.base.a(3)
@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI;", "Lcom/tencent/mm/plugin/forcenotify/ui/BaseForceNotifyShowUI;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "UIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "mAudioManager", "Landroid/media/AudioManager;", "mSoundPlay", "Landroid/media/MediaPlayer;", "mVibrator", "Landroid/os/Vibrator;", "stopSoundRunnable", "Ljava/lang/Runnable;", "getLayoutId", "", "onAppBackground", "", "activity", "", "onAppForeground", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onStart", "onStop", "reset", "setBlurBg", "view", "Landroid/view/View;", "plugin-force-notify_release"})
public final class ForceNotifyShowUI
  extends BaseForceNotifyShowUI
  implements com.tencent.mm.app.n
{
  private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  private AudioManager mAudioManager;
  private Vibrator mUw;
  private MediaPlayer tku;
  private Runnable tkv;
  private final ap tkw;
  private com.tencent.mm.plugin.forcenotify.c.d tkx;
  
  public ForceNotifyShowUI()
  {
    AppMethodBeat.i(149247);
    this.tkw = new ap(Looper.getMainLooper());
    this.tkx = new com.tencent.mm.plugin.forcenotify.c.d();
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
    this.tkw.removeCallbacksAndMessages(null);
    localObject = this.mAudioManager;
    if (localObject != null) {
      ((AudioManager)localObject).abandonAudioFocus(this.audioFocusChangeListener);
    }
    try
    {
      localObject = getWindow();
      p.g(localObject, "window");
      ((Window)localObject).getDecorView().removeCallbacks(this.tkv);
      localObject = this.tkv;
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
      this.tkv = null;
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
    String str = String.valueOf(this.tkx.field_CreateTime / 1000L) + this.tkx.field_UserName;
    ((com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).f(this.tkx.field_ForcePushId, str, 8, cf.aCL() / 1000L);
    AppMethodBeat.o(149238);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(149237);
    super.onCreate(paramBundle);
    com.tencent.mm.util.d.erL();
    ad.i(this.TAG, "[onCreate] username=" + this.username);
    paramBundle = this.username;
    Object localObject1;
    if (paramBundle != null)
    {
      localObject1 = com.tencent.mm.plugin.forcenotify.d.a.tjV;
      this.tkx = com.tencent.mm.plugin.forcenotify.d.a.ajD(paramBundle);
    }
    AppForegroundDelegate.cSQ.a((com.tencent.mm.app.n)this);
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
    this.mUw = ((Vibrator)paramBundle);
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
      this.audioFocusChangeListener = ((AudioManager.OnAudioFocusChangeListener)b.tkz);
      paramBundle = this.mAudioManager;
      if (paramBundle == null) {
        break label692;
      }
      paramBundle = Integer.valueOf(paramBundle.requestAudioFocus(this.audioFocusChangeListener, 3, 2));
      label270:
      this.tkw.postDelayed((Runnable)new c(this), 1000L);
      localObject1 = getWindow();
      p.g(localObject1, "window");
      localObject1 = ((Window)localObject1).getDecorView();
      p.g(localObject1, "window.decorView");
      ((View)localObject1).setKeepScreenOn(true);
      p.g(findViewById(2131298739), "findViewById(R.id.content)");
      getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(getResources().getColor(2131100384)));
      ad.i(this.TAG, "[onCreate] username:%s requestAudioFocus:%s", new Object[] { this.username, paramBundle });
      localObject1 = (TextView)findViewById(2131302867);
      paramBundle = (ImageView)findViewById(2131297008);
      findViewById(2131300872).setOnClickListener((View.OnClickListener)new ForceNotifyShowUI.d(this));
      this.tkv = ((Runnable)new e(this));
      this.tkw.postDelayed(this.tkv, 60000L);
      localObject2 = (CharSequence)this.tkx.field_ForcePushId;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label697;
      }
      i = 1;
      label486:
      if (i != 0) {
        break label702;
      }
      localObject2 = this.tkx.field_ForcePushId;
      p.g(localObject2, "info.field_ForcePushId");
      if (!d.n.n.nA((String)localObject2, "@miniapp")) {
        break label702;
      }
      ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(this.username, (n.a)new f(this, paramBundle, (TextView)localObject1));
      paramBundle = (com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class);
      localObject1 = this.username;
      localObject2 = c.tjT;
      localObject2 = getContext();
      p.g(localObject2, "context");
      if (!c.fh((Context)localObject2)) {
        break label829;
      }
      localObject2 = c.tjT;
      localObject2 = getContext();
      p.g(localObject2, "context");
      if (!c.fi((Context)localObject2)) {
        break label824;
      }
      i = 1;
    }
    for (;;)
    {
      paramBundle.C((String)localObject1, i, cf.aCL() / 1000L);
      if (this.username != null)
      {
        paramBundle = com.tencent.mm.plugin.forcenotify.d.a.tjV;
        localObject1 = this.username;
        if (localObject1 == null) {
          p.gfZ();
        }
        paramBundle.CA((String)localObject1);
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
      localObject2 = this.tkx;
      com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
      ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).azp().Bf(this.username);
      a.b.d(paramBundle, this.username, 0.1F);
      p.g(localObject1, "titleView");
      localObject2 = (Context)getContext();
      paramBundle = this.tkx.contact;
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.adv();; paramBundle = null)
      {
        ((TextView)localObject1).setText((CharSequence)k.a((Context)localObject2, (CharSequence)paramBundle, (int)((TextView)localObject1).getTextSize(), 0, null, null));
        break;
      }
      label824:
      i = 4;
      continue;
      label829:
      localObject2 = c.tjT;
      localObject2 = getContext();
      p.g(localObject2, "context");
      if (c.fi((Context)localObject2)) {
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
    String str = this.tkx.field_ForcePushId;
    if (str != null) {
      com.tencent.mm.plugin.forcenotify.d.a.tjV.CA(str);
    }
    AppForegroundDelegate.cSQ.b((com.tencent.mm.app.n)this);
    AppMethodBeat.o(149245);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(149240);
    p.h(paramKeyEvent, "event");
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149230);
      ForceNotifyShowUI.d(this.tky);
      AppMethodBeat.o(149230);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "onAudioFocusChange"})
  static final class b
    implements AudioManager.OnAudioFocusChangeListener
  {
    public static final b tkz;
    
    static
    {
      AppMethodBeat.i(149231);
      tkz = new b();
      AppMethodBeat.o(149231);
    }
    
    public final void onAudioFocusChange(int paramInt) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149232);
      Object localObject = c.tjT;
      localObject = this.tky.getContext();
      p.g(localObject, "context");
      if (!c.fh((Context)localObject)) {
        ForceNotifyShowUI.a(this.tky, bd.a((Context)this.tky.getContext(), 2131759601, bd.b.Ifn, 2, true, null));
      }
      localObject = c.tjT;
      localObject = this.tky.getContext();
      p.g(localObject, "context");
      if (c.fi((Context)localObject))
      {
        localObject = ForceNotifyShowUI.b(this.tky);
        if (localObject == null) {
          p.gfZ();
        }
        ((Vibrator)localObject).vibrate(new long[] { 1000L, 1000L, 1000L, 1000L }, 0);
      }
      AppMethodBeat.o(149232);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149234);
      try
      {
        Object localObject = ForceNotifyShowUI.b(this.tky);
        if (localObject != null) {
          ((Vibrator)localObject).cancel();
        }
        localObject = ForceNotifyShowUI.a(this.tky);
        if (localObject != null) {
          ((MediaPlayer)localObject).stop();
        }
        localObject = ForceNotifyShowUI.a(this.tky);
        if (localObject != null) {
          ((MediaPlayer)localObject).release();
        }
        localObject = this.tky.getWindow();
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
  static final class f
    implements n.a
  {
    f(ForceNotifyShowUI paramForceNotifyShowUI, ImageView paramImageView, TextView paramTextView) {}
    
    public final void b(final WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(149236);
      ad.i(this.tky.TAG, "getOrSync result=".concat(String.valueOf(paramWxaAttributes)));
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
          q.aIJ().loadImage(this.tkk, this.tkC.tkA);
          TextView localTextView1 = this.tkC.tkB;
          p.g(localTextView1, "titleView");
          Context localContext = (Context)this.tkC.tky.getContext();
          CharSequence localCharSequence = (CharSequence)paramWxaAttributes.field_nickname;
          TextView localTextView2 = this.tkC.tkB;
          p.g(localTextView2, "titleView");
          localTextView1.setText((CharSequence)k.a(localContext, localCharSequence, (int)localTextView2.getTextSize(), 0, null, null));
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