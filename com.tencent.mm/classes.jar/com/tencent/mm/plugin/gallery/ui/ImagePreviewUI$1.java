package com.tencent.mm.plugin.gallery.ui;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.plugin.gallery.stub.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class ImagePreviewUI$1
  implements ServiceConnection
{
  ImagePreviewUI$1(ImagePreviewUI paramImagePreviewUI) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    y.d("MicroMsg.ImagePreviewUI", "onServiceConnected");
    ImagePreviewUI.a(this.kKb, a.a.A(paramIBinder));
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    y.d("MicroMsg.ImagePreviewUI", "onServiceDisconnected");
    ImagePreviewUI.a(this.kKb, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.1
 * JD-Core Version:    0.7.0.1
 */