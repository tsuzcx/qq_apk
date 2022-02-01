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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.dax;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  implements c
{
  private Context mContext;
  private BaseAdapter nxo;
  private long nxp;
  private long nxq;
  private int nxr;
  private int nxs;
  private ArrayList<Integer> nxt;
  private ArrayList<String> nxu;
  private ArrayList<String> nxv;
  protected LinkedList<CardTagTextView> nxw;
  
  public j(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113141);
    this.nxp = 0L;
    this.nxq = 0L;
    this.nxt = new ArrayList();
    this.nxu = new ArrayList();
    this.nxv = new ArrayList();
    this.nxw = new LinkedList();
    this.mContext = paramContext;
    this.nxo = paramBaseAdapter;
    this.nxr = this.mContext.getResources().getDimensionPixelSize(2131165519);
    this.nxs = this.mContext.getResources().getDimensionPixelSize(2131165500);
    this.nxt.clear();
    this.nxu.clear();
    this.nxv.clear();
    AppMethodBeat.o(113141);
  }
  
  private CardTagTextView bKb()
  {
    AppMethodBeat.i(113144);
    if (this.nxw.size() == 0)
    {
      localCardTagTextView = new CardTagTextView(this.mContext);
      AppMethodBeat.o(113144);
      return localCardTagTextView;
    }
    CardTagTextView localCardTagTextView = (CardTagTextView)this.nxw.removeFirst();
    AppMethodBeat.o(113144);
    return localCardTagTextView;
  }
  
  public final void X(View paramView, int paramInt) {}
  
  public final void Y(View paramView, int paramInt) {}
  
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
      locala.nxx = ((LinearLayout)paramView.findViewById(2131297904));
      locala.nxy = ((TextView)paramView.findViewById(2131297834));
      locala.nxz = ((TextView)paramView.findViewById(2131297838));
      locala.nxA = ((RelativeLayout)paramView.findViewById(2131297771));
      locala.nxB = ((ImageView)paramView.findViewById(2131297828));
      locala.nxC = ((TextView)paramView.findViewById(2131297743));
      locala.nxD = ((TextView)paramView.findViewById(2131297863));
      locala.nxH = paramView.findViewById(2131297840);
      locala.nxE = ((TextView)paramView.findViewById(2131305529));
      locala.nxF = ((TextView)paramView.findViewById(2131297732));
      locala.nxG = ((TextView)paramView.findViewById(2131297864));
      locala.nxI = ((TextView)paramView.findViewById(2131297774));
      locala.nxE.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      paramView.setTag(locala);
      localObject1 = (com.tencent.mm.plugin.card.base.b)this.nxo.getItem(paramInt);
      j = ((com.tencent.mm.plugin.card.base.b)localObject1).bIe();
      if (!com.tencent.mm.plugin.card.sharecard.a.b.yT(((com.tencent.mm.plugin.card.base.b)localObject1).bIe())) {
        break label1794;
      }
      if (paramInt != 0) {
        break label830;
      }
      if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).yO(j))) {
        break label1794;
      }
      i = 1;
    }
    for (;;)
    {
      label274:
      if (i != 0)
      {
        locala.nxy.setVisibility(0);
        locala.nxy.setText(((com.tencent.mm.plugin.card.base.b)localObject1).yO(j));
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).bId()))
        {
          locala.nxz.setVisibility(0);
          locala.nxz.setText(((com.tencent.mm.plugin.card.base.b)localObject1).bId());
          label342:
          if (!paramb.bHH()) {
            break label1633;
          }
          locala.nxB.setVisibility(0);
          locala.nxC.setVisibility(0);
          locala.nxx.setVisibility(0);
          locala.nxD.setVisibility(0);
          locala.nxI.setVisibility(0);
          locala.nxH.setVisibility(0);
          locala.nxE.setVisibility(0);
          locala.nxF.setVisibility(0);
          locala.nxG.setVisibility(8);
          locala.nxC.setText(paramb.bHV().nsK);
          if (!paramb.bHE()) {
            break label1018;
          }
          if ((paramb.bHV().CRF == null) || (paramb.bHV().CRF.size() != 1)) {
            break label906;
          }
          locala.nxD.setText(((xo)paramb.bHV().CRF.get(0)).title);
          i = this.mContext.getResources().getDimensionPixelSize(2131165979);
          n.a(locala.nxB, paramb.bHV().gGR, i, 2131233400, true);
          locala.nxC.setTextColor(this.mContext.getResources().getColor(2131100085));
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.QA(paramb.bIa());
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1038;
          }
          locala.nxF.setText((CharSequence)localObject1);
          label602:
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.xm(paramb.bIa());
          boolean bool = com.tencent.mm.plugin.card.sharecard.a.b.yT(paramb.bIe());
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!bool)) {
            break label1052;
          }
          locala.nxE.setText(k.b(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(2131165574)));
          label667:
          i = com.tencent.mm.plugin.card.sharecard.a.b.QB(paramb.bIa());
          if ((i <= 1) || (!bool)) {
            break label1168;
          }
          locala.nxI.setText("X".concat(String.valueOf(i)));
          locala.nxI.setVisibility(0);
        }
      }
      label514:
      label717:
      label1018:
      Object localObject2;
      for (;;)
      {
        if (((paramb.bHV().CRX != null) && (!bt.gL(paramb.bHV().CRX.EyA))) || (com.tencent.mm.plugin.card.sharecard.a.b.QD(paramb.bIa())))
        {
          locala.nxx.setVisibility(0);
          i = 0;
          for (;;)
          {
            if (i < locala.nxx.getChildCount())
            {
              localObject1 = (CardTagTextView)locala.nxx.getChildAt(i);
              this.nxw.add(localObject1);
              i += 1;
              continue;
              locala = (a)paramView.getTag();
              break;
              label830:
              if (j == ((com.tencent.mm.plugin.card.base.b)this.nxo.getItem(paramInt - 1)).bIe()) {
                break label1794;
              }
              i = 1;
              break label274;
              locala.nxz.setVisibility(8);
              break label342;
              locala.nxy.setVisibility(8);
              locala.nxz.setVisibility(8);
              locala.nxy.setText("");
              break label342;
              label906:
              if ((paramb.bHV().CRF == null) || (paramb.bHV().CRF.size() != 2)) {
                break label514;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((xo)paramb.bHV().CRF.get(0)).title);
              ((StringBuilder)localObject1).append("-");
              ((StringBuilder)localObject1).append(((xo)paramb.bHV().CRF.get(1)).title);
              locala.nxD.setText(((StringBuilder)localObject1).toString());
              break label514;
              locala.nxD.setText(paramb.bHV().title);
              break label514;
              label1038:
              locala.nxF.setText("");
              break label602;
              label1052:
              if (!TextUtils.isEmpty(paramb.bIb()))
              {
                localObject1 = l.Ro(paramb.bIb());
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject1 = this.mContext.getResources().getString(2131756978, new Object[] { localObject1 });
                  locala.nxE.setText(k.b(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(2131165574)));
                  break label667;
                }
                locala.nxE.setText("");
                break label667;
              }
              locala.nxE.setText("");
              break label667;
              label1168:
              locala.nxI.setVisibility(8);
              break label717;
            }
          }
          locala.nxx.removeAllViews();
          if (com.tencent.mm.plugin.card.sharecard.a.b.QD(paramb.bIa()))
          {
            localObject1 = bKb();
            ((CardTagTextView)localObject1).setPadding(this.nxs, this.nxr, this.nxs, this.nxr);
            ((CardTagTextView)localObject1).setTextColor(this.mContext.getResources().getColor(2131100798));
            ((CardTagTextView)localObject1).setText(this.mContext.getString(2131756989));
            ((CardTagTextView)localObject1).setTextSize(12.0F);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).rightMargin = this.mContext.getResources().getDimensionPixelOffset(2131165490);
            locala.nxx.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          }
          if ((paramb.bHV().CRX == null) || (bt.gL(paramb.bHV().CRX.EyA))) {
            break label1462;
          }
          localObject1 = paramb.bHV().CRX.EyA.iterator();
        }
      }
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (dax)((Iterator)localObject1).next();
        CardTagTextView localCardTagTextView = bKb();
        localCardTagTextView.setPadding(this.nxs, this.nxr, this.nxs, this.nxr);
        localCardTagTextView.setTextColor(l.Rm(((dax)localObject2).gHT));
        localCardTagTextView.setText(((dax)localObject2).tag);
        localCardTagTextView.setTextSize(12.0F);
        locala.nxx.addView(localCardTagTextView);
        continue;
        locala.nxx.setVisibility(8);
      }
      label1462:
      if ((paramInt == this.nxo.getCount() - 1) && (locala.nxA != null))
      {
        localObject1 = (LinearLayout.LayoutParams)locala.nxA.getLayoutParams();
        if (((LinearLayout.LayoutParams)localObject1).bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131165490))
        {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165490);
          locala.nxA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      for (;;)
      {
        this.nxp = (System.currentTimeMillis() - l + this.nxp);
        this.nxq += 1L;
        if (!this.nxu.contains(paramb.bHZ()))
        {
          this.nxu.add(paramb.bHZ());
          this.nxv.add(paramb.bIa());
          this.nxt.add(Integer.valueOf(paramInt));
        }
        AppMethodBeat.o(113143);
        return paramView;
        label1633:
        locala.nxB.setVisibility(8);
        locala.nxC.setVisibility(8);
        locala.nxx.setVisibility(8);
        locala.nxD.setVisibility(8);
        locala.nxI.setVisibility(8);
        locala.nxH.setVisibility(8);
        locala.nxE.setVisibility(8);
        locala.nxF.setVisibility(8);
        locala.nxG.setVisibility(0);
        locala.nxG.setText(this.mContext.getResources().getString(2131756947));
        break;
        if (locala.nxA != null)
        {
          localObject1 = (LinearLayout.LayoutParams)locala.nxA.getLayoutParams();
          if (((LinearLayout.LayoutParams)localObject1).bottomMargin != 0)
          {
            ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
            locala.nxA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
      label1794:
      i = 0;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener) {}
  
  public final void release()
  {
    AppMethodBeat.i(113142);
    this.mContext = null;
    this.nxo = null;
    if (this.nxq > 0L)
    {
      ArrayList localArrayList = new ArrayList();
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(281);
      localIDKey1.SetKey(5);
      localIDKey1.SetValue(1L);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(281);
      localIDKey2.SetKey(6);
      localIDKey2.SetValue((int)(this.nxp / this.nxq));
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      h.vKh.b(localArrayList, true);
    }
    if ((this.nxt.size() == this.nxu.size()) && (this.nxu.size() == this.nxv.size()) && (this.nxt.size() > 0))
    {
      long l = System.currentTimeMillis();
      int i = 0;
      while (i < this.nxt.size())
      {
        h.vKh.f(13220, new Object[] { this.nxv.get(i), this.nxu.get(i), this.nxt.get(i), Long.valueOf(l) });
        i += 1;
      }
    }
    this.nxt.clear();
    this.nxu.clear();
    this.nxv.clear();
    if (this.nxw != null) {
      this.nxw.clear();
    }
    AppMethodBeat.o(113142);
  }
  
  public final class a
  {
    public RelativeLayout nxA;
    public ImageView nxB;
    public TextView nxC;
    public TextView nxD;
    public TextView nxE;
    public TextView nxF;
    public TextView nxG;
    public View nxH;
    public TextView nxI;
    public LinearLayout nxx;
    public TextView nxy;
    public TextView nxz;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.j
 * JD-Core Version:    0.7.0.1
 */