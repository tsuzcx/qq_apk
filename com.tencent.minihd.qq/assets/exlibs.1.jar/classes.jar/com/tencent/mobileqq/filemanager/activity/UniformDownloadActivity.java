package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import ilb;
import ild;
import ile;

public class UniformDownloadActivity
  extends BaseActivity
{
  public static String a;
  public static String b = "URL";
  public static String c = "buttonType";
  public static String d = "filename";
  public static String e = "filesize";
  public static String f = "filetype";
  public static String g = "iconpath";
  public static String h = "filememo";
  private long jdField_a_of_type_Long = 0L;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public QQAppInterface a;
  private String i = null;
  private String j = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloadActivity<FileAssistant>";
  }
  
  private void a()
  {
    ReportController.b(null, "P_CliOper", "webview", "", "webview_apk_download", "download_click", 0, 1, 0, "", "", "", "");
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", this.j);
    localBundle.putLong("_filesize_from_dlg", this.jdField_a_of_type_Long);
    UniformDownloadMgr.a().b(this.i, localBundle);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "[UniformDL]. >>> downloadFile. url:" + this.i);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903774);
    paramBundle = (TextView)findViewById(2131299567);
    Object localObject = (TextView)findViewById(2131299568);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299560));
    if (localObject != null)
    {
      if (getIntent().getLongExtra(c, 0L) == 1L) {
        ((TextView)localObject).setText(2131367512);
      }
      ((TextView)localObject).setOnClickListener(new ilb(this));
    }
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new ild(this));
    }
    Intent localIntent = getIntent();
    this.i = localIntent.getStringExtra(b);
    this.j = localIntent.getStringExtra(d);
    this.jdField_a_of_type_Long = localIntent.getLongExtra(e, 0L);
    TextView localTextView1 = (TextView)findViewById(2131299563);
    TextView localTextView2 = (TextView)findViewById(2131299564);
    ImageView localImageView = (ImageView)findViewById(2131299561);
    localObject = localIntent.getStringExtra(h);
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = this.j;
    }
    localTextView1.setText(paramBundle);
    localTextView2.setText(FileUtil.a(this.jdField_a_of_type_Long));
    int k = FileManagerUtil.b(this.j);
    paramBundle = localIntent.getStringExtra(g);
    if (k != 0) {
      localImageView.setImageResource(k);
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        paramBundle = URLDrawable.getDrawable(paramBundle);
        paramBundle.setURLDrawableListener(new ile(this, localImageView));
        localImageView.setImageDrawable(paramBundle);
      }
      return true;
      localImageView.setImageResource(2130839691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity
 * JD-Core Version:    0.7.0.1
 */