package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.avc;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderCommentLogic;", "", "()V", "DEFAULT_PAGE_COUNT", "", "TAG", "", "createLocalComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "objectId", "", "objectNonceId", "username", "feedUsername", "replyCommentId", "replyContent", "replyUsername", "replyNickname", "content", "nickname", "scene", "localCommentId", "replyFinder", "", "rootComment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reason", "mentionList", "", "Lcom/tencent/mm/plugin/finder/view/MentionContact;", "commentPastedList", "Ljava/util/LinkedList;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJZLcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILjava/util/List;Ljava/util/LinkedList;)Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "transformFinderCommentInfoToLocalFinderCommentObject", "info", "feedId", "rootCommentId", "transformLevel1Comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "level1CommentInfo", "transformLevel2Comment", "level2CommentInfo", "transformLevel2CommentFromLevel1", "level1Comment", "transformLocalFinderCommentObject", "local", "transformLocalFinderCommentObjectToFinderCommentInfo", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a FNx;
  
  static
  {
    AppMethodBeat.i(167088);
    FNx = new a();
    AppMethodBeat.o(167088);
  }
  
  public static t a(FinderCommentInfo paramFinderCommentInfo, long paramLong)
  {
    AppMethodBeat.i(178426);
    s.u(paramFinderCommentInfo, "level1CommentInfo");
    paramFinderCommentInfo = d(a(paramFinderCommentInfo, paramLong, 0L));
    AppMethodBeat.o(178426);
    return paramFinderCommentInfo;
  }
  
  public static au a(long paramLong1, String paramString1, String paramString2, String paramString3, Long paramLong, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, long paramLong2, boolean paramBoolean, FinderCommentInfo paramFinderCommentInfo, bui parambui, int paramInt2, List<com.tencent.mm.plugin.finder.view.ah> paramList, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(339519);
    s.u(paramString1, "objectNonceId");
    s.u(paramString2, "username");
    s.u(paramString3, "feedUsername");
    s.u(paramString8, "nickname");
    s.u(paramList, "mentionList");
    au localau = new au();
    localau.field_actionType = 1;
    localau.field_feedId = paramLong1;
    localau.field_objectNonceId = paramString1;
    localau.field_localCommentId = paramLong2;
    localau.eZI().displayid = 0L;
    if (paramFinderCommentInfo == null) {
      paramLong1 = 0L;
    }
    for (;;)
    {
      localau.qf(paramLong1);
      label124:
      int i;
      if (paramInt1 == 1)
      {
        localau.setUsername(paramString2);
        paramString1 = d.AwY;
        paramString1 = d.a.auT(z.bAW());
        if (paramString1 == null)
        {
          paramString1 = "";
          localau.aAK(paramString1);
          if (paramString7 != null)
          {
            s.u(paramString7, "value");
            localau.eZI().content = paramString7;
          }
          s.u(paramString8, "value");
          localau.eZI().nickname = paramString8;
          localau.qg(cn.bDu() / 1000L);
          if (!s.p(paramString2, paramString3)) {
            break label765;
          }
          i = 2;
          label193:
          localau.Tu(i);
          localau.field_state = 1;
          if (paramLong != null)
          {
            ((Number)paramLong).longValue();
            paramLong1 = paramLong.longValue();
            localau.eZI().replyCommentId = paramLong1;
            paramString1 = paramString4;
            if (paramString4 == null) {
              paramString1 = "";
            }
            s.u(paramString1, "value");
            localau.eZI().reply_content = paramString1;
            if (paramString5 != null) {
              break label784;
            }
            paramString1 = "";
            s.u(paramString1, "value");
            localau.eZI().reply_username = paramString1;
            paramString1 = paramString6;
            if (paramString6 == null) {
              paramString1 = "";
            }
            s.u(paramString1, "value");
            localau.eZI().replyNickname = paramString1;
            if (Util.isEqual(paramString5, paramString3)) {
              localau.Tu(localau.eZI().displayFlag | 0x4);
            }
            if (paramBoolean) {
              localau.Tu(localau.eZI().displayFlag | 0x10);
            }
            if (paramFinderCommentInfo != null)
            {
              paramString2 = localau.field_actionInfo;
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
          localau.eZI().client_id = paramString1;
          localau.field_scene = paramInt1;
          localau.field_postTime = System.currentTimeMillis();
          localau.field_tryCount = 0L;
          localau.field_actionInfo.Auc = parambui;
          localau.field_actionInfo.ZDH = paramInt2;
          paramString1 = new LinkedList();
          paramString2 = ((Iterable)paramList).iterator();
          for (;;)
          {
            if (paramString2.hasNext())
            {
              paramString3 = (com.tencent.mm.plugin.finder.view.ah)paramString2.next();
              paramLong = av.GiL;
              s.u(paramString3, "ct");
              paramLong = new byte[16];
              av.a(0, paramLong, paramString3.start);
              av.a(8, paramLong, paramString3.length);
              Log.i(av.TAG, s.X("parseMentionContactToPb mentionCliBuf = ", com.tencent.tinker.a.b.b.a.toHexString(paramLong)));
              paramString4 = new avc();
              paramString4.ZFt = new b(paramLong);
              paramString4.username = paramString3.username;
              paramString1.add(paramString4);
              continue;
              paramLong1 = paramFinderCommentInfo.commentId;
              break;
              Object localObject = paramString1.amx();
              paramString1 = (String)localObject;
              if (localObject != null) {
                break label124;
              }
              paramString1 = "";
              break label124;
              paramString1 = z.bAM();
              s.s(paramString1, "getUsernameFromUserInfo()");
              localau.setUsername(paramString1);
              paramString1 = q.bFE().LS(localau.getUsername());
              if (paramString1 != null)
              {
                localObject = (CharSequence)paramString1.bFw();
                if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
                  break label744;
                }
                i = 1;
                label700:
                if (i == 0) {
                  break label750;
                }
                paramString1 = paramString1.bFx();
                s.s(paramString1, "imgFlag.smallUrl");
              }
              for (;;)
              {
                localau.aAK(paramString1);
                if (!Util.isNullOrNil(localau.exZ())) {
                  break;
                }
                localau.aAK("");
                break;
                label744:
                i = 0;
                break label700;
                label750:
                paramString1 = paramString1.bFw();
                s.s(paramString1, "imgFlag.bigUrl");
              }
              label765:
              if (paramInt1 == 1)
              {
                i = 8;
                break label193;
              }
              i = 0;
              break label193;
              label784:
              paramString1 = paramString5;
            }
          }
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
        if (paramString1.expandCommentCount > 0) {}
        for (i = 1;; i = 0)
        {
          paramString1.continueFlag = i;
          paramString3 = paramString1.levelTwoComment;
          if (paramString3 != null) {
            paramString3.clear();
          }
          paramString1.lastBuffer = null;
          paramString1.displayid = 0L;
          paramString3 = kotlin.ah.aiuX;
          break;
        }
        localau.field_actionInfo.ZDI = paramString1;
        localau.eZI().extFlag = 1;
        localau.FME = paramLinkedList;
        AppMethodBeat.o(339519);
      }
    }
    return localau;
  }
  
  private static au a(FinderCommentInfo paramFinderCommentInfo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(178424);
    s.u(paramFinderCommentInfo, "info");
    au localau = new au();
    localau.field_feedId = paramLong1;
    localau.field_state = 2;
    s.u(paramFinderCommentInfo, "value");
    localau.field_actionInfo.ZDD = paramFinderCommentInfo;
    localau.qf(paramLong2);
    AppMethodBeat.o(178424);
    return localau;
  }
  
  public static t b(FinderCommentInfo paramFinderCommentInfo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(178427);
    s.u(paramFinderCommentInfo, "level2CommentInfo");
    paramFinderCommentInfo = d(a(paramFinderCommentInfo, paramLong1, paramLong2));
    AppMethodBeat.o(178427);
    return paramFinderCommentInfo;
  }
  
  public static t d(au paramau)
  {
    AppMethodBeat.i(167085);
    s.u(paramau, "local");
    paramau = new t(paramau);
    paramau.ECw = p.b(MMApplicationContext.getContext(), (CharSequence)paramau.ECu.getContent());
    AppMethodBeat.o(167085);
    return paramau;
  }
  
  public static FinderCommentInfo e(au paramau)
  {
    AppMethodBeat.i(339574);
    s.u(paramau, "local");
    FinderCommentInfo localFinderCommentInfo = new FinderCommentInfo();
    localFinderCommentInfo.username = paramau.getUsername();
    localFinderCommentInfo.displayid = paramau.eZI().displayid;
    localFinderCommentInfo.commentId = paramau.eZI().commentId;
    localFinderCommentInfo.content = paramau.getContent();
    localFinderCommentInfo.createtime = paramau.eZI().createtime;
    localFinderCommentInfo.deleteFlag = paramau.eZI().deleteFlag;
    localFinderCommentInfo.replyCommentId = paramau.eZI().replyCommentId;
    localFinderCommentInfo.nickname = paramau.getNickname();
    localFinderCommentInfo.headUrl = paramau.exZ();
    localFinderCommentInfo.replyNickname = paramau.eZJ();
    localFinderCommentInfo.likeCount = paramau.eZI().likeCount;
    localFinderCommentInfo.likeFlag = paramau.eZI().likeFlag;
    localFinderCommentInfo.expandCommentCount = paramau.eZI().expandCommentCount;
    localFinderCommentInfo.continueFlag = paramau.eZI().continueFlag;
    localFinderCommentInfo.displayFlag = paramau.eZI().displayFlag;
    localFinderCommentInfo.blacklist_flag = paramau.eZI().blacklist_flag;
    localFinderCommentInfo.reply_content = paramau.eZK();
    localFinderCommentInfo.reply_username = paramau.eZL();
    localFinderCommentInfo.client_id = paramau.eZM();
    localFinderCommentInfo.extFlag = paramau.eZI().extFlag;
    AppMethodBeat.o(339574);
    return localFinderCommentInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.a
 * JD-Core Version:    0.7.0.1
 */