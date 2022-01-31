package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h;
import com.tencent.mm.ai.h.a;
import com.tencent.mm.ai.h.b;
import com.tencent.mm.ai.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  implements h.a, h.b, SensorController.a
{
  static SensorController mub;
  private List<n.a> callbacks;
  private int cve;
  long lastShakeTime;
  public h mtU;
  private boolean mtV;
  private boolean mtW;
  private boolean mtX;
  bf mtY;
  boolean mtZ;
  private int mua;
  public String path;
  
  public n()
  {
    AppMethodBeat.i(102702);
    this.mtV = true;
    this.mtX = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.mtU = ((i)com.tencent.mm.kernel.g.E(i.class)).BP();
    Boolean localBoolean = (Boolean)com.tencent.mm.kernel.g.RL().Ru().get(26, Boolean.FALSE);
    this.mtW = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.mtV = bool;
      if (this.mtU == null) {
        break label185;
      }
      this.mtU.a(this);
      this.mtU.a(this);
      this.mtU.bx(this.mtV);
    }
    for (;;)
    {
      if (mub == null) {
        mub = new SensorController(ah.getContext());
      }
      if (this.mtY == null) {
        this.mtY = new bf(ah.getContext());
      }
      AppMethodBeat.o(102702);
      return;
      bool = false;
      break;
      label185:
      ab.w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
    }
  }
  
  private void bwC()
  {
    AppMethodBeat.i(102714);
    if (mub != null) {
      mub.dtJ();
    }
    if (this.mtY != null) {
      this.mtY.dtK();
    }
    AppMethodBeat.o(102714);
  }
  
  public final void Es()
  {
    AppMethodBeat.i(102713);
    ab.d("MicroMsg.FavVoiceLogic", "on completion, do stop play");
    stopPlay();
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((n.a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(102713);
  }
  
  public final void a(n.a parama)
  {
    AppMethodBeat.i(102703);
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      if (parama == (n.a)localIterator.next())
      {
        AppMethodBeat.o(102703);
        return;
      }
    }
    this.callbacks.add(parama);
    AppMethodBeat.o(102703);
  }
  
  public final boolean ad(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(102707);
    if (this.mtU == null)
    {
      ab.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(102707);
      return false;
    }
    this.mtU.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((n.a)((Iterator)localObject).next()).bK(paramString, paramInt2);
    }
    if ((mub != null) && (!mub.yqq))
    {
      mub.a(this);
      localObject = new n.2(this);
      if (!this.mtY.ai((Runnable)localObject)) {
        break label202;
      }
    }
    label202:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.cve = paramInt1;
      if ((bo.isNullOrNil(paramString)) || (!this.mtU.a(paramString, this.mtV, paramInt1, paramInt2))) {
        break;
      }
      aj.apk("keep_app_silent");
      com.tencent.mm.compatible.b.g.KC().d(this.mtV, false, false);
      AppMethodBeat.o(102707);
      return true;
    }
    AppMethodBeat.o(102707);
    return false;
  }
  
  public final boolean bwA()
  {
    AppMethodBeat.i(102709);
    ab.i("MicroMsg.FavVoiceLogic", "resume play");
    aj.apk("keep_app_silent");
    if (this.mtU == null)
    {
      ab.w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
      AppMethodBeat.o(102709);
      return false;
    }
    boolean bool = this.mtU.Eo();
    AppMethodBeat.o(102709);
    return bool;
  }
  
  public final boolean bwB()
  {
    AppMethodBeat.i(102710);
    ab.i("MicroMsg.FavVoiceLogic", "pause play");
    aj.apl("keep_app_silent");
    if (this.mtU == null)
    {
      ab.w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
      AppMethodBeat.o(102710);
      return false;
    }
    boolean bool = this.mtU.pause();
    AppMethodBeat.o(102710);
    return bool;
  }
  
  public final boolean bwz()
  {
    AppMethodBeat.i(102708);
    if (this.mtU == null)
    {
      ab.w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
      AppMethodBeat.o(102708);
      return false;
    }
    boolean bool = this.mtU.isPlaying();
    AppMethodBeat.o(102708);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(102704);
    pause();
    bwC();
    mub = null;
    this.callbacks.clear();
    AppMethodBeat.o(102704);
  }
  
  public final void hv(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(102715);
    if (bo.isNullOrNil(this.path))
    {
      AppMethodBeat.o(102715);
      return;
    }
    if (this.mtX)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.mtX = paramBoolean;
        AppMethodBeat.o(102715);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bo.av(this.lastShakeTime) > 400L))
    {
      this.mtX = true;
      AppMethodBeat.o(102715);
      return;
    }
    this.mtX = false;
    if ((this.mtU != null) && (this.mtU.Ep()))
    {
      AppMethodBeat.o(102715);
      return;
    }
    if (this.mtW)
    {
      if (this.mtU != null) {
        this.mtU.bx(false);
      }
      com.tencent.mm.compatible.b.g.KC().d(false, false, false);
      this.mtV = false;
      AppMethodBeat.o(102715);
      return;
    }
    if ((this.mtU != null) && (!this.mtU.isPlaying()) && (!this.mtZ))
    {
      this.mtU.bx(true);
      this.mtV = true;
      AppMethodBeat.o(102715);
      return;
    }
    if (com.tencent.mm.compatible.b.g.KC().KH())
    {
      ab.d("MicroMsg.FavVoiceLogic", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(102715);
      return;
    }
    if (this.mtU != null) {
      this.mtU.bx(paramBoolean);
    }
    this.mtV = paramBoolean;
    if ((this.mtZ) && (!paramBoolean))
    {
      ad(this.path, this.cve, this.mua);
      AppMethodBeat.o(102715);
      return;
    }
    if (!paramBoolean) {
      startPlay(this.path, this.cve);
    }
    AppMethodBeat.o(102715);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(102712);
    ab.d("MicroMsg.FavVoiceLogic", "on error, do stop play");
    stopPlay();
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((n.a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(102712);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(102705);
    if (this.mtU == null)
    {
      ab.w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
      AppMethodBeat.o(102705);
      return;
    }
    if (this.mtU.isPlaying()) {
      bwB();
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((n.a)localIterator.next()).onPause();
    }
    AppMethodBeat.o(102705);
  }
  
  public final boolean startPlay(String paramString, int paramInt)
  {
    AppMethodBeat.i(102706);
    if (this.mtU == null)
    {
      ab.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(102706);
      return false;
    }
    this.mtU.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((n.a)((Iterator)localObject).next()).bK(paramString, 0);
    }
    if ((mub != null) && (!mub.yqq))
    {
      mub.a(this);
      localObject = new n.1(this);
      if (!this.mtY.ai((Runnable)localObject)) {
        break label187;
      }
    }
    label187:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.cve = paramInt;
      if ((bo.isNullOrNil(paramString)) || (!this.mtU.a(paramString, this.mtV, true, paramInt))) {
        break;
      }
      aj.apk("keep_app_silent");
      AppMethodBeat.o(102706);
      return true;
    }
    AppMethodBeat.o(102706);
    return false;
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(102711);
    ab.d("MicroMsg.FavVoiceLogic", "stop play");
    aj.apl("keep_app_silent");
    if (this.mtU != null) {
      this.mtU.stop();
    }
    bwC();
    AppMethodBeat.o(102711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.n
 * JD-Core Version:    0.7.0.1
 */