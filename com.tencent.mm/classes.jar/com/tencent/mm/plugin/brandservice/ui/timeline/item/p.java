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
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.x;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.protocal.protobuf.dlq;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.v;
import java.lang.ref.WeakReference;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "addContacListener", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$IListenerImpl;", "avatarIV", "Landroid/widget/ImageView;", "getAvatarIV", "()Landroid/widget/ImageView;", "setAvatarIV", "(Landroid/widget/ImageView;)V", "closeIv", "Landroid/view/View;", "getCloseIv", "()Landroid/view/View;", "setCloseIv", "(Landroid/view/View;)V", "closeLayout", "getCloseLayout", "setCloseLayout", "getContext", "()Landroid/content/Context;", "followAlready", "Landroid/widget/TextView;", "getFollowAlready", "()Landroid/widget/TextView;", "setFollowAlready", "(Landroid/widget/TextView;)V", "followArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getFollowArrow", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setFollowArrow", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "followType3", "Landroid/widget/Button;", "getFollowType3", "()Landroid/widget/Button;", "setFollowType3", "(Landroid/widget/Button;)V", "nickNameTV", "getNickNameTV", "setNickNameTV", "profileDescTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getProfileDescTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setProfileDescTv", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "profileLayout", "getProfileLayout", "setProfileLayout", "profileReasonTv", "getProfileReasonTv", "setProfileReasonTv", "recCardTitle", "getRecCardTitle", "setRecCardTitle", "weakContext", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getWeakContext", "()Ljava/lang/ref/WeakReference;", "attachRound", "", "iv", "brandURL", "", "btnFollow", "username", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "filling", "position", "", "convertView", "parent", "inflate", "inflateHeader", "header", "onAppMsgClick", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "order", "onUnLikeClick", "view", "refreshHeader", "shouldShowNegativeFeedback", "", "recCardUserInfo", "Lcom/tencent/mm/protocal/protobuf/TLRecCardUserInfo;", "viewContactProfile", "talker", "Companion", "IListenerImpl", "plugin-brandservice_release"})
public abstract class p
  extends u
{
  public static final p.a oef = new p.a((byte)0);
  final Context context;
  public ImageView fOf;
  final WeakReference<Context> mXV;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b obC;
  public TextView odU;
  public TextView odV;
  public View odW;
  public View odX;
  public View odY;
  public TextView odZ;
  public MMNeat7extView oea;
  public Button oeb;
  public TextView oec;
  public WeImageView oed;
  private p.b oee;
  
  public p(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.context = paramContext;
    this.obC = paramb;
    this.mXV = new WeakReference(this.context);
    this.oee = new p.b(this);
  }
  
  public void a(w paramw, int paramInt, View paramView1, View paramView2)
  {
    d.g.b.p.h(paramw, "info");
    d.g.b.p.h(paramView1, "convertView");
    d.g.b.p.h(paramView2, "parent");
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1149L, 2L, 1L, false);
    dD(paramView2);
    paramView2 = paramw.fpl();
    if (paramView2 != null)
    {
      paramView2 = paramView2.HzY;
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
        paramView1 = paramw.fpl();
        paramView2 = this.odV;
        if (paramView2 == null) {
          d.g.b.p.bcb("recCardTitle");
        }
        paramView2.setText((CharSequence)paramView1.GfK);
        paramView2 = this.odU;
        if (paramView2 == null) {
          d.g.b.p.bcb("nickNameTV");
        }
        if (paramView2 == null) {
          d.g.b.p.gfZ();
        }
        paramView2 = paramView2.getPaint();
        d.g.b.p.g(paramView2, "tp");
        paramView2.setFakeBoldText(true);
        paramView2 = this.fOf;
        if (paramView2 == null) {
          d.g.b.p.bcb("avatarIV");
        }
        if (paramView2 == null) {
          d.g.b.p.gfZ();
        }
        localObject1 = paramView1.HzY.FJT;
        d.g.b.p.g(localObject1, "recCard.BizInfo.BrandIconUrl");
        localObject2 = new c.a();
        ((c.a)localObject2).pI(2131231342);
        ((c.a)localObject2).aIZ();
        ((c.a)localObject2).aJa();
        q.aIJ().a((String)localObject1, paramView2, ((c.a)localObject2).aJc());
        paramView2 = this.odU;
        if (paramView2 == null) {
          d.g.b.p.bcb("nickNameTV");
        }
        if (paramView2 == null) {
          d.g.b.p.gfZ();
        }
        paramView2.setText((CharSequence)paramView1.HzY.nEt);
        paramView2 = this.odZ;
        if (paramView2 == null) {
          d.g.b.p.bcb("profileReasonTv");
        }
        paramView2.setText((CharSequence)paramView1.HzY.HAa);
        paramView2 = paramView1.HzY.nDo;
        localObject1 = this.odY;
        if (localObject1 == null) {
          d.g.b.p.bcb("profileLayout");
        }
        ((View)localObject1).setOnClickListener((View.OnClickListener)new p.d(this, paramView2, paramw));
        localObject1 = paramw.fpm();
      } while (localObject1 == null);
      Object localObject2 = paramView1.HzZ;
      int i;
      if (localObject2 == null)
      {
        ad.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
        i = 0;
        if ((i != 0) || (!bt.hj((List)((dlt)localObject1).HAe))) {
          break label681;
        }
        ad.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = " + paramView1.HzY.nEt);
        paramView1 = this.odW;
        if (paramView1 == null) {
          d.g.b.p.bcb("closeLayout");
        }
        paramView1.setVisibility(8);
      }
      for (;;)
      {
        paramw = (d.g.a.a)new p.f(this, paramw, paramView2);
        paramView1 = this.oec;
        if (paramView1 == null) {
          d.g.b.p.bcb("followAlready");
        }
        paramView1.setVisibility(8);
        paramView1 = this.oeb;
        if (paramView1 == null) {
          d.g.b.p.bcb("followType3");
        }
        paramView1.setVisibility(8);
        paramView1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        d.g.b.p.g(paramView1, "MMKernel.service(IMessengerStorage::class.java)");
        paramView1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramView1).azp().Bf(paramView2);
        if ((paramView1 != null) && (paramView1.adt() > 0)) {
          break label764;
        }
        as.a.aBA().a(paramView2, "", null);
        paramw.invoke();
        return;
        if (((dls)localObject2).HAc == null)
        {
          ad.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
          i = 0;
          break;
        }
        if (((dls)localObject2).HAc.FJO != 1)
        {
          ad.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
          i = 0;
          break;
        }
        if (bt.hj((List)((dls)localObject2).HAc.FJN))
        {
          ad.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
          i = 0;
          break;
        }
        i = 1;
        break;
        ad.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = " + paramView1.HzY.nEt);
        paramView1 = this.odW;
        if (paramView1 == null) {
          d.g.b.p.bcb("closeLayout");
        }
        paramView1.setVisibility(0);
        paramView1 = this.odW;
        if (paramView1 == null) {
          d.g.b.p.bcb("closeLayout");
        }
        paramView1.setOnClickListener((View.OnClickListener)new p.e(this, paramw, paramInt));
      }
      if (!paramView1.adh())
      {
        paramw.invoke();
        return;
      }
    } while (!paramView1.adh());
    label681:
    paramw = this.oec;
    if (paramw == null) {
      d.g.b.p.bcb("followAlready");
    }
    paramw.setVisibility(0);
  }
  
  public final void a(w paramw, dlp paramdlp, View paramView, int paramInt)
  {
    d.g.b.p.h(paramw, "info");
    if ((paramdlp != null) && (paramw.fpl() != null))
    {
      localObject1 = paramw.fpl();
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      if (((dlo)localObject1).HzY != null) {}
    }
    else
    {
      ad.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
      return;
    }
    Object localObject1 = paramw.fpl();
    if (localObject1 == null) {
      d.g.b.p.gfZ();
    }
    Object localObject2 = ((dlo)localObject1).HzY;
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1149L, 4L, 1L, false);
    ad.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { paramdlp.FFW });
    Intent localIntent = new Intent();
    localObject1 = m.d(paramdlp.FFW, 138, 10000, 0);
    localIntent.putExtra("rawUrl", (String)localObject1);
    localIntent.putExtra("geta8key_scene", 56);
    localIntent.putExtra("geta8key_username", ((dlq)localObject2).nDo);
    localIntent.putExtra("srcUsername", ((dlq)localObject2).nDo);
    localIntent.putExtra("srcDisplayname", ((dlq)localObject2).nEt);
    localIntent.putExtra("prePublishId", "rec_card");
    localIntent.putExtra("KPublisherId", "rec_card");
    int i;
    int j;
    if (paramdlp.hCZ == 5)
    {
      Object localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
      d.g.b.p.g(localObject3, "MMKernel.service(IBrandService::class.java)");
      if (((com.tencent.mm.plugin.brandservice.a.b)localObject3).bNg())
      {
        localIntent.putExtra(e.b.IUn, 138);
        localIntent.putExtra(e.b.IUo, 10000);
        localIntent.putExtra("biz_video_session_id", y.getSessionId());
        localObject3 = new x();
        ((x)localObject3).hDf = localIntent.getStringExtra("KPublisherId");
        ((x)localObject3).doK = ((dlq)localObject2).nDo;
        ((x)localObject3).hDe = ((dlq)localObject2).nEt;
        ((x)localObject3).hDg.url = ((String)localObject1);
        ((x)localObject3).hDg.title = paramdlp.Title;
        ((x)localObject3).hDg.hDo = paramdlp.FFU;
        ((x)localObject3).hDg.hDm = paramdlp.FFY;
        ((x)localObject3).hDg.type = paramdlp.hCZ;
        ((x)localObject3).hDg.time = paramdlp.CreateTime;
        ((x)localObject3).hDg.hDq = paramdlp.FGk;
        ((x)localObject3).hDg.videoWidth = paramdlp.FGi;
        ((x)localObject3).hDg.videoHeight = paramdlp.FGj;
        ((x)localObject3).hDg.hzm = paramdlp.FGh;
        ((x)localObject3).t(localIntent);
        ad.i("MicroMsg.BizTimeLineItem", "jump to native video");
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
    if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(1)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.context, (String)localObject1, paramdlp.hCZ, 138, 10000, localIntent))) {
      ad.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
    }
    for (;;)
    {
      paramdlp = paramw.fpm();
      if (paramdlp != null)
      {
        j = 0;
        i = j;
      }
      try
      {
        paramView = Uri.parse((String)localObject1);
        i = j;
        j = bt.getInt(paramView.getQueryParameter("idx"), 0);
        i = j;
        l = bt.getLong(paramView.getQueryParameter("mid"), 0L);
        i = j;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          long l = 0L;
        }
      }
      this.obC.oaB.a(paramw.field_talker, l, i, 15, 0, paramdlp.Hki, true, paramInt);
      this.obC.b(paramw, paramInt);
      return;
      com.tencent.mm.bs.d.b(this.context, "webview", ".ui.tools.WebViewUI", localIntent);
    }
  }
  
  public final TextView bOG()
  {
    TextView localTextView = this.odZ;
    if (localTextView == null) {
      d.g.b.p.bcb("profileReasonTv");
    }
    return localTextView;
  }
  
  public final Button bOH()
  {
    Button localButton = this.oeb;
    if (localButton == null) {
      d.g.b.p.bcb("followType3");
    }
    return localButton;
  }
  
  public final TextView bOI()
  {
    TextView localTextView = this.oec;
    if (localTextView == null) {
      d.g.b.p.bcb("followAlready");
    }
    return localTextView;
  }
  
  public abstract void dD(View paramView);
  
  public final void dE(View paramView)
  {
    d.g.b.p.h(paramView, "header");
    Object localObject = paramView.findViewById(2131297008);
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.widget.ImageView");
    }
    this.fOf = ((ImageView)localObject);
    localObject = paramView.findViewById(2131302860);
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.widget.TextView");
    }
    this.odU = ((TextView)localObject);
    localObject = paramView.findViewById(2131297298);
    d.g.b.p.g(localObject, "header.findViewById(R.id.biz_rec_card_title)");
    this.odV = ((TextView)localObject);
    localObject = com.tencent.mm.plugin.brandservice.ui.b.d.osr;
    localObject = this.odV;
    if (localObject == null) {
      d.g.b.p.bcb("recCardTitle");
    }
    com.tencent.mm.plugin.brandservice.ui.b.d.i((TextView)localObject);
    localObject = paramView.findViewById(2131298374);
    d.g.b.p.g(localObject, "header.findViewById(R.id.close_layout)");
    this.odW = ((View)localObject);
    localObject = paramView.findViewById(2131298373);
    d.g.b.p.g(localObject, "header.findViewById(R.id.close_iv)");
    this.odX = ((View)localObject);
    localObject = paramView.findViewById(2131297296);
    d.g.b.p.g(localObject, "header.findViewById(R.id…_rec_card_profile_layout)");
    this.odY = ((View)localObject);
    localObject = paramView.findViewById(2131297297);
    d.g.b.p.g(localObject, "header.findViewById(R.id.biz_rec_card_reason_tv)");
    this.odZ = ((TextView)localObject);
    localObject = paramView.findViewById(2131297294);
    d.g.b.p.g(localObject, "header.findViewById(R.id.biz_rec_card_desc_tv)");
    this.oea = ((MMNeat7extView)localObject);
    localObject = paramView.findViewById(2131302669);
    ((WeImageView)localObject).setVisibility(0);
    d.g.b.p.g(localObject, "header.findViewById<WeIm…sibility = View.VISIBLE }");
    this.oed = ((WeImageView)localObject);
    localObject = paramView.findViewById(2131307162);
    d.g.b.p.g(localObject, "header.findViewById(R.id…_rec_card_follow_already)");
    this.oec = ((TextView)localObject);
    paramView = paramView.findViewById(2131307163);
    d.g.b.p.g(paramView, "header.findViewById(R.id…iz_rec_card_follow_type3)");
    this.oeb = ((Button)paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.p
 * JD-Core Version:    0.7.0.1
 */