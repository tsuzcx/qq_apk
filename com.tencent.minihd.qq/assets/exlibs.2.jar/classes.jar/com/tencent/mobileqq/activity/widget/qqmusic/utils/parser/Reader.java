package com.tencent.mobileqq.activity.widget.qqmusic.utils.parser;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import java.util.Vector;

public abstract class Reader
  implements Parcelable
{
  public static final String a = ".";
  public static final String b = "*";
  protected final Object a;
  protected Vector a;
  protected byte[] a;
  protected Vector[] a;
  
  public Reader()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private Vector b(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilVector != null) && (this.jdField_a_of_type_ArrayOfJavaUtilVector != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfJavaUtilVector.length) && (this.jdField_a_of_type_ArrayOfJavaUtilVector[paramInt] != null)) {
      return this.jdField_a_of_type_ArrayOfJavaUtilVector[paramInt];
    }
    return null;
  }
  
  public int a(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramString.indexOf("*") != -1)
      {
        MLog.a("setParsePath ERROR: ", "path含有非法字符");
        return -1;
      }
    }
    if (this.jdField_a_of_type_JavaUtilVector == null) {
      this.jdField_a_of_type_JavaUtilVector = new Vector();
    }
    int i = this.jdField_a_of_type_JavaUtilVector.size();
    this.jdField_a_of_type_JavaUtilVector.add(paramString + "*" + i);
    return i;
  }
  
  public String a(int paramInt)
  {
    Vector localVector = b(paramInt);
    if (localVector != null) {
      return (String)localVector.elementAt(0);
    }
    return null;
  }
  
  public Vector a(int paramInt)
  {
    Vector localVector = b(paramInt);
    if ((localVector != null) && ((localVector.size() > 1) || ((localVector.size() == 1) && (localVector.get(0) != null) && (((String)localVector.get(0)).length() > 0)))) {
      return localVector;
    }
    return null;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilVector = null;
      return;
    }
  }
  
  public void a(Parcel paramParcel)
  {
    paramParcel.readByteArray(this.jdField_a_of_type_ArrayOfByte);
    if (this.jdField_a_of_type_JavaUtilVector != null)
    {
      this.jdField_a_of_type_JavaUtilVector.clear();
      this.jdField_a_of_type_JavaUtilVector.addAll(paramParcel.readArrayList(String.class.getClassLoader()));
    }
    for (;;)
    {
      int j = paramParcel.readInt();
      this.jdField_a_of_type_ArrayOfJavaUtilVector = new Vector[j];
      int i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_ArrayOfJavaUtilVector[i] = new Vector();
        this.jdField_a_of_type_ArrayOfJavaUtilVector[i].addAll(paramParcel.readArrayList(String.class.getClassLoader()));
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilVector = new Vector();
      this.jdField_a_of_type_JavaUtilVector.addAll(paramParcel.readArrayList(String.class.getClassLoader()));
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilVector != null)
      {
        this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.jdField_a_of_type_ArrayOfJavaUtilVector = null;
        c();
        this.jdField_a_of_type_ArrayOfByte = null;
      }
      return;
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= paramArrayOfString.length) {
          break;
        }
        if (paramArrayOfString[i].indexOf("*") != -1)
        {
          MLog.a("setParsePath ERROR: ", "path含有非法字符");
          this.jdField_a_of_type_JavaUtilVector = null;
          return;
        }
      }
      finally {}
      if (this.jdField_a_of_type_JavaUtilVector == null) {
        this.jdField_a_of_type_JavaUtilVector = new Vector();
      }
      int j = this.jdField_a_of_type_JavaUtilVector.size();
      this.jdField_a_of_type_JavaUtilVector.add(paramArrayOfString[i] + "*" + j);
      i += 1;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ArrayOfJavaUtilVector = null;
      return;
    }
  }
  
  protected abstract void c();
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this.jdField_a_of_type_ArrayOfByte);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilVector);
    paramParcel.writeInt(this.jdField_a_of_type_ArrayOfJavaUtilVector.length);
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_ArrayOfJavaUtilVector.length)
    {
      paramParcel.writeList(this.jdField_a_of_type_ArrayOfJavaUtilVector[paramInt]);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.parser.Reader
 * JD-Core Version:    0.7.0.1
 */