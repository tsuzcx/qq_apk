package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.s;

public class BindFacebookUI
  extends MMWizardActivity
  implements f
{
  private c fjx;
  private ProgressDialog flc;
  private DialogInterface.OnCancelListener fld;
  private v fle;
  
  protected final int getLayoutId()
  {
    return q.g.bindfacebook;
  }
  
  protected final void initView()
  {
    this.fjx = new c("290293790992170");
    this.fld = new BindFacebookUI.1(this);
    addTextOptionMenu(0, getString(q.j.app_ignore_it), new BindFacebookUI.2(this));
    setMMTitle(q.j.bind_facebook_start_title);
    Object localObject = (TextView)findViewById(q.f.setting_bind_facebook_hint);
    ((TextView)localObject).setVisibility(4);
    ((TextView)localObject).setText(q.j.bind_facebook_start_hint);
    localObject = (Button)findViewById(q.f.bind_facebook_start_btn);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new BindFacebookUI.3(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    com.tencent.mm.kernel.g.Dk().b(183, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    com.tencent.mm.kernel.g.Dk().a(183, this);
    initView();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() != 183) {}
    do
    {
      return;
      if (this.flc != null) {
        this.flc.dismiss();
      }
    } while (a.eUS.a(this.mController.uMN, paramInt1, paramInt2, paramString));
    int i = ((v)paramm).opType;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (i == 1)
      {
        ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abu("facebookapp");
        ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HG("facebookapp");
      }
      FW(1);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -67))
    {
      Toast.makeText(this, q.j.facebook_auth_have_bind_facebook, 1).show();
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -5))
    {
      if (i == 1) {}
      for (paramInt1 = q.j.facebook_auth_bind_access_denied;; paramInt1 = q.j.facebook_auth_unbind_access_denied)
      {
        Toast.makeText(this, paramInt1, 1).show();
        return;
      }
    }
    if (i == 0) {}
    for (paramInt1 = q.j.contact_info_facebookapp_unbind_fail;; paramInt1 = q.j.contact_info_facebookapp_bind_fail)
    {
      Toast.makeText(this, paramInt1, 1).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BindFacebookUI
 * JD-Core Version:    0.7.0.1
 */