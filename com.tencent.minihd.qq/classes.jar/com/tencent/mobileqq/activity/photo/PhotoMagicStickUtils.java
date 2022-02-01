package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class PhotoMagicStickUtils
{
  private static int jdField_a_of_type_Int;
  static long jdField_a_of_type_Long;
  private static int b = 0;
  
  static
  {
    a = 19922944;
  }
  
  public static void a(Activity paramActivity, String paramString1, ActionSheet paramActionSheet, boolean paramBoolean, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    String str = paramActionSheet.a(paramInt);
    if (str == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("_photo", 2, "onBtnClickListener clikedBtn text:" + str);
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    if (paramActivity.getString(2131368345).equals(str)) {
      PhotoUtils.a(paramActivity, localIntent, 4, paramString1, paramString2, paramString3, paramString4);
    }
    for (;;)
    {
      paramActionSheet.dismiss();
      return;
      if (paramActivity.getString(2131368346).equals(str)) {
        PhotoUtils.a(paramActivity, localIntent, 5, paramString1, paramString2, paramString3, paramString4);
      } else if (paramActivity.getString(2131368347).equals(str)) {
        PhotoUtils.a(paramActivity, localIntent, 6, paramString1, paramString2, paramString3, paramString4);
      }
    }
  }
  
  public static void a(Context paramContext, ArrayList paramArrayList, ActionSheet paramActionSheet, int paramInt)
  {
    Iterator localIterator = paramArrayList.iterator();
    int j = 0;
    int i = 0;
    int k;
    int m;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      long l = new File(str).length();
      k = j;
      if (l > a) {
        k = j + 1;
      }
      m = (int)(i + l);
      i = m;
      j = k;
      if (QLog.isColorLevel())
      {
        QLog.d("_photo", 2, "addExtraBtn path:" + str + ",len:" + l);
        i = m;
        j = k;
      }
    }
    if (paramInt == 0)
    {
      k = 1;
      if (paramInt != 3000) {
        break label323;
      }
      m = 1;
      label155:
      if (paramInt != 1) {
        break label329;
      }
      paramInt = 1;
      label162:
      paramInt = k | m | paramInt;
      if ((paramInt == 0) || (j > 0)) {
        break label334;
      }
    }
    label323:
    label329:
    label334:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "addExtraBtn showSendRaw:" + bool);
      }
      paramArrayList = PhotoUtils.b(paramArrayList);
      paramActionSheet.a(paramContext.getString(2131368349) + "(" + paramArrayList + ")", 5, false);
      if (!bool) {
        break label340;
      }
      paramArrayList = PhotoUtils.a(paramContext, i);
      paramActionSheet.a(paramContext.getString(2131368350) + "(" + paramArrayList + ")", 5, false);
      paramActionSheet.a(2131368364);
      return;
      k = 0;
      break;
      m = 0;
      break label155;
      paramInt = 0;
      break label162;
    }
    label340:
    if (paramInt != 0)
    {
      paramActionSheet.a(2131368365);
      return;
    }
    paramActionSheet.a(2131368364);
  }
  
  public static void a(String paramString1, Activity paramActivity, boolean paramBoolean, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = paramActivity.getIntent();
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    PhotoUtils.a(paramActivity, localIntent, 6, paramString1, paramString2, paramString3, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoMagicStickUtils
 * JD-Core Version:    0.7.0.1
 */