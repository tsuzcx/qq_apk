package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
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

public final class x
{
  public static Bundle a(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return z.a(paramNotification);
    }
    return null;
  }
  
  public static final class c
  {
    public String mCategory;
    String mChannelId;
    public int mColor = 0;
    public Context mContext;
    Bundle mExtras;
    int mPriority;
    long mTimeout;
    PendingIntent xA;
    RemoteViews xB;
    public Bitmap xC;
    CharSequence xD;
    int xE;
    boolean xF = true;
    boolean xG;
    x.f xH;
    CharSequence xI;
    CharSequence[] xJ;
    int xK;
    int xL;
    boolean xM;
    String xN;
    boolean xO;
    String xP;
    public boolean xQ = false;
    boolean xR;
    boolean xS;
    int xT = 0;
    Notification xU;
    RemoteViews xV;
    RemoteViews xW;
    RemoteViews xX;
    int xY = 0;
    String xZ;
    public ArrayList<x.a> xw = new ArrayList();
    CharSequence xx;
    CharSequence xy;
    public PendingIntent xz;
    int ya = 0;
    public Notification yb = new Notification();
    @Deprecated
    public ArrayList<String> yc;
    
    private c(Context paramContext)
    {
      this.mContext = paramContext;
      this.mChannelId = null;
      this.yb.when = System.currentTimeMillis();
      this.yb.audioStreamType = -1;
      this.mPriority = 0;
      this.yc = new ArrayList();
    }
    
    @Deprecated
    public c(Context paramContext, byte paramByte)
    {
      this(paramContext);
    }
    
    protected static CharSequence f(CharSequence paramCharSequence)
    {
      if (paramCharSequence == null) {}
      while (paramCharSequence.length() <= 5120) {
        return paramCharSequence;
      }
      return paramCharSequence.subSequence(0, 5120);
    }
    
    public final c a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this.xw.add(new x.a(paramInt, paramCharSequence, paramPendingIntent));
      return this;
    }
    
    public final c a(x.f paramf)
    {
      if (this.xH != paramf)
      {
        this.xH = paramf;
        if (this.xH != null) {
          this.xH.b(this);
        }
      }
      return this;
    }
    
    public final c ah(int paramInt)
    {
      this.yb.icon = paramInt;
      return this;
    }
    
    public final c b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.xK = paramInt1;
      this.xL = paramInt2;
      this.xM = paramBoolean;
      return this;
    }
    
    public final c b(Uri paramUri)
    {
      this.yb.sound = paramUri;
      this.yb.audioStreamType = -1;
      if (Build.VERSION.SDK_INT >= 21) {
        this.yb.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
      }
      return this;
    }
    
    public final Notification build()
    {
      y localy = new y(this);
      x.f localf = localy.yq.xH;
      if (localf != null) {
        localf.a(localy);
      }
      Object localObject1;
      if (Build.VERSION.SDK_INT >= 26) {
        localObject1 = localy.mBuilder.build();
      }
      for (;;)
      {
        if (localy.yq.xV != null) {
          ((Notification)localObject1).contentView = localy.yq.xV;
        }
        int i = Build.VERSION.SDK_INT;
        i = Build.VERSION.SDK_INT;
        if ((Build.VERSION.SDK_INT >= 16) && (localf != null)) {
          x.a((Notification)localObject1);
        }
        return localObject1;
        Object localObject2;
        if (Build.VERSION.SDK_INT >= 24)
        {
          localObject2 = localy.mBuilder.build();
          localObject1 = localObject2;
          if (localy.ya != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localy.ya == 2)) {
              y.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localy.ya == 1)
                {
                  y.b((Notification)localObject2);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 21)
        {
          localy.mBuilder.setExtras(localy.mExtras);
          localObject2 = localy.mBuilder.build();
          if (localy.xV != null) {
            ((Notification)localObject2).contentView = localy.xV;
          }
          if (localy.xW != null) {
            ((Notification)localObject2).bigContentView = localy.xW;
          }
          if (localy.xX != null) {
            ((Notification)localObject2).headsUpContentView = localy.xX;
          }
          localObject1 = localObject2;
          if (localy.ya != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localy.ya == 2)) {
              y.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localy.ya == 1)
                {
                  y.b((Notification)localObject2);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 20)
        {
          localy.mBuilder.setExtras(localy.mExtras);
          localObject2 = localy.mBuilder.build();
          if (localy.xV != null) {
            ((Notification)localObject2).contentView = localy.xV;
          }
          if (localy.xW != null) {
            ((Notification)localObject2).bigContentView = localy.xW;
          }
          localObject1 = localObject2;
          if (localy.ya != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localy.ya == 2)) {
              y.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localy.ya == 1)
                {
                  y.b((Notification)localObject2);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 19)
        {
          localObject1 = z.i(localy.yr);
          if (localObject1 != null) {
            localy.mExtras.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject1);
          }
          localy.mBuilder.setExtras(localy.mExtras);
          localObject2 = localy.mBuilder.build();
          if (localy.xV != null) {
            ((Notification)localObject2).contentView = localy.xV;
          }
          localObject1 = localObject2;
          if (localy.xW != null)
          {
            ((Notification)localObject2).bigContentView = localy.xW;
            localObject1 = localObject2;
          }
        }
        else if (Build.VERSION.SDK_INT >= 16)
        {
          localObject1 = localy.mBuilder.build();
          localObject2 = x.a((Notification)localObject1);
          Bundle localBundle = new Bundle(localy.mExtras);
          Iterator localIterator = localy.mExtras.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (((Bundle)localObject2).containsKey(str)) {
              localBundle.remove(str);
            }
          }
          ((Bundle)localObject2).putAll(localBundle);
          localObject2 = z.i(localy.yr);
          if (localObject2 != null) {
            x.a((Notification)localObject1).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject2);
          }
          if (localy.xV != null) {
            ((Notification)localObject1).contentView = localy.xV;
          }
          if (localy.xW != null) {
            ((Notification)localObject1).bigContentView = localy.xW;
          }
        }
        else
        {
          localObject1 = localy.mBuilder.getNotification();
        }
      }
    }
    
    public final c c(CharSequence paramCharSequence)
    {
      this.xx = f(paramCharSequence);
      return this;
    }
    
    public final c d(CharSequence paramCharSequence)
    {
      this.xy = f(paramCharSequence);
      return this;
    }
    
    public final c e(CharSequence paramCharSequence)
    {
      this.yb.tickerText = f(paramCharSequence);
      return this;
    }
    
    public final c j(long paramLong)
    {
      this.yb.when = paramLong;
      return this;
    }
    
    public final void l(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        localNotification = this.yb;
        localNotification.flags |= paramInt;
        return;
      }
      Notification localNotification = this.yb;
      localNotification.flags &= (paramInt ^ 0xFFFFFFFF);
    }
    
    public final c z(boolean paramBoolean)
    {
      l(16, paramBoolean);
      return this;
    }
  }
  
  public static abstract interface e
  {
    public abstract x.c a(x.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.app.x
 * JD-Core Version:    0.7.0.1
 */