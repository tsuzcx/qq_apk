package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import d.l;
import java.util.ArrayList;

@a(3)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/ui/VLogPreloadUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setWindowStyle", "Companion", "plugin-gallery_release"})
public final class VLogPreloadUI
  extends MMActivity
{
  public static final a ubj;
  private com.tencent.mm.ui.base.p mHs;
  
  static
  {
    AppMethodBeat.i(111806);
    ubj = new a((byte)0);
    AppMethodBeat.o(111806);
  }
  
  public final int getLayoutId()
  {
    return 2131495855;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111805);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    d.ow(true);
    getWindow().setFormat(-3);
    this.mHs = h.b((Context)getContext(), getString(2131760706), false, null);
    getIntent().getStringArrayListExtra("key_select_video_list");
    getIntent().getStringArrayListExtra("key_select_image_list");
    getIntent().getIntArrayExtra("index");
    paramBundle = al.fS((Context)this);
    Point localPoint = al.ck((Context)this);
    int i = getIntent().getIntExtra("KEY_PREVIEW_WIDTH", -1);
    int j = getIntent().getIntExtra("KEY_PREVIEW_HEIGHT", -1);
    ae.i("MicroMsg.VLogPreloadUI", "screen x:" + paramBundle.x + " y:" + paramBundle.y + "  realScreen x:" + localPoint.x + " y:" + localPoint.y + ", previewSize:" + i + ',' + j);
    AppMethodBeat.o(111805);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(186304);
    super.onDestroy();
    ae.i("MicroMsg.VLogPreloadUI", "VLogPreloadUI onDestroy");
    AppMethodBeat.o(186304);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/ui/VLogPreloadUI$Companion;", "", "()V", "INDEX", "", "TAG", "jumpToVLogPreloadUI", "", "context", "Landroid/content/Context;", "videoList", "Ljava/util/ArrayList;", "imageList", "index", "", "previewSize", "Landroid/graphics/Point;", "plugin-gallery_release"})
  public static final class a
  {
    public static void a(Context paramContext, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(186303);
      d.g.b.p.h(paramContext, "context");
      d.g.b.p.h(paramArrayList1, "videoList");
      d.g.b.p.h(paramArrayList2, "imageList");
      d.g.b.p.h(paramArrayOfInt, "index");
      Intent localIntent = new Intent(paramContext, VLogPreloadUI.class);
      localIntent.putStringArrayListExtra("key_select_video_list", paramArrayList1);
      localIntent.putStringArrayListExtra("key_select_image_list", paramArrayList2);
      localIntent.putExtra("index", paramArrayOfInt);
      ((Activity)paramContext).startActivityForResult(localIntent, 4381);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(186303);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.VLogPreloadUI
 * JD-Core Version:    0.7.0.1
 */