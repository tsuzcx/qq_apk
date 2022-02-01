package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.core.app.e.d;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.ai.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ai.c;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.utils.e.a;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AppBrandAudioOfVideoBackgroundPlayNotificationLogic
  extends CustomBackgroundRunningNotificationLogic
{
  private static final int nSh;
  private static final int nSi;
  private final NotificationManager Jv;
  private volatile boolean jxX;
  private final Context mAppContext;
  volatile boolean mIsCanceled;
  private final com.tencent.mm.plugin.appbrand.jsapi.ai.a nSj;
  private int nSk;
  private volatile String nSl;
  private volatile Bitmap nSm;
  private BroadcastReceiver nSn;
  private final AppBrandRuntime nxs;
  
  static
  {
    AppMethodBeat.i(275569);
    nSh = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 17104901);
    nSi = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 17104902);
    AppMethodBeat.o(275569);
  }
  
  @Keep
  public AppBrandAudioOfVideoBackgroundPlayNotificationLogic(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(275547);
    this.nSk = 292;
    this.mIsCanceled = true;
    this.jxX = false;
    this.nSl = null;
    this.nSm = null;
    this.nSn = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(282976);
        if ((paramAnonymousIntent == null) || (Util.isNullOrNil(paramAnonymousIntent.getAction())))
        {
          AppMethodBeat.o(282976);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getStringExtra("background_audio_notification_action_key");
        if (Util.isNullOrNil(paramAnonymousContext))
        {
          Log.e("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action is null, err, return");
          AppMethodBeat.o(282976);
          return;
        }
        Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action:%s", new Object[] { paramAnonymousContext });
        if (paramAnonymousContext.equals("background_audio_notification_action_play"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bYk();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
          Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify start");
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bKe(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
          AppMethodBeat.o(282976);
          return;
        }
        if (paramAnonymousContext.equals("background_audio_notification_action_pause"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bYl();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).pJx.bYq();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
          Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify pause");
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bKe(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), false));
          AppMethodBeat.o(282976);
          return;
        }
        if (paramAnonymousContext.equals("background_audio_notification_action_close"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bYm();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
          Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, cancel");
          paramAnonymousContext = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this;
          Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "cancelNotify");
          if (!paramAnonymousContext.mIsCanceled) {
            break label303;
          }
          Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "cancelNotify, already cancel");
        }
        for (;;)
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bYo();
          AppMethodBeat.o(282976);
          return;
          label303:
          paramAnonymousContext.mIsCanceled = true;
          h.ZvG.bc(new AppBrandAudioOfVideoBackgroundPlayNotificationLogic.5(paramAnonymousContext));
        }
      }
    };
    paramString = d.abA(paramString);
    if (paramString == null)
    {
      paramString = new IllegalStateException("find AppBrandRuntime fail");
      AppMethodBeat.o(275547);
      throw paramString;
    }
    this.nxs = paramString;
    paramString = (com.tencent.mm.plugin.appbrand.jsapi.ai.a)this.nxs.av(com.tencent.mm.plugin.appbrand.jsapi.ai.a.class);
    if (paramString == null)
    {
      paramString = new IllegalStateException("find AppBrandRuntimeAudioOfVideoBackgroundPlayManager fail");
      AppMethodBeat.o(275547);
      throw paramString;
    }
    this.nSj = paramString;
    this.nSj.pJz = new a.a()
    {
      public final void bKk()
      {
        AppMethodBeat.i(273066);
        if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.d(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this))
        {
          Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, isCanceled");
          AppMethodBeat.o(273066);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
        Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, notify start");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bKe(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
        AppMethodBeat.o(273066);
      }
      
      public final void bKl()
      {
        AppMethodBeat.i(273067);
        if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.d(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this))
        {
          Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, isCanceled");
          AppMethodBeat.o(273067);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
        Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, notify pause");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bKe(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), false));
        AppMethodBeat.o(273067);
      }
    };
    this.mAppContext = this.nxs.mContext;
    this.Jv = ((NotificationManager)this.mAppContext.getSystemService("notification"));
    AppMethodBeat.o(275547);
  }
  
  private static Bitmap M(Bitmap paramBitmap)
  {
    AppMethodBeat.i(275557);
    if (paramBitmap == null)
    {
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRoundedCornerBitmap, bitmap is null");
      AppMethodBeat.o(275557);
      return null;
    }
    paramBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, 12.0F, false);
    AppMethodBeat.o(275557);
    return paramBitmap;
  }
  
  private Notification a(Context paramContext, boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(275551);
    paramContext = com.tencent.mm.bx.a.cp(paramContext, "reminder_channel_id").bn(com.tencent.mm.bx.a.fkG()).a(b(paramContext, paramBoolean, paramBitmap)).W(false);
    paramContext.e(2, true);
    paramContext = paramContext.gr();
    AppMethodBeat.o(275551);
    return paramContext;
  }
  
  private static void a(View paramView, List<TextView> paramList)
  {
    AppMethodBeat.i(275563);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i), paramList);
        i += 1;
      }
      AppMethodBeat.o(275563);
      return;
    }
    if ((paramView instanceof TextView)) {
      paramList.add((TextView)paramView);
    }
    AppMethodBeat.o(275563);
  }
  
  private RemoteViews b(Context paramContext, boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(275553);
    Object localObject2 = this.nSj.bYh();
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2)) {
      localObject1 = this.nxs.Sq().fzM;
    }
    localObject2 = paramBitmap;
    if (paramBitmap == null) {
      localObject2 = bKg();
    }
    paramBitmap = new RemoteViews(paramContext.getPackageName(), au.g.remote_music_notification);
    if (localObject2 != null) {
      paramBitmap.setImageViewBitmap(au.f.music_notification_album, (Bitmap)localObject2);
    }
    boolean bool;
    if (!Util.isNullOrNil((String)localObject1))
    {
      paramBitmap.setViewVisibility(au.f.music_notification_title, 0);
      paramBitmap.setTextViewText(au.f.music_notification_title, (CharSequence)localObject1);
      paramBitmap.setViewVisibility(au.f.music_notification_desc, 8);
      bool = zn(dG(paramContext));
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_pre");
      localObject1 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject1, 134217728);
      localObject2 = hz(bool);
      if (localObject2 != null) {
        break label371;
      }
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRemoteViews, preIconBitmap is null");
      label179:
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      if (!paramBoolean) {
        break label392;
      }
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_pause");
      label207:
      localObject1 = PendingIntent.getBroadcast(paramContext, 1, (Intent)localObject1, 134217728);
      paramBitmap.setImageViewResource(a.e.music_notification_pause, w(paramBoolean, bool));
      paramBitmap.setOnClickPendingIntent(a.e.music_notification_pause, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_next");
      localObject1 = PendingIntent.getBroadcast(paramContext, 2, (Intent)localObject1, 134217728);
      localObject2 = hB(bool);
      if (localObject2 != null) {
        break label407;
      }
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRemoteViews, nextIconBitmap is null");
    }
    for (;;)
    {
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_close");
      paramContext = PendingIntent.getBroadcast(paramContext, 3, (Intent)localObject1, 134217728);
      paramBitmap.setImageViewResource(a.e.music_notification_close, hD(bool));
      paramBitmap.setOnClickPendingIntent(a.e.music_notification_close, paramContext);
      AppMethodBeat.o(275553);
      return paramBitmap;
      paramBitmap.setViewVisibility(au.f.music_notification_title, 8);
      break;
      label371:
      paramBitmap.setImageViewBitmap(a.e.music_notification_pre, (Bitmap)localObject2);
      paramBitmap.setOnClickPendingIntent(a.e.music_notification_pre, (PendingIntent)localObject1);
      break label179;
      label392:
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_play");
      break label207;
      label407:
      paramBitmap.setImageViewBitmap(a.e.music_notification_next, (Bitmap)localObject2);
      paramBitmap.setOnClickPendingIntent(a.e.music_notification_next, (PendingIntent)localObject1);
    }
  }
  
  private Bitmap bKg()
  {
    AppMethodBeat.i(275555);
    String str = this.nSj.bYi();
    Object localObject = str;
    if (Util.isNullOrNil(str)) {
      localObject = this.nxs.Sq().iconUrl;
    }
    if (Util.isNullOrNil((String)localObject))
    {
      localObject = M(bKh());
      AppMethodBeat.o(275555);
      return localObject;
    }
    if ((((String)localObject).equals(this.nSl)) && (this.nSm != null))
    {
      Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, use mAlbumBitmap");
      localObject = this.nSm;
      AppMethodBeat.o(275555);
      return localObject;
    }
    Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumUrl: ".concat(String.valueOf(localObject)));
    this.nSl = ((String)localObject);
    e.a(this.nxs.QW(), (String)localObject, null, new e.a()
    {
      public final void dR(String paramAnonymousString)
      {
        AppMethodBeat.i(281576);
        Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, localPath: ".concat(String.valueOf(paramAnonymousString)));
        paramAnonymousString = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.N(BitmapUtil.getBitmapNative(paramAnonymousString, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.bKi(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.bKj()));
        if (paramAnonymousString == null)
        {
          Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumBitmap is null");
          AppMethodBeat.o(281576);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, paramAnonymousString);
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, paramAnonymousString);
        AppMethodBeat.o(281576);
      }
    });
    localObject = M(bKh());
    AppMethodBeat.o(275555);
    return localObject;
  }
  
  private Bitmap bKh()
  {
    AppMethodBeat.i(275556);
    Object localObject = (j)this.nxs.ae(j.class);
    if (localObject == null)
    {
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, iconProvider is null");
      AppMethodBeat.o(275556);
      return null;
    }
    localObject = ((j)localObject).cmY();
    if (localObject == null)
    {
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, albumDrawable is null");
      AppMethodBeat.o(275556);
      return null;
    }
    localObject = BitmapUtil.transformDrawableToBitmap((Drawable)localObject);
    AppMethodBeat.o(275556);
    return localObject;
  }
  
  private static int dG(Context paramContext)
  {
    AppMethodBeat.i(275561);
    Object localObject = com.tencent.mm.bx.a.cp(paramContext, "reminder_channel_id").gr().contentView;
    if (localObject == null)
    {
      AppMethodBeat.o(275561);
      return -16777216;
    }
    int i = ((RemoteViews)localObject).getLayoutId();
    paramContext = (ViewGroup)LayoutInflater.from(paramContext).inflate(i, null);
    localObject = (TextView)paramContext.findViewById(16908310);
    if (localObject != null)
    {
      i = ((TextView)localObject).getCurrentTextColor();
      AppMethodBeat.o(275561);
      return i;
    }
    i = i(paramContext);
    AppMethodBeat.o(275561);
    return i;
  }
  
  private static int hA(boolean paramBoolean)
  {
    if (paramBoolean) {
      return a.d.remote_notification_pre_dark;
    }
    return a.d.remote_notification_pre_light;
  }
  
  private static Bitmap hB(boolean paramBoolean)
  {
    AppMethodBeat.i(275559);
    Bitmap localBitmap = BitmapUtil.getBitmapNative(hC(paramBoolean));
    if (localBitmap == null)
    {
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getNextIconBitmap, bitmap is null");
      AppMethodBeat.o(275559);
      return null;
    }
    localBitmap = BitmapUtil.setAlpha(localBitmap, 0.3F);
    AppMethodBeat.o(275559);
    return localBitmap;
  }
  
  private static int hC(boolean paramBoolean)
  {
    if (paramBoolean) {
      return a.d.remote_notification_next_dark;
    }
    return a.d.remote_notification_next_light;
  }
  
  private static int hD(boolean paramBoolean)
  {
    if (paramBoolean) {
      return a.d.remote_notification_close_dark;
    }
    return a.d.remote_notification_close_light;
  }
  
  private static Bitmap hz(boolean paramBoolean)
  {
    AppMethodBeat.i(275558);
    Bitmap localBitmap = BitmapUtil.getBitmapNative(hA(paramBoolean));
    if (localBitmap == null)
    {
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getPreIconBitmap, bitmap is null");
      AppMethodBeat.o(275558);
      return null;
    }
    localBitmap = BitmapUtil.setAlpha(localBitmap, 0.3F);
    AppMethodBeat.o(275558);
    return localBitmap;
  }
  
  private static int i(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(275562);
    Object localObject = new ArrayList();
    a(paramViewGroup, (List)localObject);
    paramViewGroup = null;
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      localObject = (TextView)localIterator.next();
      if (((TextView)localObject).getTextSize() <= -1.0F) {
        break label90;
      }
      paramViewGroup = (ViewGroup)localObject;
    }
    label90:
    for (;;)
    {
      break;
      if (paramViewGroup != null)
      {
        int i = paramViewGroup.getCurrentTextColor();
        AppMethodBeat.o(275562);
        return i;
      }
      AppMethodBeat.o(275562);
      return -16777216;
    }
  }
  
  private static int w(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return a.d.remote_notification_pause_dark;
      }
      return a.d.remote_notification_pause_light;
    }
    if (paramBoolean2) {
      return a.d.remote_notification_play_dark;
    }
    return a.d.remote_notification_play_light;
  }
  
  private static boolean zn(int paramInt)
  {
    AppMethodBeat.i(275564);
    int j = paramInt | 0xFF000000;
    paramInt = Color.red(-16777216) - Color.red(j);
    int i = Color.green(-16777216) - Color.green(j);
    j = Color.blue(-16777216) - Color.blue(j);
    if (Math.sqrt(j * j + (paramInt * paramInt + i * i)) < 180.0D)
    {
      AppMethodBeat.o(275564);
      return true;
    }
    AppMethodBeat.o(275564);
    return false;
  }
  
  public final Notification bKd()
  {
    AppMethodBeat.i(275548);
    Notification localNotification = a(this.mAppContext, this.jxX, null);
    AppMethodBeat.o(275548);
    return localNotification;
  }
  
  public final int bKe()
  {
    AppMethodBeat.i(275549);
    if (292 == this.nSk) {
      this.nSk = (MMApplicationContext.getProcessName().hashCode() + 292);
    }
    int i = this.nSk;
    AppMethodBeat.o(275549);
    return i;
  }
  
  public final void bKf()
  {
    AppMethodBeat.i(275550);
    Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify");
    if (!this.mIsCanceled)
    {
      Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify, already start");
      h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256034);
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bKe(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
          AppMethodBeat.o(256034);
        }
      });
      AppMethodBeat.o(275550);
      return;
    }
    this.mIsCanceled = false;
    h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(269195);
        IntentFilter localIntentFilter = new IntentFilter("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).registerReceiver(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.e(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), localIntentFilter);
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bKe(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
        AppMethodBeat.o(269195);
      }
    });
    AppMethodBeat.o(275550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandAudioOfVideoBackgroundPlayNotificationLogic
 * JD-Core Version:    0.7.0.1
 */