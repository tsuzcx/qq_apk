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
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.protocal.protobuf.cpd;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  implements c
{
  private BaseAdapter krV;
  private long krW;
  private long krX;
  private int krY;
  private int krZ;
  private ArrayList<Integer> ksa;
  private ArrayList<String> ksb;
  private ArrayList<String> ksc;
  protected LinkedList<CardTagTextView> ksd;
  private Context mContext;
  
  public j(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    AppMethodBeat.i(88207);
    this.krW = 0L;
    this.krX = 0L;
    this.ksa = new ArrayList();
    this.ksb = new ArrayList();
    this.ksc = new ArrayList();
    this.ksd = new LinkedList();
    this.mContext = paramContext;
    this.krV = paramBaseAdapter;
    this.krY = this.mContext.getResources().getDimensionPixelSize(2131427811);
    this.krZ = this.mContext.getResources().getDimensionPixelSize(2131427792);
    this.ksa.clear();
    this.ksb.clear();
    this.ksc.clear();
    AppMethodBeat.o(88207);
  }
  
  private CardTagTextView bdd()
  {
    AppMethodBeat.i(88210);
    if (this.ksd.size() == 0)
    {
      localCardTagTextView = new CardTagTextView(this.mContext);
      AppMethodBeat.o(88210);
      return localCardTagTextView;
    }
    CardTagTextView localCardTagTextView = (CardTagTextView)this.ksd.removeFirst();
    AppMethodBeat.o(88210);
    return localCardTagTextView;
  }
  
  public final void V(View paramView, int paramInt) {}
  
  public final void W(View paramView, int paramInt) {}
  
  public final View a(int paramInt, View paramView, com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(88209);
    long l = System.currentTimeMillis();
    j.a locala;
    Object localObject1;
    int j;
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2130968990, null);
      locala = new j.a(this);
      locala.kse = ((LinearLayout)paramView.findViewById(2131822356));
      locala.ksf = ((TextView)paramView.findViewById(2131822354));
      locala.ksg = ((TextView)paramView.findViewById(2131822355));
      locala.ksh = ((RelativeLayout)paramView.findViewById(2131821968));
      locala.ksi = ((ImageView)paramView.findViewById(2131821970));
      locala.ksj = ((TextView)paramView.findViewById(2131821971));
      locala.ksk = ((TextView)paramView.findViewById(2131821973));
      locala.kso = paramView.findViewById(2131822358);
      locala.ksl = ((TextView)paramView.findViewById(2131821949));
      locala.ksm = ((TextView)paramView.findViewById(2131822359));
      locala.ksn = ((TextView)paramView.findViewById(2131821976));
      locala.ksp = ((TextView)paramView.findViewById(2131822357));
      locala.ksl.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      paramView.setTag(locala);
      localObject1 = (com.tencent.mm.plugin.card.base.b)this.krV.getItem(paramInt);
      j = ((com.tencent.mm.plugin.card.base.b)localObject1).bbm();
      if (!com.tencent.mm.plugin.card.sharecard.a.b.ta(((com.tencent.mm.plugin.card.base.b)localObject1).bbm())) {
        break label1794;
      }
      if (paramInt != 0) {
        break label830;
      }
      if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).sV(j))) {
        break label1794;
      }
      i = 1;
    }
    for (;;)
    {
      label274:
      if (i != 0)
      {
        locala.ksf.setVisibility(0);
        locala.ksf.setText(((com.tencent.mm.plugin.card.base.b)localObject1).sV(j));
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject1).bbl()))
        {
          locala.ksg.setVisibility(0);
          locala.ksg.setText(((com.tencent.mm.plugin.card.base.b)localObject1).bbl());
          label342:
          if (!paramb.baQ()) {
            break label1633;
          }
          locala.ksi.setVisibility(0);
          locala.ksj.setVisibility(0);
          locala.kse.setVisibility(0);
          locala.ksk.setVisibility(0);
          locala.ksp.setVisibility(0);
          locala.kso.setVisibility(0);
          locala.ksl.setVisibility(0);
          locala.ksm.setVisibility(0);
          locala.ksn.setVisibility(8);
          locala.ksj.setText(paramb.bbd().knw);
          if (!paramb.baN()) {
            break label1018;
          }
          if ((paramb.bbd().wFZ == null) || (paramb.bbd().wFZ.size() != 1)) {
            break label906;
          }
          locala.ksk.setText(((uo)paramb.bbd().wFZ.get(0)).title);
          i = this.mContext.getResources().getDimensionPixelSize(2131428180);
          m.a(locala.ksi, paramb.bbd().kmm, i, 2130839758, true);
          locala.ksj.setTextColor(this.mContext.getResources().getColor(2131689825));
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.HQ(paramb.bbi());
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1038;
          }
          locala.ksm.setText((CharSequence)localObject1);
          label602:
          localObject1 = com.tencent.mm.plugin.card.sharecard.a.b.so(paramb.bbi());
          boolean bool = com.tencent.mm.plugin.card.sharecard.a.b.ta(paramb.bbm());
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!bool)) {
            break label1052;
          }
          locala.ksl.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(2131427860)));
          label667:
          i = com.tencent.mm.plugin.card.sharecard.a.b.HR(paramb.bbi());
          if ((i <= 1) || (!bool)) {
            break label1168;
          }
          locala.ksp.setText("X".concat(String.valueOf(i)));
          locala.ksp.setVisibility(0);
        }
      }
      label514:
      label717:
      label1018:
      Object localObject2;
      for (;;)
      {
        if (((paramb.bbd().wGs != null) && (!bo.es(paramb.bbd().wGs.xXT))) || (com.tencent.mm.plugin.card.sharecard.a.b.HT(paramb.bbi())))
        {
          locala.kse.setVisibility(0);
          i = 0;
          for (;;)
          {
            if (i < locala.kse.getChildCount())
            {
              localObject1 = (CardTagTextView)locala.kse.getChildAt(i);
              this.ksd.add(localObject1);
              i += 1;
              continue;
              locala = (j.a)paramView.getTag();
              break;
              label830:
              if (j == ((com.tencent.mm.plugin.card.base.b)this.krV.getItem(paramInt - 1)).bbm()) {
                break label1794;
              }
              i = 1;
              break label274;
              locala.ksg.setVisibility(8);
              break label342;
              locala.ksf.setVisibility(8);
              locala.ksg.setVisibility(8);
              locala.ksf.setText("");
              break label342;
              label906:
              if ((paramb.bbd().wFZ == null) || (paramb.bbd().wFZ.size() != 2)) {
                break label514;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((uo)paramb.bbd().wFZ.get(0)).title);
              ((StringBuilder)localObject1).append("-");
              ((StringBuilder)localObject1).append(((uo)paramb.bbd().wFZ.get(1)).title);
              locala.ksk.setText(((StringBuilder)localObject1).toString());
              break label514;
              locala.ksk.setText(paramb.bbd().title);
              break label514;
              label1038:
              locala.ksm.setText("");
              break label602;
              label1052:
              if (!TextUtils.isEmpty(paramb.bbj()))
              {
                localObject1 = l.ID(paramb.bbj());
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject1 = this.mContext.getResources().getString(2131298036, new Object[] { localObject1 });
                  locala.ksl.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, (CharSequence)localObject1, this.mContext.getResources().getDimensionPixelOffset(2131427860)));
                  break label667;
                }
                locala.ksl.setText("");
                break label667;
              }
              locala.ksl.setText("");
              break label667;
              label1168:
              locala.ksp.setVisibility(8);
              break label717;
            }
          }
          locala.kse.removeAllViews();
          if (com.tencent.mm.plugin.card.sharecard.a.b.HT(paramb.bbi()))
          {
            localObject1 = bdd();
            ((CardTagTextView)localObject1).setPadding(this.krZ, this.krY, this.krZ, this.krY);
            ((CardTagTextView)localObject1).setTextColor(this.mContext.getResources().getColor(2131690391));
            ((CardTagTextView)localObject1).setText(this.mContext.getString(2131298047));
            ((CardTagTextView)localObject1).setTextSize(12.0F);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).rightMargin = this.mContext.getResources().getDimensionPixelOffset(2131427782);
            locala.kse.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          }
          if ((paramb.bbd().wGs == null) || (bo.es(paramb.bbd().wGs.xXT))) {
            break label1462;
          }
          localObject1 = paramb.bbd().wGs.xXT.iterator();
        }
      }
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cjg)((Iterator)localObject1).next();
        CardTagTextView localCardTagTextView = bdd();
        localCardTagTextView.setPadding(this.krZ, this.krY, this.krZ, this.krY);
        localCardTagTextView.setTextColor(l.IB(((cjg)localObject2).color));
        localCardTagTextView.setText(((cjg)localObject2).tag);
        localCardTagTextView.setTextSize(12.0F);
        locala.kse.addView(localCardTagTextView);
        continue;
        locala.kse.setVisibility(8);
      }
      label1462:
      if ((paramInt == this.krV.getCount() - 1) && (locala.ksh != null))
      {
        localObject1 = (LinearLayout.LayoutParams)locala.ksh.getLayoutParams();
        if (((LinearLayout.LayoutParams)localObject1).bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131427782))
        {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131427782);
          locala.ksh.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      for (;;)
      {
        this.krW = (System.currentTimeMillis() - l + this.krW);
        this.krX += 1L;
        if (!this.ksb.contains(paramb.bbh()))
        {
          this.ksb.add(paramb.bbh());
          this.ksc.add(paramb.bbi());
          this.ksa.add(Integer.valueOf(paramInt));
        }
        AppMethodBeat.o(88209);
        return paramView;
        label1633:
        locala.ksi.setVisibility(8);
        locala.ksj.setVisibility(8);
        locala.kse.setVisibility(8);
        locala.ksk.setVisibility(8);
        locala.ksp.setVisibility(8);
        locala.kso.setVisibility(8);
        locala.ksl.setVisibility(8);
        locala.ksm.setVisibility(8);
        locala.ksn.setVisibility(0);
        locala.ksn.setText(this.mContext.getResources().getString(2131298005));
        break;
        if (locala.ksh != null)
        {
          localObject1 = (LinearLayout.LayoutParams)locala.ksh.getLayoutParams();
          if (((LinearLayout.LayoutParams)localObject1).bottomMargin != 0)
          {
            ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
            locala.ksh.setLayoutParams((ViewGroup.LayoutParams)localObject1);
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
    AppMethodBeat.i(88208);
    this.mContext = null;
    this.krV = null;
    if (this.krX > 0L)
    {
      ArrayList localArrayList = new ArrayList();
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(281);
      localIDKey1.SetKey(5);
      localIDKey1.SetValue(1L);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(281);
      localIDKey2.SetKey(6);
      localIDKey2.SetValue((int)(this.krW / this.krX));
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      h.qsU.b(localArrayList, true);
    }
    if ((this.ksa.size() == this.ksb.size()) && (this.ksb.size() == this.ksc.size()) && (this.ksa.size() > 0))
    {
      long l = System.currentTimeMillis();
      int i = 0;
      while (i < this.ksa.size())
      {
        h.qsU.e(13220, new Object[] { this.ksc.get(i), this.ksb.get(i), this.ksa.get(i), Long.valueOf(l) });
        i += 1;
      }
    }
    this.ksa.clear();
    this.ksb.clear();
    this.ksc.clear();
    if (this.ksd != null) {
      this.ksd.clear();
    }
    AppMethodBeat.o(88208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.j
 * JD-Core Version:    0.7.0.1
 */