package com.tencent.mm.plugin.finder.activity.uic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.activity.view.a;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.post.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderNewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "headerManager", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "getHeaderManager", "()Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "setHeaderManager", "(Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;)V", "headerView", "Landroid/view/View;", "isFirstResume", "", "addParticipateCount", "", "getParticipateCount", "", "getReportKvs", "Lorg/json/JSONObject;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "setCampaignFinished", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends UIComponent
{
  public a AuO;
  private boolean AuP;
  private View pUv;
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(348136);
    this.AuP = true;
    AppMethodBeat.o(348136);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(348161);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 20000))
    {
      paramIntent = this.AuO;
      if (paramIntent != null) {
        paramIntent.dTR();
      }
    }
    AppMethodBeat.o(348161);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(348141);
    super.onCreate(paramBundle);
    this.pUv = getActivity().findViewById(e.e.activity_profile_header);
    paramBundle = new a((MMActivity)getActivity());
    paramBundle.fn(this.pUv);
    ah localah = ah.aiuX;
    this.AuO = paramBundle;
    AppMethodBeat.o(348141);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(348146);
    super.onDestroy();
    a locala = this.AuO;
    if (locala != null) {
      locala.destroy();
    }
    AppMethodBeat.o(348146);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(348153);
    super.onResume();
    if (this.AuP) {
      this.AuP = false;
    }
    a locala = this.AuO;
    if (locala != null)
    {
      if (!this.AuP) {
        locala.dTP();
      }
      if (locala.AwM == null)
      {
        localObject = new di(13);
        h.aZW().a((p)localObject, 0);
      }
      Object localObject = locala.AwN;
      if (localObject != null) {
        ((g)localObject).onResume();
      }
      locala.AwO = null;
    }
    AppMethodBeat.o(348153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.c
 * JD-Core Version:    0.7.0.1
 */