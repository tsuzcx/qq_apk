package com.tencent.mm.plugin.brandservice.ui.timeline.a;

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
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.x;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.dat;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.v;
import d.y;
import java.lang.ref.WeakReference;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "addContacListener", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$IListenerImpl;", "avatarIV", "Landroid/widget/ImageView;", "getAvatarIV", "()Landroid/widget/ImageView;", "setAvatarIV", "(Landroid/widget/ImageView;)V", "closeIv", "Landroid/view/View;", "getCloseIv", "()Landroid/view/View;", "setCloseIv", "(Landroid/view/View;)V", "closeLayout", "getCloseLayout", "setCloseLayout", "getContext", "()Landroid/content/Context;", "followAlready", "Landroid/widget/TextView;", "getFollowAlready", "()Landroid/widget/TextView;", "setFollowAlready", "(Landroid/widget/TextView;)V", "followArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getFollowArrow", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setFollowArrow", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "followType3", "Landroid/widget/Button;", "getFollowType3", "()Landroid/widget/Button;", "setFollowType3", "(Landroid/widget/Button;)V", "nickNameTV", "getNickNameTV", "setNickNameTV", "profileDescTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getProfileDescTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setProfileDescTv", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "profileLayout", "getProfileLayout", "setProfileLayout", "profileReasonTv", "getProfileReasonTv", "setProfileReasonTv", "recCardTitle", "getRecCardTitle", "setRecCardTitle", "weakContext", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getWeakContext", "()Ljava/lang/ref/WeakReference;", "attachRound", "", "iv", "brandURL", "", "btnFollow", "username", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "filling", "position", "", "convertView", "parent", "inflate", "inflateHeader", "header", "onAppMsgClick", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "order", "onUnLikeClick", "view", "refreshHeader", "shouldShowNegativeFeedback", "", "recCardUserInfo", "Lcom/tencent/mm/protocal/protobuf/TLRecCardUserInfo;", "viewContactProfile", "talker", "Companion", "IListenerImpl", "plugin-brandservice_release"})
public abstract class g
{
  public static final g.a mZs = new g.a((byte)0);
  final Context context;
  public ImageView frr;
  final WeakReference<Context> lVp;
  final c mXW;
  public TextView mZh;
  public TextView mZi;
  public View mZj;
  public View mZk;
  public View mZl;
  public TextView mZm;
  public MMNeat7extView mZn;
  public Button mZo;
  public TextView mZp;
  public WeImageView mZq;
  private g.b mZr;
  
  public g(Context paramContext, c paramc)
  {
    this.context = paramContext;
    this.mXW = paramc;
    this.lVp = new WeakReference(this.context);
    this.mZr = new g.b(this);
  }
  
