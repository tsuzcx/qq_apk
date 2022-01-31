package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.dynamic.h.a;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.dynamic.widget.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class a$b$4
  implements Runnable
{
  a$b$4(a.b paramb, String paramString1, a.a parama, LinkedList paramLinkedList, String paramString2, String paramString3) {}
  
  public final void run()
  {
    int i = 1;
    Object localObject = a.afw().tj(this.fVe);
    if (localObject == null) {
      y.e("MicroMsg.IPCInvoke_DoAuthorize", "dynamicPageView not found! widgetid[%s]", new Object[] { this.fVe });
    }
    for (;;)
    {
      return;
      localObject = new b(((IPCDynamicPageView)localObject).getContext());
      a.b.4.1 local1 = new a.b.4.1(this);
      if ((this.fVj != null) && (this.fVj.size() > 0))
      {
        LinkedList localLinkedList = this.fVj;
        String str1 = this.fEt;
        String str2 = this.fVk;
        y.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
        ((b)localObject).mAppName = str1;
        ((b)localObject).fXS = str2;
        if (((b)localObject).a(localLinkedList, local1)) {
          break label162;
        }
      }
      while (i != 0)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("retCode", -2);
        this.fVi.g((Bundle)localObject);
        return;
        y.e("MicroMsg.IPCInvoke_DoAuthorize", "scopeInfoList is empty!");
        continue;
        label162:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.b.4
 * JD-Core Version:    0.7.0.1
 */