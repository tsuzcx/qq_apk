package cooperation.secmsg.ipc;

import android.os.Bundle;
import android.util.SparseArray;

public abstract class BaseResp
  extends BaseIpc
{
  public static BaseResp a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    int i = paramBundle.getInt("_secmsg_ipc_code", -1);
    Object localObject = (Class)b.get(i);
    try
    {
      localObject = (BaseResp)((Class)localObject).newInstance();
      ((BaseResp)localObject).b(paramBundle);
      return localObject;
    }
    catch (Exception paramBundle) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.secmsg.ipc.BaseResp
 * JD-Core Version:    0.7.0.1
 */