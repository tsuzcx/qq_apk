package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecordController;
import com.tencent.liteav.audio.impl.Record.f;
import com.tencent.liteav.audio.impl.Record.g;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.audio.impl.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class b
  implements e
{
  static b a;
  private static final String b;
  private WeakReference<d> c;
  private int d;
  private int e;
  private int f;
  private int g;
  private boolean h;
  private int i;
  private boolean j;
  private boolean k;
  private Context l;
  private float m;
  private int n;
  private int o;
  private int p;
  private int q;
  private float r;
  private com.tencent.liteav.basic.module.a s;
  private String t;
  private boolean u;
  private com.tencent.liteav.audio.impl.Record.c v;
  
  static
  {
    AppMethodBeat.i(66743);
    b = "AudioCenter:" + b.class.getSimpleName();
    a = new b();
    AppMethodBeat.o(66743);
  }
  
  private b()
  {
    AppMethodBeat.i(146251);
    this.d = 48000;
    this.e = 1;
    this.f = 16;
    this.g = 0;
    this.h = false;
    this.i = 0;
    this.j = false;
    this.k = false;
    this.m = 1.0F;
    this.n = -1;
    this.o = -1;
    this.p = 10;
    this.q = 21;
    this.r = 0.0F;
    this.s = null;
    this.u = false;
    this.v = null;
    this.s = new com.tencent.liteav.basic.module.a();
    AppMethodBeat.o(146251);
  }
  
  public static b a()
  {
    return a;
  }
  
  private void a(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(66735);
    if ((paramInt == 2) && (!TXCTraeJNI.nativeCheckTraeEngine(paramContext)))
    {
      TXCLog.e(b, "set aec type failed, check trae library failed!!");
      AppMethodBeat.o(66735);
      return;
    }
    if (this.i != paramInt)
    {
      if ((this.v != null) && (this.v.isRecording()))
      {
        this.v.stopRecord();
        this.v = null;
        this.i = paramInt;
        a(this.l);
      }
      this.i = paramInt;
    }
    if (this.v != null) {
      this.v.setAECType(paramInt);
    }
    AppMethodBeat.o(66735);
  }
  
  private void g()
  {
    AppMethodBeat.i(66741);
    if (this.c != null) {
      a((d)this.c.get());
    }
    a(this.k);
    a(this.d);
    b(this.e);
    d(this.g);
    a(this.i, this.l);
    b(this.j);
    c(this.h);
    a(this.m);
    a(this.n, this.o);
    f(this.p);
    e(this.q);
    b(this.r);
    d(this.u);
    AppMethodBeat.o(66741);
  }
  
  public int a(Context paramContext)
  {
    AppMethodBeat.i(66726);
    if (paramContext == null)
    {
      TXCLog.e(b, "invalid param, start record failed!");
      AppMethodBeat.o(66726);
      return -901;
    }
    this.l = paramContext.getApplicationContext();
    com.tencent.liteav.audio.impl.a.a().a(this.l);
    com.tencent.liteav.audio.impl.c.a().a(this.l);
    com.tencent.liteav.audio.impl.c.a().a(this);
    if (com.tencent.liteav.audio.impl.b.b(this.i) != 0) {
      TXCLog.w(b, "start recorder failed, with aec type " + this.i + ", invalid aec player has started!");
    }
    if ((this.v != null) && (this.v.isRecording()))
    {
      TXCLog.e(b, "record has started, can not start again!");
      AppMethodBeat.o(66726);
      return -2;
    }
    if (this.v == null) {
      if (this.i != 2) {
        break label208;
      }
    }
    label208:
    for (this.v = new g();; this.v = new TXCAudioSysRecordController())
    {
      this.v.SetID(this.t);
      com.tencent.liteav.audio.impl.a.a().a(true);
      if (this.v == null) {
        break;
      }
      g();
      int i1 = this.v.startRecord(this.l);
      AppMethodBeat.o(66726);
      return i1;
    }
    TXCLog.e(b, "start Record failed! controller is null!");
    AppMethodBeat.o(66726);
    return -901;
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(66737);
    TXCLog.i(b, "setVolume: ".concat(String.valueOf(paramFloat)));
    this.m = paramFloat;
    if (this.v != null) {
      this.v.setVolume(paramFloat);
    }
    AppMethodBeat.o(66737);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(66731);
    TXCLog.i(b, "setSampleRate: ".concat(String.valueOf(paramInt)));
    this.d = paramInt;
    this.s.setStatusValue(14003, Integer.valueOf(this.d));
    if (this.v != null) {
      this.v.setSamplerate(paramInt);
    }
    AppMethodBeat.o(66731);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66738);
    TXCLog.i(b, "setChangerType: " + paramInt1 + " " + paramInt2);
    this.n = paramInt1;
    this.o = paramInt2;
    if (this.v != null) {
      this.v.setChangerType(paramInt1, paramInt2);
    }
    AppMethodBeat.o(66738);
  }
  
  public void a(d paramd)
  {
    AppMethodBeat.i(66730);
    this.c = new WeakReference(paramd);
    if (this.v != null) {
      this.v.setListener(paramd);
    }
    AppMethodBeat.o(66730);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(146252);
    this.t = paramString;
    this.s.setID(paramString);
    if (this.v != null) {
      this.v.SetID(this.t);
    }
    AppMethodBeat.o(146252);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(66729);
    this.k = paramBoolean;
    if (this.v != null) {
      this.v.setIsCustomRecord(paramBoolean);
    }
    AppMethodBeat.o(66729);
  }
  
  public void a(boolean paramBoolean, Context paramContext)
  {
    AppMethodBeat.i(66734);
    if (!paramBoolean)
    {
      a(0, paramContext);
      this.s.setStatusValue(14005, Integer.valueOf(0));
      AppMethodBeat.o(66734);
      return;
    }
    if (com.tencent.liteav.basic.e.b.a().g())
    {
      a(1, paramContext);
      this.s.setStatusValue(14005, Integer.valueOf(1));
      AppMethodBeat.o(66734);
      return;
    }
    com.tencent.liteav.audio.impl.a.a(com.tencent.liteav.basic.e.b.a().b());
    a(2, paramContext);
    this.s.setStatusValue(14005, Integer.valueOf(2));
    AppMethodBeat.o(66734);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66739);
    if (this.v != null) {
      this.v.sendCustomPCMData(paramArrayOfByte);
    }
    AppMethodBeat.o(66739);
  }
  
  public int b()
  {
    AppMethodBeat.i(66727);
    int i1;
    if (this.v != null)
    {
      i1 = this.v.stopRecord();
      this.v = null;
    }
    for (;;)
    {
      this.c = null;
      this.d = 48000;
      this.e = 1;
      this.f = 16;
      this.g = 0;
      this.h = false;
      this.i = 0;
      this.j = false;
      this.k = false;
      this.l = null;
      this.m = 1.0F;
      this.n = -1;
      this.o = -1;
      this.p = 10;
      this.q = 21;
      this.u = false;
      g();
      com.tencent.liteav.audio.impl.c.a().b(this);
      com.tencent.liteav.audio.impl.a.a().a(false);
      AppMethodBeat.o(66727);
      return i1;
      i1 = 0;
    }
  }
  
  public void b(float paramFloat)
  {
    AppMethodBeat.i(146255);
    TXCLog.i(b, "setFecRatio : ".concat(String.valueOf(paramFloat)));
    this.r = paramFloat;
    if (this.v != null) {
      this.v.setFecRatio(paramFloat);
    }
    AppMethodBeat.o(146255);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(66742);
    TXCLog.i(b, "setChannels: ".concat(String.valueOf(paramInt)));
    this.e = paramInt;
    if (this.v != null) {
      this.v.setChannels(paramInt);
    }
    AppMethodBeat.o(66742);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(66732);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(66732);
      return;
      if (this.v != null)
      {
        this.v.setMute(true);
        AppMethodBeat.o(66732);
        return;
        if (this.v != null)
        {
          this.v.setMute(true);
          AppMethodBeat.o(66732);
          return;
          if (this.v != null) {
            this.v.setMute(this.h);
          }
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int i2 = 1;
    AppMethodBeat.i(66736);
    TXCLog.i(b, "setMute: ".concat(String.valueOf(paramBoolean)));
    Object localObject;
    if (this.h != paramBoolean)
    {
      localObject = this.t;
      if (paramBoolean)
      {
        i1 = 1;
        TXCEventRecorderProxy.a((String)localObject, 3001, i1, -1, "", 0);
      }
    }
    else
    {
      this.h = paramBoolean;
      localObject = this.s;
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (int i1 = i2;; i1 = 0)
    {
      ((com.tencent.liteav.basic.module.a)localObject).setStatusValue(14014, Integer.valueOf(i1));
      if (this.v != null) {
        this.v.setMute(paramBoolean);
      }
      AppMethodBeat.o(66736);
      return;
      i1 = 0;
      break;
    }
  }
  
  public boolean c()
  {
    AppMethodBeat.i(66728);
    if (this.v != null)
    {
      boolean bool = this.v.isRecording();
      AppMethodBeat.o(66728);
      return bool;
    }
    AppMethodBeat.o(66728);
    return false;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(66733);
    TXCLog.i(b, "setReverbType: ".concat(String.valueOf(paramInt)));
    this.g = paramInt;
    if (this.v != null) {
      this.v.setReverbType(paramInt);
    }
    AppMethodBeat.o(66733);
  }
  
  public void d(boolean paramBoolean)
  {
    AppMethodBeat.i(146256);
    this.u = paramBoolean;
    if (this.v != null) {
      this.v.setEnableVolumeLevel(paramBoolean);
    }
    AppMethodBeat.o(146256);
  }
  
  public int e()
  {
    return this.d;
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(146253);
    this.q = paramInt;
    if (this.v != null) {
      this.v.setEncFrameLenMs(this.q);
    }
    AppMethodBeat.o(146253);
  }
  
  public int f()
  {
    AppMethodBeat.i(66740);
    int i1;
    if (f.a().c())
    {
      if (this.i == 2)
      {
        TXCLog.e(b, "audio mic has start, but aec type is trae!!" + this.i);
        AppMethodBeat.o(66740);
        return 0;
      }
      i1 = this.i;
      AppMethodBeat.o(66740);
      return i1;
    }
    if (TXCTraeJNI.nativeTraeIsRecording())
    {
      if (this.i != 2)
      {
        TXCLog.e(b, "trae engine has start, but aec type is not trae!!" + this.i);
        AppMethodBeat.o(66740);
        return 2;
      }
      i1 = this.i;
      AppMethodBeat.o(66740);
      return i1;
    }
    AppMethodBeat.o(66740);
    return 0;
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(146254);
    TXCLog.i(b, "setAudioFormat: ".concat(String.valueOf(paramInt)));
    this.p = paramInt;
    if (this.p == 11) {
      if (this.q == 21) {
        this.q = 20;
      }
    }
    for (;;)
    {
      this.s.setStatusValue(14004, Integer.valueOf(this.p));
      if (this.v != null) {
        this.v.setAudioFormat(paramInt);
      }
      AppMethodBeat.o(146254);
      return;
      if (this.p == 10) {
        this.q = 21;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.audio.b
 * JD-Core Version:    0.7.0.1
 */