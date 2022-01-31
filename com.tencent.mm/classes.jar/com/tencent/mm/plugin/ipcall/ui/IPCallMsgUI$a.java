package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.w;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class IPCallMsgUI$a
  extends p<g>
{
  int eke;
  protected MMSlideDelView.g jSb;
  protected MMSlideDelView.c jSc;
  protected MMSlideDelView.d jSe;
  int kxm;
  private Set<MMSlideDelView> nTX;
  
  public IPCallMsgUI$a(IPCallMsgUI paramIPCallMsgUI, Context paramContext, g paramg)
  {
    super(paramContext, paramg);
    AppMethodBeat.i(22198);
    this.nTX = new HashSet();
    this.jSe = new MMSlideDelView.d()
    {
      public final void a(MMSlideDelView paramAnonymousMMSlideDelView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(22194);
        if (paramAnonymousBoolean)
        {
          nTX.add(paramAnonymousMMSlideDelView);
          AppMethodBeat.o(22194);
          return;
        }
        nTX.remove(paramAnonymousMMSlideDelView);
        AppMethodBeat.o(22194);
      }
      
      public final boolean bKj()
      {
        AppMethodBeat.i(22195);
        if (nTX.size() > 0)
        {
          AppMethodBeat.o(22195);
          return true;
        }
        AppMethodBeat.o(22195);
        return false;
      }
      
      public final void bKk()
      {
        AppMethodBeat.i(22196);
        Iterator localIterator = nTX.iterator();
        while (localIterator.hasNext())
        {
          MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
          if (localMMSlideDelView != null) {
            localMMSlideDelView.dEk();
          }
        }
        nTX.clear();
        AppMethodBeat.o(22196);
      }
      
      public final void bKl()
      {
        AppMethodBeat.i(22197);
        Iterator localIterator = nTX.iterator();
        while (localIterator.hasNext())
        {
          MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
          if (localMMSlideDelView != null) {
            localMMSlideDelView.dEj();
          }
        }
        nTX.clear();
        AppMethodBeat.o(22197);
      }
    };
    this.kxm = 10;
    this.eke = this.kxm;
    AppMethodBeat.o(22198);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(22202);
    this.eke = i.bJw().getCount();
    setCursor(i.bJw().xL(this.kxm));
    notifyDataSetChanged();
    AppMethodBeat.o(22202);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(22200);
    bKb();
    Ku();
    AppMethodBeat.o(22200);
  }
  
  public final void a(String paramString, m paramm)
  {
    try
    {
      AppMethodBeat.i(22201);
      super.a(paramString, paramm);
      AppMethodBeat.o(22201);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean bem()
  {
    return this.kxm >= this.eke;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(22199);
    long l = ((g)getItem(paramInt)).systemRowid;
    AppMethodBeat.o(22199);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22203);
    g localg = (g)getItem(paramInt);
    View localView;
    long l1;
    Object localObject1;
    Object localObject2;
    if ((paramView == null) || (!(paramView.getTag() instanceof IPCallMsgUI.a.a)))
    {
      localView = w.hM(this.context).inflate(2130969938, null);
      paramViewGroup = new IPCallMsgUI.a.a(this);
      paramViewGroup.titleTv = ((TextView)localView.findViewById(2131821335));
      paramViewGroup.gMp = ((TextView)localView.findViewById(2131825295));
      paramViewGroup.timeTv = ((TextView)localView.findViewById(2131825296));
      localView.setTag(paramViewGroup);
      paramViewGroup.titleTv.setText(localg.field_title);
      paramViewGroup.gMp.setText(localg.field_content);
      TextView localTextView = paramViewGroup.timeTv;
      paramView = this.nTV.getContext();
      l1 = localg.field_pushTime * 1000L;
      localObject1 = new GregorianCalendar();
      localObject2 = new GregorianCalendar(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2), ((GregorianCalendar)localObject1).get(5));
      localObject1 = (String)DateFormat.format(paramView.getString(2131300031), l1);
      if (((String)localObject1).indexOf("-") <= 0) {
        break label372;
      }
      localObject2 = localObject1.split("-")[0];
      localObject1 = localObject1.split("-")[1];
      localObject2 = c.aJ(paramView, (String)localObject2);
      localObject1 = (String)localObject1 + " " + (String)localObject2 + " ";
      paramView = (String)localObject1 + " " + (String)c.i(paramView, l1);
      label308:
      localTextView.setText(paramView);
      if (localg.field_isRead != 1) {
        break label531;
      }
      paramInt = 1;
      label325:
      if (paramInt == 0) {
        break label536;
      }
      paramViewGroup.titleTv.setTextColor(this.nTV.getResources().getColor(2131690189));
    }
    for (;;)
    {
      AppMethodBeat.o(22203);
      return localView;
      paramViewGroup = (IPCallMsgUI.a.a)paramView.getTag();
      localView = paramView;
      break;
      label372:
      long l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis();
      if ((l2 > 0L) && (l2 <= 86400000L))
      {
        paramView = (String)c.i(paramView, l1);
        break label308;
      }
      l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L;
      if ((l2 > 0L) && (l2 <= 86400000L))
      {
        paramView = paramView.getString(2131300084) + " " + (String)c.i(paramView, l1);
        break label308;
      }
      paramView = (String)localObject1 + " " + (String)c.i(paramView, l1);
      break label308;
      label531:
      paramInt = 0;
      break label325;
      label536:
      paramViewGroup.titleTv.setTextColor(this.nTV.getResources().getColor(2131690190));
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.jSc = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.jSb = paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.a
 * JD-Core Version:    0.7.0.1
 */