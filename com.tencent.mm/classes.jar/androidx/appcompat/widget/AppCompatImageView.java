package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.g.u;
import androidx.core.widget.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatImageView
  extends ImageView
  implements u, k
{
  private final d mBackgroundTintHelper;
  private final h qP;
  
  public AppCompatImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppCompatImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(z.L(paramContext), paramAttributeSet, paramInt);
    AppMethodBeat.i(240871);
    this.mBackgroundTintHelper = new d(this);
    this.mBackgroundTintHelper.a(paramAttributeSet, paramInt);
    this.qP = new h(this);
    this.qP.a(paramAttributeSet, paramInt);
    AppMethodBeat.o(240871);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(240895);
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.dm();
    }
    if (this.qP != null) {
      this.qP.dr();
    }
    AppMethodBeat.o(240895);
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(240883);
    if (this.mBackgroundTintHelper != null)
    {
      ColorStateList localColorStateList = this.mBackgroundTintHelper.getSupportBackgroundTintList();
      AppMethodBeat.o(240883);
      return localColorStateList;
    }
    AppMethodBeat.o(240883);
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(240886);
    if (this.mBackgroundTintHelper != null)
    {
      PorterDuff.Mode localMode = this.mBackgroundTintHelper.getSupportBackgroundTintMode();
      AppMethodBeat.o(240886);
      return localMode;
    }
    AppMethodBeat.o(240886);
    return null;
  }
  
  public ColorStateList getSupportImageTintList()
  {
    AppMethodBeat.i(240890);
    if (this.qP != null)
    {
      ColorStateList localColorStateList = this.qP.getSupportImageTintList();
      AppMethodBeat.o(240890);
      return localColorStateList;
    }
    AppMethodBeat.o(240890);
    return null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    AppMethodBeat.i(240893);
    if (this.qP != null)
    {
      PorterDuff.Mode localMode = this.qP.getSupportImageTintMode();
      AppMethodBeat.o(240893);
      return localMode;
    }
    AppMethodBeat.o(240893);
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    AppMethodBeat.i(240897);
    if ((this.qP.hasOverlappingRendering()) && (super.hasOverlappingRendering()))
    {
      AppMethodBeat.o(240897);
      return true;
    }
    AppMethodBeat.o(240897);
    return false;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(240879);
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.dl();
    }
    AppMethodBeat.o(240879);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(240878);
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ar(paramInt);
    }
    AppMethodBeat.o(240878);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(240875);
    super.setImageBitmap(paramBitmap);
    if (this.qP != null) {
      this.qP.dr();
    }
    AppMethodBeat.o(240875);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(240873);
    super.setImageDrawable(paramDrawable);
    if (this.qP != null) {
      this.qP.dr();
    }
    AppMethodBeat.o(240873);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(240872);
    if (this.qP != null) {
      this.qP.setImageResource(paramInt);
    }
    AppMethodBeat.o(240872);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(240876);
    super.setImageURI(paramUri);
    if (this.qP != null) {
      this.qP.dr();
    }
    AppMethodBeat.o(240876);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240881);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
    AppMethodBeat.o(240881);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(240885);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
    AppMethodBeat.o(240885);
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240889);
    if (this.qP != null) {
      this.qP.setSupportImageTintList(paramColorStateList);
    }
    AppMethodBeat.o(240889);
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(240892);
    if (this.qP != null) {
      this.qP.setSupportImageTintMode(paramMode);
    }
    AppMethodBeat.o(240892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatImageView
 * JD-Core Version:    0.7.0.1
 */