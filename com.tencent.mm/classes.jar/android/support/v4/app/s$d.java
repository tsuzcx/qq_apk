package android.support.v4.app;

import android.app.PendingIntent;
import android.app.RemoteInput.Builder;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public final class s$d
  implements s.e
{
  private Bitmap Ez;
  public a Fa;
  private int mColor = 0;
  
  private static Bundle a(a parama)
  {
    int i = 0;
    Bundle localBundle1 = new Bundle();
    Parcelable[] arrayOfParcelable = null;
    Object localObject = arrayOfParcelable;
    if (parama.Ff != null)
    {
      localObject = arrayOfParcelable;
      if (parama.Ff.length > 1) {
        localObject = parama.Ff[0];
      }
    }
    arrayOfParcelable = new Parcelable[parama.Fb.length];
    while (i < arrayOfParcelable.length)
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("text", parama.Fb[i]);
      localBundle2.putString("author", (String)localObject);
      arrayOfParcelable[i] = localBundle2;
      i += 1;
    }
    localBundle1.putParcelableArray("messages", arrayOfParcelable);
    localObject = parama.Fc;
    if (localObject != null) {
      localBundle1.putParcelable("remote_input", new RemoteInput.Builder(((x)localObject).FH).setLabel(((x)localObject).FI).setChoices(((x)localObject).FJ).setAllowFreeFormInput(((x)localObject).FK).addExtras(((x)localObject).mExtras).build());
    }
    localBundle1.putParcelable("on_reply", parama.Fd);
    localBundle1.putParcelable("on_read", parama.Fe);
    localBundle1.putStringArray("participants", parama.Ff);
    localBundle1.putLong("timestamp", parama.Fg);
    return localBundle1;
  }
  
  public final s.c a(s.c paramc)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return paramc;
    }
    Bundle localBundle = new Bundle();
    if (this.Ez != null) {
      localBundle.putParcelable("large_icon", this.Ez);
    }
    if (this.mColor != 0) {
      localBundle.putInt("app_color", this.mColor);
    }
    if (this.Fa != null) {
      localBundle.putBundle("car_conversation", a(this.Fa));
    }
    paramc.getExtras().putBundle("android.car.EXTENSIONS", localBundle);
    return paramc;
  }
  
  public static final class a
  {
    final String[] Fb;
    final x Fc;
    final PendingIntent Fd;
    final PendingIntent Fe;
    final String[] Ff;
    final long Fg;
    
    public a(String[] paramArrayOfString1, x paramx, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString2, long paramLong)
    {
      this.Fb = paramArrayOfString1;
      this.Fc = paramx;
      this.Fe = paramPendingIntent2;
      this.Fd = paramPendingIntent1;
      this.Ff = paramArrayOfString2;
      this.Fg = paramLong;
    }
    
    public static final class a
    {
      public x Fc;
      public PendingIntent Fd;
      public PendingIntent Fe;
      public long Fg;
      public final List<String> Fh = new ArrayList();
      public final String Fi;
      
      public a(String paramString)
      {
        this.Fi = paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.app.s.d
 * JD-Core Version:    0.7.0.1
 */