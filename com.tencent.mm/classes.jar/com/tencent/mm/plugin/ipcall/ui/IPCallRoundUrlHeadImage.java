package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.d;

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
    AppMethodBeat.i(22282);
    if (paramBitmap != null) {
      setImageBitmap(d.a(paramBitmap, false, 0.5F * paramBitmap.getWidth()));
    }
    AppMethodBeat.o(22282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRoundUrlHeadImage
 * JD-Core Version:    0.7.0.1
 */