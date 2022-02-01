package com.tencent.mm.plugin.luckymoney.a;

import android.widget.ImageView;
import com.tencent.mm.message.g;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.eoh;

public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract void a(ImageView paramImageView, int paramInt1, int paramInt2, czi paramczi, boolean paramBoolean);
  
  public abstract void a(ImageView paramImageView, czi paramczi);
  
  public abstract void a(ImageView paramImageView, czi paramczi, a parama);
  
  public abstract void a(ImageView paramImageView, String paramString1, String paramString2, String paramString3);
  
  public abstract void a(ImageView paramImageView, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(ImageView paramImageView, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, a parama, int paramInt4, int paramInt5, int paramInt6);
  
  public abstract void a(g paramg);
  
  public abstract void a(czi paramczi);
  
  public abstract void a(eoh parameoh, boolean paramBoolean);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, a parama);
  
  public abstract void ay(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void b(ImageView paramImageView, int paramInt1, int paramInt2, czi paramczi, boolean paramBoolean);
  
  public abstract void b(ImageView paramImageView, czi paramczi, a parama);
  
  public static abstract interface a
  {
    public abstract void onComplete(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.a
 * JD-Core Version:    0.7.0.1
 */