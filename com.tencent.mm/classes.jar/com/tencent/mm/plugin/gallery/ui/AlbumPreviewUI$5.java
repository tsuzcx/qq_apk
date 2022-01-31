package com.tencent.mm.plugin.gallery.ui;

import android.os.Process;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class AlbumPreviewUI$5
  implements AbsListView.OnScrollListener
{
  private Runnable kGn;
  
  AlbumPreviewUI$5(AlbumPreviewUI paramAlbumPreviewUI)
  {
    AppMethodBeat.i(21393);
    this.kGn = new AlbumPreviewUI.5.1(this);
    AppMethodBeat.o(21393);
  }
  
  private String bEt()
  {
    AppMethodBeat.i(21394);
    String str = AlbumPreviewUI.a(this.neV).wP(AlbumPreviewUI.D(this.neV).getFirstVisiblePosition());
    if ((!bo.isNullOrNil(str)) && (str.equals("album_business_bubble_media_by_coordinate")))
    {
      str = AlbumPreviewUI.E(this.neV) + "附近的照片和视频";
      AppMethodBeat.o(21394);
      return str;
    }
    AppMethodBeat.o(21394);
    return str;
  }
  
  private void hU(boolean paramBoolean)
  {
    AppMethodBeat.i(21395);
    if (paramBoolean)
    {
      AlbumPreviewUI.C(this.neV).removeCallbacks(this.kGn);
      if (AlbumPreviewUI.C(this.neV).getVisibility() != 0)
      {
        AlbumPreviewUI.D(this.neV).getFirstVisiblePosition();
        Object localObject = bEt();
        AlbumPreviewUI.C(this.neV).setText((CharSequence)localObject);
        AlbumPreviewUI.C(this.neV).clearAnimation();
        localObject = AnimationUtils.loadAnimation(this.neV.getContext(), 2131034181);
        AlbumPreviewUI.C(this.neV).setVisibility(0);
        AlbumPreviewUI.C(this.neV).startAnimation((Animation)localObject);
        AppMethodBeat.o(21395);
      }
    }
    else
    {
      AlbumPreviewUI.C(this.neV).removeCallbacks(this.kGn);
      AlbumPreviewUI.C(this.neV).postDelayed(this.kGn, 256L);
    }
    AppMethodBeat.o(21395);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(21397);
    paramAbsListView = bEt();
    AlbumPreviewUI.C(this.neV).setText(paramAbsListView);
    AppMethodBeat.o(21397);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(21396);
    ab.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (1 == paramInt)
    {
      hU(true);
      AlbumPreviewUI.F(this.neV).setVisibility(8);
    }
    for (;;)
    {
      if (2 == paramInt)
      {
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, AlbumPreviewUI.G(this.neV));
        paramAbsListView = this.neV;
        boolean bool = WXHardCoderJNI.hcAlbumScrollEnable;
        int j = WXHardCoderJNI.hcAlbumScrollDelay;
        int k = WXHardCoderJNI.hcAlbumScrollCPU;
        int m = WXHardCoderJNI.hcAlbumScrollIO;
        paramInt = i;
        if (WXHardCoderJNI.hcAlbumScrollThr) {
          paramInt = Process.myTid();
        }
        AlbumPreviewUI.c(paramAbsListView, WXHardCoderJNI.startPerformance(bool, j, k, m, paramInt, WXHardCoderJNI.hcAlbumScrollTimeout, 702, WXHardCoderJNI.hcAlbumScrollAction, "MicroMsg.AlbumPreviewUI"));
      }
      AppMethodBeat.o(21396);
      return;
      if (paramInt == 0) {
        hU(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.5
 * JD-Core Version:    0.7.0.1
 */