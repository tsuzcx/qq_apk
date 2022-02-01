package com.tencent.mobileqq.activity.widget.qqmusic.utils.parser;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import het;
import java.util.Vector;

public class XmlReader
  extends Reader
{
  public static final Parcelable.Creator CREATOR = new het();
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;" };
  private static final String[] b = { "<", ">", "\"", "'", "&" };
  private int jdField_a_of_type_Int = 0;
  
  public XmlReader() {}
  
  public XmlReader(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  private int a()
  {
    while (this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfByte.length)
    {
      int i;
      if ((this.jdField_a_of_type_ArrayOfByte[this.jdField_a_of_type_Int] == 60) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfByte.length - 1))
      {
        if (this.jdField_a_of_type_ArrayOfByte[(this.jdField_a_of_type_Int + 1)] == 63)
        {
          this.jdField_a_of_type_Int += 1;
        }
        else
        {
          if (this.jdField_a_of_type_ArrayOfByte[(this.jdField_a_of_type_Int + 1)] == 47)
          {
            i = this.jdField_a_of_type_Int;
            for (this.jdField_a_of_type_Int += 2; this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfByte.length; this.jdField_a_of_type_Int += 1) {
              if (this.jdField_a_of_type_ArrayOfByte[this.jdField_a_of_type_Int] == 62)
              {
                this.jdField_a_of_type_Int += 1;
                return i;
              }
            }
          }
          this.jdField_a_of_type_Int += 1;
          a();
        }
      }
      else
      {
        if ((this.jdField_a_of_type_ArrayOfByte[this.jdField_a_of_type_Int] == 47) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfByte.length - 1) && (this.jdField_a_of_type_ArrayOfByte[(this.jdField_a_of_type_Int + 1)] == 62))
        {
          i = this.jdField_a_of_type_Int;
          this.jdField_a_of_type_Int += 2;
          return i;
        }
        this.jdField_a_of_type_Int += 1;
      }
    }
    return -1;
  }
  
  private String a()
  {
    Object localObject1 = b();
    Object localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = ((String)localObject1).trim();
      int i = ((String)localObject2).indexOf(" ");
      localObject1 = localObject2;
      if (i > 0) {
        localObject1 = ((String)localObject2).substring(0, i);
      }
      localObject2 = localObject1;
      if (((String)localObject1).length() == 0) {
        localObject2 = null;
      }
    }
    return localObject2;
  }
  
  private void a(Vector paramVector)
  {
    Vector localVector1 = new Vector();
    Vector localVector2 = new Vector();
    String str1 = a();
    String str2;
    String str3;
    String str4;
    if (str1 != null)
    {
      str2 = str1 + ".";
      str3 = str1 + "*";
      localVector1.removeAllElements();
      localVector2.removeAllElements();
      i = 0;
      if (i >= paramVector.size()) {
        break label350;
      }
      str4 = (String)paramVector.elementAt(i);
      if (!str4.startsWith(str3)) {}
    }
    label285:
    label350:
    for (int i = Integer.parseInt(str4.substring(str3.length()));; i = -1)
    {
      if (localVector2.size() > 0)
      {
        i = 0;
        while (i < localVector2.size())
        {
          a((Vector)localVector2.elementAt(i));
          i += 1;
        }
        int j;
        if (str4.startsWith(str2)) {
          j = 0;
        }
        for (;;)
        {
          if (j < localVector1.size() + 1)
          {
            if (j < localVector1.size()) {
              break label243;
            }
            localVector1.addElement(str1);
            Vector localVector3 = new Vector();
            localVector3.addElement(str4.substring(str2.length()));
            localVector2.addElement(localVector3);
          }
          for (;;)
          {
            i += 1;
            break;
            label243:
            if (!((String)localVector1.elementAt(j)).equals(str1)) {
              break label285;
            }
            ((Vector)localVector2.elementAt(j)).addElement(str4.substring(str2.length()));
          }
          j += 1;
        }
      }
      if (i >= 0)
      {
        if (this.jdField_a_of_type_ArrayOfJavaUtilVector[i] == null) {
          this.jdField_a_of_type_ArrayOfJavaUtilVector[i] = new Vector();
        }
        this.jdField_a_of_type_ArrayOfJavaUtilVector[i].add(c());
      }
      for (;;)
      {
        str1 = a();
        break;
        a();
      }
      return;
    }
  }
  
  private String b()
  {
    for (;;)
    {
      if (this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfByte.length - 6)
      {
        if (this.jdField_a_of_type_ArrayOfByte[this.jdField_a_of_type_Int] != 60) {
          break label189;
        }
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_ArrayOfByte[this.jdField_a_of_type_Int] == 47) {
          this.jdField_a_of_type_Int += 3;
        }
      }
      else
      {
        return null;
      }
      if (this.jdField_a_of_type_ArrayOfByte[this.jdField_a_of_type_Int] == 63)
      {
        this.jdField_a_of_type_Int += 1;
        return b();
      }
      int i = this.jdField_a_of_type_Int;
      while (this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfByte.length - 4)
      {
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_ArrayOfByte[this.jdField_a_of_type_Int] == 62)
        {
          this.jdField_a_of_type_Int += 1;
          if (this.jdField_a_of_type_ArrayOfByte[(this.jdField_a_of_type_Int - 2)] == 47) {
            return b();
          }
          return new String(this.jdField_a_of_type_ArrayOfByte, i, this.jdField_a_of_type_Int - i - 1);
        }
      }
      label189:
      this.jdField_a_of_type_Int += 1;
    }
  }
  
  private String c()
  {
    int i = this.jdField_a_of_type_Int;
    int j = a();
    if (j >= i)
    {
      Object localObject1 = new byte[j - i];
      System.arraycopy(this.jdField_a_of_type_ArrayOfByte, i, localObject1, 0, localObject1.length);
      byte[] arrayOfByte = Replace.a((byte[])localObject1, jdField_a_of_type_ArrayOfJavaLangString, b);
      try
      {
        localObject1 = new String(arrayOfByte, "UTF-8");
        Object localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new String(arrayOfByte);
        }
        return localObject3;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
    return "";
  }
  
  protected void c()
  {
    try
    {
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        return;
      }
      this.jdField_a_of_type_ArrayOfJavaUtilVector = null;
      this.jdField_a_of_type_ArrayOfJavaUtilVector = new Vector[this.jdField_a_of_type_JavaUtilVector.size()];
      a(this.jdField_a_of_type_JavaUtilVector);
      return;
    }
    catch (Exception localException) {}
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.parser.XmlReader
 * JD-Core Version:    0.7.0.1
 */