package com.tencent.mm.plugin.finder.activity.uic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.activity.view.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.live.ui.post.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderNewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "headerManager", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "headerView", "Landroid/view/View;", "isFirstResume", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "setCampaignFinished", "plugin-finder_release"})
public final class c
  extends UIComponent
{
  private View mXN;
  a wXQ;
  private boolean wXR;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(282735);
    this.wXR = true;
    AppMethodBeat.o(282735);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(282734);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 20000))
    {
      paramIntent = this.wXQ;
      if (paramIntent != null)
      {
        paramIntent.dmX();
        AppMethodBeat.o(282734);
        return;
      }
    }
    AppMethodBeat.o(282734);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(282731);
    super.onCreate(paramBundle);
    this.mXN = getActivity().findViewById(b.f.activity_profile_header);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(282731);
      throw paramBundle;
    }
    paramBundle = new a((MMActivity)paramBundle);
    paramBundle.ep(this.mXN);
    this.wXQ = paramBundle;
    AppMethodBeat.o(282731);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(282732);
    super.onDestroy();
    a locala = this.wXQ;
    if (locala != null)
    {
      locala.destroy();
      AppMethodBeat.o(282732);
      return;
    }
    AppMethodBeat.o(282732);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(282733);
    super.onResume();
    if (this.wXR) {
      this.wXR = false;
    }
    Object localObject = this.wXQ;
    if (localObject != null)
    {
      if (!this.wXR) {
        ((a)localObject).dmV();
      }
      if (((a)localObject).wZz == null)
      {
        ch localch = new ch(13);
        h.aGY().b((q)localch);
      }
      localObject = ((a)localObject).wZA;
      if (localObject != null)
      {
        ((d)localObject).onResume();
        AppMethodBeat.o(282733);
        return;
      }
      AppMethodBeat.o(282733);
      return;
    }
    AppMethodBeat.o(282733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.c
 * JD-Core Version:    0.7.0.1
 */