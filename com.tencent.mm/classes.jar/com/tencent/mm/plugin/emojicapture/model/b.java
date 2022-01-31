package com.tencent.mm.plugin.emojicapture.model;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "TAG", "", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "stickerCommand", "([Ljava/lang/String;)Z", "plugin-emojicapture_release"})
public final class b
  implements a
{
  private final String TAG = "MicroMsg.EmojiCaptureCommand";
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(2575);
    j.q(paramArrayOfString, "args");
    j.q(paramString, "username");
    ab.i(this.TAG, "processCommand: " + a.a.e.a(paramArrayOfString, (CharSequence)" ", null, null, 0, null, null, 62));
    if (paramArrayOfString.length <= 1)
    {
      AppMethodBeat.o(2575);
      return false;
    }
    paramContext = paramArrayOfString[1];
    switch (paramContext.hashCode())
    {
    }
    do
    {
      AppMethodBeat.o(2575);
      return false;
    } while ((!paramContext.equals("sticker")) || (paramArrayOfString.length <= 2));
    paramContext = paramArrayOfString[2];
    switch (paramContext.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(2575);
      return true;
      if (paramContext.equals("assets"))
      {
        paramContext = com.tencent.mm.plugin.emojicapture.model.a.e.luf;
        com.tencent.mm.vfs.e.cO(com.tencent.mm.plugin.emojicapture.model.a.e.boC());
        paramContext = com.tencent.mm.plugin.emojicapture.model.a.e.luf;
        com.tencent.mm.plugin.emojicapture.model.a.e.boF();
        continue;
        if (paramContext.equals("clean"))
        {
          paramContext = com.tencent.mm.plugin.emojicapture.model.a.e.luf;
          com.tencent.mm.vfs.e.cO(com.tencent.mm.plugin.emojicapture.model.a.e.boC());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b
 * JD-Core Version:    0.7.0.1
 */