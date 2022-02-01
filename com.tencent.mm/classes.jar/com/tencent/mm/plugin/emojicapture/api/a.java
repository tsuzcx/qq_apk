package com.tencent.mm.plugin.emojicapture.api;

import android.content.Context;

public abstract interface a
  extends com.tencent.mm.kernel.b.a
{
  public abstract boolean isStickerEnable();
  
  public abstract void preCheck(Context paramContext, int paramInt, a parama);
  
  public abstract void prepareEmojiCapture(Context paramContext, String paramString, a.b paramb);
  
  public abstract void prepareStickerPreview(Context paramContext, String paramString, a.b paramb);
  
  public abstract int stickerRecommendCount();
  
  public static abstract interface a
  {
    public abstract void ha(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.api.a
 * JD-Core Version:    0.7.0.1
 */