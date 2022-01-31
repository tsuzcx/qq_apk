package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.internal.zzacb;
import com.google.android.gms.internal.zzacc;
import java.lang.ref.WeakReference;

public final class zza$zzb
  extends zza
{
  private WeakReference<ImageView> zzaEB;
  
  public zza$zzb(ImageView paramImageView, int paramInt)
  {
    super(null, paramInt);
    zzc.zzt(paramImageView);
    this.zzaEB = new WeakReference(paramImageView);
  }
  
  public zza$zzb(ImageView paramImageView, Uri paramUri)
  {
    super(paramUri, 0);
    zzc.zzt(paramImageView);
    this.zzaEB = new WeakReference(paramImageView);
  }
  
  private void zza(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean2) && (!paramBoolean3)) {}
    for (int i = 1; (i != 0) && ((paramImageView instanceof zzacc)); i = 0)
    {
      int j = ((zzacc)paramImageView).zzxu();
      if ((this.zzaEw == 0) || (j != this.zzaEw)) {
        break;
      }
      return;
    }
    paramBoolean1 = zzc(paramBoolean1, paramBoolean2);
    if (paramBoolean1) {
      paramDrawable = zza(paramImageView.getDrawable(), paramDrawable);
    }
    for (;;)
    {
      paramImageView.setImageDrawable(paramDrawable);
      zzacc localzzacc;
      if ((paramImageView instanceof zzacc))
      {
        localzzacc = (zzacc)paramImageView;
        if (!paramBoolean3) {
          break label149;
        }
        paramImageView = this.zzaEu.uri;
        label110:
        localzzacc.zzr(paramImageView);
        if (i == 0) {
          break label154;
        }
      }
      label149:
      label154:
      for (i = this.zzaEw;; i = 0)
      {
        localzzacc.zzcQ(i);
        if (!paramBoolean1) {
          break;
        }
        ((zzacb)paramDrawable).startTransition(250);
        return;
        paramImageView = null;
        break label110;
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzb)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    Object localObject = (zzb)paramObject;
    paramObject = (ImageView)this.zzaEB.get();
    localObject = (ImageView)((zzb)localObject).zzaEB.get();
    return (localObject != null) && (paramObject != null) && (zzaa.equal(localObject, paramObject));
  }
  
  public final int hashCode()
  {
    return 0;
  }
  
  protected final void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ImageView localImageView = (ImageView)this.zzaEB.get();
    if (localImageView != null) {
      zza(localImageView, paramDrawable, paramBoolean1, paramBoolean2, paramBoolean3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.images.zza.zzb
 * JD-Core Version:    0.7.0.1
 */