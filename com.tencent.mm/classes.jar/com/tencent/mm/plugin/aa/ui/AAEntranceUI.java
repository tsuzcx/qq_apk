package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class AAEntranceUI
  extends MMActivity
{
  private Button gpl;
  private TextView gpm;
  
  public int getLayoutId()
  {
    return 2130968576;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(40712);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(40712);
      return;
    }
    if (paramInt1 == 1)
    {
      String str = paramIntent.getStringExtra("Select_Conv_User");
      ab.i("MicroMsg.AAEntranceUI", "select chatroom：%s", new Object[] { str });
      if (!bo.isNullOrNil(str))
      {
        Intent localIntent = new Intent(getContext(), LaunchAAUI.class);
        localIntent.putExtra("enter_scene", 2);
        localIntent.putExtra("chatroom_name", str);
        if (getIntent().getExtras() != null) {
          localIntent.putExtras(getIntent().getExtras());
        }
        startActivityForResult(localIntent, 2);
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(40712);
      return;
      if (paramInt1 == 2) {
        finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(40711);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getActionbarColor());
    setMMTitle(2131301049);
    this.gpl = ((Button)findViewById(2131820899));
    this.gpm = ((TextView)findViewById(2131820900));
    this.gpl.setOnClickListener(new AAEntranceUI.1(this));
    this.gpm.setClickable(true);
    this.gpm.setOnTouchListener(new m(this));
    paramBundle = new SpannableStringBuilder(getString(2131298345));
    paramBundle.setSpan(new a(new AAEntranceUI.2(this)), 0, paramBundle.length(), 18);
    this.gpm.setText(paramBundle);
    setBackBtn(new AAEntranceUI.3(this));
    AppMethodBeat.o(40711);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAEntranceUI
 * JD-Core Version:    0.7.0.1
 */