package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderCommentLogic;", "", "()V", "DEFAULT_PAGE_COUNT", "", "TAG", "", "createLocalComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "objectId", "", "objectNonceId", "username", "feedUsername", "replyCommentId", "replyContent", "replyUsername", "replyNickname", "content", "nickname", "scene", "localCommentId", "replyFinder", "", "rootComment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reason", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJZLcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "transformFinderCommentInfoToLocalFinderCommentObject", "info", "feedId", "rootCommentId", "transformLevel1Comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "level1CommentInfo", "transformLevel2Comment", "level2CommentInfo", "transformLevel2CommentFromLevel1", "", "level1Comment", "transformLocalFinderCommentObject", "local", "transformLocalFinderCommentObjectToFinderCommentInfo", "plugin-finder_release"})
public final class a
{
  public static final a AnH;
  
  static
  {
    AppMethodBeat.i(167088);
    AnH = new a();
    AppMethodBeat.o(167088);
  }
  
  public static am a(long paramLong1, String paramString1, String paramString2, String paramString3, Long paramLong, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, long paramLong2, boolean paramBoolean, FinderCommentInfo paramFinderCommentInfo, bid parambid, int paramInt2)
  {
    AppMethodBeat.i(288181);
    p.k(paramString1, "objectNonceId");
    p.k(paramString2, "username");
    p.k(paramString3, "feedUsername");
    p.k(paramString8, "nickname");
    am localam = new am();
    localam.field_actionType = 1;
    localam.field_feedId = paramLong1;
    localam.field_objectNonceId = paramString1;
    localam.field_localCommentId = paramLong2;
    localam.dYY().displayid = 0L;
    Object localObject;
    int i;
    if (paramFinderCommentInfo != null)
    {
      paramLong1 = paramFinderCommentInfo.commentId;
      localam.MK(paramLong1);
      if (paramInt1 != 1) {
        break label558;
      }
      localam.setUsername(paramString2);
      paramString1 = d.wZQ;
      paramString1 = d.a.aAK(z.bdh());
      if (paramString1 != null)
      {
        localObject = paramString1.Mm();
        paramString1 = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localam.aER(paramString1);
      if (paramString7 != null)
      {
        p.k(paramString7, "value");
        localam.dYY().content = paramString7;
      }
      p.k(paramString8, "value");
      localam.dYY().nickname = paramString8;
      localam.ML(cm.bfC() / 1000L);
      if (!p.h(paramString2, paramString3)) {
        break label683;
      }
      i = 2;
      label204:
      localam.Qn(i);
      localam.field_state = 1;
      if (paramLong != null)
      {
        ((Number)paramLong).longValue();
        paramLong1 = paramLong.longValue();
        localam.dYY().replyCommentId = paramLong1;
        paramString1 = paramString4;
        if (paramString4 == null) {
          paramString1 = "";
        }
        p.k(paramString1, "value");
        localam.dYY().reply_content = paramString1;
        if (paramString5 != null) {
          break label735;
        }
      }
    }
    label558:
    label735:
    for (paramString1 = "";; paramString1 = paramString5) {
      for (;;)
      {
        p.k(paramString1, "value");
        localam.dYY().reply_username = paramString1;
        paramString1 = paramString6;
        if (paramString6 == null) {
          paramString1 = "";
        }
        p.k(paramString1, "value");
        localam.dYY().replyNickname = paramString1;
        if (Util.isEqual(paramString5, paramString3)) {
          localam.Qn(localam.dYY().displayFlag | 0x4);
        }
        if (paramBoolean) {
          localam.Qn(localam.dYY().displayFlag | 0x10);
        }
        if (paramFinderCommentInfo != null)
        {
          paramString2 = localam.field_actionInfo;
          paramString1 = (com.tencent.mm.cd.a)new FinderCommentInfo();
          paramString3 = paramFinderCommentInfo.toByteArray();
        }
        try
        {
          paramString1.parseFrom(paramString3);
          paramString1 = (FinderCommentInfo)paramString1;
          if (paramString1 != null)
          {
            paramString1.expandCommentCount -= 1;
            paramString1.upContinueFlag = 0;
            if (paramString1.expandCommentCount > 0)
            {
              i = 1;
              paramString1.continueFlag = i;
              paramString3 = paramString1.levelTwoComment;
              if (paramString3 != null) {
                paramString3.clear();
              }
              paramString1.lastBuffer = null;
              paramString1.displayid = 0L;
              paramString2.SCO = paramString1;
              paramString1 = String.valueOf(paramLong2);
              p.k(paramString1, "value");
              localam.dYY().client_id = paramString1;
              localam.field_scene = paramInt1;
              localam.field_postTime = System.currentTimeMillis();
              localam.field_tryCount = 0L;
              localam.field_actionInfo.xbu = parambid;
              localam.field_actionInfo.SCP = paramInt2;
              localam.dYY().extFlag = 1;
              AppMethodBeat.o(288181);
              return localam;
              paramLong1 = 0L;
              break;
              paramString1 = z.bcZ();
              p.j(paramString1, "ConfigStorageLogic.getUsernameFromUserInfo()");
              localam.setUsername(paramString1);
              paramString1 = q.bhP().TS(localam.getUsername());
              if (paramString1 != null)
              {
                localObject = (CharSequence)paramString1.bhH();
                if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
                  break label662;
                }
                i = 1;
                label618:
                if (i == 0) {
                  break label668;
                }
                paramString1 = paramString1.bhI();
                p.j(paramString1, "imgFlag.smallUrl");
              }
              for (;;)
              {
                localam.aER(paramString1);
                if (!Util.isNullOrNil(localam.dYZ())) {
                  break;
                }
                localam.aER("");
                break;
                i = 0;
                break label618;
                paramString1 = paramString1.bhH();
                p.j(paramString1, "imgFlag.bigUrl");
              }
              if (paramInt1 == 1)
              {
                i = 8;
                break label204;
              }
              i = 0;
            }
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { paramString1 });
            paramString1 = null;
            continue;
            i = 0;
            continue;
            paramString1 = null;
          }
        }
      }
    }
  }
  
  private static am a(FinderCommentInfo paramFinderCommentInfo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(178424);
    p.k(paramFinderCommentInfo, "info");
    am localam = new am();
    localam.field_feedId = paramLong1;
    localam.field_state = 2;
    p.k(paramFinderCommentInfo, "value");
    localam.field_actionInfo.SCL = paramFinderCommentInfo;
    localam.MK(paramLong2);
    AppMethodBeat.o(178424);
    return localam;
  }
  
  public static s b(am paramam)
  {
    AppMethodBeat.i(167085);
    p.k(paramam, "local");
    paramam = new s(paramam);
    paramam.zAm = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramam.zAt.getContent());
    AppMethodBeat.o(167085);
    return paramam;
  }
  
  public static s b(FinderCommentInfo paramFinderCommentInfo, long paramLong)
  {
    AppMethodBeat.i(178426);
    p.k(paramFinderCommentInfo, "level1CommentInfo");
    paramFinderCommentInfo = b(a(paramFinderCommentInfo, paramLong, 0L));
    AppMethodBeat.o(178426);
    return paramFinderCommentInfo;
  }
  
  public static s b(FinderCommentInfo paramFinderCommentInfo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(178427);
    p.k(paramFinderCommentInfo, "level2CommentInfo");
    paramFinderCommentInfo = b(a(paramFinderCommentInfo, paramLong1, paramLong2));
    AppMethodBeat.o(178427);
    return paramFinderCommentInfo;
  }
  
  public static FinderCommentInfo c(am paramam)
  {
    AppMethodBeat.i(288182);
    p.k(paramam, "local");
    FinderCommentInfo localFinderCommentInfo = new FinderCommentInfo();
    localFinderCommentInfo.username = paramam.getUsername();
    localFinderCommentInfo.displayid = paramam.dYY().displayid;
    localFinderCommentInfo.commentId = paramam.dYY().commentId;
    localFinderCommentInfo.content = paramam.getContent();
    localFinderCommentInfo.createtime = paramam.dYY().createtime;
    localFinderCommentInfo.deleteFlag = paramam.dYY().deleteFlag;
    localFinderCommentInfo.replyCommentId = paramam.dYY().replyCommentId;
    localFinderCommentInfo.nickname = paramam.getNickname();
    localFinderCommentInfo.headUrl = paramam.dYZ();
    localFinderCommentInfo.replyNickname = paramam.dZa();
    localFinderCommentInfo.likeCount = paramam.dYY().likeCount;
    localFinderCommentInfo.likeFlag = paramam.dYY().likeFlag;
    localFinderCommentInfo.expandCommentCount = paramam.dYY().expandCommentCount;
    localFinderCommentInfo.continueFlag = paramam.dYY().continueFlag;
    localFinderCommentInfo.displayFlag = paramam.dYY().displayFlag;
    localFinderCommentInfo.blacklist_flag = paramam.dYY().blacklist_flag;
    localFinderCommentInfo.reply_content = paramam.dZb();
    localFinderCommentInfo.reply_username = paramam.dZc();
    localFinderCommentInfo.client_id = paramam.dZd();
    localFinderCommentInfo.extFlag = paramam.dYY().extFlag;
    AppMethodBeat.o(288182);
    return localFinderCommentInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.a
 * JD-Core Version:    0.7.0.1
 */