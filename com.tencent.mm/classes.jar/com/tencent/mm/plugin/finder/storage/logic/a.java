package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderCommentLogic;", "", "()V", "DEFAULT_PAGE_COUNT", "", "TAG", "", "createLocalComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "objectId", "", "objectNonceId", "username", "feedUsername", "replyCommentId", "replyContent", "replyUsername", "replyNickname", "content", "nickname", "scene", "localCommentId", "replyFinder", "", "rootComment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reason", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJZLcom/tencent/mm/protocal/protobuf/FinderCommentInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "transformFinderCommentInfoToLocalFinderCommentObject", "info", "feedId", "rootCommentId", "transformLevel1Comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "level1CommentInfo", "transformLevel2Comment", "level2CommentInfo", "transformLevel2CommentFromLevel1", "", "level1Comment", "transformLocalFinderCommentObject", "local", "transformLocalFinderCommentObjectToFinderCommentInfo", "plugin-finder_release"})
public final class a
{
  public static final a vGJ;
  
  static
  {
    AppMethodBeat.i(167088);
    vGJ = new a();
    AppMethodBeat.o(167088);
  }
  
  public static an a(long paramLong1, String paramString1, String paramString2, String paramString3, Long paramLong, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, long paramLong2, boolean paramBoolean, FinderCommentInfo paramFinderCommentInfo, bbn parambbn, int paramInt2)
  {
    AppMethodBeat.i(252054);
    kotlin.g.b.p.h(paramString1, "objectNonceId");
    kotlin.g.b.p.h(paramString2, "username");
    kotlin.g.b.p.h(paramString3, "feedUsername");
    kotlin.g.b.p.h(paramString8, "nickname");
    an localan = new an();
    localan.field_actionType = 1;
    localan.field_feedId = paramLong1;
    localan.field_objectNonceId = paramString1;
    localan.field_localCommentId = paramLong2;
    localan.dyb().displayid = 0L;
    Object localObject;
    int i;
    if (paramFinderCommentInfo != null)
    {
      paramLong1 = paramFinderCommentInfo.commentId;
      localan.FB(paramLong1);
      if (paramInt1 != 1) {
        break label558;
      }
      localan.setUsername(paramString2);
      paramString1 = c.tsp;
      paramString1 = c.a.asG(z.aUg());
      if (paramString1 != null)
      {
        localObject = paramString1.cXH();
        paramString1 = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString1 = "";
      }
      localan.avC(paramString1);
      if (paramString7 != null)
      {
        kotlin.g.b.p.h(paramString7, "value");
        localan.dyb().content = paramString7;
      }
      kotlin.g.b.p.h(paramString8, "value");
      localan.dyb().nickname = paramString8;
      localan.FC(cl.aWy() / 1000L);
      if (!kotlin.g.b.p.j(paramString2, paramString3)) {
        break label683;
      }
      i = 2;
      label204:
      localan.Lb(i);
      localan.field_state = 1;
      if (paramLong != null)
      {
        ((Number)paramLong).longValue();
        paramLong1 = paramLong.longValue();
        localan.dyb().replyCommentId = paramLong1;
        paramString1 = paramString4;
        if (paramString4 == null) {
          paramString1 = "";
        }
        kotlin.g.b.p.h(paramString1, "value");
        localan.dyb().reply_content = paramString1;
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
        kotlin.g.b.p.h(paramString1, "value");
        localan.dyb().reply_username = paramString1;
        paramString1 = paramString6;
        if (paramString6 == null) {
          paramString1 = "";
        }
        kotlin.g.b.p.h(paramString1, "value");
        localan.dyb().replyNickname = paramString1;
        if (Util.isEqual(paramString5, paramString3)) {
          localan.Lb(localan.dyb().displayFlag | 0x4);
        }
        if (paramBoolean) {
          localan.Lb(localan.dyb().displayFlag | 0x10);
        }
        if (paramFinderCommentInfo != null)
        {
          paramString2 = localan.field_actionInfo;
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
              paramString2.LAn = paramString1;
              paramString1 = String.valueOf(paramLong2);
              kotlin.g.b.p.h(paramString1, "value");
              localan.dyb().client_id = paramString1;
              localan.field_scene = paramInt1;
              localan.field_postTime = System.currentTimeMillis();
              localan.field_tryCount = 0L;
              localan.field_actionInfo.ttO = parambbn;
              localan.field_actionInfo.LAo = paramInt2;
              localan.dyb().extFlag = 1;
              AppMethodBeat.o(252054);
              return localan;
              paramLong1 = 0L;
              break;
              paramString1 = z.aTY();
              kotlin.g.b.p.g(paramString1, "ConfigStorageLogic.getUsernameFromUserInfo()");
              localan.setUsername(paramString1);
              paramString1 = com.tencent.mm.aj.p.aYB().Mx(localan.getUsername());
              if (paramString1 != null)
              {
                localObject = (CharSequence)paramString1.aYt();
                if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
                  break label662;
                }
                i = 1;
                label618:
                if (i == 0) {
                  break label668;
                }
                paramString1 = paramString1.aYu();
                kotlin.g.b.p.g(paramString1, "imgFlag.smallUrl");
              }
              for (;;)
              {
                localan.avC(paramString1);
                if (!Util.isNullOrNil(localan.dyc())) {
                  break;
                }
                localan.avC("");
                break;
                i = 0;
                break label618;
                paramString1 = paramString1.aYt();
                kotlin.g.b.p.g(paramString1, "imgFlag.bigUrl");
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
  
  private static an a(FinderCommentInfo paramFinderCommentInfo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(178424);
    kotlin.g.b.p.h(paramFinderCommentInfo, "info");
    an localan = new an();
    localan.field_feedId = paramLong1;
    localan.field_state = 2;
    kotlin.g.b.p.h(paramFinderCommentInfo, "value");
    localan.field_actionInfo.LAk = paramFinderCommentInfo;
    localan.FB(paramLong2);
    AppMethodBeat.o(178424);
    return localan;
  }
  
  public static s b(an paraman)
  {
    AppMethodBeat.i(167085);
    kotlin.g.b.p.h(paraman, "local");
    paraman = new s(paraman);
    paraman.uNY = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paraman.uOf.getContent());
    AppMethodBeat.o(167085);
    return paraman;
  }
  
  public static s b(FinderCommentInfo paramFinderCommentInfo, long paramLong)
  {
    AppMethodBeat.i(178426);
    kotlin.g.b.p.h(paramFinderCommentInfo, "level1CommentInfo");
    paramFinderCommentInfo = b(a(paramFinderCommentInfo, paramLong, 0L));
    AppMethodBeat.o(178426);
    return paramFinderCommentInfo;
  }
  
  public static s b(FinderCommentInfo paramFinderCommentInfo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(178427);
    kotlin.g.b.p.h(paramFinderCommentInfo, "level2CommentInfo");
    paramFinderCommentInfo = b(a(paramFinderCommentInfo, paramLong1, paramLong2));
    AppMethodBeat.o(178427);
    return paramFinderCommentInfo;
  }
  
  public static FinderCommentInfo c(an paraman)
  {
    AppMethodBeat.i(252055);
    kotlin.g.b.p.h(paraman, "local");
    FinderCommentInfo localFinderCommentInfo = new FinderCommentInfo();
    localFinderCommentInfo.username = paraman.getUsername();
    localFinderCommentInfo.displayid = paraman.dyb().displayid;
    localFinderCommentInfo.commentId = paraman.dyb().commentId;
    localFinderCommentInfo.content = paraman.getContent();
    localFinderCommentInfo.createtime = paraman.dyb().createtime;
    localFinderCommentInfo.deleteFlag = paraman.dyb().deleteFlag;
    localFinderCommentInfo.replyCommentId = paraman.dyb().replyCommentId;
    localFinderCommentInfo.nickname = paraman.getNickname();
    localFinderCommentInfo.headUrl = paraman.dyc();
    localFinderCommentInfo.replyNickname = paraman.dyd();
    localFinderCommentInfo.likeCount = paraman.dyb().likeCount;
    localFinderCommentInfo.likeFlag = paraman.dyb().likeFlag;
    localFinderCommentInfo.expandCommentCount = paraman.dyb().expandCommentCount;
    localFinderCommentInfo.continueFlag = paraman.dyb().continueFlag;
    localFinderCommentInfo.displayFlag = paraman.dyb().displayFlag;
    localFinderCommentInfo.blacklist_flag = paraman.dyb().blacklist_flag;
    localFinderCommentInfo.reply_content = paraman.dye();
    localFinderCommentInfo.reply_username = paraman.dyf();
    localFinderCommentInfo.client_id = paraman.dyg();
    localFinderCommentInfo.extFlag = paraman.dyb().extFlag;
    AppMethodBeat.o(252055);
    return localFinderCommentInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.a
 * JD-Core Version:    0.7.0.1
 */