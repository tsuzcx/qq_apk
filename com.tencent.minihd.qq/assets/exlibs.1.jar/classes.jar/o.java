import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.dataline.activities.DLRouterActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import java.util.ArrayList;
import java.util.List;

public class o
  extends AsyncTask
{
  private String jdField_a_of_type_JavaLangString = null;
  
  private o(DLRouterActivity paramDLRouterActivity) {}
  
  private DataLineMsgRecord a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.thumbPath = null;
    localDataLineMsgRecord.path = paramString;
    localDataLineMsgRecord.msgtype = -2000;
    localDataLineMsgRecord.sessionid = 0L;
    localDataLineMsgRecord.groupId = paramInt1;
    localDataLineMsgRecord.groupSize = paramInt2;
    localDataLineMsgRecord.groupIndex = paramInt3;
    return localDataLineMsgRecord;
  }
  
  private void a(List paramList)
  {
    RouterHandler localRouterHandler = (RouterHandler)this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.app.a(50);
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(a((String)paramList.get(i), 0, 0, 0));
      i += 1;
    }
    localRouterHandler.a(localArrayList, false, null, null, Long.parseLong(this.jdField_a_of_type_JavaLangString));
  }
  
  protected String a(Intent... paramVarArgs)
  {
    ArrayList localArrayList = paramVarArgs[0].getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
    this.jdField_a_of_type_JavaLangString = paramVarArgs[0].getStringExtra("uin");
    if (localArrayList == null) {
      return null;
    }
    a(localArrayList);
    return null;
  }
  
  protected void a(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     o
 * JD-Core Version:    0.7.0.1
 */