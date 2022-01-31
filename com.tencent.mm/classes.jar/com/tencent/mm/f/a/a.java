package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.h.a;
import com.tencent.mm.ah.h.b;
import com.tencent.mm.ah.h.c;
import com.tencent.mm.ah.h.d;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.f.b.g.b;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.modelvoice.j;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public final class a
  implements h, f.a
{
  private static String bBA = null;
  private boolean bBB = true;
  private boolean bBC = true;
  private boolean bBD = false;
  private b.a bBE = new a.1(this);
  public h.b bBF = null;
  public h.a bBG;
  private d bBo = null;
  private boolean bBp = false;
  private boolean bBq = false;
  private boolean bBr = false;
  private b bBs;
  private int bBt = 0;
  private boolean bBu = false;
  private boolean bBv = false;
  private boolean bBw = true;
  private h.c bBx;
  private h.d bBy;
  private String bBz = null;
  private Context context = null;
  
  public a(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public a(Context paramContext, int paramInt)
  {
    this.context = paramContext;
    this.bBs = new b(paramContext);
    this.bBt = paramInt;
    new g.b();
  }
  
  private void setError()
  {
    a.3 local3 = new a.3(this);
    if (this.bBo != null) {
      this.bBo.a(local3);
    }
  }
  
  private void ud()
  {
    a.4 local4 = new a.4(this);
    if (this.bBo != null) {
      this.bBo.a(local4);
    }
  }
  
  public final void a(h.a parama)
  {
    this.bBG = parama;
  }
  
  public final void a(h.b paramb)
  {
    this.bBF = paramb;
  }
  
  public final void a(h.c paramc)
  {
    this.bBx = paramc;
  }
  
  public final void a(h.d paramd)
  {
    this.bBy = paramd;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(true), Integer.valueOf(paramInt1), Integer.valueOf(this.bBt) });
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (com.tencent.mm.vfs.e.bK(paramString)) {
        break;
      }
      y.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, paramString });
      return false;
    }
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = o.g(paramString, this.bBt, true);
    }
    if (i == 0) {
      if (this.context != null) {
        this.bBo = new s(this.context);
      }
    }
    for (;;)
    {
      if (this.bBo != null)
      {
        this.bBo.b(this.bBE);
        this.bBs.a(this.bBE);
        this.bBo.SX();
      }
      this.bBp = paramBoolean;
      this.bBu = paramBoolean;
      if ((f.yi().yt()) || (f.yi().yn()))
      {
        y.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(f.yi().yt()), Boolean.valueOf(f.yi().yn()) });
        this.bBp = false;
      }
      f.yi().f(this.bBp, false, false);
      ud();
      setError();
      f.yi().a(this);
      if (!f.yi().yt())
      {
        f.yi().yk();
        this.bBv = true;
      }
      if (this.bBo.c(paramString, this.bBp, paramInt2)) {
        break;
      }
      y.i("MicroMsg.SceneVoicePlayer", "start play fileName[" + paramString + "], [" + paramBoolean + "]");
      f.yi().yl();
      this.bBv = false;
      return false;
      this.bBo = new s();
      continue;
      if (i == 1)
      {
        if (this.context != null) {
          this.bBo = new j(this.context);
        } else {
          this.bBo = new j();
        }
      }
      else if (i == 2) {
        if (this.context != null) {
          this.bBo = new i(this.context);
        } else {
          this.bBo = new i();
        }
      }
    }
    y.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.bBB) });
    if (this.bBB)
    {
      this.bBs.requestFocus();
      this.bBD = true;
    }
    this.bBC = true;
    return true;
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    y.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), Integer.valueOf(this.bBt) });
    boolean bool;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      bBA = this.bBz;
      this.bBz = paramString;
      if (!paramBoolean2) {
        break label124;
      }
      str = paramString;
      label81:
      if (com.tencent.mm.vfs.e.bK(str)) {
        break label142;
      }
      if (!paramBoolean2) {
        break label133;
      }
    }
    label133:
    for (String str = paramString;; str = q.getFullPath(paramString))
    {
      y.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, str });
      return false;
      bool = false;
      break;
      label124:
      str = q.getFullPath(paramString);
      break label81;
    }
    label142:
    int i = paramInt;
    if (paramInt == -1) {
      i = o.g(paramString, this.bBt, paramBoolean2);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.bBo = new s(this.context);
        if (this.bBo != null)
        {
          this.bBo.b(this.bBE);
          this.bBs.a(this.bBE);
          this.bBo.SX();
        }
        this.bBp = paramBoolean1;
        this.bBu = paramBoolean1;
        if ((f.yi().yt()) || (f.yi().yn()))
        {
          y.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(f.yi().yt()), Boolean.valueOf(f.yi().yn()) });
          this.bBp = false;
        }
        f.yi().f(this.bBp, false, false);
        ud();
        setError();
        str = null;
        if (!paramBoolean2) {
          break label528;
        }
        str = paramString;
      }
    }
    for (;;)
    {
      f.yi().a(this);
      if (!f.yi().yt())
      {
        f.yi().yk();
        this.bBv = true;
      }
      if (this.bBo.P(str, this.bBp)) {
        break label544;
      }
      y.i("MicroMsg.SceneVoicePlayer", "start play error fileName[" + paramString + "], [" + paramBoolean1 + "]");
      f.yi().yl();
      this.bBv = false;
      return false;
      this.bBo = new s();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.bBo = new j(this.context);
          break;
        }
        this.bBo = new j();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.bBo = new i(this.context);
        break;
      }
      this.bBo = new i();
      break;
      label528:
      if (this.bBt == 0) {
        str = q.getFullPath(paramString);
      }
    }
    label544:
    y.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.bBB) });
    if (this.bBB)
    {
      this.bBs.requestFocus();
      this.bBD = true;
    }
    this.bBC = true;
    return true;
  }
  
  public final void aT(boolean paramBoolean)
  {
    this.bBB = paramBoolean;
  }
  
  public final boolean aU(boolean paramBoolean)
  {
    if (this.bBo == null) {
      return false;
    }
    y.i("MicroMsg.SceneVoicePlayer", "pause");
    if (this.bBo.isPlaying()) {}
    for (boolean bool = this.bBo.aU(paramBoolean);; bool = false)
    {
      if (bool)
      {
        if (this.bBv)
        {
          f.yi().yl();
          this.bBv = false;
        }
        if (this.bBx != null) {
          this.bBx.bL(paramBoolean);
        }
      }
      f.yi().setMode(0);
      y.i("MicroMsg.SceneVoicePlayer", "jacks Player abandonFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.bBB), Boolean.valueOf(this.bBD) });
      if (this.bBD)
      {
        this.bBs.zE();
        this.bBD = false;
      }
      return bool;
    }
  }
  
  public final void aV(boolean paramBoolean)
  {
    if (this.bBp == paramBoolean) {
      return;
    }
    this.bBp = paramBoolean;
    if ((this.bBo != null) && (this.bBo.isPlaying())) {
      this.bBo.aV(paramBoolean);
    }
    com.tencent.mm.sdk.f.e.post(new a.2(this, paramBoolean), "SceneVoicePlayer_shiftSpeaker");
  }
  
  public final void aW(boolean paramBoolean)
  {
    y.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.bBr = paramBoolean;
  }
  
  public final void ew(int paramInt)
  {
    y.i("MicroMsg.SceneVoicePlayer", "onBluetoothHeadsetStateChange, status: %d, currentSpeaker: %b, bluetoothResumeSpeaker: %b, isRequestStartBluetooth: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.bBp), Boolean.valueOf(this.bBu), Boolean.valueOf(this.bBv) });
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          aV(false);
          return;
          aV(this.bBu);
        } while (!this.bBv);
        f.yi().yl();
        this.bBv = false;
        return;
        aV(this.bBu);
      } while ((this.bBo == null) || (!this.bBo.isPlaying()));
      f.yi().yk();
      this.bBv = true;
      return;
    } while ((this.bBo == null) || (!this.bBo.isPlaying()));
    f.yi().yk();
    this.bBv = true;
  }
  
  public final boolean isPlaying()
  {
    if (this.bBo == null) {
      return false;
    }
    return this.bBo.isPlaying();
  }
  
  public final boolean k(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, false, -1);
  }
  
  public final boolean pause()
  {
    return aU(true);
  }
  
  public final void stop()
  {
    stop(false);
  }
  
  public final void stop(boolean paramBoolean)
  {
    if (this.bBo == null) {
      return;
    }
    y.i("MicroMsg.SceneVoicePlayer", "stop, isRequestStartBluetooth: %b, player.isPlaying: %b, fromStart: %b", new Object[] { Boolean.valueOf(this.bBv), Boolean.valueOf(this.bBo.isPlaying()), Boolean.valueOf(paramBoolean) });
    this.bBo.un();
    y.i("MicroMsg.SceneVoicePlayer", "stop player abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s, abandonFocusOnStop: %s", new Object[] { Boolean.valueOf(this.bBB), Boolean.valueOf(this.bBD), Boolean.valueOf(this.bBC) });
    if ((this.bBD) && (this.bBC))
    {
      this.bBs.zE();
      this.bBD = false;
    }
    f.yi().b(this);
    if ((this.bBv) && (!paramBoolean))
    {
      f.yi().yl();
      this.bBv = false;
    }
    if ((!paramBoolean) && (this.bBy != null)) {
      this.bBy.onStop();
    }
    try
    {
      f.yi().setMode(0);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SceneVoicePlayer", localException, "stop reset speaker error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  public final void ua()
  {
    this.bBC = false;
  }
  
  public final boolean ub()
  {
    if (this.bBo == null) {
      return false;
    }
    y.i("MicroMsg.SceneVoicePlayer", "resume");
    boolean bool = this.bBo.ub();
    if (bool)
    {
      f.yi().yk();
      this.bBv = true;
      if (f.yi().yn()) {
        this.bBp = false;
      }
      f.yi().f(this.bBp, false, false);
    }
    y.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.bBB), Boolean.valueOf(this.bBD) });
    if (this.bBD)
    {
      this.bBs.requestFocus();
      this.bBD = false;
    }
    return bool;
  }
  
  public final boolean uc()
  {
    return this.bBq;
  }
  
  public final double ue()
  {
    if (this.bBo == null) {
      return 0.0D;
    }
    return this.bBo.ue();
  }
  
  public final boolean uf()
  {
    if (this.bBo == null) {}
    while (this.bBo.getStatus() != 2) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.a
 * JD-Core Version:    0.7.0.1
 */