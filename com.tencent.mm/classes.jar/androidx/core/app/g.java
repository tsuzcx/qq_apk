package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.Notification.BubbleMetadata;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.Person.Builder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.b.b;
import androidx.core.graphics.drawable.IconCompat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class g
  implements e
{
  RemoteViews boO;
  RemoteViews boP;
  RemoteViews boQ;
  int boU;
  final Notification.Builder bpo;
  final f.d bpp;
  final List<Bundle> bpq;
  private final Context mContext;
  final Bundle mExtras;
  
  g(f.d paramd)
  {
    AppMethodBeat.i(196386);
    this.bpq = new ArrayList();
    this.mExtras = new Bundle();
    this.bpp = paramd;
    this.mContext = paramd.mContext;
    Notification localNotification;
    Object localObject1;
    label162:
    label183:
    label204:
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.bpo = new Notification.Builder(paramd.mContext, paramd.mChannelId);
      localNotification = paramd.boX;
      localObject1 = this.bpo.setWhen(localNotification.when).setSmallIcon(localNotification.icon, localNotification.iconLevel).setContent(localNotification.contentView).setTicker(localNotification.tickerText, paramd.bot).setVibrate(localNotification.vibrate).setLights(localNotification.ledARGB, localNotification.ledOnMS, localNotification.ledOffMS);
      if ((localNotification.flags & 0x2) == 0) {
        break label428;
      }
      bool = true;
      localObject1 = ((Notification.Builder)localObject1).setOngoing(bool);
      if ((localNotification.flags & 0x8) == 0) {
        break label433;
      }
      bool = true;
      localObject1 = ((Notification.Builder)localObject1).setOnlyAlertOnce(bool);
      if ((localNotification.flags & 0x10) == 0) {
        break label438;
      }
      bool = true;
      localObject1 = ((Notification.Builder)localObject1).setAutoCancel(bool).setDefaults(localNotification.defaults).setContentTitle(paramd.bop).setContentText(paramd.boq).setContentInfo(paramd.bov).setContentIntent(paramd.bor).setDeleteIntent(localNotification.deleteIntent);
      localObject2 = paramd.bos;
      if ((localNotification.flags & 0x80) == 0) {
        break label443;
      }
    }
    label428:
    label433:
    label438:
    label443:
    for (boolean bool = true;; bool = false)
    {
      ((Notification.Builder)localObject1).setFullScreenIntent((PendingIntent)localObject2, bool).setLargeIcon(paramd.bou).setNumber(paramd.bow).setProgress(paramd.boD, paramd.boE, paramd.boF);
      if (Build.VERSION.SDK_INT < 21) {
        this.bpo.setSound(localNotification.sound, localNotification.audioStreamType);
      }
      if (Build.VERSION.SDK_INT < 16) {
        break label568;
      }
      this.bpo.setSubText(paramd.boA).setUsesChronometer(paramd.boy).setPriority(paramd.mPriority);
      localObject1 = paramd.bom.iterator();
      while (((Iterator)localObject1).hasNext()) {
        b((f.a)((Iterator)localObject1).next());
      }
      this.bpo = new Notification.Builder(paramd.mContext);
      break;
      bool = false;
      break label162;
      bool = false;
      break label183;
      bool = false;
      break label204;
    }
    if (paramd.mExtras != null) {
      this.mExtras.putAll(paramd.mExtras);
    }
    if (Build.VERSION.SDK_INT < 20)
    {
      if (paramd.boJ) {
        this.mExtras.putBoolean("android.support.localOnly", true);
      }
      if (paramd.boG != null)
      {
        this.mExtras.putString("android.support.groupKey", paramd.boG);
        if (!paramd.boH) {
          break label851;
        }
        this.mExtras.putBoolean("android.support.isGroupSummary", true);
      }
      if (paramd.boI != null) {
        this.mExtras.putString("android.support.sortKey", paramd.boI);
      }
    }
    this.boO = paramd.boO;
    this.boP = paramd.boP;
    label568:
    if (Build.VERSION.SDK_INT >= 17) {
      this.bpo.setShowWhen(paramd.box);
    }
    if ((Build.VERSION.SDK_INT >= 19) && (Build.VERSION.SDK_INT < 21))
    {
      localObject1 = f(V(paramd.bon), paramd.bpa);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        this.mExtras.putStringArray("android.people", (String[])((List)localObject1).toArray(new String[((List)localObject1).size()]));
      }
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      this.bpo.setLocalOnly(paramd.boJ).setGroup(paramd.boG).setGroupSummary(paramd.boH).setSortKey(paramd.boI);
      this.boU = paramd.boU;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.bpo.setCategory(paramd.boM).setColor(paramd.mColor).setVisibility(paramd.bje).setPublicVersion(paramd.boN).setSound(localNotification.sound, localNotification.audioAttributes);
      if (Build.VERSION.SDK_INT < 28) {}
      for (localObject1 = f(V(paramd.bon), paramd.bpa);; localObject1 = paramd.bpa)
      {
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break label874;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.bpo.addPerson((String)localObject2);
        }
        label851:
        this.mExtras.putBoolean("android.support.useSideChannel", true);
        break;
      }
      label874:
      this.boQ = paramd.boQ;
      if (paramd.boo.size() > 0)
      {
        localObject1 = paramd.getExtras().getBundle("android.car.EXTENSIONS");
        if (localObject1 != null) {
          break label1521;
        }
        localObject1 = new Bundle();
      }
    }
    label1513:
    label1521:
    for (;;)
    {
      localObject2 = new Bundle((Bundle)localObject1);
      Bundle localBundle = new Bundle();
      int i = 0;
      while (i < paramd.boo.size())
      {
        localBundle.putBundle(Integer.toString(i), h.c((f.a)paramd.boo.get(i)));
        i += 1;
      }
      ((Bundle)localObject1).putBundle("invisible_actions", localBundle);
      ((Bundle)localObject2).putBundle("invisible_actions", localBundle);
      paramd.getExtras().putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
      this.mExtras.putBundle("android.car.EXTENSIONS", (Bundle)localObject2);
      if ((Build.VERSION.SDK_INT >= 23) && (paramd.boZ != null)) {
        this.bpo.setSmallIcon(paramd.boZ);
      }
      if (Build.VERSION.SDK_INT >= 24)
      {
        this.bpo.setExtras(paramd.mExtras).setRemoteInputHistory(paramd.boC);
        if (paramd.boO != null) {
          this.bpo.setCustomContentView(paramd.boO);
        }
        if (paramd.boP != null) {
          this.bpo.setCustomBigContentView(paramd.boP);
        }
        if (paramd.boQ != null) {
          this.bpo.setCustomHeadsUpContentView(paramd.boQ);
        }
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        this.bpo.setBadgeIconType(paramd.boR).setSettingsText(paramd.boB).setShortcutId(paramd.boS).setTimeoutAfter(paramd.mTimeout).setGroupAlertBehavior(paramd.boU);
        if (paramd.boL) {
          this.bpo.setColorized(paramd.boK);
        }
        if (!TextUtils.isEmpty(paramd.mChannelId)) {
          this.bpo.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
      }
      if (Build.VERSION.SDK_INT >= 28)
      {
        localObject1 = paramd.bon.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          ((Iterator)localObject1).next();
          new Person.Builder();
          AppMethodBeat.o(196386);
          throw null;
        }
      }
      if (Build.VERSION.SDK_INT >= 29)
      {
        this.bpo.setAllowSystemGeneratedContextualActions(paramd.boV);
        localObject2 = this.bpo;
        localObject1 = paramd.boW;
        if (localObject1 != null) {
          if (Build.VERSION.SDK_INT >= 30) {
            localObject1 = f.c.b.a((f.c)localObject1);
          }
        }
        for (;;)
        {
          ((Notification.Builder)localObject2).setBubbleMetadata((Notification.BubbleMetadata)localObject1);
          if (paramd.boT == null) {
            break;
          }
          AppMethodBeat.o(196386);
          throw null;
          if (Build.VERSION.SDK_INT == 29) {
            localObject1 = f.c.a.a((f.c)localObject1);
          } else {
            localObject1 = null;
          }
        }
      }
      if (paramd.boY) {
        if (!this.bpp.boH) {
          break label1513;
        }
      }
      for (this.boU = 2;; this.boU = 1)
      {
        this.bpo.setVibrate(null);
        this.bpo.setSound(null);
        localNotification.defaults &= 0xFFFFFFFE;
        localNotification.defaults &= 0xFFFFFFFD;
        this.bpo.setDefaults(localNotification.defaults);
        if (Build.VERSION.SDK_INT >= 26)
        {
          if (TextUtils.isEmpty(this.bpp.boG)) {
            this.bpo.setGroup("silent");
          }
          this.bpo.setGroupAlertBehavior(this.boU);
        }
        AppMethodBeat.o(196386);
        return;
      }
    }
  }
  
  private static List<String> V(List<Object> paramList)
  {
    AppMethodBeat.i(196409);
    if (paramList == null)
    {
      AppMethodBeat.o(196409);
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      paramList.next();
      AppMethodBeat.o(196409);
      throw null;
    }
    AppMethodBeat.o(196409);
    return localArrayList;
  }
  
  static void b(Notification paramNotification)
  {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    paramNotification.defaults &= 0xFFFFFFFE;
    paramNotification.defaults &= 0xFFFFFFFD;
  }
  
  private void b(f.a parama)
  {
    int j = 0;
    AppMethodBeat.i(196427);
    if (Build.VERSION.SDK_INT >= 20)
    {
      IconCompat localIconCompat = parama.Dw();
      Object localObject1;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (localIconCompat != null) {
          switch (localIconCompat.mType)
          {
          case 0: 
          default: 
            parama = new IllegalArgumentException("Unknown type");
            AppMethodBeat.o(196427);
            throw parama;
          case -1: 
            localObject2 = (Icon)localIconCompat.bqU;
          }
        }
        for (;;)
        {
          localObject1 = new Notification.Action.Builder((Icon)localObject2, parama.title, parama.boi);
          if (parama.boc == null) {
            break;
          }
          localObject2 = j.b(parama.boc);
          int k = localObject2.length;
          i = j;
          while (i < k)
          {
            ((Notification.Action.Builder)localObject1).addRemoteInput(localObject2[i]);
            i += 1;
          }
          localObject1 = Icon.createWithBitmap((Bitmap)localIconCompat.bqU);
          for (;;)
          {
            if (localIconCompat.kz != null) {
              ((Icon)localObject1).setTintList(localIconCompat.kz);
            }
            localObject2 = localObject1;
            if (localIconCompat.kA == IconCompat.bqY) {
              break;
            }
            ((Icon)localObject1).setTintMode(localIconCompat.kA);
            localObject2 = localObject1;
            break;
            if (Build.VERSION.SDK_INT >= 26)
            {
              localObject1 = Icon.createWithAdaptiveBitmap((Bitmap)localIconCompat.bqU);
            }
            else
            {
              localObject1 = Icon.createWithBitmap(IconCompat.k((Bitmap)localIconCompat.bqU));
              continue;
              if ((localIconCompat.mType == -1) && (Build.VERSION.SDK_INT >= 23)) {
                localObject1 = IconCompat.b((Icon)localIconCompat.bqU);
              }
              for (;;)
              {
                localObject1 = Icon.createWithResource((String)localObject1, localIconCompat.bqW);
                break;
                if (localIconCompat.mType != 2)
                {
                  parama = new IllegalStateException("called getResPackage() on ".concat(String.valueOf(localIconCompat)));
                  AppMethodBeat.o(196427);
                  throw parama;
                }
                if (TextUtils.isEmpty(localIconCompat.bra)) {
                  localObject1 = ((String)localIconCompat.bqU).split(":", -1)[0];
                } else {
                  localObject1 = localIconCompat.bra;
                }
              }
              localObject1 = Icon.createWithData((byte[])localIconCompat.bqU, localIconCompat.bqW, localIconCompat.bqX);
              continue;
              localObject1 = Icon.createWithContentUri((String)localIconCompat.bqU);
              continue;
              if (Build.VERSION.SDK_INT < 30) {
                break label477;
              }
              localObject1 = Icon.createWithAdaptiveBitmapContentUri(localIconCompat.getUri());
            }
          }
          label477:
          parama = new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + localIconCompat.getUri());
          AppMethodBeat.o(196427);
          throw parama;
          localObject2 = null;
        }
      }
      if (localIconCompat != null) {}
      for (int i = localIconCompat.getResId();; i = 0)
      {
        localObject1 = new Notification.Action.Builder(i, parama.title, parama.boi);
        break;
      }
      if (parama.mExtras != null) {}
      for (Object localObject2 = new Bundle(parama.mExtras);; localObject2 = new Bundle())
      {
        ((Bundle)localObject2).putBoolean("android.support.allowGeneratedReplies", parama.boe);
        if (Build.VERSION.SDK_INT >= 24) {
          ((Notification.Action.Builder)localObject1).setAllowGeneratedReplies(parama.boe);
        }
        ((Bundle)localObject2).putInt("android.support.action.semanticAction", parama.bog);
        if (Build.VERSION.SDK_INT >= 28) {
          ((Notification.Action.Builder)localObject1).setSemanticAction(parama.bog);
        }
        if (Build.VERSION.SDK_INT >= 29) {
          ((Notification.Action.Builder)localObject1).setContextual(parama.boh);
        }
        ((Bundle)localObject2).putBoolean("android.support.action.showsUserInterface", parama.bof);
        ((Notification.Action.Builder)localObject1).addExtras((Bundle)localObject2);
        this.bpo.addAction(((Notification.Action.Builder)localObject1).build());
        AppMethodBeat.o(196427);
        return;
      }
    }
    if (Build.VERSION.SDK_INT >= 16) {
      this.bpq.add(h.a(this.bpo, parama));
    }
    AppMethodBeat.o(196427);
  }
  
  private static List<String> f(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(196398);
    if (paramList1 == null)
    {
      AppMethodBeat.o(196398);
      return paramList2;
    }
    if (paramList2 == null)
    {
      AppMethodBeat.o(196398);
      return paramList1;
    }
    b localb = new b(paramList1.size() + paramList2.size());
    localb.addAll(paramList1);
    localb.addAll(paramList2);
    paramList1 = new ArrayList(localb);
    AppMethodBeat.o(196398);
    return paramList1;
  }
  
  public final Notification.Builder Dv()
  {
    return this.bpo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.core.app.g
 * JD-Core Version:    0.7.0.1
 */