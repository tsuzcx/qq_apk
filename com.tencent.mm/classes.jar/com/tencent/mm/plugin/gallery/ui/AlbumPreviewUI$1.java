package com.tencent.mm.plugin.gallery.ui;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.plugin.gallery.stub.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class AlbumPreviewUI$1
  implements ServiceConnection
{
  AlbumPreviewUI$1(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    y.d("MicroMsg.AlbumPreviewUI", "onServiceConnected");
    AlbumPreviewUI.a(this.kIF, a.a.A(paramIBinder));
    if (AlbumPreviewUI.a(this.kIF) != null) {
      AlbumPreviewUI.a(this.kIF).kHB = AlbumPreviewUI.b(this.kIF);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    y.d("MicroMsg.AlbumPreviewUI", "onServiceDisconnected");
    AlbumPreviewUI.a(this.kIF, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.1
 * JD-Core Version:    0.7.0.1
 */