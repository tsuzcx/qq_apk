package com.tencent.mm.plugin.emojicapture.ui.a;

import a.n;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureTextureView;

public final class a
{
  public final String TAG;
  public final int fvY;
  public final int fvZ;
  public final int fwu;
  public final e jog;
  public boolean jqQ;
  public final EmojiCaptureTextureView jqR;
  
  public a(EmojiCaptureTextureView paramEmojiCaptureTextureView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jqR = paramEmojiCaptureTextureView;
    this.fvY = paramInt1;
    this.fvZ = paramInt2;
    this.fwu = paramInt3;
    this.TAG = "MicroMsg.EmojiCaptureGLDrawManager";
    this.jqQ = true;
    this.jog = this.jqR.getRenderer();
  }
  
  public final void aKW()
  {
    this.jog.jrO = true;
    this.jqR.requestRender();
  }
  
  public final void d(a.d.a.a<n> parama)
  {
    this.jog.jrP = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.a
 * JD-Core Version:    0.7.0.1
 */