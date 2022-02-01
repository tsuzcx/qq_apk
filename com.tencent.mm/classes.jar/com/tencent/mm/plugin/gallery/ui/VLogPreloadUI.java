package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import kotlin.Metadata;

@a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/ui/VLogPreloadUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setWindowStyle", "Companion", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VLogPreloadUI
  extends MMActivity
{
  public static final VLogPreloadUI.a HQX;
  private w rYw;
  
  static
  {
    AppMethodBeat.i(111806);
    HQX = new VLogPreloadUI.a((byte)0);
    AppMethodBeat.o(111806);
  }
  
  public final int getLayoutId()
  {
    return b.f.vlog_preload_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111805);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    d.ys(true);
    getWindow().setFormat(-3);
    this.rYw = k.a((Context)getContext(), getString(b.i.loading), false, null);
    getIntent().getStringArrayListExtra("key_select_video_list");
    getIntent().getStringArrayListExtra("key_select_image_list");
    getIntent().getIntArrayExtra("index");
    paramBundle = aw.iQ((Context)this);
    Point localPoint = aw.bf((Context)this);
    int i = getIntent().getIntExtra("KEY_PREVIEW_WIDTH", -1);
    int j = getIntent().getIntExtra("KEY_PREVIEW_HEIGHT", -1);
    Log.i("MicroMsg.VLogPreloadUI", "screen x:" + paramBundle.x + " y:" + paramBundle.y + "  realScreen x:" + localPoint.x + " y:" + localPoint.y + ", previewSize:" + i + ',' + j);
    AppMethodBeat.o(111805);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(289505);
    super.onDestroy();
    Log.i("MicroMsg.VLogPreloadUI", "VLogPreloadUI onDestroy");
    AppMethodBeat.o(289505);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.VLogPreloadUI
 * JD-Core Version:    0.7.0.1
 */