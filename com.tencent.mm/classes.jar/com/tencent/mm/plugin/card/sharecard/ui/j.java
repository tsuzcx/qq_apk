package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bwv;
import com.tencent.mm.protocal.c.cbx;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  implements c
{
  private BaseAdapter iqN;
  private long iqO = 0L;
  private long iqP = 0L;
  private int iqQ;
  private int iqR;
  private ArrayList<Integer> iqS = new ArrayList();
  private ArrayList<String> iqT = new ArrayList();
  private ArrayList<String> iqU = new ArrayList();
  protected LinkedList<CardTagTextView> iqV = new LinkedList();
  private Context mContext;
  
  public j(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    this.mContext = paramContext;
    this.iqN = paramBaseAdapter;
    this.iqQ = this.mContext.getResources().getDimensionPixelSize(a.b.OneDPPadding);
    this.iqR = this.mContext.getResources().getDimensionPixelSize(a.b.MiddlePadding);
    this.iqS.clear();
    this.iqT.clear();
    this.iqU.clear();
  }
  
  private CardTagTextView aBl()
  {
    if (this.iqV.size() == 0) {
      return new CardTagTextView(this.mContext);
    }
    return (CardTagTextView)this.iqV.removeFirst();
  }
  
  public final void F(View paramView, int paramInt) {}
  
  public final void G(View paramView, int paramInt) {}
  
  public final View a(int paramInt, View paramView, com.tencent.mm.plugin.card.base.b paramb)
  {
    long l = System.currentTimeMillis();
    j.a locala;
    Object localObject1;
    int j;
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, a.e.card_share_card_item, null);
      locala = new j.a(this);
      locala.iqW = ((LinearLayout)paramView.findViewById(a.d.card_tag_layout));
      locala.iqX = ((TextView)paramView.findViewById(a.d.card_item_category_title));
      locala.iqY = ((TextView)paramView.findViewById(a.d.card_item_subcategory_title));
      locala.iqZ = ((RelativeLayout)paramView.findViewById(a.d.card_container_parent));
      locala.ira = ((ImageView)paramView.findViewById(a.d.card_img));
      locala.irb = ((TextView)paramView.findViewById(a.d.card_brand_name));
      locala.irc = ((TextView)paramView.findViewById(a.d.card_name));
      locala.irg = paramView.findViewById(a.d.card_line);
      locala.ird = ((TextView)paramView.findViewById(a.d.subtitle));
      locala.ire = ((TextView)paramView.findViewById(a.d.card_announcement));
      locala.irf = ((TextView)paramView.findViewById(a.d.card_not_support_tip));
      locala.irh = ((TextView)paramView.findViewById(a.d.card_count_title));
      locala.ird.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      paramView.setTag(locala);
      localObject1 = (com.tencent.mm.plugin.card.base.b)this.iqN.getItem(paramInt);
      j = ((com.tencent.mm.plugin.card.base.b)localObject1).azG();
      if (!com.tencent.mm.plugin.card.sharecard.a.b.oQ(((com.tencent.mm.plugin.card.base.b)localObject1).azG())) {
        break label1804;
      }
      if (paramInt != 0) {
        break label845;
      }
      if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).oL(j))) {
        break label1804;
      }
      i = 1;
    }
    for (;;)
    {
      label282:
      if (i != 0)
      {
        locala.iqX.setVisibility(0);
        locala.iqX.setText(((com.tencent.mm.plugin.card.base.b)localObject1).oL(j));
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).azF()))
        {
          locala.iqY.setVisibility(0);
          locala.iqY.setText(((com.tencent.mm.plugin.card.base.b)localObject1).azF());
          label350:
          if (!paramb.azk()) {
            break label1643;
          }
          locala.ira.setVisibility(0);
          locala.irb.setVisibility(0);
          locala.iqW.setVisibility(0);
          locala.irc.setVisibility(0);
          locala.irh.setVisibility(0);
          locala.irg.setVisibility(0);
          locala.ird.setVisibility(0);
          locala.ire.setVisibility(0);
          locala.irf.setVisibility(8);
          locala.irb.setText(paramb.azx().imA);
          if (!paramb.azh()) {
            break label1033;
          }
          if ((paramb.azx().sIq == null) || (paramb.azx().sIq.size() != 1)) {
            break label921;
          }
          locala.irc.setText(((ra)paramb.azx().sIq.get(0)).title);
          i = this.mContext.getResources().getDimensionPixelSize(a.b.card_list_logo_height);
          m.a(locala.ira, paramb.azx().ilp, i, a.c.my_card_package_defaultlogo, true);
          locala.irb.setTextColor(this.mContext.getResources().getColor(a.a.card_black_color));
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.yp(paramb.azC());
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1053;
          }
          locala.ire.setText((CharSequence)localObject1);
          label610:
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.ls(paramb.azC());
          boolean bool = com.tencent.mm.plugin.card.sharecard.a.b.oQ(paramb.azG());
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!bool)) {
            break label1067;
          }
          locala.ird.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(a.b.SmallerTextSize)));
          label675:
          i = com.tencent.mm.plugin.card.sharecard.a.b.yq(paramb.azC());
          if ((i <= 1) || (!bool)) {
            break label1183;
          }
          locala.irh.setText("X" + i);
          locala.irh.setVisibility(0);
        }
      }
      label522:
      label732:
      Object localObject2;
      for (;;)
      {
        if (((paramb.azx().sIJ != null) && (!bk.dk(paramb.azx().sIJ.tQZ))) || (com.tencent.mm.plugin.card.sharecard.a.b.ys(paramb.azC())))
        {
          locala.iqW.setVisibility(0);
          i = 0;
          for (;;)
          {
            if (i < locala.iqW.getChildCount())
            {
              localObject1 = (CardTagTextView)locala.iqW.getChildAt(i);
              this.iqV.add(localObject1);
              i += 1;
              continue;
              locala = (j.a)paramView.getTag();
              break;
              label845:
              if (j == ((com.tencent.mm.plugin.card.base.b)this.iqN.getItem(paramInt - 1)).azG()) {
                break label1804;
              }
              i = 1;
              break label282;
              locala.iqY.setVisibility(8);
              break label350;
              locala.iqX.setVisibility(8);
              locala.iqY.setVisibility(8);
              locala.iqX.setText("");
              break label350;
              label921:
              if ((paramb.azx().sIq == null) || (paramb.azx().sIq.size() != 2)) {
                break label522;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((ra)paramb.azx().sIq.get(0)).title);
              ((StringBuilder)localObject1).append("-");
              ((StringBuilder)localObject1).append(((ra)paramb.azx().sIq.get(1)).title);
              locala.irc.setText(((StringBuilder)localObject1).toString());
              break label522;
              label1033:
              locala.irc.setText(paramb.azx().title);
              break label522;
              label1053:
              locala.ire.setText("");
              break label610;
              label1067:
              if (!TextUtils.isEmpty(paramb.azD()))
              {
                localObject1 = l.yU(paramb.azD());
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject1 = this.mContext.getResources().getString(a.g.card_share_card_list_users, new Object[] { localObject1 });
                  locala.ird.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(a.b.SmallerTextSize)));
                  break label675;
                }
                locala.ird.setText("");
                break label675;
              }
              locala.ird.setText("");
              break label675;
              label1183:
              locala.irh.setVisibility(8);
              break label732;
            }
          }
          locala.iqW.removeAllViews();
          if (com.tencent.mm.plugin.card.sharecard.a.b.ys(paramb.azC()))
          {
            localObject1 = aBl();
            ((CardTagTextView)localObject1).setPadding(this.iqR, this.iqQ, this.iqR, this.iqQ);
            ((CardTagTextView)localObject1).setTextColor(this.mContext.getResources().getColor(a.a.red));
            ((CardTagTextView)localObject1).setText(this.mContext.getString(a.g.card_share_card_top_tips));
            ((CardTagTextView)localObject1).setTextSize(12.0F);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).rightMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding);
            locala.iqW.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          }
          if ((paramb.azx().sIJ == null) || (bk.dk(paramb.azx().sIJ.tQZ))) {
            break label1477;
          }
          localObject1 = paramb.azx().sIJ.tQZ.iterator();
        }
      }
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bwv)((Iterator)localObject1).next();
        CardTagTextView localCardTagTextView = aBl();
        localCardTagTextView.setPadding(this.iqR, this.iqQ, this.iqR, this.iqQ);
        localCardTagTextView.setTextColor(l.yR(((bwv)localObject2).color));
        localCardTagTextView.setText(((bwv)localObject2).tag);
        localCardTagTextView.setTextSize(12.0F);
        locala.iqW.addView(localCardTagTextView);
        continue;
        locala.iqW.setVisibility(8);
      }
      label1477:
      if ((paramInt == this.iqN.getCount() - 1) && (locala.iqZ != null))
      {
        localObject1 = (LinearLayout.LayoutParams)locala.iqZ.getLayoutParams();
        if (((LinearLayout.LayoutParams)localObject1).bottomMargin != this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding))
        {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding);
          locala.iqZ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      for (;;)
      {
        this.iqO = (System.currentTimeMillis() - l + this.iqO);
        this.iqP += 1L;
        if (!this.iqT.contains(paramb.azB()))
        {
          this.iqT.add(paramb.azB());
          this.iqU.add(paramb.azC());
          this.iqS.add(Integer.valueOf(paramInt));
        }
        return paramView;
        label1643:
        locala.ira.setVisibility(8);
        locala.irb.setVisibility(8);
        locala.iqW.setVisibility(8);
        locala.irc.setVisibility(8);
        locala.irh.setVisibility(8);
        locala.irg.setVisibility(8);
        locala.ird.setVisibility(8);
        locala.ire.setVisibility(8);
        locala.irf.setVisibility(0);
        locala.irf.setText(this.mContext.getResources().getString(a.g.card_not_support_card_type));
        break;
        if (locala.iqZ != null)
        {
          localObject1 = (LinearLayout.LayoutParams)locala.iqZ.getLayoutParams();
          if (((LinearLayout.LayoutParams)localObject1).bottomMargin != 0)
          {
            ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
            locala.iqZ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
      label1804:
      i = 0;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener) {}
  
  public final void release()
  {
    this.mContext = null;
    this.iqN = null;
    if (this.iqP > 0L)
    {
      ArrayList localArrayList = new ArrayList();
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(281);
      localIDKey1.SetKey(5);
      localIDKey1.SetValue(1L);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(281);
      localIDKey2.SetKey(6);
      localIDKey2.SetValue((int)(this.iqO / this.iqP));
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      h.nFQ.b(localArrayList, true);
    }
    if ((this.iqS.size() == this.iqT.size()) && (this.iqT.size() == this.iqU.size()) && (this.iqS.size() > 0))
    {
      long l = System.currentTimeMillis();
      int i = 0;
      while (i < this.iqS.size())
      {
        h.nFQ.f(13220, new Object[] { this.iqU.get(i), this.iqT.get(i), this.iqS.get(i), Long.valueOf(l) });
        i += 1;
      }
    }
    this.iqS.clear();
    this.iqT.clear();
    this.iqU.clear();
    if (this.iqV != null) {
      this.iqV.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.j
 * JD-Core Version:    0.7.0.1
 */