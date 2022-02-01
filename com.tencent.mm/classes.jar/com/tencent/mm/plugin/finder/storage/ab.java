package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.bvj;
import d.g.b.ad;
import d.l;
import d.v;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction;", "()V", "value", "", "blacklist_flag", "getBlacklist_flag", "()I", "setBlacklist_flag", "(I)V", "canRemove", "getCanRemove", "setCanRemove", "", "clientId", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "", "commentId", "getCommentId", "()J", "setCommentId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "kotlin.jvm.PlatformType", "commentInfo", "getCommentInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "setCommentInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;)V", "content", "getContent", "setContent", "continueFlag", "getContinueFlag", "setContinueFlag", "createtime", "getCreatetime", "setCreatetime", "deleteFlag", "getDeleteFlag", "setDeleteFlag", "displayFlag", "getDisplayFlag", "setDisplayFlag", "displayid", "getDisplayid", "setDisplayid", "displayidDiscarded", "getDisplayidDiscarded", "setDisplayidDiscarded", "expandCommentCount", "getExpandCommentCount", "setExpandCommentCount", "extFlag", "getExtFlag", "setExtFlag", "failedFlag", "getFailedFlag", "setFailedFlag", "feedId", "getFeedId", "setFeedId", "headUrl", "getHeadUrl", "setHeadUrl", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "Ljava/util/LinkedList;", "levelTwoComment", "getLevelTwoComment", "()Ljava/util/LinkedList;", "setLevelTwoComment", "(Ljava/util/LinkedList;)V", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "nickname", "getNickname", "setNickname", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "postCommentReason", "getPostCommentReason", "setPostCommentReason", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "replyNickname", "getReplyNickname", "setReplyNickname", "reply_content", "getReply_content", "setReply_content", "reply_username", "getReply_username", "setReply_username", "rootCommentId", "getRootCommentId", "setRootCommentId", "state", "getState", "setState", "upContinueFlag", "getUpContinueFlag", "setUpContinueFlag", "username", "getUsername", "setUsername", "isAuthorMentioned", "", "isCommentCanDelete", "isCommentSent", "isExtFlagFriend", "isFinderComment", "isPoster", "isReplyerFinder", "isReplyerPoster", "toString", "Companion", "plugin-finder_release"})
public final class ab
  extends aa
{
  public static final a szq;
  
  static
  {
    AppMethodBeat.i(167037);
    szq = new a((byte)0);
    AppMethodBeat.o(167037);
  }
  
  public ab()
  {
    AppMethodBeat.i(167036);
    alh localalh = new alh();
    localalh.Gla = new FinderCommentInfo();
    localalh.Glb = new bvi();
    localalh.Glc = new bvj();
    this.field_actionInfo = localalh;
    AppMethodBeat.o(167036);
  }
  
  public final void Fo(int paramInt)
  {
    this.field_actionInfo.Gla.expandCommentCount = paramInt;
  }
  
  public final void Fp(int paramInt)
  {
    this.field_actionInfo.Gla.displayFlag = paramInt;
  }
  
  public final String VC()
  {
    String str2 = this.field_actionInfo.Gla.nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void aiz(String paramString)
  {
    AppMethodBeat.i(167034);
    d.g.b.p.h(paramString, "value");
    this.field_actionInfo.Gla.headUrl = paramString;
    AppMethodBeat.o(167034);
  }
  
  public final long cIG()
  {
    return this.field_actionInfo.Gla.commentId;
  }
  
  public final String cIH()
  {
    String str2 = this.field_actionInfo.Gla.headUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final long cII()
  {
    return this.field_actionInfo.Gla.createtime;
  }
  
  public final String cIJ()
  {
    String str2 = this.field_actionInfo.Gla.replyNickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final int cIK()
  {
    return this.field_actionInfo.Gla.displayFlag;
  }
  
  public final String cIL()
  {
    String str2 = this.field_actionInfo.Gla.reply_content;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cIM()
  {
    String str2 = this.field_actionInfo.Gla.reply_username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cIN()
  {
    String str2 = this.field_actionInfo.Gla.client_id;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final int cIO()
  {
    return this.field_actionInfo.Gla.extFlag;
  }
  
  public final boolean cIP()
  {
    AppMethodBeat.i(203751);
    if ((cIO() & 0x1) > 0)
    {
      AppMethodBeat.o(203751);
      return true;
    }
    AppMethodBeat.o(203751);
    return false;
  }
  
  public final boolean cIQ()
  {
    return (this.field_state != 1) && (this.field_state != -1);
  }
  
  public final boolean cIR()
  {
    AppMethodBeat.i(178419);
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
    boolean bool = com.tencent.mm.plugin.finder.utils.p.FP(cIK());
    AppMethodBeat.o(178419);
    return bool;
  }
  
  public final boolean cIS()
  {
    AppMethodBeat.i(178420);
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
    boolean bool = com.tencent.mm.plugin.finder.utils.p.FQ(cIK());
    AppMethodBeat.o(178420);
    return bool;
  }
  
  public final boolean cIT()
  {
    AppMethodBeat.i(178421);
    if ((cIK() & 0x4) != 0)
    {
      AppMethodBeat.o(178421);
      return true;
    }
    AppMethodBeat.o(178421);
    return false;
  }
  
  public final int eQt()
  {
    return this.field_actionInfo.Gla.blacklist_flag;
  }
  
  public final String getContent()
  {
    String str2 = this.field_actionInfo.Gla.content;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final int getLikeCount()
  {
    return this.field_actionInfo.Gla.likeCount;
  }
  
  public final int getLikeFlag()
  {
    return this.field_actionInfo.Gla.likeFlag;
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
    String str2 = this.field_actionInfo.Gla.username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final void setLikeCount(int paramInt)
  {
    this.field_actionInfo.Gla.likeCount = paramInt;
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(167033);
    d.g.b.p.h(paramString, "value");
    this.field_actionInfo.Gla.username = paramString;
    AppMethodBeat.o(167033);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167035);
    Object localObject = ad.MLZ;
    String str2 = "field_commentInfo{commentId:" + this.field_actionInfo.Gla.commentId + ", displayid:" + this.field_actionInfo.Gla.displayid + " try_count " + this.field_tryCount + " conetent:%s}";
    localObject = this.field_actionInfo.Gla.content;
    d.g.b.p.g(localObject, "it");
    int i = Math.min(((String)localObject).length(), 2);
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(167035);
      throw ((Throwable)localObject);
    }
    String str1 = ((String)localObject).substring(0, i);
    d.g.b.p.g(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localObject = str1;
    if (str1 == null) {
      localObject = "";
    }
    localObject = String.format(str2, Arrays.copyOf(new Object[] { localObject }, 1));
    d.g.b.p.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(167035);
    return localObject;
  }
  
  public final void wR(long paramLong)
  {
    this.field_actionInfo.rID = paramLong;
  }
  
  public final void wS(long paramLong)
  {
    this.field_actionInfo.Gla.createtime = paramLong;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject$Companion;", "", "()V", "FAILED_BAN", "", "FAILED_NORMAL", "STATE_ERROR", "STATE_REPLIED", "STATE_REPLYING", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ab
 * JD-Core Version:    0.7.0.1
 */