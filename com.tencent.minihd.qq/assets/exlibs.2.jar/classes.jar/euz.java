import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;

class euz
  implements Runnable
{
  euz(euy parameuy, long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Euy.a.getResources();
    String str = ((Resources)localObject).getString(2131368940);
    if (this.jdField_a_of_type_Long != 0L) {
      localObject = str + ((Resources)localObject).getString(2131368943);
    }
    for (;;)
    {
      this.jdField_a_of_type_Euy.a.e.setText((CharSequence)localObject);
      return;
      if ((this.b != 0L) || (!this.jdField_a_of_type_Boolean)) {
        localObject = str + ((Resources)localObject).getString(2131368942);
      } else {
        localObject = str + ((Resources)localObject).getString(2131368941);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     euz
 * JD-Core Version:    0.7.0.1
 */