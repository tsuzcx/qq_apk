package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class AlbumPreviewUI$4
  implements AbsListView.OnScrollListener
{
  private Runnable khx = new AlbumPreviewUI.4.1(this);
  
  AlbumPreviewUI$4(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  private void gc(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AlbumPreviewUI.x(this.kIF).removeCallbacks(this.khx);
      if (AlbumPreviewUI.x(this.kIF).getVisibility() != 0)
      {
        Object localObject = AlbumPreviewUI.a(this.kIF).rT(AlbumPreviewUI.y(this.kIF).getFirstVisiblePosition());
        AlbumPreviewUI.x(this.kIF).setText((CharSequence)localObject);
        AlbumPreviewUI.x(this.kIF).clearAnimation();
        localObject = AnimationUtils.loadAnimation(this.kIF.mController.uMN, R.a.fast_faded_in);
        AlbumPreviewUI.x(this.kIF).setVisibility(0);
        AlbumPreviewUI.x(this.kIF).startAnimation((Animation)localObject);
      }
      return;
    }
    AlbumPreviewUI.x(this.kIF).removeCallbacks(this.khx);
    AlbumPreviewUI.x(this.kIF).postDelayed(this.khx, 256L);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = AlbumPreviewUI.a(this.kIF).rT(paramInt1);
    AlbumPreviewUI.x(this.kIF).setText(paramAbsListView);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    y.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (1 == paramInt) {
      gc(true);
    }
    for (;;)
    {
      if (2 == paramInt) {}
      try
      {
        AlbumPreviewUI.b(this.kIF).rQ(AlbumPreviewUI.z(this.kIF));
        AlbumPreviewUI.c(this.kIF, AlbumPreviewUI.b(this.kIF).aXI());
        return;
      }
      catch (Exception paramAbsListView)
      {
        y.printErrStackTrace("MicroMsg.AlbumPreviewUI", paramAbsListView, "", new Object[0]);
      }
      if (paramInt == 0) {
        gc(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.4
 * JD-Core Version:    0.7.0.1
 */