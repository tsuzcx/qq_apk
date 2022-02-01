package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.a.a;
import androidx.core.g.u;
import androidx.core.widget.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatImageButton
  extends ImageButton
  implements u, k
{
  private final d mBackgroundTintHelper;
  private final h qP;
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.imageButtonStyle);
  }
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(z.L(paramContext), paramAttributeSet, paramInt);
    AppMethodBeat.i(240839);
    this.mBackgroundTintHelper = new d(this);
    this.mBackgroundTintHelper.a(paramAttributeSet, paramInt);
    this.qP = new h(this);
    this.qP.a(paramAttributeSet, paramInt);
    AppMethodBeat.o(240839);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(240858);
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.dm();
    }
    if (this.qP != null) {
      this.qP.dr();
    }
    AppMethodBeat.o(240858);
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(240851);
    if (this.mBackgroundTintHelper != null)
    {
      ColorStateList localColorStateList = this.mBackgroundTintHelper.getSupportBackgroundTintList();
      AppMethodBeat.o(240851);
      return localColorStateList;
    }
    AppMethodBeat.o(240851);
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(240853);
    if (this.mBackgroundTintHelper != null)
    {
      PorterDuff.Mode localMode = this.mBackgroundTintHelper.getSupportBackgroundTintMode();
      AppMethodBeat.o(240853);
      return localMode;
    }
    AppMethodBeat.o(240853);
    return null;
  }
  
  public ColorStateList getSupportImageTintList()
  {
    AppMethodBeat.i(240855);
    if (this.qP != null)
    {
      ColorStateList localColorStateList = this.qP.getSupportImageTintList();
      AppMethodBeat.o(240855);
      return localColorStateList;
    }
    AppMethodBeat.o(240855);
    return null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    AppMethodBeat.i(240857);
    if (this.qP != null)
    {
      PorterDuff.Mode localMode = this.qP.getSupportImageTintMode();
      AppMethodBeat.o(240857);
      return localMode;
    }
    AppMethodBeat.o(240857);
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    AppMethodBeat.i(240860);
    if ((this.qP.hasOverlappingRendering()) && (super.hasOverlappingRendering()))
    {
      AppMethodBeat.o(240860);
      return true;
    }
    AppMethodBeat.o(240860);
    return false;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(240848);
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.dl();
    }
    AppMethodBeat.o(240848);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(240846);
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ar(paramInt);
    }
    AppMethodBeat.o(240846);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(240842);
    super.setImageBitmap(paramBitmap);
    if (this.qP != null) {
      this.qP.dr();
    }
    AppMethodBeat.o(240842);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(240841);
    super.setImageDrawable(paramDrawable);
    if (this.qP != null) {
      this.qP.dr();
    }
    AppMethodBeat.o(240841);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(240840);
    this.qP.setImageResource(paramInt);
    AppMethodBeat.o(240840);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(240843);
    super.setImageURI(paramUri);
    if (this.qP != null) {
      this.qP.dr();
    }
    AppMethodBeat.o(240843);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240850);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
    AppMethodBeat.o(240850);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(240852);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
    AppMethodBeat.o(240852);
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(240854);
    if (this.qP != null) {
      this.qP.setSupportImageTintList(paramColorStateList);
    }
    AppMethodBeat.o(240854);
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(240856);
    if (this.qP != null) {
      this.qP.setSupportImageTintMode(paramMode);
    }
    AppMethodBeat.o(240856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatImageButton
 * JD-Core Version:    0.7.0.1
 */