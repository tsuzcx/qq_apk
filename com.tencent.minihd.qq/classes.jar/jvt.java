import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.memoryleak.DumpMemInfoHandler;
import com.tencent.mobileqq.memoryleak.LeakInspector.InspectorListener;
import com.tencent.mobileqq.startup.step.InitLeakInspector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class jvt
  implements LeakInspector.InspectorListener
{
  public List a(String paramString)
  {
    if (BaseActivity.sTopActivity != null) {
      BaseActivity.sTopActivity.runOnUiThread(new jvu(this, paramString));
    }
    if (QLog.isColorLevel()) {
      QLog.d("LeakInspector", 2, "onBeforeDump ,leakedObj=" + paramString);
    }
    paramString = new ArrayList(3);
    paramString.add(DumpMemInfoHandler.a());
    paramString.addAll(DumpMemInfoHandler.b());
    return paramString;
  }
  
  public void a(String paramString, WeakReference paramWeakReference)
  {
    InitLeakInspector.a(paramString, paramWeakReference);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (BaseActivity.sTopActivity != null) {
      BaseActivity.sTopActivity.runOnUiThread(new jvv(this, paramString1, paramBoolean, paramString2));
    }
    if (QLog.isColorLevel()) {
      QLog.d("LeakInspector", 2, "onFinishDump isSuccess=" + paramBoolean + ",objDigest=" + paramString1 + ",zipPath=" + paramString2);
    }
  }
  
  public boolean a(Activity paramActivity)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jvt
 * JD-Core Version:    0.7.0.1
 */