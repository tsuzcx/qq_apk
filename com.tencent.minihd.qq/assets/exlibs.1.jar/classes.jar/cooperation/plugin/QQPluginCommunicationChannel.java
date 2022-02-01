package cooperation.plugin;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.AbstractPluginCommunicationChannel;
import mqq.app.AppRuntime;

public class QQPluginCommunicationChannel
  extends AbstractPluginCommunicationChannel
{
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public String getNickName()
  {
    String str = null;
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      str = localQQAppInterface.c();
    }
    return str;
  }
  
  public String getSKey()
  {
    String str = null;
    if (a() != null) {
      str = "getSKey";
    }
    return str;
  }
  
  public String getSid()
  {
    String str = null;
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      str = localQQAppInterface.getSid();
    }
    return str;
  }
  
  public long getUin()
  {
    long l = 0L;
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      l = localQQAppInterface.getLongAccountUin();
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.plugin.QQPluginCommunicationChannel
 * JD-Core Version:    0.7.0.1
 */