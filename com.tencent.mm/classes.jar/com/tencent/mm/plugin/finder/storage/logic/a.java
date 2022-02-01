package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderCommentLogic;", "", "()V", "DEFAULT_PAGE_COUNT", "", "TAG", "", "createLocalComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "objectId", "", "objectNonceId", "username", "feedUsername", "replyCommentId", "replyContent", "replyUsername", "replyNickname", "content", "nickname", "scene", "localCommentId", "replyFinder", "", "rootComment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reason", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJZLcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "transformFinderCommentInfoToLocalFinderCommentObject", "info", "feedId", "rootCommentId", "transformLevel1Comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "level1CommentInfo", "transformLevel2Comment", "level2CommentInfo", "transformLevel2CommentFromLevel1", "", "level1Comment", "transformLocalFinderCommentObject", "local", "transformLocalFinderCommentObjectToFinderCommentInfo", "plugin-finder_release"})
public final class a
{
  public static final a sLo;
  
  static
  {
    AppMethodBeat.i(167088);
    sLo = new a();
    AppMethodBeat.o(167088);
  }
  
  public static ab a(long paramLong1, String paramString1, String paramString2, String paramString3, Long paramLong, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, long paramLong2, boolean paramBoolean, FinderCommentInfo paramFinderCommentInfo, arn paramarn, int paramInt2)
  {
    AppMethodBeat.i(204445);
    d.g.b.p.h(paramString1, "objectNonceId");
    d.g.b.p.h(paramString2, "username");
    d.g.b.p.h(paramString3, "feedUsername");
    d.g.b.p.h(paramString8, "nickname");
    ab localab = new ab();
    localab.field_actionType = 1;
    localab.field_feedId = paramLong1;
    localab.field_objectNonceId = paramString1;
    localab.field_localCommentId = paramLong2;
    localab.cLl().displayid = 0L;
    Object localObject;
    int i;
    if (paramFinderCommentInfo != null)
    {
      paramLong1 = paramFinderCommentInfo.commentId;
      localab.xi(paramLong1);
      if (paramInt1 != 1) {
        break label558;
      }
      localab.setUsername(paramString2);
      paramString1 = c.rPy;
      paramString1 = c.a.ahT(v.aAK());
      if (paramString1 != null)
      {
        localObject = paramString1.czm();
        paramString1 = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localab.ajw(paramString1);
      if (paramString7 != null)
      {
        d.g.b.p.h(paramString7, "value");
        localab.cLl().content = paramString7;
      }
      d.g.b.p.h(paramString8, "value");
      localab.cLl().nickname = paramString8;
      localab.xj(ch.aDa() / 1000L);
      if (!d.g.b.p.i(paramString2, paramString3)) {
        break label683;
      }
      i = 2;
      label204:
      localab.FM(i);
      localab.field_state = 1;
      if (paramLong != null)
      {
        ((Number)paramLong).longValue();
        paramLong1 = paramLong.longValue();
        localab.cLl().replyCommentId = paramLong1;
        paramString1 = paramString4;
        if (paramString4 == null) {
          paramString1 = "";
        }
        d.g.b.p.h(paramString1, "value");
        localab.cLl().reply_content = paramString1;
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
        d.g.b.p.h(paramString1, "value");
        localab.cLl().reply_username = paramString1;
        paramString1 = paramString6;
        if (paramString6 == null) {
          paramString1 = "";
        }
        d.g.b.p.h(paramString1, "value");
        localab.cLl().replyNickname = paramString1;
        if (bu.lX(paramString5, paramString3)) {
          localab.FM(localab.cLl().displayFlag | 0x4);
        }
        if (paramBoolean) {
          localab.FM(localab.cLl().displayFlag | 0x10);
        }
        if (paramFinderCommentInfo != null)
        {
          paramString2 = localab.field_actionInfo;
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
              paramString2.GDN = paramString1;
              paramString1 = String.valueOf(paramLong2);
              d.g.b.p.h(paramString1, "value");
              localab.cLl().client_id = paramString1;
              localab.field_scene = paramInt1;
              localab.field_postTime = System.currentTimeMillis();
              localab.field_tryCount = 0L;
              localab.field_actionInfo.rQw = paramarn;
              localab.field_actionInfo.GDO = paramInt2;
              localab.cLl().extFlag = 1;
              AppMethodBeat.o(204445);
              return localab;
              paramLong1 = 0L;
              break;
              paramString1 = v.aAC();
              d.g.b.p.g(paramString1, "ConfigStorageLogic.getUsernameFromUserInfo()");
              localab.setUsername(paramString1);
              paramString1 = com.tencent.mm.aj.p.aEN().DL(localab.getUsername());
              if (paramString1 != null)
              {
                localObject = (CharSequence)paramString1.aEG();
                if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
                  break label662;
                }
                i = 1;
                label618:
                if (i == 0) {
                  break label668;
                }
                paramString1 = paramString1.aEH();
                d.g.b.p.g(paramString1, "imgFlag.smallUrl");
              }
              for (;;)
              {
                localab.ajw(paramString1);
                if (!bu.isNullOrNil(localab.cLm())) {
                  break;
                }
                localab.ajw("");
                break;
                i = 0;
                break label618;
                paramString1 = paramString1.aEG();
                d.g.b.p.g(paramString1, "imgFlag.bigUrl");
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
            ae.l("safeParser", "", new Object[] { paramString1 });
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
    d.g.b.p.h(paramFinderCommentInfo, "value");
    localab.field_actionInfo.GDK = paramFinderCommentInfo;
    localab.xi(paramLong2);
    AppMethodBeat.o(178424);
    return localab;
  }
  
  public static n b(ab paramab)
  {
    AppMethodBeat.i(167085);
    d.g.b.p.h(paramab, "local");
    paramab = new n(paramab);
    paramab.ssX = k.c(ak.getContext(), (CharSequence)paramab.ste.getContent());
    AppMethodBeat.o(167085);
    return paramab;
  }
  
  public static n b(FinderCommentInfo paramFinderCommentInfo, long paramLong)
  {
    AppMethodBeat.i(178426);
    d.g.b.p.h(paramFinderCommentInfo, "level1CommentInfo");
    paramFinderCommentInfo = b(a(paramFinderCommentInfo, paramLong, 0L));
    AppMethodBeat.o(178426);
    return paramFinderCommentInfo;
  }
  
  public static n b(FinderCommentInfo paramFinderCommentInfo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(178427);
    d.g.b.p.h(paramFinderCommentInfo, "level2CommentInfo");
    paramFinderCommentInfo = b(a(paramFinderCommentInfo, paramLong1, paramLong2));
    AppMethodBeat.o(178427);
    return paramFinderCommentInfo;
  }
  
  public static FinderCommentInfo c(ab paramab)
  {
    AppMethodBeat.i(204446);
    d.g.b.p.h(paramab, "local");
    FinderCommentInfo localFinderCommentInfo = new FinderCommentInfo();
    localFinderCommentInfo.username = paramab.getUsername();
    localFinderCommentInfo.displayid = paramab.cLl().displayid;
    localFinderCommentInfo.commentId = paramab.cLl().commentId;
    localFinderCommentInfo.content = paramab.getContent();
    localFinderCommentInfo.createtime = paramab.cLl().createtime;
    localFinderCommentInfo.deleteFlag = paramab.cLl().deleteFlag;
    localFinderCommentInfo.replyCommentId = paramab.cLl().replyCommentId;
    localFinderCommentInfo.nickname = paramab.VK();
    localFinderCommentInfo.headUrl = paramab.cLm();
    localFinderCommentInfo.replyNickname = paramab.cLn();
    localFinderCommentInfo.likeCount = paramab.cLl().likeCount;
    localFinderCommentInfo.likeFlag = paramab.cLl().likeFlag;
    localFinderCommentInfo.expandCommentCount = paramab.cLl().expandCommentCount;
    localFinderCommentInfo.continueFlag = paramab.cLl().continueFlag;
    localFinderCommentInfo.displayFlag = paramab.cLl().displayFlag;
    localFinderCommentInfo.blacklist_flag = paramab.cLl().blacklist_flag;
    localFinderCommentInfo.reply_content = paramab.cLo();
    localFinderCommentInfo.reply_username = paramab.cLp();
    localFinderCommentInfo.client_id = paramab.cLq();
    localFinderCommentInfo.extFlag = paramab.cLl().extFlag;
    AppMethodBeat.o(204446);
    return localFinderCommentInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.a
 * JD-Core Version:    0.7.0.1
 */