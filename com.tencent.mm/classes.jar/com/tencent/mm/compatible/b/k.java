package com.tencent.mm.compatible.b;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public final class k
  extends MediaPlayer
{
  public k()
  {
    AppMethodBeat.i(92899);
    g.iL(hashCode());
    AppMethodBeat.o(92899);
  }
  
  public static k d(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(92900);
    try
    {
      k localk = new k();
      localk.setDataSource(paramContext, paramUri);
      localk.prepare();
      AppMethodBeat.o(92900);
      return localk;
    }
    catch (IOException paramContext)
    {
      ab.d("MicroMsg.MediaPlayerWrapper", "create failed:", new Object[] { paramContext });
      AppMethodBeat.o(92900);
      return null;
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        ab.d("MicroMsg.MediaPlayerWrapper", "create failed:", new Object[] { paramContext });
      }
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        ab.d("MicroMsg.MediaPlayerWrapper", "create failed:", new Object[] { paramContext });
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(92901);
    super.release();
    g.iM(hashCode());
    AppMethodBeat.o(92901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.b.k
 * JD-Core Version:    0.7.0.1
 */