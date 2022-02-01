import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

public class cmn
  implements Runnable
{
  public cmn(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    int i = (int)(20.0F * QRDisplayActivity.b(this.a));
    i = (int)(SizeMeasure.e(this.a.getBaseContext()) / 2.0F);
    int j = (int)(SizeMeasure.i(this.a.getBaseContext()) / 2.0F);
    if (i * 740 < j * 540)
    {
      this.a.f = i;
      this.a.g = ((int)(i / 540.0D * 740.0D));
      localObject1 = this.a.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = this.a.f;
      ((ViewGroup.LayoutParams)localObject1).height = this.a.g;
      this.a.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.a.d.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = this.a.f;
      ((ViewGroup.LayoutParams)localObject1).height = this.a.g;
      this.a.d.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (this.a.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        if (this.a.jdField_e_of_type_Int != 1) {
          break label485;
        }
        this.a.jdField_a_of_type_AndroidGraphicsBitmap = this.a.app.a(this.a.h, false);
        label215:
        if (this.a.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          this.a.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
        }
      }
      if (this.a.jdField_a_of_type_AndroidOsBundle == null)
      {
        this.a.jdField_a_of_type_AndroidOsBundle = new Bundle();
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("bkgRes", 0);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("nameClr", -16777216);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("tipsClr", -8947849);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("B", -16777216);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("W", 16777215);
        this.a.jdField_a_of_type_AndroidOsBundle.putParcelable("qrloc", new Rect(45, 76, 495, 526));
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("head", 1);
      }
      if (this.a.jdField_e_of_type_Int == 5) {
        break label702;
      }
      if (this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix == null) {
        this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = this.a.a(this.a.h, this.a.jdField_e_of_type_Int, -1);
      }
      if (this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix == null) {
        break label589;
      }
      this.a.d();
    }
    for (;;)
    {
      this.a.jdField_b_of_type_AndroidViewView.post(this.a.jdField_b_of_type_JavaLangRunnable);
      return;
      this.a.f = ((int)(j / 740.0D * 540.0D));
      this.a.g = j;
      break;
      label485:
      if (this.a.jdField_e_of_type_Int == 2)
      {
        this.a.jdField_a_of_type_AndroidGraphicsBitmap = this.a.app.a(this.a.h, (byte)3, false, false);
        if (this.a.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          break label215;
        }
        this.a.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.d();
        break label215;
      }
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.a.h, true);
      if (!(localObject1 instanceof BitmapDrawable)) {
        break label215;
      }
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)localObject1).getBitmap();
      break label215;
      label589:
      if (QLog.isDevelopLevel()) {
        QLog.d(QRDisplayActivity.jdField_a_of_type_JavaLangString, 4, "qrcode url not valid");
      }
      Object localObject2 = (TicketManager)this.a.app.getManager(2);
      localObject1 = this.a.app.getAccount();
      localObject2 = ((TicketManager)localObject2).getSkey((String)localObject1);
      Intent localIntent = this.a.getIntent();
      String str = localIntent.getStringExtra("uin");
      i = localIntent.getIntExtra("type", 1);
      QRUtils.a(this.a.app, this.a, str, i, (String)localObject1, (String)localObject2, new cmo(this, str, i));
    }
    label702:
    Object localObject1 = this.a.getSharedPreferences("qrcode", 0);
    this.a.jdField_b_of_type_Long = ((SharedPreferences)localObject1).getLong("discussionvalidtime" + this.a.h, 0L);
    this.a.i = ((SharedPreferences)localObject1).getString("discussion" + this.a.h, null);
    this.a.j = ((SharedPreferences)localObject1).getString("discussionfullSig" + this.a.h, null);
    if (this.a.jdField_b_of_type_Long - System.currentTimeMillis() / 1000L > 0L) {}
    for (i = 1;; i = 0)
    {
      this.a.findViewById(2131298980).setOnClickListener(this.a);
      if ((this.a.i == null) || (this.a.j == null) || (i == 0)) {
        break label1022;
      }
      ((TextView)this.a.findViewById(2131298979)).setText(this.a.i);
      this.a.jdField_e_of_type_AndroidViewView.setVisibility(0);
      if (this.a.f != 540)
      {
        localObject1 = this.a.jdField_e_of_type_AndroidViewView.getLayoutParams();
        if (localObject1 != null)
        {
          ((ViewGroup.LayoutParams)localObject1).width = (this.a.f + (int)(QRDisplayActivity.c(this.a) * 2.0F));
          this.a.jdField_e_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
      this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = QRUtils.a(this.a.i, -1);
      this.a.d();
      break;
    }
    label1022:
    if (QLog.isDevelopLevel()) {
      QLog.d(QRDisplayActivity.jdField_a_of_type_JavaLangString, 4, "qrcode url not valid");
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.a.h), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cmn
 * JD-Core Version:    0.7.0.1
 */