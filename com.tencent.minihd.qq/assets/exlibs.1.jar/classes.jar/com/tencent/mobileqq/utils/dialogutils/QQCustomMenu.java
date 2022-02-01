package com.tencent.mobileqq.utils.dialogutils;

import java.util.ArrayList;
import java.util.List;

public class QQCustomMenu
{
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public QQCustomMenuItem a(int paramInt)
  {
    return (QQCustomMenuItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt, String paramString)
  {
    QQCustomMenuItem localQQCustomMenuItem = new QQCustomMenuItem();
    localQQCustomMenuItem.jdField_a_of_type_Int = paramInt;
    localQQCustomMenuItem.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList.add(localQQCustomMenuItem);
  }
  
  public void a(QQCustomMenuItem paramQQCustomMenuItem)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramQQCustomMenuItem);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public QQCustomMenuItem[] a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      QQCustomMenuItem[] arrayOfQQCustomMenuItem = new QQCustomMenuItem[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfQQCustomMenuItem);
      return arrayOfQQCustomMenuItem;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenu
 * JD-Core Version:    0.7.0.1
 */