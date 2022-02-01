package com.tencent.mm.plugin.finder.live.viewmodel.data.a;

import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bgh;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BaseBoxMsg;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxInfo;", "isLocal", "", "source", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(ZLcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "()Z", "setLocal", "(Z)V", "isValid", "setValid", "likeCount", "", "getLikeCount", "()I", "setLikeCount", "(I)V", "selfLike", "getSelfLike", "setSelfLike", "showLikeCount", "getShowLikeCount", "setShowLikeCount", "getSource", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "setSource", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getBoxId", "", "getFromContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getFromHeadUrl", "getFromNickName", "getFromUsername", "getItemId", "", "getItemType", "getSeq", "getToNickname", "getToUsername", "getWXFromDisplayName", "likeCnt", "logInfo", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  implements g, cc
{
  public bdm akfZ;
  public boolean akga;
  private boolean clZ;
  public boolean hJv;
  public int likeCount;
  
  public b(boolean paramBoolean, bdm parambdm)
  {
    this.hJv = paramBoolean;
    this.akfZ = parambdm;
    this.clZ = true;
  }
  
  public int a(k paramk)
  {
    s.u(paramk, "obj");
    if (((paramk instanceof b)) && (((b)paramk).hJv == this.hJv) && (s.p(((b)paramk).akfZ.Tro, this.akfZ.Tro)) && (s.p(((b)paramk).akfZ.ZOc, this.akfZ.ZOc))) {
      return 0;
    }
    return -1;
  }
  
  public final String aJO()
  {
    Object localObject = this.akfZ.ZOb;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      localObject = ((bgh)localObject).contact;
      if (localObject == null) {
        return "";
      }
      str = ((FinderContact)localObject).username;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final String aJP()
  {
    Object localObject = this.akfZ.ZNW;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      localObject = ((bgh)localObject).contact;
      if (localObject == null) {
        return "";
      }
      str = ((FinderContact)localObject).username;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final long bZA()
  {
    return this.akfZ.seq;
  }
  
  public final int bZB()
  {
    return this.akfZ.msg_type;
  }
  
  public String eYN()
  {
    return "msgType:" + this.akfZ.msg_type + ", seq:" + this.akfZ.seq + ", likeCount:" + this.likeCount + ", selfLike:" + this.akga + ", fromUsername:" + aJO() + ", toUsername:" + aJP();
  }
  
  public final void jKA()
  {
    this.clZ = false;
  }
  
  public final String jKB()
  {
    Object localObject = this.akfZ.ZOb;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      localObject = ((bgh)localObject).contact;
      if (localObject == null) {
        return "";
      }
      str = ((FinderContact)localObject).nickname;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final String kKZ()
  {
    Object localObject = this.akfZ.akjQ;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((bfv)localObject).id;
      localObject = str;
    } while (str != null);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.a.b
 * JD-Core Version:    0.7.0.1
 */