package com.tencent.mm.plugin.forcenotify.ui;

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
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.forcenotify.a.a;
import com.tencent.mm.plugin.forcenotify.a.e;
import com.tencent.mm.plugin.forcenotify.a.f;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.forcenotify.c.f;
import com.tencent.mm.plugin.forcenotify.core.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.PlaySound.SPEAKERON;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI;", "Lcom/tencent/mm/plugin/forcenotify/ui/BaseForceNotifyShowUI;", "()V", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "hasPlay", "", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getInfo", "()Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "info$delegate", "needSound", "playSoundRunnable", "Ljava/lang/Runnable;", "soundPlay", "Landroid/media/MediaPlayer;", "stopSoundRunnable", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "vibrator$delegate", "adjustUI", "", "getLayoutId", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onStart", "onStop", "playSound", "removeWordingMargin", "wordingContainer", "Landroid/view/View;", "reset", "stopSound", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ForceNotifyShowUI
  extends BaseForceNotifyShowUI
{
  private boolean FYr;
  private final kotlin.j HoR;
  private MediaPlayer HoS;
  private Runnable HoT;
  private Runnable HoU;
  private boolean HoV;
  private final kotlin.j HoW;
  private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  private final MMHandler mRi;
  private final kotlin.j sQv;
  
  public ForceNotifyShowUI()
  {
    AppMethodBeat.i(149247);
    this.sQv = kotlin.k.cm((kotlin.g.a.a)new a(this));
    this.HoR = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.audioFocusChangeListener = ForceNotifyShowUI..ExternalSyntheticLambda0.INSTANCE;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.HoW = kotlin.k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(149247);
  }
  
  private static final void VZ(int paramInt) {}
  
  private static final void a(com.tencent.mm.plugin.forcenotify.c.a parama, ForceNotifyShowUI paramForceNotifyShowUI, View paramView)
  {
    AppMethodBeat.i(274956);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramForceNotifyShowUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$item");
    s.u(paramForceNotifyShowUI, "this$0");
    s.s(paramView, "it");
    parama.hp(paramView);
    paramForceNotifyShowUI.HoV = false;
    paramForceNotifyShowUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(274956);
  }
  
  private static final void a(ForceNotifyShowUI paramForceNotifyShowUI)
  {
    AppMethodBeat.i(274945);
    s.u(paramForceNotifyShowUI, "this$0");
    if (!c.a(c.Hoc))
    {
      Log.i(paramForceNotifyShowUI.getTAG(), "PlaySound.playRoot");
      paramForceNotifyShowUI.HoS = PlaySound.playRoot((Context)paramForceNotifyShowUI.getContext(), a.h.force_notify_voice, PlaySound.SPEAKERON.NOTSET, 2, true, null);
    }
    if (c.b(c.Hoc))
    {
      Log.i(paramForceNotifyShowUI.getTAG(), "vibrator.vibrate");
      paramForceNotifyShowUI.fwU().vibrate(new long[] { 1000L, 1000L, 1000L, 1000L }, 0);
    }
    paramForceNotifyShowUI.FYr = true;
    AppMethodBeat.o(274945);
  }
  
  private static final void b(com.tencent.mm.plugin.forcenotify.c.a parama, ForceNotifyShowUI paramForceNotifyShowUI, View paramView)
  {
    AppMethodBeat.i(274964);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramForceNotifyShowUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$item");
    s.u(paramForceNotifyShowUI, "this$0");
    if ((parama instanceof com.tencent.mm.plugin.forcenotify.c.k))
    {
      paramView = ((com.tencent.mm.plugin.forcenotify.c.k)parama).createTime / 1000L + ((com.tencent.mm.plugin.forcenotify.c.k)parama).username;
      ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.a.class)).f(parama.id, paramView, 2, com.tencent.mm.model.cn.bDv() / 1000L);
    }
    paramForceNotifyShowUI.finish();
    paramForceNotifyShowUI.HoV = false;
    paramForceNotifyShowUI.overridePendingTransition(0, a.a.push_down_out);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(274964);
  }
  
  private static final void b(ForceNotifyShowUI paramForceNotifyShowUI)
  {
    AppMethodBeat.i(274951);
    s.u(paramForceNotifyShowUI, "this$0");
    paramForceNotifyShowUI.fwV();
    paramForceNotifyShowUI.HoV = false;
    AppMethodBeat.o(274951);
  }
  
  private final Vibrator fwU()
  {
    AppMethodBeat.i(274920);
    Vibrator localVibrator = (Vibrator)this.HoR.getValue();
    AppMethodBeat.o(274920);
    return localVibrator;
  }
  
  private final void fwV()
  {
    AppMethodBeat.i(274932);
    try
    {
      fwU().cancel();
      MediaPlayer localMediaPlayer = this.HoS;
      if (localMediaPlayer != null) {
        localMediaPlayer.stop();
      }
      localMediaPlayer = this.HoS;
      if (localMediaPlayer != null) {
        localMediaPlayer.release();
      }
      getWindow().getDecorView().setKeepScreenOn(false);
      getAudioManager().abandonAudioFocus(this.audioFocusChangeListener);
      AppMethodBeat.o(274932);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(274932);
    }
  }
  
  private final AudioManager getAudioManager()
  {
    AppMethodBeat.i(274916);
    AudioManager localAudioManager = (AudioManager)this.sQv.getValue();
    AppMethodBeat.o(274916);
    return localAudioManager;
  }
  
  private static void hr(View paramView)
  {
    AppMethodBeat.i(274924);
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(274924);
      throw paramView;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(274924);
  }
  
  private final void reset()
  {
    AppMethodBeat.i(149246);
    Log.i(getTAG(), "reset");
    if (this.FYr) {
      this.HoV = false;
    }
    getWindow().getDecorView().setKeepScreenOn(false);
    this.mRi.removeCallbacksAndMessages(null);
    try
    {
      this.mRi.removeCallbacks(this.HoT);
      fwV();
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
    com.tencent.mm.plugin.forcenotify.c.a locala = this.HoB;
    if ((locala != null) && ((locala instanceof com.tencent.mm.plugin.forcenotify.c.k)))
    {
      String str = ((com.tencent.mm.plugin.forcenotify.c.k)locala).createTime / 1000L + ((com.tencent.mm.plugin.forcenotify.c.k)locala).username;
      ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.a.class)).f(locala.id, str, 8, com.tencent.mm.model.cn.bDv() / 1000L);
    }
    AppMethodBeat.o(149238);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(149237);
    super.onCreate(paramBundle);
    if (this.HoB == null)
    {
      finish();
      AppMethodBeat.o(149237);
      return;
    }
    com.tencent.mm.plugin.forcenotify.c.a locala = this.HoB;
    s.checkNotNull(locala);
    int i = getAudioManager().getVibrateSetting(1);
    int j = getAudioManager().getVibrateSetting(0);
    int k = getAudioManager().getRingerMode();
    Log.i(getTAG(), "V:%s V1:%s  R:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    i = getAudioManager().requestAudioFocus(this.audioFocusChangeListener, 3, 2);
    getWindow().getDecorView().setKeepScreenOn(true);
    ImageView localImageView1;
    TextView localTextView1;
    ImageView localImageView2;
    Object localObject1;
    View localView;
    ImageView localImageView4;
    TextView localTextView2;
    Object localObject2;
    if (aw.isDarkMode())
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
      getWindow().getDecorView().setBackground((Drawable)new ColorDrawable(getResources().getColor(com.tencent.mm.plugin.forcenotify.a.b.force_notify_full_screen_background_color_dark)));
      this.HoV = true;
      this.HoU = new ForceNotifyShowUI..ExternalSyntheticLambda4(this);
      this.HoT = new ForceNotifyShowUI..ExternalSyntheticLambda3(this);
      Log.i(getTAG(), "[onCreate] forcePushId:%s requestAudioFocus:%s", new Object[] { locala.id, Integer.valueOf(i) });
      paramBundle = (TextView)findViewById(a.e.nickname_tv);
      localImageView1 = (ImageView)findViewById(a.e.avatar_iv);
      localTextView1 = (TextView)findViewById(a.e.wording_tv);
      localImageView2 = (ImageView)findViewById(a.e.auth_icon_iv);
      ImageView localImageView3 = (ImageView)findViewById(a.e.close_btn);
      localObject1 = (TextView)findViewById(a.e.desc_tv);
      localView = findViewById(a.e.nickname_container);
      localImageView4 = (ImageView)findViewById(a.e.auth_icon_iv_new);
      localTextView2 = (TextView)findViewById(a.e.nickname_tv_new);
      findViewById(a.e.icon_iv);
      TextView localTextView3 = (TextView)findViewById(a.e.title_tv);
      localObject2 = findViewById(a.e.wording_container);
      localTextView3.setText((CharSequence)locala.dXa());
      aw.a((Paint)localTextView1.getPaint(), 0.8F);
      aw.a((Paint)localTextView2.getPaint(), 0.8F);
      findViewById(a.e.i_kown).setOnClickListener(new ForceNotifyShowUI..ExternalSyntheticLambda1(locala, this));
      localImageView3.setOnClickListener(new ForceNotifyShowUI..ExternalSyntheticLambda2(locala, this));
      if (!(locala instanceof com.tencent.mm.plugin.forcenotify.c.k)) {
        break label881;
      }
      if (!n.rs(locala.id, "@miniapp")) {
        break label861;
      }
      r.bKe().loadImage(((com.tencent.mm.plugin.forcenotify.c.k)locala).nVM, localImageView1);
      label585:
      paramBundle.setText((CharSequence)((com.tencent.mm.plugin.forcenotify.c.k)locala).nickname);
      localTextView1.setText((CharSequence)((com.tencent.mm.plugin.forcenotify.c.k)locala).wording);
      label616:
      localObject1 = this.HoB;
      if (localObject1 != null)
      {
        if (!(localObject1 instanceof com.tencent.mm.plugin.forcenotify.c.k)) {
          break label1250;
        }
        j = 1;
        paramBundle = ((com.tencent.mm.plugin.forcenotify.c.k)localObject1).username;
        label646:
        localObject2 = (com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.a.class);
        if (!c.a(c.Hoc)) {
          break label1277;
        }
        if (!c.b(c.Hoc)) {
          break label1272;
        }
        i = 1;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.forcenotify.a.a)localObject2).a(paramBundle, i, j, ((com.tencent.mm.plugin.forcenotify.c.a)localObject1).id, true);
      label861:
      label881:
      do
      {
        com.tencent.mm.plugin.forcenotify.d.b.Hoz.iP(locala.id);
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
        getWindow().getDecorView().setBackground((Drawable)new ColorDrawable(getResources().getColor(com.tencent.mm.plugin.forcenotify.a.b.force_notify_full_screen_background_color)));
        break;
        com.tencent.mm.pluginsdk.ui.a.b.a(localImageView1, ((com.tencent.mm.plugin.forcenotify.c.k)locala).username, 0.1F, false);
        break label585;
        if ((locala instanceof com.tencent.mm.plugin.forcenotify.c.j))
        {
          localView.setVisibility(8);
          localImageView1.setVisibility(8);
          if (((com.tencent.mm.plugin.forcenotify.c.j)locala).authIconUrl != null) {
            if (((CharSequence)((com.tencent.mm.plugin.forcenotify.c.j)locala).authIconUrl).length() > 0)
            {
              i = 1;
              if (i == 0) {
                break label1087;
              }
              localImageView4.setVisibility(0);
              ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).loadImage(((com.tencent.mm.plugin.forcenotify.c.j)locala).authIconUrl, localImageView2);
              localTextView2.setVisibility(0);
              localTextView2.setText((CharSequence)((com.tencent.mm.plugin.forcenotify.c.j)locala).nickname);
              localTextView1.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(a.h.force_notify_live_start));
              paramBundle = ((com.tencent.mm.plugin.forcenotify.c.j)locala).Hox;
              if (paramBundle == null) {
                break label1102;
              }
              if (((CharSequence)paramBundle).length() <= 0) {
                break label1097;
              }
              i = 1;
              if (i != 1) {
                break label1102;
              }
              i = 1;
              if (i == 0) {
                break label1107;
              }
              if (paramBundle != null) {
                break label1112;
              }
            }
          }
          for (paramBundle = null;; paramBundle = ah.aiuX)
          {
            if (paramBundle == null) {
              ((TextView)localObject1).setVisibility(8);
            }
            s.s(localObject2, "wordingContainer");
            hr((View)localObject2);
            break;
            i = 0;
            break label935;
            localImageView4.setVisibility(8);
            break label969;
            i = 0;
            break label1038;
            i = 0;
            break label1045;
            paramBundle = null;
            break label1049;
            ((TextView)localObject1).setVisibility(0);
            ((TextView)localObject1).setText((CharSequence)paramBundle);
          }
        }
        if (!(locala instanceof f)) {
          break label616;
        }
        localView.setVisibility(8);
        localImageView1.setVisibility(8);
        localTextView1.setText((CharSequence)((f)locala).title);
        if (((CharSequence)((f)locala).desc).length() > 0)
        {
          i = 1;
          if (i == 0) {
            break label1240;
          }
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setText((CharSequence)((f)locala).desc);
        }
        for (;;)
        {
          s.s(localObject2, "wordingContainer");
          hr((View)localObject2);
          break;
          i = 0;
          break label1193;
          ((TextView)localObject1).setVisibility(8);
        }
      } while (!(localObject1 instanceof com.tencent.mm.plugin.forcenotify.c.j));
      label935:
      label969:
      label1102:
      label1107:
      label1112:
      label1250:
      j = 2;
      label1038:
      label1045:
      label1049:
      label1087:
      label1097:
      label1240:
      paramBundle = ((com.tencent.mm.plugin.forcenotify.c.j)localObject1).feedId;
      label1193:
      break label646;
      label1272:
      i = 4;
      continue;
      label1277:
      if (c.b(c.Hoc)) {
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
    this.HoU = null;
    this.HoT = null;
    Object localObject = this.HoB;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.forcenotify.c.a)localObject).id;
      if (localObject != null) {
        com.tencent.mm.plugin.forcenotify.d.b.Hoz.iP((String)localObject);
      }
    }
    AppMethodBeat.o(149245);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(149240);
    s.u(paramKeyEvent, "event");
    Log.i(getTAG(), s.X("[onKeyDown] keyCode:", Integer.valueOf(paramInt)));
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
    if (this.HoV)
    {
      this.mRi.postDelayed(this.HoU, 1000L);
      this.mRi.postDelayed(this.HoT, 60000L);
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
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/media/AudioManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<AudioManager>
  {
    a(ForceNotifyShowUI paramForceNotifyShowUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.forcenotify.c.h>
  {
    b(ForceNotifyShowUI paramForceNotifyShowUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/os/Vibrator;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Vibrator>
  {
    c(ForceNotifyShowUI paramForceNotifyShowUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI
 * JD-Core Version:    0.7.0.1
 */