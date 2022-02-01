import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.config.QQMapConstants;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SelectPicPopupWindow;
import com.tencent.mobileqq.widget.SelectPicPopupWindow.ViewHolder;
import java.io.File;
import java.util.ArrayList;

public class etl
  implements View.OnClickListener
{
  public etl(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    int i = QQMapActivity.b(this.a).getDimensionPixelSize(2131492923);
    int j = paramView.getId();
    if (j == 2131297003) {
      if (new File(QQMapConstants.i).exists())
      {
        this.a.s = true;
        UniformDownloadUtil.a(QQMapConstants.i);
      }
    }
    label473:
    do
    {
      boolean bool;
      do
      {
        return;
        if (this.a.C == 1)
        {
          QQMapActivity.a(this.a);
          ((SelectPicPopupWindow.ViewHolder)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(0)).a.setText(this.a.getString(2131364037));
          this.a.C = 2;
          return;
        }
        if (!NetworkUtil.e(this.a.getApplicationContext()))
        {
          QQToast.a(this.a, 1, this.a.getString(2131364027), 1).b(i);
          return;
        }
        if (NetworkUtil.g(this.a.getApplicationContext()))
        {
          this.a.o();
          return;
        }
        this.a.p();
        return;
        if (j != 2131298934) {
          break;
        }
        if (this.a.a.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          QQToast.a(this.a, 1, this.a.getString(2131364029), 1).b(i);
          return;
        }
        paramView = (String)this.a.a.jdField_a_of_type_AndroidWidgetImageView.getTag();
        this.a.c(paramView);
        bool = QQMapActivity.a(this.a, paramView);
        this.a.a.dismiss();
      } while (bool);
      QQToast.a(this.a, 1, this.a.getString(2131364026), 1).b(i);
      return;
      if (j == 2131298935)
      {
        if (this.a.a.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          QQToast.a(this.a, 1, this.a.getString(2131364029), 1).b(i);
          return;
        }
        if (!this.a.a(this.a.a(), true))
        {
          QQMapActivity.a(this.a);
          this.a.C = 2;
          if (!new File(QQMapConstants.i).exists()) {
            break label473;
          }
        }
        for (paramView = this.a.getString(2131364035);; paramView = this.a.getString(2131364034))
        {
          this.a.a.a(paramView);
          paramView = (String)this.a.a.jdField_a_of_type_AndroidWidgetImageView.getTag();
          if (QQMapActivity.a(this.a, paramView)) {
            break;
          }
          QQToast.a(this.a, 1, this.a.getString(2131364026), 1).b(i);
          this.a.a.dismiss();
          return;
        }
      }
    } while ((!(paramView.getTag() instanceof Integer)) || (((Integer)paramView.getTag()).intValue() != 1));
    paramView = (ImageView)paramView.findViewById(2131298937);
    if (this.a.a.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.a.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.a.a.jdField_a_of_type_AndroidWidgetImageView = paramView;
    this.a.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     etl
 * JD-Core Version:    0.7.0.1
 */