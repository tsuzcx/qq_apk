package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderCommentLogic;", "", "()V", "DEFAULT_PAGE_COUNT", "", "TAG", "", "createLocalComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "objectId", "", "objectNonceId", "username", "feedUsername", "replyCommentId", "replyContent", "replyUsername", "replyNickname", "content", "nickname", "scene", "localCommentId", "replyFinder", "", "rootComment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reason", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJZLcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "transformFinderCommentInfoToLocalFinderCommentObject", "info", "feedId", "rootCommentId", "transformLevel1Comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "level1CommentInfo", "transformLevel2Comment", "level2CommentInfo", "transformLevel2CommentFromLevel1", "", "level1Comment", "transformLocalFinderCommentObject", "local", "transformLocalFinderCommentObjectToFinderCommentInfo", "plugin-finder_release"})
public final class a
{
  public static final a sAq;
  
  static
  {
    AppMethodBeat.i(167088);
    sAq = new a();
    AppMethodBeat.o(167088);
  }
  
  public static ab a(long paramLong1, String paramString1, String paramString2, String paramString3, Long paramLong, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, long paramLong2, boolean paramBoolean, FinderCommentInfo paramFinderCommentInfo, aqy paramaqy, int paramInt2)
  {
    AppMethodBeat.i(221545);
    d.g.b.p.h(paramString1, "objectNonceId");
    d.g.b.p.h(paramString2, "username");
    d.g.b.p.h(paramString3, "feedUsername");
    d.g.b.p.h(paramString8, "nickname");
    ab localab = new ab();
    localab.field_actionType = 1;
    localab.field_feedId = paramLong1;
    localab.field_objectNonceId = paramString1;
    localab.field_localCommentId = paramLong2;
    localab.field_actionInfo.Gla.displayid = 0L;
    Object localObject;
    int i;
    if (paramFinderCommentInfo != null)
    {
      paramLong1 = paramFinderCommentInfo.commentId;
      localab.wR(paramLong1);
      if (paramInt1 != 1) {
        break label587;
      }
      localab.setUsername(paramString2);
      paramString1 = c.rHn;
      paramString1 = u.aAu();
      d.g.b.p.g(paramString1, "ConfigStorageLogic.getMyFinderUsername()");
      paramString1 = c.a.agW(paramString1);
      if (paramString1 != null)
      {
        localObject = paramString1.cxL();
        paramString1 = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localab.aiz(paramString1);
      if (paramString7 != null)
      {
        d.g.b.p.h(paramString7, "value");
        localab.field_actionInfo.Gla.content = paramString7;
      }
      d.g.b.p.h(paramString8, "value");
      localab.field_actionInfo.Gla.nickname = paramString8;
      localab.wS(cf.aCK() / 1000L);
      if (!d.g.b.p.i(paramString2, paramString3)) {
        break label712;
      }
      i = 2;
      label221:
      localab.Fp(i);
      localab.field_state = 1;
      if (paramLong != null)
      {
        ((Number)paramLong).longValue();
        paramLong1 = paramLong.longValue();
        localab.field_actionInfo.Gla.replyCommentId = paramLong1;
        paramString1 = paramString4;
        if (paramString4 == null) {
          paramString1 = "";
        }
        d.g.b.p.h(paramString1, "value");
        localab.field_actionInfo.Gla.reply_content = paramString1;
        if (paramString5 != null) {
          break label764;
        }
      }
    }
    label587:
    label764:
    for (paramString1 = "";; paramString1 = paramString5) {
      for (;;)
      {
        d.g.b.p.h(paramString1, "value");
        localab.field_actionInfo.Gla.reply_username = paramString1;
        paramString1 = paramString6;
        if (paramString6 == null) {
          paramString1 = "";
        }
        d.g.b.p.h(paramString1, "value");
        localab.field_actionInfo.Gla.replyNickname = paramString1;
        if (bt.lQ(paramString5, paramString3)) {
          localab.Fp(localab.cIK() | 0x4);
        }
        if (paramBoolean) {
          localab.Fp(localab.cIK() | 0x10);
        }
        if (paramFinderCommentInfo != null)
        {
          paramString2 = localab.field_actionInfo;
          paramString1 = (com.tencent.mm.bx.a)new FinderCommentInfo();
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
              paramString2.Gld = paramString1;
              paramString1 = String.valueOf(paramLong2);
              d.g.b.p.h(paramString1, "value");
              localab.field_actionInfo.Gla.client_id = paramString1;
              localab.field_scene = paramInt1;
              localab.field_postTime = System.currentTimeMillis();
              localab.field_tryCount = 0L;
              localab.field_actionInfo.rIl = paramaqy;
              localab.field_actionInfo.Oer = paramInt2;
              localab.field_actionInfo.Gla.extFlag = 1;
              AppMethodBeat.o(221545);
              return localab;
              paramLong1 = 0L;
              break;
              paramString1 = u.aAm();
              d.g.b.p.g(paramString1, "ConfigStorageLogic.getUsernameFromUserInfo()");
              localab.setUsername(paramString1);
              paramString1 = com.tencent.mm.ak.p.aEx().Dj(localab.getUsername());
              if (paramString1 != null)
              {
                localObject = (CharSequence)paramString1.aEq();
                if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
                  break label691;
                }
                i = 1;
                if (i == 0) {
                  break label697;
                }
                paramString1 = paramString1.aEr();
                d.g.b.p.g(paramString1, "imgFlag.smallUrl");
              }
              for (;;)
              {
                localab.aiz(paramString1);
                if (!bt.isNullOrNil(localab.cIH())) {
                  break;
                }
                localab.aiz("");
                break;
                i = 0;
                break label647;
                paramString1 = paramString1.aEq();
                d.g.b.p.g(paramString1, "imgFlag.bigUrl");
              }
              if (paramInt1 == 1)
              {
                i = 8;
                break label221;
              }
              i = 0;
            }
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            ad.l("safeParser", "", new Object[] { paramString1 });
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
  
  private static ab a(FinderCommentInfo paramFinderCommentInfo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(178424);
    d.g.b.p.h(paramFinderCommentInfo, "info");
    ab localab = new ab();
    localab.field_feedId = paramLong1;
    localab.field_state = 2;
    localab.field_actionInfo.Gla = paramFinderCommentInfo;
    localab.wR(paramLong2);
    AppMethodBeat.o(178424);
    return localab;
  }
  
  public static m b(ab paramab)
  {
    AppMethodBeat.i(167085);
    d.g.b.p.h(paramab, "local");
    paramab = new m(paramab);
    paramab.ska = k.c(aj.getContext(), (CharSequence)paramab.skh.getContent());
    AppMethodBeat.o(167085);
    return paramab;
  }
  
  public static m b(FinderCommentInfo paramFinderCommentInfo, long paramLong)
  {
    AppMethodBeat.i(178426);
    d.g.b.p.h(paramFinderCommentInfo, "level1CommentInfo");
    paramFinderCommentInfo = b(a(paramFinderCommentInfo, paramLong, 0L));
    AppMethodBeat.o(178426);
    return paramFinderCommentInfo;
  }
  
  public static m b(FinderCommentInfo paramFinderCommentInfo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(178427);
    d.g.b.p.h(paramFinderCommentInfo, "level2CommentInfo");
    paramFinderCommentInfo = b(a(paramFinderCommentInfo, paramLong1, paramLong2));
    AppMethodBeat.o(178427);
    return paramFinderCommentInfo;
  }
  
  public static FinderCommentInfo c(ab paramab)
  {
    AppMethodBeat.i(221546);
    d.g.b.p.h(paramab, "local");
    FinderCommentInfo localFinderCommentInfo = new FinderCommentInfo();
    localFinderCommentInfo.username = paramab.getUsername();
    localFinderCommentInfo.displayid = paramab.field_actionInfo.Gla.displayid;
    localFinderCommentInfo.commentId = paramab.cIG();
    localFinderCommentInfo.content = paramab.getContent();
    localFinderCommentInfo.createtime = paramab.cII();
    localFinderCommentInfo.deleteFlag = paramab.field_actionInfo.Gla.deleteFlag;
    localFinderCommentInfo.replyCommentId = paramab.field_actionInfo.Gla.replyCommentId;
    localFinderCommentInfo.nickname = paramab.VC();
    localFinderCommentInfo.headUrl = paramab.cIH();
    localFinderCommentInfo.replyNickname = paramab.cIJ();
    localFinderCommentInfo.likeCount = paramab.getLikeCount();
    localFinderCommentInfo.likeFlag = paramab.getLikeFlag();
    localFinderCommentInfo.expandCommentCount = paramab.field_actionInfo.Gla.expandCommentCount;
    localFinderCommentInfo.continueFlag = paramab.field_actionInfo.Gla.continueFlag;
    localFinderCommentInfo.displayFlag = paramab.cIK();
    localFinderCommentInfo.blacklist_flag = paramab.eQt();
    localFinderCommentInfo.reply_content = paramab.cIL();
    localFinderCommentInfo.reply_username = paramab.cIM();
    localFinderCommentInfo.client_id = paramab.cIN();
    localFinderCommentInfo.extFlag = paramab.cIO();
    AppMethodBeat.o(221546);
    return localFinderCommentInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.a
 * JD-Core Version:    0.7.0.1
 */