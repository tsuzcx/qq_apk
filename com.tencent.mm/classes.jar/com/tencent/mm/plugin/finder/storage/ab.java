package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bwd;
import d.g.b.ad;
import d.l;
import d.v;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction;", "()V", "value", "", "blacklist_flag", "getBlacklist_flag", "()I", "setBlacklist_flag", "(I)V", "canRemove", "getCanRemove", "setCanRemove", "", "clientId", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "", "commentId", "getCommentId", "()J", "setCommentId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentInfo", "getCommentInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "setCommentInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;)V", "content", "getContent", "setContent", "continueFlag", "getContinueFlag", "setContinueFlag", "createtime", "getCreatetime", "setCreatetime", "deleteFlag", "getDeleteFlag", "setDeleteFlag", "displayFlag", "getDisplayFlag", "setDisplayFlag", "displayid", "getDisplayid", "setDisplayid", "displayidDiscarded", "getDisplayidDiscarded", "setDisplayidDiscarded", "expandCommentCount", "getExpandCommentCount", "setExpandCommentCount", "extFlag", "getExtFlag", "setExtFlag", "failedFlag", "getFailedFlag", "setFailedFlag", "feedId", "getFeedId", "setFeedId", "headUrl", "getHeadUrl", "setHeadUrl", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "Ljava/util/LinkedList;", "kotlin.jvm.PlatformType", "levelTwoComment", "getLevelTwoComment", "()Ljava/util/LinkedList;", "setLevelTwoComment", "(Ljava/util/LinkedList;)V", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "nickname", "getNickname", "setNickname", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "postCommentReason", "getPostCommentReason", "setPostCommentReason", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "replyNickname", "getReplyNickname", "setReplyNickname", "reply_content", "getReply_content", "setReply_content", "reply_username", "getReply_username", "setReply_username", "rootCommentId", "getRootCommentId", "setRootCommentId", "state", "getState", "setState", "upContinueFlag", "getUpContinueFlag", "setUpContinueFlag", "username", "getUsername", "setUsername", "isAuthorMentioned", "", "isCommentCanDelete", "isCommentSent", "isExtFlagFriend", "isFinderComment", "isPoster", "isReplyerFinder", "isReplyerPoster", "toString", "Companion", "plugin-finder_release"})
public final class ab
  extends aa
{
  public static final ab.a sKh;
  
  static
  {
    AppMethodBeat.i(167037);
    sKh = new ab.a((byte)0);
    AppMethodBeat.o(167037);
  }
  
  public ab()
  {
    AppMethodBeat.i(167036);
    alr localalr = new alr();
    localalr.GDK = new FinderCommentInfo();
    localalr.GDL = new bwc();
    localalr.GDM = new bwd();
    this.field_actionInfo = localalr;
    AppMethodBeat.o(167036);
  }
  
  public final void FL(int paramInt)
  {
    AppMethodBeat.i(204326);
    cLl().expandCommentCount = paramInt;
    AppMethodBeat.o(204326);
  }
  
  public final void FM(int paramInt)
  {
    AppMethodBeat.i(204327);
    cLl().displayFlag = paramInt;
    AppMethodBeat.o(204327);
  }
  
  public final String VK()
  {
    AppMethodBeat.i(204320);
    String str2 = cLl().nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    d.g.b.p.g(str1, "commentInfo.nickname?:\"\"");
    AppMethodBeat.o(204320);
    return str1;
  }
  
  public final void ajw(String paramString)
  {
    AppMethodBeat.i(167034);
    d.g.b.p.h(paramString, "value");
    cLl().headUrl = paramString;
    AppMethodBeat.o(167034);
  }
  
  public final FinderCommentInfo cLl()
  {
    AppMethodBeat.i(204318);
    FinderCommentInfo localFinderCommentInfo2 = this.field_actionInfo.GDK;
    FinderCommentInfo localFinderCommentInfo1 = localFinderCommentInfo2;
    if (localFinderCommentInfo2 == null) {
      localFinderCommentInfo1 = new FinderCommentInfo();
    }
    d.g.b.p.g(localFinderCommentInfo1, "field_actionInfo.comment…fo ?: FinderCommentInfo()");
    AppMethodBeat.o(204318);
    return localFinderCommentInfo1;
  }
  
  public final String cLm()
  {
    AppMethodBeat.i(204322);
    String str2 = cLl().headUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    d.g.b.p.g(str1, "commentInfo.headUrl?:\"\"");
    AppMethodBeat.o(204322);
    return str1;
  }
  
  public final String cLn()
  {
    AppMethodBeat.i(204324);
    String str2 = cLl().replyNickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    d.g.b.p.g(str1, "commentInfo.replyNickname?:\"\"");
    AppMethodBeat.o(204324);
    return str1;
  }
  
  public final String cLo()
  {
    AppMethodBeat.i(204328);
    String str2 = cLl().reply_content;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    d.g.b.p.g(str1, "commentInfo.reply_content?:\"\"");
    AppMethodBeat.o(204328);
    return str1;
  }
  
  public final String cLp()
  {
    AppMethodBeat.i(204329);
    String str2 = cLl().reply_username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    d.g.b.p.g(str1, "commentInfo.reply_username?:\"\"");
    AppMethodBeat.o(204329);
    return str1;
  }
  
  public final String cLq()
  {
    AppMethodBeat.i(204330);
    String str2 = cLl().client_id;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    d.g.b.p.g(str1, "commentInfo.client_id?:\"\"");
    AppMethodBeat.o(204330);
    return str1;
  }
  
  public final boolean cLr()
  {
    AppMethodBeat.i(204331);
    if ((cLl().extFlag & 0x1) > 0)
    {
      AppMethodBeat.o(204331);
      return true;
    }
    AppMethodBeat.o(204331);
    return false;
  }
  
  public final boolean cLs()
  {
    return (this.field_state != 1) && (this.field_state != -1);
  }
  
  public final boolean cLt()
  {
    AppMethodBeat.i(178419);
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
    boolean bool = com.tencent.mm.plugin.finder.utils.p.Gn(cLl().displayFlag);
    AppMethodBeat.o(178419);
    return bool;
  }
  
  public final boolean cLu()
  {
    AppMethodBeat.i(178420);
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
    boolean bool = com.tencent.mm.plugin.finder.utils.p.Go(cLl().displayFlag);
    AppMethodBeat.o(178420);
    return bool;
  }
  
  public final boolean cLv()
  {
    AppMethodBeat.i(178421);
    if ((cLl().displayFlag & 0x4) != 0)
    {
      AppMethodBeat.o(178421);
      return true;
    }
    AppMethodBeat.o(178421);
    return false;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(204321);
    String str2 = cLl().content;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    d.g.b.p.g(str1, "commentInfo.content?:\"\"");
    AppMethodBeat.o(204321);
    return str1;
  }
  
  public final String getObjectNonceId()
  {
    String str2 = this.field_objectNonceId;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(204319);
    String str2 = cLl().username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    d.g.b.p.g(str1, "commentInfo.username?:\"\"");
    AppMethodBeat.o(204319);
    return str1;
  }
  
  public final void setLikeCount(int paramInt)
  {
    AppMethodBeat.i(204325);
    cLl().likeCount = paramInt;
    AppMethodBeat.o(204325);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(167033);
    d.g.b.p.h(paramString, "value");
    cLl().username = paramString;
    AppMethodBeat.o(167033);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167035);
    Object localObject1 = ad.Njc;
    Object localObject2 = new StringBuilder("field_commentInfo{commentId:").append(cLl().commentId).append(", displayid:");
    localObject1 = cLl();
    if (localObject1 != null) {}
    Object[] arrayOfObject;
    int i;
    for (localObject1 = Long.valueOf(((FinderCommentInfo)localObject1).displayid);; localObject1 = null)
    {
      localObject2 = ((Long)localObject1).longValue() + " try_count " + this.field_tryCount + " conetent:%s}";
      arrayOfObject = new Object[1];
      localObject1 = cLl();
      if (localObject1 == null) {
        break label171;
      }
      localObject1 = ((FinderCommentInfo)localObject1).content;
      if (localObject1 == null) {
        break label171;
      }
      d.g.b.p.g(localObject1, "it");
      i = Math.min(((String)localObject1).length(), 2);
      if (localObject1 != null) {
        break;
      }
      localObject1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(167035);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((String)localObject1).substring(0, i);
    d.g.b.p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    if (localObject1 == null) {
      label171:
      localObject1 = "";
    }
    for (;;)
    {
      arrayOfObject[0] = localObject1;
      localObject1 = String.format((String)localObject2, Arrays.copyOf(arrayOfObject, 1));
      d.g.b.p.g(localObject1, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(167035);
      return localObject1;
    }
  }
  
  public final void xi(long paramLong)
  {
    this.field_actionInfo.rQN = paramLong;
  }
  
  public final void xj(long paramLong)
  {
    AppMethodBeat.i(204323);
    cLl().createtime = paramLong;
    AppMethodBeat.o(204323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ab
 * JD-Core Version:    0.7.0.1
 */