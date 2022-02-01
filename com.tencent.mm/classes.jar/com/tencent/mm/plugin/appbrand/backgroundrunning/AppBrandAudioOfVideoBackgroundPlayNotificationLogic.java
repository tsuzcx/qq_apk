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
import android.support.annotation.Keep;
import android.support.v4.app.s.c;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.ag.a.a;
import com.tencent.mm.plugin.appbrand.utils.c.a;
import com.tencent.mm.plugin.appbrand.widget.g;
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
  private static final int kXV;
  private static final int kXW;
  private final NotificationManager Iw;
  private volatile boolean gNC;
  private final AppBrandRuntime kEc;
  private final com.tencent.mm.plugin.appbrand.jsapi.ag.a kXX;
  private int kXY;
  private volatile String kXZ;
  private volatile Bitmap kYa;
  private BroadcastReceiver kYb;
  private final Context mAppContext;
  volatile boolean mIsCanceled;
  
  static
  {
    AppMethodBeat.i(226425);
    kXV = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 17104901);
    kXW = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 17104902);
    AppMethodBeat.o(226425);
  }
  
  @Keep
  public AppBrandAudioOfVideoBackgroundPlayNotificationLogic(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(226406);
    this.kXY = 292;
    this.mIsCanceled = true;
    this.gNC = false;
    this.kXZ = null;
    this.kYa = null;
    this.kYb = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(226398);
        if ((paramAnonymousIntent == null) || (Util.isNullOrNil(paramAnonymousIntent.getAction())))
        {
          AppMethodBeat.o(226398);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getStringExtra("background_audio_notification_action_key");
        if (Util.isNullOrNil(paramAnonymousContext))
        {
          Log.e("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action is null, err, return");
          AppMethodBeat.o(226398);
          return;
        }
        Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action:%s", new Object[] { paramAnonymousContext });
        if (paramAnonymousContext.equals("background_audio_notification_action_play"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bLT();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
          Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify start");
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.getNotificationId(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
          AppMethodBeat.o(226398);
          return;
        }
        if (paramAnonymousContext.equals("background_audio_notification_action_pause"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bLU();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).mIF.bLZ();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
          Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify pause");
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.getNotificationId(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), false));
          AppMethodBeat.o(226398);
          return;
        }
        if (paramAnonymousContext.equals("background_audio_notification_action_close"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bLV();
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
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bLX();
          AppMethodBeat.o(226398);
          return;
          label303:
          paramAnonymousContext.mIsCanceled = true;
          h.RTc.aV(new AppBrandAudioOfVideoBackgroundPlayNotificationLogic.5(paramAnonymousContext));
        }
      }
    };
    paramString = com.tencent.mm.plugin.appbrand.a.TQ(paramString);
    if (paramString == null)
    {
      paramString = new IllegalStateException("find AppBrandRuntime fail");
      AppMethodBeat.o(226406);
      throw paramString;
    }
    this.kEc = paramString;
    paramString = (com.tencent.mm.plugin.appbrand.jsapi.ag.a)this.kEc.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.a.class);
    if (paramString == null)
    {
      paramString = new IllegalStateException("find AppBrandRuntimeAudioOfVideoBackgroundPlayManager fail");
      AppMethodBeat.o(226406);
      throw paramString;
    }
    this.kXX = paramString;
    this.kXX.mIH = new a.a()
    {
      public final void byV()
      {
        AppMethodBeat.i(226399);
        if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.d(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this))
        {
          Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, isCanceled");
          AppMethodBeat.o(226399);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
        Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, notify start");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.getNotificationId(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
        AppMethodBeat.o(226399);
      }
      
      public final void byW()
      {
        AppMethodBeat.i(226400);
        if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.d(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this))
        {
          Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, isCanceled");
          AppMethodBeat.o(226400);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
        Log.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, notify pause");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.getNotificationId(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), false));
        AppMethodBeat.o(226400);
      }
    };
    this.mAppContext = this.kEc.mContext;
    this.Iw = ((NotificationManager)this.mAppContext.getSystemService("notification"));
    AppMethodBeat.o(226406);
  }
  
  private static Bitmap O(Bitmap paramBitmap)
  {
    AppMethodBeat.i(226414);
    if (paramBitmap == null)
    {
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRoundedCornerBitmap, bitmap is null");
      AppMethodBeat.o(226414);
      return null;
    }
    paramBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, 12.0F, false);
    AppMethodBeat.o(226414);
    return paramBitmap;
  }
  
  private Notification a(Context paramContext, boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(226410);
    paramContext = com.tencent.mm.bq.a.cd(paramContext, "reminder_channel_id").as(com.tencent.mm.bq.a.ezb()).a(b(paramContext, paramBoolean, paramBitmap)).E(false);
    paramContext.g(2, true);
    paramContext = paramContext.build();
    AppMethodBeat.o(226410);
    return paramContext;
  }
  
  private static void a(View paramView, List<TextView> paramList)
  {
    AppMethodBeat.i(226419);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i), paramList);
        i += 1;
      }
      AppMethodBeat.o(226419);
      return;
    }
    if ((paramView instanceof TextView)) {
      paramList.add((TextView)paramView);
    }
    AppMethodBeat.o(226419);
  }
  
  private RemoteViews b(Context paramContext, boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(226411);
    Object localObject2 = this.kXX.bLQ();
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2)) {
      localObject1 = this.kEc.OU().brandName;
    }
    localObject2 = paramBitmap;
    if (paramBitmap == null) {
      localObject2 = byR();
    }
    paramBitmap = new RemoteViews(paramContext.getPackageName(), 2131496114);
    if (localObject2 != null) {
      paramBitmap.setImageViewBitmap(2131305102, (Bitmap)localObject2);
    }
    boolean bool;
    if (!Util.isNullOrNil((String)localObject1))
    {
      paramBitmap.setViewVisibility(2131305108, 0);
      paramBitmap.setTextViewText(2131305108, (CharSequence)localObject1);
      paramBitmap.setViewVisibility(2131305104, 8);
      bool = wc(dH(paramContext));
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_pre");
      localObject1 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject1, 134217728);
      localObject2 = gO(bool);
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
      paramBitmap.setImageViewResource(2131305106, t(paramBoolean, bool));
      paramBitmap.setOnClickPendingIntent(2131305106, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_next");
      localObject1 = PendingIntent.getBroadcast(paramContext, 2, (Intent)localObject1, 134217728);
      localObject2 = gQ(bool);
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
      paramBitmap.setImageViewResource(2131305103, gS(bool));
      paramBitmap.setOnClickPendingIntent(2131305103, paramContext);
      AppMethodBeat.o(226411);
      return paramBitmap;
      paramBitmap.setViewVisibility(2131305108, 8);
      break;
      label371:
      paramBitmap.setImageViewBitmap(2131305107, (Bitmap)localObject2);
      paramBitmap.setOnClickPendingIntent(2131305107, (PendingIntent)localObject1);
      break label179;
      label392:
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_play");
      break label207;
      label407:
      paramBitmap.setImageViewBitmap(2131305105, (Bitmap)localObject2);
      paramBitmap.setOnClickPendingIntent(2131305105, (PendingIntent)localObject1);
    }
  }
  
  private Bitmap byR()
  {
    AppMethodBeat.i(226412);
    String str = this.kXX.bLR();
    Object localObject = str;
    if (Util.isNullOrNil(str)) {
      localObject = this.kEc.OU().iconUrl;
    }
    if (Util.isNullOrNil((String)localObject))
    {
      localObject = O(byS());
      AppMethodBeat.o(226412);
      return localObject;
    }
    if ((((String)localObject).equals(this.kXZ)) && (this.kYa != null))
    {
      Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, use mAlbumBitmap");
      localObject = this.kYa;
      AppMethodBeat.o(226412);
      return localObject;
    }
    Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumUrl: ".concat(String.valueOf(localObject)));
    this.kXZ = ((String)localObject);
    com.tencent.mm.plugin.appbrand.utils.c.a(this.kEc.NY(), (String)localObject, null, new c.a()
    {
      public final void Wz(String paramAnonymousString)
      {
        AppMethodBeat.i(226405);
        Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, localPath: ".concat(String.valueOf(paramAnonymousString)));
        paramAnonymousString = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.P(BitmapUtil.getBitmapNative(paramAnonymousString, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.byT(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.byU()));
        if (paramAnonymousString == null)
        {
          Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumBitmap is null");
          AppMethodBeat.o(226405);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, paramAnonymousString);
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, paramAnonymousString);
        AppMethodBeat.o(226405);
      }
    });
    localObject = O(byS());
    AppMethodBeat.o(226412);
    return localObject;
  }
  
  private Bitmap byS()
  {
    AppMethodBeat.i(226413);
    Object localObject = (g)this.kEc.af(g.class);
    if (localObject == null)
    {
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, iconProvider is null");
      AppMethodBeat.o(226413);
      return null;
    }
    localObject = ((g)localObject).cab();
    if (localObject == null)
    {
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, albumDrawable is null");
      AppMethodBeat.o(226413);
      return null;
    }
    localObject = BitmapUtil.transformDrawableToBitmap((Drawable)localObject);
    AppMethodBeat.o(226413);
    return localObject;
  }
  
  private static int dH(Context paramContext)
  {
    AppMethodBeat.i(226417);
    Object localObject = com.tencent.mm.bq.a.cd(paramContext, "reminder_channel_id").build().contentView;
    if (localObject == null)
    {
      AppMethodBeat.o(226417);
      return -16777216;
    }
    int i = ((RemoteViews)localObject).getLayoutId();
    paramContext = (ViewGroup)LayoutInflater.from(paramContext).inflate(i, null);
    localObject = (TextView)paramContext.findViewById(16908310);
    if (localObject != null)
    {
      i = ((TextView)localObject).getCurrentTextColor();
      AppMethodBeat.o(226417);
      return i;
    }
    i = h(paramContext);
    AppMethodBeat.o(226417);
    return i;
  }
  
  private static Bitmap gO(boolean paramBoolean)
  {
    AppMethodBeat.i(226415);
    Bitmap localBitmap = BitmapUtil.getBitmapNative(gP(paramBoolean));
    if (localBitmap == null)
    {
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getPreIconBitmap, bitmap is null");
      AppMethodBeat.o(226415);
      return null;
    }
    localBitmap = BitmapUtil.setAlpha(localBitmap, 0.3F);
    AppMethodBeat.o(226415);
    return localBitmap;
  }
  
  private static int gP(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131234676;
    }
    return 2131234678;
  }
  
  private static Bitmap gQ(boolean paramBoolean)
  {
    AppMethodBeat.i(226416);
    Bitmap localBitmap = BitmapUtil.getBitmapNative(gR(paramBoolean));
    if (localBitmap == null)
    {
      Log.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getNextIconBitmap, bitmap is null");
      AppMethodBeat.o(226416);
      return null;
    }
    localBitmap = BitmapUtil.setAlpha(localBitmap, 0.3F);
    AppMethodBeat.o(226416);
    return localBitmap;
  }
  
  private static int gR(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131234665;
    }
    return 2131234667;
  }
  
  private static int gS(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131234662;
    }
    return 2131234663;
  }
  
  private static int h(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(226418);
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
        AppMethodBeat.o(226418);
        return i;
      }
      AppMethodBeat.o(226418);
      return -16777216;
    }
  }
  
  private static int t(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return 2131234669;
      }
      return 2131234671;
    }
    if (paramBoolean2) {
      return 2131234673;
    }
    return 2131234674;
  }
  
  private static boolean wc(int paramInt)
  {
    AppMethodBeat.i(226420);
    int j = paramInt | 0xFF000000;
    paramInt = Color.red(-16777216) - Color.red(j);
    int i = Color.green(-16777216) - Color.green(j);
    j = Color.blue(-16777216) - Color.blue(j);
    if (Math.sqrt(j * j + (paramInt * paramInt + i * i)) < 180.0D)
    {
      AppMethodBeat.o(226420);
      return true;
    }
    AppMethodBeat.o(226420);
    return false;
  }
  
  public final Notification byP()
  {
    AppMethodBeat.i(226407);
    Notification localNotification = a(this.mAppContext, this.gNC, null);
    AppMethodBeat.o(226407);
    return localNotification;
  }
  
  public final void byQ()
  {
    AppMethodBeat.i(226409);
    Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify");
    if (!this.mIsCanceled)
    {
      Log.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify, already start");
      h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(226401);
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.getNotificationId(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
          AppMethodBeat.o(226401);
        }
      });
      AppMethodBeat.o(226409);
      return;
    }
    this.mIsCanceled = false;
    h.RTc.aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226402);
        IntentFilter localIntentFilter = new IntentFilter("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).registerReceiver(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.e(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), localIntentFilter);
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.getNotificationId(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
        AppMethodBeat.o(226402);
      }
    });
    AppMethodBeat.o(226409);
  }
  
  public final int getNotificationId()
  {
    AppMethodBeat.i(226408);
    if (292 == this.kXY) {
      this.kXY = (MMApplicationContext.getProcessName().hashCode() + 292);
    }
    int i = this.kXY;
    AppMethodBeat.o(226408);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandAudioOfVideoBackgroundPlayNotificationLogic
 * JD-Core Version:    0.7.0.1
 */