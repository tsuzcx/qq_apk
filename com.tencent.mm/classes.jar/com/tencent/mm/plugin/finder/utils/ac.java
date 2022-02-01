package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.aa.d;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil;", "", "Companion", "plugin-finder_release"})
public abstract interface ac
{
  public static final ac.a AEJ = ac.a.AEK;
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class a$a
    implements MMActivity.a
  {
    a$a(ac.a parama, com.tencent.mm.plugin.findersdk.a.d paramd, bid parambid) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(288639);
      if (paramInt2 == -1)
      {
        Object localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = new ArrayList(0);
        }
        localObject = Util.listToString((List)paramIntent, ";");
        com.tencent.mm.plugin.finder.report.n localn = com.tencent.mm.plugin.finder.report.n.zWF;
        long l = com.tencent.mm.ae.d.Nb(this.AEM.mbg.cardId);
        p.j(localObject, "users");
        com.tencent.mm.plugin.finder.report.n.a(l, 3, 1L, (String)localObject, paramIntent.size(), this.$contextObj);
        Log.i(ac.a.getTAG(), "[shareAlbumToChat] " + this.AEM.mbg.title + " to " + paramIntent);
        AppMethodBeat.o(288639);
        return;
      }
      paramIntent = com.tencent.mm.plugin.finder.report.n.zWF;
      com.tencent.mm.plugin.finder.report.n.a(com.tencent.mm.ae.d.Nb(this.AEM.mbg.cardId), 3, 2L, "", 0L, this.$contextObj);
      AppMethodBeat.o(288639);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class a$b
    implements MMActivity.a
  {
    a$b(ac.a parama, MMActivity paramMMActivity, c paramc, bid parambid) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(251241);
      if (paramInt2 == -1)
      {
        Object localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = new ArrayList(0);
        }
        localObject = Util.listToString((List)paramIntent, ";");
        h.cL((Context)this.xzL, this.xzL.getString(b.j.app_shared));
        com.tencent.mm.plugin.finder.report.n localn = com.tencent.mm.plugin.finder.report.n.zWF;
        long l = com.tencent.mm.ae.d.Nb(this.AEN.mbg.cardId);
        p.j(localObject, "users");
        com.tencent.mm.plugin.finder.report.n.a(l, 2, 1L, (String)localObject, paramIntent.size(), this.$contextObj);
        Log.i(ac.a.getTAG(), "[shareAlbumToSnsTimeLine] " + this.AEN.mbg.title + " to " + paramIntent);
        AppMethodBeat.o(251241);
        return;
      }
      paramIntent = com.tencent.mm.plugin.finder.report.n.zWF;
      com.tencent.mm.plugin.finder.report.n.a(com.tencent.mm.ae.d.Nb(this.AEN.mbg.cardId), 2, 2L, "", 0L, this.$contextObj);
      AppMethodBeat.o(251241);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class a$c
    implements w.b
  {
    public static final c AEO;
    
    static
    {
      AppMethodBeat.i(274429);
      AEO = new c();
      AppMethodBeat.o(274429);
    }
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(274427);
      if (paramView != null)
      {
        paramView = (TextView)paramView.findViewById(b.f.toast_text);
        if (paramView != null)
        {
          paramView.setTextSize(1, 14.0F);
          AppMethodBeat.o(274427);
          return;
        }
      }
      AppMethodBeat.o(274427);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class a$d
    implements MMFragmentActivity.b
  {
    a$d(ac.a parama, FinderItem paramFinderItem, AppCompatActivity paramAppCompatActivity, aa.d paramd, aa.f paramf) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(274041);
      Object localObject = new ArrayList();
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringArrayListExtra("SendMsgUsernames");
        p.j(paramIntent, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
        Log.i(ac.a.getTAG(), "share finderObject " + this.AAu.getId() + " to " + paramIntent);
        if (!((Collection)paramIntent).isEmpty())
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label377;
          }
          localObject = com.tencent.mm.ui.component.g.Xox;
          localObject = aj.b((aj)com.tencent.mm.ui.component.g.b(this.zQu).i(aj.class));
          if (localObject == null) {
            break label237;
          }
          ((com.tencent.mm.plugin.finder.event.a)localObject).dpO().Kw(this.AAu.getId());
        }
      }
      label134:
      label237:
      label377:
      for (;;)
      {
        if (paramInt2 == -1) {}
        for (long l1 = 1L;; l1 = 2L)
        {
          if (this.AAu.getFromType() != 32768) {
            break label303;
          }
          localObject = com.tencent.mm.plugin.finder.report.n.zWF;
          localObject = new bs(this.AAu.getFeedObject());
          paramInt1 = this.AEP.aaBA;
          String str = Util.listToString((List)paramIntent, ";");
          p.j(str, "Util.listToString(toUsers, \";\")");
          com.tencent.mm.plugin.finder.report.n.a((bs)localObject, paramInt1, l1, str, (bid)this.AEQ.aaBC, paramIntent.size());
          AppMethodBeat.o(274041);
          return;
          paramInt1 = 0;
          break;
          break label134;
          paramIntent = com.tencent.mm.ui.component.g.Xox;
          paramIntent = aj.b((aj)com.tencent.mm.ui.component.g.b(this.zQu).i(aj.class));
          if (paramIntent != null)
          {
            paramIntent.dpO().Ky(this.AAu.getId());
            paramIntent = (Intent)localObject;
            break label134;
          }
          paramIntent = (Intent)localObject;
          break label134;
        }
        localObject = com.tencent.mm.plugin.finder.report.n.zWF;
        long l2 = this.AAu.getId();
        paramInt1 = this.AEP.aaBA;
        localObject = Util.listToString((List)paramIntent, ";");
        p.j(localObject, "Util.listToString(toUsers, \";\")");
        com.tencent.mm.plugin.finder.report.n.a(l2, paramInt1, l1, (String)localObject, (bid)this.AEQ.aaBC, paramIntent.size(), null, 64);
        AppMethodBeat.o(274041);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class a$e
    implements MMActivity.a
  {
    a$e(ac.a parama, i parami, aa.d paramd) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(167898);
      Object localObject;
      FinderAuthInfo localFinderAuthInfo;
      if (paramInt2 == -1)
      {
        localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
        Log.i(ac.a.getTAG(), "share namecard " + this.xmS.getNickname() + '(' + this.xmS.getUsername() + ") to " + localObject);
        p.j(localObject, "toUsers");
        if (((Collection)localObject).isEmpty()) {
          break label168;
        }
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          paramIntent = com.tencent.mm.plugin.finder.report.n.zWF;
          paramIntent = this.xmS.getUsername();
          localObject = Util.listToString((List)localObject, ",");
          p.j(localObject, "Util.listToString(toUsers, \",\")");
          localFinderAuthInfo = this.xmS.field_authInfo;
          if (localFinderAuthInfo == null) {
            break label173;
          }
        }
      }
      label168:
      label173:
      for (paramInt1 = localFinderAuthInfo.authIconType;; paramInt1 = 0)
      {
        com.tencent.mm.plugin.finder.report.n.j(paramIntent, (String)localObject, paramInt1, this.xxk.aaBA);
        AppMethodBeat.o(167898);
        return;
        paramInt1 = 0;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class a$f
    implements MMFragmentActivity.b
  {
    a$f(ac.a parama, FinderItem paramFinderItem, b paramb) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(288424);
      Object localObject1 = new ArrayList();
      Object localObject2;
      if (paramInt2 == -1)
      {
        localObject2 = paramIntent.getStringArrayListExtra("SendMsgUsernames");
        p.j(localObject2, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
        Log.i(ac.a.getTAG(), "share finderObject " + this.AAu.getId() + " to " + localObject2);
        if (!((Collection)localObject2).isEmpty()) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramIntent = (Intent)localObject2;
          if (paramInt1 == 0) {
            break label400;
          }
          localObject3 = new JSONObject();
          localObject1 = ((ArrayList)localObject2).iterator();
          for (paramIntent = ""; ((Iterator)localObject1).hasNext(); paramIntent = paramIntent + (String)localObject4 + ';') {
            localObject4 = (String)((Iterator)localObject1).next();
          }
        }
        localObject1 = paramIntent;
        if (kotlin.n.n.pu(paramIntent, ";"))
        {
          paramInt1 = paramIntent.length();
          if (paramIntent == null)
          {
            paramIntent = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(288424);
            throw paramIntent;
          }
          localObject1 = paramIntent.substring(0, paramInt1 - 1);
          p.j(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        ((JSONObject)localObject3).put("1", localObject1);
        paramIntent = k.yBj;
        k.a(s.c.yEn, ((JSONObject)localObject3).toString());
        Object localObject3 = this.AEL;
        Object localObject4 = this.AAu;
        p.k(localObject4, "feedObject");
        LinkedList localLinkedList = new LinkedList();
        emr localemr = new emr();
        localemr.xbk = ((FinderItem)localObject4).getId();
        localemr.objectNonceId = ((FinderItem)localObject4).getObjectNonceId();
        paramIntent = new dhb();
        paramIntent.TNO = 1;
        paramIntent.TNQ = 1;
        localemr.Upl = paramIntent;
        paramIntent = ((FinderItem)localObject4).getFeedObject();
        if (paramIntent != null)
        {
          localObject1 = paramIntent.sessionBuffer;
          paramIntent = (Intent)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramIntent = "";
        }
        localemr.sessionBuffer = paramIntent;
        localemr.finderUsername = ((FinderItem)localObject4).getUserName();
        localemr.xkX = 65;
        localLinkedList.add(localemr);
        ((ac.a)localObject3).bb(localLinkedList);
      }
      for (paramIntent = (Intent)localObject2;; paramIntent = (Intent)localObject1)
      {
        label400:
        localObject1 = this.jFa;
        if (localObject1 == null) {
          break;
        }
        ((b)localObject1).invoke(paramIntent);
        AppMethodBeat.o(288424);
        return;
        paramIntent = new JSONObject();
        paramIntent.put("3", "");
        localObject2 = k.yBj;
        k.a(s.c.yEn, paramIntent.toString());
      }
      AppMethodBeat.o(288424);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareLiveToSnsTimeLineInternal$1", "Lcom/tencent/mm/ui/MMFragmentActivity$IMMOnFragmentActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
  public static final class a$g
    implements MMFragmentActivity.b
  {
    a$g(AppCompatActivity paramAppCompatActivity, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(291079);
      if (paramInt2 == -1)
      {
        h.cL((Context)this.zQu, this.zQu.getString(b.j.app_shared));
        paramIntent = com.tencent.mm.ui.component.g.Xox;
        paramIntent = aj.b((aj)com.tencent.mm.ui.component.g.b(this.zQu).i(aj.class));
        if (paramIntent != null) {
          paramIntent.dpO().Kx(this.xno.mf());
        }
        paramIntent = new JSONObject();
        paramIntent.put("2", "");
        localObject = k.yBj;
        k.a(s.c.yEn, paramIntent.toString());
        paramIntent = this.AEL;
        localObject = this.xno;
        p.k(localObject, "feed");
        LinkedList localLinkedList = new LinkedList();
        emr localemr = new emr();
        localemr.xbk = ((BaseFinderFeed)localObject).feedObject.getId();
        localemr.objectNonceId = ((BaseFinderFeed)localObject).feedObject.getObjectNonceId();
        dhb localdhb = new dhb();
        localdhb.TOa = 1;
        localdhb.TNQ = 1;
        localemr.Upl = localdhb;
        localemr.sessionBuffer = ((BaseFinderFeed)localObject).getSessionBuffer();
        localemr.finderUsername = ((BaseFinderFeed)localObject).feedObject.getUserName();
        localemr.xkX = 65;
        localLinkedList.add(localemr);
        ((ac.a)paramIntent).bb(localLinkedList);
        AppMethodBeat.o(291079);
        return;
      }
      paramIntent = com.tencent.mm.ui.component.g.Xox;
      paramIntent = aj.b((aj)com.tencent.mm.ui.component.g.b(this.zQu).i(aj.class));
      if (paramIntent != null) {
        paramIntent.dpO().Kz(this.xno.mf());
      }
      paramIntent = new JSONObject();
      paramIntent.put("4", "");
      Object localObject = k.yBj;
      k.a(s.c.yEn, paramIntent.toString());
      AppMethodBeat.o(291079);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  public static final class a$h
    implements MMActivity.a
  {
    public a$h(ac.a parama, com.tencent.mm.plugin.findersdk.a.g paramg) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(265060);
      new ArrayList();
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringArrayListExtra("SendMsgUsernames");
        p.j(paramIntent, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
        Log.i(ac.a.getTAG(), "share poi " + this.AER.mbj + " to " + paramIntent);
      }
      AppMethodBeat.o(265060);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a$j<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a$j(ac.a parama, LinkedList paramLinkedList) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class a$k
    implements w.b
  {
    public static final k AET;
    
    static
    {
      AppMethodBeat.i(285552);
      AET = new k();
      AppMethodBeat.o(285552);
    }
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(285551);
      if (paramView != null)
      {
        paramView = (TextView)paramView.findViewById(b.f.toast_text);
        if (paramView != null)
        {
          paramView.setTextSize(1, 14.0F);
          AppMethodBeat.o(285551);
          return;
        }
      }
      AppMethodBeat.o(285551);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareToSnsTimeLineInternal$2", "Lcom/tencent/mm/ui/MMFragmentActivity$IMMOnFragmentActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
  public static final class a$l
    implements MMFragmentActivity.b
  {
    a$l(MMFragmentActivity paramMMFragmentActivity, BaseFinderFeed paramBaseFinderFeed, int paramInt, aa.f paramf) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(292031);
      if (paramInt2 == -1)
      {
        h.cL((Context)this.AEU, this.AEU.getString(b.j.app_shared));
        paramIntent = com.tencent.mm.ui.component.g.Xox;
        paramIntent = aj.b((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.AEU).i(aj.class));
        if (paramIntent != null) {
          paramIntent.dpO().Kx(this.xno.mf());
        }
        if (paramInt2 != -1) {
          break label196;
        }
      }
      label196:
      for (long l = 1L;; l = 2L)
      {
        if (this.xno.feedObject.getFromType() != 32768) {
          break label204;
        }
        com.tencent.mm.plugin.finder.report.n.a(com.tencent.mm.plugin.finder.report.n.zWF, new bs(this.xno.feedObject.getFeedObject()), this.AEV, l, "", (bid)this.AEQ.aaBC);
        AppMethodBeat.o(292031);
        return;
        paramIntent = com.tencent.mm.ui.component.g.Xox;
        paramIntent = aj.b((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.AEU).i(aj.class));
        if (paramIntent == null) {
          break;
        }
        paramIntent.dpO().Kz(this.xno.mf());
        break;
      }
      label204:
      paramIntent = com.tencent.mm.plugin.finder.report.n.zWF;
      com.tencent.mm.plugin.finder.report.n.a(this.xno.feedObject.getId(), this.AEV, l, "", (bid)this.AEQ.aaBC, 0L, this.xno.feedObject, 32);
      AppMethodBeat.o(292031);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ac
 * JD-Core Version:    0.7.0.1
 */