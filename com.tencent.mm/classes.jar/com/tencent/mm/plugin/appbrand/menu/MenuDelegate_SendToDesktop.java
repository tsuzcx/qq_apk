package com.tencent.mm.plugin.appbrand.menu;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.base.model.c.a;
import com.tencent.mm.plugin.report.service.h;

public final class MenuDelegate_SendToDesktop
  extends com.tencent.mm.plugin.appbrand.menu.a.a<z>
{
  MenuDelegate_SendToDesktop()
  {
    super(r.ira.ordinal());
    AppMethodBeat.i(132233);
    AppMethodBeat.o(132233);
  }
  
  static final class SaveNoMoreShowPermissionNotifyStatusTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<SaveNoMoreShowPermissionNotifyStatusTask> CREATOR;
    
    static
    {
      AppMethodBeat.i(132232);
      CREATOR = new MenuDelegate_SendToDesktop.SaveNoMoreShowPermissionNotifyStatusTask.1();
      AppMethodBeat.o(132232);
    }
    
    public SaveNoMoreShowPermissionNotifyStatusTask() {}
    
    public SaveNoMoreShowPermissionNotifyStatusTask(byte paramByte) {}
    
    public final void ata()
    {
      AppMethodBeat.i(132231);
      g.wg().bG("key_sendtodesktop_no_more_show_permission_notify_dialog", "1");
      AppMethodBeat.o(132231);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.MenuDelegate_SendToDesktop
 * JD-Core Version:    0.7.0.1
 */