package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.protocal.protobuf.fv;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$9", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$SwitchResolutionListener;", "onHideSwitchResolutionLayout", "", "resolutionBtnClick", "switchResolution", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "beforeType", "", "afterType", "plugin-brandservice_release"})
public final class MPVideoView$n
  implements MPVideoViewControlBar.a
{
  public final void b(fv paramfv)
  {
    AppMethodBeat.i(266008);
    MPVideoView.k(this.sVn);
    this.sVn.setAutoPlay(this.sVn.isPlaying());
    int i = this.sVn.getCurrPosMs();
    MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.sVn);
    if (localMPExoVideoWrapper == null) {
      p.iCn();
    }
    if (paramfv == null) {
      p.iCn();
    }
    String str = paramfv.RKY;
    Log.i(MPExoVideoWrapper.TAG, "onSetResolution %b", new Object[] { Boolean.valueOf(localMPExoVideoWrapper.sUu) });
    localMPExoVideoWrapper.sUt = true;
    localMPExoVideoWrapper.sUe = str;
    Object localObject = localMPExoVideoWrapper.sUf;
    if (localObject != null)
    {
      localObject = ((MPExoVideoTextureView)localObject).getBitmap();
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label313;
      }
      ImageView localImageView = localMPExoVideoWrapper.sUb;
      if (localImageView != null) {
        localImageView.setImageBitmap((Bitmap)localObject);
      }
      label145:
      localObject = localMPExoVideoWrapper.sUc;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)localMPExoVideoWrapper.getContext().getString(d.i.svo, new Object[] { str }));
      }
      localMPExoVideoWrapper.cEy();
      localMPExoVideoWrapper.Ic(0L);
      localObject = MPVideoView.h(this.sVn);
      if (localObject == null) {
        p.iCn();
      }
      ((MPExoVideoWrapper)localObject).cEC();
      localObject = this.sVn;
      if (i != 0) {
        break label333;
      }
      i = 1;
    }
    label313:
    label333:
    for (;;)
    {
      ((MPVideoView)localObject).setInitialTime(i);
      localObject = this.sVn;
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
        break label336;
      }
      paramfv.hide();
      AppMethodBeat.o(266008);
      return;
      localObject = null;
      break;
      localObject = localMPExoVideoWrapper.sUb;
      if (localObject == null) {
        break label145;
      }
      ((ImageView)localObject).setImageResource(d.d.mm_trans);
      break label145;
    }
    label336:
    AppMethodBeat.o(266008);
  }
  
  public final void cEM()
  {
    AppMethodBeat.i(7497);
    MPVideoView.k(this.sVn);
    AppMethodBeat.o(7497);
  }
  
  public final void cEN()
  {
    AppMethodBeat.i(7499);
    MPVideoView.k(this.sVn);
    AppMethodBeat.o(7499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.n
 * JD-Core Version:    0.7.0.1
 */