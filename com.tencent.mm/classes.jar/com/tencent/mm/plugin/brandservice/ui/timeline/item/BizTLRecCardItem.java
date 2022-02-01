package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.message.m;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.b.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.protocal.protobuf.flg;
import com.tencent.mm.protocal.protobuf.fli;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "addContacListener", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$IListenerImpl;", "avatarIV", "Landroid/widget/ImageView;", "getAvatarIV", "()Landroid/widget/ImageView;", "setAvatarIV", "(Landroid/widget/ImageView;)V", "closeIv", "Landroid/view/View;", "getCloseIv", "()Landroid/view/View;", "setCloseIv", "(Landroid/view/View;)V", "closeLayout", "getCloseLayout", "setCloseLayout", "getContext", "()Landroid/content/Context;", "followAlready", "Landroid/widget/TextView;", "getFollowAlready", "()Landroid/widget/TextView;", "setFollowAlready", "(Landroid/widget/TextView;)V", "followArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getFollowArrow", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setFollowArrow", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "followType3", "Landroid/widget/Button;", "getFollowType3", "()Landroid/widget/Button;", "setFollowType3", "(Landroid/widget/Button;)V", "nickNameTV", "getNickNameTV", "setNickNameTV", "profileDescTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getProfileDescTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setProfileDescTv", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "profileLayout", "getProfileLayout", "setProfileLayout", "profileReasonTv", "getProfileReasonTv", "setProfileReasonTv", "recCardTitle", "getRecCardTitle", "setRecCardTitle", "weakContext", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getWeakContext", "()Ljava/lang/ref/WeakReference;", "attachRound", "", "iv", "brandURL", "", "btnFollow", "username", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "filling", "position", "", "convertView", "parent", "inflate", "inflateHeader", "header", "onAppMsgClick", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", "order", "onUnLikeClick", "view", "refreshHeader", "shouldShowNegativeFeedback", "", "recCardUserInfo", "Lcom/tencent/mm/protocal/protobuf/TLRecCardUserInfo;", "viewContactProfile", "talker", "Companion", "IListenerImpl", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BizTLRecCardItem
  extends ab
{
  public static final BizTLRecCardItem.a vKD = new BizTLRecCardItem.a((byte)0);
  final Context context;
  public ImageView lBC;
  final com.tencent.mm.plugin.brandservice.ui.timeline.b vHY;
  public TextView vKE;
  public TextView vKF;
  public View vKG;
  public View vKH;
  public View vKI;
  public TextView vKJ;
  public MMNeat7extView vKK;
  public Button vKL;
  public TextView vKM;
  public WeImageView vKN;
  private final WeakReference<Context> vKO;
  private BizTLRecCardItem.IListenerImpl vKP;
  
  public BizTLRecCardItem(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.context = paramContext;
    this.vHY = paramb;
    this.vKO = new WeakReference(this.context);
    this.vKP = new BizTLRecCardItem.IListenerImpl(this);
  }
  
  private static final void a(BizTLRecCardItem paramBizTLRecCardItem, com.tencent.mm.storage.ab paramab, int paramInt, View paramView)
  {
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramBizTLRecCardItem);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramab);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramBizTLRecCardItem, "this$0");
    s.u(paramab, "$info");
    paramView = paramBizTLRecCardItem.vKH;
    if (paramView != null)
    {
      localObject1 = paramab.iYp();
      if (localObject1 != null) {
        break label128;
      }
      Log.w("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] onUnLikeClick wrapper is null");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
      s.bIx("closeIv");
      paramView = null;
      break;
      label128:
      localObject2 = paramBizTLRecCardItem.vHY.vFK;
      fle localfle = paramab.iYo();
      s.checkNotNull(localfle);
      ((f)localObject2).a(localfle.abLF.UserName, 0L, 0, 16, 0, ((flj)localObject1).abry, true, 0);
      int i = 0;
      if ((((flj)localObject1).abLK == null) || (((flj)localObject1).abLK.abLG == null) || (((flj)localObject1).abLK.abLG.abLJ == null) || (Util.isNullOrNil((List)((flj)localObject1).abLK.abLG.abLJ.YVA))) {
        i = 1;
      }
      if ((Util.isNullOrNil((List)((flj)localObject1).abLL)) && (i != 0))
      {
        Log.w("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] onUnLikeClick negativeFeedbackReason is null");
      }
      else
      {
        localObject1 = paramView.getContext();
        s.s(localObject1, "view.context");
        ((b)new b((Context)localObject1, paramab, paramBizTLRecCardItem.vHY, paramInt).mj(paramView)).show();
      }
    }
  }
  
  private static final void a(BizTLRecCardItem paramBizTLRecCardItem, String paramString, com.tencent.mm.storage.ab paramab, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBizTLRecCardItem);
    localb.cH(paramString);
    localb.cH(paramab);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBizTLRecCardItem, "this$0");
    s.u(paramab, "$info");
    s.s(paramString, "username");
    paramab = paramab.iYp();
    if (paramab == null) {
      Log.w("MicroMsg.BizTimeLineItem", "viewContactProfile wrapper is null");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
      paramView = new Intent();
      paramView.putExtra("Contact_User", paramString);
      paramView.putExtra("Contact_Scene", 160);
      paramView.putExtra("KBizRecCardId", paramab.abry);
      paramView.putExtra("force_get_contact", true);
      paramView.putExtra("key_use_new_contact_profile", true);
      com.tencent.mm.br.c.b(paramBizTLRecCardItem.context, "profile", ".ui.ContactInfoUI", paramView);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1149L, 3L, 1L, false);
      paramBizTLRecCardItem.vHY.vFK.a(paramString, 0L, 0, 13, 0, paramab.abry, true, 0);
    }
  }
  
  private static final void a(BizTLRecCardItem paramBizTLRecCardItem, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    s.u(paramBizTLRecCardItem, "this$0");
    s.u(paramString1, "respUsername");
    s.u(paramString2, "googleItemID");
    if ((paramBoolean1) && (paramBizTLRecCardItem.vKO != null) && (paramBizTLRecCardItem.vKO.get() != null))
    {
      paramBizTLRecCardItem.ddK().setVisibility(0);
      paramBizTLRecCardItem.ddJ().setVisibility(8);
    }
  }
  
  private TextView ddF()
  {
    TextView localTextView = this.vKE;
    if (localTextView != null) {
      return localTextView;
    }
    s.bIx("nickNameTV");
    return null;
  }
  
  private TextView ddG()
  {
    TextView localTextView = this.vKF;
    if (localTextView != null) {
      return localTextView;
    }
    s.bIx("recCardTitle");
    return null;
  }
  
  private View ddH()
  {
    View localView = this.vKG;
    if (localView != null) {
      return localView;
    }
    s.bIx("closeLayout");
    return null;
  }
  
  public void a(com.tencent.mm.storage.ab paramab, int paramInt, View paramView1, View paramView2)
  {
    s.u(paramab, "info");
    s.u(paramView1, "convertView");
    s.u(paramView2, "parent");
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1149L, 2L, 1L, false);
    eF(paramView2);
    paramView2 = paramab.iYo();
    if (paramView2 == null)
    {
      paramView2 = null;
      if (paramView2 != null) {
        break label78;
      }
      paramView1.setVisibility(8);
    }
    label78:
    label599:
    do
    {
      String str;
      do
      {
        return;
        paramView2 = paramView2.abLF;
        break;
        paramView1.setVisibility(0);
        s.u(paramab, "info");
        paramView2 = paramab.iYo();
        ddG().setText((CharSequence)paramView2.Zxn);
        paramView1 = ddF();
        s.checkNotNull(paramView1);
        paramView1.getPaint().setFakeBoldText(true);
        paramView1 = this.lBC;
        if (paramView1 == null) {
          break label445;
        }
        s.checkNotNull(paramView1);
        str = paramView2.abLF.YPo;
        s.s(str, "recCard.BizInfo.BrandIconUrl");
        localObject = new c.a();
        ((c.a)localObject).oKE = d.d.brand_default_head;
        ((c.a)localObject).oKo = true;
        ((c.a)localObject).nrc = true;
        r.bKe().a(str, paramView1, ((c.a)localObject).bKx());
        paramView1 = ddF();
        s.checkNotNull(paramView1);
        paramView1.setText((CharSequence)paramView2.abLF.vhX);
        ddI().setText((CharSequence)paramView2.abLF.abLH);
        str = paramView2.abLF.UserName;
        paramView1 = this.vKI;
        if (paramView1 == null) {
          break label456;
        }
        paramView1.setOnClickListener(new BizTLRecCardItem..ExternalSyntheticLambda1(this, str, paramab));
        paramView1 = paramab.iYp();
      } while (paramView1 == null);
      Object localObject = paramView2.abLG;
      int i;
      if (localObject == null)
      {
        Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
        i = 0;
        if ((i != 0) || (!Util.isNullOrNil((List)paramView1.abLL))) {
          break label552;
        }
        Log.i("MicroMsg.BizTLRecCardItem", s.X("[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = ", paramView2.abLF.vhX));
        ddH().setVisibility(8);
      }
      for (;;)
      {
        paramab = (kotlin.g.a.a)new BizTLRecCardItem.b(paramab, this, str);
        ddK().setVisibility(8);
        ddJ().setVisibility(8);
        paramView1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(str);
        if ((paramView1 != null) && ((int)paramView1.maN > 0)) {
          break label599;
        }
        az.a.okP.a(str, "", null);
        paramab.invoke();
        return;
        s.bIx("avatarIV");
        paramView1 = null;
        break;
        s.bIx("profileLayout");
        paramView1 = null;
        break label263;
        if (((fli)localObject).abLJ == null)
        {
          Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
          i = 0;
          break label310;
        }
        if (((fli)localObject).abLJ.YVB != 1)
        {
          Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
          i = 0;
          break label310;
        }
        if (Util.isNullOrNil((List)((fli)localObject).abLJ.YVA))
        {
          Log.i("MicroMsg.BizTLRecCardItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
          i = 0;
          break label310;
        }
        i = 1;
        break label310;
        Log.i("MicroMsg.BizTLRecCardItem", s.X("[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = ", paramView2.abLF.vhX));
        ddH().setVisibility(0);
        ddH().setOnClickListener(new BizTLRecCardItem..ExternalSyntheticLambda0(this, paramab, paramInt));
      }
      if (!d.rs(paramView1.field_type))
      {
        paramab.invoke();
        return;
      }
    } while (!d.rs(paramView1.field_type));
    label263:
    label310:
    label445:
    label456:
    ddK().setVisibility(0);
    label552:
  }
  
  public final void a(com.tencent.mm.storage.ab paramab, flf paramflf, int paramInt)
  {
    s.u(paramab, "info");
    if ((paramflf != null) && (paramab.iYo() != null))
    {
      localObject1 = paramab.iYo();
      s.checkNotNull(localObject1);
      if (((fle)localObject1).abLF != null) {}
    }
    else
    {
      Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
      return;
    }
    Object localObject1 = paramab.iYo();
    s.checkNotNull(localObject1);
    Object localObject2 = ((fle)localObject1).abLF;
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1149L, 4L, 1L, false);
    Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { paramflf.YQK });
    Intent localIntent = new Intent();
    localObject1 = m.e(paramflf.YQK, 138, 10000, (int)System.currentTimeMillis() / 1000);
    localIntent.putExtra("rawUrl", (String)localObject1);
    localIntent.putExtra("geta8key_scene", 56);
    localIntent.putExtra("geta8key_username", ((flg)localObject2).UserName);
    localIntent.putExtra("srcUsername", ((flg)localObject2).UserName);
    localIntent.putExtra("srcDisplayname", ((flg)localObject2).vhX);
    localIntent.putExtra("prePublishId", "rec_card");
    localIntent.putExtra("KPublisherId", "rec_card");
    if ((((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(1)) && (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(this.context, (String)localObject1, paramflf.nUA, 138, 10000, localIntent))) {
      Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
    }
    for (;;)
    {
      paramflf = paramab.iYp();
      int j;
      int i;
      if (paramflf != null)
      {
        j = 0;
        i = j;
      }
      try
      {
        localObject2 = Uri.parse((String)localObject1);
        i = j;
        j = Util.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
        i = j;
        l = Util.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l = 0L;
        }
      }
      localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramab, (String)localObject1, a.a.vNT);
      this.vHY.vFK.a(paramab.field_talker, l, i, 15, 0, paramflf.abry, true, paramInt);
      this.vHY.b(paramab, paramInt);
      return;
      com.tencent.mm.br.c.b(this.context, "webview", ".ui.tools.WebViewUI", localIntent);
    }
  }
  
  public final TextView ddI()
  {
    TextView localTextView = this.vKJ;
    if (localTextView != null) {
      return localTextView;
    }
    s.bIx("profileReasonTv");
    return null;
  }
  
  public final Button ddJ()
  {
    Button localButton = this.vKL;
    if (localButton != null) {
      return localButton;
    }
    s.bIx("followType3");
    return null;
  }
  
  public final TextView ddK()
  {
    TextView localTextView = this.vKM;
    if (localTextView != null) {
      return localTextView;
    }
    s.bIx("followAlready");
    return null;
  }
  
  public abstract void eF(View paramView);
  
  public final void eG(View paramView)
  {
    s.u(paramView, "header");
    Object localObject = paramView.findViewById(d.e.avatar_iv);
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    }
    localObject = (ImageView)localObject;
    s.u(localObject, "<set-?>");
    this.lBC = ((ImageView)localObject);
    localObject = paramView.findViewById(d.e.nick_name_tv);
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
    localObject = (TextView)localObject;
    s.u(localObject, "<set-?>");
    this.vKE = ((TextView)localObject);
    localObject = paramView.findViewById(d.e.biz_rec_card_title);
    s.s(localObject, "header.findViewById(R.id.biz_rec_card_title)");
    localObject = (TextView)localObject;
    s.u(localObject, "<set-?>");
    this.vKF = ((TextView)localObject);
    localObject = e.vYK;
    e.l(ddG());
    localObject = paramView.findViewById(d.e.close_layout);
    s.s(localObject, "header.findViewById(R.id.close_layout)");
    s.u(localObject, "<set-?>");
    this.vKG = ((View)localObject);
    localObject = paramView.findViewById(d.e.close_iv);
    s.s(localObject, "header.findViewById(R.id.close_iv)");
    s.u(localObject, "<set-?>");
    this.vKH = ((View)localObject);
    localObject = paramView.findViewById(d.e.biz_rec_card_profile_layout);
    s.s(localObject, "header.findViewById(R.id…_rec_card_profile_layout)");
    s.u(localObject, "<set-?>");
    this.vKI = ((View)localObject);
    localObject = paramView.findViewById(d.e.biz_rec_card_reason_tv);
    s.s(localObject, "header.findViewById(R.id.biz_rec_card_reason_tv)");
    localObject = (TextView)localObject;
    s.u(localObject, "<set-?>");
    this.vKJ = ((TextView)localObject);
    localObject = paramView.findViewById(d.e.biz_rec_card_desc_tv);
    s.s(localObject, "header.findViewById(R.id.biz_rec_card_desc_tv)");
    localObject = (MMNeat7extView)localObject;
    s.u(localObject, "<set-?>");
    this.vKK = ((MMNeat7extView)localObject);
    localObject = paramView.findViewById(d.e.nav_arrow);
    ((WeImageView)localObject).setVisibility(0);
    ah localah = ah.aiuX;
    s.s(localObject, "header.findViewById<WeIm…sibility = View.VISIBLE }");
    localObject = (WeImageView)localObject;
    s.u(localObject, "<set-?>");
    this.vKN = ((WeImageView)localObject);
    localObject = paramView.findViewById(d.e.biz_rec_card_follow_already);
    s.s(localObject, "header.findViewById(R.id…_rec_card_follow_already)");
    localObject = (TextView)localObject;
    s.u(localObject, "<set-?>");
    this.vKM = ((TextView)localObject);
    paramView = paramView.findViewById(d.e.biz_rec_card_follow_type3);
    s.s(paramView, "header.findViewById(R.id…iz_rec_card_follow_type3)");
    paramView = (Button)paramView;
    s.u(paramView, "<set-?>");
    this.vKL = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardItem
 * JD-Core Version:    0.7.0.1
 */