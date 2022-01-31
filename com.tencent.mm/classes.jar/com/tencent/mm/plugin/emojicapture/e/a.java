package com.tencent.mm.plugin.emojicapture.e;

import a.d.b.g;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emojicapture.model.b;
import com.tencent.mm.plugin.emojicapture.model.c;
import com.tencent.mm.plugin.emojicapture.model.c.a;
import com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy;
import com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration;
import com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class a
  implements com.tencent.mm.plugin.emojicapture.c.a.a
{
  final String TAG;
  private Context context;
  private final com.tencent.mm.remoteservice.d eMh;
  private final String goK;
  private com.tencent.mm.plugin.emojicapture.ui.a.a jlO;
  com.tencent.mm.plugin.emojicapture.model.c.a jlP;
  b jlQ;
  private boolean jlR;
  private int jlS;
  private a.a jlT;
  private long jlU;
  private final boolean jlV;
  boolean jlW;
  String jlX;
  VoiceInputProxy jlY;
  private final am jlZ;
  com.tencent.mm.plugin.emojicapture.c.a.b jma;
  private final VideoTransPara jmb;
  private final EmojiInfo jmc;
  EmojiCaptureUI.b jmd;
  
  public a(Context paramContext, com.tencent.mm.plugin.emojicapture.c.a.b paramb, VideoTransPara paramVideoTransPara, String paramString, EmojiInfo paramEmojiInfo, EmojiCaptureUI.b paramb1)
  {
    this.context = paramContext;
    this.jma = paramb;
    this.jmb = paramVideoTransPara;
    this.goK = paramString;
    this.jmc = paramEmojiInfo;
    this.jmd = paramb1;
    this.TAG = "MicroMsg.CapturePresenter";
    this.jlQ = new b(this.jmb);
    this.jlS = com.tencent.mm.compatible.e.d.getNumberOfCameras();
    this.jlT = a.a.jmf;
    this.eMh = new com.tencent.mm.remoteservice.d(this.context);
    this.jlY = new VoiceInputProxy((VoiceInputProxy.b)new g(this), this.eMh);
    this.jlZ = new am((am.a)new a.f(this), true);
    if (this.jmc != null)
    {
      this.jlV = true;
      this.jlX = this.jmc.field_attachedText;
      paramContext = this.jma.getDecoration();
      paramVideoTransPara = this.jmc;
      paramb = this.jmc.field_attachedText;
      g.k(paramVideoTransPara, "emojiInfo");
      paramContext.jpq = new MMEmojiView(paramContext.getContext());
      paramString = new FrameLayout.LayoutParams(-1, -1);
      paramContext.addView((View)paramContext.jpq, (ViewGroup.LayoutParams)paramString);
      paramString = paramContext.jpq;
      if (paramString != null) {
        paramString.a(paramVideoTransPara, "");
      }
      paramVideoTransPara = paramContext.jpq;
      if (paramVideoTransPara != null) {
        paramVideoTransPara.setAlpha(0.4F);
      }
      if (!bk.bl(paramb))
      {
        paramVideoTransPara = new TextEditorItemView(paramContext.getContext());
        paramString = new FrameLayout.LayoutParams(-1, -1);
        paramString.gravity = 81;
        paramEmojiInfo = paramContext.getContext();
        g.j(paramEmojiInfo, "context");
        paramString.bottomMargin = paramEmojiInfo.getResources().getDimensionPixelSize(com.tencent.mm.plugin.emojicapture.a.b.editor_text_item_bottom_margin);
        paramContext.addView((View)paramVideoTransPara, (ViewGroup.LayoutParams)paramString);
        paramVideoTransPara.a((CharSequence)paramb, -1, -16777216, true);
        paramb = paramContext.getContext();
        g.j(paramb, "context");
        paramb = new RectF(0.0F, 0.0F, paramb.getResources().getDimension(com.tencent.mm.plugin.emojicapture.a.b.preview_size), paramContext.getHeight());
        paramContext = paramContext.getContext();
        g.j(paramContext, "context");
        paramVideoTransPara.a(paramb, paramContext.getResources().getDimension(com.tencent.mm.plugin.emojicapture.a.b.preview_radius));
      }
    }
    for (;;)
    {
      CaptureMMProxy.createProxy(new CaptureMMProxy(this.eMh));
      this.eMh.connect((Runnable)new a.1(this));
      this.jmb.width = 640;
      this.jmb.height = 640;
      this.jmb.videoBitrate = 5000000;
      j.mhB.videoBitrate = this.jmb.videoBitrate;
      j.mhB.mfr = this.jmb;
      return;
      this.jlV = false;
      this.jma.getDecoration().setVisibility(8);
    }
  }
  
  private final void aKl()
  {
    y.i(this.TAG, "reset camera");
    this.jlQ = new b(this.jmb);
    if (this.jlR)
    {
      if (!this.jlQ.r(this.context, false))
      {
        com.tencent.mm.plugin.emojicapture.f.a.a locala = com.tencent.mm.plugin.emojicapture.f.a.jnW;
        com.tencent.mm.plugin.emojicapture.f.a.a.cG(9, 1);
      }
      this.jlQ.a((f)new a.c(this));
    }
    aKm();
  }
  
  private final void aKm()
  {
    if (this.jlP != null)
    {
      locala = this.jlP;
      if (locala != null) {
        locala.cancel();
      }
    }
    this.jlP = new com.tencent.mm.plugin.emojicapture.model.c.a(this.jmb);
    com.tencent.mm.plugin.emojicapture.model.c.a locala = this.jlP;
    if (locala != null) {
      locala.setFilePath(this.goK);
    }
    locala = this.jlP;
    if (locala != null)
    {
      c.a locala1 = c.jko;
      locala.In(c.a.aKe() + "temp_thumb");
    }
  }
  
  public final void aJM()
  {
    y.i(this.TAG, "pauseCapture " + this.jlW + ' ' + this.jlV);
    if ((this.jlW) || (this.jlV))
    {
      this.jmd.Bn(this.jlX);
      return;
    }
    ai.l((Runnable)new a.b(this), 1500L);
  }
  
  public final void aJN()
  {
    boolean bool = true;
    if (g.e(this.jlT, a.a.jmg)) {
      return;
    }
    y.i(this.TAG, "resumeCapture");
    Object localObject = this.jma;
    if (this.jlS > 1) {}
    for (;;)
    {
      ((com.tencent.mm.plugin.emojicapture.c.a.b)localObject).fq(bool);
      this.jma.fr(false);
      aKl();
      if (((a)this).jlO != null)
      {
        localObject = this.jlO;
        if (localObject == null) {
          g.ahh("drawManager");
        }
        ((com.tencent.mm.plugin.emojicapture.ui.a.a)localObject).aKW();
      }
      if (this.jma.getCameraDataView().isAvailable())
      {
        localObject = this.jlQ;
        SurfaceTexture localSurfaceTexture = this.jma.getCameraDataView().getSurfaceTexture();
        g.j(localSurfaceTexture, "view.getCameraDataView().surfaceTexture");
        ((b)localObject).g(localSurfaceTexture);
        this.jlO = new com.tencent.mm.plugin.emojicapture.ui.a.a(this.jma.getCaptureView(), this.jlQ.aKa().x, this.jlQ.aKa().y, this.jlQ.getOrientation());
      }
      if (this.jlV) {
        this.jma.getDecoration().resume();
      }
      this.jlT = a.a.jmg;
      return;
      bool = false;
    }
  }
  
  public final boolean aJO()
  {
    if (this.jma.getCameraDataView().getSurfaceTexture() != null)
    {
      Object localObject = this.jlQ;
      Context localContext = this.context;
      SurfaceTexture localSurfaceTexture = this.jma.getCameraDataView().getSurfaceTexture();
      g.j(localSurfaceTexture, "view.getCameraDataView().surfaceTexture");
      ((b)localObject).a(localContext, localSurfaceTexture);
      this.jlO = new com.tencent.mm.plugin.emojicapture.ui.a.a(this.jma.getCaptureView(), this.jlQ.aKa().x, this.jlQ.aKa().y, this.jlQ.getOrientation());
      localObject = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.a.a(5, 0L, 0L, 0L);
    }
    return this.jlQ.biS();
  }
  
  public final void aJP()
  {
    if (this.jlQ.biR()) {
      this.jlQ.aJP();
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (this.jlQ.biR()) {
      this.jlQ.b(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
  }
  
  public final void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.jlQ.biR()) {
      this.jlQ.c(paramBoolean1, paramBoolean2, paramInt);
    }
  }
  
  public final void destroy()
  {
    this.jlQ.biN();
    this.eMh.release();
  }
  
  public final void exit()
  {
    this.jmd.exit();
  }
  
  public final void f(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = true;
    g.k(paramSurfaceTexture, "surface");
    y.i(this.TAG, "camera count is " + this.jlS);
    com.tencent.mm.plugin.emojicapture.c.a.b localb = this.jma;
    if (this.jlS > 1) {}
    for (;;)
    {
      localb.fq(bool);
      this.jlQ.g(paramSurfaceTexture);
      this.jlO = new com.tencent.mm.plugin.emojicapture.ui.a.a(this.jma.getCaptureView(), this.jlQ.aKa().x, this.jlQ.aKa().y, this.jlQ.getOrientation());
      return;
      bool = false;
    }
  }
  
  public final void fp(boolean paramBoolean)
  {
    this.jlR = paramBoolean;
  }
  
  public final void pause()
  {
    y.i(this.TAG, "pause " + this.jlQ.biR());
    this.jlT = a.a.jmh;
    Object localObject;
    if (this.jlQ.biR())
    {
      localObject = this.jlO;
      if (localObject == null) {
        g.ahh("drawManager");
      }
      ((com.tencent.mm.plugin.emojicapture.ui.a.a)localObject).jqQ = false;
      ((com.tencent.mm.plugin.emojicapture.ui.a.a)localObject).aKW();
      this.jlQ.biN();
    }
    if (this.jlV)
    {
      localObject = this.jma.getDecoration().jpq;
      if (localObject != null) {
        ((MMEmojiView)localObject).pause();
      }
    }
  }
  
  public final void qg(int paramInt)
  {
    this.jlQ.tY(paramInt);
  }
  
  public final void resume()
  {
    if (g.e(this.jlT, a.a.jmg)) {
      return;
    }
    y.i(this.TAG, "resume " + this.jlQ.biR() + ' ' + this.jma.getCameraDataView().isAvailable());
    Object localObject;
    if (this.jlQ.biR())
    {
      localObject = this.jlO;
      if (localObject == null) {
        g.ahh("drawManager");
      }
      ((com.tencent.mm.plugin.emojicapture.ui.a.a)localObject).jqQ = true;
    }
    for (;;)
    {
      if (this.jlV) {
        this.jma.getDecoration().resume();
      }
      this.jlT = a.a.jmg;
      return;
      aKl();
      if (this.jma.getCameraDataView().isAvailable())
      {
        localObject = this.jlO;
        if (localObject == null) {
          g.ahh("drawManager");
        }
        ((com.tencent.mm.plugin.emojicapture.ui.a.a)localObject).aKW();
        localObject = this.jlQ;
        SurfaceTexture localSurfaceTexture = this.jma.getCameraDataView().getSurfaceTexture();
        g.j(localSurfaceTexture, "view.getCameraDataView().surfaceTexture");
        ((b)localObject).g(localSurfaceTexture);
        this.jlO = new com.tencent.mm.plugin.emojicapture.ui.a.a(this.jma.getCaptureView(), this.jlQ.aKa().x, this.jlQ.aKa().y, this.jlQ.getOrientation());
      }
    }
  }
  
  public final void startRecord()
  {
    y.i(this.TAG, "start record " + this.jlT);
    if ((g.e(this.jlT, a.a.jmg) ^ true)) {
      return;
    }
    Object localObject = this.jlP;
    com.tencent.mm.plugin.emojicapture.ui.a.a locala;
    if (localObject != null)
    {
      locala = this.jlO;
      if (locala == null) {
        g.ahh("drawManager");
      }
      ((com.tencent.mm.plugin.emojicapture.model.c.a)localObject).jlL = locala;
    }
    localObject = this.jlP;
    if (localObject != null)
    {
      y.i(((com.tencent.mm.plugin.emojicapture.model.c.a)localObject).TAG, "startRecord");
      locala = ((com.tencent.mm.plugin.emojicapture.model.c.a)localObject).jlL;
      if (locala != null) {
        locala.d((a.d.a.a)new com.tencent.mm.plugin.emojicapture.model.c.a.a((com.tencent.mm.plugin.emojicapture.model.c.a)localObject));
      }
      ((com.tencent.mm.plugin.emojicapture.model.c.a)localObject).d(0, false, 0);
      ((com.tencent.mm.plugin.emojicapture.model.c.a)localObject).jlK = 0L;
    }
    if (this.jlV)
    {
      localObject = this.jma.getDecoration().jpq;
      if (localObject != null) {
        ((MMEmojiView)localObject).reset();
      }
    }
    for (;;)
    {
      this.jlZ.hq(50L);
      this.jlW = false;
      this.jlT = a.a.jmi;
      this.jlU = bk.UZ();
      localObject = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.dw(System.currentTimeMillis());
      localObject = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.a.a(3, 0L, 0L, 0L);
      return;
      this.jlX = "";
      localObject = this.jlY;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).start();
      }
    }
  }
  
  public final boolean uh()
  {
    y.i(this.TAG, "stop record " + this.jlT);
    if (g.e(this.jlT, a.a.jmj)) {
      return true;
    }
    this.jlT = a.a.jmj;
    if (bk.cp(this.jlU) < 600L)
    {
      localObject = this.jlY;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
      aKm();
      this.jlT = a.a.jmg;
      return false;
    }
    Object localObject = this.jmd;
    Context localContext = this.context;
    String str = this.context.getString(com.tencent.mm.plugin.emojicapture.a.f.loading_tips);
    g.j(str, "context.getString(R.string.loading_tips)");
    ((EmojiCaptureUI.b)localObject).a(localContext, (CharSequence)str, (DialogInterface.OnCancelListener)new a.d(this));
    if (this.jlV)
    {
      localObject = this.jma.getDecoration().jpq;
      if (localObject != null) {
        ((MMEmojiView)localObject).pause();
      }
    }
    for (;;)
    {
      this.jlZ.stopTimer();
      localObject = this.jlP;
      if (localObject != null) {
        ((com.tencent.mm.plugin.emojicapture.model.c.a)localObject).a((a.d.a.a)new a.e(this));
      }
      localObject = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.dx(System.currentTimeMillis());
      localObject = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      localObject = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      long l = com.tencent.mm.plugin.emojicapture.f.a.aKq();
      localObject = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.dC(l - com.tencent.mm.plugin.emojicapture.f.a.aKp());
      localObject = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      localObject = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.a.a(4, 0L, com.tencent.mm.plugin.emojicapture.f.a.aKv(), 0L);
      return true;
      localObject = this.jlY;
      if (localObject != null) {
        ((VoiceInputProxy)localObject).stop(true);
      }
    }
  }
  
  public static final class g
    implements VoiceInputProxy.b
  {
    public final void TC()
    {
      y.i(this.jme.TAG, "onRecognizeFinish voice finish called");
      if (!this.jme.jlW) {
        this.jme.jmd.Bn(this.jme.jlX);
      }
      this.jme.jlW = true;
    }
    
    public final void onRes(String paramString)
    {
      y.i(this.jme.TAG, "onRes " + paramString);
      this.jme.jlX = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a
 * JD-Core Version:    0.7.0.1
 */