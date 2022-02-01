import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class egj
  implements Runnable
{
  egj(egi paramegi, List paramList) {}
  
  public void run()
  {
    Leba.a(this.jdField_a_of_type_Egi.a).clear();
    Leba.a(this.jdField_a_of_type_Egi.a).addAll(this.jdField_a_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. lebaData size=" + Leba.a(this.jdField_a_of_type_Egi.a).size());
    }
    Leba.a(this.jdField_a_of_type_Egi.a);
    if (this.jdField_a_of_type_Egi.a.a != null)
    {
      this.jdField_a_of_type_Egi.a.a.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. notifyData.");
      }
      Leba.b(this.jdField_a_of_type_Egi.a);
      if (this.jdField_a_of_type_Egi.a.isResume())
      {
        if ((Leba.a(this.jdField_a_of_type_Egi.a)) && (this.jdField_a_of_type_Egi.a.getResources().getConfiguration().orientation != 1)) {
          this.jdField_a_of_type_Egi.a.openDefualtRightPage();
        }
        Leba.a(this.jdField_a_of_type_Egi.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     egj
 * JD-Core Version:    0.7.0.1
 */