package com.tencent.mm.plugin.finder.utils;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.t.b;
import d.a.j;
import d.g.b.y.d;
import d.g.b.y.f;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil;", "", "Companion", "plugin-finder_release"})
public abstract interface m
{
  public static final a sLy = a.sLD;
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion;", "", "()V", "REQUEST_CODE_SHARE_FEED_TO_CHAT", "", "getREQUEST_CODE_SHARE_FEED_TO_CHAT", "()I", "REQUEST_CODE_SHARE_FEED_TO_SNS", "getREQUEST_CODE_SHARE_FEED_TO_SNS", "REQUEST_CODE_SHARE_NAMECARD_TO_CAHT", "getREQUEST_CODE_SHARE_NAMECARD_TO_CAHT", "REQUEST_CODE_SHARE_VIDEO_FILE_TO_CHAT", "getREQUEST_CODE_SHARE_VIDEO_FILE_TO_CHAT", "TAG", "", "getTAG", "()Ljava/lang/String;", "getFavEventInfo", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "thumbPath", "getFinderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "feedObject", "isShareSns", "", "getFinderTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "topic", "topicType", "iconUrl", "desc", "poiLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "shareFinderContactToConversation", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "param", "Landroid/os/Bundle;", "shareToConversation", "shareType", "shareToSnsTimeLine", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "shareTopicToConversation", "totalCount", "", "scene", "shareTopicToSnsTimeLine", "plugin-finder_release"})
  public static final class a
  {
    public static final String TAG = "Finder.FinderShareUtil";
    public static final int sLA = 1002;
    private static final int sLB = 1003;
    private static final int sLC = 1004;
    public static final int sLz = 1001;
    
    static
    {
      AppMethodBeat.i(167909);
      sLD = new a();
      sLz = 1001;
      sLA = 1002;
      sLB = 1003;
      sLC = 1004;
      TAG = "Finder.FinderShareUtil";
      AppMethodBeat.o(167909);
    }
    
    public static ark a(String paramString1, int paramInt, String paramString2, String paramString3, aoy paramaoy)
    {
      float f2 = 0.0F;
      AppMethodBeat.i(167908);
      ark localark = new ark();
      localark.dzZ = bt.nullAsNil(paramString1);
      localark.sMj = paramInt;
      localark.iconUrl = bt.nullAsNil(paramString2);
      localark.desc = bt.nullAsNil(paramString3);
      paramString2 = new arh();
      if (paramaoy != null)
      {
        paramString1 = paramaoy.Gnu;
        paramString2.Gnu = paramString1;
        if (paramaoy == null) {
          break label133;
        }
      }
      label133:
      for (float f1 = paramaoy.dAp;; f1 = 0.0F)
      {
        paramString2.dAp = f1;
        f1 = f2;
        if (paramaoy != null) {
          f1 = paramaoy.dyz;
        }
        paramString2.dyz = f1;
        localark.Gpj = paramString2;
        AppMethodBeat.o(167908);
        return localark;
        paramString1 = null;
        break;
      }
    }
    
    private static arj c(FinderItem paramFinderItem, boolean paramBoolean)
    {
      AppMethodBeat.i(204502);
      d.g.b.p.h(paramFinderItem, "feedObject");
      Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      int i = ((Number)com.tencent.mm.plugin.finder.storage.b.cGN().value()).intValue();
      ad.i(TAG, "getFinderShareObject " + i + ' ' + paramFinderItem.getFeedObject().forward_style + ' ' + paramBoolean);
      arj localarj;
      Object localObject3;
      Object localObject2;
      label251:
      bvf localbvf;
      ari localari;
      StringBuilder localStringBuilder;
      if ((paramBoolean) && (i != 1)) {
        if (i == 2)
        {
          localObject1 = "";
          localarj = new arj();
          localarj.objectId = c.rc(paramFinderItem.getId());
          localarj.objectNonceId = paramFinderItem.getObjectNonceId();
          localarj.Gpi = paramFinderItem.getMediaType();
          localObject3 = paramFinderItem.getFeedObject().contact.headUrl;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localarj.sjU = ((String)localObject2);
          localarj.nickname = ((String)localObject1);
          localarj.username = paramFinderItem.getUserName();
          localObject1 = com.tencent.mm.plugin.finder.search.h.stT;
          localarj.desc = com.tencent.mm.plugin.finder.search.h.ahX(paramFinderItem.getDescription());
          localarj.dqU = paramFinderItem.getMediaList().size();
          localObject2 = localarj.mediaList;
          paramFinderItem = (Iterable)paramFinderItem.getMediaList();
          localObject3 = (Collection)new ArrayList(j.a(paramFinderItem, 10));
          Iterator localIterator = paramFinderItem.iterator();
          if (!localIterator.hasNext()) {
            break label527;
          }
          localbvf = (bvf)localIterator.next();
          localari = new ari();
          localari.mediaType = localbvf.mediaType;
          localStringBuilder = new StringBuilder().append(localbvf.url);
          localObject1 = localbvf.url_token;
          paramFinderItem = (FinderItem)localObject1;
          if (localObject1 == null) {
            paramFinderItem = "";
          }
          localari.url = paramFinderItem;
          if (bt.isNullOrNil(localbvf.coverUrl)) {
            break label477;
          }
          localStringBuilder = new StringBuilder().append(localbvf.coverUrl);
          localObject1 = localbvf.cover_url_token;
          paramFinderItem = (FinderItem)localObject1;
          if (localObject1 == null) {
            paramFinderItem = "";
          }
        }
      }
      for (localari.thumbUrl = paramFinderItem;; localari.thumbUrl = paramFinderItem)
      {
        localari.width = localbvf.width;
        localari.height = localbvf.height;
        localari.Gph = localbvf.videoDuration;
        ((Collection)localObject3).add(localari);
        break label251;
        if (c.cQ(paramFinderItem.getFeedObject().forward_style, 1))
        {
          localObject1 = "";
          break;
        }
        localObject1 = paramFinderItem.getNickName();
        break;
        localObject1 = paramFinderItem.getNickName();
        break;
        label477:
        localStringBuilder = new StringBuilder().append(localbvf.thumbUrl);
        localObject1 = localbvf.thumb_url_token;
        paramFinderItem = (FinderItem)localObject1;
        if (localObject1 == null) {
          paramFinderItem = "";
        }
      }
      label527:
      ((LinkedList)localObject2).addAll((Collection)localObject3);
      AppMethodBeat.o(204502);
      return localarj;
    }
    
    public static int cLs()
    {
      return sLC;
    }
    
    public static String getTAG()
    {
      return TAG;
    }
    
    public final void a(final MMActivity paramMMActivity, final FinderItem paramFinderItem, final int paramInt)
    {
      AppMethodBeat.i(204498);
      d.g.b.p.h(paramMMActivity, "context");
      d.g.b.p.h(paramFinderItem, "feedObject");
      Object localObject1 = p.sMo;
      if (!p.q(paramFinderItem.getFeedObject()))
      {
        paramFinderItem = p.sMo;
        paramFinderItem = (Context)paramMMActivity;
        paramMMActivity = paramMMActivity.getString(2131767019);
        d.g.b.p.g(paramMMActivity, "context.getString(R.stri…finder_private_ban_share)");
        p.ar(paramFinderItem, paramMMActivity);
        AppMethodBeat.o(204498);
        return;
      }
      ad.i(TAG, "shareToConversation, id:" + paramFinderItem.getId() + ", pflag:" + paramFinderItem.getFeedObject().permissionFlag);
      if (paramFinderItem.getFeedObject().privateFlag == 1)
      {
        t.a((Context)paramMMActivity, paramMMActivity.getString(2131767023), (t.b)m.a.b.sLF);
        AppMethodBeat.o(204498);
        return;
      }
      e.ygI.idkeyStat(1278L, 11L, 1L, false);
      localObject1 = com.tencent.mm.plugin.finder.spam.a.suA;
      if (com.tencent.mm.plugin.finder.spam.a.aip("share"))
      {
        AppMethodBeat.o(204498);
        return;
      }
      localObject1 = new y.f();
      Object localObject2 = com.tencent.mm.ui.component.a.KiD;
      ((y.f)localObject1).MLV = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class)).cOu();
      localObject2 = new k.b();
      Object localObject3 = new com.tencent.mm.plugin.i.a.b();
      ((com.tencent.mm.plugin.i.a.b)localObject3).a(o(paramFinderItem));
      ((k.b)localObject2).a((f)localObject3);
      ((k.b)localObject2).type = 51;
      ((k.b)localObject2).title = aj.getContext().getString(2131760809);
      ((k.b)localObject2).url = aj.getContext().getString(2131760810);
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("Retr_Msg_Type", 18);
      ((Intent)localObject3).putExtra("Multi_Retr", true);
      ((Intent)localObject3).putExtra("Retr_Msg_content", k.b.a((k.b)localObject2, null, null));
      ((Intent)localObject3).putExtra("Retr_go_to_chattingUI", false);
      ((Intent)localObject3).putExtra("Retr_show_success_tips", true);
      d.a(paramMMActivity, ".ui.transmit.MsgRetransmitUI", (Intent)localObject3, sLz, (MMActivity.a)new c(this, paramFinderItem, paramMMActivity, paramInt, (y.f)localObject1));
      AppMethodBeat.o(204498);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class a
      implements MMActivity.a
    {
      a(m.a parama, g paramg, y.d paramd) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(167898);
        Object localObject;
        FinderAuthInfo localFinderAuthInfo;
        if (paramInt2 == -1)
        {
          localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          ad.i(m.a.getTAG(), "share namecard %s(%s) to %s", new Object[] { this.sgY.VC(), this.sgY.getUsername(), localObject });
          d.g.b.p.g(localObject, "toUsers");
          if (((Collection)localObject).isEmpty()) {
            break label152;
          }
          paramInt1 = 1;
          if (paramInt1 != 0)
          {
            paramIntent = com.tencent.mm.plugin.finder.report.h.soM;
            paramIntent = this.sgY.getUsername();
            localObject = bt.m((List)localObject, ",");
            d.g.b.p.g(localObject, "Util.listToString(toUsers, \",\")");
            localFinderAuthInfo = this.sgY.field_authInfo;
            if (localFinderAuthInfo == null) {
              break label157;
            }
          }
        }
        label152:
        label157:
        for (paramInt1 = localFinderAuthInfo.authIconType;; paramInt1 = 0)
        {
          com.tencent.mm.plugin.finder.report.h.j(paramIntent, (String)localObject, paramInt1, this.rVj.MLT);
          AppMethodBeat.o(167898);
          return;
          paramInt1 = 0;
          break;
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class c
      implements MMActivity.a
    {
      c(m.a parama, FinderItem paramFinderItem, MMActivity paramMMActivity, int paramInt, y.f paramf) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(204494);
        Object localObject = new ArrayList();
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          d.g.b.p.g(paramIntent, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
          ad.i(m.a.getTAG(), "share finderObject %d to %s", new Object[] { Long.valueOf(paramFinderItem.getId()), paramIntent });
          if (!((Collection)paramIntent).isEmpty())
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label273;
            }
            localObject = com.tencent.mm.ui.component.a.KiD;
            localObject = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class));
            if (localObject == null) {
              break label207;
            }
            ((com.tencent.mm.plugin.finder.event.a)localObject).cze().vL(paramFinderItem.getId());
          }
        }
        label273:
        for (;;)
        {
          label126:
          if (paramInt2 == -1) {}
          for (long l1 = 1L;; l1 = 2L)
          {
            localObject = com.tencent.mm.plugin.finder.report.h.soM;
            long l2 = paramFinderItem.getId();
            paramInt1 = paramInt;
            localObject = bt.m((List)paramIntent, ";");
            d.g.b.p.g(localObject, "Util.listToString(toUsers, \";\")");
            com.tencent.mm.plugin.finder.report.h.a(l2, paramInt1, l1, (String)localObject, (aqy)this.sLH.MLV, paramIntent.size());
            AppMethodBeat.o(204494);
            return;
            paramInt1 = 0;
            break;
            label207:
            break label126;
            paramIntent = com.tencent.mm.ui.component.a.KiD;
            paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class));
            if (paramIntent != null)
            {
              paramIntent.cze().vN(paramFinderItem.getId());
              paramIntent = (Intent)localObject;
              break label126;
            }
            paramIntent = (Intent)localObject;
            break label126;
          }
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareToSnsTimeLine$2", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
    public static final class e
      implements MMActivity.a
    {
      e(MMActivity paramMMActivity, BaseFinderFeed paramBaseFinderFeed, int paramInt, y.f paramf) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(204497);
        if (paramInt2 == -1)
        {
          com.tencent.mm.ui.base.h.ci((Context)this.sav, this.sav.getString(2131755894));
          paramIntent = com.tencent.mm.ui.component.a.KiD;
          paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.sav).get(FinderReporterUIC.class));
          if (paramIntent != null) {
            paramIntent.cze().vM(this.rPa.lP());
          }
          if (paramInt2 != -1) {
            break label168;
          }
        }
        label168:
        for (long l = 1L;; l = 2L)
        {
          paramIntent = com.tencent.mm.plugin.finder.report.h.soM;
          com.tencent.mm.plugin.finder.report.h.a(this.rPa.feedObject.getId(), this.sLG, l, "", (aqy)this.sLH.MLV);
          AppMethodBeat.o(204497);
          return;
          paramIntent = com.tencent.mm.ui.component.a.KiD;
          paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.sav).get(FinderReporterUIC.class));
          if (paramIntent == null) {
            break;
          }
          paramIntent.cze().vO(this.rPa.lP());
          break;
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    public static final class f
      implements MMActivity.a
    {
      public f(m.a parama, String paramString, int paramInt, long paramLong) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        boolean bool = false;
        AppMethodBeat.i(167901);
        Object localObject = new ArrayList();
        if (paramInt2 == -1)
        {
          localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          d.g.b.p.g(localObject, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
          ad.i(m.a.getTAG(), "share topic %s to %s", new Object[] { this.sLJ, localObject });
        }
        paramIntent = com.tencent.mm.plugin.finder.report.h.soM;
        if (paramInt2 == -1) {
          bool = true;
        }
        paramIntent = bt.nullAsNil(this.sLJ);
        d.g.b.p.g(paramIntent, "Util.nullAsNil(topic)");
        paramInt1 = this.sLK;
        long l = this.sLL;
        localObject = bt.m((List)localObject, ",");
        d.g.b.p.g(localObject, "Util.listToString(toUsers, \",\")");
        com.tencent.mm.plugin.finder.report.h.a(1, bool, paramIntent, paramInt1, l, (String)localObject);
        AppMethodBeat.o(167901);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareTopicToSnsTimeLine$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
    public static final class g
      implements MMActivity.a
    {
      public g(MMActivity paramMMActivity, String paramString, int paramInt, long paramLong) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(167902);
        if (paramInt2 == -1) {
          com.tencent.mm.ui.base.h.ci((Context)this.sav, this.sav.getString(2131755894));
        }
        paramIntent = com.tencent.mm.plugin.finder.report.h.soM;
        if (paramInt2 == -1) {}
        for (boolean bool = true;; bool = false)
        {
          paramIntent = bt.nullAsNil(this.sLJ);
          d.g.b.p.g(paramIntent, "Util.nullAsNil(topic)");
          com.tencent.mm.plugin.finder.report.h.a(2, bool, paramIntent, this.sLK, this.sLL, "");
          AppMethodBeat.o(167902);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.m
 * JD-Core Version:    0.7.0.1
 */