package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import fyo;
import java.io.File;

public class AIOImageData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new fyo();
  public static final int a = 1;
  public static final String a = "I:N";
  public static final int b = 2;
  public static final String b = "I:E";
  public static final int c = 4;
  @Deprecated
  public static final String c = "";
  public static final int d = 8;
  public long a;
  public boolean a;
  public long b;
  public boolean b;
  public long c;
  public boolean c;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  public String f;
  public boolean f;
  public String g = "I:N";
  public String h = "I:N";
  
  public AIOImageData()
  {
    this.jdField_e_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = "I:N";
    this.jdField_e_of_type_JavaLangString = "I:N";
    this.jdField_f_of_type_JavaLangString = "I:N";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public int a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 0;
      if (paramString.equals(this.jdField_d_of_type_JavaLangString)) {
        return 1;
      }
      if (paramString.equals(this.jdField_e_of_type_JavaLangString)) {
        return 2;
      }
    } while (!paramString.equals(this.jdField_f_of_type_JavaLangString));
    return 4;
  }
  
  public File a(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      localObject = null;
    }
    while ((localObject != null) && (!((String)localObject).equals("I:N")))
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        break;
      }
      return localObject;
      localObject = this.jdField_d_of_type_JavaLangString;
      continue;
      localObject = this.jdField_e_of_type_JavaLangString;
      continue;
      localObject = this.jdField_f_of_type_JavaLangString;
      continue;
      localObject = this.g;
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    Object localObject2 = null;
    String str;
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      str = null;
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (!str.equals("I:N"))
        {
          localObject1 = localObject2;
          if (!str.equals(""))
          {
            if (str.startsWith("/")) {
              break;
            }
            localObject1 = "file:/" + str;
          }
        }
      }
      return localObject1;
      str = this.jdField_d_of_type_JavaLangString;
      continue;
      str = this.jdField_e_of_type_JavaLangString;
      continue;
      str = this.jdField_f_of_type_JavaLangString;
      continue;
      str = this.g;
    }
    if (str.startsWith("//")) {
      return "file:" + str;
    }
    return "file:" + str;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 3: 
    default: 
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
        } while (!this.jdField_d_of_type_JavaLangString.equals("I:N"));
        return false;
      } while (!this.jdField_e_of_type_JavaLangString.equals("I:N"));
      return false;
    } while (!this.jdField_f_of_type_JavaLangString.equals("I:N"));
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeLong(this.jdField_e_of_type_Long);
    if (this.jdField_d_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_e_of_type_Boolean) {
        break label141;
      }
      paramInt = 1;
      label114:
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_f_of_type_Boolean) {
        break label146;
      }
    }
    label141:
    label146:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label114;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageData
 * JD-Core Version:    0.7.0.1
 */