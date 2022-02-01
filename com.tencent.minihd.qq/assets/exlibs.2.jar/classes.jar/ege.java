import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import java.util.List;

class ege
  implements Runnable
{
  ege(egd paramegd, List paramList) {}
  
  public void run()
  {
    if (Leba.a(this.jdField_a_of_type_Egd.a) != null)
    {
      Leba.a(this.jdField_a_of_type_Egd.a).clear();
      Leba.a(this.jdField_a_of_type_Egd.a).addAll(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Egd.a.a != null) {
        this.jdField_a_of_type_Egd.a.a.notifyDataSetChanged();
      }
      Leba.b(this.jdField_a_of_type_Egd.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ege
 * JD-Core Version:    0.7.0.1
 */