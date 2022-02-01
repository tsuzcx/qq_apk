package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.view.recyclerview.j;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "", "isValid", "", "feedId", "", "mediaId", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "feedType", "", "feedPosition", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(ZJLjava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FeedData;IILcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/RVFeed;)V", "currentVisibleFeedList", "Ljava/util/LinkedList;", "getCurrentVisibleFeedList", "()Ljava/util/LinkedList;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "getFeedId", "()J", "setFeedId", "(J)V", "getFeedPosition", "()I", "setFeedPosition", "(I)V", "getFeedType", "setFeedType", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "setHolder", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "()Z", "setValid", "(Z)V", "getItem", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setItem", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;)V", "getMediaId", "()Ljava/lang/String;", "setMediaId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public j AIz;
  public int GfT;
  public int GfU;
  public cc GfV;
  public final LinkedList<d> GfW;
  public boolean clZ;
  public FeedData feed;
  public long feedId;
  public String mediaId;
  
  public d()
  {
    this(false, null, 255);
  }
  
  private d(boolean paramBoolean, long paramLong, String paramString, FeedData paramFeedData, int paramInt1, int paramInt2, j paramj, cc paramcc)
  {
    AppMethodBeat.i(333742);
    this.clZ = paramBoolean;
    this.feedId = paramLong;
    this.mediaId = paramString;
    this.feed = paramFeedData;
    this.GfT = paramInt1;
    this.GfU = paramInt2;
    this.AIz = paramj;
    this.GfV = paramcc;
    this.GfW = new LinkedList();
    AppMethodBeat.o(333742);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(333793);
    if (this == paramObject)
    {
      AppMethodBeat.o(333793);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(333793);
      return false;
    }
    paramObject = (d)paramObject;
    if (this.clZ != paramObject.clZ)
    {
      AppMethodBeat.o(333793);
      return false;
    }
    if (this.feedId != paramObject.feedId)
    {
      AppMethodBeat.o(333793);
      return false;
    }
    if (!s.p(this.mediaId, paramObject.mediaId))
    {
      AppMethodBeat.o(333793);
      return false;
    }
    if (!s.p(this.feed, paramObject.feed))
    {
      AppMethodBeat.o(333793);
      return false;
    }
    if (this.GfT != paramObject.GfT)
    {
      AppMethodBeat.o(333793);
      return false;
    }
    if (this.GfU != paramObject.GfU)
    {
      AppMethodBeat.o(333793);
      return false;
    }
    if (!s.p(this.AIz, paramObject.AIz))
    {
      AppMethodBeat.o(333793);
      return false;
    }
    if (!s.p(this.GfV, paramObject.GfV))
    {
      AppMethodBeat.o(333793);
      return false;
    }
    AppMethodBeat.o(333793);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void setMediaId(String paramString)
  {
    AppMethodBeat.i(333772);
    s.u(paramString, "<set-?>");
    this.mediaId = paramString;
    AppMethodBeat.o(333772);
  }
  
  public final String toString()
  {
    boolean bool2 = true;
    AppMethodBeat.i(333780);
    Object localObject = new StringBuilder("isValid=").append(this.clZ).append(" feedType=").append(this.GfT).append(" feedPosition=").append(this.GfU).append(" feedId=").append(com.tencent.mm.ae.d.hF(this.feedId)).append(" mediaId=").append(this.mediaId).append(" holder=");
    if (this.AIz != null)
    {
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append(" centerList=").append(this.GfW.size()).append(" feed=");
      if (this.feed != null) {
        break label145;
      }
    }
    label145:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject = bool1;
      AppMethodBeat.o(333780);
      return localObject;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.d
 * JD-Core Version:    0.7.0.1
 */