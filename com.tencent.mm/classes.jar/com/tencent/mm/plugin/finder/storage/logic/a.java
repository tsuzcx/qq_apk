package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.api.b;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderCommentLogic;", "", "()V", "DEFAULT_PAGE_COUNT", "", "TAG", "", "createLocalComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "objectId", "", "objectNonceId", "username", "feedUsername", "replyCommentId", "replyContent", "replyUsername", "replyNickname", "content", "nickname", "scene", "localCommentId", "replyFinder", "", "rootComment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJZLcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "transformFinderCommentInfoToLocalFinderCommentObject", "info", "feedId", "rootCommentId", "transformLevel1Comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "level1CommentInfo", "transformLevel2Comment", "level2CommentInfo", "transformLevel2CommentFromLevel1", "", "level1Comment", "transformLocalFinderCommentObject", "local", "plugin-finder_release"})
public final class a
{
  public static final a rFj;
  
  static
  {
    AppMethodBeat.i(167088);
    rFj = new a();
    AppMethodBeat.o(167088);
  }
  
  public static t a(long paramLong1, String paramString1, String paramString2, String paramString3, Long paramLong, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, long paramLong2, boolean paramBoolean, FinderCommentInfo paramFinderCommentInfo, anm paramanm)
  {
    AppMethodBeat.i(203054);
    d.g.b.k.h(paramString1, "objectNonceId");
    d.g.b.k.h(paramString2, "username");
    d.g.b.k.h(paramString3, "feedUsername");
    d.g.b.k.h(paramString8, "nickname");
    t localt = new t();
    localt.field_actionType = 1;
    localt.field_feedId = paramLong1;
    localt.field_objectNonceId = paramString1;
    localt.field_localCommentId = paramLong2;
    localt.field_actionInfo.EDq.displayid = 0L;
    Object localObject;
    int i;
    if (paramFinderCommentInfo != null)
    {
      paramLong1 = paramFinderCommentInfo.commentId;
      localt.uQ(paramLong1);
      if (paramInt != 1) {
        break label577;
      }
      localt.setUsername(paramString2);
      paramString1 = b.qWt;
      paramString1 = u.axE();
      d.g.b.k.g(paramString1, "ConfigStorageLogic.getMyFinderUsername()");
      paramString1 = b.a.adh(paramString1);
      if (paramString1 != null)
      {
        localObject = paramString1.crZ();
        paramString1 = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localt.aef(paramString1);
      if (paramString7 != null)
      {
        d.g.b.k.h(paramString7, "value");
        localt.field_actionInfo.EDq.content = paramString7;
      }
      d.g.b.k.h(paramString8, "value");
      localt.field_actionInfo.EDq.nickname = paramString8;
      localt.uR(ce.azH() / 1000L);
      if (!d.g.b.k.g(paramString2, paramString3)) {
        break label702;
      }
      i = 2;
      label221:
      localt.Ei(i);
      localt.field_state = 1;
      if (paramLong != null)
      {
        ((Number)paramLong).longValue();
        paramLong1 = paramLong.longValue();
        localt.field_actionInfo.EDq.replyCommentId = paramLong1;
        paramString1 = paramString4;
        if (paramString4 == null) {
          paramString1 = "";
        }
        d.g.b.k.h(paramString1, "value");
        localt.field_actionInfo.EDq.reply_content = paramString1;
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
        localt.field_actionInfo.EDq.reply_username = paramString1;
        paramString1 = paramString6;
        if (paramString6 == null) {
          paramString1 = "";
        }
        d.g.b.k.h(paramString1, "value");
        localt.field_actionInfo.EDq.replyNickname = paramString1;
        if (bs.lr(paramString5, paramString3)) {
          localt.Ei(localt.cAO() | 0x4);
        }
        if (paramBoolean) {
          localt.Ei(localt.cAO() | 0x10);
        }
        if (paramFinderCommentInfo != null)
        {
          paramString2 = localt.field_actionInfo;
          paramString1 = (com.tencent.mm.bw.a)new FinderCommentInfo();
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
              paramString2.EDt = paramString1;
              paramString1 = String.valueOf(paramLong2);
              d.g.b.k.h(paramString1, "value");
              localt.field_actionInfo.EDq.client_id = paramString1;
              localt.field_scene = paramInt;
              localt.field_postTime = System.currentTimeMillis();
              localt.field_tryCount = 0L;
              localt.field_actionInfo.contextObj = paramanm;
              localt.field_actionInfo.EDq.extFlag = 1;
              AppMethodBeat.o(203054);
              return localt;
              paramLong1 = 0L;
              break;
              paramString1 = u.axw();
              d.g.b.k.g(paramString1, "ConfigStorageLogic.getUsernameFromUserInfo()");
              localt.setUsername(paramString1);
              paramString1 = p.aBw().Ak(localt.getUsername());
              if (paramString1 != null)
              {
                localObject = (CharSequence)paramString1.aBo();
                if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
                  break label681;
                }
                i = 1;
                label637:
                if (i == 0) {
                  break label687;
                }
                paramString1 = paramString1.aBp();
                d.g.b.k.g(paramString1, "imgFlag.smallUrl");
              }
              for (;;)
              {
                localt.aef(paramString1);
                if (!bs.isNullOrNil(localt.cAL())) {
                  break;
                }
                localt.aef("");
                break;
                i = 0;
                break label637;
                paramString1 = paramString1.aBo();
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
            ac.l("safeParser", "", new Object[] { paramString1 });
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
  
  private static t a(FinderCommentInfo paramFinderCommentInfo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(178424);
    d.g.b.k.h(paramFinderCommentInfo, "info");
    t localt = new t();
    localt.field_feedId = paramLong1;
    localt.field_state = 2;
    localt.field_actionInfo.EDq = paramFinderCommentInfo;
    localt.uQ(paramLong2);
    AppMethodBeat.o(178424);
    return localt;
  }
  
  public static com.tencent.mm.plugin.finder.model.l b(t paramt)
  {
    AppMethodBeat.i(167085);
    d.g.b.k.h(paramt, "local");
    paramt = new com.tencent.mm.plugin.finder.model.l(paramt);
    paramt.ruH = com.tencent.mm.pluginsdk.ui.span.k.c(ai.getContext(), (CharSequence)paramt.ruO.getContent());
    AppMethodBeat.o(167085);
    return paramt;
  }
  
  public static com.tencent.mm.plugin.finder.model.l b(FinderCommentInfo paramFinderCommentInfo, long paramLong)
  {
    AppMethodBeat.i(178426);
    d.g.b.k.h(paramFinderCommentInfo, "level1CommentInfo");
    paramFinderCommentInfo = b(a(paramFinderCommentInfo, paramLong, 0L));
    AppMethodBeat.o(178426);
    return paramFinderCommentInfo;
  }
  
  public static com.tencent.mm.plugin.finder.model.l b(FinderCommentInfo paramFinderCommentInfo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(178427);
    d.g.b.k.h(paramFinderCommentInfo, "level2CommentInfo");
    paramFinderCommentInfo = b(a(paramFinderCommentInfo, paramLong1, paramLong2));
    AppMethodBeat.o(178427);
    return paramFinderCommentInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.a
 * JD-Core Version:    0.7.0.1
 */