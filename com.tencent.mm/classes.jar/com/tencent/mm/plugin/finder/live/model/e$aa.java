package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.ap;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
final class e$aa
  implements DialogInterface.OnClickListener
{
  e$aa(e parame, int paramInt1, int paramInt2, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(276820);
    paramDialogInterface.dismiss();
    paramDialogInterface = "qqmusic://qq.com/media/playSonglist?p=%7b%22song%22%3a%5b%7b%22type%22%3a%220%22%2c%22songid%22%3a%22" + this.yeg + "%22%2c%22songmid%22%3a%22" + this.yeh + "%22%7d%5d%2c%22action%22%3a%22play%22%7d&source=https%3a%2f%2fi.y.qq.com%2fv8%2fplaysong.html%3fADTAG%3dhz_nb_wxzhibo1";
    Object localObject1 = Uri.parse(paramDialogInterface);
    if (localObject1 == null) {
      Log.w(this.ydI.TAG, "goQQMusic parse qq music action url fail, url %s", new Object[] { paramDialogInterface });
    }
    Object localObject2 = new Intent("android.intent.action.VIEW", (Uri)localObject1);
    ((Intent)localObject2).addFlags(268435456);
    localObject1 = this.$context;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$goQQMusic$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$goQQMusic$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    Log.i(this.ydI.TAG, "goQQMusic qqMusicActionUrl: %s", new Object[] { paramDialogInterface });
    m.yCt.NG(s.ap.yJA.type);
    AppMethodBeat.o(276820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.e.aa
 * JD-Core Version:    0.7.0.1
 */