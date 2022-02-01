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
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.eqk;
import com.tencent.mm.protocal.protobuf.eyt;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  implements c
{
  private Context mContext;
  private int shP;
  private BaseAdapter ttU;
  private long ttV;
  private long ttW;
  private int ttX;
  private ArrayList<Integer> ttY;
  private ArrayList<String> ttZ;
  private ArrayList<String> tua;
  protected LinkedList<CardTagTextView> tub;
  
  public j(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(113141);
    this.ttV = 0L;
    this.ttW = 0L;
    this.ttY = new ArrayList();
    this.ttZ = new ArrayList();
    this.tua = new ArrayList();
    this.tub = new LinkedList();
    this.mContext = paramContext;
    this.ttU = paramBaseAdapter;
    this.shP = this.mContext.getResources().getDimensionPixelSize(a.b.OneDPPadding);
    this.ttX = this.mContext.getResources().getDimensionPixelSize(a.b.MiddlePadding);
    this.ttY.clear();
    this.ttZ.clear();
    this.tua.clear();
    AppMethodBeat.o(113141);
  }
  
  private CardTagTextView cIA()
  {
    AppMethodBeat.i(113144);
    if (this.tub.size() == 0)
    {
      localCardTagTextView = new CardTagTextView(this.mContext);
      AppMethodBeat.o(113144);
      return localCardTagTextView;
    }
    CardTagTextView localCardTagTextView = (CardTagTextView)this.tub.removeFirst();
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
      paramView = View.inflate(this.mContext, a.e.tje, null);
      locala = new a();
      locala.tuc = ((LinearLayout)paramView.findViewById(a.d.tdB));
      locala.tud = ((TextView)paramView.findViewById(a.d.tcA));
      locala.tue = ((TextView)paramView.findViewById(a.d.tcB));
      locala.tuf = ((RelativeLayout)paramView.findViewById(a.d.tbI));
      locala.tug = ((ImageView)paramView.findViewById(a.d.tcw));
      locala.tuh = ((TextView)paramView.findViewById(a.d.duY));
      locala.tui = ((TextView)paramView.findViewById(a.d.tcV));
      locala.tum = paramView.findViewById(a.d.tcD);
      locala.tuj = ((TextView)paramView.findViewById(a.d.subtitle));
      locala.tuk = ((TextView)paramView.findViewById(a.d.tbg));
      locala.tul = ((TextView)paramView.findViewById(a.d.tcW));
      locala.tun = ((TextView)paramView.findViewById(a.d.tbK));
      locala.tuj.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      paramView.setTag(locala);
      localObject1 = (com.tencent.mm.plugin.card.base.b)this.ttU.getItem(paramInt);
      j = ((com.tencent.mm.plugin.card.base.b)localObject1).cGB();
      if (!com.tencent.mm.plugin.card.sharecard.a.b.HK(((com.tencent.mm.plugin.card.base.b)localObject1).cGB())) {
        break label1807;
      }
      if (paramInt != 0) {
        break label843;
      }
      if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).HF(j))) {
        break label1807;
      }
      i = 1;
    }
    for (;;)
    {
      label287:
      if (i != 0)
      {
        locala.tud.setVisibility(0);
        locala.tud.setText(((com.tencent.mm.plugin.card.base.b)localObject1).HF(j));
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).cGA()))
        {
          locala.tue.setVisibility(0);
          locala.tue.setText(((com.tencent.mm.plugin.card.base.b)localObject1).cGA());
          label355:
          if (!paramb.cGd()) {
            break label1646;
          }
          locala.tug.setVisibility(0);
          locala.tuh.setVisibility(0);
          locala.tuc.setVisibility(0);
          locala.tui.setVisibility(0);
          locala.tun.setVisibility(0);
          locala.tum.setVisibility(0);
          locala.tuj.setVisibility(0);
          locala.tuk.setVisibility(0);
          locala.tul.setVisibility(8);
          locala.tuh.setText(paramb.cGs().jEi);
          if (!paramb.cGa()) {
            break label1031;
          }
          if ((paramb.cGs().SfP == null) || (paramb.cGs().SfP.size() != 1)) {
            break label919;
          }
          locala.tui.setText(((acg)paramb.cGs().SfP.get(0)).title);
          i = this.mContext.getResources().getDimensionPixelSize(a.b.sZN);
          n.a(locala.tug, paramb.cGs().llI, i, a.c.my_card_package_defaultlogo, true);
          locala.tuh.setTextColor(this.mContext.getResources().getColor(a.a.sZt));
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.are(paramb.cGx());
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1051;
          }
          locala.tuk.setText((CharSequence)localObject1);
          label615:
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.Vd(paramb.cGx());
          boolean bool = com.tencent.mm.plugin.card.sharecard.a.b.HK(paramb.cGB());
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!bool)) {
            break label1065;
          }
          locala.tuj.setText(com.tencent.mm.pluginsdk.ui.span.l.d(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(a.b.SmallerTextSize)));
          label680:
          i = com.tencent.mm.plugin.card.sharecard.a.b.arf(paramb.cGx());
          if ((i <= 1) || (!bool)) {
            break label1181;
          }
          locala.tun.setText("X".concat(String.valueOf(i)));
          locala.tun.setVisibility(0);
        }
      }
      label527:
      label730:
      Object localObject2;
      for (;;)
      {
        if (((paramb.cGs().Sgh != null) && (!Util.isNullOrNil(paramb.cGs().Sgh.UyW))) || (com.tencent.mm.plugin.card.sharecard.a.b.arh(paramb.cGx())))
        {
          locala.tuc.setVisibility(0);
          i = 0;
          for (;;)
          {
            if (i < locala.tuc.getChildCount())
            {
              localObject1 = (CardTagTextView)locala.tuc.getChildAt(i);
              this.tub.add(localObject1);
              i += 1;
              continue;
              locala = (a)paramView.getTag();
              break;
              label843:
              if (j == ((com.tencent.mm.plugin.card.base.b)this.ttU.getItem(paramInt - 1)).cGB()) {
                break label1807;
              }
              i = 1;
              break label287;
              locala.tue.setVisibility(8);
              break label355;
              locala.tud.setVisibility(8);
              locala.tue.setVisibility(8);
              locala.tud.setText("");
              break label355;
              label919:
              if ((paramb.cGs().SfP == null) || (paramb.cGs().SfP.size() != 2)) {
                break label527;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((acg)paramb.cGs().SfP.get(0)).title);
              ((StringBuilder)localObject1).append("-");
              ((StringBuilder)localObject1).append(((acg)paramb.cGs().SfP.get(1)).title);
              locala.tui.setText(((StringBuilder)localObject1).toString());
              break label527;
              label1031:
              locala.tui.setText(paramb.cGs().title);
              break label527;
              label1051:
              locala.tuk.setText("");
              break label615;
              label1065:
              if (!TextUtils.isEmpty(paramb.cGy()))
              {
                localObject1 = com.tencent.mm.plugin.card.d.l.arT(paramb.cGy());
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject1 = this.mContext.getResources().getString(a.g.tlz, new Object[] { localObject1 });
                  locala.tuj.setText(com.tencent.mm.pluginsdk.ui.span.l.d(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(a.b.SmallerTextSize)));
                  break label680;
                }
                locala.tuj.setText("");
                break label680;
              }
              locala.tuj.setText("");
              break label680;
              label1181:
              locala.tun.setVisibility(8);
              break label730;
            }
          }
          locala.tuc.removeAllViews();
          if (com.tencent.mm.plugin.card.sharecard.a.b.arh(paramb.cGx()))
          {
            localObject1 = cIA();
            ((CardTagTextView)localObject1).setPadding(this.ttX, this.shP, this.ttX, this.shP);
            ((CardTagTextView)localObject1).setTextColor(this.mContext.getResources().getColor(a.a.red));
            ((CardTagTextView)localObject1).setText(this.mContext.getString(a.g.tlH));
            ((CardTagTextView)localObject1).setTextSize(12.0F);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).rightMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding);
            locala.tuc.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          }
          if ((paramb.cGs().Sgh == null) || (Util.isNullOrNil(paramb.cGs().Sgh.UyW))) {
            break label1475;
          }
          localObject1 = paramb.cGs().Sgh.UyW.iterator();
        }
      }
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (eqk)((Iterator)localObject1).next();
        CardTagTextView localCardTagTextView = cIA();
        localCardTagTextView.setPadding(this.ttX, this.shP, this.ttX, this.shP);
        localCardTagTextView.setTextColor(com.tencent.mm.plugin.card.d.l.arR(((eqk)localObject2).lmL));
        localCardTagTextView.setText(((eqk)localObject2).tag);
        localCardTagTextView.setTextSize(12.0F);
        locala.tuc.addView(localCardTagTextView);
        continue;
        locala.tuc.setVisibility(8);
      }
      label1475:
      if ((paramInt == this.ttU.getCount() - 1) && (locala.tuf != null))
      {
        localObject1 = (LinearLayout.LayoutParams)locala.tuf.getLayoutParams();
        if (((LinearLayout.LayoutParams)localObject1).bottomMargin != this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding))
        {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelOffset(a.b.LittlePadding);
          locala.tuf.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      for (;;)
      {
        this.ttV = (System.currentTimeMillis() - l + this.ttV);
        this.ttW += 1L;
        if (!this.ttZ.contains(paramb.cGw()))
        {
          this.ttZ.add(paramb.cGw());
          this.tua.add(paramb.cGx());
          this.ttY.add(Integer.valueOf(paramInt));
        }
        AppMethodBeat.o(113143);
        return paramView;
        label1646:
        locala.tug.setVisibility(8);
        locala.tuh.setVisibility(8);
        locala.tuc.setVisibility(8);
        locala.tui.setVisibility(8);
        locala.tun.setVisibility(8);
        locala.tum.setVisibility(8);
        locala.tuj.setVisibility(8);
        locala.tuk.setVisibility(8);
        locala.tul.setVisibility(0);
        locala.tul.setText(this.mContext.getResources().getString(a.g.card_not_support_card_type));
        break;
        if (locala.tuf != null)
        {
          localObject1 = (LinearLayout.LayoutParams)locala.tuf.getLayoutParams();
          if (((LinearLayout.LayoutParams)localObject1).bottomMargin != 0)
          {
            ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
            locala.tuf.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
      label1807:
      i = 0;
    }
  }
  
  public final void a(View paramView, int paramInt, View.OnClickListener paramOnClickListener) {}
  
  public final void aa(View paramView, int paramInt) {}
  
  public final void ab(View paramView, int paramInt) {}
  
  public final void release()
  {
    AppMethodBeat.i(113142);
    this.mContext = null;
    this.ttU = null;
    if (this.ttW > 0L)
    {
      ArrayList localArrayList = new ArrayList();
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(281);
      localIDKey1.SetKey(5);
      localIDKey1.SetValue(1L);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(281);
      localIDKey2.SetKey(6);
      localIDKey2.SetValue((int)(this.ttV / this.ttW));
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      h.IzE.b(localArrayList, true);
    }
    if ((this.ttY.size() == this.ttZ.size()) && (this.ttZ.size() == this.tua.size()) && (this.ttY.size() > 0))
    {
      long l = System.currentTimeMillis();
      int i = 0;
      while (i < this.ttY.size())
      {
        h.IzE.a(13220, new Object[] { this.tua.get(i), this.ttZ.get(i), this.ttY.get(i), Long.valueOf(l) });
        i += 1;
      }
    }
    this.ttY.clear();
    this.ttZ.clear();
    this.tua.clear();
    if (this.tub != null) {
      this.tub.clear();
    }
    AppMethodBeat.o(113142);
  }
  
  public final class a
  {
    public LinearLayout tuc;
    public TextView tud;
    public TextView tue;
    public RelativeLayout tuf;
    public ImageView tug;
    public TextView tuh;
    public TextView tui;
    public TextView tuj;
    public TextView tuk;
    public TextView tul;
    public View tum;
    public TextView tun;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.j
 * JD-Core Version:    0.7.0.1
 */