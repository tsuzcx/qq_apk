import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.TroopBarPageEntity;
import com.tencent.mobileqq.troop.data.TroopBarPostLayoutBanner;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;

public class kjj
  implements Runnable
{
  public kjj(TroopBarPostLayoutBanner paramTroopBarPostLayoutBanner, View paramView) {}
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_AndroidViewView.getContext();
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getTag();
    if ((!(localObject2 instanceof BaseActivity)) || (!(localObject1 instanceof View))) {
      return;
    }
    localObject1 = (TroopBarPageEntity)((View)localObject1).getTag(2131296416);
    localObject2 = (BaseActivity)localObject2;
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", ((TroopBarPageEntity)localObject1).id);
    TroopBarUtils.a((BaseActivity)localObject2, localBundle, "https://xiaoqu.qq.com/cgi-bin/bar/sign", 1, null, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPostLayoutBanner.a);
    TroopBarUtils.a("Clk_sign", ((TroopBarPageEntity)localObject1).id, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kjj
 * JD-Core Version:    0.7.0.1
 */