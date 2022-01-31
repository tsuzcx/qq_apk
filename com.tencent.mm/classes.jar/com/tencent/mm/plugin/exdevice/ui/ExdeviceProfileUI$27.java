package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

final class ExdeviceProfileUI$27
  implements Runnable
{
  ExdeviceProfileUI$27(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(20054);
    a locala = ExdeviceProfileUI.l(this.lOl);
    ArrayList localArrayList = ExdeviceProfileUI.p(this.lOl);
    List localList = ExdeviceProfileUI.q(this.lOl);
    locala.lNl = ad.bqa().LC(locala.ikj);
    locala.lNo = localArrayList;
    if (!bo.es(localArrayList)) {}
    for (locala.lNm = localArrayList.size();; locala.lNm = 0)
    {
      locala.lNp = localList;
      if (!bo.es(localList)) {
        locala.lNn = localList.size();
      }
      ab.d("MicroMsg.ExdeviceProfileAdapter", "setData,mIsFollower:%s ,mFollowersNum:%s  ,mButtonNum:%s ,mUsername:%s", new Object[] { Boolean.valueOf(locala.lNl), Integer.valueOf(locala.lNm), Integer.valueOf(locala.lNn), locala.ikj });
      ExdeviceProfileUI.l(this.lOl).notifyDataSetChanged();
      AppMethodBeat.o(20054);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.27
 * JD-Core Version:    0.7.0.1
 */