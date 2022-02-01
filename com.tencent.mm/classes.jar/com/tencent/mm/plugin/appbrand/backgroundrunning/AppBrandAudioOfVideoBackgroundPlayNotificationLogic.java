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
import com.tencent.mm.plugin.appbrand.jsapi.z.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.z.c;
import com.tencent.mm.plugin.appbrand.utils.b;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AppBrandAudioOfVideoBackgroundPlayNotificationLogic
  extends CustomBackgroundRunningNotificationLogic
{
  private static final int jxL;
  private static final int jxM;
  private final Context GX;
  private final NotificationManager Gu;
  private final AppBrandRuntime jgY;
  private final com.tencent.mm.plugin.appbrand.jsapi.z.a jxN;
  private int jxO;
  private volatile String jxP;
  private volatile Bitmap jxQ;
  private BroadcastReceiver jxR;
  volatile boolean mIsCanceled;
  private volatile boolean mIsPlaying;
  
  static
  {
    AppMethodBeat.i(186372);
    jxL = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 17104901);
    jxM = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 17104902);
    AppMethodBeat.o(186372);
  }
  
  @Keep
  public AppBrandAudioOfVideoBackgroundPlayNotificationLogic(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(186353);
    this.jxO = 292;
    this.mIsCanceled = true;
    this.mIsPlaying = false;
    this.jxP = null;
    this.jxQ = null;
    this.jxR = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(186345);
        if ((paramAnonymousIntent == null) || (bs.isNullOrNil(paramAnonymousIntent.getAction())))
        {
          AppMethodBeat.o(186345);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getStringExtra("background_audio_notification_action_key");
        if (bs.isNullOrNil(paramAnonymousContext))
        {
          ac.e("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action is null, err, return");
          AppMethodBeat.o(186345);
          return;
        }
        ac.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "action:%s", new Object[] { paramAnonymousContext });
        if (paramAnonymousContext.equals("background_audio_notification_action_play"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).blM();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
          ac.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify start");
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.aZv(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
          AppMethodBeat.o(186345);
          return;
        }
        if (paramAnonymousContext.equals("background_audio_notification_action_pause"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).blU();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).kZQ.bjF();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
          ac.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, notify pause");
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.aZv(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), false));
          AppMethodBeat.o(186345);
          return;
        }
        if (paramAnonymousContext.equals("background_audio_notification_action_close"))
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).blQ();
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
          ac.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onReceive, cancel");
          paramAnonymousContext = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this;
          ac.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "cancelNotify");
          if (!paramAnonymousContext.mIsCanceled) {
            break label303;
          }
          ac.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "cancelNotify, already cancel");
        }
        for (;;)
        {
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).blS();
          AppMethodBeat.o(186345);
          return;
          label303:
          paramAnonymousContext.mIsCanceled = true;
          com.tencent.e.h.JZN.aQ(new AppBrandAudioOfVideoBackgroundPlayNotificationLogic.5(paramAnonymousContext));
        }
      }
    };
    paramString = com.tencent.mm.plugin.appbrand.a.GU(paramString);
    if (paramString == null)
    {
      paramString = new IllegalStateException("find AppBrandRuntime fail");
      AppMethodBeat.o(186353);
      throw paramString;
    }
    this.jgY = paramString;
    paramString = (com.tencent.mm.plugin.appbrand.jsapi.z.a)this.jgY.as(com.tencent.mm.plugin.appbrand.jsapi.z.a.class);
    if (paramString == null)
    {
      paramString = new IllegalStateException("find AppBrandRuntimeAudioOfVideoBackgroundPlayManager fail");
      AppMethodBeat.o(186353);
      throw paramString;
    }
    this.jxN = paramString;
    this.jxN.kZI = new a.a()
    {
      public final void aZB()
      {
        AppMethodBeat.i(186346);
        if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.d(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this))
        {
          ac.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, isCanceled");
          AppMethodBeat.o(186346);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
        ac.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioStart, notify start");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.aZv(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
        AppMethodBeat.o(186346);
      }
      
      public final void aZC()
      {
        AppMethodBeat.i(186347);
        if (AppBrandAudioOfVideoBackgroundPlayNotificationLogic.d(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this))
        {
          ac.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, isCanceled");
          AppMethodBeat.o(186347);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, false);
        ac.d("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "onBackgroundAudioPause, notify pause");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.aZv(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), false));
        AppMethodBeat.o(186347);
      }
    };
    this.GX = this.jgY.mContext;
    this.Gu = ((NotificationManager)this.GX.getSystemService("notification"));
    AppMethodBeat.o(186353);
  }
  
  private static Bitmap K(Bitmap paramBitmap)
  {
    AppMethodBeat.i(186361);
    if (paramBitmap == null)
    {
      ac.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRoundedCornerBitmap, bitmap is null");
      AppMethodBeat.o(186361);
      return null;
    }
    paramBitmap = f.a(paramBitmap, false, 12.0F, false);
    AppMethodBeat.o(186361);
    return paramBitmap;
  }
  
  private Notification a(Context paramContext, boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(186357);
    paramContext = com.tencent.mm.bq.a.bE(paramContext, "reminder_channel_id").as(com.tencent.mm.bq.a.dlN()).a(b(paramContext, paramBoolean, paramBitmap)).F(false);
    paramContext.f(2, true);
    paramContext = paramContext.build();
    AppMethodBeat.o(186357);
    return paramContext;
  }
  
  private static void a(View paramView, List<TextView> paramList)
  {
    AppMethodBeat.i(186366);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i), paramList);
        i += 1;
      }
      AppMethodBeat.o(186366);
      return;
    }
    if ((paramView instanceof TextView)) {
      paramList.add((TextView)paramView);
    }
    AppMethodBeat.o(186366);
  }
  
  private Bitmap aZx()
  {
    AppMethodBeat.i(186359);
    String str = this.jxN.blO();
    Object localObject = str;
    if (bs.isNullOrNil(str)) {
      localObject = this.jgY.DJ().iconUrl;
    }
    if (bs.isNullOrNil((String)localObject))
    {
      localObject = K(aZy());
      AppMethodBeat.o(186359);
      return localObject;
    }
    if ((((String)localObject).equals(this.jxP)) && (this.jxQ != null))
    {
      ac.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, use mAlbumBitmap");
      localObject = this.jxQ;
      AppMethodBeat.o(186359);
      return localObject;
    }
    ac.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumUrl: ".concat(String.valueOf(localObject)));
    this.jxP = ((String)localObject);
    b.a(this.jgY.CX(), (String)localObject, null, new b.a()
    {
      public final void Jr(String paramAnonymousString)
      {
        AppMethodBeat.i(186352);
        ac.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, localPath: ".concat(String.valueOf(paramAnonymousString)));
        paramAnonymousString = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.L(f.aI(paramAnonymousString, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.aZz(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.aZA()));
        if (paramAnonymousString == null)
        {
          ac.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadAlbum, albumBitmap is null");
          AppMethodBeat.o(186352);
          return;
        }
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, paramAnonymousString);
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, paramAnonymousString);
        AppMethodBeat.o(186352);
      }
    });
    localObject = K(aZy());
    AppMethodBeat.o(186359);
    return localObject;
  }
  
  private Bitmap aZy()
  {
    AppMethodBeat.i(186360);
    Object localObject = (com.tencent.mm.plugin.appbrand.widget.h)this.jgY.ab(com.tencent.mm.plugin.appbrand.widget.h.class);
    if (localObject == null)
    {
      ac.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, iconProvider is null");
      AppMethodBeat.o(186360);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.widget.h)localObject).bya();
    if (localObject == null)
    {
      ac.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "loadDefaultAlbum, albumDrawable is null");
      AppMethodBeat.o(186360);
      return null;
    }
    localObject = f.A((Drawable)localObject);
    AppMethodBeat.o(186360);
    return localObject;
  }
  
  private RemoteViews b(Context paramContext, boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(186358);
    Object localObject2 = this.jxN.blN();
    Object localObject1 = localObject2;
    if (bs.isNullOrNil((String)localObject2)) {
      localObject1 = this.jgY.DJ().ddh;
    }
    localObject2 = paramBitmap;
    if (paramBitmap == null) {
      localObject2 = aZx();
    }
    paramBitmap = new RemoteViews(paramContext.getPackageName(), 2131495265);
    if (localObject2 != null) {
      paramBitmap.setImageViewBitmap(2131302607, (Bitmap)localObject2);
    }
    boolean bool;
    if (!bs.isNullOrNil((String)localObject1))
    {
      paramBitmap.setViewVisibility(2131302613, 0);
      paramBitmap.setTextViewText(2131302613, (CharSequence)localObject1);
      paramBitmap.setViewVisibility(2131302609, 8);
      bool = rD(dm(paramContext));
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_pre");
      localObject1 = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject1, 134217728);
      localObject2 = fO(bool);
      if (localObject2 != null) {
        break label373;
      }
      ac.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRemoteViews, preIconBitmap is null");
      label180:
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      if (!paramBoolean) {
        break label394;
      }
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_pause");
      label208:
      localObject1 = PendingIntent.getBroadcast(paramContext, 1, (Intent)localObject1, 134217728);
      paramBitmap.setImageViewResource(2131302611, t(paramBoolean, bool));
      paramBitmap.setOnClickPendingIntent(2131302611, (PendingIntent)localObject1);
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_next");
      localObject1 = PendingIntent.getBroadcast(paramContext, 2, (Intent)localObject1, 134217728);
      localObject2 = fQ(bool);
      if (localObject2 != null) {
        break label409;
      }
      ac.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getRemoteViews, nextIconBitmap is null");
    }
    for (;;)
    {
      localObject1 = new Intent("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
      ((Intent)localObject1).putExtra("background_audio_notification_action_key", "background_audio_notification_action_close");
      paramContext = PendingIntent.getBroadcast(paramContext, 3, (Intent)localObject1, 134217728);
      paramBitmap.setImageViewResource(2131302608, fS(bool));
      paramBitmap.setOnClickPendingIntent(2131302608, paramContext);
      AppMethodBeat.o(186358);
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
  
  private static int dm(Context paramContext)
  {
    AppMethodBeat.i(186364);
    Object localObject = com.tencent.mm.bq.a.bE(paramContext, "reminder_channel_id").build().contentView;
    if (localObject == null)
    {
      AppMethodBeat.o(186364);
      return -16777216;
    }
    int i = ((RemoteViews)localObject).getLayoutId();
    paramContext = (ViewGroup)LayoutInflater.from(paramContext).inflate(i, null);
    localObject = (TextView)paramContext.findViewById(16908310);
    if (localObject != null)
    {
      i = ((TextView)localObject).getCurrentTextColor();
      AppMethodBeat.o(186364);
      return i;
    }
    i = g(paramContext);
    AppMethodBeat.o(186364);
    return i;
  }
  
  private static Bitmap fO(boolean paramBoolean)
  {
    AppMethodBeat.i(186362);
    Bitmap localBitmap = f.Yo(fP(paramBoolean));
    if (localBitmap == null)
    {
      ac.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getPreIconBitmap, bitmap is null");
      AppMethodBeat.o(186362);
      return null;
    }
    localBitmap = f.b(localBitmap, 0.3F);
    AppMethodBeat.o(186362);
    return localBitmap;
  }
  
  private static int fP(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233852;
    }
    return 2131233854;
  }
  
  private static Bitmap fQ(boolean paramBoolean)
  {
    AppMethodBeat.i(186363);
    Bitmap localBitmap = f.Yo(fR(paramBoolean));
    if (localBitmap == null)
    {
      ac.w("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "getNextIconBitmap, bitmap is null");
      AppMethodBeat.o(186363);
      return null;
    }
    localBitmap = f.b(localBitmap, 0.3F);
    AppMethodBeat.o(186363);
    return localBitmap;
  }
  
  private static int fR(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233841;
    }
    return 2131233843;
  }
  
  private static int fS(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131233838;
    }
    return 2131233839;
  }
  
  private static int g(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(186365);
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
        AppMethodBeat.o(186365);
        return i;
      }
      AppMethodBeat.o(186365);
      return -16777216;
    }
  }
  
  private static boolean rD(int paramInt)
  {
    AppMethodBeat.i(186367);
    int j = paramInt | 0xFF000000;
    paramInt = Color.red(-16777216) - Color.red(j);
    int i = Color.green(-16777216) - Color.green(j);
    j = Color.blue(-16777216) - Color.blue(j);
    if (Math.sqrt(j * j + (paramInt * paramInt + i * i)) < 180.0D)
    {
      AppMethodBeat.o(186367);
      return true;
    }
    AppMethodBeat.o(186367);
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
  
  public final Notification aZu()
  {
    AppMethodBeat.i(186354);
    Notification localNotification = a(this.GX, this.mIsPlaying, null);
    AppMethodBeat.o(186354);
    return localNotification;
  }
  
  public final int aZv()
  {
    AppMethodBeat.i(186355);
    if (292 == this.jxO) {
      this.jxO = (ai.getProcessName().hashCode() + 292);
    }
    int i = this.jxO;
    AppMethodBeat.o(186355);
    return i;
  }
  
  public final void aZw()
  {
    AppMethodBeat.i(186356);
    ac.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify");
    if (!this.mIsCanceled)
    {
      ac.i("AppBrand.MicroMsg.AppBrandAudioOfVideoBackgroundPlayNotificationLogic", "startNotify, already start");
      com.tencent.e.h.JZN.aQ(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186348);
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.aZv(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
          AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
          AppMethodBeat.o(186348);
        }
      });
      AppMethodBeat.o(186356);
      return;
    }
    this.mIsCanceled = false;
    com.tencent.e.h.JZN.aQ(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186349);
        IntentFilter localIntentFilter = new IntentFilter("com.tencent.mm.Intent.ACTION_BACKGROUND_AUDIO_NOTIFICATION_CLICK");
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).registerReceiver(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.e(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), localIntentFilter);
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.c(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this).notify(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this.aZv(), AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, AppBrandAudioOfVideoBackgroundPlayNotificationLogic.b(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this), true));
        AppBrandAudioOfVideoBackgroundPlayNotificationLogic.a(AppBrandAudioOfVideoBackgroundPlayNotificationLogic.this, true);
        AppMethodBeat.o(186349);
      }
    });
    AppMethodBeat.o(186356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandAudioOfVideoBackgroundPlayNotificationLogic
 * JD-Core Version:    0.7.0.1
 */