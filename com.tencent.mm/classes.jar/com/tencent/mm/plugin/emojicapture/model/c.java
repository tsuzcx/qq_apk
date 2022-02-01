package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.xlabeffect.d;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.a.b;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "TAG", "", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "stickerCommand", "([Ljava/lang/String;)Z", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements a
{
  private final String TAG = "MicroMsg.EmojiCaptureCommand";
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(154);
    s.u(paramArrayOfString, "args");
    s.u(paramString, "username");
    Log.i(this.TAG, s.X("processCommand: ", k.a(paramArrayOfString, (CharSequence)" ", null, null, 0, null, null, 62)));
    if (paramArrayOfString.length <= 1)
    {
      AppMethodBeat.o(154);
      return false;
    }
    if ((s.p(paramArrayOfString[1], "sticker")) && (paramArrayOfString.length > 2))
    {
      paramContext = paramArrayOfString[2];
      if (s.p(paramContext, "clean"))
      {
        paramContext = b.acDc;
        b.iWI();
      }
      for (;;)
      {
        AppMethodBeat.o(154);
        return true;
        if (s.p(paramContext, "assets"))
        {
          paramContext = d.XJR;
          d.iFT();
        }
      }
    }
    AppMethodBeat.o(154);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.c
 * JD-Core Version:    0.7.0.1
 */