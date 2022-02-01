package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@a(3)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/ui/VLogPreloadUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setWindowStyle", "Companion", "plugin-gallery_release"})
public final class VLogPreloadUI
  extends MMActivity
{
  public static final a xsx;
  private q nUq;
  
  static
  {
    AppMethodBeat.i(111806);
    xsx = new a((byte)0);
    AppMethodBeat.o(111806);
  }
  
  public final int getLayoutId()
  {
    return 2131496829;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111805);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    d.rb(true);
    getWindow().setFormat(-3);
    this.nUq = h.a((Context)getContext(), getString(2131762443), false, null);
    getIntent().getStringArrayListExtra("key_select_video_list");
    getIntent().getStringArrayListExtra("key_select_image_list");
    getIntent().getIntArrayExtra("index");
    paramBundle = ao.gx((Context)this);
    Point localPoint = ao.az((Context)this);
    int i = getIntent().getIntExtra("KEY_PREVIEW_WIDTH", -1);
    int j = getIntent().getIntExtra("KEY_PREVIEW_HEIGHT", -1);
    Log.i("MicroMsg.VLogPreloadUI", "screen x:" + paramBundle.x + " y:" + paramBundle.y + "  realScreen x:" + localPoint.x + " y:" + localPoint.y + ", previewSize:" + i + ',' + j);
    AppMethodBeat.o(111805);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(257870);
    super.onDestroy();
    Log.i("MicroMsg.VLogPreloadUI", "VLogPreloadUI onDestroy");
    AppMethodBeat.o(257870);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/ui/VLogPreloadUI$Companion;", "", "()V", "INDEX", "", "TAG", "jumpToVLogPreloadUI", "", "context", "Landroid/content/Context;", "videoList", "Ljava/util/ArrayList;", "imageList", "index", "", "previewSize", "Landroid/graphics/Point;", "plugin-gallery_release"})
  public static final class a
  {
    public static void a(Context paramContext, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(257869);
      p.h(paramContext, "context");
      p.h(paramArrayList1, "videoList");
      p.h(paramArrayList2, "imageList");
      p.h(paramArrayOfInt, "index");
      Intent localIntent = new Intent(paramContext, VLogPreloadUI.class);
      localIntent.putStringArrayListExtra("key_select_video_list", paramArrayList1);
      localIntent.putStringArrayListExtra("key_select_image_list", paramArrayList2);
      localIntent.putExtra("index", paramArrayOfInt);
      ((Activity)paramContext).startActivityForResult(localIntent, 4381);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(257869);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.VLogPreloadUI
 * JD-Core Version:    0.7.0.1
 */