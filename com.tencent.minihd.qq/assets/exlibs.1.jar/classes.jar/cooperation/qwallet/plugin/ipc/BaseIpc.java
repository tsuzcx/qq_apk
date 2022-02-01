package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;

public abstract class BaseIpc
{
  protected static final String a = "_qwallet_ipc_class";
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putString("_qwallet_ipc_class", getClass().getName());
  }
  
  public void b(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.BaseIpc
 * JD-Core Version:    0.7.0.1
 */