package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;

public abstract class BaseReq
  extends BaseIpc
{
  public ResultReceiver a;
  
  public static BaseReq a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Object localObject = paramBundle.getString("_qwallet_ipc_class");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    try
    {
      ClassLoader localClassLoader = BaseIpc.class.getClassLoader();
      if (localClassLoader == null) {
        return null;
      }
      localObject = localClassLoader.loadClass((String)localObject);
      if (localObject == null) {
        return null;
      }
      localObject = (BaseReq)((Class)localObject).newInstance();
      ((BaseReq)localObject).b(paramBundle);
      return localObject;
    }
    catch (Exception paramBundle) {}
    return null;
  }
  
  public abstract void a();
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.a != null)
    {
      Parcel localParcel = Parcel.obtain();
      this.a.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      ResultReceiver localResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      paramBundle.putParcelable("_qwallet_ipc_req_fromreceiver", localResultReceiver);
    }
  }
  
  public final boolean a(Bundle paramBundle)
  {
    if ((paramBundle == null) || (this.a == null)) {
      return false;
    }
    this.a.send(0, paramBundle);
    return true;
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.a = ((ResultReceiver)paramBundle.getParcelable("_qwallet_ipc_req_fromreceiver"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.BaseReq
 * JD-Core Version:    0.7.0.1
 */