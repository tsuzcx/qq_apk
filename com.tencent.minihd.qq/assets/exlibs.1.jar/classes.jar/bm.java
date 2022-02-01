import android.os.AsyncTask;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;
import java.util.List;

public class bm
  extends AsyncTask
{
  public bm(LiteActivity paramLiteActivity, ArrayList paramArrayList) {}
  
  private DataLineMsgRecord a(DataLineHandler paramDataLineHandler, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 == 0) {
      switch (FileManagerUtil.a(paramString))
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      paramDataLineHandler = new DataLineMsgRecord();
      paramDataLineHandler.msgtype = DataLineHandler.c(i);
      paramDataLineHandler.sessionid = 0L;
      paramDataLineHandler.path = paramString;
      paramDataLineHandler.thumbPath = null;
      paramDataLineHandler.groupId = paramInt2;
      paramDataLineHandler.groupSize = paramInt3;
      paramDataLineHandler.groupIndex = paramInt4;
      return paramDataLineHandler;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 2;
    }
  }
  
  private void a(List paramList, int paramInt)
  {
    if (paramList == null) {}
    DataLineHandler localDataLineHandler;
    int j;
    int i;
    Object localObject;
    for (;;)
    {
      return;
      localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(8);
      j = paramList.size();
      if (j > 3) {
        break;
      }
      i = 0;
      while (i < j)
      {
        localObject = a(localDataLineHandler, (String)paramList.get(i), paramInt, 0, 0, 0);
        if (localObject != null) {
          localDataLineHandler.a((DataLineMsgRecord)localObject, false);
        }
        i += 1;
      }
    }
    label117:
    DataLineMsgRecord localDataLineMsgRecord;
    if ((j > 3) && (j < 50))
    {
      localObject = new ArrayList();
      int k = localDataLineHandler.a();
      i = 0;
      if (i < j)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (String)paramList.get(i), paramInt, k, j, i);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, k)) {
          break label398;
        }
        localDataLineMsgRecord.groupId = 0;
        localDataLineMsgRecord.groupIndex = 0;
        localDataLineMsgRecord.groupSize = 0;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
    }
    label395:
    label398:
    for (;;)
    {
      i += 1;
      break label117;
      if (((ArrayList)localObject).size() <= 0) {
        break;
      }
      localDataLineHandler.a((ArrayList)localObject, false);
      return;
      localObject = new ArrayList();
      j = localDataLineHandler.a();
      i = 0;
      label254:
      if (i < 50)
      {
        localDataLineMsgRecord = a(localDataLineHandler, (String)paramList.get(i), paramInt, j, 50, i);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, j)) {
          break label395;
        }
        localDataLineMsgRecord.groupId = 0;
        localDataLineMsgRecord.groupIndex = 0;
        localDataLineMsgRecord.groupSize = 0;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
      for (;;)
      {
        i += 1;
        break label254;
        if (((ArrayList)localObject).size() > 0) {
          localDataLineHandler.a((ArrayList)localObject, false);
        }
        i = 0;
        while (i < 50)
        {
          paramList.remove(0);
          i += 1;
        }
        break;
      }
    }
  }
  
  protected String a(Integer... paramVarArgs)
  {
    int i = paramVarArgs[0].intValue();
    a(this.jdField_a_of_type_JavaUtilArrayList, i);
    return null;
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bm
 * JD-Core Version:    0.7.0.1
 */