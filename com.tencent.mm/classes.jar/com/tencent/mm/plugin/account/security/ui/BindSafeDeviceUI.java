package com.tencent.mm.plugin.account.security.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.ui.MMWizardActivity;

public class BindSafeDeviceUI
  extends MMWizardActivity
{
  public int getLayoutId()
  {
    return 2131495331;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125543);
    setMMTitle(2131762744);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125540);
        BindSafeDeviceUI.this.finish();
        AppMethodBeat.o(125540);
        return true;
      }
    });
    ((ImageView)findViewById(2131304473)).setImageResource(2131689475);
    ((TextView)findViewById(2131304474)).setText(2131762750);
    ((TextView)findViewById(2131305879)).setText(2131762751);
    findViewById(2131305879).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125541);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("bind_scene", 1);
        paramAnonymousView.setClass(BindSafeDeviceUI.this, BindMContactUI.class);
        MMWizardActivity.V(BindSafeDeviceUI.this, paramAnonymousView);
        AppMethodBeat.o(125541);
      }
    });
    AppMethodBeat.o(125543);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125542);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(125542);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.BindSafeDeviceUI
 * JD-Core Version:    0.7.0.1
 */