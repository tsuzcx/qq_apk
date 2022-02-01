package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.view.FinderChooseOriginalView;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderOriginalWidget;", "Lcom/tencent/mm/plugin/finder/api/IFinderPostWidget;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "originalView", "Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getOriginalView", "()Lcom/tencent/mm/plugin/finder/view/FinderChooseOriginalView;", "canPost", "", "onCreate", "", "intent", "Landroid/content/Intent;", "postData", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "shouldInterceptBackPress", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements i
{
  private final FinderChooseOriginalView GfI;
  private final String TAG;
  private final MMActivity activity;
  
  public g(MMActivity paramMMActivity, FinderChooseOriginalView paramFinderChooseOriginalView)
  {
    AppMethodBeat.i(342847);
    this.activity = paramMMActivity;
    this.GfI = paramFinderChooseOriginalView;
    this.TAG = "Finder.FinderOriginalWidget";
    AppMethodBeat.o(342847);
  }
  
  public final void c(Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(342852);
    s.u(paramIntent, "intent");
    s.u(paramBundle, "postData");
    paramIntent = this.activity.findViewById(l.e.choose_original_divider);
    this.GfI.setVisibility(8);
    if (paramIntent != null) {
      paramIntent.setVisibility(8);
    }
    AppMethodBeat.o(342852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.g
 * JD-Core Version:    0.7.0.1
 */