package com.tencent.mobileqq.app.asyncdb.cache;

import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.data.RoamDate;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import hqu;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RoamDateCache
  extends FullCache
{
  private static final String a = "Q.db.Cache.RoamDateCache";
  
  public RoamDateCache(QQAppInterface paramQQAppInterface, DBDelayManager paramDBDelayManager)
  {
    super(paramQQAppInterface, paramDBDelayManager, RoamDate.class);
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    return paramInt1 + '-' + paramInt2;
  }
  
  private String a(String paramString, int paramInt1, int paramInt2)
  {
    return paramString + "&" + a(paramInt1, paramInt2);
  }
  
  private String a(String paramString1, String paramString2)
  {
    return paramString1 + "&" + paramString2;
  }
  
  private String[] a(String paramString)
  {
    return paramString.split("\\&");
  }
  
  private List b()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet());
    Collections.sort(localArrayList, new hqu(this));
    return localArrayList;
  }
  
  public Pair a()
  {
    Object localObject2 = b();
    if (!((List)localObject2).isEmpty())
    {
      Object localObject1 = (RoamDate)((Map.Entry)((List)localObject2).get(0)).getValue();
      localObject2 = (RoamDate)((Map.Entry)((List)localObject2).get(((List)localObject2).size() - 1)).getValue();
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      localCalendar.set(1, ((RoamDate)localObject1).getYear());
      localCalendar.set(2, ((RoamDate)localObject1).getMonth() - 1);
      int i = 0;
      if ((i >= ((RoamDate)localObject1).getDays()) || (((RoamDate)localObject1).getSerState(i) == 2))
      {
        localCalendar.set(5, i + 1);
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).set(11, 0);
        ((Calendar)localObject1).set(12, 0);
        ((Calendar)localObject1).set(13, 0);
        ((Calendar)localObject1).set(14, 0);
        ((Calendar)localObject1).set(1, ((RoamDate)localObject2).getYear());
        ((Calendar)localObject1).set(2, ((RoamDate)localObject2).getMonth() - 1);
        i = ((RoamDate)localObject2).getDays() - 1;
      }
      for (;;)
      {
        if ((i < 0) || (((RoamDate)localObject2).getSerState(i) == 2))
        {
          ((Calendar)localObject1).set(5, i + 1);
          return new Pair(localCalendar, localObject1);
          i += 1;
          break;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public RoamDate a(String paramString, int paramInt1, int paramInt2)
  {
    return (RoamDate)a(a(paramString, paramInt1, paramInt2));
  }
  
  public RoamDate a(String paramString1, String paramString2)
  {
    return (RoamDate)a(a(paramString1, paramString2));
  }
  
  protected String a(Entity paramEntity)
  {
    paramEntity = (RoamDate)paramEntity;
    return paramEntity.uin + "&" + paramEntity.date;
  }
  
  public Calendar a(String paramString, Calendar paramCalendar)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    List localList = b();
    int j;
    int k;
    int i1;
    int i;
    if (!localList.isEmpty())
    {
      j = paramCalendar.get(1);
      k = paramCalendar.get(2);
      i1 = paramCalendar.get(5);
      i = 0;
      if (i >= localList.size()) {
        break label385;
      }
      if (!((String)((Map.Entry)localList.get(i)).getKey()).equals(a(paramString, j, k + 1))) {
        break label242;
      }
    }
    label385:
    for (;;)
    {
      j = 0;
      int m = i;
      paramString = localObject2;
      label101:
      localObject1 = paramString;
      if (m >= 0)
      {
        localObject1 = (RoamDate)((Map.Entry)localList.get(m)).getValue();
        if (m != i) {
          break label258;
        }
        k = i1 - 2;
        label143:
        if (k < 0) {
          break label382;
        }
        if (((RoamDate)localObject1).getSerState(k) != 2) {
          break label249;
        }
        paramString = Calendar.getInstance();
        paramString.set(11, 0);
        paramString.set(12, 0);
        paramString.set(13, 0);
        paramString.set(14, 0);
        paramString.set(1, ((RoamDate)localObject1).getYear());
        paramString.set(2, ((RoamDate)localObject1).getMonth() - 1);
        paramString.set(5, k + 1);
        j = 1;
      }
      label242:
      label249:
      label382:
      for (;;)
      {
        paramCalendar = paramString;
        k = j;
        if (k != 0)
        {
          localObject1 = paramCalendar;
          return localObject1;
          i += 1;
          break;
          k -= 1;
          break label143;
          int n = ((RoamDate)localObject1).getDays() - 1;
          for (;;)
          {
            k = j;
            paramCalendar = paramString;
            if (n < 0) {
              break;
            }
            if (((RoamDate)localObject1).getSerState(n) == 2)
            {
              paramCalendar = Calendar.getInstance();
              paramCalendar.set(11, 0);
              paramCalendar.set(12, 0);
              paramCalendar.set(13, 0);
              paramCalendar.set(14, 0);
              paramCalendar.set(1, ((RoamDate)localObject1).getYear());
              paramCalendar.set(2, ((RoamDate)localObject1).getMonth() - 1);
              paramCalendar.set(5, n + 1);
              k = 1;
              break;
            }
            n -= 1;
          }
        }
        m -= 1;
        j = k;
        paramString = paramCalendar;
        break label101;
      }
      label258:
      i = 0;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RoamDate localRoamDate = a(String.valueOf(paramLong), paramInt1, paramInt2);
    if (localRoamDate == null) {
      localRoamDate = new RoamDate(String.valueOf(paramLong), a(paramInt1, paramInt2), paramInt3, paramInt4);
    }
    for (;;)
    {
      a(localRoamDate);
      return;
      localRoamDate.setSerindex(paramInt3, paramInt4);
    }
  }
  
  public void a(RoamDate paramRoamDate)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RoamDateCache", 2, "saveRoamDate roamDate = " + paramRoamDate);
    }
    a(paramRoamDate);
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager.c();
  }
  
  public void a(String paramString)
  {
    int i = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString = ((EntityManager)localObject).a(RoamDate.class, false, "uin=?", new String[] { paramString }, null, null, null, null);
    ((EntityManager)localObject).a();
    if (paramString != null)
    {
      d();
      localObject = paramString.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RoamDate localRoamDate = (RoamDate)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(localRoamDate), localRoamDate);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("doInit size = ");
      if (paramString != null) {
        break label131;
      }
    }
    for (;;)
    {
      QLog.d("Q.db.Cache.RoamDateCache", 2, i);
      return;
      label131:
      i = paramString.size();
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()))
    {
      paramString = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)((Map.Entry)localIterator.next()).getKey();
        String str2 = str1.split("&")[1];
        paramInt3 = Integer.parseInt(str2.split("-")[0]);
        paramInt4 = Integer.parseInt(str2.split("-")[1]);
        if ((paramInt3 < paramInt1) || ((paramInt3 == paramInt1) && (paramInt4 < paramInt2))) {
          paramString.add(str1);
        }
      }
      if (!paramString.isEmpty())
      {
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          b((String)paramString.next());
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis((5L + paramLong) * 1000L);
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2) + 1;
    int k = ((Calendar)localObject).get(5);
    RoamDate localRoamDate = a(paramString, i, j);
    localObject = localRoamDate;
    if (localRoamDate == null) {
      localObject = new RoamDate(paramString, a(i, j));
    }
    ((RoamDate)localObject).setSerState(k - 1, paramInt);
    a((RoamDate)localObject);
  }
  
  public void a(String paramString, Calendar paramCalendar1, Calendar paramCalendar2, int paramInt)
  {
    int k = paramCalendar1.get(1);
    int j = paramCalendar1.get(2) + 1;
    int i = paramCalendar1.get(5);
    int m = paramCalendar2.get(1);
    int n = paramCalendar2.get(2);
    int i1 = paramCalendar2.get(5);
    boolean bool = false;
    RoamDate localRoamDate = a(paramString, k, j);
    if (localRoamDate != null)
    {
      localRoamDate.setLocState(i - 1, paramInt);
      a(localRoamDate);
      bool = true;
    }
    if ((k == m) && (j == n + 1) && (i == i1))
    {
      if (!bool) {
        break label174;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager.c();
    }
    label174:
    while (!QLog.isColorLevel())
    {
      return;
      if (i == RoamDate.getDays(k, j))
      {
        if (j == 12)
        {
          k += 1;
          i = 1;
          j = 1;
          break;
        }
        j += 1;
        i = 1;
        break;
      }
      i += 1;
      break;
    }
    QLog.d("Q.db.Cache.RoamDateCache", 2, "updateRoamDateLocIndexByRange neadWrite = " + bool + ", start = " + paramCalendar1 + ", end = " + paramCalendar2);
  }
  
  public Calendar b(String paramString, Calendar paramCalendar)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    List localList = b();
    int j;
    int k;
    int i1;
    int i;
    if (!localList.isEmpty())
    {
      j = paramCalendar.get(1);
      k = paramCalendar.get(2);
      i1 = paramCalendar.get(5);
      i = 0;
      if (i >= localList.size()) {
        break label394;
      }
      if (!((String)((Map.Entry)localList.get(i)).getKey()).equals(a(paramString, j, k + 1))) {
        break label252;
      }
    }
    for (;;)
    {
      j = 0;
      int m = i;
      paramString = localObject2;
      label101:
      localObject1 = paramString;
      if (m < localList.size())
      {
        localObject1 = (RoamDate)((Map.Entry)localList.get(m)).getValue();
        if (m != i) {
          break label268;
        }
        k = i1;
        label148:
        if (k >= ((RoamDate)localObject1).getDays()) {
          break label391;
        }
        if (((RoamDate)localObject1).getSerState(k) != 2) {
          break label259;
        }
        paramString = Calendar.getInstance();
        paramString.set(11, 0);
        paramString.set(12, 0);
        paramString.set(13, 0);
        paramString.set(14, 0);
        paramString.set(1, ((RoamDate)localObject1).getYear());
        paramString.set(2, ((RoamDate)localObject1).getMonth() - 1);
        paramString.set(5, k + 1);
        j = 1;
      }
      label259:
      label391:
      for (;;)
      {
        paramCalendar = paramString;
        k = j;
        if (k != 0)
        {
          localObject1 = paramCalendar;
          return localObject1;
          label252:
          i += 1;
          break;
          k += 1;
          break label148;
          label268:
          int n = 0;
          for (;;)
          {
            k = j;
            paramCalendar = paramString;
            if (n >= ((RoamDate)localObject1).getDays()) {
              break;
            }
            if (((RoamDate)localObject1).getSerState(n) == 2)
            {
              paramCalendar = Calendar.getInstance();
              paramCalendar.set(11, 0);
              paramCalendar.set(12, 0);
              paramCalendar.set(13, 0);
              paramCalendar.set(14, 0);
              paramCalendar.set(1, ((RoamDate)localObject1).getYear());
              paramCalendar.set(2, ((RoamDate)localObject1).getMonth() - 1);
              paramCalendar.set(5, n + 1);
              k = 1;
              break;
            }
            n += 1;
          }
        }
        m += 1;
        j = k;
        paramString = paramCalendar;
        break label101;
      }
      label394:
      i = 0;
    }
  }
  
  protected void b() {}
  
  public void b(RoamDate paramRoamDate)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RoamDateCache", 2, "removeRoamDate roamDate = " + paramRoamDate);
    }
    c(paramRoamDate);
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager.c();
  }
  
  public void b(String paramString)
  {
    paramString = a(paramString);
    if ((paramString == null) || (paramString.length != 2)) {
      return;
    }
    paramString = a(paramString[0], paramString[1]);
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RoamDateCache", 2, "removeRoamDate roamDate = " + paramString);
    }
    c(paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager.c();
  }
  
  public void b(String paramString, long paramLong, int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis((5L + paramLong) * 1000L);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    paramString = a(paramString, i, j + 1);
    if (paramString != null)
    {
      paramString.setLocState(k - 1, paramInt);
      a(paramString);
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    List localList = ((EntityManager)localObject).a(RoamDate.class);
    ((EntityManager)localObject).a();
    if (localList != null)
    {
      d();
      localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RoamDate localRoamDate = (RoamDate)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(localRoamDate), localRoamDate);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("doInit size = ");
      if (localList != null) {
        break label116;
      }
    }
    label116:
    for (int i = 0;; i = localList.size())
    {
      QLog.d("Q.db.Cache.RoamDateCache", 2, i);
      return;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      b((RoamDate)((Map.Entry)localIterator.next()).getValue());
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      RoamDate localRoamDate = (RoamDate)((Map.Entry)localIterator.next()).getValue();
      localRoamDate.clearLocState();
      a(localRoamDate);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache
 * JD-Core Version:    0.7.0.1
 */