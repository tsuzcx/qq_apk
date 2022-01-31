package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.mm.plugin.account.friend.a.f;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.plugin.account.friend.a.i.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.List;

public class FindMContactAddUI
  extends MMWizardActivity
{
  private ProgressDialog dnm = null;
  private String dqS = null;
  private f eBv = null;
  private TextView emptyTipTv = null;
  private String fcQ = "";
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
  private i.a fhu = new i.a()
  {
    public final void notifyDataSetChanged()
    {
      if ((FindMContactAddUI.e(FindMContactAddUI.this) != 2) && (FindMContactAddUI.e(FindMContactAddUI.this) == 1))
      {
        FindMContactAddUI.f(FindMContactAddUI.this).setText(FindMContactAddUI.this.getString(a.h.find_mcontact_add_all_continue));
        if (!FindMContactAddUI.c(FindMContactAddUI.this).WK()) {
          break label233;
        }
        if ((FindMContactAddUI.e(FindMContactAddUI.this) != 1) && (FindMContactAddUI.f(FindMContactAddUI.this).getVisibility() == 0) && (FindMContactAddUI.g(FindMContactAddUI.this) != null))
        {
          FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(8);
          FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(0);
        }
      }
      for (;;)
      {
        if ((FindMContactAddUI.c(FindMContactAddUI.this).getSelectCount() <= 0) || (FindMContactAddUI.e(FindMContactAddUI.this) == 1)) {
          break label295;
        }
        FindMContactAddUI.h(FindMContactAddUI.this).setText(FindMContactAddUI.this.getResources().getQuantityString(a.f.find_mcontact_already_add_count, FindMContactAddUI.c(FindMContactAddUI.this).getSelectCount(), new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).getSelectCount()) }));
        return;
        FindMContactAddUI.f(FindMContactAddUI.this).setText(FindMContactAddUI.this.getString(a.h.find_mcontact_add_all, new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).getCount()) }));
        break;
        label233:
        if ((FindMContactAddUI.e(FindMContactAddUI.this) != 1) && (FindMContactAddUI.f(FindMContactAddUI.this).getVisibility() == 8) && (FindMContactAddUI.g(FindMContactAddUI.this) != null))
        {
          FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(0);
          FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(8);
        }
      }
      label295:
      FindMContactAddUI.h(FindMContactAddUI.this).setText(FindMContactAddUI.this.getResources().getQuantityString(a.f.find_mcontact_wechat_friend, FindMContactAddUI.c(FindMContactAddUI.this).getCount(), new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).getCount()) }));
    }
  };
  
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
    this.dnm = h.b(localAppCompatActivity, getString(a.h.mobile_friend_loading), true, new FindMContactAddUI.1(this));
    g.DS().a(new FindMContactAddUI.6(this));
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
      this.fhn.setText(getString(a.h.find_mcontact_your_friend));
      this.fho.setText(getString(a.h.find_mcontact_your_friend_title));
      this.fhq.setText(getString(a.h.find_mcontact_add_all_continue));
    }
    for (;;)
    {
      this.fhk = new i(this, this.fhu, 1);
      this.fhq.setOnClickListener(new FindMContactAddUI.8(this));
      if (this.fhp != null)
      {
        this.fhp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(0);
            FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(8);
            FindMContactAddUI.c(FindMContactAddUI.this).cu(false);
            FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
          }
        });
        this.fhp.setVisibility(8);
      }
      this.fem.addHeaderView(this.fhl);
      this.fem.setAdapter(this.fhk);
      addTextOptionMenu(0, getString(a.h.app_nextstep), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          FindMContactAddUI.i(FindMContactAddUI.this);
          return true;
        }
      });
      new FindMContactAddUI.11(this);
      return;
      this.fhl = LayoutInflater.from(this).inflate(a.e.find_mcontact_header, null);
      this.fhm = ((TextView)this.fhl.findViewById(a.d.findmcontact_count));
      this.fhn = ((TextView)this.fhl.findViewById(a.d.findmcontact_tip));
      this.fho = ((TextView)this.fhl.findViewById(a.d.find_mcontact_title));
      this.fhq = ((Button)this.fhl.findViewById(a.d.find_mcontact_addall));
      this.fhn.setText(getString(a.h.find_mcontact_your_friend));
      this.fho.setText(getString(a.h.find_mcontact_your_friend_title));
      this.fhq.setText(getString(a.h.find_mcontact_add_all, new Object[] { Integer.valueOf(0) }));
      this.fhp = ((TextView)this.fhl.findViewById(a.d.mobile_all_unselect));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.h.find_mcontact_add_title);
    com.tencent.mm.plugin.account.a.a.eUS.tn();
    this.dqS = getIntent().getStringExtra("regsetinfo_ticket");
    this.fcQ = getIntent().getStringExtra("regsetinfo_NextStep");
    this.fcR = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.fhr = getIntent().getIntExtra("login_type", 0);
    this.fcX = com.tencent.mm.plugin.b.a.YA();
    initView();
  }
  
  public void onDestroy()
  {
    if (this.eBv != null)
    {
      g.Dk().b(30, this.eBv);
      this.eBv = null;
    }
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
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R300_300_QQ") + ",2");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_300_phone,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R300_300_phone") + ",2");
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.FindMContactAddUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
    h.a(this, getString(a.h.permission_contacts_request_again_msg), getString(a.h.permission_tips_title), getString(a.h.jump_to_settings), getString(a.h.app_cancel), false, new FindMContactAddUI.4(this), new FindMContactAddUI.5(this));
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
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R300_300_QQ") + ",1");
      com.tencent.mm.plugin.b.a.qi("R300_300_QQ");
    }
    for (;;)
    {
      if (this.fht)
      {
        boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null);
        y.i("MicroMsg.FindMContactAddUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bk.csb() });
        if (bool) {
          break;
        }
      }
      return;
      localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_300_phone,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R300_300_phone") + ",1");
      com.tencent.mm.plugin.b.a.qi("R300_300_phone");
    }
    Xp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI
 * JD-Core Version:    0.7.0.1
 */