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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.dmt;
import com.tencent.mm.protocal.protobuf.dum;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  implements c
{
  private Context mContext;
  private BaseAdapter oKk;
  private long oKl;
  private long oKm;
  private int oKn;
  private int oKo;
  private ArrayList<Integer> oKp;
  private ArrayList<String> oKq;
  private ArrayList<String> oKr;
  protected LinkedList<CardTagTextView> oKs;
  
  public j(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113141);
    this.oKl = 0L;
    this.oKm = 0L;
    this.oKp = new ArrayList();
    this.oKq = new ArrayList();
    this.oKr = new ArrayList();
    this.oKs = new LinkedList();
    this.mContext = paramContext;
    this.oKk = paramBaseAdapter;
    this.oKn = this.mContext.getResources().getDimensionPixelSize(2131165519);
    this.oKo = this.mContext.getResources().getDimensionPixelSize(2131165500);
    this.oKp.clear();
    this.oKq.clear();
    this.oKr.clear();
    AppMethodBeat.o(113141);
  }
  
  private CardTagTextView bXi()
  {
    AppMethodBeat.i(113144);
    if (this.oKs.size() == 0)
    {
      localCardTagTextView = new CardTagTextView(this.mContext);
      AppMethodBeat.o(113144);
      return localCardTagTextView;
    }
    CardTagTextView localCardTagTextView = (CardTagTextView)this.oKs.removeFirst();
    AppMethodBeat.o(113144);
    return localCardTagTextView;
  }
  
  public final void Z(View paramView, int paramInt) {}
  
  public final View a(int paramInt, View paramView, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113143);
    long l = System.currentTimeMillis();
    a locala;
    Object localObject1;
    int j;
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2131493341, null);
      locala = new a();
      locala.oKt = ((LinearLayout)paramView.findViewById(2131297904));
      locala.oKu = ((TextView)paramView.findViewById(2131297834));
      locala.oKv = ((TextView)paramView.findViewById(2131297838));
      locala.oKw = ((RelativeLayout)paramView.findViewById(2131297771));
      locala.oKx = ((ImageView)paramView.findViewById(2131297828));
      locala.oKy = ((TextView)paramView.findViewById(2131297743));
      locala.oKz = ((TextView)paramView.findViewById(2131297863));
      locala.oKD = paramView.findViewById(2131297840);
      locala.oKA = ((TextView)paramView.findViewById(2131305529));
      locala.oKB = ((TextView)paramView.findViewById(2131297732));
      locala.oKC = ((TextView)paramView.findViewById(2131297864));
      locala.oKE = ((TextView)paramView.findViewById(2131297774));
      locala.oKA.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      paramView.setTag(locala);
      localObject1 = (com.tencent.mm.plugin.card.base.b)this.oKk.getItem(paramInt);
      j = ((com.tencent.mm.plugin.card.base.b)localObject1).bVl();
      if (!com.tencent.mm.plugin.card.sharecard.a.b.AE(((com.tencent.mm.plugin.card.base.b)localObject1).bVl())) {
        break label1794;
      }
      if (paramInt != 0) {
        break label830;
      }
      if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).Az(j))) {
        break label1794;
      }
      i = 1;
    }
    for (;;)
    {
      label274:
      if (i != 0)
      {
        locala.oKu.setVisibility(0);
        locala.oKu.setText(((com.tencent.mm.plugin.card.base.b)localObject1).Az(j));
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).bVk()))
        {
          locala.oKv.setVisibility(0);
          locala.oKv.setText(((com.tencent.mm.plugin.card.base.b)localObject1).bVk());
          label342:
          if (!paramb.bUO()) {
            break label1633;
          }
          locala.oKx.setVisibility(0);
          locala.oKy.setVisibility(0);
          locala.oKt.setVisibility(0);
          locala.oKz.setVisibility(0);
          locala.oKE.setVisibility(0);
          locala.oKD.setVisibility(0);
          locala.oKA.setVisibility(0);
          locala.oKB.setVisibility(0);
          locala.oKC.setVisibility(8);
          locala.oKy.setText(paramb.bVc().oFG);
          if (!paramb.bUL()) {
            break label1018;
          }
          if ((paramb.bVc().GjY == null) || (paramb.bVc().GjY.size() != 1)) {
            break label906;
          }
          locala.oKz.setText(((aai)paramb.bVc().GjY.get(0)).title);
          i = this.mContext.getResources().getDimensionPixelSize(2131165979);
          n.a(locala.oKx, paramb.bVc().hCp, i, 2131233400, true);
          locala.oKy.setTextColor(this.mContext.getResources().getColor(2131100085));
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.Zm(paramb.bVh());
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1038;
          }
          locala.oKB.setText((CharSequence)localObject1);
          label602:
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.ET(paramb.bVh());
          boolean bool = com.tencent.mm.plugin.card.sharecard.a.b.AE(paramb.bVl());
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!bool)) {
            break label1052;
          }
          locala.oKA.setText(k.b(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(2131165574)));
          label667:
          i = com.tencent.mm.plugin.card.sharecard.a.b.Zn(paramb.bVh());
          if ((i <= 1) || (!bool)) {
            break label1168;
          }
          locala.oKE.setText("X".concat(String.valueOf(i)));
          locala.oKE.setVisibility(0);
        }
      }
      label514:
      label717:
      label1018:
      Object localObject2;
      for (;;)
      {
        if (((paramb.bVc().Gkq != null) && (!bu.ht(paramb.bVc().Gkq.Iad))) || (com.tencent.mm.plugin.card.sharecard.a.b.Zp(paramb.bVh())))
        {
          locala.oKt.setVisibility(0);
          i = 0;
          for (;;)
          {
            if (i < locala.oKt.getChildCount())
            {
              localObject1 = (CardTagTextView)locala.oKt.getChildAt(i);
              this.oKs.add(localObject1);
              i += 1;
              continue;
              locala = (a)paramView.getTag();
              break;
              label830:
              if (j == ((com.tencent.mm.plugin.card.base.b)this.oKk.getItem(paramInt - 1)).bVl()) {
                break label1794;
              }
              i = 1;
              break label274;
              locala.oKv.setVisibility(8);
              break label342;
              locala.oKu.setVisibility(8);
              locala.oKv.setVisibility(8);
              locala.oKu.setText("");
              break label342;
              label906:
              if ((paramb.bVc().GjY == null) || (paramb.bVc().GjY.size() != 2)) {
                break label514;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((aai)paramb.bVc().GjY.get(0)).title);
              ((StringBuilder)localObject1).append("-");
              ((StringBuilder)localObject1).append(((aai)paramb.bVc().GjY.get(1)).title);
              locala.oKz.setText(((StringBuilder)localObject1).toString());
              break label514;
              locala.oKz.setText(paramb.bVc().title);
              break label514;
              label1038:
              locala.oKB.setText("");
              break label602;
              label1052:
              if (!TextUtils.isEmpty(paramb.bVi()))
              {
                localObject1 = l.aaa(paramb.bVi());
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject1 = this.mContext.getResources().getString(2131756978, new Object[] { localObject1 });
                  locala.oKA.setText(k.b(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(2131165574)));
                  break label667;
                }
                locala.oKA.setText("");
                break label667;
              }
              locala.oKA.setText("");
              break label667;
              label1168:
              locala.oKE.setVisibility(8);
              break label717;
            }
          }
          locala.oKt.removeAllViews();
          if (com.tencent.mm.plugin.card.sharecard.a.b.Zp(paramb.bVh()))
          {
            localObject1 = bXi();
            ((CardTagTextView)localObject1).setPadding(this.oKo, this.oKn, this.oKo, this.oKn);
            ((CardTagTextView)localObject1).setTextColor(this.mContext.getResources().getColor(2131100798));
            ((CardTagTextView)localObject1).setText(this.mContext.getString(2131756989));
            ((CardTagTextView)localObject1).setTextSize(12.0F);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).rightMargin = this.mContext.getResources().getDimensionPixelOffset(2131165490);
            locala.oKt.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          }
          if ((paramb.bVc().Gkq == null) || (bu.ht(paramb.bVc().Gkq.Iad))) {
            break label1462;
          }
          localObject1 = paramb.bVc().Gkq.Iad.iterator();
        }
      }
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (dmt)((Iterator)localObject1).next();
        CardTagTextView localCardTagTextView = bXi();
        localCardTagTextView.setPadding(this.oKo, this.oKn, this.oKo, this.oKn);
        localCardTagTextView.setTextColor(l.ZY(((dmt)localObject2).hDr));
        localCardTagTextView.setText(((dmt)localObject2).tag);
        localCardTagTextView.setTextSize(12.0F);
        locala.oKt.addView(localCardTagTextView);
        continue;
        locala.oKt.setVisibility(8);
      }
      label1462:
      if ((paramInt == this.oKk.getCount() - 1) && (locala.oKw != null))
      {
        localObject1 = (LinearLayout.LayoutParams)locala.oKw.getLayoutParams();
        if (((LinearLayout.LayoutParams)localObject1).bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131165490))
        {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165490);
          locala.oKw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      for (;;)
      {
        this.oKl = (System.currentTimeMillis() - l + this.oKl);
        this.oKm += 1L;
        if (!this.oKq.contains(paramb.bVg()))
        {
          this.oKq.add(paramb.bVg());
          this.oKr.add(paramb.bVh());
          this.oKp.add(Integer.valueOf(paramInt));
        }
        AppMethodBeat.o(113143);
        return paramView;
        label1633:
        locala.oKx.setVisibility(8);
        locala.oKy.setVisibility(8);
        locala.oKt.setVisibility(8);
        locala.oKz.setVisibility(8);
        locala.oKE.setVisibility(8);
        locala.oKD.setVisibility(8);
        locala.oKA.setVisibility(8);
        locala.oKB.setVisibility(8);
        locala.oKC.setVisibility(0);
        locala.oKC.setText(this.mContext.getResources().getString(2131756947));
        break;
        if (locala.oKw != null)
        {
          localObject1 = (LinearLayout.LayoutParams)locala.oKw.getLayoutParams();
          if (((LinearLayout.LayoutParams)localObject1).bottomMargin != 0)
          {
            ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
            locala.oKw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
      label1794:
      i = 0;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener) {}
  
  public final void aa(View paramView, int paramInt) {}
  
  public final void release()
  {
    AppMethodBeat.i(113142);
    this.mContext = null;
    this.oKk = null;
    if (this.oKm > 0L)
    {
      ArrayList localArrayList = new ArrayList();
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(281);
      localIDKey1.SetKey(5);
      localIDKey1.SetValue(1L);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(281);
      localIDKey2.SetKey(6);
      localIDKey2.SetValue((int)(this.oKl / this.oKm));
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      g.yxI.b(localArrayList, true);
    }
    if ((this.oKp.size() == this.oKq.size()) && (this.oKq.size() == this.oKr.size()) && (this.oKp.size() > 0))
    {
      long l = System.currentTimeMillis();
      int i = 0;
      while (i < this.oKp.size())
      {
        g.yxI.f(13220, new Object[] { this.oKr.get(i), this.oKq.get(i), this.oKp.get(i), Long.valueOf(l) });
        i += 1;
      }
    }
    this.oKp.clear();
    this.oKq.clear();
    this.oKr.clear();
    if (this.oKs != null) {
      this.oKs.clear();
    }
    AppMethodBeat.o(113142);
  }
  
  public final class a
  {
    public TextView oKA;
    public TextView oKB;
    public TextView oKC;
    public View oKD;
    public TextView oKE;
    public LinearLayout oKt;
    public TextView oKu;
    public TextView oKv;
    public RelativeLayout oKw;
    public ImageView oKx;
    public TextView oKy;
    public TextView oKz;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.j
 * JD-Core Version:    0.7.0.1
 */