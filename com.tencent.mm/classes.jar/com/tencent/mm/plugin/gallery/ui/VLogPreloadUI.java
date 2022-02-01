package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aoa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.io.Serializable;
import java.util.ArrayList;

@a(3)
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/ui/VLogPreloadUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setWindowStyle", "Companion", "plugin-gallery_release"})
public final class VLogPreloadUI
  extends MMActivity
{
  public static final a rLZ;
  private p lAj;
  
  static
  {
    AppMethodBeat.i(111806);
    rLZ = new a((byte)0);
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
    com.tencent.mm.plugin.mmsight.d.ne(true);
    getWindow().setFormat(-3);
    this.lAj = h.b((Context)getContext(), getString(2131764707), false, null);
    final ArrayList localArrayList1 = getIntent().getStringArrayListExtra("key_select_video_list");
    final ArrayList localArrayList2 = getIntent().getStringArrayListExtra("key_select_image_list");
    getIntent().getIntArrayExtra("index");
    paramBundle = ai.fv((Context)this);
    Object localObject = ai.cf((Context)this);
    int i = getIntent().getIntExtra("KEY_PREVIEW_WIDTH", -1);
    int j = getIntent().getIntExtra("KEY_PREVIEW_HEIGHT", -1);
    ad.i("MicroMsg.VLogPreloadUI", "screen x:" + paramBundle.x + " y:" + paramBundle.y + "  realScreen x:" + ((Point)localObject).x + " y:" + ((Point)localObject).y + ", previewSize:" + i + ',' + j);
    paramBundle = (Bundle)localObject;
    if (i > 0)
    {
      paramBundle = (Bundle)localObject;
      if (j > 0) {
        paramBundle = new Point(i, j);
      }
    }
    localObject = com.tencent.mm.plugin.vlog.ui.manager.d.zcE;
    com.tencent.mm.plugin.vlog.ui.manager.d.setPreviewSize(paramBundle.x, paramBundle.y);
    paramBundle = com.tencent.mm.plugin.vlog.ui.manager.d.zcE;
    paramBundle = com.tencent.mm.plugin.vlog.ui.manager.d.zcE;
    com.tencent.mm.plugin.vlog.ui.manager.d.w((b)new b(this, localArrayList1, localArrayList2));
    AppMethodBeat.o(111805);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200796);
    super.onDestroy();
    ad.i("MicroMsg.VLogPreloadUI", "VLogPreloadUI onDestroy");
    AppMethodBeat.o(200796);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/ui/VLogPreloadUI$Companion;", "", "()V", "INDEX", "", "TAG", "jumpToVLogPreloadUI", "", "context", "Landroid/content/Context;", "videoList", "Ljava/util/ArrayList;", "imageList", "index", "", "previewSize", "Landroid/graphics/Point;", "plugin-gallery_release"})
  public static final class a
  {
    public static void a(Context paramContext, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(200795);
      k.h(paramContext, "context");
      k.h(paramArrayList1, "videoList");
      k.h(paramArrayList2, "imageList");
      k.h(paramArrayOfInt, "index");
      Intent localIntent = new Intent(paramContext, VLogPreloadUI.class);
      localIntent.putStringArrayListExtra("key_select_video_list", paramArrayList1);
      localIntent.putStringArrayListExtra("key_select_image_list", paramArrayList2);
      localIntent.putExtra("index", paramArrayOfInt);
      ((Activity)paramContext).startActivityForResult(localIntent, 4381);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      AppMethodBeat.o(200795);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<aoa, y>
  {
    b(VLogPreloadUI paramVLogPreloadUI, ArrayList paramArrayList1, ArrayList paramArrayList2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.VLogPreloadUI
 * JD-Core Version:    0.7.0.1
 */