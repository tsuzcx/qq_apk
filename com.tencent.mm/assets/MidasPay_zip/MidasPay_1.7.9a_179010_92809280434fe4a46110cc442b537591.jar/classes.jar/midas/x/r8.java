package midas.x;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;

public class r8
  implements Parcelable
{
  public static final Parcelable.Creator<r8> CREATOR = new a();
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public ResultReceiver e;
  public String f;
  public String g;
  
  public r8() {}
  
  public r8(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = ((ResultReceiver)paramParcel.readParcelable(r8.class.getClassLoader()));
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("APWebRiskControlSoftH5Params{riskControlSoftToken='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", riskControlSoftUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", riskControlSoftAmt='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", payMethod='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", resultReceiver=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", extend='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serviceCode='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeParcelable(this.e, paramInt);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
  }
  
  public static final class a
    implements Parcelable.Creator<r8>
  {
    public r8 createFromParcel(Parcel paramParcel)
    {
      return new r8(paramParcel);
    }
    
    public r8[] newArray(int paramInt)
    {
      return new r8[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.r8
 * JD-Core Version:    0.7.0.1
 */