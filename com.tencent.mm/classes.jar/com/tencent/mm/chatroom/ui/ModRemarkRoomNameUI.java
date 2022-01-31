package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.roomsdk.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.MMEditText;

public class ModRemarkRoomNameUI
  extends MMActivity
  implements c.a
{
  private String dmT;
  private p dnV = null;
  private String dpm = "";
  private MMEditText dpn;
  
  public final void eP(String paramString)
  {
    this.dpm = paramString;
    paramString = b.YK(this.dmT).F(this.dmT, this.dpm);
    paramString.d(new ModRemarkRoomNameUI.4(this, paramString));
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    getString(a.i.app_tip);
    paramString.a(localAppCompatActivity, getString(a.i.contact_info_change_remarkimage_save), false, null);
  }
  
  protected final int getLayoutId()
  {
    return a.f.mod_roomname_and_describle;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.room_card);
    this.dpn = ((MMEditText)findViewById(a.e.modify_roomname_et));
    Object localObject = bk.pm(getIntent().getStringExtra("room_name"));
    if (bk.bl((String)localObject))
    {
      af localaf = ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF();
      this.dpn.setHint(j.a(this, localaf.gV(this.dmT), this.dpn.getTextSize()));
      this.dpn.setEllipsize(TextUtils.TruncateAt.END);
    }
    for (;;)
    {
      this.dpn.setSelection(this.dpn.getText().length());
      this.dpn.addTextChangedListener(new ModRemarkRoomNameUI.1(this, (String)localObject));
      localObject = com.tencent.mm.ui.tools.a.c.d(this.dpn).fJ(1, 32);
      ((com.tencent.mm.ui.tools.a.c)localObject).wfM = false;
      ((com.tencent.mm.ui.tools.a.c)localObject).a(null);
      setBackBtn(new ModRemarkRoomNameUI.2(this));
      a(0, getString(a.i.app_save), new ModRemarkRoomNameUI.3(this), s.b.uNx);
      enableOptionMenu(false);
      return;
      this.dpn.setText(j.a(this, (CharSequence)localObject, this.dpn.getTextSize()));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dmT = getIntent().getStringExtra("RoomInfo_Id");
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  public final void xB()
  {
    h.h(this, a.i.settings_modify_name_invalid_less, a.i.settings_modify_name_title);
  }
  
  public final void xC()
  {
    h.h(this, a.i.settings_modify_name_invalid_more, a.i.settings_modify_name_title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI
 * JD-Core Version:    0.7.0.1
 */