package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMWizardActivity;

public class BakFinishUI
  extends MMWizardActivity
  implements e.e
{
  private MMHandler handler;
  private TextView mlA;
  private int vfN;
  
  public BakFinishUI()
  {
    AppMethodBeat.i(21980);
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(21980);
  }
  
  public final void cXk()
  {
    AppMethodBeat.i(21985);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21978);
        a.cWU().cWV().vfh = -1;
        BakFinishUI.b(BakFinishUI.this);
        AppMethodBeat.o(21978);
      }
    });
    AppMethodBeat.o(21985);
  }
  
  public int getLayoutId()
  {
    return R.i.geE;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21982);
    setMMTitle(R.l.gvw);
    this.mlA = ((TextView)findViewById(R.h.fth));
    if (6 == this.vfN) {
      this.mlA.setText(getString(R.l.gvv));
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(21977);
          a.cWU().cWV().vfh = -1;
          BakFinishUI.a(BakFinishUI.this);
          AppMethodBeat.o(21977);
          return true;
        }
      });
      AppMethodBeat.o(21982);
      return;
      if (1 == this.vfN) {
        this.mlA.setText(getString(R.l.gvo));
      }
    }
  }
  
  public final void oc(int paramInt)
  {
    AppMethodBeat.i(21986);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21979);
        Log.d("MicroMsg.BakFinishUI", "BakFinishUI onCloseSocket");
        Intent localIntent = new Intent(BakFinishUI.this, BakConnErrorUI.class);
        MMWizardActivity.aQ(BakFinishUI.this, localIntent);
        AppMethodBeat.o(21979);
      }
    });
    AppMethodBeat.o(21986);
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
    this.vfN = getIntent().getIntExtra("cmd", -1);
    Log.i("MicroMsg.BakFinishUI", "BakFinishUI onCreate nowCmd:%d", new Object[] { Integer.valueOf(this.vfN) });
    initView();
    a.cWU().cWV().veZ = this;
    AppMethodBeat.o(21981);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21983);
    super.onDestroy();
    a.cWU().cWV().veZ = null;
    Log.i("MicroMsg.BakFinishUI", "BakFinishUI onDestroy nowCmd:%d", new Object[] { Integer.valueOf(this.vfN) });
    AppMethodBeat.o(21983);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21984);
    if (paramInt == 4)
    {
      a.cWU().cWV().vfh = -1;
      aAp(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakFinishUI
 * JD-Core Version:    0.7.0.1
 */