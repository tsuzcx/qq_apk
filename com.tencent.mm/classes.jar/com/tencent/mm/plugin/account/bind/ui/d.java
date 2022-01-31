package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.p.a;

public final class d
  extends b
{
  private int[] gvA;
  private String gvB;
  private b.a gvC;
  private b.b gvD;
  
  public d(Context paramContext, p.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.a());
    AppMethodBeat.i(13712);
    this.gvD = new d.1(this);
    super.a(parama);
    this.context = paramContext;
    qp(true);
    AppMethodBeat.o(13712);
  }
  
  private static String a(com.tencent.mm.plugin.account.friend.a.a parama)
  {
    AppMethodBeat.i(13717);
    if (parama.gwN == 123)
    {
      AppMethodBeat.o(13717);
      return "#";
    }
    char c = (char)parama.gwN;
    AppMethodBeat.o(13717);
    return String.valueOf(c);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(13715);
    bKb();
    setCursor(((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).wZ(this.gvB));
    this.gvA = new int[getCount()];
    if ((this.gvC != null) && (this.gvB != null)) {
      this.gvC.mQ(getCursor().getCount());
    }
    notifyDataSetChanged();
    AppMethodBeat.o(13715);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(13714);
    Ku();
    AppMethodBeat.o(13714);
  }
  
  public final void a(b.a parama)
  {
    this.gvC = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(13716);
    com.tencent.mm.plugin.account.friend.a.a locala = (com.tencent.mm.plugin.account.friend.a.a)getItem(paramInt);
    label160:
    label192:
    Object localObject;
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2130969639, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.gvH = paramInt;
      paramViewGroup.account = locala.Al();
      paramViewGroup.status = locala.status;
      paramViewGroup.gvQ.setText(locala.apZ());
      paramViewGroup.gvR.setText(this.context.getString(2131300195) + locala.aqc());
      a.b.c(paramViewGroup.ehv, locala.getUsername());
      switch (locala.status)
      {
      default: 
        switch (locala.fsi)
        {
        default: 
          localObject = (com.tencent.mm.plugin.account.friend.a.a)getItem(paramInt - 1);
          if (localObject == null)
          {
            i = -1;
            label212:
            if (paramInt != 0) {
              break label672;
            }
            localObject = a(locala);
            if (!bo.isNullOrNil((String)localObject)) {
              break label641;
            }
            ab.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { locala.getUsername(), Integer.valueOf(paramInt) });
            paramViewGroup.gvP.setVisibility(8);
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(13716);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      if (locala.fsi == 2)
      {
        paramViewGroup.gvJ.setClickable(false);
        paramViewGroup.gvJ.setBackgroundDrawable(null);
        paramViewGroup.gpr.setText(2131300191);
        paramViewGroup.gpr.setTextColor(this.context.getResources().getColor(2131690211));
        break label160;
      }
      paramViewGroup.gvJ.setClickable(true);
      paramViewGroup.gvJ.setBackgroundResource(2130838045);
      paramViewGroup.gpr.setText(2131300190);
      paramViewGroup.gpr.setTextColor(this.context.getResources().getColor(2131690709));
      break label160;
      if ((((j)g.E(j.class)).YA().arr(locala.getUsername())) || (r.Zn().equals(locala.getUsername())))
      {
        paramViewGroup.gvJ.setClickable(false);
        paramViewGroup.gvJ.setBackgroundDrawable(null);
        paramViewGroup.gpr.setText(2131300189);
        paramViewGroup.gpr.setTextColor(this.context.getResources().getColor(2131690211));
        break label160;
      }
      if (locala.fsi == 2)
      {
        paramViewGroup.gvJ.setClickable(false);
        paramViewGroup.gvJ.setBackgroundDrawable(null);
        paramViewGroup.gpr.setText(2131300194);
        paramViewGroup.gpr.setTextColor(this.context.getResources().getColor(2131690211));
        break label160;
      }
      paramViewGroup.gvJ.setClickable(true);
      paramViewGroup.gvJ.setBackgroundResource(2130838045);
      paramViewGroup.gpr.setText(2131300188);
      paramViewGroup.gpr.setTextColor(this.context.getResources().getColor(2131690709));
      break label160;
      paramViewGroup.gpr.setVisibility(4);
      paramViewGroup.gvS.setVisibility(0);
      break label192;
      paramViewGroup.gpr.setVisibility(0);
      paramViewGroup.gvS.setVisibility(4);
      break label192;
      i = ((com.tencent.mm.plugin.account.friend.a.a)localObject).gwN;
      break label212;
      label641:
      paramViewGroup.gvP.setVisibility(0);
      paramViewGroup.gvP.setText((CharSequence)localObject);
      paramViewGroup.gvP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      continue;
      label672:
      if (locala.gwN != i) {}
      for (i = 1;; i = 0)
      {
        localObject = a(locala);
        if ((!bo.isNullOrNil((String)localObject)) && (i != 0)) {
          break label749;
        }
        ab.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { locala.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.gvP.setVisibility(8);
        break;
      }
      label749:
      paramViewGroup.gvP.setVisibility(0);
      paramViewGroup.gvP.setText((CharSequence)localObject);
      paramViewGroup.gvP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
  }
  
  public final void wQ(String paramString)
  {
    AppMethodBeat.i(13713);
    this.gvB = bo.wC(paramString.trim());
    bKb();
    Ku();
    AppMethodBeat.o(13713);
  }
  
  final class a
  {
    String account;
    ImageView ehv;
    TextView gpr;
    int gvH;
    View gvJ;
    TextView gvP;
    TextView gvQ;
    TextView gvR;
    ProgressBar gvS;
    int status;
    
    public a(View paramView)
    {
      AppMethodBeat.i(13711);
      this.gvP = ((TextView)paramView.findViewById(2131824297));
      this.ehv = ((ImageView)paramView.findViewById(2131824298));
      this.gvQ = ((TextView)paramView.findViewById(2131824299));
      this.gvR = ((TextView)paramView.findViewById(2131824300));
      this.gvJ = paramView.findViewById(2131824301);
      this.gpr = ((TextView)paramView.findViewById(2131824302));
      this.gvS = ((ProgressBar)paramView.findViewById(2131824303));
      this.gvJ.setOnClickListener(new d.a.1(this, d.this));
      AppMethodBeat.o(13711);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.d
 * JD-Core Version:    0.7.0.1
 */