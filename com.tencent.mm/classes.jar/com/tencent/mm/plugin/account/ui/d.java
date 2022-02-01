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
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

@Deprecated
final class d
  extends r<com.tencent.mm.plugin.account.friend.a.g>
{
  private String jbP;
  a jjK;
  private int[] pq;
  
  public d(Context paramContext, r.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.g());
    AppMethodBeat.i(127952);
    super.a(parama);
    AppMethodBeat.o(127952);
  }
  
  public final void Jo(String paramString)
  {
    AppMethodBeat.i(127955);
    this.jbP = bt.aQN(paramString.trim());
    det();
    Zu();
    AppMethodBeat.o(127955);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(127954);
    setCursor(com.tencent.mm.plugin.account.a.getFacebookFrdStg().JB(this.jbP));
    this.pq = new int[getCount()];
    if ((this.jjK != null) && (this.jbP != null)) {
      this.jjK.rl(getCursor().getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(127954);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(127953);
    Zu();
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
      paramViewGroup.fRd = ((ImageView)paramView.findViewById(2131298722));
      paramViewGroup.jbW = ((TextView)paramView.findViewById(2131303561));
      paramViewGroup.jdG = ((TextView)paramView.findViewById(2131303556));
      paramViewGroup.jjL = ((TextView)paramView.findViewById(2131303557));
      paramViewGroup.jjM = ((TextView)paramView.findViewById(2131303559));
      paramViewGroup.jjN = ((ImageView)paramView.findViewById(2131303564));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jbW.setText(k.b(this.context, ((com.tencent.mm.plugin.account.friend.a.g)localObject).aSI(), paramViewGroup.jbW.getTextSize()));
      paramViewGroup.jjM.setVisibility(8);
      paramViewGroup.jjN.setVisibility(0);
      switch (this.pq[paramInt])
      {
      case 1: 
      default: 
        label196:
        localObject = c.CM(((com.tencent.mm.plugin.account.friend.a.g)localObject).ePm);
        if (localObject == null) {
          paramViewGroup.fRd.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131690013));
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
      paramViewGroup.jjL.setVisibility(8);
      paramViewGroup.jdG.setVisibility(0);
      paramViewGroup.jdG.setText(2131759666);
      paramViewGroup.jdG.setTextColor(this.context.getResources().getColor(2131099893));
      break label196;
      if ((((com.tencent.mm.plugin.account.friend.a.g)localObject).status != 102) && (!((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTg(((com.tencent.mm.plugin.account.friend.a.g)localObject).getUsername())))
      {
        paramViewGroup.jdG.setVisibility(8);
        paramViewGroup.jjL.setVisibility(0);
        break label196;
      }
      if (((com.tencent.mm.plugin.account.friend.a.g)localObject).status == 102)
      {
        paramViewGroup.jdG.setVisibility(8);
        paramViewGroup.jjL.setVisibility(8);
        paramViewGroup.jjN.setVisibility(8);
        break label196;
      }
      paramViewGroup.jdG.setVisibility(0);
      paramViewGroup.jdG.setText(2131759662);
      paramViewGroup.jdG.setTextColor(this.context.getResources().getColor(2131099892));
      paramViewGroup.jjL.setVisibility(8);
      break label196;
      paramViewGroup.fRd.setImageBitmap((Bitmap)localObject);
    }
  }
  
  public static abstract interface a
  {
    public abstract void rl(int paramInt);
  }
  
  static final class b
  {
    ImageView fRd;
    TextView jbW;
    TextView jdG;
    TextView jjL;
    TextView jjM;
    ImageView jjN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.d
 * JD-Core Version:    0.7.0.1
 */