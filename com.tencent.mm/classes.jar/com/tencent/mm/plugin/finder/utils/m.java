package com.tencent.mm.plugin.finder.utils;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.arw;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil;", "", "Companion", "plugin-finder_release"})
public abstract interface m
{
  public static final a sWJ = a.sWO;
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion;", "", "()V", "REQUEST_CODE_SHARE_FEED_TO_CHAT", "", "getREQUEST_CODE_SHARE_FEED_TO_CHAT", "()I", "REQUEST_CODE_SHARE_FEED_TO_SNS", "getREQUEST_CODE_SHARE_FEED_TO_SNS", "REQUEST_CODE_SHARE_NAMECARD_TO_CAHT", "getREQUEST_CODE_SHARE_NAMECARD_TO_CAHT", "REQUEST_CODE_SHARE_VIDEO_FILE_TO_CHAT", "getREQUEST_CODE_SHARE_VIDEO_FILE_TO_CHAT", "TAG", "", "getTAG", "()Ljava/lang/String;", "getFavEventInfo", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "thumbPath", "getFinderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "feedObject", "isShareSns", "", "getFinderTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "topic", "topicType", "iconUrl", "desc", "poiLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "shareFinderContactToConversation", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "param", "Landroid/os/Bundle;", "shareToConversation", "shareType", "shareToSnsTimeLine", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "shareTopicToConversation", "totalCount", "", "scene", "shareTopicToSnsTimeLine", "plugin-finder_release"})
  public static final class a
  {
    public static final String TAG = "Finder.FinderShareUtil";
    public static final int sWK = 1001;
    public static final int sWL = 1002;
    private static final int sWM = 1003;
    private static final int sWN = 1004;
    
    static
    {
      AppMethodBeat.i(167909);
      sWO = new a();
      sWK = 1001;
      sWL = 1002;
      sWM = 1003;
      sWN = 1004;
      TAG = "Finder.FinderShareUtil";
      AppMethodBeat.o(167909);
    }
    
    public static arz a(String paramString1, int paramInt, String paramString2, String paramString3, apl paramapl)
    {
      float f2 = 0.0F;
      AppMethodBeat.i(167908);
      arz localarz = new arz();
      localarz.dBe = bu.nullAsNil(paramString1);
      localarz.sXu = paramInt;
      localarz.iconUrl = bu.nullAsNil(paramString2);
      localarz.desc = bu.nullAsNil(paramString3);
      paramString2 = new arw();
      if (paramapl != null)
      {
        paramString1 = paramapl.GGA;
        paramString2.GGA = paramString1;
        if (paramapl == null) {
          break label133;
        }
      }
      label133:
      for (float f1 = paramapl.dBu;; f1 = 0.0F)
      {
        paramString2.dBu = f1;
        f1 = f2;
        if (paramapl != null) {
          f1 = paramapl.dzE;
        }
        paramString2.dzE = f1;
        localarz.GIz = paramString2;
        AppMethodBeat.o(167908);
        return localarz;
        paramString1 = null;
        break;
      }
    }
    
    private static ary c(FinderItem paramFinderItem, boolean paramBoolean)
    {
      AppMethodBeat.i(205122);
      d.g.b.p.h(paramFinderItem, "feedObject");
      Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      int i = ((Number)com.tencent.mm.plugin.finder.storage.b.cIM().value()).intValue();
      ae.i(TAG, "getFinderShareObject " + i + ' ' + paramFinderItem.getFeedObject().forward_style + ' ' + paramBoolean);
      ary localary;
      Object localObject2;
      Object localObject3;
      label260:
      bvz localbvz;
      arx localarx;
      StringBuilder localStringBuilder;
      if ((paramBoolean) && (i != 1)) {
        if (i == 2)
        {
          localObject1 = "";
          localary = new ary();
          localary.objectId = c.rp(paramFinderItem.getId());
          localary.objectNonceId = paramFinderItem.getObjectNonceId();
          localary.GIy = paramFinderItem.getMediaType();
          localObject2 = paramFinderItem.getFeedObject().contact;
          if (localObject2 != null)
          {
            localObject3 = ((FinderContact)localObject2).headUrl;
            localObject2 = localObject3;
            if (localObject3 != null) {}
          }
          else
          {
            localObject2 = "";
          }
          localary.ssR = ((String)localObject2);
          localary.nickname = ((String)localObject1);
          localary.username = paramFinderItem.getUserName();
          localObject1 = com.tencent.mm.plugin.finder.search.h.sEe;
          localary.desc = com.tencent.mm.plugin.finder.search.h.aiV(paramFinderItem.getDescription());
          localary.drZ = paramFinderItem.getMediaList().size();
          localObject2 = localary.mediaList;
          paramFinderItem = (Iterable)paramFinderItem.getMediaList();
          localObject3 = (Collection)new ArrayList(j.a(paramFinderItem, 10));
          Iterator localIterator = paramFinderItem.iterator();
          if (!localIterator.hasNext()) {
            break label536;
          }
          localbvz = (bvz)localIterator.next();
          localarx = new arx();
          localarx.mediaType = localbvz.mediaType;
          localStringBuilder = new StringBuilder().append(localbvz.url);
          localObject1 = localbvz.url_token;
          paramFinderItem = (FinderItem)localObject1;
          if (localObject1 == null) {
            paramFinderItem = "";
          }
          localarx.url = paramFinderItem;
          if (bu.isNullOrNil(localbvz.coverUrl)) {
            break label486;
          }
          localStringBuilder = new StringBuilder().append(localbvz.coverUrl);
          localObject1 = localbvz.cover_url_token;
          paramFinderItem = (FinderItem)localObject1;
          if (localObject1 == null) {
            paramFinderItem = "";
          }
        }
      }
      for (localarx.thumbUrl = paramFinderItem;; localarx.thumbUrl = paramFinderItem)
      {
        localarx.width = localbvz.width;
        localarx.height = localbvz.height;
        localarx.GIx = localbvz.videoDuration;
        ((Collection)localObject3).add(localarx);
        break label260;
        if (c.cQ(paramFinderItem.getFeedObject().forward_style, 1))
        {
          localObject1 = "";
          break;
        }
        localObject1 = paramFinderItem.getNickName();
        break;
        localObject1 = paramFinderItem.getNickName();
        break;
        label486:
        localStringBuilder = new StringBuilder().append(localbvz.thumbUrl);
        localObject1 = localbvz.thumb_url_token;
        paramFinderItem = (FinderItem)localObject1;
        if (localObject1 == null) {
          paramFinderItem = "";
        }
      }
      label536:
      ((LinkedList)localObject2).addAll((Collection)localObject3);
      AppMethodBeat.o(205122);
      return localary;
    }
    
    public static int cNY()
    {
      return sWN;
    }
    
    public static String getTAG()
    {
      return TAG;
    }
    
    public final void a(final MMActivity paramMMActivity, final FinderItem paramFinderItem, final int paramInt)
    {
      AppMethodBeat.i(205118);
      d.g.b.p.h(paramMMActivity, "context");
      d.g.b.p.h(paramFinderItem, "feedObject");
      Object localObject1 = p.sXz;
      if (!p.q(paramFinderItem.getFeedObject()))
      {
        paramFinderItem = p.sXz;
        paramFinderItem = (Context)paramMMActivity;
        paramMMActivity = paramMMActivity.getString(2131767019);
        d.g.b.p.g(paramMMActivity, "context.getString(R.stri…finder_private_ban_share)");
        p.at(paramFinderItem, paramMMActivity);
        AppMethodBeat.o(205118);
        return;
      }
      ae.i(TAG, "shareToConversation, id:" + paramFinderItem.getId() + ", pflag:" + paramFinderItem.getFeedObject().permissionFlag);
      if (paramFinderItem.getFeedObject().privateFlag == 1)
      {
        t.a((Context)paramMMActivity, paramMMActivity.getString(2131767023), (t.b)m.a.b.sWQ);
        AppMethodBeat.o(205118);
        return;
      }
      e.ywz.idkeyStat(1278L, 11L, 1L, false);
      localObject1 = com.tencent.mm.plugin.finder.spam.a.sEK;
      if (com.tencent.mm.plugin.finder.spam.a.ajm("share"))
      {
        AppMethodBeat.o(205118);
        return;
      }
      localObject1 = new y.f();
      Object localObject2 = com.tencent.mm.ui.component.a.KEX;
      ((y.f)localObject1).NiY = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class)).cQZ();
      localObject2 = new k.b();
      Object localObject3 = new com.tencent.mm.plugin.i.a.b();
      ((com.tencent.mm.plugin.i.a.b)localObject3).a(o(paramFinderItem));
      ((k.b)localObject2).a((f)localObject3);
      ((k.b)localObject2).type = 51;
      ((k.b)localObject2).title = ak.getContext().getString(2131760809);
      ((k.b)localObject2).url = ak.getContext().getString(2131760810);
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("Retr_Msg_Type", 18);
      ((Intent)localObject3).putExtra("Multi_Retr", true);
      ((Intent)localObject3).putExtra("Retr_Msg_content", k.b.a((k.b)localObject2, null, null));
      ((Intent)localObject3).putExtra("Retr_go_to_chattingUI", false);
      ((Intent)localObject3).putExtra("Retr_show_success_tips", true);
      d.a(paramMMActivity, ".ui.transmit.MsgRetransmitUI", (Intent)localObject3, sWK, (MMActivity.a)new c(this, paramFinderItem, paramMMActivity, paramInt, (y.f)localObject1));
      AppMethodBeat.o(205118);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
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
          ae.i(m.a.getTAG(), "share namecard %s(%s) to %s", new Object[] { this.spS.VK(), this.spS.getUsername(), localObject });
          d.g.b.p.g(localObject, "toUsers");
          if (((Collection)localObject).isEmpty()) {
            break label152;
          }
          paramInt1 = 1;
          if (paramInt1 != 0)
          {
            paramIntent = i.syT;
            paramIntent = this.spS.getUsername();
            localObject = bu.m((List)localObject, ",");
            d.g.b.p.g(localObject, "Util.listToString(toUsers, \",\")");
            localFinderAuthInfo = this.spS.field_authInfo;
            if (localFinderAuthInfo == null) {
              break label157;
            }
          }
        }
        label152:
        label157:
        for (paramInt1 = localFinderAuthInfo.authIconType;; paramInt1 = 0)
        {
          i.j(paramIntent, (String)localObject, paramInt1, this.sdP.NiW);
          AppMethodBeat.o(167898);
          return;
          paramInt1 = 0;
          break;
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class c
      implements MMActivity.a
    {
      c(m.a parama, FinderItem paramFinderItem, MMActivity paramMMActivity, int paramInt, y.f paramf) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(205114);
        Object localObject = new ArrayList();
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getStringArrayListExtra("SendMsgUsernames");
          d.g.b.p.g(paramIntent, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
          ae.i(m.a.getTAG(), "share finderObject %d to %s", new Object[] { Long.valueOf(paramFinderItem.getId()), paramIntent });
          if (!((Collection)paramIntent).isEmpty())
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label273;
            }
            localObject = com.tencent.mm.ui.component.a.KEX;
            localObject = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class));
            if (localObject == null) {
              break label207;
            }
            ((com.tencent.mm.plugin.finder.event.a)localObject).cAI().wb(paramFinderItem.getId());
          }
        }
        label273:
        for (;;)
        {
          label126:
          if (paramInt2 == -1) {}
          for (long l1 = 1L;; l1 = 2L)
          {
            localObject = i.syT;
            long l2 = paramFinderItem.getId();
            paramInt1 = paramInt;
            localObject = bu.m((List)paramIntent, ";");
            d.g.b.p.g(localObject, "Util.listToString(toUsers, \";\")");
            i.a(l2, paramInt1, l1, (String)localObject, (arn)this.sWS.NiY, paramIntent.size());
            AppMethodBeat.o(205114);
            return;
            paramInt1 = 0;
            break;
            label207:
            break label126;
            paramIntent = com.tencent.mm.ui.component.a.KEX;
            paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class));
            if (paramIntent != null)
            {
              paramIntent.cAI().wd(paramFinderItem.getId());
              paramIntent = (Intent)localObject;
              break label126;
            }
            paramIntent = (Intent)localObject;
            break label126;
          }
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareToSnsTimeLine$2", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
    public static final class e
      implements MMActivity.a
    {
      e(MMActivity paramMMActivity, BaseFinderFeed paramBaseFinderFeed, int paramInt, y.f paramf) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(205117);
        if (paramInt2 == -1)
        {
          com.tencent.mm.ui.base.h.cj((Context)this.sjk, this.sjk.getString(2131755894));
          paramIntent = com.tencent.mm.ui.component.a.KEX;
          paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.sjk).get(FinderReporterUIC.class));
          if (paramIntent != null) {
            paramIntent.cAI().wc(this.rXB.lP());
          }
          if (paramInt2 != -1) {
            break label168;
          }
        }
        label168:
        for (long l = 1L;; l = 2L)
        {
          paramIntent = i.syT;
          i.a(this.rXB.feedObject.getId(), this.sWR, l, "", (arn)this.sWS.NiY);
          AppMethodBeat.o(205117);
          return;
          paramIntent = com.tencent.mm.ui.component.a.KEX;
          paramIntent = FinderReporterUIC.b((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.sjk).get(FinderReporterUIC.class));
          if (paramIntent == null) {
            break;
          }
          paramIntent.cAI().we(this.rXB.lP());
          break;
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
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
          ae.i(m.a.getTAG(), "share topic %s to %s", new Object[] { this.sWU, localObject });
        }
        paramIntent = i.syT;
        if (paramInt2 == -1) {
          bool = true;
        }
        paramIntent = bu.nullAsNil(this.sWU);
        d.g.b.p.g(paramIntent, "Util.nullAsNil(topic)");
        paramInt1 = this.sWV;
        long l = this.sWW;
        localObject = bu.m((List)localObject, ",");
        d.g.b.p.g(localObject, "Util.listToString(toUsers, \",\")");
        i.a(1, bool, paramIntent, paramInt1, l, (String)localObject);
        AppMethodBeat.o(167901);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareTopicToSnsTimeLine$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
    public static final class g
      implements MMActivity.a
    {
      public g(MMActivity paramMMActivity, String paramString, int paramInt, long paramLong) {}
      
      public final void c(int paramInt1, int paramInt2, Intent paramIntent)
      {
        AppMethodBeat.i(167902);
        if (paramInt2 == -1) {
          com.tencent.mm.ui.base.h.cj((Context)this.sjk, this.sjk.getString(2131755894));
        }
        paramIntent = i.syT;
        if (paramInt2 == -1) {}
        for (boolean bool = true;; bool = false)
        {
          paramIntent = bu.nullAsNil(this.sWU);
          d.g.b.p.g(paramIntent, "Util.nullAsNil(topic)");
          i.a(2, bool, paramIntent, this.sWV, this.sWW, "");
          AppMethodBeat.o(167902);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.m
 * JD-Core Version:    0.7.0.1
 */