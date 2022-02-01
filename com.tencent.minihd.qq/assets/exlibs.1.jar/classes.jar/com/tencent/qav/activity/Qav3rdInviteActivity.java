package com.tencent.qav.activity;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qav.QavSDK;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.bussiness.QavBussinessObserver;
import com.tencent.qav.ipc.QavCallbackWrapper;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.session.QavSession;
import com.tencent.qav.thread.ThreadManager;
import lid;
import lie;
import lif;

public class Qav3rdInviteActivity
  extends Activity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "QavInviteActivity";
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QavBussinessCtrl jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl;
  private QavBussinessObserver jdField_a_of_type_ComTencentQavBussinessQavBussinessObserver = new lid(this);
  private QavSession jdField_a_of_type_ComTencentQavSessionQavSession;
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private TextView c;
  
  private void a()
  {
    View localView = getLayoutInflater().inflate(2130903445, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298278));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298279));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298280));
    this.c = ((TextView)localView.findViewById(2131298281));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131298284));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131298283));
    Object localObject = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a().a(0, this.jdField_b_of_type_JavaLangString);
    String str = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a().a(0, this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2131363231;; i = 2131363232)
    {
      ((TextView)localObject).setText(i);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidAppDialog = new AlertDialog.Builder(this).setView(localView).create();
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new lie(this));
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    QavSession localQavSession = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
    if ((localQavSession != null) && (localQavSession != this.jdField_a_of_type_ComTencentQavSessionQavSession))
    {
      if (!localQavSession.b()) {
        break label63;
      }
      this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a(String.valueOf(localQavSession.a), 23);
    }
    for (;;)
    {
      ThreadManager.executeOnSubThreadDelay(new lif(this, paramBoolean), 1000L);
      b();
      return;
      label63:
      this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.b(String.valueOf(localQavSession.a), 0);
    }
  }
  
  private boolean a()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("key_peer_uin");
      this.jdField_a_of_type_Boolean = ((Intent)localObject).getBooleanExtra("key_only_audio", true);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = QavSession.a(3, Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue());
      localObject = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a((String)localObject);
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentQavSessionQavSession = ((QavSession)localObject);
        a();
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a(this.jdField_b_of_type_JavaLangString, 1);
    b();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298284: 
      a(this.jdField_a_of_type_Boolean);
      return;
    }
    c();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().addFlags(2097152);
    getWindow().addFlags(128);
    getWindow().addFlags(1024);
    getWindow().setBackgroundDrawableResource(2131427375);
    this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl = QavBussinessCtrl.a();
    QavSDK.getInstance().addObserver(this.jdField_a_of_type_ComTencentQavBussinessQavBussinessObserver);
    if (!a())
    {
      AVLog.e("QavInviteActivity", "onCreate invalid params.");
      finish();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl = null;
    QavSDK.getInstance().removeObserver(this.jdField_a_of_type_ComTencentQavBussinessQavBussinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.activity.Qav3rdInviteActivity
 * JD-Core Version:    0.7.0.1
 */