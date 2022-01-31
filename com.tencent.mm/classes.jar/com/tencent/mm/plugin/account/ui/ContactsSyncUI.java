package com.tencent.mm.plugin.account.ui;

import android.accounts.AccountAuthenticatorResponse;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import com.jg.JgClassChecked;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.model.b.a;
import com.tencent.mm.plugin.account.model.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public final class ContactsSyncUI
  extends MMActivity
{
  private AccountAuthenticatorResponse flg = null;
  Bundle flh = null;
  
  public final void finish()
  {
    if (this.flg != null)
    {
      if (this.flh == null) {
        break label35;
      }
      this.flg.onResult(this.flh);
    }
    for (;;)
    {
      this.flg = null;
      super.finish();
      return;
      label35:
      this.flg.onError(4, "canceled");
    }
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected final void initView()
  {
    boolean bool = false;
    g.DN();
    if ((!com.tencent.mm.kernel.a.Db()) || (com.tencent.mm.kernel.a.CW()))
    {
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
      finish();
      return;
    }
    if (getIntent() == null)
    {
      y.e("MicroMsg.ContactsSyncUI", "initView fail, intent is null");
      finish();
      return;
    }
    int i = t.a(getIntent(), "contact_sync_scene", -1);
    if ((getIntent().getAction() != null) && (getIntent().getAction().equalsIgnoreCase("com.tencent.mm.login.ACTION_LOGIN"))) {
      i = 4;
    }
    Object localObject;
    while (i == -1)
    {
      y.e("MicroMsg.ContactsSyncUI", "unkown scene, finish");
      finish();
      return;
      localObject = getIntent().resolveType(this);
      y.i("MicroMsg.ContactsSyncUI", "scheme = " + (String)localObject + ", action = " + getIntent().getAction());
      if (!bk.bl((String)localObject)) {
        if (((String)localObject).equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile")) {
          i = 2;
        } else if (((String)localObject).equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip")) {
          i = 12;
        } else if (((String)localObject).equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
          i = 13;
        } else if (((String)localObject).equals("vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline")) {
          i = 3;
        } else if (((String)localObject).equals("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.phonenum")) {
          i = 6;
        } else {
          i = -1;
        }
      }
    }
    switch (i)
    {
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    default: 
      localObject = null;
      label314:
      if (localObject != null) {
        switch (((b.a)localObject).bY(this))
        {
        }
      }
      break;
    }
    for (;;)
    {
      finish();
      return;
      localObject = getIntent().getData();
      localObject = new b.b(1, t.j(getIntent(), "k_phone_num"), (Uri)localObject);
      break label314;
      localObject = getIntent().getData();
      localObject = new b.b(3, t.j(getIntent(), "k_phone_num"), (Uri)localObject);
      break label314;
      localObject = getIntent().getData();
      localObject = new b.b(4, t.j(getIntent(), "k_phone_num"), (Uri)localObject);
      break label314;
      localObject = getIntent().getData();
      localObject = new b.b(2, t.j(getIntent(), "k_phone_num"), (Uri)localObject);
      break label314;
      localObject = getIntent().getParcelableExtra("accountAuthenticatorResponse");
      this.flg = null;
      if ((localObject != null) && ((localObject instanceof AccountAuthenticatorResponse))) {
        this.flg = ((AccountAuthenticatorResponse)localObject);
      }
      if (this.flg != null) {
        this.flg.onRequestContinued();
      }
      if (getSharedPreferences(ae.cqR(), 0).getBoolean("upload_contacts_already_displayed", false)) {
        break;
      }
      if (!t.a(getIntent(), "k_login_without_bind_mobile", false)) {}
      for (bool = true;; bool = false)
      {
        localObject = new ContactsSyncUI.a(this, bool);
        break;
      }
      localObject = getIntent().getParcelableExtra("accountAuthenticatorResponse");
      this.flg = null;
      if ((localObject != null) && ((localObject instanceof AccountAuthenticatorResponse))) {
        this.flg = ((AccountAuthenticatorResponse)localObject);
      }
      if (this.flg != null) {
        this.flg.onRequestContinued();
      }
      if (!t.a(getIntent(), "k_login_without_bind_mobile", false)) {
        bool = true;
      }
      localObject = new ContactsSyncUI.a(this, bool);
      break label314;
      localObject = getIntent();
      ((Intent)localObject).setClass(this, ContactsSyncUI.class);
      Intent localIntent = new Intent();
      localIntent.setClass(this, BindMContactIntroUI.class);
      localIntent.putExtra("key_upload_scene", 2);
      localIntent.putExtra("is_bind_for_contact_sync", true);
      MMWizardActivity.b(this, localIntent, (Intent)localObject);
      finish();
      continue;
      localObject = getIntent();
      ((Intent)localObject).setClass(this, ContactsSyncUI.class);
      localIntent = new Intent();
      localIntent.setClass(this, SimpleLoginUI.class);
      MMWizardActivity.b(this, localIntent, (Intent)localObject);
      finish();
      continue;
      localObject = getIntent();
      ((Intent)localObject).setClass(this, ContactsSyncUI.class);
      localIntent = new Intent();
      localIntent.setClass(this, SimpleLoginUI.class);
      localIntent.putExtra("accountAuthenticatorResponse", this.flg);
      MMWizardActivity.b(this, localIntent, (Intent)localObject);
      finish();
      continue;
      y.e("MicroMsg.ContactsSyncUI", "unkown scene, finish");
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle("");
    int i = t.a(getIntent(), "wizard_activity_result_code", 0);
    y.i("MicroMsg.ContactsSyncUI", "onCreate() resultCode[%d]", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      y.e("MicroMsg.ContactsSyncUI", "onCreate, should not reach here, resultCode = " + i);
      finish();
    }
    boolean bool;
    do
    {
      do
      {
        return;
        finish();
        return;
        bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null);
        y.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts read[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bk.csb() });
      } while (!bool);
      bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.WRITE_CONTACTS", 48, null, null);
      y.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts write[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bk.csb() });
    } while (!bool);
    initView();
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      if (paramArrayOfInt == null) {}
      for (int i = -1;; i = paramArrayOfInt.length)
      {
        y.w("MicroMsg.ContactsSyncUI", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bk.csb() });
        return;
      }
    }
    y.i("MicroMsg.ContactsSyncUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      paramArrayOfString = paramArrayOfString[0];
      new ah().post(new ContactsSyncUI.1(this, paramArrayOfString));
      return;
    }
    h.a(this, getString(q.j.permission_contacts_request_again_msg), getString(q.j.permission_tips_title), getString(q.j.jump_to_settings), getString(q.j.app_cancel), false, new ContactsSyncUI.2(this), new ContactsSyncUI.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ContactsSyncUI
 * JD-Core Version:    0.7.0.1
 */