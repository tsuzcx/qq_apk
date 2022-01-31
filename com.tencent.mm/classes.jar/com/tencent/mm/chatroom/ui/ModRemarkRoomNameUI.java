package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.roomsdk.a.b;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.MMEditText;

public class ModRemarkRoomNameUI
  extends MMActivity
  implements c.a
{
  private String eeu;
  private p efs = null;
  private String egI = "";
  private MMEditText egJ;
  
  public final void JU()
  {
    AppMethodBeat.i(104126);
    h.h(this, 2131303316, 2131303319);
    AppMethodBeat.o(104126);
  }
  
  public int getLayoutId()
  {
    return 2130970296;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104122);
    setMMTitle(2131302668);
    this.egJ = ((MMEditText)findViewById(2131826326));
    Object localObject = bo.nullAsNil(getIntent().getStringExtra("room_name"));
    if (bo.isNullOrNil((String)localObject))
    {
      ag localag = ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ();
      this.egJ.setHint(j.b(this, localag.nE(this.eeu), this.egJ.getTextSize()));
      this.egJ.setEllipsize(TextUtils.TruncateAt.END);
    }
    for (;;)
    {
      this.egJ.setSelection(this.egJ.getText().length());
      this.egJ.addTextChangedListener(new ModRemarkRoomNameUI.1(this, (String)localObject));
      localObject = com.tencent.mm.ui.tools.b.c.d(this.egJ).hR(1, 32);
      ((com.tencent.mm.ui.tools.b.c)localObject).AyD = false;
      ((com.tencent.mm.ui.tools.b.c)localObject).a(null);
      setBackBtn(new ModRemarkRoomNameUI.2(this));
      addTextOptionMenu(0, getString(2131297063), new ModRemarkRoomNameUI.3(this), null, q.b.zby);
      enableOptionMenu(false);
      AppMethodBeat.o(104122);
      return;
      this.egJ.setText(j.b(this, (CharSequence)localObject, this.egJ.getTextSize()));
    }
  }
  
  public final void kY(final String paramString)
  {
    AppMethodBeat.i(104125);
    this.egI = paramString;
    paramString = b.aoI(this.eeu).P(this.eeu, this.egI);
    paramString.d(new e() {});
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131297087);
    paramString.a(localAppCompatActivity, getString(2131298567), false, null);
    AppMethodBeat.o(104125);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104121);
    super.onCreate(paramBundle);
    this.eeu = getIntent().getStringExtra("RoomInfo_Id");
    initView();
    AppMethodBeat.o(104121);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104124);
    super.onDestroy();
    AppMethodBeat.o(104124);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(104123);
    super.onPause();
    AppMethodBeat.o(104123);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vn()
  {
    AppMethodBeat.i(104127);
    h.h(this, 2131303317, 2131303319);
    AppMethodBeat.o(104127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI
 * JD-Core Version:    0.7.0.1
 */