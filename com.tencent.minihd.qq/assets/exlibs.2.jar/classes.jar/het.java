import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.parser.XmlReader;

public final class het
  implements Parcelable.Creator
{
  public XmlReader a(Parcel paramParcel)
  {
    return new XmlReader(paramParcel);
  }
  
  public XmlReader[] a(int paramInt)
  {
    return new XmlReader[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     het
 * JD-Core Version:    0.7.0.1
 */