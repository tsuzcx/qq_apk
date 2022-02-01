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
import com.tencent.mm.av.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o.a;
import com.tencent.mm.plugin.forcenotify.b.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.b;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import d.g.b.p;
import d.n.n;
import d.v;

@com.tencent.mm.ui.base.a(3)
@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI;", "Lcom/tencent/mm/plugin/forcenotify/ui/BaseForceNotifyShowUI;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "UIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "mAudioManager", "Landroid/media/AudioManager;", "mSoundPlay", "Landroid/media/MediaPlayer;", "mVibrator", "Landroid/os/Vibrator;", "stopSoundRunnable", "Ljava/lang/Runnable;", "getLayoutId", "", "onAppBackground", "", "activity", "", "onAppForeground", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onStart", "onStop", "reset", "setBlurBg", "view", "Landroid/view/View;", "plugin-force-notify_release"})
public final class ForceNotifyShowUI
  extends BaseForceNotifyShowUI
  implements com.tencent.mm.app.o
{
  private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  private AudioManager mAudioManager;
  private Vibrator mZD;
  private MediaPlayer tvm;
  private Runnable tvn;
  private final aq tvo;
  private com.tencent.mm.plugin.forcenotify.c.d tvp;
  
  public ForceNotifyShowUI()
  {
    AppMethodBeat.i(149247);
    this.tvo = new aq(Looper.getMainLooper());
    this.tvp = new com.tencent.mm.plugin.forcenotify.c.d();
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
    this.tvo.removeCallbacksAndMessages(null);
    localObject = this.mAudioManager;
    if (localObject != null) {
      ((AudioManager)localObject).abandonAudioFocus(this.audioFocusChangeListener);
    }
    try
    {
      localObject = getWindow();
      p.g(localObject, "window");
      ((Window)localObject).getDecorView().removeCallbacks(this.tvn);
      localObject = this.tvn;
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
      this.tvn = null;
      AppMethodBeat.o(149246);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      ae.printErrStackTrace(this.TAG, (Throwable)localIllegalStateException, "", new Object[0]);
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
    ae.i(this.TAG, "[onBackPressed]");
    String str = String.valueOf(this.tvp.field_CreateTime / 1000L) + this.tvp.field_UserName;
    ((com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).f(this.tvp.field_ForcePushId, str, 8, ch.aDb() / 1000L);
    AppMethodBeat.o(149238);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(149237);
    super.onCreate(paramBundle);
    com.tencent.mm.util.d.evs();
    ae.i(this.TAG, "[onCreate] username=" + this.username);
    paramBundle = this.username;
    Object localObject1;
    if (paramBundle != null)
    {
      localObject1 = com.tencent.mm.plugin.forcenotify.d.a.tuN;
      this.tvp = com.tencent.mm.plugin.forcenotify.d.a.akB(paramBundle);
    }
    AppForegroundDelegate.cTA.a((com.tencent.mm.app.o)this);
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
    this.mZD = ((Vibrator)paramBundle);
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
      ae.i(this.TAG, "V:%s V1:%s  R:%s", new Object[] { paramBundle, localObject1, localObject2 });
      this.audioFocusChangeListener = ((AudioManager.OnAudioFocusChangeListener)b.tvr);
      paramBundle = this.mAudioManager;
      if (paramBundle == null) {
        break label692;
      }
      paramBundle = Integer.valueOf(paramBundle.requestAudioFocus(this.audioFocusChangeListener, 3, 2));
      label270:
      this.tvo.postDelayed((Runnable)new c(this), 1000L);
      localObject1 = getWindow();
      p.g(localObject1, "window");
      localObject1 = ((Window)localObject1).getDecorView();
      p.g(localObject1, "window.decorView");
      ((View)localObject1).setKeepScreenOn(true);
      p.g(findViewById(2131298739), "findViewById(R.id.content)");
      getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(getResources().getColor(2131100384)));
      ae.i(this.TAG, "[onCreate] username:%s requestAudioFocus:%s", new Object[] { this.username, paramBundle });
      localObject1 = (TextView)findViewById(2131302867);
      paramBundle = (ImageView)findViewById(2131297008);
      findViewById(2131300872).setOnClickListener((View.OnClickListener)new d(this));
      this.tvn = ((Runnable)new e(this));
      this.tvo.postDelayed(this.tvn, 60000L);
      localObject2 = (CharSequence)this.tvp.field_ForcePushId;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label697;
      }
      i = 1;
      label486:
      if (i != 0) {
        break label702;
      }
      localObject2 = this.tvp.field_ForcePushId;
      p.g(localObject2, "info.field_ForcePushId");
      if (!n.nG((String)localObject2, "@miniapp")) {
        break label702;
      }
      ((com.tencent.mm.plugin.appbrand.service.o)g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).a(this.username, (o.a)new f(this, paramBundle, (TextView)localObject1));
      paramBundle = (com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class);
      localObject1 = this.username;
      localObject2 = c.tuL;
      localObject2 = getContext();
      p.g(localObject2, "context");
      if (!c.fl((Context)localObject2)) {
        break label829;
      }
      localObject2 = c.tuL;
      localObject2 = getContext();
      p.g(localObject2, "context");
      if (!c.fm((Context)localObject2)) {
        break label824;
      }
      i = 1;
    }
    for (;;)
    {
      paramBundle.B((String)localObject1, i, ch.aDb() / 1000L);
      if (this.username != null)
      {
        paramBundle = com.tencent.mm.plugin.forcenotify.d.a.tuN;
        localObject1 = this.username;
        if (localObject1 == null) {
          p.gkB();
        }
        paramBundle.Dc((String)localObject1);
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
      localObject2 = this.tvp;
      com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
      ((com.tencent.mm.plugin.forcenotify.c.d)localObject2).contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).azF().BH(this.username);
      a.b.d(paramBundle, this.username, 0.1F);
      p.g(localObject1, "titleView");
      localObject2 = (Context)getContext();
      paramBundle = this.tvp.contact;
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.adG();; paramBundle = null)
      {
        ((TextView)localObject1).setText((CharSequence)k.a((Context)localObject2, (CharSequence)paramBundle, (int)((TextView)localObject1).getTextSize(), 0, null, null));
        break;
      }
      label824:
      i = 4;
      continue;
      label829:
      localObject2 = c.tuL;
      localObject2 = getContext();
      p.g(localObject2, "context");
      if (c.fm((Context)localObject2)) {
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
    String str = this.tvp.field_ForcePushId;
    if (str != null) {
      com.tencent.mm.plugin.forcenotify.d.a.tuN.Dc(str);
    }
    AppForegroundDelegate.cTA.b((com.tencent.mm.app.o)this);
    AppMethodBeat.o(149245);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(149240);
    p.h(paramKeyEvent, "event");
    ae.i(this.TAG, "[onKeyDown] keyCode:".concat(String.valueOf(paramInt)));
    reset();
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(149240);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(149243);
    super.onPause();
    ae.i(this.TAG, "onPause");
    AppMethodBeat.o(149243);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(149242);
    super.onResume();
    ae.i(this.TAG, "onResume");
    AppMethodBeat.o(149242);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(149241);
    super.onStart();
    ae.i(this.TAG, "onStart");
    AppMethodBeat.o(149241);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(149244);
    super.onStop();
    ae.i(this.TAG, "onStop");
    reset();
    AppMethodBeat.o(149244);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149230);
      ForceNotifyShowUI.d(this.tvq);
      AppMethodBeat.o(149230);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "onAudioFocusChange"})
  static final class b
    implements AudioManager.OnAudioFocusChangeListener
  {
    public static final b tvr;
    
    static
    {
      AppMethodBeat.i(149231);
      tvr = new b();
      AppMethodBeat.o(149231);
    }
    
    public final void onAudioFocusChange(int paramInt) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149232);
      Object localObject = c.tuL;
      localObject = this.tvq.getContext();
      p.g(localObject, "context");
      if (!c.fl((Context)localObject)) {
        ForceNotifyShowUI.a(this.tvq, be.a((Context)this.tvq.getContext(), 2131759601, be.b.Izy, 2, true, null));
      }
      localObject = c.tuL;
      localObject = this.tvq.getContext();
      p.g(localObject, "context");
      if (c.fm((Context)localObject))
      {
        localObject = ForceNotifyShowUI.b(this.tvq);
        if (localObject == null) {
          p.gkB();
        }
        ((Vibrator)localObject).vibrate(new long[] { 1000L, 1000L, 1000L, 1000L }, 0);
      }
      AppMethodBeat.o(149232);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149233);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (ForceNotifyShowUI.c(this.tvq).field_CreateTime > 0L)
      {
        paramView = String.valueOf(ForceNotifyShowUI.c(this.tvq).field_CreateTime / 1000L) + ForceNotifyShowUI.c(this.tvq).field_UserName;
        ((com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).f(ForceNotifyShowUI.c(this.tvq).field_ForcePushId, paramView, 2, ch.aDb() / 1000L);
      }
      this.tvq.finish();
      this.tvq.overridePendingTransition(0, 2130772106);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(149233);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149234);
      try
      {
        Object localObject = ForceNotifyShowUI.b(this.tvq);
        if (localObject != null) {
          ((Vibrator)localObject).cancel();
        }
        localObject = ForceNotifyShowUI.a(this.tvq);
        if (localObject != null) {
          ((MediaPlayer)localObject).stop();
        }
        localObject = ForceNotifyShowUI.a(this.tvq);
        if (localObject != null) {
          ((MediaPlayer)localObject).release();
        }
        localObject = this.tvq.getWindow();
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
  static final class f
    implements o.a
  {
    f(ForceNotifyShowUI paramForceNotifyShowUI, ImageView paramImageView, TextView paramTextView) {}
    
    public final void b(final WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(149236);
      ae.i(this.tvq.TAG, "getOrSync result=".concat(String.valueOf(paramWxaAttributes)));
      if (paramWxaAttributes == null)
      {
        AppMethodBeat.o(149236);
        return;
      }
      ar.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149235);
          q.aJb().loadImage(this.tvc, this.tvu.tvs);
          TextView localTextView1 = this.tvu.tvt;
          p.g(localTextView1, "titleView");
          Context localContext = (Context)this.tvu.tvq.getContext();
          CharSequence localCharSequence = (CharSequence)paramWxaAttributes.field_nickname;
          TextView localTextView2 = this.tvu.tvt;
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