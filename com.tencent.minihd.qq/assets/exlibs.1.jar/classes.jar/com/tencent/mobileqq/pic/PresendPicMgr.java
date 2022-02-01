package com.tencent.mobileqq.pic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.pic.compress.PicType;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jmc;
import jmd;
import jme;

public class PresendPicMgr
{
  public static final int a = 1;
  private static PresendPicMgr jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
  public static final String a = "presend_handler";
  public static final int b = 2;
  private static final String jdField_b_of_type_JavaLangString = "PresendPicMgr";
  private static final String jdField_c_of_type_JavaLangString = "presend_worker_thread";
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public Messenger a;
  private final IPresendPicMgr jdField_a_of_type_ComTencentMobileqqPicIPresendPicMgr;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private jmc jdField_a_of_type_Jmc;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public PresendPicMgr(IPresendPicMgr paramIPresendPicMgr)
  {
    this.b = true;
    Logger.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, service = " + paramIPresendPicMgr);
    this.jdField_a_of_type_ComTencentMobileqqPicIPresendPicMgr = paramIPresendPicMgr;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("presend_worker_thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Jmc = new jmc(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    paramIPresendPicMgr = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (;;)
    {
      paramIPresendPicMgr = paramIPresendPicMgr.getSharedPreferences("presend_config_sp", i).getString("key_presendconfig", "");
      Logger.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, presendConfig = " + paramIPresendPicMgr);
      if ((paramIPresendPicMgr != null) && (paramIPresendPicMgr.length() > 0))
      {
        paramIPresendPicMgr = paramIPresendPicMgr.split("\\|");
        if (paramIPresendPicMgr.length >= 8)
        {
          this.c = paramIPresendPicMgr[0].equals("1");
          this.d = paramIPresendPicMgr[1].equals("1");
          this.e = paramIPresendPicMgr[2].equals("1");
          this.f = paramIPresendPicMgr[3].equals("1");
        }
      }
      try
      {
        PicType.i = Integer.parseInt(paramIPresendPicMgr[4]);
        PicType.e = Integer.parseInt(paramIPresendPicMgr[5]);
        PicType.f = Integer.parseInt(paramIPresendPicMgr[6]);
        PicType.g = Integer.parseInt(paramIPresendPicMgr[7]);
        Logger.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, mEnablePreCompress_WIFI = " + this.c + ",mEnablePreCompress_2G = " + this.d + ",mEnablePreCompress_3G = " + this.e + ",mEnablePreCompress_4G = " + this.f + ",PicType.SendPhotoMaxLongSide = " + PicType.i + ",PicType.SendPhotoWiFiPicQuality = " + PicType.e + ",PicType.SendPhoto23GPicQuality = " + PicType.f + ",PicType.SendPhoto4GPicQuality = " + PicType.g);
        i = NetworkUtil.a(BaseApplication.getContext());
        switch (i)
        {
        default: 
          Logger.a("PresendPicMgr", "getInstance", "construct PresendPicMgr, NetType = " + i + ", mEnablePreCompress = " + this.b);
          return;
          i = 0;
        }
      }
      catch (NumberFormatException paramIPresendPicMgr)
      {
        for (;;)
        {
          paramIPresendPicMgr.printStackTrace();
          continue;
          this.b = this.c;
          continue;
          this.b = this.d;
          continue;
          this.b = this.e;
          continue;
          this.b = this.f;
        }
      }
    }
  }
  
  public static PresendPicMgr a(IPresendPicMgr paramIPresendPicMgr)
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) {}
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr == null) && (paramIPresendPicMgr != null)) {
        jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = new PresendPicMgr(paramIPresendPicMgr);
      }
      Logger.a("PresendPicMgr", "getInstance", "mInstance = " + jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr + ", Ibinder = " + paramIPresendPicMgr);
      return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr;
    }
    finally {}
  }
  
  private jmd a(String paramString)
  {
    Logger.a("PresendPicMgr", "findRequestByPath", "path = " + paramString);
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      Logger.b("PresendPicMgr", "findRequestByPath", "mPresendReqList == null");
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      Logger.b("PresendPicMgr", "findRequestByPath", "mPresendReqList.size() == 0");
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      jmd localjmd = (jmd)localIterator.next();
      if (localjmd.a.c.equals(paramString)) {
        return localjmd;
      }
    }
    return null;
  }
  
  private void d()
  {
    Logger.a("PresendPicMgr", "sendMsg", "");
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPicIPresendPicMgr.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
    }
  }
  
  public List a(List paramList)
  {
    try
    {
      paramList = this.jdField_a_of_type_ComTencentMobileqqPicIPresendPicMgr.a(paramList);
      return paramList;
    }
    catch (RemoteException paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PresendPicMgr", 2, paramList.getMessage(), paramList);
      }
    }
    return null;
  }
  
  public void a()
  {
    if (!this.b)
    {
      Logger.a("PresendPicMgr", "cancelAll", "mEnablePreCompress is false!");
      return;
    }
    Logger.a("PresendPicMgr", "cancelAll", "Start!");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((jmd)localIterator.next()).a();
    }
    c();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPicIPresendPicMgr.a();
      Logger.a("PresendPicMgr", "cancelAll", "End!");
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
        }
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    Logger.a("PresendPicMgr", "getCompossedIntent", "");
    if (!this.b)
    {
      Logger.a("PresendPicMgr", "getCompossedIntent", "Presend is OFF!");
      return;
    }
    paramIntent.putExtra("presend_handler", new BinderWarpper(new Messenger(this.jdField_a_of_type_Jmc).getBinder()));
  }
  
  public void a(String paramString)
  {
    if (!this.b)
    {
      Logger.a("PresendPicMgr", "presendPic", "mEnablePreCompress is false!");
      return;
    }
    Logger.a("PresendPicMgr", "presendPic", "path = " + paramString);
    paramString = new jmd(this, new CompressInfo(paramString, CompressOperator.a(0), 1007));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    this.jdField_a_of_type_Jmc.post(new jme(this, paramString));
  }
  
  public void b()
  {
    Logger.a("PresendPicMgr", "disablePicPresend", "");
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((Context)localObject).getSharedPreferences("presend_config_sp", i);
      ((SharedPreferences)localObject).edit().putBoolean("key_presend_off_flag", true).commit();
      ((SharedPreferences)localObject).edit().putLong("key_presend_off_time", System.currentTimeMillis()).commit();
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (!this.b)
    {
      Logger.a("PresendPicMgr", "cancelPresendPic", "mEnablePreCompress is false!");
      return;
    }
    Logger.a("PresendPicMgr", "cancelPresendPic", "path = " + paramString);
    jmd localjmd = a(paramString);
    if (localjmd == null)
    {
      Logger.a("PresendPicMgr", "cancelPresendPic", "cannot find PresendReq,path = " + paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(localjmd);
    localjmd.a();
  }
  
  public void c()
  {
    Logger.b("PresendPicMgr", "release", "");
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgr
 * JD-Core Version:    0.7.0.1
 */