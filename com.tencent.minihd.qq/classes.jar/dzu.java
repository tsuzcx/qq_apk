import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.ForwardOperations;
import java.lang.ref.WeakReference;
import mqq.observer.SSOAccountObserver;

public class dzu
  extends SSOAccountObserver
{
  WeakReference a;
  
  public dzu(ForwardOperations paramForwardOperations)
  {
    this.a = new WeakReference(paramForwardOperations);
  }
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    paramString = (ForwardOperations)this.a.get();
    if ((paramString != null) && (!paramString.c) && (ForwardOperations.a(paramString) != null)) {
      ForwardOperations.a(paramString).sendEmptyMessage(0);
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 4096) {}
    for (paramString = new String(paramArrayOfByte);; paramString = null)
    {
      paramArrayOfByte = (ForwardOperations)this.a.get();
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.G = paramString;
        paramArrayOfByte.c = true;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dzu
 * JD-Core Version:    0.7.0.1
 */