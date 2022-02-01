package com.tencent.mm.plugin.festival.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.festival.a.d;
import com.tencent.mm.plugin.festival.a.a.a;
import com.tencent.mm.plugin.festival.ui.bak.FestivalSecondBakUI;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/festival/model/FestivalExportService;", "Lcom/tencent/mm/plugin/festival/api/IFestivalExportService;", "()V", "enterFestivalFinderLiveUI", "", "context", "Landroid/content/Context;", "fromScene", "", "forceCloseFestivalLiveFloatBall", "getFestivalLiveInfo", "Lcom/tencent/mm/plugin/festival/api/IFestivalExportService$FestivalLiveInfo;", "infoUpdateCallback", "Lcom/tencent/mm/plugin/festival/api/IFestivalExportService$LiveInfoUpdateCallback;", "getMultiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "isFestivalLiveOpen", "", "Companion", "plugin-festival_release"})
public final class b
  implements com.tencent.mm.plugin.festival.a.a
{
  public static final a wUx;
  
  static
  {
    AppMethodBeat.i(258595);
    wUx = new a((byte)0);
    AppMethodBeat.o(258595);
  }
  
  public final a.a dmu()
  {
    AppMethodBeat.i(258591);
    a.a locala = new a.a();
    locala.gZ = false;
    locala.wUt = -1L;
    locala.wUu = -1;
    locala.title = MMApplicationContext.getContext().getString(a.d.wUs);
    locala.liveStatus = 2;
    AppMethodBeat.o(258591);
    return locala;
  }
  
  public final void fp(Context paramContext)
  {
    AppMethodBeat.i(258589);
    if (paramContext != null)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(paramContext, FestivalSecondBakUI.class);
      ((Intent)localObject).putExtra("IntentKeyStatusErrorType", 1);
      if (!(paramContext instanceof Activity)) {
        ((Intent)localObject).addFlags(335544320);
      }
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/festival/model/FestivalExportService", "enterFestivalFinderLiveUI", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/festival/model/FestivalExportService", "enterFestivalFinderLiveUI", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(258589);
      return;
    }
    AppMethodBeat.o(258589);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/festival/model/FestivalExportService$Companion;", "", "()V", "TAG", "", "liveStatus", "", "plugin-festival_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.festival.b.b
 * JD-Core Version:    0.7.0.1
 */