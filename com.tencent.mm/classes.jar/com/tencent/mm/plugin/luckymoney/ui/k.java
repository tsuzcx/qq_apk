package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.m.a;
import com.tencent.mm.sdk.platformtools.y;

public final class k
{
  public static void G(Context paramContext, int paramInt)
  {
    k.a locala = k.a.lXY;
    if ((paramContext == null) || (locala == null)) {
      y.e("MicroMsg.LuckySoundUtil", "play Err context:%s pathId:%d speekeron:%s looping:%b", new Object[] { paramContext, Integer.valueOf(paramInt), locala, Boolean.valueOf(false) });
    }
    while ((!a.zQ()) || (!a.zT())) {
      return;
    }
    String str = paramContext.getString(paramInt);
    j localj = new j();
    if (locala != k.a.lXY) {
      if (locala != k.a.lXZ) {
        break label261;
      }
    }
    label261:
    for (int i = 5;; i = 0)
    {
      localj.setAudioStreamType(i);
      y.i("MicroMsg.LuckySoundUtil", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b ", new Object[] { Integer.valueOf(localj.hashCode()), str, paramContext, Integer.valueOf(paramInt), locala, Boolean.valueOf(false) });
      try
      {
        paramContext = paramContext.getAssets().openFd(str);
        localj.setDataSource(paramContext.getFileDescriptor(), paramContext.getStartOffset(), paramContext.getLength());
        paramContext.close();
        localj.setLooping(false);
        localj.prepare();
        localj.start();
        localj.setOnErrorListener(new k.1());
        localj.setOnCompletionListener(new k.2(str));
        return;
      }
      catch (Exception paramContext)
      {
        y.e("MicroMsg.LuckySoundUtil", "play failed pathId:%d e:%s", new Object[] { Integer.valueOf(paramInt), paramContext.getMessage() });
        y.printErrStackTrace("MicroMsg.LuckySoundUtil", paramContext, "", new Object[0]);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.k
 * JD-Core Version:    0.7.0.1
 */