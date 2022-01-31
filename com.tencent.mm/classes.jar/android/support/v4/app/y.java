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

final class y
  implements w
{
  final Notification.Builder mBuilder;
  final Bundle mExtras = new Bundle();
  RemoteViews xV;
  RemoteViews xW;
  RemoteViews xX;
  int ya;
  final x.c yq;
  final List<Bundle> yr = new ArrayList();
  
  y(x.c paramc)
  {
    this.yq = paramc;
    Object localObject1;
    Object localObject2;
    label138:
    label158:
    label178:
    PendingIntent localPendingIntent;
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mBuilder = new Notification.Builder(paramc.mContext, paramc.mChannelId);
      localObject1 = paramc.yb;
      localObject2 = this.mBuilder.setWhen(((Notification)localObject1).when).setSmallIcon(((Notification)localObject1).icon, ((Notification)localObject1).iconLevel).setContent(((Notification)localObject1).contentView).setTicker(((Notification)localObject1).tickerText, paramc.xB).setVibrate(((Notification)localObject1).vibrate).setLights(((Notification)localObject1).ledARGB, ((Notification)localObject1).ledOnMS, ((Notification)localObject1).ledOffMS);
      if ((((Notification)localObject1).flags & 0x2) == 0) {
        break label397;
      }
      bool = true;
      localObject2 = ((Notification.Builder)localObject2).setOngoing(bool);
      if ((((Notification)localObject1).flags & 0x8) == 0) {
        break label402;
      }
      bool = true;
      localObject2 = ((Notification.Builder)localObject2).setOnlyAlertOnce(bool);
      if ((((Notification)localObject1).flags & 0x10) == 0) {
        break label407;
      }
      bool = true;
      localObject2 = ((Notification.Builder)localObject2).setAutoCancel(bool).setDefaults(((Notification)localObject1).defaults).setContentTitle(paramc.xx).setContentText(paramc.xy).setContentInfo(paramc.xD).setContentIntent(paramc.xz).setDeleteIntent(((Notification)localObject1).deleteIntent);
      localPendingIntent = paramc.xA;
      if ((((Notification)localObject1).flags & 0x80) == 0) {
        break label412;
      }
    }
    label397:
    label402:
    label407:
    label412:
    for (boolean bool = true;; bool = false)
    {
      ((Notification.Builder)localObject2).setFullScreenIntent(localPendingIntent, bool).setLargeIcon(paramc.xC).setNumber(paramc.xE).setProgress(paramc.xK, paramc.xL, paramc.xM);
      if (Build.VERSION.SDK_INT < 21) {
        this.mBuilder.setSound(((Notification)localObject1).sound, ((Notification)localObject1).audioStreamType);
      }
      if (Build.VERSION.SDK_INT < 16) {
        break label537;
      }
      this.mBuilder.setSubText(paramc.xI).setUsesChronometer(paramc.xG).setPriority(paramc.mPriority);
      localObject2 = paramc.xw.iterator();
      while (((Iterator)localObject2).hasNext()) {
        a((x.a)((Iterator)localObject2).next());
      }
      this.mBuilder = new Notification.Builder(paramc.mContext);
      break;
      bool = false;
      break label138;
      bool = false;
      break label158;
      bool = false;
      break label178;
    }
    if (paramc.mExtras != null) {
      this.mExtras.putAll(paramc.mExtras);
    }
    if (Build.VERSION.SDK_INT < 20)
    {
      if (paramc.xQ) {
        this.mExtras.putBoolean("android.support.localOnly", true);
      }
      if (paramc.xN != null)
      {
        this.mExtras.putString("android.support.groupKey", paramc.xN);
        if (!paramc.xO) {
          break label754;
        }
        this.mExtras.putBoolean("android.support.isGroupSummary", true);
      }
    }
    for (;;)
    {
      if (paramc.xP != null) {
        this.mExtras.putString("android.support.sortKey", paramc.xP);
      }
      this.xV = paramc.xV;
      this.xW = paramc.xW;
      label537:
      if (Build.VERSION.SDK_INT >= 19)
      {
        this.mBuilder.setShowWhen(paramc.xF);
        if ((Build.VERSION.SDK_INT < 21) && (paramc.yc != null) && (!paramc.yc.isEmpty())) {
          this.mExtras.putStringArray("android.people", (String[])paramc.yc.toArray(new String[paramc.yc.size()]));
        }
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        this.mBuilder.setLocalOnly(paramc.xQ).setGroup(paramc.xN).setGroupSummary(paramc.xO).setSortKey(paramc.xP);
        this.ya = paramc.ya;
      }
      if (Build.VERSION.SDK_INT < 21) {
        break label776;
      }
      this.mBuilder.setCategory(paramc.mCategory).setColor(paramc.mColor).setVisibility(paramc.xT).setPublicVersion(paramc.xU).setSound(((Notification)localObject1).sound, ((Notification)localObject1).audioAttributes);
      localObject1 = paramc.yc.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.mBuilder.addPerson((String)localObject2);
      }
      label754:
      this.mExtras.putBoolean("android.support.useSideChannel", true);
    }
    this.xX = paramc.xX;
    label776:
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.mBuilder.setExtras(paramc.mExtras).setRemoteInputHistory(paramc.xJ);
      if (paramc.xV != null) {
        this.mBuilder.setCustomContentView(paramc.xV);
      }
      if (paramc.xW != null) {
        this.mBuilder.setCustomBigContentView(paramc.xW);
      }
      if (paramc.xX != null) {
        this.mBuilder.setCustomHeadsUpContentView(paramc.xX);
      }
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mBuilder.setBadgeIconType(paramc.xY).setShortcutId(paramc.xZ).setTimeoutAfter(paramc.mTimeout).setGroupAlertBehavior(paramc.ya);
      if (paramc.xS) {
        this.mBuilder.setColorized(paramc.xR);
      }
      if (!TextUtils.isEmpty(paramc.mChannelId)) {
        this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
      }
    }
  }
  
  private void a(x.a parama)
  {
    if (Build.VERSION.SDK_INT >= 20)
    {
      localBuilder = new Notification.Action.Builder(parama.icon, parama.title, parama.actionIntent);
      if (parama.xs != null)
      {
        localObject = ac.b(parama.xs);
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
        ((Bundle)localObject).putBoolean("android.support.allowGeneratedReplies", parama.xu);
        if (Build.VERSION.SDK_INT >= 24) {
          localBuilder.setAllowGeneratedReplies(parama.xu);
        }
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
    this.yr.add(z.a(this.mBuilder, parama));
  }
  
  static void b(Notification paramNotification)
  {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    paramNotification.defaults &= 0xFFFFFFFE;
    paramNotification.defaults &= 0xFFFFFFFD;
  }
  
  public final Notification.Builder cg()
  {
    return this.mBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.app.y
 * JD-Core Version:    0.7.0.1
 */