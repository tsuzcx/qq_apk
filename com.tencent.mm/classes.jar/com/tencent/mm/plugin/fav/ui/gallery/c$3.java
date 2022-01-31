package com.tencent.mm.plugin.fav.ui.gallery;

import android.os.Process;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.bo;

final class c$3
  extends RecyclerView.m
{
  private Runnable kGn;
  
  c$3(c paramc)
  {
    AppMethodBeat.i(74543);
    this.kGn = new c.3.1(this);
    AppMethodBeat.o(74543);
  }
  
  private void gh(boolean paramBoolean)
  {
    AppMethodBeat.i(74544);
    if (paramBoolean)
    {
      this.mCh.mBX.removeCallbacks(this.kGn);
      if (this.mCh.mBX.getVisibility() != 0)
      {
        this.mCh.mBX.clearAnimation();
        Animation localAnimation = AnimationUtils.loadAnimation(this.mCh.cup, 2131034181);
        this.mCh.mBX.setVisibility(0);
        this.mCh.mBX.startAnimation(localAnimation);
        AppMethodBeat.o(74544);
      }
    }
    else
    {
      this.mCh.mBX.removeCallbacks(this.kGn);
      this.mCh.mBX.postDelayed(this.kGn, 256L);
    }
    AppMethodBeat.o(74544);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74545);
    super.a(paramRecyclerView, paramInt1, paramInt2);
    Object localObject = (LinearLayoutManager)this.mCh.mBW.bgA();
    paramRecyclerView = (f)this.mCh.mBW.byo();
    localObject = paramRecyclerView.wb(((LinearLayoutManager)localObject).it());
    if (localObject == null)
    {
      AppMethodBeat.o(74545);
      return;
    }
    paramRecyclerView = paramRecyclerView.in(((f.c)localObject).timeStamp);
    this.mCh.mBX.setText(bo.bf(paramRecyclerView, ""));
    AppMethodBeat.o(74545);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(74546);
    int i;
    if (1 == paramInt)
    {
      gh(true);
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.mCh.eez);
      c localc = this.mCh;
      boolean bool = WXHardCoderJNI.hcMediaGalleryScrollEnable;
      int j = WXHardCoderJNI.hcMediaGalleryScrollDelay;
      int k = WXHardCoderJNI.hcMediaGalleryScrollCPU;
      int m = WXHardCoderJNI.hcMediaGalleryScrollIO;
      if (WXHardCoderJNI.hcMediaGalleryScrollThr)
      {
        i = Process.myTid();
        localc.eez = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
      }
    }
    for (;;)
    {
      if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
      {
        if ((((LinearLayoutManager)paramRecyclerView.getLayoutManager()).it() == 0) && (!this.mCh.kGk)) {
          this.mCh.mBW.v(false, -1);
        }
        this.mCh.kGk = false;
        o.ahG().bX(paramInt);
      }
      AppMethodBeat.o(74546);
      return;
      i = 0;
      break;
      if (paramInt == 0) {
        gh(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c.3
 * JD-Core Version:    0.7.0.1
 */