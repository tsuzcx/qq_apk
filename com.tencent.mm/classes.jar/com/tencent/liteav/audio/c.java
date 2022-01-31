package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecordController;
import com.tencent.liteav.audio.impl.Record.f;
import com.tencent.liteav.audio.impl.Record.g;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

public class c
  implements com.tencent.liteav.audio.impl.e
{
  public static final int a = com.tencent.liteav.basic.a.a.e;
  public static final int b = com.tencent.liteav.basic.a.a.f;
  public static final int c = com.tencent.liteav.basic.a.a.h;
  public static final int d = TXEAudioDef.TXE_REVERB_TYPE_0;
  public static final int e = TXEAudioDef.TXE_AEC_NONE;
  public static final int f = TXEAudioDef.TXE_AUDIO_TYPE_AAC;
  static c g = new c();
  private static final String h = "AudioCenter:" + c.class.getSimpleName();
  private WeakReference<e> i;
  private int j = a;
  private int k = b;
  private int l = com.tencent.liteav.basic.a.a.h;
  private int m = d;
  private boolean n = false;
  private int o = e;
  private boolean p = false;
  private boolean q = false;
  private Context r;
  private float s = 1.0F;
  private int t = -1;
  private int u = -1;
  private com.tencent.liteav.audio.impl.Record.c v = null;
  
  public static c a()
  {
    return g;
  }
  
  private void a(int paramInt, Context paramContext)
  {
    if ((paramInt == TXEAudioDef.TXE_AEC_TRAE) && (!TXCTraeJNI.nativeCheckTraeEngine(paramContext))) {
      TXCLog.e(h, "set aec type failed, check trae library failed!!");
    }
    do
    {
      return;
      if (this.o != paramInt)
      {
        if ((this.v != null) && (this.v.isRecording()))
        {
          this.v.stopRecord();
          this.v = null;
          this.o = paramInt;
          a(this.r);
        }
        this.o = paramInt;
      }
    } while (this.v == null);
    this.v.setAECType(paramInt);
  }
  
  private void g()
  {
    if (this.i != null) {
      a((e)this.i.get());
    }
    a(this.q);
    a(this.j);
    c(this.k);
    d(this.m);
    a(this.o, this.r);
    b(this.p);
    c(this.n);
    a(this.s);
    a(this.t, this.u);
  }
  
  public int a(Context paramContext)
  {
    if (paramContext == null)
    {
      TXCLog.e(h, "invalid param, start record failed!");
      return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
    }
    this.r = paramContext.getApplicationContext();
    com.tencent.liteav.audio.impl.c.a().a(this.r);
    com.tencent.liteav.audio.impl.c.a().a(this);
    if (com.tencent.liteav.audio.impl.a.b(this.o) != TXEAudioDef.TXE_AUDIO_RECORD_ERR_OK) {
      TXCLog.w(h, "start recorder failed, with aec type " + this.o + ", invalid aec player has started!");
    }
    if ((this.v != null) && (this.v.isRecording()))
    {
      TXCLog.e(h, "record has started, can not start again!");
      return TXEAudioDef.TXE_AUDIO_RECORD_ERR_REPEAT_OPTION;
    }
    if (this.v == null) {
      if (this.o != TXEAudioDef.TXE_AEC_TRAE) {
        break label164;
      }
    }
    label164:
    for (this.v = new g(); this.v != null; this.v = new TXCAudioSysRecordController())
    {
      g();
      return this.v.startRecord(this.r);
    }
    TXCLog.e(h, "start Record failed! controller is null!");
    return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
  }
  
  public void a(float paramFloat)
  {
    TXCLog.i(h, "setVolume: " + paramFloat);
    this.s = paramFloat;
    if (this.v != null) {
      this.v.setVolume(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    TXCLog.i(h, "setSampleRate: " + paramInt);
    this.j = paramInt;
    if (this.v != null) {
      this.v.setSamplerate(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    TXCLog.i(h, "setChangerType: " + paramInt1 + " " + paramInt2);
    this.t = paramInt1;
    this.u = paramInt2;
    if (this.v != null) {
      this.v.setChangerType(paramInt1, paramInt2);
    }
  }
  
  public void a(e parame)
  {
    this.i = new WeakReference(parame);
    if (this.v != null) {
      this.v.setListener(parame);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
    if (this.v != null) {
      this.v.setIsCustomRecord(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, Context paramContext)
  {
    if (!paramBoolean)
    {
      a(TXEAudioDef.TXE_AEC_NONE, paramContext);
      return;
    }
    if (b.a().g())
    {
      a(TXEAudioDef.TXE_AEC_SYSTEM, paramContext);
      return;
    }
    a.a(b.a().b());
    a(TXEAudioDef.TXE_AEC_TRAE, paramContext);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.v != null) {
      this.v.sendCustomPCMData(paramArrayOfByte);
    }
  }
  
  public int b()
  {
    int i1 = TXEAudioDef.TXE_AUDIO_RECORD_ERR_OK;
    if (this.v != null)
    {
      i1 = this.v.stopRecord();
      this.v = null;
    }
    this.i = null;
    this.j = a;
    this.k = b;
    this.l = com.tencent.liteav.basic.a.a.h;
    this.m = d;
    this.n = false;
    this.o = e;
    this.p = false;
    this.q = false;
    this.r = null;
    this.s = 1.0F;
    this.t = -1;
    this.u = -1;
    g();
    com.tencent.liteav.audio.impl.c.a().b(this);
    return i1;
  }
  
  public void b(int paramInt)
  {
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
        } while (this.v == null);
        this.v.setMute(true);
        return;
      } while (this.v == null);
      this.v.setMute(true);
      return;
    } while (this.v == null);
    this.v.setMute(this.n);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(int paramInt)
  {
    TXCLog.i(h, "setChannels: " + paramInt);
    this.k = paramInt;
    if (this.v != null) {
      this.v.setChannels(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    TXCLog.i(h, "setMute: " + paramBoolean);
    this.n = paramBoolean;
    if (this.v != null) {
      this.v.setMute(paramBoolean);
    }
  }
  
  public boolean c()
  {
    if (this.v != null) {
      return this.v.isRecording();
    }
    return false;
  }
  
  public int d()
  {
    return this.k;
  }
  
  public void d(int paramInt)
  {
    TXCLog.i(h, "setReverbType: " + paramInt);
    this.m = paramInt;
    if (this.v != null) {
      this.v.setReverbType(paramInt);
    }
  }
  
  public int e()
  {
    return this.j;
  }
  
  public int f()
  {
    if (f.a().c())
    {
      if (this.o == TXEAudioDef.TXE_AEC_TRAE)
      {
        TXCLog.e(h, "audio mic has start, but aec type is trae!!" + this.o);
        return TXEAudioDef.TXE_AEC_NONE;
      }
      return this.o;
    }
    if (TXCTraeJNI.nativeTraeIsRecording())
    {
      if (this.o != TXEAudioDef.TXE_AEC_TRAE)
      {
        TXCLog.e(h, "trae engine has start, but aec type is not trae!!" + this.o);
        return TXEAudioDef.TXE_AEC_TRAE;
      }
      return this.o;
    }
    return TXEAudioDef.TXE_AEC_NONE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.audio.c
 * JD-Core Version:    0.7.0.1
 */