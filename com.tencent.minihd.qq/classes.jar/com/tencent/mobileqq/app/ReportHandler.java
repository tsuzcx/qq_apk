package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class ReportHandler
  extends BusinessHandler
{
  public static final int a = 10;
  public static String a;
  public static String b = "Click_desktop_friend|";
  private String c = "FuMeiTiCeSu|";
  
  static
  {
    jdField_a_of_type_JavaLangString = "Add_friend_to_desktop|";
  }
  
  ReportHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return "PLUG|" + paramString1 + "|" + paramString2 + "|internal|" + paramString3 + "|PB|" + paramString4 + "||";
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("CliLogSvc.UploadReq");
    paramString1 = this.c + paramString1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "|" + paramString2 + "|" + paramInt;
    localToServiceMsg.extraData.putString("data", paramString1);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ToServiceMsg localToServiceMsg = a("CliLogSvc.UploadReq");
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramString1 = "PLUG" + "|" + paramString1 + "|" + paramString2 + "|" + "internal" + "|" + paramString3 + "|" + "CHAT" + "|" + paramString5 + "|" + str + "|" + "" + "|" + paramString4 + "|";
    localToServiceMsg.extraData.putString("data", paramString1);
    a(localToServiceMsg);
  }
  
  public void a(String[] paramArrayOfString)
  {
    ToServiceMsg localToServiceMsg = a("CliLogSvc.UploadReq");
    localToServiceMsg.extraData.putStringArray("data", paramArrayOfString);
    a(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ReportHandler
 * JD-Core Version:    0.7.0.1
 */