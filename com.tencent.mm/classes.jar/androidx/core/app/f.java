package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.Notification.BubbleMetadata.Builder;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class f
  implements d
{
  RemoteViews IM;
  RemoteViews IN;
  RemoteViews IP;
  int IS;
  final Notification.Builder Jl;
  final e.d Jm;
  final List<Bundle> Jn;
  final Bundle mExtras;
  
  f(e.d paramd)
  {
    AppMethodBeat.i(250368);
    this.Jn = new ArrayList();
    this.mExtras = new Bundle();
    this.Jm = paramd;
    Notification localNotification;
    Object localObject1;
    label154:
    label175:
    label196:
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.Jl = new Notification.Builder(paramd.mContext, paramd.mChannelId);
      localNotification = paramd.IV;
      localObject1 = this.Jl.setWhen(localNotification.when).setSmallIcon(localNotification.icon, localNotification.iconLevel).setContent(localNotification.contentView).setTicker(localNotification.tickerText, paramd.Ir).setVibrate(localNotification.vibrate).setLights(localNotification.ledARGB, localNotification.ledOnMS, localNotification.ledOffMS);
      if ((localNotification.flags & 0x2) == 0) {
        break label420;
      }
      bool = true;
      localObject1 = ((Notification.Builder)localObject1).setOngoing(bool);
      if ((localNotification.flags & 0x8) == 0) {
        break label425;
      }
      bool = true;
      localObject1 = ((Notification.Builder)localObject1).setOnlyAlertOnce(bool);
      if ((localNotification.flags & 0x10) == 0) {
        break label430;
      }
      bool = true;
      localObject1 = ((Notification.Builder)localObject1).setAutoCancel(bool).setDefaults(localNotification.defaults).setContentTitle(paramd.In).setContentText(paramd.Io).setContentInfo(paramd.It).setContentIntent(paramd.Ip).setDeleteIntent(localNotification.deleteIntent);
      localObject2 = paramd.Iq;
      if ((localNotification.flags & 0x80) == 0) {
        break label435;
      }
    }
    label420:
    label425:
    label430:
    label435:
    for (boolean bool = true;; bool = false)
    {
      ((Notification.Builder)localObject1).setFullScreenIntent((PendingIntent)localObject2, bool).setLargeIcon(paramd.Is).setNumber(paramd.Iu).setProgress(paramd.IA, paramd.IB, paramd.IC);
      if (Build.VERSION.SDK_INT < 21) {
        this.Jl.setSound(localNotification.sound, localNotification.audioStreamType);
      }
      if (Build.VERSION.SDK_INT < 16) {
        break label560;
      }
      this.Jl.setSubText(paramd.Iy).setUsesChronometer(paramd.Iw).setPriority(paramd.mPriority);
      localObject1 = paramd.Il.iterator();
      while (((Iterator)localObject1).hasNext()) {
        b((e.a)((Iterator)localObject1).next());
      }
      this.Jl = new Notification.Builder(paramd.mContext);
      break;
      bool = false;
      break label154;
      bool = false;
      break label175;
      bool = false;
      break label196;
    }
    if (paramd.mExtras != null) {
      this.mExtras.putAll(paramd.mExtras);
    }
    if (Build.VERSION.SDK_INT < 20)
    {
      if (paramd.IH) {
        this.mExtras.putBoolean("android.support.localOnly", true);
      }
      if (paramd.IE != null)
      {
        this.mExtras.putString("android.support.groupKey", paramd.IE);
        if (!paramd.IF) {
          break label782;
        }
        this.mExtras.putBoolean("android.support.isGroupSummary", true);
      }
    }
    for (;;)
    {
      if (paramd.IG != null) {
        this.mExtras.putString("android.support.sortKey", paramd.IG);
      }
      this.IM = paramd.IM;
      this.IN = paramd.IN;
      label560:
      if (Build.VERSION.SDK_INT >= 19)
      {
        this.Jl.setShowWhen(paramd.Iv);
        if ((Build.VERSION.SDK_INT < 21) && (paramd.IX != null) && (!paramd.IX.isEmpty())) {
          this.mExtras.putStringArray("android.people", (String[])paramd.IX.toArray(new String[paramd.IX.size()]));
        }
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        this.Jl.setLocalOnly(paramd.IH).setGroup(paramd.IE).setGroupSummary(paramd.IF).setSortKey(paramd.IG);
        this.IS = paramd.IS;
      }
      if (Build.VERSION.SDK_INT < 21) {
        break label926;
      }
      this.Jl.setCategory(paramd.IK).setColor(paramd.mColor).setVisibility(paramd.CX).setPublicVersion(paramd.IL).setSound(localNotification.sound, localNotification.audioAttributes);
      localObject1 = paramd.IX.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.Jl.addPerson((String)localObject2);
      }
      label782:
      this.mExtras.putBoolean("android.support.useSideChannel", true);
    }
    this.IP = paramd.IP;
    if (paramd.Im.size() > 0)
    {
      localObject1 = paramd.getExtras().getBundle("android.car.EXTENSIONS");
      if (localObject1 != null) {
        break label1295;
      }
      localObject1 = new Bundle();
    }
    label1287:
    label1295:
    for (;;)
    {
      localObject2 = new Bundle();
      int i = 0;
      while (i < paramd.Im.size())
      {
        ((Bundle)localObject2).putBundle(Integer.toString(i), g.c((e.a)paramd.Im.get(i)));
        i += 1;
      }
      ((Bundle)localObject1).putBundle("invisible_actions", (Bundle)localObject2);
      paramd.getExtras().putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
      this.mExtras.putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
      label926:
      if (Build.VERSION.SDK_INT >= 24)
      {
        this.Jl.setExtras(paramd.mExtras).setRemoteInputHistory(paramd.Iz);
        if (paramd.IM != null) {
          this.Jl.setCustomContentView(paramd.IM);
        }
        if (paramd.IN != null) {
          this.Jl.setCustomBigContentView(paramd.IN);
        }
        if (paramd.IP != null) {
          this.Jl.setCustomHeadsUpContentView(paramd.IP);
        }
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        this.Jl.setBadgeIconType(paramd.IQ).setShortcutId(paramd.IR).setTimeoutAfter(paramd.mTimeout).setGroupAlertBehavior(paramd.IS);
        if (paramd.IJ) {
          this.Jl.setColorized(paramd.II);
        }
        if (!TextUtils.isEmpty(paramd.mChannelId)) {
          this.Jl.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
      }
      if (Build.VERSION.SDK_INT >= 29)
      {
        this.Jl.setAllowSystemGeneratedContextualActions(paramd.IT);
        localObject1 = this.Jl;
        if (paramd.IU == null) {
          ((Notification.Builder)localObject1).setBubbleMetadata(null);
        }
      }
      else if (paramd.IW)
      {
        if (!this.Jm.IF) {
          break label1287;
        }
      }
      for (this.IS = 2;; this.IS = 1)
      {
        this.Jl.setVibrate(null);
        this.Jl.setSound(null);
        localNotification.defaults &= 0xFFFFFFFE;
        localNotification.defaults &= 0xFFFFFFFD;
        this.Jl.setDefaults(localNotification.defaults);
        if (Build.VERSION.SDK_INT >= 26)
        {
          if (TextUtils.isEmpty(this.Jm.IE)) {
            this.Jl.setGroup("silent");
          }
          this.Jl.setGroupAlertBehavior(this.IS);
        }
        AppMethodBeat.o(250368);
        return;
        new Notification.BubbleMetadata.Builder();
        AppMethodBeat.o(250368);
        throw null;
      }
    }
  }
  
  static void b(Notification paramNotification)
  {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    paramNotification.defaults &= 0xFFFFFFFE;
    paramNotification.defaults &= 0xFFFFFFFD;
  }
  
  private void b(e.a parama)
  {
    int j = 0;
    AppMethodBeat.i(250376);
    if (Build.VERSION.SDK_INT >= 20)
    {
      IconCompat localIconCompat = parama.gn();
      Object localObject1;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (localIconCompat != null) {
          switch (localIconCompat.mType)
          {
          case 0: 
          default: 
            parama = new IllegalArgumentException("Unknown type");
            AppMethodBeat.o(250376);
            throw parama;
          case -1: 
            localObject2 = (Icon)localIconCompat.KM;
          }
        }
        for (;;)
        {
          localObject1 = new Notification.Action.Builder((Icon)localObject2, parama.Ig, parama.Ih);
          if (parama.HZ == null) {
            break;
          }
          localObject2 = i.b(parama.HZ);
          int k = localObject2.length;
          i = j;
          while (i < k)
          {
            ((Notification.Action.Builder)localObject1).addRemoteInput(localObject2[i]);
            i += 1;
          }
          localObject1 = Icon.createWithBitmap((Bitmap)localIconCompat.KM);
          for (;;)
          {
            if (localIconCompat.jE != null) {
              ((Icon)localObject1).setTintList(localIconCompat.jE);
            }
            localObject2 = localObject1;
            if (localIconCompat.jF == IconCompat.KQ) {
              break;
            }
            ((Icon)localObject1).setTintMode(localIconCompat.jF);
            localObject2 = localObject1;
            break;
            if (Build.VERSION.SDK_INT >= 26)
            {
              localObject1 = Icon.createWithAdaptiveBitmap((Bitmap)localIconCompat.KM);
            }
            else
            {
              localObject1 = Icon.createWithBitmap(IconCompat.d((Bitmap)localIconCompat.KM));
              continue;
              localObject1 = Icon.createWithResource(localIconCompat.gz(), localIconCompat.KO);
              continue;
              localObject1 = Icon.createWithData((byte[])localIconCompat.KM, localIconCompat.KO, localIconCompat.KP);
              continue;
              localObject1 = Icon.createWithContentUri((String)localIconCompat.KM);
            }
          }
          localObject1 = new StringBuilder("Context is required to resolve the file uri of the icon: ");
          if ((localIconCompat.mType == -1) && (Build.VERSION.SDK_INT >= 23)) {}
          for (parama = IconCompat.d((Icon)localIconCompat.KM);; parama = Uri.parse((String)localIconCompat.KM))
          {
            parama = new IllegalArgumentException(parama);
            AppMethodBeat.o(250376);
            throw parama;
            if ((localIconCompat.mType != 4) && (localIconCompat.mType != 6))
            {
              parama = new IllegalStateException("called getUri() on ".concat(String.valueOf(localIconCompat)));
              AppMethodBeat.o(250376);
              throw parama;
            }
          }
          localObject2 = null;
        }
      }
      if (localIconCompat != null) {}
      for (int i = localIconCompat.getResId();; i = 0)
      {
        localObject1 = new Notification.Action.Builder(i, parama.Ig, parama.Ih);
        break;
      }
      if (parama.mExtras != null) {}
      for (Object localObject2 = new Bundle(parama.mExtras);; localObject2 = new Bundle())
      {
        ((Bundle)localObject2).putBoolean("android.support.allowGeneratedReplies", parama.Ib);
        if (Build.VERSION.SDK_INT >= 24) {
          ((Notification.Action.Builder)localObject1).setAllowGeneratedReplies(parama.Ib);
        }
        ((Bundle)localObject2).putInt("android.support.action.semanticAction", parama.Ie);
        if (Build.VERSION.SDK_INT >= 28) {
          ((Notification.Action.Builder)localObject1).setSemanticAction(parama.Ie);
        }
        if (Build.VERSION.SDK_INT >= 29) {
          ((Notification.Action.Builder)localObject1).setContextual(parama.If);
        }
        ((Bundle)localObject2).putBoolean("android.support.action.showsUserInterface", parama.Ic);
        ((Notification.Action.Builder)localObject1).addExtras((Bundle)localObject2);
        this.Jl.addAction(((Notification.Action.Builder)localObject1).build());
        AppMethodBeat.o(250376);
        return;
      }
    }
    if (Build.VERSION.SDK_INT >= 16) {
      this.Jn.add(g.a(this.Jl, parama));
    }
    AppMethodBeat.o(250376);
  }
  
  public final Notification.Builder gm()
  {
    return this.Jl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.app.f
 * JD-Core Version:    0.7.0.1
 */