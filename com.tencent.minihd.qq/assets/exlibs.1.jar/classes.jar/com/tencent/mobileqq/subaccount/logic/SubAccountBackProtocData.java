package com.tencent.mobileqq.subaccount.logic;

import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7a2.oidb_0x7a2.RspBody;

public class SubAccountBackProtocData
{
  public static final int a = 0;
  public static final int b = 1000;
  public static final int c = 1001;
  public static final int d = 1002;
  public static final int e = 1003;
  public static final int f = 1004;
  public static final int g = 1005;
  public static final int h = 1006;
  public static final int i = 1007;
  public static final int j = 1008;
  public static final int k = 1009;
  public static final int l = 1010;
  public static final int m = 1011;
  public static final int n = 0;
  public static final int o = 1;
  public Object a;
  public String a;
  public ArrayList a;
  public boolean a;
  public String b;
  public ArrayList b;
  public boolean b;
  public String c;
  public ArrayList c;
  public boolean c;
  public boolean d = false;
  public int p = -99999;
  public int q = -99999;
  
  public SubAccountBackProtocData()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_c_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public static SubAccountBackProtocData a(SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (paramSubAccountBackProtocData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.clone() return, backData == null.");
      }
      return null;
    }
    SubAccountBackProtocData localSubAccountBackProtocData = new SubAccountBackProtocData();
    localSubAccountBackProtocData.jdField_a_of_type_JavaLangString = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
    localSubAccountBackProtocData.p = paramSubAccountBackProtocData.p;
    localSubAccountBackProtocData.jdField_b_of_type_JavaLangString = paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString;
    localSubAccountBackProtocData.jdField_c_of_type_JavaLangString = paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString;
    ArrayList localArrayList = new ArrayList();
    if (paramSubAccountBackProtocData.jdField_a_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(paramSubAccountBackProtocData.jdField_a_of_type_JavaUtilArrayList);
    }
    localSubAccountBackProtocData.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    localArrayList = new ArrayList();
    if (paramSubAccountBackProtocData.jdField_b_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(paramSubAccountBackProtocData.jdField_b_of_type_JavaUtilArrayList);
    }
    localSubAccountBackProtocData.jdField_b_of_type_JavaUtilArrayList = localArrayList;
    localArrayList = new ArrayList();
    if (paramSubAccountBackProtocData.jdField_c_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(paramSubAccountBackProtocData.jdField_c_of_type_JavaUtilArrayList);
    }
    localSubAccountBackProtocData.jdField_c_of_type_JavaUtilArrayList = localArrayList;
    localSubAccountBackProtocData.jdField_a_of_type_JavaLangObject = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangObject;
    localSubAccountBackProtocData.q = paramSubAccountBackProtocData.q;
    localSubAccountBackProtocData.jdField_a_of_type_Boolean = paramSubAccountBackProtocData.jdField_a_of_type_Boolean;
    localSubAccountBackProtocData.jdField_b_of_type_Boolean = paramSubAccountBackProtocData.jdField_b_of_type_Boolean;
    localSubAccountBackProtocData.jdField_c_of_type_Boolean = paramSubAccountBackProtocData.jdField_c_of_type_Boolean;
    localSubAccountBackProtocData.d = paramSubAccountBackProtocData.d;
    return localSubAccountBackProtocData;
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_b_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.clearNewUins()");
    }
    if (this.jdField_b_of_type_JavaUtilArrayList != null) {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_c_of_type_JavaUtilArrayList != null) {
      this.jdField_c_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.addNewUin subUin=" + paramString);
    }
    if ((paramString == null) || (paramString.length() < 4)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      }
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
    } while (this.jdField_b_of_type_JavaUtilArrayList.contains(paramString));
    this.jdField_b_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void a(oidb_0x7a2.RspBody paramRspBody, ArrayList paramArrayList)
  {
    if (paramRspBody == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      for (;;)
      {
        if ((paramRspBody.uint64_bind_uin.has()) && (paramRspBody.uint64_bind_uin.get() > 10000L))
        {
          this.jdField_c_of_type_JavaLangString = Long.toString(paramRspBody.uint64_bind_uin.get());
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_JavaLangString);
        }
        if (!paramRspBody.uint64_multi_bind_uin.has()) {
          break;
        }
        paramRspBody = paramRspBody.uint64_multi_bind_uin.get();
        if (paramRspBody == null) {
          break;
        }
        paramRspBody = paramRspBody.iterator();
        while (paramRspBody.hasNext())
        {
          Object localObject = (Long)paramRspBody.next();
          if (((Long)localObject).longValue() > 10000L)
          {
            localObject = Long.toString(((Long)localObject).longValue());
            if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localObject)) {
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
            }
            if (this.jdField_c_of_type_JavaLangString == null) {
              this.jdField_c_of_type_JavaLangString = ((String)localObject);
            }
          }
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramRspBody = paramArrayList.iterator();
        while (paramRspBody.hasNext())
        {
          paramArrayList = (String)paramRspBody.next();
          if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramArrayList)) {
            this.jdField_c_of_type_JavaUtilArrayList.add(paramArrayList);
          }
          this.jdField_b_of_type_JavaUtilArrayList.remove(paramArrayList);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.parseUins() figure new subUins. localSubUins is null. new SubUins=" + String.valueOf(this.jdField_b_of_type_JavaUtilArrayList) + " overdue SubUins=" + String.valueOf(this.jdField_c_of_type_JavaUtilArrayList));
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public ArrayList b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_c_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(this.jdField_c_of_type_JavaUtilArrayList);
    }
    return localArrayList;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_c_of_type_JavaUtilArrayList != null)
    {
      bool1 = bool2;
      if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public ArrayList c()
  {
    if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 4))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_c_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      }
      return localArrayList;
      this.jdField_a_of_type_JavaUtilArrayList = null;
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUinsBinded() return null, mSubUin is null");
      }
    }
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 4))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_c_of_type_JavaLangString);
      }
    }
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData
 * JD-Core Version:    0.7.0.1
 */