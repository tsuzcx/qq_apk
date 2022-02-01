package com.tencent.mobileqq.testassister.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import jzc;
import jzd;
import jze;

public class ShareDumpMemoryActivity
  extends BaseActivity
{
  private static final String jdField_a_of_type_JavaLangString = "LeakInspector";
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c = "";
  
  public static ProgressDialog a(Context paramContext)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130841600);
    paramContext = new ProgressDialog(paramContext, 2131558902);
    paramContext.show();
    paramContext.getWindow().setContentView(2130903050);
    paramContext.setContentView(2130903050);
    ((TextView)paramContext.findViewById(2131296606)).setText(2131367620);
    ((ProgressBar)paramContext.findViewById(2131296605)).setIndeterminateDrawable(localDrawable);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(false);
    return paramContext;
  }
  
  private String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    this.c = "";
    localStringBuffer.append("以下对象存在内存泄露：");
    String[] arrayOfString = (String[])this.jdField_a_of_type_JavaUtilList.toArray(new String[this.jdField_a_of_type_JavaUtilList.size()]);
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      localStringBuffer.append("\n");
      localStringBuffer.append(str);
      this.c += str;
      this.c += "|";
      i += 1;
    }
    localStringBuffer.append("\n\n发现内存泄漏，请及时反馈。\n点击发送开始dump。\n文件路径:SD卡/tencent/MobileQQ/log\n时间：");
    localStringBuffer.append(new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss").format(new Date(System.currentTimeMillis())));
    return localStringBuffer.toString();
  }
  
  private void c()
  {
    Object localObject = getIntent();
    this.jdField_a_of_type_Boolean = ((Intent)localObject).getBooleanExtra("showWarningDialog", false);
    localObject = ((Intent)localObject).getStringExtra("suspiciousName");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        e();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a());
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void e()
  {
    Dialog localDialog = new Dialog(this, 2131558902);
    localDialog.setContentView(2130903211);
    TextView localTextView = (TextView)localDialog.findViewById(2131297367);
    if (localTextView != null) {
      localTextView.setText("内存泄露告警(内测)");
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localDialog.findViewById(2131296606));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a());
    }
    localTextView = (TextView)localDialog.findViewById(2131297370);
    if (localTextView != null)
    {
      localTextView.setText(2131365736);
      localTextView.setOnClickListener(new jzc(this, localDialog));
    }
    localTextView = (TextView)localDialog.findViewById(2131297371);
    if (localTextView != null)
    {
      localTextView.setText(2131368982);
      localTextView.setOnClickListener(new jzd(this, localDialog));
    }
    localDialog.show();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a()
  {
    try
    {
      Object localObject1 = new FileInfo(this.b);
      Object localObject2 = FileManagerUtil.a((FileInfo)localObject1);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(((FileManagerEntity)localObject2).nSessionId);
      localForwardFileInfo.d(3);
      localForwardFileInfo.b(10000);
      localForwardFileInfo.a(((FileInfo)localObject1).d());
      localForwardFileInfo.d(((FileInfo)localObject1).e());
      localForwardFileInfo.d(((FileInfo)localObject1).a());
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("forward_type", 0);
      ((Bundle)localObject1).putParcelable("fileinfo", localForwardFileInfo);
      ((Bundle)localObject1).putBoolean("not_forward", true);
      localObject2 = new Intent(this, ForwardRecentActivity.class);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtra("forward_text", localForwardFileInfo.d());
      ((Intent)localObject2).putExtra("forward_type", 0);
      startActivityForResult((Intent)localObject2, 103);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void b()
  {
    ProgressDialog localProgressDialog = a(this);
    new Timer().schedule(new jze(this, localProgressDialog), 100L);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      finish();
      return;
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Intent localIntent = new Intent(this, ChatActivity.class);
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903386);
    c();
    if (this.jdField_a_of_type_Boolean)
    {
      e();
      return true;
    }
    a();
    return false;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    c();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.testassister.activity.ShareDumpMemoryActivity
 * JD-Core Version:    0.7.0.1
 */