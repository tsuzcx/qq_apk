package com.tencent.mm.plugin.card.ui.v4;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.m;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter$CardTicketVH;", "isInvalid", "", "(Z)V", "cardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "getModelByPos", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateModelList", "CardTicketVH", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.a<a>
{
  public static final c.b wId;
  private final boolean wGC;
  private ArrayList<a> wIe;
  
  static
  {
    AppMethodBeat.i(294354);
    wId = new c.b((byte)0);
    AppMethodBeat.o(294354);
  }
  
  public c(boolean paramBoolean)
  {
    this.wGC = paramBoolean;
  }
  
  public final a IJ(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(294383);
    Object localObject = this.wIe;
    if (localObject != null)
    {
      int i = j;
      if (paramInt >= 0)
      {
        i = j;
        if (paramInt < ((ArrayList)localObject).size()) {
          i = 1;
        }
      }
      if (i != 0)
      {
        localObject = (a)((ArrayList)localObject).get(paramInt);
        AppMethodBeat.o(294383);
        return localObject;
      }
    }
    AppMethodBeat.o(294383);
    return null;
  }
  
  public final void U(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(294390);
    this.wIe = paramArrayList;
    this.bZE.notifyChanged();
    AppMethodBeat.o(294390);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(294366);
    int i = 0;
    ArrayList localArrayList = this.wIe;
    if (localArrayList != null) {
      i = localArrayList.size() + 0;
    }
    AppMethodBeat.o(294366);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(294376);
    a locala = IJ(paramInt);
    if (locala != null)
    {
      Object localObject1 = locala.title;
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = locala.wIa;
      if (localObject1 == null)
      {
        localObject1 = "";
        localObject1 = s.X((String)localObject2, localObject1);
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label132;
        }
      }
      label132:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label137;
        }
        l = locala.hashCode();
        AppMethodBeat.o(294376);
        return l;
        String str = ((vt)localObject1).YBH;
        localObject1 = str;
        if (str != null) {
          break;
        }
        localObject1 = "";
        break;
      }
      label137:
      long l = s.X((String)localObject1, Integer.valueOf(paramInt)).hashCode();
      AppMethodBeat.o(294376);
      return l;
    }
    Log.e("MicroMsg.CouponAndGiftCardListAdapter", "[getItemId] position=" + paramInt + " itemCount=" + getItemCount() + " }");
    AppMethodBeat.o(294376);
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(294358);
    a locala = IJ(paramInt);
    if (locala != null)
    {
      paramInt = locala.type;
      AppMethodBeat.o(294358);
      return paramInt;
    }
    AppMethodBeat.o(294358);
    return -1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter$CardTicketVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "bgIv", "Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "descTv", "Landroid/widget/TextView;", "labelLayout", "Landroid/widget/LinearLayout;", "mViewHeight", "mViewWidth", "roundCornerIv", "Landroid/widget/ImageView;", "shadowBgIv", "subTextLayout", "titleTv", "bindCommonCardDataModel", "", "element", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "cardType", "bindCouponCardDataModel", "bindDataModel", "model", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "updateSubLabelText", "subLabel", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    TextView descTv;
    private int mViewHeight;
    private int mViewWidth;
    TextView titleTv;
    private MemberCardTopCropImageView wGQ;
    LinearLayout wIf;
    LinearLayout wIg;
    ImageView wIh;
    private ImageView wIi;
    
    public a(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(294402);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(294402);
        return;
        paramView = paramView.findViewById(a.d.wgT);
        s.s(paramView, "itemView.findViewById(R.id.card_list_header_text)");
        this.titleTv = ((TextView)paramView);
        AppMethodBeat.o(294402);
        return;
        View localView = paramView.findViewById(a.d.wiN);
        s.s(localView, "itemView.findViewById(R.id.chpiv3_title_tv)");
        this.titleTv = ((TextView)localView);
        localView = paramView.findViewById(a.d.wiH);
        s.s(localView, "itemView.findViewById(R.id.chpiv3_desc_tv)");
        this.descTv = ((TextView)localView);
        localView = paramView.findViewById(a.d.wiL);
        s.s(localView, "itemView.findViewById(R.…iv3_right_subtext_layout)");
        this.wIf = ((LinearLayout)localView);
        localView = paramView.findViewById(a.d.wie);
        s.s(localView, "itemView.findViewById(R.….chpc_rignt_label_layout)");
        this.wIg = ((LinearLayout)localView);
        paramView = paramView.findViewById(a.d.wiI);
        s.s(paramView, "itemView.findViewById(R.id.chpiv3_icon_iv)");
        this.wIh = ((ImageView)paramView);
        AppMethodBeat.o(294402);
        return;
        localView = paramView.findViewById(a.d.wiN);
        s.s(localView, "itemView.findViewById(R.id.chpiv3_title_tv)");
        this.titleTv = ((TextView)localView);
        localView = paramView.findViewById(a.d.wiH);
        s.s(localView, "itemView.findViewById(R.id.chpiv3_desc_tv)");
        this.descTv = ((TextView)localView);
        localView = paramView.findViewById(a.d.wiL);
        s.s(localView, "itemView.findViewById(R.…iv3_right_subtext_layout)");
        this.wIf = ((LinearLayout)localView);
        localView = paramView.findViewById(a.d.wie);
        s.s(localView, "itemView.findViewById(R.….chpc_rignt_label_layout)");
        this.wIg = ((LinearLayout)localView);
        localView = paramView.findViewById(a.d.wiG);
        s.s(localView, "itemView.findViewById(R.id.chpiv3_card_bg_iv)");
        this.wGQ = ((MemberCardTopCropImageView)localView);
        localView = paramView.findViewById(a.d.wiF);
        s.s(localView, "itemView.findViewById(R.id.chpiv3_bg_shadow_iv)");
        this.wIi = ((ImageView)localView);
        paramView = paramView.findViewById(a.d.wiI);
        s.s(paramView, "itemView.findViewById(R.id.chpiv3_icon_iv)");
        this.wIh = ((ImageView)paramView);
      }
    }
    
    private static final void a(a parama, kotlin.g.a.a parama1)
    {
      AppMethodBeat.i(294428);
      s.u(parama, "this$0");
      s.u(parama1, "$func");
      parama.mViewHeight = parama.caK.getHeight();
      parama.mViewWidth = parama.caK.getWidth();
      parama1.invoke();
      AppMethodBeat.o(294428);
    }
    
    static void a(String paramString, List<? extends vs> paramList, LinearLayout paramLinearLayout, final int paramInt)
    {
      AppMethodBeat.i(294420);
      Object localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label81;
        }
        localObject = (Collection)paramList;
        if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
          break label75;
        }
      }
      label75:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label81;
        }
        AppMethodBeat.o(294420);
        return;
        i = 0;
        break;
      }
      label81:
      paramLinearLayout.setVisibility(0);
      localObject = MMApplicationContext.getContext();
      if (localObject != null)
      {
        localObject = (kotlin.g.a.a)new b((Context)localObject, paramInt);
        if (paramList != null)
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            String str = ((vs)paramList.next()).ZbR;
            if (str != null)
            {
              TextView localTextView = (TextView)((kotlin.g.a.a)localObject).invoke();
              localTextView.setText((CharSequence)str);
              localTextView.setTextSize(1, 12.0F);
              paramLinearLayout.addView((View)localTextView);
            }
          }
        }
        if (paramString != null)
        {
          paramList = (TextView)((kotlin.g.a.a)localObject).invoke();
          paramList.setText((CharSequence)paramString);
          paramList.setTextSize(1, 10.0F);
          paramLinearLayout.addView((View)paramList);
        }
      }
      AppMethodBeat.o(294420);
    }
    
    static void a(List<? extends vs> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(294411);
      Object localObject = (Collection)paramList;
      if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(294411);
        return;
      }
      paramLinearLayout.setVisibility(0);
      localObject = MMApplicationContext.getContext();
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        vs localvs = (vs)paramList.next();
        CardTagTextView localCardTagTextView = new CardTagTextView((Context)localObject);
        localCardTagTextView.setMinHeight(com.tencent.mm.cd.a.fromDPToPix((Context)localObject, 18));
        localCardTagTextView.setMinWidth(com.tencent.mm.cd.a.fromDPToPix((Context)localObject, 56));
        i = com.tencent.mm.cd.a.fromDPToPix((Context)localObject, 8);
        int j = com.tencent.mm.cd.a.fromDPToPix((Context)localObject, 4);
        localCardTagTextView.setPadding(i, j, i, j);
        localCardTagTextView.setText((CharSequence)localvs.ZbR);
        localCardTagTextView.setTextSize(1, 10.0F);
        if (!Util.isNullOrNil(localvs.ZbS))
        {
          localCardTagTextView.setTextColor(Color.parseColor(localvs.ZbS));
          label184:
          if (Util.isNullOrNil(localvs.ZbT)) {
            break label234;
          }
          localCardTagTextView.setFillColor(l.dO(localvs.ZbT, localvs.ZbW));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localCardTagTextView);
          break;
          localCardTagTextView.setTextColor(-1);
          break label184;
          label234:
          localCardTagTextView.setFillColor(l.gy(-16777216, 26));
        }
      }
      AppMethodBeat.o(294411);
    }
    
    final void a(final vt paramvt, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(294474);
      if (paramvt == null)
      {
        AppMethodBeat.o(294474);
        return;
      }
      Object localObject1 = (CharSequence)paramvt.Zcg;
      int i;
      label110:
      Object localObject4;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
      {
        i = 1;
        if (i == 0)
        {
          localObject3 = this.titleTv;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("titleTv");
            localObject1 = null;
          }
          ((TextView)localObject1).setTextColor(l.dO(paramvt.Zcg, paramvt.Zch));
        }
        localObject1 = this.titleTv;
        if (localObject1 != null) {
          break label503;
        }
        s.bIx("titleTv");
        localObject1 = null;
        ((TextView)localObject1).setText((CharSequence)paramvt.ZbX);
        localObject3 = this.titleTv;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("titleTv");
          localObject1 = null;
        }
        aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
        localObject1 = this.descTv;
        if (localObject1 != null) {
          break label506;
        }
        s.bIx("descTv");
        localObject1 = null;
        label180:
        ((TextView)localObject1).setText((CharSequence)paramvt.ZbY);
        localObject1 = (CharSequence)paramvt.Zck;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label509;
        }
        i = 1;
        label218:
        if (i == 0)
        {
          localObject3 = this.wIh;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("roundCornerIv");
            localObject1 = null;
          }
          i = com.tencent.mm.cd.a.fromDPToPix(((ImageView)localObject1).getContext(), 48);
          localObject3 = this.wIh;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("roundCornerIv");
            localObject1 = null;
          }
          localObject3 = paramvt.Zck;
          s.s(localObject3, "element.card_icon_url");
          m.a((ImageView)localObject1, (String)localObject3, false, a.f.card_default_merchant_icon, i, i, 12);
        }
        if (paramInt != 2) {
          break label514;
        }
        localObject3 = this.wIg;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("labelLayout");
          localObject1 = null;
        }
        ((LinearLayout)localObject1).removeAllViews();
        localObject3 = this.wIf;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("subTextLayout");
          localObject1 = null;
        }
        ((LinearLayout)localObject1).setVisibility(8);
        localObject4 = (List)paramvt.Zcc;
        localObject3 = this.wIg;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("labelLayout");
          localObject1 = null;
        }
        a((List)localObject4, (LinearLayout)localObject1);
        label415:
        localObject3 = this.wGQ;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("bgIv");
          localObject1 = null;
        }
        localObject3 = ((MemberCardTopCropImageView)localObject1).getTag();
        localObject1 = paramvt.YBH;
        if (localObject1 != null) {
          break label626;
        }
        localObject1 = "";
      }
      label514:
      label626:
      for (;;)
      {
        if ((!(localObject3 instanceof String)) || (TextUtils.isEmpty((CharSequence)localObject3)) || (!localObject3.equals(localObject1))) {
          break label629;
        }
        AppMethodBeat.o(294474);
        return;
        i = 0;
        break;
        label503:
        break label110;
        label506:
        break label180;
        label509:
        i = 0;
        break label218;
        localObject3 = this.wIf;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("subTextLayout");
          localObject1 = null;
        }
        ((LinearLayout)localObject1).removeAllViews();
        localObject3 = this.wIg;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("labelLayout");
          localObject1 = null;
        }
        ((LinearLayout)localObject1).setVisibility(8);
        localObject4 = paramvt.Zcp;
        List localList = (List)paramvt.Zcc;
        localObject3 = this.wIf;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("subTextLayout");
          localObject1 = null;
        }
        a((String)localObject4, localList, (LinearLayout)localObject1, paramInt);
        break label415;
      }
      label629:
      Object localObject3 = this.wGQ;
      if (localObject3 == null) {
        s.bIx("bgIv");
      }
      for (;;)
      {
        localObject2.setTag(localObject1);
        paramvt = (kotlin.g.a.a)new a(this, paramvt);
        if ((this.mViewHeight > 0) && (this.mViewWidth > 0)) {
          break;
        }
        this.mViewHeight = this.caK.getHeight();
        this.mViewWidth = this.caK.getWidth();
        if ((this.mViewHeight > 0) && (this.mViewWidth > 0)) {
          break;
        }
        this.caK.post(new c.a..ExternalSyntheticLambda0(this, paramvt));
        AppMethodBeat.o(294474);
        return;
        localObject2 = localObject3;
      }
      paramvt.invoke();
      AppMethodBeat.o(294474);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(c.a parama, vt paramvt)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<TextView>
    {
      b(Context paramContext, int paramInt)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.c
 * JD-Core Version:    0.7.0.1
 */