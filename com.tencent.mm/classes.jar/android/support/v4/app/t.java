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
  RemoteViews HR;
  RemoteViews HS;
  RemoteViews HT;
  int HW;
  final s.c In;
  final List<Bundle> Io = new ArrayList();
  final Notification.Builder mBuilder;
  final Bundle mExtras = new Bundle();
  
  t(s.c paramc)
  {
    this.In = paramc;
    Object localObject1;
    Object localObject2;
    label149:
    label170:
    label191:
    PendingIntent localPendingIntent;
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mBuilder = new Notification.Builder(paramc.mContext, paramc.mChannelId);
      localObject1 = paramc.HX;
      localObject2 = this.mBuilder.setWhen(((Notification)localObject1).when).setSmallIcon(((Notification)localObject1).icon, ((Notification)localObject1).iconLevel).setContent(((Notification)localObject1).contentView).setTicker(((Notification)localObject1).tickerText, paramc.Hx).setVibrate(((Notification)localObject1).vibrate).setLights(((Notification)localObject1).ledARGB, ((Notification)localObject1).ledOnMS, ((Notification)localObject1).ledOffMS);
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
      localObject2 = ((Notification.Builder)localObject2).setAutoCancel(bool).setDefaults(((Notification)localObject1).defaults).setContentTitle(paramc.Ht).setContentText(paramc.Hu).setContentInfo(paramc.Hz).setContentIntent(paramc.Hv).setDeleteIntent(((Notification)localObject1).deleteIntent);
      localPendingIntent = paramc.Hw;
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
      ((Notification.Builder)localObject2).setFullScreenIntent(localPendingIntent, bool).setLargeIcon(paramc.Hy).setNumber(paramc.HA).setProgress(paramc.HG, paramc.HH, paramc.HI);
      if (Build.VERSION.SDK_INT < 21) {
        this.mBuilder.setSound(((Notification)localObject1).sound, ((Notification)localObject1).audioStreamType);
      }
      if (Build.VERSION.SDK_INT < 16) {
        break label555;
      }
      this.mBuilder.setSubText(paramc.HE).setUsesChronometer(paramc.HC).setPriority(paramc.mPriority);
      localObject2 = paramc.Hr.iterator();
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
      if (paramc.HM) {
        this.mExtras.putBoolean("android.support.localOnly", true);
      }
      if (paramc.HJ != null)
      {
        this.mExtras.putString("android.support.groupKey", paramc.HJ);
        if (!paramc.HK) {
          break label777;
        }
        this.mExtras.putBoolean("android.support.isGroupSummary", true);
      }
    }
    for (;;)
    {
      if (paramc.HL != null) {
        this.mExtras.putString("android.support.sortKey", paramc.HL);
      }
      this.HR = paramc.HR;
      this.HS = paramc.HS;
      label555:
      if (Build.VERSION.SDK_INT >= 19)
      {
        this.mBuilder.setShowWhen(paramc.HB);
        if ((Build.VERSION.SDK_INT < 21) && (paramc.HY != null) && (!paramc.HY.isEmpty())) {
          this.mExtras.putStringArray("android.people", (String[])paramc.HY.toArray(new String[paramc.HY.size()]));
        }
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        this.mBuilder.setLocalOnly(paramc.HM).setGroup(paramc.HJ).setGroupSummary(paramc.HK).setSortKey(paramc.HL);
        this.HW = paramc.HW;
      }
      if (Build.VERSION.SDK_INT < 21) {
        break label921;
      }
      this.mBuilder.setCategory(paramc.HP).setColor(paramc.mColor).setVisibility(paramc.mVisibility).setPublicVersion(paramc.HQ).setSound(((Notification)localObject1).sound, ((Notification)localObject1).audioAttributes);
      localObject1 = paramc.HY.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.mBuilder.addPerson((String)localObject2);
      }
      label777:
      this.mExtras.putBoolean("android.support.useSideChannel", true);
    }
    this.HT = paramc.HT;
    if (paramc.Hs.size() > 0)
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
      while (i < paramc.Hs.size())
      {
        ((Bundle)localObject2).putBundle(Integer.toString(i), u.c((s.a)paramc.Hs.get(i)));
        i += 1;
      }
      ((Bundle)localObject1).putBundle("invisible_actions", (Bundle)localObject2);
      paramc.getExtras().putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
      this.mExtras.putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
      if (Build.VERSION.SDK_INT >= 24)
      {
        this.mBuilder.setExtras(paramc.mExtras).setRemoteInputHistory(paramc.HF);
        if (paramc.HR != null) {
          this.mBuilder.setCustomContentView(paramc.HR);
        }
        if (paramc.HS != null) {
          this.mBuilder.setCustomBigContentView(paramc.HS);
        }
        if (paramc.HT != null) {
          this.mBuilder.setCustomHeadsUpContentView(paramc.HT);
        }
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        this.mBuilder.setBadgeIconType(paramc.HU).setShortcutId(paramc.HV).setTimeoutAfter(paramc.mTimeout).setGroupAlertBehavior(paramc.HW);
        if (paramc.HO) {
          this.mBuilder.setColorized(paramc.HN);
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
      if (parama.Hh != null)
      {
        localObject = x.b(parama.Hh);
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
        ((Bundle)localObject).putBoolean("android.support.allowGeneratedReplies", parama.Hj);
        if (Build.VERSION.SDK_INT >= 24) {
          localBuilder.setAllowGeneratedReplies(parama.Hj);
        }
        ((Bundle)localObject).putInt("android.support.action.semanticAction", parama.Hl);
        if (Build.VERSION.SDK_INT >= 28) {
          localBuilder.setSemanticAction(parama.Hl);
        }
        ((Bundle)localObject).putBoolean("android.support.action.showsUserInterface", parama.Hk);
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
    this.Io.add(u.a(this.mBuilder, parama));
  }
  
  public final Notification.Builder er()
  {
    return this.mBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.t
 * JD-Core Version:    0.7.0.1
 */