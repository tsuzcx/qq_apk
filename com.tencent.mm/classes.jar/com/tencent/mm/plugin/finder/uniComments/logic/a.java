package com.tencent.mm.plugin.finder.uniComments.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.uniComments.storge.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/logic/UniCommentLogic;", "", "()V", "DEFAULT_PAGE_COUNT", "", "TAG", "", "createLocalComment", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "objectId", "", "objectNonceId", "username", "feedUsername", "replyCommentId", "replyContent", "replyUsername", "replyNickname", "content", "nickname", "scene", "localCommentId", "replyFinder", "", "rootComment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reason", "mentionList", "", "Lcom/tencent/mm/plugin/finder/uniComments/MentionContact;", "commentPastedList", "Ljava/util/LinkedList;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJZLcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILjava/util/List;Ljava/util/LinkedList;)Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "transformFinderCommentInfoToLocalFinderCommentObject", "info", "feedId", "rootCommentId", "transformLevel1Comment", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "level1CommentInfo", "transformLevel2Comment", "level2CommentInfo", "transformLevel2CommentFromLevel1", "level1Comment", "transformLocalFinderCommentObject", "local", "transformLocalFinderCommentObjectToFinderCommentInfo", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a GaM;
  
  static
  {
    AppMethodBeat.i(341541);
    GaM = new a();
    AppMethodBeat.o(341541);
  }
  
  public static b a(long paramLong1, String paramString1, String paramString2, String paramString3, Long paramLong, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, long paramLong2, boolean paramBoolean, FinderCommentInfo paramFinderCommentInfo, int paramInt2, List<com.tencent.mm.plugin.finder.uniComments.a> paramList, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(341509);
    s.u(paramString1, "objectNonceId");
    s.u(paramString2, "username");
    s.u(paramString3, "feedUsername");
    s.u(paramString8, "nickname");
    s.u(paramList, "mentionList");
    b localb = new b();
    localb.field_actionType = 1;
    localb.field_feedId = paramLong1;
    localb.field_objectNonceId = paramString1;
    localb.field_localCommentId = paramLong2;
    localb.eZI().displayid = 0L;
    if (paramFinderCommentInfo == null) {
      paramLong1 = 0L;
    }
    for (;;)
    {
      localb.qf(paramLong1);
      if (paramInt1 == 1)
      {
        localb.setUsername(paramString2);
        paramString1 = com.tencent.mm.plugin.finder.api.d.AwY;
        paramString1 = d.a.auT(z.bAW());
        if (paramString1 == null)
        {
          paramString1 = "";
          label124:
          localb.aAK(paramString1);
          if (paramString7 != null)
          {
            s.u(paramString7, "value");
            localb.eZI().content = paramString7;
          }
          s.u(paramString8, "value");
          localb.eZI().nickname = paramString8;
          localb.qg(cn.bDu() / 1000L);
          if (!s.p(paramString2, paramString3)) {
            break label664;
          }
          i = 2;
          label193:
          localb.Tu(i);
          localb.field_state = 1;
          if (paramLong != null)
          {
            ((Number)paramLong).longValue();
            paramLong1 = paramLong.longValue();
            localb.eZI().replyCommentId = paramLong1;
            paramString1 = paramString4;
            if (paramString4 == null) {
              paramString1 = "";
            }
            s.u(paramString1, "value");
            localb.eZI().reply_content = paramString1;
            if (paramString5 != null) {
              break label683;
            }
            paramString1 = "";
            s.u(paramString1, "value");
            localb.eZI().reply_username = paramString1;
            paramString1 = paramString6;
            if (paramString6 == null) {
              paramString1 = "";
            }
            s.u(paramString1, "value");
            localb.eZI().replyNickname = paramString1;
            if (Util.isEqual(paramString5, paramString3)) {
              localb.Tu(localb.eZI().displayFlag | 0x4);
            }
            if (paramBoolean) {
              localb.Tu(localb.eZI().displayFlag | 0x10);
            }
            if (paramFinderCommentInfo != null)
            {
              paramString2 = localb.field_actionInfo;
              paramString1 = (com.tencent.mm.bx.a)new FinderCommentInfo();
              paramString3 = paramFinderCommentInfo.toByteArray();
            }
          }
        }
      }
      try
      {
        paramString1.parseFrom(paramString3);
        paramString1 = (FinderCommentInfo)paramString1;
        if (paramString1 == null)
        {
          paramString1 = null;
          paramString2.ZDG = paramString1;
          paramString1 = String.valueOf(paramLong2);
          s.u(paramString1, "value");
          localb.eZI().client_id = paramString1;
          localb.field_scene = paramInt1;
          localb.field_postTime = System.currentTimeMillis();
          localb.field_tryCount = 0L;
          localb.field_actionInfo.Auc = null;
          localb.field_actionInfo.ZDH = paramInt2;
          paramString1 = new LinkedList();
          localb.field_actionInfo.ZDI = paramString1;
          localb.eZI().extFlag = 1;
          localb.FME = paramLinkedList;
          AppMethodBeat.o(341509);
          return localb;
          paramLong1 = paramFinderCommentInfo.commentId;
          continue;
          paramList = paramString1.amx();
          paramString1 = paramList;
          if (paramList != null) {
            break label124;
          }
          paramString1 = "";
          break label124;
          paramString1 = z.bAM();
          s.s(paramString1, "getUsernameFromUserInfo()");
          localb.setUsername(paramString1);
          paramString1 = q.bFE().LS(localb.getUsername());
          if (paramString1 != null)
          {
            paramList = (CharSequence)paramString1.bFw();
            if ((paramList != null) && (paramList.length() != 0)) {
              break label643;
            }
            i = 1;
            label599:
            if (i == 0) {
              break label649;
            }
            paramString1 = paramString1.bFx();
            s.s(paramString1, "imgFlag.smallUrl");
          }
          for (;;)
          {
            localb.aAK(paramString1);
            if (!Util.isNullOrNil(localb.exZ())) {
              break;
            }
            localb.aAK("");
            break;
            label643:
            i = 0;
            break label599;
            label649:
            paramString1 = paramString1.bFw();
            s.s(paramString1, "imgFlag.bigUrl");
          }
          label664:
          if (paramInt1 == 1)
          {
            i = 8;
            break label193;
          }
          i = 0;
          break label193;
          label683:
          paramString1 = paramString5;
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramString1 });
          paramString1 = null;
        }
        paramString1.expandCommentCount -= 1;
        paramString1.upContinueFlag = 0;
        if (paramString1.expandCommentCount <= 0) {}
      }
    }
    for (int i = 1;; i = 0)
    {
      paramString1.continueFlag = i;
      paramString3 = paramString1.levelTwoComment;
      if (paramString3 != null) {
        paramString3.clear();
      }
      paramString1.lastBuffer = null;
      paramString1.displayid = 0L;
      paramString3 = ah.aiuX;
      break;
    }
  }
  
  public static com.tencent.mm.plugin.finder.uniComments.storge.d b(FinderCommentInfo paramFinderCommentInfo, long paramLong)
  {
    AppMethodBeat.i(341532);
    s.u(paramFinderCommentInfo, "level1CommentInfo");
    paramFinderCommentInfo = c(c(paramFinderCommentInfo, paramLong, 0L));
    AppMethodBeat.o(341532);
    return paramFinderCommentInfo;
  }
  
  private static b c(FinderCommentInfo paramFinderCommentInfo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(341525);
    s.u(paramFinderCommentInfo, "info");
    b localb = new b();
    localb.field_feedId = paramLong1;
    localb.field_state = 2;
    s.u(paramFinderCommentInfo, "value");
    localb.field_actionInfo.ZDD = paramFinderCommentInfo;
    localb.qf(paramLong2);
    AppMethodBeat.o(341525);
    return localb;
  }
  
  public static com.tencent.mm.plugin.finder.uniComments.storge.d c(b paramb)
  {
    AppMethodBeat.i(341516);
    s.u(paramb, "local");
    paramb = new com.tencent.mm.plugin.finder.uniComments.storge.d(paramb);
    paramb.ECw = p.b(MMApplicationContext.getContext(), (CharSequence)paramb.Gbp.getContent());
    AppMethodBeat.o(341516);
    return paramb;
  }
  
  public static com.tencent.mm.plugin.finder.uniComments.storge.d d(FinderCommentInfo paramFinderCommentInfo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(341537);
    s.u(paramFinderCommentInfo, "level2CommentInfo");
    paramFinderCommentInfo = c(c(paramFinderCommentInfo, paramLong1, paramLong2));
    AppMethodBeat.o(341537);
    return paramFinderCommentInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.logic.a
 * JD-Core Version:    0.7.0.1
 */