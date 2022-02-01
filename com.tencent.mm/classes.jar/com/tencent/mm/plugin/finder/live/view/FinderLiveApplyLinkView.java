package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveApplyLinkView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onAcceptBattle", "", "onBattleActionFail", "actionType", "onBattleActionSucc", "onBind", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "onHideLinkMicPanel", "onKeyboardChange", "show", "", "height", "onMicSettingChanged", "micSettingFlag", "", "onNotifyDataChanged", "onNotifyHungup", "isSuccess", "micUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "onTimerUpdateData", "showBattlePanel", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FinderLiveApplyLinkView
  extends RelativeLayout
{
  public FinderLiveApplyLinkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FinderLiveApplyLinkView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void O(boolean paramBoolean, int paramInt);
  
  public abstract void a(a parama, ap paramap);
  
  public abstract void b(boolean paramBoolean, h paramh);
  
  public abstract void dvs();
  
  public void epf() {}
  
  public void epg() {}
  
  public abstract void euZ();
  
  public void eva() {}
  
  public void evb() {}
  
  public abstract void oU(long paramLong);
  
  public abstract void t(a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveApplyLinkView
 * JD-Core Version:    0.7.0.1
 */