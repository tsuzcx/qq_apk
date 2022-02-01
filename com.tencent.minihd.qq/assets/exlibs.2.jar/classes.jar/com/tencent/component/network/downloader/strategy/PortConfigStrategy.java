package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.downloader.common.a;
import com.tencent.component.network.module.base.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class PortConfigStrategy
{
  private String jdField_a_of_type_JavaLangString = null;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private ReadWriteLock jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock = new ReentrantReadWriteLock();
  private Map b = new HashMap();
  private Map c = new HashMap();
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.c.entrySet().iterator();
    Map.Entry localEntry;
    String str;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
      str = (String)localEntry.getKey();
    } while (!a.a((Pattern)localEntry.getValue(), paramString));
    for (paramString = str;; paramString = null) {
      return paramString;
    }
  }
  
  private List a(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {
      return localObject2;
    }
    int j = 1;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().lock();
    int i = j;
    for (;;)
    {
      try
      {
        if (!this.b.containsKey(paramString)) {
          continue;
        }
        i = j;
        localObject2 = (List)this.b.get(paramString);
        localObject1 = localObject2;
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        b.c("PortConfigStrategy", "findPortConfig", localThrowable);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().unlock();
        continue;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().unlock();
      }
      localObject2 = localObject1;
      if (i != 0) {
        break;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().lock();
        this.b.put(paramString, localObject1);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().unlock();
        return localObject1;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().unlock();
      }
      j = 0;
      i = j;
      localObject2 = a(paramString);
      i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        i = j;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject2))
        {
          i = j;
          localObject2 = (List)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
          localObject1 = localObject2;
          i = 0;
          continue;
        }
      }
      i = 0;
      localObject1 = null;
    }
  }
  
  public final int a(String paramString, int paramInt)
  {
    if ((paramInt <= 0) || (TextUtils.isEmpty(paramString))) {
      return 80;
    }
    paramString = a(paramString);
    if ((paramString != null) && (paramString.size() > 0)) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().lock();
      int i = paramString.indexOf(new Integer(paramInt));
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      paramInt = ((Integer)paramString.get((paramInt + 1) % paramString.size())).intValue();
      return paramInt;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return -1;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.readLock().unlock();
    }
  }
  
  public final void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (b.b()) {
      b.b("PortConfigStrategy", "Downloader port config:" + paramString);
    }
    localHashMap1 = new HashMap();
    localHashMap2 = new HashMap();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject == null) {
          continue;
        }
        JSONArray localJSONArray1 = localJSONObject.names();
        if (localJSONArray1 == null) {
          continue;
        }
        i = 0;
        if (i >= localJSONArray1.length()) {
          continue;
        }
        str = localJSONArray1.getString(i);
        localArrayList = new ArrayList();
        localJSONArray2 = localJSONObject.getJSONArray(localJSONArray1.getString(i));
        if (localJSONArray2 == null) {
          continue;
        }
        j = 0;
      }
      catch (Exception localException)
      {
        int i;
        String str;
        ArrayList localArrayList;
        JSONArray localJSONArray2;
        int j;
        Integer localInteger;
        localException.printStackTrace();
        try
        {
          this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().lock();
          this.jdField_a_of_type_JavaLangString = paramString;
          this.jdField_a_of_type_JavaUtilMap.clear();
          this.jdField_a_of_type_JavaUtilMap.putAll(localHashMap1);
          this.b.clear();
          this.c.clear();
          this.c.putAll(localHashMap2);
          return;
        }
        finally
        {
          this.jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock.writeLock().unlock();
        }
        j += 1;
        continue;
      }
      if (j < localJSONArray2.length())
      {
        localInteger = Integer.valueOf(localJSONArray2.getJSONObject(j).getInt("port"));
        localArrayList.add(localInteger);
        if (!b.b()) {
          continue;
        }
        b.b("PortConfigStrategy", "downloader port: domain:" + str + " port:" + localInteger);
        continue;
      }
      localHashMap1.put(str, localArrayList);
      localHashMap2.put(str, Pattern.compile(str, 2));
      i += 1;
    }
  }
  
  public final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (a(paramString) == null) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.PortConfigStrategy
 * JD-Core Version:    0.7.0.1
 */