package com.tencent.mobileqq.activity.photo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Messenger;
import android.os.RemoteException;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import gth;
import gti;
import gtk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class SendPhotoActivity
  extends BaseActivity
{
  public static final int a = 1;
  public static final String a;
  public static final int b = 2;
  private long jdField_a_of_type_Long;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private Handler jdField_a_of_type_AndroidOsHandler = new gtk(this);
  Messenger jdField_a_of_type_AndroidOsMessenger;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ArrayList a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  public ArrayList b;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private ArrayList jdField_c_of_type_JavaUtilArrayList;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private ArrayList jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = SendPhotoActivity.class.getName();
  }
  
  public SendPhotoActivity()
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", -1);
    if (i != -1)
    {
      paramIntent = new ArrayList(Arrays.asList(new String[this.jdField_b_of_type_JavaUtilArrayList.size()]));
      Collections.copy(paramIntent, this.jdField_b_of_type_JavaUtilArrayList);
      PhotoUtils.a(this.app, i, paramIntent);
    }
  }
  
  private void a(PicReq paramPicReq)
  {
    int i = -1;
    PicBusiManager.a(paramPicReq, this.app);
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet() == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.intValue())
    {
      Logger.b("PIC_TAG_COST", "launch req ", "time cost:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
      b();
      paramPicReq = getIntent();
      a(paramPicReq);
    }
    try
    {
      String[] arrayOfString = new String[this.jdField_a_of_type_JavaUtilArrayList.size()];
      this.jdField_a_of_type_JavaUtilArrayList.toArray(arrayOfString);
      if (this.jdField_c_of_type_Boolean) {
        i = paramPicReq.getIntExtra("forward_source_uin_type", -1);
      }
      StatisticConstants.a(arrayOfString, this.jdField_d_of_type_Int, this.jdField_c_of_type_Boolean, i, this.app);
    }
    catch (Exception localException)
    {
      label126:
      break label126;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new gti(this, paramPicReq));
  }
  
  private boolean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = new String[10];
      arrayOfString[0] = "download";
      arrayOfString[1] = "weibo";
      arrayOfString[2] = "save";
      arrayOfString[3] = "faceq";
      arrayOfString[4] = "newsreader";
      arrayOfString[5] = "tieba";
      arrayOfString[6] = "news_article";
      arrayOfString[7] = "sohunewsdown";
      arrayOfString[8] = "pins";
      arrayOfString[9] = "tumblr";
      int i = 0;
      while (i < arrayOfString.length)
      {
        if (paramString.contains(arrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private void b()
  {
    String str1 = AppConstants.aG + "photo/" + ".nomedia";
    String str2 = AppConstants.aG + "thumb/" + ".nomedia";
    String str3 = AppConstants.aG + "thumb2/" + ".nomedia";
    FileUtils.b(str1);
    FileUtils.b(str2);
    FileUtils.b(str3);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "TestPicSend finish compress,currentTime = " + System.currentTimeMillis());
    }
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        a();
      }
      while (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131558902);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903413);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131298140));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.b("PIC_TAG_ERROR", "SendPhotoActivity.showProgressDialog", localThrowable.toString());
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!FileUtils.a(this)) {}
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("PhotoConst.IS_FORWARD", false);
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      Logger.b(jdField_a_of_type_JavaLangString, "initPicUploadInfos", "paths is null");
      finish();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "TestPicSend start compress,currentTime = " + System.currentTimeMillis());
    }
    Object localObject = (BinderWarpper)paramBundle.getParcelableExtra("presend_handler");
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidOsMessenger = new Messenger(((BinderWarpper)localObject).a);
      localObject = Message.obtain(null, 1);
      ((Message)localObject).replyTo = new Messenger(this.jdField_a_of_type_AndroidOsHandler);
    }
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.send((Message)localObject);
      this.jdField_b_of_type_Long = System.nanoTime();
      this.jdField_c_of_type_Int = paramBundle.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("PicContants.NEED_COMPRESS", true);
      this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
      this.jdField_d_of_type_Int = paramBundle.getIntExtra("uintype", 1003);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(this.jdField_a_of_type_JavaUtilArrayList.size());
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
      Logger.a(jdField_a_of_type_JavaLangString, "initPicUploadInfos", "curType:" + this.jdField_d_of_type_Int + ",businessType:" + this.jdField_c_of_type_Int + ",needCompress:" + this.jdField_a_of_type_Boolean + ", totalCount:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.intValue());
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, localRemoteException.getMessage());
        }
        localRemoteException.printStackTrace();
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Looper.myQueue().addIdleHandler(new gth(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoActivity
 * JD-Core Version:    0.7.0.1
 */