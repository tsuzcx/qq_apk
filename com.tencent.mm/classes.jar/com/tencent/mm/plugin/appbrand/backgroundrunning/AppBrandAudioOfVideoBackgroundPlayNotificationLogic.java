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
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.al.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.al.c;
import com.tencent.mm.plugin.appbrand.utils.g;
import com.tencent.mm.plugin.appbrand.utils.g.a;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AppBrandAudioOfVideoBackgroundPlayNotificationLogic
  extends CustomBackgroundRunningNotificationLogic
{
  private static final int qRR;
  private static final int qRS;
  private final NotificationManager bpy;
  private final Context mAppContext;
  volatile boolean mIsCanceled;
  private final com.tencent.mm.plugin.appbrand.jsapi.al.a qRT;
  private int qRU;
  private volatile boolean qRV;
  private volatile String qRW;
  private volatile Bitmap qRX;
  private BroadcastReceiver qRY;
  private final AppBrandRuntime qwG;
  
  static
  {
    AppMethodBeat.i(318379);
    qRR = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 17104901);
    qRS = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 17104902);
    AppMethodBeat.o(318379);
  }
  
  public AppBrandAudioOfVideoBackgroundPlayNotificationLogic(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(318139);
    this.qRU = 292;
    this.mIsCanceled = true;
    this.qRV = false;
    this.qRW = null;
    this.qRX = null;
    this.qRY = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(318136);
        if ((paramAnonymousIntent == null) || (Util.isNullOrNil(paramAnonymousIntent.getAction())))
        {
          AppMethodBeat.o(318136);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getStringExtra("background_audio_notification_action_key");
        if (Util.isNullOrNil(paramAnonymousContext))
        {
          Log.e("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action is null, err, return");
          AppMethodBeat.o(318136);
          return;
        }
        Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action:%s", new Object[] { paramAnonymousContext });
        if (paramAnonymousContext.equals("background_audio_notification_action_play"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).cyA();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
          Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify start");
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.cjF(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
          AppMethodBeat.o(318136);
          return;
        }
        if (paramAnonymousContext.equals("background_audio_notification_action_pause"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).cyB();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).sOp.cyG();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
          Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify pause");
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.cjF(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), false));
          AppMethodBeat.o(318136);
          return;
        }
        if (paramAnonymousContext.equals("background_audio_notification_action_close"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).cyC();
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
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).cyE();
          AppMethodBeat.o(318136);
          return;
          label303:
          paramAnonymousContext.mIsCanceled = true;
          h.ahAA.bk(new AppBrandAudioOfVideoBackgroundPlayNotificationLogic.5(paramAnonymousContext));
        }
      }
    };
    paramString = d.Uc(paramString);
    if (paramString == null)
    {
      paramString = new IllegalStateException("find AppBrandRuntime fail");
      AppMethodBeat.o(318139);
      throw paramString;
    }
    this.qwG = paramString;
    paramString = (com.tencent.mm.plugin.appbrand.jsapi.al.a)this.qwG.aO(com.tencent.mm.plugin.appbrand.jsapi.al.a.class);
    if (paramString == null)
    {
      paramString = new IllegalStateException("find AppBrandRuntimeAudioOfVideoBackgroundPlayManager fail");
      AppMethodBeat.o(318139);
      throw paramString;
    }
    this.qRT = paramString;
    this.qRT.sOr = new a.a()
    {
      public final void cjK()
      {
        AppMethodBeat.i(318127);
        if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.d(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this))
        {
          Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, isCanceled");
          AppMethodBeat.o(318127);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
        Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, notify start");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.cjF(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
        AppMethodBeat.o(318127);
      }
      
      public final void cjL()
      {
        AppMethodBeat.i(318131);
        if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.d(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this))
        {
          Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, isCanceled");
          AppMethodBeat.o(318131);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
        Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, notify pause");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.cjF(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), false));
        AppMethodBeat.o(318131);
      }
    };
    this.mAppContext = this.qwG.mContext;
    this.bpy = ((NotificationManager)this.mAppContext.getSystemService("notification"));
    AppMethodBeat.o(318139);
  }
  
  private static int B(boolean paramBoolean1, boolean paramBoolean2)
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
  
  private static Bitmap U(Bitmap paramBitmap)
  {
    AppMethodBeat.i(318185);
    if (paramBitmap == null)
    {
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRoundedCornerBitmap, bitmap is null");
      AppMethodBeat.o(318185);
      return null;
    }
    paramBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, 12.0F, false);
    AppMethodBeat.o(318185);
    return paramBitmap;
  }
  
  private Notification a(Context paramContext, boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(318150);
    paramContext = com.tencent.mm.bq.a.cA(paramContext, "reminder_channel_id").eb(com.tencent.mm.bq.a.guX()).a(b(paramContext, paramBoolean, paramBitmap)).aC(false);
    paramContext.q(2, true);
    paramContext = paramContext.DA();
    AppMethodBeat.o(318150);
    return paramContext;
  }
  
  private static void a(View paramView, List<TextView> paramList)
  {
    AppMethodBeat.i(318290);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i), paramList);
        i += 1;
      }
      AppMethodBeat.o(318290);
      return;
    }
    if ((paramView instanceof TextView)) {
      paramList.add((TextView)paramView);
    }
    AppMethodBeat.o(318290);
  }
  
  private RemoteViews b(Context paramContext, boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(318160);
    Object localObject2 = this.qRT.cyx();
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2)) {
      localObject1 = this.qwG.asH().hEy;
    }
    localObject2 = paramBitmap;
    if (paramBitmap == null) {
      localObject2 = cjH();
    }
    paramBitmap = new RemoteViews(paramContext.getPackageName(), ba.g.remote_music_notification);
    if (localObject2 != null) {
      paramBitmap.setImageViewBitmap(ba.f.music_notification_album, (Bitmap)localObject2);
    }
    boolean bool;
    if (!Util.isNullOrNil((String)localObject1))
    {
      paramBitmap.setViewVisibility(ba.f.music_notification_title, 0);
      paramBitmap.setTextViewText(ba.f.music_notification_title, (CharSequence)localObject1);
      paramBitmap.setViewVisibility(ba.f.music_notification_desc, 8);
      bool = zA(ey(paramContext));
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_pre");
      localObject1 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject1, 134217728);
      localObject2 = ip(bool);
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
      paramBitmap.setImageViewResource(a.e.music_notification_pause, B(paramBoolean, bool));
      paramBitmap.setOnClickPendingIntent(a.e.music_notification_pause, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_next");
      localObject1 = PendingIntent.getBroadcast(paramContext, 2, (Intent)localObject1, 134217728);
      localObject2 = ir(bool);
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
      paramBitmap.setImageViewResource(a.e.music_notification_close, it(bool));
      paramBitmap.setOnClickPendingIntent(a.e.music_notification_close, paramContext);
      AppMethodBeat.o(318160);
      return paramBitmap;
      paramBitmap.setViewVisibility(ba.f.music_notification_title, 8);
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
  
  private Bitmap cjH()
  {
    AppMethodBeat.i(318169);
    String str = this.qRT.cyy();
    Object localObject = str;
    if (Util.isNullOrNil(str)) {
      localObject = this.qwG.asH().iconUrl;
    }
    if (Util.isNullOrNil((String)localObject))
    {
      localObject = U(cjI());
      AppMethodBeat.o(318169);
      return localObject;
    }
    if ((((String)localObject).equals(this.qRW)) && (this.qRX != null))
    {
      Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, use mAlbumBitmap");
      localObject = this.qRX;
      AppMethodBeat.o(318169);
      return localObject;
    }
    Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumUrl: ".concat(String.valueOf(localObject)));
    this.qRW = ((String)localObject);
    g.a(this.qwG.ari(), (String)localObject, null, new g.a()
    {
      public final void onLoad(String paramAnonymousString)
      {
        AppMethodBeat.i(318133);
        Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, localPath: ".concat(String.valueOf(paramAnonymousString)));
        paramAnonymousString = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.V(BitmapUtil.getBitmapNative(paramAnonymousString, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.alu(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.cjJ()));
        if (paramAnonymousString == null)
        {
          Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumBitmap is null");
          AppMethodBeat.o(318133);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, paramAnonymousString);
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, paramAnonymousString);
        AppMethodBeat.o(318133);
      }
    });
    localObject = U(cjI());
    AppMethodBeat.o(318169);
    return localObject;
  }
  
  private Bitmap cjI()
  {
    AppMethodBeat.i(318177);
    Object localObject = (m)this.qwG.ax(m.class);
    if (localObject == null)
    {
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, iconProvider is null");
      AppMethodBeat.o(318177);
      return null;
    }
    localObject = ((m)localObject).cOQ();
    if (localObject == null)
    {
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, albumDrawable is null");
      AppMethodBeat.o(318177);
      return null;
    }
    localObject = BitmapUtil.transformDrawableToBitmap((Drawable)localObject);
    AppMethodBeat.o(318177);
    return localObject;
  }
  
  private static int ey(Context paramContext)
  {
    AppMethodBeat.i(318259);
    Object localObject = com.tencent.mm.bq.a.cA(paramContext, "reminder_channel_id").DA().contentView;
    if (localObject == null)
    {
      AppMethodBeat.o(318259);
      return -16777216;
    }
    int i = ((RemoteViews)localObject).getLayoutId();
    paramContext = (ViewGroup)LayoutInflater.from(paramContext).inflate(i, null);
    localObject = (TextView)paramContext.findViewById(16908310);
    if (localObject != null)
    {
      i = ((TextView)localObject).getCurrentTextColor();
      AppMethodBeat.o(318259);
      return i;
    }
    i = l(paramContext);
    AppMethodBeat.o(318259);
    return i;
  }
  
  private static Bitmap ip(boolean paramBoolean)
  {
    AppMethodBeat.i(318199);
    Bitmap localBitmap = BitmapUtil.getBitmapNative(iq(paramBoolean));
    if (localBitmap == null)
    {
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getPreIconBitmap, bitmap is null");
      AppMethodBeat.o(318199);
      return null;
    }
    localBitmap = BitmapUtil.setAlpha(localBitmap, 0.3F);
    AppMethodBeat.o(318199);
    return localBitmap;
  }
  
  private static int iq(boolean paramBoolean)
  {
    if (paramBoolean) {
      return a.d.remote_notification_pre_dark;
    }
    return a.d.remote_notification_pre_light;
  }
  
  private static Bitmap ir(boolean paramBoolean)
  {
    AppMethodBeat.i(318217);
    Bitmap localBitmap = BitmapUtil.getBitmapNative(is(paramBoolean));
    if (localBitmap == null)
    {
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getNextIconBitmap, bitmap is null");
      AppMethodBeat.o(318217);
      return null;
    }
    localBitmap = BitmapUtil.setAlpha(localBitmap, 0.3F);
    AppMethodBeat.o(318217);
    return localBitmap;
  }
  
  private static int is(boolean paramBoolean)
  {
    if (paramBoolean) {
      return a.d.remote_notification_next_dark;
    }
    return a.d.remote_notification_next_light;
  }
  
  private static int it(boolean paramBoolean)
  {
    if (paramBoolean) {
      return a.d.remote_notification_close_dark;
    }
    return a.d.remote_notification_close_light;
  }
  
  private static int l(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(318273);
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
        AppMethodBeat.o(318273);
        return i;
      }
      AppMethodBeat.o(318273);
      return -16777216;
    }
  }
  
  private static boolean zA(int paramInt)
  {
    AppMethodBeat.i(318308);
    int j = paramInt | 0xFF000000;
    paramInt = Color.red(-16777216) - Color.red(j);
    int i = Color.green(-16777216) - Color.green(j);
    j = Color.blue(-16777216) - Color.blue(j);
    if (Math.sqrt(j * j + (paramInt * paramInt + i * i)) < 180.0D)
    {
      AppMethodBeat.o(318308);
      return true;
    }
    AppMethodBeat.o(318308);
    return false;
  }
  
  public final Notification cjE()
  {
    AppMethodBeat.i(318382);
    Notification localNotification = a(this.mAppContext, this.qRV, null);
    AppMethodBeat.o(318382);
    return localNotification;
  }
  
  public final int cjF()
  {
    AppMethodBeat.i(318384);
    if (292 == this.qRU) {
      this.qRU = (MMApplicationContext.getProcessName().hashCode() + 292);
    }
    int i = this.qRU;
    AppMethodBeat.o(318384);
    return i;
  }
  
  public final void cjG()
  {
    AppMethodBeat.i(318386);
    Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify");
    if (!this.mIsCanceled)
    {
      Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify, already start");
      h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(318128);
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.cjF(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
          AppMethodBeat.o(318128);
        }
      });
      AppMethodBeat.o(318386);
      return;
    }
    this.mIsCanceled = false;
    h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(318135);
        IntentFilter localIntentFilter = new IntentFilter("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).registerReceiver(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.e(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), localIntentFilter);
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.cjF(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
        AppMethodBeat.o(318135);
      }
    });
    AppMethodBeat.o(318386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandAudioOfVideoBackgroundPlayNotificationLogic
 * JD-Core Version:    0.7.0.1
 */