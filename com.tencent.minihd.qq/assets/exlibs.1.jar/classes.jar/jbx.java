import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class jbx
  implements View.OnClickListener
{
  public jbx(SendBottomBar paramSendBottomBar) {}
  
  private void a()
  {
    int i = TroopFileUtils.a(SendBottomBar.a(this.a));
    if (i == 0)
    {
      TroopFileError.a(SendBottomBar.a(this.a), SendBottomBar.a(this.a).getString(2131363364));
      this.a.b();
      return;
    }
    if (1 == i)
    {
      jbz localjbz = new jbz(this);
      DialogUtil.a(SendBottomBar.a(this.a), 230, SendBottomBar.a(this.a).getString(2131363346), SendBottomBar.a(this.a).getString(2131363351), 2131365736, 2131363313, localjbz, localjbz).show();
      return;
    }
    this.a.b();
  }
  
  public void onClick(View paramView)
  {
    int j;
    switch (SendBottomBar.a(this.a).b())
    {
    default: 
      j = SendBottomBar.a(this.a).a();
      if (j != 1) {
        break;
      }
    }
    for (int i = 1; j == 5; i = 0)
    {
      this.a.b();
      return;
      SendBottomBar.a(this.a);
      return;
      if ((FileManagerUtil.a()) && (FMDataCache.a()))
      {
        FMDialogUtil.a(SplashActivity.sTopActivity, 2131362469, 2131362465, new jby(this));
        return;
      }
      paramView = FMDataCache.b();
      Intent localIntent = new Intent();
      localIntent.putParcelableArrayListExtra("sFilesSelected", paramView);
      SendBottomBar.a(this.a).setResult(-1, localIntent);
      SendBottomBar.a(this.a).finish();
      return;
    }
    if (i != 0)
    {
      a();
      return;
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jbx
 * JD-Core Version:    0.7.0.1
 */