package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.vlog.ui.manager.c;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.io.Serializable;
import java.util.ArrayList;

@a(3)
@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/ui/VLogPreloadUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setWindowStyle", "Companion", "plugin-gallery_release"})
public final class VLogPreloadUI
  extends MMActivity
{
  public static final a sTO;
  private p mcf;
  
  static
  {
    AppMethodBeat.i(111806);
    sTO = new a((byte)0);
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
    d.nX(true);
    getWindow().setFormat(-3);
    this.mcf = h.b((Context)getContext(), getString(2131764707), false, null);
    final ArrayList localArrayList1 = getIntent().getStringArrayListExtra("key_select_video_list");
    final ArrayList localArrayList2 = getIntent().getStringArrayListExtra("key_select_image_list");
    getIntent().getIntArrayExtra("index");
    paramBundle = aj.fH((Context)this);
    Object localObject = aj.cl((Context)this);
    int i = getIntent().getIntExtra("KEY_PREVIEW_WIDTH", -1);
    int j = getIntent().getIntExtra("KEY_PREVIEW_HEIGHT", -1);
    ac.i("MicroMsg.VLogPreloadUI", "screen x:" + paramBundle.x + " y:" + paramBundle.y + "  realScreen x:" + ((Point)localObject).x + " y:" + ((Point)localObject).y + ", previewSize:" + i + ',' + j);
    paramBundle = (Bundle)localObject;
    if (i > 0)
    {
      paramBundle = (Bundle)localObject;
      if (j > 0) {
        paramBundle = new Point(i, j);
      }
    }
    localObject = c.AsH;
    c.setPreviewSize(paramBundle.x, paramBundle.y);
    paramBundle = c.AsH;
    paramBundle = c.AsH;
    c.E((b)new b(this, localArrayList1, localArrayList2));
    AppMethodBeat.o(111805);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198534);
    super.onDestroy();
    ac.i("MicroMsg.VLogPreloadUI", "VLogPreloadUI onDestroy");
    AppMethodBeat.o(198534);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/ui/VLogPreloadUI$Companion;", "", "()V", "INDEX", "", "TAG", "jumpToVLogPreloadUI", "", "context", "Landroid/content/Context;", "videoList", "Ljava/util/ArrayList;", "imageList", "index", "", "previewSize", "Landroid/graphics/Point;", "plugin-gallery_release"})
  public static final class a
  {
    public static void a(Context paramContext, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(198533);
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
      AppMethodBeat.o(198533);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<are, y>
  {
    b(VLogPreloadUI paramVLogPreloadUI, ArrayList paramArrayList1, ArrayList paramArrayList2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.VLogPreloadUI
 * JD-Core Version:    0.7.0.1
 */