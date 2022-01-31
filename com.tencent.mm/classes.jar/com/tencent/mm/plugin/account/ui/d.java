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
import com.tencent.mm.ah.b;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.p.a;

@Deprecated
final class d
  extends p<com.tencent.mm.plugin.account.friend.a.g>
{
  d.a gDb;
  private int[] gvA;
  private String gvB;
  
  public d(Context paramContext, p.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.g());
    AppMethodBeat.i(124801);
    super.a(parama);
    AppMethodBeat.o(124801);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(124803);
    setCursor(com.tencent.mm.plugin.account.a.getFacebookFrdStg().xe(this.gvB));
    this.gvA = new int[getCount()];
    if ((this.gDb != null) && (this.gvB != null)) {
      this.gDb.mQ(getCursor().getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(124803);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(124802);
    Ku();
    AppMethodBeat.o(124802);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(124805);
    Object localObject = (com.tencent.mm.plugin.account.friend.a.g)getItem(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new d.b();
      paramView = View.inflate(this.context, 2130969516, null);
      paramViewGroup.ehv = ((ImageView)paramView.findViewById(2131823956));
      paramViewGroup.gvI = ((TextView)paramView.findViewById(2131823957));
      paramViewGroup.gxt = ((TextView)paramView.findViewById(2131823960));
      paramViewGroup.gDc = ((TextView)paramView.findViewById(2131823958));
      paramViewGroup.gDd = ((TextView)paramView.findViewById(2131823959));
      paramViewGroup.gDe = ((ImageView)paramView.findViewById(2131823961));
      paramView.setTag(paramViewGroup);
      paramViewGroup.gvI.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, ((com.tencent.mm.plugin.account.friend.a.g)localObject).aqk(), paramViewGroup.gvI.getTextSize()));
      paramViewGroup.gDd.setVisibility(8);
      paramViewGroup.gDe.setVisibility(0);
      switch (this.gvA[paramInt])
      {
      case 1: 
      default: 
        label196:
        localObject = b.qN(((com.tencent.mm.plugin.account.friend.a.g)localObject).dqE);
        if (localObject == null) {
          paramViewGroup.ehv.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2131231207));
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(124805);
      return paramView;
      paramViewGroup = (d.b)paramView.getTag();
      break;
      paramViewGroup.gDc.setVisibility(8);
      paramViewGroup.gxt.setVisibility(0);
      paramViewGroup.gxt.setText(2131300193);
      paramViewGroup.gxt.setTextColor(this.context.getResources().getColor(2131689659));
      break label196;
      if ((((com.tencent.mm.plugin.account.friend.a.g)localObject).status != 102) && (!((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arr(((com.tencent.mm.plugin.account.friend.a.g)localObject).getUsername())))
      {
        paramViewGroup.gxt.setVisibility(8);
        paramViewGroup.gDc.setVisibility(0);
        break label196;
      }
      if (((com.tencent.mm.plugin.account.friend.a.g)localObject).status == 102)
      {
        paramViewGroup.gxt.setVisibility(8);
        paramViewGroup.gDc.setVisibility(8);
        paramViewGroup.gDe.setVisibility(8);
        break label196;
      }
      paramViewGroup.gxt.setVisibility(0);
      paramViewGroup.gxt.setText(2131300189);
      paramViewGroup.gxt.setTextColor(this.context.getResources().getColor(2131689658));
      paramViewGroup.gDc.setVisibility(8);
      break label196;
      paramViewGroup.ehv.setImageBitmap((Bitmap)localObject);
    }
  }
  
  public final void wQ(String paramString)
  {
    AppMethodBeat.i(124804);
    this.gvB = bo.wC(paramString.trim());
    bKb();
    Ku();
    AppMethodBeat.o(124804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.d
 * JD-Core Version:    0.7.0.1
 */