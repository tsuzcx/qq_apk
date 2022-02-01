import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.VipProfileCardBaseActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class jmu
  extends CardObserver
{
  public jmu(VipProfileCardBaseActivity paramVipProfileCardBaseActivity) {}
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "CardObserver onSetCardTemplateReturn isSuccess : " + paramBoolean + ", obj : " + paramObject);
    }
    String str = this.a.app.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_BackgroundId", String.valueOf(this.a.y));
    localHashMap.put("param_StyleId", String.valueOf(this.a.jdField_a_of_type_Long));
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.b();
    if ((paramBoolean) && (paramObject != null))
    {
      if ((paramObject instanceof Card))
      {
        paramObject = (Card)paramObject;
        paramBoolean = this.a.a((int)paramObject.lCurrentStyleId, (int)paramObject.lCurrentBgId, paramObject.backgroundUrl, (int)paramObject.backgroundColor, paramObject.templateRet);
        if (paramBoolean)
        {
          paramObject = "0";
          localHashMap.put("param_FailCode", paramObject);
          if (paramBoolean != true) {
            break label251;
          }
          StatisticCollector.a(this.a.app.a()).a(str, "profileCardSet", true, 0L, 0L, localHashMap, "", false);
          paramObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
        }
      }
      label251:
      while (!(paramObject instanceof Pair))
      {
        for (;;)
        {
          return;
          paramObject = "-102";
        }
        StatisticCollector.a(this.a.app.a()).a(str, "profileCardSet", false, 0L, 0L, localHashMap, "", false);
        paramObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
        return;
      }
      paramObject = (Pair)paramObject;
      Message localMessage;
      if (((Integer)paramObject.first).intValue() == 101107)
      {
        this.a.jdField_a_of_type_Int = 1;
        this.a.d = 2;
        localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        if (paramObject.first == null) {
          break label556;
        }
      }
      label556:
      for (paramObject = String.valueOf(paramObject.first);; paramObject = "-103")
      {
        localHashMap.put("param_FailCode", paramObject);
        StatisticCollector.a(this.a.app.a()).a(str, "profileCardSet", false, 0L, 0L, localHashMap, "", false);
        return;
        if (((Integer)paramObject.first).intValue() == 101108)
        {
          this.a.jdField_a_of_type_Int = 2;
          this.a.d = 5;
          localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
          break;
        }
        localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
        if ((((Integer)paramObject.first).intValue() >= 400000) && (((Integer)paramObject.first).intValue() <= 499999)) {
          localMessage.obj = paramObject.second;
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        break;
      }
    }
    if (!paramBoolean) {}
    for (paramObject = "-104";; paramObject = "-105")
    {
      localHashMap.put("param_FailCode", paramObject);
      StatisticCollector.a(this.a.app.a()).a(str, "profileCardSet", false, 0L, 0L, localHashMap, "", false);
      paramObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jmu
 * JD-Core Version:    0.7.0.1
 */