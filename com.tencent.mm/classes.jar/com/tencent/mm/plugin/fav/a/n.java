package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ah.h;
import com.tencent.mm.ah.h.a;
import com.tencent.mm.ah.h.b;
import com.tencent.mm.ah.i;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  implements h.a, h.b, SensorController.a
{
  static SensorController iah;
  private int bNM;
  private List<n.a> dhm = new LinkedList();
  private boolean iak = true;
  bb ial;
  long iam = -1L;
  private boolean ian;
  private boolean iar = false;
  public h jZC = ((i)g.r(i.class)).tl();
  boolean jZD;
  private int jZE;
  public String path;
  
  public n()
  {
    Boolean localBoolean = (Boolean)g.DP().Dz().get(26, Boolean.valueOf(false));
    this.ian = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.iak = bool;
      if (this.jZC == null) {
        break label176;
      }
      this.jZC.a(this);
      this.jZC.a(this);
      this.jZC.aV(this.iak);
    }
    for (;;)
    {
      if (iah == null) {
        iah = new SensorController(ae.getContext());
      }
      if (this.ial == null) {
        this.ial = new bb(ae.getContext());
      }
      return;
      bool = false;
      break;
      label176:
      y.w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
    }
  }
  
  private void axa()
  {
    if (iah != null) {
      iah.crJ();
    }
    if (this.ial != null) {
      this.ial.crK();
    }
  }
  
  public final boolean P(String paramString, int paramInt1, int paramInt2)
  {
    if (this.jZC == null)
    {
      y.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt1) });
      return false;
    }
    this.jZC.stop();
    Object localObject = this.dhm.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((n.a)((Iterator)localObject).next()).bj(paramString, paramInt2);
    }
    if ((iah != null) && (!iah.uil))
    {
      iah.a(this);
      localObject = new n.2(this);
      if (!this.ial.W((Runnable)localObject)) {
        break label187;
      }
    }
    label187:
    for (this.iam = 0L;; this.iam = -1L)
    {
      this.path = paramString;
      this.bNM = paramInt1;
      if ((bk.bl(paramString)) || (!this.jZC.a(paramString, this.iak, paramInt1, paramInt2))) {
        break;
      }
      ag.Zm("keep_app_silent");
      f.yi().f(this.iak, false, false);
      return true;
    }
    return false;
  }
  
  public final void a(n.a parama)
  {
    Iterator localIterator = this.dhm.iterator();
    while (localIterator.hasNext()) {
      if (parama == (n.a)localIterator.next()) {
        return;
      }
    }
    this.dhm.add(parama);
  }
  
  public final boolean aQk()
  {
    if (this.jZC == null)
    {
      y.w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
      return false;
    }
    return this.jZC.isPlaying();
  }
  
  public final boolean aQl()
  {
    y.i("MicroMsg.FavVoiceLogic", "resume play");
    ag.Zm("keep_app_silent");
    if (this.jZC == null)
    {
      y.w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
      return false;
    }
    return this.jZC.ub();
  }
  
  public final boolean aQm()
  {
    y.i("MicroMsg.FavVoiceLogic", "pause play");
    ag.Zn("keep_app_silent");
    if (this.jZC == null)
    {
      y.w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
      return false;
    }
    return this.jZC.pause();
  }
  
  public final void destroy()
  {
    pause();
    axa();
    iah = null;
    this.dhm.clear();
  }
  
  public final void eq(boolean paramBoolean)
  {
    boolean bool = true;
    if (bk.bl(this.path)) {}
    do
    {
      do
      {
        return;
        if (this.iar)
        {
          if (!paramBoolean) {}
          for (paramBoolean = bool;; paramBoolean = false)
          {
            this.iar = paramBoolean;
            return;
          }
        }
        if ((!paramBoolean) && (this.iam != -1L) && (bk.cp(this.iam) > 400L))
        {
          this.iar = true;
          return;
        }
        this.iar = false;
      } while ((this.jZC != null) && (this.jZC.uc()));
      if (this.ian)
      {
        if (this.jZC != null) {
          this.jZC.aV(false);
        }
        f.yi().f(false, false, false);
        this.iak = false;
        return;
      }
      if ((this.jZC != null) && (!this.jZC.isPlaying()) && (!this.jZD))
      {
        this.jZC.aV(true);
        this.iak = true;
        return;
      }
      if (this.jZC != null) {
        this.jZC.aV(paramBoolean);
      }
      this.iak = paramBoolean;
      if ((this.jZD) && (!paramBoolean))
      {
        P(this.path, this.bNM, this.jZE);
        return;
      }
    } while (paramBoolean);
    startPlay(this.path, this.bNM);
  }
  
  public final void onError()
  {
    y.d("MicroMsg.FavVoiceLogic", "on error, do stop play");
    stopPlay();
    Iterator localIterator = this.dhm.iterator();
    while (localIterator.hasNext()) {
      ((n.a)localIterator.next()).onFinish();
    }
  }
  
  public final void pause()
  {
    if (this.jZC == null) {
      y.w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
    }
    for (;;)
    {
      return;
      if (this.jZC.isPlaying()) {
        aQm();
      }
      Iterator localIterator = this.dhm.iterator();
      while (localIterator.hasNext()) {
        ((n.a)localIterator.next()).onPause();
      }
    }
  }
  
  public final boolean startPlay(String paramString, int paramInt)
  {
    if (this.jZC == null)
    {
      y.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      return false;
    }
    this.jZC.stop();
    Object localObject = this.dhm.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((n.a)((Iterator)localObject).next()).bj(paramString, 0);
    }
    if ((iah != null) && (!iah.uil))
    {
      iah.a(this);
      localObject = new n.1(this);
      if (!this.ial.W((Runnable)localObject)) {
        break label169;
      }
    }
    label169:
    for (this.iam = 0L;; this.iam = -1L)
    {
      this.path = paramString;
      this.bNM = paramInt;
      if ((bk.bl(paramString)) || (!this.jZC.a(paramString, this.iak, true, paramInt))) {
        break;
      }
      ag.Zm("keep_app_silent");
      return true;
    }
    return false;
  }
  
  public final void stopPlay()
  {
    y.d("MicroMsg.FavVoiceLogic", "stop play");
    ag.Zn("keep_app_silent");
    if (this.jZC != null) {
      this.jZC.stop();
    }
    axa();
  }
  
  public final void ug()
  {
    y.d("MicroMsg.FavVoiceLogic", "on completion, do stop play");
    stopPlay();
    Iterator localIterator = this.dhm.iterator();
    while (localIterator.hasNext()) {
      ((n.a)localIterator.next()).onFinish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.n
 * JD-Core Version:    0.7.0.1
 */