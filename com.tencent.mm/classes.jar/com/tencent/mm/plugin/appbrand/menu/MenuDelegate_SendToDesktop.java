package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.os.Parcelable.Creator;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.s;

public final class MenuDelegate_SendToDesktop
  extends a<s>
{
  MenuDelegate_SendToDesktop()
  {
    super(o.gPs.ordinal());
  }
  
  private static final class SaveNoMoreShowPermissionNotifyStatusTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<SaveNoMoreShowPermissionNotifyStatusTask> CREATOR = new MenuDelegate_SendToDesktop.SaveNoMoreShowPermissionNotifyStatusTask.1();
    
    public SaveNoMoreShowPermissionNotifyStatusTask() {}
    
    public SaveNoMoreShowPermissionNotifyStatusTask(byte paramByte) {}
    
    public final void Zu()
    {
      e.aaY().bi("key_sendtodesktop_no_more_show_permission_notify_dialog", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.MenuDelegate_SendToDesktop
 * JD-Core Version:    0.7.0.1
 */