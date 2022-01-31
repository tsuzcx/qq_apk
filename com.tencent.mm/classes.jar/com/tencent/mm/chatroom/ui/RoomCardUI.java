package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.widget.MMEditText;

public class RoomCardUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private String egF;
  private String egT;
  private int egU;
  private String egV;
  private boolean egW;
  private boolean egX;
  private String egY;
  private String egZ;
  private long eha;
  private com.tencent.mm.ui.base.p ehb;
  private TextView ehc;
  private MMEditText ehd;
  private TextView ehe;
  private TextView ehf;
  private ImageView ehg;
  private LinearLayout ehh;
  private LinearLayout ehi;
  private LinearLayout ehj;
  private LinearLayout ehk;
  private com.tencent.mm.ui.tools.h ehl;
  private j.b ehm;
  private c ehn;
  private boolean eho;
  
  public RoomCardUI()
  {
    AppMethodBeat.i(104158);
    this.ehn = new RoomCardUI.4(this);
    this.eho = false;
    AppMethodBeat.o(104158);
  }
  
  private boolean JV()
  {
    AppMethodBeat.i(104163);
    String str = this.ehd.getText().toString();
    if (bo.isNullOrNil(str))
    {
      if (bo.isNullOrNil(this.egY))
      {
        AppMethodBeat.o(104163);
        return false;
      }
      AppMethodBeat.o(104163);
      return true;
    }
    if ((this.egY == null) || (!this.egY.equals(str)))
    {
      AppMethodBeat.o(104163);
      return true;
    }
    AppMethodBeat.o(104163);
    return false;
  }
  
  private void JW()
  {
    AppMethodBeat.i(104164);
    if (JV())
    {
      enableOptionMenu(true);
      AppMethodBeat.o(104164);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(104164);
  }
  
  private void JX()
  {
    AppMethodBeat.i(104169);
    Intent localIntent = new Intent();
    localIntent.putExtra("room_name", this.egT);
    localIntent.putExtra("room_notice", this.egY);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(104169);
  }
  
  private void e(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(104168);
    if ((this.ehb != null) && (this.ehb.isShowing())) {
      this.ehb.dismiss();
    }
    if ((this.ehb != null) && (this.ehb.isShowing())) {
      this.ehb.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
      this.egY = this.ehd.getText().toString();
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 15L, 1L, true);
      JX();
      AppMethodBeat.o(104168);
      return;
    }
    kZ(paramString);
    ab.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(104168);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(104162);
    if ((!this.egW) && (!this.egX))
    {
      setResult(0);
      finish();
      AppMethodBeat.o(104162);
      return;
    }
    if (JV())
    {
      com.tencent.mm.ui.base.h.d(this, getString(2131302669), null, getString(2131302671), getString(2131302670), new RoomCardUI.11(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(104155);
          RoomCardUI.this.setResult(0);
          RoomCardUI.this.finish();
          AppMethodBeat.o(104155);
        }
      });
      AppMethodBeat.o(104162);
      return;
    }
    setResult(0);
    finish();
    AppMethodBeat.o(104162);
  }
  
  private void kZ(String paramString)
  {
    AppMethodBeat.i(104170);
    ab.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", new Object[] { paramString });
    paramString = a.kO(paramString);
    if (paramString != null) {
      paramString.a(this, new RoomCardUI.5(this));
    }
    AppMethodBeat.o(104170);
  }
  
  public int getLayoutId()
  {
    return 2130970588;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104159);
    setMMTitle(2131302750);
    getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131690709)));
    this.ehl = new com.tencent.mm.ui.tools.h(this);
    getWindow().setSoftInputMode(48);
    this.ehl.Avp = new RoomCardUI.1(this);
    addTextOptionMenu(0, getString(2131296914), new RoomCardUI.6(this), null, q.b.zby);
    enableOptionMenu(true);
    this.ehj = ((LinearLayout)findViewById(2131827369));
    this.ehk = ((LinearLayout)findViewById(2131827375));
    this.ehd = ((MMEditText)findViewById(2131827373));
    this.ehe = ((TextView)findViewById(2131827372));
    this.ehf = ((TextView)findViewById(2131827371));
    this.ehh = ((LinearLayout)findViewById(2131827376));
    this.ehg = ((ImageView)findViewById(2131827370));
    this.ehi = ((LinearLayout)findViewById(2131827378));
    this.ehd.setText(this.egY);
    Object localObject = (WindowManager)getSystemService("window");
    this.ehd.setMinHeight(((WindowManager)localObject).getDefaultDisplay().getHeight() * 2 / 3 - 100);
    j.b(this.ehd, Integer.valueOf(31));
    this.ehc = ((TextView)findViewById(2131827374));
    this.ehc.setText(Integer.toString(com.tencent.mm.ui.tools.f.bO(280, this.egY)));
    this.ehi.setVisibility(8);
    this.ehd.setCursorVisible(false);
    this.ehd.setFocusable(false);
    label424:
    String str;
    if ((!this.egW) && (!this.egX))
    {
      removeOptionMenu(0);
      this.ehk.setVisibility(0);
      this.ehd.setFocusable(false);
      this.ehd.setCursorVisible(false);
      this.ehd.setOnLongClickListener(new RoomCardUI.7(this));
      if (this.eha == 0L) {
        break label623;
      }
      this.ehe.setVisibility(0);
      this.ehe.setText(com.tencent.mm.pluginsdk.f.h.formatTime("yyyy-MM-dd HH:mm", this.eha));
      if (!bo.isNullOrNil(this.egY)) {
        break label635;
      }
      this.ehd.setEnabled(true);
      this.ehd.setFocusableInTouchMode(true);
      this.ehd.setFocusable(true);
      this.ehj.setVisibility(8);
      this.ehd.setMinHeight(((WindowManager)localObject).getDefaultDisplay().getHeight() * 2 / 3 + 100);
      this.ehd.requestFocus();
      this.ehd.setCursorVisible(true);
      updateOptionMenuText(0, getContext().getString(2131296964));
      JW();
      this.ehd.performClick();
      showVKB();
      label537:
      localObject = s.nE(this.egZ);
      this.ehf.setText(j.b(this, (CharSequence)localObject, this.ehf.getTextSize()));
      localObject = this.ehg;
      str = this.egZ;
      if (!bo.isNullOrNil(str)) {
        break label646;
      }
      ((ImageView)localObject).setImageResource(2130838493);
    }
    for (;;)
    {
      this.ehd.addTextChangedListener(new RoomCardUI.a(this, (byte)0));
      AppMethodBeat.o(104159);
      return;
      this.ehk.setVisibility(8);
      break;
      label623:
      this.ehe.setVisibility(8);
      break label424;
      label635:
      this.ehj.setVisibility(0);
      break label537;
      label646:
      a.b.c((ImageView)localObject, str);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(104166);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(104166);
      return;
    }
    AppMethodBeat.o(104166);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104160);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 0L, 1L, true);
    g.RK().eHt.a(993, this);
    this.egF = getIntent().getStringExtra("RoomInfo_Id");
    this.egY = getIntent().getStringExtra("room_notice");
    this.egZ = getIntent().getStringExtra("room_notice_editor");
    this.eha = getIntent().getLongExtra("room_notice_publish_time", 0L);
    this.egT = getIntent().getStringExtra("room_name");
    this.egU = getIntent().getIntExtra("room_member_count", 0);
    this.egV = getIntent().getStringExtra("room_owner_name");
    this.egW = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.egX = getIntent().getBooleanExtra("Is_RoomManager", false);
    initView();
    setBackBtn(new RoomCardUI.10(this));
    AppMethodBeat.o(104160);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104161);
    super.onDestroy();
    g.RK().eHt.b(993, this);
    if ((this.ehb != null) && (this.ehb.isShowing())) {
      this.ehb.dismiss();
    }
    AppMethodBeat.o(104161);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(104165);
    super.onKeyDown(paramInt, paramKeyEvent);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      goBack();
      AppMethodBeat.o(104165);
      return true;
    }
    AppMethodBeat.o(104165);
    return false;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(155178);
    super.onPause();
    this.ehl.close();
    AppMethodBeat.o(155178);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(155176);
    super.onResume();
    this.ehl.start();
    AppMethodBeat.o(155176);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(104167);
    if (paramm.getType() == 993)
    {
      e(paramInt1, paramInt2, paramString);
      AppMethodBeat.o(104167);
      return;
    }
    ab.w("MicroMsg.RoomInfoUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramm.getType()) });
    AppMethodBeat.o(104167);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(155177);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.ehl.start();
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(155177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI
 * JD-Core Version:    0.7.0.1
 */