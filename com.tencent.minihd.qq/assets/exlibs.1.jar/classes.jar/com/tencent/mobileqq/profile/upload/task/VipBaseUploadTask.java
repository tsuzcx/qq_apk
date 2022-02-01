package com.tencent.mobileqq.profile.upload.task;

import android.text.TextUtils;
import com.tencent.mobileqq.profile.upload.VipUploadUtils;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.AbstractUploadTask.IProgressDelegate;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.UploadServiceCreator;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import jni;

public abstract class VipBaseUploadTask
{
  public static final int a = -10001;
  public static final int b = 4;
  public static final String b = "task_state";
  public static final int c = 1;
  public static final String c = "business_refer";
  public static final int d = 5;
  public static final String d = "add_task";
  public static final int e = 2;
  public static final String e = "retry_task";
  public static final int f = -1000;
  public static final String f = "running_task";
  public static final int g = 1001;
  public static final int h = 1002;
  public long a;
  public AbstractUploadTask.IProgressDelegate a;
  protected AbstractUploadTask a;
  protected IUploadTaskCallback a;
  public Object a;
  public Map a;
  public boolean a;
  public byte[] a;
  protected IUploadTaskCallback b;
  public byte[] b;
  public byte[] c;
  protected byte[] d;
  protected String g;
  public String h = "";
  public int i;
  public String i;
  public int j;
  public String j;
  public int k = 0;
  public String k;
  public int l;
  protected String l;
  protected int m;
  protected String m;
  public volatile int n = -10001;
  
  public VipBaseUploadTask()
  {
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 6;
    this.jdField_j_of_type_JavaLangString = "mqq";
    this.jdField_a_of_type_JavaUtilMap = null;
    this.jdField_m_of_type_Int = -1;
    this.jdField_b_of_type_ComTencentUploadUinterfaceIUploadTaskCallback = new jni(this);
  }
  
  public VipBaseUploadTask(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 6;
    this.jdField_j_of_type_JavaLangString = "mqq";
    this.jdField_a_of_type_JavaUtilMap = null;
    this.jdField_m_of_type_Int = -1;
    this.jdField_b_of_type_ComTencentUploadUinterfaceIUploadTaskCallback = new jni(this);
    this.jdField_a_of_type_Long = paramLong;
    this.l = paramString;
    this.jdField_m_of_type_JavaLangString = VipUploadUtils.a(paramString);
    this.jdField_m_of_type_Int = b();
    this.d = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentUploadUinterfaceIUploadTaskCallback = this.jdField_b_of_type_ComTencentUploadUinterfaceIUploadTaskCallback;
  }
  
  public final int a()
  {
    return this.i;
  }
  
  public abstract VipBaseUploadTask a();
  
  public VipBaseUploadTask a(int paramInt1, String paramString, int paramInt2)
  {
    return this;
  }
  
  public VipBaseUploadTask a(ArrayList paramArrayList)
  {
    return this;
  }
  
  public final Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public final String a()
  {
    return this.h;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask == null) {
      throw new NullPointerException("Are you forget call buildTask()?");
    }
    if (!a()) {
      return;
    }
    b();
    b();
  }
  
  public abstract void a(int paramInt, Object... paramVarArgs);
  
  protected boolean a()
  {
    if ((this.d == null) || (this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length == 0))
    {
      this.jdField_b_of_type_ComTencentUploadUinterfaceIUploadTaskCallback.onUploadError(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask, -3, "invalid login data");
      return false;
    }
    return true;
  }
  
  protected int b()
  {
    if (this.l == null) {}
    for (String str = "";; str = this.l) {
      return (str + System.currentTimeMillis()).hashCode();
    }
  }
  
  protected void b()
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(this.g)) {
      localHashMap.put("task_state", this.g);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.uiRefer)) {
      localHashMap.put("business_refer", this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.uiRefer);
    }
    this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.transferData = localHashMap;
    if ("add_task".equals(this.g)) {
      this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.hasRetried = false;
    }
    while (!"retry_task".equals(this.g)) {
      return;
    }
    this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.hasRetried = true;
  }
  
  protected boolean b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.uploadFilePath))
    {
      this.jdField_b_of_type_ComTencentUploadUinterfaceIUploadTaskCallback.onUploadError(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask, -1, "no file path!");
      return false;
    }
    File localFile = new File(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.uploadFilePath);
    if ((localFile == null) || (!localFile.exists()) || (localFile.length() == 0L) || (localFile.isDirectory()))
    {
      this.jdField_b_of_type_ComTencentUploadUinterfaceIUploadTaskCallback.onUploadError(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask, -2, "file is not exist or empty!");
      return false;
    }
    this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask.transferData.put("task_state", "running_task");
    return IUploadService.UploadServiceCreator.getInstance().upload(this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.upload.task.VipBaseUploadTask
 * JD-Core Version:    0.7.0.1
 */