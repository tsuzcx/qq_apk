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
import com.tencent.mm.ag.m;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.egd;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "addContacListener", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$IListenerImpl;", "avatarIV", "Landroid/widget/ImageView;", "getAvatarIV", "()Landroid/widget/ImageView;", "setAvatarIV", "(Landroid/widget/ImageView;)V", "closeIv", "Landroid/view/View;", "getCloseIv", "()Landroid/view/View;", "setCloseIv", "(Landroid/view/View;)V", "closeLayout", "getCloseLayout", "setCloseLayout", "getContext", "()Landroid/content/Context;", "followAlready", "Landroid/widget/TextView;", "getFollowAlready", "()Landroid/widget/TextView;", "setFollowAlready", "(Landroid/widget/TextView;)V", "followArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getFollowArrow", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setFollowArrow", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "followType3", "Landroid/widget/Button;", "getFollowType3", "()Landroid/widget/Button;", "setFollowType3", "(Landroid/widget/Button;)V", "nickNameTV", "getNickNameTV", "setNickNameTV", "profileDescTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getProfileDescTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setProfileDescTv", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "profileLayout", "getProfileLayout", "setProfileLayout", "profileReasonTv", "getProfileReasonTv", "setProfileReasonTv", "recCardTitle", "getRecCardTitle", "setRecCardTitle", "weakContext", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getWeakContext", "()Ljava/lang/ref/WeakReference;", "attachRound", "", "iv", "brandURL", "", "btnFollow", "username", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "filling", "position", "", "convertView", "parent", "inflate", "inflateHeader", "header", "onAppMsgClick", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "order", "onUnLikeClick", "view", "refreshHeader", "shouldShowNegativeFeedback", "", "recCardUserInfo", "Lcom/tencent/mm/protocal/protobuf/TLRecCardUserInfo;", "viewContactProfile", "talker", "Companion", "IListenerImpl", "plugin-brandservice_release"})
public abstract class w
  extends ad
{
  public static final w.a pvR = new w.a((byte)0);
  final Context context;
  public ImageView gvv;
  final WeakReference<Context> ooi;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
  public TextView pvG;
  public TextView pvH;
  public View pvI;
  public View pvJ;
  public View pvK;
  public TextView pvL;
  public MMNeat7extView pvM;
  public Button pvN;
  public TextView pvO;
  public WeImageView pvP;
  private w.b pvQ;
  
  public w(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.context = paramContext;
    this.psQ = paramb;
    this.ooi = new WeakReference(this.context);
    this.pvQ = new w.b(this);
  }
  
  public void a(final z paramz, final int paramInt, View paramView1, final View paramView2)
  {
    p.h(paramz, "info");
    p.h(paramView1, "convertView");
    p.h(paramView2, "parent");
    h.CyF.idkeyStat(1149L, 2L, 1L, false);
    du(paramView2);
    paramView2 = paramz.gAC();
    if (paramView2 != null)
    {
      paramView2 = paramView2.NfT;
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
        p.h(paramz, "info");
        paramView1 = paramz.gAC();
        paramView2 = this.pvH;
        if (paramView2 == null) {
          p.btv("recCardTitle");
        }
        paramView2.setText((CharSequence)paramView1.Lug);
        paramView2 = this.pvG;
        if (paramView2 == null) {
          p.btv("nickNameTV");
        }
        if (paramView2 == null) {
          p.hyc();
        }
        paramView2 = paramView2.getPaint();
        p.g(paramView2, "tp");
        paramView2.setFakeBoldText(true);
        paramView2 = this.gvv;
        if (paramView2 == null) {
          p.btv("avatarIV");
        }
        if (paramView2 == null) {
          p.hyc();
        }
        localObject1 = paramView1.NfT.KQY;
        p.g(localObject1, "recCard.BizInfo.BrandIconUrl");
        localObject2 = new c.a();
        ((c.a)localObject2).tz(2131231405);
        ((c.a)localObject2).bdq();
        ((c.a)localObject2).bdt();
        com.tencent.mm.av.q.bcV().a((String)localObject1, paramView2, ((c.a)localObject2).bdv());
        paramView2 = this.pvG;
        if (paramView2 == null) {
          p.btv("nickNameTV");
        }
        if (paramView2 == null) {
          p.hyc();
        }
        paramView2.setText((CharSequence)paramView1.NfT.oUJ);
        paramView2 = this.pvL;
        if (paramView2 == null) {
          p.btv("profileReasonTv");
        }
        paramView2.setText((CharSequence)paramView1.NfT.NfV);
        paramView2 = paramView1.NfT.UserName;
        localObject1 = this.pvK;
        if (localObject1 == null) {
          p.btv("profileLayout");
        }
        ((View)localObject1).setOnClickListener((View.OnClickListener)new d(this, paramView2, paramz));
        localObject1 = paramz.gAD();
      } while (localObject1 == null);
      Object localObject2 = paramView1.NfU;
      int i;
      if (localObject2 == null)
      {
        Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
        i = 0;
        if ((i != 0) || (!Util.isNullOrNil((List)((ege)localObject1).NfZ))) {
          break label681;
        }
        Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = " + paramView1.NfT.oUJ);
        paramView1 = this.pvI;
        if (paramView1 == null) {
          p.btv("closeLayout");
        }
        paramView1.setVisibility(8);
      }
      for (;;)
      {
        paramz = (kotlin.g.a.a)new f(this, paramz, paramView2);
        paramView1 = this.pvO;
        if (paramView1 == null) {
          p.btv("followAlready");
        }
        paramView1.setVisibility(8);
        paramView1 = this.pvN;
        if (paramView1 == null) {
          p.btv("followType3");
        }
        paramView1.setVisibility(8);
        paramView1 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(paramView1, "MMKernel.service(IMessengerStorage::class.java)");
        paramView1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramView1).aSN().Kn(paramView2);
        if ((paramView1 != null) && (paramView1.arH() > 0)) {
          break label764;
        }
        ay.a.aVo().a(paramView2, "", null);
        paramz.invoke();
        return;
        if (((egd)localObject2).NfX == null)
        {
          Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
          i = 0;
          break;
        }
        if (((egd)localObject2).NfX.KWs != 1)
        {
          Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
          i = 0;
          break;
        }
        if (Util.isNullOrNil((List)((egd)localObject2).NfX.KWr))
        {
          Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
          i = 0;
          break;
        }
        i = 1;
        break;
        Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = " + paramView1.NfT.oUJ);
        paramView1 = this.pvI;
        if (paramView1 == null) {
          p.btv("closeLayout");
        }
        paramView1.setVisibility(0);
        paramView1 = this.pvI;
        if (paramView1 == null) {
          p.btv("closeLayout");
        }
        paramView1.setOnClickListener((View.OnClickListener)new e(this, paramz, paramInt));
      }
      if (!paramView1.arv())
      {
        paramz.invoke();
        return;
      }
    } while (!paramView1.arv());
    label681:
    paramz = this.pvO;
    if (paramz == null) {
      p.btv("followAlready");
    }
    paramz.setVisibility(0);
  }
  
  public final void a(z paramz, ega paramega, View paramView, int paramInt)
  {
    p.h(paramz, "info");
    if ((paramega != null) && (paramz.gAC() != null))
    {
      localObject1 = paramz.gAC();
      if (localObject1 == null) {
        p.hyc();
      }
      if (((efz)localObject1).NfT != null) {}
    }
    else
    {
      Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
      return;
    }
    Object localObject1 = paramz.gAC();
    if (localObject1 == null) {
      p.hyc();
    }
    Object localObject2 = ((efz)localObject1).NfT;
    h.CyF.idkeyStat(1149L, 4L, 1L, false);
    Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { paramega.KSj });
    Intent localIntent = new Intent();
    localObject1 = m.d(paramega.KSj, 138, 10000, 0);
    localIntent.putExtra("rawUrl", (String)localObject1);
    localIntent.putExtra("geta8key_scene", 56);
    localIntent.putExtra("geta8key_username", ((egb)localObject2).UserName);
    localIntent.putExtra("srcUsername", ((egb)localObject2).UserName);
    localIntent.putExtra("srcDisplayname", ((egb)localObject2).oUJ);
    localIntent.putExtra("prePublishId", "rec_card");
    localIntent.putExtra("KPublisherId", "rec_card");
    int i;
    int j;
    if (paramega.iAb == 5)
    {
      Object localObject3 = g.af(com.tencent.mm.plugin.brandservice.a.b.class);
      p.g(localObject3, "MMKernel.service(IBrandService::class.java)");
      if (((com.tencent.mm.plugin.brandservice.a.b)localObject3).cld())
      {
        localIntent.putExtra(e.b.OyQ, 138);
        localIntent.putExtra(e.b.OyR, 10000);
        localIntent.putExtra("biz_video_session_id", ab.getSessionId());
        localObject3 = new com.tencent.mm.ag.x();
        ((com.tencent.mm.ag.x)localObject3).iAh = localIntent.getStringExtra("KPublisherId");
        ((com.tencent.mm.ag.x)localObject3).dHc = ((egb)localObject2).UserName;
        ((com.tencent.mm.ag.x)localObject3).iAg = ((egb)localObject2).oUJ;
        ((com.tencent.mm.ag.x)localObject3).iAi.url = ((String)localObject1);
        ((com.tencent.mm.ag.x)localObject3).iAi.title = paramega.Title;
        ((com.tencent.mm.ag.x)localObject3).iAi.iAq = paramega.KSh;
        ((com.tencent.mm.ag.x)localObject3).iAi.iAo = paramega.KSl;
        ((com.tencent.mm.ag.x)localObject3).iAi.type = paramega.iAb;
        ((com.tencent.mm.ag.x)localObject3).iAi.time = paramega.CreateTime;
        ((com.tencent.mm.ag.x)localObject3).iAi.iAs = paramega.KSx;
        ((com.tencent.mm.ag.x)localObject3).iAi.videoWidth = paramega.KSv;
        ((com.tencent.mm.ag.x)localObject3).iAi.videoHeight = paramega.KSw;
        ((com.tencent.mm.ag.x)localObject3).iAi.vid = paramega.KSu;
        ((com.tencent.mm.ag.x)localObject3).t(localIntent);
        Log.i("MicroMsg.BizTimeLineItem", "jump to native video");
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
    if ((((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) && (((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.context, (String)localObject1, paramega.iAb, 138, 10000, localIntent))) {
      Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
    }
    for (;;)
    {
      paramega = paramz.gAD();
      if (paramega != null)
      {
        j = 0;
        i = j;
      }
      try
      {
        paramView = Uri.parse((String)localObject1);
        i = j;
        j = Util.getInt(paramView.getQueryParameter("idx"), 0);
        i = j;
        l = Util.getLong(paramView.getQueryParameter("mid"), 0L);
        i = j;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          long l = 0L;
        }
      }
      this.psQ.pqZ.a(paramz.field_talker, l, i, 15, 0, paramega.MOC, true, paramInt);
      this.psQ.b(paramz, paramInt);
      return;
      c.b(this.context, "webview", ".ui.tools.WebViewUI", localIntent);
    }
  }
  
  public final TextView cmX()
  {
    TextView localTextView = this.pvL;
    if (localTextView == null) {
      p.btv("profileReasonTv");
    }
    return localTextView;
  }
  
  public final Button cmY()
  {
    Button localButton = this.pvN;
    if (localButton == null) {
      p.btv("followType3");
    }
    return localButton;
  }
  
  public final TextView cmZ()
  {
    TextView localTextView = this.pvO;
    if (localTextView == null) {
      p.btv("followAlready");
    }
    return localTextView;
  }
  
  public abstract void du(View paramView);
  
  public final void dv(View paramView)
  {
    p.h(paramView, "header");
    Object localObject = paramView.findViewById(2131297134);
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.widget.ImageView");
    }
    this.gvv = ((ImageView)localObject);
    localObject = paramView.findViewById(2131305433);
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.widget.TextView");
    }
    this.pvG = ((TextView)localObject);
    localObject = paramView.findViewById(2131297500);
    p.g(localObject, "header.findViewById(R.id.biz_rec_card_title)");
    this.pvH = ((TextView)localObject);
    localObject = d.pMy;
    localObject = this.pvH;
    if (localObject == null) {
      p.btv("recCardTitle");
    }
    d.i((TextView)localObject);
    localObject = paramView.findViewById(2131298783);
    p.g(localObject, "header.findViewById(R.id.close_layout)");
    this.pvI = ((View)localObject);
    localObject = paramView.findViewById(2131298782);
    p.g(localObject, "header.findViewById(R.id.close_iv)");
    this.pvJ = ((View)localObject);
    localObject = paramView.findViewById(2131297498);
    p.g(localObject, "header.findViewById(R.id…_rec_card_profile_layout)");
    this.pvK = ((View)localObject);
    localObject = paramView.findViewById(2131297499);
    p.g(localObject, "header.findViewById(R.id.biz_rec_card_reason_tv)");
    this.pvL = ((TextView)localObject);
    localObject = paramView.findViewById(2131297486);
    p.g(localObject, "header.findViewById(R.id.biz_rec_card_desc_tv)");
    this.pvM = ((MMNeat7extView)localObject);
    localObject = paramView.findViewById(2131305223);
    ((WeImageView)localObject).setVisibility(0);
    p.g(localObject, "header.findViewById<WeIm…sibility = View.VISIBLE }");
    this.pvP = ((WeImageView)localObject);
    localObject = paramView.findViewById(2131297495);
    p.g(localObject, "header.findViewById(R.id…_rec_card_follow_already)");
    this.pvO = ((TextView)localObject);
    paramView = paramView.findViewById(2131297496);
    p.g(paramView, "header.findViewById(R.id…iz_rec_card_follow_type3)");
    this.pvN = ((Button)paramView);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(w paramw, String paramString, z paramz) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(195397);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.pvT;
      localObject = paramView2;
      p.g(localObject, "username");
      w.a(paramView, (String)localObject, paramz);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(195397);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(w paramw, z paramz, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(195398);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.pvT;
      localObject = this.pvT.pvJ;
      if (localObject == null) {
        p.btv("closeIv");
      }
      w.a(paramView, (View)localObject, paramz, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(195398);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    f(w paramw, z paramz, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.w
 * JD-Core Version:    0.7.0.1
 */