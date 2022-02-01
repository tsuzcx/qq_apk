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
  public a FY;
  private Bitmap Fx;
  private int mColor = 0;
  
  private static Bundle a(a parama)
  {
    int i = 0;
    Bundle localBundle1 = new Bundle();
    Parcelable[] arrayOfParcelable = null;
    Object localObject = arrayOfParcelable;
    if (parama.Gd != null)
    {
      localObject = arrayOfParcelable;
      if (parama.Gd.length > 1) {
        localObject = parama.Gd[0];
      }
    }
    arrayOfParcelable = new Parcelable[parama.FZ.length];
    while (i < arrayOfParcelable.length)
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("text", parama.FZ[i]);
      localBundle2.putString("author", (String)localObject);
      arrayOfParcelable[i] = localBundle2;
      i += 1;
    }
    localBundle1.putParcelableArray("messages", arrayOfParcelable);
    localObject = parama.Ga;
    if (localObject != null) {
      localBundle1.putParcelable("remote_input", new RemoteInput.Builder(((x)localObject).GF).setLabel(((x)localObject).GG).setChoices(((x)localObject).GH).setAllowFreeFormInput(((x)localObject).GI).addExtras(((x)localObject).mExtras).build());
    }
    localBundle1.putParcelable("on_reply", parama.Gb);
    localBundle1.putParcelable("on_read", parama.Gc);
    localBundle1.putStringArray("participants", parama.Gd);
    localBundle1.putLong("timestamp", parama.Ge);
    return localBundle1;
  }
  
  public final s.c a(s.c paramc)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return paramc;
    }
    Bundle localBundle = new Bundle();
    if (this.Fx != null) {
      localBundle.putParcelable("large_icon", this.Fx);
    }
    if (this.mColor != 0) {
      localBundle.putInt("app_color", this.mColor);
    }
    if (this.FY != null) {
      localBundle.putBundle("car_conversation", a(this.FY));
    }
    paramc.getExtras().putBundle("android.car.EXTENSIONS", localBundle);
    return paramc;
  }
  
  public static final class a
  {
    final String[] FZ;
    final x Ga;
    final PendingIntent Gb;
    final PendingIntent Gc;
    final String[] Gd;
    final long Ge;
    
    public a(String[] paramArrayOfString1, x paramx, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString2, long paramLong)
    {
      this.FZ = paramArrayOfString1;
      this.Ga = paramx;
      this.Gc = paramPendingIntent2;
      this.Gb = paramPendingIntent1;
      this.Gd = paramArrayOfString2;
      this.Ge = paramLong;
    }
    
    public static final class a
    {
      public x Ga;
      public PendingIntent Gb;
      public PendingIntent Gc;
      public long Ge;
      public final List<String> Gf = new ArrayList();
      public final String Gg;
      
      public a(String paramString)
      {
        this.Gg = paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.app.s.d
 * JD-Core Version:    0.7.0.1
 */