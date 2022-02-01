import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsDataV2.CellInfo;

public final class mat
  implements Parcelable.Creator
{
  public LbsDataV2.CellInfo a(Parcel paramParcel)
  {
    LbsDataV2.CellInfo localCellInfo = new LbsDataV2.CellInfo();
    localCellInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localCellInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localCellInfo.c = paramParcel.readInt();
    localCellInfo.d = paramParcel.readInt();
    localCellInfo.e = paramParcel.readInt();
    localCellInfo.jdField_a_of_type_Double = paramParcel.readDouble();
    localCellInfo.jdField_b_of_type_Double = paramParcel.readDouble();
    return localCellInfo;
  }
  
  public LbsDataV2.CellInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mat
 * JD-Core Version:    0.7.0.1
 */