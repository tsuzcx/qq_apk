package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import cooperation.qwallet.plugin.QWalletHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RedTouchReq
  extends BaseReq
{
  public static final int a = 1;
  public static final int b = 2;
  public ArrayList a;
  public String b;
  public int c;
  
  public void a()
  {
    QQAppInterface localQQAppInterface = QWalletHelper.a();
    if (localQQAppInterface == null)
    {
      a(null);
      return;
    }
    switch (this.c)
    {
    default: 
      a(null);
      return;
    case 1: 
      a(localQQAppInterface);
      return;
    }
    b(localQQAppInterface);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putInt("_qwallet_ipc_RedTouchReq_Type", this.c);
    paramBundle.putString("_qwallet_ipc_RedTouchReq_RedTouchPath", this.b);
    paramBundle.putStringArrayList("_qwallet_ipc_RedTouchReq_RedTouchPaths", this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (RedTouchManager)paramQQAppInterface.getManager(35);
    paramQQAppInterface = new ArrayList();
    localObject = ((RedTouchManager)localObject).a();
    if (localObject == null)
    {
      a(null);
      return;
    }
    localObject = ((BusinessInfoCheckUpdate.TimeRspBody)localObject).rptMsgAppInfo.get().iterator();
    while (((Iterator)localObject).hasNext())
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject).next();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((localAppInfo.path.get().equals(str)) && (localAppInfo.iNewFlag.get() != 0)) {
          paramQQAppInterface.add(new QWalletRedTouchInfo(localAppInfo.path.get(), localAppInfo.type.get() + "", localAppInfo.buffer.get()));
        }
      }
    }
    if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0))
    {
      a(null);
      return;
    }
    a(paramQQAppInterface);
  }
  
  protected void a(ArrayList paramArrayList)
  {
    RedTouchResp localRedTouchResp = new RedTouchResp();
    localRedTouchResp.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    localRedTouchResp.jdField_a_of_type_Int = this.c;
    paramArrayList = new Bundle();
    localRedTouchResp.a(paramArrayList);
    super.a(paramArrayList);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.c = paramBundle.getInt("_qwallet_ipc_RedTouchReq_Type");
    if (this.c == 2)
    {
      this.b = paramBundle.getString("_qwallet_ipc_RedTouchReq_RedTouchPath");
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayList("_qwallet_ipc_RedTouchReq_RedTouchPaths");
  }
  
  protected void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      ((RedTouchManager)paramQQAppInterface.getManager(35)).b(this.b);
      paramQQAppInterface = ((RedTouchManager)paramQQAppInterface.getManager(35)).a(this.b);
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface.type != null) {
          paramQQAppInterface.type.set(-1);
        }
        if (paramQQAppInterface.buffer != null) {
          paramQQAppInterface.buffer.set("");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.RedTouchReq
 * JD-Core Version:    0.7.0.1
 */