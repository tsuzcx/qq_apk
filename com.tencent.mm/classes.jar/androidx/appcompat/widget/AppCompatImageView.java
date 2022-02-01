package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.g.x;
import androidx.core.widget.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatImageView
  extends ImageView
  implements x, l
{
  private final d mBackgroundTintHelper;
  private final h rM;
  
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
    AppMethodBeat.i(200314);
    this.mBackgroundTintHelper = new d(this);
    this.mBackgroundTintHelper.a(paramAttributeSet, paramInt);
    this.rM = new h(this);
    this.rM.a(paramAttributeSet, paramInt);
    AppMethodBeat.o(200314);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(200475);
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.el();
    }
    if (this.rM != null) {
      this.rM.eq();
    }
    AppMethodBeat.o(200475);
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(200391);
    if (this.mBackgroundTintHelper != null)
    {
      ColorStateList localColorStateList = this.mBackgroundTintHelper.getSupportBackgroundTintList();
      AppMethodBeat.o(200391);
      return localColorStateList;
    }
    AppMethodBeat.o(200391);
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(200417);
    if (this.mBackgroundTintHelper != null)
    {
      PorterDuff.Mode localMode = this.mBackgroundTintHelper.getSupportBackgroundTintMode();
      AppMethodBeat.o(200417);
      return localMode;
    }
    AppMethodBeat.o(200417);
    return null;
  }
  
  public ColorStateList getSupportImageTintList()
  {
    AppMethodBeat.i(200437);
    if (this.rM != null)
    {
      ColorStateList localColorStateList = this.rM.getSupportImageTintList();
      AppMethodBeat.o(200437);
      return localColorStateList;
    }
    AppMethodBeat.o(200437);
    return null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    AppMethodBeat.i(200464);
    if (this.rM != null)
    {
      PorterDuff.Mode localMode = this.rM.getSupportImageTintMode();
      AppMethodBeat.o(200464);
      return localMode;
    }
    AppMethodBeat.o(200464);
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    AppMethodBeat.i(200487);
    if ((this.rM.hasOverlappingRendering()) && (super.hasOverlappingRendering()))
    {
      AppMethodBeat.o(200487);
      return true;
    }
    AppMethodBeat.o(200487);
    return false;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(200370);
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ek();
    }
    AppMethodBeat.o(200370);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(200359);
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ap(paramInt);
    }
    AppMethodBeat.o(200359);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(200336);
    super.setImageBitmap(paramBitmap);
    if (this.rM != null) {
      this.rM.eq();
    }
    AppMethodBeat.o(200336);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(200327);
    super.setImageDrawable(paramDrawable);
    if (this.rM != null) {
      this.rM.eq();
    }
    AppMethodBeat.o(200327);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(200319);
    if (this.rM != null) {
      this.rM.setImageResource(paramInt);
    }
    AppMethodBeat.o(200319);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(200350);
    super.setImageURI(paramUri);
    if (this.rM != null) {
      this.rM.eq();
    }
    AppMethodBeat.o(200350);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(200383);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
    AppMethodBeat.o(200383);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(200405);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
    AppMethodBeat.o(200405);
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(200426);
    if (this.rM != null) {
      this.rM.setSupportImageTintList(paramColorStateList);
    }
    AppMethodBeat.o(200426);
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(200450);
    if (this.rM != null) {
      this.rM.setSupportImageTintMode(paramMode);
    }
    AppMethodBeat.o(200450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatImageView
 * JD-Core Version:    0.7.0.1
 */