package com.tencent.mobileqq.activity.aio;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.FowardIntent;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class MessageShareActivity
  extends BaseActivity
  implements Handler.Callback, Runnable
{
  protected static final int a = 1;
  protected static final String a = "MessageShareActivity";
  protected static final int b = 2;
  protected static final int c = 3;
  protected Dialog a;
  protected Bundle a;
  protected final Handler a;
  
  public MessageShareActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsBundle = null;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      throw new IllegalArgumentException();
    }
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    super.doOnDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", -1);
      switch (i)
      {
      default: 
        break;
      case 2: 
      case 11: 
        long l = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
        paramMessage = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
        Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
        this.jdField_a_of_type_AndroidOsBundle.putLong("res_share_id", l);
        this.jdField_a_of_type_AndroidOsBundle.putString("res_pkg_name", paramMessage);
        this.jdField_a_of_type_AndroidOsBundle.putString("res_detail_url", (String)localObject);
        localObject = new FowardIntent(this, null, ChatActivity.class);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("force_not_modal", true);
        String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
        int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
        l = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
        paramMessage = "";
        switch (j)
        {
        }
        for (;;)
        {
          if (!paramMessage.equals("")) {
            ReportController.b(this.app, "CliOper", "", "", paramMessage, paramMessage, 0, 0, "", "", "", "");
          }
          if (i == 11)
          {
            paramMessage = new Intent();
            paramMessage.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(l), "shareToQQ" })));
            ((Intent)localObject).putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this, 0, paramMessage, 268435456));
          }
          paramMessage = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
          if (paramMessage != null)
          {
            if ((paramMessage instanceof StructMsgForImageShare)) {
              StructMsgForImageShare.sendAndUploadImageShare(this.app, (StructMsgForImageShare)paramMessage, str, j);
            }
            ((Intent)localObject).putExtra("stuctmsg_bytes", paramMessage.getBytes());
            ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
            startActivity((Intent)localObject);
          }
          finish();
          break;
          paramMessage = "0X800659A";
          continue;
          paramMessage = "0X800659C";
          continue;
          paramMessage = "0X800659B";
        }
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131298140)).setText("处理失败");
        this.jdField_a_of_type_AndroidAppDialog.findViewById(2131298139).setVisibility(4);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 800L);
        continue;
        finish();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(new View(this));
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558902);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903413);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131298140)).setText(2131368524);
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      handleMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1));
      return;
    }
    QLog.d("MessageShareActivity", 2, "getExtras() is null !!!!!");
    this.jdField_a_of_type_AndroidAppDialog.show();
    handleMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2));
  }
  
  public void run()
  {
    try
    {
      a();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 333L);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MessageShareActivity", 2, "doShare() cause exception !!!!!");
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 333L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MessageShareActivity
 * JD-Core Version:    0.7.0.1
 */