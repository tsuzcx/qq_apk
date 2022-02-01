package com.tencent.mm.plugin.brandservice.ui.widget;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.protocal.protobuf.fv;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$10", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$SwitchSpeedListener;", "onHideSwitchSpeedLayout", "", "speedBtnClick", "switchSpeed", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
public final class MPVideoView$f
  implements MPVideoViewControlBar.b
{
  public final void a(fv paramfv)
  {
    AppMethodBeat.i(179029);
    MPVideoView.k(this.sVn);
    this.sVn.setAutoPlay(this.sVn.isPlaying());
    int j = this.sVn.getCurrPosMs();
    MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.sVn);
    if (localMPExoVideoWrapper == null) {
      p.iCn();
    }
    Object localObject = localMPExoVideoWrapper.sUf;
    if (localObject != null)
    {
      localObject = ((MPExoVideoTextureView)localObject).getBitmap();
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label264;
      }
      ImageView localImageView = localMPExoVideoWrapper.sUb;
      if (localImageView != null) {
        localImageView.setImageBitmap((Bitmap)localObject);
      }
    }
    for (;;)
    {
      localObject = localMPExoVideoWrapper.sUb;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      localMPExoVideoWrapper.Ic(0L);
      localObject = MPVideoView.h(this.sVn);
      if (localObject == null) {
        p.iCn();
      }
      ((MPExoVideoWrapper)localObject).cEC();
      localObject = this.sVn;
      int i = j;
      if (j == 0) {
        i = 1;
      }
      ((MPVideoView)localObject).setInitialTime(i);
      localObject = this.sVn;
      if (paramfv == null) {
        p.iCn();
      }
      paramfv = paramfv.url;
      p.j(paramfv, "info!!.url");
      ((MPVideoView)localObject).dh(paramfv, this.sVn.getDuration());
      if (!MPVideoView.E(this.sVn))
      {
        paramfv = MPVideoView.h(this.sVn);
        if (paramfv == null) {
          p.iCn();
        }
        paramfv.pause();
      }
      paramfv = MPVideoView.c(this.sVn);
      if (paramfv == null) {
        break label287;
      }
      paramfv.hide();
      AppMethodBeat.o(179029);
      return;
      localObject = null;
      break;
      label264:
      localObject = localMPExoVideoWrapper.sUb;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(d.d.mm_trans);
      }
    }
    label287:
    AppMethodBeat.o(179029);
  }
  
  public final void cEK()
  {
    AppMethodBeat.i(179030);
    MPVideoView.k(this.sVn);
    AppMethodBeat.o(179030);
  }
  
  public final void cEL()
  {
    AppMethodBeat.i(179031);
    MPVideoView.k(this.sVn);
    AppMethodBeat.o(179031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.f
 * JD-Core Version:    0.7.0.1
 */