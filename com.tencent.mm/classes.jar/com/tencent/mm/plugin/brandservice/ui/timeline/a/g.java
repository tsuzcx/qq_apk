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
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.x;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dgd;
import com.tencent.mm.protocal.protobuf.dgf;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.y;
import java.lang.ref.WeakReference;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "addContacListener", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$IListenerImpl;", "avatarIV", "Landroid/widget/ImageView;", "getAvatarIV", "()Landroid/widget/ImageView;", "setAvatarIV", "(Landroid/widget/ImageView;)V", "closeIv", "Landroid/view/View;", "getCloseIv", "()Landroid/view/View;", "setCloseIv", "(Landroid/view/View;)V", "closeLayout", "getCloseLayout", "setCloseLayout", "getContext", "()Landroid/content/Context;", "followAlready", "Landroid/widget/TextView;", "getFollowAlready", "()Landroid/widget/TextView;", "setFollowAlready", "(Landroid/widget/TextView;)V", "followArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getFollowArrow", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setFollowArrow", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "followType3", "Landroid/widget/Button;", "getFollowType3", "()Landroid/widget/Button;", "setFollowType3", "(Landroid/widget/Button;)V", "nickNameTV", "getNickNameTV", "setNickNameTV", "profileDescTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getProfileDescTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setProfileDescTv", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "profileLayout", "getProfileLayout", "setProfileLayout", "profileReasonTv", "getProfileReasonTv", "setProfileReasonTv", "recCardTitle", "getRecCardTitle", "setRecCardTitle", "weakContext", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getWeakContext", "()Ljava/lang/ref/WeakReference;", "attachRound", "", "iv", "brandURL", "", "btnFollow", "username", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "filling", "position", "", "convertView", "parent", "inflate", "inflateHeader", "header", "onAppMsgClick", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "order", "onUnLikeClick", "view", "refreshHeader", "shouldShowNegativeFeedback", "", "recCardUserInfo", "Lcom/tencent/mm/protocal/protobuf/TLRecCardUserInfo;", "viewContactProfile", "talker", "Companion", "IListenerImpl", "plugin-brandservice_release"})
public abstract class g
{
  public static final g.a nBQ = new g.a((byte)0);
  final Context context;
  public ImageView fuY;
  final WeakReference<Context> mxr;
  final com.tencent.mm.plugin.brandservice.ui.timeline.c nAv;
  public TextView nBF;
  public TextView nBG;
  public View nBH;
  public View nBI;
  public View nBJ;
  public TextView nBK;
  public MMNeat7extView nBL;
  public Button nBM;
  public TextView nBN;
  public WeImageView nBO;
  private b nBP;
  
  public g(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.c paramc)
  {
    this.context = paramContext;
    this.nAv = paramc;
    this.mxr = new WeakReference(this.context);
    this.nBP = new b(this);
  }
  
