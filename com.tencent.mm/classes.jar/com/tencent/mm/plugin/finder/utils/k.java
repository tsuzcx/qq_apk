package com.tencent.mm.plugin.finder.utils;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.b;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import d.a.j;
import d.g.b.v.d;
import d.g.b.v.f;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil;", "", "Companion", "plugin-finder_release"})
public abstract interface k
{
  public static final a rPa = a.rPf;
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion;", "", "()V", "REQUEST_CODE_SHARE_FEED_TO_CHAT", "", "getREQUEST_CODE_SHARE_FEED_TO_CHAT", "()I", "REQUEST_CODE_SHARE_FEED_TO_SNS", "getREQUEST_CODE_SHARE_FEED_TO_SNS", "REQUEST_CODE_SHARE_NAMECARD_TO_CAHT", "getREQUEST_CODE_SHARE_NAMECARD_TO_CAHT", "REQUEST_CODE_SHARE_VIDEO_FILE_TO_CHAT", "getREQUEST_CODE_SHARE_VIDEO_FILE_TO_CHAT", "TAG", "", "getTAG", "()Ljava/lang/String;", "getFavEventInfo", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "thumbPath", "getFinderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "feedObject", "isShareSns", "", "getFinderTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "topic", "topicType", "iconUrl", "desc", "poiLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "shareFinderContactToConversation", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "param", "Landroid/os/Bundle;", "shareToConversation", "shareToSnsTimeLine", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "shareTopicToConversation", "totalCount", "", "scene", "shareTopicToSnsTimeLine", "plugin-finder_release"})
  public static final class a
  {
    public static final String TAG = "Finder.FinderShareUtil";
    public static final int rPb = 1001;
    public static final int rPc = 1002;
    private static final int rPd = 1003;
    private static final int rPe = 1004;
    
    static
    {
      AppMethodBeat.i(167909);
      rPf = new a();
      rPb = 1001;
      rPc = 1002;
      rPd = 1003;
      rPe = 1004;
      TAG = "Finder.FinderShareUtil";
      AppMethodBeat.o(167909);
    }
    
    public static any a(String paramString1, int paramInt, String paramString2, String paramString3, alt paramalt)
    {
      float f2 = 0.0F;
      AppMethodBeat.i(167908);
      any localany = new any();
      localany.dol = bs.nullAsNil(paramString1);
      localany.rPI = paramInt;
      localany.iconUrl = bs.nullAsNil(paramString2);
      localany.desc = bs.nullAsNil(paramString3);
      paramString2 = new anv();
      if (paramalt != null)
      {
        paramString1 = paramalt.EFm;
        paramString2.EFm = paramString1;
        if (paramalt == null) {
          break label133;
        }
      }
      label133:
      for (float f1 = paramalt.doB;; f1 = 0.0F)
      {
        paramString2.doB = f1;
        f1 = f2;
        if (paramalt != null) {
          f1 = paramalt.dmL;
        }
        paramString2.dmL = f1;
        localany.EGK = paramString2;
        AppMethodBeat.o(167908);
        return localany;
        paramString1 = null;
        break;
      }
    }
    
    public static int cDb()
    {
      return rPe;
    }
    
    private static anx d(FinderItem paramFinderItem, boolean paramBoolean)
    {
      AppMethodBeat.i(203622);
      d.g.b.k.h(paramFinderItem, "feedObject");
      Object localObject1 = g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      int i = ((com.tencent.mm.kernel.e)localObject1).agA().getInt(ah.a.GVD, -1);
      ac.i(TAG, "getFinderShareObject " + i + ' ' + paramFinderItem.getFeedObject().forward_style + ' ' + paramBoolean);
      anx localanx;
      Object localObject3;
      Object localObject2;
      label248:
      bqs localbqs;
      anw localanw;
      StringBuilder localStringBuilder;
      if ((paramBoolean) && (i != 1)) {
        if (i == 2)
        {
          localObject1 = "";
          localanx = new anx();
          localanx.objectId = c.pb(paramFinderItem.getId());
          localanx.objectNonceId = paramFinderItem.getObjectNonceId();
          localanx.EGJ = paramFinderItem.getMediaType();
          localObject3 = paramFinderItem.getFeedObject().contact.headUrl;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localanx.ruB = ((String)localObject2);
          localanx.nickname = ((String)localObject1);
          localObject1 = com.tencent.mm.plugin.finder.search.h.rBC;
          localanx.desc = com.tencent.mm.plugin.finder.search.h.adY(paramFinderItem.getDescription());
          localanx.dfy = paramFinderItem.getMediaList().size();
          localObject2 = localanx.mediaList;
          paramFinderItem = (Iterable)paramFinderItem.getMediaList();
          localObject3 = (Collection)new ArrayList(j.a(paramFinderItem, 10));
          Iterator localIterator = paramFinderItem.iterator();
          if (!localIterator.hasNext()) {
            break label514;
          }
          localbqs = (bqs)localIterator.next();
          localanw = new anw();
          localanw.mediaType = localbqs.mediaType;
          localStringBuilder = new StringBuilder().append(localbqs.url);
          localObject1 = localbqs.url_token;
          paramFinderItem = (FinderItem)localObject1;
          if (localObject1 == null) {
            paramFinderItem = "";
          }
          localanw.url = paramFinderItem;
          if (bs.isNullOrNil(localbqs.coverUrl)) {
            break label464;
          }
          localStringBuilder = new StringBuilder().append(localbqs.coverUrl);
          localObject1 = localbqs.cover_url_token;
          paramFinderItem = (FinderItem)localObject1;
          if (localObject1 == null) {
            paramFinderItem = "";
          }
        }
      }
      for (localanw.thumbUrl = paramFinderItem;; localanw.thumbUrl = paramFinderItem)
      {
        localanw.width = localbqs.width;
        localanw.height = localbqs.height;
        ((Collection)localObject3).add(localanw);
        break label248;
        if (c.cO(paramFinderItem.getFeedObject().forward_style, 1))
        {
          localObject1 = "";
          break;
        }
        localObject1 = paramFinderItem.getNickName();
        break;
        localObject1 = paramFinderItem.getNickName();
        break;
        label464:
        localStringBuilder = new StringBuilder().append(localbqs.thumbUrl);
        localObject1 = localbqs.thumb_url_token;
        paramFinderItem = (FinderItem)localObject1;
        if (localObject1 == null) {
          paramFinderItem = "";
        }
      }
      label514:
      ((LinkedList)localObject2).addAll((Collection)localObject3);
      AppMethodBeat.o(203622);
      return localanx;
    }
    
    public static String getTAG()
    {
      return TAG;
    }
    
    public final void a(final MMActivity paramMMActivity, final FinderItem paramFinderItem)
    {
      AppMethodBeat.i(203618);
      d.g.b.k.h(paramMMActivity, "context");
      d.g.b.k.h(paramFinderItem, "feedObject");
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1278L, 11L, 1L, false);
      Object localObject1 = com.tencent.mm.plugin.finder.spam.a.rBD;
      if (com.tencent.mm.plugin.finder.spam.a.aed("share"))
      {
        AppMethodBeat.o(203618);
        return;
      }
      localObject1 = new v.f();
      Object localObject2 = com.tencent.mm.ui.component.a.IrY;
      ((v.f)localObject1).KUQ = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(paramMMActivity).get(FinderReporterUIC.class)).cGb();
      localObject2 = new k.b();
      Object localObject3 = new b();
      ((b)localObject3).a(d(paramFinderItem, false));
      ((k.b)localObject2).a((com.tencent.mm.ah.f)localObject3);
      ((k.b)localObject2).type = 51;
      ((k.b)localObject2).title = ai.getContext().getString(2131760809);
      ((k.b)localObject2).url = ai.getContext().getString(2131760810);
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("Retr_Msg_Type", 18);
      ((Intent)localObject3).putExtra("Multi_Retr", true);
      ((Intent)localObject3).putExtra("Retr_Msg_content", k.b.a((k.b)localObject2, null, null));
      ((Intent)localObject3).putExtra("Retr_go_to_chattingUI", false);
      ((Intent)localObject3).putExtra("Retr_show_success_tips", true);
      com.tencent.mm.br.d.a(paramMMActivity, ".ui.transmit.MsgRetransmitUI", (Intent)localObject3, rPb, (MMActivity.a)new b(this, paramFinderItem, paramMMActivity, (v.f)localObject1));
      AppMethodBeat.o(203618);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class a
      implements MMActivity.a
    {
      a(k.a parama, com.tencent.mm.plugin.finder.api.f paramf, v.d paramd) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(167898);
        Object localObject;
        FinderAuthInfo localFinderAuthInfo;
        if (paramInt2 == -1)
        {
          localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          ac.i(k.a.getTAG(), "share namecard %s(%s) to %s", new Object[] { this.rrR.Tn(), this.rrR.getUsername(), localObject });
          d.g.b.k.g(localObject, "toUsers");
          if (((Collection)localObject).isEmpty()) {
            break label152;
          }
          paramInt1 = 1;
          if (paramInt1 != 0)
          {
            paramIntent = com.tencent.mm.plugin.finder.report.d.rxr;
            paramIntent = this.rrR.getUsername();
            localObject = bs.n((List)localObject, ",");
            d.g.b.k.g(localObject, "Util.listToString(toUsers, \",\")");
            localFinderAuthInfo = this.rrR.field_authInfo;
            if (localFinderAuthInfo == null) {
              break label157;
            }
          }
        }
        label152:
        label157:
        for (paramInt1 = localFinderAuthInfo.authIconType;; paramInt1 = 0)
        {
          com.tencent.mm.plugin.finder.report.d.j(paramIntent, (String)localObject, paramInt1, this.rhc.KUO);
          AppMethodBeat.o(167898);
          return;
          paramInt1 = 0;
          break;
        }
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class b
      implements MMActivity.a
    {
      b(k.a parama, FinderItem paramFinderItem, MMActivity paramMMActivity, v.f paramf) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        boolean bool = false;
        AppMethodBeat.i(167899);
        Object localObject = new ArrayList();
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          d.g.b.k.g(paramIntent, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
          ac.i(k.a.getTAG(), "share finderObject %d to %s", new Object[] { Long.valueOf(paramFinderItem.getId()), paramIntent });
          if (!((Collection)paramIntent).isEmpty())
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label255;
            }
            localObject = com.tencent.mm.ui.component.a.IrY;
            localObject = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.q(paramMMActivity).get(FinderReporterUIC.class));
            if (localObject == null) {
              break label197;
            }
            ((com.tencent.mm.plugin.finder.event.a)localObject).ctb().tO(paramFinderItem.getId());
          }
        }
        label197:
        label255:
        for (;;)
        {
          localObject = com.tencent.mm.plugin.finder.report.d.rxr;
          long l = paramFinderItem.getId();
          if (paramInt2 == -1) {
            bool = true;
          }
          paramIntent = bs.n((List)paramIntent, ";");
          d.g.b.k.g(paramIntent, "Util.listToString(toUsers, \";\")");
          com.tencent.mm.plugin.finder.report.d.a(l, 1, bool, paramIntent, (anm)this.rPh.KUQ);
          AppMethodBeat.o(167899);
          return;
          paramInt1 = 0;
          break;
          continue;
          paramIntent = com.tencent.mm.ui.component.a.IrY;
          paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.q(paramMMActivity).get(FinderReporterUIC.class));
          if (paramIntent != null)
          {
            paramIntent.ctb().tQ(paramFinderItem.getId());
            paramIntent = (Intent)localObject;
          }
          else
          {
            paramIntent = (Intent)localObject;
          }
        }
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareToSnsTimeLine$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
    public static final class c
      implements MMActivity.a
    {
      c(MMActivity paramMMActivity, BaseFinderFeed paramBaseFinderFeed, v.f paramf) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(167900);
        long l;
        if (paramInt2 == -1)
        {
          com.tencent.mm.ui.base.h.cd((Context)this.rOB, this.rOB.getString(2131755894));
          paramIntent = com.tencent.mm.ui.component.a.IrY;
          paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.rOB).get(FinderReporterUIC.class));
          if (paramIntent != null) {
            paramIntent.ctb().tP(this.rce.lx());
          }
          paramIntent = com.tencent.mm.plugin.finder.report.d.rxr;
          l = this.rce.feedObject.getId();
          if (paramInt2 != -1) {
            break label169;
          }
        }
        label169:
        for (boolean bool = true;; bool = false)
        {
          com.tencent.mm.plugin.finder.report.d.a(l, 2, bool, "", (anm)this.rPh.KUQ);
          AppMethodBeat.o(167900);
          return;
          paramIntent = com.tencent.mm.ui.component.a.IrY;
          paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.rOB).get(FinderReporterUIC.class));
          if (paramIntent == null) {
            break;
          }
          paramIntent.ctb().tR(this.rce.lx());
          break;
        }
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    public static final class d
      implements MMActivity.a
    {
      public d(k.a parama, String paramString, int paramInt, long paramLong) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        boolean bool = false;
        AppMethodBeat.i(167901);
        Object localObject = new ArrayList();
        if (paramInt2 == -1)
        {
          localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          d.g.b.k.g(localObject, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
          ac.i(k.a.getTAG(), "share topic %s to %s", new Object[] { this.rPi, localObject });
        }
        paramIntent = com.tencent.mm.plugin.finder.report.d.rxr;
        if (paramInt2 == -1) {
          bool = true;
        }
        paramIntent = bs.nullAsNil(this.rPi);
        d.g.b.k.g(paramIntent, "Util.nullAsNil(topic)");
        paramInt1 = this.rPj;
        long l = this.rPk;
        localObject = bs.n((List)localObject, ",");
        d.g.b.k.g(localObject, "Util.listToString(toUsers, \",\")");
        com.tencent.mm.plugin.finder.report.d.a(1, bool, paramIntent, paramInt1, l, (String)localObject);
        AppMethodBeat.o(167901);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareTopicToSnsTimeLine$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
    public static final class e
      implements MMActivity.a
    {
      public e(MMActivity paramMMActivity, String paramString, int paramInt, long paramLong) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(167902);
        if (paramInt2 == -1) {
          com.tencent.mm.ui.base.h.cd((Context)this.rOB, this.rOB.getString(2131755894));
        }
        paramIntent = com.tencent.mm.plugin.finder.report.d.rxr;
        if (paramInt2 == -1) {}
        for (boolean bool = true;; bool = false)
        {
          paramIntent = bs.nullAsNil(this.rPi);
          d.g.b.k.g(paramIntent, "Util.nullAsNil(topic)");
          com.tencent.mm.plugin.finder.report.d.a(2, bool, paramIntent, this.rPj, this.rPk, "");
          AppMethodBeat.o(167902);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.k
 * JD-Core Version:    0.7.0.1
 */