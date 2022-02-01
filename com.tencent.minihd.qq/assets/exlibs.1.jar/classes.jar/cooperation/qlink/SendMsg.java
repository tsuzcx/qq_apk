package cooperation.qlink;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import lys;

public class SendMsg
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new lys();
  private static final String jdField_b_of_type_JavaLangString = "SendMsg";
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = -1L;
  public final Bundle a;
  public String a;
  long jdField_b_of_type_Long;
  
  public SendMsg(Parcel paramParcel)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.b = -1L;
    a(paramParcel);
  }
  
  public SendMsg(String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.b = -1L;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(Parcel paramParcel)
  {
    try
    {
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.jdField_a_of_type_AndroidOsBundle.clear();
      this.jdField_a_of_type_AndroidOsBundle.putAll(paramParcel.readBundle(Thread.currentThread().getContextClassLoader()));
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.d("SendMsg", 2, "readFromParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public void b(long paramLong)
  {
    this.b = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "SendMsg appSeq:" + this.jdField_a_of_type_Int + " serviceCmd:" + this.jdField_a_of_type_JavaLangString + " timeout:" + this.jdField_a_of_type_Long;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.d("SendMsg", 2, "writeToParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qlink.SendMsg
 * JD-Core Version:    0.7.0.1
 */