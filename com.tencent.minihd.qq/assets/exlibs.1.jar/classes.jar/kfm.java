import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;

public class kfm
  implements View.OnClickListener
{
  String jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int);
  
  public kfm(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, URLDrawable paramURLDrawable) {}
  
  public void onClick(View paramView)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.c)
    {
      i = ((Integer)paramView.getTag()).intValue();
      label21:
      if (AvatarTroopUtil.b(this.jdField_a_of_type_JavaLangString)) {
        break label78;
      }
    }
    label78:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        break label83;
      }
      paramView = this.jdField_a_of_type_JavaLangString;
      switch (i)
      {
      default: 
        return;
        i = 2;
        break label21;
      }
    }
    label83:
    if (this.jdField_a_of_type_JavaLangString.equals("-5")) {}
    for (paramView = AvatarTroopUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.j, 0);; paramView = AvatarTroopUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.j, 1))
    {
      AvatarTroopUtil.a(paramView);
      break;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_JavaLangString);
    return;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentImageURLDrawable);
    return;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int);
    return;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kfm
 * JD-Core Version:    0.7.0.1
 */