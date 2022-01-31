package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.b;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends BaseAdapter
{
  boolean cnz;
  Context context;
  ArrayList<r.b> kGB;
  int nAi;
  boolean nCB;
  int nCC;
  int nCD;
  int nCE;
  int nCF;
  private int nCG;
  boolean nCH;
  boolean nCI;
  private ArrayList<r.d> nCJ;
  int nor;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(112175);
    this.cnz = false;
    this.nCB = false;
    this.nAi = 0;
    this.nCC = 0;
    this.nCD = 0;
    this.nCE = 0;
    this.nCF = 0;
    this.nor = 0;
    this.nCH = false;
    this.nCI = false;
    this.context = paramContext;
    this.kGB = null;
    this.nCG = paramContext.getResources().getColor(2131690127);
    AppMethodBeat.o(112175);
  }
  
  private String Qv(String paramString)
  {
    AppMethodBeat.i(112180);
    if (this.nCJ == null) {
      this.nCJ = new ArrayList();
    }
    for (;;)
    {
      paramString = new StringBuilder(paramString);
      r.d locald = new r.d(this, (byte)0);
      for (int i = paramString.indexOf("<em>"); i >= 0; i = paramString.indexOf("<em>"))
      {
        locald.start = i;
        paramString.delete(i, i + 4);
        i = paramString.indexOf("</em>");
        if (i < 0) {
          break;
        }
        locald.end = i;
        paramString.delete(i, i + 5);
        this.nCJ.add(locald);
      }
      this.nCJ.clear();
    }
    paramString = paramString.toString();
    AppMethodBeat.o(112180);
    return paramString;
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(112181);
    if (!bo.isNullOrNil(paramString))
    {
      paramString = new SpannableString(Qv(paramString));
      Iterator localIterator = this.nCJ.iterator();
      while (localIterator.hasNext())
      {
        r.d locald = (r.d)localIterator.next();
        if (locald.start < locald.end) {
          paramString.setSpan(new ForegroundColorSpan(this.nCG), locald.start, locald.end, 33);
        }
      }
      paramTextView.setText(paramString);
      paramTextView.setVisibility(0);
      AppMethodBeat.o(112181);
      return;
    }
    paramTextView.setVisibility(8);
    AppMethodBeat.o(112181);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(112176);
    if (this.kGB == null)
    {
      AppMethodBeat.o(112176);
      return 0;
    }
    int i = this.kGB.size();
    AppMethodBeat.o(112176);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(112177);
    Object localObject = this.kGB.get(paramInt);
    AppMethodBeat.o(112177);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(112178);
    paramInt = ((r.b)getItem(paramInt)).type;
    AppMethodBeat.o(112178);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(112179);
    r.b localb = (r.b)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = new r.a((byte)0);
      paramView = this.context;
      switch (localb.type)
      {
      case 4: 
      default: 
        paramInt = 0;
        localObject2 = View.inflate(paramView, paramInt, null);
        ((r.a)localObject1).contentView = ((View)localObject2).findViewById(2131824747);
        ((r.a)localObject1).nCN = ((ImageView)((View)localObject2).findViewById(2131824748));
        ((r.a)localObject1).nCO = ((TextView)((View)localObject2).findViewById(2131824750));
        ((r.a)localObject1).nCP = ((TextView)((View)localObject2).findViewById(2131824749));
        ((r.a)localObject1).nCQ = ((TextView)((View)localObject2).findViewById(2131824751));
        ((r.a)localObject1).nCR = ((TextView)((View)localObject2).findViewById(2131824757));
        ((r.a)localObject1).nCS = ((View)localObject2).findViewById(2131824758);
        ((r.a)localObject1).nCT = ((TextView)((View)localObject2).findViewById(2131824759));
        ((r.a)localObject1).nCU = ((TextView)((View)localObject2).findViewById(2131824760));
        ((View)localObject2).setTag(localObject1);
        paramViewGroup = (ViewGroup)localObject1;
        paramView = (View)localObject2;
        if (((r.a)localObject1).nCO != null)
        {
          paramViewGroup = (ViewGroup)localObject1;
          paramView = (View)localObject2;
          if (((r.a)localObject1).nCQ != null)
          {
            paramView = ((r.a)localObject1).nCO;
            paramViewGroup = ((r.a)localObject1).nCQ;
            paramView.getViewTreeObserver().addOnGlobalLayoutListener(new r.1(this, paramView, paramViewGroup));
            paramView = (View)localObject2;
            paramViewGroup = (ViewGroup)localObject1;
          }
        }
        label290:
        switch (localb.type)
        {
        case 4: 
        default: 
          label336:
          switch (localb.type)
          {
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112179);
      return paramView;
      paramInt = 2130969812;
      break;
      paramInt = 2130969819;
      break;
      paramInt = 2130969818;
      break;
      paramInt = 2130969814;
      break;
      paramInt = 2130969815;
      break;
      paramInt = 2130969817;
      break;
      paramViewGroup = (r.a)paramView.getTag();
      break label290;
      if (!bo.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).eNK = false;
        ((e.a.a)localObject1).eNM = false;
        e.bHE().a(paramViewGroup.nCN, localb.iconUrl, ((e.a.a)localObject1).bHF());
      }
      a(paramViewGroup.nCO, localb.name);
      a(paramViewGroup.nCP, localb.nCV);
      a(paramViewGroup.nCQ, localb.hKa);
      break label336;
      if (!bo.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).eNK = false;
        ((e.a.a)localObject1).eNM = false;
        ((e.a.a)localObject1).nEu = true;
        e.bHE().a(paramViewGroup.nCN, localb.iconUrl, ((e.a.a)localObject1).bHF());
        paramViewGroup.nCN.setVisibility(0);
        label600:
        a(paramViewGroup.nCO, localb.name);
        a(paramViewGroup.nCQ, localb.hKa);
        if (bo.isNullOrNil(localb.fnp)) {
          break label720;
        }
        paramViewGroup.nCT.setText(j.b(this.context, localb.fnp));
        paramViewGroup.nCT.setVisibility(0);
      }
      for (;;)
      {
        if (localb.createTime <= 0L) {
          break label732;
        }
        paramViewGroup.nCU.setText(b.h(this.context, localb.createTime * 1000L));
        paramViewGroup.nCU.setVisibility(0);
        break;
        paramViewGroup.nCN.setVisibility(8);
        break label600;
        label720:
        paramViewGroup.nCT.setVisibility(8);
      }
      label732:
      paramViewGroup.nCU.setVisibility(8);
      break label336;
      if (!bo.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).eNK = false;
        ((e.a.a)localObject1).eNM = false;
        e.bHE().a(paramViewGroup.nCN, localb.iconUrl, ((e.a.a)localObject1).bHF());
      }
      a(paramViewGroup.nCO, localb.name);
      a(paramViewGroup.nCP, localb.nCV);
      a(paramViewGroup.nCQ, localb.hKa);
      localObject1 = paramViewGroup.nCR;
      localObject2 = localb.nCY;
      StringBuilder localStringBuilder = new StringBuilder();
      if (!bo.es((List)localObject2))
      {
        int i = ((LinkedList)localObject2).size();
        paramInt = 0;
        while (paramInt < i - 1)
        {
          localStringBuilder.append((String)((LinkedList)localObject2).get(paramInt) + "\n");
          paramInt += 1;
        }
        localStringBuilder.append((String)((LinkedList)localObject2).get(i - 1));
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(localStringBuilder.toString());
        break label336;
      }
      ((TextView)localObject1).setVisibility(8);
      break label336;
      paramViewGroup.nCQ.setText(localb.name);
      break label336;
      paramViewGroup.nCN.setImageResource(2131231954);
      paramViewGroup.nCO.setText(localb.name);
      break label336;
      if (localb.nDc) {
        paramViewGroup.contentView.setBackgroundResource(2130838447);
      }
      for (;;)
      {
        paramInt = this.context.getResources().getDimensionPixelSize(2131427839);
        paramViewGroup.contentView.setPadding(0, paramInt, 0, paramInt);
        break;
        paramViewGroup.contentView.setBackgroundResource(2130838445);
      }
      if (localb.nDb) {
        paramViewGroup.nCS.setVisibility(8);
      } else {
        paramViewGroup.nCS.setVisibility(0);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 7;
  }
  
  public final void reset()
  {
    this.nor = 0;
    this.nCH = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.r
 * JD-Core Version:    0.7.0.1
 */