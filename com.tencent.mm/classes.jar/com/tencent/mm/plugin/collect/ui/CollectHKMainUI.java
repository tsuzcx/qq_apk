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
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.d.i;

public class CollectHKMainUI
  extends CollectMainUI
{
  private boolean kRr = false;
  
  protected final void bio()
  {
    AppMethodBeat.i(41248);
    g.RM();
    this.kRP = ((String)g.RL().Ru().get(ac.a.yGJ, ""));
    com.tencent.mm.plugin.collect.model.m localm = new com.tencent.mm.plugin.collect.model.m(r.Zu());
    if (!bo.isNullOrNil(this.kRP))
    {
      dSV().a(localm, false, 1);
      AppMethodBeat.o(41248);
      return;
    }
    ab.i("MicroMsg.CollectHKMainUI", "force load payurl");
    this.kRr = true;
    dSV().a(localm, true, 1);
    AppMethodBeat.o(41248);
  }
  
  protected final String bip()
  {
    AppMethodBeat.i(41249);
    if (bo.isNullOrNil(this.kRQ)) {
      this.kRQ = ae.dSz();
    }
    String str = this.kRQ;
    AppMethodBeat.o(41249);
    return str;
  }
  
  protected final void biq()
  {
    AppMethodBeat.i(41251);
    ImageView localImageView1 = (ImageView)this.kPF.findViewById(2131822949);
    ImageView localImageView2 = (ImageView)this.kPF.findViewById(2131822957);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView2.getLayoutParams();
    localLayoutParams.topMargin = 0;
    localLayoutParams.bottomMargin = 0;
    localLayoutParams.addRule(13);
    localImageView2.setLayoutParams(localLayoutParams);
    if (aa.dsG().equals("zh_HK"))
    {
      localImageView1.setImageResource(2131231158);
      localImageView2.setImageResource(2131231154);
      AppMethodBeat.o(41251);
      return;
    }
    localImageView1.setImageResource(2131231157);
    localImageView2.setImageResource(2131231153);
    AppMethodBeat.o(41251);
  }
  
  protected final void bir()
  {
    AppMethodBeat.i(41252);
    super.bir();
    if (this.kRX)
    {
      findViewById(2131822926).setVisibility(8);
      AppMethodBeat.o(41252);
      return;
    }
    findViewById(2131822926).setVisibility(0);
    AppMethodBeat.o(41252);
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(41250);
    if ((paramm instanceof com.tencent.mm.plugin.collect.model.m))
    {
      paramString = (com.tencent.mm.plugin.collect.model.m)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.cnK == 0)
        {
          this.kRP = paramString.kNw;
          this.mTrueName = paramString.kNI;
          this.kRQ = paramString.kNF;
          refreshView();
          if (!bo.isNullOrNil(paramString.kNC))
          {
            this.kSm.setText(paramString.kNC);
            this.kSp.setOnClickListener(new CollectHKMainUI.2(this, paramString));
            this.kSp.setVisibility(0);
            if (bo.isNullOrNil(paramString.kNG)) {
              break label171;
            }
            this.kRM.setText(paramString.kNG);
            this.kRM.setOnClickListener(new CollectHKMainUI.3(this, paramString));
            this.kRL.setVisibility(0);
          }
          for (;;)
          {
            AppMethodBeat.o(41250);
            return true;
            this.kSp.setVisibility(8);
            break;
            label171:
            this.kRL.setVisibility(8);
          }
        }
      }
      else {
        ab.e("MicroMsg.CollectHKMainUI", "net error: %s", new Object[] { paramm });
      }
      if (!this.kRr)
      {
        AppMethodBeat.o(41250);
        return true;
      }
    }
    AppMethodBeat.o(41250);
    return false;
  }
  
  protected final String getTrueName()
  {
    return this.mTrueName;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41246);
    super.onCreate(paramBundle);
    this.kSp.setVisibility(8);
    findViewById(2131822926).setVisibility(0);
    findViewById(2131822924).setVisibility(8);
    dSV().addSceneEndListener(1335);
    addIconOptionMenu(0, 2130840873, new CollectHKMainUI.1(this));
    AppMethodBeat.o(41246);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41247);
    super.onDestroy();
    dSV().removeSceneEndListener(1335);
    AppMethodBeat.o(41247);
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