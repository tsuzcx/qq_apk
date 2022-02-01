package androidx.core.app;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.a.b;
import androidx.core.graphics.drawable.IconCompat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class e
{
  public static Bundle a(Notification paramNotification)
  {
    AppMethodBeat.i(250352);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramNotification = paramNotification.extras;
      AppMethodBeat.o(250352);
      return paramNotification;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramNotification = g.a(paramNotification);
      AppMethodBeat.o(250352);
      return paramNotification;
    }
    AppMethodBeat.o(250352);
    return null;
  }
  
  public static final class a
  {
    private IconCompat HY;
    final i[] HZ;
    final i[] Ia;
    boolean Ib;
    boolean Ic;
    final int Ie;
    final boolean If;
    public CharSequence Ig;
    public PendingIntent Ih;
    @Deprecated
    public int icon;
    final Bundle mExtras;
    
    public a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent) {}
    
    private a(IconCompat paramIconCompat, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this(paramIconCompat, paramCharSequence, paramPendingIntent, new Bundle(), null, null, true, 0, true, false);
      AppMethodBeat.i(250268);
      AppMethodBeat.o(250268);
    }
    
    a(IconCompat paramIconCompat, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, i[] paramArrayOfi1, i[] paramArrayOfi2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
    {
      AppMethodBeat.i(250269);
      this.Ic = true;
      this.HY = paramIconCompat;
      int i;
      if (paramIconCompat != null)
      {
        if ((paramIconCompat.mType != -1) || (Build.VERSION.SDK_INT < 23)) {
          break label131;
        }
        i = IconCompat.a((Icon)paramIconCompat.KM);
        if (i == 2) {
          this.icon = paramIconCompat.getResId();
        }
      }
      this.Ig = e.d.o(paramCharSequence);
      this.Ih = paramPendingIntent;
      if (paramBundle != null) {}
      for (;;)
      {
        this.mExtras = paramBundle;
        this.HZ = paramArrayOfi1;
        this.Ia = paramArrayOfi2;
        this.Ib = paramBoolean1;
        this.Ie = paramInt;
        this.Ic = paramBoolean2;
        this.If = paramBoolean3;
        AppMethodBeat.o(250269);
        return;
        label131:
        i = paramIconCompat.mType;
        break;
        paramBundle = new Bundle();
      }
    }
    
    public final IconCompat gn()
    {
      AppMethodBeat.i(250270);
      if ((this.HY == null) && (this.icon != 0)) {
        this.HY = IconCompat.h("", this.icon);
      }
      IconCompat localIconCompat = this.HY;
      AppMethodBeat.o(250270);
      return localIconCompat;
    }
    
    public static final class a
    {
      private final IconCompat HY;
      public boolean Ib;
      private boolean Ic;
      private int Ie;
      private boolean If;
      private final PendingIntent Ii;
      private ArrayList<i> Ij;
      private final CharSequence cZ;
      private final Bundle mExtras;
      
      public a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent) {}
      
      private a(IconCompat paramIconCompat, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
      {
        AppMethodBeat.i(250263);
        this.Ib = true;
        this.Ic = true;
        this.HY = paramIconCompat;
        this.cZ = e.d.o(paramCharSequence);
        this.Ii = paramPendingIntent;
        this.mExtras = paramBundle;
        this.Ij = null;
        this.Ib = true;
        this.Ie = 0;
        this.Ic = true;
        this.If = false;
        AppMethodBeat.o(250263);
      }
      
      public final e.a go()
      {
        AppMethodBeat.i(250264);
        if ((this.If) && (this.Ii == null))
        {
          localObject1 = new NullPointerException("Contextual Actions must contain a valid PendingIntent");
          AppMethodBeat.o(250264);
          throw ((Throwable)localObject1);
        }
        Object localObject1 = new ArrayList();
        Object localObject2 = new ArrayList();
        if (this.Ij != null)
        {
          Iterator localIterator = this.Ij.iterator();
          while (localIterator.hasNext())
          {
            i locali = (i)localIterator.next();
            if ((!locali.JK) && ((locali.JJ == null) || (locali.JJ.length == 0)) && (locali.JM != null) && (!locali.JM.isEmpty())) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label159;
              }
              ((List)localObject1).add(locali);
              break;
            }
            label159:
            ((List)localObject2).add(locali);
          }
        }
        if (((List)localObject1).isEmpty())
        {
          localObject1 = null;
          if (!((List)localObject2).isEmpty()) {
            break label264;
          }
        }
        label264:
        for (localObject2 = null;; localObject2 = (i[])((List)localObject2).toArray(new i[((List)localObject2).size()]))
        {
          localObject1 = new e.a(this.HY, this.cZ, this.Ii, this.mExtras, (i[])localObject2, (i[])localObject1, this.Ib, this.Ie, this.Ic, this.If);
          AppMethodBeat.o(250264);
          return localObject1;
          localObject1 = (i[])((List)localObject1).toArray(new i[((List)localObject1).size()]);
          break;
        }
      }
    }
  }
  
  public static final class b
    extends e.g
  {
    private CharSequence Ik;
    
    public b() {}
    
    public b(e.d paramd)
    {
      AppMethodBeat.i(250273);
      b(paramd);
      AppMethodBeat.o(250273);
    }
    
    public final void a(d paramd)
    {
      AppMethodBeat.i(250275);
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramd = new Notification.BigTextStyle(paramd.gm()).setBigContentTitle(this.Ji).bigText(this.Ik);
        if (this.Jk) {
          paramd.setSummaryText(this.Jj);
        }
      }
      AppMethodBeat.o(250275);
    }
    
    public final b j(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(250274);
      this.Ik = e.d.o(paramCharSequence);
      AppMethodBeat.o(250274);
      return this;
    }
  }
  
  public static final class c {}
  
  public static final class d
  {
    int CX;
    int IA;
    int IB;
    boolean IC;
    String IE;
    boolean IF;
    String IG;
    public boolean IH;
    boolean II;
    boolean IJ;
    public String IK;
    Notification IL;
    RemoteViews IM;
    RemoteViews IN;
    RemoteViews IP;
    int IQ;
    String IR;
    int IS;
    boolean IT;
    e.c IU;
    public Notification IV;
    boolean IW;
    @Deprecated
    public ArrayList<String> IX;
    public ArrayList<e.a> Il;
    ArrayList<e.a> Im;
    CharSequence In;
    CharSequence Io;
    public PendingIntent Ip;
    PendingIntent Iq;
    RemoteViews Ir;
    Bitmap Is;
    CharSequence It;
    int Iu;
    boolean Iv;
    boolean Iw;
    e.g Ix;
    CharSequence Iy;
    CharSequence[] Iz;
    public String mChannelId;
    public int mColor;
    public Context mContext;
    Bundle mExtras;
    int mPriority;
    long mTimeout;
    
    @Deprecated
    public d(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public d(Context paramContext, String paramString)
    {
      AppMethodBeat.i(250277);
      this.Il = new ArrayList();
      this.Im = new ArrayList();
      this.Iv = true;
      this.IH = false;
      this.mColor = 0;
      this.CX = 0;
      this.IQ = 0;
      this.IS = 0;
      this.IV = new Notification();
      this.mContext = paramContext;
      this.mChannelId = paramString;
      this.IV.when = System.currentTimeMillis();
      this.IV.audioStreamType = -1;
      this.mPriority = 0;
      this.IX = new ArrayList();
      this.IT = true;
      AppMethodBeat.o(250277);
    }
    
    protected static CharSequence o(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(250315);
      if (paramCharSequence == null)
      {
        AppMethodBeat.o(250315);
        return paramCharSequence;
      }
      CharSequence localCharSequence = paramCharSequence;
      if (paramCharSequence.length() > 5120) {
        localCharSequence = paramCharSequence.subSequence(0, 5120);
      }
      AppMethodBeat.o(250315);
      return localCharSequence;
    }
    
    public final d W(boolean paramBoolean)
    {
      AppMethodBeat.i(250289);
      e(16, paramBoolean);
      AppMethodBeat.o(250289);
      return this;
    }
    
    public final d a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      AppMethodBeat.i(250296);
      this.Il.add(new e.a(paramInt, paramCharSequence, paramPendingIntent));
      AppMethodBeat.o(250296);
      return this;
    }
    
    public final d a(PendingIntent paramPendingIntent)
    {
      this.Ip = paramPendingIntent;
      return this;
    }
    
    public final d a(RemoteViews paramRemoteViews)
    {
      this.IV.contentView = paramRemoteViews;
      return this;
    }
    
    public final d a(e.a parama)
    {
      AppMethodBeat.i(250298);
      this.Il.add(parama);
      AppMethodBeat.o(250298);
      return this;
    }
    
    public final d a(e.g paramg)
    {
      AppMethodBeat.i(250299);
      if (this.Ix != paramg)
      {
        this.Ix = paramg;
        if (this.Ix != null) {
          this.Ix.b(this);
        }
      }
      AppMethodBeat.o(250299);
      return this;
    }
    
    public final d b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.IA = paramInt1;
      this.IB = paramInt2;
      this.IC = paramBoolean;
      return this;
    }
    
    public final d b(PendingIntent paramPendingIntent)
    {
      this.IV.deleteIntent = paramPendingIntent;
      return this;
    }
    
    public final d b(Bitmap paramBitmap)
    {
      AppMethodBeat.i(250286);
      Object localObject = paramBitmap;
      if (paramBitmap != null)
      {
        if (Build.VERSION.SDK_INT < 27) {
          break label36;
        }
        localObject = paramBitmap;
      }
      for (;;)
      {
        this.Is = ((Bitmap)localObject);
        AppMethodBeat.o(250286);
        return this;
        label36:
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
    
    public final d b(RemoteViews paramRemoteViews)
    {
      this.IM = paramRemoteViews;
      return this;
    }
    
    public final d bn(int paramInt)
    {
      this.IV.icon = paramInt;
      return this;
    }
    
    public final d c(PendingIntent paramPendingIntent)
    {
      AppMethodBeat.i(250283);
      this.Iq = paramPendingIntent;
      e(128, true);
      AppMethodBeat.o(250283);
      return this;
    }
    
    public final d c(RemoteViews paramRemoteViews)
    {
      this.IN = paramRemoteViews;
      return this;
    }
    
    public final d d(Uri paramUri)
    {
      AppMethodBeat.i(250287);
      this.IV.sound = paramUri;
      this.IV.audioStreamType = -1;
      if (Build.VERSION.SDK_INT >= 21) {
        this.IV.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
      }
      AppMethodBeat.o(250287);
      return this;
    }
    
    public final d d(RemoteViews paramRemoteViews)
    {
      this.IP = paramRemoteViews;
      return this;
    }
    
    public final d e(long paramLong)
    {
      this.IV.when = paramLong;
      return this;
    }
    
    public final void e(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        localNotification = this.IV;
        localNotification.flags |= paramInt;
        return;
      }
      Notification localNotification = this.IV;
      localNotification.flags &= (paramInt ^ 0xFFFFFFFF);
    }
    
    public final Bundle getExtras()
    {
      AppMethodBeat.i(250294);
      if (this.mExtras == null) {
        this.mExtras = new Bundle();
      }
      Bundle localBundle = this.mExtras;
      AppMethodBeat.o(250294);
      return localBundle;
    }
    
    public final d gp()
    {
      AppMethodBeat.i(250288);
      e(2, true);
      AppMethodBeat.o(250288);
      return this;
    }
    
    public final d gq()
    {
      this.mPriority = 1;
      return this;
    }
    
    public final Notification gr()
    {
      AppMethodBeat.i(250311);
      f localf = new f(this);
      e.g localg = localf.Jm.Ix;
      if (localg != null) {
        localg.a(localf);
      }
      Object localObject1;
      if (Build.VERSION.SDK_INT >= 26) {
        localObject1 = localf.Jl.build();
      }
      for (;;)
      {
        if (localf.Jm.IM != null) {
          ((Notification)localObject1).contentView = localf.Jm.IM;
        }
        int i = Build.VERSION.SDK_INT;
        i = Build.VERSION.SDK_INT;
        if ((Build.VERSION.SDK_INT >= 16) && (localg != null)) {
          e.a((Notification)localObject1);
        }
        AppMethodBeat.o(250311);
        return localObject1;
        Object localObject2;
        if (Build.VERSION.SDK_INT >= 24)
        {
          localObject2 = localf.Jl.build();
          localObject1 = localObject2;
          if (localf.IS != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localf.IS == 2)) {
              f.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localf.IS == 1)
                {
                  f.b((Notification)localObject2);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 21)
        {
          localf.Jl.setExtras(localf.mExtras);
          localObject2 = localf.Jl.build();
          if (localf.IM != null) {
            ((Notification)localObject2).contentView = localf.IM;
          }
          if (localf.IN != null) {
            ((Notification)localObject2).bigContentView = localf.IN;
          }
          if (localf.IP != null) {
            ((Notification)localObject2).headsUpContentView = localf.IP;
          }
          localObject1 = localObject2;
          if (localf.IS != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localf.IS == 2)) {
              f.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localf.IS == 1)
                {
                  f.b((Notification)localObject2);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 20)
        {
          localf.Jl.setExtras(localf.mExtras);
          localObject2 = localf.Jl.build();
          if (localf.IM != null) {
            ((Notification)localObject2).contentView = localf.IM;
          }
          if (localf.IN != null) {
            ((Notification)localObject2).bigContentView = localf.IN;
          }
          localObject1 = localObject2;
          if (localf.IS != 0)
          {
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (localf.IS == 2)) {
              f.b((Notification)localObject2);
            }
            localObject1 = localObject2;
            if (((Notification)localObject2).getGroup() != null)
            {
              localObject1 = localObject2;
              if ((((Notification)localObject2).flags & 0x200) == 0)
              {
                localObject1 = localObject2;
                if (localf.IS == 1)
                {
                  f.b((Notification)localObject2);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 19)
        {
          localObject1 = g.g(localf.Jn);
          if (localObject1 != null) {
            localf.mExtras.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject1);
          }
          localf.Jl.setExtras(localf.mExtras);
          localObject2 = localf.Jl.build();
          if (localf.IM != null) {
            ((Notification)localObject2).contentView = localf.IM;
          }
          localObject1 = localObject2;
          if (localf.IN != null)
          {
            ((Notification)localObject2).bigContentView = localf.IN;
            localObject1 = localObject2;
          }
        }
        else if (Build.VERSION.SDK_INT >= 16)
        {
          localObject1 = localf.Jl.build();
          localObject2 = e.a((Notification)localObject1);
          Bundle localBundle = new Bundle(localf.mExtras);
          Iterator localIterator = localf.mExtras.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (((Bundle)localObject2).containsKey(str)) {
              localBundle.remove(str);
            }
          }
          ((Bundle)localObject2).putAll(localBundle);
          localObject2 = g.g(localf.Jn);
          if (localObject2 != null) {
            e.a((Notification)localObject1).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject2);
          }
          if (localf.IM != null) {
            ((Notification)localObject1).contentView = localf.IM;
          }
          if (localf.IN != null) {
            ((Notification)localObject1).bigContentView = localf.IN;
          }
        }
        else
        {
          localObject1 = localf.Jl.getNotification();
        }
      }
    }
    
    public final d k(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(250278);
      this.In = o(paramCharSequence);
      AppMethodBeat.o(250278);
      return this;
    }
    
    public final d l(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(250279);
      this.Io = o(paramCharSequence);
      AppMethodBeat.o(250279);
      return this;
    }
    
    public final d m(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(250280);
      this.Iy = o(paramCharSequence);
      AppMethodBeat.o(250280);
      return this;
    }
    
    public final d n(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(250284);
      this.IV.tickerText = o(paramCharSequence);
      AppMethodBeat.o(250284);
      return this;
    }
    
    public final d z(String paramString)
    {
      this.IK = paramString;
      return this;
    }
  }
  
  public static final class e
    implements e.f
  {
    public a IY;
    private Bitmap Is;
    private int mColor = 0;
    
    private static Bundle a(a parama)
    {
      int i = 0;
      AppMethodBeat.i(250340);
      Bundle localBundle1 = new Bundle();
      Parcelable[] arrayOfParcelable = null;
      Object localObject = arrayOfParcelable;
      if (parama.Jd != null)
      {
        localObject = arrayOfParcelable;
        if (parama.Jd.length > 1) {
          localObject = parama.Jd[0];
        }
      }
      arrayOfParcelable = new Parcelable[parama.IZ.length];
      while (i < arrayOfParcelable.length)
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("text", parama.IZ[i]);
        localBundle2.putString("author", (String)localObject);
        arrayOfParcelable[i] = localBundle2;
        i += 1;
      }
      localBundle1.putParcelableArray("messages", arrayOfParcelable);
      localObject = parama.Ja;
      if (localObject != null) {
        localBundle1.putParcelable("remote_input", new RemoteInput.Builder(((i)localObject).JH).setLabel(((i)localObject).JI).setChoices(((i)localObject).JJ).setAllowFreeFormInput(((i)localObject).JK).addExtras(((i)localObject).mExtras).build());
      }
      localBundle1.putParcelable("on_reply", parama.Jb);
      localBundle1.putParcelable("on_read", parama.Jc);
      localBundle1.putStringArray("participants", parama.Jd);
      localBundle1.putLong("timestamp", parama.Je);
      AppMethodBeat.o(250340);
      return localBundle1;
    }
    
    public final e.d a(e.d paramd)
    {
      AppMethodBeat.i(250342);
      if (Build.VERSION.SDK_INT < 21)
      {
        AppMethodBeat.o(250342);
        return paramd;
      }
      Bundle localBundle = new Bundle();
      if (this.Is != null) {
        localBundle.putParcelable("large_icon", this.Is);
      }
      if (this.mColor != 0) {
        localBundle.putInt("app_color", this.mColor);
      }
      if (this.IY != null) {
        localBundle.putBundle("car_conversation", a(this.IY));
      }
      paramd.getExtras().putBundle("android.car.EXTENSIONS", localBundle);
      AppMethodBeat.o(250342);
      return paramd;
    }
    
    @Deprecated
    public static final class a
    {
      final String[] IZ;
      final i Ja;
      final PendingIntent Jb;
      final PendingIntent Jc;
      final String[] Jd;
      final long Je;
      
      public a(String[] paramArrayOfString1, i parami, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString2, long paramLong)
      {
        this.IZ = paramArrayOfString1;
        this.Ja = parami;
        this.Jc = paramPendingIntent2;
        this.Jb = paramPendingIntent1;
        this.Jd = paramArrayOfString2;
        this.Je = paramLong;
      }
    }
  }
  
  public static abstract interface f
  {
    public abstract e.d a(e.d paramd);
  }
  
  public static abstract class g
  {
    protected e.d Jh;
    CharSequence Ji;
    CharSequence Jj;
    boolean Jk = false;
    
    public void a(d paramd) {}
    
    public final void b(e.d paramd)
    {
      if (this.Jh != paramd)
      {
        this.Jh = paramd;
        if (this.Jh != null) {
          this.Jh.a(this);
        }
      }
    }
    
    public final Notification gr()
    {
      Notification localNotification = null;
      if (this.Jh != null) {
        localNotification = this.Jh.gr();
      }
      return localNotification;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.app.e
 * JD-Core Version:    0.7.0.1
 */