  public void a(final t paramt, final int paramInt, View paramView1, final View paramView2)
  {
    d.g.b.k.h(paramt, "info");
    d.g.b.k.h(paramView1, "convertView");
    d.g.b.k.h(paramView2, "parent");
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1149L, 2L, 1L, false);
    dA(paramView2);
    paramView2 = paramt.eZp();
    if (paramView2 != null)
    {
      paramView2 = paramView2.FPo;
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
        d.g.b.k.h(paramt, "info");
        paramView1 = paramt.eZp();
        paramView2 = this.nBG;
        if (paramView2 == null) {
          d.g.b.k.aVY("recCardTitle");
        }
        paramView2.setText((CharSequence)paramView1.FPn);
        paramView2 = this.nBF;
        if (paramView2 == null) {
          d.g.b.k.aVY("nickNameTV");
        }
        if (paramView2 == null) {
          d.g.b.k.fOy();
        }
        paramView2 = paramView2.getPaint();
        d.g.b.k.g(paramView2, "tp");
        paramView2.setFakeBoldText(true);
        paramView2 = this.fuY;
        if (paramView2 == null) {
          d.g.b.k.aVY("avatarIV");
        }
        if (paramView2 == null) {
          d.g.b.k.fOy();
        }
        localObject1 = paramView1.FPo.FPx;
        d.g.b.k.g(localObject1, "recCard.BizInfo.BrandIconUrl");
        localObject2 = new c.a();
        ((c.a)localObject2).pf(2131231342);
        ((c.a)localObject2).aFQ();
        ((c.a)localObject2).aFR();
        o.aFB().a((String)localObject1, paramView2, ((c.a)localObject2).aFT());
        paramView2 = this.nBF;
        if (paramView2 == null) {
          d.g.b.k.aVY("nickNameTV");
        }
        if (paramView2 == null) {
          d.g.b.k.fOy();
        }
        paramView2.setText((CharSequence)paramView1.FPo.ndW);
        paramView2 = this.nBK;
        if (paramView2 == null) {
          d.g.b.k.aVY("profileReasonTv");
        }
        paramView2.setText((CharSequence)paramView1.FPo.FPw);
        paramView2 = paramView1.FPo.ncR;
        localObject1 = this.nBJ;
        if (localObject1 == null) {
          d.g.b.k.aVY("profileLayout");
        }
        ((View)localObject1).setOnClickListener((View.OnClickListener)new d(this, paramView2, paramt));
        localObject1 = paramt.eZq();
      } while (localObject1 == null);
      Object localObject2 = paramView1.FPt;
      int i;
      if (localObject2 == null)
      {
        ac.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
        i = 0;
        if ((i != 0) || (!bs.gY((List)((dgg)localObject1).FPD))) {
          break label681;
        }
        ac.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = " + paramView1.FPo.ndW);
        paramView1 = this.nBH;
        if (paramView1 == null) {
          d.g.b.k.aVY("closeLayout");
        }
        paramView1.setVisibility(8);
      }
      for (;;)
      {
        paramt = (d.g.a.a)new f(this, paramt, paramView2);
        paramView1 = this.nBN;
        if (paramView1 == null) {
          d.g.b.k.aVY("followAlready");
        }
        paramView1.setVisibility(8);
        paramView1 = this.nBM;
        if (paramView1 == null) {
          d.g.b.k.aVY("followType3");
        }
        paramView1.setVisibility(8);
        paramView1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        d.g.b.k.g(paramView1, "MMKernel.service(IMessengerStorage::class.java)");
        paramView1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramView1).awB().aNt(paramView2);
        if ((paramView1 != null) && (paramView1.aaQ() > 0)) {
          break label764;
        }
        ar.a.ayw().a(paramView2, "", null);
        paramt.invoke();
        return;
        if (((dgf)localObject2).FPA == null)
        {
          ac.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
          i = 0;
          break;
        }
        if (((dgf)localObject2).FPA.EDg != 1)
        {
          ac.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
          i = 0;
          break;
        }
        if (bs.gY((List)((dgf)localObject2).FPA.EDf))
        {
          ac.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
          i = 0;
          break;
        }
        i = 1;
        break;
        ac.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = " + paramView1.FPo.ndW);
        paramView1 = this.nBH;
        if (paramView1 == null) {
          d.g.b.k.aVY("closeLayout");
        }
        paramView1.setVisibility(0);
        paramView1 = this.nBH;
        if (paramView1 == null) {
          d.g.b.k.aVY("closeLayout");
        }
        paramView1.setOnClickListener((View.OnClickListener)new e(this, paramt, paramInt));
      }
      if (!paramView1.aaE())
      {
        paramt.invoke();
        return;
      }
    } while (!paramView1.aaE());
    label681:
    paramt = this.nBN;
    if (paramt == null) {
      d.g.b.k.aVY("followAlready");
    }
    paramt.setVisibility(0);
  }
  
  public final void a(t paramt, dgc paramdgc, View paramView, int paramInt)
  {
    d.g.b.k.h(paramt, "info");
    if ((paramdgc != null) && (paramt.eZp() != null))
    {
      localObject1 = paramt.eZp();
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      if (((dgb)localObject1).FPo != null) {}
    }
    else
    {
      ac.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
      return;
    }
    Object localObject1 = paramt.eZp();
    if (localObject1 == null) {
      d.g.b.k.fOy();
    }
    Object localObject2 = ((dgb)localObject1).FPo;
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1149L, 4L, 1L, false);
    ac.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { paramdgc.Ean });
    Intent localIntent = new Intent();
    localObject1 = m.d(paramdgc.Ean, 138, 10000, 0);
    localIntent.putExtra("rawUrl", (String)localObject1);
    localIntent.putExtra("geta8key_scene", 56);
    localIntent.putExtra("geta8key_username", ((dgd)localObject2).ncR);
    localIntent.putExtra("srcUsername", ((dgd)localObject2).ncR);
    localIntent.putExtra("srcDisplayname", ((dgd)localObject2).ndW);
    localIntent.putExtra("prePublishId", "rec_card");
    localIntent.putExtra("KPublisherId", "rec_card");
    int i;
    int j;
    if (paramdgc.hkQ == 5)
    {
      Object localObject3 = com.tencent.mm.kernel.g.ab(b.class);
      d.g.b.k.g(localObject3, "MMKernel.service(IBrandService::class.java)");
      if (((b)localObject3).bIP())
      {
        localIntent.putExtra(e.b.HgX, 138);
        localIntent.putExtra(e.b.HgY, 10000);
        localIntent.putExtra("biz_video_session_id", com.tencent.mm.storage.v.getSessionId());
        localObject3 = new x();
        ((x)localObject3).hkW = localIntent.getStringExtra("KPublisherId");
        ((x)localObject3).ddo = ((dgd)localObject2).ncR;
        ((x)localObject3).hkV = ((dgd)localObject2).ndW;
        ((x)localObject3).hkX.url = ((String)localObject1);
        ((x)localObject3).hkX.title = paramdgc.Title;
        ((x)localObject3).hkX.hlf = paramdgc.Eal;
        ((x)localObject3).hkX.hld = paramdgc.Eap;
        ((x)localObject3).hkX.type = paramdgc.hkQ;
        ((x)localObject3).hkX.time = paramdgc.CreateTime;
        ((x)localObject3).hkX.hlh = paramdgc.EaB;
        ((x)localObject3).hkX.videoWidth = paramdgc.Eaz;
        ((x)localObject3).hkX.videoHeight = paramdgc.EaA;
        ((x)localObject3).hkX.hhd = paramdgc.Eay;
        ((x)localObject3).t(localIntent);
        ac.i("MicroMsg.BizTimeLineItem", "jump to native video");
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
    if ((((b)com.tencent.mm.kernel.g.ab(b.class)).ys(1)) && (((b)com.tencent.mm.kernel.g.ab(b.class)).a(this.context, (String)localObject1, paramdgc.hkQ, 138, 10000, localIntent))) {
      ac.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
    }
    for (;;)
    {
      paramdgc = paramt.eZq();
      if (paramdgc != null)
      {
        j = 0;
        i = j;
      }
      try
      {
        paramView = Uri.parse((String)localObject1);
        i = j;
        j = bs.getInt(paramView.getQueryParameter("idx"), 0);
        i = j;
        l = bs.getLong(paramView.getQueryParameter("mid"), 0L);
        i = j;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          long l = 0L;
        }
      }
      this.nAv.nzw.a(paramt.field_talker, l, i, 15, 0, paramdgc.FPC, true, paramInt);
      this.nAv.b(paramt, paramInt);
      return;
      com.tencent.mm.br.d.b(this.context, "webview", ".ui.tools.WebViewUI", localIntent);
    }
  }
  
  public final TextView bKf()
  {
    TextView localTextView = this.nBK;
    if (localTextView == null) {
      d.g.b.k.aVY("profileReasonTv");
    }
    return localTextView;
  }
  
  public final Button bKg()
  {
    Button localButton = this.nBM;
    if (localButton == null) {
      d.g.b.k.aVY("followType3");
    }
    return localButton;
  }
  
  public final TextView bKh()
  {
    TextView localTextView = this.nBN;
    if (localTextView == null) {
      d.g.b.k.aVY("followAlready");
    }
    return localTextView;
  }
  
  public abstract void dA(View paramView);
  
  public final void dB(View paramView)
  {
    d.g.b.k.h(paramView, "header");
    Object localObject = paramView.findViewById(2131297008);
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type android.widget.ImageView");
    }
    this.fuY = ((ImageView)localObject);
    localObject = paramView.findViewById(2131302860);
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type android.widget.TextView");
    }
    this.nBF = ((TextView)localObject);
    localObject = paramView.findViewById(2131297298);
    d.g.b.k.g(localObject, "header.findViewById(R.id.biz_rec_card_title)");
    this.nBG = ((TextView)localObject);
    localObject = com.tencent.mm.plugin.brandservice.ui.b.d.nPK;
    localObject = this.nBG;
    if (localObject == null) {
      d.g.b.k.aVY("recCardTitle");
    }
    com.tencent.mm.plugin.brandservice.ui.b.d.i((TextView)localObject);
    localObject = paramView.findViewById(2131298374);
    d.g.b.k.g(localObject, "header.findViewById(R.id.close_layout)");
    this.nBH = ((View)localObject);
    localObject = paramView.findViewById(2131298373);
    d.g.b.k.g(localObject, "header.findViewById(R.id.close_iv)");
    this.nBI = ((View)localObject);
    localObject = paramView.findViewById(2131297296);
    d.g.b.k.g(localObject, "header.findViewById(R.id…_rec_card_profile_layout)");
    this.nBJ = ((View)localObject);
    localObject = paramView.findViewById(2131297297);
    d.g.b.k.g(localObject, "header.findViewById(R.id.biz_rec_card_reason_tv)");
    this.nBK = ((TextView)localObject);
    localObject = paramView.findViewById(2131297294);
    d.g.b.k.g(localObject, "header.findViewById(R.id.biz_rec_card_desc_tv)");
    this.nBL = ((MMNeat7extView)localObject);
    localObject = paramView.findViewById(2131302669);
    ((WeImageView)localObject).setVisibility(0);
    d.g.b.k.g(localObject, "header.findViewById<WeIm…sibility = View.VISIBLE }");
    this.nBO = ((WeImageView)localObject);
    localObject = paramView.findViewById(2131307162);
    d.g.b.k.g(localObject, "header.findViewById(R.id…_rec_card_follow_already)");
    this.nBN = ((TextView)localObject);
    paramView = paramView.findViewById(2131307163);
    d.g.b.k.g(paramView, "header.findViewById(R.id…iz_rec_card_follow_type3)");
    this.nBM = ((Button)paramView);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$IListenerImpl;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ModNewContactEvent;", "ref", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;)V", "value", "", "username", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "weakRef", "Ljava/lang/ref/WeakReference;", "callback", "", "event", "plugin-brandservice_release"})
  static final class b
    extends com.tencent.mm.sdk.b.c<lp>
  {
    private final WeakReference<g> nBR;
    private String username;
    
    public b(g paramg)
    {
      AppMethodBeat.i(198855);
      this.nBR = new WeakReference(paramg);
      this.username = "";
      AppMethodBeat.o(198855);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "ok", "", "hasSentVerify", "respUsername", "", "googleItemID", "canAddContact"})
  static final class c
    implements a.a
  {
    c(g paramg) {}
    
    public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(198856);
      d.g.b.k.h(paramString1, "respUsername");
      d.g.b.k.h(paramString2, "googleItemID");
      if ((paramBoolean1) && (this.nBS.mxr != null) && (this.nBS.mxr.get() != null))
      {
        this.nBS.bKh().setVisibility(0);
        this.nBS.bKg().setVisibility(8);
      }
      AppMethodBeat.o(198856);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(g paramg, String paramString, t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198857);
      paramView = this.nBS;
      String str = paramView2;
      d.g.b.k.g(str, "username");
      g.a(paramView, str, paramt);
      AppMethodBeat.o(198857);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(g paramg, t paramt, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198858);
      paramView = this.nBS;
      View localView = this.nBS.nBI;
      if (localView == null) {
        d.g.b.k.aVY("closeIv");
      }
      g.a(paramView, localView, paramt, paramInt);
      AppMethodBeat.o(198858);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<no name provided>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(g paramg, t paramt, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.g
 * JD-Core Version:    0.7.0.1
 */