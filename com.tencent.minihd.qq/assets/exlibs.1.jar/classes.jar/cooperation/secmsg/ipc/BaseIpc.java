package cooperation.secmsg.ipc;

import android.os.Bundle;
import android.util.SparseArray;

public abstract class BaseIpc
{
  public static final int a = 1;
  protected static SparseArray a = new SparseArray();
  public static final int b = 2;
  protected static SparseArray b = new SparseArray();
  public static final int c = 3;
  
  static
  {
    a.put(1, RefreshRecentReq.class);
    a.put(3, UserFaceDrawableReq.class);
    b.put(3, UserFaceDrawableResp.class);
  }
  
  public abstract int a();
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("_secmsg_ipc_code", a());
  }
  
  public void b(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.secmsg.ipc.BaseIpc
 * JD-Core Version:    0.7.0.1
 */