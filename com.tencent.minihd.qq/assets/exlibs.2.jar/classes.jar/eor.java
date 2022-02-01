import com.tencent.mobileqq.activity.OpenTroopChatLogic;

public class eor
  implements Runnable
{
  public eor(OpenTroopChatLogic paramOpenTroopChatLogic) {}
  
  public void run()
  {
    this.a.jdField_b_of_type_Boolean = true;
    if (this.a.jdField_c_of_type_Boolean)
    {
      this.a.jdField_c_of_type_Boolean = false;
      OpenTroopChatLogic.a(this.a, this.a.a, this.a.jdField_b_of_type_JavaLangString, this.a.d, this.a.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eor
 * JD-Core Version:    0.7.0.1
 */