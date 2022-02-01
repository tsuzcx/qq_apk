package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.protocal.protobuf.cjr;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction;", "()V", "value", "", "blacklist_flag", "getBlacklist_flag", "()I", "setBlacklist_flag", "(I)V", "canRemove", "getCanRemove", "setCanRemove", "", "clientId", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "", "commentId", "getCommentId", "()J", "setCommentId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentInfo", "getCommentInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "setCommentInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;)V", "content", "getContent", "setContent", "continueFlag", "getContinueFlag", "setContinueFlag", "createtime", "getCreatetime", "setCreatetime", "deleteFlag", "getDeleteFlag", "setDeleteFlag", "displayFlag", "getDisplayFlag", "setDisplayFlag", "displayid", "getDisplayid", "setDisplayid", "displayidDiscarded", "getDisplayidDiscarded", "setDisplayidDiscarded", "expandCommentCount", "getExpandCommentCount", "setExpandCommentCount", "extFlag", "getExtFlag", "setExtFlag", "failedFlag", "getFailedFlag", "setFailedFlag", "feedId", "getFeedId", "setFeedId", "headUrl", "getHeadUrl", "setHeadUrl", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "Ljava/util/LinkedList;", "kotlin.jvm.PlatformType", "levelTwoComment", "getLevelTwoComment", "()Ljava/util/LinkedList;", "setLevelTwoComment", "(Ljava/util/LinkedList;)V", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "nickname", "getNickname", "setNickname", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "postCommentReason", "getPostCommentReason", "setPostCommentReason", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "replyNickname", "getReplyNickname", "setReplyNickname", "reply_content", "getReply_content", "setReply_content", "reply_username", "getReply_username", "setReply_username", "rootCommentId", "getRootCommentId", "setRootCommentId", "state", "getState", "setState", "upContinueFlag", "getUpContinueFlag", "setUpContinueFlag", "username", "getUsername", "setUsername", "isAuthorMentioned", "", "isCommentCanDelete", "isCommentSent", "isExtFlagFriend", "isFinderComment", "isPoster", "isReplyerFinder", "isReplyerPoster", "toString", "Companion", "plugin-finder_release"})
public final class an
  extends am
{
  public static final a vFt;
  
  static
  {
    AppMethodBeat.i(167037);
    vFt = new a((byte)0);
    AppMethodBeat.o(167037);
  }
  
  public an()
  {
    AppMethodBeat.i(167036);
    aoh localaoh = new aoh();
    localaoh.LAk = new FinderCommentInfo();
    localaoh.LAl = new cjq();
    localaoh.LAm = new cjr();
    this.field_actionInfo = localaoh;
    AppMethodBeat.o(167036);
  }
  
  public final void FB(long paramLong)
  {
    this.field_actionInfo.tuf = paramLong;
  }
  
  public final void FC(long paramLong)
  {
    AppMethodBeat.i(251893);
    dyb().createtime = paramLong;
    AppMethodBeat.o(251893);
  }
  
  public final void La(int paramInt)
  {
    AppMethodBeat.i(251896);
    dyb().expandCommentCount = paramInt;
    AppMethodBeat.o(251896);
  }
  
  public final void Lb(int paramInt)
  {
    AppMethodBeat.i(251897);
    dyb().displayFlag = paramInt;
    AppMethodBeat.o(251897);
  }
  
  public final void avC(String paramString)
  {
    AppMethodBeat.i(167034);
    p.h(paramString, "value");
    dyb().headUrl = paramString;
    AppMethodBeat.o(167034);
  }
  
  public final FinderCommentInfo dyb()
  {
    AppMethodBeat.i(251888);
    FinderCommentInfo localFinderCommentInfo2 = this.field_actionInfo.LAk;
    FinderCommentInfo localFinderCommentInfo1 = localFinderCommentInfo2;
    if (localFinderCommentInfo2 == null) {
      localFinderCommentInfo1 = new FinderCommentInfo();
    }
    p.g(localFinderCommentInfo1, "field_actionInfo.comment…fo ?: FinderCommentInfo()");
    AppMethodBeat.o(251888);
    return localFinderCommentInfo1;
  }
  
  public final String dyc()
  {
    AppMethodBeat.i(251892);
    String str2 = dyb().headUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.g(str1, "commentInfo.headUrl?:\"\"");
    AppMethodBeat.o(251892);
    return str1;
  }
  
  public final String dyd()
  {
    AppMethodBeat.i(251894);
    String str2 = dyb().replyNickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.g(str1, "commentInfo.replyNickname?:\"\"");
    AppMethodBeat.o(251894);
    return str1;
  }
  
  public final String dye()
  {
    AppMethodBeat.i(251898);
    String str2 = dyb().reply_content;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.g(str1, "commentInfo.reply_content?:\"\"");
    AppMethodBeat.o(251898);
    return str1;
  }
  
  public final String dyf()
  {
    AppMethodBeat.i(251899);
    String str2 = dyb().reply_username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.g(str1, "commentInfo.reply_username?:\"\"");
    AppMethodBeat.o(251899);
    return str1;
  }
  
  public final String dyg()
  {
    AppMethodBeat.i(251900);
    String str2 = dyb().client_id;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.g(str1, "commentInfo.client_id?:\"\"");
    AppMethodBeat.o(251900);
    return str1;
  }
  
  public final boolean dyh()
  {
    AppMethodBeat.i(251901);
    if ((dyb().extFlag & 0x1) > 0)
    {
      AppMethodBeat.o(251901);
      return true;
    }
    AppMethodBeat.o(251901);
    return false;
  }
  
  public final boolean dyi()
  {
    return (this.field_state != 1) && (this.field_state != -1);
  }
  
  public final boolean dyj()
  {
    AppMethodBeat.i(178419);
    y localy = y.vXH;
    boolean bool = y.LG(dyb().displayFlag);
    AppMethodBeat.o(178419);
    return bool;
  }
  
  public final boolean dyk()
  {
    AppMethodBeat.i(178420);
    y localy = y.vXH;
    boolean bool = y.LH(dyb().displayFlag);
    AppMethodBeat.o(178420);
    return bool;
  }
  
  public final boolean dyl()
  {
    AppMethodBeat.i(178421);
    if ((dyb().displayFlag & 0x4) != 0)
    {
      AppMethodBeat.o(178421);
      return true;
    }
    AppMethodBeat.o(178421);
    return false;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(251891);
    String str2 = dyb().content;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.g(str1, "commentInfo.content?:\"\"");
    AppMethodBeat.o(251891);
    return str1;
  }
  
  public final String getNickname()
  {
    AppMethodBeat.i(251890);
    String str2 = dyb().nickname;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.g(str1, "commentInfo.nickname?:\"\"");
    AppMethodBeat.o(251890);
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
    AppMethodBeat.i(251889);
    String str2 = dyb().username;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.g(str1, "commentInfo.username?:\"\"");
    AppMethodBeat.o(251889);
    return str1;
  }
  
  public final void setLikeCount(int paramInt)
  {
    AppMethodBeat.i(251895);
    dyb().likeCount = paramInt;
    AppMethodBeat.o(251895);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(167033);
    p.h(paramString, "value");
    dyb().username = paramString;
    AppMethodBeat.o(167033);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167035);
    Object localObject1 = ae.SYK;
    Object localObject2 = new StringBuilder("field_commentInfo{commentId:").append(dyb().commentId).append(", displayid:");
    localObject1 = dyb();
    if (localObject1 != null) {}
    Object[] arrayOfObject;
    int i;
    for (localObject1 = Long.valueOf(((FinderCommentInfo)localObject1).displayid);; localObject1 = null)
    {
      localObject2 = ((Long)localObject1).longValue() + " try_count " + this.field_tryCount + " conetent:%s}";
      arrayOfObject = new Object[1];
      localObject1 = dyb();
      if (localObject1 == null) {
        break label171;
      }
      localObject1 = ((FinderCommentInfo)localObject1).content;
      if (localObject1 == null) {
        break label171;
      }
      p.g(localObject1, "it");
      i = Math.min(((String)localObject1).length(), 2);
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(167035);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((String)localObject1).substring(0, i);
    p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    if (localObject1 == null) {
      label171:
      localObject1 = "";
    }
    for (;;)
    {
      arrayOfObject[0] = localObject1;
      localObject1 = String.format((String)localObject2, Arrays.copyOf(arrayOfObject, 1));
      p.g(localObject1, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(167035);
      return localObject1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject$Companion;", "", "()V", "FAILED_BAN", "", "FAILED_NORMAL", "STATE_ERROR", "STATE_REPLIED", "STATE_REPLYING", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.an
 * JD-Core Version:    0.7.0.1
 */