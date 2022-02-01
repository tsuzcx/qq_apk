package com.tencent.mm.plugin.emoji.ui.v3;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.p;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.viewpager.widget.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.mogic.WxViewPager;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3HomePagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "activity", "Landroidx/fragment/app/FragmentActivity;", "currentIndex", "", "pageChangedListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "pager", "Lcom/tencent/mm/ui/mogic/WxViewPager;", "enablePersonTab", "", "fragmentRequest", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "Lcom/tencent/mm/ui/MMFragment;", "(Landroidx/fragment/app/FragmentActivity;ILandroidx/viewpager/widget/ViewPager$OnPageChangeListener;Lcom/tencent/mm/ui/mogic/WxViewPager;ZLkotlin/jvm/functions/Function1;)V", "DEFAULT_NO_TAB_SIZE", "DEFAULT_TAB_SIZE", "getEnablePersonTab", "()Z", "getFragmentRequest", "()Lkotlin/jvm/functions/Function1;", "getPager", "()Lcom/tencent/mm/ui/mogic/WxViewPager;", "getCount", "getItem", "position", "onViewDestroy", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends p
{
  private final WxViewPager xZY;
  private final boolean xZZ;
  private final b<Integer, MMFragment> yaa;
  private final int yab;
  private final int yac;
  
  public c(FragmentActivity paramFragmentActivity, int paramInt, ViewPager.OnPageChangeListener paramOnPageChangeListener, WxViewPager paramWxViewPager, boolean paramBoolean, b<? super Integer, ? extends MMFragment> paramb)
  {
    super(paramFragmentActivity.getSupportFragmentManager());
    AppMethodBeat.i(270446);
    this.xZY = paramWxViewPager;
    this.xZZ = paramBoolean;
    this.yaa = paramb;
    this.yab = 2;
    this.yac = 1;
    this.xZY.setAdapter((a)this);
    this.xZY.setOnPageChangeListener(paramOnPageChangeListener);
    this.xZY.setCurrentItem(paramInt);
    AppMethodBeat.o(270446);
  }
  
  public final MMFragment KB(int paramInt)
  {
    AppMethodBeat.i(270452);
    MMFragment localMMFragment = (MMFragment)this.yaa.invoke(Integer.valueOf(paramInt));
    AppMethodBeat.o(270452);
    return localMMFragment;
  }
  
  public final int getCount()
  {
    if (this.xZZ) {
      return this.yab;
    }
    return this.yac;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.c
 * JD-Core Version:    0.7.0.1
 */