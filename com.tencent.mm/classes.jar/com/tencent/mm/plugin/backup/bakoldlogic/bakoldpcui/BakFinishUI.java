package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMWizardActivity;

public class BakFinishUI
  extends MMWizardActivity
  implements e.e
{
  private ap handler;
  private int mzJ;
  private TextView mzL;
  
  public BakFinishUI()
  {
    AppMethodBeat.i(21980);
    this.handler = new ap(Looper.getMainLooper());
    AppMethodBeat.o(21980);
  }
  
  public final void byt()
  {
    AppMethodBeat.i(21985);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21978);
        a.byd().bye().mzc = -1;
        BakFinishUI.b(BakFinishUI.this);
        AppMethodBeat.o(21978);
      }
    });
    AppMethodBeat.o(21985);
  }
  
  public int getLayoutId()
  {
    return 2131493142;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21982);
    setMMTitle(2131756308);
    this.mzL = ((TextView)findViewById(2131297074));
    if (6 == this.mzJ) {
      this.mzL.setText(getString(2131756304));
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(21977);
          a.byd().bye().mzc = -1;
          BakFinishUI.a(BakFinishUI.this);
          AppMethodBeat.o(21977);
          return true;
        }
      });
      AppMethodBeat.o(21982);
      return;
      if (1 == this.mzJ) {
        this.mzL.setText(getString(2131756295));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21981);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false))
    {
      AppMethodBeat.o(21981);
      return;
    }
    this.mzJ = getIntent().getIntExtra("cmd", -1);
    ad.i("MicroMsg.BakFinishUI", "BakFinishUI onCreate nowCmd:%d", new Object[] { Integer.valueOf(this.mzJ) });
    initView();
    a.byd().bye().myU = this;
    AppMethodBeat.o(21981);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21983);
    super.onDestroy();
    a.byd().bye().myU = null;
    ad.i("MicroMsg.BakFinishUI", "BakFinishUI onDestroy nowCmd:%d", new Object[] { Integer.valueOf(this.mzJ) });
    AppMethodBeat.o(21983);
  }
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(21986);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21979);
        ad.d("MicroMsg.BakFinishUI", "BakFinishUI onCloseSocket");
        Intent localIntent = new Intent(BakFinishUI.this, BakConnErrorUI.class);
        MMWizardActivity.V(BakFinishUI.this, localIntent);
        AppMethodBeat.o(21979);
      }
    });
    AppMethodBeat.o(21986);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21984);
    if (paramInt == 4)
    {
      a.byd().bye().mzc = -1;
      Xo(1);
      AppMethodBeat.o(21984);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21984);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakFinishUI
 * JD-Core Version:    0.7.0.1
 */