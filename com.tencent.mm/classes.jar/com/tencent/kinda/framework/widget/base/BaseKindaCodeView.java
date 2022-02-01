package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;

public abstract class BaseKindaCodeView
  extends MMKView<ImageView>
{
  private ArrayList<Bitmap> mCodeBitmaps;
  private String mCodeStringValue;
  protected Context mContext;
  private ImageView mIvCodeView;
  
  private void recycleBmpList()
  {
    if (this.mCodeBitmaps.size() >= 2)
    {
      int i = this.mCodeBitmaps.size() - 1;
      while (i > 1)
      {
        f.Z((Bitmap)this.mCodeBitmaps.remove(i));
        i -= 1;
      }
    }
  }
  
  public ImageView createView(Context paramContext)
  {
    this.mContext = paramContext;
    this.mIvCodeView = new ImageView(paramContext);
    this.mIvCodeView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.mCodeBitmaps = new ArrayList();
    return this.mIvCodeView;
  }
  
  public String getCode()
  {
    return this.mCodeStringValue;
  }
  
  protected abstract Bitmap getNewBitmap(String paramString);
  
  public void setCode(String paramString)
  {
    this.mCodeStringValue = paramString;
    paramString = getNewBitmap(paramString);
    this.mIvCodeView.setImageBitmap(paramString);
    recycleBmpList();
    this.mCodeBitmaps.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseKindaCodeView
 * JD-Core Version:    0.7.0.1
 */