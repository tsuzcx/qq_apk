package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.message.m;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.b.e;
import com.tencent.mm.plugin.findersdk.a.br;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flg;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "clickCallback", "Lkotlin/Function0;", "", "getClickCallback", "()Lkotlin/jvm/functions/Function0;", "setClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "setClickView", "(Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "friendReadTv", "Landroid/widget/TextView;", "getFriendReadTv", "()Landroid/widget/TextView;", "setFriendReadTv", "(Landroid/widget/TextView;)V", "itemView", "getItemView", "setItemView", "pressMask", "Landroid/widget/ImageView;", "getPressMask", "()Landroid/widget/ImageView;", "setPressMask", "(Landroid/widget/ImageView;)V", "singleDigest", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getSingleDigest", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setSingleDigest", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "singleTitle", "getSingleTitle", "setSingleTitle", "singleTitleLayout", "Landroid/widget/LinearLayout;", "getSingleTitleLayout", "()Landroid/widget/LinearLayout;", "setSingleTitleLayout", "(Landroid/widget/LinearLayout;)V", "statLayout", "getStatLayout", "setStatLayout", "title", "getTitle", "setTitle", "titleLayout", "getTitleLayout", "setTitleLayout", "filling", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "hide", "inflate", "id", "", "inflateStatLayout", "needRoundBottom", "", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "onAppMsgClick", "convertView", "order", "refreshClickView", "refreshFriendInfo", "refreshTitle", "isSingleMsg", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f
{
  private View caK;
  final Context context;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.b vHY;
  private View vIV;
  MMNeat7extView vIW;
  ImageView vIX;
  private LinearLayout vIY;
  private LinearLayout vIZ;
  private MMNeat7extView vJa;
  private MMNeat7extView vJb;
  private View vJc;
  TextView vJd;
  kotlin.g.a.a<ah> vJe;
  
  public f(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.context = paramContext;
    this.vHY = paramb;
  }
  
  private static final void a(f paramf, ab paramab, qn paramqn, View paramView)
  {
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramab);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramqn);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramf, "this$0");
    s.u(paramab, "$info");
    s.u(paramqn, "$appMsg");
    paramView = paramf.vJe;
    if (paramView != null) {
      paramView.invoke();
    }
    s.u(paramab, "info");
    if ((paramqn != null) && (paramab.iYo() != null))
    {
      paramView = paramab.iYo();
      s.checkNotNull(paramView);
      if (paramView.abLF != null) {}
    }
    else
    {
      Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
    }
    localObject1 = null;
    if (paramqn.YVG != null)
    {
      paramView = paramqn.YVG;
      s.s(paramView, "appMsg.finderXmlContent");
      if (n.U(paramView, "<finder_feed>", false))
      {
        paramView = XmlParser.parseXml(paramqn.YVG, "finder_feed", null);
        localObject1 = "";
      }
    }
    for (;;)
    {
      if (paramView != null)
      {
        localObject2 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(26, 2, 25, null);
        if (((br)com.tencent.mm.kernel.h.ax(br.class)).a(paramf.context, (String)localObject1, paramView, (String)localObject2))
        {
          Log.i("MicroMsg.BizTimeLineItem", "open finder success!");
          paramf.vHY.b(paramab, 0);
          break;
          paramView = paramqn.YVG;
          s.s(paramView, "appMsg.finderXmlContent");
          if (!n.U(paramView, "~SEMI_XML~", false)) {
            break label697;
          }
          paramView = SemiXml.decode(paramqn.YVG);
          localObject1 = ".sysmsg.BizAccountRecommend.BizAccount.AppMsg";
          continue;
        }
      }
      paramView = paramab.iYo();
      s.checkNotNull(paramView);
      localObject1 = paramView.abLF;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1149L, 4L, 1L, false);
      Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", new Object[] { paramqn.YQK });
      localObject2 = new Intent();
      paramView = m.e(paramqn.YQK, 169, 10000, (int)System.currentTimeMillis() / 1000);
      ((Intent)localObject2).putExtra("rawUrl", paramView);
      ((Intent)localObject2).putExtra("geta8key_scene", 56);
      ((Intent)localObject2).putExtra("geta8key_username", ((flg)localObject1).UserName);
      ((Intent)localObject2).putExtra("srcUsername", ((flg)localObject1).UserName);
      ((Intent)localObject2).putExtra("srcDisplayname", ((flg)localObject1).vhX);
      ((Intent)localObject2).putExtra("prePublishId", "rec_card");
      ((Intent)localObject2).putExtra("KPublisherId", "rec_card");
      if ((((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(1)) && (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(paramf.context, paramView, paramqn.nUA, 169, 10000, (Intent)localObject2))) {
        Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
      }
      for (;;)
      {
        localObject1 = paramab.iYp();
        int j;
        int i;
        if (localObject1 != null)
        {
          j = 0;
          i = j;
        }
        try
        {
          paramView = Uri.parse(paramView);
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
        com.tencent.mm.plugin.brandservice.ui.timeline.f.a((flj)localObject1);
        paramf.vHY.vFK.a(paramab.field_talker, l, i, 15, ((flj)localObject1).abry, "", 0, ((flj)localObject1).abLM.YSJ, ((flj)localObject1).event, ((flj)localObject1).abLM.YSF, paramqn.YVE, ((flj)localObject1).style, paramqn.YVF);
        paramf.vHY.b(paramab, 0);
        break;
        com.tencent.mm.br.c.b(paramf.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      }
      label697:
      paramView = null;
    }
  }
  
  private static boolean a(ab paramab, qo paramqo)
  {
    boolean bool = true;
    s.u(paramab, "<this>");
    switch (paramab.iYp().style)
    {
    default: 
      return false;
    case 101: 
      if (paramqo == null) {}
      for (paramab = (qo)paramab.iYp().abLM.YSB.get(0); paramab.YVI.size() <= 1; paramab = paramqo) {
        return true;
      }
      return false;
    }
    paramab = paramab.iYp().abLM.YSB;
    s.s(paramab, "tlRecCardWrapper.extraInfo.BizInfo");
    paramab = ((Iterable)p.c((Iterable)paramab, 2)).iterator();
    int i = 0;
    int j = 0;
    if (paramab.hasNext())
    {
      paramqo = paramab.next();
      if (j < 0) {
        p.kkW();
      }
      if (((qo)paramqo).YFu != 0) {
        break label181;
      }
      i += 1;
    }
    label181:
    for (;;)
    {
      j += 1;
      break;
      if (i < 2) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
  }
  
  public final void a(LinearLayout paramLinearLayout)
  {
    this.vIY = paramLinearLayout;
  }
  
  public final void a(ab paramab, qn paramqn)
  {
    s.u(paramab, "info");
    s.u(paramqn, "appMsg");
    Object localObject = this.vJb;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setVisibility(8);
    }
    localObject = this.vJc;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (a(paramab, null)) {
      if (!Util.isNullOrNil(paramqn.IJA))
      {
        paramab = this.vJb;
        if (paramab != null) {
          paramab.setVisibility(0);
        }
        paramab = this.vJb;
        if (paramab != null) {
          paramab.aZ((CharSequence)paramqn.IJA);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (Util.isNullOrNil(paramqn.IJA));
      paramab = this.vJc;
      if (paramab != null) {
        paramab.setVisibility(0);
      }
      paramab = this.vIY;
      if (paramab != null) {
        paramab.setBackgroundResource(d.d.biz_time_line_title_gradient_mask);
      }
      paramab = this.vJd;
    } while (paramab == null);
    paramab.setText((CharSequence)paramqn.IJA);
  }
  
  public final void a(ab paramab, qo paramqo, qn paramqn)
  {
    s.u(paramab, "info");
    s.u(paramqo, "bizInfo");
    s.u(paramqn, "appMsg");
    Object localObject = this.vIW;
    if (localObject != null) {
      ((MMNeat7extView)localObject).setTextColor(this.context.getResources().getColor(d.b.light_grey_text_color));
    }
    localObject = this.vIY;
    if (localObject != null) {
      ((LinearLayout)localObject).setBackgroundResource(d.d.mm_trans);
    }
    localObject = this.vJd;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(this.context.getResources().getColor(d.b.light_grey_text_color));
    }
    if (a(paramab, paramqo))
    {
      paramab = this.vIZ;
      if (paramab != null) {
        paramab.setVisibility(0);
      }
      paramab = this.vIW;
      if (paramab != null) {
        paramab.setVisibility(8);
      }
      paramab = this.vJa;
      if (paramab != null)
      {
        paramab.setMaxLines(2);
        paramab.aZ((CharSequence)paramqn.hAP);
        paramqo = e.vYK;
        if (e.dhV())
        {
          paramqo = e.vYK;
          e.e(paramab);
        }
      }
      return;
    }
    paramab = this.vIZ;
    if (paramab != null) {
      paramab.setVisibility(8);
    }
    paramab = this.vIW;
    if (paramab != null) {
      paramab.setVisibility(0);
    }
    paramab = this.vIW;
    if (paramab != null) {
      paramab.aZ((CharSequence)paramqn.hAP);
    }
    paramab = e.vYK;
    e.e(this.vIW);
  }
  
  public void aa(View paramView, int paramInt)
  {
    s.u(paramView, "parent");
    if (this.caK != null) {
      return;
    }
    this.caK = ((ViewStub)paramView.findViewById(paramInt)).inflate();
  }
  
  public final void b(LinearLayout paramLinearLayout)
  {
    this.vIZ = paramLinearLayout;
  }
  
  public final void b(ab paramab, qo paramqo, qn paramqn)
  {
    int k = 0;
    s.u(paramab, "info");
    s.u(paramqo, "bizInfo");
    s.u(paramqn, "appMsg");
    Object localObject;
    int i;
    if (a(paramab, paramqo))
    {
      localObject = this.vIV;
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(d.d.biz_time_line_item_bottom_bg);
      }
      localObject = this.vIV;
      if (localObject != null)
      {
        localView = this.vIV;
        if (localView != null) {
          break label229;
        }
        i = 0;
        localView = this.vIV;
        if (localView != null) {
          break label239;
        }
        j = 0;
        label89:
        ((View)localObject).setPadding(i, 0, j, com.tencent.mm.plugin.brandservice.ui.timeline.b.vGi);
      }
    }
    label229:
    label239:
    do
    {
      localObject = this.vIX;
      if (localObject != null) {
        ((ImageView)localObject).setBackgroundResource(d.d.biz_time_line_cover_mask_selector);
      }
      localObject = this.vIV;
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new f..ExternalSyntheticLambda0(this, paramab, paramqn));
      }
      s.u(paramqo, "bizInfo");
      s.u(paramqn, "appMsg");
      j = paramqo.YVI.size();
      i = k;
      if (j <= 1)
      {
        i = k;
        if (j == 1)
        {
          i = k;
          if (!Util.isNullOrNil(paramqn.YQI)) {
            i = 1;
          }
        }
      }
      if (i != 0)
      {
        paramab = this.vIX;
        if (paramab != null) {
          paramab.setBackgroundResource(d.d.biz_time_line_cover_bottom_round_mask_selector);
        }
      }
      return;
      i = localView.getPaddingLeft();
      break;
      j = localView.getPaddingRight();
      break label89;
      localObject = this.vIV;
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(d.d.biz_time_line_item_middle_bg);
      }
      localObject = this.vIV;
    } while (localObject == null);
    View localView = this.vIV;
    if (localView == null)
    {
      i = 0;
      label293:
      localView = this.vIV;
      if (localView != null) {
        break label331;
      }
    }
    label331:
    for (int j = 0;; j = localView.getPaddingRight())
    {
      ((View)localObject).setPadding(i, 0, j, 0);
      break;
      i = localView.getPaddingLeft();
      break label293;
    }
  }
  
  public final void c(MMNeat7extView paramMMNeat7extView)
  {
    this.vJa = paramMMNeat7extView;
  }
  
  public final void d(MMNeat7extView paramMMNeat7extView)
  {
    this.vJb = paramMMNeat7extView;
  }
  
  public final com.tencent.mm.plugin.brandservice.ui.timeline.b ddo()
  {
    return this.vHY;
  }
  
  public final void ddp()
  {
    Object localObject2 = null;
    if (this.caK == null) {
      return;
    }
    Object localObject1 = this.caK;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.vJc = ((View)localObject1);
      localObject1 = this.caK;
      if (localObject1 != null) {
        break label54;
      }
    }
    label54:
    for (localObject1 = localObject2;; localObject1 = (TextView)((View)localObject1).findViewById(d.e.friends_read_tv))
    {
      this.vJd = ((TextView)localObject1);
      return;
      localObject1 = ((View)localObject1).findViewById(d.e.stat_layout);
      break;
    }
  }
  
  public final void eE(View paramView)
  {
    this.vIV = paramView;
  }
  
  public final View getItemView()
  {
    return this.caK;
  }
  
  public final void hide()
  {
    View localView = this.caK;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.f
 * JD-Core Version:    0.7.0.1
 */