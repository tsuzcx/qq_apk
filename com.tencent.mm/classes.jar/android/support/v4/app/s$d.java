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
  public a HZ;
  private Bitmap Hy;
  private int mColor = 0;
  
  private static Bundle a(a parama)
  {
    int i = 0;
    Bundle localBundle1 = new Bundle();
    Parcelable[] arrayOfParcelable = null;
    Object localObject = arrayOfParcelable;
    if (parama.If != null)
    {
      localObject = arrayOfParcelable;
      if (parama.If.length > 1) {
        localObject = parama.If[0];
      }
    }
    arrayOfParcelable = new Parcelable[parama.Ia.length];
    while (i < arrayOfParcelable.length)
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("text", parama.Ia[i]);
      localBundle2.putString("author", (String)localObject);
      arrayOfParcelable[i] = localBundle2;
      i += 1;
    }
    localBundle1.putParcelableArray("messages", arrayOfParcelable);
    localObject = parama.Ib;
    if (localObject != null) {
      localBundle1.putParcelable("remote_input", new RemoteInput.Builder(((x)localObject).II).setLabel(((x)localObject).IJ).setChoices(((x)localObject).IK).setAllowFreeFormInput(((x)localObject).IL).addExtras(((x)localObject).mExtras).build());
    }
    localBundle1.putParcelable("on_reply", parama.Ic);
    localBundle1.putParcelable("on_read", parama.Ie);
    localBundle1.putStringArray("participants", parama.If);
    localBundle1.putLong("timestamp", parama.Ig);
    return localBundle1;
  }
  
  public final s.c a(s.c paramc)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return paramc;
    }
    Bundle localBundle = new Bundle();
    if (this.Hy != null) {
      localBundle.putParcelable("large_icon", this.Hy);
    }
    if (this.mColor != 0) {
      localBundle.putInt("app_color", this.mColor);
    }
    if (this.HZ != null) {
      localBundle.putBundle("car_conversation", a(this.HZ));
    }
    paramc.getExtras().putBundle("android.car.EXTENSIONS", localBundle);
    return paramc;
  }
  
  public static final class a
  {
    final String[] Ia;
    final x Ib;
    final PendingIntent Ic;
    final PendingIntent Ie;
    final String[] If;
    final long Ig;
    
    public a(String[] paramArrayOfString1, x paramx, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString2, long paramLong)
    {
      this.Ia = paramArrayOfString1;
      this.Ib = paramx;
      this.Ie = paramPendingIntent2;
      this.Ic = paramPendingIntent1;
      this.If = paramArrayOfString2;
      this.Ig = paramLong;
    }
    
    public static final class a
    {
      public x Ib;
      public PendingIntent Ic;
      public PendingIntent Ie;
      public long Ig;
      public final List<String> Ih = new ArrayList();
      public final String Ii;
      
      public a(String paramString)
      {
        this.Ii = paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.app.s.d
 * JD-Core Version:    0.7.0.1
 */