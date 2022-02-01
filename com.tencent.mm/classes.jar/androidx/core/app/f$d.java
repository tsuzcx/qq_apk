package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.a.b;
import androidx.core.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public final class f$d
{
  int bje;
  CharSequence boA;
  CharSequence boB;
  CharSequence[] boC;
  int boD;
  int boE;
  boolean boF;
  String boG;
  boolean boH;
  String boI;
  public boolean boJ;
  boolean boK;
  boolean boL;
  public String boM;
  Notification boN;
  public RemoteViews boO;
  public RemoteViews boP;
  public RemoteViews boQ;
  int boR;
  String boS;
  b boT;
  int boU;
  boolean boV;
  f.c boW;
  public Notification boX;
  boolean boY;
  Icon boZ;
  public ArrayList<f.a> bom;
  public ArrayList<Object> bon;
  ArrayList<f.a> boo;
  CharSequence bop;
  CharSequence boq;
  public PendingIntent bor;
  PendingIntent bos;
  RemoteViews bot;
  Bitmap bou;
  CharSequence bov;
  int bow;
  boolean box;
  boolean boy;
  f.g boz;
  @Deprecated
  public ArrayList<String> bpa;
  String mChannelId;
  int mColor;
  public Context mContext;
  Bundle mExtras;
  public int mPriority;
  long mTimeout;
  
  @Deprecated
  public f$d(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public f$d(Context paramContext, String paramString)
  {
    AppMethodBeat.i(196452);
    this.bom = new ArrayList();
    this.bon = new ArrayList();
    this.boo = new ArrayList();
    this.box = true;
    this.boJ = false;
    this.mColor = 0;
    this.bje = 0;
    this.boR = 0;
    this.boU = 0;
    this.boX = new Notification();
    this.mContext = paramContext;
    this.mChannelId = paramString;
    this.boX.when = System.currentTimeMillis();
    this.boX.audioStreamType = -1;
    this.mPriority = 0;
    this.bpa = new ArrayList();
    this.boV = true;
    AppMethodBeat.o(196452);
  }
  
  protected static CharSequence p(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196469);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(196469);
      return paramCharSequence;
    }
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence.length() > 5120) {
      localCharSequence = paramCharSequence.subSequence(0, 5120);
    }
    AppMethodBeat.o(196469);
    return localCharSequence;
  }
  
  public final Notification DA()
  {
    AppMethodBeat.i(196632);
    g localg1 = new g(this);
    f.g localg = localg1.bpp.boz;
    if (localg != null) {
      localg.a(localg1);
    }
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 26) {
      localObject1 = localg1.bpo.build();
    }
    for (;;)
    {
      if (localg1.bpp.boO != null) {
        ((Notification)localObject1).contentView = localg1.bpp.boO;
      }
      int i = Build.VERSION.SDK_INT;
      i = Build.VERSION.SDK_INT;
      Object localObject2;
      if ((Build.VERSION.SDK_INT >= 16) && (localg != null))
      {
        localObject2 = f.a((Notification)localObject1);
        if (localObject2 != null) {
          localg.k((Bundle)localObject2);
        }
      }
      AppMethodBeat.o(196632);
      return localObject1;
      if (Build.VERSION.SDK_INT >= 24)
      {
        localObject2 = localg1.bpo.build();
        localObject1 = localObject2;
        if (localg1.boU != 0)
        {
          if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localg1.boU == 2)) {
            g.b((Notification)localObject2);
          }
          localObject1 = localObject2;
          if (((Notification)localObject2).getGroup() != null)
          {
            localObject1 = localObject2;
            if ((((Notification)localObject2).flags & 0x200) == 0)
            {
              localObject1 = localObject2;
              if (localg1.boU == 1)
              {
                g.b((Notification)localObject2);
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      else if (Build.VERSION.SDK_INT >= 21)
      {
        localg1.bpo.setExtras(localg1.mExtras);
        localObject2 = localg1.bpo.build();
        if (localg1.boO != null) {
          ((Notification)localObject2).contentView = localg1.boO;
        }
        if (localg1.boP != null) {
          ((Notification)localObject2).bigContentView = localg1.boP;
        }
        if (localg1.boQ != null) {
          ((Notification)localObject2).headsUpContentView = localg1.boQ;
        }
        localObject1 = localObject2;
        if (localg1.boU != 0)
        {
          if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localg1.boU == 2)) {
            g.b((Notification)localObject2);
          }
          localObject1 = localObject2;
          if (((Notification)localObject2).getGroup() != null)
          {
            localObject1 = localObject2;
            if ((((Notification)localObject2).flags & 0x200) == 0)
            {
              localObject1 = localObject2;
              if (localg1.boU == 1)
              {
                g.b((Notification)localObject2);
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      else if (Build.VERSION.SDK_INT >= 20)
      {
        localg1.bpo.setExtras(localg1.mExtras);
        localObject2 = localg1.bpo.build();
        if (localg1.boO != null) {
          ((Notification)localObject2).contentView = localg1.boO;
        }
        if (localg1.boP != null) {
          ((Notification)localObject2).bigContentView = localg1.boP;
        }
        localObject1 = localObject2;
        if (localg1.boU != 0)
        {
          if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localg1.boU == 2)) {
            g.b((Notification)localObject2);
          }
          localObject1 = localObject2;
          if (((Notification)localObject2).getGroup() != null)
          {
            localObject1 = localObject2;
            if ((((Notification)localObject2).flags & 0x200) == 0)
            {
              localObject1 = localObject2;
              if (localg1.boU == 1)
              {
                g.b((Notification)localObject2);
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      else if (Build.VERSION.SDK_INT >= 19)
      {
        localObject1 = h.W(localg1.bpq);
        if (localObject1 != null) {
          localg1.mExtras.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject1);
        }
        localg1.bpo.setExtras(localg1.mExtras);
        localObject2 = localg1.bpo.build();
        if (localg1.boO != null) {
          ((Notification)localObject2).contentView = localg1.boO;
        }
        localObject1 = localObject2;
        if (localg1.boP != null)
        {
          ((Notification)localObject2).bigContentView = localg1.boP;
          localObject1 = localObject2;
        }
      }
      else if (Build.VERSION.SDK_INT >= 16)
      {
        localObject1 = localg1.bpo.build();
        localObject2 = f.a((Notification)localObject1);
        Bundle localBundle = new Bundle(localg1.mExtras);
        Iterator localIterator = localg1.mExtras.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (((Bundle)localObject2).containsKey(str)) {
            localBundle.remove(str);
          }
        }
        ((Bundle)localObject2).putAll(localBundle);
        localObject2 = h.W(localg1.bpq);
        if (localObject2 != null) {
          f.a((Notification)localObject1).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject2);
        }
        if (localg1.boO != null) {
          ((Notification)localObject1).contentView = localg1.boO;
        }
        if (localg1.boP != null) {
          ((Notification)localObject1).bigContentView = localg1.boP;
        }
      }
      else
      {
        localObject1 = localg1.bpo.getNotification();
      }
    }
  }
  
  public final d Dz()
  {
    this.boJ = true;
    return this;
  }
  
  public final d a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(196598);
    this.bom.add(new f.a(paramInt, paramCharSequence, paramPendingIntent));
    AppMethodBeat.o(196598);
    return this;
  }
  
  public final d a(PendingIntent paramPendingIntent)
  {
    this.bor = paramPendingIntent;
    return this;
  }
  
  public final d a(RemoteViews paramRemoteViews)
  {
    this.boX.contentView = paramRemoteViews;
    return this;
  }
  
  public final d a(f.a parama)
  {
    AppMethodBeat.i(196603);
    if (parama != null) {
      this.bom.add(parama);
    }
    AppMethodBeat.o(196603);
    return this;
  }
  
  public final d a(f.g paramg)
  {
    AppMethodBeat.i(196609);
    if (this.boz != paramg)
    {
      this.boz = paramg;
      if (this.boz != null) {
        this.boz.b(this);
      }
    }
    AppMethodBeat.o(196609);
    return this;
  }
  
  public final d aC(boolean paramBoolean)
  {
    AppMethodBeat.i(196575);
    q(16, paramBoolean);
    AppMethodBeat.o(196575);
    return this;
  }
  
  public final d ar(String paramString)
  {
    this.mChannelId = paramString;
    return this;
  }
  
  public final d b(PendingIntent paramPendingIntent)
  {
    this.boX.deleteIntent = paramPendingIntent;
    return this;
  }
  
  public final d bt(long paramLong)
  {
    this.boX.when = paramLong;
    return this;
  }
  
  public final d c(PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(196538);
    this.bos = paramPendingIntent;
    q(128, true);
    AppMethodBeat.o(196538);
    return this;
  }
  
  public final d d(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.boD = paramInt1;
    this.boE = paramInt2;
    this.boF = paramBoolean;
    return this;
  }
  
  public final d d(Uri paramUri)
  {
    AppMethodBeat.i(196567);
    this.boX.sound = paramUri;
    this.boX.audioStreamType = -1;
    if (Build.VERSION.SDK_INT >= 21) {
      this.boX.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
    }
    AppMethodBeat.o(196567);
    return this;
  }
  
  public final d eb(int paramInt)
  {
    this.boX.icon = paramInt;
    return this;
  }
  
  public final d ec(int paramInt)
  {
    this.mColor = paramInt;
    return this;
  }
  
  public final Bundle getExtras()
  {
    AppMethodBeat.i(196592);
    if (this.mExtras == null) {
      this.mExtras = new Bundle();
    }
    Bundle localBundle = this.mExtras;
    AppMethodBeat.o(196592);
    return localBundle;
  }
  
  public final d i(Bitmap paramBitmap)
  {
    AppMethodBeat.i(196555);
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      if (Build.VERSION.SDK_INT < 27) {
        break label38;
      }
      localObject = paramBitmap;
    }
    for (;;)
    {
      this.bou = ((Bitmap)localObject);
      AppMethodBeat.o(196555);
      return this;
      label38:
      localObject = this.mContext.getResources();
      int i = ((Resources)localObject).getDimensionPixelSize(a.b.compat_notification_large_icon_max_width);
      int j = ((Resources)localObject).getDimensionPixelSize(a.b.compat_notification_large_icon_max_height);
      if (paramBitmap.getWidth() <= i)
      {
        localObject = paramBitmap;
        if (paramBitmap.getHeight() <= j) {}
      }
      else
      {
        double d = Math.min(i / Math.max(1, paramBitmap.getWidth()), j / Math.max(1, paramBitmap.getHeight()));
        localObject = Bitmap.createScaledBitmap(paramBitmap, (int)Math.ceil(paramBitmap.getWidth() * d), (int)Math.ceil(d * paramBitmap.getHeight()), true);
      }
    }
  }
  
  public final d l(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196488);
    this.bop = p(paramCharSequence);
    AppMethodBeat.o(196488);
    return this;
  }
  
  public final d m(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196495);
    this.boq = p(paramCharSequence);
    AppMethodBeat.o(196495);
    return this;
  }
  
  public final d n(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196502);
    this.boA = p(paramCharSequence);
    AppMethodBeat.o(196502);
    return this;
  }
  
  public final d o(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196542);
    this.boX.tickerText = p(paramCharSequence);
    AppMethodBeat.o(196542);
    return this;
  }
  
  public final void q(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localNotification = this.boX;
      localNotification.flags |= paramInt;
      return;
    }
    Notification localNotification = this.boX;
    localNotification.flags &= (paramInt ^ 0xFFFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.core.app.f.d
 * JD-Core Version:    0.7.0.1
 */