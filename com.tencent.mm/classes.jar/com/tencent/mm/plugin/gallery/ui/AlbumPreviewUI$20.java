package com.tencent.mm.plugin.gallery.ui;

import android.os.Process;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.p;
import com.tencent.mm.plugin.gallery.model.p.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

final class AlbumPreviewUI$20
  extends RecyclerView.l
{
  private Runnable tNY;
  
  AlbumPreviewUI$20(AlbumPreviewUI paramAlbumPreviewUI, GridLayoutManager paramGridLayoutManager)
  {
    AppMethodBeat.i(242979);
    this.tNY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111440);
        if (AlbumPreviewUI.p(AlbumPreviewUI.20.this.CaZ).getVisibility() == 0) {
          AlbumPreviewUI.p(AlbumPreviewUI.20.this.CaZ).animate().alpha(0.0F).setDuration(300L).withEndAction(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(111439);
              AlbumPreviewUI.p(AlbumPreviewUI.20.this.CaZ).setVisibility(4);
              AppMethodBeat.o(111439);
            }
          }).start();
        }
        AppMethodBeat.o(111440);
      }
    };
    AppMethodBeat.o(242979);
  }
  
  private String euD()
  {
    AppMethodBeat.i(111442);
    String str = this.CaZ.Cai.SZ(this.Cbe.kJ());
    if ((!Util.isNullOrNil(str)) && (str.equals("album_business_bubble_media_by_coordinate")))
    {
      str = AlbumPreviewUI.q(this.CaZ) + "附近的照片和视频";
      AppMethodBeat.o(111442);
      return str;
    }
    AppMethodBeat.o(111442);
    return str;
  }
  
  private void rX(boolean paramBoolean)
  {
    AppMethodBeat.i(111443);
    if (paramBoolean)
    {
      AlbumPreviewUI.p(this.CaZ).removeCallbacks(this.tNY);
      if (AlbumPreviewUI.p(this.CaZ).getVisibility() != 0)
      {
        String str = euD();
        AlbumPreviewUI.p(this.CaZ).setText(str);
        AlbumPreviewUI.p(this.CaZ).setVisibility(0);
        AlbumPreviewUI.p(this.CaZ).setAlpha(0.0F);
        AlbumPreviewUI.p(this.CaZ).animate().alpha(1.0F).setDuration(300L).start();
        AppMethodBeat.o(111443);
      }
    }
    else
    {
      AlbumPreviewUI.p(this.CaZ).removeCallbacks(this.tNY);
      AlbumPreviewUI.p(this.CaZ).postDelayed(this.tNY, 256L);
    }
    AppMethodBeat.o(111443);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(242985);
    b localb = new b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
    Log.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (1 == paramInt)
    {
      rX(true);
      AlbumPreviewUI.r(this.CaZ).setVisibility(8);
      com.tencent.mm.plugin.gallery.model.e.etk().etf();
    }
    do
    {
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(242985);
        return;
        if (paramInt != 0) {
          break;
        }
        rX(false);
        AlbumPreviewUI.a(this.CaZ, this.Cbe.kJ());
        AlbumPreviewUI.b(this.CaZ, this.Cbe.kL());
        Log.d("MicroMsg.AlbumPreviewUI", "cancelTask logic, firstVisibleItem: %s lastVisibleItem: %s.", new Object[] { Integer.valueOf(AlbumPreviewUI.s(this.CaZ)), Integer.valueOf(AlbumPreviewUI.t(this.CaZ)) });
        paramRecyclerView = p.BVL;
        p.etV().a(p.c.BVO, AlbumPreviewUI.s(this.CaZ), AlbumPreviewUI.t(this.CaZ), this.CaZ.Cai.BZG.size());
      }
    } while (2 != paramInt);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, AlbumPreviewUI.u(this.CaZ));
    paramRecyclerView = this.CaZ;
    boolean bool = WXHardCoderJNI.hcAlbumScrollEnable;
    int i = WXHardCoderJNI.hcAlbumScrollDelay;
    int j = WXHardCoderJNI.hcAlbumScrollCPU;
    int k = WXHardCoderJNI.hcAlbumScrollIO;
    if (WXHardCoderJNI.hcAlbumScrollThr) {}
    for (paramInt = Process.myTid();; paramInt = 0)
    {
      AlbumPreviewUI.c(paramRecyclerView, WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt, WXHardCoderJNI.hcAlbumScrollTimeout, 702, WXHardCoderJNI.hcAlbumScrollAction, "MicroMsg.AlbumPreviewUI"));
      break;
    }
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242987);
    Object localObject = new b();
    ((b)localObject).bn(paramRecyclerView);
    ((b)localObject).sg(paramInt1);
    ((b)localObject).sg(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((b)localObject).aFi());
    paramRecyclerView = euD();
    AlbumPreviewUI.p(this.CaZ).setText(paramRecyclerView);
    paramInt1 = this.Cbe.kJ();
    int i = this.Cbe.kL();
    Log.d("MicroMsg.AlbumPreviewUI", "pennqin, onScrolled, %s %s %s %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(AlbumPreviewUI.s(this.CaZ)), Integer.valueOf(AlbumPreviewUI.t(this.CaZ)) });
    if ((AlbumPreviewUI.s(this.CaZ) != paramInt1) || (AlbumPreviewUI.t(this.CaZ) != i))
    {
      AlbumPreviewUI.a(this.CaZ, paramInt1);
      AlbumPreviewUI.b(this.CaZ, i);
      paramRecyclerView = new ArrayList();
      paramInt1 = AlbumPreviewUI.s(this.CaZ);
      while (paramInt1 <= AlbumPreviewUI.t(this.CaZ))
      {
        localObject = this.CaZ.Cai.SY(paramInt1);
        if (localObject != null) {
          paramRecyclerView.add(com.tencent.mm.plugin.gallery.a.e.a(((GalleryItem.MediaItem)localObject).aZe(), null, -1));
        }
        paramInt1 += 1;
      }
      Log.d("MicroMsg.AlbumPreviewUI", "cancelTask, legalPaths size: %s.", new Object[] { Integer.valueOf(paramRecyclerView.size()) });
      com.tencent.mm.plugin.gallery.model.e.etk().fj(paramRecyclerView);
      if (paramInt2 != 0)
      {
        if (paramInt2 >= 0) {
          break label389;
        }
        AlbumPreviewUI.a(this.CaZ, p.c.BVP);
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.AlbumPreviewUI", "onScrolled, dy: %s state: %s.", new Object[] { Integer.valueOf(paramInt2), AlbumPreviewUI.v(this.CaZ) });
      paramRecyclerView = p.BVL;
      p.etV().a(AlbumPreviewUI.v(this.CaZ), AlbumPreviewUI.s(this.CaZ), AlbumPreviewUI.t(this.CaZ), this.CaZ.Cai.BZG.size());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI$8", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(242987);
      return;
      label389:
      AlbumPreviewUI.a(this.CaZ, p.c.BVQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.20
 * JD-Core Version:    0.7.0.1
 */