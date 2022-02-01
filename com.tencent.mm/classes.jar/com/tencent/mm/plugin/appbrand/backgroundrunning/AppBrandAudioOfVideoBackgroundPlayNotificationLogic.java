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
import com.tencent.mm.plugin.appbrand.jsapi.ac.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c;
import com.tencent.mm.plugin.appbrand.utils.b;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AppBrandAudioOfVideoBackgroundPlayNotificationLogic
  extends CustomBackgroundRunningNotificationLogic
{
  private static final int jRH;
  private static final int jRI;
  private final Context IR;
  private final NotificationManager Im;
  private final com.tencent.mm.plugin.appbrand.jsapi.ac.a jRJ;
  private int jRK;
  private volatile String jRL;
  private volatile Bitmap jRM;
  private BroadcastReceiver jRN;
  private final AppBrandRuntime jzY;
  volatile boolean mIsCanceled;
  private volatile boolean mIsPlaying;
  
  static
  {
    AppMethodBeat.i(188065);
    jRH = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 17104901);
    jRI = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 17104902);
    AppMethodBeat.o(188065);
  }
  
  @Keep
  public AppBrandAudioOfVideoBackgroundPlayNotificationLogic(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(188046);
    this.jRK = 292;
    this.mIsCanceled = true;
    this.mIsPlaying = false;
    this.jRL = null;
    this.jRM = null;
    this.jRN = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(188038);
        if ((paramAnonymousIntent == null) || (bt.isNullOrNil(paramAnonymousIntent.getAction())))
        {
          AppMethodBeat.o(188038);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getStringExtra("background_audio_notification_action_key");
        if (bt.isNullOrNil(paramAnonymousContext))
        {
          ad.e("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action is null, err, return");
          AppMethodBeat.o(188038);
          return;
        }
        ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action:%s", new Object[] { paramAnonymousContext });
        if (paramAnonymousContext.equals("background_audio_notification_action_play"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bpB();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
          ad.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify start");
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bcT(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
          AppMethodBeat.o(188038);
          return;
        }
        if (paramAnonymousContext.equals("background_audio_notification_action_pause"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bpC();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).lwJ.bpH();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
          ad.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify pause");
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bcT(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), false));
          AppMethodBeat.o(188038);
          return;
        }
        if (paramAnonymousContext.equals("background_audio_notification_action_close"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bpD();
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
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).bpF();
          AppMethodBeat.o(188038);
          return;
          label303:
          paramAnonymousContext.mIsCanceled = true;
          com.tencent.e.h.LTJ.aP(new AppBrandAudioOfVideoBackgroundPlayNotificationLogic.5(paramAnonymousContext));
        }
      }
    };
    paramString = com.tencent.mm.plugin.appbrand.a.Kj(paramString);
    if (paramString == null)
    {
      paramString = new IllegalStateException("find AppBrandRuntime fail");
      AppMethodBeat.o(188046);
      throw paramString;
    }
    this.jzY = paramString;
    paramString = (com.tencent.mm.plugin.appbrand.jsapi.ac.a)this.jzY.as(com.tencent.mm.plugin.appbrand.jsapi.ac.a.class);
    if (paramString == null)
    {
      paramString = new IllegalStateException("find AppBrandRuntimeAudioOfVideoBackgroundPlayManager fail");
      AppMethodBeat.o(188046);
      throw paramString;
    }
    this.jRJ = paramString;
    this.jRJ.lwL = new a.a()
    {
      public final void bcZ()
      {
        AppMethodBeat.i(188039);
        if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.d(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this))
        {
          ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, isCanceled");
          AppMethodBeat.o(188039);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
        ad.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, notify start");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bcT(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
        AppMethodBeat.o(188039);
      }
      
      public final void bda()
      {
        AppMethodBeat.i(188040);
        if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.d(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this))
        {
          ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, isCanceled");
          AppMethodBeat.o(188040);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
        ad.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, notify pause");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bcT(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), false));
        AppMethodBeat.o(188040);
      }
    };
    this.IR = this.jzY.mContext;
    this.Im = ((NotificationManager)this.IR.getSystemService("notification"));
    AppMethodBeat.o(188046);
  }
  
  private static Bitmap K(Bitmap paramBitmap)
  {
    AppMethodBeat.i(188054);
    if (paramBitmap == null)
    {
      ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRoundedCornerBitmap, bitmap is null");
      AppMethodBeat.o(188054);
      return null;
    }
    paramBitmap = g.a(paramBitmap, false, 12.0F, false);
    AppMethodBeat.o(188054);
    return paramBitmap;
  }
  
  private Notification a(Context paramContext, boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(188050);
    paramContext = com.tencent.mm.br.a.bI(paramContext, "reminder_channel_id").as(com.tencent.mm.br.a.dwe()).a(b(paramContext, paramBoolean, paramBitmap)).F(false);
    paramContext.f(2, true);
    paramContext = paramContext.build();
    AppMethodBeat.o(188050);
    return paramContext;
  }
  
  private static void a(View paramView, List<TextView> paramList)
  {
    AppMethodBeat.i(188059);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i), paramList);
        i += 1;
      }
      AppMethodBeat.o(188059);
      return;
    }
    if ((paramView instanceof TextView)) {
      paramList.add((TextView)paramView);
    }
    AppMethodBeat.o(188059);
  }
  
  private RemoteViews b(Context paramContext, boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(188051);
    Object localObject2 = this.jRJ.bpy();
    Object localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2)) {
      localObject1 = this.jzY.Fi().doD;
    }
    localObject2 = paramBitmap;
    if (paramBitmap == null) {
      localObject2 = bcV();
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
      bool = sd(dk(paramContext));
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_pre");
      localObject1 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject1, 134217728);
      localObject2 = fS(bool);
      if (localObject2 != null) {
        break label371;
      }
      ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRemoteViews, preIconBitmap is null");
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
      localObject2 = fU(bool);
      if (localObject2 != null) {
        break label407;
      }
      ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRemoteViews, nextIconBitmap is null");
    }
    for (;;)
    {
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_close");
      paramContext = PendingIntent.getBroadcast(paramContext, 3, (Intent)localObject1, 134217728);
      paramBitmap.setImageViewResource(2131302608, fW(bool));
      paramBitmap.setOnClickPendingIntent(2131302608, paramContext);
      AppMethodBeat.o(188051);
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
  
  private Bitmap bcV()
  {
    AppMethodBeat.i(188052);
    String str = this.jRJ.bpz();
    Object localObject = str;
    if (bt.isNullOrNil(str)) {
      localObject = this.jzY.Fi().iconUrl;
    }
    if (bt.isNullOrNil((String)localObject))
    {
      localObject = K(bcW());
      AppMethodBeat.o(188052);
      return localObject;
    }
    if ((((String)localObject).equals(this.jRL)) && (this.jRM != null))
    {
      ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, use mAlbumBitmap");
      localObject = this.jRM;
      AppMethodBeat.o(188052);
      return localObject;
    }
    ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumUrl: ".concat(String.valueOf(localObject)));
    this.jRL = ((String)localObject);
    b.a(this.jzY.Ew(), (String)localObject, null, new b.a()
    {
      public final void MK(String paramAnonymousString)
      {
        AppMethodBeat.i(188045);
        ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, localPath: ".concat(String.valueOf(paramAnonymousString)));
        paramAnonymousString = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.L(g.aM(paramAnonymousString, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.bcX(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.bcY()));
        if (paramAnonymousString == null)
        {
          ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumBitmap is null");
          AppMethodBeat.o(188045);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, paramAnonymousString);
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, paramAnonymousString);
        AppMethodBeat.o(188045);
      }
    });
    localObject = K(bcW());
    AppMethodBeat.o(188052);
    return localObject;
  }
  
  private Bitmap bcW()
  {
    AppMethodBeat.i(188053);
    Object localObject = (com.tencent.mm.plugin.appbrand.widget.h)this.jzY.ab(com.tencent.mm.plugin.appbrand.widget.h.class);
    if (localObject == null)
    {
      ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, iconProvider is null");
      AppMethodBeat.o(188053);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.widget.h)localObject).bCg();
    if (localObject == null)
    {
      ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, albumDrawable is null");
      AppMethodBeat.o(188053);
      return null;
    }
    localObject = g.A((Drawable)localObject);
    AppMethodBeat.o(188053);
    return localObject;
  }
  
  private static int dk(Context paramContext)
  {
    AppMethodBeat.i(188057);
    Object localObject = com.tencent.mm.br.a.bI(paramContext, "reminder_channel_id").build().contentView;
    if (localObject == null)
    {
      AppMethodBeat.o(188057);
      return -16777216;
    }
    int i = ((RemoteViews)localObject).getLayoutId();
    paramContext = (ViewGroup)LayoutInflater.from(paramContext).inflate(i, null);
    localObject = (TextView)paramContext.findViewById(16908310);
    if (localObject != null)
    {
      i = ((TextView)localObject).getCurrentTextColor();
      AppMethodBeat.o(188057);
      return i;
    }
    i = h(paramContext);
    AppMethodBeat.o(188057);
    return i;
  }
  
  private static Bitmap fS(boolean paramBoolean)
  {
    AppMethodBeat.i(188055);
    Bitmap localBitmap = g.aat(fT(paramBoolean));
    if (localBitmap == null)
    {
      ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getPreIconBitmap, bitmap is null");
      AppMethodBeat.o(188055);
      return null;
    }
    localBitmap = g.b(localBitmap, 0.3F);
    AppMethodBeat.o(188055);
    return localBitmap;
  }
  
  private static int fT(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233852;
    }
    return 2131233854;
  }
  
  private static Bitmap fU(boolean paramBoolean)
  {
    AppMethodBeat.i(188056);
    Bitmap localBitmap = g.aat(fV(paramBoolean));
    if (localBitmap == null)
    {
      ad.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getNextIconBitmap, bitmap is null");
      AppMethodBeat.o(188056);
      return null;
    }
    localBitmap = g.b(localBitmap, 0.3F);
    AppMethodBeat.o(188056);
    return localBitmap;
  }
  
  private static int fV(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233841;
    }
    return 2131233843;
  }
  
  private static int fW(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233838;
    }
    return 2131233839;
  }
  
  private static int h(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(188058);
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
        AppMethodBeat.o(188058);
        return i;
      }
      AppMethodBeat.o(188058);
      return -16777216;
    }
  }
  
  private static boolean sd(int paramInt)
  {
    AppMethodBeat.i(188060);
    int j = paramInt | 0xFF000000;
    paramInt = Color.red(-16777216) - Color.red(j);
    int i = Color.green(-16777216) - Color.green(j);
    j = Color.blue(-16777216) - Color.blue(j);
    if (Math.sqrt(j * j + (paramInt * paramInt + i * i)) < 180.0D)
    {
      AppMethodBeat.o(188060);
      return true;
    }
    AppMethodBeat.o(188060);
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
  
  public final Notification bcS()
  {
    AppMethodBeat.i(188047);
    Notification localNotification = a(this.IR, this.mIsPlaying, null);
    AppMethodBeat.o(188047);
    return localNotification;
  }
  
  public final int bcT()
  {
    AppMethodBeat.i(188048);
    if (292 == this.jRK) {
      this.jRK = (aj.getProcessName().hashCode() + 292);
    }
    int i = this.jRK;
    AppMethodBeat.o(188048);
    return i;
  }
  
  public final void bcU()
  {
    AppMethodBeat.i(188049);
    ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify");
    if (!this.mIsCanceled)
    {
      ad.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify, already start");
      com.tencent.e.h.LTJ.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188041);
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bcT(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
          AppMethodBeat.o(188041);
        }
      });
      AppMethodBeat.o(188049);
      return;
    }
    this.mIsCanceled = false;
    com.tencent.e.h.LTJ.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188042);
        IntentFilter localIntentFilter = new IntentFilter("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).registerReceiver(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.e(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), localIntentFilter);
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.bcT(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
        AppMethodBeat.o(188042);
      }
    });
    AppMethodBeat.o(188049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandAudioOfVideoBackgroundPlayNotificationLogic
 * JD-Core Version:    0.7.0.1
 */