package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class HttpDownloadFileProcessor
  extends BaseTransProcessor
  implements IHttpCommunicatorListener
{
  private boolean jdField_a_of_type_Boolean = true;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  
  public HttpDownloadFileProcessor(String paramString1, String paramString2, TransFileController paramTransFileController)
  {
    super(paramTransFileController);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg = new FileMsg("", paramString1, 1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(paramString1);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile = new File(paramString2 + ".tmp");
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.getParentFile();
      if ((paramString1 != null) && (!paramString1.exists())) {
        paramString1.mkdirs();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.exists()) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.delete();
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(paramString2 + ".tmp");
      return;
    }
    catch (FileNotFoundException paramString1) {}
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString == null)) {
      b(null, null);
    }
    this.jdField_a_of_type_Boolean = false;
    HttpMsg localHttpMsg = new HttpMsg(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k, null, this, true);
    localHttpMsg.b(5);
    localHttpMsg.a(true);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream == null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString + ".tmp");
      localHttpMsg.b(false);
      localHttpMsg.a("Accept-Encoding", "identity");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localHttpMsg);
      d(2001);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        b(null, null);
        localFileNotFoundException.printStackTrace();
      }
    }
  }
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfInt)
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
            break label68;
          }
          throw new Exception("send or recv mFile==null");
        }
        catch (Exception paramHttpMsg1)
        {
          if (paramHttpMsg1.toString().equals("java.io.IOException: No space left on device")) {
            d(2006);
          }
          b(null, null);
        }
        return;
      }
      label68:
      if (paramHttpMsg1 != this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) {
        throw new Exception("send or recv req!=mFile.curRequest");
      }
      if ((paramHttpMsg2.c() == 200) || (paramHttpMsg2.c() == 206))
      {
        l();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream != null)
        {
          paramHttpMsg1 = paramHttpMsg2.a();
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream.write(paramHttpMsg1);
          paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
          paramHttpMsg1.jdField_e_of_type_Long += paramHttpMsg2.a().length;
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = paramHttpMsg2.a();
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long == paramHttpMsg2.a())
          {
            k();
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a();
            this.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long = 0L;
            paramHttpMsg1 = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString);
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.renameTo(paramHttpMsg1))
            {
              this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.setLastModified(System.currentTimeMillis());
              a(false);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
              d(2003);
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.delete();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
              d(2004);
            }
          }
          else
          {
            f();
          }
        }
      }
    }
  }
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "HttpDownloadFileProcessor statusChanged(),status is:" + paramInt);
    }
    return true;
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    h();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public void h()
  {
    super.h();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a();
    d(2004);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.delete();
  }
  
  public void i()
  {
    super.i();
  }
  
  protected void j()
  {
    k();
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpDownloadFileProcessor
 * JD-Core Version:    0.7.0.1
 */