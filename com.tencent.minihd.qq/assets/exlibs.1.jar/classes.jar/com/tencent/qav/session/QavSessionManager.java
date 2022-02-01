package com.tencent.qav.session;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class QavSessionManager
{
  private static final String jdField_a_of_type_JavaLangString = "QavSessionManager";
  private QavSession jdField_a_of_type_ComTencentQavSessionQavSession;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilMap.size();
  }
  
  public QavSession a()
  {
    return this.jdField_a_of_type_ComTencentQavSessionQavSession;
  }
  
  public QavSession a(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString))
    {
      QavSession localQavSession = (QavSession)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      localObject = localQavSession;
      if (localQavSession == null)
      {
        localQavSession = new QavSession(paramInt, paramString);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localQavSession);
        if (this.jdField_a_of_type_JavaUtilMap.size() != 1)
        {
          localObject = localQavSession;
          if (!paramBoolean) {}
        }
        else
        {
          a(paramString);
          localObject = localQavSession;
        }
      }
    }
    return localObject;
  }
  
  public QavSession a(String paramString)
  {
    QavSession localQavSession = null;
    if (!this.jdField_a_of_type_JavaUtilMap.isEmpty()) {
      localQavSession = (QavSession)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return localQavSession;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && (!paramString.a))
    {
      if (this.jdField_a_of_type_ComTencentQavSessionQavSession != null) {
        this.jdField_a_of_type_ComTencentQavSessionQavSession.a = false;
      }
      paramString.a = true;
      this.jdField_a_of_type_ComTencentQavSessionQavSession = paramString;
    }
  }
  
  public QavSession b(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      paramString = (QavSession)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      if ((paramString != null) && (paramString == this.jdField_a_of_type_ComTencentQavSessionQavSession))
      {
        this.jdField_a_of_type_ComTencentQavSessionQavSession.a = false;
        this.jdField_a_of_type_ComTencentQavSessionQavSession = null;
      }
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.session.QavSessionManager
 * JD-Core Version:    0.7.0.1
 */