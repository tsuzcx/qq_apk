package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.x;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.protocal.protobuf.ali;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.protocal.protobuf.dmp;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.z;
import java.lang.ref.WeakReference;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "addContacListener", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$IListenerImpl;", "avatarIV", "Landroid/widget/ImageView;", "getAvatarIV", "()Landroid/widget/ImageView;", "setAvatarIV", "(Landroid/widget/ImageView;)V", "closeIv", "Landroid/view/View;", "getCloseIv", "()Landroid/view/View;", "setCloseIv", "(Landroid/view/View;)V", "closeLayout", "getCloseLayout", "setCloseLayout", "getContext", "()Landroid/content/Context;", "followAlready", "Landroid/widget/TextView;", "getFollowAlready", "()Landroid/widget/TextView;", "setFollowAlready", "(Landroid/widget/TextView;)V", "followArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getFollowArrow", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setFollowArrow", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "followType3", "Landroid/widget/Button;", "getFollowType3", "()Landroid/widget/Button;", "setFollowType3", "(Landroid/widget/Button;)V", "nickNameTV", "getNickNameTV", "setNickNameTV", "profileDescTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getProfileDescTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setProfileDescTv", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "profileLayout", "getProfileLayout", "setProfileLayout", "profileReasonTv", "getProfileReasonTv", "setProfileReasonTv", "recCardTitle", "getRecCardTitle", "setRecCardTitle", "weakContext", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getWeakContext", "()Ljava/lang/ref/WeakReference;", "attachRound", "", "iv", "brandURL", "", "btnFollow", "username", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "filling", "position", "", "convertView", "parent", "inflate", "inflateHeader", "header", "onAppMsgClick", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "order", "onUnLikeClick", "view", "refreshHeader", "shouldShowNegativeFeedback", "", "recCardUserInfo", "Lcom/tencent/mm/protocal/protobuf/TLRecCardUserInfo;", "viewContactProfile", "talker", "Companion", "IListenerImpl", "plugin-brandservice_release"})
public abstract class p
  extends v
{
  public static final p.a ojV = new p.a((byte)0);
  final Context context;
  public ImageView fQl;
  final WeakReference<Context> ndc;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b ohs;
  public TextView ojK;
  public TextView ojL;
  public View ojM;
  public View ojN;
  public View ojO;
  public TextView ojP;
  public MMNeat7extView ojQ;
  public Button ojR;
  public TextView ojS;
  public WeImageView ojT;
  private p.b ojU;
  
  public p(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.context = paramContext;
    this.ohs = paramb;
    this.ndc = new WeakReference(this.context);
    this.ojU = new p.b(this);
  }
  
  public void a(final w paramw, int paramInt, View paramView1, final View paramView2)
  {
    d.g.b.p.h(paramw, "info");
    d.g.b.p.h(paramView1, "convertView");
    d.g.b.p.h(paramView2, "parent");
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1149L, 2L, 1L, false);
    dD(paramView2);
    paramView2 = paramw.ftj();
    if (paramView2 != null)
    {
      paramView2 = paramView2.HTL;
      if (paramView2 != null) {
        break label78;
      }
      paramView1.setVisibility(8);
    }
    label78:
    label764:
    do
    {
      Object localObject1;
      do
      {
        return;
        paramView2 = null;
        break;
        paramView1.setVisibility(0);
        d.g.b.p.h(paramw, "info");
        paramView1 = paramw.ftj();
        paramView2 = this.ojL;
        if (paramView2 == null) {
          d.g.b.p.bdF("recCardTitle");
        }
        paramView2.setText((CharSequence)paramView1.Gys);
        paramView2 = this.ojK;
        if (paramView2 == null) {
          d.g.b.p.bdF("nickNameTV");
        }
        if (paramView2 == null) {
          d.g.b.p.gkB();
        }
        paramView2 = paramView2.getPaint();
        d.g.b.p.g(paramView2, "tp");
        paramView2.setFakeBoldText(true);
        paramView2 = this.fQl;
        if (paramView2 == null) {
          d.g.b.p.bdF("avatarIV");
        }
        if (paramView2 == null) {
          d.g.b.p.gkB();
        }
        localObject1 = paramView1.HTL.Gcs;
        d.g.b.p.g(localObject1, "recCard.BizInfo.BrandIconUrl");
        localObject2 = new c.a();
        ((c.a)localObject2).pL(2131231342);
        ((c.a)localObject2).aJr();
        ((c.a)localObject2).aJs();
        com.tencent.mm.av.q.aJb().a((String)localObject1, paramView2, ((c.a)localObject2).aJu());
        paramView2 = this.ojK;
        if (paramView2 == null) {
          d.g.b.p.bdF("nickNameTV");
        }
        if (paramView2 == null) {
          d.g.b.p.gkB();
        }
        paramView2.setText((CharSequence)paramView1.HTL.nJO);
        paramView2 = this.ojP;
        if (paramView2 == null) {
          d.g.b.p.bdF("profileReasonTv");
        }
        paramView2.setText((CharSequence)paramView1.HTL.HTN);
        paramView2 = paramView1.HTL.nIJ;
        localObject1 = this.ojO;
        if (localObject1 == null) {
          d.g.b.p.bdF("profileLayout");
        }
        ((View)localObject1).setOnClickListener((View.OnClickListener)new p.d(this, paramView2, paramw));
        localObject1 = paramw.ftk();
      } while (localObject1 == null);
      Object localObject2 = paramView1.HTM;
      int i;
      if (localObject2 == null)
      {
        ae.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
        i = 0;
        if ((i != 0) || (!bu.ht((List)((dmq)localObject1).HTR))) {
          break label681;
        }
        ae.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = " + paramView1.HTL.nJO);
        paramView1 = this.ojM;
        if (paramView1 == null) {
          d.g.b.p.bdF("closeLayout");
        }
        paramView1.setVisibility(8);
      }
      for (;;)
      {
        paramw = (d.g.a.a)new f(this, paramw, paramView2);
        paramView1 = this.ojS;
        if (paramView1 == null) {
          d.g.b.p.bdF("followAlready");
        }
        paramView1.setVisibility(8);
        paramView1 = this.ojR;
        if (paramView1 == null) {
          d.g.b.p.bdF("followType3");
        }
        paramView1.setVisibility(8);
        paramView1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        d.g.b.p.g(paramView1, "MMKernel.service(IMessengerStorage::class.java)");
        paramView1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramView1).azF().BH(paramView2);
        if ((paramView1 != null) && (paramView1.adE() > 0)) {
          break label764;
        }
        au.a.aBQ().a(paramView2, "", null);
        paramw.invoke();
        return;
        if (((dmp)localObject2).HTP == null)
        {
          ae.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
          i = 0;
          break;
        }
        if (((dmp)localObject2).HTP.Gcn != 1)
        {
          ae.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
          i = 0;
          break;
        }
        if (bu.ht((List)((dmp)localObject2).HTP.Gcm))
        {
          ae.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
          i = 0;
          break;
        }
        i = 1;
        break;
        ae.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = " + paramView1.HTL.nJO);
        paramView1 = this.ojM;
        if (paramView1 == null) {
          d.g.b.p.bdF("closeLayout");
        }
        paramView1.setVisibility(0);
        paramView1 = this.ojM;
        if (paramView1 == null) {
          d.g.b.p.bdF("closeLayout");
        }
        paramView1.setOnClickListener((View.OnClickListener)new p.e(this, paramw, paramInt));
      }
      if (!paramView1.ads())
      {
        paramw.invoke();
        return;
      }
    } while (!paramView1.ads());
    label681:
    paramw = this.ojS;
    if (paramw == null) {
      d.g.b.p.bdF("followAlready");
    }
    paramw.setVisibility(0);
  }
  
  public final void a(w paramw, dmm paramdmm, View paramView, int paramInt)
  {
    d.g.b.p.h(paramw, "info");
    if ((paramdmm != null) && (paramw.ftj() != null))
    {
      localObject1 = paramw.ftj();
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      if (((dml)localObject1).HTL != null) {}
    }
    else
    {
      ae.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
      return;
    }
    Object localObject1 = paramw.ftj();
    if (localObject1 == null) {
      d.g.b.p.gkB();
    }
    Object localObject2 = ((dml)localObject1).HTL;
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1149L, 4L, 1L, false);
    ae.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { paramdmm.FYs });
    Intent localIntent = new Intent();
    localObject1 = m.d(paramdmm.FYs, 138, 10000, 0);
    localIntent.putExtra("rawUrl", (String)localObject1);
    localIntent.putExtra("geta8key_scene", 56);
    localIntent.putExtra("geta8key_username", ((dmn)localObject2).nIJ);
    localIntent.putExtra("srcUsername", ((dmn)localObject2).nIJ);
    localIntent.putExtra("srcDisplayname", ((dmn)localObject2).nJO);
    localIntent.putExtra("prePublishId", "rec_card");
    localIntent.putExtra("KPublisherId", "rec_card");
    int i;
    int j;
    if (paramdmm.hFR == 5)
    {
      Object localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
      d.g.b.p.g(localObject3, "MMKernel.service(IBrandService::class.java)");
      if (((com.tencent.mm.plugin.brandservice.a.b)localObject3).bOe())
      {
        localIntent.putExtra(e.b.JoV, 138);
        localIntent.putExtra(e.b.JoW, 10000);
        localIntent.putExtra("biz_video_session_id", y.getSessionId());
        localObject3 = new x();
        ((x)localObject3).hFX = localIntent.getStringExtra("KPublisherId");
        ((x)localObject3).dpP = ((dmn)localObject2).nIJ;
        ((x)localObject3).hFW = ((dmn)localObject2).nJO;
        ((x)localObject3).hFY.url = ((String)localObject1);
        ((x)localObject3).hFY.title = paramdmm.Title;
        ((x)localObject3).hFY.hGg = paramdmm.FYq;
        ((x)localObject3).hFY.hGe = paramdmm.FYu;
        ((x)localObject3).hFY.type = paramdmm.hFR;
        ((x)localObject3).hFY.time = paramdmm.CreateTime;
        ((x)localObject3).hFY.hGi = paramdmm.FYG;
        ((x)localObject3).hFY.videoWidth = paramdmm.FYE;
        ((x)localObject3).hFY.videoHeight = paramdmm.FYF;
        ((x)localObject3).hFY.hCa = paramdmm.FYD;
        ((x)localObject3).t(localIntent);
        ae.i("MicroMsg.BizTimeLineItem", "jump to native video");
        localObject2 = new int[2];
        if (paramView != null)
        {
          i = paramView.getWidth();
          j = paramView.getHeight();
          paramView.getLocationInWindow((int[])localObject2);
          localIntent.putExtra("img_gallery_width", i).putExtra("img_gallery_height", j).putExtra("img_gallery_left", localObject2[0]).putExtra("img_gallery_top", localObject2[1]);
        }
        localIntent.addFlags(268435456);
      }
    }
    if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(1)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.context, (String)localObject1, paramdmm.hFR, 138, 10000, localIntent))) {
      ae.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
    }
    for (;;)
    {
      paramdmm = paramw.ftk();
      if (paramdmm != null)
      {
        j = 0;
        i = j;
      }
      try
      {
        paramView = Uri.parse((String)localObject1);
        i = j;
        j = bu.getInt(paramView.getQueryParameter("idx"), 0);
        i = j;
        l = bu.getLong(paramView.getQueryParameter("mid"), 0L);
        i = j;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          long l = 0L;
        }
      }
      this.ohs.ogr.a(paramw.field_talker, l, i, 15, 0, paramdmm.HDI, true, paramInt);
      this.ohs.b(paramw, paramInt);
      return;
      com.tencent.mm.br.d.b(this.context, "webview", ".ui.tools.WebViewUI", localIntent);
    }
  }
  
  public final TextView bPE()
  {
    TextView localTextView = this.ojP;
    if (localTextView == null) {
      d.g.b.p.bdF("profileReasonTv");
    }
    return localTextView;
  }
  
  public final Button bPF()
  {
    Button localButton = this.ojR;
    if (localButton == null) {
      d.g.b.p.bdF("followType3");
    }
    return localButton;
  }
  
  public final TextView bPG()
  {
    TextView localTextView = this.ojS;
    if (localTextView == null) {
      d.g.b.p.bdF("followAlready");
    }
    return localTextView;
  }
  
  public abstract void dD(View paramView);
  
  public final void dE(View paramView)
  {
    d.g.b.p.h(paramView, "header");
    Object localObject = paramView.findViewById(2131297008);
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type android.widget.ImageView");
    }
    this.fQl = ((ImageView)localObject);
    localObject = paramView.findViewById(2131302860);
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type android.widget.TextView");
    }
    this.ojK = ((TextView)localObject);
    localObject = paramView.findViewById(2131297298);
    d.g.b.p.g(localObject, "header.findViewById(R.id.biz_rec_card_title)");
    this.ojL = ((TextView)localObject);
    localObject = com.tencent.mm.plugin.brandservice.ui.b.d.oyS;
    localObject = this.ojL;
    if (localObject == null) {
      d.g.b.p.bdF("recCardTitle");
    }
    com.tencent.mm.plugin.brandservice.ui.b.d.h((TextView)localObject);
    localObject = paramView.findViewById(2131298374);
    d.g.b.p.g(localObject, "header.findViewById(R.id.close_layout)");
    this.ojM = ((View)localObject);
    localObject = paramView.findViewById(2131298373);
    d.g.b.p.g(localObject, "header.findViewById(R.id.close_iv)");
    this.ojN = ((View)localObject);
    localObject = paramView.findViewById(2131297296);
    d.g.b.p.g(localObject, "header.findViewById(R.id…_rec_card_profile_layout)");
    this.ojO = ((View)localObject);
    localObject = paramView.findViewById(2131297297);
    d.g.b.p.g(localObject, "header.findViewById(R.id.biz_rec_card_reason_tv)");
    this.ojP = ((TextView)localObject);
    localObject = paramView.findViewById(2131297294);
    d.g.b.p.g(localObject, "header.findViewById(R.id.biz_rec_card_desc_tv)");
    this.ojQ = ((MMNeat7extView)localObject);
    localObject = paramView.findViewById(2131302669);
    ((WeImageView)localObject).setVisibility(0);
    d.g.b.p.g(localObject, "header.findViewById<WeIm…sibility = View.VISIBLE }");
    this.ojT = ((WeImageView)localObject);
    localObject = paramView.findViewById(2131307162);
    d.g.b.p.g(localObject, "header.findViewById(R.id…_rec_card_follow_already)");
    this.ojS = ((TextView)localObject);
    paramView = paramView.findViewById(2131307163);
    d.g.b.p.g(paramView, "header.findViewById(R.id…iz_rec_card_follow_type3)");
    this.ojR = ((Button)paramView);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    f(p paramp, w paramw, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.p
 * JD-Core Version:    0.7.0.1
 */