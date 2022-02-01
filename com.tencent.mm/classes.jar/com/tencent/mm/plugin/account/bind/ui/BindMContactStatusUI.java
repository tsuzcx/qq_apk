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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMContactStatusUI
  extends MMWizardActivity
{
  private Button hPX;
  private ImageView kaB;
  private TextView kaT;
  private TextView kaU;
  
  public int getLayoutId()
  {
    return 2131493227;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109883);
    this.kaB = ((ImageView)findViewById(2131297395));
    this.kaT = ((TextView)findViewById(2131297393));
    this.kaU = ((TextView)findViewById(2131297391));
    this.hPX = ((Button)findViewById(2131297394));
    if (l.bnZ() == l.a.keL)
    {
      this.kaB.setImageResource(2131691105);
      String str2 = (String)g.aAh().azQ().get(6, null);
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!str2.equals("")) {}
      }
      else
      {
        str1 = (String)g.aAh().azQ().get(4097, null);
      }
      this.kaU.setText(getString(2131756621));
      this.kaT.setText(getString(2131756647, new Object[] { str1 }));
    }
    for (;;)
    {
      this.hPX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109881);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/account/bind/ui/BindMContactStatusUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          BindMContactStatusUI.a(BindMContactStatusUI.this);
          a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactStatusUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109881);
        }
      });
      AppMethodBeat.o(109883);
      return;
      this.kaB.setImageResource(2131691106);
      this.kaU.setText(2131756633);
      this.kaT.setText(2131756633);
      this.kaU.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109882);
    super.onCreate(paramBundle);
    setMMTitle(2131756625);
    initView();
    AppMethodBeat.o(109882);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109884);
    if (paramInt == 4)
    {
      ala(1);
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