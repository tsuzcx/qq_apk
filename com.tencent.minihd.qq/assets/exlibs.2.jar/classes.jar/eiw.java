import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class eiw
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  Filter jdField_a_of_type_AndroidWidgetFilter;
  
  public eiw(LoginActivity paramLoginActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public Filter a()
  {
    if (this.jdField_a_of_type_AndroidWidgetFilter == null) {
      this.jdField_a_of_type_AndroidWidgetFilter = new eix(this);
    }
    return this.jdField_a_of_type_AndroidWidgetFilter;
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.app.b(((SimpleAccount)LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity).get(paramInt)).getUin());
  }
  
  public String b(int paramInt)
  {
    return ((SimpleAccount)LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity).get(paramInt)).getUin();
  }
  
  public int getCount()
  {
    if (LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity).size() == 0) {
      LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity).b().setVisibility(8);
    }
    for (;;)
    {
      return LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity).size();
      LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity).b().setVisibility(0);
    }
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903363, null);
    paramViewGroup = (ImageView)paramView.findViewById(2131296574);
    ImageView localImageView = (ImageView)paramView.findViewById(2131296576);
    localImageView.setVisibility(4);
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.a(((SimpleAccount)LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity).get(paramInt)).getUin(), false);
    if (localBitmap != null) {
      paramViewGroup.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      localImageView.setTag(Integer.valueOf(paramInt));
      localImageView.setOnClickListener(LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity));
      localImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.getString(2131365937));
      paramView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.getString(2131365921) + "%s", new Object[] { ((SimpleAccount)LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity).get(paramInt)).getUin() }));
      return paramView;
      paramViewGroup.setImageResource(2130838535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eiw
 * JD-Core Version:    0.7.0.1
 */