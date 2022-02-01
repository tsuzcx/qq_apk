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
import com.tencent.mm.aj.m;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqc;
import com.tencent.mm.protocal.protobuf.eqd;
import com.tencent.mm.protocal.protobuf.eqf;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "addContacListener", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$IListenerImpl;", "avatarIV", "Landroid/widget/ImageView;", "getAvatarIV", "()Landroid/widget/ImageView;", "setAvatarIV", "(Landroid/widget/ImageView;)V", "closeIv", "Landroid/view/View;", "getCloseIv", "()Landroid/view/View;", "setCloseIv", "(Landroid/view/View;)V", "closeLayout", "getCloseLayout", "setCloseLayout", "getContext", "()Landroid/content/Context;", "followAlready", "Landroid/widget/TextView;", "getFollowAlready", "()Landroid/widget/TextView;", "setFollowAlready", "(Landroid/widget/TextView;)V", "followArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getFollowArrow", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setFollowArrow", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "followType3", "Landroid/widget/Button;", "getFollowType3", "()Landroid/widget/Button;", "setFollowType3", "(Landroid/widget/Button;)V", "nickNameTV", "getNickNameTV", "setNickNameTV", "profileDescTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getProfileDescTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setProfileDescTv", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "profileLayout", "getProfileLayout", "setProfileLayout", "profileReasonTv", "getProfileReasonTv", "setProfileReasonTv", "recCardTitle", "getRecCardTitle", "setRecCardTitle", "weakContext", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getWeakContext", "()Ljava/lang/ref/WeakReference;", "attachRound", "", "iv", "brandURL", "", "btnFollow", "username", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "filling", "position", "", "convertView", "parent", "inflate", "inflateHeader", "header", "onAppMsgClick", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "order", "onUnLikeClick", "view", "refreshHeader", "shouldShowNegativeFeedback", "", "recCardUserInfo", "Lcom/tencent/mm/protocal/protobuf/TLRecCardUserInfo;", "viewContactProfile", "talker", "Companion", "IListenerImpl", "plugin-brandservice_release"})
public abstract class x
  extends ae
{
  public static final x.a sFj = new x.a((byte)0);
  final Context context;
  public ImageView iZG;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b sCg;
  public TextView sEX;
  public TextView sEY;
  public View sEZ;
  public View sFa;
  public View sFb;
  public TextView sFc;
  public MMNeat7extView sFd;
  public Button sFe;
  public TextView sFf;
  public WeImageView sFg;
  final WeakReference<Context> sFh;
  private x.b sFi;
  
  public x(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.context = paramContext;
    this.sCg = paramb;
    this.sFh = new WeakReference(this.context);
    this.sFi = new x.b(this);
  }
  
  public void a(final z paramz, final int paramInt, View paramView1, final View paramView2)
  {
    p.k(paramz, "info");
    p.k(paramView1, "convertView");
    p.k(paramView2, "parent");
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1149L, 2L, 1L, false);
    dS(paramView2);
    paramView2 = paramz.hwK();
    if (paramView2 != null)
    {
      paramView2 = paramView2.Usy;
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
        p.k(paramz, "info");
        paramView1 = paramz.hwK();
        paramView2 = this.sEY;
        if (paramView2 == null) {
          p.bGy("recCardTitle");
        }
        paramView2.setText((CharSequence)paramView1.SwE);
        paramView2 = this.sEX;
        if (paramView2 == null) {
          p.bGy("nickNameTV");
        }
        if (paramView2 == null) {
          p.iCn();
        }
        paramView2 = paramView2.getPaint();
        p.j(paramView2, "tp");
        paramView2.setFakeBoldText(true);
        paramView2 = this.iZG;
        if (paramView2 == null) {
          p.bGy("avatarIV");
        }
        if (paramView2 == null) {
          p.iCn();
        }
        localObject1 = paramView1.Usy.RRW;
        p.j(localObject1, "recCard.BizInfo.BrandIconUrl");
        localObject2 = new c.a();
        ((c.a)localObject2).wz(d.d.brand_default_head);
        ((c.a)localObject2).bmG();
        ((c.a)localObject2).bmJ();
        com.tencent.mm.ay.q.bml().a((String)localObject1, paramView2, ((c.a)localObject2).bmL());
        paramView2 = this.sEX;
        if (paramView2 == null) {
          p.bGy("nickNameTV");
        }
        if (paramView2 == null) {
          p.iCn();
        }
        paramView2.setText((CharSequence)paramView1.Usy.rWI);
        paramView2 = this.sFc;
        if (paramView2 == null) {
          p.bGy("profileReasonTv");
        }
        paramView2.setText((CharSequence)paramView1.Usy.UsA);
        paramView2 = paramView1.Usy.UserName;
        localObject1 = this.sFb;
        if (localObject1 == null) {
          p.bGy("profileLayout");
        }
        ((View)localObject1).setOnClickListener((View.OnClickListener)new d(this, paramView2, paramz));
        localObject1 = paramz.hwL();
      } while (localObject1 == null);
      Object localObject2 = paramView1.Usz;
      int i;
      if (localObject2 == null)
      {
        Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
        i = 0;
        if ((i != 0) || (!Util.isNullOrNil((List)((eqg)localObject1).UsE))) {
          break label681;
        }
        Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = " + paramView1.Usy.rWI);
        paramView1 = this.sEZ;
        if (paramView1 == null) {
          p.bGy("closeLayout");
        }
        paramView1.setVisibility(8);
      }
      for (;;)
      {
        paramz = (kotlin.g.a.a)new f(this, paramz, paramView2);
        paramView1 = this.sFf;
        if (paramView1 == null) {
          p.bGy("followAlready");
        }
        paramView1.setVisibility(8);
        paramView1 = this.sFe;
        if (paramView1 == null) {
          p.bGy("followType3");
        }
        paramView1.setVisibility(8);
        paramView1 = com.tencent.mm.kernel.h.ae(n.class);
        p.j(paramView1, "MMKernel.service(IMessengerStorage::class.java)");
        paramView1 = ((n)paramView1).bbL().RG(paramView2);
        if ((paramView1 != null) && (paramView1.ayq() > 0)) {
          break label764;
        }
        az.a.ber().a(paramView2, "", null);
        paramz.invoke();
        return;
        if (((eqf)localObject2).UsC == null)
        {
          Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
          i = 0;
          break;
        }
        if (((eqf)localObject2).UsC.RXG != 1)
        {
          Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
          i = 0;
          break;
        }
        if (Util.isNullOrNil((List)((eqf)localObject2).UsC.RXF))
        {
          Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
          i = 0;
          break;
        }
        i = 1;
        break;
        Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = " + paramView1.Usy.rWI);
        paramView1 = this.sEZ;
        if (paramView1 == null) {
          p.bGy("closeLayout");
        }
        paramView1.setVisibility(0);
        paramView1 = this.sEZ;
        if (paramView1 == null) {
          p.bGy("closeLayout");
        }
        paramView1.setOnClickListener((View.OnClickListener)new e(this, paramz, paramInt));
      }
      if (!paramView1.axZ())
      {
        paramz.invoke();
        return;
      }
    } while (!paramView1.axZ());
    label681:
    paramz = this.sFf;
    if (paramz == null) {
      p.bGy("followAlready");
    }
    paramz.setVisibility(0);
  }
  
  public final void a(z paramz, eqc parameqc, int paramInt)
  {
    p.k(paramz, "info");
    if ((parameqc != null) && (paramz.hwK() != null))
    {
      localObject = paramz.hwK();
      if (localObject == null) {
        p.iCn();
      }
      if (((eqb)localObject).Usy != null) {}
    }
    else
    {
      Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
      return;
    }
    Object localObject = paramz.hwK();
    if (localObject == null) {
      p.iCn();
    }
    eqd localeqd = ((eqb)localObject).Usy;
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1149L, 4L, 1L, false);
    Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { parameqc.RTk });
    Intent localIntent = new Intent();
    localObject = m.e(parameqc.RTk, 138, 10000, 0);
    localIntent.putExtra("rawUrl", (String)localObject);
    localIntent.putExtra("geta8key_scene", 56);
    localIntent.putExtra("geta8key_username", localeqd.UserName);
    localIntent.putExtra("srcUsername", localeqd.UserName);
    localIntent.putExtra("srcDisplayname", localeqd.rWI);
    localIntent.putExtra("prePublishId", "rec_card");
    localIntent.putExtra("KPublisherId", "rec_card");
    if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(this.context, (String)localObject, parameqc.lpx, 138, 10000, localIntent))) {
      Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
    }
    for (;;)
    {
      parameqc = paramz.hwL();
      int j;
      int i;
      if (parameqc != null)
      {
        j = 0;
        i = j;
      }
      try
      {
        localObject = Uri.parse((String)localObject);
        i = j;
        j = Util.getInt(((Uri)localObject).getQueryParameter("idx"), 0);
        i = j;
        l = Util.getLong(((Uri)localObject).getQueryParameter("mid"), 0L);
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l = 0L;
        }
      }
      this.sCg.szZ.a(paramz.field_talker, l, i, 15, 0, parameqc.Uaw, true, paramInt);
      this.sCg.b(paramz, paramInt);
      return;
      com.tencent.mm.by.c.b(this.context, "webview", ".ui.tools.WebViewUI", localIntent);
    }
  }
  
  public final TextView cAF()
  {
    TextView localTextView = this.sFc;
    if (localTextView == null) {
      p.bGy("profileReasonTv");
    }
    return localTextView;
  }
  
  public final Button cAG()
  {
    Button localButton = this.sFe;
    if (localButton == null) {
      p.bGy("followType3");
    }
    return localButton;
  }
  
  public final TextView cAH()
  {
    TextView localTextView = this.sFf;
    if (localTextView == null) {
      p.bGy("followAlready");
    }
    return localTextView;
  }
  
  public abstract void dS(View paramView);
  
  public final void dT(View paramView)
  {
    p.k(paramView, "header");
    Object localObject = paramView.findViewById(d.e.avatar_iv);
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.widget.ImageView");
    }
    this.iZG = ((ImageView)localObject);
    localObject = paramView.findViewById(d.e.nick_name_tv);
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.widget.TextView");
    }
    this.sEX = ((TextView)localObject);
    localObject = paramView.findViewById(d.e.sqj);
    p.j(localObject, "header.findViewById(R.id.biz_rec_card_title)");
    this.sEY = ((TextView)localObject);
    localObject = d.sTw;
    localObject = this.sEY;
    if (localObject == null) {
      p.bGy("recCardTitle");
    }
    d.l((TextView)localObject);
    localObject = paramView.findViewById(d.e.close_layout);
    p.j(localObject, "header.findViewById(R.id.close_layout)");
    this.sEZ = ((View)localObject);
    localObject = paramView.findViewById(d.e.close_iv);
    p.j(localObject, "header.findViewById(R.id.close_iv)");
    this.sFa = ((View)localObject);
    localObject = paramView.findViewById(d.e.sqh);
    p.j(localObject, "header.findViewById(R.id…_rec_card_profile_layout)");
    this.sFb = ((View)localObject);
    localObject = paramView.findViewById(d.e.sqi);
    p.j(localObject, "header.findViewById(R.id.biz_rec_card_reason_tv)");
    this.sFc = ((TextView)localObject);
    localObject = paramView.findViewById(d.e.spV);
    p.j(localObject, "header.findViewById(R.id.biz_rec_card_desc_tv)");
    this.sFd = ((MMNeat7extView)localObject);
    localObject = paramView.findViewById(d.e.sse);
    ((WeImageView)localObject).setVisibility(0);
    p.j(localObject, "header.findViewById<WeIm…sibility = View.VISIBLE }");
    this.sFg = ((WeImageView)localObject);
    localObject = paramView.findViewById(d.e.sqe);
    p.j(localObject, "header.findViewById(R.id…_rec_card_follow_already)");
    this.sFf = ((TextView)localObject);
    paramView = paramView.findViewById(d.e.sqf);
    p.j(paramView, "header.findViewById(R.id…iz_rec_card_follow_type3)");
    this.sFe = ((Button)paramView);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(x paramx, String paramString, z paramz) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(265808);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.sFl;
      localObject = paramView2;
      p.j(localObject, "username");
      x.a(paramView, (String)localObject, paramz);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265808);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(x paramx, z paramz, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(259768);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.sFl;
      localObject = this.sFl.sFa;
      if (localObject == null) {
        p.bGy("closeIv");
      }
      x.a(paramView, (View)localObject, paramz, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(259768);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    f(x paramx, z paramz, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.x
 * JD-Core Version:    0.7.0.1
 */