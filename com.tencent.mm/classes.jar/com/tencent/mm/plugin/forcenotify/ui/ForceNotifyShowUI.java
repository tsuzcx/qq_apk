package com.tencent.mm.plugin.forcenotify.ui;

import a.l;
import a.v;
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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyShowUI;", "Lcom/tencent/mm/plugin/forcenotify/ui/BaseForceNotifyShowUI;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "UIHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "mAudioManager", "Landroid/media/AudioManager;", "mSoundPlay", "Landroid/media/MediaPlayer;", "mVibrator", "Landroid/os/Vibrator;", "stopSoundRunnable", "Ljava/lang/Runnable;", "getLayoutId", "", "onAppBackground", "", "activity", "", "onAppForeground", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onStart", "onStop", "reset", "setBlurBg", "view", "Landroid/view/View;", "plugin-force-notify_release"})
@com.tencent.mm.ui.base.a(3)
public final class ForceNotifyShowUI
  extends BaseForceNotifyShowUI
  implements com.tencent.mm.app.j
{
  private Vibrator jbU;
  private AudioManager mAudioManager;
  private MediaPlayer mHS;
  private Runnable mHT;
  private AudioManager.OnAudioFocusChangeListener mHU;
  private final ak mHV;
  private d mHW;
  
  public ForceNotifyShowUI()
  {
    AppMethodBeat.i(51095);
    this.mHV = new ak(Looper.getMainLooper());
    this.mHW = new d();
    AppMethodBeat.o(51095);
  }
  
  private final void reset()
  {
    AppMethodBeat.i(51094);
    Object localObject = getWindow();
    a.f.b.j.p(localObject, "window");
    localObject = ((Window)localObject).getDecorView();
    a.f.b.j.p(localObject, "window.decorView");
    ((View)localObject).setKeepScreenOn(false);
    this.mHV.removeCallbacksAndMessages(null);
    localObject = this.mAudioManager;
    if (localObject != null) {
      ((AudioManager)localObject).abandonAudioFocus(this.mHU);
    }
    try
    {
      localObject = getWindow();
      a.f.b.j.p(localObject, "window");
      ((Window)localObject).getDecorView().removeCallbacks(this.mHT);
      localObject = this.mHT;
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
      this.mHT = null;
      AppMethodBeat.o(51094);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)localIllegalStateException, "", new Object[0]);
      AppMethodBeat.o(51094);
    }
  }
  
  public final int getLayoutId()
  {
    return 2130969625;
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(140614);
    runOnUiThread((Runnable)new ForceNotifyShowUI.a(this));
    AppMethodBeat.o(140614);
  }
  
  public final void onAppForeground(String paramString) {}
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(51089);
    super.onBackPressed();
    ab.i(this.TAG, "[onBackPressed]");
    String str = String.valueOf(this.mHW.field_CreateTime / 1000L) + this.mHW.field_UserName;
    ((com.tencent.mm.plugin.forcenotify.a.a)g.E(com.tencent.mm.plugin.forcenotify.a.a.class)).b(this.mHW.field_ForcePushId, str, 8, cb.abq() / 1000L);
    AppMethodBeat.o(51089);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51088);
    super.onCreate(paramBundle);
    this.mHW.field_UserName = this.username;
    com.tencent.mm.plugin.forcenotify.d.a.mHw.get((com.tencent.mm.sdk.e.c)this.mHW, new String[0]);
    AppForegroundDelegate.bXk.a((com.tencent.mm.app.j)this);
    paramBundle = getSystemService("audio");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(51088);
      throw paramBundle;
    }
    this.mAudioManager = ((AudioManager)paramBundle);
    paramBundle = getContext().getSystemService("vibrator");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.os.Vibrator");
      AppMethodBeat.o(51088);
      throw paramBundle;
    }
    this.jbU = ((Vibrator)paramBundle);
    paramBundle = this.mAudioManager;
    Object localObject1;
    label164:
    Object localObject2;
    label185:
    label245:
    int i;
    if (paramBundle != null)
    {
      paramBundle = Integer.valueOf(paramBundle.getVibrateSetting(1));
      localObject1 = this.mAudioManager;
      if (localObject1 == null) {
        break label677;
      }
      localObject1 = Integer.valueOf(((AudioManager)localObject1).getVibrateSetting(0));
      localObject2 = this.mAudioManager;
      if (localObject2 == null) {
        break label682;
      }
      localObject2 = Integer.valueOf(((AudioManager)localObject2).getRingerMode());
      ab.i(this.TAG, "V:%s V1:%s  R:%s", new Object[] { paramBundle, localObject1, localObject2 });
      this.mHU = ((AudioManager.OnAudioFocusChangeListener)ForceNotifyShowUI.b.mHY);
      paramBundle = this.mAudioManager;
      if (paramBundle == null) {
        break label688;
      }
      paramBundle = Integer.valueOf(paramBundle.requestAudioFocus(this.mHU, 3, 2));
      this.mHV.postDelayed((Runnable)new ForceNotifyShowUI.c(this), 1000L);
      localObject1 = getWindow();
      a.f.b.j.p(localObject1, "window");
      localObject1 = ((Window)localObject1).getDecorView();
      a.f.b.j.p(localObject1, "window.decorView");
      ((View)localObject1).setKeepScreenOn(true);
      a.f.b.j.p(findViewById(2131820946), "findViewById(R.id.content)");
      getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(getResources().getColor(2131690069)));
      ab.i(this.TAG, "[onCreate] username:%s requestAudioFocus:%s", new Object[] { this.username, paramBundle });
      localObject1 = (TextView)findViewById(2131823254);
      paramBundle = (ImageView)findViewById(2131821210);
      findViewById(2131824244).setOnClickListener((View.OnClickListener)new ForceNotifyShowUI.d(this));
      this.mHT = ((Runnable)new ForceNotifyShowUI.e(this));
      this.mHV.postDelayed(this.mHT, 60000L);
      localObject2 = this.mHW;
      com.tencent.mm.kernel.c.a locala = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.f.b.j.p(locala, "MMKernel.service(IMessengerStorage::class.java)");
      ((d)localObject2).contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)locala).YA().arw(this.username);
      a.b.b(paramBundle, this.mHW.field_UserName, 0.1F);
      a.f.b.j.p(localObject1, "titleView");
      localObject2 = getBaseContext();
      paramBundle = this.mHW.contact;
      if (paramBundle == null) {
        break label693;
      }
      paramBundle = paramBundle.Of();
      label522:
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.d.j.a((Context)localObject2, (CharSequence)paramBundle, (int)((TextView)localObject1).getTextSize(), 0, null, null));
      paramBundle = (com.tencent.mm.plugin.forcenotify.a.a)g.E(com.tencent.mm.plugin.forcenotify.a.a.class);
      localObject1 = this.username;
      localObject2 = com.tencent.mm.plugin.forcenotify.b.c.mHu;
      localObject2 = getContext();
      a.f.b.j.p(localObject2, "context");
      if (!com.tencent.mm.plugin.forcenotify.b.c.isSilentMode((Context)localObject2)) {
        break label703;
      }
      localObject2 = com.tencent.mm.plugin.forcenotify.b.c.mHu;
      localObject2 = getContext();
      a.f.b.j.p(localObject2, "context");
      if (!com.tencent.mm.plugin.forcenotify.b.c.dX((Context)localObject2)) {
        break label698;
      }
      i = 1;
    }
    for (;;)
    {
      paramBundle.f((String)localObject1, i, cb.abq() / 1000L);
      if (this.username != null)
      {
        paramBundle = com.tencent.mm.plugin.forcenotify.d.a.mHw;
        localObject1 = this.username;
        if (localObject1 == null) {
          a.f.b.j.ebi();
        }
        paramBundle.qD((String)localObject1);
      }
      AppMethodBeat.o(51088);
      return;
      paramBundle = null;
      break;
      label677:
      localObject1 = null;
      break label164;
      label682:
      localObject2 = null;
      break label185;
      label688:
      paramBundle = null;
      break label245;
      label693:
      paramBundle = null;
      break label522;
      label698:
      i = 4;
      continue;
      label703:
      localObject2 = com.tencent.mm.plugin.forcenotify.b.c.mHu;
      localObject2 = getContext();
      a.f.b.j.p(localObject2, "context");
      if (com.tencent.mm.plugin.forcenotify.b.c.dX((Context)localObject2)) {
        i = 3;
      } else {
        i = 2;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(51092);
    super.onDestroy();
    reset();
    AppForegroundDelegate.bXk.b((com.tencent.mm.app.j)this);
    AppMethodBeat.o(51092);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(51090);
    a.f.b.j.q(paramKeyEvent, "event");
    ab.i(this.TAG, "[onKeyDown] keyCode:".concat(String.valueOf(paramInt)));
    reset();
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(51090);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(140617);
    super.onPause();
    ab.i(this.TAG, "onPause");
    AppMethodBeat.o(140617);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(140616);
    super.onResume();
    ab.i(this.TAG, "onResume");
    AppMethodBeat.o(140616);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(140615);
    super.onStart();
    ab.i(this.TAG, "onStart");
    AppMethodBeat.o(140615);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(51091);
    super.onStop();
    ab.i(this.TAG, "onStop");
    AppMethodBeat.o(51091);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI
 * JD-Core Version:    0.7.0.1
 */