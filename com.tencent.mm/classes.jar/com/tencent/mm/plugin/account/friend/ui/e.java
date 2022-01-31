package com.tencent.mm.plugin.account.friend.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ah.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends d
{
  private final int TR;
  private final MMActivity cmc;
  private String gvB;
  private final a gzG;
  private final c gzH;
  private d.a gzI;
  boolean gzJ;
  private e.a gzK;
  
  public e(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, new ao());
    AppMethodBeat.i(108595);
    this.gzJ = false;
    this.gzK = new e.1(this);
    this.cmc = paramMMActivity;
    this.TR = paramInt;
    this.gzJ = paramMMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
    this.gzG = new a(paramMMActivity, new e.2(this));
    this.gzH = new c(paramMMActivity, new e.3(this));
    AppMethodBeat.o(108595);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(108598);
    bKb();
    if (bo.isNullOrNil(this.gvB)) {
      setCursor(((ap)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).E(this.TR, this.gzJ));
    }
    for (;;)
    {
      if ((this.gzI != null) && (this.gvB != null)) {
        this.gzI.mQ(getCursor().getCount());
      }
      notifyDataSetChanged();
      AppMethodBeat.o(108598);
      return;
      setCursor(((ap)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).c(this.TR, this.gvB, this.gzJ));
    }
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(108597);
    Ku();
    AppMethodBeat.o(108597);
  }
  
  public final void a(d.a parama)
  {
    this.gzI = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108599);
    ao localao = (ao)getItem(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.cmc, 2130970478, null);
      paramViewGroup = new e.b(this, paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.gvH = paramInt;
      paramViewGroup.gzN = localao.gyE;
      paramViewGroup.status = localao.gyF;
      paramViewGroup.gvI.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.cmc, localao.getDisplayName(), paramViewGroup.gvI.getTextSize()));
      if (p.cU(localao.gyE) == 0) {
        break label621;
      }
    }
    label162:
    label208:
    label621:
    for (Bitmap localBitmap = b.gB(localao.gyE);; localBitmap = null)
    {
      if (localBitmap == null)
      {
        paramViewGroup.ehv.setImageDrawable(com.tencent.mm.cb.a.k(this.cmc, 2131231207));
        if (!this.gzJ) {
          break label208;
        }
        paramViewGroup.gvJ.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(108599);
        return paramView;
        paramViewGroup = (e.b)paramView.getTag();
        break;
        paramViewGroup.ehv.setImageBitmap(localBitmap);
        break label162;
        switch (localao.gyF)
        {
        }
        for (;;)
        {
          switch (localao.fsi)
          {
          default: 
            break;
          case 0: 
          case 2: 
            paramViewGroup.gpr.setVisibility(0);
            paramViewGroup.gvK.setVisibility(4);
            break;
            if (localao.fsi == 2)
            {
              paramViewGroup.gvJ.setClickable(false);
              paramViewGroup.gvJ.setBackgroundDrawable(null);
              paramViewGroup.gpr.setText(2131300191);
              paramViewGroup.gpr.setTextColor(this.cmc.getResources().getColor(2131690211));
            }
            else
            {
              paramViewGroup.gvJ.setClickable(true);
              paramViewGroup.gvJ.setBackgroundResource(2130838045);
              paramViewGroup.gpr.setText(2131300190);
              paramViewGroup.gpr.setTextColor(this.cmc.getResources().getColor(2131690709));
              continue;
              if ((((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arr(localao.getUsername())) || (r.Zn().equals(localao.getUsername())))
              {
                paramViewGroup.gvJ.setClickable(false);
                paramViewGroup.gvJ.setBackgroundDrawable(null);
                paramViewGroup.gpr.setText(2131300189);
                paramViewGroup.gpr.setTextColor(this.cmc.getResources().getColor(2131690211));
              }
              else if (localao.fsi == 2)
              {
                paramViewGroup.gvJ.setClickable(false);
                paramViewGroup.gvJ.setBackgroundDrawable(null);
                paramViewGroup.gpr.setText(2131300194);
                paramViewGroup.gpr.setTextColor(this.cmc.getResources().getColor(2131690211));
              }
              else
              {
                paramViewGroup.gvJ.setClickable(true);
                paramViewGroup.gvJ.setBackgroundResource(2130838045);
                paramViewGroup.gpr.setText(2131300188);
                paramViewGroup.gpr.setTextColor(this.cmc.getResources().getColor(2131690709));
              }
            }
            break;
          }
        }
        paramViewGroup.gpr.setVisibility(4);
        paramViewGroup.gvK.setVisibility(0);
      }
    }
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(108600);
    notifyDataSetChanged();
    AppMethodBeat.o(108600);
  }
  
  public final void wQ(String paramString)
  {
    AppMethodBeat.i(108596);
    this.gvB = bo.wC(paramString.trim());
    bKb();
    Ku();
    AppMethodBeat.o(108596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e
 * JD-Core Version:    0.7.0.1
 */