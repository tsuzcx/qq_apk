package android.support.v4.media.session;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import java.util.HashSet;

public final class MediaControllerCompat
{
  final MediaControllerCompat.b CL;
  private final MediaSessionCompat.Token CM;
  private final HashSet<a> CN = new HashSet();
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat.Token paramToken)
  {
    if (paramToken == null) {
      throw new IllegalArgumentException("sessionToken must not be null");
    }
    this.CM = paramToken;
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.CL = new MediaControllerCompat.d(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.CL = new MediaControllerCompat.c(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.CL = new MediaControllerCompat.MediaControllerImplApi21(paramContext, paramToken);
      return;
    }
    this.CL = new MediaControllerCompat.e(this.CM);
  }
  
  public static abstract class a
    implements IBinder.DeathRecipient
  {
    private final Object CO;
    MediaControllerCompat.a.a CQ;
    boolean CR;
    
    public a()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.CO = new c.b(new MediaControllerCompat.a.b(this));
        return;
      }
      this.CO = new MediaControllerCompat.a.c(this);
    }
    
    final void a(int paramInt, Object paramObject, Bundle paramBundle)
    {
      if (this.CQ != null)
      {
        paramObject = this.CQ.obtainMessage(paramInt, paramObject);
        paramObject.setData(paramBundle);
        paramObject.sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat
 * JD-Core Version:    0.7.0.1
 */