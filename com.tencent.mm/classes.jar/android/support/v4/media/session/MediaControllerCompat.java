package android.support.v4.media.session;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import java.util.HashSet;

public final class MediaControllerCompat
{
  final MediaControllerCompat.b Cd;
  private final MediaSessionCompat.Token Ce;
  private final HashSet<a> Cf = new HashSet();
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat.Token paramToken)
  {
    if (paramToken == null) {
      throw new IllegalArgumentException("sessionToken must not be null");
    }
    this.Ce = paramToken;
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.Cd = new MediaControllerCompat.d(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.Cd = new c(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.Cd = new MediaControllerCompat.MediaControllerImplApi21(paramContext, paramToken);
      return;
    }
    this.Cd = new MediaControllerCompat.e(this.Ce);
  }
  
  public static abstract class a
    implements IBinder.DeathRecipient
  {
    private final Object Cg;
    MediaControllerCompat.a.a Ch;
    boolean Ci;
    
    public a()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.Cg = new c.b(new MediaControllerCompat.a.b(this));
        return;
      }
      this.Cg = new MediaControllerCompat.a.c(this);
    }
    
    final void a(int paramInt, Object paramObject, Bundle paramBundle)
    {
      if (this.Ch != null)
      {
        paramObject = this.Ch.obtainMessage(paramInt, paramObject);
        paramObject.setData(paramBundle);
        paramObject.sendToTarget();
      }
    }
  }
  
  static class c
    extends MediaControllerCompat.MediaControllerImplApi21
  {
    public c(Context paramContext, MediaSessionCompat.Token paramToken)
    {
      super(paramToken);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat
 * JD-Core Version:    0.7.0.1
 */