package cooperation.qqfav.widget;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavReport;
import java.util.ArrayList;
import java.util.List;
import lzl;
import lzm;
import mqq.app.AppRuntime;

public class FavoriteActionSheet
  implements View.OnClickListener
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "qqfav.FavoriteActionSheet";
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 8;
  public static final int e = 16;
  public static final int f = 32;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new lzl(this);
  IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
  public FavoriteActionSheet.Actions a;
  public List a;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime = null;
  public boolean a;
  public List b = new ArrayList();
  int g = 1;
  int h = -1;
  
  public FavoriteActionSheet(Activity paramActivity, FavoriteActionSheet.Actions paramActions, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.g = paramInt1;
    this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions = paramActions;
    this.h = paramInt2;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(paramActivity);
    if ((this.g & 0x10) != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131367082, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(16));
    }
    if ((this.g & 0x20) != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131364756, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(32));
    }
    if ((this.g & 0x1) != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131367595, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
    }
    if ((this.g & 0x2) != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131363593, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
    }
    if ((this.g & 0x4) != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131364620, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(4));
    }
    if ((this.g & 0x8) != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131362450, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(new lzm(this));
  }
  
  private void c()
  {
    QfavReport.a(this.jdField_a_of_type_MqqAppAppRuntime, "User_Forward", this.h, 0, 0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a()) {
        break label39;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|showing");
      }
    }
    label39:
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|not showing");
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a()))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramView, paramInt);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramString, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.b.add(paramString);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a()))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramView, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.FavoriteActionSheet
 * JD-Core Version:    0.7.0.1
 */