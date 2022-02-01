package com.tencent.mm.plugin.finder.utils.fake;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftSingleDebug;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "commandList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "show", "", "Companion", "plugin-finder_release"})
public final class d
{
  private static final String TAG = "MicroMsg.FinderLiveGiftMockDebug";
  public static final a waW;
  public final MMActivity activity;
  private final LinkedList<c.d> waJ;
  
  static
  {
    AppMethodBeat.i(253856);
    waW = new a((byte)0);
    TAG = "MicroMsg.FinderLiveGiftMockDebug";
    AppMethodBeat.o(253856);
  }
  
  public d(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(253855);
    this.activity = paramMMActivity;
    this.waJ = new LinkedList();
    AppMethodBeat.o(253855);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftSingleDebug$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class b
    implements o.f
  {
    public b(d paramd) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(253854);
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.d(1, (CharSequence)"爱心*1").setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(253847);
            LinkedList localLinkedList = d.a(this.waY.waX);
            paramAnonymousMenuItem = c.waP;
            paramAnonymousMenuItem = (c.c)c.dEK().get(e.waZ);
            if (paramAnonymousMenuItem != null) {}
            for (paramAnonymousMenuItem = paramAnonymousMenuItem.Ma(1);; paramAnonymousMenuItem = null)
            {
              localLinkedList.offerLast(paramAnonymousMenuItem);
              paramAnonymousMenuItem = c.waP;
              c.eD((List)d.a(this.waY.waX));
              AppMethodBeat.o(253847);
              return true;
            }
          }
        });
        paramm.d(2, (CharSequence)"鼓掌*2").setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(253848);
            LinkedList localLinkedList = d.a(this.waY.waX);
            paramAnonymousMenuItem = c.waP;
            paramAnonymousMenuItem = (c.c)c.dEK().get(e.wba);
            if (paramAnonymousMenuItem != null) {}
            for (paramAnonymousMenuItem = paramAnonymousMenuItem.Ma(2);; paramAnonymousMenuItem = null)
            {
              localLinkedList.offerLast(paramAnonymousMenuItem);
              paramAnonymousMenuItem = c.waP;
              c.eD((List)d.a(this.waY.waX));
              AppMethodBeat.o(253848);
              return true;
            }
          }
        });
        paramm.d(3, (CharSequence)"小花*3").setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(253849);
            LinkedList localLinkedList = d.a(this.waY.waX);
            paramAnonymousMenuItem = c.waP;
            paramAnonymousMenuItem = (c.c)c.dEK().get(e.wbb);
            if (paramAnonymousMenuItem != null) {}
            for (paramAnonymousMenuItem = paramAnonymousMenuItem.Ma(3);; paramAnonymousMenuItem = null)
            {
              localLinkedList.offerLast(paramAnonymousMenuItem);
              paramAnonymousMenuItem = c.waP;
              c.eD((List)d.a(this.waY.waX));
              AppMethodBeat.o(253849);
              return true;
            }
          }
        });
        paramm.d(4, (CharSequence)"奶茶*4").setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(253850);
            LinkedList localLinkedList = d.a(this.waY.waX);
            paramAnonymousMenuItem = c.waP;
            paramAnonymousMenuItem = (c.c)c.dEK().get(e.wbc);
            if (paramAnonymousMenuItem != null) {}
            for (paramAnonymousMenuItem = paramAnonymousMenuItem.Ma(4);; paramAnonymousMenuItem = null)
            {
              localLinkedList.offerLast(paramAnonymousMenuItem);
              paramAnonymousMenuItem = c.waP;
              c.eD((List)d.a(this.waY.waX));
              AppMethodBeat.o(253850);
              return true;
            }
          }
        });
        paramm.d(5, (CharSequence)"打call*1").setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(253851);
            LinkedList localLinkedList = d.a(this.waY.waX);
            paramAnonymousMenuItem = c.waP;
            paramAnonymousMenuItem = (c.c)c.dEK().get(e.wbd);
            if (paramAnonymousMenuItem != null) {}
            for (paramAnonymousMenuItem = paramAnonymousMenuItem.Ma(1);; paramAnonymousMenuItem = null)
            {
              localLinkedList.offerLast(paramAnonymousMenuItem);
              paramAnonymousMenuItem = c.waP;
              c.eD((List)d.a(this.waY.waX));
              AppMethodBeat.o(253851);
              return true;
            }
          }
        });
        paramm.d(6, (CharSequence)"火箭*1").setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(253852);
            LinkedList localLinkedList = d.a(this.waY.waX);
            paramAnonymousMenuItem = c.waP;
            paramAnonymousMenuItem = (c.c)c.dEK().get(e.wbe);
            if (paramAnonymousMenuItem != null) {}
            for (paramAnonymousMenuItem = paramAnonymousMenuItem.Ma(1);; paramAnonymousMenuItem = null)
            {
              localLinkedList.offerLast(paramAnonymousMenuItem);
              paramAnonymousMenuItem = c.waP;
              c.eD((List)d.a(this.waY.waX));
              AppMethodBeat.o(253852);
              return true;
            }
          }
        });
        paramm.d(7, (CharSequence)"桃花岛*1").setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(253853);
            LinkedList localLinkedList = d.a(this.waY.waX);
            paramAnonymousMenuItem = c.waP;
            paramAnonymousMenuItem = (c.c)c.dEK().get(e.wbf);
            if (paramAnonymousMenuItem != null) {}
            for (paramAnonymousMenuItem = paramAnonymousMenuItem.Ma(1);; paramAnonymousMenuItem = null)
            {
              localLinkedList.offerLast(paramAnonymousMenuItem);
              paramAnonymousMenuItem = c.waP;
              c.eD((List)d.a(this.waY.waX));
              AppMethodBeat.o(253853);
              return true;
            }
          }
        });
      }
      AppMethodBeat.o(253854);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.fake.d
 * JD-Core Version:    0.7.0.1
 */