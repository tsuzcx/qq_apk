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
import androidx.core.g.x;
import androidx.core.widget.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppCompatImageButton
  extends ImageButton
  implements x, l
{
  private final d mBackgroundTintHelper;
  private final h rM;
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.imageButtonStyle);
  }
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(z.L(paramContext), paramAttributeSet, paramInt);
    AppMethodBeat.i(199945);
    this.mBackgroundTintHelper = new d(this);
    this.mBackgroundTintHelper.a(paramAttributeSet, paramInt);
    this.rM = new h(this);
    this.rM.a(paramAttributeSet, paramInt);
    AppMethodBeat.o(199945);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(200078);
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.el();
    }
    if (this.rM != null) {
      this.rM.eq();
    }
    AppMethodBeat.o(200078);
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(200016);
    if (this.mBackgroundTintHelper != null)
    {
      ColorStateList localColorStateList = this.mBackgroundTintHelper.getSupportBackgroundTintList();
      AppMethodBeat.o(200016);
      return localColorStateList;
    }
    AppMethodBeat.o(200016);
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(200033);
    if (this.mBackgroundTintHelper != null)
    {
      PorterDuff.Mode localMode = this.mBackgroundTintHelper.getSupportBackgroundTintMode();
      AppMethodBeat.o(200033);
      return localMode;
    }
    AppMethodBeat.o(200033);
    return null;
  }
  
  public ColorStateList getSupportImageTintList()
  {
    AppMethodBeat.i(200053);
    if (this.rM != null)
    {
      ColorStateList localColorStateList = this.rM.getSupportImageTintList();
      AppMethodBeat.o(200053);
      return localColorStateList;
    }
    AppMethodBeat.o(200053);
    return null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    AppMethodBeat.i(200070);
    if (this.rM != null)
    {
      PorterDuff.Mode localMode = this.rM.getSupportImageTintMode();
      AppMethodBeat.o(200070);
      return localMode;
    }
    AppMethodBeat.o(200070);
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    AppMethodBeat.i(200086);
    if ((this.rM.hasOverlappingRendering()) && (super.hasOverlappingRendering()))
    {
      AppMethodBeat.o(200086);
      return true;
    }
    AppMethodBeat.o(200086);
    return false;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(199997);
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ek();
    }
    AppMethodBeat.o(199997);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(199987);
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.ap(paramInt);
    }
    AppMethodBeat.o(199987);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(199972);
    super.setImageBitmap(paramBitmap);
    if (this.rM != null) {
      this.rM.eq();
    }
    AppMethodBeat.o(199972);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(199962);
    super.setImageDrawable(paramDrawable);
    if (this.rM != null) {
      this.rM.eq();
    }
    AppMethodBeat.o(199962);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(199952);
    this.rM.setImageResource(paramInt);
    AppMethodBeat.o(199952);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(199980);
    super.setImageURI(paramUri);
    if (this.rM != null) {
      this.rM.eq();
    }
    AppMethodBeat.o(199980);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(200007);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
    AppMethodBeat.o(200007);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(200025);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
    AppMethodBeat.o(200025);
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(200044);
    if (this.rM != null) {
      this.rM.setSupportImageTintList(paramColorStateList);
    }
    AppMethodBeat.o(200044);
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(200059);
    if (this.rM != null) {
      this.rM.setSupportImageTintMode(paramMode);
    }
    AppMethodBeat.o(200059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatImageButton
 * JD-Core Version:    0.7.0.1
 */