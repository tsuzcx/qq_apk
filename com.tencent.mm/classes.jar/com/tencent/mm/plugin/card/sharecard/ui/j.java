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
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.flo;
import com.tencent.mm.protocal.protobuf.fum;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  implements c
{
  private Context mContext;
  private int vtQ;
  private BaseAdapter wyr;
  private long wys;
  private long wyt;
  private int wyu;
  private ArrayList<Integer> wyv;
  private ArrayList<String> wyw;
  private ArrayList<String> wyx;
  protected LinkedList<CardTagTextView> wyy;
  
  public j(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113141);
    this.wys = 0L;
    this.wyt = 0L;
    this.wyv = new ArrayList();
    this.wyw = new ArrayList();
    this.wyx = new ArrayList();
    this.wyy = new LinkedList();
    this.mContext = paramContext;
    this.wyr = paramBaseAdapter;
    this.vtQ = this.mContext.getResources().getDimensionPixelSize(a.b.OneDPPadding);
    this.wyu = this.mContext.getResources().getDimensionPixelSize(a.b.MiddlePadding);
    this.wyv.clear();
    this.wyw.clear();
    this.wyx.clear();
    AppMethodBeat.o(113141);
  }
  
  private CardTagTextView dlR()
  {
    AppMethodBeat.i(113144);
    if (this.wyy.size() == 0)
    {
      localCardTagTextView = new CardTagTextView(this.mContext);
      AppMethodBeat.o(113144);
      return localCardTagTextView;
    }
    CardTagTextView localCardTagTextView = (CardTagTextView)this.wyy.removeFirst();
    AppMethodBeat.o(113144);
    return localCardTagTextView;
  }
  
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
      paramView = View.inflate(this.mContext, a.e.wnB, null);
      locala = new a();
      locala.wyz = ((LinearLayout)paramView.findViewById(a.d.whP));
      locala.wyA = ((TextView)paramView.findViewById(a.d.wgN));
      locala.wyB = ((TextView)paramView.findViewById(a.d.wgP));
      locala.wyC = ((RelativeLayout)paramView.findViewById(a.d.wfV));
      locala.wyD = ((ImageView)paramView.findViewById(a.d.wgJ));
      locala.wyE = ((TextView)paramView.findViewById(a.d.fvq));
      locala.wyF = ((TextView)paramView.findViewById(a.d.whj));
      locala.wyJ = paramView.findViewById(a.d.wgR);
      locala.wyG = ((TextView)paramView.findViewById(a.d.subtitle));
      locala.wyH = ((TextView)paramView.findViewById(a.d.wfq));
      locala.wyI = ((TextView)paramView.findViewById(a.d.whk));
      locala.wyK = ((TextView)paramView.findViewById(a.d.wfX));
      locala.wyG.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      paramView.setTag(locala);
      localObject1 = (com.tencent.mm.plugin.card.base.b)this.wyr.getItem(paramInt);
      j = ((com.tencent.mm.plugin.card.base.b)localObject1).getCategoryType();
      if (!com.tencent.mm.plugin.card.sharecard.a.b.Il(((com.tencent.mm.plugin.card.base.b)localObject1).getCategoryType())) {
        break label1807;
      }
      if (paramInt != 0) {
        break label843;
      }
      if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).Ig(j))) {
        break label1807;
      }
      i = 1;
    }
    for (;;)
    {
      label287:
      if (i != 0)
      {
        locala.wyA.setVisibility(0);
        locala.wyA.setText(((com.tencent.mm.plugin.card.base.b)localObject1).Ig(j));
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).djS()))
        {
          locala.wyB.setVisibility(0);
          locala.wyB.setText(((com.tencent.mm.plugin.card.base.b)localObject1).djS());
          label355:
          if (!paramb.djv()) {
            break label1646;
          }
          locala.wyD.setVisibility(0);
          locala.wyE.setVisibility(0);
          locala.wyz.setVisibility(0);
          locala.wyF.setVisibility(0);
          locala.wyK.setVisibility(0);
          locala.wyJ.setVisibility(0);
          locala.wyG.setVisibility(0);
          locala.wyH.setVisibility(0);
          locala.wyI.setVisibility(8);
          locala.wyE.setText(paramb.djK().mee);
          if (!paramb.djs()) {
            break label1031;
          }
          if ((paramb.djK().ZdK == null) || (paramb.djK().ZdK.size() != 1)) {
            break label919;
          }
          locala.wyF.setText(((aek)paramb.djK().ZdK.get(0)).title);
          i = this.mContext.getResources().getDimensionPixelSize(a.b.wdU);
          n.a(locala.wyD, paramb.djK().nQG, i, a.c.my_card_package_defaultlogo, true);
          locala.wyE.setTextColor(this.mContext.getResources().getColor(a.a.wdC));
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.akJ(paramb.djP());
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1051;
          }
          locala.wyH.setText((CharSequence)localObject1);
          label615:
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.Nc(paramb.djP());
          boolean bool = com.tencent.mm.plugin.card.sharecard.a.b.Il(paramb.getCategoryType());
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!bool)) {
            break label1065;
          }
          locala.wyG.setText(p.d(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(a.b.SmallerTextSize)));
          label680:
          i = com.tencent.mm.plugin.card.sharecard.a.b.akK(paramb.djP());
          if ((i <= 1) || (!bool)) {
            break label1181;
          }
          locala.wyK.setText("X".concat(String.valueOf(i)));
          locala.wyK.setVisibility(0);
        }
      }
      label527:
      label730:
      Object localObject2;
      for (;;)
      {
        if (((paramb.djK().Zec != null) && (!Util.isNullOrNil(paramb.djK().Zec.abSG))) || (com.tencent.mm.plugin.card.sharecard.a.b.akM(paramb.djP())))
        {
          locala.wyz.setVisibility(0);
          i = 0;
          for (;;)
          {
            if (i < locala.wyz.getChildCount())
            {
              localObject1 = (CardTagTextView)locala.wyz.getChildAt(i);
              this.wyy.add(localObject1);
              i += 1;
              continue;
              locala = (a)paramView.getTag();
              break;
              label843:
              if (j == ((com.tencent.mm.plugin.card.base.b)this.wyr.getItem(paramInt - 1)).getCategoryType()) {
                break label1807;
              }
              i = 1;
              break label287;
              locala.wyB.setVisibility(8);
              break label355;
              locala.wyA.setVisibility(8);
              locala.wyB.setVisibility(8);
              locala.wyA.setText("");
              break label355;
              label919:
              if ((paramb.djK().ZdK == null) || (paramb.djK().ZdK.size() != 2)) {
                break label527;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((aek)paramb.djK().ZdK.get(0)).title);
              ((StringBuilder)localObject1).append("-");
              ((StringBuilder)localObject1).append(((aek)paramb.djK().ZdK.get(1)).title);
              locala.wyF.setText(((StringBuilder)localObject1).toString());
              break label527;
              label1031:
              locala.wyF.setText(paramb.djK().title);
              break label527;
              label1051:
              locala.wyH.setText("");
              break label615;
              label1065:
              if (!TextUtils.isEmpty(paramb.djQ()))
              {
                localObject1 = l.alx(paramb.djQ());
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject1 = this.mContext.getResources().getString(a.g.wpY, new Object[] { localObject1 });
                  locala.wyG.setText(p.d(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(a.b.SmallerTextSize)));
                  break label680;
                }
                locala.wyG.setText("");
                break label680;
              }
              locala.wyG.setText("");
              break label680;
              label1181:
              locala.wyK.setVisibility(8);
              break label730;
            }
          }
          locala.wyz.removeAllViews();
          if (com.tencent.mm.plugin.card.sharecard.a.b.akM(paramb.djP()))
          {
            localObject1 = dlR();
            ((CardTagTextView)localObject1).setPadding(this.wyu, this.vtQ, this.wyu, this.vtQ);
            ((CardTagTextView)localObject1).setTextColor(this.mContext.getResources().getColor(a.a.red));
            ((CardTagTextView)localObject1).setText(this.mContext.getString(a.g.wqg));
            ((CardTagTextView)localObject1).setTextSize(12.0F);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).rightMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding);
            locala.wyz.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          }
          if ((paramb.djK().Zec == null) || (Util.isNullOrNil(paramb.djK().Zec.abSG))) {
            break label1475;
          }
          localObject1 = paramb.djK().Zec.abSG.iterator();
        }
      }
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (flo)((Iterator)localObject1).next();
        CardTagTextView localCardTagTextView = dlR();
        localCardTagTextView.setPadding(this.wyu, this.vtQ, this.wyu, this.vtQ);
        localCardTagTextView.setTextColor(l.alv(((flo)localObject2).nRQ));
        localCardTagTextView.setText(((flo)localObject2).tag);
        localCardTagTextView.setTextSize(12.0F);
        locala.wyz.addView(localCardTagTextView);
        continue;
        locala.wyz.setVisibility(8);
      }
      label1475:
      if ((paramInt == this.wyr.getCount() - 1) && (locala.wyC != null))
      {
        localObject1 = (LinearLayout.LayoutParams)locala.wyC.getLayoutParams();
        if (((LinearLayout.LayoutParams)localObject1).bottomMargin != this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding))
        {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding);
          locala.wyC.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      for (;;)
      {
        this.wys = (System.currentTimeMillis() - l + this.wys);
        this.wyt += 1L;
        if (!this.wyw.contains(paramb.djO()))
        {
          this.wyw.add(paramb.djO());
          this.wyx.add(paramb.djP());
          this.wyv.add(Integer.valueOf(paramInt));
        }
        AppMethodBeat.o(113143);
        return paramView;
        label1646:
        locala.wyD.setVisibility(8);
        locala.wyE.setVisibility(8);
        locala.wyz.setVisibility(8);
        locala.wyF.setVisibility(8);
        locala.wyK.setVisibility(8);
        locala.wyJ.setVisibility(8);
        locala.wyG.setVisibility(8);
        locala.wyH.setVisibility(8);
        locala.wyI.setVisibility(0);
        locala.wyI.setText(this.mContext.getResources().getString(a.g.card_not_support_card_type));
        break;
        if (locala.wyC != null)
        {
          localObject1 = (LinearLayout.LayoutParams)locala.wyC.getLayoutParams();
          if (((LinearLayout.LayoutParams)localObject1).bottomMargin != 0)
          {
            ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
            locala.wyC.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
      label1807:
      i = 0;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener) {}
  
  public final void af(View paramView, int paramInt) {}
  
  public final void ag(View paramView, int paramInt) {}
  
  public final void release()
  {
    AppMethodBeat.i(113142);
    this.mContext = null;
    this.wyr = null;
    if (this.wyt > 0L)
    {
      ArrayList localArrayList = new ArrayList();
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(281);
      localIDKey1.SetKey(5);
      localIDKey1.SetValue(1L);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(281);
      localIDKey2.SetKey(6);
      localIDKey2.SetValue((int)(this.wys / this.wyt));
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      h.OAn.b(localArrayList, true);
    }
    if ((this.wyv.size() == this.wyw.size()) && (this.wyw.size() == this.wyx.size()) && (this.wyv.size() > 0))
    {
      long l = System.currentTimeMillis();
      int i = 0;
      while (i < this.wyv.size())
      {
        h.OAn.b(13220, new Object[] { this.wyx.get(i), this.wyw.get(i), this.wyv.get(i), Long.valueOf(l) });
        i += 1;
      }
    }
    this.wyv.clear();
    this.wyw.clear();
    this.wyx.clear();
    if (this.wyy != null) {
      this.wyy.clear();
    }
    AppMethodBeat.o(113142);
  }
  
  public final class a
  {
    public TextView wyA;
    public TextView wyB;
    public RelativeLayout wyC;
    public ImageView wyD;
    public TextView wyE;
    public TextView wyF;
    public TextView wyG;
    public TextView wyH;
    public TextView wyI;
    public View wyJ;
    public TextView wyK;
    public LinearLayout wyz;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.j
 * JD-Core Version:    0.7.0.1
 */