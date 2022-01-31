package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.plugin.account.friend.a.i.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.List;

public class FindMContactInviteUI
  extends MMWizardActivity
{
  private ProgressDialog dnm = null;
  private f eBv = null;
  private TextView emptyTipTv = null;
  private int fcR = 2;
  private String fcX;
  private ListView fem;
  private i fhk;
  private View fhl;
  private TextView fhm = null;
  private TextView fhn = null;
  private TextView fho = null;
  private TextView fhp = null;
  private Button fhq = null;
  private int fhr;
  private List<String[]> fhs;
  private boolean fht = true;
  private i.a fhu = new FindMContactInviteUI.6(this);
  private String fhw = null;
  
  private void Wc()
  {
    com.tencent.mm.plugin.b.a.qj(this.fcX);
    XM();
    FW(1);
  }
  
  private void Xp()
  {
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    getString(a.h.app_tip);
    this.dnm = h.b(localAppCompatActivity, getString(a.h.mobile_friend_loading), true, new FindMContactInviteUI.1(this));
    g.DS().a(new FindMContactInviteUI.5(this));
  }
  
  protected final int getLayoutId()
  {
    return a.e.find_mcontact_add;
  }
  
  protected final void initView()
  {
    this.emptyTipTv = ((TextView)findViewById(a.d.mobile_friend_empty_msg_tip_tv));
    this.emptyTipTv.setText(a.h.mobile_friend_empty_qmsg_tip);
    this.fem = ((ListView)findViewById(a.d.mobile_friend_lv));
    if ((this.fcR != 2) && (this.fcR == 1))
    {
      this.fhl = LayoutInflater.from(this).inflate(a.e.find_mcontact_header_style_two, null);
      this.fhm = ((TextView)this.fhl.findViewById(a.d.findmcontact_count));
      this.fhn = ((TextView)this.fhl.findViewById(a.d.findmcontact_tip));
      this.fho = ((TextView)this.fhl.findViewById(a.d.find_mcontact_title));
      this.fhq = ((Button)this.fhl.findViewById(a.d.find_mcontact_addall));
      this.fhn.setText(getString(a.h.find_mcontact_invite_friend));
      this.fho.setText(getString(a.h.find_mcontact_invite_friend));
      this.fhq.setText(getString(a.h.find_mcontact_invite_all_continue));
    }
    for (;;)
    {
      this.fhk = new i(this, this.fhu, 2);
      this.fhq.setOnClickListener(new FindMContactInviteUI.7(this));
      if (this.fhp != null)
      {
        this.fhp.setOnClickListener(new FindMContactInviteUI.8(this));
        this.fhp.setVisibility(8);
      }
      this.fem.addHeaderView(this.fhl);
      this.fem.setAdapter(this.fhk);
      this.fem.setOnScrollListener(new com.tencent.mm.ui.applet.a());
      this.fem.setOnTouchListener(new FindMContactInviteUI.9(this));
      addTextOptionMenu(0, getString(a.h.app_finish), new FindMContactInviteUI.10(this));
      new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          BackwardSupportUtil.c.a(FindMContactInviteUI.i(FindMContactInviteUI.this));
        }
      };
      return;
      this.fhl = LayoutInflater.from(this).inflate(a.e.find_mcontact_header, null);
      this.fhm = ((TextView)this.fhl.findViewById(a.d.findmcontact_count));
      this.fhn = ((TextView)this.fhl.findViewById(a.d.findmcontact_tip));
      this.fho = ((TextView)this.fhl.findViewById(a.d.find_mcontact_title));
      this.fhq = ((Button)this.fhl.findViewById(a.d.find_mcontact_addall));
      this.fhn.setText(getString(a.h.find_mcontact_invite_your_friend));
      this.fho.setText(getString(a.h.find_mcontact_invite_friend));
      this.fhq.setText(getString(a.h.find_mcontact_invite_all, new Object[] { Integer.valueOf(0) }));
      this.fhp = ((TextView)this.fhl.findViewById(a.d.mobile_all_unselect));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.h.find_mcontact_invite_title);
    com.tencent.mm.plugin.account.a.a.eUS.tn();
    this.fhw = getIntent().getStringExtra("regsetinfo_ticket");
    this.fhr = getIntent().getIntExtra("login_type", 0);
    this.fcR = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.fcX = com.tencent.mm.plugin.b.a.YA();
    initView();
  }
  
  public void onDestroy()
  {
    if (this.eBv != null)
    {
      g.Dk().b(432, this.eBv);
      this.eBv = null;
    }
    if (this.fhk != null)
    {
      i locali = this.fhk;
      if (locali.ffG != null)
      {
        locali.ffG.detach();
        locali.ffG = null;
      }
    }
    ((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).clearFriendData();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Wc();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.fhr == 1)
    {
      localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R300_400_QQ") + ",2");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_400_phone,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R300_400_phone") + ",2");
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.FindMContactInviteUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      Xp();
      return;
    }
    this.fht = false;
    h.a(this, getString(a.h.permission_contacts_request_again_msg), getString(a.h.permission_tips_title), getString(a.h.jump_to_settings), getString(a.h.app_cancel), false, new FindMContactInviteUI.3(this), new FindMContactInviteUI.4(this));
  }
  
  protected void onResume()
  {
    super.onResume();
    this.fhk.notifyDataSetChanged();
    StringBuilder localStringBuilder;
    if (this.fhr == 1)
    {
      localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R300_400_QQ") + ",1");
    }
    for (;;)
    {
      if (this.fht)
      {
        boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null);
        y.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bk.csb() });
        if (bool) {
          break;
        }
      }
      return;
      localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_400_phone,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R300_400_phone") + ",1");
    }
    Xp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI
 * JD-Core Version:    0.7.0.1
 */