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
    final x[] Fg;
    final x[] Fh;
    boolean Fi;
    boolean Fj = true;
    final int Fk;
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
        this.Fg = paramArrayOfx1;
        this.Fh = paramArrayOfx2;
        this.Fi = paramBoolean1;
        this.Fk = paramInt2;
        this.Fj = paramBoolean2;
        return;
        paramBundle = new Bundle();
      }
    }
  }
  
  public static final class b
    extends s.f
  {
    private CharSequence Fp;
    
    public b() {}
    
    public b(s.c paramc)
    {
      b(paramc);
    }
    
    public final void a(r paramr)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramr = new Notification.BigTextStyle(paramr.dS()).setBigContentTitle(this.Gi).bigText(this.Fp);
        if (this.Gk) {
          paramr.setSummaryText(this.Gj);
        }
      }
    }
    
    public final b e(CharSequence paramCharSequence)
    {
      this.Fp = s.c.j(paramCharSequence);
      return this;
    }
  }
  
  public static final class c
  {
    boolean FA = true;
    boolean FB;
    s.f FC;
    CharSequence FD;
    CharSequence[] FE;
    int FF;
    int FG;
    boolean FH;
    String FI;
    boolean FJ;
    String FK;
    public boolean FL = false;
    boolean FM;
    boolean FN;
    public String FO;
    Notification FP;
    RemoteViews FQ;
    RemoteViews FR;
    RemoteViews FS;
    int FT = 0;
    String FU;
    int FV = 0;
    public Notification FW = new Notification();
    @Deprecated
    public ArrayList<String> FX;
    public ArrayList<s.a> Fq = new ArrayList();
    ArrayList<s.a> Fr = new ArrayList();
    CharSequence Fs;
    CharSequence Ft;
    public PendingIntent Fu;
    PendingIntent Fv;
    RemoteViews Fw;
    Bitmap Fx;
    CharSequence Fy;
    int Fz;
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
      this.FW.when = System.currentTimeMillis();
      this.FW.audioStreamType = -1;
      this.mPriority = 0;
      this.FX = new ArrayList();
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
      this.Fq.add(new s.a(paramInt, paramCharSequence, paramPendingIntent));
      return this;
    }
    
    public final c a(PendingIntent paramPendingIntent)
    {
      this.Fu = paramPendingIntent;
      return this;
    }
    
    public final c a(s.a parama)
    {
      this.Fq.add(parama);
      return this;
    }
    
    public final c a(s.f paramf)
    {
      if (this.FC != paramf)
      {
        this.FC = paramf;
        if (this.FC != null) {
          this.FC.b(this);
        }
      }
      return this;
    }
    
    public final c a(RemoteViews paramRemoteViews)
    {
      this.FW.contentView = paramRemoteViews;
      return this;
    }
    
    public final c as(int paramInt)
    {
      this.FW.icon = paramInt;
      return this;
    }
    
    public final c b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.FF = paramInt1;
      this.FG = paramInt2;
      this.FH = paramBoolean;
      return this;
    }
    
    public final c b(PendingIntent paramPendingIntent)
    {
      this.FW.deleteIntent = paramPendingIntent;
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
        this.Fx = ((Bitmap)localObject);
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
      this.FW.sound = paramUri;
      this.FW.audioStreamType = -1;
      if (Build.VERSION.SDK_INT >= 21) {
        this.FW.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
      }
      return this;
    }
    
    public final c b(RemoteViews paramRemoteViews)
    {
      this.FQ = paramRemoteViews;
      return this;
    }
    
    public final Notification build()
    {
      t localt = new t(this);
      s.f localf = localt.Gl.FC;
      if (localf != null) {
        localf.a(localt);
      }
      Object localObject1;
      if (Build.VERSION.SDK_INT >= 26) {
        localObject1 = localt.mBuilder.build();
      }
      for (;;)
      {
        if (localt.Gl.FQ != null) {
          ((Notification)localObject1).contentView = localt.Gl.FQ;
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
          if (localt.FV != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localt.FV == 2)) {
              t.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localt.FV == 1)
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
          if (localt.FQ != null) {
            ((Notification)localObject2).contentView = localt.FQ;
          }
          if (localt.FR != null) {
            ((Notification)localObject2).bigContentView = localt.FR;
          }
          if (localt.FS != null) {
            ((Notification)localObject2).headsUpContentView = localt.FS;
          }
          localObject1 = localObject2;
          if (localt.FV != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localt.FV == 2)) {
              t.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localt.FV == 1)
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
          if (localt.FQ != null) {
            ((Notification)localObject2).contentView = localt.FQ;
          }
          if (localt.FR != null) {
            ((Notification)localObject2).bigContentView = localt.FR;
          }
          localObject1 = localObject2;
          if (localt.FV != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localt.FV == 2)) {
              t.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localt.FV == 1)
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
          localObject1 = u.h(localt.Gm);
          if (localObject1 != null) {
            localt.mExtras.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject1);
          }
          localt.mBuilder.setExtras(localt.mExtras);
          localObject2 = localt.mBuilder.build();
          if (localt.FQ != null) {
            ((Notification)localObject2).contentView = localt.FQ;
          }
          localObject1 = localObject2;
          if (localt.FR != null)
          {
            ((Notification)localObject2).bigContentView = localt.FR;
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
          localObject2 = u.h(localt.Gm);
          if (localObject2 != null) {
            s.a((Notification)localObject1).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject2);
          }
          if (localt.FQ != null) {
            ((Notification)localObject1).contentView = localt.FQ;
          }
          if (localt.FR != null) {
            ((Notification)localObject1).bigContentView = localt.FR;
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
      this.Fv = paramPendingIntent;
      f(128, true);
      return this;
    }
    
    public final c c(RemoteViews paramRemoteViews)
    {
      this.FR = paramRemoteViews;
      return this;
    }
    
    public final c d(RemoteViews paramRemoteViews)
    {
      this.FS = paramRemoteViews;
      return this;
    }
    
    public final c dU()
    {
      f(2, true);
      return this;
    }
    
    public final c dV()
    {
      this.mPriority = 1;
      return this;
    }
    
    public final c f(CharSequence paramCharSequence)
    {
      this.Fs = j(paramCharSequence);
      return this;
    }
    
    public final void f(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        localNotification = this.FW;
        localNotification.flags |= paramInt;
        return;
      }
      Notification localNotification = this.FW;
      localNotification.flags &= (paramInt ^ 0xFFFFFFFF);
    }
    
    public final c g(CharSequence paramCharSequence)
    {
      this.Ft = j(paramCharSequence);
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
      this.FD = j(paramCharSequence);
      return this;
    }
    
    public final c i(long paramLong)
    {
      this.FW.when = paramLong;
      return this;
    }
    
    public final c i(CharSequence paramCharSequence)
    {
      this.FW.tickerText = j(paramCharSequence);
      return this;
    }
    
    public final c u(String paramString)
    {
      this.FO = paramString;
      return this;
    }
  }
  
  public static abstract class f
  {
    protected s.c Gh;
    CharSequence Gi;
    CharSequence Gj;
    boolean Gk = false;
    
    public void a(r paramr) {}
    
    public final void b(s.c paramc)
    {
      if (this.Gh != paramc)
      {
        this.Gh = paramc;
        if (this.Gh != null) {
          this.Gh.a(this);
        }
      }
    }
    
    public final Notification build()
    {
      Notification localNotification = null;
      if (this.Gh != null) {
        localNotification = this.Gh.build();
      }
      return localNotification;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.s
 * JD-Core Version:    0.7.0.1
 */