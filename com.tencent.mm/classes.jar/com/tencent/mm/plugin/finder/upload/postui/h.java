package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.FinderChooseNewsView;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderSetNewsFeedWidget;", "Lcom/tencent/mm/plugin/finder/api/IFinderPostWidget;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "newsView", "Lcom/tencent/mm/plugin/finder/view/FinderChooseNewsView;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderChooseNewsView;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "getNewsView", "()Lcom/tencent/mm/plugin/finder/view/FinderChooseNewsView;", "canPost", "", "isChecked", "onCreate", "", "intent", "Landroid/content/Intent;", "postData", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "shouldInterceptBackPress", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements i
{
  private final FinderChooseNewsView GfJ;
  private final MMActivity activity;
  
  public h(MMActivity paramMMActivity, FinderChooseNewsView paramFinderChooseNewsView)
  {
    AppMethodBeat.i(342850);
    this.activity = paramMMActivity;
    this.GfJ = paramFinderChooseNewsView;
    AppMethodBeat.o(342850);
  }
  
  public final void c(Intent paramIntent, Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(342855);
    s.u(paramIntent, "intent");
    s.u(paramBundle, "postData");
    paramIntent = (TextView)this.activity.findViewById(l.e.choose_news_divider);
    Object localObject = av.GiL;
    boolean bool = av.ffX();
    localObject = this.GfJ;
    if (bool)
    {
      i = 0;
      ((FinderChooseNewsView)localObject).setVisibility(i);
      if (!bool) {
        break label98;
      }
    }
    label98:
    for (int i = j;; i = 8)
    {
      paramIntent.setVisibility(i);
      paramBundle.putBoolean("isNews", isChecked());
      AppMethodBeat.o(342855);
      return;
      i = 8;
      break;
    }
  }
  
  public final boolean isChecked()
  {
    AppMethodBeat.i(342867);
    av localav = av.GiL;
    if ((av.ffX()) && (this.GfJ.getCheckBox().isChecked()))
    {
      AppMethodBeat.o(342867);
      return true;
    }
    AppMethodBeat.o(342867);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.h
 * JD-Core Version:    0.7.0.1
 */