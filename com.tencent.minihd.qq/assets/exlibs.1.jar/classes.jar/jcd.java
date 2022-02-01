import android.os.AsyncTask;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import cooperation.troop.TroopProxyActivity;
import java.util.ArrayList;

class jcd
  extends AsyncTask
{
  jcd(jcc paramjcc) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = SendBottomBar.a(this.a.a).a();
    int i = SendBottomBar.a(this.a.a).a();
    if (i == 5)
    {
      TroopProxyActivity.a.addAll(FMDataCache.b());
      return null;
    }
    if (paramVarArgs.equals(AppConstants.Y))
    {
      paramVarArgs = FMDataCache.b();
      ((DataLineHandler)SendBottomBar.a(this.a.a).a(8)).a(paramVarArgs);
      return null;
    }
    if (i == 6002)
    {
      localObject = FMDataCache.b();
      ((RouterHandler)SendBottomBar.a(this.a.a).a(50)).a((ArrayList)localObject, null, null, Long.parseLong(paramVarArgs));
      return null;
    }
    if (i == 1)
    {
      SendBottomBar.a(this.a.a).a().a(paramVarArgs);
      return null;
    }
    Object localObject = SendBottomBar.a(this.a.a).b();
    SendBottomBar.a(this.a.a).a().a((String)localObject, paramVarArgs, i);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    this.a.a.c();
    FMDataCache.b();
    SendBottomBar.c(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jcd
 * JD-Core Version:    0.7.0.1
 */