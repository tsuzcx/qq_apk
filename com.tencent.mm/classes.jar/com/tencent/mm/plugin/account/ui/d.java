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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.q.a;

@Deprecated
final class d
  extends q<com.tencent.mm.plugin.account.friend.a.g>
{
  private String iiy;
  a iqv;
  private int[] mv;
  
  public d(Context paramContext, q.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.g());
    AppMethodBeat.i(127952);
    super.a(parama);
    AppMethodBeat.o(127952);
  }
  
  public final void BW(String paramString)
  {
    AppMethodBeat.i(127955);
    this.iiy = bt.aFQ(paramString.trim());
    cHX();
    Wd();
    AppMethodBeat.o(127955);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(127954);
    setCursor(com.tencent.mm.plugin.account.a.getFacebookFrdStg().Cj(this.iiy));
    this.mv = new int[getCount()];
    if ((this.iqv != null) && (this.iiy != null)) {
      this.iqv.pY(getCursor().getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(127954);
  }
  
  public final void We()
  {
    AppMethodBeat.i(127953);
    Wd();
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
      paramViewGroup.fuj = ((ImageView)paramView.findViewById(2131298722));
      paramViewGroup.iiF = ((TextView)paramView.findViewById(2131303561));
      paramViewGroup.ikq = ((TextView)paramView.findViewById(2131303556));
      paramViewGroup.iqw = ((TextView)paramView.findViewById(2131303557));
      paramViewGroup.iqx = ((TextView)paramView.findViewById(2131303559));
      paramViewGroup.iqy = ((ImageView)paramView.findViewById(2131303564));
      paramView.setTag(paramViewGroup);
      paramViewGroup.iiF.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, ((com.tencent.mm.plugin.account.friend.a.g)localObject).aIF(), paramViewGroup.iiF.getTextSize()));
      paramViewGroup.iqx.setVisibility(8);
      paramViewGroup.iqy.setVisibility(0);
      switch (this.mv[paramInt])
      {
      case 1: 
      default: 
        label196:
        localObject = c.vH(((com.tencent.mm.plugin.account.friend.a.g)localObject).evr);
        if (localObject == null) {
          paramViewGroup.fuj.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131690013));
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
      paramViewGroup.iqw.setVisibility(8);
      paramViewGroup.ikq.setVisibility(0);
      paramViewGroup.ikq.setText(2131759666);
      paramViewGroup.ikq.setTextColor(this.context.getResources().getColor(2131099893));
      break label196;
      if ((((com.tencent.mm.plugin.account.friend.a.g)localObject).status != 102) && (!((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHT(((com.tencent.mm.plugin.account.friend.a.g)localObject).getUsername())))
      {
        paramViewGroup.ikq.setVisibility(8);
        paramViewGroup.iqw.setVisibility(0);
        break label196;
      }
      if (((com.tencent.mm.plugin.account.friend.a.g)localObject).status == 102)
      {
        paramViewGroup.ikq.setVisibility(8);
        paramViewGroup.iqw.setVisibility(8);
        paramViewGroup.iqy.setVisibility(8);
        break label196;
      }
      paramViewGroup.ikq.setVisibility(0);
      paramViewGroup.ikq.setText(2131759662);
      paramViewGroup.ikq.setTextColor(this.context.getResources().getColor(2131099892));
      paramViewGroup.iqw.setVisibility(8);
      break label196;
      paramViewGroup.fuj.setImageBitmap((Bitmap)localObject);
    }
  }
  
  public static abstract interface a
  {
    public abstract void pY(int paramInt);
  }
  
  static final class b
  {
    ImageView fuj;
    TextView iiF;
    TextView ikq;
    TextView iqw;
    TextView iqx;
    ImageView iqy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.d
 * JD-Core Version:    0.7.0.1
 */