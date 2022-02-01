package midas.x;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;

public class ic
  implements Parcelable
{
  public static final Parcelable.Creator<ic> CREATOR = new Parcelable.Creator()
  {
    public ic a(Parcel paramAnonymousParcel)
    {
      return new ic(paramAnonymousParcel);
    }
    
    public ic[] a(int paramAnonymousInt)
    {
      return new ic[paramAnonymousInt];
    }
  };
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public ResultReceiver e;
  public String f;
  public String g;
  
  public ic() {}
  
  protected ic(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = ((ResultReceiver)paramParcel.readParcelable(ic.class.getClassLoader()));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ic
 * JD-Core Version:    0.7.0.1
 */