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
  RemoteViews ES;
  RemoteViews ET;
  RemoteViews EU;
  int EX;
  final s.c Fn;
  final List<Bundle> Fo = new ArrayList();
  final Notification.Builder mBuilder;
  final Bundle mExtras = new Bundle();
  
  t(s.c paramc)
  {
    this.Fn = paramc;
    Object localObject1;
    Object localObject2;
    label149:
    label170:
    label191:
    PendingIntent localPendingIntent;
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mBuilder = new Notification.Builder(paramc.mContext, paramc.mChannelId);
      localObject1 = paramc.EY;
      localObject2 = this.mBuilder.setWhen(((Notification)localObject1).when).setSmallIcon(((Notification)localObject1).icon, ((Notification)localObject1).iconLevel).setContent(((Notification)localObject1).contentView).setTicker(((Notification)localObject1).tickerText, paramc.Ey).setVibrate(((Notification)localObject1).vibrate).setLights(((Notification)localObject1).ledARGB, ((Notification)localObject1).ledOnMS, ((Notification)localObject1).ledOffMS);
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
      localObject2 = ((Notification.Builder)localObject2).setAutoCancel(bool).setDefaults(((Notification)localObject1).defaults).setContentTitle(paramc.Eu).setContentText(paramc.Ev).setContentInfo(paramc.EA).setContentIntent(paramc.Ew).setDeleteIntent(((Notification)localObject1).deleteIntent);
      localPendingIntent = paramc.Ex;
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
      ((Notification.Builder)localObject2).setFullScreenIntent(localPendingIntent, bool).setLargeIcon(paramc.Ez).setNumber(paramc.EB).setProgress(paramc.EH, paramc.EI, paramc.EJ);
      if (Build.VERSION.SDK_INT < 21) {
        this.mBuilder.setSound(((Notification)localObject1).sound, ((Notification)localObject1).audioStreamType);
      }
      if (Build.VERSION.SDK_INT < 16) {
        break label555;
      }
      this.mBuilder.setSubText(paramc.EF).setUsesChronometer(paramc.ED).setPriority(paramc.mPriority);
      localObject2 = paramc.Es.iterator();
      while (((Iterator)localObject2).hasNext()) {
        b((s.a)((Iterator)localObject2).next());
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
      if (paramc.EN) {
        this.mExtras.putBoolean("android.support.localOnly", true);
      }
      if (paramc.EK != null)
      {
        this.mExtras.putString("android.support.groupKey", paramc.EK);
        if (!paramc.EL) {
          break label777;
        }
        this.mExtras.putBoolean("android.support.isGroupSummary", true);
      }
    }
    for (;;)
    {
      if (paramc.EM != null) {
        this.mExtras.putString("android.support.sortKey", paramc.EM);
      }
      this.ES = paramc.ES;
      this.ET = paramc.ET;
      label555:
      if (Build.VERSION.SDK_INT >= 19)
      {
        this.mBuilder.setShowWhen(paramc.EC);
        if ((Build.VERSION.SDK_INT < 21) && (paramc.EZ != null) && (!paramc.EZ.isEmpty())) {
          this.mExtras.putStringArray("android.people", (String[])paramc.EZ.toArray(new String[paramc.EZ.size()]));
        }
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        this.mBuilder.setLocalOnly(paramc.EN).setGroup(paramc.EK).setGroupSummary(paramc.EL).setSortKey(paramc.EM);
        this.EX = paramc.EX;
      }
      if (Build.VERSION.SDK_INT < 21) {
        break label921;
      }
      this.mBuilder.setCategory(paramc.EQ).setColor(paramc.mColor).setVisibility(paramc.mVisibility).setPublicVersion(paramc.ER).setSound(((Notification)localObject1).sound, ((Notification)localObject1).audioAttributes);
      localObject1 = paramc.EZ.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.mBuilder.addPerson((String)localObject2);
      }
      label777:
      this.mExtras.putBoolean("android.support.useSideChannel", true);
    }
    this.EU = paramc.EU;
    if (paramc.Et.size() > 0)
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
      while (i < paramc.Et.size())
      {
        ((Bundle)localObject2).putBundle(Integer.toString(i), u.c((s.a)paramc.Et.get(i)));
        i += 1;
      }
      ((Bundle)localObject1).putBundle("invisible_actions", (Bundle)localObject2);
      paramc.getExtras().putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
      this.mExtras.putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
      if (Build.VERSION.SDK_INT >= 24)
      {
        this.mBuilder.setExtras(paramc.mExtras).setRemoteInputHistory(paramc.EG);
        if (paramc.ES != null) {
          this.mBuilder.setCustomContentView(paramc.ES);
        }
        if (paramc.ET != null) {
          this.mBuilder.setCustomBigContentView(paramc.ET);
        }
        if (paramc.EU != null) {
          this.mBuilder.setCustomHeadsUpContentView(paramc.EU);
        }
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        this.mBuilder.setBadgeIconType(paramc.EV).setShortcutId(paramc.EW).setTimeoutAfter(paramc.mTimeout).setGroupAlertBehavior(paramc.EX);
        if (paramc.EP) {
          this.mBuilder.setColorized(paramc.EO);
        }
        if (!TextUtils.isEmpty(paramc.mChannelId)) {
          this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
      }
      return;
    }
  }
  
  static void b(Notification paramNotification)
  {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    paramNotification.defaults &= 0xFFFFFFFE;
    paramNotification.defaults &= 0xFFFFFFFD;
  }
  
  private void b(s.a parama)
  {
    if (Build.VERSION.SDK_INT >= 20)
    {
      localBuilder = new Notification.Action.Builder(parama.icon, parama.title, parama.actionIntent);
      if (parama.Ei != null)
      {
        localObject = x.b(parama.Ei);
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
        ((Bundle)localObject).putBoolean("android.support.allowGeneratedReplies", parama.Ek);
        if (Build.VERSION.SDK_INT >= 24) {
          localBuilder.setAllowGeneratedReplies(parama.Ek);
        }
        ((Bundle)localObject).putInt("android.support.action.semanticAction", parama.Em);
        if (Build.VERSION.SDK_INT >= 28) {
          localBuilder.setSemanticAction(parama.Em);
        }
        ((Bundle)localObject).putBoolean("android.support.action.showsUserInterface", parama.El);
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
    this.Fo.add(u.a(this.mBuilder, parama));
  }
  
  public final Notification.Builder dL()
  {
    return this.mBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.t
 * JD-Core Version:    0.7.0.1
 */