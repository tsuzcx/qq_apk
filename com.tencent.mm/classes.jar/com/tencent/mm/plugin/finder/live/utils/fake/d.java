package com.tencent.mm.plugin.finder.live.utils.fake;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftSingleDebug;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "commandList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "createDefault", "giftType", "Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "count", "", "show", "", "Companion", "plugin-finder_release"})
public final class d
{
  private static final String TAG = "MicroMsg.FinderLiveGiftMockDebug";
  public static final a ySd;
  public final MMActivity activity;
  private final a xYp;
  private final LinkedList<c.d> yRP;
  
  static
  {
    AppMethodBeat.i(223297);
    ySd = new a((byte)0);
    TAG = "MicroMsg.FinderLiveGiftMockDebug";
    AppMethodBeat.o(223297);
  }
  
  public d(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(223296);
    this.activity = paramMMActivity;
    this.xYp = parama;
    this.yRP = new LinkedList();
    AppMethodBeat.o(223296);
  }
  
  private final c.d a(e parame, int paramInt)
  {
    AppMethodBeat.i(223289);
    c localc = c.yRV;
    parame = (c.c)c.dES().get(parame);
    if (parame != null)
    {
      parame = parame.NL(paramInt).aCS(((b)this.xYp.business(b.class)).kig);
      AppMethodBeat.o(223289);
      return parame;
    }
    AppMethodBeat.o(223289);
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftSingleDebug$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class b
    implements q.f
  {
    public b(d paramd) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(292191);
      p.j(paramo, "it");
      if (paramo.hJO())
      {
        paramo.d(1, (CharSequence)(e.ySg.ySp + "*1")).setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(289925);
            d.a(this.ySf.ySe).offerLast(d.a(this.ySf.ySe, e.ySg));
            paramAnonymousMenuItem = c.yRV;
            c.ev((List)d.a(this.ySf.ySe));
            AppMethodBeat.o(289925);
            return true;
          }
        });
        paramo.d(2, (CharSequence)(e.ySh.ySp + "*2")).setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(268831);
            d.a(this.ySf.ySe).offerLast(d.a(this.ySf.ySe, e.ySh, 2));
            paramAnonymousMenuItem = c.yRV;
            c.ev((List)d.a(this.ySf.ySe));
            AppMethodBeat.o(268831);
            return true;
          }
        });
        paramo.d(3, (CharSequence)(e.ySi.ySp + "*3")).setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(276963);
            d.a(this.ySf.ySe).offerLast(d.a(this.ySf.ySe, e.ySi, 3));
            paramAnonymousMenuItem = c.yRV;
            c.ev((List)d.a(this.ySf.ySe));
            AppMethodBeat.o(276963);
            return true;
          }
        });
        paramo.d(4, (CharSequence)(e.ySj.ySp + "*4")).setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(286067);
            d.a(this.ySf.ySe).offerLast(d.a(this.ySf.ySe, e.ySj, 4));
            paramAnonymousMenuItem = c.yRV;
            c.ev((List)d.a(this.ySf.ySe));
            AppMethodBeat.o(286067);
            return true;
          }
        });
        paramo.d(5, (CharSequence)(e.ySk.ySp + "*1")).setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(279606);
            d.a(this.ySf.ySe).offerLast(d.a(this.ySf.ySe, e.ySk));
            paramAnonymousMenuItem = c.yRV;
            c.ev((List)d.a(this.ySf.ySe));
            AppMethodBeat.o(279606);
            return true;
          }
        });
        paramo.d(6, (CharSequence)(e.ySl.ySp + "*1")).setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(283837);
            d.a(this.ySf.ySe).offerLast(d.a(this.ySf.ySe, e.ySl));
            paramAnonymousMenuItem = c.yRV;
            c.ev((List)d.a(this.ySf.ySe));
            AppMethodBeat.o(283837);
            return true;
          }
        });
        paramo.d(7, (CharSequence)(e.ySm.ySp + "*1")).setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(277808);
            d.a(this.ySf.ySe).offerLast(d.a(this.ySf.ySe, e.ySm));
            paramAnonymousMenuItem = c.yRV;
            c.ev((List)d.a(this.ySf.ySe));
            AppMethodBeat.o(277808);
            return true;
          }
        });
        paramo.d(8, (CharSequence)(e.ySn.ySp + "*1")).setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(268211);
            d.a(this.ySf.ySe).offerLast(d.a(this.ySf.ySe, e.ySn));
            paramAnonymousMenuItem = c.yRV;
            c.ev((List)d.a(this.ySf.ySe));
            AppMethodBeat.o(268211);
            return true;
          }
        });
      }
      AppMethodBeat.o(292191);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.utils.fake.d
 * JD-Core Version:    0.7.0.1
 */