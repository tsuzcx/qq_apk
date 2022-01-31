package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.p.a;

public final class c
  extends b
{
  private int[] gvA;
  private String gvB;
  private b.a gvC;
  private b.b gvD;
  
  public c(Context paramContext, p.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.a());
    AppMethodBeat.i(13700);
    this.gvD = new c.1(this);
    super.a(parama);
    this.context = paramContext;
    AppMethodBeat.o(13700);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(13703);
    bKb();
    setCursor(((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).wY(this.gvB));
    this.gvA = new int[getCount()];
    if ((this.gvC != null) && (this.gvB != null)) {
      this.gvC.mQ(getCursor().getCount());
    }
    notifyDataSetChanged();
    AppMethodBeat.o(13703);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(13702);
    Ku();
    AppMethodBeat.o(13702);
  }
  
  public final void a(b.a parama)
  {
    this.gvC = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(13704);
    com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2130970290, null);
      paramViewGroup = new c.a(this, paramView);
      paramViewGroup.gvI = ((TextView)paramView.findViewById(2131824136));
      paramView.setTag(paramViewGroup);
      paramViewGroup.gvH = paramInt;
      paramViewGroup.cqq = locala.Al();
      paramViewGroup.status = locala.status;
      paramViewGroup.gvI.setText(locala.apZ());
      switch (locala.status)
      {
      default: 
        label124:
        switch (locala.fsi)
        {
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(13704);
      return paramView;
      paramViewGroup = (c.a)paramView.getTag();
      break;
      if (locala.fsi == 2)
      {
        paramViewGroup.gvJ.setClickable(false);
        paramViewGroup.gvJ.setBackgroundDrawable(null);
        paramViewGroup.gpr.setText(2131300191);
        paramViewGroup.gpr.setTextColor(this.context.getResources().getColor(2131690211));
        break label124;
      }
      paramViewGroup.gvJ.setClickable(true);
      paramViewGroup.gvJ.setBackgroundResource(2130838045);
      paramViewGroup.gpr.setText(2131300190);
      paramViewGroup.gpr.setTextColor(this.context.getResources().getColor(2131690709));
      break label124;
      ab.d("MicroMsg.MobileFriendAdapter", "username:%s", new Object[] { locala.getUsername() });
      if ((((j)g.E(j.class)).YA().arr(locala.getUsername())) || (r.Zn().equals(locala.getUsername())))
      {
        paramViewGroup.gvJ.setClickable(false);
        paramViewGroup.gvJ.setBackgroundDrawable(null);
        paramViewGroup.gpr.setText(2131300189);
        paramViewGroup.gpr.setTextColor(this.context.getResources().getColor(2131690211));
        break label124;
      }
      if (locala.fsi == 2)
      {
        paramViewGroup.gvJ.setClickable(false);
        paramViewGroup.gvJ.setBackgroundDrawable(null);
        paramViewGroup.gpr.setText(2131300194);
        paramViewGroup.gpr.setTextColor(this.context.getResources().getColor(2131690211));
        break label124;
      }
      paramViewGroup.gvJ.setClickable(true);
      paramViewGroup.gvJ.setBackgroundResource(2130838045);
      paramViewGroup.gpr.setText(2131300188);
      paramViewGroup.gpr.setTextColor(this.context.getResources().getColor(2131690709));
      break label124;
      paramViewGroup.gpr.setVisibility(4);
      paramViewGroup.gvK.setVisibility(0);
      continue;
      paramViewGroup.gpr.setVisibility(0);
      paramViewGroup.gvK.setVisibility(4);
    }
  }
  
  public final void wQ(String paramString)
  {
    AppMethodBeat.i(13701);
    this.gvB = bo.wC(paramString.trim());
    bKb();
    Ku();
    AppMethodBeat.o(13701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.c
 * JD-Core Version:    0.7.0.1
 */