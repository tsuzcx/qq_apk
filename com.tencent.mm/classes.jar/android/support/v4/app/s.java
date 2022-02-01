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
    final x[] Ei;
    final x[] Ej;
    boolean Ek;
    boolean El = true;
    final int Em;
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
        this.Ei = paramArrayOfx1;
        this.Ej = paramArrayOfx2;
        this.Ek = paramBoolean1;
        this.Em = paramInt2;
        this.El = paramBoolean2;
        return;
        paramBundle = new Bundle();
      }
    }
  }
  
  public static final class b
    extends s.f
  {
    private CharSequence Er;
    
    public b() {}
    
    public b(s.c paramc)
    {
      b(paramc);
    }
    
    public final void a(r paramr)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramr = new Notification.BigTextStyle(paramr.dL()).setBigContentTitle(this.Fk).bigText(this.Er);
        if (this.Fm) {
          paramr.setSummaryText(this.Fl);
        }
      }
    }
    
    public final b e(CharSequence paramCharSequence)
    {
      this.Er = s.c.j(paramCharSequence);
      return this;
    }
  }
  
  public static final class c
  {
    CharSequence EA;
    int EB;
    boolean EC = true;
    boolean ED;
    s.f EE;
    CharSequence EF;
    CharSequence[] EG;
    int EH;
    int EI;
    boolean EJ;
    String EK;
    boolean EL;
    String EM;
    public boolean EN = false;
    boolean EO;
    boolean EP;
    public String EQ;
    Notification ER;
    RemoteViews ES;
    RemoteViews ET;
    RemoteViews EU;
    int EV = 0;
    String EW;
    int EX = 0;
    public Notification EY = new Notification();
    @Deprecated
    public ArrayList<String> EZ;
    public ArrayList<s.a> Es = new ArrayList();
    ArrayList<s.a> Et = new ArrayList();
    CharSequence Eu;
    CharSequence Ev;
    public PendingIntent Ew;
    PendingIntent Ex;
    RemoteViews Ey;
    Bitmap Ez;
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
      this.EY.when = System.currentTimeMillis();
      this.EY.audioStreamType = -1;
      this.mPriority = 0;
      this.EZ = new ArrayList();
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
      this.Es.add(new s.a(paramInt, paramCharSequence, paramPendingIntent));
      return this;
    }
    
    public final c a(PendingIntent paramPendingIntent)
    {
      this.Ew = paramPendingIntent;
      return this;
    }
    
    public final c a(s.a parama)
    {
      this.Es.add(parama);
      return this;
    }
    
    public final c a(s.f paramf)
    {
      if (this.EE != paramf)
      {
        this.EE = paramf;
        if (this.EE != null) {
          this.EE.b(this);
        }
      }
      return this;
    }
    
    public final c a(RemoteViews paramRemoteViews)
    {
      this.EY.contentView = paramRemoteViews;
      return this;
    }
    
    public final c as(int paramInt)
    {
      this.EY.icon = paramInt;
      return this;
    }
    
    public final c b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.EH = paramInt1;
      this.EI = paramInt2;
      this.EJ = paramBoolean;
      return this;
    }
    
    public final c b(PendingIntent paramPendingIntent)
    {
      this.EY.deleteIntent = paramPendingIntent;
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
        this.Ez = ((Bitmap)localObject);
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
      this.EY.sound = paramUri;
      this.EY.audioStreamType = -1;
      if (Build.VERSION.SDK_INT >= 21) {
        this.EY.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
      }
      return this;
    }
    
    public final c b(RemoteViews paramRemoteViews)
    {
      this.ES = paramRemoteViews;
      return this;
    }
    
    public final Notification build()
    {
      t localt = new t(this);
      s.f localf = localt.Fn.EE;
      if (localf != null) {
        localf.a(localt);
      }
      Object localObject1;
      if (Build.VERSION.SDK_INT >= 26) {
        localObject1 = localt.mBuilder.build();
      }
      for (;;)
      {
        if (localt.Fn.ES != null) {
          ((Notification)localObject1).contentView = localt.Fn.ES;
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
          if (localt.EX != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localt.EX == 2)) {
              t.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localt.EX == 1)
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
          if (localt.ES != null) {
            ((Notification)localObject2).contentView = localt.ES;
          }
          if (localt.ET != null) {
            ((Notification)localObject2).bigContentView = localt.ET;
          }
          if (localt.EU != null) {
            ((Notification)localObject2).headsUpContentView = localt.EU;
          }
          localObject1 = localObject2;
          if (localt.EX != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localt.EX == 2)) {
              t.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localt.EX == 1)
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
          if (localt.ES != null) {
            ((Notification)localObject2).contentView = localt.ES;
          }
          if (localt.ET != null) {
            ((Notification)localObject2).bigContentView = localt.ET;
          }
          localObject1 = localObject2;
          if (localt.EX != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localt.EX == 2)) {
              t.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localt.EX == 1)
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
          localObject1 = u.i(localt.Fo);
          if (localObject1 != null) {
            localt.mExtras.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject1);
          }
          localt.mBuilder.setExtras(localt.mExtras);
          localObject2 = localt.mBuilder.build();
          if (localt.ES != null) {
            ((Notification)localObject2).contentView = localt.ES;
          }
          localObject1 = localObject2;
          if (localt.ET != null)
          {
            ((Notification)localObject2).bigContentView = localt.ET;
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
          localObject2 = u.i(localt.Fo);
          if (localObject2 != null) {
            s.a((Notification)localObject1).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject2);
          }
          if (localt.ES != null) {
            ((Notification)localObject1).contentView = localt.ES;
          }
          if (localt.ET != null) {
            ((Notification)localObject1).bigContentView = localt.ET;
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
      this.Ex = paramPendingIntent;
      f(128, true);
      return this;
    }
    
    public final c c(RemoteViews paramRemoteViews)
    {
      this.ET = paramRemoteViews;
      return this;
    }
    
    public final c d(RemoteViews paramRemoteViews)
    {
      this.EU = paramRemoteViews;
      return this;
    }
    
    public final c dN()
    {
      f(2, true);
      return this;
    }
    
    public final c dO()
    {
      this.mPriority = 1;
      return this;
    }
    
    public final c f(CharSequence paramCharSequence)
    {
      this.Eu = j(paramCharSequence);
      return this;
    }
    
    public final void f(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        localNotification = this.EY;
        localNotification.flags |= paramInt;
        return;
      }
      Notification localNotification = this.EY;
      localNotification.flags &= (paramInt ^ 0xFFFFFFFF);
    }
    
    public final c g(long paramLong)
    {
      this.EY.when = paramLong;
      return this;
    }
    
    public final c g(CharSequence paramCharSequence)
    {
      this.Ev = j(paramCharSequence);
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
      this.EF = j(paramCharSequence);
      return this;
    }
    
    public final c i(CharSequence paramCharSequence)
    {
      this.EY.tickerText = j(paramCharSequence);
      return this;
    }
    
    public final c t(String paramString)
    {
      this.EQ = paramString;
      return this;
    }
  }
  
  public static abstract class f
  {
    protected s.c Fj;
    CharSequence Fk;
    CharSequence Fl;
    boolean Fm = false;
    
    public void a(r paramr) {}
    
    public final void b(s.c paramc)
    {
      if (this.Fj != paramc)
      {
        this.Fj = paramc;
        if (this.Fj != null) {
          this.Fj.a(this);
        }
      }
    }
    
    public final Notification build()
    {
      Notification localNotification = null;
      if (this.Fj != null) {
        localNotification = this.Fj.build();
      }
      return localNotification;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.s
 * JD-Core Version:    0.7.0.1
 */