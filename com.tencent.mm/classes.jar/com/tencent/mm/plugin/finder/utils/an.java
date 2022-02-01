package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.a;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.c;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil;", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface an
{
  public static final an.a GhR = an.a.GhS;
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareLiveToSnsTimeLineInternal$1", "Lcom/tencent/mm/ui/MMFragmentActivity$IMMOnFragmentActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a$a
    implements MMFragmentActivity.c
  {
    a$a(AppCompatActivity paramAppCompatActivity, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(333332);
      BaseFinderFeed localBaseFinderFeed;
      if (paramInt2 == -1)
      {
        com.tencent.mm.ui.base.k.cZ((Context)this.AIx, this.AIx.getString(e.h.app_shared));
        paramIntent = com.tencent.mm.ui.component.k.aeZF;
        paramIntent = com.tencent.mm.ui.component.k.d(this.AIx).q(as.class);
        s.s(paramIntent, "UICProvider.of(context).…rReporterUIC::class.java)");
        paramIntent = ((bn)paramIntent).foy();
        if (paramIntent != null)
        {
          localBaseFinderFeed = this.$feed;
          paramIntent.dYj().mV(localBaseFinderFeed.bZA());
        }
        paramIntent = new JSONObject();
        paramIntent.put("type", "2");
        ((ce)h.ax(ce.class)).a(q.c.Drl, paramIntent.toString());
        paramIntent = an.a.GhS;
        an.a.n(this.$feed);
        AppMethodBeat.o(333332);
        return;
      }
      paramIntent = com.tencent.mm.ui.component.k.aeZF;
      paramIntent = com.tencent.mm.ui.component.k.d(this.AIx).q(as.class);
      s.s(paramIntent, "UICProvider.of(context).…rReporterUIC::class.java)");
      paramIntent = ((bn)paramIntent).foy();
      if (paramIntent != null)
      {
        localBaseFinderFeed = this.$feed;
        paramIntent.dYj().mX(localBaseFinderFeed.bZA());
      }
      paramIntent = new JSONObject();
      paramIntent.put("type", "4");
      ((ce)h.ax(ce.class)).a(q.c.Drl, paramIntent.toString());
      AppMethodBeat.o(333332);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$sharePoiFeedToSnsTimeLine$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a$b
    implements MMActivity.a
  {
    a$b(MMActivity paramMMActivity) {}
    
    public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(333320);
      if (paramInt2 == -1) {
        com.tencent.mm.ui.base.k.cZ((Context)this.AXj, this.AXj.getString(e.h.app_shared));
      }
      AppMethodBeat.o(333320);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareToSnsTimeLineInternal$2", "Lcom/tencent/mm/ui/MMFragmentActivity$IMMOnFragmentActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a$d
    implements MMFragmentActivity.c
  {
    a$d(MMFragmentActivity paramMMFragmentActivity, BaseFinderFeed paramBaseFinderFeed, int paramInt, bui parambui) {}
    
    public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(333343);
      BaseFinderFeed localBaseFinderFeed;
      if (paramInt2 == -1)
      {
        com.tencent.mm.ui.base.k.cZ((Context)this.GhU, this.GhU.getString(e.h.app_shared));
        paramIntent = com.tencent.mm.ui.component.k.aeZF;
        paramIntent = com.tencent.mm.ui.component.k.d((AppCompatActivity)this.GhU).q(as.class);
        s.s(paramIntent, "UICProvider.of(context).…rReporterUIC::class.java)");
        paramIntent = ((bn)paramIntent).foy();
        if (paramIntent != null)
        {
          localBaseFinderFeed = this.$feed;
          paramIntent.dYj().mV(localBaseFinderFeed.bZA());
        }
        if (paramInt2 != -1) {
          break label218;
        }
      }
      label218:
      for (long l = 1L;; l = 2L)
      {
        if (this.$feed.feedObject.getFromType() != 32768) {
          break label226;
        }
        z.a(z.FrZ, new ca(this.$feed.feedObject.getFeedObject()), this.GhV, l, "", this.$contextObj);
        AppMethodBeat.o(333343);
        return;
        paramIntent = com.tencent.mm.ui.component.k.aeZF;
        paramIntent = com.tencent.mm.ui.component.k.d((AppCompatActivity)this.GhU).q(as.class);
        s.s(paramIntent, "UICProvider.of(context).…rReporterUIC::class.java)");
        paramIntent = ((bn)paramIntent).foy();
        if (paramIntent == null) {
          break;
        }
        localBaseFinderFeed = this.$feed;
        paramIntent.dYj().mX(localBaseFinderFeed.bZA());
        break;
      }
      label226:
      paramIntent = z.FrZ;
      z.a(this.$feed.feedObject.getId(), this.GhV, l, "", this.$contextObj, 0L, this.$feed.feedObject, 32);
      AppMethodBeat.o(333343);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.an
 * JD-Core Version:    0.7.0.1
 */