package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public class IPCallRoundUrlHeadImage
  extends CdnImageView
{
  public IPCallRoundUrlHeadImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IPCallRoundUrlHeadImage(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setImageBitmapCompleted(Bitmap paramBitmap)
  {
    AppMethodBeat.i(25902);
    if (paramBitmap != null) {
      setImageBitmap(BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, 0.5F * paramBitmap.getWidth()));
    }
    AppMethodBeat.o(25902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRoundUrlHeadImage
 * JD-Core Version:    0.7.0.1
 */