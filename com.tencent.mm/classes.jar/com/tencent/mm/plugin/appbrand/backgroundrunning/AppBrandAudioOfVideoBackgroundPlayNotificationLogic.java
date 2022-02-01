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
import com.tencent.mm.plugin.appbrand.jsapi.aa.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.aa.c;
import com.tencent.mm.plugin.appbrand.utils.b;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AppBrandAudioOfVideoBackgroundPlayNotificationLogic
  extends CustomBackgroundRunningNotificationLogic
{
  private static final int iXv;
  private static final int iXw;
  private final Context FZ;
  private final NotificationManager Fw;
  private final AppBrandRuntime iGV;
  private volatile Bitmap iXA;
  private BroadcastReceiver iXB;
  private final com.tencent.mm.plugin.appbrand.jsapi.aa.a iXx;
  private int iXy;
  private volatile String iXz;
  volatile boolean mIsCanceled;
  private volatile boolean mIsPlaying;
  
  static
  {
    AppMethodBeat.i(195654);
    iXv = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 17104901);
    iXw = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 17104902);
    AppMethodBeat.o(195654);
  }
  
  @Keep
  public AppBrandAudioOfVideoBackgroundPlayNotificationLogic(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(195635);
    this.iXy = 292;
    this.mIsCanceled = true;
    this.mIsPlaying = false;
    this.iXz = null;
    this.iXA = null;
    this.iXB = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(195628);
        if ((paramAnonymousIntent == null) || (bt.isNullOrNil(paramAnonymousIntent.getAction())))
        {
          AppMethodBeat.o(195628);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getStringExtra("background_audio_notification_action_key");
        if (bt.isNullOrNil(paramAnonymousContext))
        {
          ad.e("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action is null, err, return");
          AppMethodBeat.o(195628);
          return;
        }
        ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action:%s", new Object[] { paramAnonymousContext });
        if (paramAnonymousContext.equals("background_audio_notification_action_play"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).beW();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
          ad.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify start");
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.aSy(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
          AppMethodBeat.o(195628);
          return;
        }
        if (paramAnonymousContext.equals("background_audio_notification_action_pause"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).beX();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).kyt.bfc();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
          ad.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify pause");
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.aSy(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), false));
          AppMethodBeat.o(195628);
          return;
        }
        if (paramAnonymousContext.equals("background_audio_notification_action_close"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).beY();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
          ad.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, cancel");
          paramAnonymousContext = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this;
          ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "cancelNotify");
          if (!paramAnonymousContext.mIsCanceled) {
            break label303;
          }
          ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "cancelNotify, already cancel");
        }
        for (;;)
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bfa();
          AppMethodBeat.o(195628);
          return;
          label303:
          paramAnonymousContext.mIsCanceled = true;
          com.tencent.e.h.Iye.aN(new AppBrandAudioOfVideoBackgroundPlayNotificationLogic.4(paramAnonymousContext));
        }
      }
    };
    paramString = com.tencent.mm.plugin.appbrand.a.CR(paramString);
    if (paramString == null)
    {
      paramString = new IllegalStateException("find AppBrandRuntime fail");
      AppMethodBeat.o(195635);
      throw paramString;
    }
    this.iGV = paramString;
    paramString = (com.tencent.mm.plugin.appbrand.jsapi.aa.a)this.iGV.as(com.tencent.mm.plugin.appbrand.jsapi.aa.a.class);
    if (paramString == null)
    {
      paramString = new IllegalStateException("find AppBrandRuntimeAudioOfVideoBackgroundPlayManager fail");
      AppMethodBeat.o(195635);
      throw paramString;
    }
    this.iXx = paramString;
    this.iXx.kyv = new a.a()
    {
      public final void aSE()
      {
        AppMethodBeat.i(195629);
        if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.d(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this))
        {
          ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, isCanceled");
          AppMethodBeat.o(195629);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
        ad.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, notify start");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.aSy(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
        AppMethodBeat.o(195629);
      }
      
      public final void aSF()
      {
        AppMethodBeat.i(195630);
        if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.d(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this))
        {
          ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, isCanceled");
          AppMethodBeat.o(195630);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
        ad.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, notify pause");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.aSy(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), false));
        AppMethodBeat.o(195630);
      }
    };
    this.FZ = this.iGV.mContext;
    this.Fw = ((NotificationManager)this.FZ.getSystemService("notification"));
    AppMethodBeat.o(195635);
  }
  
  private static Bitmap K(Bitmap paramBitmap)
  {
    AppMethodBeat.i(195643);
    if (paramBitmap == null)
    {
      ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRoundedCornerBitmap, bitmap is null");
      AppMethodBeat.o(195643);
      return null;
    }
    paramBitmap = f.a(paramBitmap, false, 12.0F, false);
    AppMethodBeat.o(195643);
    return paramBitmap;
  }
  
  private Notification a(Context paramContext, boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(195639);
    paramContext = com.tencent.mm.br.a.bD(paramContext, "reminder_channel_id").as(com.tencent.mm.br.a.cYf()).a(b(paramContext, paramBoolean, paramBitmap)).F(false);
    paramContext.f(2, true);
    paramContext = paramContext.build();
    AppMethodBeat.o(195639);
    return paramContext;
  }
  
  private static void a(View paramView, List<TextView> paramList)
  {
    AppMethodBeat.i(195648);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i), paramList);
        i += 1;
      }
      AppMethodBeat.o(195648);
      return;
    }
    if ((paramView instanceof TextView)) {
      paramList.add((TextView)paramView);
    }
    AppMethodBeat.o(195648);
  }
  
  private Bitmap aSA()
  {
    AppMethodBeat.i(195641);
    String str = this.iXx.beU();
    Object localObject = str;
    if (bt.isNullOrNil(str)) {
      localObject = this.iGV.Eg().iconUrl;
    }
    if (bt.isNullOrNil((String)localObject))
    {
      localObject = K(aSB());
      AppMethodBeat.o(195641);
      return localObject;
    }
    if ((((String)localObject).equals(this.iXz)) && (this.iXA != null))
    {
      ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, use mAlbumBitmap");
      localObject = this.iXA;
      AppMethodBeat.o(195641);
      return localObject;
    }
    ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumUrl: ".concat(String.valueOf(localObject)));
    this.iXz = ((String)localObject);
    b.a(this.iGV.Du(), (String)localObject, null, new b.a()
    {
      public final void Fn(String paramAnonymousString)
      {
        AppMethodBeat.i(195634);
        ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, localPath: ".concat(String.valueOf(paramAnonymousString)));
        paramAnonymousString = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.L(f.aF(paramAnonymousString, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.aSC(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.aSD()));
        if (paramAnonymousString == null)
        {
          ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumBitmap is null");
          AppMethodBeat.o(195634);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, paramAnonymousString);
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, paramAnonymousString);
        AppMethodBeat.o(195634);
      }
    });
    localObject = K(aSB());
    AppMethodBeat.o(195641);
    return localObject;
  }
  
  private Bitmap aSB()
  {
    AppMethodBeat.i(195642);
    Object localObject = (com.tencent.mm.plugin.appbrand.widget.h)this.iGV.ab(com.tencent.mm.plugin.appbrand.widget.h.class);
    if (localObject == null)
    {
      ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, iconProvider is null");
      AppMethodBeat.o(195642);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.widget.h)localObject).bra();
    if (localObject == null)
    {
      ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, albumDrawable is null");
      AppMethodBeat.o(195642);
      return null;
    }
    localObject = f.B((Drawable)localObject);
    AppMethodBeat.o(195642);
    return localObject;
  }
  
  private RemoteViews b(Context paramContext, boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(195640);
    Object localObject2 = this.iXx.beT();
    Object localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2)) {
      localObject1 = this.iGV.Eg().dfM;
    }
    localObject2 = paramBitmap;
    if (paramBitmap == null) {
      localObject2 = aSA();
    }
    paramBitmap = new RemoteViews(paramContext.getPackageName(), 2131495265);
    if (localObject2 != null) {
      paramBitmap.setImageViewBitmap(2131302607, (Bitmap)localObject2);
    }
    boolean bool;
    if (!bt.isNullOrNil((String)localObject1))
    {
      paramBitmap.setViewVisibility(2131302613, 0);
      paramBitmap.setTextViewText(2131302613, (CharSequence)localObject1);
      paramBitmap.setViewVisibility(2131302609, 8);
      bool = qQ(dd(paramContext));
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_pre");
      localObject1 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject1, 134217728);
      localObject2 = fs(bool);
      if (localObject2 != null) {
        break label373;
      }
      ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRemoteViews, preIconBitmap is null");
      label180:
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      if (!paramBoolean) {
        break label394;
      }
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_pause");
      label208:
      localObject1 = PendingIntent.getBroadcast(paramContext, 1, (Intent)localObject1, 134217728);
      paramBitmap.setImageViewResource(2131302611, s(paramBoolean, bool));
      paramBitmap.setOnClickPendingIntent(2131302611, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_next");
      localObject1 = PendingIntent.getBroadcast(paramContext, 2, (Intent)localObject1, 134217728);
      localObject2 = fu(bool);
      if (localObject2 != null) {
        break label409;
      }
      ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRemoteViews, nextIconBitmap is null");
    }
    for (;;)
    {
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_close");
      paramContext = PendingIntent.getBroadcast(paramContext, 3, (Intent)localObject1, 134217728);
      paramBitmap.setImageViewResource(2131302608, fw(bool));
      paramBitmap.setOnClickPendingIntent(2131302608, paramContext);
      AppMethodBeat.o(195640);
      return paramBitmap;
      paramBitmap.setViewVisibility(2131302613, 8);
      break;
      label373:
      paramBitmap.setImageViewBitmap(2131302612, (Bitmap)localObject2);
      paramBitmap.setOnClickPendingIntent(2131302612, (PendingIntent)localObject1);
      break label180;
      label394:
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_play");
      break label208;
      label409:
      paramBitmap.setImageViewBitmap(2131302610, (Bitmap)localObject2);
      paramBitmap.setOnClickPendingIntent(2131302610, (PendingIntent)localObject1);
    }
  }
  
  private static int dd(Context paramContext)
  {
    AppMethodBeat.i(195646);
    Object localObject = com.tencent.mm.br.a.bD(paramContext, "reminder_channel_id").build().contentView;
    if (localObject == null)
    {
      AppMethodBeat.o(195646);
      return -16777216;
    }
    int i = ((RemoteViews)localObject).getLayoutId();
    paramContext = (ViewGroup)LayoutInflater.from(paramContext).inflate(i, null);
    localObject = (TextView)paramContext.findViewById(16908310);
    if (localObject != null)
    {
      i = ((TextView)localObject).getCurrentTextColor();
      AppMethodBeat.o(195646);
      return i;
    }
    i = g(paramContext);
    AppMethodBeat.o(195646);
    return i;
  }
  
  private static Bitmap fs(boolean paramBoolean)
  {
    AppMethodBeat.i(195644);
    Bitmap localBitmap = f.Wf(ft(paramBoolean));
    if (localBitmap == null)
    {
      ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getPreIconBitmap, bitmap is null");
      AppMethodBeat.o(195644);
      return null;
    }
    localBitmap = f.b(localBitmap, 0.3F);
    AppMethodBeat.o(195644);
    return localBitmap;
  }
  
  private static int ft(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233852;
    }
    return 2131233854;
  }
  
  private static Bitmap fu(boolean paramBoolean)
  {
    AppMethodBeat.i(195645);
    Bitmap localBitmap = f.Wf(fv(paramBoolean));
    if (localBitmap == null)
    {
      ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getNextIconBitmap, bitmap is null");
      AppMethodBeat.o(195645);
      return null;
    }
    localBitmap = f.b(localBitmap, 0.3F);
    AppMethodBeat.o(195645);
    return localBitmap;
  }
  
  private static int fv(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233841;
    }
    return 2131233843;
  }
  
  private static int fw(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233838;
    }
    return 2131233839;
  }
  
  private static int g(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(195647);
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
        AppMethodBeat.o(195647);
        return i;
      }
      AppMethodBeat.o(195647);
      return -16777216;
    }
  }
  
  private static boolean qQ(int paramInt)
  {
    AppMethodBeat.i(195649);
    int j = paramInt | 0xFF000000;
    paramInt = Color.red(-16777216) - Color.red(j);
    int i = Color.green(-16777216) - Color.green(j);
    j = Color.blue(-16777216) - Color.blue(j);
    if (Math.sqrt(j * j + (paramInt * paramInt + i * i)) < 180.0D)
    {
      AppMethodBeat.o(195649);
      return true;
    }
    AppMethodBeat.o(195649);
    return false;
  }
  
  private static int s(boolean paramBoolean1, boolean paramBoolean2)
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
  
  public final Notification aSx()
  {
    AppMethodBeat.i(195636);
    Notification localNotification = a(this.FZ, this.mIsPlaying, null);
    AppMethodBeat.o(195636);
    return localNotification;
  }
  
  public final int aSy()
  {
    AppMethodBeat.i(195637);
    if (292 == this.iXy) {
      this.iXy = (aj.getProcessName().hashCode() + 292);
    }
    int i = this.iXy;
    AppMethodBeat.o(195637);
    return i;
  }
  
  public final void aSz()
  {
    AppMethodBeat.i(195638);
    ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify");
    if (!this.mIsCanceled)
    {
      ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify, already start");
      AppMethodBeat.o(195638);
      return;
    }
    this.mIsCanceled = false;
    com.tencent.e.h.Iye.aN(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195631);
        IntentFilter localIntentFilter = new IntentFilter("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).registerReceiver(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.e(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), localIntentFilter);
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.aSy(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
        AppMethodBeat.o(195631);
      }
    });
    AppMethodBeat.o(195638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandAudioOfVideoBackgroundPlayNotificationLogic
 * JD-Core Version:    0.7.0.1
 */