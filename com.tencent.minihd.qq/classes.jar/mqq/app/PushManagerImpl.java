package mqq.app;

import mqq.manager.PushManager;

class PushManagerImpl
  implements PushManager
{
  private AppRuntime app;
  private boolean registered;
  
  public PushManagerImpl(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  boolean isRegistered()
  {
    return this.registered;
  }
  
  public void onDestroy() {}
  
  public void registProxyMessagePush(int paramInt, String paramString1, String paramString2, String... paramVarArgs)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 1025);
    localNewIntent.putExtra("appid", paramInt);
    localNewIntent.putExtra("processName", paramString1);
    localNewIntent.putExtra("broadcastName", paramString2);
    localNewIntent.putExtra("commands", paramVarArgs);
    this.app.startServlet(localNewIntent);
  }
  
  public void unregistAllNotifyPush() {}
  
  public void unregistProxyMessagePush(int paramInt, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 1026);
    localNewIntent.putExtra("appid", paramInt);
    localNewIntent.putExtra("processName", paramString);
    localNewIntent.runNow = true;
    this.app.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.PushManagerImpl
 * JD-Core Version:    0.7.0.1
 */