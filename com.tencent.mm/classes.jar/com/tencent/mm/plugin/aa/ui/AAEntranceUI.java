package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class AAEntranceUI
  extends MMActivity
{
  private Button eXn;
  private TextView eXo;
  
  protected final int getLayoutId()
  {
    return a.g.aa_entrance_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      return;
    }
    if (paramInt1 == 1)
    {
      String str = paramIntent.getStringExtra("Select_Conv_User");
      y.i("MicroMsg.AAEntranceUI", "select chatroom：%s", new Object[] { str });
      if (!bk.bl(str))
      {
        Intent localIntent = new Intent(this.mController.uMN, LaunchAAUI.class);
        localIntent.putExtra("enter_scene", 2);
        localIntent.putExtra("chatroom_name", str);
        startActivity(localIntent);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    ta(this.mController.czv());
    setMMTitle(a.i.launch_aa_title);
    this.eXn = ((Button)findViewById(a.f.launch_btn));
    this.eXo = ((TextView)findViewById(a.f.check_aa_record_tv));
    this.eXn.setOnClickListener(new AAEntranceUI.1(this));
    this.eXo.setClickable(true);
    this.eXo.setOnTouchListener(new m(this));
    paramBundle = new SpannableStringBuilder(getString(a.i.check_aa_record));
    paramBundle.setSpan(new a(new AAEntranceUI.2(this)), 0, paramBundle.length(), 18);
    this.eXo.setText(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AAEntranceUI.this.finish();
        return false;
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAEntranceUI
 * JD-Core Version:    0.7.0.1
 */