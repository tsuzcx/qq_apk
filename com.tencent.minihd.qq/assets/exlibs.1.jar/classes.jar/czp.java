import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.device.datadef.ProductInfo;

public final class czp
  implements Parcelable.Creator
{
  public ProductInfo a(Parcel paramParcel)
  {
    ProductInfo localProductInfo = new ProductInfo();
    localProductInfo.productId = paramParcel.readInt();
    localProductInfo.deviceType = paramParcel.readInt();
    localProductInfo.bindType = paramParcel.readInt();
    localProductInfo.supportMainMsgType = paramParcel.readInt();
    localProductInfo.supportFuncMsgType = paramParcel.readInt();
    localProductInfo.deviceName = paramParcel.readString();
    return localProductInfo;
  }
  
  public ProductInfo[] a(int paramInt)
  {
    return new ProductInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     czp
 * JD-Core Version:    0.7.0.1
 */