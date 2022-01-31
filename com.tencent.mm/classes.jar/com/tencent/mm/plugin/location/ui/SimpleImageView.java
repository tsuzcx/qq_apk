package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public class SimpleImageView
  extends ImageView
{
  public int eRu;
  public int eRv;
  public ak handler;
  public String imagePath;
  public String url;
  
  public SimpleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113529);
    this.url = null;
    this.handler = new SimpleImageView.1(this);
    AppMethodBeat.o(113529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.SimpleImageView
 * JD-Core Version:    0.7.0.1
 */