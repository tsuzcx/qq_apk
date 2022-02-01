package com.tencent.mm.plugin.finder.utils.fake;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockDebug;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "MOCK_GIFT_1", "", "getMOCK_GIFT_1", "()I", "MOCK_GIFT_2", "getMOCK_GIFT_2", "MOCK_GIFT_3", "getMOCK_GIFT_3", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "commandList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "relaunchAndOnAnimationEndCurrentCase", "", "relaunchFailCase", "replaceBulletCase", "show", "Companion", "plugin-finder_release"})
public final class b
{
  private static final String TAG = "MicroMsg.FinderLiveGiftMockDebug";
  public static final a waK;
  public final MMActivity activity;
  final int waG;
  final int waH;
  final int waI;
  private final LinkedList<c.d> waJ;
  
  static
  {
    AppMethodBeat.i(253830);
    waK = new a((byte)0);
    TAG = "MicroMsg.FinderLiveGiftMockDebug";
    AppMethodBeat.o(253830);
  }
  
  public b(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(253829);
    this.activity = paramMMActivity;
    this.waG = 1;
    this.waH = 2;
    this.waI = 3;
    this.waJ = new LinkedList();
    AppMethodBeat.o(253829);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockDebug$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class b
    implements o.f
  {
    public b(b paramb) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(253827);
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.d(this.waL.waG, (CharSequence)"爱心1+爱心5延迟4秒(小礼物不消失case)");
        paramm.d(this.waL.waH, (CharSequence)"全自己火箭5+打call1+爱心连击20（连击聚合失效case）");
        paramm.d(this.waL.waI, (CharSequence)"火箭1+自己打call1延迟1秒（大礼物循环播放case）");
      }
      AppMethodBeat.o(253827);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  public static final class c
    implements o.g
  {
    public c(b paramb) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(253828);
      p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == this.waL.waG)
      {
        b.a(this.waL);
        AppMethodBeat.o(253828);
        return;
      }
      if (paramMenuItem.getItemId() == this.waL.waH)
      {
        b.b(this.waL);
        AppMethodBeat.o(253828);
        return;
      }
      if (paramMenuItem.getItemId() == this.waL.waI) {
        b.c(this.waL);
      }
      AppMethodBeat.o(253828);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.fake.b
 * JD-Core Version:    0.7.0.1
 */