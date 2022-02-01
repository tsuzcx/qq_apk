package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;
import mbz;

public class PhotoParam
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new mbz();
  public static final int a = 4;
  public long a;
  public String a;
  public Map a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public String i = "";
  public String j = "";
  public String k = "";
  
  public PhotoParam()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_g_of_type_Int = 4;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_h_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_e_of_type_Int);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
      paramParcel.writeString(this.i);
      paramParcel.writeInt(this.jdField_g_of_type_Int);
      paramParcel.writeMap(this.jdField_a_of_type_JavaUtilMap);
      paramParcel.writeString(this.j);
      if (!this.jdField_b_of_type_Boolean) {
        break label254;
      }
      paramInt = 1;
      label185:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_h_of_type_Int);
      if (!this.jdField_c_of_type_Boolean) {
        break label259;
      }
      paramInt = 1;
      label207:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.k);
      if (!this.jdField_d_of_type_Boolean) {
        break label264;
      }
      paramInt = 1;
      label229:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_e_of_type_Boolean) {
        break label269;
      }
    }
    label259:
    label264:
    label269:
    for (paramInt = m;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      label254:
      paramInt = 0;
      break label185;
      paramInt = 0;
      break label207;
      paramInt = 0;
      break label229;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.model.PhotoParam
 * JD-Core Version:    0.7.0.1
 */