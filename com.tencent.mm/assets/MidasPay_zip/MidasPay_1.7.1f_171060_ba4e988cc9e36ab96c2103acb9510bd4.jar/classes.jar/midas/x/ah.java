package midas.x;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.pay.data.report.APDataReportManager;
import com.tencent.midas.comm.APLog;

public class ah
  extends SQLiteOpenHelper
{
  public ah(Context paramContext)
  {
    super(paramContext, "TencentUnipayDB", null, 1, new DatabaseErrorHandler()
    {
      public void onCorruption(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        APDataReportManager.getInstance().a("sdk.database.invalid", "", "");
      }
    });
  }
  
  public String a()
  {
    return "CREATE TABLE IF NOT EXISTS APClickStreamTable (Id INTEGER PRIMARY KEY,Pid INTEGER,Seq VARCHAR(64),QQUin VARCHAR(64),AskedQQUin VARCHAR(64),ResultInfo VARCHAR,ErrorInfo VARCHAR(64),ErrorInfo2 VARCHAR(64),UserIP VARCHAR(64),PayChannel VARCHAR(64),Channel VARCHAR(64),SubChannel VARCHAR(64),ServiceCode VARCHAR(64),Action VARCHAR(64),Format VARCHAR(64),External_ref_id VARCHAR(64),Quantity VARCHAR(64),OfferId VARCHAR(64),OfferMedia VARCHAR(64),OfferPlatform VARCHAR(64),Amount VARCHAR(64),TransactionId VARCHAR(64),Appname VARCHAR(64),Device VARCHAR(64),MPRuleID VARCHAR(64),GiftID VARCHAR(64),SuccMode VARCHAR(64),AErr VARCHAR(64),ReqUrl VARCHAR(64),FirstReq VARCHAR(64),TokenTime VARCHAR(64),DisturbMode VARCHAR(64),JumpTo VARCHAR,IsBatch VARCHAR(64),GoodsID VARCHAR,GoodsPrice VARCHAR,GoodsNum VARCHAR,BuyType VARCHAR(64),QdqbBalance VARCHAR,CftBalance VARCHAR,VipFlags VARCHAR(64),PayLevel VARCHAR(64),GoldBlc VARCHAR(64),Token VARCHAR,ResultInfoLen INTEGER )";
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onConfigure(paramSQLiteDatabase);
    paramSQLiteDatabase.enableWriteAheadLogging();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL(a());
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      APLog.i("APDatabaseHelper onCreate", paramSQLiteDatabase.toString());
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ah
 * JD-Core Version:    0.7.0.1
 */