  public void a(final s params, final int paramInt, View paramView1, final View paramView2)
  {
    d.g.b.k.h(params, "info");
    d.g.b.k.h(paramView1, "convertView");
    d.g.b.k.h(paramView2, "parent");
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1149L, 2L, 1L, false);
    dy(paramView2);
    paramView2 = params.eJR();
    if (paramView2 != null)
    {
      paramView2 = paramView2.Esm;
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
        d.g.b.k.h(params, "info");
        paramView1 = params.eJR();
        paramView2 = this.mZi;
        if (paramView2 == null) {
          d.g.b.k.aPZ("recCardTitle");
        }
        paramView2.setText((CharSequence)paramView1.Esl);
        paramView2 = this.mZh;
        if (paramView2 == null) {
          d.g.b.k.aPZ("nickNameTV");
        }
        if (paramView2 == null) {
          d.g.b.k.fvU();
        }
        paramView2 = paramView2.getPaint();
        d.g.b.k.g(paramView2, "tp");
        paramView2.setFakeBoldText(true);
        paramView2 = this.frr;
        if (paramView2 == null) {
          d.g.b.k.aPZ("avatarIV");
        }
        if (paramView2 == null) {
          d.g.b.k.fvU();
        }
        localObject1 = paramView1.Esm.Esv;
        d.g.b.k.g(localObject1, "recCard.BizInfo.BrandIconUrl");
        localObject2 = new c.a();
        ((c.a)localObject2).or(2131231342);
        ((c.a)localObject2).ayZ();
        ((c.a)localObject2).aza();
        o.ayJ().a((String)localObject1, paramView2, ((c.a)localObject2).azc());
        paramView2 = this.mZh;
        if (paramView2 == null) {
          d.g.b.k.aPZ("nickNameTV");
        }
        if (paramView2 == null) {
          d.g.b.k.fvU();
        }
        paramView2.setText((CharSequence)paramView1.Esm.mBV);
        paramView2 = this.mZm;
        if (paramView2 == null) {
          d.g.b.k.aPZ("profileReasonTv");
        }
        paramView2.setText((CharSequence)paramView1.Esm.Esu);
        paramView2 = paramView1.Esm.mAQ;
        localObject1 = this.mZl;
        if (localObject1 == null) {
          d.g.b.k.aPZ("profileLayout");
        }
        ((View)localObject1).setOnClickListener((View.OnClickListener)new d(this, paramView2, params));
        localObject1 = params.eJS();
      } while (localObject1 == null);
      Object localObject2 = paramView1.Esr;
      int i;
      if (localObject2 == null)
      {
        ad.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
        i = 0;
        if ((i != 0) || (!bt.gL((List)((dau)localObject1).EsB))) {
          break label681;
        }
        ad.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = " + paramView1.Esm.mBV);
        paramView1 = this.mZj;
        if (paramView1 == null) {
          d.g.b.k.aPZ("closeLayout");
        }
        paramView1.setVisibility(8);
      }
      for (;;)
      {
        params = (d.g.a.a)new f(this, params, paramView2);
        paramView1 = this.mZp;
        if (paramView1 == null) {
          d.g.b.k.aPZ("followAlready");
        }
        paramView1.setVisibility(8);
        paramView1 = this.mZo;
        if (paramView1 == null) {
          d.g.b.k.aPZ("followType3");
        }
        paramView1.setVisibility(8);
        paramView1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        d.g.b.k.g(paramView1, "MMKernel.service(IMessengerStorage::class.java)");
        paramView1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramView1).apM().aHY(paramView2);
        if ((paramView1 != null) && (paramView1.ZV() > 0)) {
          break label764;
        }
        ar.a.arF().a(paramView2, "", null);
        params.invoke();
        return;
        if (((dat)localObject2).Esy == null)
        {
          ad.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
          i = 0;
          break;
        }
        if (((dat)localObject2).Esy.Dka != 1)
        {
          ad.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
          i = 0;
          break;
        }
        if (bt.gL((List)((dat)localObject2).Esy.DjZ))
        {
          ad.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
          i = 0;
          break;
        }
        i = 1;
        break;
        ad.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = " + paramView1.Esm.mBV);
        paramView1 = this.mZj;
        if (paramView1 == null) {
          d.g.b.k.aPZ("closeLayout");
        }
        paramView1.setVisibility(0);
        paramView1 = this.mZj;
        if (paramView1 == null) {
          d.g.b.k.aPZ("closeLayout");
        }
        paramView1.setOnClickListener((View.OnClickListener)new e(this, params, paramInt));
      }
      if (!paramView1.ZJ())
      {
        params.invoke();
        return;
      }
    } while (!paramView1.ZJ());
    label681:
    params = this.mZp;
    if (params == null) {
      d.g.b.k.aPZ("followAlready");
    }
    params.setVisibility(0);
  }
  
  public final void a(s params, daq paramdaq, View paramView, int paramInt)
  {
    d.g.b.k.h(params, "info");
    if ((paramdaq != null) && (params.eJR() != null))
    {
      localObject1 = params.eJR();
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      if (((dap)localObject1).Esm != null) {}
    }
    else
    {
      ad.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
      return;
    }
    Object localObject1 = params.eJR();
    if (localObject1 == null) {
      d.g.b.k.fvU();
    }
    Object localObject2 = ((dap)localObject1).Esm;
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1149L, 4L, 1L, false);
    ad.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { paramdaq.CHL });
    Intent localIntent = new Intent();
    localObject1 = m.d(paramdaq.CHL, 138, 10000, 0);
    localIntent.putExtra("rawUrl", (String)localObject1);
    localIntent.putExtra("geta8key_scene", 56);
    localIntent.putExtra("geta8key_username", ((dar)localObject2).mAQ);
    localIntent.putExtra("srcUsername", ((dar)localObject2).mAQ);
    localIntent.putExtra("srcDisplayname", ((dar)localObject2).mBV);
    localIntent.putExtra("prePublishId", "rec_card");
    localIntent.putExtra("KPublisherId", "rec_card");
    int i;
    int j;
    if (paramdaq.gKq == 5)
    {
      Object localObject3 = com.tencent.mm.kernel.g.ab(b.class);
      d.g.b.k.g(localObject3, "MMKernel.service(IBrandService::class.java)");
      if (((b)localObject3).bBR())
      {
        localIntent.putExtra(e.b.FHP, 138);
        localIntent.putExtra(e.b.FHQ, 10000);
        localIntent.putExtra("biz_video_session_id", u.getSessionId());
        localObject3 = new x();
        ((x)localObject3).gKw = localIntent.getStringExtra("KPublisherId");
        ((x)localObject3).dfT = ((dar)localObject2).mAQ;
        ((x)localObject3).gKv = ((dar)localObject2).mBV;
        ((x)localObject3).gKx.url = ((String)localObject1);
        ((x)localObject3).gKx.title = paramdaq.Title;
        ((x)localObject3).gKx.gKF = paramdaq.CHJ;
        ((x)localObject3).gKx.gKD = paramdaq.CHN;
        ((x)localObject3).gKx.type = paramdaq.gKq;
        ((x)localObject3).gKx.time = paramdaq.CreateTime;
        ((x)localObject3).gKx.gKH = paramdaq.CHZ;
        ((x)localObject3).gKx.videoWidth = paramdaq.CHX;
        ((x)localObject3).gKx.videoHeight = paramdaq.CHY;
        ((x)localObject3).gKx.gGC = paramdaq.CHW;
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
    if ((((b)com.tencent.mm.kernel.g.ab(b.class)).xA(1)) && (((b)com.tencent.mm.kernel.g.ab(b.class)).a(this.context, (String)localObject1, paramdaq.gKq, 138, 10000, localIntent))) {
      ad.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
    }
    for (;;)
    {
      paramdaq = params.eJS();
      if (paramdaq == null) {
        break;
      }
      j = 0;
      i = j;
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
      this.mXW.mWX.a(params.field_talker, l, i, 15, 0, paramdaq.EsA, true, paramInt);
      return;
      com.tencent.mm.bs.d.b(this.context, "webview", ".ui.tools.WebViewUI", localIntent);
    }
  }
  
  public final Button bCX()
  {
    Button localButton = this.mZo;
    if (localButton == null) {
      d.g.b.k.aPZ("followType3");
    }
    return localButton;
  }
  
  public final TextView bCY()
  {
    TextView localTextView = this.mZp;
    if (localTextView == null) {
      d.g.b.k.aPZ("followAlready");
    }
    return localTextView;
  }
  
  public abstract void dy(View paramView);
  
  public final void dz(View paramView)
  {
    d.g.b.k.h(paramView, "header");
    Object localObject = paramView.findViewById(2131297008);
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.widget.ImageView");
    }
    this.frr = ((ImageView)localObject);
    localObject = paramView.findViewById(2131302860);
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.widget.TextView");
    }
    this.mZh = ((TextView)localObject);
    localObject = paramView.findViewById(2131297298);
    d.g.b.k.g(localObject, "header.findViewById(R.id.biz_rec_card_title)");
    this.mZi = ((TextView)localObject);
    localObject = com.tencent.mm.plugin.brandservice.ui.b.d.nmK;
    localObject = this.mZi;
    if (localObject == null) {
      d.g.b.k.aPZ("recCardTitle");
    }
    com.tencent.mm.plugin.brandservice.ui.b.d.i((TextView)localObject);
    localObject = paramView.findViewById(2131298374);
    d.g.b.k.g(localObject, "header.findViewById(R.id.close_layout)");
    this.mZj = ((View)localObject);
    localObject = paramView.findViewById(2131298373);
    d.g.b.k.g(localObject, "header.findViewById(R.id.close_iv)");
    this.mZk = ((View)localObject);
    localObject = paramView.findViewById(2131297296);
    d.g.b.k.g(localObject, "header.findViewById(R.id…_rec_card_profile_layout)");
    this.mZl = ((View)localObject);
    localObject = paramView.findViewById(2131297297);
    d.g.b.k.g(localObject, "header.findViewById(R.id.biz_rec_card_reason_tv)");
    this.mZm = ((TextView)localObject);
    localObject = paramView.findViewById(2131297294);
    d.g.b.k.g(localObject, "header.findViewById(R.id.biz_rec_card_desc_tv)");
    this.mZn = ((MMNeat7extView)localObject);
    localObject = paramView.findViewById(2131302669);
    ((WeImageView)localObject).setVisibility(8);
    d.g.b.k.g(localObject, "header.findViewById<WeIm… visibility = View.GONE }");
    this.mZq = ((WeImageView)localObject);
    localObject = paramView.findViewById(2131307162);
    d.g.b.k.g(localObject, "header.findViewById(R.id…_rec_card_follow_already)");
    this.mZp = ((TextView)localObject);
    paramView = paramView.findViewById(2131307163);
    d.g.b.k.g(paramView, "header.findViewById(R.id…iz_rec_card_follow_type3)");
    this.mZo = ((Button)paramView);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(g paramg, String paramString, s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(193063);
      paramView = this.mZu;
      String str = paramView2;
      d.g.b.k.g(str, "username");
      g.a(paramView, str, params);
      AppMethodBeat.o(193063);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(g paramg, s params, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(193064);
      paramView = this.mZu;
      View localView = this.mZu.mZk;
      if (localView == null) {
        d.g.b.k.aPZ("closeIv");
      }
      g.a(paramView, localView, params, paramInt);
      AppMethodBeat.o(193064);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<no name provided>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(g paramg, s params, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.g
 * JD-Core Version:    0.7.0.1
 */