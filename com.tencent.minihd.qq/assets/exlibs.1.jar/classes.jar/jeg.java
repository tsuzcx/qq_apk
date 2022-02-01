import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;

public class jeg
  extends ShakeListener
{
  public jeg(MagicfaceActionManager paramMagicfaceActionManager) {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    int j = 0;
    if (Math.pow(Math.abs(paramFloat1 / 9.81F), 2.0D) + Math.pow(Math.abs(paramFloat2 / 9.81F), 2.0D) + Math.pow(Math.abs(paramFloat3 / 9.81F), 2.0D) < 1.1D)
    {
      MagicfaceActionManager localMagicfaceActionManager = this.a;
      localMagicfaceActionManager.e += 1;
      if (this.a.e == 5)
      {
        paramInt = -1;
        if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.a(paramInt, MagicfaceActionManager.a(this.a));
        }
      }
      return;
    }
    this.a.e = 0;
    int i = MagicfaceActionManager.jdField_a_of_type_ArrayOfFloat.length - 1;
    for (;;)
    {
      paramInt = j;
      if (i < 0) {
        break;
      }
      if ((Math.abs(paramFloat1 / 9.81F) > MagicfaceActionManager.jdField_a_of_type_ArrayOfFloat[i]) || (Math.abs(paramFloat2 / 9.81F) > MagicfaceActionManager.jdField_a_of_type_ArrayOfFloat[i]) || (Math.abs(paramFloat3 / 9.81F) > MagicfaceActionManager.jdField_a_of_type_ArrayOfFloat[i]))
      {
        paramInt = MagicfaceActionManager.jdField_a_of_type_ArrayOfInt[i];
        break;
      }
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jeg
 * JD-Core Version:    0.7.0.1
 */