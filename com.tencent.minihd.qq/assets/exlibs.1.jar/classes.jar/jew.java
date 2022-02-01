import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;

class jew
  implements Runnable
{
  jew(jeu paramjeu, ActionGlobalData paramActionGlobalData) {}
  
  public void run()
  {
    
    if (this.jdField_a_of_type_Jeu.jdField_a_of_type_Int == 1)
    {
      ((View)MagicfaceViewController.a(this.jdField_a_of_type_Jeu.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController)).setBackgroundColor(0);
      this.jdField_a_of_type_Jeu.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) && ("gravity".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.j)) && (PreferenceManager.getDefaultSharedPreferences(MagicfaceViewController.a(this.jdField_a_of_type_Jeu.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).a()).getBoolean(MagicfaceViewController.a(this.jdField_a_of_type_Jeu.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).a().getString(2131366269), false))) {
      MagicfaceViewController.a(this.jdField_a_of_type_Jeu.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).a().turnOnShake();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jew
 * JD-Core Version:    0.7.0.1
 */