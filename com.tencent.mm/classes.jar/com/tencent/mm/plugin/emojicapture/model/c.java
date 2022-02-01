package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sticker.a.b;
import d.a.e;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "TAG", "", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "stickerCommand", "([Ljava/lang/String;)Z", "plugin-emojicapture_release"})
public final class c
  implements a
{
  private final String TAG = "MicroMsg.EmojiCaptureCommand";
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(154);
    k.h(paramArrayOfString, "args");
    k.h(paramString, "username");
    ad.i(this.TAG, "processCommand: " + e.a(paramArrayOfString, (CharSequence)" ", null, null, 0, null, null, 62));
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
        paramContext = com.tencent.mm.plugin.xlabeffect.c.BMk;
        com.tencent.mm.plugin.xlabeffect.c.eut();
        continue;
        if (paramContext.equals("clean"))
        {
          paramContext = b.FdI;
          b.eJj();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.c
 * JD-Core Version:    0.7.0.1
 */