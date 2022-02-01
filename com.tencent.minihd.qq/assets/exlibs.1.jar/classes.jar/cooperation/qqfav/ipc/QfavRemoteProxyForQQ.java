package cooperation.qqfav.ipc;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import cooperation.qqfav.QfavPluginProxyService;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import lzi;
import lzj;
import mqq.app.AppRuntime;

public class QfavRemoteProxyForQQ
{
  private ServiceConnection a;
  public IQfavRemoteProxyInterface a;
  public final String a;
  protected HashSet a;
  public ConcurrentLinkedQueue a;
  protected AppRuntime a;
  public boolean a;
  public final String b = "com.qqfav.ipc.QfavRemoteProxyService";
  
  public QfavRemoteProxyForQQ(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_JavaLangString = "QfavRemoteProxyForQQ";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqAppAppRuntime = null;
    this.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidContentServiceConnection = new lzj(this);
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  private void a(QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper paramQfavRemoteProxyCallWrapper)
  {
    if ((this.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface != null) && (paramQfavRemoteProxyCallWrapper != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        new Handler(localLooper).post(new lzi(this, paramQfavRemoteProxyCallWrapper));
      }
    }
    else
    {
      return;
    }
    try
    {
      this.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface.a(paramQfavRemoteProxyCallWrapper.jdField_a_of_type_Int, paramQfavRemoteProxyCallWrapper.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RemoteException paramQfavRemoteProxyCallWrapper) {}
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface == null) && (!this.jdField_a_of_type_Boolean))
    {
      QfavPluginProxyService.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidContentServiceConnection, "com.qqfav.ipc.QfavRemoteProxyService");
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  private boolean a(QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper paramQfavRemoteProxyCallWrapper)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramQfavRemoteProxyCallWrapper);
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface != null)
    {
      QfavPluginProxyService.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidContentServiceConnection);
      this.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface = null;
      this.jdField_a_of_type_Boolean = false;
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.contains(paramString))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
      a();
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_JavaUtilHashSet.contains(paramString))
    {
      paramString = new QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper(this, paramInt, paramBundle);
      if (this.jdField_a_of_type_CooperationQqfavIpcIQfavRemoteProxyInterface != null) {
        a(paramString);
      }
      for (;;)
      {
        return true;
        a(paramString);
        a();
      }
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashSet.contains(paramString))
    {
      this.jdField_a_of_type_JavaUtilHashSet.remove(paramString);
      if (this.jdField_a_of_type_JavaUtilHashSet.isEmpty()) {
        b();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ
 * JD-Core Version:    0.7.0.1
 */