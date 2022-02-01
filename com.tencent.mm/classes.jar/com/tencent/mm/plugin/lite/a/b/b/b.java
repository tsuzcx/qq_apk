package com.tencent.mm.plugin.lite.a.b.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ay.a.a;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.webview.core.f;
import com.tencent.mm.plugin.webview.core.o;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

public final class b
{
  j JZX;
  public long JZY;
  
  public b()
  {
    AppMethodBeat.i(271554);
    this.JZY = 0L;
    Object localObject = JsapiPermissionWrapper.YxF;
    final int i = hashCode();
    final j localj = new j(null, null, i, c.a.fUa());
    Bundle localBundle = new Bundle();
    localBundle.putString("name", "liteapp");
    localBundle.putString("appId", "wxaliteapp");
    localj.a((JsapiPermissionWrapper)localObject, localBundle);
    localObject = o.WzA;
    o.a(true, WebViewStubService.class, new f()
    {
      public final void a(com.tencent.mm.plugin.webview.core.e paramAnonymouse)
      {
        AppMethodBeat.i(271552);
        localj.sLC = paramAnonymouse.irJ();
        try
        {
          paramAnonymouse.irJ().a(new b.a(b.this, localj, jdField_this), i);
          label52:
          localj.Iy(true);
          AppMethodBeat.o(271552);
          return;
        }
        catch (Exception paramAnonymouse)
        {
          break label52;
        }
      }
      
      public final boolean fTZ()
      {
        return false;
      }
    });
    this.JZX = localj;
    AppMethodBeat.o(271554);
  }
  
  final class a
    extends a.a
  {
    private b Kad;
    
    public a(j paramj, b paramb)
    {
      super();
      this.Kad = paramb;
    }
    
    public final void aF(Bundle paramBundle)
    {
      AppMethodBeat.i(271562);
      Intent localIntent = new Intent();
      localIntent.putExtra("result_data", paramBundle);
      LiteAppCenter.closeWindow(this.Kad.JZY, localIntent);
      AppMethodBeat.o(271562);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */