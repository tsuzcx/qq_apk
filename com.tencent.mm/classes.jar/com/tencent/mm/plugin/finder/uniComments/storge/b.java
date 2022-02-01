package com.tencent.mm.plugin.finder.uniComments.storge;

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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniAction;", "()V", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizInfoForFinder;", "getBizInfo", "()Lcom/tencent/mm/protocal/protobuf/BizInfoForFinder;", "value", "", "blacklist_flag", "getBlacklist_flag", "()I", "setBlacklist_flag", "(I)V", "canRemove", "getCanRemove", "setCanRemove", "", "clientId", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "", "commentId", "getCommentId", "()J", "setCommentId", "(J)V", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentInfo", "getCommentInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "setCommentInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;)V", "commentPastedList", "Ljava/util/LinkedList;", "getCommentPastedList", "()Ljava/util/LinkedList;", "setCommentPastedList", "(Ljava/util/LinkedList;)V", "content", "getContent", "setContent", "continueFlag", "getContinueFlag", "setContinueFlag", "createtime", "getCreatetime", "setCreatetime", "deleteFlag", "getDeleteFlag", "setDeleteFlag", "displayFlag", "getDisplayFlag", "setDisplayFlag", "displayid", "getDisplayid", "setDisplayid", "displayidDiscarded", "getDisplayidDiscarded", "setDisplayidDiscarded", "expandCommentCount", "getExpandCommentCount", "setExpandCommentCount", "extFlag", "getExtFlag", "setExtFlag", "failedFlag", "getFailedFlag", "setFailedFlag", "feedId", "getFeedId", "setFeedId", "headUrl", "getHeadUrl", "setHeadUrl", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "kotlin.jvm.PlatformType", "levelTwoComment", "getLevelTwoComment", "setLevelTwoComment", "likeCount", "getLikeCount", "setLikeCount", "likeFlag", "getLikeFlag", "setLikeFlag", "nickname", "getNickname", "setNickname", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "postCommentReason", "getPostCommentReason", "setPostCommentReason", "replyBizInfo", "getReplyBizInfo", "replyCommentId", "getReplyCommentId", "setReplyCommentId", "replyNickname", "getReplyNickname", "setReplyNickname", "reply_content", "getReply_content", "setReply_content", "reply_username", "getReply_username", "setReply_username", "rootCommentId", "getRootCommentId", "setRootCommentId", "state", "getState", "setState", "uniEntityItem", "Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "getUniEntityItem", "()Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "setUniEntityItem", "(Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;)V", "upContinueFlag", "getUpContinueFlag", "setUpContinueFlag", "username", "getUsername", "setUsername", "isAuthorMentioned", "", "isCommentCanDelete", "isCommentSent", "isExtFlagFriend", "isFinderComment", "isPoster", "isReplyerFinder", "isReplyerPoster", "toString", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public static final a Gbm;
  public LinkedList<String> FME;
  public com.tencent.mm.plugin.finder.uniComments.model.b Gah;
  
  static
  {
    AppMethodBeat.i(341711);
    Gbm = new a((byte)0);
    AppMethodBeat.o(341711);
  }
  
  public b()
  {
    AppMethodBeat.i(341707);
    atd localatd = new atd();
    localatd.ZDD = new FinderCommentInfo();
    localatd.ZDE = new djn();
    localatd.ZDF = new djo();
    ah localah = ah.aiuX;
    this.field_actionInfo = localatd;
    this.FME = new LinkedList();
    AppMethodBeat.o(341707);
  }
  
  public final void Tt(int paramInt)
  {
    AppMethodBeat.i(341782);
    eZI().expandCommentCount = paramInt;
    AppMethodBeat.o(341782);
  }
  
  public final void Tu(int paramInt)
  {
    AppMethodBeat.i(341787);
    eZI().displayFlag = paramInt;
    AppMethodBeat.o(341787);
  }
  
  public final void aAK(String paramString)
  {
    AppMethodBeat.i(341759);
    s.u(paramString, "value");
    eZI().headUrl = paramString;
    AppMethodBeat.o(341759);
  }
  
  public final FinderCommentInfo eZI()
  {
    AppMethodBeat.i(341718);
    FinderCommentInfo localFinderCommentInfo = this.field_actionInfo.ZDD;
    if (localFinderCommentInfo == null)
    {
      localFinderCommentInfo = new FinderCommentInfo();
      AppMethodBeat.o(341718);
      return localFinderCommentInfo;
    }
    AppMethodBeat.o(341718);
    return localFinderCommentInfo;
  }
  
  public final String eZJ()
  {
    String str = null;
    AppMethodBeat.i(341771);
    Object localObject = eZI().reply_contact;
    if (localObject == null) {}
    while (str == null)
    {
      str = eZI().replyNickname;
      if (str == null)
      {
        AppMethodBeat.o(341771);
        return "";
        localObject = c.a((FinderContact)localObject, null, false);
        if (localObject != null) {
          str = ((m)localObject).getNickname();
        }
      }
      else
      {
        AppMethodBeat.o(341771);
        return str;
      }
    }
    AppMethodBeat.o(341771);
    return str;
  }
  
  public final String eZK()
  {
    AppMethodBeat.i(341796);
    String str = eZI().reply_content;
    if (str == null)
    {
      AppMethodBeat.o(341796);
      return "";
    }
    AppMethodBeat.o(341796);
    return str;
  }
  
  public final String eZL()
  {
    AppMethodBeat.i(341802);
    String str = eZI().reply_username;
    if (str == null)
    {
      AppMethodBeat.o(341802);
      return "";
    }
    AppMethodBeat.o(341802);
    return str;
  }
  
  public final String eZM()
  {
    AppMethodBeat.i(341808);
    String str = eZI().client_id;
    if (str == null)
    {
      AppMethodBeat.o(341808);
      return "";
    }
    AppMethodBeat.o(341808);
    return str;
  }
  
  public final boolean eZN()
  {
    AppMethodBeat.i(341823);
    if ((eZI().extFlag & 0x1) > 0)
    {
      AppMethodBeat.o(341823);
      return true;
    }
    AppMethodBeat.o(341823);
    return false;
  }
  
  public final boolean eZO()
  {
    return (this.field_state != 1) && (this.field_state != -1);
  }
  
  public final boolean eZP()
  {
    AppMethodBeat.i(341835);
    aw localaw = aw.Gjk;
    boolean bool = aw.Us(eZI().displayFlag);
    AppMethodBeat.o(341835);
    return bool;
  }
  
  public final boolean eZQ()
  {
    AppMethodBeat.i(341845);
    aw localaw = aw.Gjk;
    boolean bool = aw.Ut(eZI().displayFlag);
    AppMethodBeat.o(341845);
    return bool;
  }
  
  public final boolean eZR()
  {
    AppMethodBeat.i(341853);
    if ((eZI().displayFlag & 0x4) != 0)
    {
      AppMethodBeat.o(341853);
      return true;
    }
    AppMethodBeat.o(341853);
    return false;
  }
  
  public final String exZ()
  {
    String str = null;
    AppMethodBeat.i(341753);
    Object localObject = eZI().author_contact;
    if (localObject == null) {}
    while (str == null)
    {
      str = eZI().headUrl;
      if (str == null)
      {
        AppMethodBeat.o(341753);
        return "";
        localObject = c.a((FinderContact)localObject, null, false);
        if (localObject != null) {
          str = ((m)localObject).amx();
        }
      }
      else
      {
        AppMethodBeat.o(341753);
        return str;
      }
    }
    AppMethodBeat.o(341753);
    return str;
  }
  
  public final pu getBizInfo()
  {
    AppMethodBeat.i(341815);
    Object localObject = eZI().author_contact;
    if (localObject == null)
    {
      AppMethodBeat.o(341815);
      return null;
    }
    localObject = c.a((FinderContact)localObject, null, false);
    if (localObject == null)
    {
      AppMethodBeat.o(341815);
      return null;
    }
    localObject = c.a((m)localObject, false);
    AppMethodBeat.o(341815);
    return localObject;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(341746);
    String str = eZI().content;
    if (str == null)
    {
      AppMethodBeat.o(341746);
      return "";
    }
    AppMethodBeat.o(341746);
    return str;
  }
  
  public final String getNickname()
  {
    String str = null;
    AppMethodBeat.i(341741);
    Object localObject = eZI().author_contact;
    if (localObject == null) {}
    while (str == null)
    {
      str = eZI().nickname;
      if (str == null)
      {
        AppMethodBeat.o(341741);
        return "";
        localObject = c.a((FinderContact)localObject, null, false);
        if (localObject != null) {
          str = ((m)localObject).getNickname();
        }
      }
      else
      {
        AppMethodBeat.o(341741);
        return str;
      }
    }
    AppMethodBeat.o(341741);
    return str;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(341724);
    String str = eZI().username;
    if (str == null)
    {
      AppMethodBeat.o(341724);
      return "";
    }
    AppMethodBeat.o(341724);
    return str;
  }
  
  public final void qf(long paramLong)
  {
    this.field_actionInfo.ABa = paramLong;
  }
  
  public final void qg(long paramLong)
  {
    AppMethodBeat.i(341767);
    eZI().createtime = paramLong;
    AppMethodBeat.o(341767);
  }
  
  public final void setLikeCount(int paramInt)
  {
    AppMethodBeat.i(341776);
    eZI().likeCount = paramInt;
    AppMethodBeat.o(341776);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(341733);
    s.u(paramString, "value");
    eZI().username = paramString;
    AppMethodBeat.o(341733);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(341862);
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
        break label134;
      }
      localObject1 = "";
    }
    for (;;)
    {
      arrayOfObject[0] = localObject1;
      localObject1 = String.format((String)localObject2, Arrays.copyOf(arrayOfObject, 1));
      s.s(localObject1, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(341862);
      return localObject1;
      localObject1 = Long.valueOf(((FinderCommentInfo)localObject1).displayid);
      break;
      label134:
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject$Companion;", "", "()V", "FAILED_BAN", "", "FAILED_NORMAL", "STATE_ERROR", "STATE_REPLIED", "STATE_REPLYING", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.storge.b
 * JD-Core Version:    0.7.0.1
 */