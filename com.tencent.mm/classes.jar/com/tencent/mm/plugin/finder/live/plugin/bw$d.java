package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.j;
import com.tencent.xweb.j.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenShareWidget$inputFileInfo$1", "Lcom/tencent/xweb/FileReaderXWeb$ActionCallback;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onPageChange", "pageIndex", "", "pageWidth", "pageHeight", "onPageCountUpdate", "totalCount", "onReachEnd", "onSingleTap", "onThumbnailLoad", "thumbnail", "Landroid/graphics/Bitmap;", "onUserCancel", "onUserOperated", "onViewStatusChange", "index", "zoom", "", "curWidth", "curHeight", "transX", "transY", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bw$d
  implements j.a
{
  bw$d(bw parambw) {}
  
  public final void Pc(int paramInt)
  {
    AppMethodBeat.i(354062);
    Log.i("FinderLiveScreenShareWidget", s.X("xfile onPageCountUpdate ", Integer.valueOf(paramInt)));
    AppMethodBeat.o(354062);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(354076);
    Log.i("FinderLiveScreenShareWidget", "xfile onViewStatusChange " + paramInt1 + " and pageWidth " + paramInt2 + " and pageHeight " + paramInt3 + " and scale " + paramFloat + " and transX " + paramInt4 + " and " + paramInt5);
    AppMethodBeat.o(354076);
  }
  
  public final void ay(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(354072);
    Log.i("FinderLiveScreenShareWidget", "xfile onPageChange " + paramInt1 + " and pageWidth " + paramInt2 + " and pageHeight " + paramInt3);
    bw.a(this.DiU, j.qT(bw.b(this.DiU), bw.c(this.DiU)));
    AppMethodBeat.o(354072);
  }
  
  public final void bSt()
  {
    AppMethodBeat.i(354067);
    Log.i("FinderLiveScreenShareWidget", "xfile on user cancel finish");
    AppMethodBeat.o(354067);
  }
  
  public final void c(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(354079);
    s.u(paramBitmap, "thumbnail");
    Log.i("FinderLiveScreenShareWidget", s.X("xfile onThumbnailLoad ", Integer.valueOf(paramInt)));
    AppMethodBeat.o(354079);
  }
  
  public final void erQ() {}
  
  public final void erR() {}
  
  public final void erS() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bw.d
 * JD-Core Version:    0.7.0.1
 */