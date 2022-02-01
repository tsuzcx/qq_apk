package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "TAG", "", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "stickerCommand", "([Ljava/lang/String;)Z", "plugin-emojicapture_release"})
public final class c
  implements a
{
  private final String TAG = "MicroMsg.EmojiCaptureCommand";
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(154);
    p.h(paramArrayOfString, "args");
    p.h(paramString, "username");
    Log.i(this.TAG, "processCommand: " + kotlin.a.e.a(paramArrayOfString, (CharSequence)" ", null, null, 0, null, null, 62));
    if (paramArrayOfString.length <= 1)
    {
      AppMethodBeat.o(154);
      return false;
    }
    paramContext = paramArrayOfString[1];
    switch (paramContext.hashCode())
    {
    }
    do
    {
      AppMethodBeat.o(154);
      return false;
    } while ((!paramContext.equals("sticker")) || (paramArrayOfString.length <= 2));
    paramContext = paramArrayOfString[2];
    switch (paramContext.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(154);
      return true;
      if (paramContext.equals("assets"))
      {
        paramContext = com.tencent.mm.plugin.xlabeffect.e.JRF;
        com.tencent.mm.plugin.xlabeffect.e.glw();
        continue;
        if (paramContext.equals("clean"))
        {
          paramContext = b.NOi;
          b.gzh();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.c
 * JD-Core Version:    0.7.0.1
 */