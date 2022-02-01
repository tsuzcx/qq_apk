package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.utils.at;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/AdConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/AdConvertData;", "isMoreThanOne", "", "(Z)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends f<com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.a>
{
  private static final int DWZ;
  public static final a ENA;
  private static final int akhO;
  private static final int sJv;
  private final boolean akhL;
  
  static
  {
    AppMethodBeat.i(340589);
    ENA = new a((byte)0);
    DWZ = bd.fromDPToPix(MMApplicationContext.getContext(), 12);
    akhO = bd.fromDPToPix(MMApplicationContext.getContext(), 24);
    at localat = at.GiI;
    sJv = at.getScreenWidth();
    AppMethodBeat.o(340589);
  }
  
  public a(boolean paramBoolean)
  {
    this.akhL = paramBoolean;
  }
  
  private static final void a(com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.a parama, j paramj, View paramView)
  {
    AppMethodBeat.i(370499);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/AdConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$item");
    s.u(paramj, "$holder");
    parama = parama.url;
    int i;
    if (((CharSequence)parama).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label163;
      }
    }
    for (;;)
    {
      if (parama != null)
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", parama);
        paramView.putExtra("useJs", true);
        c.b(paramj.context, "webview", ".ui.tools.WebViewUI", paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/AdConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(370499);
      return;
      i = 0;
      break;
      label163:
      parama = null;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(340620);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = paramj.caK.getLayoutParams();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).cbB = true;
    }
    AppMethodBeat.o(340620);
  }
  
  public final int getLayoutId()
  {
    return f.e.EGQ;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/AdConvert$Companion;", "", "()V", "DP_12", "", "DP_24", "TAG", "", "screenWidth", "getScreenWidth", "()I", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static int getScreenWidth()
    {
      AppMethodBeat.i(370535);
      if (aw.ato())
      {
        Context localContext = MMApplicationContext.getContext();
        i = bd.fromDPToPix(localContext, localContext.getResources().getConfiguration().screenWidthDp);
        AppMethodBeat.o(370535);
        return i;
      }
      int i = a.gll();
      AppMethodBeat.o(370535);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.a
 * JD-Core Version:    0.7.0.1
 */