package com.tencent.mm.plugin.emoji.ui.v3.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.g.b.a;
import com.tencent.mm.plugin.emoji.g.c;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.model.k.a;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.view.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.am;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3HomeMainHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BaseHolder;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmotionTypeItem;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3StatusView;", "context", "Landroid/content/Context;", "itemView", "Landroid/view/View;", "designerNewProductList", "", "", "enableReward", "", "enableSendToFriend", "clickListener", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3HomeItemClickListener;", "(Landroid/content/Context;Landroid/view/View;Ljava/util/List;ZZLcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3HomeItemClickListener;)V", "TAG", "belowTitleIntroduceTv", "Landroid/widget/TextView;", "getClickListener", "()Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3HomeItemClickListener;", "container", "containerRoot", "getContext", "()Landroid/content/Context;", "dataModel", "Lcom/tencent/mm/plugin/emoji/model/IEmojiStoreTypeRecModel;", "getDataModel", "()Lcom/tencent/mm/plugin/emoji/model/IEmojiStoreTypeRecModel;", "setDataModel", "(Lcom/tencent/mm/plugin/emoji/model/IEmojiStoreTypeRecModel;)V", "getDesignerNewProductList", "()Ljava/util/List;", "downloadProgress", "Landroid/widget/ProgressBar;", "downloadProgressRoot", "emotionData", "Lcom/tencent/mm/plugin/emoji/adapter/data/EmotionItem;", "getEnableReward", "()Z", "setEnableReward", "(Z)V", "getEnableSendToFriend", "setEnableSendToFriend", "firstEmotionItemShape", "Landroid/graphics/drawable/Drawable;", "iconImg", "Landroid/widget/ImageView;", "iconWH", "", "infoTag", "introduceRoot", "Landroid/view/ViewGroup;", "itemMinHeight", "", "getItemView", "()Landroid/view/View;", "marginPixel", "", "nonFirstEmotionItemShape", "normBgColor", "pressBgColor", "radius", "getRadius", "()F", "rightBtnDataPriceRoot", "rightBtnRoot", "rightImg", "rightTv", "rightViewStatusController", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3PayOrDownloadComponent;", "getRightViewStatusController", "()Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3PayOrDownloadComponent;", "setRightViewStatusController", "(Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3PayOrDownloadComponent;)V", "stateGooglePriceLoading", "tipImg", "titleNewTip", "titleTv", "dealActivityLimitView", "", "dealCurrentDownloadView", "dealDownloadedView", "dealDownloadingView", "dealExpiredView", "dealFreeDownloadView", "dealLoadGoogleMarketFailView", "dealLoadingGoogleMarketView", "dealRewardView", "dealWaitForDownloadView", "dealWaitForPayView", "dellCellSet", "item", "forceRefreshItemStatus", "productId", "getEmotionData", "getIconWH", "getItemMinH", "getSelfPosition", "onBind", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "payloads", "", "", "reCheckIconImg", "wh", "reCheckItemMinHeight", "minH", "refreshRightBtnView", "safeReplaceStatus", "emotionItem", "status", "setIntroduce", "introduce", "showTag", "setIntroduct", "updateProgress", "progress", "updateStatus", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends e<s>
  implements w
{
  private final String TAG;
  private final View caK;
  private final Context context;
  private final View hDw;
  private final float radius;
  private final TextView titleTv;
  private int[] xFW;
  private final v ybO;
  public p ybU;
  private final List<String> ybW;
  private boolean ybX;
  private boolean ybY;
  private final View ybZ;
  private final int ybv;
  private final int ybw;
  private final ImageView yca;
  private final View ycb;
  private final ViewGroup ycc;
  private final TextView ycd;
  private ImageView yce;
  private final View ycf;
  private final ViewGroup ycg;
  private TextView ych;
  private View yci;
  private ImageView ycj;
  private View yck;
  private ProgressBar ycl;
  private ProgressBar ycm;
  private final int ycn;
  private final Drawable yco;
  private final Drawable ycp;
  private final float ycq;
  public n ycr;
  private f ycs;
  
  private j(Context paramContext, View paramView, List<String> paramList, v paramv)
  {
    super(paramView, (u)paramv);
    AppMethodBeat.i(270702);
    this.context = paramContext;
    this.caK = paramView;
    this.ybW = paramList;
    this.ybX = false;
    this.ybY = true;
    this.ybO = paramv;
    paramContext = this.caK.findViewById(h.e.item_list_content);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.item_list_content)");
    this.ybZ = paramContext;
    paramContext = this.caK.findViewById(h.e.item_container);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.item_container)");
    this.hDw = paramContext;
    paramContext = this.caK.findViewById(h.e.item_icon);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.item_icon)");
    this.yca = ((ImageView)paramContext);
    paramContext = this.caK.findViewById(h.e.item_name);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.item_name)");
    this.titleTv = ((TextView)paramContext);
    paramContext = this.caK.findViewById(h.e.item_option);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.item_option)");
    this.ycb = paramContext;
    paramContext = this.caK.findViewById(h.e.item_root);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.item_root)");
    this.ycc = ((ViewGroup)paramContext);
    paramContext = this.caK.findViewById(h.e.item_state);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.item_state)");
    this.ycd = ((TextView)paramContext);
    paramContext = this.caK.findViewById(h.e.item_tip);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.item_tip)");
    this.yce = ((ImageView)paramContext);
    paramContext = this.caK.findViewById(h.e.item_name_new_tip);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.item_name_new_tip)");
    this.ycf = paramContext;
    paramContext = this.caK.findViewById(h.e.item_introduce_root);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.item_introduce_root)");
    this.ycg = ((ViewGroup)paramContext);
    paramContext = this.caK.findViewById(h.e.item_introduce);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.item_introduce)");
    this.ych = ((TextView)paramContext);
    paramContext = this.caK.findViewById(h.e.emoji_preview_info_tag);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.emoji_preview_info_tag)");
    this.yci = paramContext;
    paramContext = this.caK.findViewById(h.e.item_state_image);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.item_state_image)");
    this.ycj = ((ImageView)paramContext);
    paramContext = this.caK.findViewById(h.e.item_progress_bar);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.item_progress_bar)");
    this.yck = paramContext;
    paramContext = this.caK.findViewById(h.e.item_download_progress);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.item_download_progress)");
    this.ycl = ((ProgressBar)paramContext);
    paramContext = this.caK.findViewById(h.e.price_loading);
    kotlin.g.b.s.s(paramContext, "itemView.findViewById(R.id.price_loading)");
    this.ycm = ((ProgressBar)paramContext);
    this.xFW = new int[] { -1, -1 };
    this.ycn = -1;
    this.radius = d.e(this.context, 8.0F);
    this.ybv = com.tencent.mm.cd.a.w(this.context, h.b.BW_100);
    this.ybw = com.tencent.mm.cd.a.w(this.context, h.b.BW_0_Alpha_0_0_5);
    paramContext = com.tencent.mm.plugin.emoji.g.a.ydF;
    this.yco = com.tencent.mm.plugin.emoji.g.a.a(this.ybv, this.ybw, this.radius, this.radius, 0.0F, 0.0F);
    paramContext = com.tencent.mm.plugin.emoji.g.a.ydF;
    this.ycp = com.tencent.mm.plugin.emoji.g.a.a(this.ybv, this.ybw, 0.0F, 0.0F, 0.0F, 0.0F);
    this.ycq = this.context.getResources().getDimension(h.c.Edge_A);
    this.TAG = "MicroMsg.EmojiStoreV3HomeMainHolder";
    AppMethodBeat.o(270702);
  }
  
  private void D(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(270726);
    kotlin.g.b.s.u(paramArrayOfInt, "wh");
    if ((paramArrayOfInt.length != 2) || (paramArrayOfInt[0] < 0) || (paramArrayOfInt[1] < 0) || ((paramArrayOfInt[0] == this.xFW[0]) && (paramArrayOfInt[1] == this.xFW[1])))
    {
      AppMethodBeat.o(270726);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.yca.getLayoutParams();
    kotlin.g.b.s.s(localLayoutParams, "iconImg.layoutParams");
    localLayoutParams.width = paramArrayOfInt[0];
    localLayoutParams.height = paramArrayOfInt[1];
    this.yca.setLayoutParams(localLayoutParams);
    this.xFW = paramArrayOfInt;
    AppMethodBeat.o(270726);
  }
  
  private void KG(int paramInt)
  {
    AppMethodBeat.i(270730);
    if ((paramInt < 0) || (this.ycn == paramInt))
    {
      AppMethodBeat.o(270730);
      return;
    }
    this.caK.setMinimumHeight(paramInt);
    this.hDw.setMinimumHeight(paramInt);
    AppMethodBeat.o(270730);
  }
  
  private void a(f paramf, String paramString, int paramInt)
  {
    AppMethodBeat.i(270743);
    if ((paramf == null) || (paramString == null) || (kotlin.g.b.s.p(paramString, "")))
    {
      AppMethodBeat.o(270743);
      return;
    }
    paramf.setStatus(paramInt);
    paramf = this.ybU;
    if (paramf != null) {
      paramf.dZ(paramString, paramInt);
    }
    AppMethodBeat.o(270743);
  }
  
  private static final void a(j paramj, t paramt, View paramView)
  {
    AppMethodBeat.i(270776);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3HomeMainHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "this$0");
    kotlin.g.b.s.u(paramt, "$item");
    paramView = paramj.ybO;
    if (paramView != null) {
      paramView.b((e)paramj, paramj.KJ(), paramt);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3HomeMainHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(270776);
  }
  
  private void anK(String paramString)
  {
    AppMethodBeat.i(270715);
    if (Util.isNullOrNil(paramString))
    {
      this.ycg.setVisibility(8);
      this.ych.setVisibility(8);
      AppMethodBeat.o(270715);
      return;
    }
    this.ycg.setVisibility(0);
    this.ych.setVisibility(0);
    this.ych.setText((CharSequence)paramString);
    AppMethodBeat.o(270715);
  }
  
  private void anL(String paramString)
  {
    AppMethodBeat.i(270719);
    this.ycg.setVisibility(0);
    this.ych.setVisibility(0);
    this.ych.setText((CharSequence)paramString);
    this.yci.setVisibility(0);
    AppMethodBeat.o(270719);
  }
  
  private final boolean b(f paramf)
  {
    AppMethodBeat.i(270711);
    paramf = paramf.xHF;
    if (paramf == null)
    {
      this.ycb.setVisibility(0);
      AppMethodBeat.o(270711);
      return false;
    }
    String str = paramf.hAP;
    this.titleTv.setText((CharSequence)str);
    anK(paramf.IGG);
    if (!Util.isNullOrNil(paramf.IHo)) {
      r.bKe().a(paramf.IHo, this.yca, com.tencent.mm.plugin.emoji.mgr.e.gJ("", paramf.IHo));
    }
    if (!Util.isNullOrNil(paramf.akjW))
    {
      r.bKe().a(paramf.akjW, this.yce, com.tencent.mm.plugin.emoji.mgr.e.gJ("", paramf.akjW));
      this.yce.setVisibility(0);
    }
    for (;;)
    {
      this.ycb.setVisibility(8);
      AppMethodBeat.o(270711);
      return true;
      this.yce.setVisibility(8);
    }
  }
  
  private void dDe()
  {
    AppMethodBeat.i(270746);
    f localf = this.ycs;
    if (localf == null)
    {
      AppMethodBeat.o(270746);
      return;
    }
    this.ycm.setVisibility(8);
    this.ycc.setBackgroundResource(h.d.btn_solid_green);
    this.ycc.setVisibility(0);
    this.ycc.setTag(localf.xHE.ProductID);
    this.ycb.setEnabled(true);
    this.ycd.setVisibility(0);
    this.ycd.setText(h.h.emoji_store_use);
    this.ycd.setTextColor(this.context.getResources().getColorStateList(h.b.white_text_color_selector));
    this.ycj.setVisibility(4);
    this.yck.setVisibility(4);
    AppMethodBeat.o(270746);
  }
  
  private void dDf()
  {
    AppMethodBeat.i(270750);
    this.ycm.setVisibility(8);
    this.ycc.setBackgroundResource(h.d.btn_solid_green);
    this.ycc.setEnabled(false);
    this.ycc.setVisibility(0);
    this.yci.setVisibility(0);
    this.ycb.setEnabled(false);
    this.ycd.setTextColor(this.ycd.getResources().getColorStateList(h.b.emoji_download_finish_color));
    this.ycd.setVisibility(0);
    this.ycd.setText(h.h.emoji_preview_activity_limit);
    this.ycj.setVisibility(4);
    this.yck.setVisibility(4);
    AppMethodBeat.o(270750);
  }
  
  private void dDg()
  {
    AppMethodBeat.i(270752);
    this.ycm.setVisibility(8);
    this.ycc.setBackgroundDrawable(null);
    this.ycc.setVisibility(0);
    this.ycb.setEnabled(false);
    this.ycd.setVisibility(0);
    this.ycd.setText(h.h.emoji_store_expire);
    this.ycj.setVisibility(4);
    this.yck.setVisibility(4);
    AppMethodBeat.o(270752);
  }
  
  private void dDh()
  {
    AppMethodBeat.i(270758);
    this.ycm.setVisibility(8);
    this.ycc.setVisibility(0);
    this.ycc.setBackgroundResource(h.d.btn_solid_white);
    this.ycd.setVisibility(0);
    this.ycd.setText(h.h.emoji_store_downloaded);
    this.ycd.setTextColor(this.context.getResources().getColorStateList(h.b.black_text_color_disabled));
    this.ycj.setVisibility(4);
    this.ycb.setEnabled(false);
    this.yck.setVisibility(4);
    AppMethodBeat.o(270758);
  }
  
  private void dDi()
  {
    AppMethodBeat.i(270765);
    Object localObject1 = this.ycs;
    if (localObject1 == null)
    {
      AppMethodBeat.o(270765);
      return;
    }
    this.ycm.setVisibility(8);
    this.ycc.setBackgroundResource(h.d.btn_solid_white);
    this.ycc.setVisibility(0);
    this.yck.setVisibility(4);
    this.ycb.setEnabled(true);
    this.ycj.setVisibility(4);
    this.ycd.setVisibility(0);
    Object localObject2;
    if (((f)localObject1).xHE != null)
    {
      localObject2 = com.tencent.mm.plugin.emoji.g.b.ydG;
      if (!b.a.KK(((f)localObject1).xHE.akke)) {
        break label236;
      }
      localObject2 = this.ycd;
      Object localObject3 = com.tencent.mm.plugin.emoji.g.b.ydG;
      ((TextView)localObject2).setText(b.a.c(this.context, ((f)localObject1).xHE.akkv, ""));
      localObject2 = this.ycd;
      localObject3 = am.aixg;
      localObject3 = MMApplicationContext.getString(h.h.emoji_wecoin_price_unit);
      kotlin.g.b.s.s(localObject3, "getString(R.string.emoji_wecoin_price_unit)");
      localObject1 = String.format((String)localObject3, Arrays.copyOf(new Object[] { Integer.valueOf(((f)localObject1).xHE.akkv) }, 1));
      kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
      ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
    }
    for (;;)
    {
      this.ycd.setTextColor(this.context.getResources().getColorStateList(h.b.white_text_color_selector));
      this.ycc.setBackgroundResource(h.d.btn_solid_green);
      AppMethodBeat.o(270765);
      return;
      label236:
      this.ycd.setText((CharSequence)((f)localObject1).xHE.akkc);
      localObject1 = this.ycd;
      localObject2 = am.aixg;
      localObject2 = MMApplicationContext.getString(h.h.emoji_price_unit);
      kotlin.g.b.s.s(localObject2, "getString(R.string.emoji_price_unit)");
      localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { this.ycd.getText() }, 1));
      kotlin.g.b.s.s(localObject2, "java.lang.String.format(format, *args)");
      ((TextView)localObject1).setContentDescription((CharSequence)localObject2);
    }
  }
  
  private void dDj()
  {
    AppMethodBeat.i(270767);
    this.ycm.setVisibility(0);
    this.ycc.setBackgroundResource(h.d.btn_solid_white);
    this.ycc.setVisibility(0);
    this.ycd.setVisibility(0);
    this.ycd.setText((CharSequence)"");
    this.ycb.setEnabled(false);
    this.ycj.setVisibility(4);
    this.yck.setVisibility(4);
    AppMethodBeat.o(270767);
  }
  
  private void dDk()
  {
    AppMethodBeat.i(270770);
    this.ycm.setVisibility(8);
    this.ycc.setBackgroundResource(h.d.btn_solid_white);
    this.ycc.setVisibility(0);
    this.ycd.setVisibility(0);
    this.ycd.setText(h.h.emoji_store_play);
    this.ycj.setVisibility(4);
    this.ycb.setEnabled(true);
    this.yck.setVisibility(4);
    AppMethodBeat.o(270770);
  }
  
  private void dDl()
  {
    AppMethodBeat.i(270773);
    this.ycc.setVisibility(0);
    this.ycc.setBackgroundResource(h.d.btn_solid_red);
    this.ycd.setVisibility(0);
    this.ycd.setText(h.h.emoji_store_reward);
    this.ycd.setTextColor(this.context.getResources().getColorStateList(h.b.white_text_color_selector));
    this.ycj.setVisibility(4);
    this.ycb.setEnabled(true);
    this.yck.setVisibility(4);
    AppMethodBeat.o(270773);
  }
  
  private int[] dxU()
  {
    AppMethodBeat.i(270735);
    int i = com.tencent.mm.cd.a.br(this.context, h.c.emoji_store_v3_list_item_icon_size);
    AppMethodBeat.o(270735);
    return new int[] { i, i };
  }
  
  private int dxV()
  {
    AppMethodBeat.i(270742);
    int i = com.tencent.mm.cd.a.br(this.context, h.c.emoji_store_v3_list_item_min_height);
    AppMethodBeat.o(270742);
    return i;
  }
  
  private void dyc()
  {
    AppMethodBeat.i(270755);
    Object localObject1 = this.ycs;
    if (localObject1 == null)
    {
      AppMethodBeat.o(270755);
      return;
    }
    this.ycm.setVisibility(8);
    this.ycc.setVisibility(8);
    this.ycb.setEnabled(false);
    this.ycj.setVisibility(8);
    this.ycl.setVisibility(0);
    this.ycl.setProgress(((f)localObject1).boE);
    ProgressBar localProgressBar = this.ycl;
    Object localObject2 = am.aixg;
    localObject2 = MMApplicationContext.getString(h.h.emoji_download);
    kotlin.g.b.s.s(localObject2, "getString(R.string.emoji_download)");
    localObject1 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(((f)localObject1).boE) }, 1));
    kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
    localProgressBar.setContentDescription((CharSequence)localObject1);
    this.yck.setVisibility(0);
    AppMethodBeat.o(270755);
  }
  
  private void dyd()
  {
    AppMethodBeat.i(270762);
    this.ycm.setVisibility(8);
    this.ycc.setBackgroundResource(h.d.btn_solid_green);
    this.ycc.setVisibility(0);
    this.ycb.setEnabled(true);
    this.ycd.setText((CharSequence)"");
    this.yck.setVisibility(4);
    this.ycd.setVisibility(0);
    this.ycd.setText(h.h.emoji_store_download);
    this.ycd.setTextColor(this.context.getResources().getColorStateList(h.b.white_text_color_selector));
    this.ycj.setVisibility(8);
    AppMethodBeat.o(270762);
  }
  
  public final void a(t paramt)
  {
    AppMethodBeat.i(270781);
    kotlin.g.b.s.u(paramt, "item");
    super.a(paramt);
    a(paramt, (List)new ArrayList());
    AppMethodBeat.o(270781);
  }
  
  public final void a(t paramt, List<Object> paramList)
  {
    AppMethodBeat.i(270783);
    kotlin.g.b.s.u(paramt, "item");
    kotlin.g.b.s.u(paramList, "payloads");
    super.a(paramt, paramList);
    if (!((Collection)paramList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      dye();
      AppMethodBeat.o(270783);
      return;
    }
    if ((paramt instanceof s))
    {
      paramList = (s)paramt;
      if (paramList != null) {
        break label94;
      }
    }
    label94:
    for (paramList = null;; paramList = paramList.ycP)
    {
      if (paramList != null) {
        break label102;
      }
      AppMethodBeat.o(270783);
      return;
      paramList = null;
      break;
    }
    label102:
    this.ycs = paramList;
    if (this.ybX)
    {
      paramList.xHL = true;
      paramList.xHJ = true;
      paramList.xHK = false;
    }
    paramList.xHK = this.ybY;
    if (b(paramList))
    {
      AppMethodBeat.o(270783);
      return;
    }
    cjb localcjb = paramList.xHE;
    if (localcjb == null)
    {
      AppMethodBeat.o(270783);
      return;
    }
    this.titleTv.setText((CharSequence)localcjb.Zul);
    boolean bool;
    if (c.i(localcjb))
    {
      r.bKe().loadImage("", this.yca);
      this.yca.setImageResource(h.d.icon_002_cover);
      D(dxU());
      KG(dxV());
      bool = com.tencent.mm.plugin.emoji.a.a.e.f(localcjb);
      if (TextUtils.isEmpty((CharSequence)localcjb.akkB)) {
        break label449;
      }
      this.yce.setImageDrawable(null);
      this.yce.setVisibility(0);
      r.bKe().a(localcjb.akkB, this.yce, com.tencent.mm.plugin.emoji.mgr.e.gJ("", localcjb.akkB));
      label295:
      View localView = this.ycf;
      if (!this.ybW.contains(localcjb.ProductID)) {
        break label487;
      }
      i = 0;
      label320:
      localView.setVisibility(i);
      if ((paramList.xHG == null) || (!com.tencent.mm.plugin.emoji.a.a.e.gO(paramList.xHG.akke, 128))) {
        break label493;
      }
      anL(paramList.xHG.akkt);
      dye();
      this.hDw.setBackgroundResource(h.d.comm_list_item_selector_no_divider);
      if (!((s)paramt).isFirst) {
        break label527;
      }
      this.ybZ.setBackground(this.yco);
    }
    for (;;)
    {
      this.ycb.setOnClickListener(new j..ExternalSyntheticLambda0(this, paramt));
      AppMethodBeat.o(270783);
      return;
      r.bKe().a(localcjb.IHo, this.yca, com.tencent.mm.plugin.emoji.mgr.e.gJ(localcjb.ProductID, localcjb.IHo));
      break;
      label449:
      if (bool)
      {
        this.yce.setVisibility(0);
        this.yce.setImageResource(h.d.emotionstore_newtips);
        break label295;
      }
      this.yce.setVisibility(8);
      break label295;
      label487:
      i = 8;
      break label320;
      label493:
      if (!Util.isNullOrNil(localcjb.akkC)) {}
      for (paramList = localcjb.akkC;; paramList = localcjb.akkA)
      {
        anK(paramList);
        break;
      }
      label527:
      this.ybZ.setBackground(this.ycp);
    }
  }
  
  public final void anO(String paramString)
  {
    AppMethodBeat.i(270788);
    kotlin.g.b.s.u(paramString, "productId");
    f localf = this.ycs;
    if (localf == null)
    {
      AppMethodBeat.o(270788);
      return;
    }
    localf.setStatus(-1);
    boolean bool = h.dDc();
    Object localObject = this.ybU;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((p)localObject).anQ(paramString))
    {
      k.a locala = k.xML;
      localf.a(bool, (bj)localObject, k.a.anP(paramString));
      AppMethodBeat.o(270788);
      return;
    }
  }
  
  public final void aoY(String paramString)
  {
    AppMethodBeat.i(270786);
    kotlin.g.b.s.u(paramString, "productId");
    f localf = this.ycs;
    if (localf == null)
    {
      AppMethodBeat.o(270786);
      return;
    }
    a(localf, paramString, 6);
    localf.boE = 0;
    dye();
    AppMethodBeat.o(270786);
  }
  
  public final void bg(int paramInt, String paramString)
  {
    AppMethodBeat.i(270787);
    kotlin.g.b.s.u(paramString, "productId");
    f localf = this.ycs;
    if (localf == null)
    {
      AppMethodBeat.o(270787);
      return;
    }
    a(localf, paramString, paramInt);
    boolean bool;
    if (localf.mStatus == -1)
    {
      Log.i(this.TAG, "force refresh status");
      bool = h.dDc();
      localObject = this.ybU;
      if (localObject != null) {
        break label104;
      }
    }
    label104:
    for (Object localObject = null;; localObject = ((p)localObject).anQ(paramString))
    {
      k.a locala = k.xML;
      localf.a(bool, (bj)localObject, k.a.anP(paramString));
      dye();
      AppMethodBeat.o(270787);
      return;
    }
  }
  
  public final f dDd()
  {
    return this.ycs;
  }
  
  public final void dye()
  {
    AppMethodBeat.i(270789);
    f localf = this.ycs;
    if (localf == null)
    {
      AppMethodBeat.o(270789);
      return;
    }
    this.ycd.setVisibility(8);
    this.ycd.setTextColor(this.context.getResources().getColorStateList(h.b.black_text_color_selector));
    switch (localf.mStatus)
    {
    case 1: 
    case 2: 
    case 5: 
    case 9: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      Log.w(this.TAG, "unknown product status:%d", new Object[] { Integer.valueOf(localf.mStatus) });
      AppMethodBeat.o(270789);
      return;
    case 8: 
      dDg();
      AppMethodBeat.o(270789);
      return;
    case 0: 
      dyd();
      AppMethodBeat.o(270789);
      return;
    case 6: 
      dyc();
      AppMethodBeat.o(270789);
      return;
    case 7: 
      if (localf.xHJ)
      {
        dDe();
        AppMethodBeat.o(270789);
        return;
      }
      if ((localf.xHL) && (com.tencent.mm.plugin.emoji.a.a.e.gO(localf.xHE.akke, 64)))
      {
        dDl();
        AppMethodBeat.o(270789);
        return;
      }
      dDh();
      AppMethodBeat.o(270789);
      return;
    case 3: 
      dyd();
      AppMethodBeat.o(270789);
      return;
    case 4: 
    case 12: 
      dDi();
      AppMethodBeat.o(270789);
      return;
    case 10: 
      dDk();
      AppMethodBeat.o(270789);
      return;
    case 11: 
      dDj();
      AppMethodBeat.o(270789);
      return;
    }
    dDf();
    AppMethodBeat.o(270789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.j
 * JD-Core Version:    0.7.0.1
 */