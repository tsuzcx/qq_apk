package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.k;
import com.tencent.mm.plugin.findersdk.a.ar;
import com.tencent.mm.plugin.findersdk.a.as;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveNoticePreLoadUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoadUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "liveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
  extends UIComponent
  implements ar
{
  private final k CAx;
  
  public am(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(352733);
    this.CAx = new k((Activity)paramAppCompatActivity);
    AppMethodBeat.o(352733);
  }
  
  public am(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(352740);
    this.CAx = new k(paramFragment);
    AppMethodBeat.o(352740);
  }
  
  public final as eiJ()
  {
    return (as)this.CAx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.am
 * JD-Core Version:    0.7.0.1
 */