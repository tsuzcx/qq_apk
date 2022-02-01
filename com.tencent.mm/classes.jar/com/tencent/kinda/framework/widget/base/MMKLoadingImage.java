package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.kinda.gen.KLoadingImage;
import com.tencent.kinda.gen.LoadingImageStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;

public class MMKLoadingImage
  extends MMKView<LinearLayout>
  implements KLoadingImage
{
  private CircleProgressDrawable circleProgressDrawable;
  private LoadingImageStyle loadingImageStype;
  private ProgressBar progressBar;
  
  public LinearLayout createView(Context paramContext)
  {
    AppMethodBeat.i(19084);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    this.progressBar = new ProgressBar(paramContext);
    this.circleProgressDrawable = new CircleProgressDrawable(paramContext);
    this.circleProgressDrawable.setStrokeColor(2131100470);
    this.progressBar.setIndeterminateDrawable(this.circleProgressDrawable);
    this.progressBar.setVisibility(8);
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    localLinearLayout.addView(this.progressBar, paramContext);
    AppMethodBeat.o(19084);
    return localLinearLayout;
  }
  
  public LoadingImageStyle getStyle()
  {
    return this.loadingImageStype;
  }
  
  public void setStyle(LoadingImageStyle paramLoadingImageStyle)
  {
    AppMethodBeat.i(19087);
    this.loadingImageStype = paramLoadingImageStyle;
    if (paramLoadingImageStyle == LoadingImageStyle.WHITE) {
      this.circleProgressDrawable.setStrokeColor(2131101181);
    }
    for (;;)
    {
      this.progressBar.setIndeterminateDrawable(this.circleProgressDrawable);
      AppMethodBeat.o(19087);
      return;
      if (paramLoadingImageStyle == LoadingImageStyle.WHITELARGE) {
        this.circleProgressDrawable.setStrokeColor(2131101181);
      } else if (paramLoadingImageStyle == LoadingImageStyle.GRAY) {
        this.circleProgressDrawable.setStrokeColor(2131100470);
      }
    }
  }
  
  public void startAnimating()
  {
    AppMethodBeat.i(19085);
    this.circleProgressDrawable.blV();
    this.circleProgressDrawable.start();
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(19085);
  }
  
  public void stopAnimating()
  {
    AppMethodBeat.i(19086);
    this.circleProgressDrawable.stop();
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(19086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKLoadingImage
 * JD-Core Version:    0.7.0.1
 */