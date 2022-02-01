package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import jah;
import jai;
import jaj;

public class FMDialogUtil
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseActivity.sTopActivity;
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMDialogUtil<FileAssistant>", 2, "show dialog fail, context is null!");
      }
      return;
    }
    a((Context)localObject, ((Context)localObject).getString(paramInt1), paramInt2, paramFMDialogInterface);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    jah localjah = new jah(paramFMDialogInterface);
    paramFMDialogInterface = new jai(paramFMDialogInterface);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new jaj(paramContext, paramString, paramInt, localjah, paramFMDialogInterface));
      return;
    }
    DialogUtil.a(paramContext, 230, paramString, paramContext.getString(paramInt), 2131362387, 2131362388, localjah, paramFMDialogInterface).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMDialogUtil
 * JD-Core Version:    0.7.0.1
 */