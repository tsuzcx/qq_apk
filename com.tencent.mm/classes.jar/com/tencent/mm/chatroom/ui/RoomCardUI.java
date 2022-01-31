package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.ah.m;
import com.tencent.mm.i.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.9;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.c.a;

public class RoomCardUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private boolean dpA;
  private boolean dpB;
  private String dpC;
  private String dpD;
  private long dpE;
  private com.tencent.mm.ui.base.p dpF;
  private TextView dpG;
  private MMEditText dpH;
  private TextView dpI;
  private TextView dpJ;
  private ImageView dpK;
  private LinearLayout dpL;
  private LinearLayout dpM;
  private LinearLayout dpN;
  private LinearLayout dpO;
  private i.b dpP;
  private com.tencent.mm.sdk.b.c dpQ = new RoomCardUI.3(this);
  private boolean dpR = false;
  private String dpj;
  private String dpx;
  private int dpy;
  private String dpz;
  
  private void c(int paramInt1, int paramInt2, String paramString)
  {
    if ((this.dpF != null) && (this.dpF.isShowing())) {
      this.dpF.dismiss();
    }
    if ((this.dpF != null) && (this.dpF.isShowing())) {
      this.dpF.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
      this.dpC = this.dpH.getText().toString();
      com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 15L, 1L, true);
      xF();
      return;
    }
    y.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", new Object[] { paramString });
    Object localObject2 = a.eI(paramString);
    if (localObject2 != null)
    {
      Object localObject1 = new RoomCardUI.4(this);
      String str = ((a)localObject2).desc;
      localObject2 = ((a)localObject2).bGw;
      if ((!(this instanceof Activity)) || (!((Activity)this).isFinishing()))
      {
        c.a locala = new c.a(this);
        locala.aez((String)localObject2);
        locala.aeA(str);
        locala.a((DialogInterface.OnDismissListener)localObject1);
        locala.nW(false);
        locala.Is(a.k.app_ok).a(new h.9());
        localObject1 = locala.aoP();
        ((com.tencent.mm.ui.widget.a.c)localObject1).show();
        com.tencent.mm.ui.base.h.a(this, (Dialog)localObject1);
      }
    }
    y.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
  }
  
  private void goBack()
  {
    if ((!this.dpA) && (!this.dpB))
    {
      setResult(0);
      finish();
      return;
    }
    if (xD())
    {
      com.tencent.mm.ui.base.h.a(this, getString(a.i.room_card_cancel_alert), null, getString(a.i.room_card_cancel_alert_save), getString(a.i.room_card_cancel_alert_cancel), new DialogInterface.OnClickListener()new RoomCardUI.10
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }, new RoomCardUI.10(this));
      return;
    }
    setResult(0);
    finish();
  }
  
  private boolean xD()
  {
    String str = this.dpH.getText().toString();
    if (bk.bl(str)) {
      if (!bk.bl(this.dpC)) {}
    }
    while ((this.dpC != null) && (this.dpC.equals(str)))
    {
      return false;
      return true;
    }
    return true;
  }
  
  private void xE()
  {
    if (xD())
    {
      enableOptionMenu(true);
      return;
    }
    enableOptionMenu(false);
  }
  
  private void xF()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("room_name", this.dpx);
    localIntent.putExtra("room_notice", this.dpC);
    setResult(-1, localIntent);
    finish();
  }
  
  protected final int getLayoutId()
  {
    return a.f.room_card_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.room_notice_title);
    a(0, getString(a.i.app_edit), new RoomCardUI.1(this), s.b.uNx);
    enableOptionMenu(true);
    this.dpN = ((LinearLayout)findViewById(a.e.header_notice));
    this.dpO = ((LinearLayout)findViewById(a.e.room_notice_only_edit_by_owner_layout));
    this.dpH = ((MMEditText)findViewById(a.e.notice_content));
    this.dpI = ((TextView)findViewById(a.e.notice_publish_time));
    this.dpJ = ((TextView)findViewById(a.e.notice_editor_nickname));
    this.dpL = ((LinearLayout)findViewById(a.e.room_qr_code));
    this.dpK = ((ImageView)findViewById(a.e.notice_editor_avatar_iv));
    this.dpM = ((LinearLayout)findViewById(a.e.room_transfer));
    this.dpH.setText(this.dpC);
    Object localObject = (WindowManager)getSystemService("window");
    this.dpH.setMinHeight(((WindowManager)localObject).getDefaultDisplay().getHeight() * 2 / 3 - 100);
    j.b(this.dpH, Integer.valueOf(31));
    this.dpG = ((TextView)findViewById(a.e.left_word));
    this.dpG.setText(Integer.toString(com.tencent.mm.ui.tools.f.bi(280, this.dpC)));
    this.dpM.setVisibility(8);
    this.dpH.setCursorVisible(false);
    this.dpH.setFocusable(false);
    label357:
    String str;
    if ((!this.dpA) && (!this.dpB))
    {
      removeOptionMenu(0);
      this.dpO.setVisibility(0);
      this.dpH.setFocusable(false);
      this.dpH.setCursorVisible(false);
      this.dpH.setOnLongClickListener(new RoomCardUI.5(this));
      if (this.dpE == 0L) {
        break label553;
      }
      this.dpI.setVisibility(0);
      this.dpI.setText(com.tencent.mm.pluginsdk.f.h.g("yyyy-MM-dd HH:mm", this.dpE));
      if (!bk.bl(this.dpC)) {
        break label565;
      }
      this.dpH.setEnabled(true);
      this.dpH.setFocusableInTouchMode(true);
      this.dpH.setFocusable(true);
      this.dpN.setVisibility(8);
      this.dpH.setMinHeight(((WindowManager)localObject).getDefaultDisplay().getHeight() * 2 / 3 + 100);
      this.dpH.requestFocus();
      this.dpH.setCursorVisible(true);
      updateOptionMenuText(0, this.mController.uMN.getString(a.i.app_finish));
      xE();
      this.dpH.performClick();
      showVKB();
      label473:
      localObject = r.gV(this.dpD);
      this.dpJ.setText(j.a(this, (CharSequence)localObject, this.dpJ.getTextSize()));
      localObject = this.dpK;
      str = this.dpD;
      if (!bk.bl(str)) {
        break label576;
      }
      ((ImageView)localObject).setImageResource(a.d.default_avatar);
    }
    for (;;)
    {
      this.dpH.addTextChangedListener(new RoomCardUI.a(this, (byte)0));
      return;
      this.dpO.setVisibility(8);
      break;
      label553:
      this.dpI.setVisibility(8);
      break label357;
      label565:
      this.dpN.setVisibility(0);
      break label473;
      label576:
      a.b.a((ImageView)localObject, str);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 0L, 1L, true);
    g.DO().dJT.a(993, this);
    this.dpj = getIntent().getStringExtra("RoomInfo_Id");
    this.dpC = getIntent().getStringExtra("room_notice");
    this.dpD = getIntent().getStringExtra("room_notice_editor");
    this.dpE = getIntent().getLongExtra("room_notice_publish_time", 0L);
    this.dpx = getIntent().getStringExtra("room_name");
    this.dpy = getIntent().getIntExtra("room_member_count", 0);
    this.dpz = getIntent().getStringExtra("room_owner_name");
    this.dpA = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.dpB = getIntent().getBooleanExtra("Is_RoomManager", false);
    initView();
    setBackBtn(new RoomCardUI.8(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    g.DO().dJT.b(993, this);
    if ((this.dpF != null) && (this.dpF.isShowing())) {
      this.dpF.dismiss();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    super.onKeyDown(paramInt, paramKeyEvent);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      goBack();
      return true;
    }
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() == 993)
    {
      c(paramInt1, paramInt2, paramString);
      return;
    }
    y.w("MicroMsg.RoomInfoUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramm.getType()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI
 * JD-Core Version:    0.7.0.1
 */