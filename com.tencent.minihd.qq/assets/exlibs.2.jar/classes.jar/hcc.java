import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.widget.WidgetWeatherData.Forcast;

public final class hcc
  implements Parcelable.Creator
{
  public WidgetWeatherData.Forcast a(Parcel paramParcel)
  {
    WidgetWeatherData.Forcast localForcast = new WidgetWeatherData.Forcast();
    localForcast.jdField_a_of_type_Int = paramParcel.readInt();
    localForcast.b = paramParcel.readInt();
    localForcast.c = paramParcel.readInt();
    localForcast.d = paramParcel.readInt();
    localForcast.e = paramParcel.readInt();
    localForcast.jdField_a_of_type_JavaLangString = paramParcel.readString();
    return localForcast;
  }
  
  public WidgetWeatherData.Forcast[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hcc
 * JD-Core Version:    0.7.0.1
 */