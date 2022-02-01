import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class jnx
  implements Runnable
{
  public jnx(ProfileHeaderView paramProfileHeaderView, int paramInt, ProfileActivity.AllInOne paramAllInOne, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) {
      return;
    }
    Object localObject1 = null;
    int i = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.getResources().getDimensionPixelSize(2131493018);
    if (this.jdField_a_of_type_Int == 0) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) || (!ProfileCardUtil.a())) {
        break label354;
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = ProfileCardUtil.c();
        Object localObject5 = new File((String)localObject2);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localObject5 = new FileInputStream((File)localObject5);
        localOptions.inSampleSize = ((int)ImageUtil.a((InputStream)localObject5, i, i));
        ((InputStream)localObject5).close();
        localObject2 = BitmapManager.a((String)localObject2, localOptions);
        localObject1 = localObject2;
        localObject2 = localObject1;
        if (localObject1 == null) {}
      }
      catch (Exception localException1) {}
      try
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((Bitmap)localObject1, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 41) || ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))) {
            break label256;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a(100, this.jdField_a_of_type_JavaLangString, true, 0);
        }
      }
      catch (Exception localException2)
      {
        Object localObject3;
        break label235;
        localObject1 = null;
        continue;
      }
      if (localObject1 == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivity().runOnUiThread(new jny(this, (Bitmap)localObject1));
      return;
      label235:
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, localException1.toString());
      }
      localObject3 = localObject1;
      continue;
      label256:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a(this.jdField_a_of_type_JavaLangString, true);
      continue;
      if (1 == this.jdField_a_of_type_Int)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a(this.jdField_a_of_type_JavaLangString, (byte)3);
        if ((localObject1 instanceof BitmapDrawable)) {
          localObject1 = ((BitmapDrawable)localObject1).getBitmap();
        }
      }
      else
      {
        if (2 == this.jdField_a_of_type_Int)
        {
          localObject1 = ImageUtil.b();
          continue;
        }
        localObject1 = ImageUtil.a();
        continue;
      }
      label354:
      Object localObject4 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jnx
 * JD-Core Version:    0.7.0.1
 */