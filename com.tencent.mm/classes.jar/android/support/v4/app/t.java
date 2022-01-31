package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class t
  implements r
{
  final Notification.Builder mBuilder;
  final Bundle mExtras = new Bundle();
  int yB;
  final s.c yS;
  final List<Bundle> yT = new ArrayList();
  RemoteViews yw;
  RemoteViews yx;
  RemoteViews yy;
  
  t(s.c paramc)
  {
    this.yS = paramc;
    Object localObject1;
    Object localObject2;
    label149:
    label170:
    label191:
    PendingIntent localPendingIntent;
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mBuilder = new Notification.Builder(paramc.mContext, paramc.mChannelId);
      localObject1 = paramc.yC;
      localObject2 = this.mBuilder.setWhen(((Notification)localObject1).when).setSmallIcon(((Notification)localObject1).icon, ((Notification)localObject1).iconLevel).setContent(((Notification)localObject1).contentView).setTicker(((Notification)localObject1).tickerText, paramc.yc).setVibrate(((Notification)localObject1).vibrate).setLights(((Notification)localObject1).ledARGB, ((Notification)localObject1).ledOnMS, ((Notification)localObject1).ledOffMS);
      if ((((Notification)localObject1).flags & 0x2) == 0) {
        break label415;
      }
      bool = true;
      localObject2 = ((Notification.Builder)localObject2).setOngoing(bool);
      if ((((Notification)localObject1).flags & 0x8) == 0) {
        break label420;
      }
      bool = true;
      localObject2 = ((Notification.Builder)localObject2).setOnlyAlertOnce(bool);
      if ((((Notification)localObject1).flags & 0x10) == 0) {
        break label425;
      }
      bool = true;
      localObject2 = ((Notification.Builder)localObject2).setAutoCancel(bool).setDefaults(((Notification)localObject1).defaults).setContentTitle(paramc.xY).setContentText(paramc.xZ).setContentInfo(paramc.ye).setContentIntent(paramc.ya).setDeleteIntent(((Notification)localObject1).deleteIntent);
      localPendingIntent = paramc.yb;
      if ((((Notification)localObject1).flags & 0x80) == 0) {
        break label430;
      }
    }
    label415:
    label420:
    label425:
    label430:
    for (boolean bool = true;; bool = false)
    {
      ((Notification.Builder)localObject2).setFullScreenIntent(localPendingIntent, bool).setLargeIcon(paramc.yd).setNumber(paramc.yf).setProgress(paramc.yl, paramc.ym, paramc.yn);
      if (Build.VERSION.SDK_INT < 21) {
        this.mBuilder.setSound(((Notification)localObject1).sound, ((Notification)localObject1).audioStreamType);
      }
      if (Build.VERSION.SDK_INT < 16) {
        break label555;
      }
      this.mBuilder.setSubText(paramc.yj).setUsesChronometer(paramc.yh).setPriority(paramc.mPriority);
      localObject2 = paramc.xW.iterator();
      while (((Iterator)localObject2).hasNext()) {
        a((s.a)((Iterator)localObject2).next());
      }
      this.mBuilder = new Notification.Builder(paramc.mContext);
      break;
      bool = false;
      break label149;
      bool = false;
      break label170;
      bool = false;
      break label191;
    }
    if (paramc.mExtras != null) {
      this.mExtras.putAll(paramc.mExtras);
    }
    if (Build.VERSION.SDK_INT < 20)
    {
      if (paramc.yr) {
        this.mExtras.putBoolean("android.support.localOnly", true);
      }
      if (paramc.yo != null)
      {
        this.mExtras.putString("android.support.groupKey", paramc.yo);
        if (!paramc.yp) {
          break label777;
        }
        this.mExtras.putBoolean("android.support.isGroupSummary", true);
      }
    }
    for (;;)
    {
      if (paramc.yq != null) {
        this.mExtras.putString("android.support.sortKey", paramc.yq);
      }
      this.yw = paramc.yw;
      this.yx = paramc.yx;
      label555:
      if (Build.VERSION.SDK_INT >= 19)
      {
        this.mBuilder.setShowWhen(paramc.yg);
        if ((Build.VERSION.SDK_INT < 21) && (paramc.yD != null) && (!paramc.yD.isEmpty())) {
          this.mExtras.putStringArray("android.people", (String[])paramc.yD.toArray(new String[paramc.yD.size()]));
        }
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        this.mBuilder.setLocalOnly(paramc.yr).setGroup(paramc.yo).setGroupSummary(paramc.yp).setSortKey(paramc.yq);
        this.yB = paramc.yB;
      }
      if (Build.VERSION.SDK_INT < 21) {
        break label921;
      }
      this.mBuilder.setCategory(paramc.yu).setColor(paramc.mColor).setVisibility(paramc.mVisibility).setPublicVersion(paramc.yv).setSound(((Notification)localObject1).sound, ((Notification)localObject1).audioAttributes);
      localObject1 = paramc.yD.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.mBuilder.addPerson((String)localObject2);
      }
      label777:
      this.mExtras.putBoolean("android.support.useSideChannel", true);
    }
    this.yy = paramc.yy;
    if (paramc.xX.size() > 0)
    {
      localObject1 = paramc.getExtras().getBundle("android.car.EXTENSIONS");
      if (localObject1 != null) {
        break label1099;
      }
      localObject1 = new Bundle();
    }
    label921:
    label1099:
    for (;;)
    {
      localObject2 = new Bundle();
      int i = 0;
      while (i < paramc.xX.size())
      {
        ((Bundle)localObject2).putBundle(Integer.toString(i), u.b((s.a)paramc.xX.get(i)));
        i += 1;
      }
      ((Bundle)localObject1).putBundle("invisible_actions", (Bundle)localObject2);
      paramc.getExtras().putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
      this.mExtras.putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
      if (Build.VERSION.SDK_INT >= 24)
      {
        this.mBuilder.setExtras(paramc.mExtras).setRemoteInputHistory(paramc.yk);
        if (paramc.yw != null) {
          this.mBuilder.setCustomContentView(paramc.yw);
        }
        if (paramc.yx != null) {
          this.mBuilder.setCustomBigContentView(paramc.yx);
        }
        if (paramc.yy != null) {
          this.mBuilder.setCustomHeadsUpContentView(paramc.yy);
        }
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        this.mBuilder.setBadgeIconType(paramc.yz).setShortcutId(paramc.yA).setTimeoutAfter(paramc.mTimeout).setGroupAlertBehavior(paramc.yB);
        if (paramc.yt) {
          this.mBuilder.setColorized(paramc.ys);
        }
        if (!TextUtils.isEmpty(paramc.mChannelId)) {
          this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
      }
      return;
    }
  }
  
  private void a(s.a parama)
  {
    if (Build.VERSION.SDK_INT >= 20)
    {
      localBuilder = new Notification.Action.Builder(parama.icon, parama.title, parama.actionIntent);
      if (parama.xQ != null)
      {
        localObject = x.b(parama.xQ);
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          localBuilder.addRemoteInput(localObject[i]);
          i += 1;
        }
      }
      if (parama.mExtras != null)
      {
        localObject = new Bundle(parama.mExtras);
        ((Bundle)localObject).putBoolean("android.support.allowGeneratedReplies", parama.xS);
        if (Build.VERSION.SDK_INT >= 24) {
          localBuilder.setAllowGeneratedReplies(parama.xS);
        }
        ((Bundle)localObject).putInt("android.support.action.semanticAction", parama.xU);
        if (Build.VERSION.SDK_INT >= 28) {
          localBuilder.setSemanticAction(parama.xU);
        }
        ((Bundle)localObject).putBoolean("android.support.action.showsUserInterface", parama.xT);
        localBuilder.addExtras((Bundle)localObject);
        this.mBuilder.addAction(localBuilder.build());
      }
    }
    while (Build.VERSION.SDK_INT < 16) {
      for (;;)
      {
        Notification.Action.Builder localBuilder;
        int j;
        int i;
        return;
        Object localObject = new Bundle();
      }
    }
    this.yT.add(u.a(this.mBuilder, parama));
  }
  
  static void b(Notification paramNotification)
  {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    paramNotification.defaults &= 0xFFFFFFFE;
    paramNotification.defaults &= 0xFFFFFFFD;
  }
  
  public final Notification.Builder cI()
  {
    return this.mBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.t
 * JD-Core Version:    0.7.0.1
 */