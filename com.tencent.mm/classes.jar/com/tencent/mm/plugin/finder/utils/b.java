package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.view.recyclerview.i;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "", "isValid", "", "feedId", "", "mediaId", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "feedType", "", "feedPosition", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(ZJLjava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FeedData;IILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "currentVisibleFeedList", "Ljava/util/LinkedList;", "getCurrentVisibleFeedList", "()Ljava/util/LinkedList;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "getFeedId", "()J", "setFeedId", "(J)V", "getFeedPosition", "()I", "setFeedPosition", "(I)V", "getFeedType", "setFeedType", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "setHolder", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "()Z", "setValid", "(Z)V", "getMediaId", "()Ljava/lang/String;", "setMediaId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "plugin-finder-base_release"})
public final class b
{
  public final LinkedList<b> ACP;
  public int ACQ;
  public int ACR;
  public boolean cSY;
  public FeedData feed;
  public long feedId;
  public String mediaId;
  public i xhX;
  
  public b()
  {
    this(false, null, 127);
  }
  
  private b(boolean paramBoolean, long paramLong, String paramString, FeedData paramFeedData, int paramInt1, int paramInt2, i parami)
  {
    AppMethodBeat.i(263089);
    this.cSY = paramBoolean;
    this.feedId = paramLong;
    this.mediaId = paramString;
    this.feed = paramFeedData;
    this.ACQ = paramInt1;
    this.ACR = paramInt2;
    this.xhX = parami;
    this.ACP = new LinkedList();
    AppMethodBeat.o(263089);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(263098);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.cSY != paramObject.cSY) || (this.feedId != paramObject.feedId) || (!p.h(this.mediaId, paramObject.mediaId)) || (!p.h(this.feed, paramObject.feed)) || (this.ACQ != paramObject.ACQ) || (this.ACR != paramObject.ACR) || (!p.h(this.xhX, paramObject.xhX))) {}
      }
    }
    else
    {
      AppMethodBeat.o(263098);
      return true;
    }
    AppMethodBeat.o(263098);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void setMediaId(String paramString)
  {
    AppMethodBeat.i(263086);
    p.k(paramString, "<set-?>");
    this.mediaId = paramString;
    AppMethodBeat.o(263086);
  }
  
  public final String toString()
  {
    boolean bool2 = true;
    AppMethodBeat.i(263083);
    Object localObject = new StringBuilder("isValid=").append(this.cSY).append(" feedType=").append(this.ACQ).append(" feedPosition=").append(this.ACR).append(" feedId=").append(d.Fw(this.feedId)).append(" mediaId=").append(this.mediaId).append(" holder=");
    if (this.xhX != null)
    {
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append(" centerList=").append(this.ACP.size()).append(" feed=");
      if (this.feed != null) {
        break label145;
      }
    }
    label145:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject = bool1;
      AppMethodBeat.o(263083);
      return localObject;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.b
 * JD-Core Version:    0.7.0.1
 */