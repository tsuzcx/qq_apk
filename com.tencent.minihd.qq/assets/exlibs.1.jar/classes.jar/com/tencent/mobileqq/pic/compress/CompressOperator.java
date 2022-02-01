package com.tencent.mobileqq.pic.compress;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class CompressOperator
{
  public static final String a = "CompressOperatorSRC_PATH";
  private static List a;
  public static final String b = "CompressOperatorPIC_QUALITY";
  private static final String c = "CompressOperator";
  private static final String d = BaseApplication.getContext().getString(2131369197);
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 1: 
    default: 
      return 0;
    }
    return 2;
  }
  
  public static CompressInfo a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    int i = paramBundle.getInt("CompressOperatorPIC_QUALITY");
    paramBundle = new CompressInfo(paramBundle.getString("CompressOperatorSRC_PATH"), a(i));
    paramBundle.h = NetworkUtil.b(BaseApplication.getContext());
    if (Utils.a(paramBundle.c))
    {
      paramBundle.jdField_f_of_type_Int = 2;
      return paramBundle;
    }
    if (Utils.b(paramBundle.c))
    {
      paramBundle.jdField_f_of_type_Int = 1;
      return paramBundle;
    }
    paramBundle.jdField_f_of_type_Int = 0;
    return paramBundle;
  }
  
  private static PicType a(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo != null) {}
    switch (paramCompressInfo.jdField_f_of_type_Int)
    {
    default: 
      return null;
    case 0: 
      if (paramCompressInfo.jdField_a_of_type_Int == 1035) {
        return new PicTypeTroopBar(paramCompressInfo);
      }
      return new PicTypeNormal(paramCompressInfo);
    case 1: 
      return new PicTypeLong(paramCompressInfo);
    }
    return new PicTypeGif(paramCompressInfo);
  }
  
  private static void a(CompressInfo paramCompressInfo, boolean paramBoolean)
  {
    if ((paramCompressInfo == null) || (TextUtils.isEmpty(paramCompressInfo.c)) || (TextUtils.isEmpty(paramCompressInfo.jdField_e_of_type_JavaLangString))) {
      Logger.b("CompressOperator", " checkAndLog()", "info == null || TextUtils.isEmpty(info.srcPath) || TextUtils.isEmpty(info.destPath)");
    }
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        Logger.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", paramCompressInfo.toString());
        if (!paramCompressInfo.jdField_a_of_type_Boolean) {
          break;
        }
      } while (paramBoolean);
      l1 = Utils.a(paramCompressInfo.c);
      l2 = Utils.a(paramCompressInfo.jdField_e_of_type_JavaLangString);
      Logger.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", "src File size:" + l1);
      Logger.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", "dest File size:" + l2);
    } while ((l1 <= 0L) || (l2 <= l1) || ("webp".equals(FileUtils.a(paramCompressInfo.c))));
    Logger.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", d);
    paramCompressInfo.jdField_f_of_type_JavaLangString = ("CompressOperator" + paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()" + d);
    FileUtils.d(paramCompressInfo.jdField_e_of_type_JavaLangString);
    if (a == null) {
      a = new ArrayList();
    }
    if (!a.contains(paramBoolean + paramCompressInfo.c)) {
      a.add(paramBoolean + paramCompressInfo.c);
    }
    paramCompressInfo.jdField_e_of_type_JavaLangString = paramCompressInfo.c;
    Logger.b("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", " destSize > srcSize, info.destPath = info.srcPath");
    return;
    paramCompressInfo.jdField_e_of_type_JavaLangString = paramCompressInfo.c;
    Logger.b("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", "info.isSuccess = false, info.destPath = info.srcPath");
  }
  
  public static boolean a(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo == null) {
      return false;
    }
    Logger.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " start()", "");
    return a(paramCompressInfo, false);
  }
  
  private static boolean a(CompressInfo paramCompressInfo, boolean paramBoolean)
  {
    if ((paramCompressInfo == null) || (!FileUtils.b(paramCompressInfo.c)))
    {
      Logger.b("CompressOperator", " startImpl()", "info == null || TextUtils.isEmpty(info.srcPath)");
      return false;
    }
    Object localObject;
    if ((a != null) && (a.contains(paramBoolean + paramCompressInfo.c)))
    {
      Logger.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " startImpl()", d);
      paramCompressInfo.jdField_f_of_type_JavaLangString = ("CompressOperator" + paramCompressInfo.jdField_a_of_type_JavaLangString + " startImpl()" + d);
      paramCompressInfo.jdField_e_of_type_JavaLangString = paramCompressInfo.c;
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramCompressInfo.jdField_e_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      paramCompressInfo.d = ((BitmapFactory.Options)localObject).outWidth;
      paramCompressInfo.jdField_e_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      return true;
    }
    paramCompressInfo.h = NetworkUtil.b(BaseApplication.getContext());
    if (Utils.a(paramCompressInfo.c))
    {
      paramCompressInfo.jdField_f_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        Logger.a("CompressOperator", " startImpl()", "info:" + paramCompressInfo);
      }
      localObject = a(paramCompressInfo);
      if (!paramBoolean) {
        break label335;
      }
    }
    label335:
    for (boolean bool = ((PicType)localObject).b();; bool = ((PicType)localObject).a())
    {
      paramCompressInfo.jdField_a_of_type_Boolean = bool;
      a(paramCompressInfo, paramBoolean);
      if (paramCompressInfo.jdField_e_of_type_JavaLangString != null)
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      }
      try
      {
        BitmapFactory.decodeFile(paramCompressInfo.jdField_e_of_type_JavaLangString, (BitmapFactory.Options)localObject);
        paramCompressInfo.d = ((BitmapFactory.Options)localObject).outWidth;
        paramCompressInfo.jdField_e_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
        return paramCompressInfo.jdField_a_of_type_Boolean;
      }
      catch (OutOfMemoryError paramCompressInfo) {}
      if (Utils.b(paramCompressInfo.c))
      {
        paramCompressInfo.jdField_f_of_type_Int = 1;
        break;
      }
      paramCompressInfo.jdField_f_of_type_Int = 0;
      break;
    }
    return false;
  }
  
  public static boolean b(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo == null) {
      return false;
    }
    Logger.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", "");
    return a(paramCompressInfo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.CompressOperator
 * JD-Core Version:    0.7.0.1
 */