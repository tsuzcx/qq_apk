package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.d.i;

public class CollectHKMainUI
  extends CollectMainUI
{
  private boolean pex = false;
  
  protected final void cbe()
  {
    AppMethodBeat.i(64109);
    g.ajD();
    this.peX = ((String)g.ajC().ajl().get(al.a.IzB, ""));
    com.tencent.mm.plugin.collect.model.n localn = new com.tencent.mm.plugin.collect.model.n(u.aAt());
    if (!bt.isNullOrNil(this.peX))
    {
      fSc().a(localn, false, 1);
      AppMethodBeat.o(64109);
      return;
    }
    ad.i("MicroMsg.CollectHKMainUI", "force load payurl");
    this.pex = true;
    fSc().a(localn, true, 1);
    AppMethodBeat.o(64109);
  }
  
  protected final String cbf()
  {
    AppMethodBeat.i(64110);
    if (bt.isNullOrNil(this.peY)) {
      this.peY = ah.fRG();
    }
    String str = this.peY;
    AppMethodBeat.o(64110);
    return str;
  }
  
  protected final void cbg()
  {
    AppMethodBeat.i(64112);
    ImageView localImageView1 = (ImageView)this.pcJ.findViewById(2131298474);
    ImageView localImageView2 = (ImageView)this.pcJ.findViewById(2131298465);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView2.getLayoutParams();
    localLayoutParams.topMargin = 0;
    localLayoutParams.bottomMargin = 0;
    localLayoutParams.addRule(13);
    localImageView2.setLayoutParams(localLayoutParams);
    if (ac.fks().equals("zh_HK"))
    {
      localImageView1.setImageResource(2131689962);
      localImageView2.setImageResource(2131689958);
      AppMethodBeat.o(64112);
      return;
    }
    localImageView1.setImageResource(2131689961);
    localImageView2.setImageResource(2131689957);
    AppMethodBeat.o(64112);
  }
  
  protected final void cbh()
  {
    AppMethodBeat.i(64113);
    super.cbh();
    if (this.pff)
    {
      findViewById(2131298458).setVisibility(8);
      AppMethodBeat.o(64113);
      return;
    }
    findViewById(2131298458).setVisibility(0);
    AppMethodBeat.o(64113);
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(64111);
    if ((paramn instanceof com.tencent.mm.plugin.collect.model.n))
    {
      paramString = (com.tencent.mm.plugin.collect.model.n)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.dlw == 0)
        {
          this.peX = paramString.paB;
          this.mTrueName = paramString.paL;
          this.peY = paramString.paK;
          refreshView();
          if (!bt.isNullOrNil(paramString.paH))
          {
            this.pft.setText(paramString.paH);
            this.pfw.setOnClickListener(new CollectHKMainUI.2(this, paramString));
            this.pfw.setVisibility(0);
            if (bt.isNullOrNil(paramString.iTH)) {
              break label171;
            }
            this.peU.setText(paramString.iTH);
            this.peU.setOnClickListener(new CollectHKMainUI.3(this, paramString));
            this.peT.setVisibility(0);
          }
          for (;;)
          {
            AppMethodBeat.o(64111);
            return true;
            this.pfw.setVisibility(8);
            break;
            label171:
            this.peT.setVisibility(8);
          }
        }
      }
      else {
        ad.e("MicroMsg.CollectHKMainUI", "net error: %s", new Object[] { paramn });
      }
      if (!this.pex)
      {
        AppMethodBeat.o(64111);
        return true;
      }
    }
    AppMethodBeat.o(64111);
    return false;
  }
  
  protected final String getTrueName()
  {
    return this.mTrueName;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64107);
    super.onCreate(paramBundle);
    this.pfw.setVisibility(8);
    findViewById(2131298458).setVisibility(0);
    findViewById(2131298479).setVisibility(8);
    fSc().addSceneEndListener(1335);
    addIconOptionMenu(0, 2131234701, new CollectHKMainUI.1(this));
    cbi();
    AppMethodBeat.o(64107);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64108);
    super.onDestroy();
    fSc().removeSceneEndListener(1335);
    AppMethodBeat.o(64108);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectHKMainUI
 * JD-Core Version:    0.7.0.1
 */