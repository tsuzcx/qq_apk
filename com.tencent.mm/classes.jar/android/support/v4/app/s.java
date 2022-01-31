package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    public PendingIntent actionIntent;
    public int icon;
    final Bundle mExtras;
    public CharSequence title;
    final x[] xQ;
    final x[] xR;
    boolean xS;
    boolean xT = true;
    final int xU;
    
    public a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this(paramInt, paramCharSequence, paramPendingIntent, new Bundle());
    }
    
    private a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
    {
      this.icon = paramInt;
      this.title = s.c.i(paramCharSequence);
      this.actionIntent = paramPendingIntent;
      this.mExtras = paramBundle;
      this.xQ = null;
      this.xR = null;
      this.xS = true;
      this.xU = 0;
      this.xT = true;
    }
  }
  
  public static final class b
    extends s.f
  {
    private CharSequence xV;
    
    public b() {}
    
    public b(s.c paramc)
    {
      b(paramc);
    }
    
    public final void a(r paramr)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramr = new Notification.BigTextStyle(paramr.cI()).setBigContentTitle(this.yP).bigText(this.xV);
        if (this.yR) {
          paramr.setSummaryText(this.yQ);
        }
      }
    }
    
    public final b d(CharSequence paramCharSequence)
    {
      this.xV = s.c.i(paramCharSequence);
      return this;
    }
  }
  
  public static final class c
  {
    public String mChannelId;
    public int mColor = 0;
    public Context mContext;
    Bundle mExtras;
    public int mPriority;
    long mTimeout;
    int mVisibility = 0;
    public ArrayList<s.a> xW = new ArrayList();
    ArrayList<s.a> xX = new ArrayList();
    CharSequence xY;
    CharSequence xZ;
    String yA;
    int yB = 0;
    Notification yC = new Notification();
    @Deprecated
    public ArrayList<String> yD;
    public PendingIntent ya;
    PendingIntent yb;
    RemoteViews yc;
    Bitmap yd;
    CharSequence ye;
    int yf;
    boolean yg = true;
    boolean yh;
    s.f yi;
    CharSequence yj;
    CharSequence[] yk;
    int yl;
    int ym;
    boolean yn;
    String yo;
    boolean yp;
    String yq;
    public boolean yr = false;
    boolean ys;
    boolean yt;
    public String yu;
    Notification yv;
    public RemoteViews yw;
    RemoteViews yx;
    RemoteViews yy;
    int yz = 0;
    
    @Deprecated
    public c(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public c(Context paramContext, String paramString)
    {
      this.mContext = paramContext;
      this.mChannelId = paramString;
      this.yC.when = System.currentTimeMillis();
      this.yC.audioStreamType = -1;
      this.mPriority = 0;
      this.yD = new ArrayList();
    }
    
    protected static CharSequence i(CharSequence paramCharSequence)
    {
      if (paramCharSequence == null) {}
      while (paramCharSequence.length() <= 5120) {
        return paramCharSequence;
      }
      return paramCharSequence.subSequence(0, 5120);
    }
    
    public final c Y(int paramInt)
    {
      this.yC.icon = paramInt;
      return this;
    }
    
    public final c Z(int paramInt)
    {
      this.yC.defaults = paramInt;
      if ((paramInt & 0x4) != 0)
      {
        Notification localNotification = this.yC;
        localNotification.flags |= 0x1;
      }
      return this;
    }
    
    public final c a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this.xW.add(new s.a(paramInt, paramCharSequence, paramPendingIntent));
      return this;
    }
    
    public final c a(PendingIntent paramPendingIntent)
    {
      this.yC.deleteIntent = paramPendingIntent;
      return this;
    }
    
    public final c a(s.e parame)
    {
      parame.a(this);
      return this;
    }
    
    public final c a(s.f paramf)
    {
      if (this.yi != paramf)
      {
        this.yi = paramf;
        if (this.yi != null) {
          this.yi.b(this);
        }
      }
      return this;
    }
    
    public final c a(RemoteViews paramRemoteViews)
    {
      this.yC.contentView = paramRemoteViews;
      return this;
    }
    
    public final c a(long[] paramArrayOfLong)
    {
      this.yC.vibrate = paramArrayOfLong;
      return this;
    }
    
    public final c b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.yl = paramInt1;
      this.ym = paramInt2;
      this.yn = paramBoolean;
      return this;
    }
    
    public final c b(PendingIntent paramPendingIntent)
    {
      this.yb = paramPendingIntent;
      g(128, true);
      return this;
    }
    
    public final c b(Uri paramUri)
    {
      this.yC.sound = paramUri;
      this.yC.audioStreamType = -1;
      if (Build.VERSION.SDK_INT >= 21) {
        this.yC.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
      }
      return this;
    }
    
    public final Notification build()
    {
      t localt = new t(this);
      s.f localf = localt.yS.yi;
      if (localf != null) {
        localf.a(localt);
      }
      Object localObject1;
      if (Build.VERSION.SDK_INT >= 26) {
        localObject1 = localt.mBuilder.build();
      }
      for (;;)
      {
        if (localt.yS.yw != null) {
          ((Notification)localObject1).contentView = localt.yS.yw;
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
          if (localt.yB != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localt.yB == 2)) {
              t.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localt.yB == 1)
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
          if (localt.yw != null) {
            ((Notification)localObject2).contentView = localt.yw;
          }
          if (localt.yx != null) {
            ((Notification)localObject2).bigContentView = localt.yx;
          }
          if (localt.yy != null) {
            ((Notification)localObject2).headsUpContentView = localt.yy;
          }
          localObject1 = localObject2;
          if (localt.yB != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localt.yB == 2)) {
              t.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localt.yB == 1)
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
          if (localt.yw != null) {
            ((Notification)localObject2).contentView = localt.yw;
          }
          if (localt.yx != null) {
            ((Notification)localObject2).bigContentView = localt.yx;
          }
          localObject1 = localObject2;
          if (localt.yB != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localt.yB == 2)) {
              t.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localt.yB == 1)
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
          localObject1 = u.i(localt.yT);
          if (localObject1 != null) {
            localt.mExtras.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject1);
          }
          localt.mBuilder.setExtras(localt.mExtras);
          localObject2 = localt.mBuilder.build();
          if (localt.yw != null) {
            ((Notification)localObject2).contentView = localt.yw;
          }
          localObject1 = localObject2;
          if (localt.yx != null)
          {
            ((Notification)localObject2).bigContentView = localt.yx;
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
          localObject2 = u.i(localt.yT);
          if (localObject2 != null) {
            s.a((Notification)localObject1).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject2);
          }
          if (localt.yw != null) {
            ((Notification)localObject1).contentView = localt.yw;
          }
          if (localt.yx != null) {
            ((Notification)localObject1).bigContentView = localt.yx;
          }
        }
        else
        {
          localObject1 = localt.mBuilder.getNotification();
        }
      }
    }
    
    public final c c(Bitmap paramBitmap)
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
        this.yd = ((Bitmap)localObject);
        return this;
        label26:
        localObject = this.mContext.getResources();
        int i = ((Resources)localObject).getDimensionPixelSize(2131428258);
        int j = ((Resources)localObject).getDimensionPixelSize(2131428257);
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
    
    public final c cJ()
    {
      int j = 1;
      this.yC.ledARGB = -16711936;
      this.yC.ledOnMS = 300;
      this.yC.ledOffMS = 1000;
      Notification localNotification;
      int k;
      if ((this.yC.ledOnMS != 0) && (this.yC.ledOffMS != 0))
      {
        i = 1;
        localNotification = this.yC;
        k = this.yC.flags;
        if (i == 0) {
          break label92;
        }
      }
      label92:
      for (int i = j;; i = 0)
      {
        localNotification.flags = (k & 0xFFFFFFFE | i);
        return this;
        i = 0;
        break;
      }
    }
    
    public final c e(CharSequence paramCharSequence)
    {
      this.xY = i(paramCharSequence);
      return this;
    }
    
    public final c f(CharSequence paramCharSequence)
    {
      this.xZ = i(paramCharSequence);
      return this;
    }
    
    public final c g(long paramLong)
    {
      this.yC.when = paramLong;
      return this;
    }
    
    public final c g(CharSequence paramCharSequence)
    {
      this.yj = i(paramCharSequence);
      return this;
    }
    
    public final void g(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        localNotification = this.yC;
        localNotification.flags |= paramInt;
        return;
      }
      Notification localNotification = this.yC;
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
      this.yC.tickerText = i(paramCharSequence);
      return this;
    }
    
    public final c z(boolean paramBoolean)
    {
      g(16, paramBoolean);
      return this;
    }
  }
  
  public static final class d
    implements s.e
  {
    private int mColor = 0;
    public a yE;
    private Bitmap yd;
    
    private static Bundle a(a parama)
    {
      int i = 0;
      Bundle localBundle1 = new Bundle();
      Parcelable[] arrayOfParcelable = null;
      Object localObject = arrayOfParcelable;
      if (parama.yJ != null)
      {
        localObject = arrayOfParcelable;
        if (parama.yJ.length > 1) {
          localObject = parama.yJ[0];
        }
      }
      arrayOfParcelable = new Parcelable[parama.yF.length];
      while (i < arrayOfParcelable.length)
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("text", parama.yF[i]);
        localBundle2.putString("author", (String)localObject);
        arrayOfParcelable[i] = localBundle2;
        i += 1;
      }
      localBundle1.putParcelableArray("messages", arrayOfParcelable);
      localObject = parama.yG;
      if (localObject != null) {
        localBundle1.putParcelable("remote_input", new RemoteInput.Builder(((x)localObject).zn).setLabel(((x)localObject).zo).setChoices(((x)localObject).zp).setAllowFreeFormInput(((x)localObject).zq).addExtras(((x)localObject).mExtras).build());
      }
      localBundle1.putParcelable("on_reply", parama.yH);
      localBundle1.putParcelable("on_read", parama.yI);
      localBundle1.putStringArray("participants", parama.yJ);
      localBundle1.putLong("timestamp", parama.yL);
      return localBundle1;
    }
    
    public final s.c a(s.c paramc)
    {
      if (Build.VERSION.SDK_INT < 21) {
        return paramc;
      }
      Bundle localBundle = new Bundle();
      if (this.yd != null) {
        localBundle.putParcelable("large_icon", this.yd);
      }
      if (this.mColor != 0) {
        localBundle.putInt("app_color", this.mColor);
      }
      if (this.yE != null) {
        localBundle.putBundle("car_conversation", a(this.yE));
      }
      paramc.getExtras().putBundle("android.car.EXTENSIONS", localBundle);
      return paramc;
    }
    
    public static final class a
    {
      final String[] yF;
      final x yG;
      final PendingIntent yH;
      final PendingIntent yI;
      final String[] yJ;
      final long yL;
      
      public a(String[] paramArrayOfString1, x paramx, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString2, long paramLong)
      {
        this.yF = paramArrayOfString1;
        this.yG = paramx;
        this.yI = paramPendingIntent2;
        this.yH = paramPendingIntent1;
        this.yJ = paramArrayOfString2;
        this.yL = paramLong;
      }
      
      public static final class a
      {
        public x yG;
        public PendingIntent yH;
        public PendingIntent yI;
        public long yL;
        public final List<String> yM = new ArrayList();
        public final String yN;
        
        public a(String paramString)
        {
          this.yN = paramString;
        }
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract s.c a(s.c paramc);
  }
  
  public static abstract class f
  {
    protected s.c yO;
    CharSequence yP;
    CharSequence yQ;
    boolean yR = false;
    
    public void a(r paramr) {}
    
    public final void b(s.c paramc)
    {
      if (this.yO != paramc)
      {
        this.yO = paramc;
        if (this.yO != null) {
          this.yO.a(this);
        }
      }
    }
    
    public final Notification build()
    {
      Notification localNotification = null;
      if (this.yO != null) {
        localNotification = this.yO.build();
      }
      return localNotification;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.s
 * JD-Core Version:    0.7.0.1
 */