import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.io.File;

class ab
  implements Runnable
{
  ab(aa paramaa, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Aa.a.app.a().a().b(this.jdField_a_of_type_Long);
    DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_Aa.a.app.a().a(this.jdField_a_of_type_Long);
    if ((localDataLineMsgSet != null) && (!localDataLineMsgSet.isSingle())) {
      if (!LiteActivity.a(this.jdField_a_of_type_Aa.a).a(this.jdField_a_of_type_Long, LiteActivity.a(this.jdField_a_of_type_Aa.a))) {
        LiteActivity.a(this.jdField_a_of_type_Aa.a).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      if ((localObject != null) && (((DataLineMsgRecord)localObject).fileFrom == 0) && (((DataLineMsgRecord)localObject).path != null) && (((DataLineMsgRecord)localObject).thumbPath != null) && (((DataLineMsgRecord)localObject).path.equals(this.jdField_a_of_type_JavaLangString)))
      {
        localObject = new File(((DataLineMsgRecord)localObject).thumbPath);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
      return;
      LiteActivity.a(this.jdField_a_of_type_Aa.a).notifyDataSetChanged();
      if ((localObject != null) && (!((DataLineMsgRecord)localObject).bIsResendOrRecvFile))
      {
        LiteActivity.a(this.jdField_a_of_type_Aa.a.a, LiteActivity.a(this.jdField_a_of_type_Aa.a));
        LiteActivity.a(LiteActivity.a(this.jdField_a_of_type_Aa.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ab
 * JD-Core Version:    0.7.0.1
 */