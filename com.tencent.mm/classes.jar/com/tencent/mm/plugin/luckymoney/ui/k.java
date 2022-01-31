package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class k
{
  static void a(Context paramContext, k.a parama)
  {
    AppMethodBeat.i(43075);
    if ((paramContext == null) || (parama == null))
    {
      ab.e("MicroMsg.LuckySoundUtil", "play Err context:%s pathId:%d speekeron:%s looping:%b", new Object[] { paramContext, Integer.valueOf(2131301188), parama, Boolean.FALSE });
      AppMethodBeat.o(43075);
      return;
    }
    if (!a.Mx())
    {
      AppMethodBeat.o(43075);
      return;
    }
    if (!a.MB())
    {
      AppMethodBeat.o(43075);
      return;
    }
    String str = paramContext.getString(2131301188);
    com.tencent.mm.compatible.b.k localk = new com.tencent.mm.compatible.b.k();
    if (parama != k.a.oxx) {
      if (parama != k.a.oxy) {
        break label240;
      }
    }
    for (int i = 5;; i = 0)
    {
      localk.setAudioStreamType(i);
      ab.i("MicroMsg.LuckySoundUtil", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b ", new Object[] { Integer.valueOf(localk.hashCode()), str, paramContext, Integer.valueOf(2131301188), parama, Boolean.FALSE });
      try
      {
        paramContext = paramContext.getAssets().openFd(str);
        localk.setDataSource(paramContext.getFileDescriptor(), paramContext.getStartOffset(), paramContext.getLength());
        paramContext.close();
        localk.setLooping(false);
        localk.prepare();
        localk.start();
        localk.setOnErrorListener(new k.1());
        localk.setOnCompletionListener(new k.2(str));
        AppMethodBeat.o(43075);
        return;
      }
      catch (Exception paramContext)
      {
        label240:
        ab.e("MicroMsg.LuckySoundUtil", "play failed pathId:%d e:%s", new Object[] { Integer.valueOf(2131301188), paramContext.getMessage() });
        ab.printErrStackTrace("MicroMsg.LuckySoundUtil", paramContext, "", new Object[0]);
        AppMethodBeat.o(43075);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.k
 * JD-Core Version:    0.7.0.1
 */