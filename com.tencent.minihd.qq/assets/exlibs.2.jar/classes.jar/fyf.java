import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.activities.PrinterActivity;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageInfo;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import java.util.ArrayList;

public class fyf
  implements View.OnClickListener
{
  public fyf(AIOGalleryScene paramAIOGalleryScene, AIOImageInfo paramAIOImageInfo, File paramFile) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getText().toString();
      if (paramView != null) {
        break label25;
      }
    }
    label25:
    label665:
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramView));
      if (paramView.equals(AIOGalleryScene.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131368326)))
      {
        AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, "Pic_Forward_Contacts", 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo);
        if (!paramView.equals(AIOGalleryScene.q(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131368329))) {}
      }
      else
      {
        for (;;)
        {
          try
          {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.a.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.a.e);
            if (paramView != null) {
              break label665;
            }
            QfavBuilder.b(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()).a(AIOGalleryScene.r(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b);
            QfavReport.a(null, 40, 3);
            return;
          }
          catch (RemoteException paramView)
          {
            if (QLog.isColorLevel()) {
              QLog.e("AIOGalleryScene", 2, "", paramView);
            }
            QQToast.a(AIOGalleryScene.t(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getApplicationContext(), AIOGalleryScene.u(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131367030), 0).a();
            return;
          }
          if (paramView.equals(AIOGalleryScene.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131368334)))
          {
            AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, "Pic_Forward_Qzone", 0);
            AIOGalleryUtils.a(AIOGalleryScene.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b, AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo, AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), AIOGalleryScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene));
            AIOGalleryScene.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).finish();
            break;
          }
          if (paramView.equals(AIOGalleryScene.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131368342)))
          {
            if (LocalMultiProcConfig.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b + "__qzone_pic_permission__" + AIOGalleryScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), -1, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b).longValue()) == 0)
            {
              localObject = new QQCustomDialog(AIOGalleryScene.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), 2131558902);
              ((QQCustomDialog)localObject).setContentView(2130903216);
              ((QQCustomDialog)localObject).setTitle(AIOGalleryScene.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131363508));
              ((QQCustomDialog)localObject).setMessage(AIOGalleryScene.j(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131363510));
              ((QQCustomDialog)localObject).setNegativeButton(AIOGalleryScene.k(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131363511), new fyg(this));
              ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
              ((QQCustomDialog)localObject).setCancelable(false);
              ((QQCustomDialog)localObject).show();
              QZoneClickReport.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b, "40", "1");
              break;
            }
            AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, "Pic_Forward_Grpalbum", 0);
            AIOGalleryUtils.a(AIOGalleryScene.m(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b, AIOGalleryScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.a.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.a.h, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.a.b, -1);
            AIOGalleryScene.n(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).finish();
            break;
          }
          if (!paramView.equals(AIOGalleryScene.o(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131368331))) {
            break;
          }
          AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, "Pic_save", 0);
          AIOGalleryUtils.a(AIOGalleryScene.p(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()));
          AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 55);
          break;
          new QfavBuilder(paramView).a(AIOGalleryScene.s(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b);
        }
      }
      if (paramView.equals(AIOGalleryScene.v(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131368335)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.q();
        return;
      }
    } while (!paramView.equals(AIOGalleryScene.w(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131362199)));
    paramView = new Intent(AIOGalleryScene.x(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), PrinterActivity.class);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(this.jdField_a_of_type_JavaIoFile.getPath());
    paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    paramView.putExtra(AlbumConstants.i, 55);
    AIOGalleryScene.y(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).startActivityForResult(paramView, 55);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fyf
 * JD-Core Version:    0.7.0.1
 */