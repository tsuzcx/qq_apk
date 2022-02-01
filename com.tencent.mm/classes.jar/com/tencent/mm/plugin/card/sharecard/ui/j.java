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
import com.tencent.mm.protocal.protobuf.dgj;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  implements c
{
  private Context mContext;
  private BaseAdapter oao;
  private long oap;
  private long oaq;
  private int oar;
  private int oas;
  private ArrayList<Integer> oat;
  private ArrayList<String> oau;
  private ArrayList<String> oav;
  protected LinkedList<CardTagTextView> oaw;
  
  public j(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113141);
    this.oap = 0L;
    this.oaq = 0L;
    this.oat = new ArrayList();
    this.oau = new ArrayList();
    this.oav = new ArrayList();
    this.oaw = new LinkedList();
    this.mContext = paramContext;
    this.oao = paramBaseAdapter;
    this.oar = this.mContext.getResources().getDimensionPixelSize(2131165519);
    this.oas = this.mContext.getResources().getDimensionPixelSize(2131165500);
    this.oat.clear();
    this.oau.clear();
    this.oav.clear();
    AppMethodBeat.o(113141);
  }
  
  private CardTagTextView bRo()
  {
    AppMethodBeat.i(113144);
    if (this.oaw.size() == 0)
    {
      localCardTagTextView = new CardTagTextView(this.mContext);
      AppMethodBeat.o(113144);
      return localCardTagTextView;
    }
    CardTagTextView localCardTagTextView = (CardTagTextView)this.oaw.removeFirst();
    AppMethodBeat.o(113144);
    return localCardTagTextView;
  }
  
  public final void Y(View paramView, int paramInt) {}
  
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
      locala.oax = ((LinearLayout)paramView.findViewById(2131297904));
      locala.oay = ((TextView)paramView.findViewById(2131297834));
      locala.oaz = ((TextView)paramView.findViewById(2131297838));
      locala.oaA = ((RelativeLayout)paramView.findViewById(2131297771));
      locala.oaB = ((ImageView)paramView.findViewById(2131297828));
      locala.oaC = ((TextView)paramView.findViewById(2131297743));
      locala.oaD = ((TextView)paramView.findViewById(2131297863));
      locala.oaH = paramView.findViewById(2131297840);
      locala.oaE = ((TextView)paramView.findViewById(2131305529));
      locala.oaF = ((TextView)paramView.findViewById(2131297732));
      locala.oaG = ((TextView)paramView.findViewById(2131297864));
      locala.oaI = ((TextView)paramView.findViewById(2131297774));
      locala.oaE.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      paramView.setTag(locala);
      localObject1 = (com.tencent.mm.plugin.card.base.b)this.oao.getItem(paramInt);
      j = ((com.tencent.mm.plugin.card.base.b)localObject1).bPr();
      if (!com.tencent.mm.plugin.card.sharecard.a.b.zJ(((com.tencent.mm.plugin.card.base.b)localObject1).bPr())) {
        break label1794;
      }
      if (paramInt != 0) {
        break label830;
      }
      if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).zE(j))) {
        break label1794;
      }
      i = 1;
    }
    for (;;)
    {
      label274:
      if (i != 0)
      {
        locala.oay.setVisibility(0);
        locala.oay.setText(((com.tencent.mm.plugin.card.base.b)localObject1).zE(j));
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).bPq()))
        {
          locala.oaz.setVisibility(0);
          locala.oaz.setText(((com.tencent.mm.plugin.card.base.b)localObject1).bPq());
          label342:
          if (!paramb.bOU()) {
            break label1633;
          }
          locala.oaB.setVisibility(0);
          locala.oaC.setVisibility(0);
          locala.oax.setVisibility(0);
          locala.oaD.setVisibility(0);
          locala.oaI.setVisibility(0);
          locala.oaH.setVisibility(0);
          locala.oaE.setVisibility(0);
          locala.oaF.setVisibility(0);
          locala.oaG.setVisibility(8);
          locala.oaC.setText(paramb.bPi().nVK);
          if (!paramb.bOR()) {
            break label1018;
          }
          if ((paramb.bPi().Ekq == null) || (paramb.bPi().Ekq.size() != 1)) {
            break label906;
          }
          locala.oaD.setText(((yg)paramb.bPi().Ekq.get(0)).title);
          i = this.mContext.getResources().getDimensionPixelSize(2131165979);
          n.a(locala.oaB, paramb.bPi().hhs, i, 2131233400, true);
          locala.oaC.setTextColor(this.mContext.getResources().getColor(2131100085));
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.UM(paramb.bPn());
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1038;
          }
          locala.oaF.setText((CharSequence)localObject1);
          label602:
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.Bs(paramb.bPn());
          boolean bool = com.tencent.mm.plugin.card.sharecard.a.b.zJ(paramb.bPr());
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!bool)) {
            break label1052;
          }
          locala.oaE.setText(k.b(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(2131165574)));
          label667:
          i = com.tencent.mm.plugin.card.sharecard.a.b.UN(paramb.bPn());
          if ((i <= 1) || (!bool)) {
            break label1168;
          }
          locala.oaI.setText("X".concat(String.valueOf(i)));
          locala.oaI.setVisibility(0);
        }
      }
      label514:
      label717:
      label1018:
      Object localObject2;
      for (;;)
      {
        if (((paramb.bPi().EkI != null) && (!bs.gY(paramb.bPi().EkI.FVC))) || (com.tencent.mm.plugin.card.sharecard.a.b.UP(paramb.bPn())))
        {
          locala.oax.setVisibility(0);
          i = 0;
          for (;;)
          {
            if (i < locala.oax.getChildCount())
            {
              localObject1 = (CardTagTextView)locala.oax.getChildAt(i);
              this.oaw.add(localObject1);
              i += 1;
              continue;
              locala = (a)paramView.getTag();
              break;
              label830:
              if (j == ((com.tencent.mm.plugin.card.base.b)this.oao.getItem(paramInt - 1)).bPr()) {
                break label1794;
              }
              i = 1;
              break label274;
              locala.oaz.setVisibility(8);
              break label342;
              locala.oay.setVisibility(8);
              locala.oaz.setVisibility(8);
              locala.oay.setText("");
              break label342;
              label906:
              if ((paramb.bPi().Ekq == null) || (paramb.bPi().Ekq.size() != 2)) {
                break label514;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((yg)paramb.bPi().Ekq.get(0)).title);
              ((StringBuilder)localObject1).append("-");
              ((StringBuilder)localObject1).append(((yg)paramb.bPi().Ekq.get(1)).title);
              locala.oaD.setText(((StringBuilder)localObject1).toString());
              break label514;
              locala.oaD.setText(paramb.bPi().title);
              break label514;
              label1038:
              locala.oaF.setText("");
              break label602;
              label1052:
              if (!TextUtils.isEmpty(paramb.bPo()))
              {
                localObject1 = l.VA(paramb.bPo());
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject1 = this.mContext.getResources().getString(2131756978, new Object[] { localObject1 });
                  locala.oaE.setText(k.b(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(2131165574)));
                  break label667;
                }
                locala.oaE.setText("");
                break label667;
              }
              locala.oaE.setText("");
              break label667;
              label1168:
              locala.oaI.setVisibility(8);
              break label717;
            }
          }
          locala.oax.removeAllViews();
          if (com.tencent.mm.plugin.card.sharecard.a.b.UP(paramb.bPn()))
          {
            localObject1 = bRo();
            ((CardTagTextView)localObject1).setPadding(this.oas, this.oar, this.oas, this.oar);
            ((CardTagTextView)localObject1).setTextColor(this.mContext.getResources().getColor(2131100798));
            ((CardTagTextView)localObject1).setText(this.mContext.getString(2131756989));
            ((CardTagTextView)localObject1).setTextSize(12.0F);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).rightMargin = this.mContext.getResources().getDimensionPixelOffset(2131165490);
            locala.oax.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          }
          if ((paramb.bPi().EkI == null) || (bs.gY(paramb.bPi().EkI.FVC))) {
            break label1462;
          }
          localObject1 = paramb.bPi().EkI.FVC.iterator();
        }
      }
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (dgj)((Iterator)localObject1).next();
        CardTagTextView localCardTagTextView = bRo();
        localCardTagTextView.setPadding(this.oas, this.oar, this.oas, this.oar);
        localCardTagTextView.setTextColor(l.Vy(((dgj)localObject2).hiu));
        localCardTagTextView.setText(((dgj)localObject2).tag);
        localCardTagTextView.setTextSize(12.0F);
        locala.oax.addView(localCardTagTextView);
        continue;
        locala.oax.setVisibility(8);
      }
      label1462:
      if ((paramInt == this.oao.getCount() - 1) && (locala.oaA != null))
      {
        localObject1 = (LinearLayout.LayoutParams)locala.oaA.getLayoutParams();
        if (((LinearLayout.LayoutParams)localObject1).bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131165490))
        {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165490);
          locala.oaA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      for (;;)
      {
        this.oap = (System.currentTimeMillis() - l + this.oap);
        this.oaq += 1L;
        if (!this.oau.contains(paramb.bPm()))
        {
          this.oau.add(paramb.bPm());
          this.oav.add(paramb.bPn());
          this.oat.add(Integer.valueOf(paramInt));
        }
        AppMethodBeat.o(113143);
        return paramView;
        label1633:
        locala.oaB.setVisibility(8);
        locala.oaC.setVisibility(8);
        locala.oax.setVisibility(8);
        locala.oaD.setVisibility(8);
        locala.oaI.setVisibility(8);
        locala.oaH.setVisibility(8);
        locala.oaE.setVisibility(8);
        locala.oaF.setVisibility(8);
        locala.oaG.setVisibility(0);
        locala.oaG.setText(this.mContext.getResources().getString(2131756947));
        break;
        if (locala.oaA != null)
        {
          localObject1 = (LinearLayout.LayoutParams)locala.oaA.getLayoutParams();
          if (((LinearLayout.LayoutParams)localObject1).bottomMargin != 0)
          {
            ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
            locala.oaA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
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
    this.oao = null;
    if (this.oaq > 0L)
    {
      ArrayList localArrayList = new ArrayList();
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(281);
      localIDKey1.SetKey(5);
      localIDKey1.SetValue(1L);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(281);
      localIDKey2.SetKey(6);
      localIDKey2.SetValue((int)(this.oap / this.oaq));
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      h.wUl.b(localArrayList, true);
    }
    if ((this.oat.size() == this.oau.size()) && (this.oau.size() == this.oav.size()) && (this.oat.size() > 0))
    {
      long l = System.currentTimeMillis();
      int i = 0;
      while (i < this.oat.size())
      {
        h.wUl.f(13220, new Object[] { this.oav.get(i), this.oau.get(i), this.oat.get(i), Long.valueOf(l) });
        i += 1;
      }
    }
    this.oat.clear();
    this.oau.clear();
    this.oav.clear();
    if (this.oaw != null) {
      this.oaw.clear();
    }
    AppMethodBeat.o(113142);
  }
  
  public final class a
  {
    public RelativeLayout oaA;
    public ImageView oaB;
    public TextView oaC;
    public TextView oaD;
    public TextView oaE;
    public TextView oaF;
    public TextView oaG;
    public View oaH;
    public TextView oaI;
    public LinearLayout oax;
    public TextView oay;
    public TextView oaz;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.j
 * JD-Core Version:    0.7.0.1
 */