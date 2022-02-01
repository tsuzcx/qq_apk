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
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

@Deprecated
final class d
  extends r<com.tencent.mm.plugin.account.friend.a.g>
{
  private String iIG;
  a iQC;
  private int[] nw;
  
  public d(Context paramContext, r.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.g());
    AppMethodBeat.i(127952);
    super.a(parama);
    AppMethodBeat.o(127952);
  }
  
  public final void FZ(String paramString)
  {
    AppMethodBeat.i(127955);
    this.iIG = bs.aLh(paramString.trim());
    cVi();
    Xb();
    AppMethodBeat.o(127955);
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(127954);
    setCursor(com.tencent.mm.plugin.account.a.getFacebookFrdStg().Gm(this.iIG));
    this.nw = new int[getCount()];
    if ((this.iQC != null) && (this.iIG != null)) {
      this.iQC.qL(getCursor().getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(127954);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(127953);
    Xb();
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
      paramViewGroup.fxQ = ((ImageView)paramView.findViewById(2131298722));
      paramViewGroup.iIN = ((TextView)paramView.findViewById(2131303561));
      paramViewGroup.iKx = ((TextView)paramView.findViewById(2131303556));
      paramViewGroup.iQD = ((TextView)paramView.findViewById(2131303557));
      paramViewGroup.iQE = ((TextView)paramView.findViewById(2131303559));
      paramViewGroup.iQF = ((ImageView)paramView.findViewById(2131303564));
      paramView.setTag(paramViewGroup);
      paramViewGroup.iIN.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, ((com.tencent.mm.plugin.account.friend.a.g)localObject).aPw(), paramViewGroup.iIN.getTextSize()));
      paramViewGroup.iQE.setVisibility(8);
      paramViewGroup.iQF.setVisibility(0);
      switch (this.nw[paramInt])
      {
      case 1: 
      default: 
        label196:
        localObject = c.zN(((com.tencent.mm.plugin.account.friend.a.g)localObject).exN);
        if (localObject == null) {
          paramViewGroup.fxQ.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131690013));
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
      paramViewGroup.iQD.setVisibility(8);
      paramViewGroup.iKx.setVisibility(0);
      paramViewGroup.iKx.setText(2131759666);
      paramViewGroup.iKx.setTextColor(this.context.getResources().getColor(2131099893));
      break label196;
      if ((((com.tencent.mm.plugin.account.friend.a.g)localObject).status != 102) && (!((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNo(((com.tencent.mm.plugin.account.friend.a.g)localObject).getUsername())))
      {
        paramViewGroup.iKx.setVisibility(8);
        paramViewGroup.iQD.setVisibility(0);
        break label196;
      }
      if (((com.tencent.mm.plugin.account.friend.a.g)localObject).status == 102)
      {
        paramViewGroup.iKx.setVisibility(8);
        paramViewGroup.iQD.setVisibility(8);
        paramViewGroup.iQF.setVisibility(8);
        break label196;
      }
      paramViewGroup.iKx.setVisibility(0);
      paramViewGroup.iKx.setText(2131759662);
      paramViewGroup.iKx.setTextColor(this.context.getResources().getColor(2131099892));
      paramViewGroup.iQD.setVisibility(8);
      break label196;
      paramViewGroup.fxQ.setImageBitmap((Bitmap)localObject);
    }
  }
  
  public static abstract interface a
  {
    public abstract void qL(int paramInt);
  }
  
  static final class b
  {
    ImageView fxQ;
    TextView iIN;
    TextView iKx;
    TextView iQD;
    TextView iQE;
    ImageView iQF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.d
 * JD-Core Version:    0.7.0.1
 */