package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public final class s
{
  public static Bundle a(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return u.a(paramNotification);
    }
    return null;
  }
  
  public static final class a
  {
    final x[] GX;
    final x[] GY;
    boolean GZ;
    boolean Ha = true;
    final int Hb;
    public PendingIntent actionIntent;
    public int icon;
    final Bundle mExtras;
    public CharSequence title;
    
    public a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this(paramInt, paramCharSequence, paramPendingIntent, new Bundle(), null, null, true, 0, true);
    }
    
    a(int paramInt1, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, x[] paramArrayOfx1, x[] paramArrayOfx2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
    {
      this.icon = paramInt1;
      this.title = s.c.j(paramCharSequence);
      this.actionIntent = paramPendingIntent;
      if (paramBundle != null) {}
      for (;;)
      {
        this.mExtras = paramBundle;
        this.GX = paramArrayOfx1;
        this.GY = paramArrayOfx2;
        this.GZ = paramBoolean1;
        this.Hb = paramInt2;
        this.Ha = paramBoolean2;
        return;
        paramBundle = new Bundle();
      }
    }
  }
  
  public static final class b
    extends s.f
  {
    private CharSequence Hg;
    
    public b() {}
    
    public b(s.c paramc)
    {
      b(paramc);
    }
    
    public final void a(r paramr)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramr = new Notification.BigTextStyle(paramr.en()).setBigContentTitle(this.HZ).bigText(this.Hg);
        if (this.Ib) {
          paramr.setSummaryText(this.Ia);
        }
      }
    }
    
    public final b e(CharSequence paramCharSequence)
    {
      this.Hg = s.c.j(paramCharSequence);
      return this;
    }
  }
  
  public static final class c
  {
    boolean HA;
    String HB;
    public boolean HC = false;
    boolean HD;
    boolean HE;
    public String HF;
    Notification HG;
    RemoteViews HH;
    RemoteViews HI;
    RemoteViews HJ;
    int HK = 0;
    String HL;
    int HM = 0;
    public Notification HN = new Notification();
    @Deprecated
    public ArrayList<String> HO;
    public ArrayList<s.a> Hh = new ArrayList();
    ArrayList<s.a> Hi = new ArrayList();
    CharSequence Hj;
    CharSequence Hk;
    public PendingIntent Hl;
    PendingIntent Hm;
    RemoteViews Hn;
    Bitmap Ho;
    CharSequence Hp;
    int Hq;
    boolean Hr = true;
    boolean Hs;
    s.f Ht;
    CharSequence Hu;
    CharSequence[] Hv;
    int Hw;
    int Hx;
    boolean Hy;
    String Hz;
    public String mChannelId;
    public int mColor = 0;
    public Context mContext;
    Bundle mExtras;
    int mPriority;
    long mTimeout;
    int mVisibility = 0;
    
    @Deprecated
    public c(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public c(Context paramContext, String paramString)
    {
      this.mContext = paramContext;
      this.mChannelId = paramString;
      this.HN.when = System.currentTimeMillis();
      this.HN.audioStreamType = -1;
      this.mPriority = 0;
      this.HO = new ArrayList();
    }
    
    protected static CharSequence j(CharSequence paramCharSequence)
    {
      if (paramCharSequence == null) {}
      while (paramCharSequence.length() <= 5120) {
        return paramCharSequence;
      }
      return paramCharSequence.subSequence(0, 5120);
    }
    
    public final c F(boolean paramBoolean)
    {
      f(16, paramBoolean);
      return this;
    }
    
    public final c a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this.Hh.add(new s.a(paramInt, paramCharSequence, paramPendingIntent));
      return this;
    }
    
    public final c a(PendingIntent paramPendingIntent)
    {
      this.Hl = paramPendingIntent;
      return this;
    }
    
    public final c a(s.a parama)
    {
      this.Hh.add(parama);
      return this;
    }
    
    public final c a(s.f paramf)
    {
      if (this.Ht != paramf)
      {
        this.Ht = paramf;
        if (this.Ht != null) {
          this.Ht.b(this);
        }
      }
      return this;
    }
    
    public final c a(RemoteViews paramRemoteViews)
    {
      this.HN.contentView = paramRemoteViews;
      return this;
    }
    
    public final c as(int paramInt)
    {
      this.HN.icon = paramInt;
      return this;
    }
    
    public final c b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.Hw = paramInt1;
      this.Hx = paramInt2;
      this.Hy = paramBoolean;
      return this;
    }
    
    public final c b(PendingIntent paramPendingIntent)
    {
      this.HN.deleteIntent = paramPendingIntent;
      return this;
    }
    
    public final c b(Bitmap paramBitmap)
    {
      Object localObject = paramBitmap;
      if (paramBitmap != null)
      {
        if (Build.VERSION.SDK_INT < 27) {
          break label26;
        }
        localObject = paramBitmap;
      }
      for (;;)
      {
        this.Ho = ((Bitmap)localObject);
        return this;
        label26:
        localObject = this.mContext.getResources();
        int i = ((Resources)localObject).getDimensionPixelSize(2131166071);
        int j = ((Resources)localObject).getDimensionPixelSize(2131166070);
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
    
    public final c b(Uri paramUri)
    {
      this.HN.sound = paramUri;
      this.HN.audioStreamType = -1;
      if (Build.VERSION.SDK_INT >= 21) {
        this.HN.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
      }
      return this;
    }
    
    public final c b(RemoteViews paramRemoteViews)
    {
      this.HH = paramRemoteViews;
      return this;
    }
    
    public final Notification build()
    {
      t localt = new t(this);
      s.f localf = localt.Ic.Ht;
      if (localf != null) {
        localf.a(localt);
      }
      Object localObject1;
      if (Build.VERSION.SDK_INT >= 26) {
        localObject1 = localt.mBuilder.build();
      }
      for (;;)
      {
        if (localt.Ic.HH != null) {
          ((Notification)localObject1).contentView = localt.Ic.HH;
        }
        int i = Build.VERSION.SDK_INT;
        i = Build.VERSION.SDK_INT;
        if ((Build.VERSION.SDK_INT >= 16) && (localf != null)) {
          s.a((Notification)localObject1);
        }
        return localObject1;
        Object localObject2;
        if (Build.VERSION.SDK_INT >= 24)
        {
          localObject2 = localt.mBuilder.build();
          localObject1 = localObject2;
          if (localt.HM != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localt.HM == 2)) {
              t.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localt.HM == 1)
                {
                  t.b((Notification)localObject2);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 21)
        {
          localt.mBuilder.setExtras(localt.mExtras);
          localObject2 = localt.mBuilder.build();
          if (localt.HH != null) {
            ((Notification)localObject2).contentView = localt.HH;
          }
          if (localt.HI != null) {
            ((Notification)localObject2).bigContentView = localt.HI;
          }
          if (localt.HJ != null) {
            ((Notification)localObject2).headsUpContentView = localt.HJ;
          }
          localObject1 = localObject2;
          if (localt.HM != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localt.HM == 2)) {
              t.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localt.HM == 1)
                {
                  t.b((Notification)localObject2);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 20)
        {
          localt.mBuilder.setExtras(localt.mExtras);
          localObject2 = localt.mBuilder.build();
          if (localt.HH != null) {
            ((Notification)localObject2).contentView = localt.HH;
          }
          if (localt.HI != null) {
            ((Notification)localObject2).bigContentView = localt.HI;
          }
          localObject1 = localObject2;
          if (localt.HM != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localt.HM == 2)) {
              t.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localt.HM == 1)
                {
                  t.b((Notification)localObject2);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 19)
        {
          localObject1 = u.h(localt.Ie);
          if (localObject1 != null) {
            localt.mExtras.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject1);
          }
          localt.mBuilder.setExtras(localt.mExtras);
          localObject2 = localt.mBuilder.build();
          if (localt.HH != null) {
            ((Notification)localObject2).contentView = localt.HH;
          }
          localObject1 = localObject2;
          if (localt.HI != null)
          {
            ((Notification)localObject2).bigContentView = localt.HI;
            localObject1 = localObject2;
          }
        }
        else if (Build.VERSION.SDK_INT >= 16)
        {
          localObject1 = localt.mBuilder.build();
          localObject2 = s.a((Notification)localObject1);
          Bundle localBundle = new Bundle(localt.mExtras);
          Iterator localIterator = localt.mExtras.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (((Bundle)localObject2).containsKey(str)) {
              localBundle.remove(str);
            }
          }
          ((Bundle)localObject2).putAll(localBundle);
          localObject2 = u.h(localt.Ie);
          if (localObject2 != null) {
            s.a((Notification)localObject1).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject2);
          }
          if (localt.HH != null) {
            ((Notification)localObject1).contentView = localt.HH;
          }
          if (localt.HI != null) {
            ((Notification)localObject1).bigContentView = localt.HI;
          }
        }
        else
        {
          localObject1 = localt.mBuilder.getNotification();
        }
      }
    }
    
    public final c c(PendingIntent paramPendingIntent)
    {
      this.Hm = paramPendingIntent;
      f(128, true);
      return this;
    }
    
    public final c c(RemoteViews paramRemoteViews)
    {
      this.HI = paramRemoteViews;
      return this;
    }
    
    public final c d(RemoteViews paramRemoteViews)
    {
      this.HJ = paramRemoteViews;
      return this;
    }
    
    public final c ep()
    {
      f(2, true);
      return this;
    }
    
    public final c eq()
    {
      this.mPriority = 1;
      return this;
    }
    
    public final c f(CharSequence paramCharSequence)
    {
      this.Hj = j(paramCharSequence);
      return this;
    }
    
    public final void f(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        localNotification = this.HN;
        localNotification.flags |= paramInt;
        return;
      }
      Notification localNotification = this.HN;
      localNotification.flags &= (paramInt ^ 0xFFFFFFFF);
    }
    
    public final c g(CharSequence paramCharSequence)
    {
      this.Hk = j(paramCharSequence);
      return this;
    }
    
    public final Bundle getExtras()
    {
      if (this.mExtras == null) {
        this.mExtras = new Bundle();
      }
      return this.mExtras;
    }
    
    public final c h(CharSequence paramCharSequence)
    {
      this.Hu = j(paramCharSequence);
      return this;
    }
    
    public final c i(long paramLong)
    {
      this.HN.when = paramLong;
      return this;
    }
    
    public final c i(CharSequence paramCharSequence)
    {
      this.HN.tickerText = j(paramCharSequence);
      return this;
    }
    
    public final c t(String paramString)
    {
      this.HF = paramString;
      return this;
    }
  }
  
  public static abstract class f
  {
    protected s.c HY;
    CharSequence HZ;
    CharSequence Ia;
    boolean Ib = false;
    
    public void a(r paramr) {}
    
    public final void b(s.c paramc)
    {
      if (this.HY != paramc)
      {
        this.HY = paramc;
        if (this.HY != null) {
          this.HY.a(this);
        }
      }
    }
    
    public final Notification build()
    {
      Notification localNotification = null;
      if (this.HY != null) {
        localNotification = this.HY.build();
      }
      return localNotification;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.s
 * JD-Core Version:    0.7.0.1
 */