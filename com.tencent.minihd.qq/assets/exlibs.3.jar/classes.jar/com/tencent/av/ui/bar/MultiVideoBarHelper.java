package com.tencent.av.ui.bar;

import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.UITools1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qav.ipc.QavStateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MultiVideoBarHelper
{
  static final String a = "MultiVideoBarHelper";
  
  public static void a(QQAppInterface paramQQAppInterface, View paramView, Message paramMessage, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    QavStateManager localQavStateManager = (QavStateManager)paramQQAppInterface.getManager(87);
    View localView = paramView.findViewById(2131298003);
    TextView localTextView = (TextView)paramView.findViewById(2131298005);
    paramView = (ImageView)paramView.findViewById(2131298004);
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      ((Long)paramMessage.obj).longValue();
    }
    int i = localQavStateManager.a();
    boolean bool;
    if (localQavStateManager.b() == 2)
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.w("MultiVideoBarHelper", 1, "updateMultiVideoBar, sessionType[" + i + "], sessionStatus[" + localQavStateManager.a() + "], getSmallScreenState[" + localQavStateManager.b() + "]");
      }
      if (i != 1) {
        break label246;
      }
      if (!localQavStateManager.b()) {
        break label199;
      }
      localTextView.setText(2131363225);
    }
    for (;;)
    {
      UITools1.a(localView, paramQQAppInterface.a().getString(2131362898));
      SmallScreenUtils.a(localView, bool, paramBoolean);
      return;
      bool = false;
      break;
      label199:
      paramView = localQavStateManager.a();
      paramMessage = paramQQAppInterface.a().getString(2131363073);
      localTextView.setText(paramMessage + " " + paramView);
    }
    label246:
    if (i == 2)
    {
      if (localQavStateManager.b()) {
        localTextView.setText(2131363225);
      }
      for (;;)
      {
        UITools1.a(localView, paramQQAppInterface.a().getString(2131362898));
        SmallScreenUtils.a(localView, bool, paramBoolean);
        return;
        paramView = localQavStateManager.a();
        paramMessage = paramQQAppInterface.a().getString(2131363074);
        localTextView.setText(paramMessage + " " + paramView);
      }
    }
    SmallScreenUtils.a(localView, false, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.ui.bar.MultiVideoBarHelper
 * JD-Core Version:    0.7.0.1
 */