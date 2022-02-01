import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.List;

public class emp
  extends Handler
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public emp(NearbyActivity paramNearbyActivity1, NearbyActivity paramNearbyActivity2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramNearbyActivity2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    NearbyActivity localNearbyActivity = (NearbyActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localNearbyActivity == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 0: 
            NearbyActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity);
            localNearbyActivity.a.B();
          }
        } while (paramMessage.arg1 != 1);
        localNearbyActivity.a(1, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.getString(2131366939));
        return;
        NearbyActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity);
        localNearbyActivity.a.B();
        localNearbyActivity.a(1, localNearbyActivity.getString(2131367328));
        return;
      } while (NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity) == null);
      NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).notifyDataSetChanged();
      return;
      paramMessage = (List)paramMessage.obj;
      NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).clear();
      NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).addAll(paramMessage);
    } while (NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity) == null);
    NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).notifyDataSetChanged();
    return;
    NearbyActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity);
    localNearbyActivity.a.B();
    if (paramMessage.arg1 == 1) {}
    for (paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.getString(2131366592);; paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.getString(2131366584))
    {
      localNearbyActivity.a(1, paramMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     emp
 * JD-Core Version:    0.7.0.1
 */