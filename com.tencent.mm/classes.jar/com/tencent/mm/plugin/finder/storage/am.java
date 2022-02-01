package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.ak;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.protocal.protobuf.csm;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction;", "()V", "value", "", "blacklist_flag", "getBlacklist_flag", "()I", "setBlacklist_flag", "(I)V", "canRemove", "getCanRemove", "setCanRemove", "", "clientId", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "", "commentId", "getCommentId", "()J", "setCommentId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentInfo", "getCommentInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "setCommentInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;)V", "content", "getContent", "setContent", "continueFlag", "getContinueFlag", "setContinueFlag", "createtime", "getCreatetime", "setCreatetime", "deleteFlag", "getDeleteFlag", "setDeleteFlag", "displayFlag", "getDisplayFlag", "setDisplayFlag", "displayid", "getDisplayid", "setDisplayid", "displayidDiscarded", "getDisplayidDiscarded", "setDisplayidDiscarded", "expandCommentCount", "getExpandCommentCount", "setExpandCommentCount", "extFlag", "getExtFlag", "setExtFlag", "failedFlag", "getFailedFlag", "setFailedFlag", "feedId", "getFeedId", "setFeedId", "headUrl", "getHeadUrl", "setHeadUrl", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "Ljava/util/LinkedList;", "kotlin.jvm.PlatformType", "levelTwoComment", "getLevelTwoComment", "()Ljava/util/LinkedList;", "setLevelTwoComment", "(Ljava/util/LinkedList;)V", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "nickname", "getNickname", "setNickname", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "postCommentReason", "getPostCommentReason", "setPostCommentReason", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "replyNickname", "getReplyNickname", "setReplyNickname", "reply_content", "getReply_content", "setReply_content", "reply_username", "getReply_username", "setReply_username", "rootCommentId", "getRootCommentId", "setRootCommentId", "state", "getState", "setState", "upContinueFlag", "getUpContinueFlag", "setUpContinueFlag", "username", "getUsername", "setUsername", "isAuthorMentioned", "", "isCommentCanDelete", "isCommentSent", "isExtFlagFriend", "isFinderComment", "isPoster", "isReplyerFinder", "isReplyerPoster", "toString", "Companion", "plugin-finder-base_release"})
public final class am
  extends al
{
  public static final a AmL;
  
  static
  {
    AppMethodBeat.i(167037);
    AmL = new a((byte)0);
    AppMethodBeat.o(167037);
  }
  
  public am()
  {
    AppMethodBeat.i(167036);
    apk localapk = new apk();
    localapk.SCL = new FinderCommentInfo();
    localapk.SCM = new csl();
    localapk.SCN = new csm();
    this.field_actionInfo = localapk;
    AppMethodBeat.o(167036);
  }
  
  public final void MK(long paramLong)
  {
    this.field_actionInfo.xbP = paramLong;
  }
  
  public final void ML(long paramLong)
  {
    AppMethodBeat.i(258843);
    dYY().createtime = paramLong;
    AppMethodBeat.o(258843);
  }
  
  public final void Qm(int paramInt)
  {
    AppMethodBeat.i(258848);
    dYY().expandCommentCount = paramInt;
    AppMethodBeat.o(258848);
  }
  
  public final void Qn(int paramInt)
  {
    AppMethodBeat.i(258849);
    dYY().displayFlag = paramInt;
    AppMethodBeat.o(258849);
  }
  
  public final void aER(String paramString)
  {
    AppMethodBeat.i(167034);
    p.k(paramString, "value");
    dYY().headUrl = paramString;
    AppMethodBeat.o(167034);
  }
  
  public final FinderCommentInfo dYY()
  {
    AppMethodBeat.i(258835);
    FinderCommentInfo localFinderCommentInfo2 = this.field_actionInfo.SCL;
    FinderCommentInfo localFinderCommentInfo1 = localFinderCommentInfo2;
    if (localFinderCommentInfo2 == null) {
      localFinderCommentInfo1 = new FinderCommentInfo();
    }
    p.j(localFinderCommentInfo1, "field_actionInfo.comment…fo ?: FinderCommentInfo()");
    AppMethodBeat.o(258835);
    return localFinderCommentInfo1;
  }
  
  public final String dYZ()
  {
    AppMethodBeat.i(258841);
    String str2 = dYY().headUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.j(str1, "commentInfo.headUrl?:\"\"");
    AppMethodBeat.o(258841);
    return str1;
  }
  
  public final String dZa()
  {
    AppMethodBeat.i(258844);
    String str2 = dYY().replyNickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.j(str1, "commentInfo.replyNickname?:\"\"");
    AppMethodBeat.o(258844);
    return str1;
  }
  
  public final String dZb()
  {
    AppMethodBeat.i(258852);
    String str2 = dYY().reply_content;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.j(str1, "commentInfo.reply_content?:\"\"");
    AppMethodBeat.o(258852);
    return str1;
  }
  
  public final String dZc()
  {
    AppMethodBeat.i(258855);
    String str2 = dYY().reply_username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.j(str1, "commentInfo.reply_username?:\"\"");
    AppMethodBeat.o(258855);
    return str1;
  }
  
  public final String dZd()
  {
    AppMethodBeat.i(258858);
    String str2 = dYY().client_id;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.j(str1, "commentInfo.client_id?:\"\"");
    AppMethodBeat.o(258858);
    return str1;
  }
  
  public final boolean dZe()
  {
    AppMethodBeat.i(258862);
    if ((dYY().extFlag & 0x1) > 0)
    {
      AppMethodBeat.o(258862);
      return true;
    }
    AppMethodBeat.o(258862);
    return false;
  }
  
  public final boolean dZf()
  {
    return (this.field_state != 1) && (this.field_state != -1);
  }
  
  public final boolean dZg()
  {
    AppMethodBeat.i(178419);
    ak localak = ak.AGL;
    boolean bool = ak.QU(dYY().displayFlag);
    AppMethodBeat.o(178419);
    return bool;
  }
  
  public final boolean dZh()
  {
    AppMethodBeat.i(178420);
    ak localak = ak.AGL;
    boolean bool = ak.Ro(dYY().displayFlag);
    AppMethodBeat.o(178420);
    return bool;
  }
  
  public final boolean dZi()
  {
    AppMethodBeat.i(178421);
    if ((dYY().displayFlag & 0x4) != 0)
    {
      AppMethodBeat.o(178421);
      return true;
    }
    AppMethodBeat.o(178421);
    return false;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(258840);
    String str2 = dYY().content;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.j(str1, "commentInfo.content?:\"\"");
    AppMethodBeat.o(258840);
    return str1;
  }
  
  public final String getNickname()
  {
    AppMethodBeat.i(258839);
    String str2 = dYY().nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.j(str1, "commentInfo.nickname?:\"\"");
    AppMethodBeat.o(258839);
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
    AppMethodBeat.i(258838);
    String str2 = dYY().username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.j(str1, "commentInfo.username?:\"\"");
    AppMethodBeat.o(258838);
    return str1;
  }
  
  public final void setLikeCount(int paramInt)
  {
    AppMethodBeat.i(258846);
    dYY().likeCount = paramInt;
    AppMethodBeat.o(258846);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(167033);
    p.k(paramString, "value");
    dYY().username = paramString;
    AppMethodBeat.o(167033);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167035);
    Object localObject1 = af.aaBG;
    Object localObject2 = new StringBuilder("field_commentInfo{commentId:").append(dYY().commentId).append(", displayid:");
    localObject1 = dYY();
    if (localObject1 != null) {}
    Object[] arrayOfObject;
    int i;
    for (localObject1 = Long.valueOf(((FinderCommentInfo)localObject1).displayid);; localObject1 = null)
    {
      localObject2 = ((Long)localObject1).longValue() + " try_count " + this.field_tryCount + " conetent:%s}";
      arrayOfObject = new Object[1];
      localObject1 = dYY();
      if (localObject1 == null) {
        break label171;
      }
      localObject1 = ((FinderCommentInfo)localObject1).content;
      if (localObject1 == null) {
        break label171;
      }
      p.j(localObject1, "it");
      i = Math.min(((String)localObject1).length(), 2);
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(167035);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((String)localObject1).substring(0, i);
    p.j(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    if (localObject1 == null) {
      label171:
      localObject1 = "";
    }
    for (;;)
    {
      arrayOfObject[0] = localObject1;
      localObject1 = String.format((String)localObject2, Arrays.copyOf(arrayOfObject, 1));
      p.j(localObject1, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(167035);
      return localObject1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject$Companion;", "", "()V", "FAILED_BAN", "", "FAILED_NORMAL", "STATE_ERROR", "STATE_REPLIED", "STATE_REPLYING", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.am
 * JD-Core Version:    0.7.0.1
 */