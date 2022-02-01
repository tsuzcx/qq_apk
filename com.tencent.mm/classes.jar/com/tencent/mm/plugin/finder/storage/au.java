package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.protobuf.djn;
import com.tencent.mm.protocal.protobuf.djo;
import com.tencent.mm.protocal.protobuf.pu;
import java.util.Arrays;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction;", "()V", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizInfoForFinder;", "getBizInfo", "()Lcom/tencent/mm/protocal/protobuf/BizInfoForFinder;", "value", "", "blacklist_flag", "getBlacklist_flag", "()I", "setBlacklist_flag", "(I)V", "canRemove", "getCanRemove", "setCanRemove", "", "clientId", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "", "commentId", "getCommentId", "()J", "setCommentId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentInfo", "getCommentInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "setCommentInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;)V", "commentPastedList", "Ljava/util/LinkedList;", "getCommentPastedList", "()Ljava/util/LinkedList;", "setCommentPastedList", "(Ljava/util/LinkedList;)V", "content", "getContent", "setContent", "continueFlag", "getContinueFlag", "setContinueFlag", "createtime", "getCreatetime", "setCreatetime", "deleteFlag", "getDeleteFlag", "setDeleteFlag", "displayFlag", "getDisplayFlag", "setDisplayFlag", "displayid", "getDisplayid", "setDisplayid", "displayidDiscarded", "getDisplayidDiscarded", "setDisplayidDiscarded", "expandCommentCount", "getExpandCommentCount", "setExpandCommentCount", "extFlag", "getExtFlag", "setExtFlag", "failedFlag", "getFailedFlag", "setFailedFlag", "feedId", "getFeedId", "setFeedId", "headUrl", "getHeadUrl", "setHeadUrl", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "kotlin.jvm.PlatformType", "levelTwoComment", "getLevelTwoComment", "setLevelTwoComment", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "nickname", "getNickname", "setNickname", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "postCommentReason", "getPostCommentReason", "setPostCommentReason", "replyBizInfo", "getReplyBizInfo", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "replyNickname", "getReplyNickname", "setReplyNickname", "reply_content", "getReply_content", "setReply_content", "reply_username", "getReply_username", "setReply_username", "rootCommentId", "getRootCommentId", "setRootCommentId", "state", "getState", "setState", "upContinueFlag", "getUpContinueFlag", "setUpContinueFlag", "username", "getUsername", "setUsername", "isAuthorMentioned", "", "isCommentCanDelete", "isCommentSent", "isExtFlagFriend", "isFinderComment", "isPoster", "isReplyerFinder", "isReplyerPoster", "toString", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class au
  extends at
{
  public static final a FMD;
  public LinkedList<String> FME;
  
  static
  {
    AppMethodBeat.i(167037);
    FMD = new a((byte)0);
    AppMethodBeat.o(167037);
  }
  
  public au()
  {
    AppMethodBeat.i(167036);
    atd localatd = new atd();
    localatd.ZDD = new FinderCommentInfo();
    localatd.ZDE = new djn();
    localatd.ZDF = new djo();
    ah localah = ah.aiuX;
    this.field_actionInfo = localatd;
    this.FME = new LinkedList();
    AppMethodBeat.o(167036);
  }
  
  public final void Tt(int paramInt)
  {
    AppMethodBeat.i(339094);
    eZI().expandCommentCount = paramInt;
    AppMethodBeat.o(339094);
  }
  
  public final void Tu(int paramInt)
  {
    AppMethodBeat.i(339099);
    eZI().displayFlag = paramInt;
    AppMethodBeat.o(339099);
  }
  
  public final void aAK(String paramString)
  {
    AppMethodBeat.i(167034);
    s.u(paramString, "value");
    eZI().headUrl = paramString;
    AppMethodBeat.o(167034);
  }
  
  public final FinderCommentInfo eZI()
  {
    AppMethodBeat.i(339039);
    FinderCommentInfo localFinderCommentInfo = this.field_actionInfo.ZDD;
    if (localFinderCommentInfo == null)
    {
      localFinderCommentInfo = new FinderCommentInfo();
      AppMethodBeat.o(339039);
      return localFinderCommentInfo;
    }
    AppMethodBeat.o(339039);
    return localFinderCommentInfo;
  }
  
  public final String eZJ()
  {
    String str = null;
    AppMethodBeat.i(339085);
    Object localObject = eZI().reply_contact;
    if (localObject == null) {}
    while (str == null)
    {
      str = eZI().replyNickname;
      if (str == null)
      {
        AppMethodBeat.o(339085);
        return "";
        localObject = c.a((FinderContact)localObject, null, false);
        if (localObject != null) {
          str = ((m)localObject).getNickname();
        }
      }
      else
      {
        AppMethodBeat.o(339085);
        return str;
      }
    }
    AppMethodBeat.o(339085);
    return str;
  }
  
  public final String eZK()
  {
    AppMethodBeat.i(339107);
    String str = eZI().reply_content;
    if (str == null)
    {
      AppMethodBeat.o(339107);
      return "";
    }
    AppMethodBeat.o(339107);
    return str;
  }
  
  public final String eZL()
  {
    AppMethodBeat.i(339114);
    String str = eZI().reply_username;
    if (str == null)
    {
      AppMethodBeat.o(339114);
      return "";
    }
    AppMethodBeat.o(339114);
    return str;
  }
  
  public final String eZM()
  {
    AppMethodBeat.i(339120);
    String str = eZI().client_id;
    if (str == null)
    {
      AppMethodBeat.o(339120);
      return "";
    }
    AppMethodBeat.o(339120);
    return str;
  }
  
  public final boolean eZN()
  {
    AppMethodBeat.i(339135);
    if ((eZI().extFlag & 0x1) > 0)
    {
      AppMethodBeat.o(339135);
      return true;
    }
    AppMethodBeat.o(339135);
    return false;
  }
  
  public final boolean eZO()
  {
    return (this.field_state != 1) && (this.field_state != -1);
  }
  
  public final boolean eZP()
  {
    AppMethodBeat.i(178419);
    aw localaw = aw.Gjk;
    boolean bool = aw.Us(eZI().displayFlag);
    AppMethodBeat.o(178419);
    return bool;
  }
  
  public final boolean eZQ()
  {
    AppMethodBeat.i(178420);
    aw localaw = aw.Gjk;
    boolean bool = aw.Ut(eZI().displayFlag);
    AppMethodBeat.o(178420);
    return bool;
  }
  
  public final boolean eZR()
  {
    AppMethodBeat.i(178421);
    if ((eZI().displayFlag & 0x4) != 0)
    {
      AppMethodBeat.o(178421);
      return true;
    }
    AppMethodBeat.o(178421);
    return false;
  }
  
  public final String exZ()
  {
    String str = null;
    AppMethodBeat.i(339068);
    Object localObject = eZI().author_contact;
    if (localObject == null) {}
    while (str == null)
    {
      str = eZI().headUrl;
      if (str == null)
      {
        AppMethodBeat.o(339068);
        return "";
        localObject = c.a((FinderContact)localObject, null, false);
        if (localObject != null) {
          str = ((m)localObject).amx();
        }
      }
      else
      {
        AppMethodBeat.o(339068);
        return str;
      }
    }
    AppMethodBeat.o(339068);
    return str;
  }
  
  public final pu getBizInfo()
  {
    AppMethodBeat.i(339129);
    Object localObject = eZI().author_contact;
    if (localObject == null)
    {
      AppMethodBeat.o(339129);
      return null;
    }
    localObject = c.a((FinderContact)localObject, null, false);
    if (localObject == null)
    {
      AppMethodBeat.o(339129);
      return null;
    }
    localObject = c.a((m)localObject, false);
    AppMethodBeat.o(339129);
    return localObject;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(339060);
    String str = eZI().content;
    if (str == null)
    {
      AppMethodBeat.o(339060);
      return "";
    }
    AppMethodBeat.o(339060);
    return str;
  }
  
  public final String getNickname()
  {
    String str = null;
    AppMethodBeat.i(339056);
    Object localObject = eZI().author_contact;
    if (localObject == null) {}
    while (str == null)
    {
      str = eZI().nickname;
      if (str == null)
      {
        AppMethodBeat.o(339056);
        return "";
        localObject = c.a((FinderContact)localObject, null, false);
        if (localObject != null) {
          str = ((m)localObject).getNickname();
        }
      }
      else
      {
        AppMethodBeat.o(339056);
        return str;
      }
    }
    AppMethodBeat.o(339056);
    return str;
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
    AppMethodBeat.i(339045);
    String str = eZI().username;
    if (str == null)
    {
      AppMethodBeat.o(339045);
      return "";
    }
    AppMethodBeat.o(339045);
    return str;
  }
  
  public final void qf(long paramLong)
  {
    this.field_actionInfo.ABa = paramLong;
  }
  
  public final void qg(long paramLong)
  {
    AppMethodBeat.i(339080);
    eZI().createtime = paramLong;
    AppMethodBeat.o(339080);
  }
  
  public final void setLikeCount(int paramInt)
  {
    AppMethodBeat.i(339089);
    eZI().likeCount = paramInt;
    AppMethodBeat.o(339089);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(167033);
    s.u(paramString, "value");
    eZI().username = paramString;
    AppMethodBeat.o(167033);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167035);
    Object localObject1 = am.aixg;
    Object localObject2 = new StringBuilder("field_commentInfo{commentId:").append(eZI().commentId).append(", displayid:");
    localObject1 = eZI();
    Object[] arrayOfObject;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = localObject1 + " try_count " + this.field_tryCount + " conetent:%s}";
      arrayOfObject = new Object[1];
      localObject1 = eZI();
      if (localObject1 != null) {
        break label133;
      }
      localObject1 = "";
    }
    for (;;)
    {
      arrayOfObject[0] = localObject1;
      localObject1 = String.format((String)localObject2, Arrays.copyOf(arrayOfObject, 1));
      s.s(localObject1, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(167035);
      return localObject1;
      localObject1 = Long.valueOf(((FinderCommentInfo)localObject1).displayid);
      break;
      label133:
      localObject1 = ((FinderCommentInfo)localObject1).content;
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject1 = ((String)localObject1).substring(0, Math.min(((String)localObject1).length(), 2));
        s.s(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (localObject1 == null) {
          localObject1 = "";
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject$Companion;", "", "()V", "FAILED_BAN", "", "FAILED_NORMAL", "STATE_ERROR", "STATE_REPLIED", "STATE_REPLYING", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.au
 * JD-Core Version:    0.7.0.1
 */