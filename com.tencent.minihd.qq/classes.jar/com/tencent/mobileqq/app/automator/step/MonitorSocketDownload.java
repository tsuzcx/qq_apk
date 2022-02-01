package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import hrq;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MonitorSocketDownload
  extends AsyncStep
  implements INetEngine.INetEngineListener
{
  protected static INetEngine.IBreakDownFix a;
  public static final String c = "MonitorSocketDownload";
  private long c = 0L;
  private final String d = "https://3gimg.qq.com/qq_product_operations/minitext/monitorconfig.txt";
  private final String e = "https://3gimg.qq.com/qq_product_operations/minitext/monitorversion.txt";
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new hrq();
  }
  
  private int b()
  {
    this.c = System.currentTimeMillis();
    Object localObject = BaseApplicationImpl.a().a();
    if ((localObject instanceof QQAppInterface)) {
      try
      {
        String str = BaseApplicationImpl.a().getFilesDir().getAbsolutePath() + "/com.tencent.mobileqq_checkurl";
        localObject = ((QQAppInterface)localObject).a(0);
        HttpNetReq localHttpNetReq = new HttpNetReq();
        localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
        localHttpNetReq.jdField_a_of_type_JavaLangString = "https://3gimg.qq.com/qq_product_operations/minitext/monitorversion.txt";
        localHttpNetReq.c = 0;
        localHttpNetReq.b = str;
        localHttpNetReq.l = 0;
        localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
        ((INetEngine)localObject).a(localHttpNetReq);
        if (QLog.isColorLevel()) {
          QLog.d("MonitorSocketDownload", 2, "send request to check version and decide whether to download MS config");
        }
        return 7;
      }
      catch (Exception localException)
      {
        QLog.d("MonitorSocketDownload", 1, "" + localException);
        return 6;
      }
    }
    return 7;
  }
  
  private void c()
  {
    Object localObject = BaseApplicationImpl.a().a();
    if ((localObject instanceof QQAppInterface)) {}
    try
    {
      String str = BaseApplicationImpl.a().getFilesDir().getAbsolutePath() + "/monitor_config.properties";
      localObject = ((QQAppInterface)localObject).a(0);
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      localHttpNetReq.jdField_a_of_type_JavaLangString = "https://3gimg.qq.com/qq_product_operations/minitext/monitorconfig.txt";
      localHttpNetReq.c = 0;
      localHttpNetReq.b = str;
      localHttpNetReq.l = 0;
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
      ((INetEngine)localObject).a(localHttpNetReq);
      if (QLog.isColorLevel()) {
        QLog.d("MonitorSocketDownload", 2, "download MS config");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MonitorSocketDownload", 1, "" + localException);
    }
  }
  
  protected int a()
  {
    return b();
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.e == 0) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = (HttpNetReq)paramNetResp.a;
      File localFile = new File(((HttpNetReq)localObject).b);
      if (i != 0)
      {
        if (((HttpNetReq)localObject).jdField_a_of_type_JavaLangString.equals("https://3gimg.qq.com/qq_product_operations/minitext/monitorversion.txt"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MonitorSocketDownload", 2, "file exists " + localFile.exists());
          }
          try
          {
            paramNetResp = new BufferedReader(new InputStreamReader(new FileInputStream(localFile)));
            localObject = paramNetResp.readLine();
            if (localObject != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MonitorSocketDownload", 2, (String)localObject);
              }
              i = Integer.parseInt(localObject.split("\\=")[1]);
              localObject = BaseApplicationImpl.a().getSharedPreferences("monitor_socket_config", 0);
              if (((SharedPreferences)localObject).getInt("version", -1) != i) {
                break label210;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MonitorSocketDownload", 2, "config version does not change, no need to download config file, used " + (System.currentTimeMillis() - this.c) + "ms");
              }
            }
            for (;;)
            {
              paramNetResp.close();
              return;
              label210:
              c();
              ((SharedPreferences)localObject).edit().putInt("version", i);
            }
            if (!((HttpNetReq)localObject).jdField_a_of_type_JavaLangString.equals("https://3gimg.qq.com/qq_product_operations/minitext/monitorconfig.txt")) {
              break label424;
            }
          }
          catch (Exception paramNetResp)
          {
            QLog.d("MonitorSocketDownload", 1, "" + paramNetResp);
            return;
          }
        }
        if (!QLog.isColorLevel()) {
          break label424;
        }
        try
        {
          localObject = new BufferedReader(new InputStreamReader(new FileInputStream(localFile)));
          for (paramNetResp = ((BufferedReader)localObject).readLine(); paramNetResp != null; paramNetResp = ((BufferedReader)localObject).readLine()) {
            QLog.d("MonitorSocketDownload", 2, "Banlist: " + paramNetResp + ", used " + (System.currentTimeMillis() - this.c) + "ms");
          }
          ((BufferedReader)localObject).close();
          return;
        }
        catch (Exception paramNetResp)
        {
          QLog.d("MonitorSocketDownload", 1, "" + paramNetResp);
          return;
        }
      }
      QLog.d("MonitorSocketDownload", 1, "result: " + paramNetResp.e);
      label424:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.MonitorSocketDownload
 * JD-Core Version:    0.7.0.1
 */