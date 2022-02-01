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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.ad.a.a;
import com.tencent.mm.plugin.appbrand.utils.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AppBrandAudioOfVideoBackgroundPlayNotificationLogic
  extends CustomBackgroundRunningNotificationLogic
{
  private static final int jUZ;
  private static final int jVa;
  private final Context IR;
  private final NotificationManager Im;
  private final AppBrandRuntime jDb;
  private final com.tencent.mm.plugin.appbrand.jsapi.ad.a jVb;
  private int jVc;
  private volatile String jVd;
  private volatile Bitmap jVe;
  private BroadcastReceiver jVf;
  volatile boolean mIsCanceled;
  private volatile boolean mIsPlaying;
  
  static
  {
    AppMethodBeat.i(222184);
    jUZ = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 17104901);
    jVa = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 17104902);
    AppMethodBeat.o(222184);
  }
  
  @Keep
  public AppBrandAudioOfVideoBackgroundPlayNotificationLogic(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(222165);
    this.jVc = 292;
    this.mIsCanceled = true;
    this.mIsPlaying = false;
    this.jVd = null;
    this.jVe = null;
    this.jVf = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(222157);
        if ((paramAnonymousIntent == null) || (bu.isNullOrNil(paramAnonymousIntent.getAction())))
        {
          AppMethodBeat.o(222157);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getStringExtra("background_audio_notification_action_key");
        if (bu.isNullOrNil(paramAnonymousContext))
        {
          ae.e("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action is null, err, return");
          AppMethodBeat.o(222157);
          return;
        }
        ae.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action:%s", new Object[] { paramAnonymousContext });
        if (paramAnonymousContext.equals("background_audio_notification_action_play"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bql();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
          ae.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify start");
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bdy(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
          AppMethodBeat.o(222157);
          return;
        }
        if (paramAnonymousContext.equals("background_audio_notification_action_pause"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bqm();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).lBh.bqr();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
          ae.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify pause");
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bdy(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), false));
          AppMethodBeat.o(222157);
          return;
        }
        if (paramAnonymousContext.equals("background_audio_notification_action_close"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bqn();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
          ae.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, cancel");
          paramAnonymousContext = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this;
          ae.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "cancelNotify");
          if (!paramAnonymousContext.mIsCanceled) {
            break label303;
          }
          ae.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "cancelNotify, already cancel");
        }
        for (;;)
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bqp();
          AppMethodBeat.o(222157);
          return;
          label303:
          paramAnonymousContext.mIsCanceled = true;
          com.tencent.e.h.MqF.aM(new AppBrandAudioOfVideoBackgroundPlayNotificationLogic.5(paramAnonymousContext));
        }
      }
    };
    paramString = com.tencent.mm.plugin.appbrand.a.KI(paramString);
    if (paramString == null)
    {
      paramString = new IllegalStateException("find AppBrandRuntime fail");
      AppMethodBeat.o(222165);
      throw paramString;
    }
    this.jDb = paramString;
    paramString = (com.tencent.mm.plugin.appbrand.jsapi.ad.a)this.jDb.as(com.tencent.mm.plugin.appbrand.jsapi.ad.a.class);
    if (paramString == null)
    {
      paramString = new IllegalStateException("find AppBrandRuntimeAudioOfVideoBackgroundPlayManager fail");
      AppMethodBeat.o(222165);
      throw paramString;
    }
    this.jVb = paramString;
    this.jVb.lBj = new a.a()
    {
      public final void bdE()
      {
        AppMethodBeat.i(222158);
        if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.d(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this))
        {
          ae.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, isCanceled");
          AppMethodBeat.o(222158);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
        ae.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, notify start");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bdy(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
        AppMethodBeat.o(222158);
      }
      
      public final void bdF()
      {
        AppMethodBeat.i(222159);
        if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.d(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this))
        {
          ae.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, isCanceled");
          AppMethodBeat.o(222159);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
        ae.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, notify pause");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bdy(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), false));
        AppMethodBeat.o(222159);
      }
    };
    this.IR = this.jDb.mContext;
    this.Im = ((NotificationManager)this.IR.getSystemService("notification"));
    AppMethodBeat.o(222165);
  }
  
  private static Bitmap L(Bitmap paramBitmap)
  {
    AppMethodBeat.i(222173);
    if (paramBitmap == null)
    {
      ae.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRoundedCornerBitmap, bitmap is null");
      AppMethodBeat.o(222173);
      return null;
    }
    paramBitmap = com.tencent.mm.sdk.platformtools.h.a(paramBitmap, false, 12.0F, false);
    AppMethodBeat.o(222173);
    return paramBitmap;
  }
  
  private Notification a(Context paramContext, boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(222169);
    paramContext = com.tencent.mm.bq.a.bJ(paramContext, "reminder_channel_id").as(com.tencent.mm.bq.a.dzu()).a(b(paramContext, paramBoolean, paramBitmap)).F(false);
    paramContext.f(2, true);
    paramContext = paramContext.build();
    AppMethodBeat.o(222169);
    return paramContext;
  }
  
  private static void a(View paramView, List<TextView> paramList)
  {
    AppMethodBeat.i(222178);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i), paramList);
        i += 1;
      }
      AppMethodBeat.o(222178);
      return;
    }
    if ((paramView instanceof TextView)) {
      paramList.add((TextView)paramView);
    }
    AppMethodBeat.o(222178);
  }
  
  private RemoteViews b(Context paramContext, boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(222170);
    Object localObject2 = this.jVb.bqi();
    Object localObject1 = localObject2;
    if (bu.isNullOrNil((String)localObject2)) {
      localObject1 = this.jDb.Fn().dpI;
    }
    localObject2 = paramBitmap;
    if (paramBitmap == null) {
      localObject2 = bdA();
    }
    paramBitmap = new RemoteViews(paramContext.getPackageName(), 2131495265);
    if (localObject2 != null) {
      paramBitmap.setImageViewBitmap(2131302607, (Bitmap)localObject2);
    }
    boolean bool;
    if (!bu.isNullOrNil((String)localObject1))
    {
      paramBitmap.setViewVisibility(2131302613, 0);
      paramBitmap.setTextViewText(2131302613, (CharSequence)localObject1);
      paramBitmap.setViewVisibility(2131302609, 8);
      bool = sg(dm(paramContext));
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_pre");
      localObject1 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject1, 134217728);
      localObject2 = fR(bool);
      if (localObject2 != null) {
        break label371;
      }
      ae.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRemoteViews, preIconBitmap is null");
      label179:
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      if (!paramBoolean) {
        break label392;
      }
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_pause");
      label207:
      localObject1 = PendingIntent.getBroadcast(paramContext, 1, (Intent)localObject1, 134217728);
      paramBitmap.setImageViewResource(2131302611, t(paramBoolean, bool));
      paramBitmap.setOnClickPendingIntent(2131302611, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_next");
      localObject1 = PendingIntent.getBroadcast(paramContext, 2, (Intent)localObject1, 134217728);
      localObject2 = fT(bool);
      if (localObject2 != null) {
        break label407;
      }
      ae.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRemoteViews, nextIconBitmap is null");
    }
    for (;;)
    {
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_close");
      paramContext = PendingIntent.getBroadcast(paramContext, 3, (Intent)localObject1, 134217728);
      paramBitmap.setImageViewResource(2131302608, fV(bool));
      paramBitmap.setOnClickPendingIntent(2131302608, paramContext);
      AppMethodBeat.o(222170);
      return paramBitmap;
      paramBitmap.setViewVisibility(2131302613, 8);
      break;
      label371:
      paramBitmap.setImageViewBitmap(2131302612, (Bitmap)localObject2);
      paramBitmap.setOnClickPendingIntent(2131302612, (PendingIntent)localObject1);
      break label179;
      label392:
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_play");
      break label207;
      label407:
      paramBitmap.setImageViewBitmap(2131302610, (Bitmap)localObject2);
      paramBitmap.setOnClickPendingIntent(2131302610, (PendingIntent)localObject1);
    }
  }
  
  private Bitmap bdA()
  {
    AppMethodBeat.i(222171);
    String str = this.jVb.bqj();
    Object localObject = str;
    if (bu.isNullOrNil(str)) {
      localObject = this.jDb.Fn().iconUrl;
    }
    if (bu.isNullOrNil((String)localObject))
    {
      localObject = L(bdB());
      AppMethodBeat.o(222171);
      return localObject;
    }
    if ((((String)localObject).equals(this.jVd)) && (this.jVe != null))
    {
      ae.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, use mAlbumBitmap");
      localObject = this.jVe;
      AppMethodBeat.o(222171);
      return localObject;
    }
    ae.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumUrl: ".concat(String.valueOf(localObject)));
    this.jVd = ((String)localObject);
    com.tencent.mm.plugin.appbrand.utils.c.a(this.jDb.Ey(), (String)localObject, null, new c.a()
    {
      public final void Nr(String paramAnonymousString)
      {
        AppMethodBeat.i(222164);
        ae.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, localPath: ".concat(String.valueOf(paramAnonymousString)));
        paramAnonymousString = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.M(com.tencent.mm.sdk.platformtools.h.aO(paramAnonymousString, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.bdC(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.bdD()));
        if (paramAnonymousString == null)
        {
          ae.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumBitmap is null");
          AppMethodBeat.o(222164);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, paramAnonymousString);
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, paramAnonymousString);
        AppMethodBeat.o(222164);
      }
    });
    localObject = L(bdB());
    AppMethodBeat.o(222171);
    return localObject;
  }
  
  private Bitmap bdB()
  {
    AppMethodBeat.i(222172);
    Object localObject = (com.tencent.mm.plugin.appbrand.widget.h)this.jDb.ab(com.tencent.mm.plugin.appbrand.widget.h.class);
    if (localObject == null)
    {
      ae.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, iconProvider is null");
      AppMethodBeat.o(222172);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.widget.h)localObject).bDa();
    if (localObject == null)
    {
      ae.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, albumDrawable is null");
      AppMethodBeat.o(222172);
      return null;
    }
    localObject = com.tencent.mm.sdk.platformtools.h.B((Drawable)localObject);
    AppMethodBeat.o(222172);
    return localObject;
  }
  
  private static int dm(Context paramContext)
  {
    AppMethodBeat.i(222176);
    Object localObject = com.tencent.mm.bq.a.bJ(paramContext, "reminder_channel_id").build().contentView;
    if (localObject == null)
    {
      AppMethodBeat.o(222176);
      return -16777216;
    }
    int i = ((RemoteViews)localObject).getLayoutId();
    paramContext = (ViewGroup)LayoutInflater.from(paramContext).inflate(i, null);
    localObject = (TextView)paramContext.findViewById(16908310);
    if (localObject != null)
    {
      i = ((TextView)localObject).getCurrentTextColor();
      AppMethodBeat.o(222176);
      return i;
    }
    i = h(paramContext);
    AppMethodBeat.o(222176);
    return i;
  }
  
  private static Bitmap fR(boolean paramBoolean)
  {
    AppMethodBeat.i(222174);
    Bitmap localBitmap = com.tencent.mm.sdk.platformtools.h.aaZ(fS(paramBoolean));
    if (localBitmap == null)
    {
      ae.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getPreIconBitmap, bitmap is null");
      AppMethodBeat.o(222174);
      return null;
    }
    localBitmap = com.tencent.mm.sdk.platformtools.h.b(localBitmap, 0.3F);
    AppMethodBeat.o(222174);
    return localBitmap;
  }
  
  private static int fS(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233852;
    }
    return 2131233854;
  }
  
  private static Bitmap fT(boolean paramBoolean)
  {
    AppMethodBeat.i(222175);
    Bitmap localBitmap = com.tencent.mm.sdk.platformtools.h.aaZ(fU(paramBoolean));
    if (localBitmap == null)
    {
      ae.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getNextIconBitmap, bitmap is null");
      AppMethodBeat.o(222175);
      return null;
    }
    localBitmap = com.tencent.mm.sdk.platformtools.h.b(localBitmap, 0.3F);
    AppMethodBeat.o(222175);
    return localBitmap;
  }
  
  private static int fU(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233841;
    }
    return 2131233843;
  }
  
  private static int fV(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233838;
    }
    return 2131233839;
  }
  
  private static int h(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(222177);
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
        AppMethodBeat.o(222177);
        return i;
      }
      AppMethodBeat.o(222177);
      return -16777216;
    }
  }
  
  private static boolean sg(int paramInt)
  {
    AppMethodBeat.i(222179);
    int j = paramInt | 0xFF000000;
    paramInt = Color.red(-16777216) - Color.red(j);
    int i = Color.green(-16777216) - Color.green(j);
    j = Color.blue(-16777216) - Color.blue(j);
    if (Math.sqrt(j * j + (paramInt * paramInt + i * i)) < 180.0D)
    {
      AppMethodBeat.o(222179);
      return true;
    }
    AppMethodBeat.o(222179);
    return false;
  }
  
  private static int t(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return 2131233845;
      }
      return 2131233847;
    }
    if (paramBoolean2) {
      return 2131233849;
    }
    return 2131233850;
  }
  
  public final Notification bdx()
  {
    AppMethodBeat.i(222166);
    Notification localNotification = a(this.IR, this.mIsPlaying, null);
    AppMethodBeat.o(222166);
    return localNotification;
  }
  
  public final int bdy()
  {
    AppMethodBeat.i(222167);
    if (292 == this.jVc) {
      this.jVc = (ak.getProcessName().hashCode() + 292);
    }
    int i = this.jVc;
    AppMethodBeat.o(222167);
    return i;
  }
  
  public final void bdz()
  {
    AppMethodBeat.i(222168);
    ae.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify");
    if (!this.mIsCanceled)
    {
      ae.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify, already start");
      com.tencent.e.h.MqF.aM(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222160);
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bdy(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
          AppMethodBeat.o(222160);
        }
      });
      AppMethodBeat.o(222168);
      return;
    }
    this.mIsCanceled = false;
    com.tencent.e.h.MqF.aM(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222161);
        IntentFilter localIntentFilter = new IntentFilter("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).registerReceiver(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.e(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), localIntentFilter);
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bdy(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
        AppMethodBeat.o(222161);
      }
    });
    AppMethodBeat.o(222168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandAudioOfVideoBackgroundPlayNotificationLogic
 * JD-Core Version:    0.7.0.1
 */