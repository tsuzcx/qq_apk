import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareResp;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class kpg
  extends TroopObserver
{
  public kpg(TroopShareUtility paramTroopShareUtility) {}
  
  public void a(boolean paramBoolean, TroopShareResp paramTroopShareResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "onTroopShareLink start");
    }
    if ((TroopShareUtility.a(this.a).c == null) || (!TroopShareUtility.a(this.a).c.equals(paramTroopShareResp.jdField_a_of_type_JavaLangString))) {
      if ((TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
      }
    }
    label236:
    label376:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if ((TroopShareUtility.a(this.a) == null) || (!TroopShareUtility.a(this.a).isShowing()) || (TroopShareUtility.a(this.a) == -1) || (TroopShareUtility.b(this.a) == -1)) {
                  break label555;
                }
                if ((!paramBoolean) || (paramTroopShareResp.jdField_a_of_type_Int != 0)) {
                  break label376;
                }
                if (!paramTroopShareResp.jdField_a_of_type_Boolean) {
                  break;
                }
                TroopShareUtility.a(this.a, paramTroopShareResp.b);
                if (TroopShareUtility.b(this.a) == 0) {
                  break label236;
                }
              } while (!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity));
              ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
              return;
              TroopShareUtility.b(this.a, paramTroopShareResp.b);
              if (TroopShareUtility.b(this.a) == 1) {
                break;
              }
            } while (!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity));
            ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
            return;
            switch (TroopShareUtility.a(this.a))
            {
            default: 
              return;
            case 0: 
              TroopShareUtility.c(this.a, AvatarTroopUtil.a("", TroopShareUtility.a(this.a).c, 0));
              this.a.b();
              TroopShareUtility.d(this.a);
              return;
            case 3: 
              this.a.b();
              TroopShareUtility.b(this.a);
              return;
            case 2: 
              this.a.b();
              TroopShareUtility.c(this.a);
              return;
            case 1: 
              this.a.b();
              TroopShareUtility.e(this.a);
              return;
            }
            this.a.b();
            TroopShareUtility.f(this.a);
            return;
            if ((!paramTroopShareResp.jdField_a_of_type_Boolean) || (TroopShareUtility.b(this.a) == 0)) {
              break;
            }
          } while (!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity));
          ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
          return;
          if ((paramTroopShareResp.jdField_a_of_type_Boolean) || (TroopShareUtility.b(this.a) == 1)) {
            break;
          }
        } while (!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity));
        ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
        return;
        this.a.b();
        QQToast.a(TroopShareUtility.a(this.a), 1, TroopShareUtility.a(this.a).getString(2131367839), 0).b(TroopShareUtility.a(this.a).getTitleBarHeight());
        TroopShareUtility.a(this.a, -1);
        TroopShareUtility.b(this.a, -1);
      } while (!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity));
      ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
      return;
    } while (!(TroopShareUtility.a(this.a) instanceof TroopCreateLogicActivity));
    label555:
    ((TroopCreateLogicActivity)TroopShareUtility.a(this.a)).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kpg
 * JD-Core Version:    0.7.0.1
 */