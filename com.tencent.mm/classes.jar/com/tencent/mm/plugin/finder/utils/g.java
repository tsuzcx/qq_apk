package com.tencent.mm.plugin.finder.utils;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.finder.event.c.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.search.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.alb;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import d.a.j;
import d.g.b.k;
import d.g.b.v.c;
import d.g.b.v.e;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil;", "", "Companion", "plugin-finder_release"})
public abstract interface g
{
  public static final a qSw = a.qSA;
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion;", "", "()V", "REQUEST_CODE_SHARE_FEED_TO_CHAT", "", "getREQUEST_CODE_SHARE_FEED_TO_CHAT", "()I", "REQUEST_CODE_SHARE_FEED_TO_SNS", "getREQUEST_CODE_SHARE_FEED_TO_SNS", "REQUEST_CODE_SHARE_NAMECARD_TO_CAHT", "getREQUEST_CODE_SHARE_NAMECARD_TO_CAHT", "REQUEST_CODE_SHARE_VIDEO_FILE_TO_CHAT", "getREQUEST_CODE_SHARE_VIDEO_FILE_TO_CHAT", "TAG", "", "getTAG", "()Ljava/lang/String;", "getFavEventInfo", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "thumbPath", "getFinderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "feedObject", "isShareSns", "", "getFinderTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "topic", "topicType", "iconUrl", "desc", "poiLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "shareFinderContactToConversation", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "param", "Landroid/os/Bundle;", "shareToConversation", "shareToSnsTimeLine", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "shareTopicToConversation", "totalCount", "", "scene", "shareTopicToSnsTimeLine", "plugin-finder_release"})
  public static final class a
  {
    private static final int LaM = 1004;
    public static final String TAG = "Finder.FinderShareUtil";
    public static final int qSx = 1001;
    public static final int qSy = 1002;
    private static final int qSz = 1003;
    
    static
    {
      AppMethodBeat.i(167909);
      qSA = new a();
      qSx = 1001;
      qSy = 1002;
      qSz = 1003;
      LaM = 1004;
      TAG = "Finder.FinderShareUtil";
      AppMethodBeat.o(167909);
    }
    
    public static ale a(String paramString1, int paramInt, String paramString2, String paramString3, ajq paramajq)
    {
      float f2 = 0.0F;
      AppMethodBeat.i(167908);
      ale localale = new ale();
      localale.dqA = bt.nullAsNil(paramString1);
      localale.qSS = paramInt;
      localale.iconUrl = bt.nullAsNil(paramString2);
      localale.desc = bt.nullAsNil(paramString3);
      paramString2 = new alb();
      if (paramajq != null)
      {
        paramString1 = paramajq.DlE;
        paramString2.DlE = paramString1;
        if (paramajq == null) {
          break label133;
        }
      }
      label133:
      for (float f1 = paramajq.dqQ;; f1 = 0.0F)
      {
        paramString2.dqQ = f1;
        f1 = f2;
        if (paramajq != null) {
          f1 = paramajq.dpb;
        }
        paramString2.dpb = f1;
        localale.Dmy = paramString2;
        AppMethodBeat.o(167908);
        return localale;
        paramString1 = null;
        break;
      }
    }
    
    private static ald c(FinderItem paramFinderItem, boolean paramBoolean)
    {
      AppMethodBeat.i(190891);
      k.h(paramFinderItem, "feedObject");
      Object localObject1 = com.tencent.mm.kernel.g.afB();
      k.g(localObject1, "MMKernel.storage()");
      int i = ((com.tencent.mm.kernel.e)localObject1).afk().getInt(ae.a.Fxn, -1);
      ad.i(TAG, "getFinderShareObject " + i + ' ' + paramFinderItem.getFeedObject().forward_style + ' ' + paramBoolean);
      ald localald;
      Object localObject3;
      Object localObject2;
      label248:
      bmd localbmd;
      alc localalc;
      StringBuilder localStringBuilder;
      if ((paramBoolean) && (i != 1)) {
        if (i == 2)
        {
          localObject1 = "";
          localald = new ald();
          localald.objectId = com.tencent.mm.ad.c.ly(paramFinderItem.getId());
          localald.objectNonceId = paramFinderItem.getObjectNonceId();
          localald.Dmx = paramFinderItem.getMediaType();
          localObject3 = paramFinderItem.getFeedObject().contact.headUrl;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localald.qDs = ((String)localObject2);
          localald.nickname = ((String)localObject1);
          localObject1 = i.qIB;
          localald.desc = i.Zq(paramFinderItem.getDescription());
          localald.did = paramFinderItem.getMediaList().size();
          localObject2 = localald.mediaList;
          paramFinderItem = (Iterable)paramFinderItem.getMediaList();
          localObject3 = (Collection)new ArrayList(j.a(paramFinderItem, 10));
          Iterator localIterator = paramFinderItem.iterator();
          if (!localIterator.hasNext()) {
            break label514;
          }
          localbmd = (bmd)localIterator.next();
          localalc = new alc();
          localalc.mediaType = localbmd.mediaType;
          localStringBuilder = new StringBuilder().append(localbmd.url);
          localObject1 = localbmd.url_token;
          paramFinderItem = (FinderItem)localObject1;
          if (localObject1 == null) {
            paramFinderItem = "";
          }
          localalc.url = paramFinderItem;
          if (bt.isNullOrNil(localbmd.coverUrl)) {
            break label464;
          }
          localStringBuilder = new StringBuilder().append(localbmd.coverUrl);
          localObject1 = localbmd.cover_url_token;
          paramFinderItem = (FinderItem)localObject1;
          if (localObject1 == null) {
            paramFinderItem = "";
          }
        }
      }
      for (localalc.thumbUrl = paramFinderItem;; localalc.thumbUrl = paramFinderItem)
      {
        localalc.width = localbmd.width;
        localalc.height = localbmd.height;
        ((Collection)localObject3).add(localalc);
        break label248;
        if (com.tencent.mm.ad.c.cQ(paramFinderItem.getFeedObject().forward_style, 1))
        {
          localObject1 = "";
          break;
        }
        localObject1 = paramFinderItem.getNickName();
        break;
        localObject1 = paramFinderItem.getNickName();
        break;
        label464:
        localStringBuilder = new StringBuilder().append(localbmd.thumbUrl);
        localObject1 = localbmd.thumb_url_token;
        paramFinderItem = (FinderItem)localObject1;
        if (localObject1 == null) {
          paramFinderItem = "";
        }
      }
      label514:
      ((LinkedList)localObject2).addAll((Collection)localObject3);
      AppMethodBeat.o(190891);
      return localald;
    }
    
    public static int fVZ()
    {
      return LaM;
    }
    
    public static String getTAG()
    {
      return TAG;
    }
    
    public final void a(final MMActivity paramMMActivity, final FinderItem paramFinderItem)
    {
      AppMethodBeat.i(199642);
      k.h(paramMMActivity, "context");
      k.h(paramFinderItem, "feedObject");
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1278L, 11L, 1L, false);
      Object localObject1 = com.tencent.mm.plugin.finder.spam.a.qIC;
      if (com.tencent.mm.plugin.finder.spam.a.Zv("share"))
      {
        AppMethodBeat.o(199642);
        return;
      }
      localObject1 = new v.e();
      Object localObject2 = com.tencent.mm.ui.component.a.LCX;
      ((v.e)localObject1).Jhw = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class)).fXs();
      localObject2 = new k.b();
      Object localObject3 = new com.tencent.mm.plugin.i.a.b();
      ((com.tencent.mm.plugin.i.a.b)localObject3).d(c(paramFinderItem, false));
      ((k.b)localObject2).a((com.tencent.mm.ai.f)localObject3);
      ((k.b)localObject2).type = 51;
      ((k.b)localObject2).title = aj.getContext().getString(2131760809);
      ((k.b)localObject2).url = aj.getContext().getString(2131760810);
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("Retr_Msg_Type", 18);
      ((Intent)localObject3).putExtra("Multi_Retr", true);
      ((Intent)localObject3).putExtra("Retr_Msg_content", k.b.a((k.b)localObject2, null, null));
      ((Intent)localObject3).putExtra("Retr_go_to_chattingUI", false);
      ((Intent)localObject3).putExtra("Retr_show_success_tips", true);
      d.a(paramMMActivity, ".ui.transmit.MsgRetransmitUI", (Intent)localObject3, qSx, (MMActivity.a)new b(this, paramFinderItem, paramMMActivity, (v.e)localObject1));
      AppMethodBeat.o(199642);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class a
      implements MMActivity.a
    {
      a(g.a parama, com.tencent.mm.plugin.finder.api.f paramf, v.c paramc) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(167898);
        Object localObject;
        FinderAuthInfo localFinderAuthInfo;
        if (paramInt2 == -1)
        {
          localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          ad.i(g.a.getTAG(), "share namecard %s(%s) to %s", new Object[] { this.qBe.Su(), this.qBe.getUsername(), localObject });
          k.g(localObject, "toUsers");
          if (((Collection)localObject).isEmpty()) {
            break label152;
          }
          paramInt1 = 1;
          if (paramInt1 != 0)
          {
            paramIntent = com.tencent.mm.plugin.finder.report.b.qFq;
            paramIntent = this.qBe.getUsername();
            localObject = bt.n((List)localObject, ",");
            k.g(localObject, "Util.listToString(toUsers, \",\")");
            localFinderAuthInfo = this.qBe.field_authInfo;
            if (localFinderAuthInfo == null) {
              break label157;
            }
          }
        }
        label152:
        label157:
        for (paramInt1 = localFinderAuthInfo.authIconType;; paramInt1 = 0)
        {
          com.tencent.mm.plugin.finder.report.b.j(paramIntent, (String)localObject, paramInt1, this.KNb.Jhu);
          AppMethodBeat.o(167898);
          return;
          paramInt1 = 0;
          break;
        }
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class b
      implements MMActivity.a
    {
      b(g.a parama, FinderItem paramFinderItem, MMActivity paramMMActivity, v.e parame) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        boolean bool = false;
        AppMethodBeat.i(167899);
        Object localObject = new ArrayList();
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          k.g(paramIntent, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
          ad.i(g.a.getTAG(), "share finderObject %d to %s", new Object[] { Long.valueOf(paramFinderItem.getId()), paramIntent });
          if (!((Collection)paramIntent).isEmpty())
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label255;
            }
            localObject = com.tencent.mm.ui.component.a.LCX;
            localObject = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class));
            if (localObject == null) {
              break label197;
            }
            ((com.tencent.mm.plugin.finder.event.c)localObject).fSl().Bq(paramFinderItem.getId());
          }
        }
        label197:
        label255:
        for (;;)
        {
          localObject = com.tencent.mm.plugin.finder.report.b.qFq;
          long l = paramFinderItem.getId();
          if (paramInt2 == -1) {
            bool = true;
          }
          paramIntent = bt.n((List)paramIntent, ";");
          k.g(paramIntent, "Util.listToString(toUsers, \";\")");
          com.tencent.mm.plugin.finder.report.b.a(l, 1, bool, paramIntent, (dzp)this.LaN.Jhw);
          AppMethodBeat.o(167899);
          return;
          paramInt1 = 0;
          break;
          continue;
          paramIntent = com.tencent.mm.ui.component.a.LCX;
          paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class));
          if (paramIntent != null)
          {
            paramIntent.fSl().Bs(paramFinderItem.getId());
            paramIntent = (Intent)localObject;
          }
          else
          {
            paramIntent = (Intent)localObject;
          }
        }
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareToSnsTimeLine$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
    public static final class c
      implements MMActivity.a
    {
      c(MMActivity paramMMActivity, BaseFinderFeed paramBaseFinderFeed, v.e parame) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(167900);
        long l;
        if (paramInt2 == -1)
        {
          h.cc((Context)this.qSd, this.qSd.getString(2131755894));
          paramIntent = com.tencent.mm.ui.component.a.LCX;
          paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.qSd).get(FinderReporterUIC.class));
          if (paramIntent != null) {
            paramIntent.fSl().Br(this.qug.bMs());
          }
          paramIntent = com.tencent.mm.plugin.finder.report.b.qFq;
          l = this.qug.feedObject.getId();
          if (paramInt2 != -1) {
            break label169;
          }
        }
        label169:
        for (boolean bool = true;; bool = false)
        {
          com.tencent.mm.plugin.finder.report.b.a(l, 2, bool, "", (dzp)this.LaN.Jhw);
          AppMethodBeat.o(167900);
          return;
          paramIntent = com.tencent.mm.ui.component.a.LCX;
          paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.qSd).get(FinderReporterUIC.class));
          if (paramIntent == null) {
            break;
          }
          paramIntent.fSl().Bt(this.qug.bMs());
          break;
        }
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    public static final class d
      implements MMActivity.a
    {
      public d(g.a parama, String paramString, int paramInt, long paramLong) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        boolean bool = false;
        AppMethodBeat.i(167901);
        Object localObject = new ArrayList();
        if (paramInt2 == -1)
        {
          localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          k.g(localObject, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
          ad.i(g.a.getTAG(), "share topic %s to %s", new Object[] { this.qSD, localObject });
        }
        paramIntent = com.tencent.mm.plugin.finder.report.b.qFq;
        if (paramInt2 == -1) {
          bool = true;
        }
        paramIntent = bt.nullAsNil(this.qSD);
        k.g(paramIntent, "Util.nullAsNil(topic)");
        paramInt1 = this.qSE;
        long l = this.qSF;
        localObject = bt.n((List)localObject, ",");
        k.g(localObject, "Util.listToString(toUsers, \",\")");
        com.tencent.mm.plugin.finder.report.b.a(1, bool, paramIntent, paramInt1, l, (String)localObject);
        AppMethodBeat.o(167901);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareTopicToSnsTimeLine$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
    public static final class e
      implements MMActivity.a
    {
      public e(MMActivity paramMMActivity, String paramString, int paramInt, long paramLong) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(167902);
        if (paramInt2 == -1) {
          h.cc((Context)this.qSd, this.qSd.getString(2131755894));
        }
        paramIntent = com.tencent.mm.plugin.finder.report.b.qFq;
        if (paramInt2 == -1) {}
        for (boolean bool = true;; bool = false)
        {
          paramIntent = bt.nullAsNil(this.qSD);
          k.g(paramIntent, "Util.nullAsNil(topic)");
          com.tencent.mm.plugin.finder.report.b.a(2, bool, paramIntent, this.qSE, this.qSF, "");
          AppMethodBeat.o(167902);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.g
 * JD-Core Version:    0.7.0.1
 */