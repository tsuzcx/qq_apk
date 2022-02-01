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
    final x[] Hh;
    final x[] Hi;
    boolean Hj;
    boolean Hk = true;
    final int Hl;
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
        this.Hh = paramArrayOfx1;
        this.Hi = paramArrayOfx2;
        this.Hj = paramBoolean1;
        this.Hl = paramInt2;
        this.Hk = paramBoolean2;
        return;
        paramBundle = new Bundle();
      }
    }
  }
  
  public static final class b
    extends s.f
  {
    private CharSequence Hq;
    
    public b() {}
    
    public b(s.c paramc)
    {
      b(paramc);
    }
    
    public final void a(r paramr)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramr = new Notification.BigTextStyle(paramr.er()).setBigContentTitle(this.Ik).bigText(this.Hq);
        if (this.Im) {
          paramr.setSummaryText(this.Il);
        }
      }
    }
    
    public final b e(CharSequence paramCharSequence)
    {
      this.Hq = s.c.j(paramCharSequence);
      return this;
    }
  }
  
  public static final class c
  {
    int HA;
    boolean HB = true;
    boolean HC;
    s.f HD;
    CharSequence HE;
    CharSequence[] HF;
    int HG;
    int HH;
    boolean HI;
    String HJ;
    boolean HK;
    String HL;
    public boolean HM = false;
    boolean HN;
    boolean HO;
    public String HP;
    Notification HQ;
    RemoteViews HR;
    RemoteViews HS;
    RemoteViews HT;
    int HU = 0;
    String HV;
    int HW = 0;
    public Notification HX = new Notification();
    @Deprecated
    public ArrayList<String> HY;
    public ArrayList<s.a> Hr = new ArrayList();
    ArrayList<s.a> Hs = new ArrayList();
    CharSequence Ht;
    CharSequence Hu;
    public PendingIntent Hv;
    PendingIntent Hw;
    RemoteViews Hx;
    Bitmap Hy;
    CharSequence Hz;
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
      this.HX.when = System.currentTimeMillis();
      this.HX.audioStreamType = -1;
      this.mPriority = 0;
      this.HY = new ArrayList();
    }
    
    protected static CharSequence j(CharSequence paramCharSequence)
    {
      if (paramCharSequence == null) {}
      while (paramCharSequence.length() <= 5120) {
        return paramCharSequence;
      }
      return paramCharSequence.subSequence(0, 5120);
    }
    
    public final c E(boolean paramBoolean)
    {
      g(16, paramBoolean);
      return this;
    }
    
    public final c a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this.Hr.add(new s.a(paramInt, paramCharSequence, paramPendingIntent));
      return this;
    }
    
    public final c a(PendingIntent paramPendingIntent)
    {
      this.Hv = paramPendingIntent;
      return this;
    }
    
    public final c a(s.a parama)
    {
      this.Hr.add(parama);
      return this;
    }
    
    public final c a(s.f paramf)
    {
      if (this.HD != paramf)
      {
        this.HD = paramf;
        if (this.HD != null) {
          this.HD.b(this);
        }
      }
      return this;
    }
    
    public final c a(RemoteViews paramRemoteViews)
    {
      this.HX.contentView = paramRemoteViews;
      return this;
    }
    
    public final c as(int paramInt)
    {
      this.HX.icon = paramInt;
      return this;
    }
    
    public final c b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.HG = paramInt1;
      this.HH = paramInt2;
      this.HI = paramBoolean;
      return this;
    }
    
    public final c b(PendingIntent paramPendingIntent)
    {
      this.HX.deleteIntent = paramPendingIntent;
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
        this.Hy = ((Bitmap)localObject);
        return this;
        label26:
        localObject = this.mContext.getResources();
        int i = ((Resources)localObject).getDimensionPixelSize(2131166111);
        int j = ((Resources)localObject).getDimensionPixelSize(2131166110);
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
      this.HX.sound = paramUri;
      this.HX.audioStreamType = -1;
      if (Build.VERSION.SDK_INT >= 21) {
        this.HX.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
      }
      return this;
    }
    
    public final c b(RemoteViews paramRemoteViews)
    {
      this.HR = paramRemoteViews;
      return this;
    }
    
    public final Notification build()
    {
      t localt = new t(this);
      s.f localf = localt.In.HD;
      if (localf != null) {
        localf.a(localt);
      }
      Object localObject1;
      if (Build.VERSION.SDK_INT >= 26) {
        localObject1 = localt.mBuilder.build();
      }
      for (;;)
      {
        if (localt.In.HR != null) {
          ((Notification)localObject1).contentView = localt.In.HR;
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
          if (localt.HW != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localt.HW == 2)) {
              t.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localt.HW == 1)
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
          if (localt.HR != null) {
            ((Notification)localObject2).contentView = localt.HR;
          }
          if (localt.HS != null) {
            ((Notification)localObject2).bigContentView = localt.HS;
          }
          if (localt.HT != null) {
            ((Notification)localObject2).headsUpContentView = localt.HT;
          }
          localObject1 = localObject2;
          if (localt.HW != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localt.HW == 2)) {
              t.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localt.HW == 1)
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
          if (localt.HR != null) {
            ((Notification)localObject2).contentView = localt.HR;
          }
          if (localt.HS != null) {
            ((Notification)localObject2).bigContentView = localt.HS;
          }
          localObject1 = localObject2;
          if (localt.HW != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localt.HW == 2)) {
              t.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localt.HW == 1)
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
          localObject1 = u.h(localt.Io);
          if (localObject1 != null) {
            localt.mExtras.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject1);
          }
          localt.mBuilder.setExtras(localt.mExtras);
          localObject2 = localt.mBuilder.build();
          if (localt.HR != null) {
            ((Notification)localObject2).contentView = localt.HR;
          }
          localObject1 = localObject2;
          if (localt.HS != null)
          {
            ((Notification)localObject2).bigContentView = localt.HS;
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
          localObject2 = u.h(localt.Io);
          if (localObject2 != null) {
            s.a((Notification)localObject1).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject2);
          }
          if (localt.HR != null) {
            ((Notification)localObject1).contentView = localt.HR;
          }
          if (localt.HS != null) {
            ((Notification)localObject1).bigContentView = localt.HS;
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
      this.Hw = paramPendingIntent;
      g(128, true);
      return this;
    }
    
    public final c c(RemoteViews paramRemoteViews)
    {
      this.HS = paramRemoteViews;
      return this;
    }
    
    public final c d(RemoteViews paramRemoteViews)
    {
      this.HT = paramRemoteViews;
      return this;
    }
    
    public final c et()
    {
      g(2, true);
      return this;
    }
    
    public final c eu()
    {
      this.mPriority = 1;
      return this;
    }
    
    public final c f(CharSequence paramCharSequence)
    {
      this.Ht = j(paramCharSequence);
      return this;
    }
    
    public final c g(CharSequence paramCharSequence)
    {
      this.Hu = j(paramCharSequence);
      return this;
    }
    
    public final void g(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        localNotification = this.HX;
        localNotification.flags |= paramInt;
        return;
      }
      Notification localNotification = this.HX;
      localNotification.flags &= (paramInt ^ 0xFFFFFFFF);
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
      this.HE = j(paramCharSequence);
      return this;
    }
    
    public final c i(long paramLong)
    {
      this.HX.when = paramLong;
      return this;
    }
    
    public final c i(CharSequence paramCharSequence)
    {
      this.HX.tickerText = j(paramCharSequence);
      return this;
    }
    
    public final c u(String paramString)
    {
      this.HP = paramString;
      return this;
    }
  }
  
  public static abstract class f
  {
    protected s.c Ij;
    CharSequence Ik;
    CharSequence Il;
    boolean Im = false;
    
    public void a(r paramr) {}
    
    public final void b(s.c paramc)
    {
      if (this.Ij != paramc)
      {
        this.Ij = paramc;
        if (this.Ij != null) {
          this.Ij.a(this);
        }
      }
    }
    
    public final Notification build()
    {
      Notification localNotification = null;
      if (this.Ij != null) {
        localNotification = this.Ij.build();
      }
      return localNotification;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.s
 * JD-Core Version:    0.7.0.1
 */