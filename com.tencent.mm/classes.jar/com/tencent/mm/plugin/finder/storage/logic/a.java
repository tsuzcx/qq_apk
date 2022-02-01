package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.api.b;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderCommentLogic;", "", "()V", "DEFAULT_PAGE_COUNT", "", "TAG", "", "createLocalComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "objectId", "", "objectNonceId", "username", "feedUsername", "replyCommentId", "replyContent", "replyUsername", "replyNickname", "content", "nickname", "scene", "localCommentId", "replyFinder", "", "rootComment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJZLcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "transformFinderCommentInfoToLocalFinderCommentObject", "info", "feedId", "rootCommentId", "transformLevel1Comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "level1CommentInfo", "transformLevel2Comment", "level2CommentInfo", "transformLevel2CommentFromLevel1", "", "level1Comment", "transformLocalFinderCommentObject", "local", "plugin-finder_release"})
public final class a
{
  public static final a qKE;
  
  static
  {
    AppMethodBeat.i(167088);
    qKE = new a();
    AppMethodBeat.o(167088);
  }
  
  public static com.tencent.mm.plugin.finder.storage.k a(long paramLong1, String paramString1, String paramString2, String paramString3, Long paramLong, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, long paramLong2, boolean paramBoolean, FinderCommentInfo paramFinderCommentInfo, dzp paramdzp)
  {
    AppMethodBeat.i(199086);
    d.g.b.k.h(paramString1, "objectNonceId");
    d.g.b.k.h(paramString2, "username");
    d.g.b.k.h(paramString3, "feedUsername");
    d.g.b.k.h(paramString8, "nickname");
    com.tencent.mm.plugin.finder.storage.k localk = new com.tencent.mm.plugin.finder.storage.k();
    localk.field_actionType = 1;
    localk.field_feedId = paramLong1;
    localk.field_objectNonceId = paramString1;
    localk.field_localCommentId = paramLong2;
    localk.field_actionInfo.Dkk.displayid = 0L;
    Object localObject;
    int i;
    if (paramFinderCommentInfo != null)
    {
      paramLong1 = paramFinderCommentInfo.commentId;
      localk.qA(paramLong1);
      if (paramInt != 1) {
        break label577;
      }
      localk.setUsername(paramString2);
      paramString1 = b.qnX;
      paramString1 = u.aqO();
      d.g.b.k.g(paramString1, "ConfigStorageLogic.getMyFinderUsername()");
      paramString1 = b.a.YL(paramString1);
      if (paramString1 != null)
      {
        localObject = paramString1.cks();
        paramString1 = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localk.Zy(paramString1);
      if (paramString7 != null)
      {
        d.g.b.k.h(paramString7, "value");
        localk.field_actionInfo.Dkk.content = paramString7;
      }
      d.g.b.k.h(paramString8, "value");
      localk.field_actionInfo.Dkk.nickname = paramString8;
      localk.qB(ce.asQ() / 1000L);
      if (!d.g.b.k.g(paramString2, paramString3)) {
        break label702;
      }
      i = 2;
      label221:
      localk.CS(i);
      localk.field_state = 1;
      if (paramLong != null)
      {
        ((Number)paramLong).longValue();
        paramLong1 = paramLong.longValue();
        localk.field_actionInfo.Dkk.replyCommentId = paramLong1;
        paramString1 = paramString4;
        if (paramString4 == null) {
          paramString1 = "";
        }
        d.g.b.k.h(paramString1, "value");
        localk.field_actionInfo.Dkk.reply_content = paramString1;
        if (paramString5 != null) {
          break label754;
        }
      }
    }
    label577:
    label754:
    for (paramString1 = "";; paramString1 = paramString5) {
      for (;;)
      {
        d.g.b.k.h(paramString1, "value");
        localk.field_actionInfo.Dkk.reply_username = paramString1;
        paramString1 = paramString6;
        if (paramString6 == null) {
          paramString1 = "";
        }
        d.g.b.k.h(paramString1, "value");
        localk.field_actionInfo.Dkk.replyNickname = paramString1;
        if (bt.kU(paramString5, paramString3)) {
          localk.CS(localk.cqv() | 0x4);
        }
        if (paramBoolean) {
          localk.CS(localk.cqv() | 0x10);
        }
        if (paramFinderCommentInfo != null)
        {
          paramString2 = localk.field_actionInfo;
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
              paramString2.Dkn = paramString1;
              paramString1 = String.valueOf(paramLong2);
              d.g.b.k.h(paramString1, "value");
              localk.field_actionInfo.Dkk.client_id = paramString1;
              localk.field_scene = paramInt;
              localk.field_postTime = System.currentTimeMillis();
              localk.field_tryCount = 0L;
              localk.field_actionInfo.contextObj = paramdzp;
              localk.field_actionInfo.Dkk.extFlag = 1;
              AppMethodBeat.o(199086);
              return localk;
              paramLong1 = 0L;
              break;
              paramString1 = u.aqG();
              d.g.b.k.g(paramString1, "ConfigStorageLogic.getUsernameFromUserInfo()");
              localk.setUsername(paramString1);
              paramString1 = p.auF().we(localk.getUsername());
              if (paramString1 != null)
              {
                localObject = (CharSequence)paramString1.aux();
                if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
                  break label681;
                }
                i = 1;
                label637:
                if (i == 0) {
                  break label687;
                }
                paramString1 = paramString1.auy();
                d.g.b.k.g(paramString1, "imgFlag.smallUrl");
              }
              for (;;)
              {
                localk.Zy(paramString1);
                if (!bt.isNullOrNil(localk.cqs())) {
                  break;
                }
                localk.Zy("");
                break;
                i = 0;
                break label637;
                paramString1 = paramString1.aux();
                d.g.b.k.g(paramString1, "imgFlag.bigUrl");
              }
              if (paramInt == 1)
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
  
  private static com.tencent.mm.plugin.finder.storage.k a(FinderCommentInfo paramFinderCommentInfo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(178424);
    d.g.b.k.h(paramFinderCommentInfo, "info");
    com.tencent.mm.plugin.finder.storage.k localk = new com.tencent.mm.plugin.finder.storage.k();
    localk.field_feedId = paramLong1;
    localk.field_state = 2;
    localk.field_actionInfo.Dkk = paramFinderCommentInfo;
    localk.qA(paramLong2);
    AppMethodBeat.o(178424);
    return localk;
  }
  
  public static h b(com.tencent.mm.plugin.finder.storage.k paramk)
  {
    AppMethodBeat.i(167085);
    d.g.b.k.h(paramk, "local");
    paramk = new h(paramk);
    paramk.qDv = com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), (CharSequence)paramk.qDA.getContent());
    AppMethodBeat.o(167085);
    return paramk;
  }
  
  public static h b(FinderCommentInfo paramFinderCommentInfo, long paramLong)
  {
    AppMethodBeat.i(178426);
    d.g.b.k.h(paramFinderCommentInfo, "level1CommentInfo");
    paramFinderCommentInfo = b(a(paramFinderCommentInfo, paramLong, 0L));
    AppMethodBeat.o(178426);
    return paramFinderCommentInfo;
  }
  
  public static h b(FinderCommentInfo paramFinderCommentInfo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(178427);
    d.g.b.k.h(paramFinderCommentInfo, "level2CommentInfo");
    paramFinderCommentInfo = b(a(paramFinderCommentInfo, paramLong1, paramLong2));
    AppMethodBeat.o(178427);
    return paramFinderCommentInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.a
 * JD-Core Version:    0.7.0.1
 */