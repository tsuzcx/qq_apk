package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.protocal.protobuf.bmf;
import com.tencent.mm.protocal.protobuf.bmg;
import d.g.b.z;
import d.l;
import d.v;
import java.util.Arrays;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction;", "()V", "value", "", "blacklist_flag", "getBlacklist_flag", "()I", "setBlacklist_flag", "(I)V", "canRemove", "getCanRemove", "setCanRemove", "", "clientId", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "", "commentId", "getCommentId", "()J", "setCommentId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "kotlin.jvm.PlatformType", "commentInfo", "getCommentInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "setCommentInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;)V", "content", "getContent", "setContent", "continueFlag", "getContinueFlag", "setContinueFlag", "createtime", "getCreatetime", "setCreatetime", "deleteFlag", "getDeleteFlag", "setDeleteFlag", "displayFlag", "getDisplayFlag", "setDisplayFlag", "displayid", "getDisplayid", "setDisplayid", "displayidDiscarded", "getDisplayidDiscarded", "setDisplayidDiscarded", "expandCommentCount", "getExpandCommentCount", "setExpandCommentCount", "extFlag", "getExtFlag", "setExtFlag", "failedFlag", "getFailedFlag", "setFailedFlag", "feedId", "getFeedId", "setFeedId", "headUrl", "getHeadUrl", "setHeadUrl", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "Ljava/util/LinkedList;", "levelTwoComment", "getLevelTwoComment", "()Ljava/util/LinkedList;", "setLevelTwoComment", "(Ljava/util/LinkedList;)V", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "nickname", "getNickname", "setNickname", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "replyNickname", "getReplyNickname", "setReplyNickname", "reply_content", "getReply_content", "setReply_content", "reply_username", "getReply_username", "setReply_username", "rootCommentId", "getRootCommentId", "setRootCommentId", "state", "getState", "setState", "upContinueFlag", "getUpContinueFlag", "setUpContinueFlag", "username", "getUsername", "setUsername", "isAuthorMentioned", "", "isCommentCanDelete", "isCommentSent", "isExtFlagFriend", "isFinderComment", "isPoster", "isReplyerFinder", "isReplyerPoster", "toString", "Companion", "plugin-finder_release"})
public final class k
  extends j
{
  public static final a qKg;
  
  static
  {
    AppMethodBeat.i(167037);
    qKg = new a((byte)0);
    AppMethodBeat.o(167037);
  }
  
  public k()
  {
    AppMethodBeat.i(167036);
    ahs localahs = new ahs();
    localahs.Dkk = new FinderCommentInfo();
    localahs.Dkl = new bmf();
    localahs.Dkm = new bmg();
    this.field_actionInfo = localahs;
    AppMethodBeat.o(167036);
  }
  
  private int fUZ()
  {
    return this.field_actionInfo.Dkk.extFlag;
  }
  
  public final void CR(int paramInt)
  {
    this.field_actionInfo.Dkk.expandCommentCount = paramInt;
  }
  
  public final void CS(int paramInt)
  {
    this.field_actionInfo.Dkk.displayFlag = paramInt;
  }
  
  public final String Su()
  {
    String str2 = this.field_actionInfo.Dkk.nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void Zy(String paramString)
  {
    AppMethodBeat.i(167034);
    d.g.b.k.h(paramString, "value");
    this.field_actionInfo.Dkk.headUrl = paramString;
    AppMethodBeat.o(167034);
  }
  
  public final boolean cqA()
  {
    AppMethodBeat.i(178419);
    i locali = i.qTa;
    boolean bool = i.Dm(cqv());
    AppMethodBeat.o(178419);
    return bool;
  }
  
  public final boolean cqB()
  {
    AppMethodBeat.i(178420);
    i locali = i.qTa;
    boolean bool = i.Dn(cqv());
    AppMethodBeat.o(178420);
    return bool;
  }
  
  public final boolean cqC()
  {
    AppMethodBeat.i(178421);
    if ((cqv() & 0x4) != 0)
    {
      AppMethodBeat.o(178421);
      return true;
    }
    AppMethodBeat.o(178421);
    return false;
  }
  
  public final long cqr()
  {
    return this.field_actionInfo.Dkk.commentId;
  }
  
  public final String cqs()
  {
    String str2 = this.field_actionInfo.Dkk.headUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final long cqt()
  {
    return this.field_actionInfo.Dkk.createtime;
  }
  
  public final String cqu()
  {
    String str2 = this.field_actionInfo.Dkk.replyNickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final int cqv()
  {
    return this.field_actionInfo.Dkk.displayFlag;
  }
  
  public final String cqw()
  {
    String str2 = this.field_actionInfo.Dkk.reply_content;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cqx()
  {
    String str2 = this.field_actionInfo.Dkk.reply_username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cqy()
  {
    String str2 = this.field_actionInfo.Dkk.client_id;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final boolean cqz()
  {
    return (this.field_state != 1) && (this.field_state != -1);
  }
  
  public final boolean fVa()
  {
    AppMethodBeat.i(199038);
    if ((fUZ() & 0x1) > 0)
    {
      AppMethodBeat.o(199038);
      return true;
    }
    AppMethodBeat.o(199038);
    return false;
  }
  
  public final String getContent()
  {
    String str2 = this.field_actionInfo.Dkk.content;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final int getLikeCount()
  {
    return this.field_actionInfo.Dkk.likeCount;
  }
  
  public final int getLikeFlag()
  {
    return this.field_actionInfo.Dkk.likeFlag;
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
    String str2 = this.field_actionInfo.Dkk.username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void qA(long paramLong)
  {
    this.field_actionInfo.qoB = paramLong;
  }
  
  public final void qB(long paramLong)
  {
    this.field_actionInfo.Dkk.createtime = paramLong;
  }
  
  public final void setLikeCount(int paramInt)
  {
    this.field_actionInfo.Dkk.likeCount = paramInt;
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(167033);
    d.g.b.k.h(paramString, "value");
    this.field_actionInfo.Dkk.username = paramString;
    AppMethodBeat.o(167033);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167035);
    Object localObject = z.Jhz;
    String str2 = "field_commentInfo{commentId:" + this.field_actionInfo.Dkk.commentId + ", displayid:" + this.field_actionInfo.Dkk.displayid + " try_count " + this.field_tryCount + " conetent:%s}";
    localObject = this.field_actionInfo.Dkk.content;
    d.g.b.k.g(localObject, "it");
    int i = Math.min(((String)localObject).length(), 2);
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(167035);
      throw ((Throwable)localObject);
    }
    String str1 = ((String)localObject).substring(0, i);
    d.g.b.k.g(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localObject = str1;
    if (str1 == null) {
      localObject = "";
    }
    localObject = String.format(str2, Arrays.copyOf(new Object[] { localObject }, 1));
    d.g.b.k.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(167035);
    return localObject;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject$Companion;", "", "()V", "FAILED_BAN", "", "FAILED_NORMAL", "STATE_ERROR", "STATE_REPLIED", "STATE_REPLYING", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.k
 * JD-Core Version:    0.7.0.1
 */