package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMContactStatusUI
  extends MMWizardActivity
{
  private Button hJh;
  private TextView igF;
  private TextView igG;
  private ImageView ign;
  
  public int getLayoutId()
  {
    return 2131493181;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109883);
    this.ign = ((ImageView)findViewById(2131297240));
    this.igF = ((TextView)findViewById(2131297238));
    this.igG = ((TextView)findViewById(2131297236));
    this.hJh = ((Button)findViewById(2131297239));
    if (l.aIL() == l.a.iky)
    {
      this.ign.setImageResource(2131690819);
      String str2 = (String)g.afB().afk().get(6, null);
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!str2.equals("")) {}
      }
      else
      {
        str1 = (String)g.afB().afk().get(4097, null);
      }
      this.igG.setText(getString(2131756485));
      this.igF.setText(getString(2131756511, new Object[] { str1 }));
    }
    for (;;)
    {
      this.hJh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109881);
          BindMContactStatusUI.a(BindMContactStatusUI.this);
          AppMethodBeat.o(109881);
        }
      });
      AppMethodBeat.o(109883);
      return;
      this.ign.setImageResource(2131690820);
      this.igG.setText(2131756497);
      this.igF.setText(2131756497);
      this.igG.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109882);
    super.onCreate(paramBundle);
    setMMTitle(2131756489);
    initView();
    AppMethodBeat.o(109882);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109884);
    if (paramInt == 4)
    {
      Xo(1);
      AppMethodBeat.o(109884);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(109884);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactStatusUI
 * JD-Core Version:    0.7.0.1
 */