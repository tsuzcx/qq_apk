package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

@Deprecated
final class d
  extends r<com.tencent.mm.plugin.account.friend.a.g>
{
  private String jeI;
  a jmD;
  private int[] pq;
  
  public d(Context paramContext, r.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.g());
    AppMethodBeat.i(127952);
    super.a(parama);
    AppMethodBeat.o(127952);
  }
  
  public final void JN(String paramString)
  {
    AppMethodBeat.i(127955);
    this.jeI = bu.aSk(paramString.trim());
    dhl();
    ZD();
    AppMethodBeat.o(127955);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(127954);
    setCursor(com.tencent.mm.plugin.account.a.getFacebookFrdStg().Ka(this.jeI));
    this.pq = new int[getCount()];
    if ((this.jmD != null) && (this.jeI != null)) {
      this.jmD.ro(getCursor().getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(127954);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(127953);
    ZD();
    AppMethodBeat.o(127953);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(127956);
    Object localObject = (com.tencent.mm.plugin.account.friend.a.g)getItem(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new b();
      paramView = View.inflate(this.context, 2131493929, null);
      paramViewGroup.fTj = ((ImageView)paramView.findViewById(2131298722));
      paramViewGroup.jeP = ((TextView)paramView.findViewById(2131303561));
      paramViewGroup.jgz = ((TextView)paramView.findViewById(2131303556));
      paramViewGroup.jmE = ((TextView)paramView.findViewById(2131303557));
      paramViewGroup.jmF = ((TextView)paramView.findViewById(2131303559));
      paramViewGroup.jmG = ((ImageView)paramView.findViewById(2131303564));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jeP.setText(k.b(this.context, ((com.tencent.mm.plugin.account.friend.a.g)localObject).aTh(), paramViewGroup.jeP.getTextSize()));
      paramViewGroup.jmF.setVisibility(8);
      paramViewGroup.jmG.setVisibility(0);
      switch (this.pq[paramInt])
      {
      case 1: 
      default: 
        label196:
        localObject = c.Do(((com.tencent.mm.plugin.account.friend.a.g)localObject).eQX);
        if (localObject == null) {
          paramViewGroup.fTj.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690013));
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(127956);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      paramViewGroup.jmE.setVisibility(8);
      paramViewGroup.jgz.setVisibility(0);
      paramViewGroup.jgz.setText(2131759666);
      paramViewGroup.jgz.setTextColor(this.context.getResources().getColor(2131099893));
      break label196;
      if ((((com.tencent.mm.plugin.account.friend.a.g)localObject).status != 102) && (!((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUH(((com.tencent.mm.plugin.account.friend.a.g)localObject).getUsername())))
      {
        paramViewGroup.jgz.setVisibility(8);
        paramViewGroup.jmE.setVisibility(0);
        break label196;
      }
      if (((com.tencent.mm.plugin.account.friend.a.g)localObject).status == 102)
      {
        paramViewGroup.jgz.setVisibility(8);
        paramViewGroup.jmE.setVisibility(8);
        paramViewGroup.jmG.setVisibility(8);
        break label196;
      }
      paramViewGroup.jgz.setVisibility(0);
      paramViewGroup.jgz.setText(2131759662);
      paramViewGroup.jgz.setTextColor(this.context.getResources().getColor(2131099892));
      paramViewGroup.jmE.setVisibility(8);
      break label196;
      paramViewGroup.fTj.setImageBitmap((Bitmap)localObject);
    }
  }
  
  public static abstract interface a
  {
    public abstract void ro(int paramInt);
  }
  
  static final class b
  {
    ImageView fTj;
    TextView jeP;
    TextView jgz;
    TextView jmE;
    TextView jmF;
    ImageView jmG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.d
 * JD-Core Version:    0.7.0.1
 */