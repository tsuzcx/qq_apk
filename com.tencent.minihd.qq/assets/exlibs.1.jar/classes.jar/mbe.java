import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import cooperation.qzone.QZoneStatisticsSettingActivity;
import cooperation.qzone.widget.RadioPreference;

public class mbe
  implements Preference.OnPreferenceClickListener
{
  public mbe(QZoneStatisticsSettingActivity paramQZoneStatisticsSettingActivity) {}
  
  public boolean onPreferenceClick(Preference paramPreference)
  {
    QZoneStatisticsSettingActivity.a(this.a, 1);
    ((RadioPreference)paramPreference).a(true);
    paramPreference = ((RadioPreference)paramPreference).getKey();
    QZoneStatisticsSettingActivity.a(this.a, paramPreference, 1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mbe
 * JD-Core Version:    0.7.0.1
 */