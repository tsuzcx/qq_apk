import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.device.JNICallCenter.DataPoint;

public final class cww
  implements Parcelable.Creator
{
  public DataPoint a(Parcel paramParcel)
  {
    DataPoint localDataPoint = new DataPoint();
    localDataPoint.mDin = paramParcel.readLong();
    localDataPoint.mSendUinType = paramParcel.readInt();
    localDataPoint.mApiName = paramParcel.readString();
    localDataPoint.mProperityId = paramParcel.readInt();
    localDataPoint.mValueType = paramParcel.readString();
    localDataPoint.mValue = paramParcel.readString();
    localDataPoint.mRetCode = paramParcel.readInt();
    localDataPoint.mErrMsg = paramParcel.readString();
    localDataPoint.mSeq = paramParcel.readString();
    return localDataPoint;
  }
  
  public DataPoint[] a(int paramInt)
  {
    return new DataPoint[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cww
 * JD-Core Version:    0.7.0.1
 */