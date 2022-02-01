package com.tencent.mobileqq.app.automator.step;

import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mqq.shared_file_accessor.LogUtil;

public class AutomatorFinish
  extends AsyncStep
{
  protected int a()
  {
    long l = System.currentTimeMillis() - this.a.jdField_a_of_type_Long;
    StatisticCollector.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).a(null, "actQQInit", true, l, this.a.e, null, null);
    Log.i("AutoMonitor", "QQInitialize, cost=" + l + ", totalFailCount=" + this.a.e);
    LogUtil.timeLogEnd(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, null, null, Long.toString(l), "all-ended", null, false, null);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AutomatorFinish
 * JD-Core Version:    0.7.0.1
 */