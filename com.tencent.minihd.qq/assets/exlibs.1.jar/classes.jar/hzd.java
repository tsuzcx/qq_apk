import android.annotation.TargetApi;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class hzd
  implements DatabaseErrorHandler
{
  private DefaultDatabaseErrorHandler jdField_a_of_type_AndroidDatabaseDefaultDatabaseErrorHandler = new DefaultDatabaseErrorHandler();
  
  @TargetApi(11)
  public hzd(QQEntityManagerFactory paramQQEntityManagerFactory) {}
  
  public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory.TAG, 2, "[SQLiteDatabaseCorruptException]Corruption reported by sqlite on database: " + paramSQLiteDatabase.getPath());
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_ROM", DeviceInfoUtil.i());
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actSqliteDatabaseCorrupt", true, -1L, 0L, localHashMap, null, false);
    this.jdField_a_of_type_AndroidDatabaseDefaultDatabaseErrorHandler.onCorruption(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hzd
 * JD-Core Version:    0.7.0.1
 */