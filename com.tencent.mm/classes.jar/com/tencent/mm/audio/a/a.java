package com.tencent.mm.audio.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h;
import com.tencent.mm.ai.h.a;
import com.tencent.mm.ai.h.b;
import com.tencent.mm.ai.h.c;
import com.tencent.mm.ai.h.d;
import com.tencent.mm.audio.b.g.b;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.b.g.a;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import junit.framework.Assert;

public final class a
  implements h, g.a
{
  private static String cip = null;
  private com.tencent.mm.modelvoice.d cid;
  private boolean cie;
  private boolean cif;
  private boolean cig;
  private b cih;
  private int cii;
  private boolean cij;
  private boolean cik;
  private boolean cil;
  private h.c cim;
  private h.d cin;
  private String cio;
  private boolean ciq;
  private boolean cir;
  private boolean cis;
  private b.a cit;
  public h.b ciu;
  public h.a civ;
  private Context context;
  
  public a(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(116456);
    this.cid = null;
    this.context = null;
    this.cie = false;
    this.cif = false;
    this.cig = false;
    this.cii = 0;
    this.cij = false;
    this.cik = false;
    this.cil = true;
    this.cio = null;
    this.ciq = true;
    this.cir = true;
    this.cis = false;
    this.cit = new a.1(this);
    this.ciu = null;
    this.context = paramContext;
    this.cih = new b(paramContext);
    this.cii = paramInt;
    new g.b();
    AppMethodBeat.o(116456);
  }
  
  private void Eq()
  {
    AppMethodBeat.i(116468);
    a.4 local4 = new a.4(this);
    if (this.cid != null) {
      this.cid.a(local4);
    }
    AppMethodBeat.o(116468);
  }
  
  private void setError()
  {
    AppMethodBeat.i(116467);
    a.3 local3 = new a.3(this);
    if (this.cid != null) {
      this.cid.a(local3);
    }
    AppMethodBeat.o(116467);
  }
  
  public final boolean Ds()
  {
    AppMethodBeat.i(116471);
    if (this.cid == null)
    {
      AppMethodBeat.o(116471);
      return false;
    }
    if (this.cid.getStatus() == 2)
    {
      AppMethodBeat.o(116471);
      return true;
    }
    AppMethodBeat.o(116471);
    return false;
  }
  
  public final boolean Eo()
  {
    AppMethodBeat.i(116462);
    if (this.cid == null)
    {
      AppMethodBeat.o(116462);
      return false;
    }
    ab.i("MicroMsg.SceneVoicePlayer", "resume");
    boolean bool = this.cid.Eo();
    if (bool)
    {
      g.KC().KE();
      this.cik = true;
      if (g.KC().KH()) {
        this.cie = false;
      }
      g.KC().d(this.cie, false, false);
    }
    ab.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.ciq), Boolean.valueOf(this.cis) });
    if (this.cis)
    {
      this.cih.requestFocus();
      this.cis = false;
    }
    AppMethodBeat.o(116462);
    return bool;
  }
  
  public final boolean Ep()
  {
    return this.cif;
  }
  
  public final double Er()
  {
    AppMethodBeat.i(116469);
    if (this.cid == null)
    {
      AppMethodBeat.o(116469);
      return 0.0D;
    }
    double d = this.cid.Er();
    AppMethodBeat.o(116469);
    return d;
  }
  
  public final void a(h.a parama)
  {
    this.civ = parama;
  }
  
  public final void a(h.b paramb)
  {
    this.ciu = paramb;
  }
  
  public final void a(h.c paramc)
  {
    this.cim = paramc;
  }
  
  public final void a(h.d paramd)
  {
    this.cin = paramd;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116459);
    ab.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.TRUE, Integer.valueOf(paramInt1), Integer.valueOf(this.cii) });
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (e.cN(paramString)) {
        break;
      }
      ab.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, paramString });
      AppMethodBeat.o(116459);
      return false;
    }
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = q.g(paramString, this.cii, true);
    }
    if (i == 0) {
      if (this.context != null) {
        this.cid = new u(this.context);
      }
    }
    for (;;)
    {
      if (this.cid != null)
      {
        this.cid.b(this.cit);
        this.cih.a(this.cit);
        this.cid.ami();
      }
      this.cie = paramBoolean;
      this.cij = paramBoolean;
      if ((g.KC().KN()) || (g.KC().KH()))
      {
        ab.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(g.KC().KN()), Boolean.valueOf(g.KC().KH()) });
        this.cie = false;
      }
      g.KC().d(this.cie, false, false);
      Eq();
      setError();
      g.KC().a(this);
      if (!g.KC().KN())
      {
        g.KC().KE();
        this.cik = true;
      }
      if (this.cid.d(paramString, this.cie, paramInt2)) {
        break;
      }
      ab.i("MicroMsg.SceneVoicePlayer", "start play fileName[" + paramString + "], [" + paramBoolean + "]");
      g.KC().KF();
      this.cik = false;
      AppMethodBeat.o(116459);
      return false;
      this.cid = new u();
      continue;
      if (i == 1)
      {
        if (this.context != null) {
          this.cid = new l(this.context);
        } else {
          this.cid = new l();
        }
      }
      else if (i == 2) {
        if (this.context != null) {
          this.cid = new k(this.context);
        } else {
          this.cid = new k();
        }
      }
    }
    ab.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.ciq) });
    if (this.ciq)
    {
      this.cih.requestFocus();
      this.cis = true;
    }
    this.cir = true;
    AppMethodBeat.o(116459);
    return true;
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(116458);
    ab.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), Integer.valueOf(this.cii) });
    boolean bool;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      cip = this.cio;
      this.cio = paramString;
      if (!paramBoolean2) {
        break label136;
      }
      str = paramString;
      label87:
      if (e.cN(str)) {
        break label154;
      }
      if (!paramBoolean2) {
        break label145;
      }
    }
    label136:
    label145:
    for (String str = paramString;; str = s.getFullPath(paramString))
    {
      ab.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, str });
      AppMethodBeat.o(116458);
      return false;
      bool = false;
      break;
      str = s.getFullPath(paramString);
      break label87;
    }
    label154:
    int i = paramInt;
    if (paramInt == -1) {
      i = q.g(paramString, this.cii, paramBoolean2);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.cid = new u(this.context);
        if (this.cid != null)
        {
          this.cid.b(this.cit);
          this.cih.a(this.cit);
          this.cid.ami();
        }
        this.cie = paramBoolean1;
        this.cij = paramBoolean1;
        if ((g.KC().KN()) || (g.KC().KH()))
        {
          ab.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(g.KC().KN()), Boolean.valueOf(g.KC().KH()) });
          this.cie = false;
        }
        g.KC().d(this.cie, false, false);
        Eq();
        setError();
        str = null;
        if (!paramBoolean2) {
          break label549;
        }
        str = paramString;
      }
    }
    for (;;)
    {
      g.KC().a(this);
      if (!g.KC().KN())
      {
        g.KC().KE();
        this.cik = true;
      }
      if (this.cid.T(str, this.cie)) {
        break label565;
      }
      ab.i("MicroMsg.SceneVoicePlayer", "start play error fileName[" + paramString + "], [" + paramBoolean1 + "]");
      g.KC().KF();
      this.cik = false;
      AppMethodBeat.o(116458);
      return false;
      this.cid = new u();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.cid = new l(this.context);
          break;
        }
        this.cid = new l();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.cid = new k(this.context);
        break;
      }
      this.cid = new k();
      break;
      label549:
      if (this.cii == 0) {
        str = s.getFullPath(paramString);
      }
    }
    label565:
    ab.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.ciq) });
    if (this.ciq)
    {
      this.cih.requestFocus();
      this.cis = true;
    }
    this.cir = true;
    AppMethodBeat.o(116458);
    return true;
  }
  
  public final void bu(boolean paramBoolean)
  {
    this.ciq = paramBoolean;
  }
  
  public final void bv(boolean paramBoolean)
  {
    this.cir = paramBoolean;
  }
  
  public final boolean bw(boolean paramBoolean)
  {
    AppMethodBeat.i(116461);
    if (this.cid == null)
    {
      AppMethodBeat.o(116461);
      return false;
    }
    ab.i("MicroMsg.SceneVoicePlayer", "pause");
    if (this.cid.isPlaying()) {}
    for (boolean bool = this.cid.bw(paramBoolean);; bool = false)
    {
      if (bool)
      {
        if (this.cik)
        {
          g.KC().KF();
          this.cik = false;
        }
        if (this.cim != null) {
          this.cim.cN(paramBoolean);
        }
      }
      g.KC().setMode(0);
      ab.i("MicroMsg.SceneVoicePlayer", "jacks Player abandonFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.ciq), Boolean.valueOf(this.cis) });
      if (this.cis)
      {
        this.cih.Mh();
        this.cis = false;
      }
      AppMethodBeat.o(116461);
      return bool;
    }
  }
  
  public final void bx(boolean paramBoolean)
  {
    AppMethodBeat.i(116466);
    if (this.cie == paramBoolean)
    {
      AppMethodBeat.o(116466);
      return;
    }
    this.cie = paramBoolean;
    if ((this.cid != null) && (this.cid.isPlaying())) {
      this.cid.bx(paramBoolean);
    }
    com.tencent.mm.sdk.g.d.post(new a.2(this, paramBoolean), "SceneVoicePlayer_shiftSpeaker");
    AppMethodBeat.o(116466);
  }
  
  public final void by(boolean paramBoolean)
  {
    AppMethodBeat.i(116470);
    ab.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.cig = paramBoolean;
    AppMethodBeat.o(116470);
  }
  
  public final void gy(int paramInt)
  {
    AppMethodBeat.i(116472);
    ab.i("MicroMsg.SceneVoicePlayer", "onBluetoothHeadsetStateChange, status: %d, currentSpeaker: %b, bluetoothResumeSpeaker: %b, isRequestStartBluetooth: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.cie), Boolean.valueOf(this.cij), Boolean.valueOf(this.cik) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116472);
      return;
      bx(false);
      AppMethodBeat.o(116472);
      return;
      bx(this.cij);
      if (this.cik)
      {
        g.KC().KF();
        this.cik = false;
        AppMethodBeat.o(116472);
        return;
        g.KC().KE();
        AppMethodBeat.o(116472);
        return;
        bx(this.cij);
        if ((this.cid != null) && (this.cid.isPlaying()))
        {
          g.KC().KE();
          this.cik = true;
          AppMethodBeat.o(116472);
          return;
          if ((this.cid != null) && (this.cid.isPlaying()))
          {
            g.KC().KE();
            this.cik = true;
          }
        }
      }
    }
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(116457);
    if (this.cid == null)
    {
      AppMethodBeat.o(116457);
      return false;
    }
    boolean bool = this.cid.isPlaying();
    AppMethodBeat.o(116457);
    return bool;
  }
  
  public final boolean n(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(116463);
    paramBoolean = a(paramString, paramBoolean, false, -1);
    AppMethodBeat.o(116463);
    return paramBoolean;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(156816);
    boolean bool = bw(true);
    AppMethodBeat.o(156816);
    return bool;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(156817);
    stop(false);
    AppMethodBeat.o(156817);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(116465);
    if (this.cid == null)
    {
      AppMethodBeat.o(116465);
      return;
    }
    ab.i("MicroMsg.SceneVoicePlayer", "stop, isRequestStartBluetooth: %b, player.isPlaying: %b, fromStart: %b", new Object[] { Boolean.valueOf(this.cik), Boolean.valueOf(this.cid.isPlaying()), Boolean.valueOf(paramBoolean) });
    this.cid.Ez();
    ab.i("MicroMsg.SceneVoicePlayer", "stop player abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s, abandonFocusOnStop: %s", new Object[] { Boolean.valueOf(this.ciq), Boolean.valueOf(this.cis), Boolean.valueOf(this.cir) });
    if ((this.cis) && (this.cir))
    {
      this.cih.Mh();
      this.cis = false;
    }
    g.KC().b(this);
    if ((this.cik) && (!paramBoolean))
    {
      g.KC().KF();
      this.cik = false;
    }
    if ((!paramBoolean) && (this.cin != null)) {
      this.cin.onStop();
    }
    try
    {
      g.KC().setMode(0);
      AppMethodBeat.o(116465);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SceneVoicePlayer", localException, "stop reset speaker error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(116465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.a.a
 * JD-Core Version:    0.7.0.1
 */