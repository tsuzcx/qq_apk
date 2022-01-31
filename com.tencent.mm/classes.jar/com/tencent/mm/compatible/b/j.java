package com.tencent.mm.compatible.b;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class j
  extends MediaPlayer
{
  public j()
  {
    f.gw(hashCode());
  }
  
  public static j d(Context paramContext, Uri paramUri)
  {
    try
    {
      j localj = new j();
      localj.setDataSource(paramContext, paramUri);
      localj.prepare();
      return localj;
    }
    catch (IOException paramContext)
    {
      y.d("MicroMsg.MediaPlayerWrapper", "create failed:", new Object[] { paramContext });
      return null;
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        y.d("MicroMsg.MediaPlayerWrapper", "create failed:", new Object[] { paramContext });
      }
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        y.d("MicroMsg.MediaPlayerWrapper", "create failed:", new Object[] { paramContext });
      }
    }
  }
  
  public final void release()
  {
    super.release();
    f.gx(hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.b.j
 * JD-Core Version:    0.7.0.1
 */