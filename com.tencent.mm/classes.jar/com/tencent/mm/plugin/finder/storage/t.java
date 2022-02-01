package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.bqv;
import com.tencent.mm.protocal.protobuf.bqw;
import d.g.b.k;
import d.g.b.z;
import d.l;
import d.v;
import java.util.Arrays;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction;", "()V", "value", "", "blacklist_flag", "getBlacklist_flag", "()I", "setBlacklist_flag", "(I)V", "canRemove", "getCanRemove", "setCanRemove", "", "clientId", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "", "commentId", "getCommentId", "()J", "setCommentId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "kotlin.jvm.PlatformType", "commentInfo", "getCommentInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "setCommentInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;)V", "content", "getContent", "setContent", "continueFlag", "getContinueFlag", "setContinueFlag", "createtime", "getCreatetime", "setCreatetime", "deleteFlag", "getDeleteFlag", "setDeleteFlag", "displayFlag", "getDisplayFlag", "setDisplayFlag", "displayid", "getDisplayid", "setDisplayid", "displayidDiscarded", "getDisplayidDiscarded", "setDisplayidDiscarded", "expandCommentCount", "getExpandCommentCount", "setExpandCommentCount", "extFlag", "getExtFlag", "setExtFlag", "failedFlag", "getFailedFlag", "setFailedFlag", "feedId", "getFeedId", "setFeedId", "headUrl", "getHeadUrl", "setHeadUrl", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "Ljava/util/LinkedList;", "levelTwoComment", "getLevelTwoComment", "()Ljava/util/LinkedList;", "setLevelTwoComment", "(Ljava/util/LinkedList;)V", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "nickname", "getNickname", "setNickname", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "replyNickname", "getReplyNickname", "setReplyNickname", "reply_content", "getReply_content", "setReply_content", "reply_username", "getReply_username", "setReply_username", "rootCommentId", "getRootCommentId", "setRootCommentId", "state", "getState", "setState", "upContinueFlag", "getUpContinueFlag", "setUpContinueFlag", "username", "getUsername", "setUsername", "isAuthorMentioned", "", "isCommentCanDelete", "isCommentSent", "isExtFlagFriend", "isFinderComment", "isPoster", "isReplyerFinder", "isReplyerPoster", "toString", "Companion", "plugin-finder_release"})
public final class t
  extends s
{
  public static final t.a rEw;
  
  static
  {
    AppMethodBeat.i(167037);
    rEw = new t.a((byte)0);
    AppMethodBeat.o(167037);
  }
  
  public t()
  {
    AppMethodBeat.i(167036);
    air localair = new air();
    localair.EDq = new FinderCommentInfo();
    localair.EDr = new bqv();
    localair.EDs = new bqw();
    this.field_actionInfo = localair;
    AppMethodBeat.o(167036);
  }
  
  private int cAS()
  {
    return this.field_actionInfo.EDq.extFlag;
  }
  
  public final void Eh(int paramInt)
  {
    this.field_actionInfo.EDq.expandCommentCount = paramInt;
  }
  
  public final void Ei(int paramInt)
  {
    this.field_actionInfo.EDq.displayFlag = paramInt;
  }
  
  public final String Tn()
  {
    String str2 = this.field_actionInfo.EDq.nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void aef(String paramString)
  {
    AppMethodBeat.i(167034);
    k.h(paramString, "value");
    this.field_actionInfo.EDq.headUrl = paramString;
    AppMethodBeat.o(167034);
  }
  
  public final long cAK()
  {
    return this.field_actionInfo.EDq.commentId;
  }
  
  public final String cAL()
  {
    String str2 = this.field_actionInfo.EDq.headUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final long cAM()
  {
    return this.field_actionInfo.EDq.createtime;
  }
  
  public final String cAN()
  {
    String str2 = this.field_actionInfo.EDq.replyNickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final int cAO()
  {
    return this.field_actionInfo.EDq.displayFlag;
  }
  
  public final String cAP()
  {
    String str2 = this.field_actionInfo.EDq.reply_content;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cAQ()
  {
    String str2 = this.field_actionInfo.EDq.reply_username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cAR()
  {
    String str2 = this.field_actionInfo.EDq.client_id;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final boolean cAT()
  {
    AppMethodBeat.i(203002);
    if ((cAS() & 0x1) > 0)
    {
      AppMethodBeat.o(203002);
      return true;
    }
    AppMethodBeat.o(203002);
    return false;
  }
  
  public final boolean cAU()
  {
    return (this.field_state != 1) && (this.field_state != -1);
  }
  
  public final boolean cAV()
  {
    AppMethodBeat.i(178419);
    n localn = n.rPN;
    boolean bool = n.EF(cAO());
    AppMethodBeat.o(178419);
    return bool;
  }
  
  public final boolean cAW()
  {
    AppMethodBeat.i(178420);
    n localn = n.rPN;
    boolean bool = n.EG(cAO());
    AppMethodBeat.o(178420);
    return bool;
  }
  
  public final boolean cAX()
  {
    AppMethodBeat.i(178421);
    if ((cAO() & 0x4) != 0)
    {
      AppMethodBeat.o(178421);
      return true;
    }
    AppMethodBeat.o(178421);
    return false;
  }
  
  public final String getContent()
  {
    String str2 = this.field_actionInfo.EDq.content;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final int getLikeCount()
  {
    return this.field_actionInfo.EDq.likeCount;
  }
  
  public final int getLikeFlag()
  {
    return this.field_actionInfo.EDq.likeFlag;
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
    String str2 = this.field_actionInfo.EDq.username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void setLikeCount(int paramInt)
  {
    this.field_actionInfo.EDq.likeCount = paramInt;
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(167033);
    k.h(paramString, "value");
    this.field_actionInfo.EDq.username = paramString;
    AppMethodBeat.o(167033);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167035);
    Object localObject = z.KUT;
    String str2 = "field_commentInfo{commentId:" + this.field_actionInfo.EDq.commentId + ", displayid:" + this.field_actionInfo.EDq.displayid + " try_count " + this.field_tryCount + " conetent:%s}";
    localObject = this.field_actionInfo.EDq.content;
    k.g(localObject, "it");
    int i = Math.min(((String)localObject).length(), 2);
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(167035);
      throw ((Throwable)localObject);
    }
    String str1 = ((String)localObject).substring(0, i);
    k.g(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localObject = str1;
    if (str1 == null) {
      localObject = "";
    }
    localObject = String.format(str2, Arrays.copyOf(new Object[] { localObject }, 1));
    k.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(167035);
    return localObject;
  }
  
  public final void uQ(long paramLong)
  {
    this.field_actionInfo.qXu = paramLong;
  }
  
  public final void uR(long paramLong)
  {
    this.field_actionInfo.EDq.createtime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.t
 * JD-Core Version:    0.7.0.1
 */