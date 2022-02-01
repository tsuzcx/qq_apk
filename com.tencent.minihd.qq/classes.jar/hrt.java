import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;

public class hrt
  extends MessageObserver
{
  private hrt(RegisterProxy paramRegisterProxy) {}
  
  private void f()
  {
    if (this.a.a()) {
      this.a.a(7);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.d(this.a) + " onGetAllProxyMsgFin:" + paramBoolean + ", timeoutFlag=" + paramLong1 + ", type=" + paramLong2);
    }
    RegisterProxy localRegisterProxy;
    if (paramLong2 == 0L)
    {
      localRegisterProxy = this.a;
      if ((!paramBoolean) || (paramLong1 == 8L) || (paramLong1 == 4L)) {
        break label166;
      }
      i = 2;
      RegisterProxy.d(localRegisterProxy, i);
      localRegisterProxy = this.a;
      if ((!paramBoolean) || (paramLong1 == 128L) || (paramLong1 == 64L) || (paramLong1 == 32L)) {
        break label172;
      }
    }
    label166:
    label172:
    for (int i = j;; i = 1)
    {
      RegisterProxy.c(localRegisterProxy, i);
      this.a.c = paramLong1;
      f();
      return;
      i = 1;
      break;
    }
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.c(this.a) + " on GetTroopMsg Fin:" + paramBoolean);
    }
    MsgAutoMonitorUtil.a().h();
    paramArrayOfString = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.d(paramArrayOfString, i);
      f();
      return;
      i = 1;
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.a(this.a) + " on GetC2CMsg Fin:" + paramBoolean);
    }
    MsgAutoMonitorUtil.a().f();
    Object localObject = this.a;
    int i;
    if (paramBoolean)
    {
      i = 2;
      RegisterProxy.b((RegisterProxy)localObject, i);
      localObject = RegisterProxy.a(this.a);
      if (RegisterProxy.a(this.a) != 2) {
        break label106;
      }
    }
    label106:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((Automator)localObject).f = paramBoolean;
      f();
      return;
      i = 1;
      break;
    }
  }
  
  protected void f(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "on RegisterProxy Fin:" + paramBoolean);
    }
    RegisterProxy localRegisterProxy = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.a(localRegisterProxy, i);
      if (!paramBoolean) {
        break;
      }
      f();
      return;
      i = 1;
    }
    this.a.a(6);
  }
  
  protected void g(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.b(this.a) + " on GetDiscussionMsg Fin:" + paramBoolean);
    }
    MsgAutoMonitorUtil.a().j();
    RegisterProxy localRegisterProxy = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.c(localRegisterProxy, i);
      f();
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hrt
 * JD-Core Version:    0.7.0.1
 */