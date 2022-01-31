package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMContactStatusUI
  extends MMWizardActivity
{
  private TextView gtD;
  private TextView gtE;
  private Button gtF;
  private ImageView gtl;
  
  public int getLayoutId()
  {
    return 2130968849;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13456);
    this.gtl = ((ImageView)findViewById(2131821776));
    this.gtD = ((TextView)findViewById(2131821777));
    this.gtE = ((TextView)findViewById(2131821807));
    this.gtF = ((Button)findViewById(2131821779));
    if (l.aqq() == l.a.gxB)
    {
      this.gtl.setImageResource(2131231661);
      String str2 = (String)g.RL().Ru().get(6, null);
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!str2.equals("")) {}
      }
      else
      {
        str1 = (String)g.RL().Ru().get(4097, null);
      }
      this.gtE.setText(getString(2131297593));
      this.gtD.setText(getString(2131297618, new Object[] { str1 }));
    }
    for (;;)
    {
      this.gtF.setOnClickListener(new BindMContactStatusUI.1(this));
      AppMethodBeat.o(13456);
      return;
      this.gtl.setImageResource(2131231662);
      this.gtE.setText(2131297605);
      this.gtD.setText(2131297605);
      this.gtE.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13455);
    super.onCreate(paramBundle);
    setMMTitle(2131297597);
    initView();
    AppMethodBeat.o(13455);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(13457);
    if (paramInt == 4)
    {
      Oi(1);
      AppMethodBeat.o(13457);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(13457);
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