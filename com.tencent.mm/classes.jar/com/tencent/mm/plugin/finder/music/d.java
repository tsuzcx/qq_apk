package com.tencent.mm.plugin.finder.music;

import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bxt;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/music/IFinderFollowTopicHeaderView;", "", "bindOriginFeed", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "bgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "tabType", "", "flag", "onDettach", "onFollowBtnClick", "onResume", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
{
  public abstract void a(FinderItem paramFinderItem, bxt parambxt, int paramInt1, int paramInt2);
  
  public abstract void eDL();
  
  public abstract void eDM();
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.d
 * JD-Core Version:    0.7.0.1
 */