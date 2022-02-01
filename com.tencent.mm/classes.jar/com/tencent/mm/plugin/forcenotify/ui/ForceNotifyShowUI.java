package com.tencent.mm.plugin.forcenotify.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Looper;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.forcenotify.a.a;
import com.tencent.mm.plugin.forcenotify.a.e;
import com.tencent.mm.plugin.forcenotify.a.f;
import com.tencent.mm.plugin.forcenotify.a.g;
import com.tencent.mm.plugin.forcenotify.c.c;
import com.tencent.mm.plugin.forcenotify.d.d;
import com.tencent.mm.plugin.forcenotify.d.e;
import com.tencent.mm.plugin.forcenotify.d.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(3)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI;", "Lcom/tencent/mm/plugin/forcenotify/ui/BaseForceNotifyShowUI;", "()V", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "hasPlay", "", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getInfo", "()Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "info$delegate", "needSound", "playSoundRunnable", "Ljava/lang/Runnable;", "soundPlay", "Landroid/media/MediaPlayer;", "stopSoundRunnable", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "vibrator$delegate", "adjustUI", "", "getLayoutId", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onStart", "onStop", "playSound", "reset", "stopSound", "plugin-force-notify_release"})
public final class ForceNotifyShowUI
  extends BaseForceNotifyShowUI
{
  private boolean Azc;
  private Runnable BEA;
  private Runnable BEB;
  private boolean BEC;
  private final kotlin.f BED;
  private MediaPlayer BEz;
  private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  private final MMHandler knk;
  private final kotlin.f pLA;
  private final kotlin.f yWF;
  
  public ForceNotifyShowUI()
  {
    AppMethodBeat.i(149247);
    this.pLA = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.yWF = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.audioFocusChangeListener = ((AudioManager.OnAudioFocusChangeListener)ForceNotifyShowUI.a.BEE);
    this.knk = new MMHandler(Looper.getMainLooper());
    this.BED = kotlin.g.ar((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(149247);
  }
  
  private final Vibrator eqq()
  {
    AppMethodBeat.i(252826);
    Vibrator localVibrator = (Vibrator)this.yWF.getValue();
    AppMethodBeat.o(252826);
    return localVibrator;
  }
  
  private final void eqr()
  {
    AppMethodBeat.i(252828);
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
      localObject = getWindow();
      p.j(localObject, "window");
      localObject = ((Window)localObject).getDecorView();
      p.j(localObject, "window.decorView");
      ((View)localObject).setKeepScreenOn(false);
      getAudioManager().abandonAudioFocus(this.audioFocusChangeListener);
      AppMethodBeat.o(252828);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(252828);
    }
  }
  
  private final AudioManager getAudioManager()
  {
    AppMethodBeat.i(252824);
    AudioManager localAudioManager = (AudioManager)this.pLA.getValue();
    AppMethodBeat.o(252824);
    return localAudioManager;
  }
  
  private final void reset()
  {
    AppMethodBeat.i(149246);
    Log.i(getTAG(), "reset");
    if (this.Azc) {
      this.BEC = false;
    }
    Object localObject = getWindow();
    p.j(localObject, "window");
    localObject = ((Window)localObject).getDecorView();
    p.j(localObject, "window.decorView");
    ((View)localObject).setKeepScreenOn(false);
    this.knk.removeCallbacksAndMessages(null);
    try
    {
      this.knk.removeCallbacks(this.BEA);
      eqr();
      AppMethodBeat.o(149246);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.printErrStackTrace(getTAG(), (Throwable)localIllegalStateException, "", new Object[0]);
      AppMethodBeat.o(149246);
    }
  }
  
  public final int getLayoutId()
  {
    return a.f.force_notify_show_ui;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(149238);
    super.onBackPressed();
    Log.i(getTAG(), "[onBackPressed]");
    e locale = this.BEb;
    if (locale != null)
    {
      if ((locale instanceof com.tencent.mm.plugin.forcenotify.d.h))
      {
        String str = String.valueOf(((com.tencent.mm.plugin.forcenotify.d.h)locale).createTime / 1000L) + ((com.tencent.mm.plugin.forcenotify.d.h)locale).username;
        ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.a.class)).f(locale.BDR, str, 8, cm.bfD() / 1000L);
      }
      AppMethodBeat.o(149238);
      return;
    }
    AppMethodBeat.o(149238);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(149237);
    super.onCreate(paramBundle);
    if (this.BEb == null)
    {
      finish();
      AppMethodBeat.o(149237);
      return;
    }
    final e locale = this.BEb;
    if (locale == null) {
      p.iCn();
    }
    int i = getAudioManager().getVibrateSetting(1);
    int j = getAudioManager().getVibrateSetting(0);
    int k = getAudioManager().getRingerMode();
    Log.i(getTAG(), "V:%s V1:%s  R:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    i = getAudioManager().requestAudioFocus(this.audioFocusChangeListener, 3, 2);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setKeepScreenOn(true);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject1;
    if (ar.isDarkMode())
    {
      paramBundle = (TextView)findViewById(a.e.nickname_tv);
      if (paramBundle != null) {
        paramBundle.setTextColor(getResources().getColor(com.tencent.mm.plugin.forcenotify.a.b.force_notify_text_white_80));
      }
      paramBundle = (TextView)findViewById(a.e.wording_tv);
      if (paramBundle != null) {
        paramBundle.setTextColor(getResources().getColor(com.tencent.mm.plugin.forcenotify.a.b.force_notify_text_white_80));
      }
      paramBundle = (TextView)findViewById(a.e.title_tv);
      if (paramBundle != null) {
        paramBundle.setTextColor(getResources().getColor(com.tencent.mm.plugin.forcenotify.a.b.force_notify_icon_full_screen_color_dark));
      }
      paramBundle = (WeImageView)findViewById(a.e.icon_iv);
      if (paramBundle != null) {
        paramBundle.setIconColor(getResources().getColor(com.tencent.mm.plugin.forcenotify.a.b.force_notify_icon_full_screen_color_dark));
      }
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.j(paramBundle, "window.decorView");
      paramBundle.setBackground((Drawable)new ColorDrawable(getResources().getColor(com.tencent.mm.plugin.forcenotify.a.b.force_notify_full_screen_background_color_dark)));
      this.BEC = true;
      this.BEB = ((Runnable)new d(this));
      this.BEA = ((Runnable)new e(this));
      Log.i(getTAG(), "[onCreate] forcePushId:%s requestAudioFocus:%s", new Object[] { locale.BDR, Integer.valueOf(i) });
      paramBundle = (TextView)findViewById(a.e.nickname_tv);
      localObject2 = (ImageView)findViewById(a.e.avatar_iv);
      localObject3 = (TextView)findViewById(a.e.wording_tv);
      localObject4 = (ImageView)findViewById(a.e.auth_icon_iv);
      localObject5 = (ImageView)findViewById(a.e.close_btn);
      localObject1 = (TextView)findViewById(a.e.desc_tv);
      p.j(localObject3, "wordingTv");
      ar.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
      findViewById(a.e.i_kown).setOnClickListener((View.OnClickListener)new f(this, locale));
      ((ImageView)localObject5).setOnClickListener((View.OnClickListener)new g(this, locale));
      if (!(locale instanceof com.tencent.mm.plugin.forcenotify.d.h)) {
        break label918;
      }
      if (!n.pu(locale.BDR, "@miniapp")) {
        break label899;
      }
      com.tencent.mm.ay.q.bml().loadImage(((com.tencent.mm.plugin.forcenotify.d.h)locale).nfY, (ImageView)localObject2);
      label553:
      p.j(paramBundle, "nicknameTv");
      paramBundle.setText((CharSequence)((com.tencent.mm.plugin.forcenotify.d.h)locale).nickname);
      ((TextView)localObject3).setText((CharSequence)((com.tencent.mm.plugin.forcenotify.d.h)locale).wording);
      label591:
      localObject1 = this.BEb;
      if (localObject1 != null)
      {
        j = -1;
        if (!(localObject1 instanceof com.tencent.mm.plugin.forcenotify.d.h)) {
          break label1248;
        }
        paramBundle = ((com.tencent.mm.plugin.forcenotify.d.h)localObject1).username;
        j = 1;
        label623:
        localObject2 = (com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.a.class);
        localObject3 = c.BDQ;
        localObject4 = getContext();
        p.j(localObject4, "context");
        if (!((c)localObject3).gk((Context)localObject4)) {
          break label1282;
        }
        localObject3 = c.BDQ;
        localObject4 = getContext();
        p.j(localObject4, "context");
        if (!((c)localObject3).gl((Context)localObject4)) {
          break label1277;
        }
        i = 1;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.forcenotify.a.a)localObject2).a(paramBundle, i, j, ((e)localObject1).BDR, true);
      com.tencent.mm.plugin.forcenotify.e.b.BEa.ho(locale.BDR);
      AppMethodBeat.o(149237);
      return;
      paramBundle = (TextView)findViewById(a.e.nickname_tv);
      if (paramBundle != null) {
        paramBundle.setTextColor(getResources().getColor(com.tencent.mm.plugin.forcenotify.a.b.force_notify_text_dark_90));
      }
      paramBundle = (TextView)findViewById(a.e.wording_tv);
      if (paramBundle != null) {
        paramBundle.setTextColor(getResources().getColor(com.tencent.mm.plugin.forcenotify.a.b.force_notify_text_dark_90));
      }
      paramBundle = (TextView)findViewById(a.e.title_tv);
      if (paramBundle != null) {
        paramBundle.setTextColor(getResources().getColor(com.tencent.mm.plugin.forcenotify.a.b.force_notify_icon_full_screen_color));
      }
      paramBundle = (WeImageView)findViewById(a.e.icon_iv);
      if (paramBundle != null) {
        paramBundle.setIconColor(getResources().getColor(com.tencent.mm.plugin.forcenotify.a.b.force_notify_icon_full_screen_color));
      }
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.j(paramBundle, "window.decorView");
      paramBundle.setBackground((Drawable)new ColorDrawable(getResources().getColor(com.tencent.mm.plugin.forcenotify.a.b.force_notify_full_screen_background_color)));
      break;
      label899:
      com.tencent.mm.pluginsdk.ui.a.b.d((ImageView)localObject2, ((com.tencent.mm.plugin.forcenotify.d.h)locale).username, 0.1F);
      break label553;
      label918:
      if (!(locale instanceof com.tencent.mm.plugin.forcenotify.d.g)) {
        break label591;
      }
      if (((CharSequence)((com.tencent.mm.plugin.forcenotify.d.g)locale).nfY).length() > 0)
      {
        i = 1;
        label947:
        if (i == 0) {
          break label1160;
        }
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).loadAvatar(((com.tencent.mm.plugin.forcenotify.d.g)locale).nfY, (ImageView)localObject2);
        label975:
        if (((com.tencent.mm.plugin.forcenotify.d.g)locale).authIconUrl == null) {
          break label1197;
        }
        if (((CharSequence)((com.tencent.mm.plugin.forcenotify.d.g)locale).authIconUrl).length() <= 0) {
          break label1192;
        }
        i = 1;
        label1007:
        if (i == 0) {
          break label1197;
        }
        p.j(localObject4, "authIv");
        ((ImageView)localObject4).setVisibility(0);
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).loadImage(((com.tencent.mm.plugin.forcenotify.d.g)locale).authIconUrl, (ImageView)localObject4);
        label1049:
        p.j(paramBundle, "nicknameTv");
        paramBundle.setText((CharSequence)((com.tencent.mm.plugin.forcenotify.d.g)locale).nickname);
        ((TextView)localObject3).setText((CharSequence)((com.tencent.mm.plugin.forcenotify.d.g)locale).wording);
        paramBundle = ((com.tencent.mm.plugin.forcenotify.d.g)locale).BDX;
        if (paramBundle == null) {
          break label1220;
        }
        if (((CharSequence)paramBundle).length() <= 0) {
          break label1215;
        }
        i = 1;
        label1114:
        if (i != 1) {
          break label1220;
        }
        i = 1;
        label1121:
        if (i == 0) {
          break label1225;
        }
      }
      for (;;)
      {
        if (paramBundle == null) {
          break label1230;
        }
        p.j(localObject1, "descTv");
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText((CharSequence)paramBundle);
        break;
        i = 0;
        break label947;
        label1160:
        localObject5 = getContext();
        p.j(localObject5, "context");
        ((ImageView)localObject2).setImageDrawable(com.tencent.mm.svg.a.a.h(((AppCompatActivity)localObject5).getResources(), a.g.default_round_avatar));
        break label975;
        label1192:
        i = 0;
        break label1007;
        label1197:
        p.j(localObject4, "authIv");
        ((ImageView)localObject4).setVisibility(8);
        break label1049;
        label1215:
        i = 0;
        break label1114;
        label1220:
        i = 0;
        break label1121;
        label1225:
        paramBundle = null;
      }
      label1230:
      p.j(localObject1, "descTv");
      ((TextView)localObject1).setVisibility(8);
      break label591;
      label1248:
      if ((localObject1 instanceof com.tencent.mm.plugin.forcenotify.d.g))
      {
        paramBundle = ((com.tencent.mm.plugin.forcenotify.d.g)localObject1).feedId;
        j = 2;
        break label623;
      }
      paramBundle = "";
      break label623;
      label1277:
      i = 4;
      continue;
      label1282:
      localObject3 = c.BDQ;
      localObject4 = getContext();
      p.j(localObject4, "context");
      if (((c)localObject3).gl((Context)localObject4)) {
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
    this.BEB = null;
    this.BEA = null;
    Object localObject = this.BEb;
    if (localObject != null)
    {
      localObject = ((e)localObject).BDR;
      if (localObject != null)
      {
        com.tencent.mm.plugin.forcenotify.e.b.BEa.ho((String)localObject);
        AppMethodBeat.o(149245);
        return;
      }
    }
    AppMethodBeat.o(149245);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(149240);
    p.k(paramKeyEvent, "event");
    Log.i(getTAG(), "[onKeyDown] keyCode:".concat(String.valueOf(paramInt)));
    reset();
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(149240);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(149243);
    super.onPause();
    Log.i(getTAG(), "onPause");
    AppMethodBeat.o(149243);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(149242);
    super.onResume();
    Log.i(getTAG(), "onResume");
    AppMethodBeat.o(149242);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(149241);
    super.onStart();
    Log.i(getTAG(), "onStart");
    if (this.BEC)
    {
      this.knk.postDelayed(this.BEB, 1000L);
      this.knk.postDelayed(this.BEA, 60000L);
    }
    AppMethodBeat.o(149241);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(149244);
    super.onStop();
    reset();
    Log.i(getTAG(), "onStop");
    AppMethodBeat.o(149244);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/media/AudioManager;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<AudioManager>
  {
    b(ForceNotifyShowUI paramForceNotifyShowUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<d>
  {
    c(ForceNotifyShowUI paramForceNotifyShowUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(253244);
      ForceNotifyShowUI.a(this.BEF);
      AppMethodBeat.o(253244);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ForceNotifyShowUI paramForceNotifyShowUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(252914);
      ForceNotifyShowUI.b(this.BEF);
      ForceNotifyShowUI.c(this.BEF);
      AppMethodBeat.o(252914);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(ForceNotifyShowUI paramForceNotifyShowUI, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(253130);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = com.tencent.mm.plugin.forcenotify.f.b.BFh;
      p.j(paramView, "it");
      paramView = paramView.getContext();
      p.j(paramView, "it.context");
      localObject = locale;
      f.a locala = com.tencent.mm.plugin.forcenotify.d.f.BDU;
      com.tencent.mm.plugin.forcenotify.f.b.a(paramView, (e)localObject, f.a.eql().BDS.size());
      ForceNotifyShowUI.c(this.BEF);
      this.BEF.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(253130);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(ForceNotifyShowUI paramForceNotifyShowUI, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149233);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if ((locale instanceof com.tencent.mm.plugin.forcenotify.d.h))
      {
        paramView = String.valueOf(((com.tencent.mm.plugin.forcenotify.d.h)locale).createTime / 1000L) + ((com.tencent.mm.plugin.forcenotify.d.h)locale).username;
        ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.a.class)).f(locale.BDR, paramView, 2, cm.bfD() / 1000L);
      }
      this.BEF.finish();
      ForceNotifyShowUI.c(this.BEF);
      this.BEF.overridePendingTransition(0, a.a.push_down_out);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(149233);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/os/Vibrator;", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Vibrator>
  {
    h(ForceNotifyShowUI paramForceNotifyShowUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI
 * JD-Core Version:    0.7.0.1
 */