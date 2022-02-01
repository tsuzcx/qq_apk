package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/ui/VLogPreloadUI$Companion;", "", "()V", "INDEX", "", "TAG", "jumpToVLogPreloadUI", "", "context", "Landroid/content/Context;", "videoList", "Ljava/util/ArrayList;", "imageList", "index", "", "previewSize", "Landroid/graphics/Point;", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VLogPreloadUI$a
{
  public static void a(Context paramContext, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(289558);
    s.u(paramContext, "context");
    s.u(paramArrayList1, "videoList");
    s.u(paramArrayList2, "imageList");
    s.u(paramArrayOfInt, "index");
    Intent localIntent = new Intent(paramContext, VLogPreloadUI.class);
    localIntent.putStringArrayListExtra("key_select_video_list", paramArrayList1);
    localIntent.putStringArrayListExtra("key_select_image_list", paramArrayList2);
    localIntent.putExtra("index", paramArrayOfInt);
    com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, c.a(4381, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/gallery/ui/VLogPreloadUI$Companion", "jumpToVLogPreloadUI", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/util/ArrayList;[ILandroid/graphics/Point;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    ((Activity)paramContext).overridePendingTransition(0, 0);
    AppMethodBeat.o(289558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.VLogPreloadUI.a
 * JD-Core Version:    0.7.0.1
 */