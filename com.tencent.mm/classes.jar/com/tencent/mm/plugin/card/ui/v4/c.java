package com.tencent.mm.plugin.card.ui.v4;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.protocal.protobuf.tz;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter$CardTicketVH;", "isInvalid", "", "(Z)V", "cardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "getModelByPos", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateModelList", "CardTicketVH", "Companion", "plugin-card_release"})
public final class c
  extends RecyclerView.a<a>
{
  public static final c.b qiC;
  private final boolean qgD;
  private ArrayList<a> qiB;
  
  static
  {
    AppMethodBeat.i(201622);
    qiC = new c.b((byte)0);
    AppMethodBeat.o(201622);
  }
  
  public c(boolean paramBoolean)
  {
    this.qgD = paramBoolean;
  }
  
  public final a EF(int paramInt)
  {
    AppMethodBeat.i(201620);
    Object localObject = this.qiB;
    int i;
    if (localObject != null)
    {
      i = ((ArrayList)localObject).size();
      if (paramInt >= 0) {
        break label30;
      }
    }
    label30:
    while (i <= paramInt)
    {
      AppMethodBeat.o(201620);
      return null;
    }
    localObject = (a)((ArrayList)localObject).get(paramInt);
    AppMethodBeat.o(201620);
    return localObject;
  }
  
  public final void P(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(201621);
    this.qiB = paramArrayList;
    notifyDataSetChanged();
    AppMethodBeat.o(201621);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(201617);
    int i = 0;
    ArrayList localArrayList = this.qiB;
    if (localArrayList != null) {
      i = localArrayList.size() + 0;
    }
    AppMethodBeat.o(201617);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(201618);
    a locala = EF(paramInt);
    if (locala != null)
    {
      Object localObject2 = locala.title;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = locala.qiw;
      if (localObject2 != null)
      {
        String str = ((ua)localObject2).KDM;
        localObject2 = str;
        if (str != null) {}
      }
      else
      {
        localObject2 = "";
      }
      localObject1 = (String)localObject1 + (String)localObject2;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        l = locala.hashCode();
        AppMethodBeat.o(201618);
        return l;
      }
      long l = ((String)localObject1 + paramInt).hashCode();
      AppMethodBeat.o(201618);
      return l;
    }
    Log.e("MicroMsg.CouponAndGiftCardListAdapter", "[getItemId] position=" + paramInt + " itemCount=" + getItemCount() + " }");
    AppMethodBeat.o(201618);
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(201616);
    a locala = EF(paramInt);
    if (locala != null)
    {
      paramInt = locala.type;
      AppMethodBeat.o(201616);
      return paramInt;
    }
    AppMethodBeat.o(201616);
    return -1;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter$CardTicketVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "bgIv", "Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "descTv", "Landroid/widget/TextView;", "labelLayout", "Landroid/widget/LinearLayout;", "mViewHeight", "mViewWidth", "roundCornerIv", "Landroid/widget/ImageView;", "shadowBgIv", "subTextLayout", "titleTv", "bindCommonCardDataModel", "", "element", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "cardType", "bindCouponCardDataModel", "bindDataModel", "model", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "updateSubLabelText", "subLabel", "", "plugin-card_release"})
  public static final class a
    extends RecyclerView.v
  {
    int aYN;
    int aYO;
    TextView hPW;
    MemberCardTopCropImageView qgR;
    LinearLayout qiD;
    LinearLayout qiE;
    ImageView qiF;
    private ImageView qiG;
    TextView titleTv;
    
    public a(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(201612);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(201612);
        return;
        paramView = paramView.findViewById(2131298159);
        p.g(paramView, "itemView.findViewById(R.id.card_list_header_text)");
        this.titleTv = ((TextView)paramView);
        AppMethodBeat.o(201612);
        return;
        View localView = paramView.findViewById(2131298702);
        p.g(localView, "itemView.findViewById(R.id.chpiv3_title_tv)");
        this.titleTv = ((TextView)localView);
        localView = paramView.findViewById(2131298697);
        p.g(localView, "itemView.findViewById(R.id.chpiv3_desc_tv)");
        this.hPW = ((TextView)localView);
        localView = paramView.findViewById(2131298700);
        p.g(localView, "itemView.findViewById(R.…iv3_right_subtext_layout)");
        this.qiD = ((LinearLayout)localView);
        localView = paramView.findViewById(2131298668);
        p.g(localView, "itemView.findViewById(R.….chpc_rignt_label_layout)");
        this.qiE = ((LinearLayout)localView);
        paramView = paramView.findViewById(2131298698);
        p.g(paramView, "itemView.findViewById(R.id.chpiv3_icon_iv)");
        this.qiF = ((ImageView)paramView);
        AppMethodBeat.o(201612);
        return;
        localView = paramView.findViewById(2131298702);
        p.g(localView, "itemView.findViewById(R.id.chpiv3_title_tv)");
        this.titleTv = ((TextView)localView);
        localView = paramView.findViewById(2131298697);
        p.g(localView, "itemView.findViewById(R.id.chpiv3_desc_tv)");
        this.hPW = ((TextView)localView);
        localView = paramView.findViewById(2131298700);
        p.g(localView, "itemView.findViewById(R.…iv3_right_subtext_layout)");
        this.qiD = ((LinearLayout)localView);
        localView = paramView.findViewById(2131298668);
        p.g(localView, "itemView.findViewById(R.….chpc_rignt_label_layout)");
        this.qiE = ((LinearLayout)localView);
        localView = paramView.findViewById(2131298696);
        p.g(localView, "itemView.findViewById(R.id.chpiv3_card_bg_iv)");
        this.qgR = ((MemberCardTopCropImageView)localView);
        localView = paramView.findViewById(2131298695);
        p.g(localView, "itemView.findViewById(R.id.chpiv3_bg_shadow_iv)");
        this.qiG = ((ImageView)localView);
        paramView = paramView.findViewById(2131298698);
        p.g(paramView, "itemView.findViewById(R.id.chpiv3_icon_iv)");
        this.qiF = ((ImageView)paramView);
      }
    }
    
    static void a(String paramString, List<? extends tz> paramList, LinearLayout paramLinearLayout, int paramInt)
    {
      AppMethodBeat.i(201611);
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
        AppMethodBeat.o(201611);
        return;
        i = 0;
        break;
      }
      label81:
      paramLinearLayout.setVisibility(0);
      localObject = MMApplicationContext.getContext();
      if (localObject != null)
      {
        localObject = (kotlin.g.a.a)new c.a.c((Context)localObject, paramInt, paramList, paramLinearLayout, paramString);
        if (paramList != null)
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            String str = ((tz)paramList.next()).LcI;
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
      AppMethodBeat.o(201611);
    }
    
    static void a(List<? extends tz> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(201610);
      Object localObject = (Collection)paramList;
      if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(201610);
        return;
      }
      paramLinearLayout.setVisibility(0);
      localObject = MMApplicationContext.getContext();
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        tz localtz = (tz)paramList.next();
        CardTagTextView localCardTagTextView = new CardTagTextView((Context)localObject);
        localCardTagTextView.setMinHeight(com.tencent.mm.cb.a.fromDPToPix((Context)localObject, 18));
        localCardTagTextView.setMinWidth(com.tencent.mm.cb.a.fromDPToPix((Context)localObject, 56));
        i = com.tencent.mm.cb.a.fromDPToPix((Context)localObject, 8);
        int j = com.tencent.mm.cb.a.fromDPToPix((Context)localObject, 4);
        localCardTagTextView.setPadding(i, j, i, j);
        localCardTagTextView.setText((CharSequence)localtz.LcI);
        localCardTagTextView.setTextSize(1, 10.0F);
        if (!Util.isNullOrNil(localtz.LcJ))
        {
          localCardTagTextView.setTextColor(Color.parseColor(localtz.LcJ));
          label184:
          if (Util.isNullOrNil(localtz.LcK)) {
            break label234;
          }
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.cT(localtz.LcK, localtz.LcN));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localCardTagTextView);
          break;
          localCardTagTextView.setTextColor(-1);
          break label184;
          label234:
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.fj(-16777216, 26));
        }
      }
      AppMethodBeat.o(201610);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c.a parama, kotlin.g.a.a parama1) {}
      
      public final void run()
      {
        AppMethodBeat.i(201607);
        c.a locala = this.qiH;
        View localView = this.qiH.aus;
        p.g(localView, "itemView");
        c.a.a(locala, localView.getHeight());
        locala = this.qiH;
        localView = this.qiH.aus;
        p.g(localView, "itemView");
        c.a.b(locala, localView.getWidth());
        this.qgW.invoke();
        AppMethodBeat.o(201607);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(c.a parama, ua paramua)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.c
 * JD-Core Version:    0.7.0.1
 */