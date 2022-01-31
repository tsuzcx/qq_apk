package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

final class ExdeviceProfileUI$27
  implements Runnable
{
  ExdeviceProfileUI$27(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void run()
  {
    a locala = ExdeviceProfileUI.l(this.jEM);
    ArrayList localArrayList = ExdeviceProfileUI.p(this.jEM);
    List localList = ExdeviceProfileUI.q(this.jEM);
    locala.jDN = ad.aLN().BA(locala.hcm);
    locala.jDQ = localArrayList;
    if (!bk.dk(localArrayList)) {}
    for (locala.jDO = localArrayList.size();; locala.jDO = 0)
    {
      locala.jDR = localList;
      if (!bk.dk(localList)) {
        locala.jDP = localList.size();
      }
      y.d("MicroMsg.ExdeviceProfileAdapter", "setData,mIsFollower:%s ,mFollowersNum:%s  ,mButtonNum:%s ,mUsername:%s", new Object[] { Boolean.valueOf(locala.jDN), Integer.valueOf(locala.jDO), Integer.valueOf(locala.jDP), locala.hcm });
      ExdeviceProfileUI.l(this.jEM).notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.27
 * JD-Core Version:    0.7.0.1
 */