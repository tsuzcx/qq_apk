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
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.egi;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  implements c
{
  private Context mContext;
  private BaseAdapter pXY;
  private long pXZ;
  private long pYa;
  private int pYb;
  private int pYc;
  private ArrayList<Integer> pYd;
  private ArrayList<String> pYe;
  private ArrayList<String> pYf;
  protected LinkedList<CardTagTextView> pYg;
  
  public j(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113141);
    this.pXZ = 0L;
    this.pYa = 0L;
    this.pYd = new ArrayList();
    this.pYe = new ArrayList();
    this.pYf = new ArrayList();
    this.pYg = new LinkedList();
    this.mContext = paramContext;
    this.pXY = paramBaseAdapter;
    this.pYb = this.mContext.getResources().getDimensionPixelSize(2131165537);
    this.pYc = this.mContext.getResources().getDimensionPixelSize(2131165518);
    this.pYd.clear();
    this.pYe.clear();
    this.pYf.clear();
    AppMethodBeat.o(113141);
  }
  
  private CardTagTextView cuY()
  {
    AppMethodBeat.i(113144);
    if (this.pYg.size() == 0)
    {
      localCardTagTextView = new CardTagTextView(this.mContext);
      AppMethodBeat.o(113144);
      return localCardTagTextView;
    }
    CardTagTextView localCardTagTextView = (CardTagTextView)this.pYg.removeFirst();
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
      paramView = View.inflate(this.mContext, 2131493432, null);
      locala = new a();
      locala.pYh = ((LinearLayout)paramView.findViewById(2131298222));
      locala.pYi = ((TextView)paramView.findViewById(2131298150));
      locala.pYj = ((TextView)paramView.findViewById(2131298154));
      locala.pYk = ((RelativeLayout)paramView.findViewById(2131298086));
      locala.pYl = ((ImageView)paramView.findViewById(2131298144));
      locala.pYm = ((TextView)paramView.findViewById(2131298056));
      locala.pYn = ((TextView)paramView.findViewById(2131298179));
      locala.pYr = paramView.findViewById(2131298156);
      locala.pYo = ((TextView)paramView.findViewById(2131308746));
      locala.pYp = ((TextView)paramView.findViewById(2131298036));
      locala.pYq = ((TextView)paramView.findViewById(2131298180));
      locala.pYs = ((TextView)paramView.findViewById(2131298089));
      locala.pYo.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      paramView.setTag(locala);
      localObject1 = (com.tencent.mm.plugin.card.base.b)this.pXY.getItem(paramInt);
      j = ((com.tencent.mm.plugin.card.base.b)localObject1).csZ();
      if (!com.tencent.mm.plugin.card.sharecard.a.b.Ej(((com.tencent.mm.plugin.card.base.b)localObject1).csZ())) {
        break label1794;
      }
      if (paramInt != 0) {
        break label830;
      }
      if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).Ee(j))) {
        break label1794;
      }
      i = 1;
    }
    for (;;)
    {
      label274:
      if (i != 0)
      {
        locala.pYi.setVisibility(0);
        locala.pYi.setText(((com.tencent.mm.plugin.card.base.b)localObject1).Ee(j));
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).csY()))
        {
          locala.pYj.setVisibility(0);
          locala.pYj.setText(((com.tencent.mm.plugin.card.base.b)localObject1).csY());
          label342:
          if (!paramb.csC()) {
            break label1633;
          }
          locala.pYl.setVisibility(0);
          locala.pYm.setVisibility(0);
          locala.pYh.setVisibility(0);
          locala.pYn.setVisibility(0);
          locala.pYs.setVisibility(0);
          locala.pYr.setVisibility(0);
          locala.pYo.setVisibility(0);
          locala.pYp.setVisibility(0);
          locala.pYq.setVisibility(8);
          locala.pYm.setText(paramb.csQ().gTG);
          if (!paramb.csz()) {
            break label1018;
          }
          if ((paramb.csQ().LeC == null) || (paramb.csQ().LeC.size() != 1)) {
            break label906;
          }
          locala.pYn.setText(((abz)paramb.csQ().LeC.get(0)).title);
          i = this.mContext.getResources().getDimensionPixelSize(2131166011);
          n.a(locala.pYl, paramb.csQ().iwv, i, 2131234198, true);
          locala.pYm.setTextColor(this.mContext.getResources().getColor(2131100116));
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.ajr(paramb.csV());
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1038;
          }
          locala.pYp.setText((CharSequence)localObject1);
          label602:
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.NH(paramb.csV());
          boolean bool = com.tencent.mm.plugin.card.sharecard.a.b.Ej(paramb.csZ());
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!bool)) {
            break label1052;
          }
          locala.pYo.setText(com.tencent.mm.pluginsdk.ui.span.l.e(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(2131165592)));
          label667:
          i = com.tencent.mm.plugin.card.sharecard.a.b.ajs(paramb.csV());
          if ((i <= 1) || (!bool)) {
            break label1168;
          }
          locala.pYs.setText("X".concat(String.valueOf(i)));
          locala.pYs.setVisibility(0);
        }
      }
      label514:
      label717:
      label1018:
      Object localObject2;
      for (;;)
      {
        if (((paramb.csQ().LeT != null) && (!Util.isNullOrNil(paramb.csQ().LeT.Nmk))) || (com.tencent.mm.plugin.card.sharecard.a.b.aju(paramb.csV())))
        {
          locala.pYh.setVisibility(0);
          i = 0;
          for (;;)
          {
            if (i < locala.pYh.getChildCount())
            {
              localObject1 = (CardTagTextView)locala.pYh.getChildAt(i);
              this.pYg.add(localObject1);
              i += 1;
              continue;
              locala = (a)paramView.getTag();
              break;
              label830:
              if (j == ((com.tencent.mm.plugin.card.base.b)this.pXY.getItem(paramInt - 1)).csZ()) {
                break label1794;
              }
              i = 1;
              break label274;
              locala.pYj.setVisibility(8);
              break label342;
              locala.pYi.setVisibility(8);
              locala.pYj.setVisibility(8);
              locala.pYi.setText("");
              break label342;
              label906:
              if ((paramb.csQ().LeC == null) || (paramb.csQ().LeC.size() != 2)) {
                break label514;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((abz)paramb.csQ().LeC.get(0)).title);
              ((StringBuilder)localObject1).append("-");
              ((StringBuilder)localObject1).append(((abz)paramb.csQ().LeC.get(1)).title);
              locala.pYn.setText(((StringBuilder)localObject1).toString());
              break label514;
              locala.pYn.setText(paramb.csQ().title);
              break label514;
              label1038:
              locala.pYp.setText("");
              break label602;
              label1052:
              if (!TextUtils.isEmpty(paramb.csW()))
              {
                localObject1 = com.tencent.mm.plugin.card.d.l.akg(paramb.csW());
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject1 = this.mContext.getResources().getString(2131757148, new Object[] { localObject1 });
                  locala.pYo.setText(com.tencent.mm.pluginsdk.ui.span.l.e(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(2131165592)));
                  break label667;
                }
                locala.pYo.setText("");
                break label667;
              }
              locala.pYo.setText("");
              break label667;
              label1168:
              locala.pYs.setVisibility(8);
              break label717;
            }
          }
          locala.pYh.removeAllViews();
          if (com.tencent.mm.plugin.card.sharecard.a.b.aju(paramb.csV()))
          {
            localObject1 = cuY();
            ((CardTagTextView)localObject1).setPadding(this.pYc, this.pYb, this.pYc, this.pYb);
            ((CardTagTextView)localObject1).setTextColor(this.mContext.getResources().getColor(2131100994));
            ((CardTagTextView)localObject1).setText(this.mContext.getString(2131757159));
            ((CardTagTextView)localObject1).setTextSize(12.0F);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).rightMargin = this.mContext.getResources().getDimensionPixelOffset(2131165508);
            locala.pYh.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          }
          if ((paramb.csQ().LeT == null) || (Util.isNullOrNil(paramb.csQ().LeT.Nmk))) {
            break label1462;
          }
          localObject1 = paramb.csQ().LeT.Nmk.iterator();
        }
      }
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (egi)((Iterator)localObject1).next();
        CardTagTextView localCardTagTextView = cuY();
        localCardTagTextView.setPadding(this.pYc, this.pYb, this.pYc, this.pYb);
        localCardTagTextView.setTextColor(com.tencent.mm.plugin.card.d.l.ake(((egi)localObject2).ixw));
        localCardTagTextView.setText(((egi)localObject2).tag);
        localCardTagTextView.setTextSize(12.0F);
        locala.pYh.addView(localCardTagTextView);
        continue;
        locala.pYh.setVisibility(8);
      }
      label1462:
      if ((paramInt == this.pXY.getCount() - 1) && (locala.pYk != null))
      {
        localObject1 = (LinearLayout.LayoutParams)locala.pYk.getLayoutParams();
        if (((LinearLayout.LayoutParams)localObject1).bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131165508))
        {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165508);
          locala.pYk.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      for (;;)
      {
        this.pXZ = (System.currentTimeMillis() - l + this.pXZ);
        this.pYa += 1L;
        if (!this.pYe.contains(paramb.csU()))
        {
          this.pYe.add(paramb.csU());
          this.pYf.add(paramb.csV());
          this.pYd.add(Integer.valueOf(paramInt));
        }
        AppMethodBeat.o(113143);
        return paramView;
        label1633:
        locala.pYl.setVisibility(8);
        locala.pYm.setVisibility(8);
        locala.pYh.setVisibility(8);
        locala.pYn.setVisibility(8);
        locala.pYs.setVisibility(8);
        locala.pYr.setVisibility(8);
        locala.pYo.setVisibility(8);
        locala.pYp.setVisibility(8);
        locala.pYq.setVisibility(0);
        locala.pYq.setText(this.mContext.getResources().getString(2131757117));
        break;
        if (locala.pYk != null)
        {
          localObject1 = (LinearLayout.LayoutParams)locala.pYk.getLayoutParams();
          if (((LinearLayout.LayoutParams)localObject1).bottomMargin != 0)
          {
            ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
            locala.pYk.setLayoutParams((ViewGroup.LayoutParams)localObject1);
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
    this.pXY = null;
    if (this.pYa > 0L)
    {
      ArrayList localArrayList = new ArrayList();
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(281);
      localIDKey1.SetKey(5);
      localIDKey1.SetValue(1L);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(281);
      localIDKey2.SetKey(6);
      localIDKey2.SetValue((int)(this.pXZ / this.pYa));
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      h.CyF.b(localArrayList, true);
    }
    if ((this.pYd.size() == this.pYe.size()) && (this.pYe.size() == this.pYf.size()) && (this.pYd.size() > 0))
    {
      long l = System.currentTimeMillis();
      int i = 0;
      while (i < this.pYd.size())
      {
        h.CyF.a(13220, new Object[] { this.pYf.get(i), this.pYe.get(i), this.pYd.get(i), Long.valueOf(l) });
        i += 1;
      }
    }
    this.pYd.clear();
    this.pYe.clear();
    this.pYf.clear();
    if (this.pYg != null) {
      this.pYg.clear();
    }
    AppMethodBeat.o(113142);
  }
  
  public final class a
  {
    public LinearLayout pYh;
    public TextView pYi;
    public TextView pYj;
    public RelativeLayout pYk;
    public ImageView pYl;
    public TextView pYm;
    public TextView pYn;
    public TextView pYo;
    public TextView pYp;
    public TextView pYq;
    public View pYr;
    public TextView pYs;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.j
 * JD-Core Version:    0.7.0.1
 */