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
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.dlw;
import com.tencent.mm.protocal.protobuf.dtp;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  implements c
{
  private Context mContext;
  private BaseAdapter oDI;
  private long oDJ;
  private long oDK;
  private int oDL;
  private int oDM;
  private ArrayList<Integer> oDN;
  private ArrayList<String> oDO;
  private ArrayList<String> oDP;
  protected LinkedList<CardTagTextView> oDQ;
  
  public j(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113141);
    this.oDJ = 0L;
    this.oDK = 0L;
    this.oDN = new ArrayList();
    this.oDO = new ArrayList();
    this.oDP = new ArrayList();
    this.oDQ = new LinkedList();
    this.mContext = paramContext;
    this.oDI = paramBaseAdapter;
    this.oDL = this.mContext.getResources().getDimensionPixelSize(2131165519);
    this.oDM = this.mContext.getResources().getDimensionPixelSize(2131165500);
    this.oDN.clear();
    this.oDO.clear();
    this.oDP.clear();
    AppMethodBeat.o(113141);
  }
  
  private CardTagTextView bVT()
  {
    AppMethodBeat.i(113144);
    if (this.oDQ.size() == 0)
    {
      localCardTagTextView = new CardTagTextView(this.mContext);
      AppMethodBeat.o(113144);
      return localCardTagTextView;
    }
    CardTagTextView localCardTagTextView = (CardTagTextView)this.oDQ.removeFirst();
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
      locala.oDR = ((LinearLayout)paramView.findViewById(2131297904));
      locala.oDS = ((TextView)paramView.findViewById(2131297834));
      locala.oDT = ((TextView)paramView.findViewById(2131297838));
      locala.oDU = ((RelativeLayout)paramView.findViewById(2131297771));
      locala.oDV = ((ImageView)paramView.findViewById(2131297828));
      locala.oDW = ((TextView)paramView.findViewById(2131297743));
      locala.oDX = ((TextView)paramView.findViewById(2131297863));
      locala.oEb = paramView.findViewById(2131297840);
      locala.oDY = ((TextView)paramView.findViewById(2131305529));
      locala.oDZ = ((TextView)paramView.findViewById(2131297732));
      locala.oEa = ((TextView)paramView.findViewById(2131297864));
      locala.oEc = ((TextView)paramView.findViewById(2131297774));
      locala.oDY.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      paramView.setTag(locala);
      localObject1 = (com.tencent.mm.plugin.card.base.b)this.oDI.getItem(paramInt);
      j = ((com.tencent.mm.plugin.card.base.b)localObject1).bTW();
      if (!com.tencent.mm.plugin.card.sharecard.a.b.As(((com.tencent.mm.plugin.card.base.b)localObject1).bTW())) {
        break label1794;
      }
      if (paramInt != 0) {
        break label830;
      }
      if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).An(j))) {
        break label1794;
      }
      i = 1;
    }
    for (;;)
    {
      label274:
      if (i != 0)
      {
        locala.oDS.setVisibility(0);
        locala.oDS.setText(((com.tencent.mm.plugin.card.base.b)localObject1).An(j));
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).bTV()))
        {
          locala.oDT.setVisibility(0);
          locala.oDT.setText(((com.tencent.mm.plugin.card.base.b)localObject1).bTV());
          label342:
          if (!paramb.bTz()) {
            break label1633;
          }
          locala.oDV.setVisibility(0);
          locala.oDW.setVisibility(0);
          locala.oDR.setVisibility(0);
          locala.oDX.setVisibility(0);
          locala.oEc.setVisibility(0);
          locala.oEb.setVisibility(0);
          locala.oDY.setVisibility(0);
          locala.oDZ.setVisibility(0);
          locala.oEa.setVisibility(8);
          locala.oDW.setText(paramb.bTN().oze);
          if (!paramb.bTw()) {
            break label1018;
          }
          if ((paramb.bTN().FRz == null) || (paramb.bTN().FRz.size() != 1)) {
            break label906;
          }
          locala.oDX.setText(((aaf)paramb.bTN().FRz.get(0)).title);
          i = this.mContext.getResources().getDimensionPixelSize(2131165979);
          n.a(locala.oDV, paramb.bTN().hzB, i, 2131233400, true);
          locala.oDW.setTextColor(this.mContext.getResources().getColor(2131100085));
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.Yv(paramb.bTS());
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1038;
          }
          locala.oDZ.setText((CharSequence)localObject1);
          label602:
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.Er(paramb.bTS());
          boolean bool = com.tencent.mm.plugin.card.sharecard.a.b.As(paramb.bTW());
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!bool)) {
            break label1052;
          }
          locala.oDY.setText(k.b(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(2131165574)));
          label667:
          i = com.tencent.mm.plugin.card.sharecard.a.b.Yw(paramb.bTS());
          if ((i <= 1) || (!bool)) {
            break label1168;
          }
          locala.oEc.setText("X".concat(String.valueOf(i)));
          locala.oEc.setVisibility(0);
        }
      }
      label514:
      label717:
      label1018:
      Object localObject2;
      for (;;)
      {
        if (((paramb.bTN().FRR != null) && (!bt.hj(paramb.bTN().FRR.HGq))) || (com.tencent.mm.plugin.card.sharecard.a.b.Yy(paramb.bTS())))
        {
          locala.oDR.setVisibility(0);
          i = 0;
          for (;;)
          {
            if (i < locala.oDR.getChildCount())
            {
              localObject1 = (CardTagTextView)locala.oDR.getChildAt(i);
              this.oDQ.add(localObject1);
              i += 1;
              continue;
              locala = (a)paramView.getTag();
              break;
              label830:
              if (j == ((com.tencent.mm.plugin.card.base.b)this.oDI.getItem(paramInt - 1)).bTW()) {
                break label1794;
              }
              i = 1;
              break label274;
              locala.oDT.setVisibility(8);
              break label342;
              locala.oDS.setVisibility(8);
              locala.oDT.setVisibility(8);
              locala.oDS.setText("");
              break label342;
              label906:
              if ((paramb.bTN().FRz == null) || (paramb.bTN().FRz.size() != 2)) {
                break label514;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((aaf)paramb.bTN().FRz.get(0)).title);
              ((StringBuilder)localObject1).append("-");
              ((StringBuilder)localObject1).append(((aaf)paramb.bTN().FRz.get(1)).title);
              locala.oDX.setText(((StringBuilder)localObject1).toString());
              break label514;
              locala.oDX.setText(paramb.bTN().title);
              break label514;
              label1038:
              locala.oDZ.setText("");
              break label602;
              label1052:
              if (!TextUtils.isEmpty(paramb.bTT()))
              {
                localObject1 = l.Zj(paramb.bTT());
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject1 = this.mContext.getResources().getString(2131756978, new Object[] { localObject1 });
                  locala.oDY.setText(k.b(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(2131165574)));
                  break label667;
                }
                locala.oDY.setText("");
                break label667;
              }
              locala.oDY.setText("");
              break label667;
              label1168:
              locala.oEc.setVisibility(8);
              break label717;
            }
          }
          locala.oDR.removeAllViews();
          if (com.tencent.mm.plugin.card.sharecard.a.b.Yy(paramb.bTS()))
          {
            localObject1 = bVT();
            ((CardTagTextView)localObject1).setPadding(this.oDM, this.oDL, this.oDM, this.oDL);
            ((CardTagTextView)localObject1).setTextColor(this.mContext.getResources().getColor(2131100798));
            ((CardTagTextView)localObject1).setText(this.mContext.getString(2131756989));
            ((CardTagTextView)localObject1).setTextSize(12.0F);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).rightMargin = this.mContext.getResources().getDimensionPixelOffset(2131165490);
            locala.oDR.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          }
          if ((paramb.bTN().FRR == null) || (bt.hj(paramb.bTN().FRR.HGq))) {
            break label1462;
          }
          localObject1 = paramb.bTN().FRR.HGq.iterator();
        }
      }
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (dlw)((Iterator)localObject1).next();
        CardTagTextView localCardTagTextView = bVT();
        localCardTagTextView.setPadding(this.oDM, this.oDL, this.oDM, this.oDL);
        localCardTagTextView.setTextColor(l.Zh(((dlw)localObject2).hAD));
        localCardTagTextView.setText(((dlw)localObject2).tag);
        localCardTagTextView.setTextSize(12.0F);
        locala.oDR.addView(localCardTagTextView);
        continue;
        locala.oDR.setVisibility(8);
      }
      label1462:
      if ((paramInt == this.oDI.getCount() - 1) && (locala.oDU != null))
      {
        localObject1 = (LinearLayout.LayoutParams)locala.oDU.getLayoutParams();
        if (((LinearLayout.LayoutParams)localObject1).bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131165490))
        {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131165490);
          locala.oDU.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      for (;;)
      {
        this.oDJ = (System.currentTimeMillis() - l + this.oDJ);
        this.oDK += 1L;
        if (!this.oDO.contains(paramb.bTR()))
        {
          this.oDO.add(paramb.bTR());
          this.oDP.add(paramb.bTS());
          this.oDN.add(Integer.valueOf(paramInt));
        }
        AppMethodBeat.o(113143);
        return paramView;
        label1633:
        locala.oDV.setVisibility(8);
        locala.oDW.setVisibility(8);
        locala.oDR.setVisibility(8);
        locala.oDX.setVisibility(8);
        locala.oEc.setVisibility(8);
        locala.oEb.setVisibility(8);
        locala.oDY.setVisibility(8);
        locala.oDZ.setVisibility(8);
        locala.oEa.setVisibility(0);
        locala.oEa.setText(this.mContext.getResources().getString(2131756947));
        break;
        if (locala.oDU != null)
        {
          localObject1 = (LinearLayout.LayoutParams)locala.oDU.getLayoutParams();
          if (((LinearLayout.LayoutParams)localObject1).bottomMargin != 0)
          {
            ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
            locala.oDU.setLayoutParams((ViewGroup.LayoutParams)localObject1);
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
    this.oDI = null;
    if (this.oDK > 0L)
    {
      ArrayList localArrayList = new ArrayList();
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(281);
      localIDKey1.SetKey(5);
      localIDKey1.SetValue(1L);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(281);
      localIDKey2.SetKey(6);
      localIDKey2.SetValue((int)(this.oDJ / this.oDK));
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      g.yhR.b(localArrayList, true);
    }
    if ((this.oDN.size() == this.oDO.size()) && (this.oDO.size() == this.oDP.size()) && (this.oDN.size() > 0))
    {
      long l = System.currentTimeMillis();
      int i = 0;
      while (i < this.oDN.size())
      {
        g.yhR.f(13220, new Object[] { this.oDP.get(i), this.oDO.get(i), this.oDN.get(i), Long.valueOf(l) });
        i += 1;
      }
    }
    this.oDN.clear();
    this.oDO.clear();
    this.oDP.clear();
    if (this.oDQ != null) {
      this.oDQ.clear();
    }
    AppMethodBeat.o(113142);
  }
  
  public final class a
  {
    public LinearLayout oDR;
    public TextView oDS;
    public TextView oDT;
    public RelativeLayout oDU;
    public ImageView oDV;
    public TextView oDW;
    public TextView oDX;
    public TextView oDY;
    public TextView oDZ;
    public TextView oEa;
    public View oEb;
    public TextView oEc;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.j
 * JD-Core Version:    0.7.0.1
 */