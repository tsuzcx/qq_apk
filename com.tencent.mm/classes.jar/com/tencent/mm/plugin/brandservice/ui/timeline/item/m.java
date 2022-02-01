package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.bizui.widget.BizRecTagTextView;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.plugin.findersdk.a.br;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.protocal.protobuf.fxo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "articleContentTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getArticleContentTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setArticleContentTv", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "clickCallback", "Lkotlin/Function0;", "", "getClickCallback", "()Lkotlin/jvm/functions/Function0;", "setClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "setClickView", "(Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "coverContainer", "getCoverContainer", "setCoverContainer", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "setCoverIv", "(Landroid/widget/ImageView;)V", "coverMaskIv", "getCoverMaskIv", "setCoverMaskIv", "digest", "getDigest", "setDigest", "digestLayout", "Landroid/widget/LinearLayout;", "getDigestLayout", "()Landroid/widget/LinearLayout;", "setDigestLayout", "(Landroid/widget/LinearLayout;)V", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "itemShowType", "", "getItemShowType", "()I", "setItemShowType", "(I)V", "itemView", "getItemView", "setItemView", "pressMask", "getPressMask", "setPressMask", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "tagTv", "Lcom/tencent/mm/plugin/bizui/widget/BizRecTagTextView;", "title", "getTitle", "setTitle", "txtJumpLink", "Landroid/widget/TextView;", "viewClose", "viewId", "getViewId", "setViewId", "width", "getWidth", "filling", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "getViewContainer", "gone", "inflate", "id", "initFeedBack", "initReaderItem", "itemInfo", "Lcom/tencent/mm/protocal/protobuf/ItemMsg;", "onAppMsgClick", "recommendItem", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "onInflate", "setCoverHeight", "view", "height", "shouldShowMe", "", "itemMsg", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class m
{
  private View caK;
  final Context context;
  private ImageView coverIv;
  private int nQm;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.b vHY;
  private final v vIN;
  private View vIV;
  private MMNeat7extView vIW;
  private ImageView vIX;
  private LinearLayout vJA;
  private TextView vJB;
  private View vJC;
  private WeImageView vJD;
  private BizRecTagTextView vJE;
  kotlin.g.a.a<kotlin.ah> vJe;
  View vJg;
  private ImageView vJx;
  private MMNeat7extView vJy;
  private MMNeat7extView vJz;
  private int viewId;
  private final int width;
  
  public m(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    this.context = paramContext;
    this.vHY = paramb;
    this.width = paramb.vFN.deL();
    this.nQm = -1;
    this.vIN = new v();
  }
  
  private static final void a(m paramm, enp paramenp, ab paramab, int paramInt, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramm);
    localb.cH(paramenp);
    localb.cH(paramab);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramm, "this$0");
    s.u(paramab, "$info");
    paramView = paramm.vJe;
    if (paramView != null) {
      paramView.invoke();
    }
    if (paramenp.abse.aaID != null)
    {
      paramView = paramenp.abse.aaID.YRk;
      if (Util.isNullOrNil(paramView)) {
        break label251;
      }
      paramView = XmlParser.parseXml(paramView, "finder_feed", null);
      if (paramView == null) {
        break label342;
      }
      localObject = ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(26, 2, 25, null);
    }
    label342:
    for (boolean bool = ((br)com.tencent.mm.kernel.h.ax(br.class)).a(paramm.context, "", paramView, (String)localObject);; bool = false)
    {
      if (bool)
      {
        paramm.vHY.vFK.d(paramab, paramInt, (int)(System.currentTimeMillis() / 1000L));
        Log.i("MicroMsg.BizTimeLineItem", "enter finder success!");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        return;
        paramView = null;
        break;
        label251:
        s.s(paramenp, "itemMsg");
        s.u(paramab, "info");
        s.u(paramenp, "recommendItem");
        if ((paramab.acFJ == null) || (paramenp.absd == null) || (paramenp.abse == null))
        {
          Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
        }
        else
        {
          paramView = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramm.context, paramab, paramenp);
          paramm.vHY.vFK.d(paramab, 0, (int)(System.currentTimeMillis() / 1000L));
        }
      }
    }
  }
  
  private static final void a(m paramm, ab paramab, int paramInt, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramm);
    localb.cH(paramab);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramm, "this$0");
    s.u(paramab, "$info");
    ((h)new h(paramm.context, paramab, paramm.vHY, paramInt).mj((View)paramm.vJD)).show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public static void ab(View paramView, int paramInt)
  {
    if (paramView == null) {}
    for (ViewGroup.LayoutParams localLayoutParams = null;; localLayoutParams = paramView.getLayoutParams())
    {
      if (localLayoutParams != null) {
        localLayoutParams.height = paramInt;
      }
      if (paramView != null) {
        paramView.setLayoutParams(localLayoutParams);
      }
      return;
    }
  }
  
  public void a(ddb paramddb)
  {
    s.u(paramddb, "itemInfo");
    this.vIN.type = paramddb.nUA;
    this.vIN.nUM = paramddb.YQM;
    this.vIN.nVd = paramddb.YQN;
    this.vIN.url = paramddb.YQK;
  }
  
  public void a(ab paramab, int paramInt, View paramView1, View paramView2)
  {
    s.u(paramab, "info");
    s.u(paramView1, "convertView");
    s.u(paramView2, "parent");
    int i = getViewId();
    s.u(paramView2, "parent");
    if (this.caK == null)
    {
      paramView1 = ((ViewStub)paramView2.findViewById(i)).inflate();
      this.vIV = paramView1.findViewById(d.e.chatting_item_rec_feed_click_view);
      this.vIX = ((ImageView)paramView1.findViewById(d.e.press_mask_iv));
      this.vIW = ((MMNeat7extView)paramView1.findViewById(d.e.chatting_item_rec_feed_title_tv));
      this.vJy = ((MMNeat7extView)paramView1.findViewById(d.e.chatting_item_rec_feed_digest_tv));
      this.vJz = ((MMNeat7extView)paramView1.findViewById(d.e.chatting_item_rec_feed_content_tv));
      this.vJg = paramView2.findViewById(d.e.chatting_item_rec_feed_cover_ll);
      this.coverIv = ((ImageView)paramView1.findViewById(d.e.cover));
      this.vJx = ((ImageView)paramView1.findViewById(d.e.cover_mask_iv));
      this.vJB = ((TextView)paramView1.findViewById(d.e.jump_link));
      this.vJA = ((LinearLayout)paramView1.findViewById(d.e.biz_time_line_rec_feed_digest_layout));
      this.vJC = paramView1.findViewById(d.e.close_layout);
      this.vJD = ((WeImageView)paramView1.findViewById(d.e.close_iv));
      this.vJE = ((BizRecTagTextView)paramView1.findViewById(d.e.rec_feed_tag));
      paramView2 = kotlin.ah.aiuX;
      this.caK = paramView1;
      ddz();
    }
    paramView1 = (Collection)paramab.acFJ.YVA;
    if ((paramView1 == null) || (paramView1.isEmpty()))
    {
      i = 1;
      if (i == 0) {
        break label665;
      }
      paramView1 = this.vJC;
      if (paramView1 != null) {
        paramView1.setVisibility(8);
      }
      label292:
      paramView1 = this.vJC;
      if (paramView1 != null) {
        paramView1.setOnClickListener(new m..ExternalSyntheticLambda1(this, paramab, paramInt));
      }
      if (com.tencent.mm.cd.a.getScaleSize(this.context) >= 1.125F)
      {
        paramView1 = com.tencent.mm.plugin.bizui.a.a.vtB;
        com.tencent.mm.plugin.bizui.a.a.r((View)this.vJD, com.tencent.mm.cd.a.fromDPToPix(this.context, 31), com.tencent.mm.cd.a.fromDPToPix(this.context, 21));
      }
      paramView1 = this.caK;
      if (paramView1 != null) {
        paramView1.setVisibility(0);
      }
      paramView1 = (enp)paramab.acFJ.abrC.get(0);
      paramView2 = paramView1.abse;
      s.s(paramView2, "itemMsg.ItemInfo");
      a(paramView2);
      paramView2 = this.vIV;
      if (paramView2 != null) {
        paramView2.setOnClickListener(new m..ExternalSyntheticLambda0(this, paramView1, paramab, paramInt));
      }
      paramView2 = (CharSequence)paramView1.abrE;
      if ((paramView2 != null) && (!n.bp(paramView2))) {
        break label682;
      }
      i = 1;
      label462:
      if (i == 0) {
        break label688;
      }
      paramView2 = this.vJy;
      if (paramView2 != null) {
        paramView2.aZ((CharSequence)"");
      }
      paramView2 = this.vJy;
      if (paramView2 != null) {
        paramView2.setVisibility(8);
      }
      label507:
      paramView2 = this.vJB;
      if (paramView2 != null)
      {
        Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
        localObject = this.vHY.vFK;
        s.s(paramView1, "itemMsg");
        com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a((f)localObject, paramInt, paramab, paramView1, paramView2, this.context);
      }
      paramab = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.vNK;
      com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(paramView1.abrF, this.vJE);
      paramab = (CharSequence)paramView1.abrE;
      if ((paramab != null) && (!n.bp(paramab))) {
        break label731;
      }
      paramInt = 1;
      label589:
      if (paramInt == 0) {
        break label746;
      }
      paramab = (CharSequence)paramView1.Zxr;
      if ((paramab != null) && (!n.bp(paramab))) {
        break label736;
      }
      paramInt = 1;
      label614:
      if (paramInt == 0)
      {
        paramab = (CharSequence)paramView1.Zxq;
        if ((paramab != null) && (!n.bp(paramab))) {
          break label741;
        }
        paramInt = 1;
        label639:
        if (paramInt == 0) {
          break label746;
        }
      }
      paramab = this.vJA;
      if (paramab != null) {
        paramab.setVisibility(8);
      }
    }
    label665:
    label682:
    label688:
    label731:
    label736:
    label741:
    label746:
    do
    {
      return;
      i = 0;
      break;
      paramView1 = this.vJC;
      if (paramView1 == null) {
        break label292;
      }
      paramView1.setVisibility(0);
      break label292;
      i = 0;
      break label462;
      paramView2 = this.vJy;
      if (paramView2 != null) {
        paramView2.setVisibility(0);
      }
      paramView2 = this.vJy;
      if (paramView2 == null) {
        break label507;
      }
      paramView2.aZ((CharSequence)paramView1.abrE);
      break label507;
      paramInt = 0;
      break label589;
      paramInt = 0;
      break label614;
      paramInt = 0;
      break label639;
      paramab = this.vJA;
    } while (paramab == null);
    paramab.setVisibility(0);
  }
  
  public boolean a(enp paramenp)
  {
    if (paramenp == null) {}
    do
    {
      do
      {
        return false;
      } while ((com.tencent.mm.storage.ah.b(paramenp)) || (paramenp == null));
      paramenp = paramenp.abse;
    } while ((paramenp == null) || (paramenp.nUA != getItemShowType()));
    return true;
  }
  
  public final com.tencent.mm.plugin.brandservice.ui.timeline.b ddo()
  {
    return this.vHY;
  }
  
  public abstract void ddv();
  
  public final MMNeat7extView ddw()
  {
    return this.vIW;
  }
  
  public final MMNeat7extView ddx()
  {
    return this.vJz;
  }
  
  public final v ddy()
  {
    return this.vIN;
  }
  
  public void ddz() {}
  
  public final ImageView getCoverIv()
  {
    return this.coverIv;
  }
  
  public int getItemShowType()
  {
    return this.nQm;
  }
  
  public final View getItemView()
  {
    return this.caK;
  }
  
  public int getViewId()
  {
    return this.viewId;
  }
  
  public final int getWidth()
  {
    return this.width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.m
 * JD-Core Version:    0.7.0.1
 */