package com.tencent.mm.plugin.account.ui;

import android.accounts.AccountAuthenticatorResponse;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.model.b.a;
import com.tencent.mm.plugin.account.model.b.b;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public final class ContactsSyncUI
  extends MMActivity
{
  private AccountAuthenticatorResponse kki = null;
  Bundle kkj = null;
  
  public final void finish()
  {
    AppMethodBeat.i(127904);
    if (this.kki != null)
    {
      if (this.kkj == null) {
        break label45;
      }
      this.kki.onResult(this.kkj);
    }
    for (;;)
    {
      this.kki = null;
      super.finish();
      AppMethodBeat.o(127904);
      return;
      label45:
      this.kki.onError(4, "canceled");
    }
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void initView()
  {
    boolean bool = true;
    AppMethodBeat.i(127903);
    g.aAf();
    if ((!com.tencent.mm.kernel.a.azo()) || (com.tencent.mm.kernel.a.azj()))
    {
      MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
      finish();
      AppMethodBeat.o(127903);
      return;
    }
    if (getIntent() == null)
    {
      Log.e("MicroMsg.ContactsSyncUI", "initView fail, intent is null");
      finish();
      AppMethodBeat.o(127903);
      return;
    }
    int i = IntentUtil.getIntExtra(getIntent(), "contact_sync_scene", -1);
    if ((getIntent().getAction() != null) && (getIntent().getAction().equalsIgnoreCase("com.tencent.mm.login.ACTION_LOGIN"))) {
      i = 4;
    }
    Object localObject;
    while (i == -1)
    {
      Log.e("MicroMsg.ContactsSyncUI", "unkown scene, finish");
      finish();
      AppMethodBeat.o(127903);
      return;
      localObject = getIntent().resolveType(this);
      Log.i("MicroMsg.ContactsSyncUI", "scheme = " + (String)localObject + ", action = " + getIntent().getAction());
      if (!Util.isNullOrNil((String)localObject)) {
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
      label334:
      if (localObject != null) {
        switch (((b.a)localObject).dC(this))
        {
        }
      }
      break;
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(127903);
      return;
      localObject = getIntent().getData();
      localObject = new b.b(1, IntentUtil.getStringExtra(getIntent(), "k_phone_num"), (Uri)localObject);
      break label334;
      localObject = getIntent().getData();
      localObject = new b.b(3, IntentUtil.getStringExtra(getIntent(), "k_phone_num"), (Uri)localObject);
      break label334;
      localObject = getIntent().getData();
      localObject = new b.b(4, IntentUtil.getStringExtra(getIntent(), "k_phone_num"), (Uri)localObject);
      break label334;
      localObject = getIntent().getData();
      localObject = new b.b(2, IntentUtil.getStringExtra(getIntent(), "k_phone_num"), (Uri)localObject);
      break label334;
      localObject = getIntent().getParcelableExtra("accountAuthenticatorResponse");
      this.kki = null;
      if ((localObject != null) && ((localObject instanceof AccountAuthenticatorResponse))) {
        this.kki = ((AccountAuthenticatorResponse)localObject);
      }
      if (this.kki != null) {
        this.kki.onRequestContinued();
      }
      if (getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("upload_contacts_already_displayed", false)) {
        break;
      }
      if (!IntentUtil.getBooleanExtra(getIntent(), "k_login_without_bind_mobile", false)) {}
      for (bool = true;; bool = false)
      {
        localObject = new a(bool);
        break;
      }
      localObject = getIntent().getParcelableExtra("accountAuthenticatorResponse");
      this.kki = null;
      if ((localObject != null) && ((localObject instanceof AccountAuthenticatorResponse))) {
        this.kki = ((AccountAuthenticatorResponse)localObject);
      }
      if (this.kki != null) {
        this.kki.onRequestContinued();
      }
      if (!IntentUtil.getBooleanExtra(getIntent(), "k_login_without_bind_mobile", false)) {}
      for (;;)
      {
        localObject = new a(bool);
        break;
        bool = false;
      }
      localObject = getIntent();
      ((Intent)localObject).setClass(this, ContactsSyncUI.class);
      Intent localIntent = new Intent();
      localIntent.setClass(this, BindMContactIntroUI.class);
      localIntent.putExtra("key_upload_scene", 2);
      localIntent.putExtra("bind_scene", 2);
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
      localIntent.putExtra("accountAuthenticatorResponse", this.kki);
      MMWizardActivity.b(this, localIntent, (Intent)localObject);
      finish();
      continue;
      AppMethodBeat.o(127903);
      return;
      Log.e("MicroMsg.ContactsSyncUI", "unkown scene, finish");
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127902);
    super.onCreate(paramBundle);
    setMMTitle("");
    int i = IntentUtil.getIntExtra(getIntent(), "wizard_activity_result_code", 0);
    Log.i("MicroMsg.ContactsSyncUI", "onCreate() resultCode[%d]", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      Log.e("MicroMsg.ContactsSyncUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(i)));
      finish();
      AppMethodBeat.o(127902);
      return;
    case 1: 
      finish();
      AppMethodBeat.o(127902);
      return;
    }
    boolean bool = b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    Log.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts read[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (!bool)
    {
      AppMethodBeat.o(127902);
      return;
    }
    bool = b.a(this, "android.permission.WRITE_CONTACTS", 48, null, null);
    Log.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts write[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (!bool)
    {
      AppMethodBeat.o(127902);
      return;
    }
    initView();
    AppMethodBeat.o(127902);
  }
  
  public final void onRequestPermissionsResult(int paramInt, final String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(127905);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.ContactsSyncUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(127905);
      return;
    }
    Log.i("MicroMsg.ContactsSyncUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127905);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        paramArrayOfString = paramArrayOfString[0];
        new MMHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(127892);
            ContactsSyncUI localContactsSyncUI = ContactsSyncUI.this;
            if (paramArrayOfString.equals("android.permission.READ_CONTACTS")) {}
            for (String str = "android.permission.WRITE_CONTACTS";; str = "android.permission.READ_CONTACTS")
            {
              boolean bool = b.a(localContactsSyncUI, str, 48, null, null);
              Log.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts [%b], oldPermission[%s], stack[%s]", new Object[] { Boolean.valueOf(bool), paramArrayOfString, Util.getStack() });
              if (bool) {
                ContactsSyncUI.this.initView();
              }
              AppMethodBeat.o(127892);
              return;
            }
          }
          
          public final String toString()
          {
            AppMethodBeat.i(127893);
            String str = super.toString() + "|checkContacts";
            AppMethodBeat.o(127893);
            return str;
          }
        });
        AppMethodBeat.o(127905);
        return;
      }
      h.a(this, getString(2131763866), getString(2131763890), getString(2131762043), getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(127894);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = ContactsSyncUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/ContactsSyncUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/ContactsSyncUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(127894);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(127895);
          paramAnonymousDialogInterface.dismiss();
          ContactsSyncUI.this.finish();
          AppMethodBeat.o(127895);
        }
      });
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements b.a
  {
    private boolean kkm;
    private t.a kkn;
    
    public a(boolean paramBoolean)
    {
      AppMethodBeat.i(127899);
      this.kkn = new t.a()
      {
        public final void D(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(127896);
          ContactsSyncUI localContactsSyncUI = ContactsSyncUI.this;
          localContactsSyncUI.kkj = paramAnonymousBundle;
          localContactsSyncUI.finish();
          AppMethodBeat.o(127896);
        }
      };
      this.kkm = paramBoolean;
      AppMethodBeat.o(127899);
    }
    
    final int W(Context paramContext, String paramString)
    {
      AppMethodBeat.i(127901);
      if (paramContext == null)
      {
        AppMethodBeat.o(127901);
        return 1;
      }
      int i = t.a(paramContext, paramString, this.kkn);
      if (i == 2)
      {
        Toast.makeText(paramContext, ContactsSyncUI.this.getString(2131758174), 1).show();
        AppMethodBeat.o(127901);
        return 1;
      }
      if (i == 3)
      {
        Toast.makeText(paramContext, ContactsSyncUI.this.getString(2131758173), 1).show();
        AppMethodBeat.o(127901);
        return 1;
      }
      AppMethodBeat.o(127901);
      return 0;
    }
    
    public final int dC(final Context paramContext)
    {
      AppMethodBeat.i(127900);
      g.aAf();
      if ((!com.tencent.mm.kernel.a.azo()) || (com.tencent.mm.kernel.a.azj()))
      {
        AppMethodBeat.o(127900);
        return 4;
      }
      if (!this.kkm)
      {
        Log.i("MicroMsg.ProcessorAddAccount", "no need to bind mobile");
        t.a(ContactsSyncUI.this, this.kkn);
        AppMethodBeat.o(127900);
        return 0;
      }
      final String str = (String)g.aAh().azQ().get(6, "");
      if (Util.isNullOrNil(str))
      {
        Log.e("MicroMsg.ProcessorAddAccount", "not bind mobile phone");
        AppMethodBeat.o(127900);
        return 2;
      }
      if (l.bnY())
      {
        h.a(paramContext, 2131758172, 2131755998, 2131755921, 2131755761, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(127897);
            l.gl(true);
            ContactsSyncUI.this.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
            ContactsSyncUI.a.this.W(paramContext, str);
            if ((paramContext instanceof Activity)) {
              ((Activity)paramContext).finish();
            }
            AppMethodBeat.o(127897);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(127898);
            l.gl(false);
            ContactsSyncUI.this.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
            if ((paramContext instanceof Activity)) {
              ((Activity)paramContext).finish();
            }
            AppMethodBeat.o(127898);
          }
        });
        AppMethodBeat.o(127900);
        return 5;
      }
      int i = W(paramContext, str);
      AppMethodBeat.o(127900);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ContactsSyncUI
 * JD-Core Version:    0.7.0.1
 */