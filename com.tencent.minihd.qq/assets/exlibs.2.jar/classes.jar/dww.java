import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

class dww
  implements Runnable
{
  dww(dwu paramdwu, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_Dwu.a.c)
    {
      this.jdField_a_of_type_Dwu.a.a.setText("内容超出!" + this.jdField_a_of_type_Dwu.a.b);
      this.jdField_a_of_type_Dwu.a.a.setTextColor(-65536);
      EditInfoActivity.c(this.jdField_a_of_type_Dwu.a, false);
      return;
    }
    this.jdField_a_of_type_Dwu.a.a.setText(this.jdField_a_of_type_Dwu.a.b);
    this.jdField_a_of_type_Dwu.a.a.setTextColor(Color.rgb(119, 119, 119));
    EditInfoActivity.d(this.jdField_a_of_type_Dwu.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dww
 * JD-Core Version:    0.7.0.1
 */