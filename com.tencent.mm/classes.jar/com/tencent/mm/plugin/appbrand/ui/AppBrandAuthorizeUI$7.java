package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fs;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

final class AppBrandAuthorizeUI$7
  implements Runnable
{
  AppBrandAuthorizeUI$7(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, boolean paramBoolean1, Preference paramPreference, boolean paramBoolean2, fs paramfs, f paramf) {}
  
  public final void run()
  {
    int i = 1;
    AppMethodBeat.i(132898);
    if (this.egM)
    {
      ((CheckBoxPreference)this.iLK).vxW = this.iLL;
      localObject = this.iLM;
      if (this.iLL) {}
      for (i = 1;; i = 2)
      {
        ((fs)localObject).state = i;
        this.iLN.notifyDataSetChanged();
        AppMethodBeat.o(132898);
        return;
      }
    }
    Object localObject = (CheckBoxPreference)this.iLK;
    boolean bool;
    if (!this.iLL)
    {
      bool = true;
      ((CheckBoxPreference)localObject).vxW = bool;
      localObject = this.iLM;
      if (this.iLL) {
        break label126;
      }
    }
    for (;;)
    {
      ((fs)localObject).state = i;
      this.iLN.notifyDataSetChanged();
      AppMethodBeat.o(132898);
      return;
      bool = false;
      break;
      label126:
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.7
 * JD-Core Version:    0.7.0.1
 */