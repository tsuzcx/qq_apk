import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class kpc
  implements AdapterView.OnItemClickListener
{
  public kpc(TroopShareUtility paramTroopShareUtility) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    TroopShareUtility.a(this.a).dismiss();
    int i;
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        i = 2131367829;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        QQToast.a(TroopShareUtility.a(this.a), TroopShareUtility.a(this.a).getString(i), 0).b(TroopShareUtility.a(this.a).getTitleBarHeight());
        TroopShareUtility.a(this.a, -1);
        TroopShareUtility.b(this.a, -1);
        if ((TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity)) {
          ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
        }
      }
      do
      {
        return;
        if (WXShareHelper.a().b()) {
          break label335;
        }
        i = 2131367830;
        break;
        if (QLog.isColorLevel()) {
          QLog.i("TroopShareUtility", 2, "onItemClick.chooseChannel: " + paramInt + "," + paramLong);
        }
        TroopShareUtility.a(this.a, (int)paramLong);
        if ((TroopShareUtility.a(this.a) != 5) || (!TroopShareUtility.a(this.a).a)) {
          break label255;
        }
        this.a.g();
      } while (!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity));
      ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
      return;
      label255:
      if (TroopShareUtility.a(this.a).e())
      {
        if ((TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity)) {
          this.a.a = true;
        }
        this.a.d();
        return;
      }
      if ((TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity)) {
        this.a.a = false;
      }
      TroopShareUtility.b(this.a, 0);
      TroopShareUtility.a(this.a);
      return;
      label335:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kpc
 * JD-Core Version:    0.7.0.1
 */