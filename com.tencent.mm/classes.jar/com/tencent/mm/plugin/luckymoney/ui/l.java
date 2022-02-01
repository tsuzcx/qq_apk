package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.k.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class l
{
  private static void a(Context paramContext, int paramInt, l.a parama)
  {
    AppMethodBeat.i(284273);
    if ((paramContext == null) || (parama == null))
    {
      Log.e("MicroMsg.LuckySoundUtil", "play Err context:%s pathId:%d speekeron:%s looping:%b", new Object[] { paramContext, Integer.valueOf(paramInt), parama, Boolean.FALSE });
      AppMethodBeat.o(284273);
      return;
    }
    if (!b.aQF())
    {
      AppMethodBeat.o(284273);
      return;
    }
    if (!b.aQL())
    {
      AppMethodBeat.o(284273);
      return;
    }
    String str = paramContext.getString(paramInt);
    k localk = new k();
    if (parama != l.a.KIQ) {
      if (parama != l.a.KIR) {
        break label241;
      }
    }
    for (int i = 5;; i = 0)
    {
      localk.setAudioStreamType(i);
      Log.i("MicroMsg.LuckySoundUtil", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b ", new Object[] { Integer.valueOf(localk.hashCode()), str, paramContext, Integer.valueOf(paramInt), parama, Boolean.FALSE });
      try
      {
        paramContext = paramContext.getAssets().openFd(str);
        localk.setDataSource(paramContext.getFileDescriptor(), paramContext.getStartOffset(), paramContext.getLength());
        paramContext.close();
        localk.setLooping(false);
        localk.prepare();
        localk.start();
        localk.setOnErrorListener(new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(65966);
            Log.i("MicroMsg.LuckySoundUtil", "onError, what: %d, extra: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            AppMethodBeat.o(65966);
            return false;
          }
        });
        localk.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            AppMethodBeat.i(65967);
            if (paramAnonymousMediaPlayer == null) {}
            for (int i = -1;; i = paramAnonymousMediaPlayer.hashCode())
            {
              Log.i("MicroMsg.LuckySoundUtil", "play completion mp:%d  path:%s", new Object[] { Integer.valueOf(i), l.this });
              if (paramAnonymousMediaPlayer != null) {
                paramAnonymousMediaPlayer.release();
              }
              AppMethodBeat.o(65967);
              return;
            }
          }
        });
        AppMethodBeat.o(284273);
        return;
      }
      catch (Exception paramContext)
      {
        label241:
        Log.e("MicroMsg.LuckySoundUtil", "play failed pathId:%d e:%s", new Object[] { Integer.valueOf(paramInt), paramContext.getMessage() });
        Log.printErrStackTrace("MicroMsg.LuckySoundUtil", paramContext, "", new Object[0]);
        AppMethodBeat.o(284273);
      }
    }
  }
  
  public static void play(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(284269);
    a(paramContext, paramInt, l.a.KIQ);
    AppMethodBeat.o(284269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.l
 * JD-Core Version:    0.7.0.1
 */