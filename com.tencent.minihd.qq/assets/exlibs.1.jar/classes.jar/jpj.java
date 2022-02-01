import com.tencent.mobileqq.qcall.QCallDetailActivity;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class jpj
  implements Runnable
{
  jpj(jpi paramjpi, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    if (QCallDetailActivity.a(this.jdField_a_of_type_Jpi.a) == null) {
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (QCallDetailActivity.a(this.jdField_a_of_type_Jpi.a).jdField_a_of_type_JavaUtilList == null) {
        break label131;
      }
      QCallDetailActivity.a(this.jdField_a_of_type_Jpi.a).jdField_a_of_type_JavaUtilList.clear();
    }
    for (;;)
    {
      QCallDetailActivity.a(this.jdField_a_of_type_Jpi.a).jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
      QCallDetailActivity.a(this.jdField_a_of_type_Jpi.a, this.jdField_a_of_type_Boolean);
      if (QCallDetailActivity.a(this.jdField_a_of_type_Jpi.a) == null) {
        break;
      }
      QCallDetailActivity.a(this.jdField_a_of_type_Jpi.a).notifyDataSetChanged();
      return;
      label131:
      QCallDetailActivity.a(this.jdField_a_of_type_Jpi.a).jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jpj
 * JD-Core Version:    0.7.0.1
 */