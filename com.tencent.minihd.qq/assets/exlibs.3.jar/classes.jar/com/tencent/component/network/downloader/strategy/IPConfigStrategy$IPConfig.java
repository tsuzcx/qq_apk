package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.downloader.common.IPInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class IPConfigStrategy$IPConfig
{
  private int a;
  public ArrayList a;
  
  public IPConfigStrategy$IPConfig()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
      return;
    }
    this.jdField_a_of_type_Int = (Math.abs(new Random(System.currentTimeMillis()).nextInt()) % this.jdField_a_of_type_JavaUtilArrayList.size());
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(IPInfo paramIPInfo)
  {
    if (paramIPInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramIPInfo);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    IPInfo localIPInfo;
    int j;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        i = -1;
      }
      localIPInfo = (IPInfo)localIterator.next();
      j = i + 1;
      int i = j;
    } while (!paramString.endsWith(localIPInfo.a));
    this.jdField_a_of_type_Int = j;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Int < 0) {
      a();
    }
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.IPConfigStrategy.IPConfig
 * JD-Core Version:    0.7.0.1
 */