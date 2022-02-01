import com.tencent.device.file.DeviceFileObserver;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class dbk
  extends DeviceFileObserver
{
  public dbk(DeviceMsgHandle paramDeviceMsgHandle) {}
  
  private List a(Session paramSession)
  {
    String str = "";
    if (paramSession.actionInfo != null) {
      str = paramSession.actionInfo.strServiceName;
    }
    if (str != null) {
      return (List)this.a.jdField_a_of_type_JavaUtilHashMap.get(str);
    }
    return null;
  }
  
  public void a(Session paramSession)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 4, "onServiceSessionNew:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).a(paramSession);
      }
    }
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 4, "onServiceSessionProgress:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).a(paramSession, paramFloat);
      }
    }
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 4, "onServiceSessionComplete:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).a(paramSession, paramBoolean);
      }
    }
  }
  
  public void b(Session paramSession)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 4, "onServiceSessionStart:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DeviceFileObserver)((Iterator)localObject).next()).b(paramSession);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbk
 * JD-Core Version:    0.7.0.1
 */