package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.y;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class IPCallMsgUI$a
  extends r<g>
{
  int dsw = this.iwi;
  protected MMSlideDelView.g hZd;
  protected MMSlideDelView.c hZe;
  protected MMSlideDelView.d hZg = new MMSlideDelView.d()
  {
    public final void a(MMSlideDelView paramAnonymousMMSlideDelView, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
      {
        lwK.add(paramAnonymousMMSlideDelView);
        return;
      }
      lwK.remove(paramAnonymousMMSlideDelView);
    }
    
    public final boolean bda()
    {
      return lwK.size() > 0;
    }
    
    public final void bdb()
    {
      Iterator localIterator = lwK.iterator();
      while (localIterator.hasNext())
      {
        MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
        if (localMMSlideDelView != null) {
          localMMSlideDelView.cAY();
        }
      }
      lwK.clear();
    }
    
    public final void bdc()
    {
      Iterator localIterator = lwK.iterator();
      while (localIterator.hasNext())
      {
        MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
        if (localMMSlideDelView != null) {
          localMMSlideDelView.cAX();
        }
      }
      lwK.clear();
    }
  };
  int iwi = 10;
  private Set<MMSlideDelView> lwK = new HashSet();
  
  public IPCallMsgUI$a(IPCallMsgUI paramIPCallMsgUI, Context paramContext, g paramg)
  {
    super(paramContext, paramg);
  }
  
  public final void a(String paramString, l paraml)
  {
    try
    {
      super.a(paramString, paraml);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean aCc()
  {
    return this.iwi >= this.dsw;
  }
  
  public final long getItemId(int paramInt)
  {
    return ((g)getItem(paramInt)).ujK;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    g localg = (g)getItem(paramInt);
    View localView;
    long l1;
    Object localObject1;
    Object localObject2;
    if ((paramView == null) || (!(paramView.getTag() instanceof IPCallMsgUI.a.a)))
    {
      localView = y.gt(this.context).inflate(R.i.ipcall_msg_item, null);
      paramViewGroup = new IPCallMsgUI.a.a(this);
      paramViewGroup.eXr = ((TextView)localView.findViewById(R.h.titleTv));
      paramViewGroup.fuN = ((TextView)localView.findViewById(R.h.contentTv));
      paramViewGroup.igx = ((TextView)localView.findViewById(R.h.timeTv));
      localView.setTag(paramViewGroup);
      paramViewGroup.eXr.setText(localg.field_title);
      paramViewGroup.fuN.setText(localg.field_content);
      TextView localTextView = paramViewGroup.igx;
      paramView = this.lwI.mController.uMN;
      l1 = localg.field_pushTime * 1000L;
      localObject1 = new GregorianCalendar();
      localObject2 = new GregorianCalendar(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2), ((GregorianCalendar)localObject1).get(5));
      localObject1 = (String)DateFormat.format(paramView.getString(R.l.fmt_date), l1);
      if (((String)localObject1).indexOf("-") <= 0) {
        break label368;
      }
      localObject2 = localObject1.split("-")[0];
      localObject1 = localObject1.split("-")[1];
      localObject2 = c.aA(paramView, (String)localObject2);
      localObject1 = (String)localObject1 + " " + (String)localObject2 + " ";
      paramView = (String)localObject1 + " " + (String)c.h(paramView, l1);
      label310:
      localTextView.setText(paramView);
      if (localg.field_isRead != 1) {
        break label527;
      }
    }
    label527:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label532;
      }
      paramViewGroup.eXr.setTextColor(this.lwI.getResources().getColor(R.e.ipcall_msg_ui_has_read_color));
      return localView;
      paramViewGroup = (IPCallMsgUI.a.a)paramView.getTag();
      localView = paramView;
      break;
      label368:
      long l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis();
      if ((l2 > 0L) && (l2 <= 86400000L))
      {
        paramView = (String)c.h(paramView, l1);
        break label310;
      }
      l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L;
      if ((l2 > 0L) && (l2 <= 86400000L))
      {
        paramView = paramView.getString(R.l.fmt_pre_yesterday) + " " + (String)c.h(paramView, l1);
        break label310;
      }
      paramView = (String)localObject1 + " " + (String)c.h(paramView, l1);
      break label310;
    }
    label532:
    paramViewGroup.eXr.setTextColor(this.lwI.getResources().getColor(R.e.ipcall_msg_ui_not_read_color));
    return localView;
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.hZe = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.hZd = paramg;
  }
  
  public final void yc()
  {
    this.dsw = i.bcp().getCount();
    h localh = i.bcp();
    int i = this.iwi;
    setCursor(localh.dXw.query("IPCallMsg", h.lsO, null, null, null, null, "pushTime desc limit " + i));
    notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    bcS();
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.a
 * JD-Core Version:    0.7.0.1
 */