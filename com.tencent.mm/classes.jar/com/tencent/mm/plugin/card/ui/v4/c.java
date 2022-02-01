package com.tencent.mm.plugin.card.ui.v4;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.protocal.protobuf.uc;
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

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter$CardTicketVH;", "isInvalid", "", "(Z)V", "cardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "getModelByPos", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateModelList", "CardTicketVH", "Companion", "plugin-card_release"})
public final class c
  extends RecyclerView.a<a>
{
  public static final c.b tEy;
  private final boolean tCz;
  private ArrayList<a> tEx;
  
  static
  {
    AppMethodBeat.i(245536);
    tEy = new c.b((byte)0);
    AppMethodBeat.o(245536);
  }
  
  public c(boolean paramBoolean)
  {
    this.tCz = paramBoolean;
  }
  
  public final a Ig(int paramInt)
  {
    AppMethodBeat.i(245532);
    Object localObject = this.tEx;
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
      AppMethodBeat.o(245532);
      return null;
    }
    localObject = (a)((ArrayList)localObject).get(paramInt);
    AppMethodBeat.o(245532);
    return localObject;
  }
  
  public final void Q(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(245533);
    this.tEx = paramArrayList;
    notifyDataSetChanged();
    AppMethodBeat.o(245533);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(245524);
    int i = 0;
    ArrayList localArrayList = this.tEx;
    if (localArrayList != null) {
      i = localArrayList.size() + 0;
    }
    AppMethodBeat.o(245524);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(245526);
    a locala = Ig(paramInt);
    if (locala != null)
    {
      Object localObject2 = locala.title;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = locala.tEs;
      if (localObject2 != null)
      {
        String str = ((uc)localObject2).RFf;
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
        AppMethodBeat.o(245526);
        return l;
      }
      long l = ((String)localObject1 + paramInt).hashCode();
      AppMethodBeat.o(245526);
      return l;
    }
    Log.e("MicroMsg.CouponAndGiftCardListAdapter", "[getItemId] position=" + paramInt + " itemCount=" + getItemCount() + " }");
    AppMethodBeat.o(245526);
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(245522);
    a locala = Ig(paramInt);
    if (locala != null)
    {
      paramInt = locala.type;
      AppMethodBeat.o(245522);
      return paramInt;
    }
    AppMethodBeat.o(245522);
    return -1;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter$CardTicketVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "bgIv", "Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "descTv", "Landroid/widget/TextView;", "labelLayout", "Landroid/widget/LinearLayout;", "mViewHeight", "mViewWidth", "roundCornerIv", "Landroid/widget/ImageView;", "shadowBgIv", "subTextLayout", "titleTv", "bindCommonCardDataModel", "", "element", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "cardType", "bindCouponCardDataModel", "bindDataModel", "model", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "updateSubLabelText", "subLabel", "", "plugin-card_release"})
  public static final class a
    extends RecyclerView.v
  {
    int aIj;
    int aIk;
    TextView kEs;
    MemberCardTopCropImageView tCN;
    LinearLayout tEA;
    ImageView tEB;
    private ImageView tEC;
    LinearLayout tEz;
    TextView titleTv;
    
    public a(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(246405);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(246405);
        return;
        paramView = paramView.findViewById(a.d.tcF);
        p.j(paramView, "itemView.findViewById(R.id.card_list_header_text)");
        this.titleTv = ((TextView)paramView);
        AppMethodBeat.o(246405);
        return;
        View localView = paramView.findViewById(a.d.tey);
        p.j(localView, "itemView.findViewById(R.id.chpiv3_title_tv)");
        this.titleTv = ((TextView)localView);
        localView = paramView.findViewById(a.d.tet);
        p.j(localView, "itemView.findViewById(R.id.chpiv3_desc_tv)");
        this.kEs = ((TextView)localView);
        localView = paramView.findViewById(a.d.tew);
        p.j(localView, "itemView.findViewById(R.…iv3_right_subtext_layout)");
        this.tEz = ((LinearLayout)localView);
        localView = paramView.findViewById(a.d.tdQ);
        p.j(localView, "itemView.findViewById(R.….chpc_rignt_label_layout)");
        this.tEA = ((LinearLayout)localView);
        paramView = paramView.findViewById(a.d.teu);
        p.j(paramView, "itemView.findViewById(R.id.chpiv3_icon_iv)");
        this.tEB = ((ImageView)paramView);
        AppMethodBeat.o(246405);
        return;
        localView = paramView.findViewById(a.d.tey);
        p.j(localView, "itemView.findViewById(R.id.chpiv3_title_tv)");
        this.titleTv = ((TextView)localView);
        localView = paramView.findViewById(a.d.tet);
        p.j(localView, "itemView.findViewById(R.id.chpiv3_desc_tv)");
        this.kEs = ((TextView)localView);
        localView = paramView.findViewById(a.d.tew);
        p.j(localView, "itemView.findViewById(R.…iv3_right_subtext_layout)");
        this.tEz = ((LinearLayout)localView);
        localView = paramView.findViewById(a.d.tdQ);
        p.j(localView, "itemView.findViewById(R.….chpc_rignt_label_layout)");
        this.tEA = ((LinearLayout)localView);
        localView = paramView.findViewById(a.d.tes);
        p.j(localView, "itemView.findViewById(R.id.chpiv3_card_bg_iv)");
        this.tCN = ((MemberCardTopCropImageView)localView);
        localView = paramView.findViewById(a.d.ter);
        p.j(localView, "itemView.findViewById(R.id.chpiv3_bg_shadow_iv)");
        this.tEC = ((ImageView)localView);
        paramView = paramView.findViewById(a.d.teu);
        p.j(paramView, "itemView.findViewById(R.id.chpiv3_icon_iv)");
        this.tEB = ((ImageView)paramView);
      }
    }
    
    static void a(String paramString, List<? extends ub> paramList, LinearLayout paramLinearLayout, int paramInt)
    {
      AppMethodBeat.i(246404);
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
        AppMethodBeat.o(246404);
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
            String str = ((ub)paramList.next()).SdV;
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
      AppMethodBeat.o(246404);
    }
    
    static void a(List<? extends ub> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(246401);
      Object localObject = (Collection)paramList;
      if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(246401);
        return;
      }
      paramLinearLayout.setVisibility(0);
      localObject = MMApplicationContext.getContext();
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        ub localub = (ub)paramList.next();
        CardTagTextView localCardTagTextView = new CardTagTextView((Context)localObject);
        localCardTagTextView.setMinHeight(com.tencent.mm.ci.a.fromDPToPix((Context)localObject, 18));
        localCardTagTextView.setMinWidth(com.tencent.mm.ci.a.fromDPToPix((Context)localObject, 56));
        i = com.tencent.mm.ci.a.fromDPToPix((Context)localObject, 8);
        int j = com.tencent.mm.ci.a.fromDPToPix((Context)localObject, 4);
        localCardTagTextView.setPadding(i, j, i, j);
        localCardTagTextView.setText((CharSequence)localub.SdV);
        localCardTagTextView.setTextSize(1, 10.0F);
        if (!Util.isNullOrNil(localub.SdW))
        {
          localCardTagTextView.setTextColor(Color.parseColor(localub.SdW));
          label184:
          if (Util.isNullOrNil(localub.SdX)) {
            break label234;
          }
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.dn(localub.SdX, localub.Sea));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localCardTagTextView);
          break;
          localCardTagTextView.setTextColor(-1);
          break label184;
          label234:
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.fG(-16777216, 26));
        }
      }
      AppMethodBeat.o(246401);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c.a parama, kotlin.g.a.a parama1) {}
      
      public final void run()
      {
        AppMethodBeat.i(254318);
        c.a locala = this.tED;
        View localView = this.tED.amk;
        p.j(localView, "itemView");
        c.a.a(locala, localView.getHeight());
        locala = this.tED;
        localView = this.tED.amk;
        p.j(localView, "itemView");
        c.a.b(locala, localView.getWidth());
        this.tCS.invoke();
        AppMethodBeat.o(254318);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(c.a parama, uc paramuc)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.c
 * JD-Core Version:    0.7.0.1
 */