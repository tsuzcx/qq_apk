package com.tencent.open.downloadnew;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.open.business.base.StaticAnalyz;

public class MyAppApi$BackListener
  implements DialogInterface.OnCancelListener
{
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public MyAppApi$BackListener(MyAppApi paramMyAppApi, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = StaticAnalyz.a(paramString1, "NEWYYB");
    this.b = paramString2;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = DownloadManager.a();
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.b = this.b;
    localDownloadInfo.a(10);
    if (localDownloadInfo != null) {
      paramDialogInterface.a(10, localDownloadInfo);
    }
    StaticAnalyz.a("720", this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.BackListener
 * JD-Core Version:    0.7.0.1
 */