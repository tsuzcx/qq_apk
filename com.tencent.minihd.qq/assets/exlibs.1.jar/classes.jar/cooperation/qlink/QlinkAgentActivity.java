package cooperation.qlink;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;

public class QlinkAgentActivity
  extends BaseActivity
{
  public static final int a = 1;
  public static final String a = "what";
  public static final int b = 2;
  public static final String b = "param.sessionid";
  public static final int c = 3;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (10 == paramInt2) {
      setResult(10, paramIntent);
    }
    if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true))) || (paramInt2 == 4))
    {
      this.app.a().a(new QlAndQQInterface.DailogClickInfo(8));
      Intent localIntent = new Intent(this, ChatActivity.class);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    for (;;)
    {
      finish();
      return;
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setTitle(null);
    if (1 == getIntent().getIntExtra("what", 0))
    {
      long l = getIntent().getLongExtra("param.sessionid", 0L);
      if (0L != l)
      {
        Object localObject = this.app.a().a(l);
        if (localObject != null)
        {
          paramBundle = new ForwardFileInfo();
          paramBundle.d(((FileManagerEntity)localObject).cloudType);
          paramBundle.b(10001);
          paramBundle.b(((FileManagerEntity)localObject).nSessionId);
          paramBundle.c(((FileManagerEntity)localObject).uniseq);
          paramBundle.d(((FileManagerEntity)localObject).fileName);
          paramBundle.d(((FileManagerEntity)localObject).fileSize);
          paramBundle.b(((FileManagerEntity)localObject).Uuid);
          paramBundle.a(((FileManagerEntity)localObject).strFilePath);
          localObject = new Intent(getApplicationContext(), FileBrowserActivity.class);
          ((Intent)localObject).putExtra("fileinfo", paramBundle);
          ((Intent)localObject).putExtra("from_qlink_enter_recent", true);
          startActivityForResult((Intent)localObject, 102);
          return;
        }
      }
    }
    finish();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkAgentActivity
 * JD-Core Version:    0.7.0.1
 */