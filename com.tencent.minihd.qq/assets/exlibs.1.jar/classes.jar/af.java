import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class af
  implements Runnable
{
  af(aa paramaa, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_Aa.a.app.a().a().b(this.jdField_a_of_type_Long);
    if (localDataLineMsgRecord == null) {}
    label221:
    do
    {
      do
      {
        return;
      } while (localDataLineMsgRecord.isSendFromLocal());
      if (this.jdField_a_of_type_Boolean)
      {
        localDataLineMsgRecord.issuc = true;
        localDataLineMsgRecord.fileMsgStatus = 0L;
        this.jdField_a_of_type_Aa.a.app.a().a().c(localDataLineMsgRecord.msgId);
        this.jdField_a_of_type_Aa.a.app.a().a().d();
      }
      for (;;)
      {
        DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_Aa.a.app.a().a(this.jdField_a_of_type_Long);
        if ((localDataLineMsgSet == null) || (localDataLineMsgSet.isSingle())) {
          break label221;
        }
        if (LiteActivity.a(this.jdField_a_of_type_Aa.a).a(this.jdField_a_of_type_Long, LiteActivity.a(this.jdField_a_of_type_Aa.a))) {
          break;
        }
        LiteActivity.a(this.jdField_a_of_type_Aa.a).notifyDataSetChanged();
        return;
        localDataLineMsgRecord.fileMsgStatus = 1L;
        this.jdField_a_of_type_Aa.a.app.a().a().c(localDataLineMsgRecord.msgId);
        this.jdField_a_of_type_Aa.a.app.a().a().d();
      }
      LiteActivity.a(this.jdField_a_of_type_Aa.a).notifyDataSetChanged();
    } while (localDataLineMsgRecord.bIsResendOrRecvFile);
    LiteActivity.a(this.jdField_a_of_type_Aa.a.a, LiteActivity.a(this.jdField_a_of_type_Aa.a));
    LiteActivity.a(LiteActivity.a(this.jdField_a_of_type_Aa.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     af
 * JD-Core Version:    0.7.0.1
 */