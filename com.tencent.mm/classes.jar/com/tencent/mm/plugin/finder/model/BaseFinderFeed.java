package com.tencent.mm.plugin.finder.model;

import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.view.recyclerview.a;
import d.g.b.k;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "getCommentList", "()Ljava/util/LinkedList;", "setCommentList", "(Ljava/util/LinkedList;)V", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "setContact", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "getFeedObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeedObject", "footerWording", "", "getFooterWording", "()Ljava/lang/String;", "setFooterWording", "(Ljava/lang/String;)V", "headerWording", "getHeaderWording", "setHeaderWording", "isContentCollapsed", "", "()Z", "setContentCollapsed", "(Z)V", "isNeedShowUnFollow", "setNeedShowUnFollow", "showLikeTips", "getShowLikeTips", "setShowLikeTips", "compare", "", "obj", "equals", "other", "", "getItemId", "", "getItemType", "hashCode", "onStore", "", "printSimpleId", "toString", "plugin-finder_release"})
public abstract class BaseFinderFeed
  implements i, a
{
  private LinkedList<h> commentList;
  public f contact;
  public FinderItem feedObject;
  public String footerWording;
  public String headerWording;
  public boolean isContentCollapsed;
  private boolean isNeedShowUnFollow;
  public boolean showLikeTips;
  
  public BaseFinderFeed(FinderItem paramFinderItem)
  {
    this.feedObject = paramFinderItem;
    this.commentList = new LinkedList();
    this.isContentCollapsed = true;
    this.headerWording = "";
    this.footerWording = "";
  }
  
  public final int a(i parami)
  {
    k.h(parami, "obj");
    if (!(parami instanceof BaseFinderFeed)) {}
    for (Object localObject = null;; localObject = parami)
    {
      localObject = (BaseFinderFeed)localObject;
      if (localObject != null)
      {
        if ((this.feedObject.getMediaType() == 9999) && (((BaseFinderFeed)parami).feedObject.getMediaType() == 9999)) {
          return 0;
        }
        if ((((BaseFinderFeed)localObject).feedObject.field_id != 0L) && (this.feedObject.field_id != 0L) && (((BaseFinderFeed)localObject).feedObject.field_id == this.feedObject.field_id)) {
          return 0;
        }
        if ((((BaseFinderFeed)localObject).feedObject.getLocalId() > 0L) && (this.feedObject.getLocalId() > 0L) && (((BaseFinderFeed)localObject).feedObject.getLocalId() == this.feedObject.getLocalId())) {
          return 0;
        }
        if (this.feedObject.getCreateTime() > ((BaseFinderFeed)localObject).feedObject.getCreateTime()) {
          return 1;
        }
        return -1;
      }
      return -1;
    }
  }
  
  public final long bMs()
  {
    if (this.feedObject.field_id == 0L) {
      return this.feedObject.getLocalId();
    }
    return this.feedObject.field_id;
  }
  
  public final int bMt()
  {
    return this.feedObject.getMediaType();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof BaseFinderFeed)) {
      return bMs() == ((BaseFinderFeed)paramObject).bMs();
    }
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    return (int)bMs();
  }
  
  public String toString()
  {
    String str1;
    if ("".length() > 20)
    {
      str1 = "".substring(0, 20);
      k.g(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (;;)
    {
      int i = this.feedObject.getCreateTime();
      if (this.feedObject.getMediaList().size() > 0) {}
      for (String str2 = ((bmd)this.feedObject.getMediaList().get(0)).url;; str2 = "") {
        return "id=[" + this.feedObject.field_id + ',' + c.ly(this.feedObject.field_id) + "] type=" + this.feedObject.getMediaType() + " localId=" + this.feedObject.getLocalId() + " time:" + Integer.valueOf(i) + " url:" + str2 + ' ' + str1;
      }
      str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.BaseFinderFeed
 * JD-Core Version:    0.7.0.1
 */