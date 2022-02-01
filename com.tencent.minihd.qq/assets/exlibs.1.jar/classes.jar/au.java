import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class au
  implements DialogInterface.OnClickListener
{
  public au(LiteActivity paramLiteActivity, List paramList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(8);
    localDataLineHandler.b(113);
    localDataLineHandler.a(116);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
        DataLineReportUtil.f(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app);
      }
      localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
    }
    localDataLineHandler.a(localArrayList);
    LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).notifyDataSetChanged();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     au
 * JD-Core Version:    0.7.0.1
 */