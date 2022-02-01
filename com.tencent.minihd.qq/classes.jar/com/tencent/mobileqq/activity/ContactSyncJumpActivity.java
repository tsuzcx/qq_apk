package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.contactsync.SimplePhoneContact;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import dri;
import drj;
import drk;
import drl;
import drm;
import java.util.ArrayList;

public class ContactSyncJumpActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a = "key_req_by_contact_sync";
  public static final String b = "key_uin_to_login";
  private static final int c = 1000;
  public static final String c = "key_req_from_switch_account";
  private static final int d = 4;
  public static final String d = "key_req_from_lock_screen";
  private static final int e = 0;
  public static final String e = "key_orginal_intent";
  private static final int f = 1;
  public static final String f = "key_change";
  private static final int jdField_g_of_type_Int = 2;
  private static final String jdField_g_of_type_JavaLangString = "ContactSync.JumpActivity";
  public int a;
  public Dialog a;
  private DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new drl(this);
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new dri(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new drk(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new drj(this);
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  private ContactSyncManager jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new drm(this);
  private int b;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  
  public ContactSyncJumpActivity()
  {
    this.jdField_a_of_type_AndroidAppDialog = null;
  }
  
  private Dialog a()
  {
    Dialog localDialog = new Dialog(this, 2131558902);
    localDialog.setContentView(2130903863);
    Object localObject2 = (ImageView)localDialog.findViewById(2131299855);
    if (this.k.equals("0")) {}
    for (Object localObject1 = FaceDrawable.a(this.app, 11, this.i + this.j);; localObject1 = FaceDrawable.a(this.app, 1, this.k))
    {
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      Object localObject3 = (TextView)localDialog.findViewById(2131299856);
      localObject1 = (TextView)localDialog.findViewById(2131299857);
      TextView localTextView = (TextView)localDialog.findViewById(2131299853);
      localObject2 = (TextView)localDialog.findViewById(2131299854);
      ((TextView)localObject3).setText(this.l);
      localTextView.setText(2131369288);
      localTextView.setOnClickListener(this);
      ((TextView)localObject2).setText(String.format(getResources().getString(2131369296), new Object[] { "" }));
      if (!NetworkUtil.e(this)) {
        break;
      }
      localObject3 = getResources().getDrawable(2130838136);
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject3, null, null, null);
      ((TextView)localObject1).setCompoundDrawablePadding(10);
      ((Animatable)localObject3).start();
      ((TextView)localObject2).setOnClickListener(this);
      return localDialog;
    }
    ((TextView)localObject1).setText(2131369298);
    ((TextView)localObject2).setTextColor(getResources().getColor(2131427486));
    ((TextView)localObject2).setEnabled(false);
    return localDialog;
  }
  
  private Dialog a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Dialog localDialog = new Dialog(this, 2131558902);
    localDialog.setContentView(2130903862);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131299851);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131299852);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131299853);
    TextView localTextView4 = (TextView)localDialog.findViewById(2131299854);
    localTextView1.setText(paramInt1);
    localTextView2.setText(paramString);
    if (paramInt2 == 0) {
      localTextView3.setVisibility(8);
    }
    for (;;)
    {
      localTextView4.setText(paramInt3);
      localTextView3.setOnClickListener(this);
      localTextView4.setOnClickListener(this);
      return localDialog;
      localTextView3.setText(paramInt2);
    }
  }
  
  private void a()
  {
    ReportController.b(this.app, "CliOper", "", "", "System_contact", "Contact_msg", 0, 0, "", "", "", "");
    if (!this.k.equals("0"))
    {
      localIntent = new Intent(this, ChatActivity.class);
      localIntent.putExtra("uin", this.k);
      localObject = (FriendManager)this.app.getManager(8);
      if (localObject != null)
      {
        localObject = ((FriendManager)localObject).c(this.k);
        if (localObject != null)
        {
          localIntent.putExtra("cSpecialFlag", ((Friends)localObject).cSpecialFlag);
          localIntent.putExtra("uinname", ContactUtils.a((Friends)localObject));
          if (((Friends)localObject).cSpecialFlag == 1)
          {
            localIntent.setClass(this, ChatActivity.class);
            localIntent.putExtra("chat_subType", 1);
          }
        }
      }
      localIntent.putExtra("entrance", 0);
      localIntent.putExtra("uintype", 0);
      localIntent.putExtra("key_req_by_contact_sync", true);
      localIntent.addFlags(268435456);
      startActivity(localIntent);
      finish();
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("entrance", 0);
    localIntent.putExtra("uin", this.i + this.j);
    localIntent.putExtra("uintype", 1006);
    localIntent.putExtra("uinname", this.l);
    Object localObject = new ProfileActivity.AllInOne(this.i + this.j, 31);
    ((ProfileActivity.AllInOne)localObject).a = new ArrayList();
    ((ProfileActivity.AllInOne)localObject).k = this.l;
    ((ProfileActivity.AllInOne)localObject).a.add(new ProfileActivity.CardContactInfo(this.l, this.j, this.i));
    ((ProfileActivity.AllInOne)localObject).d = this.b;
    ((ProfileActivity.AllInOne)localObject).g = 59;
    localIntent.putExtra("AIO_INFO", (Parcelable)localObject);
    localIntent.putExtra("key_req_by_contact_sync", true);
    localIntent.addFlags(67108864);
    localIntent.addFlags(268435456);
    startActivity(localIntent);
    finish();
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.JumpActivity", 2, "showAlertDialog | type = " + paramInt + " | current type = " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null)
      {
        this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      return;
      this.jdField_a_of_type_AndroidAppDialog = a(2131369284, paramString, 2131369288, 2131369289);
      continue;
      this.jdField_a_of_type_AndroidAppDialog = a(2131369291, paramString, 0, 2131369293);
      continue;
      this.jdField_a_of_type_AndroidAppDialog = a();
    }
  }
  
  private boolean a(int paramInt)
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a();
    String str3 = this.app.a();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.JumpActivity", 2, "dealWithUnbind | syncUin = " + ContactSyncManager.b(str2) + " | loginUin = " + ContactSyncManager.b(str3) + " | bindState = " + paramInt);
    }
    if ((paramInt == 2) || (paramInt == 1) || (paramInt == 0)) {}
    for (String str1 = getResources().getString(2131369285);; str1 = getResources().getString(2131369286))
    {
      a(0, String.format(str1, new Object[] { ContactSyncManager.d(str3), ContactSyncManager.d(str2) }));
      return true;
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject = getIntent();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.JumpActivity", 2, "doJump | intent = " + localObject);
    }
    if (localObject != null) {
      try
      {
        if ((!TextUtils.isEmpty(((Intent)localObject).getAction())) || (((Intent)localObject).getBooleanExtra("key_req_from_switch_account", false)) || (((Intent)localObject).getBooleanExtra("key_req_from_lock_screen", false))) {
          if (((Intent)localObject).getBooleanExtra("key_req_from_switch_account", false))
          {
            if (!((Intent)localObject).getBooleanExtra("key_change", false))
            {
              finish();
              return false;
            }
            localObject = getIntent().getParcelableExtra("key_orginal_intent");
            if ((localObject == null) || (!(localObject instanceof Intent)))
            {
              finish();
              return false;
            }
            setIntent((Intent)localObject);
          }
        }
        while ((paramBoolean) && (!this.app.isLogin()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.JumpActivity", 2, "doJump | check user is not login");
          }
          localObject = new Intent(this, LoginActivity.class);
          ((Intent)localObject).putExtra("key_req_by_contact_sync", true);
          ((Intent)localObject).putExtra("key_orginal_intent", getIntent());
          ((Intent)localObject).addFlags(67108864);
          ((Intent)localObject).addFlags(536870912);
          startActivity((Intent)localObject);
          finish();
          return false;
          if (((Intent)localObject).getBooleanExtra("key_req_from_lock_screen", false))
          {
            localObject = getIntent().getParcelableExtra("key_orginal_intent");
            if ((localObject == null) || (!(localObject instanceof Intent)))
            {
              finish();
              return false;
            }
            setIntent((Intent)localObject);
            continue;
            return false;
          }
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "doJump", localException1);
        }
      }
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.a())) && (!GesturePWDUtils.getAppForground(this)))
    {
      Intent localIntent = new Intent(this, GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_req_by_contact_sync", true);
      localIntent.putExtra("key_orginal_intent", getIntent());
      startActivity(localIntent);
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(10));
    this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager = ((ContactSyncManager)this.app.getManager(40));
    int n;
    String str;
    try
    {
      this.m = this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a(getIntent().getData());
      if ((this.m == null) || ((!this.m.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.zchat")) && (!this.m.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.voicecall.profile"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "doJump | error mimeType = " + this.m);
        }
        finish();
        return false;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "doJump | e = ", localException2);
        }
      }
      this.h = this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.b(getIntent().getData());
      n = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
      str = this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a();
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.JumpActivity", 2, "doJump | check user is login | bind state is " + n + " | currentUin = " + ContactSyncManager.b(this.app.a()) + " | syncUin = " + ContactSyncManager.b(str));
      }
      if (n != 0) {
        break label657;
      }
    }
    if (str.equals(this.app.a())) {
      return b();
    }
    for (;;)
    {
      return a(n);
      label657:
      do
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.g()) || (str.equals(this.app.a()))) {
          return b();
        }
        paramBoolean = a(n);
        return paramBoolean;
        if ((n == 2) || (n == 1)) {
          break;
        }
      } while (n != 0);
    }
  }
  
  private void b()
  {
    String str;
    if (!this.k.equals("0"))
    {
      n = 1;
      QQAppInterface localQQAppInterface = this.app;
      if (n == 0) {
        break label123;
      }
      str = "0";
      label26:
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "16", str, "", "");
      if (n == 0) {
        break label130;
      }
    }
    label130:
    for (int n = 0;; n = 1006)
    {
      str = this.i + this.j;
      if (ChatActivityUtils.a(this.app, this, n, this.k, this.l, str, true, null, true, true, this.jdField_a_of_type_AndroidOsHandler$Callback, null)) {
        finish();
      }
      return;
      n = 0;
      break;
      label123:
      str = "3";
      break label26;
    }
  }
  
  private boolean b()
  {
    boolean bool2 = true;
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    Uri localUri = getIntent().getData();
    if (!TextUtils.isEmpty(this.h)) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this.h);; localObject = null)
    {
      boolean bool1;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("dealWithBindOK | getTargetPhoneContact | uri = ").append(localUri).append(" | mobileNo = ").append(ContactSyncManager.c(this.h)).append(" | pc = ");
        if (localObject != null)
        {
          bool1 = true;
          QLog.d("ContactSync.JumpActivity", 2, bool1);
        }
      }
      else
      {
        if (localObject == null) {
          break label215;
        }
        this.k = ((PhoneContact)localObject).uin;
        this.i = ((PhoneContact)localObject).nationCode;
        this.j = ((PhoneContact)localObject).mobileCode;
        this.l = ((PhoneContact)localObject).name;
        this.b = ((PhoneContact)localObject).ability;
        label157:
        if (((TextUtils.isEmpty(this.k)) || (this.k.equals("0"))) && (TextUtils.isEmpty(this.j))) {
          break label371;
        }
        if (!this.m.equals("vnd.android.cursor.item/vnd.com.tencent.mobileqq.zchat")) {
          break label302;
        }
        a();
        bool1 = false;
      }
      label215:
      do
      {
        return bool1;
        bool1 = false;
        break;
        localObject = this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a(localUri);
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.JumpActivity", 2, "dealWithBindOK | pc is null | simplePc = " + localObject);
        }
        if (localObject == null) {
          break label157;
        }
        this.k = "0";
        this.i = ((SimplePhoneContact)localObject).b;
        this.j = ((SimplePhoneContact)localObject).c;
        this.l = ((SimplePhoneContact)localObject).jdField_a_of_type_JavaLangString;
        this.b = ((SimplePhoneContact)localObject).jdField_a_of_type_Int;
        break label157;
        a(2, null);
        bool1 = bool2;
      } while (!NetworkUtil.e(this));
      label302:
      localObject = (FriendListHandler)this.app.a(1);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      ((FriendListHandler)localObject).c(this.i + this.j, true);
      return true;
      label371:
      localObject = String.format(getResources().getString(2131369292), new Object[] { this.l });
      this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a(this.h);
      a(1, (String)localObject);
      return true;
    }
  }
  
  public boolean a()
  {
    return ((KeyguardManager)getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(new ListView(this));
    return a(true);
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    setIntent(paramIntent);
    a(true);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    finish();
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131299853: 
      do
      {
        return;
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
          finish();
          return;
        }
      } while (this.jdField_a_of_type_Int != 2);
      finish();
      return;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      paramView = new Intent();
      paramView.setPackage(getPackageName());
      paramView.setClass(this, LoginActivity.class);
      paramView.putExtra("IS_ADD_ACCOUNT", true);
      paramView.putExtra("key_req_by_contact_sync", true);
      paramView.putExtra("key_uin_to_login", this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager.a());
      paramView.putExtra("key_orginal_intent", getIntent());
      paramView.addFlags(67108864);
      paramView.addFlags(536870912);
      startActivity(paramView);
      finish();
      return;
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      b();
      return;
    }
    finish();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactSyncJumpActivity
 * JD-Core Version:    0.7.0.1
 */