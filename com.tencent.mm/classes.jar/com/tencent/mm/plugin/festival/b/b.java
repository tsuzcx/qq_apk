package com.tencent.mm.plugin.festival.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.festival.a.d;
import com.tencent.mm.plugin.festival.a.a.a;
import com.tencent.mm.plugin.festival.ui.bak.FestivalSecondBakUI;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/festival/model/FestivalExportService;", "Lcom/tencent/mm/plugin/festival/api/IFestivalExportService;", "()V", "enterFestivalFinderLiveUI", "", "context", "Landroid/content/Context;", "fromScene", "", "forceCloseFestivalLiveFloatBall", "getFestivalLiveInfo", "Lcom/tencent/mm/plugin/festival/api/IFestivalExportService$FestivalLiveInfo;", "infoUpdateCallback", "Lcom/tencent/mm/plugin/festival/api/IFestivalExportService$LiveInfoUpdateCallback;", "getMultiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "isFestivalLiveOpen", "", "Companion", "plugin-festival_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.festival.a.a
{
  public static final a Arf;
  
  static
  {
    AppMethodBeat.i(260888);
    Arf = new a((byte)0);
    AppMethodBeat.o(260888);
  }
  
  public final boolean dTk()
  {
    return false;
  }
  
  public final a.a dTl()
  {
    AppMethodBeat.i(260907);
    a.a locala = new a.a();
    locala.hU = false;
    locala.Arc = -1L;
    locala.Ard = -1;
    locala.title = MMApplicationContext.getContext().getString(a.d.Arb);
    locala.liveStatus = 2;
    AppMethodBeat.o(260907);
    return locala;
  }
  
  public final void gn(Context paramContext)
  {
    AppMethodBeat.i(260899);
    if (paramContext != null)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(paramContext, FestivalSecondBakUI.class);
      ((Intent)localObject).putExtra("IntentKeyStatusErrorType", 1);
      if (!(paramContext instanceof Activity)) {
        ((Intent)localObject).addFlags(335544320);
      }
      ah localah = ah.aiuX;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/festival/model/FestivalExportService", "enterFestivalFinderLiveUI", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/festival/model/FestivalExportService", "enterFestivalFinderLiveUI", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(260899);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/festival/model/FestivalExportService$Companion;", "", "()V", "TAG", "", "liveStatus", "", "plugin-festival_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.festival.b.b
 * JD-Core Version:    0.7.0.1
 */